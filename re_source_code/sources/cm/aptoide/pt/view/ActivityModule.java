package cm.aptoide.pt.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.AppShortcutsAnalytics;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.CatappultNavigator;
import cm.aptoide.pt.DeepLinkAnalytics;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.R;
import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.aab.DynamicSplitsManager;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.AgentPersistence;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.account.view.ImagePickerNavigator;
import cm.aptoide.pt.account.view.PhotoFileGenerator;
import cm.aptoide.pt.account.view.UriToPathResolver;
import cm.aptoide.pt.account.view.store.ManageStoreNavigator;
import cm.aptoide.pt.account.view.user.ManageUserNavigator;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.ads.AdsRepository;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.analytics.FirstLaunchAnalytics;
import cm.aptoide.pt.apkfy.ApkFyParser;
import cm.aptoide.pt.apkfy.ApkfyManager;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.app.DownloadStateParser;
import cm.aptoide.pt.app.view.AppViewNavigator;
import cm.aptoide.pt.autoupdate.AutoUpdateManager;
import cm.aptoide.pt.autoupdate.AutoUpdateRepository;
import cm.aptoide.pt.autoupdate.AutoUpdateService;
import cm.aptoide.pt.autoupdate.Service;
import cm.aptoide.pt.bottomNavigation.BottomNavigationAnalytics;
import cm.aptoide.pt.bottomNavigation.BottomNavigationMapper;
import cm.aptoide.pt.bottomNavigation.BottomNavigationNavigator;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.download.SplitAnalyticsMapper;
import cm.aptoide.pt.home.AptoideBottomNavigator;
import cm.aptoide.pt.home.apps.UpdatesManager;
import cm.aptoide.pt.home.more.apps.ListAppsMoreRepository;
import cm.aptoide.pt.install.AppInstallerStatusReceiver;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.install.InstallAnalytics;
import cm.aptoide.pt.install.InstallCompletedNotifier;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.install.installer.RootInstallationRetryHandler;
import cm.aptoide.pt.navigator.ActivityNavigator;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.navigator.ExternalNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.FragmentResultNavigator;
import cm.aptoide.pt.navigator.Result;
import cm.aptoide.pt.notification.ContentPuller;
import cm.aptoide.pt.notification.NotificationAnalytics;
import cm.aptoide.pt.notification.NotificationSyncScheduler;
import cm.aptoide.pt.notification.ReadyToInstallNotificationManager;
import cm.aptoide.pt.orientation.ScreenOrientationManager;
import cm.aptoide.pt.permission.AccountPermissionProvider;
import cm.aptoide.pt.permission.PermissionProvider;
import cm.aptoide.pt.presenter.MainPresenter;
import cm.aptoide.pt.presenter.MainView;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.promotions.ClaimPromotionsNavigator;
import cm.aptoide.pt.promotions.PromotionsNavigator;
import cm.aptoide.pt.root.RootAvailabilityManager;
import cm.aptoide.pt.search.SearchNavigator;
import cm.aptoide.pt.search.analytics.SearchAnalytics;
import cm.aptoide.pt.socialmedia.SocialMediaNavigator;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.themes.NewFeature;
import cm.aptoide.pt.themes.ThemeAnalytics;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.util.MarketResourceFormatter;
import cm.aptoide.pt.view.app.ListStoreAppsNavigator;
import cm.aptoide.pt.view.dialog.DialogUtils;
import cm.aptoide.pt.view.settings.MyAccountNavigator;
import cm.aptoide.pt.wallet.WalletAppProvider;
import cm.aptoide.pt.wallet.WalletInstallAnalytics;
import cm.aptoide.pt.wallet.WalletInstallConfiguration;
import cm.aptoide.pt.wallet.WalletInstallManager;
import cm.aptoide.pt.wallet.WalletInstallNavigator;
import cm.aptoide.pt.wallet.WalletInstallPresenter;
import cm.aptoide.pt.wallet.WalletInstallView;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Map;
import javax.inject.Named;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class ActivityModule {
    private final androidx.appcompat.app.d activity;
    private final String fileProviderAuthority;
    private final boolean firstCreated;
    private final Intent intent;
    private final NotificationSyncScheduler notificationSyncScheduler;
    private final View view;

    public ActivityModule(androidx.appcompat.app.d dVar, Intent intent, NotificationSyncScheduler notificationSyncScheduler, View view, boolean z, String str) {
        this.activity = dVar;
        this.intent = intent;
        this.notificationSyncScheduler = notificationSyncScheduler;
        this.view = view;
        this.firstCreated = z;
        this.fileProviderAuthority = str;
    }

    @ActivityScope
    AccountNavigator provideAccountNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AptoideAccountManager aptoideAccountManager, com.facebook.y yVar, GoogleApiClient googleApiClient, AccountAnalytics accountAnalytics, BottomNavigationNavigator bottomNavigationNavigator, ThemeManager themeManager) {
        return new AccountNavigator(bottomNavigationNavigator, fragmentNavigator, aptoideAccountManager, (ActivityNavigator) this.activity, com.facebook.login.x.g(), yVar, googleApiClient, e.g.b.c.f1(), "http://m.aptoide.com/account/password-recovery", accountAnalytics, themeManager);
    }

    @ActivityScope
    AccountPermissionProvider provideAccountPermissionProvider() {
        return new AccountPermissionProvider((PermissionProvider) this.activity);
    }

    @ActivityScope
    ApkFyParser provideApkFy(@Named("secureShared") SharedPreferences sharedPreferences, ApkfyManager apkfyManager, FirstLaunchAnalytics firstLaunchAnalytics) {
        return new ApkFyParser(this.activity, this.intent, sharedPreferences, apkfyManager, firstLaunchAnalytics);
    }

    @ActivityScope
    AutoUpdateManager provideAutoUpdateManager(DownloadFactory downloadFactory, PermissionManager permissionManager, InstallManager installManager, DownloadAnalytics downloadAnalytics, @Named("local-version-code") int i2, AutoUpdateRepository autoUpdateRepository) {
        return new AutoUpdateManager(downloadFactory, permissionManager, installManager, downloadAnalytics, i2, autoUpdateRepository, Build.VERSION.SDK_INT, ((AptoideApplication) this.activity.getApplication()).getDefaultSharedPreferences());
    }

    @ActivityScope
    BottomNavigationMapper provideBottomNavigationMapper() {
        return new BottomNavigationMapper();
    }

    @ActivityScope
    BottomNavigationNavigator provideBottomNavigationNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationAnalytics bottomNavigationAnalytics, SearchAnalytics searchAnalytics, ThemeManager themeManager) {
        return new BottomNavigationNavigator(fragmentNavigator, bottomNavigationAnalytics, searchAnalytics, themeManager);
    }

    @ActivityScope
    @Named
    int provideClientSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    @ActivityScope
    DeepLinkManager provideDeepLinkManager(StoreUtilsProxy storeUtilsProxy, @Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator, SearchNavigator searchNavigator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, RoomStoreRepository roomStoreRepository, NavigationTracker navigationTracker, SearchAnalytics searchAnalytics, DeepLinkAnalytics deepLinkAnalytics, AppShortcutsAnalytics appShortcutsAnalytics, AptoideAccountManager aptoideAccountManager, StoreAnalytics storeAnalytics, AdsRepository adsRepository, AppNavigator appNavigator, InstallManager installManager, NewFeature newFeature, ThemeManager themeManager, ThemeAnalytics themeAnalytics, ReadyToInstallNotificationManager readyToInstallNotificationManager) {
        return new DeepLinkManager(storeUtilsProxy, fragmentNavigator, bottomNavigationNavigator, searchNavigator, (DeepLinkManager.DeepLinkView) this.activity, sharedPreferences, roomStoreRepository, navigationTracker, searchAnalytics, appShortcutsAnalytics, aptoideAccountManager, deepLinkAnalytics, storeAnalytics, adsRepository, appNavigator, installManager, newFeature, themeManager, themeAnalytics, readyToInstallNotificationManager);
    }

    @ActivityScope
    FragmentManager provideFragmentManager() {
        return this.activity.getSupportFragmentManager();
    }

    @ActivityScope
    ImagePickerNavigator provideImagePickerNavigator() {
        return new ImagePickerNavigator((ActivityNavigator) this.activity);
    }

    @ActivityScope
    ListStoreAppsNavigator provideListStoreAppsNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        return new ListStoreAppsNavigator(fragmentNavigator, appNavigator);
    }

    @ActivityScope
    @Named
    int provideLocalVersionCode(@Named("package-name") String str) {
        try {
            return this.activity.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @ActivityScope
    @Named
    FragmentNavigator provideMainFragmentNavigator(Map<Integer, Result> map, e.g.b.a<Map<Integer, Result>> aVar, FragmentManager fragmentManager) {
        return new FragmentResultNavigator(fragmentManager, R.id.fragment_placeholder, android.R.anim.fade_in, android.R.anim.fade_out, map, aVar);
    }

    @ActivityScope
    Presenter provideMainPresenter(RootInstallationRetryHandler rootInstallationRetryHandler, ApkFyParser apkFyParser, InstallManager installManager, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, @Named("secureShared") SharedPreferences sharedPreferences2, @Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, DeepLinkManager deepLinkManager, BottomNavigationNavigator bottomNavigationNavigator, UpdatesManager updatesManager, AutoUpdateManager autoUpdateManager, RootAvailabilityManager rootAvailabilityManager, BottomNavigationMapper bottomNavigationMapper, AptoideAccountManager aptoideAccountManager, AccountNavigator accountNavigator, AgentPersistence agentPersistence) {
        return new MainPresenter((MainView) this.view, installManager, rootInstallationRetryHandler, CrashReport.getInstance(), apkFyParser, new ContentPuller(this.activity), this.notificationSyncScheduler, new InstallCompletedNotifier(e.g.b.c.f1(), installManager, CrashReport.getInstance()), sharedPreferences, sharedPreferences2, fragmentNavigator, deepLinkManager, this.firstCreated, (AptoideBottomNavigator) this.activity, rx.l.c.a.b(), Schedulers.io(), bottomNavigationNavigator, updatesManager, autoUpdateManager, (PermissionService) this.activity, rootAvailabilityManager, bottomNavigationMapper, aptoideAccountManager, accountNavigator, agentPersistence);
    }

    @ActivityScope
    ManageStoreNavigator provideManageStoreNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator) {
        return new ManageStoreNavigator(fragmentNavigator, bottomNavigationNavigator);
    }

    @ActivityScope
    ManageUserNavigator provideManageUserNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator) {
        return new ManageUserNavigator(fragmentNavigator, bottomNavigationNavigator);
    }

    @ActivityScope
    MyAccountNavigator provideMyAccountNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AccountNavigator accountNavigator, AppNavigator appNavigator, ThemeManager themeManager, SocialMediaNavigator socialMediaNavigator) {
        return new MyAccountNavigator(fragmentNavigator, accountNavigator, appNavigator, themeManager, socialMediaNavigator);
    }

    @ActivityScope
    @Named
    String providePackageName() {
        return this.activity.getPackageName();
    }

    @ActivityScope
    PhotoFileGenerator providePhotoFileGenerator() {
        androidx.appcompat.app.d dVar = this.activity;
        return new PhotoFileGenerator(dVar, dVar.getExternalFilesDir(Environment.DIRECTORY_PICTURES), this.fileProviderAuthority);
    }

    @ActivityScope
    ScreenOrientationManager provideScreenOrientationManager() {
        androidx.appcompat.app.d dVar = this.activity;
        return new ScreenOrientationManager(dVar, (WindowManager) dVar.getSystemService("window"));
    }

    @ActivityScope
    UriToPathResolver provideUriToPathResolver() {
        return new UriToPathResolver(this.activity.getContentResolver());
    }

    @ActivityScope
    AppCoinsInfoNavigator providesAppCoinsInfoNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, SocialMediaNavigator socialMediaNavigator, CatappultNavigator catappultNavigator) {
        return new AppCoinsInfoNavigator(fragmentNavigator, socialMediaNavigator, catappultNavigator);
    }

    @ActivityScope
    AppNavigator providesAppNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        return new AppNavigator(fragmentNavigator);
    }

    @ActivityScope
    AppViewNavigator providesAppViewNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AppNavigator appNavigator, CatappultNavigator catappultNavigator) {
        return new AppViewNavigator(fragmentNavigator, (ActivityNavigator) this.activity, appNavigator, catappultNavigator);
    }

    @ActivityScope
    AutoUpdateRepository providesAutoUpdateRepository(AutoUpdateService autoUpdateService) {
        return new AutoUpdateRepository(autoUpdateService);
    }

    @ActivityScope
    AutoUpdateService providesAutoUpdateService(Service service, @Named("package-name") String str, @Named("client-sdk-version") int i2) {
        return new AutoUpdateService(service, str, i2);
    }

    @ActivityScope
    BottomNavigationAnalytics providesBottomNavigationAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return new BottomNavigationAnalytics(analyticsManager, navigationTracker);
    }

    @ActivityScope
    CatappultNavigator providesCatappultNavigator(ExternalNavigator externalNavigator) {
        return new CatappultNavigator(externalNavigator);
    }

    @ActivityScope
    ClaimPromotionsNavigator providesClaimPromotionsNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        return new ClaimPromotionsNavigator(fragmentNavigator, (ActivityResultNavigator) this.activity, appNavigator);
    }

    @ActivityScope
    DialogUtils providesDialogUtils(AptoideAccountManager aptoideAccountManager, AccountNavigator accountNavigator, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, Converter.Factory factory, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, MarketResourceFormatter marketResourceFormatter, ThemeManager themeManager, UserFeedbackAnalytics userFeedbackAnalytics) {
        return new DialogUtils(aptoideAccountManager, accountNavigator, bodyInterceptor, okHttpClient, factory, aptoideInstalledAppsRepository, tokenInvalidator, sharedPreferences, marketResourceFormatter, themeManager, userFeedbackAnalytics);
    }

    @ActivityScope
    ExternalNavigator providesExternalNavigator(ThemeManager themeManager) {
        return new ExternalNavigator(this.activity.getApplicationContext(), themeManager);
    }

    @ActivityScope
    ListAppsMoreRepository providesListAppsMoreRepository(StoreCredentialsProvider storeCredentialsProvider, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, Converter.Factory factory) {
        return new ListAppsMoreRepository(storeCredentialsProvider, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, this.activity.getResources(), this.activity.getWindowManager());
    }

    @ActivityScope
    PromotionsNavigator providesPromotionsNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        return new PromotionsNavigator(fragmentNavigator, appNavigator);
    }

    @ActivityScope
    @Named
    float providesScreenHeight(Resources resources) {
        return resources.getDisplayMetrics().heightPixels;
    }

    @ActivityScope
    @Named
    float providesScreenWidth(Resources resources) {
        return resources.getDisplayMetrics().widthPixels;
    }

    @ActivityScope
    SearchNavigator providesSearchNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        return new SearchNavigator(fragmentNavigator, appNavigator);
    }

    @ActivityScope
    SocialMediaNavigator providesSocialMediaNavigator(ExternalNavigator externalNavigator) {
        return new SocialMediaNavigator(externalNavigator);
    }

    @ActivityScope
    ThemeManager providesThemeManager() {
        androidx.appcompat.app.d dVar = this.activity;
        return new ThemeManager(dVar, ((AptoideApplication) dVar.getApplicationContext()).getDefaultSharedPreferences());
    }

    @ActivityScope
    WalletInstallAnalytics providesWalletInstallAnalytics(DownloadAnalytics downloadAnalytics, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, DownloadStateParser downloadStateParser, AnalyticsManager analyticsManager, NavigationTracker navigationTracker, SplitAnalyticsMapper splitAnalyticsMapper) {
        return new WalletInstallAnalytics(downloadAnalytics, notificationAnalytics, installAnalytics, downloadStateParser, analyticsManager, navigationTracker, splitAnalyticsMapper);
    }

    @ActivityScope
    WalletInstallConfiguration providesWalletInstallConfiguration() {
        return new WalletInstallConfiguration(this.intent.getStringExtra("packageName"), this.intent.getStringExtra(DeepLinkIntentReceiver.DeepLinksKeys.WALLET_PACKAGE_NAME_KEY));
    }

    @ActivityScope
    WalletInstallManager providesWalletInstallManager(InstallManager installManager, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, MoPubAdsManager moPubAdsManager, WalletInstallAnalytics walletInstallAnalytics, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, WalletAppProvider walletAppProvider, AppInstallerStatusReceiver appInstallerStatusReceiver, DynamicSplitsManager dynamicSplitsManager) {
        return new WalletInstallManager(this.activity.getPackageManager(), installManager, downloadFactory, downloadStateParser, moPubAdsManager, walletInstallAnalytics, aptoideInstalledAppsRepository, walletAppProvider, appInstallerStatusReceiver, dynamicSplitsManager);
    }

    @ActivityScope
    WalletInstallNavigator providesWalletInstallNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        return new WalletInstallNavigator(fragmentNavigator);
    }

    @ActivityScope
    WalletInstallPresenter providesWalletInstallPresenter(WalletInstallConfiguration walletInstallConfiguration, WalletInstallNavigator walletInstallNavigator, WalletInstallManager walletInstallManager, WalletInstallAnalytics walletInstallAnalytics, MoPubAdsManager moPubAdsManager) {
        return new WalletInstallPresenter((WalletInstallView) this.view, walletInstallManager, walletInstallNavigator, new PermissionManager(), (PermissionService) this.activity, rx.l.c.a.b(), Schedulers.io(), walletInstallConfiguration, walletInstallAnalytics, moPubAdsManager);
    }
}
