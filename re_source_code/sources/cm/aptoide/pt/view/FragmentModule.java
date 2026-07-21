package cm.aptoide.pt.view;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.AppCoinsManager;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.R;
import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.aab.DynamicSplitsManager;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.AgentPersistence;
import cm.aptoide.pt.account.ErrorsMapper;
import cm.aptoide.pt.account.view.AccountErrorMapper;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.account.view.ImageInfoProvider;
import cm.aptoide.pt.account.view.ImagePickerNavigator;
import cm.aptoide.pt.account.view.ImagePickerPresenter;
import cm.aptoide.pt.account.view.ImagePickerView;
import cm.aptoide.pt.account.view.ImageValidator;
import cm.aptoide.pt.account.view.LoginSignUpCredentialsConfiguration;
import cm.aptoide.pt.account.view.LoginSignUpCredentialsFragment;
import cm.aptoide.pt.account.view.PhotoFileGenerator;
import cm.aptoide.pt.account.view.UriToPathResolver;
import cm.aptoide.pt.account.view.magiclink.CheckYourEmailNavigator;
import cm.aptoide.pt.account.view.magiclink.CheckYourEmailPresenter;
import cm.aptoide.pt.account.view.magiclink.CheckYourEmailView;
import cm.aptoide.pt.account.view.magiclink.MagicLinkView;
import cm.aptoide.pt.account.view.magiclink.SendMagicLinkNavigator;
import cm.aptoide.pt.account.view.magiclink.SendMagicLinkPresenter;
import cm.aptoide.pt.account.view.store.ManageStoreErrorMapper;
import cm.aptoide.pt.account.view.store.ManageStoreNavigator;
import cm.aptoide.pt.account.view.store.ManageStorePresenter;
import cm.aptoide.pt.account.view.store.ManageStoreView;
import cm.aptoide.pt.account.view.store.StoreManager;
import cm.aptoide.pt.account.view.user.CreateUserErrorMapper;
import cm.aptoide.pt.account.view.user.ManageUserNavigator;
import cm.aptoide.pt.account.view.user.ManageUserPresenter;
import cm.aptoide.pt.account.view.user.ManageUserView;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.ads.AdsRepository;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.app.AdsManager;
import cm.aptoide.pt.app.AppCoinsAdvertisingManager;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.app.AppViewAnalytics;
import cm.aptoide.pt.app.AppViewManager;
import cm.aptoide.pt.app.AppViewModelManager;
import cm.aptoide.pt.app.CampaignAnalytics;
import cm.aptoide.pt.app.DownloadStateParser;
import cm.aptoide.pt.app.FlagManager;
import cm.aptoide.pt.app.FlagService;
import cm.aptoide.pt.app.ReviewsManager;
import cm.aptoide.pt.app.appsflyer.AppsFlyerManager;
import cm.aptoide.pt.app.aptoideinstall.AptoideInstallManager;
import cm.aptoide.pt.app.migration.AppcMigrationManager;
import cm.aptoide.pt.app.mmpcampaigns.CampaignManager;
import cm.aptoide.pt.app.view.AppCoinsInfoView;
import cm.aptoide.pt.app.view.AppViewFragment;
import cm.aptoide.pt.app.view.AppViewNavigator;
import cm.aptoide.pt.app.view.AppViewPresenter;
import cm.aptoide.pt.app.view.AppViewView;
import cm.aptoide.pt.app.view.MoreBundleManager;
import cm.aptoide.pt.app.view.MoreBundlePresenter;
import cm.aptoide.pt.app.view.MoreBundleView;
import cm.aptoide.pt.autoupdate.AutoUpdateDialogFragment;
import cm.aptoide.pt.autoupdate.AutoUpdateDialogPresenter;
import cm.aptoide.pt.autoupdate.AutoUpdateManager;
import cm.aptoide.pt.blacklist.BlacklistManager;
import cm.aptoide.pt.bottomNavigation.BottomNavigationMapper;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.Type;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.download.SplitAnalyticsMapper;
import cm.aptoide.pt.download.view.DownloadDialogProvider;
import cm.aptoide.pt.download.view.DownloadNavigator;
import cm.aptoide.pt.download.view.DownloadStatusManager;
import cm.aptoide.pt.download.view.DownloadViewActionPresenter;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceDialogFragment;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceDialogPresenter;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceManager;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceNavigator;
import cm.aptoide.pt.editorial.CardId;
import cm.aptoide.pt.editorial.EditorialAnalytics;
import cm.aptoide.pt.editorial.EditorialFragment;
import cm.aptoide.pt.editorial.EditorialManager;
import cm.aptoide.pt.editorial.EditorialNavigator;
import cm.aptoide.pt.editorial.EditorialPresenter;
import cm.aptoide.pt.editorial.EditorialRepository;
import cm.aptoide.pt.editorial.EditorialService;
import cm.aptoide.pt.editorial.EditorialView;
import cm.aptoide.pt.editorial.Slug;
import cm.aptoide.pt.editorialList.EditorialCardListRepository;
import cm.aptoide.pt.editorialList.EditorialCardListService;
import cm.aptoide.pt.editorialList.EditorialListAnalytics;
import cm.aptoide.pt.editorialList.EditorialListManager;
import cm.aptoide.pt.editorialList.EditorialListNavigator;
import cm.aptoide.pt.editorialList.EditorialListPresenter;
import cm.aptoide.pt.editorialList.EditorialListView;
import cm.aptoide.pt.feature.NewFeatureDialogPresenter;
import cm.aptoide.pt.feature.NoBehaviourNewFeatureListener;
import cm.aptoide.pt.home.AptoideBottomNavigator;
import cm.aptoide.pt.home.ChipManager;
import cm.aptoide.pt.home.Home;
import cm.aptoide.pt.home.HomeAnalytics;
import cm.aptoide.pt.home.HomeContainerNavigator;
import cm.aptoide.pt.home.HomeContainerPresenter;
import cm.aptoide.pt.home.HomeContainerView;
import cm.aptoide.pt.home.HomeNavigator;
import cm.aptoide.pt.home.HomePresenter;
import cm.aptoide.pt.home.HomeView;
import cm.aptoide.pt.home.apps.AppMapper;
import cm.aptoide.pt.home.apps.AppsFragmentView;
import cm.aptoide.pt.home.apps.AppsManager;
import cm.aptoide.pt.home.apps.AppsNavigator;
import cm.aptoide.pt.home.apps.AppsPresenter;
import cm.aptoide.pt.home.apps.UpdatesManager;
import cm.aptoide.pt.home.bundles.BundlesRepository;
import cm.aptoide.pt.home.bundles.ads.AdMapper;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListAnalytics;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListConfiguration;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListFragment;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListManager;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListPresenter;
import cm.aptoide.pt.home.more.appcoins.EarnAppcNavigator;
import cm.aptoide.pt.home.more.apps.ListAppsConfiguration;
import cm.aptoide.pt.home.more.apps.ListAppsMoreFragment;
import cm.aptoide.pt.home.more.apps.ListAppsMoreManager;
import cm.aptoide.pt.home.more.apps.ListAppsMorePresenter;
import cm.aptoide.pt.home.more.apps.ListAppsMoreRepository;
import cm.aptoide.pt.install.InstallAnalytics;
import cm.aptoide.pt.install.InstallAppSizeValidator;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.navigator.ActivityNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.FragmentResultNavigator;
import cm.aptoide.pt.navigator.Result;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.notification.AppcPromotionNotificationStringProvider;
import cm.aptoide.pt.notification.ComingSoonNotificationManager;
import cm.aptoide.pt.notification.NotificationAnalytics;
import cm.aptoide.pt.notification.UpdatesNotificationManager;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import cm.aptoide.pt.permission.AccountPermissionProvider;
import cm.aptoide.pt.presenter.LoginSignUpCredentialsView;
import cm.aptoide.pt.presenter.LoginSignupCredentialsFlavorPresenter;
import cm.aptoide.pt.promotions.ClaimPromotionDialogPresenter;
import cm.aptoide.pt.promotions.ClaimPromotionDialogView;
import cm.aptoide.pt.promotions.ClaimPromotionsManager;
import cm.aptoide.pt.promotions.ClaimPromotionsNavigator;
import cm.aptoide.pt.promotions.PromotionViewAppMapper;
import cm.aptoide.pt.promotions.PromotionsAnalytics;
import cm.aptoide.pt.promotions.PromotionsManager;
import cm.aptoide.pt.promotions.PromotionsNavigator;
import cm.aptoide.pt.promotions.PromotionsPreferencesManager;
import cm.aptoide.pt.promotions.PromotionsPresenter;
import cm.aptoide.pt.promotions.PromotionsView;
import cm.aptoide.pt.reactions.ReactionsManager;
import cm.aptoide.pt.repository.request.RewardAppCoinsAppsRepository;
import cm.aptoide.pt.search.SearchManager;
import cm.aptoide.pt.search.SearchNavigator;
import cm.aptoide.pt.search.SearchRepository;
import cm.aptoide.pt.search.analytics.SearchAnalytics;
import cm.aptoide.pt.search.model.SearchAdResult;
import cm.aptoide.pt.search.suggestions.SearchSuggestionManager;
import cm.aptoide.pt.search.suggestions.TrendingManager;
import cm.aptoide.pt.search.view.SearchResultPresenter;
import cm.aptoide.pt.search.view.SearchResultView;
import cm.aptoide.pt.socialmedia.SocialMediaAnalytics;
import cm.aptoide.pt.socialmedia.SocialMediaNavigator;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import cm.aptoide.pt.store.view.my.MyStoresNavigator;
import cm.aptoide.pt.store.view.my.MyStoresPresenter;
import cm.aptoide.pt.store.view.my.MyStoresView;
import cm.aptoide.pt.themes.NewFeatureDialogView;
import cm.aptoide.pt.themes.NewFeatureManager;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.updates.UpdatesAnalytics;
import cm.aptoide.pt.view.app.AppCenter;
import cm.aptoide.pt.view.wizard.WizardPresenter;
import cm.aptoide.pt.view.wizard.WizardView;
import cm.aptoide.pt.wallet.WalletAppProvider;
import cm.aptoide.pt.wallet.WalletInstallManager;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class FragmentModule {
    private final Bundle arguments;
    private final Fragment fragment;
    private final boolean isCreateStoreUserPrivacyEnabled;
    private final String packageName;
    private final Bundle savedInstance;

    public FragmentModule(Fragment fragment, Bundle bundle, Bundle bundle2, boolean z, String str) {
        this.fragment = fragment;
        this.savedInstance = bundle;
        this.arguments = bundle2;
        this.isCreateStoreUserPrivacyEnabled = z;
        this.packageName = str;
    }

    private EditorialConfiguration getEditorialConfiguration() {
        String string = this.arguments.getString("cardId", HttpUrl.FRAGMENT_ENCODE_SET);
        return string.equals(HttpUrl.FRAGMENT_ENCODE_SET) ? new EditorialConfiguration(new Slug(this.arguments.getString("slug", HttpUrl.FRAGMENT_ENCODE_SET))) : new EditorialConfiguration(new CardId(string));
    }

    @FragmentScope
    EditorialListAnalytics editorialListAnalytics(NavigationTracker navigationTracker, AnalyticsManager analyticsManager) {
        return new EditorialListAnalytics(navigationTracker, analyticsManager);
    }

    @FragmentScope
    AccountErrorMapper provideAccountErrorMapper() {
        return new AccountErrorMapper(this.fragment.getContext(), new ErrorsMapper());
    }

    @FragmentScope
    CheckYourEmailPresenter provideCheckYourEmailPresenter(CheckYourEmailNavigator checkYourEmailNavigator) {
        return new CheckYourEmailPresenter((CheckYourEmailView) this.fragment, checkYourEmailNavigator);
    }

    @FragmentScope
    CreateUserErrorMapper provideCreateUserErrorMapper(AccountErrorMapper accountErrorMapper) {
        return new CreateUserErrorMapper(this.fragment.getContext(), accountErrorMapper, this.fragment.getResources());
    }

    @FragmentScope
    EarnAppcListPresenter provideEarnAppCoinsListPresenter(CrashReport crashReport, RewardAppCoinsAppsRepository rewardAppCoinsAppsRepository, AnalyticsManager analyticsManager, AppNavigator appNavigator, EarnAppcListConfiguration earnAppcListConfiguration, EarnAppcListManager earnAppcListManager, MoPubAdsManager moPubAdsManager, EarnAppcListAnalytics earnAppcListAnalytics, EarnAppcNavigator earnAppcNavigator) {
        return new EarnAppcListPresenter((EarnAppcListFragment) this.fragment, rx.l.c.a.b(), crashReport, rewardAppCoinsAppsRepository, analyticsManager, appNavigator, earnAppcListConfiguration, earnAppcListManager, new PermissionManager(), (PermissionService) this.fragment.getContext(), moPubAdsManager, earnAppcListAnalytics, earnAppcNavigator);
    }

    @FragmentScope
    EarnAppcListAnalytics provideEarnAppcListAnalytics(DownloadAnalytics downloadAnalytics) {
        return new EarnAppcListAnalytics(downloadAnalytics);
    }

    @FragmentScope
    EarnAppcListManager provideEarnAppcListManager(WalletAppProvider walletAppProvider, WalletInstallManager walletInstallManager) {
        return new EarnAppcListManager(walletAppProvider, walletInstallManager);
    }

    @FragmentScope
    EarnAppcNavigator provideEarnAppcNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        return new EarnAppcNavigator(fragmentNavigator);
    }

    @FragmentScope
    @Named
    FragmentNavigator provideHomeFragmentNavigator(Map<Integer, Result> map, e.g.b.a<Map<Integer, Result>> aVar) {
        return new FragmentResultNavigator(this.fragment.getChildFragmentManager(), R.id.main_home_container_content, android.R.anim.fade_in, android.R.anim.fade_out, map, aVar);
    }

    @FragmentScope
    ImagePickerPresenter provideImagePickerPresenter(AccountPermissionProvider accountPermissionProvider, PhotoFileGenerator photoFileGenerator, ImageValidator imageValidator, UriToPathResolver uriToPathResolver, ImagePickerNavigator imagePickerNavigator) {
        return new ImagePickerPresenter((ImagePickerView) this.fragment, CrashReport.getInstance(), accountPermissionProvider, photoFileGenerator, imageValidator, rx.l.c.a.b(), uriToPathResolver, imagePickerNavigator, this.fragment.getActivity().getContentResolver(), ImageLoader.with(this.fragment.getContext()), Schedulers.io());
    }

    @FragmentScope
    ImageValidator provideImageValidator(ImageInfoProvider imageInfoProvider) {
        return new ImageValidator(Schedulers.computation(), imageInfoProvider);
    }

    @FragmentScope
    LoginSignupCredentialsFlavorPresenter provideLoginSignUpPresenter(AptoideAccountManager aptoideAccountManager, AccountNavigator accountNavigator, AccountErrorMapper accountErrorMapper, AccountAnalytics accountAnalytics, @Named("facebookLoginPermissions") List<String> list, LoginSignUpCredentialsConfiguration loginSignUpCredentialsConfiguration) {
        return new LoginSignupCredentialsFlavorPresenter((LoginSignUpCredentialsView) this.fragment, aptoideAccountManager, CrashReport.getInstance(), loginSignUpCredentialsConfiguration, accountNavigator, list, accountErrorMapper, accountAnalytics);
    }

    @FragmentScope
    ManageStoreErrorMapper provideManageStoreErrorMapper() {
        return new ManageStoreErrorMapper(this.fragment.getResources(), new ErrorsMapper());
    }

    @FragmentScope
    ManageStorePresenter provideManageStorePresenter(UriToPathResolver uriToPathResolver, ManageStoreNavigator manageStoreNavigator, ManageStoreErrorMapper manageStoreErrorMapper, AptoideAccountManager aptoideAccountManager, AccountAnalytics accountAnalytics) {
        return new ManageStorePresenter((ManageStoreView) this.fragment, CrashReport.getInstance(), uriToPathResolver, this.packageName, manageStoreNavigator, this.arguments.getBoolean("go_to_home", true), manageStoreErrorMapper, aptoideAccountManager, this.arguments.getInt(FragmentNavigator.REQUEST_CODE_EXTRA), accountAnalytics);
    }

    @FragmentScope
    ManageUserPresenter provideManageUserPresenter(AptoideAccountManager aptoideAccountManager, CreateUserErrorMapper createUserErrorMapper, ManageUserNavigator manageUserNavigator, UriToPathResolver uriToPathResolver, AccountAnalytics accountAnalytics) {
        return new ManageUserPresenter((ManageUserView) this.fragment, CrashReport.getInstance(), aptoideAccountManager, createUserErrorMapper, manageUserNavigator, this.arguments.getBoolean("is_edit", false), uriToPathResolver, this.isCreateStoreUserPrivacyEnabled, this.savedInstance == null, accountAnalytics);
    }

    @FragmentScope
    SearchResultPresenter provideSearchResultPresenter(SearchAnalytics searchAnalytics, SearchNavigator searchNavigator, SearchManager searchManager, TrendingManager trendingManager, SearchSuggestionManager searchSuggestionManager, BottomNavigationMapper bottomNavigationMapper, DownloadViewActionPresenter downloadViewActionPresenter) {
        return new SearchResultPresenter((SearchResultView) this.fragment, searchAnalytics, searchNavigator, CrashReport.getInstance(), rx.l.c.a.b(), searchManager, trendingManager, searchSuggestionManager, (AptoideBottomNavigator) this.fragment.getActivity(), bottomNavigationMapper, Schedulers.io(), downloadViewActionPresenter);
    }

    @FragmentScope
    SendMagicLinkPresenter provideSendMagicLinkPresenter(AptoideAccountManager aptoideAccountManager, SendMagicLinkNavigator sendMagicLinkNavigator, AgentPersistence agentPersistence) {
        return new SendMagicLinkPresenter((MagicLinkView) this.fragment, aptoideAccountManager, sendMagicLinkNavigator, rx.l.c.a.b(), agentPersistence);
    }

    @FragmentScope
    AppCoinsInfoPresenter providesAppCoinsInfoPresenter(AppCoinsInfoNavigator appCoinsInfoNavigator, InstallManager installManager, CrashReport crashReport, SocialMediaAnalytics socialMediaAnalytics, AppCoinsManager appCoinsManager) {
        return new AppCoinsInfoPresenter((AppCoinsInfoView) this.fragment, appCoinsInfoNavigator, installManager, crashReport, AptoideApplication.APPCOINS_WALLET_PACKAGE_NAME, rx.l.c.a.b(), socialMediaAnalytics, appCoinsManager);
    }

    @FragmentScope
    AppMapper providesAppMapper() {
        return new AppMapper();
    }

    @FragmentScope
    AppViewConfiguration providesAppViewConfiguration() {
        return new AppViewConfiguration(this.arguments.getLong(AppViewFragment.BundleKeys.APP_ID.name(), -1L), this.arguments.getString(AppViewFragment.BundleKeys.PACKAGE_NAME.name(), null), this.arguments.getString(AppViewFragment.BundleKeys.STORE_NAME.name(), null), this.arguments.getString(AppViewFragment.BundleKeys.STORE_THEME.name(), HttpUrl.FRAGMENT_ENCODE_SET), (SearchAdResult) org.parceler.d.a(this.arguments.getParcelable(AppViewFragment.BundleKeys.MINIMAL_AD.name())), (AppViewFragment.OpenType) this.arguments.getSerializable(AppViewFragment.BundleKeys.SHOULD_INSTALL.name()), this.arguments.getString(AppViewFragment.BundleKeys.MD5.name(), HttpUrl.FRAGMENT_ENCODE_SET), this.arguments.getString(AppViewFragment.BundleKeys.UNAME.name(), HttpUrl.FRAGMENT_ENCODE_SET), this.arguments.getDouble(AppViewFragment.BundleKeys.APPC.name(), -1.0d), this.arguments.getString(AppViewFragment.BundleKeys.EDITORS_CHOICE_POSITION.name(), HttpUrl.FRAGMENT_ENCODE_SET), this.arguments.getString(AppViewFragment.BundleKeys.ORIGIN_TAG.name(), HttpUrl.FRAGMENT_ENCODE_SET), this.arguments.getString(AppViewFragment.BundleKeys.DOWNLOAD_CONVERSION_URL.name(), HttpUrl.FRAGMENT_ENCODE_SET), this.arguments.getString(AppViewFragment.BundleKeys.OEM_ID.name(), null));
    }

    @FragmentScope
    AppViewManager providesAppViewManager(AppViewModelManager appViewModelManager, InstallManager installManager, DownloadFactory downloadFactory, AppCenter appCenter, ReviewsManager reviewsManager, AdsManager adsManager, FlagManager flagManager, StoreUtilsProxy storeUtilsProxy, AptoideAccountManager aptoideAccountManager, DownloadStateParser downloadStateParser, AppViewAnalytics appViewAnalytics, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, Resources resources, WindowManager windowManager, @Named("marketName") String str, AppCoinsManager appCoinsManager, MoPubAdsManager moPubAdsManager, PromotionsManager promotionsManager, AppcMigrationManager appcMigrationManager, LocalNotificationSyncManager localNotificationSyncManager, AppcPromotionNotificationStringProvider appcPromotionNotificationStringProvider, DynamicSplitsManager dynamicSplitsManager, SplitAnalyticsMapper splitAnalyticsMapper, AppsFlyerManager appsFlyerManager, CampaignManager campaignManager) {
        return new AppViewManager(appViewModelManager, installManager, downloadFactory, appCenter, reviewsManager, adsManager, flagManager, storeUtilsProxy, aptoideAccountManager, moPubAdsManager, downloadStateParser, appViewAnalytics, notificationAnalytics, installAnalytics, Type.APPS_GROUP.getPerLineCount(resources, windowManager) * 6, str, appCoinsManager, promotionsManager, appcMigrationManager, localNotificationSyncManager, appcPromotionNotificationStringProvider, dynamicSplitsManager, splitAnalyticsMapper, appsFlyerManager, campaignManager);
    }

    @FragmentScope
    AppViewModelManager providesAppViewModelManager(AppViewConfiguration appViewConfiguration, StoreManager storeManager, @Named("marketName") String str, AppCenter appCenter, DownloadStateParser downloadStateParser, InstallManager installManager, AppcMigrationManager appcMigrationManager, AppCoinsAdvertisingManager appCoinsAdvertisingManager, AppCoinsManager appCoinsManager) {
        return new AppViewModelManager(appViewConfiguration, storeManager, str, appCenter, downloadStateParser, installManager, appcMigrationManager, appCoinsAdvertisingManager, appCoinsManager);
    }

    @FragmentScope
    AppViewPresenter providesAppViewPresenter(AccountNavigator accountNavigator, AppViewAnalytics appViewAnalytics, CampaignAnalytics campaignAnalytics, AppViewNavigator appViewNavigator, AppViewManager appViewManager, AptoideAccountManager aptoideAccountManager, CrashReport crashReport, PromotionsNavigator promotionsNavigator, WalletAppProvider walletAppProvider) {
        return new AppViewPresenter((AppViewView) this.fragment, accountNavigator, appViewAnalytics, campaignAnalytics, appViewNavigator, appViewManager, aptoideAccountManager, rx.l.c.a.b(), crashReport, new PermissionManager(), (PermissionService) this.fragment.getContext(), promotionsNavigator, walletAppProvider);
    }

    @FragmentScope
    AppcPromotionNotificationStringProvider providesAppcPromotionNotificationStringProvider() {
        return new AppcPromotionNotificationStringProvider(this.fragment.getContext().getString(R.string.promo_update2appc_claim_notification_title), this.fragment.getContext().getString(R.string.promo_update2appc_claim_notification_body));
    }

    @FragmentScope
    AppsManager providesAppsManager(UpdatesManager updatesManager, InstallManager installManager, AppMapper appMapper, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, UpdatesAnalytics updatesAnalytics, DownloadFactory downloadFactory, MoPubAdsManager moPubAdsManager, AptoideInstallManager aptoideInstallManager, UpdatesNotificationManager updatesNotificationManager, @Named("secureShared") SharedPreferences sharedPreferences, DynamicSplitsManager dynamicSplitsManager, SplitAnalyticsMapper splitAnalyticsMapper, CampaignManager campaignManager) {
        return new AppsManager(updatesManager, installManager, appMapper, downloadAnalytics, installAnalytics, updatesAnalytics, this.fragment.getContext().getPackageManager(), this.fragment.getContext(), downloadFactory, moPubAdsManager, aptoideInstallManager, updatesNotificationManager, sharedPreferences, dynamicSplitsManager, splitAnalyticsMapper, campaignManager);
    }

    @FragmentScope
    AppsNavigator providesAppsNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationMapper bottomNavigationMapper, AppNavigator appNavigator) {
        return new AppsNavigator(fragmentNavigator, (AptoideBottomNavigator) this.fragment.getActivity(), bottomNavigationMapper, appNavigator);
    }

    @FragmentScope
    AppsPresenter providesAppsPresenter(AppsManager appsManager, AptoideAccountManager aptoideAccountManager, AppsNavigator appsNavigator) {
        return new AppsPresenter((AppsFragmentView) this.fragment, appsManager, rx.l.c.a.b(), Schedulers.io(), CrashReport.getInstance(), new PermissionManager(), (PermissionService) this.fragment.getContext(), aptoideAccountManager, appsNavigator);
    }

    @FragmentScope
    AutoUpdateDialogPresenter providesAutoUpdateDialogPresenter(CrashReport crashReport, AutoUpdateManager autoUpdateManager) {
        return new AutoUpdateDialogPresenter((AutoUpdateDialogFragment) this.fragment, crashReport, autoUpdateManager);
    }

    @FragmentScope
    BundleEvent providesBundleEvent() {
        return new BundleEvent(this.arguments.getString("title"), this.arguments.getString("action"));
    }

    @FragmentScope
    CheckYourEmailNavigator providesCheckYourEmailNavigator() {
        return new CheckYourEmailNavigator((ActivityNavigator) this.fragment.getActivity());
    }

    @FragmentScope
    ClaimPromotionDialogPresenter providesClaimPromotionDialogPresenter(ClaimPromotionsManager claimPromotionsManager, PromotionsAnalytics promotionsAnalytics, ClaimPromotionsNavigator claimPromotionsNavigator) {
        return new ClaimPromotionDialogPresenter((ClaimPromotionDialogView) this.fragment, new rx.t.b(), rx.l.c.a.b(), claimPromotionsManager, promotionsAnalytics, claimPromotionsNavigator);
    }

    @FragmentScope
    ClaimPromotionsManager providesClaimPromotionsManager(PromotionsManager promotionsManager) {
        return new ClaimPromotionsManager(promotionsManager, this.arguments.getString("package_name", BuildConfig.APTOIDE_THEME), this.arguments.getString("promotion_id", BuildConfig.APTOIDE_THEME));
    }

    @FragmentScope
    NewFeatureDialogPresenter providesDarkthemeDialogPresenter(NewFeatureManager newFeatureManager) {
        return new NewFeatureDialogPresenter((NewFeatureDialogView) this.fragment, newFeatureManager, new NoBehaviourNewFeatureListener());
    }

    @FragmentScope
    DownloadDialogProvider providesDownloadDialogManager(ThemeManager themeManager) {
        return new DownloadDialogProvider(this.fragment, themeManager);
    }

    @FragmentScope
    DownloadNavigator providesDownloadNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        Fragment fragment = this.fragment;
        return new DownloadNavigator(fragment, fragment.getContext().getPackageManager(), fragmentNavigator);
    }

    @FragmentScope
    DownloadViewActionPresenter providesDownloadViewActionPresenter(InstallManager installManager, MoPubAdsManager moPubAdsManager, PermissionManager permissionManager, AppcMigrationManager appcMigrationManager, DownloadDialogProvider downloadDialogProvider, DownloadNavigator downloadNavigator, DownloadFactory downloadFactory, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, NotificationAnalytics notificationAnalytics, CrashReport crashReport, DynamicSplitsManager dynamicSplitsManager, SplitAnalyticsMapper splitAnalyticsMapper, CampaignManager campaignManager) {
        return new DownloadViewActionPresenter(installManager, moPubAdsManager, permissionManager, appcMigrationManager, downloadDialogProvider, downloadNavigator, (PermissionService) this.fragment.getActivity(), Schedulers.io(), rx.l.c.a.b(), downloadFactory, downloadAnalytics, installAnalytics, notificationAnalytics, crashReport, dynamicSplitsManager, splitAnalyticsMapper, campaignManager);
    }

    @FragmentScope
    EditorialAnalytics providesEditorialAnalytics(DownloadAnalytics downloadAnalytics, AnalyticsManager analyticsManager, NavigationTracker navigationTracker, InstallAnalytics installAnalytics, SplitAnalyticsMapper splitAnalyticsMapper) {
        return new EditorialAnalytics(downloadAnalytics, analyticsManager, navigationTracker, this.arguments.getBoolean(EditorialFragment.FROM_HOME), installAnalytics, splitAnalyticsMapper);
    }

    @FragmentScope
    EditorialListManager providesEditorialListManager(EditorialCardListRepository editorialCardListRepository, ReactionsManager reactionsManager, AppCoinsManager appCoinsManager) {
        return new EditorialListManager(editorialCardListRepository, reactionsManager, appCoinsManager);
    }

    @FragmentScope
    EditorialListNavigator providesEditorialListNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AccountNavigator accountNavigator) {
        return new EditorialListNavigator(fragmentNavigator, accountNavigator);
    }

    @FragmentScope
    EditorialListPresenter providesEditorialListPresenter(EditorialListManager editorialListManager, AptoideAccountManager aptoideAccountManager, EditorialListNavigator editorialListNavigator, EditorialListAnalytics editorialListAnalytics, UserFeedbackAnalytics userFeedbackAnalytics) {
        return new EditorialListPresenter((EditorialListView) this.fragment, editorialListManager, aptoideAccountManager, editorialListNavigator, editorialListAnalytics, CrashReport.getInstance(), rx.l.c.a.b(), userFeedbackAnalytics);
    }

    @FragmentScope
    EditorialCardListRepository providesEditorialListRepository(EditorialCardListService editorialCardListService) {
        return new EditorialCardListRepository(editorialCardListService);
    }

    @FragmentScope
    EditorialManager providesEditorialManager(EditorialRepository editorialRepository, InstallManager installManager, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, EditorialAnalytics editorialAnalytics, ReactionsManager reactionsManager, MoPubAdsManager moPubAdsManager, DynamicSplitsManager dynamicSplitsManager, SplitAnalyticsMapper splitAnalyticsMapper, CampaignManager campaignManager) {
        return new EditorialManager(editorialRepository, getEditorialConfiguration(), installManager, downloadFactory, downloadStateParser, notificationAnalytics, installAnalytics, editorialAnalytics, reactionsManager, moPubAdsManager, dynamicSplitsManager, splitAnalyticsMapper, campaignManager);
    }

    @FragmentScope
    EditorialNavigator providesEditorialNavigator(AppNavigator appNavigator, AccountNavigator accountNavigator, SocialMediaNavigator socialMediaNavigator, @Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        return new EditorialNavigator((ActivityNavigator) this.fragment.getActivity(), fragmentNavigator, appNavigator, accountNavigator, socialMediaNavigator);
    }

    @FragmentScope
    EditorialPresenter providesEditorialPresenter(EditorialManager editorialManager, CrashReport crashReport, EditorialAnalytics editorialAnalytics, EditorialNavigator editorialNavigator, UserFeedbackAnalytics userFeedbackAnalytics, MoPubAdsManager moPubAdsManager, SocialMediaAnalytics socialMediaAnalytics) {
        return new EditorialPresenter((EditorialView) this.fragment, editorialManager, rx.l.c.a.b(), crashReport, new PermissionManager(), (PermissionService) this.fragment.getContext(), editorialAnalytics, editorialNavigator, userFeedbackAnalytics, moPubAdsManager, socialMediaAnalytics);
    }

    @FragmentScope
    EditorialRepository providesEditorialRepository(EditorialService editorialService) {
        return new EditorialRepository(editorialService);
    }

    @FragmentScope
    EditorialCardListService providesEditorialService(@Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        return new EditorialCardListService(bodyInterceptor, okHttpClient, tokenInvalidator, WebService.getDefaultConverter(), sharedPreferences, 10);
    }

    @FragmentScope
    FlagManager providesFlagManager(FlagService flagService) {
        return new FlagManager(flagService);
    }

    @FragmentScope
    FlagService providesFlagService(@Named("defaultInterceptorV3") BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> bodyInterceptor, @Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences) {
        return new FlagService(bodyInterceptor, okHttpClient, tokenInvalidator, sharedPreferences);
    }

    @FragmentScope
    MoreBundleManager providesGetStoreManager(BundlesRepository bundlesRepository) {
        return new MoreBundleManager(bundlesRepository);
    }

    @FragmentScope
    MoreBundlePresenter providesGetStoreWidgetsPresenter(MoreBundleManager moreBundleManager, CrashReport crashReport, HomeNavigator homeNavigator, AdMapper adMapper, BundleEvent bundleEvent, HomeAnalytics homeAnalytics, ChipManager chipManager) {
        return new MoreBundlePresenter((MoreBundleView) this.fragment, moreBundleManager, rx.l.c.a.b(), crashReport, homeNavigator, adMapper, bundleEvent, homeAnalytics, chipManager);
    }

    @FragmentScope
    Home providesHome(BundlesRepository bundlesRepository, PromotionsManager promotionsManager, PromotionsPreferencesManager promotionsPreferencesManager, BlacklistManager blacklistManager, @Named("homePromotionsId") String str, ReactionsManager reactionsManager, ComingSoonNotificationManager comingSoonNotificationManager) {
        return new Home(bundlesRepository, promotionsManager, promotionsPreferencesManager, blacklistManager, str, reactionsManager, comingSoonNotificationManager);
    }

    @FragmentScope
    HomeAnalytics providesHomeAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return new HomeAnalytics(navigationTracker, analyticsManager);
    }

    @FragmentScope
    HomeContainerNavigator providesHomeContainerNavigator(@Named("home-fragment-navigator") FragmentNavigator fragmentNavigator) {
        return new HomeContainerNavigator(fragmentNavigator);
    }

    @FragmentScope
    HomeContainerPresenter providesHomeContainerPresenter(AptoideAccountManager aptoideAccountManager, HomeContainerNavigator homeContainerNavigator, HomeNavigator homeNavigator, HomeAnalytics homeAnalytics, Home home, ChipManager chipManager) {
        return new HomeContainerPresenter((HomeContainerView) this.fragment, rx.l.c.a.b(), aptoideAccountManager, homeContainerNavigator, homeNavigator, homeAnalytics, home, chipManager);
    }

    @FragmentScope
    HomeNavigator providesHomeNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationMapper bottomNavigationMapper, AppNavigator appNavigator, AccountNavigator accountNavigator, ThemeManager themeManager) {
        return new HomeNavigator(fragmentNavigator, (AptoideBottomNavigator) this.fragment.getActivity(), bottomNavigationMapper, appNavigator, (ActivityNavigator) this.fragment.getActivity(), accountNavigator, themeManager);
    }

    @FragmentScope
    HomePresenter providesHomePresenter(Home home, HomeNavigator homeNavigator, AdMapper adMapper, AptoideAccountManager aptoideAccountManager, HomeAnalytics homeAnalytics, UserFeedbackAnalytics userFeedbackAnalytics) {
        return new HomePresenter((HomeView) this.fragment, home, rx.l.c.a.b(), CrashReport.getInstance(), homeNavigator, adMapper, homeAnalytics, userFeedbackAnalytics);
    }

    @FragmentScope
    EarnAppcListConfiguration providesListAppsConfiguration() {
        return new EarnAppcListConfiguration(this.arguments.getString("title"), this.arguments.getString(StoreTabGridRecyclerFragment.BundleCons.TAG));
    }

    @FragmentScope
    ListAppsConfiguration providesListAppsMoreConfiguration() {
        return new ListAppsConfiguration(this.fragment.getArguments().getString("title"), this.arguments.getString(StoreTabGridRecyclerFragment.BundleCons.TAG), this.arguments.getString("action"), this.arguments.getString("name"), Long.valueOf(this.arguments.getLong(StoreTabGridRecyclerFragment.BundleCons.GROUP_ID)));
    }

    @FragmentScope
    ListAppsMoreManager providesListAppsMoreManager(ListAppsMoreRepository listAppsMoreRepository, AdsRepository adsRepository) {
        return new ListAppsMoreManager(listAppsMoreRepository, adsRepository);
    }

    @FragmentScope
    ListAppsMorePresenter providesListAppsMorePresenter(CrashReport crashReport, AppNavigator appNavigator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, ListAppsConfiguration listAppsConfiguration, ListAppsMoreManager listAppsMoreManager) {
        return new ListAppsMorePresenter((ListAppsMoreFragment) this.fragment, rx.l.c.a.b(), crashReport, appNavigator, sharedPreferences, listAppsConfiguration, listAppsMoreManager);
    }

    @FragmentScope
    LoginSignUpCredentialsConfiguration providesLoginSignUpCredentialsConfiguration() {
        String string = this.arguments.getString("magic_link_error_message");
        if (string == null) {
            string = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return new LoginSignUpCredentialsConfiguration(this.arguments.getBoolean(LoginSignUpCredentialsFragment.DISMISS_TO_NAVIGATE_TO_MAIN_VIEW), this.arguments.getBoolean(LoginSignUpCredentialsFragment.CLEAN_BACK_STACK), this.arguments.getBoolean("has_magic_link_error"), string);
    }

    @FragmentScope
    MyStoresNavigator providesMyStoreNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationMapper bottomNavigationMapper) {
        return new MyStoresNavigator(fragmentNavigator, (AptoideBottomNavigator) this.fragment.getActivity(), bottomNavigationMapper);
    }

    @FragmentScope
    MyStoresPresenter providesMyStorePresenter(AptoideAccountManager aptoideAccountManager, MyStoresNavigator myStoresNavigator) {
        return new MyStoresPresenter((MyStoresView) this.fragment, rx.l.c.a.b(), aptoideAccountManager, myStoresNavigator);
    }

    @FragmentScope
    OutOfSpaceDialogPresenter providesOutOfSpaceDialogPresenter(CrashReport crashReport, OutOfSpaceManager outOfSpaceManager, OutOfSpaceNavigator outOfSpaceNavigator) {
        return new OutOfSpaceDialogPresenter((OutOfSpaceDialogFragment) this.fragment, crashReport, rx.l.c.a.b(), Schedulers.io(), outOfSpaceManager, outOfSpaceNavigator);
    }

    @FragmentScope
    OutOfSpaceManager providesOutOfSpaceManager(InstallManager installManager, InstallAppSizeValidator installAppSizeValidator) {
        return new OutOfSpaceManager(installManager, this.arguments.getLong(OutOfSpaceDialogFragment.APP_SIZE), rx.s.b.g1(), installAppSizeValidator);
    }

    @FragmentScope
    OutOfSpaceNavigator providesOutOfSpaceNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        return new OutOfSpaceNavigator(fragmentNavigator, this.arguments.getString("package_name"));
    }

    @FragmentScope
    PromotionViewAppMapper providesPromotionViewAppMapper(DownloadStateParser downloadStateParser) {
        return new PromotionViewAppMapper(downloadStateParser);
    }

    @FragmentScope
    PromotionsPresenter providesPromotionsPresenter(PromotionsManager promotionsManager, PromotionsAnalytics promotionsAnalytics, PromotionsNavigator promotionsNavigator, @Named("homePromotionsId") String str, MoPubAdsManager moPubAdsManager) {
        return new PromotionsPresenter((PromotionsView) this.fragment, promotionsManager, new PermissionManager(), (PermissionService) this.fragment.getContext(), rx.l.c.a.b(), promotionsAnalytics, promotionsNavigator, str, moPubAdsManager);
    }

    @FragmentScope
    RewardAppCoinsAppsRepository providesRewardAppCoinsAppsRepository(@Named(BuildConfig.APTOIDE_THEME) OkHttpClient okHttpClient, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, @Named(BuildConfig.APTOIDE_THEME) SharedPreferences sharedPreferences, InstallManager installManager) {
        return new RewardAppCoinsAppsRepository(okHttpClient, WebService.getDefaultConverter(), bodyInterceptor, tokenInvalidator, sharedPreferences, installManager);
    }

    @FragmentScope
    SearchManager providesSearchManager(AptoideAccountManager aptoideAccountManager, SearchRepository searchRepository, DownloadStatusManager downloadStatusManager, AppCenter appCenter) {
        return new SearchManager(aptoideAccountManager, searchRepository, downloadStatusManager, appCenter);
    }

    @FragmentScope
    SendMagicLinkNavigator providesSendMagicLinkNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, ThemeManager themeManager) {
        return new SendMagicLinkNavigator(fragmentNavigator, this.fragment.getContext(), themeManager);
    }

    @FragmentScope
    WizardPresenter providesWizardPresenter(AptoideAccountManager aptoideAccountManager, CrashReport crashReport, AccountAnalytics accountAnalytics) {
        return new WizardPresenter((WizardView) this.fragment, aptoideAccountManager, crashReport, accountAnalytics);
    }
}
