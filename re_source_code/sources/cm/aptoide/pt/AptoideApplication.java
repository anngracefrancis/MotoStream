package cm.aptoide.pt;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AdultContent;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.account.AdultContentAnalytics;
import cm.aptoide.pt.account.MatureBodyInterceptorV7;
import cm.aptoide.pt.ads.AdsRepository;
import cm.aptoide.pt.analytics.FirstLaunchAnalytics;
import cm.aptoide.pt.crashreports.ConsoleLogger;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.RoomNotificationPersistence;
import cm.aptoide.pt.database.room.AptoideDatabase;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.cache.L2Cache;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.download.OemidProvider;
import cm.aptoide.pt.downloadmanager.AptoideDownloadManager;
import cm.aptoide.pt.file.CacheHelper;
import cm.aptoide.pt.file.FileManager;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.install.InstalledBroadcastReceiver;
import cm.aptoide.pt.install.PackageRepository;
import cm.aptoide.pt.install.installer.RootInstallationRetryHandler;
import cm.aptoide.pt.leak.LeakTool;
import cm.aptoide.pt.link.AptoideInstallParser;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.navigator.Result;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.networking.Pnp1AuthorizationInterceptor;
import cm.aptoide.pt.notification.AptoideWorkerFactory;
import cm.aptoide.pt.notification.NotificationAnalytics;
import cm.aptoide.pt.notification.NotificationCenter;
import cm.aptoide.pt.notification.NotificationInfo;
import cm.aptoide.pt.notification.NotificationPolicyFactory;
import cm.aptoide.pt.notification.NotificationProvider;
import cm.aptoide.pt.notification.NotificationService;
import cm.aptoide.pt.notification.NotificationSyncScheduler;
import cm.aptoide.pt.notification.NotificationsCleaner;
import cm.aptoide.pt.notification.ReadyToInstallNotificationManager;
import cm.aptoide.pt.notification.SystemNotificationShower;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import cm.aptoide.pt.notification.sync.NotificationSyncFactory;
import cm.aptoide.pt.notification.sync.NotificationSyncManager;
import cm.aptoide.pt.preferences.AptoideMd5Manager;
import cm.aptoide.pt.preferences.PRNGFixes;
import cm.aptoide.pt.preferences.Preferences;
import cm.aptoide.pt.preferences.SecurePreferences;
import cm.aptoide.pt.preferences.managed.ManagedKeys;
import cm.aptoide.pt.preferences.secure.SecurePreferencesImplementation;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.root.RootAvailabilityManager;
import cm.aptoide.pt.search.suggestions.SearchSuggestionManager;
import cm.aptoide.pt.search.suggestions.TrendingManager;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.sync.SyncScheduler;
import cm.aptoide.pt.sync.alarm.SyncStorage;
import cm.aptoide.pt.themes.NewFeature;
import cm.aptoide.pt.themes.NewFeatureManager;
import cm.aptoide.pt.themes.ThemeAnalytics;
import cm.aptoide.pt.updates.UpdateRepository;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.q.QManager;
import cm.aptoide.pt.view.ActivityModule;
import cm.aptoide.pt.view.ActivityProvider;
import cm.aptoide.pt.view.BaseActivity;
import cm.aptoide.pt.view.BaseFragment;
import cm.aptoide.pt.view.FragmentModule;
import cm.aptoide.pt.view.FragmentProvider;
import cm.aptoide.pt.view.configuration.implementation.VanillaActivityProvider;
import cm.aptoide.pt.view.configuration.implementation.VanillaFragmentProvider;
import cm.aptoide.pt.view.recycler.DisplayableWidgetMapping;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.a4;
import io.sentry.x4;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.OkHttpClient;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public abstract class AptoideApplication extends Application {
    public static final String APPCOINS_WALLET_PACKAGE_NAME = "com.appcoins.wallet";
    public static final String APTOIDE_GAMES_PACKAGE_NAME = "com.aptoide.android.aptoidegames";
    static final String CACHE_FILE_NAME = "aptoide.wscache";
    public static final String GAMES_HUB_PACKAGE_NAME = "com.dti.folderlauncher";
    private static final String TAG = AptoideApplication.class.getName();
    private static ActivityProvider activityProvider;
    private static DisplayableWidgetMapping displayableWidgetMapping;
    private static FragmentProvider fragmentProvider;

    @Inject
    AptoideAccountManager accountManager;

    @Inject
    @Named
    BodyInterceptor<BaseBody> accountSettingsBodyInterceptorPoolV7;
    private BodyInterceptor<BaseBody> accountSettingsBodyInterceptorWebV7;

    @Inject
    AdsRepository adsRepository;

    @Inject
    AdultContent adultContent;

    @Inject
    AdultContentAnalytics adultContentAnalytics;

    @Inject
    SyncScheduler alarmSyncScheduler;

    @Inject
    AnalyticsManager analyticsManager;

    @Inject
    AppCoinsManager appCoinsManager;

    @Inject
    AppInBackgroundTracker appInBackgroundTracker;
    private ApplicationComponent applicationComponent;

    @Inject
    AdsApplicationVersionCodeProvider applicationVersionCodeProvider;
    private AptoideApplicationAnalytics aptoideApplicationAnalytics;

    @Inject
    AptoideDatabase aptoideDatabase;

    @Inject
    AptoideDownloadManager aptoideDownloadManager;

    @Inject
    AptoideInstalledAppsRepository aptoideInstalledAppsRepository;

    @Inject
    AptoideMd5Manager aptoideMd5Manager;

    @Inject
    AptoideWorkerFactory aptoideWorkerFactory;

    @Inject
    AuthenticationPersistence authenticationPersistence;

    @Inject
    @Named
    BodyInterceptor<BaseBody> bodyInterceptorPoolV7;

    @Inject
    @Named
    BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> bodyInterceptorV3;

    @Inject
    @Named
    BodyInterceptor<BaseBody> bodyInterceptorWebV7;

    @Inject
    CacheHelper cacheHelper;

    @Inject
    @Named
    OkHttpClient defaultClient;

    @Inject
    @Named
    List<String> defaultFollowedStores;

    @Inject
    FileManager fileManager;

    @Inject
    FirebaseAnalytics firebaseAnalytics;

    @Inject
    FirstLaunchAnalytics firstLaunchAnalytics;
    private Map<Integer, Result> fragmentResultMap;
    private e.g.b.a<Map<Integer, Result>> fragmentResultRelay;

    @Inject
    L2Cache httpClientCache;

    @Inject
    IdsRepository idsRepository;

    @Inject
    InstallManager installManager;

    @Inject
    InvalidRefreshTokenLogoutManager invalidRefreshTokenLogoutManager;

    @Inject
    LaunchManager launchManager;
    private LeakTool leakTool;

    @Inject
    NavigationTracker navigationTracker;

    @Inject
    NewFeature newFeature;

    @Inject
    NewFeatureManager newFeatureManager;

    @Inject
    NotificationAnalytics notificationAnalytics;
    private NotificationCenter notificationCenter;

    @Inject
    RoomNotificationPersistence notificationPersistence;
    private NotificationProvider notificationProvider;
    private NotificationSyncScheduler notificationSyncScheduler;
    private NotificationsCleaner notificationsCleaner;
    private e.g.b.c<NotificationInfo> notificationsPublishRelay;

    @Inject
    OemidProvider oemidProvider;
    private InstalledBroadcastReceiver packageChangeReceiver;

    @Inject
    PackageRepository packageRepository;

    @Inject
    Preferences preferences;

    @Inject
    QManager qManager;

    @Inject
    @Named
    String rakamBaseHost;

    @Inject
    ReadyToInstallNotificationManager readyToInstallNotificationManager;

    @Inject
    RootAvailabilityManager rootAvailabilityManager;

    @Inject
    RootInstallationRetryHandler rootInstallationRetryHandler;

    @Inject
    SearchSuggestionManager searchSuggestionManager;

    @Inject
    @Named
    SecurePreferences securePreferences;

    @Inject
    SettingsManager settingsManager;

    @Inject
    AptoideShortcutManager shortcutManager;

    @Inject
    StoreCredentialsProvider storeCredentials;

    @Inject
    StoreUtilsProxy storeUtilsProxy;

    @Inject
    SyncStorage syncStorage;

    @Inject
    ThemeAnalytics themeAnalytics;

    @Inject
    TokenInvalidator tokenInvalidator;

    @Inject
    TrendingManager trendingManager;

    @Inject
    UpdateRepository updateRepository;

    private void clearFileCache() {
        this.fileManager.purgeCache().u(new rx.m.b() { // from class: cm.aptoide.pt.y
            @Override // rx.m.b
            public final void call(Object obj) {
                Logger.getInstance().d(AptoideApplication.TAG, "cleaned size: " + AptoideUtils.StringU.formatBytes(((Long) obj).longValue(), false));
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.e
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    private rx.b generateAptoideUuid() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.q
            @Override // rx.m.a
            public final void call() {
                this.f7231f.b();
            }
        });
    }

    public static ActivityProvider getActivityProvider() {
        return activityProvider;
    }

    public static DisplayableWidgetMapping getDisplayableWidgetMapping() {
        return displayableWidgetMapping;
    }

    public static FragmentProvider getFragmentProvider() {
        return fragmentProvider;
    }

    private Map<String, Object> getIndicativeProperties() {
        HashMap map = new HashMap();
        map.put("android_api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        map.put("aptoide_version_code", Integer.valueOf(BuildConfig.VERSION_CODE));
        map.put("android_brand", Build.MANUFACTURER);
        map.put("android_model", Build.MODEL);
        return map;
    }

    private NotificationsCleaner getNotificationCleaner() {
        if (this.notificationsCleaner == null) {
            this.notificationsCleaner = new NotificationsCleaner(this.notificationPersistence, Calendar.getInstance(TimeZone.getTimeZone("UTC")), this.accountManager, getNotificationProvider(), CrashReport.getInstance());
        }
        return this.notificationsCleaner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAptoideAppsInstallationUserProperties() {
        rx.e<Boolean> eVarX = this.aptoideInstalledAppsRepository.isInstalled(APPCOINS_WALLET_PACKAGE_NAME).j0(Schedulers.io()).t().x(new rx.m.b() { // from class: cm.aptoide.pt.p
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6830f.c((Boolean) obj);
            }
        });
        m mVar = new rx.m.b() { // from class: cm.aptoide.pt.m
            @Override // rx.m.b
            public final void call(Object obj) {
                AptoideApplication.lambda$handleAptoideAppsInstallationUserProperties$13((Boolean) obj);
            }
        };
        p0 p0Var = new rx.m.b() { // from class: cm.aptoide.pt.p0
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        };
        eVarX.H0(mVar, p0Var);
        this.aptoideInstalledAppsRepository.isInstalled(GAMES_HUB_PACKAGE_NAME).j0(Schedulers.io()).t().x(new rx.m.b() { // from class: cm.aptoide.pt.n
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6620f.d((Boolean) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.o
            @Override // rx.m.b
            public final void call(Object obj) {
                AptoideApplication.lambda$handleAptoideAppsInstallationUserProperties$15((Boolean) obj);
            }
        }, p0Var);
        this.aptoideInstalledAppsRepository.isInstalled(APTOIDE_GAMES_PACKAGE_NAME).j0(Schedulers.io()).t().x(new rx.m.b() { // from class: cm.aptoide.pt.d
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4877f.e((Boolean) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.g
            @Override // rx.m.b
            public final void call(Object obj) {
                AptoideApplication.lambda$handleAptoideAppsInstallationUserProperties$17((Boolean) obj);
            }
        }, p0Var);
    }

    private void initializeFlurry(Context context, String str) {
        new e.d.a.b.a().d(false).b(true).c(true).e(e.d.a.f.f20707d).a(context, str);
    }

    private rx.b initializeIndicative() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.b0
            @Override // rx.m.a
            public final void call() {
                this.f4764f.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initializeRakam, reason: merged with bridge method [inline-methods] */
    public void g() {
        io.rakam.api.g gVarA = io.rakam.api.f.a();
        try {
            gVarA.z(this, new URL(this.rakamBaseHost), BuildConfig.RAKAM_API_KEY);
        } catch (MalformedURLException e2) {
            Logger.getInstance().e(TAG, "error: ", e2);
        }
        gVarA.U(this.idsRepository.getAndroidId());
        gVarA.h0(true);
        gVarA.Z(2);
        gVarA.V(1);
    }

    private rx.b initializeRakamSdk() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.i
            @Override // rx.m.a
            public final void call() {
                this.f6393f.g();
            }
        }).K(Schedulers.newThread());
    }

    private rx.b initializeSentry() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.c0
            @Override // rx.m.a
            public final void call() {
                a4.l(new a4.a() { // from class: cm.aptoide.pt.j
                    @Override // io.sentry.a4.a
                    public final void a(x4 x4Var) {
                        AptoideApplication.lambda$initializeSentry$19(x4Var);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$generateAptoideUuid$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.idsRepository.getUniqueIdentifier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAptoideAppsInstallationUserProperties$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Boolean bool) {
        e.f.a.a.a.f("is_wallet_app_installed", bool.booleanValue());
        this.firebaseAnalytics.b("is_wallet_app_installed", String.valueOf(bool));
    }

    static /* synthetic */ void lambda$handleAptoideAppsInstallationUserProperties$13(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAptoideAppsInstallationUserProperties$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Boolean bool) {
        e.f.a.a.a.f("is_gh_installed", bool.booleanValue());
        this.firebaseAnalytics.b("is_gh_installed", String.valueOf(bool));
    }

    static /* synthetic */ void lambda$handleAptoideAppsInstallationUserProperties$15(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAptoideAppsInstallationUserProperties$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(Boolean bool) {
        e.f.a.a.a.f("is_ag_installed", bool.booleanValue());
        this.firebaseAnalytics.b("is_ag_installed", String.valueOf(bool));
    }

    static /* synthetic */ void lambda$handleAptoideAppsInstallationUserProperties$17(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$initializeIndicative$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f() {
        e.f.a.a.a.m(getApplicationContext(), BuildConfig.INDICATIVE_KEY);
        e.f.a.a.a.v(this.idsRepository.getAndroidId());
        e.f.a.a.a.c(getIndicativeProperties());
    }

    static /* synthetic */ void lambda$initializeSentry$19(x4 x4Var) {
        x4Var.setDsn(BuildConfig.SENTRY_DSN_KEY);
        x4Var.setRelease(BuildConfig.VERSION_NAME);
        x4Var.setEnableAutoSessionTracking(true);
        x4Var.setSessionTrackingIntervalMillis(LocalNotificationSyncManager.FIVE_MINUTES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreate$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Void h() throws Exception {
        return this.aptoideMd5Manager.calculateMd5Sum();
    }

    static /* synthetic */ void lambda$onCreate$1(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreate$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Boolean bool) {
        this.aptoideApplicationAnalytics.updateDimension(bool.booleanValue());
    }

    static /* synthetic */ void lambda$onCreate$5() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreate$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Boolean bool) {
        if (bool.booleanValue()) {
            this.rootInstallationRetryHandler.start();
        }
    }

    static /* synthetic */ void lambda$onCreate$8(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$sendAptoideApplicationStartAnalytics$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(boolean z) {
        this.aptoideApplicationAnalytics.setPackageDimension(getPackageName());
        this.aptoideApplicationAnalytics.setVersionCodeDimension(getVersionCode());
        this.aptoideApplicationAnalytics.sendIsTvEvent(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$startNotificationCenter$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(Boolean bool) {
        getNotificationSyncScheduler().setEnabled(bool.booleanValue());
    }

    private rx.b sendAppStartToAnalytics() {
        return this.firstLaunchAnalytics.sendAppStart(this, SecurePreferencesImplementation.getInstance(getApplicationContext(), getDefaultSharedPreferences()), this.idsRepository);
    }

    private rx.b sendAptoideApplicationStartAnalytics(final boolean z) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.x
            @Override // rx.m.a
            public final void call() {
                this.f8379f.k(z);
            }
        });
    }

    private rx.b setUpFirstRunAnalytics() {
        return sendAppStartToAnalytics();
    }

    private void startNotificationCenter() {
        getPreferences().getBoolean(ManagedKeys.CAMPAIGN_SOCIAL_NOTIFICATIONS_PREFERENCE_VIEW_KEY, true).E().H0(new rx.m.b() { // from class: cm.aptoide.pt.d0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4878f.l((Boolean) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.u
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
        getNotificationCenter().setup();
    }

    private void startNotificationCleaner() {
        getNotificationCleaner().setup();
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        c.r.a.k(this);
    }

    public ActivityProvider createActivityProvider() {
        return new VanillaActivityProvider();
    }

    protected DisplayableWidgetMapping createDisplayableWidgetMapping() {
        return DisplayableWidgetMapping.getInstance();
    }

    public FragmentProvider createFragmentProvider() {
        return new VanillaFragmentProvider();
    }

    public AptoideAccountManager getAccountManager() {
        return this.accountManager;
    }

    public BodyInterceptor<BaseBody> getAccountSettingsBodyInterceptorPoolV7() {
        return this.accountSettingsBodyInterceptorPoolV7;
    }

    public BodyInterceptor<BaseBody> getAccountSettingsBodyInterceptorWebV7() {
        if (this.accountSettingsBodyInterceptorWebV7 == null) {
            this.accountSettingsBodyInterceptorWebV7 = new MatureBodyInterceptorV7(this.bodyInterceptorWebV7, this.adultContent);
        }
        return this.accountSettingsBodyInterceptorWebV7;
    }

    public String getAccountType() {
        return "cm.aptoide.pt";
    }

    public ActivityModule getActivityModule(BaseActivity baseActivity, Intent intent, NotificationSyncScheduler notificationSyncScheduler, View view, boolean z, String str) {
        return new ActivityModule(baseActivity, intent, notificationSyncScheduler, view, z, str);
    }

    public AdsRepository getAdsRepository() {
        return this.adsRepository;
    }

    public AdultContentAnalytics getAdultContentAnalytics() {
        return this.adultContentAnalytics;
    }

    public SyncScheduler getAlarmSyncScheduler() {
        return this.alarmSyncScheduler;
    }

    public AnalyticsManager getAnalyticsManager() {
        return this.analyticsManager;
    }

    public AppCoinsManager getAppCoinsManager() {
        return this.appCoinsManager;
    }

    public ApplicationComponent getApplicationComponent() {
        if (this.applicationComponent == null) {
            this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).flavourApplicationModule(new FlavourApplicationModule(this)).build();
        }
        return this.applicationComponent;
    }

    protected String getAptoidePackage() {
        return "cm.aptoide.pt";
    }

    public AuthenticationPersistence getAuthenticationPersistence() {
        return this.authenticationPersistence;
    }

    public BodyInterceptor<BaseBody> getBodyInterceptorPoolV7() {
        return this.bodyInterceptorPoolV7;
    }

    public BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> getBodyInterceptorV3() {
        return this.bodyInterceptorV3;
    }

    public OkHttpClient getDefaultClient() {
        return this.defaultClient;
    }

    public SharedPreferences getDefaultSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }

    public AptoideDownloadManager getDownloadManager() {
        return this.aptoideDownloadManager;
    }

    public String getExtraId() {
        return null;
    }

    public String getFeedbackEmail() {
        return "support@aptoide.com";
    }

    public FragmentModule getFragmentModule(BaseFragment baseFragment, Bundle bundle, Bundle bundle2, boolean z, String str) {
        return new FragmentModule(baseFragment, bundle, bundle2, z, str);
    }

    @SuppressLint({"UseSparseArrays"})
    public Map<Integer, Result> getFragmentResultMap() {
        if (this.fragmentResultMap == null) {
            this.fragmentResultMap = new HashMap();
        }
        return this.fragmentResultMap;
    }

    public e.g.b.a<Map<Integer, Result>> getFragmentResultRelay() {
        if (this.fragmentResultRelay == null) {
            this.fragmentResultRelay = e.g.b.a.f1();
        }
        return this.fragmentResultRelay;
    }

    public IdsRepository getIdsRepository() {
        return this.idsRepository;
    }

    public InstallManager getInstallManager() {
        return this.installManager;
    }

    public LeakTool getLeakTool() {
        if (this.leakTool == null) {
            this.leakTool = new LeakTool();
        }
        return this.leakTool;
    }

    public NavigationTracker getNavigationTracker() {
        return this.navigationTracker;
    }

    public NewFeature getNewFeature() {
        return this.newFeature;
    }

    public NewFeatureManager getNewFeatureManager() {
        return this.newFeatureManager;
    }

    public NotificationAnalytics getNotificationAnalytics() {
        return this.notificationAnalytics;
    }

    public NotificationCenter getNotificationCenter() {
        if (this.notificationCenter == null) {
            NotificationProvider notificationProvider = getNotificationProvider();
            this.notificationCenter = new NotificationCenter(notificationProvider, getNotificationSyncScheduler(), new NotificationPolicyFactory(notificationProvider, this.aptoideInstalledAppsRepository), new NotificationAnalytics(new AptoideInstallParser(), this.analyticsManager, this.navigationTracker));
        }
        return this.notificationCenter;
    }

    public NotificationProvider getNotificationProvider() {
        if (this.notificationProvider == null) {
            this.notificationProvider = new NotificationProvider(new RoomNotificationPersistence(this.aptoideDatabase.notificationDao()), Schedulers.io());
        }
        return this.notificationProvider;
    }

    public NotificationSyncScheduler getNotificationSyncScheduler() {
        if (this.notificationSyncScheduler == null) {
            SyncScheduler alarmSyncScheduler = getAlarmSyncScheduler();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.notificationSyncScheduler = new NotificationSyncManager(alarmSyncScheduler, true, new NotificationSyncFactory(new NotificationService("cm.aptoide.pt", builder.readTimeout(45L, timeUnit).writeTimeout(45L, timeUnit).addInterceptor(new Pnp1AuthorizationInterceptor(getAuthenticationPersistence(), getTokenInvalidator())).build(), WebService.getDefaultConverter(), getIdsRepository(), BuildConfig.VERSION_NAME, getExtraId(), getDefaultSharedPreferences(), getResources(), getAccountManager()), getNotificationProvider()));
        }
        return this.notificationSyncScheduler;
    }

    public e.g.b.c<NotificationInfo> getNotificationsPublishRelay() {
        if (this.notificationsPublishRelay == null) {
            this.notificationsPublishRelay = e.g.b.c.f1();
        }
        return this.notificationsPublishRelay;
    }

    public PackageRepository getPackageRepository() {
        return this.packageRepository;
    }

    public String getPartnerId() {
        return this.oemidProvider.getOemid();
    }

    public Preferences getPreferences() {
        return this.preferences;
    }

    public QManager getQManager() {
        return this.qManager;
    }

    public ReadyToInstallNotificationManager getReadyToInstallNotificationManager() {
        return this.readyToInstallNotificationManager;
    }

    public RootAvailabilityManager getRootAvailabilityManager() {
        return this.rootAvailabilityManager;
    }

    public SearchSuggestionManager getSearchSuggestionManager() {
        return this.searchSuggestionManager;
    }

    public SettingsManager getSettingsManager() {
        return this.settingsManager;
    }

    public StoreCredentialsProvider getStoreCredentials() {
        return this.storeCredentials;
    }

    public SyncStorage getSyncStorage() {
        return this.syncStorage;
    }

    protected abstract SystemNotificationShower getSystemNotificationShower();

    public ThemeAnalytics getThemeAnalytics() {
        return this.themeAnalytics;
    }

    public TokenInvalidator getTokenInvalidator() {
        return this.tokenInvalidator;
    }

    public TrendingManager getTrendingManager() {
        return this.trendingManager;
    }

    public String getVersionCode() {
        try {
            return String.valueOf(getPackageManager().getPackageInfo(getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            return "NaN";
        }
    }

    public AdsApplicationVersionCodeProvider getVersionCodeProvider() {
        return this.applicationVersionCodeProvider;
    }

    public boolean isCreateStoreUserPrivacyEnabled() {
        return true;
    }

    @Override // android.app.Application
    public void onCreate() {
        getApplicationComponent().inject(this);
        if (Build.VERSION.SDK_INT < 26) {
            InstalledBroadcastReceiver installedBroadcastReceiver = new InstalledBroadcastReceiver();
            this.packageChangeReceiver = installedBroadcastReceiver;
            installedBroadcastReceiver.register(this);
        }
        this.appInBackgroundTracker.initialize();
        CrashReport.getInstance().addLogger(new ConsoleLogger());
        Logger.setDBG(ToolboxManager.isDebug(getDefaultSharedPreferences()));
        Single.l(new Callable() { // from class: cm.aptoide.pt.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f4767f.h();
            }
        }).v(Schedulers.io()).p(rx.l.c.a.b()).u(new rx.m.b() { // from class: cm.aptoide.pt.k
            @Override // rx.m.b
            public final void call(Object obj) {
                AptoideApplication.lambda$onCreate$1((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.e0
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
        try {
            PRNGFixes.apply();
        } catch (Exception e2) {
            CrashReport.getInstance().log(e2);
        }
        com.google.firebase.j.o(this);
        super.onCreate();
        long jCurrentTimeMillis = System.currentTimeMillis();
        getLeakTool().setup(this);
        fragmentProvider = createFragmentProvider();
        activityProvider = createActivityProvider();
        displayableWidgetMapping = createDisplayableWidgetMapping();
        this.analyticsManager.setup();
        UiModeManager uiModeManager = (UiModeManager) getSystemService("uimode");
        this.aptoideApplicationAnalytics = new AptoideApplicationAnalytics(this.analyticsManager, this.firebaseAnalytics);
        androidx.work.y.i(this, new androidx.work.b.C0048b().c(this.aptoideWorkerFactory).b(3).a());
        com.facebook.a0.M(this);
        com.facebook.o0.a0.a(this);
        com.facebook.o0.a0.e(this);
        initializeFlurry(this, BuildConfig.FLURRY_KEY);
        rx.b bVarA = generateAptoideUuid().a(rx.b.x(initializeRakamSdk(), initializeSentry(), initializeIndicative())).a(this.aptoideInstalledAppsRepository.syncWithDevice(APPCOINS_WALLET_PACKAGE_NAME)).a(rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.b
            @Override // rx.m.a
            public final void call() {
                this.f4763f.handleAptoideAppsInstallationUserProperties();
            }
        })).n(new rx.m.b() { // from class: cm.aptoide.pt.v
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }).A();
        rx.b[] bVarArr = new rx.b[2];
        bVarArr[0] = sendAptoideApplicationStartAnalytics(uiModeManager.getCurrentModeType() == 4);
        bVarArr[1] = this.aptoideInstalledAppsRepository.syncWithDevice().K(Schedulers.computation());
        bVarA.a(rx.b.x(bVarArr)).n(new rx.m.b() { // from class: cm.aptoide.pt.w
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }).A().a(setUpFirstRunAnalytics()).a(this.launchManager.launch().K(Schedulers.computation())).I(new rx.m.a() { // from class: cm.aptoide.pt.f
            @Override // rx.m.a
            public final void call() {
                AptoideApplication.lambda$onCreate$5();
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.a0
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
        clearFileCache();
        startNotificationCenter();
        startNotificationCleaner();
        this.rootAvailabilityManager.isRootAvailable().g(new rx.m.b() { // from class: cm.aptoide.pt.l
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6616f.j((Boolean) obj);
            }
        }).u(new rx.m.b() { // from class: cm.aptoide.pt.h
            @Override // rx.m.b
            public final void call(Object obj) {
                AptoideApplication.lambda$onCreate$8((Boolean) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.z
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
        this.accountManager.accountStatus().X(new rx.m.e() { // from class: cm.aptoide.pt.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Account) obj).isLoggedIn());
            }
        }).t().G0(new rx.m.b() { // from class: cm.aptoide.pt.s
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7262f.i((Boolean) obj);
            }
        });
        Logger.getInstance().v(TAG, String.format("onCreate took %d millis.", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        this.invalidRefreshTokenLogoutManager.start();
        this.installManager.start();
    }
}
