package cm.aptoide.pt;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import cm.aptoide.accountmanager.AccountFactory;
import cm.aptoide.accountmanager.AccountPersistence;
import cm.aptoide.accountmanager.AccountService;
import cm.aptoide.accountmanager.AdultContent;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.AnalyticsLogger;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.EventLogger;
import cm.aptoide.analytics.SessionLogger;
import cm.aptoide.analytics.implementation.EventsPersistence;
import cm.aptoide.analytics.implementation.PageViewsAnalytics;
import cm.aptoide.analytics.implementation.loggers.FacebookEventLogger;
import cm.aptoide.analytics.implementation.loggers.FirebaseEventLogger;
import cm.aptoide.analytics.implementation.loggers.FlurryEventLogger;
import cm.aptoide.analytics.implementation.loggers.HttpKnockEventLogger;
import cm.aptoide.analytics.implementation.loggers.IndicativeEventLogger;
import cm.aptoide.analytics.implementation.loggers.RakamEventLogger;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.analytics.implementation.utils.AnalyticsEventParametersNormalizer;
import cm.aptoide.analytics.implementation.utils.MapToJsonMapper;
import cm.aptoide.pt.aab.DynamicSplitsManager;
import cm.aptoide.pt.aab.DynamicSplitsMapper;
import cm.aptoide.pt.aab.DynamicSplitsRemoteService;
import cm.aptoide.pt.aab.DynamicSplitsService;
import cm.aptoide.pt.aab.SplitsMapper;
import cm.aptoide.pt.abtesting.ABTestCenterRepository;
import cm.aptoide.pt.abtesting.ABTestManager;
import cm.aptoide.pt.abtesting.ABTestService;
import cm.aptoide.pt.abtesting.ABTestServiceProvider;
import cm.aptoide.pt.abtesting.AbTestCacheValidator;
import cm.aptoide.pt.abtesting.ExperimentModel;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.AccountServiceV3;
import cm.aptoide.pt.account.AdultContentAnalytics;
import cm.aptoide.pt.account.AgentPersistence;
import cm.aptoide.pt.account.AndroidAccountManagerPersistence;
import cm.aptoide.pt.account.AndroidAccountProvider;
import cm.aptoide.pt.account.DatabaseStoreDataPersist;
import cm.aptoide.pt.account.FacebookSignUpAdapter;
import cm.aptoide.pt.account.GoogleSignUpAdapter;
import cm.aptoide.pt.account.LoginPreferences;
import cm.aptoide.pt.account.MatureBodyInterceptorV7;
import cm.aptoide.pt.account.MatureContentPersistence;
import cm.aptoide.pt.account.OAuthModeProvider;
import cm.aptoide.pt.account.view.ImageInfoProvider;
import cm.aptoide.pt.account.view.store.StoreManager;
import cm.aptoide.pt.account.view.user.NewsletterManager;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.ads.AdsRepository;
import cm.aptoide.pt.ads.GooglePlayServicesAvailabilityChecker;
import cm.aptoide.pt.ads.MinimalAdMapper;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.ads.MoPubAnalytics;
import cm.aptoide.pt.ads.PackageRepositoryVersionCodeProvider;
import cm.aptoide.pt.ads.WalletAdsOfferCardManager;
import cm.aptoide.pt.ads.WalletAdsOfferManager;
import cm.aptoide.pt.analytics.AppSizeAnalyticsStringMapper;
import cm.aptoide.pt.analytics.FirstLaunchAnalytics;
import cm.aptoide.pt.analytics.TrackerFilter;
import cm.aptoide.pt.apkfy.ApkfyManager;
import cm.aptoide.pt.apkfy.ApkfyService;
import cm.aptoide.pt.apkfy.AptoideApkfyService;
import cm.aptoide.pt.app.AdsManager;
import cm.aptoide.pt.app.AppCoinsAdvertisingManager;
import cm.aptoide.pt.app.AppCoinsService;
import cm.aptoide.pt.app.AppViewAnalytics;
import cm.aptoide.pt.app.CampaignAnalytics;
import cm.aptoide.pt.app.DownloadStateParser;
import cm.aptoide.pt.app.ReviewsManager;
import cm.aptoide.pt.app.ReviewsRepository;
import cm.aptoide.pt.app.ReviewsService;
import cm.aptoide.pt.app.appsflyer.AppsFlyerManager;
import cm.aptoide.pt.app.appsflyer.AppsFlyerRepository;
import cm.aptoide.pt.app.appsflyer.AppsFlyerService;
import cm.aptoide.pt.app.aptoideinstall.AptoideInstallManager;
import cm.aptoide.pt.app.aptoideinstall.AptoideInstallRepository;
import cm.aptoide.pt.app.migration.AppcMigrationManager;
import cm.aptoide.pt.app.migration.AppcMigrationPersistence;
import cm.aptoide.pt.app.migration.AppcMigrationRepository;
import cm.aptoide.pt.app.mmpcampaigns.CampaignApiRepository;
import cm.aptoide.pt.app.mmpcampaigns.CampaignManager;
import cm.aptoide.pt.app.mmpcampaigns.CampaignMapper;
import cm.aptoide.pt.app.mmpcampaigns.CampaignRepository;
import cm.aptoide.pt.appview.PreferencesPersister;
import cm.aptoide.pt.autoupdate.Service;
import cm.aptoide.pt.blacklist.BlacklistManager;
import cm.aptoide.pt.blacklist.BlacklistPersistence;
import cm.aptoide.pt.blacklist.BlacklistUnitMapper;
import cm.aptoide.pt.blacklist.Blacklister;
import cm.aptoide.pt.bonus.BonusAppcRemoteService;
import cm.aptoide.pt.bonus.BonusAppcService;
import cm.aptoide.pt.bottomNavigation.BottomNavigationAnalytics;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.RoomAppComingSoonPersistence;
import cm.aptoide.pt.database.RoomAppcMigrationPersistence;
import cm.aptoide.pt.database.RoomAptoideInstallPersistence;
import cm.aptoide.pt.database.RoomDownloadPersistence;
import cm.aptoide.pt.database.RoomEventMapper;
import cm.aptoide.pt.database.RoomEventPersistence;
import cm.aptoide.pt.database.RoomExperimentMapper;
import cm.aptoide.pt.database.RoomExperimentPersistence;
import cm.aptoide.pt.database.RoomInstallationMapper;
import cm.aptoide.pt.database.RoomInstallationPersistence;
import cm.aptoide.pt.database.RoomInstalledPersistence;
import cm.aptoide.pt.database.RoomNotificationPersistence;
import cm.aptoide.pt.database.RoomStorePersistence;
import cm.aptoide.pt.database.RoomStoredMinimalAdPersistence;
import cm.aptoide.pt.database.RoomUpdatePersistence;
import cm.aptoide.pt.database.room.AptoideDatabase;
import cm.aptoide.pt.dataprovider.NetworkOperatorManager;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.ads.AdNetworkUtils;
import cm.aptoide.pt.dataprovider.cache.L2Cache;
import cm.aptoide.pt.dataprovider.cache.POSTCacheInterceptor;
import cm.aptoide.pt.dataprovider.cache.POSTCacheKeyAlgorithm;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.WSWidgetsUtils;
import cm.aptoide.pt.dataprovider.ws.v7.store.RequestBodyFactory;
import cm.aptoide.pt.download.AppValidationAnalytics;
import cm.aptoide.pt.download.AppValidator;
import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.download.DownloadInstallationProvider;
import cm.aptoide.pt.download.DownloadMirrorEventInterceptor;
import cm.aptoide.pt.download.DownloadSpeedIntervalMapper;
import cm.aptoide.pt.download.FileDownloadManagerProvider;
import cm.aptoide.pt.download.Md5Comparator;
import cm.aptoide.pt.download.OemidProvider;
import cm.aptoide.pt.download.SplitAnalyticsMapper;
import cm.aptoide.pt.download.SplitTypeSubFileTypeMapper;
import cm.aptoide.pt.download.view.DownloadStatusManager;
import cm.aptoide.pt.downloadmanager.AppDownloaderProvider;
import cm.aptoide.pt.downloadmanager.AptoideDownloadManager;
import cm.aptoide.pt.downloadmanager.DownloadAppFileMapper;
import cm.aptoide.pt.downloadmanager.DownloadAppMapper;
import cm.aptoide.pt.downloadmanager.DownloadPersistence;
import cm.aptoide.pt.downloadmanager.DownloadStatusMapper;
import cm.aptoide.pt.downloadmanager.DownloadsRepository;
import cm.aptoide.pt.downloadmanager.FileDownloaderProvider;
import cm.aptoide.pt.downloadmanager.RetryFileDownloadManagerProvider;
import cm.aptoide.pt.downloadmanager.RetryFileDownloaderProvider;
import cm.aptoide.pt.editorial.CaptionBackgroundPainter;
import cm.aptoide.pt.editorial.EditorialAnalytics;
import cm.aptoide.pt.editorial.EditorialService;
import cm.aptoide.pt.editorialList.EditorialListAnalytics;
import cm.aptoide.pt.file.CacheHelper;
import cm.aptoide.pt.file.FileManager;
import cm.aptoide.pt.home.AppComingSoonRegistrationManager;
import cm.aptoide.pt.home.AppComingSoonRegistrationPersistence;
import cm.aptoide.pt.home.ChipManager;
import cm.aptoide.pt.home.HomeAnalytics;
import cm.aptoide.pt.home.apps.AppMapper;
import cm.aptoide.pt.home.apps.UpdatesManager;
import cm.aptoide.pt.home.bundles.BundleDataSource;
import cm.aptoide.pt.home.bundles.BundlesRepository;
import cm.aptoide.pt.home.bundles.BundlesResponseMapper;
import cm.aptoide.pt.home.bundles.RemoteBundleDataSource;
import cm.aptoide.pt.home.bundles.ads.AdMapper;
import cm.aptoide.pt.install.AppInstallerStatusReceiver;
import cm.aptoide.pt.install.AptoideInstallPersistence;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.install.FilePathProvider;
import cm.aptoide.pt.install.ForegroundManager;
import cm.aptoide.pt.install.InstallAnalytics;
import cm.aptoide.pt.install.InstallAppSizeValidator;
import cm.aptoide.pt.install.InstallEvents;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.install.Installer;
import cm.aptoide.pt.install.InstallerAnalytics;
import cm.aptoide.pt.install.PackageRepository;
import cm.aptoide.pt.install.RootInstallNotificationEventReceiver;
import cm.aptoide.pt.install.RootInstallerProvider;
import cm.aptoide.pt.install.installer.DefaultInstaller;
import cm.aptoide.pt.install.installer.InstallationProvider;
import cm.aptoide.pt.install.installer.RootInstallErrorNotificationFactory;
import cm.aptoide.pt.install.installer.RootInstallationRetryHandler;
import cm.aptoide.pt.link.AptoideInstallParser;
import cm.aptoide.pt.logger.AnalyticsLogcatLogger;
import cm.aptoide.pt.navigator.Result;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import cm.aptoide.pt.networking.BodyInterceptorV7;
import cm.aptoide.pt.networking.Cdn;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.networking.MultipartBodyInterceptor;
import cm.aptoide.pt.networking.NoAuthenticationBodyInterceptorV3;
import cm.aptoide.pt.networking.NoOpTokenInvalidator;
import cm.aptoide.pt.networking.RefreshTokenInvalidator;
import cm.aptoide.pt.networking.UserAgentInterceptor;
import cm.aptoide.pt.networking.UserAgentInterceptorDownloads;
import cm.aptoide.pt.networking.UserAgentInterceptorV8;
import cm.aptoide.pt.notification.AptoideWorkerFactory;
import cm.aptoide.pt.notification.ComingSoonNotificationManager;
import cm.aptoide.pt.notification.NotificationAnalytics;
import cm.aptoide.pt.notification.NotificationIdsMapper;
import cm.aptoide.pt.notification.NotificationProvider;
import cm.aptoide.pt.notification.PullingContentService;
import cm.aptoide.pt.notification.ReadyToInstallNotificationManager;
import cm.aptoide.pt.notification.RoomLocalNotificationSyncMapper;
import cm.aptoide.pt.notification.RoomLocalNotificationSyncPersistence;
import cm.aptoide.pt.notification.SystemNotificationShower;
import cm.aptoide.pt.notification.UpdatesNotificationManager;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import cm.aptoide.pt.packageinstaller.AppInstaller;
import cm.aptoide.pt.packageinstaller.InstallResultCallback;
import cm.aptoide.pt.packageinstaller.InstallStatus;
import cm.aptoide.pt.preferences.AptoideMd5Manager;
import cm.aptoide.pt.preferences.Preferences;
import cm.aptoide.pt.preferences.SecurePreferences;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.preferences.secure.SecureCoderDecoder;
import cm.aptoide.pt.preferences.secure.SecurePreferencesImplementation;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import cm.aptoide.pt.promotions.PromotionViewAppMapper;
import cm.aptoide.pt.promotions.PromotionsAnalytics;
import cm.aptoide.pt.promotions.PromotionsManager;
import cm.aptoide.pt.promotions.PromotionsPreferencesManager;
import cm.aptoide.pt.promotions.PromotionsService;
import cm.aptoide.pt.reactions.ReactionsManager;
import cm.aptoide.pt.reactions.network.ReactionsRemoteService;
import cm.aptoide.pt.reactions.network.ReactionsService;
import cm.aptoide.pt.root.RootAvailabilityManager;
import cm.aptoide.pt.root.RootValueSaver;
import cm.aptoide.pt.search.SearchHostProvider;
import cm.aptoide.pt.search.SearchRepository;
import cm.aptoide.pt.search.analytics.SearchAnalytics;
import cm.aptoide.pt.search.suggestions.SearchSuggestionManager;
import cm.aptoide.pt.search.suggestions.SearchSuggestionRemoteRepository;
import cm.aptoide.pt.search.suggestions.SearchSuggestionService;
import cm.aptoide.pt.search.suggestions.TrendingManager;
import cm.aptoide.pt.search.suggestions.TrendingService;
import cm.aptoide.pt.socialmedia.SocialMediaAnalytics;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreCredentialsProviderImpl;
import cm.aptoide.pt.store.StorePersistence;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.sync.SyncScheduler;
import cm.aptoide.pt.sync.alarm.AlarmSyncScheduler;
import cm.aptoide.pt.sync.alarm.SyncStorage;
import cm.aptoide.pt.themes.NewFeature;
import cm.aptoide.pt.themes.NewFeatureManager;
import cm.aptoide.pt.themes.ThemeAnalytics;
import cm.aptoide.pt.updates.UpdateMapper;
import cm.aptoide.pt.updates.UpdatePersistence;
import cm.aptoide.pt.updates.UpdateRepository;
import cm.aptoide.pt.updates.UpdatesAnalytics;
import cm.aptoide.pt.util.MarketResourceFormatter;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.FileUtils;
import cm.aptoide.pt.utils.q.QManager;
import cm.aptoide.pt.view.app.AppCenter;
import cm.aptoide.pt.view.app.AppCenterRepository;
import cm.aptoide.pt.view.app.AppService;
import cm.aptoide.pt.view.settings.SupportEmailProvider;
import cm.aptoide.pt.wallet.WalletAppProvider;
import com.aptoide.authentication.AptoideAuthentication;
import com.aptoide.authentication.network.RemoteAuthenticationService;
import com.aptoide.authenticationrx.AptoideAuthenticationRx;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class ApplicationModule {
    private final AptoideApplication application;

    public ApplicationModule(AptoideApplication aptoideApplication) {
        this.application = aptoideApplication;
    }

    private int getInstallingStateTimeout() {
        if (Build.VERSION.SDK_INT >= 21) {
            return BuildConfig.INSTALLING_STATE_INSTALLER_TIMEOUT_IN_MILLIS_21_PLUS;
        }
        return 60000;
    }

    @Singleton
    DownloadStatusMapper downloadStatusMapper() {
        return new DownloadStatusMapper();
    }

    @Singleton
    FilePathProvider filePathManager(@Named("cachePath") String str, @Named("apkPath") String str2, @Named("obbPath") String str3) {
        return new FilePathProvider(str2, str3, str);
    }

    @Singleton
    AccountAnalytics provideAccountAnalytics(NavigationTracker navigationTracker, AnalyticsManager analyticsManager) {
        return new AccountAnalytics(navigationTracker, CrashReport.getInstance(), analyticsManager);
    }

    @Singleton
    AccountFactory provideAccountFactory() {
        return new AccountFactory();
    }

    @Singleton
    AccountManager provideAccountManager() {
        return AccountManager.get(this.application);
    }

    @Singleton
    AccountService provideAccountService(@Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, @Named("long-timeout") OkHttpClient okHttpClient2, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, AuthenticationPersistence authenticationPersistence, TokenInvalidator tokenInvalidator, @Named("pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named("web-v7") BodyInterceptor<BaseBody> bodyInterceptor2, @Named("multipart") MultipartBodyInterceptor multipartBodyInterceptor, @Named("no-authentication-v3") BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> bodyInterceptor3, @Named("defaultInterceptorV3") BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> bodyInterceptor4, @Named(BuildConfig.APTOIDE_THEME) ObjectMapper objectMapper, Converter.Factory factory, @Named("extraID") String str, AccountFactory accountFactory, OAuthModeProvider oAuthModeProvider, AptoideAuthenticationRx aptoideAuthenticationRx) {
        return new AccountServiceV3(accountFactory, okHttpClient, okHttpClient2, factory, objectMapper, sharedPreferences, str, tokenInvalidator, authenticationPersistence, bodyInterceptor3, bodyInterceptor4, multipartBodyInterceptor, bodyInterceptor2, bodyInterceptor, oAuthModeProvider, aptoideAuthenticationRx);
    }

    @Singleton
    @Named
    BodyInterceptor<BaseBody> provideAccountSettingsBodyInterceptorPoolV7(@Named("pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, AdultContent adultContent) {
        return new MatureBodyInterceptorV7(bodyInterceptor, adultContent);
    }

    @Singleton
    @Named
    String provideAccountType() {
        return "cm.aptoide.pt";
    }

    @Singleton
    AdsRepository provideAdsRepository(IdsRepository idsRepository, AptoideAccountManager aptoideAccountManager, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, QManager qManager, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider, ConnectivityManager connectivityManager, OemidProvider oemidProvider) {
        return new AdsRepository(idsRepository, aptoideAccountManager, okHttpClient, WebService.getDefaultConverter(), qManager, sharedPreferences, this.application.getApplicationContext(), connectivityManager, this.application.getResources(), adsApplicationVersionCodeProvider, new GooglePlayServicesAvailabilityChecker() { // from class: cm.aptoide.pt.q0
            @Override // cm.aptoide.pt.ads.GooglePlayServicesAvailabilityChecker
            public final boolean isAvailable(Context context) {
                return AdNetworkUtils.isGooglePlayServicesAvailable(context);
            }
        }, oemidProvider.getOemid(), new MinimalAdMapper());
    }

    @Singleton
    AdultContentAnalytics provideAdultContentAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return new AdultContentAnalytics(analyticsManager, navigationTracker);
    }

    @Singleton
    AndroidAccountProvider provideAndroidAccountProvider(AccountManager accountManager, @Named("accountType") String str) {
        return new AndroidAccountProvider(accountManager, str, Schedulers.io());
    }

    @Singleton
    @Named
    String provideApkPath() {
        return this.application.getApplicationContext().getCacheDir().getAbsolutePath();
    }

    @Singleton
    ApkfyManager provideApkfyManager(ApkfyService apkfyService) {
        return new ApkfyManager(apkfyService);
    }

    @Singleton
    ApkfyService provideApkfyService(AptoideApkfyService.ServiceApi serviceApi) {
        return new AptoideApkfyService(serviceApi);
    }

    @Singleton
    com.facebook.o0.a0 provideAppEventsLogger() {
        return com.facebook.o0.a0.e(this.application);
    }

    @Singleton
    AppSizeAnalyticsStringMapper provideAppSizeAnalyticsStringMapper() {
        return new AppSizeAnalyticsStringMapper();
    }

    @Singleton
    AptoideAccountManager provideAptoideAccountManager(AdultContent adultContent, GoogleApiClient googleApiClient, StoreManager storeManager, AccountService accountService, LoginPreferences loginPreferences, AccountPersistence accountPersistence, @Named("facebookLoginPermissions") List<String> list) {
        com.facebook.a0.M(this.application);
        return new AptoideAccountManager.Builder().setAccountPersistence(new MatureContentPersistence(accountPersistence, adultContent)).setAccountService(accountService).setAdultService(adultContent).registerSignUpAdapter(GoogleSignUpAdapter.TYPE, new GoogleSignUpAdapter(googleApiClient, loginPreferences)).registerSignUpAdapter(FacebookSignUpAdapter.TYPE, new FacebookSignUpAdapter(list, com.facebook.login.x.g(), loginPreferences)).setStoreManager(storeManager).build();
    }

    @Singleton
    AptoideApplicationAnalytics provideAptoideApplicationAnalytics(AnalyticsManager analyticsManager, FirebaseAnalytics firebaseAnalytics) {
        return new AptoideApplicationAnalytics(analyticsManager, firebaseAnalytics);
    }

    @Singleton
    AptoideDownloadManager provideAptoideDownloadManager(DownloadsRepository downloadsRepository, DownloadStatusMapper downloadStatusMapper, DownloadAppMapper downloadAppMapper, AppDownloaderProvider appDownloaderProvider, @Named("apkPath") String str, @Named("obbPath") String str2, DownloadAnalytics downloadAnalytics) {
        FileUtils.createDir(str);
        FileUtils.createDir(str2);
        return new AptoideDownloadManager(downloadsRepository, downloadStatusMapper, downloadAppMapper, appDownloaderProvider, downloadAnalytics);
    }

    @Singleton
    @Named
    OkHttpClient provideAptoideMMpOkHttpClient(@Named("aptoide-mmp-okhttp-builder") OkHttpClient.Builder builder, @Named("user-agent") Interceptor interceptor) {
        builder.addInterceptor(interceptor);
        return builder.build();
    }

    @Singleton
    @Named
    String provideAptoideMmpBaseHost() {
        return "https://aptoide-mmp.aptoide.com/api/v1/";
    }

    @Singleton
    @Named
    String provideAptoidePackage() {
        return "cm.aptoide.pt";
    }

    @Singleton
    AuthenticationPersistence provideAuthenticationPersistence(AndroidAccountProvider androidAccountProvider) {
        return new AuthenticationPersistence(androidAccountProvider, (AccountManager) this.application.getSystemService("account"));
    }

    @Singleton
    @Named
    BodyInterceptor<BaseBody> provideBodyInterceptorPoolV7(AuthenticationPersistence authenticationPersistence, IdsRepository idsRepository, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, Resources resources, QManager qManager, @Named("aptoidePackage") String str, AptoideMd5Manager aptoideMd5Manager) {
        return new BodyInterceptorV7(idsRepository, authenticationPersistence, aptoideMd5Manager, str, qManager, Cdn.POOL, sharedPreferences, resources, BuildConfig.VERSION_CODE);
    }

    @Singleton
    @Named
    BodyInterceptor<BaseBody> provideBodyInterceptorWebV7(AuthenticationPersistence authenticationPersistence, IdsRepository idsRepository, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, Resources resources, QManager qManager, @Named("aptoidePackage") String str, AptoideMd5Manager aptoideMd5Manager) {
        return new BodyInterceptorV7(idsRepository, authenticationPersistence, aptoideMd5Manager, str, qManager, Cdn.WEB, sharedPreferences, resources, BuildConfig.VERSION_CODE);
    }

    @Singleton
    CacheHelper provideCacheHelper(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, @Named("cachePath") String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new CacheHelper.FolderToManage(new File(str), PullingContentService.UPDATES_INTERVAL));
        linkedList.add(new CacheHelper.FolderToManage(new File(str + "icons/"), PullingContentService.UPDATES_INTERVAL));
        linkedList.add(new CacheHelper.FolderToManage(new File(this.application.getCacheDir() + "image_manager_disk_cache/"), PullingContentService.UPDATES_INTERVAL));
        return new CacheHelper(ManagerPreferences.getCacheLimit(sharedPreferences), linkedList, new FileUtils());
    }

    @Singleton
    @Named
    String provideCachePath() {
        return this.application.getApplicationContext().getCacheDir().getAbsolutePath() + "/";
    }

    @Singleton
    com.facebook.y provideCallbackManager() {
        return new com.facebook.internal.t();
    }

    @Singleton
    CampaignManager provideCampaignManager(CampaignRepository campaignRepository, @Named("secureShared") SharedPreferences sharedPreferences) {
        return new CampaignManager(campaignRepository, sharedPreferences);
    }

    @Singleton
    CampaignMapper provideCampaignMapper() {
        return new CampaignMapper();
    }

    @Singleton
    CampaignRepository provideCampaignRepository(@Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient) {
        return new CampaignApiRepository(okHttpClient);
    }

    @Singleton
    ContentResolver provideContentResolver() {
        return this.application.getContentResolver();
    }

    @Singleton
    DeepLinkAnalytics provideDeepLinkAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return new DeepLinkAnalytics(analyticsManager, navigationTracker);
    }

    @Singleton
    @Named
    List<String> provideDefaultFollowedStores() {
        return Arrays.asList(DeepLinkIntentReceiver.DeepLinksTargets.APPS, "catappult");
    }

    @Singleton
    @Named
    Installer provideDefaultInstaller(InstallationProvider installationProvider, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, RootAvailabilityManager rootAvailabilityManager, InstallerAnalytics installerAnalytics, AppInstaller appInstaller, AppInstallerStatusReceiver appInstallerStatusReceiver, RootInstallerProvider rootInstallerProvider) {
        return new DefaultInstaller(this.application.getPackageManager(), installationProvider, appInstaller, new FileUtils(), ToolboxManager.isDebug(sharedPreferences), aptoideInstalledAppsRepository, BuildConfig.ROOT_TIMEOUT, rootAvailabilityManager, sharedPreferences, installerAnalytics, getInstallingStateTimeout(), appInstallerStatusReceiver, rootInstallerProvider, this.application);
    }

    @Singleton
    Preferences provideDefaultPreferences(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        return new Preferences(sharedPreferences);
    }

    @Singleton
    DownloadFactory provideDownloadFactory(@Named("marketName") String str, @Named("cachePath") String str2, AppValidator appValidator, SplitTypeSubFileTypeMapper splitTypeSubFileTypeMapper) {
        return new DownloadFactory(str, str2, appValidator, splitTypeSubFileTypeMapper);
    }

    @Singleton
    DownloadPersistence provideDownloadPersistence(AptoideDatabase aptoideDatabase) {
        return new RoomDownloadPersistence(aptoideDatabase.downloadDAO());
    }

    @Singleton
    DownloadSpeedIntervalMapper provideDownloadSpeedIntervalMapper() {
        return new DownloadSpeedIntervalMapper();
    }

    @Singleton
    DownloadsRepository provideDownloadsRepository(DownloadPersistence downloadPersistence) {
        return new DownloadsRepository(downloadPersistence);
    }

    @Singleton
    @Named
    String provideExtraID() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Singleton
    @Named
    Collection<String> provideFacebookEvents() {
        return Arrays.asList(InstallAnalytics.APPLICATION_INSTALL, InstallAnalytics.NOTIFICATION_APPLICATION_INSTALL, InstallAnalytics.EDITORS_APPLICATION_INSTALL, DownloadAnalytics.EDITORS_CHOICE_DOWNLOAD_COMPLETE_EVENT_NAME, DownloadAnalytics.NOTIFICATION_DOWNLOAD_COMPLETE_EVENT_NAME, DownloadAnalytics.DOWNLOAD_COMPLETE_EVENT, SearchAnalytics.SEARCH, SearchAnalytics.NO_RESULTS, SearchAnalytics.APP_CLICK, SearchAnalytics.SEARCH_START, SearchAnalytics.AB_SEARCH_ACTION, SearchAnalytics.AB_SEARCH_IMPRESSION, AppViewAnalytics.EDITORS_CHOICE_CLICKS, AppViewAnalytics.APP_VIEW_OPEN_FROM, AppViewAnalytics.APP_VIEW_INTERACT, NotificationAnalytics.NOTIFICATION_RECEIVED, NotificationAnalytics.NOTIFICATION_IMPRESSION, NotificationAnalytics.NOTIFICATION_PRESSED, StoreAnalytics.STORES_TAB_INTERACT, StoreAnalytics.STORES_OPEN, StoreAnalytics.STORES_INTERACT, AccountAnalytics.SIGN_UP_EVENT_NAME, AccountAnalytics.LOGIN_EVENT_NAME, UpdatesAnalytics.UPDATE_EVENT, PageViewsAnalytics.PAGE_VIEW_EVENT, FirstLaunchAnalytics.FIRST_LAUNCH, FirstLaunchAnalytics.PLAY_PROTECT_EVENT, InstallEvents.ROOT_V2_COMPLETE, InstallEvents.ROOT_V2_START, AppViewAnalytics.SIMILAR_APP_INTERACT, AccountAnalytics.LOGIN_SIGN_UP_START_SCREEN, AccountAnalytics.CREATE_USER_PROFILE, AccountAnalytics.PROFILE_SETTINGS, AccountAnalytics.ENTRY, DeepLinkAnalytics.FACEBOOK_APP_LAUNCH, AppViewAnalytics.CLICK_INSTALL, AppShortcutsAnalytics.APPS_SHORTCUTS, AccountAnalytics.CREATE_YOUR_STORE, HomeAnalytics.HOME_INTERACT, HomeAnalytics.CURATION_CARD_CLICK, HomeAnalytics.CURATION_CARD_IMPRESSION, HomeAnalytics.HOME_CHIP_INTERACT, AccountAnalytics.PROMOTE_APTOIDE_EVENT_NAME, EditorialListAnalytics.EDITORIAL_BN_CURATION_CARD_CLICK, EditorialListAnalytics.EDITORIAL_BN_CURATION_CARD_IMPRESSION, BottomNavigationAnalytics.BOTTOM_NAVIGATION_INTERACT, DownloadAnalytics.DOWNLOAD_INTERACT, EditorialAnalytics.CURATION_CARD_INSTALL, EditorialAnalytics.EDITORIAL_BN_CURATION_CARD_INSTALL, EditorialAnalytics.REACTION_INTERACT, PromotionsAnalytics.PROMOTION_DIALOG, PromotionsAnalytics.PROMOTIONS_INTERACT, PromotionsAnalytics.VALENTINE_MIGRATOR, AppViewAnalytics.ADS_BLOCK_BY_OFFER, AppViewAnalytics.APPC_SIMILAR_APP_INTERACT, AppViewAnalytics.BONUS_MIGRATION_APPVIEW, AppViewAnalytics.BONUS_GAME_WALLET_OFFER_19, DeepLinkAnalytics.APPCOINS_WALLET_DEEPLINK, AptoideApplicationAnalytics.IS_ANDROID_TV, ThemeAnalytics.DARK_THEME_INTERACT_EVENT, UserFeedbackAnalytics.USER_FEEDBACK_EVENT_NAME, InstallEvents.IS_INSTALLATION_TYPE_EVENT_NAME, AppValidationAnalytics.INVALID_DOWNLOAD_PATH_EVENT, SocialMediaAnalytics.PROMOTE_SOCIAL_MEDIA_EVENT_NAME, HomeAnalytics.VANILLA_PROMOTIONAL_CARDS);
    }

    @Singleton
    FileUtils provideFileUtils() {
        return new FileUtils();
    }

    @Singleton
    FirebaseAnalytics provideFirebaseAnalytics() {
        return FirebaseAnalytics.getInstance(this.application);
    }

    @Singleton
    FirebaseNotificationAnalytics provideFirebaseNotificationAnalytics(AnalyticsManager analyticsManager) {
        return new FirebaseNotificationAnalytics(analyticsManager);
    }

    @Singleton
    @Named
    Collection<String> provideFlurryEvents() {
        return new LinkedList(Arrays.asList(InstallAnalytics.APPLICATION_INSTALL, DownloadAnalytics.EDITORS_CHOICE_DOWNLOAD_COMPLETE_EVENT_NAME, DownloadAnalytics.DOWNLOAD_COMPLETE_EVENT, AppViewAnalytics.HOME_PAGE_EDITORS_CHOICE_FLURRY, AppViewAnalytics.APP_VIEW_OPEN_FROM, StoreAnalytics.STORES_TAB_INTERACT, StoreAnalytics.STORES_OPEN, StoreAnalytics.STORES_INTERACT, AccountAnalytics.SIGN_UP_EVENT_NAME, AccountAnalytics.LOGIN_EVENT_NAME, FirstLaunchAnalytics.FIRST_LAUNCH, AccountAnalytics.LOGIN_SIGN_UP_START_SCREEN, AccountAnalytics.CREATE_USER_PROFILE, AccountAnalytics.CREATE_YOUR_STORE, AccountAnalytics.PROFILE_SETTINGS, AdultContentAnalytics.ADULT_CONTENT, DeepLinkAnalytics.APP_LAUNCH, DeepLinkAnalytics.FACEBOOK_APP_LAUNCH, AppViewAnalytics.CLICK_INSTALL, InstallAnalytics.NOTIFICATION_APPLICATION_INSTALL, InstallAnalytics.EDITORS_APPLICATION_INSTALL, DownloadAnalytics.NOTIFICATION_DOWNLOAD_COMPLETE_EVENT_NAME, SearchAnalytics.SEARCH, SearchAnalytics.NO_RESULTS, SearchAnalytics.APP_CLICK, SearchAnalytics.SEARCH_START, SearchAnalytics.AB_SEARCH_ACTION, SearchAnalytics.AB_SEARCH_IMPRESSION, AppViewAnalytics.EDITORS_CHOICE_CLICKS, AppViewAnalytics.APP_VIEW_INTERACT, NotificationAnalytics.NOTIFICATION_RECEIVED, NotificationAnalytics.NOTIFICATION_IMPRESSION, NotificationAnalytics.NOTIFICATION_PRESSED, UpdatesAnalytics.UPDATE_EVENT, PageViewsAnalytics.PAGE_VIEW_EVENT, FirstLaunchAnalytics.PLAY_PROTECT_EVENT, InstallEvents.ROOT_V2_COMPLETE, InstallEvents.ROOT_V2_START, AppViewAnalytics.SIMILAR_APP_INTERACT, AccountAnalytics.ENTRY, AppShortcutsAnalytics.APPS_SHORTCUTS, HomeAnalytics.HOME_INTERACT, HomeAnalytics.CURATION_CARD_CLICK, HomeAnalytics.CURATION_CARD_IMPRESSION, HomeAnalytics.HOME_CHIP_INTERACT, AccountAnalytics.PROMOTE_APTOIDE_EVENT_NAME, EditorialListAnalytics.EDITORIAL_BN_CURATION_CARD_CLICK, EditorialListAnalytics.EDITORIAL_BN_CURATION_CARD_IMPRESSION, BottomNavigationAnalytics.BOTTOM_NAVIGATION_INTERACT, DownloadAnalytics.DOWNLOAD_INTERACT, EditorialAnalytics.CURATION_CARD_INSTALL, EditorialAnalytics.EDITORIAL_BN_CURATION_CARD_INSTALL, EditorialAnalytics.REACTION_INTERACT, PromotionsAnalytics.PROMOTION_DIALOG, PromotionsAnalytics.PROMOTIONS_INTERACT, PromotionsAnalytics.VALENTINE_MIGRATOR, AppViewAnalytics.ADS_BLOCK_BY_OFFER, AppViewAnalytics.APPC_SIMILAR_APP_INTERACT, AppViewAnalytics.BONUS_MIGRATION_APPVIEW, AppViewAnalytics.BONUS_GAME_WALLET_OFFER_19, DeepLinkAnalytics.APPCOINS_WALLET_DEEPLINK, AptoideApplicationAnalytics.IS_ANDROID_TV, ThemeAnalytics.DARK_THEME_INTERACT_EVENT, UserFeedbackAnalytics.USER_FEEDBACK_EVENT_NAME, InstallEvents.IS_INSTALLATION_TYPE_EVENT_NAME, AppValidationAnalytics.INVALID_DOWNLOAD_PATH_EVENT, SocialMediaAnalytics.PROMOTE_SOCIAL_MEDIA_EVENT_NAME, HomeAnalytics.VANILLA_PROMOTIONAL_CARDS));
    }

    @Singleton
    Map<Integer, Result> provideFragmentNavigatorMap() {
        return new HashMap();
    }

    @Singleton
    e.g.b.a<Map<Integer, Result>> provideFragmentNavigatorRelay() {
        return e.g.b.a.f1();
    }

    @Singleton
    GoogleApiClient provideGoogleApiClient() {
        return new GoogleApiClient.Builder(this.application).b(Auth.f11405g, new GoogleSignInOptions.Builder(GoogleSignInOptions.f11509k).b().f(BuildConfig.GMS_SERVER_ID).a()).e();
    }

    @Singleton
    @Named
    String provideHomePromotionsId() {
        return BuildConfig.HOME_PROMOTION_ID;
    }

    @Singleton
    IdsRepository provideIdsRepository(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, ContentResolver contentResolver) {
        Context applicationContext = this.application.getApplicationContext();
        return new IdsRepository(SecurePreferencesImplementation.getInstance(applicationContext, sharedPreferences), applicationContext, Settings.Secure.getString(contentResolver, "android_id"));
    }

    @Singleton
    @Named
    String provideImageCachePatch(@Named("cachePath") String str) {
        return str + "icons/";
    }

    @Singleton
    InstallAnalytics provideInstallAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker, ConnectivityManager connectivityManager, TelephonyManager telephonyManager, AppSizeAnalyticsStringMapper appSizeAnalyticsStringMapper) {
        return new InstallAnalytics(CrashReport.getInstance(), analyticsManager, navigationTracker, new HashMap(), connectivityManager, telephonyManager, appSizeAnalyticsStringMapper);
    }

    @Singleton
    InstallationProvider provideInstallationProvider(AptoideDownloadManager aptoideDownloadManager, DownloadPersistence downloadPersistence, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence) {
        return new DownloadInstallationProvider(aptoideDownloadManager, downloadPersistence, aptoideInstalledAppsRepository, new MinimalAdMapper(), roomStoredMinimalAdPersistence);
    }

    @Singleton
    AptoideInstalledAppsRepository provideInstalledRepository(RoomInstalledPersistence roomInstalledPersistence, FileUtils fileUtils) {
        return new AptoideInstalledAppsRepository(roomInstalledPersistence, this.application.getPackageManager(), fileUtils);
    }

    @Singleton
    InvalidRefreshTokenLogoutManager provideInvalidRefreshTokenLogoutManager(AptoideAccountManager aptoideAccountManager, TokenInvalidator tokenInvalidator) {
        return new InvalidRefreshTokenLogoutManager(aptoideAccountManager, (RefreshTokenInvalidator) tokenInvalidator);
    }

    @Singleton
    L2Cache provideL2Cache() {
        return new L2Cache(new POSTCacheKeyAlgorithm(), new File(this.application.getCacheDir(), "aptoide.wscache"));
    }

    @Singleton
    @Named
    OkHttpClient provideLongTimeoutOkHttpClient(@Named("user-agent") Interceptor interceptor, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, @Named("retrofit-log") Interceptor interceptor2) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        builder.addInterceptor(interceptor2);
        TimeUnit timeUnit = TimeUnit.MINUTES;
        builder.connectTimeout(2L, timeUnit);
        builder.readTimeout(2L, timeUnit);
        builder.writeTimeout(2L, timeUnit);
        if (ToolboxManager.isToolboxEnableRetrofitLogs(sharedPreferences)) {
            builder.addInterceptor(interceptor2);
        }
        return builder.build();
    }

    @Singleton
    @Named
    String provideMarketName() {
        return BuildConfig.MARKET_NAME;
    }

    @Singleton
    MarketResourceFormatter provideMarketResourceFormatter(@Named("marketName") String str) {
        return new MarketResourceFormatter(str);
    }

    @Singleton
    @Named
    MultipartBodyInterceptor provideMultipartBodyInterceptor(IdsRepository idsRepository, AuthenticationPersistence authenticationPersistence, RequestBodyFactory requestBodyFactory) {
        return new MultipartBodyInterceptor(idsRepository, requestBodyFactory, authenticationPersistence);
    }

    @Singleton
    NavigationTracker provideNavigationTracker(PageViewsAnalytics pageViewsAnalytics, AnalyticsLogger analyticsLogger) {
        return new NavigationTracker(new ArrayList(), new TrackerFilter(), pageViewsAnalytics, analyticsLogger);
    }

    @Singleton
    @Named
    BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> provideNoAuthenticationBodyInterceptorV3(IdsRepository idsRepository, @Named("aptoidePackage") String str, AptoideMd5Manager aptoideMd5Manager) {
        return new NoAuthenticationBodyInterceptorV3(idsRepository, aptoideMd5Manager, str);
    }

    @Singleton
    @Named
    ObjectMapper provideNonNullObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    @Singleton
    NotificationAnalytics provideNotificationAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return new NotificationAnalytics(new AptoideInstallParser(), analyticsManager, navigationTracker);
    }

    @Singleton
    NotificationProvider provideNotificationProvider(RoomNotificationPersistence roomNotificationPersistence) {
        return new NotificationProvider(roomNotificationPersistence, Schedulers.io());
    }

    @Singleton
    OAuthModeProvider provideOAuthModeProvider() {
        return new OAuthModeProvider();
    }

    @Singleton
    @Named
    String provideObbPath() {
        return this.application.getApplicationContext().getCacheDir().getAbsolutePath();
    }

    @Singleton
    @Named
    OkHttpClient provideOkHttpClient(@Named(BuildConfig.APTOIDE_THEME) OkHttpClient.Builder builder, @Named("user-agent") Interceptor interceptor) {
        builder.addInterceptor(interceptor);
        return builder.build();
    }

    @Singleton
    PageViewsAnalytics providePageViewsAnalytics(AnalyticsManager analyticsManager) {
        return new PageViewsAnalytics(analyticsManager);
    }

    @Singleton
    PermissionManager providePermissionManager() {
        return new PermissionManager();
    }

    @Singleton
    PromotionsManager providePromotionsManager(InstallManager installManager, PromotionViewAppMapper promotionViewAppMapper, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, PromotionsAnalytics promotionsAnalytics, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, PromotionsService promotionsService, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, MoPubAdsManager moPubAdsManager, WalletAppProvider walletAppProvider, DynamicSplitsManager dynamicSplitsManager, SplitAnalyticsMapper splitAnalyticsMapper) {
        return new PromotionsManager(promotionViewAppMapper, installManager, downloadFactory, downloadStateParser, promotionsAnalytics, notificationAnalytics, installAnalytics, this.application.getApplicationContext().getPackageManager(), promotionsService, aptoideInstalledAppsRepository, moPubAdsManager, walletAppProvider, dynamicSplitsManager, splitAnalyticsMapper);
    }

    @Singleton
    QManager provideQManager(Resources resources, WindowManager windowManager) {
        return new QManager(resources, (ActivityManager) this.application.getSystemService("activity"), windowManager, (UiModeManager) this.application.getSystemService("uimode"));
    }

    @Singleton
    RequestBodyFactory provideRequestBodyFactory() {
        return new RequestBodyFactory();
    }

    @Singleton
    Resources provideResources() {
        return this.application.getResources();
    }

    @Singleton
    @Named
    Interceptor provideRetrofitLogInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Singleton
    RoomInstalledPersistence provideRoomInstalledPersistence(AptoideDatabase aptoideDatabase, RoomInstallationPersistence roomInstallationPersistence, RoomInstallationMapper roomInstallationMapper) {
        return new RoomInstalledPersistence(aptoideDatabase.installedDao(), roomInstallationPersistence, roomInstallationMapper);
    }

    @Singleton
    RoomNotificationPersistence provideRoomNotificationPersistence(AptoideDatabase aptoideDatabase) {
        return new RoomNotificationPersistence(aptoideDatabase.notificationDao());
    }

    @Singleton
    RootAvailabilityManager provideRootAvailabilityManager(@Named("secure") final SecurePreferences securePreferences) {
        return new RootAvailabilityManager(new RootValueSaver() { // from class: cm.aptoide.pt.ApplicationModule.1
            final String IS_PHONE_ROOTED = "IS_PHONE_ROOTED";

            @Override // cm.aptoide.pt.root.RootValueSaver
            public Single<Boolean> isPhoneRoot() {
                return securePreferences.getBoolean("IS_PHONE_ROOTED", false).E().Z0();
            }

            @Override // cm.aptoide.pt.root.RootValueSaver
            public rx.b save(boolean z) {
                return securePreferences.save("IS_PHONE_ROOTED", z);
            }
        });
    }

    @Singleton
    RootInstallationRetryHandler provideRootInstallationRetryHandler(InstallManager installManager) {
        Intent intent = new Intent(this.application, (Class<?>) RootInstallNotificationEventReceiver.class);
        intent.setAction(RootInstallNotificationEventReceiver.ROOT_INSTALL_RETRY_ACTION);
        androidx.core.app.i.a aVar = new androidx.core.app.i.a(R.drawable.ic_refresh_action_black, this.application.getString(R.string.generalscreen_short_root_install_timeout_error_action), PendingIntent.getBroadcast(this.application, 2, intent, 67108864));
        PendingIntent broadcast = PendingIntent.getBroadcast(this.application, 3, intent.setAction(RootInstallNotificationEventReceiver.ROOT_INSTALL_DISMISS_ACTION), 67108864);
        SystemNotificationShower systemNotificationShower = this.application.getSystemNotificationShower();
        e.g.b.c cVarF1 = e.g.b.c.f1();
        AptoideApplication aptoideApplication = this.application;
        return new RootInstallationRetryHandler(230498, systemNotificationShower, installManager, cVarF1, 0, aptoideApplication, new RootInstallErrorNotificationFactory(230498, BitmapFactory.decodeResource(aptoideApplication.getResources(), R.mipmap.ic_launcher), aVar, broadcast));
    }

    @Singleton
    @Named
    String provideSearchBaseUrl(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        return new SearchHostProvider(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences), cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_SCHEME, cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_SEARCH_HOST, cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_SEARCH_SSL_HOST).getSearchHost();
    }

    @Singleton
    SecureCoderDecoder provideSecureCoderDecoder(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        return new SecureCoderDecoder.Builder(this.application, sharedPreferences).create();
    }

    @Singleton
    SplitTypeSubFileTypeMapper provideSplitTypeSubFileTypeMapper() {
        return new SplitTypeSubFileTypeMapper();
    }

    @Singleton
    StoreManager provideStoreManager(@Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, @Named("multipart") MultipartBodyInterceptor multipartBodyInterceptor, @Named("defaultInterceptorV3") BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> bodyInterceptor, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor2, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, RequestBodyFactory requestBodyFactory, @Named(BuildConfig.APTOIDE_THEME) ObjectMapper objectMapper, RoomStoreRepository roomStoreRepository) {
        return new StoreManager(okHttpClient, WebService.getDefaultConverter(), multipartBodyInterceptor, bodyInterceptor, bodyInterceptor2, sharedPreferences, tokenInvalidator, requestBodyFactory, objectMapper, roomStoreRepository);
    }

    @Singleton
    @Named
    String provideStoreName() {
        return DeepLinkIntentReceiver.DeepLinksTargets.APPS;
    }

    @Singleton
    StoreUtilsProxy provideStoreUtilsProxy(AptoideAccountManager aptoideAccountManager, RoomStoreRepository roomStoreRepository, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, StoreCredentialsProvider storeCredentialsProvider) {
        return new StoreUtilsProxy(aptoideAccountManager, bodyInterceptor, storeCredentialsProvider, roomStoreRepository, okHttpClient, WebService.getDefaultConverter(), tokenInvalidator, sharedPreferences);
    }

    @Singleton
    SyncScheduler provideSyncScheduler(SyncStorage syncStorage) {
        return new AlarmSyncScheduler(this.application, syncStorage);
    }

    @Singleton
    SyncStorage provideSyncStorage(RoomLocalNotificationSyncPersistence roomLocalNotificationSyncPersistence) {
        return new SyncStorage(new HashMap(), roomLocalNotificationSyncPersistence);
    }

    @Singleton
    TokenInvalidator provideTokenInvalidator(@Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, AuthenticationPersistence authenticationPersistence, @Named("no-authentication-v3") BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> bodyInterceptor, @Named("extraID") String str) {
        return new RefreshTokenInvalidator(bodyInterceptor, okHttpClient, WebService.getDefaultConverter(), sharedPreferences, str, new NoOpTokenInvalidator(), authenticationPersistence, rx.s.b.g1());
    }

    @Singleton
    @Named
    Interceptor provideUserAgentInterceptor(IdsRepository idsRepository, AptoideMd5Manager aptoideMd5Manager) {
        return new UserAgentInterceptor(idsRepository, this.application.getResources().getDisplayMetrics(), aptoideMd5Manager);
    }

    @Singleton
    @Named
    Interceptor provideUserAgentInterceptorDownloads(IdsRepository idsRepository, @Named("partnerID") String str) {
        return new UserAgentInterceptorDownloads(idsRepository, str, this.application.getResources().getDisplayMetrics(), AptoideUtils.SystemU.TERMINAL_INFO, AptoideUtils.Core.getDefaultVername(this.application));
    }

    @Singleton
    @Named
    Interceptor provideUserAgentInterceptorV8(IdsRepository idsRepository, @Named("aptoidePackage") String str, AuthenticationPersistence authenticationPersistence, AptoideMd5Manager aptoideMd5Manager) {
        return new UserAgentInterceptorV8(idsRepository, AptoideUtils.SystemU.getRelease(), Build.VERSION.SDK_INT, AptoideUtils.SystemU.getModel(), AptoideUtils.SystemU.getProduct(), System.getProperty("os.arch"), this.application.getResources().getDisplayMetrics(), AptoideUtils.Core.getDefaultVername(this.application).replace("aptoide-", HttpUrl.FRAGMENT_ENCODE_SET), str, aptoideMd5Manager, BuildConfig.VERSION_CODE, authenticationPersistence);
    }

    @Singleton
    @Named
    OkHttpClient provideV8OkHttpClient(@Named(BuildConfig.APTOIDE_THEME) OkHttpClient.Builder builder, @Named("user-agent-v8") Interceptor interceptor) {
        builder.addInterceptor(interceptor);
        return builder.build();
    }

    @Singleton
    @Named
    OkHttpClient provideWebSocketOkHttpClient(@Named("user-agent") Interceptor interceptor, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, @Named("retrofit-log") Interceptor interceptor2) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        builder.addInterceptor(interceptor2);
        TimeUnit timeUnit = TimeUnit.MINUTES;
        builder.connectTimeout(2L, timeUnit);
        builder.readTimeout(1L, timeUnit);
        builder.writeTimeout(1L, timeUnit);
        builder.pingInterval(10L, TimeUnit.SECONDS);
        if (ToolboxManager.isToolboxEnableRetrofitLogs(sharedPreferences)) {
            builder.addInterceptor(interceptor2);
        }
        return builder.build();
    }

    @Singleton
    WindowManager provideWindowManager() {
        return (WindowManager) this.application.getSystemService("window");
    }

    @Singleton
    @Named
    Retrofit providesABRetrofit(@Named("ab-testing-base-host") String str, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, Converter.Factory factory, @Named("rx") CallAdapter.Factory factory2) {
        return new Retrofit.Builder().baseUrl(str).client(okHttpClient).addCallAdapterFactory(factory2).addConverterFactory(factory).build();
    }

    @Singleton
    ABTestCenterRepository providesABTestCenterRepository(ABTestService aBTestService, RoomExperimentPersistence roomExperimentPersistence, @Named("ab-test-local-cache") HashMap<String, ExperimentModel> map, AbTestCacheValidator abTestCacheValidator) {
        return new ABTestCenterRepository(aBTestService, map, roomExperimentPersistence, abTestCacheValidator);
    }

    @Singleton
    @Named
    ABTestManager providesABTestManager(ABTestCenterRepository aBTestCenterRepository) {
        return new ABTestManager(aBTestCenterRepository);
    }

    @Singleton
    ABTestService providesABTestService(@Named("ab-test-service-provider") ABTestServiceProvider aBTestServiceProvider, IdsRepository idsRepository) {
        return new ABTestService(aBTestServiceProvider, idsRepository, Schedulers.io());
    }

    @Singleton
    @Named
    ABTestServiceProvider providesABTestServiceProvider(@Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, Converter.Factory factory, @Named("rx") CallAdapter.Factory factory2, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        return new ABTestServiceProvider(okHttpClient, factory, factory2, sharedPreferences);
    }

    @Singleton
    ABTestService.ABTestingService providesABTestServiceV7(@Named("retrofit-AB") Retrofit retrofit) {
        return (ABTestService.ABTestingService) retrofit.create(ABTestService.ABTestingService.class);
    }

    @Singleton
    @Named
    String providesABTestingBaseHost(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_AB_TESTING_HOST);
        sb.append("/api/v1/");
        return sb.toString();
    }

    @Singleton
    AbTestCacheValidator providesAbTestCacheValidator(@Named("ab-test-local-cache") HashMap<String, ExperimentModel> map) {
        return new AbTestCacheValidator(map);
    }

    @Singleton
    @Named
    HashMap<String, ExperimentModel> providesAbTestLocalCache() {
        return new HashMap<>();
    }

    @Singleton
    AccountPersistence providesAccountPersistence(AccountManager accountManager, DatabaseStoreDataPersist databaseStoreDataPersist, AccountFactory accountFactory, AndroidAccountProvider androidAccountProvider, AuthenticationPersistence authenticationPersistence) {
        return new AndroidAccountManagerPersistence(accountManager, databaseStoreDataPersist, accountFactory, androidAccountProvider, authenticationPersistence, Schedulers.io());
    }

    @Singleton
    AdMapper providesAdMapper() {
        return new AdMapper();
    }

    @Singleton
    AdsApplicationVersionCodeProvider providesAdsApplicationVersionCodeProvider(PackageRepository packageRepository) {
        return new PackageRepositoryVersionCodeProvider(packageRepository, this.application.getPackageName());
    }

    @Singleton
    AdsManager providesAdsManager(AdsRepository adsRepository, RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence) {
        return new AdsManager(adsRepository, roomStoredMinimalAdPersistence, new MinimalAdMapper());
    }

    @Singleton
    AgentPersistence providesAgentPersistence(@Named("secureShared") SharedPreferences sharedPreferences) {
        return new AgentPersistence(sharedPreferences);
    }

    @Singleton
    AnalyticsLogger providesAnalyticsDebugLogger() {
        return new AnalyticsLogcatLogger();
    }

    @Singleton
    AnalyticsManager providesAnalyticsManager(@Named("facebook") EventLogger eventLogger, @Named("flurryLogger") EventLogger eventLogger2, HttpKnockEventLogger httpKnockEventLogger, @Named("facebookEvents") Collection<String> collection, @Named("flurryEvents") Collection<String> collection2, @Named("flurrySession") SessionLogger sessionLogger, @Named("normalizer") AnalyticsEventParametersNormalizer analyticsEventParametersNormalizer, @Named("rakamEventLogger") EventLogger eventLogger3, @Named("rakamEvents") Collection<String> collection3, @Named("indicativeEventLogger") EventLogger eventLogger4, @Named("indicativeEvents") Collection<String> collection4, @Named("firebaseEventLogger") EventLogger eventLogger5, @Named("firebaseEvents") Collection<String> collection5, AnalyticsLogger analyticsLogger) {
        return new AnalyticsManager.Builder().addLogger(eventLogger, collection).addLogger(eventLogger2, collection2).addLogger(eventLogger3, collection3).addLogger(eventLogger4, collection4).addLogger(eventLogger5, collection5).addSessionLogger(sessionLogger).setKnockLogger(httpKnockEventLogger).setAnalyticsNormalizer(analyticsEventParametersNormalizer).setDebugLogger(analyticsLogger).build();
    }

    @Singleton
    @Named
    AnalyticsEventParametersNormalizer providesAnalyticsNormalizer() {
        return new AnalyticsEventParametersNormalizer();
    }

    @Singleton
    @Named
    Retrofit providesApiChainBDSRetrofit(@Named("v8") OkHttpClient okHttpClient, Converter.Factory factory, @Named("rx") CallAdapter.Factory factory2, @Named("apichain-bds-base-host") String str) {
        return new Retrofit.Builder().baseUrl(str).client(okHttpClient).addCallAdapterFactory(factory2).addConverterFactory(factory).build();
    }

    @Singleton
    @Named
    String providesApichainBdsBaseHost(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_APICHAIN_BDS_HOST);
        return sb.toString();
    }

    @Singleton
    AptoideApkfyService.ServiceApi providesApkfyServiceApi(@Named("retrofit-aptoide-mmp") Retrofit retrofit) {
        return (AptoideApkfyService.ServiceApi) retrofit.create(AptoideApkfyService.ServiceApi.class);
    }

    @Singleton
    AppCenter providesAppCenter(AppCenterRepository appCenterRepository) {
        return new AppCenter(appCenterRepository);
    }

    @Singleton
    AppCenterRepository providesAppCenterRepository(AppService appService) {
        return new AppCenterRepository(appService, new HashMap());
    }

    @Singleton
    AppCoinsAdvertisingManager providesAppCoinsAdvertisingManager(AppCoinsService appCoinsService) {
        return new AppCoinsAdvertisingManager(appCoinsService);
    }

    @Singleton
    AppCoinsManager providesAppCoinsManager(BonusAppcService bonusAppcService) {
        return new AppCoinsManager(bonusAppcService);
    }

    @Singleton
    AppCoinsService providesAppCoinsService(@Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, Converter.Factory factory) {
        return new AppCoinsService(okHttpClient, tokenInvalidator, sharedPreferences, bodyInterceptor, factory);
    }

    @Singleton
    AppComingSoonRegistrationManager providesAppComingSoonPreferencesManager(AppComingSoonRegistrationPersistence appComingSoonRegistrationPersistence) {
        return new AppComingSoonRegistrationManager(appComingSoonRegistrationPersistence);
    }

    @Singleton
    AppComingSoonRegistrationPersistence providesAppComingSoonRegistrationPersistence(AptoideDatabase aptoideDatabase) {
        return new RoomAppComingSoonPersistence(aptoideDatabase.appComingSoonRegistrationDAO());
    }

    @Singleton
    AppDownloaderProvider providesAppDownloaderProvider(RetryFileDownloaderProvider retryFileDownloaderProvider, DownloadAnalytics downloadAnalytics) {
        return new AppDownloaderProvider(retryFileDownloaderProvider, downloadAnalytics);
    }

    @Singleton
    AppInBackgroundTracker providesAppInBackgroundTracker() {
        return new AppInBackgroundTracker();
    }

    @Singleton
    AppInstaller providesAppInstaller(final AppInstallerStatusReceiver appInstallerStatusReceiver) {
        return new AppInstaller(this.application.getApplicationContext(), new InstallResultCallback() { // from class: cm.aptoide.pt.a
            @Override // cm.aptoide.pt.packageinstaller.InstallResultCallback
            public final void onInstallationResult(InstallStatus installStatus) {
                appInstallerStatusReceiver.onStatusReceived(installStatus);
            }
        });
    }

    @Singleton
    AppInstallerStatusReceiver providesAppInstallerStatusReceiver() {
        return new AppInstallerStatusReceiver(rx.s.b.g1());
    }

    @Singleton
    AppService providesAppService(StoreCredentialsProvider storeCredentialsProvider, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, SplitsMapper splitsMapper, CampaignMapper campaignMapper) {
        return new AppService(storeCredentialsProvider, bodyInterceptor, okHttpClient, WebService.getDefaultConverter(), tokenInvalidator, sharedPreferences, splitsMapper, campaignMapper);
    }

    @Singleton
    AppShortcutsAnalytics providesAppShortcutsAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return new AppShortcutsAnalytics(analyticsManager, navigationTracker);
    }

    @Singleton
    AppValidationAnalytics providesAppValidationAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return new AppValidationAnalytics(analyticsManager, navigationTracker);
    }

    @Singleton
    AppValidator providesAppValidator(AppValidationAnalytics appValidationAnalytics) {
        return new AppValidator(appValidationAnalytics);
    }

    @Singleton
    AppViewAnalytics providesAppViewAnalytics(DownloadAnalytics downloadAnalytics, AnalyticsManager analyticsManager, NavigationTracker navigationTracker, StoreAnalytics storeAnalytics, InstallAnalytics installAnalytics) {
        return new AppViewAnalytics(downloadAnalytics, analyticsManager, navigationTracker, storeAnalytics, installAnalytics);
    }

    @Singleton
    AppcMigrationPersistence providesAppcMigrationAccessor(AptoideDatabase aptoideDatabase) {
        return new RoomAppcMigrationPersistence(aptoideDatabase.migratedAppDAO());
    }

    @Singleton
    AppcMigrationManager providesAppcMigrationManager(AptoideInstalledAppsRepository aptoideInstalledAppsRepository, AppcMigrationRepository appcMigrationRepository) {
        return new AppcMigrationManager(aptoideInstalledAppsRepository, appcMigrationRepository);
    }

    @Singleton
    AppcMigrationRepository providesAppcMigrationService(AppcMigrationPersistence appcMigrationPersistence) {
        return new AppcMigrationRepository(appcMigrationPersistence);
    }

    @Singleton
    @Named
    String providesAppsFlyerBaseUrl() {
        return "https://impression.appsflyer.com";
    }

    @Singleton
    AppsFlyerManager providesAppsFlyerManager(AppsFlyerRepository appsFlyerRepository) {
        return new AppsFlyerManager(appsFlyerRepository);
    }

    @Singleton
    AppsFlyerRepository providesAppsFlyerRepository(AppsFlyerService appsFlyerService) {
        return new AppsFlyerRepository(appsFlyerService);
    }

    @Singleton
    @Named
    Retrofit providesAppsFlyerRetrofit(@Named("appsflyer-host") String str, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, Converter.Factory factory, @Named("rx") CallAdapter.Factory factory2) {
        return new Retrofit.Builder().baseUrl(str).client(okHttpClient).addConverterFactory(factory).addCallAdapterFactory(factory2).build();
    }

    @Singleton
    AppsFlyerService providesAppsFlyerService(@Named("apps-flyer-retrofit") Retrofit retrofit) {
        return (AppsFlyerService) retrofit.create(AppsFlyerService.class);
    }

    @Singleton
    AptoideAuthenticationRx providesAptoideAuthentication(@Named("base-webservices-host") String str, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient) {
        return new AptoideAuthenticationRx(new AptoideAuthentication(new RemoteAuthenticationService(str, okHttpClient)));
    }

    @Singleton
    AptoideDatabase providesAptoideDataBase(RoomMigrationProvider roomMigrationProvider) {
        return (AptoideDatabase) androidx.room.i.a(this.application.getApplicationContext(), AptoideDatabase.class, "aptoide.db").b(roomMigrationProvider.getMigrations()).e().d();
    }

    @Singleton
    AptoideInstallManager providesAptoideInstallManager(AptoideInstalledAppsRepository aptoideInstalledAppsRepository, AptoideInstallRepository aptoideInstallRepository) {
        return new AptoideInstallManager(aptoideInstalledAppsRepository, aptoideInstallRepository);
    }

    @Singleton
    AptoideInstallPersistence providesAptoideInstallPersistence(AptoideDatabase aptoideDatabase) {
        return new RoomAptoideInstallPersistence(aptoideDatabase.aptoideInstallDao());
    }

    @Singleton
    AptoideInstallRepository providesAptoideInstallRepository(AptoideInstallPersistence aptoideInstallPersistence) {
        return new AptoideInstallRepository(aptoideInstallPersistence);
    }

    @Singleton
    @Named
    OkHttpClient.Builder providesAptoideMMPOkHttpBuilder(L2Cache l2Cache, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, @Named("retrofit-log") Interceptor interceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.readTimeout(6L, timeUnit);
        builder.writeTimeout(6L, timeUnit);
        builder.cache(new Cache(this.application.getCacheDir(), 10485760L));
        builder.addInterceptor(new POSTCacheInterceptor(l2Cache));
        if (ToolboxManager.isToolboxEnableRetrofitLogs(sharedPreferences)) {
            builder.addInterceptor(interceptor);
        }
        return builder;
    }

    @Singleton
    AptoideMd5Manager providesAptoideMd5Manager(PreferencesPersister preferencesPersister) {
        return new AptoideMd5Manager(preferencesPersister, this.application.getPackageManager(), this.application.getPackageName(), BuildConfig.VERSION_CODE);
    }

    @Singleton
    @Named
    Retrofit providesAptoideMmpRetrofit(@Named("aptoide-mmp-base-host") String str, @Named("aptoide-mmp-okhttp") OkHttpClient okHttpClient, Converter.Factory factory, @Named("rx") CallAdapter.Factory factory2) {
        return new Retrofit.Builder().baseUrl(str).client(okHttpClient).addCallAdapterFactory(factory2).addConverterFactory(factory).build();
    }

    @Singleton
    @Named
    String providesAutoUpdateBaseHost() {
        return "http://imgs.aptoide.com/";
    }

    @Singleton
    @Named
    Retrofit providesAutoUpdateRetrofit(@Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, @Named("auto-update-base-host") String str, Converter.Factory factory, @Named("rx") CallAdapter.Factory factory2) {
        return new Retrofit.Builder().baseUrl(str).client(okHttpClient).addCallAdapterFactory(factory2).addConverterFactory(factory).build();
    }

    @Singleton
    Service providesAutoUpdateService(@Named("retrofit-v7-cache") Retrofit retrofit) {
        return (Service) retrofit.create(Service.class);
    }

    @Singleton
    @Named
    String providesBaseHost(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_V7_HOST);
        sb.append("/api/7.20240701/");
        return sb.toString();
    }

    @Singleton
    @Named
    String providesBaseHostCache(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_V7_CACHE_HOST);
        sb.append("/api/7.20240701/");
        return sb.toString();
    }

    @Singleton
    @Named
    String providesBaseRakamHost(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_RAKAM_HOST);
        return sb.toString();
    }

    @Singleton
    @Named
    String providesBaseSecondaryHost(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_READ_V7_HOST);
        sb.append("/api/7.20240701/");
        return sb.toString();
    }

    @Singleton
    @Named
    String providesBaseWebservicesHost(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(cm.aptoide.pt.dataprovider.BuildConfig.APTOIDE_WEB_SERVICES_HOST);
        sb.append("/api/7/");
        return sb.toString();
    }

    @Singleton
    BlacklistManager providesBlacklistManager(Blacklister blacklister, BlacklistUnitMapper blacklistUnitMapper) {
        return new BlacklistManager(blacklister, blacklistUnitMapper);
    }

    @Singleton
    BlacklistPersistence providesBlacklistPersistence(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        return new BlacklistPersistence(sharedPreferences);
    }

    @Singleton
    Blacklister providesBlacklister(BlacklistPersistence blacklistPersistence) {
        return new Blacklister(blacklistPersistence);
    }

    @Singleton
    @Named
    BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> providesBodyInterceptorV3(IdsRepository idsRepository, QManager qManager, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, NetworkOperatorManager networkOperatorManager, AuthenticationPersistence authenticationPersistence, @Named("aptoidePackage") String str, AptoideMd5Manager aptoideMd5Manager) {
        return new BodyInterceptorV3(idsRepository, aptoideMd5Manager, str, qManager, sharedPreferences, BodyInterceptorV3.RESPONSE_MODE_JSON, Build.VERSION.SDK_INT, networkOperatorManager, authenticationPersistence);
    }

    @Singleton
    BonusAppcService providesBonusAppcService(BonusAppcRemoteService.ServiceApi serviceApi) {
        return new BonusAppcRemoteService(serviceApi);
    }

    @Singleton
    BonusAppcRemoteService.ServiceApi providesBonusAppcServiceApi(@Named("retrofit-apichain-bds") Retrofit retrofit) {
        return (BonusAppcRemoteService.ServiceApi) retrofit.create(BonusAppcRemoteService.ServiceApi.class);
    }

    @Singleton
    BundlesRepository providesBundleRepository(@Named("remote") BundleDataSource bundleDataSource) {
        return new BundlesRepository(bundleDataSource, new HashMap(), new HashMap(), 5);
    }

    @Singleton
    BlacklistUnitMapper providesBundleToBlacklistUnitMapper() {
        return new BlacklistUnitMapper();
    }

    @Singleton
    BundlesResponseMapper providesBundlesMapper(InstallManager installManager, WalletAdsOfferCardManager walletAdsOfferCardManager, BlacklistManager blacklistManager, DownloadStateParser downloadStateParser, AppComingSoonRegistrationManager appComingSoonRegistrationManager) {
        return new BundlesResponseMapper(installManager, walletAdsOfferCardManager, blacklistManager, downloadStateParser, appComingSoonRegistrationManager);
    }

    @Singleton
    @Named
    CallAdapter.Factory providesCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    CampaignAnalytics providesCampaignAnalytics(AnalyticsManager analyticsManager) {
        return new CampaignAnalytics(new HashMap(), analyticsManager);
    }

    @Singleton
    CaptionBackgroundPainter providesCaptionBackgroundPainter() {
        return new CaptionBackgroundPainter(this.application.getApplicationContext().getResources());
    }

    @Singleton
    ChipManager providesChipManager() {
        return new ChipManager();
    }

    @Singleton
    ComingSoonNotificationManager providesComingSoonNotificationManager(AppComingSoonRegistrationManager appComingSoonRegistrationManager) {
        return new ComingSoonNotificationManager(this.application.getApplicationContext(), appComingSoonRegistrationManager);
    }

    @Singleton
    ConnectivityManager providesConnectivityManager() {
        return (ConnectivityManager) this.application.getSystemService("connectivity");
    }

    @Singleton
    Converter.Factory providesConverterFactory() {
        return WebService.getDefaultConverter();
    }

    @Singleton
    CrashReport providesCrashReports() {
        return CrashReport.getInstance();
    }

    @Singleton
    DatabaseStoreDataPersist providesDatabaseStoreDataPersist(RoomStoreRepository roomStoreRepository) {
        return new DatabaseStoreDataPersist(new DatabaseStoreDataPersist.DatabaseStoreMapper(), roomStoreRepository);
    }

    @Singleton
    @Named
    DecimalFormat providesDecimalFormat() {
        return new DecimalFormat("0.0");
    }

    @Singleton
    @Named
    SharedPreferences providesDefaultSharedPerefences() {
        return PreferenceManager.getDefaultSharedPreferences(this.application);
    }

    @Singleton
    DownloadAnalytics providesDownloadAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker, ConnectivityManager connectivityManager, TelephonyManager telephonyManager, AppSizeAnalyticsStringMapper appSizeAnalyticsStringMapper, DownloadSpeedIntervalMapper downloadSpeedIntervalMapper) {
        return new DownloadAnalytics(connectivityManager, telephonyManager, navigationTracker, analyticsManager, appSizeAnalyticsStringMapper, downloadSpeedIntervalMapper);
    }

    @Singleton
    DownloadAppFileMapper providesDownloadAppFileMapper() {
        return new DownloadAppFileMapper();
    }

    @Singleton
    DownloadAppMapper providesDownloadAppMapper(DownloadAppFileMapper downloadAppFileMapper) {
        return new DownloadAppMapper(downloadAppFileMapper);
    }

    @Singleton
    DownloadStateParser providesDownloadStateParser() {
        return new DownloadStateParser();
    }

    @Singleton
    DownloadStatusManager providesDownloadStatusManager(InstallManager installManager, AppcMigrationManager appcMigrationManager) {
        return new DownloadStatusManager(installManager, appcMigrationManager);
    }

    @Singleton
    DynamicSplitsRemoteService.DynamicSplitsApi providesDynamicSplitsApi(@Named("retrofit-v7-cache") Retrofit retrofit) {
        return (DynamicSplitsRemoteService.DynamicSplitsApi) retrofit.create(DynamicSplitsRemoteService.DynamicSplitsApi.class);
    }

    @Singleton
    DynamicSplitsManager providesDynamicSplitsManager(DynamicSplitsService dynamicSplitsService) {
        return new DynamicSplitsManager(dynamicSplitsService);
    }

    @Singleton
    DynamicSplitsMapper providesDynamicSplitsMapper() {
        return new DynamicSplitsMapper();
    }

    @Singleton
    DynamicSplitsService providesDynamicSplitsService(DynamicSplitsRemoteService.DynamicSplitsApi dynamicSplitsApi, DynamicSplitsMapper dynamicSplitsMapper) {
        return new DynamicSplitsRemoteService(dynamicSplitsApi, dynamicSplitsMapper);
    }

    @Singleton
    EditorialService providesEditorialService(@Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, SplitsMapper splitsMapper, CampaignMapper campaignMapper) {
        return new EditorialService(bodyInterceptor, okHttpClient, tokenInvalidator, factory, sharedPreferences, splitsMapper, campaignMapper);
    }

    @Singleton
    EventsPersistence providesEventsPersistence(AptoideDatabase aptoideDatabase, RoomEventMapper roomEventMapper) {
        return new RoomEventPersistence(aptoideDatabase.eventDAO(), roomEventMapper);
    }

    @Singleton
    @Named
    EventLogger providesFacebookEventLogger(com.facebook.o0.a0 a0Var, AnalyticsLogger analyticsLogger) {
        return new FacebookEventLogger(a0Var, analyticsLogger);
    }

    @Singleton
    @Named
    List<String> providesFacebookLoginPermissions() {
        return Collections.singletonList("email");
    }

    @Singleton
    FileDownloaderProvider providesFileDownloaderProvider(@Named("cachePath") String str, @Named("user-agent-downloads") Interceptor interceptor, AuthenticationPersistence authenticationPersistence, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, Md5Comparator md5Comparator) {
        OkHttpClient.Builder builderAddInterceptor = new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(new DownloadMirrorEventInterceptor(downloadAnalytics, installAnalytics));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e.h.a.q.h(this.application, new com.liulishuo.filedownloader.services.c.a().a(new d.a.a.a.C0253a(builderAddInterceptor.connectTimeout(20L, timeUnit).writeTimeout(20L, timeUnit).readTimeout(20L, timeUnit))));
        return new FileDownloadManagerProvider(str, e.h.a.q.e(), md5Comparator);
    }

    @Singleton
    FileManager providesFileManager(CacheHelper cacheHelper, @Named("cachePath") String str, AptoideDownloadManager aptoideDownloadManager, L2Cache l2Cache) {
        return new FileManager(cacheHelper, new FileUtils(), new String[]{this.application.getCacheDir().getPath(), str}, aptoideDownloadManager, l2Cache);
    }

    @Singleton
    @Named
    EventLogger providesFirebaseEventLogger(FirebaseAnalytics firebaseAnalytics, AnalyticsLogger analyticsLogger) {
        return new FirebaseEventLogger(firebaseAnalytics, analyticsLogger);
    }

    @Singleton
    @Named
    Collection<String> providesFirebaseEvents() {
        return Arrays.asList(InstallAnalytics.CLICK_ON_INSTALL, DownloadAnalytics.RAKAM_DOWNLOAD_EVENT, InstallAnalytics.RAKAM_INSTALL_EVENT, SearchAnalytics.SEARCH, SearchAnalytics.SEARCH_RESULT_CLICK, FirstLaunchAnalytics.FIRST_LAUNCH_RAKAM, HomeAnalytics.VANILLA_PROMOTIONAL_CARDS, FirebaseNotificationAnalytics.NOTIFICATION_OPEN, FirebaseNotificationAnalytics.NOTIFICATION_RECEIVE);
    }

    @Singleton
    FirstLaunchAnalytics providesFirstLaunchAnalytics(AnalyticsManager analyticsManager, AnalyticsLogger analyticsLogger, SafetyNetClient safetyNetClient, GmsStatusValueProvider gmsStatusValueProvider) {
        return new FirstLaunchAnalytics(analyticsManager, analyticsLogger, safetyNetClient, this.application.getPackageName(), gmsStatusValueProvider);
    }

    @Singleton
    FirstLaunchManager providesFirstLaunchManager(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, IdsRepository idsRepository, FollowedStoresManager followedStoresManager, RootAvailabilityManager rootAvailabilityManager, AptoideAccountManager aptoideAccountManager, AptoideShortcutManager aptoideShortcutManager) {
        return new FirstLaunchManager(sharedPreferences, idsRepository, followedStoresManager, rootAvailabilityManager, aptoideAccountManager, aptoideShortcutManager, this.application);
    }

    @Singleton
    @Named
    EventLogger providesFlurryEventLogger(@Named("flurry") FlurryEventLogger flurryEventLogger) {
        return flurryEventLogger;
    }

    @Singleton
    @Named
    FlurryEventLogger providesFlurryLogger(AnalyticsLogger analyticsLogger) {
        return new FlurryEventLogger(this.application, analyticsLogger);
    }

    @Singleton
    @Named
    SessionLogger providesFlurrySessionLogger(@Named("flurry") FlurryEventLogger flurryEventLogger) {
        return flurryEventLogger;
    }

    @Singleton
    FollowedStoresManager providesFollowedStoresManager(StoreCredentialsProvider storeCredentialsProvider, @Named("default-followed-stores") List<String> list, StoreUtilsProxy storeUtilsProxy, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, AptoideAccountManager aptoideAccountManager, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        return new FollowedStoresManager(storeCredentialsProvider, list, storeUtilsProxy, bodyInterceptor, aptoideAccountManager, okHttpClient, tokenInvalidator, sharedPreferences);
    }

    @Singleton
    ForegroundManager providesForegroundManager() {
        return new ForegroundManager(this.application.getApplicationContext());
    }

    @Singleton
    GmsStatusValueProvider providesGmsStatusValueProvider() {
        return new GmsStatusValueProvider(this.application.getApplicationContext());
    }

    @Singleton
    ImageInfoProvider providesImageInfoProvider() {
        return new ImageInfoProvider(this.application.getContentResolver());
    }

    @Singleton
    @Named
    EventLogger providesIndicativeEventLogger(AnalyticsLogger analyticsLogger) {
        return new IndicativeEventLogger(analyticsLogger);
    }

    @Singleton
    @Named
    Collection<String> providesIndicativeEvents() {
        return Arrays.asList(InstallAnalytics.CLICK_ON_INSTALL, DownloadAnalytics.RAKAM_DOWNLOAD_EVENT, InstallAnalytics.RAKAM_INSTALL_EVENT, SearchAnalytics.SEARCH, SearchAnalytics.SEARCH_RESULT_CLICK, FirstLaunchAnalytics.FIRST_LAUNCH_RAKAM, HomeAnalytics.VANILLA_PROMOTIONAL_CARDS);
    }

    @Singleton
    InstallAppSizeValidator providesInstallAppSizeValidator(FilePathProvider filePathProvider) {
        return new InstallAppSizeValidator(filePathProvider);
    }

    @Singleton
    InstallManager providesInstallManager(AptoideDownloadManager aptoideDownloadManager, @Named(BuildConfig.APTOIDE_THEME) Installer installer, RootAvailabilityManager rootAvailabilityManager, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, @Named("secureShared") SharedPreferences sharedPreferences2, DownloadsRepository downloadsRepository, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, ForegroundManager foregroundManager, AptoideInstallManager aptoideInstallManager, InstallAppSizeValidator installAppSizeValidator, FileManager fileManager) {
        return new InstallManager(this.application, aptoideDownloadManager, installer, rootAvailabilityManager, sharedPreferences, sharedPreferences2, downloadsRepository, aptoideInstalledAppsRepository, foregroundManager, aptoideInstallManager, installAppSizeValidator, fileManager);
    }

    @Singleton
    RoomInstallationPersistence providesInstallationAccessor(AptoideDatabase aptoideDatabase) {
        return new RoomInstallationPersistence(aptoideDatabase.installationDao());
    }

    @Singleton
    InstallerAnalytics providesInstallerAnalytics(AnalyticsManager analyticsManager, InstallAnalytics installAnalytics, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, RootAvailabilityManager rootAvailabilityManager, NavigationTracker navigationTracker) {
        return new InstallEvents(analyticsManager, installAnalytics, sharedPreferences, rootAvailabilityManager, navigationTracker);
    }

    @Singleton
    LaunchManager providesLaunchManager(FirstLaunchManager firstLaunchManager, UpdateLaunchManager updateLaunchManager, @Named("secureShared") SharedPreferences sharedPreferences) {
        return new LaunchManager(firstLaunchManager, updateLaunchManager, sharedPreferences);
    }

    @Singleton
    @Named
    Retrofit providesLoadTopReactionsRetrofit(@Named("reactions-host") String str, @Named("v8") OkHttpClient okHttpClient, Converter.Factory factory, @Named("rx") CallAdapter.Factory factory2) {
        return new Retrofit.Builder().baseUrl(str).client(okHttpClient).addCallAdapterFactory(factory2).addConverterFactory(factory).build();
    }

    @Singleton
    LocalNotificationSyncManager providesLocalNotificationSyncManager(SyncScheduler syncScheduler, NotificationProvider notificationProvider) {
        return new LocalNotificationSyncManager(syncScheduler, true, notificationProvider);
    }

    @Singleton
    LoginSignupManager providesLoginSignupManager() {
        return new LoginSignupManager();
    }

    @Singleton
    MapToJsonMapper providesMapToJsonMapper() {
        return new MapToJsonMapper();
    }

    @Singleton
    Md5Comparator providesMd5Comparator(@Named("cachePath") String str) {
        return new Md5Comparator(str);
    }

    @Singleton
    MoPubAdsManager providesMoPubAdsManager(WalletAdsOfferManager walletAdsOfferManager) {
        return new MoPubAdsManager(walletAdsOfferManager);
    }

    @Singleton
    MoPubAnalytics providesMoPubAnalytics() {
        return new MoPubAnalytics();
    }

    @Singleton
    MyAccountManager providesMyAccountManager() {
        return new MyAccountManager();
    }

    @Singleton
    NetworkOperatorManager providesNetworkOperatorManager(TelephonyManager telephonyManager) {
        return new NetworkOperatorManager(telephonyManager);
    }

    @Singleton
    NewFeature providesNewFeature() {
        return new NewFeature("dark_theme", this.application.getString(R.string.dark_theme_notification_title), this.application.getString(R.string.dark_theme_notification_body), "turn_it_on", R.string.dark_theme_notification_button);
    }

    @Singleton
    NewFeatureManager providesNewFeatureManager(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, NewFeature newFeature, LocalNotificationSyncManager localNotificationSyncManager) {
        return new NewFeatureManager(sharedPreferences, localNotificationSyncManager, newFeature);
    }

    @Singleton
    NewsletterManager providesNewsletterManager() {
        return new NewsletterManager();
    }

    @Singleton
    OemidProvider providesOemidProvider() {
        return new OemidProvider();
    }

    @Singleton
    @Named
    OkHttpClient.Builder providesOkHttpBuilder(L2Cache l2Cache, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, @Named("retrofit-log") Interceptor interceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.readTimeout(45L, timeUnit);
        builder.writeTimeout(45L, timeUnit);
        builder.cache(new Cache(this.application.getCacheDir(), 10485760L));
        builder.addInterceptor(new POSTCacheInterceptor(l2Cache));
        if (ToolboxManager.isToolboxEnableRetrofitLogs(sharedPreferences)) {
            builder.addInterceptor(interceptor);
        }
        return builder;
    }

    @Singleton
    PackageRepository providesPackageRepository() {
        return new PackageRepository(this.application.getPackageManager());
    }

    @Singleton
    PromotionViewAppMapper providesPromotionViewAppMapper(DownloadStateParser downloadStateParser) {
        return new PromotionViewAppMapper(downloadStateParser);
    }

    @Singleton
    PromotionsAnalytics providesPromotionsAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics) {
        return new PromotionsAnalytics(analyticsManager, navigationTracker, downloadAnalytics, installAnalytics);
    }

    @Singleton
    PromotionsPreferencesManager providesPromotionsPreferencesManager(PreferencesPersister preferencesPersister) {
        return new PromotionsPreferencesManager(preferencesPersister);
    }

    @Singleton
    PromotionsService providesPromotionsService(@Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, Converter.Factory factory, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, SplitsMapper splitsMapper) {
        return new PromotionsService(bodyInterceptor, okHttpClient, tokenInvalidator, factory, sharedPreferences, splitsMapper);
    }

    @Singleton
    @Named
    EventLogger providesRakamEventLogger(AnalyticsLogger analyticsLogger, MapToJsonMapper mapToJsonMapper) {
        return new RakamEventLogger(analyticsLogger, mapToJsonMapper);
    }

    @Singleton
    @Named
    Collection<String> providesRakamEvents() {
        return Arrays.asList(InstallAnalytics.CLICK_ON_INSTALL, DownloadAnalytics.RAKAM_DOWNLOAD_EVENT, InstallAnalytics.RAKAM_INSTALL_EVENT, SearchAnalytics.SEARCH, SearchAnalytics.SEARCH_RESULT_CLICK, FirstLaunchAnalytics.FIRST_LAUNCH_RAKAM, HomeAnalytics.VANILLA_PROMOTIONAL_CARDS);
    }

    @Singleton
    @Named
    String providesReactionsHost() {
        return "https://api.aptoide.com/";
    }

    @Singleton
    ReactionsManager providesReactionsManager(ReactionsService reactionsService) {
        return new ReactionsManager(reactionsService, new HashMap());
    }

    @Singleton
    ReactionsService providesReactionsService(ReactionsRemoteService.ServiceV8 serviceV8) {
        return new ReactionsRemoteService(serviceV8, Schedulers.io());
    }

    @Singleton
    ReactionsRemoteService.ServiceV8 providesReactionsServiceV8(@Named("retrofit-load-top-reactions") Retrofit retrofit) {
        return (ReactionsRemoteService.ServiceV8) retrofit.create(ReactionsRemoteService.ServiceV8.class);
    }

    @Singleton
    ReadyToInstallNotificationManager providesReadyToInstallNotificationManager(InstallManager installManager) {
        return new ReadyToInstallNotificationManager(installManager, new NotificationIdsMapper());
    }

    @Singleton
    @Named
    BundleDataSource providesRemoteBundleDataSource(@Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, Converter.Factory factory, BundlesResponseMapper bundlesResponseMapper, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, AptoideAccountManager aptoideAccountManager, PackageRepository packageRepository, IdsRepository idsRepository, QManager qManager, Resources resources, WindowManager windowManager, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider, OemidProvider oemidProvider, StoreCredentialsProvider storeCredentialsProvider, AppCoinsManager appCoinsManager) {
        return new RemoteBundleDataSource(5, new HashMap(), bodyInterceptor, okHttpClient, factory, bundlesResponseMapper, tokenInvalidator, sharedPreferences, new WSWidgetsUtils(), storeCredentialsProvider, idsRepository, AdNetworkUtils.isGooglePlayServicesAvailable(this.application.getApplicationContext()), oemidProvider.getOemid(), aptoideAccountManager, qManager.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences)), resources, windowManager, connectivityManager, adsApplicationVersionCodeProvider, packageRepository, 10, 10, appCoinsManager);
    }

    @Singleton
    RetryFileDownloaderProvider providesRetryFileDownloaderProvider(FileDownloaderProvider fileDownloaderProvider) {
        return new RetryFileDownloadManagerProvider(fileDownloaderProvider);
    }

    @Singleton
    ReviewsManager providesReviewsManager(ReviewsRepository reviewsRepository) {
        return new ReviewsManager(reviewsRepository);
    }

    @Singleton
    ReviewsRepository providesReviewsRepository(ReviewsService reviewsService) {
        return new ReviewsRepository(reviewsService);
    }

    @Singleton
    ReviewsService providesReviewsService(StoreCredentialsProvider storeCredentialsProvider, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        return new ReviewsService(storeCredentialsProvider, bodyInterceptor, okHttpClient, WebService.getDefaultConverter(), tokenInvalidator, sharedPreferences);
    }

    @Singleton
    RoomEventMapper providesRoomEventMapper(@Named(BuildConfig.APTOIDE_THEME) ObjectMapper objectMapper) {
        return new RoomEventMapper(objectMapper);
    }

    @Singleton
    RoomEventPersistence providesRoomEventPersistence(AptoideDatabase aptoideDatabase, RoomEventMapper roomEventMapper) {
        return new RoomEventPersistence(aptoideDatabase.eventDAO(), roomEventMapper);
    }

    @Singleton
    RoomExperimentMapper providesRoomExperimentMapper() {
        return new RoomExperimentMapper();
    }

    @Singleton
    RoomExperimentPersistence providesRoomExperimentPersistence(AptoideDatabase aptoideDatabase, RoomExperimentMapper roomExperimentMapper) {
        return new RoomExperimentPersistence(aptoideDatabase.experimentDAO(), roomExperimentMapper);
    }

    @Singleton
    RoomInstallationMapper providesRoomInstallationMapper() {
        return new RoomInstallationMapper();
    }

    @Singleton
    RoomLocalNotificationSyncPersistence providesRoomLocalNotificationSyncPersistence(AptoideDatabase aptoideDatabase, NotificationProvider notificationProvider) {
        return new RoomLocalNotificationSyncPersistence(new RoomLocalNotificationSyncMapper(), notificationProvider, aptoideDatabase.localNotificationSyncDao());
    }

    @Singleton
    RoomMigrationProvider providesRoomMigrationProvider() {
        return new RoomMigrationProvider();
    }

    @Singleton
    RoomStoredMinimalAdPersistence providesRoomStoreMinimalAdPersistence(AptoideDatabase aptoideDatabase) {
        return new RoomStoredMinimalAdPersistence(aptoideDatabase.storeMinimalAdDAO());
    }

    @Singleton
    RoomStoreRepository providesRoomStoreRepository(StorePersistence storePersistence) {
        return new RoomStoreRepository(storePersistence);
    }

    @Singleton
    RootInstallerProvider providesRootInstallerProvider(InstallerAnalytics installerAnalytics) {
        return new RootInstallerProvider(installerAnalytics, this.application.getApplicationContext().getPackageName());
    }

    @Singleton
    SafetyNetClient providesSafetyNetClient() {
        return SafetyNet.a(this.application);
    }

    @Singleton
    SearchAnalytics providesSearchAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return new SearchAnalytics(analyticsManager, navigationTracker);
    }

    @Singleton
    SearchRepository providesSearchRepository(RoomStoreRepository roomStoreRepository, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, Converter.Factory factory, OemidProvider oemidProvider, CampaignMapper campaignMapper) {
        return new SearchRepository(roomStoreRepository, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, oemidProvider, campaignMapper);
    }

    @Singleton
    SearchSuggestionManager providesSearchSuggestionManager(SearchSuggestionRemoteRepository searchSuggestionRemoteRepository) {
        return new SearchSuggestionManager(new SearchSuggestionService(searchSuggestionRemoteRepository), Schedulers.io());
    }

    @Singleton
    SearchSuggestionRemoteRepository providesSearchSuggestionRemoteRepository(Retrofit retrofit) {
        return (SearchSuggestionRemoteRepository) retrofit.create(SearchSuggestionRemoteRepository.class);
    }

    @Singleton
    Retrofit providesSearchSuggestionsRetrofit(@Named("ws-prod-suggestions-base-url") String str, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, Converter.Factory factory, @Named("rx") CallAdapter.Factory factory2) {
        return new Retrofit.Builder().baseUrl(str).client(okHttpClient).addConverterFactory(factory).addCallAdapterFactory(factory2).build();
    }

    @Singleton
    @Named
    SecurePreferences providesSecurePerefences(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, SecureCoderDecoder secureCoderDecoder) {
        return new SecurePreferences(sharedPreferences, secureCoderDecoder);
    }

    @Singleton
    @Named
    SharedPreferences providesSecureSharedPreferences(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        return SecurePreferencesImplementation.getInstance(this.application.getApplicationContext(), sharedPreferences);
    }

    @Singleton
    SettingsManager providesSettingsManager() {
        return new SettingsManager();
    }

    @Singleton
    AptoideShortcutManager providesShortcutManager() {
        return new AptoideShortcutManager();
    }

    @Singleton
    SocialMediaAnalytics providesSocialMediaAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return new SocialMediaAnalytics(analyticsManager, navigationTracker);
    }

    @Singleton
    SplitsMapper providesSplitsMapper() {
        return new SplitsMapper();
    }

    @Singleton
    StoreAnalytics providesStoreAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return new StoreAnalytics(analyticsManager, navigationTracker);
    }

    @Singleton
    StoreCredentialsProvider providesStoreCredentialsProvider(RoomStoreRepository roomStoreRepository) {
        return new StoreCredentialsProviderImpl(roomStoreRepository);
    }

    @Singleton
    StorePersistence providesStorePersistence(AptoideDatabase aptoideDatabase) {
        return new RoomStorePersistence(aptoideDatabase.storeDao());
    }

    @Singleton
    SupportEmailProvider providesSupportEmailProvider(@Named("support-email") String str) {
        return new SupportEmailProvider(str, this.application.getString(R.string.aptoide_email));
    }

    @Singleton
    TelephonyManager providesTelephonyManager() {
        return (TelephonyManager) this.application.getSystemService("phone");
    }

    @Singleton
    ThemeAnalytics providesThemeAnalytics(AnalyticsManager analyticsManager, FirebaseAnalytics firebaseAnalytics) {
        return new ThemeAnalytics(analyticsManager, firebaseAnalytics);
    }

    @Singleton
    TrendingManager providesTrendingManager(TrendingService trendingService) {
        return new TrendingManager(trendingService);
    }

    @Singleton
    TrendingService providesTrendingService(StoreCredentialsProvider storeCredentialsProvider, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, Converter.Factory factory, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor) {
        return new TrendingService(storeCredentialsProvider, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    @Singleton
    UpdateLaunchManager providesUpdateLaunchManager(FollowedStoresManager followedStoresManager) {
        return new UpdateLaunchManager(followedStoresManager);
    }

    @Singleton
    UpdateMapper providesUpdateMapper() {
        return new UpdateMapper();
    }

    @Singleton
    UpdatePersistence providesUpdatePersistence(AptoideDatabase aptoideDatabase) {
        return new RoomUpdatePersistence(aptoideDatabase.updateDao());
    }

    @Singleton
    UpdateRepository providesUpdateRepository(UpdatePersistence updatePersistence, RoomStoreRepository roomStoreRepository, IdsRepository idsRepository, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, UpdateMapper updateMapper, AptoideInstalledAppsRepository aptoideInstalledAppsRepository) {
        return new UpdateRepository(updatePersistence, roomStoreRepository, idsRepository, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, updateMapper, aptoideInstalledAppsRepository);
    }

    @Singleton
    UpdatesAnalytics providesUpdatesAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker, InstallAnalytics installAnalytics) {
        return new UpdatesAnalytics(analyticsManager, navigationTracker, installAnalytics);
    }

    @Singleton
    UpdatesManager providesUpdatesManager(UpdateRepository updateRepository) {
        return new UpdatesManager(updateRepository);
    }

    @Singleton
    UpdatesNotificationManager providesUpdatesNotificationManager() {
        return new UpdatesNotificationManager(this.application.getApplicationContext());
    }

    @Singleton
    AptoideWorkerFactory providesUpdatesNotificationWorkerFactory(UpdateRepository updateRepository, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, AptoideInstallManager aptoideInstallManager, SyncScheduler syncScheduler, SyncStorage syncStorage, CrashReport crashReport, AppCenter appCenter) {
        return new AptoideWorkerFactory(updateRepository, sharedPreferences, aptoideInstallManager, new AppMapper(), syncScheduler, syncStorage, crashReport, appCenter);
    }

    @Singleton
    UserFeedbackAnalytics providesUserFeedbackAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return new UserFeedbackAnalytics(analyticsManager, navigationTracker);
    }

    @Singleton
    PreferencesPersister providesUserPreferencesPersister(@Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        return new PreferencesPersister(sharedPreferences);
    }

    @Singleton
    @Named
    Retrofit providesV7CacheRetrofit(@Named("base-host-cache") String str, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, Converter.Factory factory, @Named("rx") CallAdapter.Factory factory2) {
        return new Retrofit.Builder().baseUrl(str).client(okHttpClient).addCallAdapterFactory(factory2).addConverterFactory(factory).build();
    }

    @Singleton
    @Named
    Retrofit providesV7Retrofit(@Named("base-host") String str, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, Converter.Factory factory, @Named("rx") CallAdapter.Factory factory2) {
        return new Retrofit.Builder().baseUrl(str).client(okHttpClient).addCallAdapterFactory(factory2).addConverterFactory(factory).build();
    }

    @Singleton
    @Named
    Retrofit providesV7SecondaryRetrofit(@Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, @Named("base-secondary-host") String str, Converter.Factory factory, @Named("rx") CallAdapter.Factory factory2) {
        return new Retrofit.Builder().baseUrl(str).client(okHttpClient).addCallAdapterFactory(factory2).addConverterFactory(factory).build();
    }

    @Singleton
    WalletAppProvider providesWalletAppProvider(AppCenter appCenter, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, InstallManager installManager, DownloadStateParser downloadStateParser) {
        return new WalletAppProvider(appCenter, aptoideInstalledAppsRepository, installManager, downloadStateParser);
    }

    @Singleton
    HttpKnockEventLogger providesknockEventLogger(@Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient) {
        return new HttpKnockEventLogger(okHttpClient);
    }

    @Singleton
    SplitAnalyticsMapper splitAnalyticsMapper() {
        return new SplitAnalyticsMapper();
    }
}
