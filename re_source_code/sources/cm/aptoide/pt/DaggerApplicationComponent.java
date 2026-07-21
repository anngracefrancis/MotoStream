package cm.aptoide.pt;

import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import cm.aptoide.accountmanager.AccountFactory;
import cm.aptoide.accountmanager.AccountPersistence;
import cm.aptoide.accountmanager.AccountService;
import cm.aptoide.accountmanager.AdultContent;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.AnalyticsLogger;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.EventLogger;
import cm.aptoide.analytics.SessionLogger;
import cm.aptoide.analytics.implementation.PageViewsAnalytics;
import cm.aptoide.analytics.implementation.loggers.FlurryEventLogger;
import cm.aptoide.analytics.implementation.loggers.HttpKnockEventLogger;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.analytics.implementation.utils.AnalyticsEventParametersNormalizer;
import cm.aptoide.analytics.implementation.utils.MapToJsonMapper;
import cm.aptoide.pt.aab.DynamicSplitsManager;
import cm.aptoide.pt.aab.DynamicSplitsMapper;
import cm.aptoide.pt.aab.DynamicSplitsRemoteService;
import cm.aptoide.pt.aab.DynamicSplitsService;
import cm.aptoide.pt.aab.SplitsMapper;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.AdultContentAnalytics;
import cm.aptoide.pt.account.AgentPersistence;
import cm.aptoide.pt.account.AndroidAccountProvider;
import cm.aptoide.pt.account.DatabaseStoreDataPersist;
import cm.aptoide.pt.account.LoginPreferences;
import cm.aptoide.pt.account.OAuthModeProvider;
import cm.aptoide.pt.account.view.AccountErrorMapper;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.account.view.ImageInfoProvider;
import cm.aptoide.pt.account.view.ImagePickerNavigator;
import cm.aptoide.pt.account.view.ImagePickerPresenter;
import cm.aptoide.pt.account.view.ImageValidator;
import cm.aptoide.pt.account.view.LoginSignUpCredentialsConfiguration;
import cm.aptoide.pt.account.view.LoginSignUpCredentialsFragment;
import cm.aptoide.pt.account.view.LoginSignUpCredentialsFragment_MembersInjector;
import cm.aptoide.pt.account.view.PhotoFileGenerator;
import cm.aptoide.pt.account.view.UriToPathResolver;
import cm.aptoide.pt.account.view.magiclink.CheckYourEmailFragment;
import cm.aptoide.pt.account.view.magiclink.CheckYourEmailFragment_MembersInjector;
import cm.aptoide.pt.account.view.magiclink.CheckYourEmailNavigator;
import cm.aptoide.pt.account.view.magiclink.CheckYourEmailPresenter;
import cm.aptoide.pt.account.view.magiclink.SendMagicLinkNavigator;
import cm.aptoide.pt.account.view.magiclink.SendMagicLinkPresenter;
import cm.aptoide.pt.account.view.store.ManageStoreErrorMapper;
import cm.aptoide.pt.account.view.store.ManageStoreFragment;
import cm.aptoide.pt.account.view.store.ManageStoreFragment_MembersInjector;
import cm.aptoide.pt.account.view.store.ManageStoreNavigator;
import cm.aptoide.pt.account.view.store.ManageStorePresenter;
import cm.aptoide.pt.account.view.store.StoreManager;
import cm.aptoide.pt.account.view.user.CreateUserErrorMapper;
import cm.aptoide.pt.account.view.user.ManageUserFragment;
import cm.aptoide.pt.account.view.user.ManageUserFragment_MembersInjector;
import cm.aptoide.pt.account.view.user.ManageUserNavigator;
import cm.aptoide.pt.account.view.user.ManageUserPresenter;
import cm.aptoide.pt.account.view.user.NewsletterManager;
import cm.aptoide.pt.account.view.user.ProfileStepOneFragment;
import cm.aptoide.pt.account.view.user.ProfileStepOneFragment_MembersInjector;
import cm.aptoide.pt.account.view.user.ProfileStepTwoFragment;
import cm.aptoide.pt.account.view.user.ProfileStepTwoFragment_MembersInjector;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.ads.AdsRepository;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.ads.WalletAdsOfferCardManager;
import cm.aptoide.pt.ads.WalletAdsOfferManager;
import cm.aptoide.pt.analytics.AppSizeAnalyticsStringMapper;
import cm.aptoide.pt.analytics.FirstLaunchAnalytics;
import cm.aptoide.pt.analytics.view.AnalyticsActivity;
import cm.aptoide.pt.analytics.view.AnalyticsActivity_MembersInjector;
import cm.aptoide.pt.apkfy.ApkFyParser;
import cm.aptoide.pt.apkfy.ApkfyManager;
import cm.aptoide.pt.apkfy.ApkfyService;
import cm.aptoide.pt.apkfy.AptoideApkfyService;
import cm.aptoide.pt.app.AdsManager;
import cm.aptoide.pt.app.AppCoinsAdvertisingManager;
import cm.aptoide.pt.app.AppCoinsService;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.app.AppViewAnalytics;
import cm.aptoide.pt.app.AppViewManager;
import cm.aptoide.pt.app.AppViewModelManager;
import cm.aptoide.pt.app.CampaignAnalytics;
import cm.aptoide.pt.app.DownloadStateParser;
import cm.aptoide.pt.app.FlagManager;
import cm.aptoide.pt.app.FlagService;
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
import cm.aptoide.pt.app.mmpcampaigns.CampaignManager;
import cm.aptoide.pt.app.mmpcampaigns.CampaignMapper;
import cm.aptoide.pt.app.mmpcampaigns.CampaignRepository;
import cm.aptoide.pt.app.view.AppCoinsInfoFragment;
import cm.aptoide.pt.app.view.AppCoinsInfoFragment_MembersInjector;
import cm.aptoide.pt.app.view.AppViewFragment;
import cm.aptoide.pt.app.view.AppViewFragment_MembersInjector;
import cm.aptoide.pt.app.view.AppViewNavigator;
import cm.aptoide.pt.app.view.AppViewPresenter;
import cm.aptoide.pt.app.view.MoreBundleFragment;
import cm.aptoide.pt.app.view.MoreBundleFragment_MembersInjector;
import cm.aptoide.pt.app.view.MoreBundleManager;
import cm.aptoide.pt.app.view.MoreBundlePresenter;
import cm.aptoide.pt.app.view.OtherVersionsFragment;
import cm.aptoide.pt.app.view.OtherVersionsFragment_MembersInjector;
import cm.aptoide.pt.appview.PreferencesPersister;
import cm.aptoide.pt.autoupdate.AutoUpdateDialogFragment;
import cm.aptoide.pt.autoupdate.AutoUpdateDialogFragment_MembersInjector;
import cm.aptoide.pt.autoupdate.AutoUpdateDialogPresenter;
import cm.aptoide.pt.autoupdate.AutoUpdateManager;
import cm.aptoide.pt.autoupdate.AutoUpdateRepository;
import cm.aptoide.pt.autoupdate.AutoUpdateService;
import cm.aptoide.pt.autoupdate.Service;
import cm.aptoide.pt.blacklist.BlacklistManager;
import cm.aptoide.pt.blacklist.BlacklistPersistence;
import cm.aptoide.pt.blacklist.BlacklistUnitMapper;
import cm.aptoide.pt.blacklist.Blacklister;
import cm.aptoide.pt.bonus.BonusAppcRemoteService;
import cm.aptoide.pt.bonus.BonusAppcService;
import cm.aptoide.pt.bottomNavigation.BottomNavigationActivity;
import cm.aptoide.pt.bottomNavigation.BottomNavigationActivity_MembersInjector;
import cm.aptoide.pt.bottomNavigation.BottomNavigationAnalytics;
import cm.aptoide.pt.bottomNavigation.BottomNavigationMapper;
import cm.aptoide.pt.bottomNavigation.BottomNavigationNavigator;
import cm.aptoide.pt.comments.view.CommentDialogFragment;
import cm.aptoide.pt.comments.view.CommentDialogFragment_MembersInjector;
import cm.aptoide.pt.comments.view.CommentListFragment;
import cm.aptoide.pt.comments.view.CommentListFragment_MembersInjector;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.RoomInstallationMapper;
import cm.aptoide.pt.database.RoomInstallationPersistence;
import cm.aptoide.pt.database.RoomInstalledPersistence;
import cm.aptoide.pt.database.RoomNotificationPersistence;
import cm.aptoide.pt.database.RoomStoredMinimalAdPersistence;
import cm.aptoide.pt.database.room.AptoideDatabase;
import cm.aptoide.pt.dataprovider.NetworkOperatorManager;
import cm.aptoide.pt.dataprovider.cache.L2Cache;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.store.RequestBodyFactory;
import cm.aptoide.pt.download.AppValidationAnalytics;
import cm.aptoide.pt.download.AppValidator;
import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.download.DownloadSpeedIntervalMapper;
import cm.aptoide.pt.download.Md5Comparator;
import cm.aptoide.pt.download.OemidProvider;
import cm.aptoide.pt.download.SplitAnalyticsMapper;
import cm.aptoide.pt.download.SplitTypeSubFileTypeMapper;
import cm.aptoide.pt.download.view.DownloadDialogProvider;
import cm.aptoide.pt.download.view.DownloadNavigator;
import cm.aptoide.pt.download.view.DownloadStatusManager;
import cm.aptoide.pt.download.view.DownloadViewActionPresenter;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceDialogFragment;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceDialogFragment_MembersInjector;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceDialogPresenter;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceManager;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceNavigator;
import cm.aptoide.pt.downloadmanager.AppDownloaderProvider;
import cm.aptoide.pt.downloadmanager.AptoideDownloadManager;
import cm.aptoide.pt.downloadmanager.DownloadAppFileMapper;
import cm.aptoide.pt.downloadmanager.DownloadAppMapper;
import cm.aptoide.pt.downloadmanager.DownloadPersistence;
import cm.aptoide.pt.downloadmanager.DownloadStatusMapper;
import cm.aptoide.pt.downloadmanager.DownloadsRepository;
import cm.aptoide.pt.downloadmanager.FileDownloaderProvider;
import cm.aptoide.pt.downloadmanager.RetryFileDownloaderProvider;
import cm.aptoide.pt.editorial.CaptionBackgroundPainter;
import cm.aptoide.pt.editorial.EditorialAnalytics;
import cm.aptoide.pt.editorial.EditorialFragment;
import cm.aptoide.pt.editorial.EditorialFragment_MembersInjector;
import cm.aptoide.pt.editorial.EditorialManager;
import cm.aptoide.pt.editorial.EditorialNavigator;
import cm.aptoide.pt.editorial.EditorialPresenter;
import cm.aptoide.pt.editorial.EditorialRepository;
import cm.aptoide.pt.editorial.EditorialService;
import cm.aptoide.pt.editorialList.EditorialCardListRepository;
import cm.aptoide.pt.editorialList.EditorialCardListService;
import cm.aptoide.pt.editorialList.EditorialListAnalytics;
import cm.aptoide.pt.editorialList.EditorialListFragment;
import cm.aptoide.pt.editorialList.EditorialListFragment_MembersInjector;
import cm.aptoide.pt.editorialList.EditorialListManager;
import cm.aptoide.pt.editorialList.EditorialListNavigator;
import cm.aptoide.pt.editorialList.EditorialListPresenter;
import cm.aptoide.pt.feature.NewFeatureDialogPresenter;
import cm.aptoide.pt.file.CacheHelper;
import cm.aptoide.pt.file.FileManager;
import cm.aptoide.pt.home.AppComingSoonRegistrationManager;
import cm.aptoide.pt.home.AppComingSoonRegistrationPersistence;
import cm.aptoide.pt.home.ChipManager;
import cm.aptoide.pt.home.Home;
import cm.aptoide.pt.home.HomeAnalytics;
import cm.aptoide.pt.home.HomeContainerFragment;
import cm.aptoide.pt.home.HomeContainerFragment_MembersInjector;
import cm.aptoide.pt.home.HomeContainerNavigator;
import cm.aptoide.pt.home.HomeContainerPresenter;
import cm.aptoide.pt.home.HomeFragment;
import cm.aptoide.pt.home.HomeFragment_MembersInjector;
import cm.aptoide.pt.home.HomeNavigator;
import cm.aptoide.pt.home.HomePresenter;
import cm.aptoide.pt.home.apps.AppMapper;
import cm.aptoide.pt.home.apps.AppsFragment;
import cm.aptoide.pt.home.apps.AppsFragment_MembersInjector;
import cm.aptoide.pt.home.apps.AppsManager;
import cm.aptoide.pt.home.apps.AppsNavigator;
import cm.aptoide.pt.home.apps.AppsPresenter;
import cm.aptoide.pt.home.apps.UpdatesManager;
import cm.aptoide.pt.home.bundles.BundleDataSource;
import cm.aptoide.pt.home.bundles.BundlesRepository;
import cm.aptoide.pt.home.bundles.BundlesResponseMapper;
import cm.aptoide.pt.home.bundles.ads.AdMapper;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListAnalytics;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListConfiguration;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListFragment;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListFragment_MembersInjector;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListManager;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListPresenter;
import cm.aptoide.pt.home.more.appcoins.EarnAppcNavigator;
import cm.aptoide.pt.home.more.apps.ListAppsConfiguration;
import cm.aptoide.pt.home.more.apps.ListAppsMoreFragment;
import cm.aptoide.pt.home.more.apps.ListAppsMoreFragment_MembersInjector;
import cm.aptoide.pt.home.more.apps.ListAppsMoreManager;
import cm.aptoide.pt.home.more.apps.ListAppsMorePresenter;
import cm.aptoide.pt.home.more.apps.ListAppsMoreRepository;
import cm.aptoide.pt.install.AppInstallerStatusReceiver;
import cm.aptoide.pt.install.AptoideInstallPersistence;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.install.DownloadService;
import cm.aptoide.pt.install.DownloadService_MembersInjector;
import cm.aptoide.pt.install.FilePathProvider;
import cm.aptoide.pt.install.ForegroundManager;
import cm.aptoide.pt.install.InstallAnalytics;
import cm.aptoide.pt.install.InstallAppSizeValidator;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.install.InstalledIntentService;
import cm.aptoide.pt.install.InstalledIntentService_MembersInjector;
import cm.aptoide.pt.install.Installer;
import cm.aptoide.pt.install.InstallerAnalytics;
import cm.aptoide.pt.install.PackageRepository;
import cm.aptoide.pt.install.RootInstallerProvider;
import cm.aptoide.pt.install.installer.InstallationProvider;
import cm.aptoide.pt.install.installer.RootInstallationRetryHandler;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.navigator.ActivityResultNavigator_MembersInjector;
import cm.aptoide.pt.navigator.ExternalNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.Result;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.networking.MultipartBodyInterceptor;
import cm.aptoide.pt.notification.AppcPromotionNotificationStringProvider;
import cm.aptoide.pt.notification.AptoideWorkerFactory;
import cm.aptoide.pt.notification.ComingSoonNotificationManager;
import cm.aptoide.pt.notification.NotificationAnalytics;
import cm.aptoide.pt.notification.NotificationProvider;
import cm.aptoide.pt.notification.PullingContentService;
import cm.aptoide.pt.notification.PullingContentService_MembersInjector;
import cm.aptoide.pt.notification.ReadyToInstallNotificationManager;
import cm.aptoide.pt.notification.RoomLocalNotificationSyncPersistence;
import cm.aptoide.pt.notification.UpdatesNotificationManager;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import cm.aptoide.pt.notification.view.InboxFragment;
import cm.aptoide.pt.orientation.ScreenOrientationManager;
import cm.aptoide.pt.packageinstaller.AppInstaller;
import cm.aptoide.pt.permission.AccountPermissionProvider;
import cm.aptoide.pt.preferences.AptoideMd5Manager;
import cm.aptoide.pt.preferences.LocalPersistenceAdultContent;
import cm.aptoide.pt.preferences.Preferences;
import cm.aptoide.pt.preferences.SecurePreferences;
import cm.aptoide.pt.preferences.secure.SecureCoderDecoder;
import cm.aptoide.pt.presenter.LoginSignupCredentialsFlavorPresenter;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.promotions.ClaimPromotionDialogFragment;
import cm.aptoide.pt.promotions.ClaimPromotionDialogFragment_MembersInjector;
import cm.aptoide.pt.promotions.ClaimPromotionDialogPresenter;
import cm.aptoide.pt.promotions.ClaimPromotionsManager;
import cm.aptoide.pt.promotions.ClaimPromotionsNavigator;
import cm.aptoide.pt.promotions.PromotionViewAppMapper;
import cm.aptoide.pt.promotions.PromotionsAnalytics;
import cm.aptoide.pt.promotions.PromotionsFragment;
import cm.aptoide.pt.promotions.PromotionsFragment_MembersInjector;
import cm.aptoide.pt.promotions.PromotionsManager;
import cm.aptoide.pt.promotions.PromotionsNavigator;
import cm.aptoide.pt.promotions.PromotionsPreferencesManager;
import cm.aptoide.pt.promotions.PromotionsPresenter;
import cm.aptoide.pt.promotions.PromotionsService;
import cm.aptoide.pt.reactions.ReactionsManager;
import cm.aptoide.pt.reactions.network.ReactionsRemoteService;
import cm.aptoide.pt.reactions.network.ReactionsService;
import cm.aptoide.pt.repository.request.RewardAppCoinsAppsRepository;
import cm.aptoide.pt.reviews.LatestReviewsFragment;
import cm.aptoide.pt.reviews.LatestReviewsFragment_MembersInjector;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import cm.aptoide.pt.reviews.RateAndReviewsFragment_MembersInjector;
import cm.aptoide.pt.root.RootAvailabilityManager;
import cm.aptoide.pt.search.SearchManager;
import cm.aptoide.pt.search.SearchNavigator;
import cm.aptoide.pt.search.SearchRepository;
import cm.aptoide.pt.search.analytics.SearchAnalytics;
import cm.aptoide.pt.search.suggestions.SearchSuggestionManager;
import cm.aptoide.pt.search.suggestions.SearchSuggestionRemoteRepository;
import cm.aptoide.pt.search.suggestions.TrendingManager;
import cm.aptoide.pt.search.suggestions.TrendingService;
import cm.aptoide.pt.search.view.SearchResultFragment;
import cm.aptoide.pt.search.view.SearchResultFragment_MembersInjector;
import cm.aptoide.pt.search.view.SearchResultPresenter;
import cm.aptoide.pt.socialmedia.SocialMediaAnalytics;
import cm.aptoide.pt.socialmedia.SocialMediaNavigator;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StorePersistence;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.store.view.AddStoreDialog;
import cm.aptoide.pt.store.view.AddStoreDialog_MembersInjector;
import cm.aptoide.pt.store.view.ListStoresFragment;
import cm.aptoide.pt.store.view.ListStoresFragment_MembersInjector;
import cm.aptoide.pt.store.view.PrivateStoreDialog;
import cm.aptoide.pt.store.view.PrivateStoreDialog_MembersInjector;
import cm.aptoide.pt.store.view.StoreFragment;
import cm.aptoide.pt.store.view.StoreFragment_MembersInjector;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment_MembersInjector;
import cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment;
import cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment_MembersInjector;
import cm.aptoide.pt.store.view.TopStoresFragment;
import cm.aptoide.pt.store.view.TopStoresFragment_MembersInjector;
import cm.aptoide.pt.store.view.my.MyStoresFragment;
import cm.aptoide.pt.store.view.my.MyStoresFragment_MembersInjector;
import cm.aptoide.pt.store.view.my.MyStoresNavigator;
import cm.aptoide.pt.store.view.my.MyStoresPresenter;
import cm.aptoide.pt.store.view.my.MyStoresSubscribedFragment;
import cm.aptoide.pt.store.view.my.MyStoresSubscribedFragment_MembersInjector;
import cm.aptoide.pt.store.view.recommended.RecommendedStoresFragment;
import cm.aptoide.pt.store.view.recommended.RecommendedStoresFragment_MembersInjector;
import cm.aptoide.pt.sync.SyncScheduler;
import cm.aptoide.pt.sync.alarm.SyncStorage;
import cm.aptoide.pt.themes.NewFeature;
import cm.aptoide.pt.themes.NewFeatureDialogFragment;
import cm.aptoide.pt.themes.NewFeatureDialogFragment_MembersInjector;
import cm.aptoide.pt.themes.NewFeatureManager;
import cm.aptoide.pt.themes.ThemeAnalytics;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowersFragment;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowersFragment_MembersInjector;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowingFragment;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowingFragment_MembersInjector;
import cm.aptoide.pt.toolbox.ToolboxContentProvider;
import cm.aptoide.pt.toolbox.ToolboxContentProvider_MembersInjector;
import cm.aptoide.pt.updates.UpdateMapper;
import cm.aptoide.pt.updates.UpdatePersistence;
import cm.aptoide.pt.updates.UpdateRepository;
import cm.aptoide.pt.updates.UpdatesAnalytics;
import cm.aptoide.pt.updates.view.excluded.ExcludedUpdatesFragment;
import cm.aptoide.pt.updates.view.excluded.ExcludedUpdatesFragment_MembersInjector;
import cm.aptoide.pt.util.MarketResourceFormatter;
import cm.aptoide.pt.utils.FileUtils;
import cm.aptoide.pt.utils.q.QManager;
import cm.aptoide.pt.view.ActivityComponent;
import cm.aptoide.pt.view.ActivityModule;
import cm.aptoide.pt.view.ActivityModule_ProvideAccountNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideAccountPermissionProviderFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideApkFyFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideAutoUpdateManagerFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideBottomNavigationMapperFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideBottomNavigationNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideClientSdkVersionFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideDeepLinkManagerFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideFragmentManagerFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideImagePickerNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideListStoreAppsNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideLocalVersionCodeFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideMainFragmentNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideMainPresenterFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideManageStoreNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideManageUserNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideMyAccountNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidePackageNameFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidePhotoFileGeneratorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideScreenOrientationManagerFactory;
import cm.aptoide.pt.view.ActivityModule_ProvideUriToPathResolverFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesAppCoinsInfoNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesAppNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesAppViewNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesAutoUpdateRepositoryFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesAutoUpdateServiceFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesBottomNavigationAnalyticsFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesCatappultNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesClaimPromotionsNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesDialogUtilsFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesExternalNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesListAppsMoreRepositoryFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesPromotionsNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesScreenHeightFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesScreenWidthFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesSearchNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesSocialMediaNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesThemeManagerFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesWalletInstallAnalyticsFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesWalletInstallConfigurationFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesWalletInstallManagerFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesWalletInstallNavigatorFactory;
import cm.aptoide.pt.view.ActivityModule_ProvidesWalletInstallPresenterFactory;
import cm.aptoide.pt.view.AppCoinsInfoNavigator;
import cm.aptoide.pt.view.AppCoinsInfoPresenter;
import cm.aptoide.pt.view.AppViewConfiguration;
import cm.aptoide.pt.view.BaseActivity;
import cm.aptoide.pt.view.BundleEvent;
import cm.aptoide.pt.view.DeepLinkManager;
import cm.aptoide.pt.view.FragmentComponent;
import cm.aptoide.pt.view.FragmentModule;
import cm.aptoide.pt.view.FragmentModule_EditorialListAnalyticsFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideAccountErrorMapperFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideCheckYourEmailPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideCreateUserErrorMapperFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideEarnAppCoinsListPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideEarnAppcListAnalyticsFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideEarnAppcListManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideEarnAppcNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideHomeFragmentNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideImagePickerPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideImageValidatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideLoginSignUpPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideManageStoreErrorMapperFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideManageStorePresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideManageUserPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideSearchResultPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvideSendMagicLinkPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesAppCoinsInfoPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesAppMapperFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesAppViewConfigurationFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesAppViewManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesAppViewModelManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesAppViewPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesAppcPromotionNotificationStringProviderFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesAppsManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesAppsNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesAppsPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesAutoUpdateDialogPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesBundleEventFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesCheckYourEmailNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesClaimPromotionDialogPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesClaimPromotionsManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesDarkthemeDialogPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesDownloadDialogManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesDownloadNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesDownloadViewActionPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesEditorialAnalyticsFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesEditorialListManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesEditorialListNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesEditorialListPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesEditorialListRepositoryFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesEditorialManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesEditorialNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesEditorialPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesEditorialRepositoryFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesEditorialServiceFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesFlagManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesFlagServiceFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesGetStoreManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesGetStoreWidgetsPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesHomeAnalyticsFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesHomeContainerNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesHomeContainerPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesHomeFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesHomeNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesHomePresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesListAppsConfigurationFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesListAppsMoreConfigurationFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesListAppsMoreManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesListAppsMorePresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesLoginSignUpCredentialsConfigurationFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesMyStoreNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesMyStorePresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesOutOfSpaceDialogPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesOutOfSpaceManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesOutOfSpaceNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesPromotionsPresenterFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesRewardAppCoinsAppsRepositoryFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesSearchManagerFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesSendMagicLinkNavigatorFactory;
import cm.aptoide.pt.view.FragmentModule_ProvidesWizardPresenterFactory;
import cm.aptoide.pt.view.MainActivity;
import cm.aptoide.pt.view.MainActivity_MembersInjector;
import cm.aptoide.pt.view.ThemedActivityView;
import cm.aptoide.pt.view.ThemedActivityView_MembersInjector;
import cm.aptoide.pt.view.app.AppCenter;
import cm.aptoide.pt.view.app.AppCenterRepository;
import cm.aptoide.pt.view.app.AppService;
import cm.aptoide.pt.view.app.ListStoreAppsFragment;
import cm.aptoide.pt.view.app.ListStoreAppsFragment_MembersInjector;
import cm.aptoide.pt.view.app.ListStoreAppsNavigator;
import cm.aptoide.pt.view.dialog.DialogUtils;
import cm.aptoide.pt.view.feedback.SendFeedbackFragment;
import cm.aptoide.pt.view.feedback.SendFeedbackFragment_MembersInjector;
import cm.aptoide.pt.view.fragment.BaseBottomSheetDialogFragment;
import cm.aptoide.pt.view.fragment.BaseDialogFragment;
import cm.aptoide.pt.view.fragment.BaseDialogFragment_MembersInjector;
import cm.aptoide.pt.view.fragment.DescriptionFragment;
import cm.aptoide.pt.view.fragment.DescriptionFragment_MembersInjector;
import cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment;
import cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment_MembersInjector;
import cm.aptoide.pt.view.settings.MyAccountFragment;
import cm.aptoide.pt.view.settings.MyAccountFragment_MembersInjector;
import cm.aptoide.pt.view.settings.MyAccountNavigator;
import cm.aptoide.pt.view.settings.SettingsFragment;
import cm.aptoide.pt.view.settings.SettingsFragment_MembersInjector;
import cm.aptoide.pt.view.settings.SupportEmailProvider;
import cm.aptoide.pt.view.wizard.WizardFragment;
import cm.aptoide.pt.view.wizard.WizardFragmentProvider;
import cm.aptoide.pt.view.wizard.WizardFragment_MembersInjector;
import cm.aptoide.pt.view.wizard.WizardPageTwoFragment;
import cm.aptoide.pt.view.wizard.WizardPageTwoFragment_MembersInjector;
import cm.aptoide.pt.view.wizard.WizardPresenter;
import cm.aptoide.pt.wallet.WalletAppProvider;
import cm.aptoide.pt.wallet.WalletInstallActivity;
import cm.aptoide.pt.wallet.WalletInstallActivity_MembersInjector;
import cm.aptoide.pt.wallet.WalletInstallAnalytics;
import cm.aptoide.pt.wallet.WalletInstallConfiguration;
import cm.aptoide.pt.wallet.WalletInstallManager;
import cm.aptoide.pt.wallet.WalletInstallNavigator;
import cm.aptoide.pt.wallet.WalletInstallPresenter;
import com.aptoide.authenticationrx.AptoideAuthenticationRx;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
public final class DaggerApplicationComponent implements ApplicationComponent {
    private final DaggerApplicationComponent applicationComponent;
    private Provider<DownloadStatusMapper> downloadStatusMapperProvider;
    private Provider<FilePathProvider> filePathManagerProvider;
    private Provider<AccountAnalytics> provideAccountAnalyticsProvider;
    private Provider<AccountFactory> provideAccountFactoryProvider;
    private Provider<AccountManager> provideAccountManagerProvider;
    private Provider<AccountService> provideAccountServiceProvider;
    private Provider<BodyInterceptor<BaseBody>> provideAccountSettingsBodyInterceptorPoolV7Provider;
    private Provider<String> provideAccountTypeProvider;
    private Provider<AdsRepository> provideAdsRepositoryProvider;
    private Provider<AdultContentAnalytics> provideAdultContentAnalyticsProvider;
    private Provider<AdultContent> provideAdultContentProvider;
    private Provider<AndroidAccountProvider> provideAndroidAccountProvider;
    private Provider<String> provideApkPathProvider;
    private Provider<ApkfyManager> provideApkfyManagerProvider;
    private Provider<ApkfyService> provideApkfyServiceProvider;
    private Provider<com.facebook.o0.a0> provideAppEventsLoggerProvider;
    private Provider<AppSizeAnalyticsStringMapper> provideAppSizeAnalyticsStringMapperProvider;
    private Provider<AptoideAccountManager> provideAptoideAccountManagerProvider;
    private Provider<AptoideDownloadManager> provideAptoideDownloadManagerProvider;
    private Provider<OkHttpClient> provideAptoideMMpOkHttpClientProvider;
    private Provider<String> provideAptoideMmpBaseHostProvider;
    private Provider<String> provideAptoidePackageProvider;
    private Provider<AuthenticationPersistence> provideAuthenticationPersistenceProvider;
    private Provider<BodyInterceptor<BaseBody>> provideBodyInterceptorPoolV7Provider;
    private Provider<BodyInterceptor<BaseBody>> provideBodyInterceptorWebV7Provider;
    private Provider<CacheHelper> provideCacheHelperProvider;
    private Provider<String> provideCachePathProvider;
    private Provider<com.facebook.y> provideCallbackManagerProvider;
    private Provider<CampaignManager> provideCampaignManagerProvider;
    private Provider<CampaignMapper> provideCampaignMapperProvider;
    private Provider<CampaignRepository> provideCampaignRepositoryProvider;
    private Provider<ContentResolver> provideContentResolverProvider;
    private Provider<DeepLinkAnalytics> provideDeepLinkAnalyticsProvider;
    private Provider<List<String>> provideDefaultFollowedStoresProvider;
    private Provider<Installer> provideDefaultInstallerProvider;
    private Provider<Preferences> provideDefaultPreferencesProvider;
    private Provider<DownloadFactory> provideDownloadFactoryProvider;
    private Provider<DownloadPersistence> provideDownloadPersistenceProvider;
    private Provider<DownloadSpeedIntervalMapper> provideDownloadSpeedIntervalMapperProvider;
    private Provider<DownloadsRepository> provideDownloadsRepositoryProvider;
    private Provider<String> provideExtraIDProvider;
    private Provider<Collection<String>> provideFacebookEventsProvider;
    private Provider<FileUtils> provideFileUtilsProvider;
    private Provider<FirebaseAnalytics> provideFirebaseAnalyticsProvider;
    private Provider<FirebaseNotificationAnalytics> provideFirebaseNotificationAnalyticsProvider;
    private Provider<Collection<String>> provideFlurryEventsProvider;
    private Provider<Map<Integer, Result>> provideFragmentNavigatorMapProvider;
    private Provider<e.g.b.a<Map<Integer, Result>>> provideFragmentNavigatorRelayProvider;
    private Provider<GoogleApiClient> provideGoogleApiClientProvider;
    private Provider<String> provideHomePromotionsIdProvider;
    private Provider<IdsRepository> provideIdsRepositoryProvider;
    private Provider<InstallAnalytics> provideInstallAnalyticsProvider;
    private Provider<InstallationProvider> provideInstallationProvider;
    private Provider<AptoideInstalledAppsRepository> provideInstalledRepositoryProvider;
    private Provider<InvalidRefreshTokenLogoutManager> provideInvalidRefreshTokenLogoutManagerProvider;
    private Provider<L2Cache> provideL2CacheProvider;
    private Provider<LocalPersistenceAdultContent> provideLocalAdultContentProvider;
    private Provider<LoginPreferences> provideLoginPreferencesProvider;
    private Provider<OkHttpClient> provideLongTimeoutOkHttpClientProvider;
    private Provider<String> provideMarketNameProvider;
    private Provider<MarketResourceFormatter> provideMarketResourceFormatterProvider;
    private Provider<MultipartBodyInterceptor> provideMultipartBodyInterceptorProvider;
    private Provider<NavigationTracker> provideNavigationTrackerProvider;
    private Provider<BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody>> provideNoAuthenticationBodyInterceptorV3Provider;
    private Provider<ObjectMapper> provideNonNullObjectMapperProvider;
    private Provider<NotificationAnalytics> provideNotificationAnalyticsProvider;
    private Provider<NotificationProvider> provideNotificationProvider;
    private Provider<OAuthModeProvider> provideOAuthModeProvider;
    private Provider<String> provideObbPathProvider;
    private Provider<OkHttpClient> provideOkHttpClientProvider;
    private Provider<PageViewsAnalytics> providePageViewsAnalyticsProvider;
    private Provider<String> providePartnerIDProvider;
    private Provider<PermissionManager> providePermissionManagerProvider;
    private Provider<PromotionsManager> providePromotionsManagerProvider;
    private Provider<QManager> provideQManagerProvider;
    private Provider<RequestBodyFactory> provideRequestBodyFactoryProvider;
    private Provider<Resources> provideResourcesProvider;
    private Provider<Interceptor> provideRetrofitLogInterceptorProvider;
    private Provider<RoomInstalledPersistence> provideRoomInstalledPersistenceProvider;
    private Provider<RoomNotificationPersistence> provideRoomNotificationPersistenceProvider;
    private Provider<RootAvailabilityManager> provideRootAvailabilityManagerProvider;
    private Provider<RootInstallationRetryHandler> provideRootInstallationRetryHandlerProvider;
    private Provider<String> provideSearchBaseUrlProvider;
    private Provider<SecureCoderDecoder> provideSecureCoderDecoderProvider;
    private Provider<SplitTypeSubFileTypeMapper> provideSplitTypeSubFileTypeMapperProvider;
    private Provider<StoreManager> provideStoreManagerProvider;
    private Provider<StoreUtilsProxy> provideStoreUtilsProxyProvider;
    private Provider<SyncScheduler> provideSyncSchedulerProvider;
    private Provider<SyncStorage> provideSyncStorageProvider;
    private Provider<TokenInvalidator> provideTokenInvalidatorProvider;
    private Provider<Interceptor> provideUserAgentInterceptorDownloadsProvider;
    private Provider<Interceptor> provideUserAgentInterceptorProvider;
    private Provider<Interceptor> provideUserAgentInterceptorV8Provider;
    private Provider<OkHttpClient> provideV8OkHttpClientProvider;
    private Provider<WindowManager> provideWindowManagerProvider;
    private Provider<AccountPersistence> providesAccountPersistenceProvider;
    private Provider<AdMapper> providesAdMapperProvider;
    private Provider<AdsApplicationVersionCodeProvider> providesAdsApplicationVersionCodeProvider;
    private Provider<AdsManager> providesAdsManagerProvider;
    private Provider<AgentPersistence> providesAgentPersistenceProvider;
    private Provider<AnalyticsLogger> providesAnalyticsDebugLoggerProvider;
    private Provider<AnalyticsManager> providesAnalyticsManagerProvider;
    private Provider<AnalyticsEventParametersNormalizer> providesAnalyticsNormalizerProvider;
    private Provider<Retrofit> providesApiChainBDSRetrofitProvider;
    private Provider<String> providesApichainBdsBaseHostProvider;
    private Provider<AptoideApkfyService.ServiceApi> providesApkfyServiceApiProvider;
    private Provider<AppCenter> providesAppCenterProvider;
    private Provider<AppCenterRepository> providesAppCenterRepositoryProvider;
    private Provider<AppCoinsAdvertisingManager> providesAppCoinsAdvertisingManagerProvider;
    private Provider<AppCoinsManager> providesAppCoinsManagerProvider;
    private Provider<AppCoinsService> providesAppCoinsServiceProvider;
    private Provider<AppComingSoonRegistrationManager> providesAppComingSoonPreferencesManagerProvider;
    private Provider<AppComingSoonRegistrationPersistence> providesAppComingSoonRegistrationPersistenceProvider;
    private Provider<AppDownloaderProvider> providesAppDownloaderProvider;
    private Provider<AppInBackgroundTracker> providesAppInBackgroundTrackerProvider;
    private Provider<AppInstaller> providesAppInstallerProvider;
    private Provider<AppInstallerStatusReceiver> providesAppInstallerStatusReceiverProvider;
    private Provider<AppService> providesAppServiceProvider;
    private Provider<AppShortcutsAnalytics> providesAppShortcutsAnalyticsProvider;
    private Provider<AppValidationAnalytics> providesAppValidationAnalyticsProvider;
    private Provider<AppValidator> providesAppValidatorProvider;
    private Provider<AppViewAnalytics> providesAppViewAnalyticsProvider;
    private Provider<AppcMigrationPersistence> providesAppcMigrationAccessorProvider;
    private Provider<AppcMigrationManager> providesAppcMigrationManagerProvider;
    private Provider<AppcMigrationRepository> providesAppcMigrationServiceProvider;
    private Provider<String> providesAppsFlyerBaseUrlProvider;
    private Provider<AppsFlyerManager> providesAppsFlyerManagerProvider;
    private Provider<AppsFlyerRepository> providesAppsFlyerRepositoryProvider;
    private Provider<Retrofit> providesAppsFlyerRetrofitProvider;
    private Provider<AppsFlyerService> providesAppsFlyerServiceProvider;
    private Provider<AptoideAuthenticationRx> providesAptoideAuthenticationProvider;
    private Provider<AptoideDatabase> providesAptoideDataBaseProvider;
    private Provider<AptoideInstallManager> providesAptoideInstallManagerProvider;
    private Provider<AptoideInstallPersistence> providesAptoideInstallPersistenceProvider;
    private Provider<AptoideInstallRepository> providesAptoideInstallRepositoryProvider;
    private Provider<OkHttpClient.Builder> providesAptoideMMPOkHttpBuilderProvider;
    private Provider<AptoideMd5Manager> providesAptoideMd5ManagerProvider;
    private Provider<Retrofit> providesAptoideMmpRetrofitProvider;
    private Provider<Service> providesAutoUpdateServiceProvider;
    private Provider<String> providesBaseHostCacheProvider;
    private Provider<String> providesBaseRakamHostProvider;
    private Provider<String> providesBaseWebservicesHostProvider;
    private Provider<BlacklistManager> providesBlacklistManagerProvider;
    private Provider<BlacklistPersistence> providesBlacklistPersistenceProvider;
    private Provider<Blacklister> providesBlacklisterProvider;
    private Provider<BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody>> providesBodyInterceptorV3Provider;
    private Provider<BonusAppcRemoteService.ServiceApi> providesBonusAppcServiceApiProvider;
    private Provider<BonusAppcService> providesBonusAppcServiceProvider;
    private Provider<BundlesRepository> providesBundleRepositoryProvider;
    private Provider<BlacklistUnitMapper> providesBundleToBlacklistUnitMapperProvider;
    private Provider<BundlesResponseMapper> providesBundlesMapperProvider;
    private Provider<CallAdapter.Factory> providesCallAdapterFactoryProvider;
    private Provider<CampaignAnalytics> providesCampaignAnalyticsProvider;
    private Provider<CaptionBackgroundPainter> providesCaptionBackgroundPainterProvider;
    private Provider<ChipManager> providesChipManagerProvider;
    private Provider<ComingSoonNotificationManager> providesComingSoonNotificationManagerProvider;
    private Provider<ConnectivityManager> providesConnectivityManagerProvider;
    private Provider<Converter.Factory> providesConverterFactoryProvider;
    private Provider<CrashReport> providesCrashReportsProvider;
    private Provider<DatabaseStoreDataPersist> providesDatabaseStoreDataPersistProvider;
    private Provider<DecimalFormat> providesDecimalFormatProvider;
    private Provider<SharedPreferences> providesDefaultSharedPerefencesProvider;
    private Provider<DownloadAnalytics> providesDownloadAnalyticsProvider;
    private Provider<DownloadAppFileMapper> providesDownloadAppFileMapperProvider;
    private Provider<DownloadAppMapper> providesDownloadAppMapperProvider;
    private Provider<DownloadStateParser> providesDownloadStateParserProvider;
    private Provider<DownloadStatusManager> providesDownloadStatusManagerProvider;
    private Provider<DynamicSplitsRemoteService.DynamicSplitsApi> providesDynamicSplitsApiProvider;
    private Provider<DynamicSplitsManager> providesDynamicSplitsManagerProvider;
    private Provider<DynamicSplitsMapper> providesDynamicSplitsMapperProvider;
    private Provider<DynamicSplitsService> providesDynamicSplitsServiceProvider;
    private Provider<EditorialService> providesEditorialServiceProvider;
    private Provider<EventLogger> providesFacebookEventLoggerProvider;
    private Provider<List<String>> providesFacebookLoginPermissionsProvider;
    private Provider<FileDownloaderProvider> providesFileDownloaderProvider;
    private Provider<FileManager> providesFileManagerProvider;
    private Provider<EventLogger> providesFirebaseEventLoggerProvider;
    private Provider<Collection<String>> providesFirebaseEventsProvider;
    private Provider<FirstLaunchAnalytics> providesFirstLaunchAnalyticsProvider;
    private Provider<FirstLaunchManager> providesFirstLaunchManagerProvider;
    private Provider<EventLogger> providesFlurryEventLoggerProvider;
    private Provider<FlurryEventLogger> providesFlurryLoggerProvider;
    private Provider<SessionLogger> providesFlurrySessionLoggerProvider;
    private Provider<FollowedStoresManager> providesFollowedStoresManagerProvider;
    private Provider<ForegroundManager> providesForegroundManagerProvider;
    private Provider<GmsStatusValueProvider> providesGmsStatusValueProvider;
    private Provider<ImageInfoProvider> providesImageInfoProvider;
    private Provider<EventLogger> providesIndicativeEventLoggerProvider;
    private Provider<Collection<String>> providesIndicativeEventsProvider;
    private Provider<InstallAppSizeValidator> providesInstallAppSizeValidatorProvider;
    private Provider<InstallManager> providesInstallManagerProvider;
    private Provider<RoomInstallationPersistence> providesInstallationAccessorProvider;
    private Provider<InstallerAnalytics> providesInstallerAnalyticsProvider;
    private Provider<LaunchManager> providesLaunchManagerProvider;
    private Provider<Retrofit> providesLoadTopReactionsRetrofitProvider;
    private Provider<LocalNotificationSyncManager> providesLocalNotificationSyncManagerProvider;
    private Provider<LoginSignupManager> providesLoginSignupManagerProvider;
    private Provider<MapToJsonMapper> providesMapToJsonMapperProvider;
    private Provider<Md5Comparator> providesMd5ComparatorProvider;
    private Provider<MoPubAdsManager> providesMoPubAdsManagerProvider;
    private Provider<MyAccountManager> providesMyAccountManagerProvider;
    private Provider<NetworkOperatorManager> providesNetworkOperatorManagerProvider;
    private Provider<NewFeatureManager> providesNewFeatureManagerProvider;
    private Provider<NewFeature> providesNewFeatureProvider;
    private Provider<NewsletterManager> providesNewsletterManagerProvider;
    private Provider<OemidProvider> providesOemidProvider;
    private Provider<OkHttpClient.Builder> providesOkHttpBuilderProvider;
    private Provider<PackageRepository> providesPackageRepositoryProvider;
    private Provider<PromotionViewAppMapper> providesPromotionViewAppMapperProvider;
    private Provider<PromotionsAnalytics> providesPromotionsAnalyticsProvider;
    private Provider<PromotionsPreferencesManager> providesPromotionsPreferencesManagerProvider;
    private Provider<PromotionsService> providesPromotionsServiceProvider;
    private Provider<EventLogger> providesRakamEventLoggerProvider;
    private Provider<Collection<String>> providesRakamEventsProvider;
    private Provider<String> providesReactionsHostProvider;
    private Provider<ReactionsManager> providesReactionsManagerProvider;
    private Provider<ReactionsService> providesReactionsServiceProvider;
    private Provider<ReactionsRemoteService.ServiceV8> providesReactionsServiceV8Provider;
    private Provider<ReadyToInstallNotificationManager> providesReadyToInstallNotificationManagerProvider;
    private Provider<BundleDataSource> providesRemoteBundleDataSourceProvider;
    private Provider<RetryFileDownloaderProvider> providesRetryFileDownloaderProvider;
    private Provider<ReviewsManager> providesReviewsManagerProvider;
    private Provider<ReviewsRepository> providesReviewsRepositoryProvider;
    private Provider<ReviewsService> providesReviewsServiceProvider;
    private Provider<RoomInstallationMapper> providesRoomInstallationMapperProvider;
    private Provider<RoomLocalNotificationSyncPersistence> providesRoomLocalNotificationSyncPersistenceProvider;
    private Provider<RoomMigrationProvider> providesRoomMigrationProvider;
    private Provider<RoomStoredMinimalAdPersistence> providesRoomStoreMinimalAdPersistenceProvider;
    private Provider<RoomStoreRepository> providesRoomStoreRepositoryProvider;
    private Provider<RootInstallerProvider> providesRootInstallerProvider;
    private Provider<SafetyNetClient> providesSafetyNetClientProvider;
    private Provider<SearchAnalytics> providesSearchAnalyticsProvider;
    private Provider<SearchRepository> providesSearchRepositoryProvider;
    private Provider<SearchSuggestionManager> providesSearchSuggestionManagerProvider;
    private Provider<SearchSuggestionRemoteRepository> providesSearchSuggestionRemoteRepositoryProvider;
    private Provider<Retrofit> providesSearchSuggestionsRetrofitProvider;
    private Provider<SecurePreferences> providesSecurePerefencesProvider;
    private Provider<SharedPreferences> providesSecureSharedPreferencesProvider;
    private Provider<SettingsManager> providesSettingsManagerProvider;
    private Provider<AptoideShortcutManager> providesShortcutManagerProvider;
    private Provider<SocialMediaAnalytics> providesSocialMediaAnalyticsProvider;
    private Provider<SplitsMapper> providesSplitsMapperProvider;
    private Provider<StoreAnalytics> providesStoreAnalyticsProvider;
    private Provider<StoreCredentialsProvider> providesStoreCredentialsProvider;
    private Provider<StorePersistence> providesStorePersistenceProvider;
    private Provider<String> providesSupportEmailProvider;
    private Provider<SupportEmailProvider> providesSupportEmailProvider2;
    private Provider<TelephonyManager> providesTelephonyManagerProvider;
    private Provider<ThemeAnalytics> providesThemeAnalyticsProvider;
    private Provider<TrendingManager> providesTrendingManagerProvider;
    private Provider<TrendingService> providesTrendingServiceProvider;
    private Provider<UpdateLaunchManager> providesUpdateLaunchManagerProvider;
    private Provider<UpdateMapper> providesUpdateMapperProvider;
    private Provider<UpdatePersistence> providesUpdatePersistenceProvider;
    private Provider<UpdateRepository> providesUpdateRepositoryProvider;
    private Provider<UpdatesAnalytics> providesUpdatesAnalyticsProvider;
    private Provider<UpdatesManager> providesUpdatesManagerProvider;
    private Provider<UpdatesNotificationManager> providesUpdatesNotificationManagerProvider;
    private Provider<AptoideWorkerFactory> providesUpdatesNotificationWorkerFactoryProvider;
    private Provider<UserFeedbackAnalytics> providesUserFeedbackAnalyticsProvider;
    private Provider<PreferencesPersister> providesUserPreferencesPersisterProvider;
    private Provider<Retrofit> providesV7CacheRetrofitProvider;
    private Provider<WalletAdsOfferCardManager> providesWalletAdsOfferCardManagerProvider;
    private Provider<WalletAdsOfferManager> providesWalletAdsOfferManagerProvider;
    private Provider<WalletAppProvider> providesWalletAppProvider;
    private Provider<HttpKnockEventLogger> providesknockEventLoggerProvider;
    private Provider<SplitAnalyticsMapper> splitAnalyticsMapperProvider;

    private static final class ActivityComponentImpl implements ActivityComponent {
        private final ActivityComponentImpl activityComponentImpl;
        private final DaggerApplicationComponent applicationComponent;
        private Provider<AccountNavigator> provideAccountNavigatorProvider;
        private Provider<AccountPermissionProvider> provideAccountPermissionProvider;
        private Provider<ApkFyParser> provideApkFyProvider;
        private Provider<AutoUpdateManager> provideAutoUpdateManagerProvider;
        private Provider<BottomNavigationMapper> provideBottomNavigationMapperProvider;
        private Provider<BottomNavigationNavigator> provideBottomNavigationNavigatorProvider;
        private Provider<Integer> provideClientSdkVersionProvider;
        private Provider<DeepLinkManager> provideDeepLinkManagerProvider;
        private Provider<FragmentManager> provideFragmentManagerProvider;
        private Provider<ImagePickerNavigator> provideImagePickerNavigatorProvider;
        private Provider<ListStoreAppsNavigator> provideListStoreAppsNavigatorProvider;
        private Provider<Integer> provideLocalVersionCodeProvider;
        private Provider<FragmentNavigator> provideMainFragmentNavigatorProvider;
        private Provider<Presenter> provideMainPresenterProvider;
        private Provider<ManageStoreNavigator> provideManageStoreNavigatorProvider;
        private Provider<ManageUserNavigator> provideManageUserNavigatorProvider;
        private Provider<MyAccountNavigator> provideMyAccountNavigatorProvider;
        private Provider<String> providePackageNameProvider;
        private Provider<PhotoFileGenerator> providePhotoFileGeneratorProvider;
        private Provider<ScreenOrientationManager> provideScreenOrientationManagerProvider;
        private Provider<UriToPathResolver> provideUriToPathResolverProvider;
        private Provider<AppCoinsInfoNavigator> providesAppCoinsInfoNavigatorProvider;
        private Provider<AppNavigator> providesAppNavigatorProvider;
        private Provider<AppViewNavigator> providesAppViewNavigatorProvider;
        private Provider<AutoUpdateRepository> providesAutoUpdateRepositoryProvider;
        private Provider<AutoUpdateService> providesAutoUpdateServiceProvider;
        private Provider<BottomNavigationAnalytics> providesBottomNavigationAnalyticsProvider;
        private Provider<CatappultNavigator> providesCatappultNavigatorProvider;
        private Provider<ClaimPromotionsNavigator> providesClaimPromotionsNavigatorProvider;
        private Provider<DialogUtils> providesDialogUtilsProvider;
        private Provider<ExternalNavigator> providesExternalNavigatorProvider;
        private Provider<ListAppsMoreRepository> providesListAppsMoreRepositoryProvider;
        private Provider<PromotionsNavigator> providesPromotionsNavigatorProvider;
        private Provider<Float> providesScreenHeightProvider;
        private Provider<Float> providesScreenWidthProvider;
        private Provider<SearchNavigator> providesSearchNavigatorProvider;
        private Provider<SocialMediaNavigator> providesSocialMediaNavigatorProvider;
        private Provider<ThemeManager> providesThemeManagerProvider;
        private Provider<WalletInstallAnalytics> providesWalletInstallAnalyticsProvider;
        private Provider<WalletInstallConfiguration> providesWalletInstallConfigurationProvider;
        private Provider<WalletInstallManager> providesWalletInstallManagerProvider;
        private Provider<WalletInstallNavigator> providesWalletInstallNavigatorProvider;
        private Provider<WalletInstallPresenter> providesWalletInstallPresenterProvider;

        private void initialize(ActivityModule activityModule, FlavourActivityModule flavourActivityModule) {
            this.providesThemeManagerProvider = f.b.a.a(ActivityModule_ProvidesThemeManagerFactory.create(activityModule));
            this.provideFragmentManagerProvider = f.b.a.a(ActivityModule_ProvideFragmentManagerFactory.create(activityModule));
            this.provideMainFragmentNavigatorProvider = f.b.a.a(ActivityModule_ProvideMainFragmentNavigatorFactory.create(activityModule, this.applicationComponent.provideFragmentNavigatorMapProvider, this.applicationComponent.provideFragmentNavigatorRelayProvider, this.provideFragmentManagerProvider));
            Provider<BottomNavigationAnalytics> providerA = f.b.a.a(ActivityModule_ProvidesBottomNavigationAnalyticsFactory.create(activityModule, this.applicationComponent.providesAnalyticsManagerProvider, this.applicationComponent.provideNavigationTrackerProvider));
            this.providesBottomNavigationAnalyticsProvider = providerA;
            this.provideBottomNavigationNavigatorProvider = f.b.a.a(ActivityModule_ProvideBottomNavigationNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider, providerA, this.applicationComponent.providesSearchAnalyticsProvider, this.providesThemeManagerProvider));
            this.provideAccountNavigatorProvider = f.b.a.a(ActivityModule_ProvideAccountNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider, this.applicationComponent.provideAptoideAccountManagerProvider, this.applicationComponent.provideCallbackManagerProvider, this.applicationComponent.provideGoogleApiClientProvider, this.applicationComponent.provideAccountAnalyticsProvider, this.provideBottomNavigationNavigatorProvider, this.providesThemeManagerProvider));
            this.provideBottomNavigationMapperProvider = f.b.a.a(ActivityModule_ProvideBottomNavigationMapperFactory.create(activityModule));
            this.provideApkFyProvider = f.b.a.a(ActivityModule_ProvideApkFyFactory.create(activityModule, this.applicationComponent.providesSecureSharedPreferencesProvider, this.applicationComponent.provideApkfyManagerProvider, this.applicationComponent.providesFirstLaunchAnalyticsProvider));
            Provider<AppNavigator> providerA2 = f.b.a.a(ActivityModule_ProvidesAppNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider));
            this.providesAppNavigatorProvider = providerA2;
            this.providesSearchNavigatorProvider = f.b.a.a(ActivityModule_ProvidesSearchNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider, providerA2));
            this.provideDeepLinkManagerProvider = f.b.a.a(ActivityModule_ProvideDeepLinkManagerFactory.create(activityModule, this.applicationComponent.provideStoreUtilsProxyProvider, this.provideMainFragmentNavigatorProvider, this.provideBottomNavigationNavigatorProvider, this.providesSearchNavigatorProvider, this.applicationComponent.providesDefaultSharedPerefencesProvider, this.applicationComponent.providesRoomStoreRepositoryProvider, this.applicationComponent.provideNavigationTrackerProvider, this.applicationComponent.providesSearchAnalyticsProvider, this.applicationComponent.provideDeepLinkAnalyticsProvider, this.applicationComponent.providesAppShortcutsAnalyticsProvider, this.applicationComponent.provideAptoideAccountManagerProvider, this.applicationComponent.providesStoreAnalyticsProvider, this.applicationComponent.provideAdsRepositoryProvider, this.providesAppNavigatorProvider, this.applicationComponent.providesInstallManagerProvider, this.applicationComponent.providesNewFeatureProvider, this.providesThemeManagerProvider, this.applicationComponent.providesThemeAnalyticsProvider, this.applicationComponent.providesReadyToInstallNotificationManagerProvider));
            Provider<String> providerA3 = f.b.a.a(ActivityModule_ProvidePackageNameFactory.create(activityModule));
            this.providePackageNameProvider = providerA3;
            this.provideLocalVersionCodeProvider = f.b.a.a(ActivityModule_ProvideLocalVersionCodeFactory.create(activityModule, providerA3));
            this.provideClientSdkVersionProvider = f.b.a.a(ActivityModule_ProvideClientSdkVersionFactory.create(activityModule));
            Provider<AutoUpdateService> providerA4 = f.b.a.a(ActivityModule_ProvidesAutoUpdateServiceFactory.create(activityModule, this.applicationComponent.providesAutoUpdateServiceProvider, this.providePackageNameProvider, this.provideClientSdkVersionProvider));
            this.providesAutoUpdateServiceProvider = providerA4;
            this.providesAutoUpdateRepositoryProvider = f.b.a.a(ActivityModule_ProvidesAutoUpdateRepositoryFactory.create(activityModule, providerA4));
            this.provideAutoUpdateManagerProvider = f.b.a.a(ActivityModule_ProvideAutoUpdateManagerFactory.create(activityModule, this.applicationComponent.provideDownloadFactoryProvider, this.applicationComponent.providePermissionManagerProvider, this.applicationComponent.providesInstallManagerProvider, this.applicationComponent.providesDownloadAnalyticsProvider, this.provideLocalVersionCodeProvider, this.providesAutoUpdateRepositoryProvider));
            this.provideMainPresenterProvider = f.b.a.a(ActivityModule_ProvideMainPresenterFactory.create(activityModule, this.applicationComponent.provideRootInstallationRetryHandlerProvider, this.provideApkFyProvider, this.applicationComponent.providesInstallManagerProvider, this.applicationComponent.providesDefaultSharedPerefencesProvider, this.applicationComponent.providesSecureSharedPreferencesProvider, this.provideMainFragmentNavigatorProvider, this.provideDeepLinkManagerProvider, this.provideBottomNavigationNavigatorProvider, this.applicationComponent.providesUpdatesManagerProvider, this.provideAutoUpdateManagerProvider, this.applicationComponent.provideRootAvailabilityManagerProvider, this.provideBottomNavigationMapperProvider, this.applicationComponent.provideAptoideAccountManagerProvider, this.provideAccountNavigatorProvider, this.applicationComponent.providesAgentPersistenceProvider));
            this.providesWalletInstallConfigurationProvider = f.b.a.a(ActivityModule_ProvidesWalletInstallConfigurationFactory.create(activityModule));
            this.providesWalletInstallNavigatorProvider = f.b.a.a(ActivityModule_ProvidesWalletInstallNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider));
            this.providesWalletInstallAnalyticsProvider = f.b.a.a(ActivityModule_ProvidesWalletInstallAnalyticsFactory.create(activityModule, this.applicationComponent.providesDownloadAnalyticsProvider, this.applicationComponent.provideNotificationAnalyticsProvider, this.applicationComponent.provideInstallAnalyticsProvider, this.applicationComponent.providesDownloadStateParserProvider, this.applicationComponent.providesAnalyticsManagerProvider, this.applicationComponent.provideNavigationTrackerProvider, this.applicationComponent.splitAnalyticsMapperProvider));
            Provider<WalletInstallManager> providerA5 = f.b.a.a(ActivityModule_ProvidesWalletInstallManagerFactory.create(activityModule, this.applicationComponent.providesInstallManagerProvider, this.applicationComponent.provideDownloadFactoryProvider, this.applicationComponent.providesDownloadStateParserProvider, this.applicationComponent.providesMoPubAdsManagerProvider, this.providesWalletInstallAnalyticsProvider, this.applicationComponent.provideInstalledRepositoryProvider, this.applicationComponent.providesWalletAppProvider, this.applicationComponent.providesAppInstallerStatusReceiverProvider, this.applicationComponent.providesDynamicSplitsManagerProvider));
            this.providesWalletInstallManagerProvider = providerA5;
            this.providesWalletInstallPresenterProvider = f.b.a.a(ActivityModule_ProvidesWalletInstallPresenterFactory.create(activityModule, this.providesWalletInstallConfigurationProvider, this.providesWalletInstallNavigatorProvider, providerA5, this.providesWalletInstallAnalyticsProvider, this.applicationComponent.providesMoPubAdsManagerProvider));
            this.provideScreenOrientationManagerProvider = f.b.a.a(ActivityModule_ProvideScreenOrientationManagerFactory.create(activityModule));
            this.provideAccountPermissionProvider = f.b.a.a(ActivityModule_ProvideAccountPermissionProviderFactory.create(activityModule));
            this.providePhotoFileGeneratorProvider = f.b.a.a(ActivityModule_ProvidePhotoFileGeneratorFactory.create(activityModule));
            this.provideUriToPathResolverProvider = f.b.a.a(ActivityModule_ProvideUriToPathResolverFactory.create(activityModule));
            this.provideImagePickerNavigatorProvider = f.b.a.a(ActivityModule_ProvideImagePickerNavigatorFactory.create(activityModule));
            this.provideManageUserNavigatorProvider = f.b.a.a(ActivityModule_ProvideManageUserNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider, this.provideBottomNavigationNavigatorProvider));
            this.provideManageStoreNavigatorProvider = f.b.a.a(ActivityModule_ProvideManageStoreNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider, this.provideBottomNavigationNavigatorProvider));
            this.provideListStoreAppsNavigatorProvider = f.b.a.a(ActivityModule_ProvideListStoreAppsNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider, this.providesAppNavigatorProvider));
            Provider<ExternalNavigator> providerA6 = f.b.a.a(ActivityModule_ProvidesExternalNavigatorFactory.create(activityModule, this.providesThemeManagerProvider));
            this.providesExternalNavigatorProvider = providerA6;
            Provider<SocialMediaNavigator> providerA7 = f.b.a.a(ActivityModule_ProvidesSocialMediaNavigatorFactory.create(activityModule, providerA6));
            this.providesSocialMediaNavigatorProvider = providerA7;
            this.provideMyAccountNavigatorProvider = f.b.a.a(ActivityModule_ProvideMyAccountNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider, this.provideAccountNavigatorProvider, this.providesAppNavigatorProvider, this.providesThemeManagerProvider, providerA7));
            Provider<CatappultNavigator> providerA8 = f.b.a.a(ActivityModule_ProvidesCatappultNavigatorFactory.create(activityModule, this.providesExternalNavigatorProvider));
            this.providesCatappultNavigatorProvider = providerA8;
            this.providesAppViewNavigatorProvider = f.b.a.a(ActivityModule_ProvidesAppViewNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider, this.providesAppNavigatorProvider, providerA8));
            this.providesPromotionsNavigatorProvider = f.b.a.a(ActivityModule_ProvidesPromotionsNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider, this.providesAppNavigatorProvider));
            this.providesDialogUtilsProvider = f.b.a.a(ActivityModule_ProvidesDialogUtilsFactory.create(activityModule, this.applicationComponent.provideAptoideAccountManagerProvider, this.provideAccountNavigatorProvider, this.applicationComponent.provideAccountSettingsBodyInterceptorPoolV7Provider, this.applicationComponent.provideOkHttpClientProvider, this.applicationComponent.providesConverterFactoryProvider, this.applicationComponent.provideInstalledRepositoryProvider, this.applicationComponent.provideTokenInvalidatorProvider, this.applicationComponent.providesDefaultSharedPerefencesProvider, this.applicationComponent.provideMarketResourceFormatterProvider, this.providesThemeManagerProvider, this.applicationComponent.providesUserFeedbackAnalyticsProvider));
            this.providesAppCoinsInfoNavigatorProvider = f.b.a.a(ActivityModule_ProvidesAppCoinsInfoNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider, this.providesSocialMediaNavigatorProvider, this.providesCatappultNavigatorProvider));
            this.providesScreenWidthProvider = f.b.a.a(ActivityModule_ProvidesScreenWidthFactory.create(activityModule, this.applicationComponent.provideResourcesProvider));
            this.providesScreenHeightProvider = f.b.a.a(ActivityModule_ProvidesScreenHeightFactory.create(activityModule, this.applicationComponent.provideResourcesProvider));
            this.providesClaimPromotionsNavigatorProvider = f.b.a.a(ActivityModule_ProvidesClaimPromotionsNavigatorFactory.create(activityModule, this.provideMainFragmentNavigatorProvider, this.providesAppNavigatorProvider));
            this.providesListAppsMoreRepositoryProvider = f.b.a.a(ActivityModule_ProvidesListAppsMoreRepositoryFactory.create(activityModule, this.applicationComponent.providesStoreCredentialsProvider, this.applicationComponent.provideOkHttpClientProvider, this.applicationComponent.provideAccountSettingsBodyInterceptorPoolV7Provider, this.applicationComponent.provideTokenInvalidatorProvider, this.applicationComponent.providesDefaultSharedPerefencesProvider, this.applicationComponent.providesConverterFactoryProvider));
        }

        private ActivityResultNavigator injectActivityResultNavigator(ActivityResultNavigator activityResultNavigator) {
            ActivityResultNavigator_MembersInjector.injectThemeManager(activityResultNavigator, this.providesThemeManagerProvider.get());
            ActivityResultNavigator_MembersInjector.injectAccountNavigator(activityResultNavigator, this.provideAccountNavigatorProvider.get());
            ActivityResultNavigator_MembersInjector.injectMarketName(activityResultNavigator, (String) this.applicationComponent.provideMarketNameProvider.get());
            return activityResultNavigator;
        }

        private AnalyticsActivity injectAnalyticsActivity(AnalyticsActivity analyticsActivity) {
            ActivityResultNavigator_MembersInjector.injectThemeManager(analyticsActivity, this.providesThemeManagerProvider.get());
            ActivityResultNavigator_MembersInjector.injectAccountNavigator(analyticsActivity, this.provideAccountNavigatorProvider.get());
            ActivityResultNavigator_MembersInjector.injectMarketName(analyticsActivity, (String) this.applicationComponent.provideMarketNameProvider.get());
            AnalyticsActivity_MembersInjector.injectAnalyticsManager(analyticsActivity, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(analyticsActivity, (FirstLaunchAnalytics) this.applicationComponent.providesFirstLaunchAnalyticsProvider.get());
            return analyticsActivity;
        }

        private BaseDialogFragment injectBaseDialogFragment(BaseDialogFragment baseDialogFragment) {
            BaseDialogFragment_MembersInjector.injectThemeManager(baseDialogFragment, this.providesThemeManagerProvider.get());
            return baseDialogFragment;
        }

        private BottomNavigationActivity injectBottomNavigationActivity(BottomNavigationActivity bottomNavigationActivity) {
            ActivityResultNavigator_MembersInjector.injectThemeManager(bottomNavigationActivity, this.providesThemeManagerProvider.get());
            ActivityResultNavigator_MembersInjector.injectAccountNavigator(bottomNavigationActivity, this.provideAccountNavigatorProvider.get());
            ActivityResultNavigator_MembersInjector.injectMarketName(bottomNavigationActivity, (String) this.applicationComponent.provideMarketNameProvider.get());
            AnalyticsActivity_MembersInjector.injectAnalyticsManager(bottomNavigationActivity, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(bottomNavigationActivity, (FirstLaunchAnalytics) this.applicationComponent.providesFirstLaunchAnalyticsProvider.get());
            ThemedActivityView_MembersInjector.injectThemeManager(bottomNavigationActivity, this.providesThemeManagerProvider.get());
            BottomNavigationActivity_MembersInjector.injectBottomNavigationMapper(bottomNavigationActivity, this.provideBottomNavigationMapperProvider.get());
            BottomNavigationActivity_MembersInjector.injectBottomNavigationNavigator(bottomNavigationActivity, this.provideBottomNavigationNavigatorProvider.get());
            return bottomNavigationActivity;
        }

        private MainActivity injectMainActivity(MainActivity mainActivity) {
            ActivityResultNavigator_MembersInjector.injectThemeManager(mainActivity, this.providesThemeManagerProvider.get());
            ActivityResultNavigator_MembersInjector.injectAccountNavigator(mainActivity, this.provideAccountNavigatorProvider.get());
            ActivityResultNavigator_MembersInjector.injectMarketName(mainActivity, (String) this.applicationComponent.provideMarketNameProvider.get());
            AnalyticsActivity_MembersInjector.injectAnalyticsManager(mainActivity, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(mainActivity, (FirstLaunchAnalytics) this.applicationComponent.providesFirstLaunchAnalyticsProvider.get());
            ThemedActivityView_MembersInjector.injectThemeManager(mainActivity, this.providesThemeManagerProvider.get());
            BottomNavigationActivity_MembersInjector.injectBottomNavigationMapper(mainActivity, this.provideBottomNavigationMapperProvider.get());
            BottomNavigationActivity_MembersInjector.injectBottomNavigationNavigator(mainActivity, this.provideBottomNavigationNavigatorProvider.get());
            MainActivity_MembersInjector.injectPresenter(mainActivity, this.provideMainPresenterProvider.get());
            MainActivity_MembersInjector.injectResources(mainActivity, (Resources) this.applicationComponent.provideResourcesProvider.get());
            MainActivity_MembersInjector.injectMarketResourceFormatter(mainActivity, (MarketResourceFormatter) this.applicationComponent.provideMarketResourceFormatterProvider.get());
            MainActivity_MembersInjector.injectThemeAnalytics(mainActivity, (ThemeAnalytics) this.applicationComponent.providesThemeAnalyticsProvider.get());
            MainActivity_MembersInjector.injectDeepLinkManager(mainActivity, this.provideDeepLinkManagerProvider.get());
            MainActivity_MembersInjector.injectFirebaseNotificationAnalytics(mainActivity, (FirebaseNotificationAnalytics) this.applicationComponent.provideFirebaseNotificationAnalyticsProvider.get());
            return mainActivity;
        }

        private SettingsFragment injectSettingsFragment(SettingsFragment settingsFragment) {
            SettingsFragment_MembersInjector.injectMarketName(settingsFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            SettingsFragment_MembersInjector.injectMarketResourceFormatter(settingsFragment, (MarketResourceFormatter) this.applicationComponent.provideMarketResourceFormatterProvider.get());
            SettingsFragment_MembersInjector.injectSupportEmailProvider(settingsFragment, (SupportEmailProvider) this.applicationComponent.providesSupportEmailProvider2.get());
            SettingsFragment_MembersInjector.injectThemeManager(settingsFragment, this.providesThemeManagerProvider.get());
            SettingsFragment_MembersInjector.injectThemeAnalytics(settingsFragment, (ThemeAnalytics) this.applicationComponent.providesThemeAnalyticsProvider.get());
            SettingsFragment_MembersInjector.injectUpdatesRepository(settingsFragment, (UpdateRepository) this.applicationComponent.providesUpdateRepositoryProvider.get());
            SettingsFragment_MembersInjector.injectFileManager(settingsFragment, (FileManager) this.applicationComponent.providesFileManagerProvider.get());
            return settingsFragment;
        }

        private StoreTabGridRecyclerFragment injectStoreTabGridRecyclerFragment(StoreTabGridRecyclerFragment storeTabGridRecyclerFragment) {
            StoreTabGridRecyclerFragment_MembersInjector.injectStoreRepository(storeTabGridRecyclerFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(storeTabGridRecyclerFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            return storeTabGridRecyclerFragment;
        }

        private ThemedActivityView injectThemedActivityView(ThemedActivityView themedActivityView) {
            ActivityResultNavigator_MembersInjector.injectThemeManager(themedActivityView, this.providesThemeManagerProvider.get());
            ActivityResultNavigator_MembersInjector.injectAccountNavigator(themedActivityView, this.provideAccountNavigatorProvider.get());
            ActivityResultNavigator_MembersInjector.injectMarketName(themedActivityView, (String) this.applicationComponent.provideMarketNameProvider.get());
            AnalyticsActivity_MembersInjector.injectAnalyticsManager(themedActivityView, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(themedActivityView, (FirstLaunchAnalytics) this.applicationComponent.providesFirstLaunchAnalyticsProvider.get());
            ThemedActivityView_MembersInjector.injectThemeManager(themedActivityView, this.providesThemeManagerProvider.get());
            return themedActivityView;
        }

        private WalletInstallActivity injectWalletInstallActivity(WalletInstallActivity walletInstallActivity) {
            ActivityResultNavigator_MembersInjector.injectThemeManager(walletInstallActivity, this.providesThemeManagerProvider.get());
            ActivityResultNavigator_MembersInjector.injectAccountNavigator(walletInstallActivity, this.provideAccountNavigatorProvider.get());
            ActivityResultNavigator_MembersInjector.injectMarketName(walletInstallActivity, (String) this.applicationComponent.provideMarketNameProvider.get());
            AnalyticsActivity_MembersInjector.injectAnalyticsManager(walletInstallActivity, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(walletInstallActivity, (FirstLaunchAnalytics) this.applicationComponent.providesFirstLaunchAnalyticsProvider.get());
            WalletInstallActivity_MembersInjector.injectPresenter(walletInstallActivity, this.providesWalletInstallPresenterProvider.get());
            return walletInstallActivity;
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(BaseActivity baseActivity) {
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(MainActivity mainActivity) {
            injectMainActivity(mainActivity);
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(DialogUtils dialogUtils) {
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(BaseBottomSheetDialogFragment baseBottomSheetDialogFragment) {
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public FragmentComponent plus(FragmentModule fragmentModule, FlavourFragmentModule flavourFragmentModule) {
            f.b.b.b(fragmentModule);
            f.b.b.b(flavourFragmentModule);
            return new FragmentComponentImpl(this.activityComponentImpl, fragmentModule, flavourFragmentModule);
        }

        private ActivityComponentImpl(DaggerApplicationComponent daggerApplicationComponent, ActivityModule activityModule, FlavourActivityModule flavourActivityModule) {
            this.activityComponentImpl = this;
            this.applicationComponent = daggerApplicationComponent;
            initialize(activityModule, flavourActivityModule);
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(ThemedActivityView themedActivityView) {
            injectThemedActivityView(themedActivityView);
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(WalletInstallActivity walletInstallActivity) {
            injectWalletInstallActivity(walletInstallActivity);
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(ActivityResultNavigator activityResultNavigator) {
            injectActivityResultNavigator(activityResultNavigator);
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(AnalyticsActivity analyticsActivity) {
            injectAnalyticsActivity(analyticsActivity);
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(BottomNavigationActivity bottomNavigationActivity) {
            injectBottomNavigationActivity(bottomNavigationActivity);
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(SettingsFragment settingsFragment) {
            injectSettingsFragment(settingsFragment);
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(StoreTabGridRecyclerFragment storeTabGridRecyclerFragment) {
            injectStoreTabGridRecyclerFragment(storeTabGridRecyclerFragment);
        }

        @Override // cm.aptoide.pt.view.ActivityComponent
        public void inject(BaseDialogFragment baseDialogFragment) {
            injectBaseDialogFragment(baseDialogFragment);
        }
    }

    public static final class Builder {
        private ApplicationModule applicationModule;
        private FlavourApplicationModule flavourApplicationModule;

        public Builder applicationModule(ApplicationModule applicationModule) {
            this.applicationModule = (ApplicationModule) f.b.b.b(applicationModule);
            return this;
        }

        public ApplicationComponent build() {
            f.b.b.a(this.applicationModule, ApplicationModule.class);
            f.b.b.a(this.flavourApplicationModule, FlavourApplicationModule.class);
            return new DaggerApplicationComponent(this.applicationModule, this.flavourApplicationModule);
        }

        public Builder flavourApplicationModule(FlavourApplicationModule flavourApplicationModule) {
            this.flavourApplicationModule = (FlavourApplicationModule) f.b.b.b(flavourApplicationModule);
            return this;
        }

        private Builder() {
        }
    }

    private static final class FragmentComponentImpl implements FragmentComponent {
        private final ActivityComponentImpl activityComponentImpl;
        private final DaggerApplicationComponent applicationComponent;
        private Provider<EditorialListAnalytics> editorialListAnalyticsProvider;
        private final FragmentComponentImpl fragmentComponentImpl;
        private Provider<AccountErrorMapper> provideAccountErrorMapperProvider;
        private Provider<CheckYourEmailPresenter> provideCheckYourEmailPresenterProvider;
        private Provider<CreateUserErrorMapper> provideCreateUserErrorMapperProvider;
        private Provider<EarnAppcListPresenter> provideEarnAppCoinsListPresenterProvider;
        private Provider<EarnAppcListAnalytics> provideEarnAppcListAnalyticsProvider;
        private Provider<EarnAppcListManager> provideEarnAppcListManagerProvider;
        private Provider<EarnAppcNavigator> provideEarnAppcNavigatorProvider;
        private Provider<FragmentNavigator> provideHomeFragmentNavigatorProvider;
        private Provider<ImagePickerPresenter> provideImagePickerPresenterProvider;
        private Provider<ImageValidator> provideImageValidatorProvider;
        private Provider<LoginSignupCredentialsFlavorPresenter> provideLoginSignUpPresenterProvider;
        private Provider<ManageStoreErrorMapper> provideManageStoreErrorMapperProvider;
        private Provider<ManageStorePresenter> provideManageStorePresenterProvider;
        private Provider<ManageUserPresenter> provideManageUserPresenterProvider;
        private Provider<SearchResultPresenter> provideSearchResultPresenterProvider;
        private Provider<SendMagicLinkPresenter> provideSendMagicLinkPresenterProvider;
        private Provider<AppCoinsInfoPresenter> providesAppCoinsInfoPresenterProvider;
        private Provider<AppMapper> providesAppMapperProvider;
        private Provider<AppViewConfiguration> providesAppViewConfigurationProvider;
        private Provider<AppViewManager> providesAppViewManagerProvider;
        private Provider<AppViewModelManager> providesAppViewModelManagerProvider;
        private Provider<AppViewPresenter> providesAppViewPresenterProvider;
        private Provider<AppcPromotionNotificationStringProvider> providesAppcPromotionNotificationStringProvider;
        private Provider<AppsManager> providesAppsManagerProvider;
        private Provider<AppsNavigator> providesAppsNavigatorProvider;
        private Provider<AppsPresenter> providesAppsPresenterProvider;
        private Provider<AutoUpdateDialogPresenter> providesAutoUpdateDialogPresenterProvider;
        private Provider<BundleEvent> providesBundleEventProvider;
        private Provider<CheckYourEmailNavigator> providesCheckYourEmailNavigatorProvider;
        private Provider<ClaimPromotionDialogPresenter> providesClaimPromotionDialogPresenterProvider;
        private Provider<ClaimPromotionsManager> providesClaimPromotionsManagerProvider;
        private Provider<NewFeatureDialogPresenter> providesDarkthemeDialogPresenterProvider;
        private Provider<DownloadDialogProvider> providesDownloadDialogManagerProvider;
        private Provider<DownloadNavigator> providesDownloadNavigatorProvider;
        private Provider<DownloadViewActionPresenter> providesDownloadViewActionPresenterProvider;
        private Provider<EditorialAnalytics> providesEditorialAnalyticsProvider;
        private Provider<EditorialListManager> providesEditorialListManagerProvider;
        private Provider<EditorialListNavigator> providesEditorialListNavigatorProvider;
        private Provider<EditorialListPresenter> providesEditorialListPresenterProvider;
        private Provider<EditorialCardListRepository> providesEditorialListRepositoryProvider;
        private Provider<EditorialManager> providesEditorialManagerProvider;
        private Provider<EditorialNavigator> providesEditorialNavigatorProvider;
        private Provider<EditorialPresenter> providesEditorialPresenterProvider;
        private Provider<EditorialRepository> providesEditorialRepositoryProvider;
        private Provider<EditorialCardListService> providesEditorialServiceProvider;
        private Provider<FlagManager> providesFlagManagerProvider;
        private Provider<FlagService> providesFlagServiceProvider;
        private Provider<MoreBundleManager> providesGetStoreManagerProvider;
        private Provider<MoreBundlePresenter> providesGetStoreWidgetsPresenterProvider;
        private Provider<HomeAnalytics> providesHomeAnalyticsProvider;
        private Provider<HomeContainerNavigator> providesHomeContainerNavigatorProvider;
        private Provider<HomeContainerPresenter> providesHomeContainerPresenterProvider;
        private Provider<HomeNavigator> providesHomeNavigatorProvider;
        private Provider<HomePresenter> providesHomePresenterProvider;
        private Provider<Home> providesHomeProvider;
        private Provider<EarnAppcListConfiguration> providesListAppsConfigurationProvider;
        private Provider<ListAppsConfiguration> providesListAppsMoreConfigurationProvider;
        private Provider<ListAppsMoreManager> providesListAppsMoreManagerProvider;
        private Provider<ListAppsMorePresenter> providesListAppsMorePresenterProvider;
        private Provider<LoginSignUpCredentialsConfiguration> providesLoginSignUpCredentialsConfigurationProvider;
        private Provider<MyStoresNavigator> providesMyStoreNavigatorProvider;
        private Provider<MyStoresPresenter> providesMyStorePresenterProvider;
        private Provider<OutOfSpaceDialogPresenter> providesOutOfSpaceDialogPresenterProvider;
        private Provider<OutOfSpaceManager> providesOutOfSpaceManagerProvider;
        private Provider<OutOfSpaceNavigator> providesOutOfSpaceNavigatorProvider;
        private Provider<PromotionsPresenter> providesPromotionsPresenterProvider;
        private Provider<RewardAppCoinsAppsRepository> providesRewardAppCoinsAppsRepositoryProvider;
        private Provider<SearchManager> providesSearchManagerProvider;
        private Provider<SendMagicLinkNavigator> providesSendMagicLinkNavigatorProvider;
        private Provider<WizardFragmentProvider> providesWizardFragmentProvider;
        private Provider<WizardPresenter> providesWizardPresenterProvider;

        private void initialize(FragmentModule fragmentModule, FlavourFragmentModule flavourFragmentModule) {
            this.provideAccountErrorMapperProvider = f.b.a.a(FragmentModule_ProvideAccountErrorMapperFactory.create(fragmentModule));
            this.providesLoginSignUpCredentialsConfigurationProvider = f.b.a.a(FragmentModule_ProvidesLoginSignUpCredentialsConfigurationFactory.create(fragmentModule));
            this.provideLoginSignUpPresenterProvider = f.b.a.a(FragmentModule_ProvideLoginSignUpPresenterFactory.create(fragmentModule, this.applicationComponent.provideAptoideAccountManagerProvider, this.activityComponentImpl.provideAccountNavigatorProvider, this.provideAccountErrorMapperProvider, this.applicationComponent.provideAccountAnalyticsProvider, this.applicationComponent.providesFacebookLoginPermissionsProvider, this.providesLoginSignUpCredentialsConfigurationProvider));
            this.providesSendMagicLinkNavigatorProvider = f.b.a.a(FragmentModule_ProvidesSendMagicLinkNavigatorFactory.create(fragmentModule, this.activityComponentImpl.provideMainFragmentNavigatorProvider, this.activityComponentImpl.providesThemeManagerProvider));
            this.provideSendMagicLinkPresenterProvider = f.b.a.a(FragmentModule_ProvideSendMagicLinkPresenterFactory.create(fragmentModule, this.applicationComponent.provideAptoideAccountManagerProvider, this.providesSendMagicLinkNavigatorProvider, this.applicationComponent.providesAgentPersistenceProvider));
            this.provideImageValidatorProvider = f.b.a.a(FragmentModule_ProvideImageValidatorFactory.create(fragmentModule, this.applicationComponent.providesImageInfoProvider));
            this.provideImagePickerPresenterProvider = f.b.a.a(FragmentModule_ProvideImagePickerPresenterFactory.create(fragmentModule, this.activityComponentImpl.provideAccountPermissionProvider, this.activityComponentImpl.providePhotoFileGeneratorProvider, this.provideImageValidatorProvider, this.activityComponentImpl.provideUriToPathResolverProvider, this.activityComponentImpl.provideImagePickerNavigatorProvider));
            this.provideCreateUserErrorMapperProvider = f.b.a.a(FragmentModule_ProvideCreateUserErrorMapperFactory.create(fragmentModule, this.provideAccountErrorMapperProvider));
            this.provideManageUserPresenterProvider = f.b.a.a(FragmentModule_ProvideManageUserPresenterFactory.create(fragmentModule, this.applicationComponent.provideAptoideAccountManagerProvider, this.provideCreateUserErrorMapperProvider, this.activityComponentImpl.provideManageUserNavigatorProvider, this.activityComponentImpl.provideUriToPathResolverProvider, this.applicationComponent.provideAccountAnalyticsProvider));
            this.provideManageStoreErrorMapperProvider = f.b.a.a(FragmentModule_ProvideManageStoreErrorMapperFactory.create(fragmentModule));
            this.provideManageStorePresenterProvider = f.b.a.a(FragmentModule_ProvideManageStorePresenterFactory.create(fragmentModule, this.activityComponentImpl.provideUriToPathResolverProvider, this.activityComponentImpl.provideManageStoreNavigatorProvider, this.provideManageStoreErrorMapperProvider, this.applicationComponent.provideAptoideAccountManagerProvider, this.applicationComponent.provideAccountAnalyticsProvider));
            this.providesSearchManagerProvider = f.b.a.a(FragmentModule_ProvidesSearchManagerFactory.create(fragmentModule, this.applicationComponent.provideAptoideAccountManagerProvider, this.applicationComponent.providesSearchRepositoryProvider, this.applicationComponent.providesDownloadStatusManagerProvider, this.applicationComponent.providesAppCenterProvider));
            this.providesDownloadDialogManagerProvider = f.b.a.a(FragmentModule_ProvidesDownloadDialogManagerFactory.create(fragmentModule, this.activityComponentImpl.providesThemeManagerProvider));
            this.providesDownloadNavigatorProvider = f.b.a.a(FragmentModule_ProvidesDownloadNavigatorFactory.create(fragmentModule, this.activityComponentImpl.provideMainFragmentNavigatorProvider));
            this.providesDownloadViewActionPresenterProvider = f.b.a.a(FragmentModule_ProvidesDownloadViewActionPresenterFactory.create(fragmentModule, this.applicationComponent.providesInstallManagerProvider, this.applicationComponent.providesMoPubAdsManagerProvider, this.applicationComponent.providePermissionManagerProvider, this.applicationComponent.providesAppcMigrationManagerProvider, this.providesDownloadDialogManagerProvider, this.providesDownloadNavigatorProvider, this.applicationComponent.provideDownloadFactoryProvider, this.applicationComponent.providesDownloadAnalyticsProvider, this.applicationComponent.provideInstallAnalyticsProvider, this.applicationComponent.provideNotificationAnalyticsProvider, this.applicationComponent.providesCrashReportsProvider, this.applicationComponent.providesDynamicSplitsManagerProvider, this.applicationComponent.splitAnalyticsMapperProvider, this.applicationComponent.provideCampaignManagerProvider));
            this.provideSearchResultPresenterProvider = f.b.a.a(FragmentModule_ProvideSearchResultPresenterFactory.create(fragmentModule, this.applicationComponent.providesSearchAnalyticsProvider, this.activityComponentImpl.providesSearchNavigatorProvider, this.providesSearchManagerProvider, this.applicationComponent.providesTrendingManagerProvider, this.applicationComponent.providesSearchSuggestionManagerProvider, this.activityComponentImpl.provideBottomNavigationMapperProvider, this.providesDownloadViewActionPresenterProvider));
            this.providesMyStoreNavigatorProvider = f.b.a.a(FragmentModule_ProvidesMyStoreNavigatorFactory.create(fragmentModule, this.activityComponentImpl.provideMainFragmentNavigatorProvider, this.activityComponentImpl.provideBottomNavigationMapperProvider));
            this.providesMyStorePresenterProvider = f.b.a.a(FragmentModule_ProvidesMyStorePresenterFactory.create(fragmentModule, this.applicationComponent.provideAptoideAccountManagerProvider, this.providesMyStoreNavigatorProvider));
            this.providesHomeProvider = f.b.a.a(FragmentModule_ProvidesHomeFactory.create(fragmentModule, this.applicationComponent.providesBundleRepositoryProvider, this.applicationComponent.providePromotionsManagerProvider, this.applicationComponent.providesPromotionsPreferencesManagerProvider, this.applicationComponent.providesBlacklistManagerProvider, this.applicationComponent.provideHomePromotionsIdProvider, this.applicationComponent.providesReactionsManagerProvider, this.applicationComponent.providesComingSoonNotificationManagerProvider));
            this.providesHomeNavigatorProvider = f.b.a.a(FragmentModule_ProvidesHomeNavigatorFactory.create(fragmentModule, this.activityComponentImpl.provideMainFragmentNavigatorProvider, this.activityComponentImpl.provideBottomNavigationMapperProvider, this.activityComponentImpl.providesAppNavigatorProvider, this.activityComponentImpl.provideAccountNavigatorProvider, this.activityComponentImpl.providesThemeManagerProvider));
            this.providesHomeAnalyticsProvider = f.b.a.a(FragmentModule_ProvidesHomeAnalyticsFactory.create(fragmentModule, this.applicationComponent.providesAnalyticsManagerProvider, this.applicationComponent.provideNavigationTrackerProvider));
            this.providesHomePresenterProvider = f.b.a.a(FragmentModule_ProvidesHomePresenterFactory.create(fragmentModule, this.providesHomeProvider, this.providesHomeNavigatorProvider, this.applicationComponent.providesAdMapperProvider, this.applicationComponent.provideAptoideAccountManagerProvider, this.providesHomeAnalyticsProvider, this.applicationComponent.providesUserFeedbackAnalyticsProvider));
            this.providesAppMapperProvider = f.b.a.a(FragmentModule_ProvidesAppMapperFactory.create(fragmentModule));
            this.providesAppsManagerProvider = f.b.a.a(FragmentModule_ProvidesAppsManagerFactory.create(fragmentModule, this.applicationComponent.providesUpdatesManagerProvider, this.applicationComponent.providesInstallManagerProvider, this.providesAppMapperProvider, this.applicationComponent.providesDownloadAnalyticsProvider, this.applicationComponent.provideInstallAnalyticsProvider, this.applicationComponent.providesUpdatesAnalyticsProvider, this.applicationComponent.provideDownloadFactoryProvider, this.applicationComponent.providesMoPubAdsManagerProvider, this.applicationComponent.providesAptoideInstallManagerProvider, this.applicationComponent.providesUpdatesNotificationManagerProvider, this.applicationComponent.providesSecureSharedPreferencesProvider, this.applicationComponent.providesDynamicSplitsManagerProvider, this.applicationComponent.splitAnalyticsMapperProvider, this.applicationComponent.provideCampaignManagerProvider));
            this.providesAppsNavigatorProvider = f.b.a.a(FragmentModule_ProvidesAppsNavigatorFactory.create(fragmentModule, this.activityComponentImpl.provideMainFragmentNavigatorProvider, this.activityComponentImpl.provideBottomNavigationMapperProvider, this.activityComponentImpl.providesAppNavigatorProvider));
            this.providesAppsPresenterProvider = f.b.a.a(FragmentModule_ProvidesAppsPresenterFactory.create(fragmentModule, this.providesAppsManagerProvider, this.applicationComponent.provideAptoideAccountManagerProvider, this.providesAppsNavigatorProvider));
            Provider<AppViewConfiguration> providerA = f.b.a.a(FragmentModule_ProvidesAppViewConfigurationFactory.create(fragmentModule));
            this.providesAppViewConfigurationProvider = providerA;
            this.providesAppViewModelManagerProvider = f.b.a.a(FragmentModule_ProvidesAppViewModelManagerFactory.create(fragmentModule, providerA, this.applicationComponent.provideStoreManagerProvider, this.applicationComponent.provideMarketNameProvider, this.applicationComponent.providesAppCenterProvider, this.applicationComponent.providesDownloadStateParserProvider, this.applicationComponent.providesInstallManagerProvider, this.applicationComponent.providesAppcMigrationManagerProvider, this.applicationComponent.providesAppCoinsAdvertisingManagerProvider, this.applicationComponent.providesAppCoinsManagerProvider));
            Provider<FlagService> providerA2 = f.b.a.a(FragmentModule_ProvidesFlagServiceFactory.create(fragmentModule, this.applicationComponent.providesBodyInterceptorV3Provider, this.applicationComponent.provideOkHttpClientProvider, this.applicationComponent.provideTokenInvalidatorProvider, this.applicationComponent.providesDefaultSharedPerefencesProvider));
            this.providesFlagServiceProvider = providerA2;
            this.providesFlagManagerProvider = f.b.a.a(FragmentModule_ProvidesFlagManagerFactory.create(fragmentModule, providerA2));
            this.providesAppcPromotionNotificationStringProvider = f.b.a.a(FragmentModule_ProvidesAppcPromotionNotificationStringProviderFactory.create(fragmentModule));
            this.providesAppViewManagerProvider = f.b.a.a(FragmentModule_ProvidesAppViewManagerFactory.create(fragmentModule, this.providesAppViewModelManagerProvider, this.applicationComponent.providesInstallManagerProvider, this.applicationComponent.provideDownloadFactoryProvider, this.applicationComponent.providesAppCenterProvider, this.applicationComponent.providesReviewsManagerProvider, this.applicationComponent.providesAdsManagerProvider, this.providesFlagManagerProvider, this.applicationComponent.provideStoreUtilsProxyProvider, this.applicationComponent.provideAptoideAccountManagerProvider, this.applicationComponent.providesDownloadStateParserProvider, this.applicationComponent.providesAppViewAnalyticsProvider, this.applicationComponent.provideNotificationAnalyticsProvider, this.applicationComponent.provideInstallAnalyticsProvider, this.applicationComponent.provideResourcesProvider, this.applicationComponent.provideWindowManagerProvider, this.applicationComponent.provideMarketNameProvider, this.applicationComponent.providesAppCoinsManagerProvider, this.applicationComponent.providesMoPubAdsManagerProvider, this.applicationComponent.providePromotionsManagerProvider, this.applicationComponent.providesAppcMigrationManagerProvider, this.applicationComponent.providesLocalNotificationSyncManagerProvider, this.providesAppcPromotionNotificationStringProvider, this.applicationComponent.providesDynamicSplitsManagerProvider, this.applicationComponent.splitAnalyticsMapperProvider, this.applicationComponent.providesAppsFlyerManagerProvider, this.applicationComponent.provideCampaignManagerProvider));
            this.providesAppViewPresenterProvider = f.b.a.a(FragmentModule_ProvidesAppViewPresenterFactory.create(fragmentModule, this.activityComponentImpl.provideAccountNavigatorProvider, this.applicationComponent.providesAppViewAnalyticsProvider, this.applicationComponent.providesCampaignAnalyticsProvider, this.activityComponentImpl.providesAppViewNavigatorProvider, this.providesAppViewManagerProvider, this.applicationComponent.provideAptoideAccountManagerProvider, this.applicationComponent.providesCrashReportsProvider, this.activityComponentImpl.providesPromotionsNavigatorProvider, this.applicationComponent.providesWalletAppProvider));
            this.providesGetStoreManagerProvider = f.b.a.a(FragmentModule_ProvidesGetStoreManagerFactory.create(fragmentModule, this.applicationComponent.providesBundleRepositoryProvider));
            this.providesBundleEventProvider = f.b.a.a(FragmentModule_ProvidesBundleEventFactory.create(fragmentModule));
            this.providesGetStoreWidgetsPresenterProvider = f.b.a.a(FragmentModule_ProvidesGetStoreWidgetsPresenterFactory.create(fragmentModule, this.providesGetStoreManagerProvider, this.applicationComponent.providesCrashReportsProvider, this.providesHomeNavigatorProvider, this.applicationComponent.providesAdMapperProvider, this.providesBundleEventProvider, this.providesHomeAnalyticsProvider, this.applicationComponent.providesChipManagerProvider));
            this.providesWizardPresenterProvider = f.b.a.a(FragmentModule_ProvidesWizardPresenterFactory.create(fragmentModule, this.applicationComponent.provideAptoideAccountManagerProvider, this.applicationComponent.providesCrashReportsProvider, this.applicationComponent.provideAccountAnalyticsProvider));
            this.providesWizardFragmentProvider = f.b.a.a(FlavourFragmentModule_ProvidesWizardFragmentProviderFactory.create(flavourFragmentModule, this.activityComponentImpl.providesThemeManagerProvider));
            this.providesAppCoinsInfoPresenterProvider = f.b.a.a(FragmentModule_ProvidesAppCoinsInfoPresenterFactory.create(fragmentModule, this.activityComponentImpl.providesAppCoinsInfoNavigatorProvider, this.applicationComponent.providesInstallManagerProvider, this.applicationComponent.providesCrashReportsProvider, this.applicationComponent.providesSocialMediaAnalyticsProvider, this.applicationComponent.providesAppCoinsManagerProvider));
            this.providesEditorialRepositoryProvider = f.b.a.a(FragmentModule_ProvidesEditorialRepositoryFactory.create(fragmentModule, this.applicationComponent.providesEditorialServiceProvider));
            this.providesEditorialAnalyticsProvider = f.b.a.a(FragmentModule_ProvidesEditorialAnalyticsFactory.create(fragmentModule, this.applicationComponent.providesDownloadAnalyticsProvider, this.applicationComponent.providesAnalyticsManagerProvider, this.applicationComponent.provideNavigationTrackerProvider, this.applicationComponent.provideInstallAnalyticsProvider, this.applicationComponent.splitAnalyticsMapperProvider));
            this.providesEditorialManagerProvider = f.b.a.a(FragmentModule_ProvidesEditorialManagerFactory.create(fragmentModule, this.providesEditorialRepositoryProvider, this.applicationComponent.providesInstallManagerProvider, this.applicationComponent.provideDownloadFactoryProvider, this.applicationComponent.providesDownloadStateParserProvider, this.applicationComponent.provideNotificationAnalyticsProvider, this.applicationComponent.provideInstallAnalyticsProvider, this.providesEditorialAnalyticsProvider, this.applicationComponent.providesReactionsManagerProvider, this.applicationComponent.providesMoPubAdsManagerProvider, this.applicationComponent.providesDynamicSplitsManagerProvider, this.applicationComponent.splitAnalyticsMapperProvider, this.applicationComponent.provideCampaignManagerProvider));
            this.providesEditorialNavigatorProvider = f.b.a.a(FragmentModule_ProvidesEditorialNavigatorFactory.create(fragmentModule, this.activityComponentImpl.providesAppNavigatorProvider, this.activityComponentImpl.provideAccountNavigatorProvider, this.activityComponentImpl.providesSocialMediaNavigatorProvider, this.activityComponentImpl.provideMainFragmentNavigatorProvider));
            this.providesEditorialPresenterProvider = f.b.a.a(FragmentModule_ProvidesEditorialPresenterFactory.create(fragmentModule, this.providesEditorialManagerProvider, this.applicationComponent.providesCrashReportsProvider, this.providesEditorialAnalyticsProvider, this.providesEditorialNavigatorProvider, this.applicationComponent.providesUserFeedbackAnalyticsProvider, this.applicationComponent.providesMoPubAdsManagerProvider, this.applicationComponent.providesSocialMediaAnalyticsProvider));
            this.providesPromotionsPresenterProvider = f.b.a.a(FragmentModule_ProvidesPromotionsPresenterFactory.create(fragmentModule, this.applicationComponent.providePromotionsManagerProvider, this.applicationComponent.providesPromotionsAnalyticsProvider, this.activityComponentImpl.providesPromotionsNavigatorProvider, this.applicationComponent.provideHomePromotionsIdProvider, this.applicationComponent.providesMoPubAdsManagerProvider));
            Provider<ClaimPromotionsManager> providerA3 = f.b.a.a(FragmentModule_ProvidesClaimPromotionsManagerFactory.create(fragmentModule, this.applicationComponent.providePromotionsManagerProvider));
            this.providesClaimPromotionsManagerProvider = providerA3;
            this.providesClaimPromotionDialogPresenterProvider = f.b.a.a(FragmentModule_ProvidesClaimPromotionDialogPresenterFactory.create(fragmentModule, providerA3, this.applicationComponent.providesPromotionsAnalyticsProvider, this.activityComponentImpl.providesClaimPromotionsNavigatorProvider));
            Provider<FragmentNavigator> providerA4 = f.b.a.a(FragmentModule_ProvideHomeFragmentNavigatorFactory.create(fragmentModule, this.applicationComponent.provideFragmentNavigatorMapProvider, this.applicationComponent.provideFragmentNavigatorRelayProvider));
            this.provideHomeFragmentNavigatorProvider = providerA4;
            this.providesHomeContainerNavigatorProvider = f.b.a.a(FragmentModule_ProvidesHomeContainerNavigatorFactory.create(fragmentModule, providerA4));
            this.providesHomeContainerPresenterProvider = f.b.a.a(FragmentModule_ProvidesHomeContainerPresenterFactory.create(fragmentModule, this.applicationComponent.provideAptoideAccountManagerProvider, this.providesHomeContainerNavigatorProvider, this.providesHomeNavigatorProvider, this.providesHomeAnalyticsProvider, this.providesHomeProvider, this.applicationComponent.providesChipManagerProvider));
            Provider<EditorialCardListService> providerA5 = f.b.a.a(FragmentModule_ProvidesEditorialServiceFactory.create(fragmentModule, this.applicationComponent.provideAccountSettingsBodyInterceptorPoolV7Provider, this.applicationComponent.provideOkHttpClientProvider, this.applicationComponent.provideTokenInvalidatorProvider, this.applicationComponent.providesDefaultSharedPerefencesProvider));
            this.providesEditorialServiceProvider = providerA5;
            Provider<EditorialCardListRepository> providerA6 = f.b.a.a(FragmentModule_ProvidesEditorialListRepositoryFactory.create(fragmentModule, providerA5));
            this.providesEditorialListRepositoryProvider = providerA6;
            this.providesEditorialListManagerProvider = f.b.a.a(FragmentModule_ProvidesEditorialListManagerFactory.create(fragmentModule, providerA6, this.applicationComponent.providesReactionsManagerProvider, this.applicationComponent.providesAppCoinsManagerProvider));
            this.providesEditorialListNavigatorProvider = f.b.a.a(FragmentModule_ProvidesEditorialListNavigatorFactory.create(fragmentModule, this.activityComponentImpl.provideMainFragmentNavigatorProvider, this.activityComponentImpl.provideAccountNavigatorProvider));
            this.editorialListAnalyticsProvider = f.b.a.a(FragmentModule_EditorialListAnalyticsFactory.create(fragmentModule, this.applicationComponent.provideNavigationTrackerProvider, this.applicationComponent.providesAnalyticsManagerProvider));
            this.providesEditorialListPresenterProvider = f.b.a.a(FragmentModule_ProvidesEditorialListPresenterFactory.create(fragmentModule, this.providesEditorialListManagerProvider, this.applicationComponent.provideAptoideAccountManagerProvider, this.providesEditorialListNavigatorProvider, this.editorialListAnalyticsProvider, this.applicationComponent.providesUserFeedbackAnalyticsProvider));
            this.providesRewardAppCoinsAppsRepositoryProvider = f.b.a.a(FragmentModule_ProvidesRewardAppCoinsAppsRepositoryFactory.create(fragmentModule, this.applicationComponent.provideOkHttpClientProvider, this.applicationComponent.provideAccountSettingsBodyInterceptorPoolV7Provider, this.applicationComponent.provideTokenInvalidatorProvider, this.applicationComponent.providesDefaultSharedPerefencesProvider, this.applicationComponent.providesInstallManagerProvider));
            this.providesListAppsConfigurationProvider = f.b.a.a(FragmentModule_ProvidesListAppsConfigurationFactory.create(fragmentModule));
            this.provideEarnAppcListManagerProvider = f.b.a.a(FragmentModule_ProvideEarnAppcListManagerFactory.create(fragmentModule, this.applicationComponent.providesWalletAppProvider, this.activityComponentImpl.providesWalletInstallManagerProvider));
            this.provideEarnAppcListAnalyticsProvider = f.b.a.a(FragmentModule_ProvideEarnAppcListAnalyticsFactory.create(fragmentModule, this.applicationComponent.providesDownloadAnalyticsProvider));
            this.provideEarnAppcNavigatorProvider = f.b.a.a(FragmentModule_ProvideEarnAppcNavigatorFactory.create(fragmentModule, this.activityComponentImpl.provideMainFragmentNavigatorProvider));
            this.provideEarnAppCoinsListPresenterProvider = f.b.a.a(FragmentModule_ProvideEarnAppCoinsListPresenterFactory.create(fragmentModule, this.applicationComponent.providesCrashReportsProvider, this.providesRewardAppCoinsAppsRepositoryProvider, this.applicationComponent.providesAnalyticsManagerProvider, this.activityComponentImpl.providesAppNavigatorProvider, this.providesListAppsConfigurationProvider, this.provideEarnAppcListManagerProvider, this.applicationComponent.providesMoPubAdsManagerProvider, this.provideEarnAppcListAnalyticsProvider, this.provideEarnAppcNavigatorProvider));
            this.providesListAppsMoreConfigurationProvider = f.b.a.a(FragmentModule_ProvidesListAppsMoreConfigurationFactory.create(fragmentModule));
            this.providesListAppsMoreManagerProvider = f.b.a.a(FragmentModule_ProvidesListAppsMoreManagerFactory.create(fragmentModule, this.activityComponentImpl.providesListAppsMoreRepositoryProvider, this.applicationComponent.provideAdsRepositoryProvider));
            this.providesListAppsMorePresenterProvider = f.b.a.a(FragmentModule_ProvidesListAppsMorePresenterFactory.create(fragmentModule, this.applicationComponent.providesCrashReportsProvider, this.activityComponentImpl.providesAppNavigatorProvider, this.applicationComponent.providesDefaultSharedPerefencesProvider, this.providesListAppsMoreConfigurationProvider, this.providesListAppsMoreManagerProvider));
            this.providesAutoUpdateDialogPresenterProvider = f.b.a.a(FragmentModule_ProvidesAutoUpdateDialogPresenterFactory.create(fragmentModule, this.applicationComponent.providesCrashReportsProvider, this.activityComponentImpl.provideAutoUpdateManagerProvider));
            this.providesDarkthemeDialogPresenterProvider = f.b.a.a(FragmentModule_ProvidesDarkthemeDialogPresenterFactory.create(fragmentModule, this.applicationComponent.providesNewFeatureManagerProvider));
            Provider<CheckYourEmailNavigator> providerA7 = f.b.a.a(FragmentModule_ProvidesCheckYourEmailNavigatorFactory.create(fragmentModule));
            this.providesCheckYourEmailNavigatorProvider = providerA7;
            this.provideCheckYourEmailPresenterProvider = f.b.a.a(FragmentModule_ProvideCheckYourEmailPresenterFactory.create(fragmentModule, providerA7));
            this.providesOutOfSpaceManagerProvider = f.b.a.a(FragmentModule_ProvidesOutOfSpaceManagerFactory.create(fragmentModule, this.applicationComponent.providesInstallManagerProvider, this.applicationComponent.providesInstallAppSizeValidatorProvider));
            this.providesOutOfSpaceNavigatorProvider = f.b.a.a(FragmentModule_ProvidesOutOfSpaceNavigatorFactory.create(fragmentModule, this.activityComponentImpl.provideMainFragmentNavigatorProvider));
            this.providesOutOfSpaceDialogPresenterProvider = f.b.a.a(FragmentModule_ProvidesOutOfSpaceDialogPresenterFactory.create(fragmentModule, this.applicationComponent.providesCrashReportsProvider, this.providesOutOfSpaceManagerProvider, this.providesOutOfSpaceNavigatorProvider));
        }

        private AddStoreDialog injectAddStoreDialog(AddStoreDialog addStoreDialog) {
            BaseDialogFragment_MembersInjector.injectThemeManager(addStoreDialog, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            AddStoreDialog_MembersInjector.injectStoreCredentialsProvider(addStoreDialog, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            AddStoreDialog_MembersInjector.injectStoreUtilsProxy(addStoreDialog, (StoreUtilsProxy) this.applicationComponent.provideStoreUtilsProxyProvider.get());
            return addStoreDialog;
        }

        private AppCoinsInfoFragment injectAppCoinsInfoFragment(AppCoinsInfoFragment appCoinsInfoFragment) {
            AppCoinsInfoFragment_MembersInjector.injectAppCoinsInfoPresenter(appCoinsInfoFragment, this.providesAppCoinsInfoPresenterProvider.get());
            AppCoinsInfoFragment_MembersInjector.injectScreenWidth(appCoinsInfoFragment, ((Float) this.activityComponentImpl.providesScreenWidthProvider.get()).floatValue());
            AppCoinsInfoFragment_MembersInjector.injectScreenHeight(appCoinsInfoFragment, ((Float) this.activityComponentImpl.providesScreenHeightProvider.get()).floatValue());
            return appCoinsInfoFragment;
        }

        private AppViewFragment injectAppViewFragment(AppViewFragment appViewFragment) {
            AppViewFragment_MembersInjector.injectPresenter(appViewFragment, this.providesAppViewPresenterProvider.get());
            AppViewFragment_MembersInjector.injectDialogUtils(appViewFragment, (DialogUtils) this.activityComponentImpl.providesDialogUtilsProvider.get());
            AppViewFragment_MembersInjector.injectMarketName(appViewFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            AppViewFragment_MembersInjector.injectOneDecimalFormat(appViewFragment, (DecimalFormat) this.applicationComponent.providesDecimalFormatProvider.get());
            AppViewFragment_MembersInjector.injectThemeManager(appViewFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            AppViewFragment_MembersInjector.injectRoomStoredMinimalAdPersistence(appViewFragment, (RoomStoredMinimalAdPersistence) this.applicationComponent.providesRoomStoreMinimalAdPersistenceProvider.get());
            return appViewFragment;
        }

        private AppsFragment injectAppsFragment(AppsFragment appsFragment) {
            AppsFragment_MembersInjector.injectAppsPresenter(appsFragment, this.providesAppsPresenterProvider.get());
            AppsFragment_MembersInjector.injectThemeManager(appsFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return appsFragment;
        }

        private AutoUpdateDialogFragment injectAutoUpdateDialogFragment(AutoUpdateDialogFragment autoUpdateDialogFragment) {
            BaseDialogFragment_MembersInjector.injectThemeManager(autoUpdateDialogFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            AutoUpdateDialogFragment_MembersInjector.injectPresenter(autoUpdateDialogFragment, this.providesAutoUpdateDialogPresenterProvider.get());
            return autoUpdateDialogFragment;
        }

        private CheckYourEmailFragment injectCheckYourEmailFragment(CheckYourEmailFragment checkYourEmailFragment) {
            CheckYourEmailFragment_MembersInjector.injectPresenter(checkYourEmailFragment, this.provideCheckYourEmailPresenterProvider.get());
            return checkYourEmailFragment;
        }

        private ClaimPromotionDialogFragment injectClaimPromotionDialogFragment(ClaimPromotionDialogFragment claimPromotionDialogFragment) {
            BaseDialogFragment_MembersInjector.injectThemeManager(claimPromotionDialogFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            ClaimPromotionDialogFragment_MembersInjector.injectPresenter(claimPromotionDialogFragment, this.providesClaimPromotionDialogPresenterProvider.get());
            ClaimPromotionDialogFragment_MembersInjector.injectClaimPromotionsManager(claimPromotionDialogFragment, this.providesClaimPromotionsManagerProvider.get());
            ClaimPromotionDialogFragment_MembersInjector.injectIdsRepository(claimPromotionDialogFragment, (IdsRepository) this.applicationComponent.provideIdsRepositoryProvider.get());
            ClaimPromotionDialogFragment_MembersInjector.injectPromotionsAnalytics(claimPromotionDialogFragment, (PromotionsAnalytics) this.applicationComponent.providesPromotionsAnalyticsProvider.get());
            ClaimPromotionDialogFragment_MembersInjector.injectNavigator(claimPromotionDialogFragment, (ClaimPromotionsNavigator) this.activityComponentImpl.providesClaimPromotionsNavigatorProvider.get());
            return claimPromotionDialogFragment;
        }

        private CommentDialogFragment injectCommentDialogFragment(CommentDialogFragment commentDialogFragment) {
            BaseDialogFragment_MembersInjector.injectThemeManager(commentDialogFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            CommentDialogFragment_MembersInjector.injectUserFeedbackAnalytics(commentDialogFragment, (UserFeedbackAnalytics) this.applicationComponent.providesUserFeedbackAnalyticsProvider.get());
            return commentDialogFragment;
        }

        private CommentListFragment injectCommentListFragment(CommentListFragment commentListFragment) {
            CommentListFragment_MembersInjector.injectAnalyticsManager(commentListFragment, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            CommentListFragment_MembersInjector.injectNavigationTracker(commentListFragment, (NavigationTracker) this.applicationComponent.provideNavigationTrackerProvider.get());
            CommentListFragment_MembersInjector.injectThemeManager(commentListFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            CommentListFragment_MembersInjector.injectStoreCredentialsProvider(commentListFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            return commentListFragment;
        }

        private DescriptionFragment injectDescriptionFragment(DescriptionFragment descriptionFragment) {
            DescriptionFragment_MembersInjector.injectThemeManager(descriptionFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            DescriptionFragment_MembersInjector.injectStoreCredentialsProvider(descriptionFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            return descriptionFragment;
        }

        private EarnAppcListFragment injectEarnAppcListFragment(EarnAppcListFragment earnAppcListFragment) {
            EarnAppcListFragment_MembersInjector.injectPresenter(earnAppcListFragment, this.provideEarnAppCoinsListPresenterProvider.get());
            EarnAppcListFragment_MembersInjector.injectThemeManager(earnAppcListFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return earnAppcListFragment;
        }

        private EditorialFragment injectEditorialFragment(EditorialFragment editorialFragment) {
            EditorialFragment_MembersInjector.injectPresenter(editorialFragment, this.providesEditorialPresenterProvider.get());
            EditorialFragment_MembersInjector.injectScreenWidth(editorialFragment, ((Float) this.activityComponentImpl.providesScreenWidthProvider.get()).floatValue());
            EditorialFragment_MembersInjector.injectScreenHeight(editorialFragment, ((Float) this.activityComponentImpl.providesScreenHeightProvider.get()).floatValue());
            EditorialFragment_MembersInjector.injectThemeManager(editorialFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            EditorialFragment_MembersInjector.injectCaptionBackgroundPainter(editorialFragment, (CaptionBackgroundPainter) this.applicationComponent.providesCaptionBackgroundPainterProvider.get());
            return editorialFragment;
        }

        private EditorialListFragment injectEditorialListFragment(EditorialListFragment editorialListFragment) {
            EditorialListFragment_MembersInjector.injectPresenter(editorialListFragment, this.providesEditorialListPresenterProvider.get());
            EditorialListFragment_MembersInjector.injectCaptionBackgroundPainter(editorialListFragment, (CaptionBackgroundPainter) this.applicationComponent.providesCaptionBackgroundPainterProvider.get());
            EditorialListFragment_MembersInjector.injectThemeAttributeProvider(editorialListFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return editorialListFragment;
        }

        private ExcludedUpdatesFragment injectExcludedUpdatesFragment(ExcludedUpdatesFragment excludedUpdatesFragment) {
            ExcludedUpdatesFragment_MembersInjector.injectUpdatesPersistence(excludedUpdatesFragment, (UpdatePersistence) this.applicationComponent.providesUpdatePersistenceProvider.get());
            return excludedUpdatesFragment;
        }

        private GridRecyclerSwipeWithToolbarFragment injectGridRecyclerSwipeWithToolbarFragment(GridRecyclerSwipeWithToolbarFragment gridRecyclerSwipeWithToolbarFragment) {
            GridRecyclerSwipeWithToolbarFragment_MembersInjector.injectMarketName(gridRecyclerSwipeWithToolbarFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            return gridRecyclerSwipeWithToolbarFragment;
        }

        private HomeContainerFragment injectHomeContainerFragment(HomeContainerFragment homeContainerFragment) {
            HomeContainerFragment_MembersInjector.injectPresenter(homeContainerFragment, this.providesHomeContainerPresenterProvider.get());
            HomeContainerFragment_MembersInjector.injectThemeManager(homeContainerFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return homeContainerFragment;
        }

        private HomeFragment injectHomeFragment(HomeFragment homeFragment) {
            HomeFragment_MembersInjector.injectPresenter(homeFragment, this.providesHomePresenterProvider.get());
            HomeFragment_MembersInjector.injectMarketName(homeFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            HomeFragment_MembersInjector.injectCaptionBackgroundPainter(homeFragment, (CaptionBackgroundPainter) this.applicationComponent.providesCaptionBackgroundPainterProvider.get());
            HomeFragment_MembersInjector.injectThemeManager(homeFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return homeFragment;
        }

        private LatestReviewsFragment injectLatestReviewsFragment(LatestReviewsFragment latestReviewsFragment) {
            LatestReviewsFragment_MembersInjector.injectAnalyticsManager(latestReviewsFragment, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            LatestReviewsFragment_MembersInjector.injectNavigationTracker(latestReviewsFragment, (NavigationTracker) this.applicationComponent.provideNavigationTrackerProvider.get());
            LatestReviewsFragment_MembersInjector.injectStoreCredentialsProvider(latestReviewsFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            return latestReviewsFragment;
        }

        private ListAppsMoreFragment injectListAppsMoreFragment(ListAppsMoreFragment listAppsMoreFragment) {
            ListAppsMoreFragment_MembersInjector.injectPresenter(listAppsMoreFragment, this.providesListAppsMorePresenterProvider.get());
            return listAppsMoreFragment;
        }

        private ListStoreAppsFragment injectListStoreAppsFragment(ListStoreAppsFragment listStoreAppsFragment) {
            ListStoreAppsFragment_MembersInjector.injectListStoreAppsNavigator(listStoreAppsFragment, (ListStoreAppsNavigator) this.activityComponentImpl.provideListStoreAppsNavigatorProvider.get());
            ListStoreAppsFragment_MembersInjector.injectAppCenter(listStoreAppsFragment, (AppCenter) this.applicationComponent.providesAppCenterProvider.get());
            return listStoreAppsFragment;
        }

        private ListStoresFragment injectListStoresFragment(ListStoresFragment listStoresFragment) {
            StoreTabGridRecyclerFragment_MembersInjector.injectStoreRepository(listStoresFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(listStoresFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreUtilsProxy(listStoresFragment, (StoreUtilsProxy) this.applicationComponent.provideStoreUtilsProxyProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAptoideInstalledAppsRepository(listStoresFragment, (AptoideInstalledAppsRepository) this.applicationComponent.provideInstalledRepositoryProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAnalyticsManager(listStoresFragment, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectMarketName(listStoresFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectThemeManager(listStoresFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreCredentialsProvider(listStoresFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreRepository(listStoresFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            ListStoresFragment_MembersInjector.injectAnalyticsManager(listStoresFragment, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            ListStoresFragment_MembersInjector.injectNavigationTracker(listStoresFragment, (NavigationTracker) this.applicationComponent.provideNavigationTrackerProvider.get());
            return listStoresFragment;
        }

        private LoginSignUpCredentialsFragment injectLoginSignUpCredentialsFragment(LoginSignUpCredentialsFragment loginSignUpCredentialsFragment) {
            LoginSignUpCredentialsFragment_MembersInjector.injectPresenter(loginSignUpCredentialsFragment, this.provideLoginSignUpPresenterProvider.get());
            LoginSignUpCredentialsFragment_MembersInjector.injectSendMagicLinkPresenter(loginSignUpCredentialsFragment, this.provideSendMagicLinkPresenterProvider.get());
            LoginSignUpCredentialsFragment_MembersInjector.injectOrientationManager(loginSignUpCredentialsFragment, (ScreenOrientationManager) this.activityComponentImpl.provideScreenOrientationManagerProvider.get());
            LoginSignUpCredentialsFragment_MembersInjector.injectAccountAnalytics(loginSignUpCredentialsFragment, (AccountAnalytics) this.applicationComponent.provideAccountAnalyticsProvider.get());
            LoginSignUpCredentialsFragment_MembersInjector.injectMarketName(loginSignUpCredentialsFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            LoginSignUpCredentialsFragment_MembersInjector.injectThemeManager(loginSignUpCredentialsFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return loginSignUpCredentialsFragment;
        }

        private ManageStoreFragment injectManageStoreFragment(ManageStoreFragment manageStoreFragment) {
            ManageStoreFragment_MembersInjector.injectImagePickerPresenter(manageStoreFragment, this.provideImagePickerPresenterProvider.get());
            ManageStoreFragment_MembersInjector.injectManageStorePresenter(manageStoreFragment, this.provideManageStorePresenterProvider.get());
            ManageStoreFragment_MembersInjector.injectOrientationManager(manageStoreFragment, (ScreenOrientationManager) this.activityComponentImpl.provideScreenOrientationManagerProvider.get());
            ManageStoreFragment_MembersInjector.injectThemeManager(manageStoreFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return manageStoreFragment;
        }

        private ManageUserFragment injectManageUserFragment(ManageUserFragment manageUserFragment) {
            ManageUserFragment_MembersInjector.injectImagePickerPresenter(manageUserFragment, this.provideImagePickerPresenterProvider.get());
            ManageUserFragment_MembersInjector.injectManageUserPresenter(manageUserFragment, this.provideManageUserPresenterProvider.get());
            ManageUserFragment_MembersInjector.injectOrientationManager(manageUserFragment, (ScreenOrientationManager) this.activityComponentImpl.provideScreenOrientationManagerProvider.get());
            ManageUserFragment_MembersInjector.injectNewsletterManager(manageUserFragment, (NewsletterManager) this.applicationComponent.providesNewsletterManagerProvider.get());
            ManageUserFragment_MembersInjector.injectThemeManager(manageUserFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return manageUserFragment;
        }

        private MoreBundleFragment injectMoreBundleFragment(MoreBundleFragment moreBundleFragment) {
            MoreBundleFragment_MembersInjector.injectPresenter(moreBundleFragment, this.providesGetStoreWidgetsPresenterProvider.get());
            MoreBundleFragment_MembersInjector.injectMarketName(moreBundleFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            MoreBundleFragment_MembersInjector.injectCaptionBackgroundPainter(moreBundleFragment, (CaptionBackgroundPainter) this.applicationComponent.providesCaptionBackgroundPainterProvider.get());
            MoreBundleFragment_MembersInjector.injectThemeAttributeProvider(moreBundleFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return moreBundleFragment;
        }

        private MyAccountFragment injectMyAccountFragment(MyAccountFragment myAccountFragment) {
            MyAccountFragment_MembersInjector.injectMyAccountNavigator(myAccountFragment, (MyAccountNavigator) this.activityComponentImpl.provideMyAccountNavigatorProvider.get());
            MyAccountFragment_MembersInjector.injectAccountAnalytics(myAccountFragment, (AccountAnalytics) this.applicationComponent.provideAccountAnalyticsProvider.get());
            MyAccountFragment_MembersInjector.injectMyAccountManager(myAccountFragment, (MyAccountManager) this.applicationComponent.providesMyAccountManagerProvider.get());
            MyAccountFragment_MembersInjector.injectMarketName(myAccountFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            MyAccountFragment_MembersInjector.injectThemeManager(myAccountFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            MyAccountFragment_MembersInjector.injectSocialMediaAnalytics(myAccountFragment, (SocialMediaAnalytics) this.applicationComponent.providesSocialMediaAnalyticsProvider.get());
            return myAccountFragment;
        }

        private MyStoresFragment injectMyStoresFragment(MyStoresFragment myStoresFragment) {
            StoreTabGridRecyclerFragment_MembersInjector.injectStoreRepository(myStoresFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(myStoresFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreUtilsProxy(myStoresFragment, (StoreUtilsProxy) this.applicationComponent.provideStoreUtilsProxyProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAptoideInstalledAppsRepository(myStoresFragment, (AptoideInstalledAppsRepository) this.applicationComponent.provideInstalledRepositoryProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAnalyticsManager(myStoresFragment, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectMarketName(myStoresFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectThemeManager(myStoresFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreCredentialsProvider(myStoresFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreRepository(myStoresFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            MyStoresFragment_MembersInjector.injectMyStoresPresenter(myStoresFragment, this.providesMyStorePresenterProvider.get());
            MyStoresFragment_MembersInjector.injectStoreRepository(myStoresFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            return myStoresFragment;
        }

        private MyStoresSubscribedFragment injectMyStoresSubscribedFragment(MyStoresSubscribedFragment myStoresSubscribedFragment) {
            StoreTabGridRecyclerFragment_MembersInjector.injectStoreRepository(myStoresSubscribedFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(myStoresSubscribedFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreUtilsProxy(myStoresSubscribedFragment, (StoreUtilsProxy) this.applicationComponent.provideStoreUtilsProxyProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAptoideInstalledAppsRepository(myStoresSubscribedFragment, (AptoideInstalledAppsRepository) this.applicationComponent.provideInstalledRepositoryProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAnalyticsManager(myStoresSubscribedFragment, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectMarketName(myStoresSubscribedFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectThemeManager(myStoresSubscribedFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreCredentialsProvider(myStoresSubscribedFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreRepository(myStoresSubscribedFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            MyStoresSubscribedFragment_MembersInjector.injectAnalyticsManager(myStoresSubscribedFragment, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            MyStoresSubscribedFragment_MembersInjector.injectNavigationTracker(myStoresSubscribedFragment, (NavigationTracker) this.applicationComponent.provideNavigationTrackerProvider.get());
            MyStoresSubscribedFragment_MembersInjector.injectStoreCredentialsProvider(myStoresSubscribedFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            MyStoresSubscribedFragment_MembersInjector.injectStoreRepository(myStoresSubscribedFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            MyStoresSubscribedFragment_MembersInjector.injectStoreUtilsProxy(myStoresSubscribedFragment, (StoreUtilsProxy) this.applicationComponent.provideStoreUtilsProxyProvider.get());
            return myStoresSubscribedFragment;
        }

        private NewFeatureDialogFragment injectNewFeatureDialogFragment(NewFeatureDialogFragment newFeatureDialogFragment) {
            NewFeatureDialogFragment_MembersInjector.injectPresenter(newFeatureDialogFragment, this.providesDarkthemeDialogPresenterProvider.get());
            return newFeatureDialogFragment;
        }

        private OtherVersionsFragment injectOtherVersionsFragment(OtherVersionsFragment otherVersionsFragment) {
            OtherVersionsFragment_MembersInjector.injectStoreRepository(otherVersionsFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            return otherVersionsFragment;
        }

        private OutOfSpaceDialogFragment injectOutOfSpaceDialogFragment(OutOfSpaceDialogFragment outOfSpaceDialogFragment) {
            BaseDialogFragment_MembersInjector.injectThemeManager(outOfSpaceDialogFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            OutOfSpaceDialogFragment_MembersInjector.injectPresenter(outOfSpaceDialogFragment, this.providesOutOfSpaceDialogPresenterProvider.get());
            return outOfSpaceDialogFragment;
        }

        private PrivateStoreDialog injectPrivateStoreDialog(PrivateStoreDialog privateStoreDialog) {
            BaseDialogFragment_MembersInjector.injectThemeManager(privateStoreDialog, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            PrivateStoreDialog_MembersInjector.injectStoreUtilsProxy(privateStoreDialog, (StoreUtilsProxy) this.applicationComponent.provideStoreUtilsProxyProvider.get());
            return privateStoreDialog;
        }

        private ProfileStepOneFragment injectProfileStepOneFragment(ProfileStepOneFragment profileStepOneFragment) {
            ProfileStepOneFragment_MembersInjector.injectOrientationManager(profileStepOneFragment, (ScreenOrientationManager) this.activityComponentImpl.provideScreenOrientationManagerProvider.get());
            ProfileStepOneFragment_MembersInjector.injectAccountNavigator(profileStepOneFragment, (AccountNavigator) this.activityComponentImpl.provideAccountNavigatorProvider.get());
            ProfileStepOneFragment_MembersInjector.injectAccountAnalytics(profileStepOneFragment, (AccountAnalytics) this.applicationComponent.provideAccountAnalyticsProvider.get());
            ProfileStepOneFragment_MembersInjector.injectLoginSignupManager(profileStepOneFragment, (LoginSignupManager) this.applicationComponent.providesLoginSignupManagerProvider.get());
            ProfileStepOneFragment_MembersInjector.injectThemeManager(profileStepOneFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return profileStepOneFragment;
        }

        private ProfileStepTwoFragment injectProfileStepTwoFragment(ProfileStepTwoFragment profileStepTwoFragment) {
            ProfileStepTwoFragment_MembersInjector.injectAccountAnalytics(profileStepTwoFragment, (AccountAnalytics) this.applicationComponent.provideAccountAnalyticsProvider.get());
            ProfileStepTwoFragment_MembersInjector.injectLoginSignupManager(profileStepTwoFragment, (LoginSignupManager) this.applicationComponent.providesLoginSignupManagerProvider.get());
            ProfileStepTwoFragment_MembersInjector.injectMarketResourceFormatter(profileStepTwoFragment, (MarketResourceFormatter) this.applicationComponent.provideMarketResourceFormatterProvider.get());
            ProfileStepTwoFragment_MembersInjector.injectThemeManager(profileStepTwoFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return profileStepTwoFragment;
        }

        private PromotionsFragment injectPromotionsFragment(PromotionsFragment promotionsFragment) {
            PromotionsFragment_MembersInjector.injectPromotionsPresenter(promotionsFragment, this.providesPromotionsPresenterProvider.get());
            PromotionsFragment_MembersInjector.injectThemeManager(promotionsFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return promotionsFragment;
        }

        private RateAndReviewsFragment injectRateAndReviewsFragment(RateAndReviewsFragment rateAndReviewsFragment) {
            RateAndReviewsFragment_MembersInjector.injectAppNavigator(rateAndReviewsFragment, (AppNavigator) this.activityComponentImpl.providesAppNavigatorProvider.get());
            RateAndReviewsFragment_MembersInjector.injectMarketName(rateAndReviewsFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            RateAndReviewsFragment_MembersInjector.injectMarketResourceFormatter(rateAndReviewsFragment, (MarketResourceFormatter) this.applicationComponent.provideMarketResourceFormatterProvider.get());
            RateAndReviewsFragment_MembersInjector.injectThemeManager(rateAndReviewsFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            RateAndReviewsFragment_MembersInjector.injectDialogUtils(rateAndReviewsFragment, (DialogUtils) this.activityComponentImpl.providesDialogUtilsProvider.get());
            RateAndReviewsFragment_MembersInjector.injectAptoideInstalledAppsRepository(rateAndReviewsFragment, (AptoideInstalledAppsRepository) this.applicationComponent.provideInstalledRepositoryProvider.get());
            RateAndReviewsFragment_MembersInjector.injectStoreCredentialsProvider(rateAndReviewsFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            RateAndReviewsFragment_MembersInjector.injectUserFeedbackAnalytics(rateAndReviewsFragment, (UserFeedbackAnalytics) this.applicationComponent.providesUserFeedbackAnalyticsProvider.get());
            return rateAndReviewsFragment;
        }

        private RecommendedStoresFragment injectRecommendedStoresFragment(RecommendedStoresFragment recommendedStoresFragment) {
            StoreTabGridRecyclerFragment_MembersInjector.injectStoreRepository(recommendedStoresFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(recommendedStoresFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreUtilsProxy(recommendedStoresFragment, (StoreUtilsProxy) this.applicationComponent.provideStoreUtilsProxyProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAptoideInstalledAppsRepository(recommendedStoresFragment, (AptoideInstalledAppsRepository) this.applicationComponent.provideInstalledRepositoryProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAnalyticsManager(recommendedStoresFragment, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectMarketName(recommendedStoresFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectThemeManager(recommendedStoresFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreCredentialsProvider(recommendedStoresFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreRepository(recommendedStoresFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            RecommendedStoresFragment_MembersInjector.injectStoreCredentialsProvider(recommendedStoresFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            RecommendedStoresFragment_MembersInjector.injectStoreRepository(recommendedStoresFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            RecommendedStoresFragment_MembersInjector.injectStoreUtilsProxy(recommendedStoresFragment, (StoreUtilsProxy) this.applicationComponent.provideStoreUtilsProxyProvider.get());
            return recommendedStoresFragment;
        }

        private SearchResultFragment injectSearchResultFragment(SearchResultFragment searchResultFragment) {
            SearchResultFragment_MembersInjector.injectSearchResultPresenter(searchResultFragment, this.provideSearchResultPresenterProvider.get());
            SearchResultFragment_MembersInjector.injectThemeManager(searchResultFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return searchResultFragment;
        }

        private SendFeedbackFragment injectSendFeedbackFragment(SendFeedbackFragment sendFeedbackFragment) {
            SendFeedbackFragment_MembersInjector.injectAptoideInstalledAppsRepository(sendFeedbackFragment, (AptoideInstalledAppsRepository) this.applicationComponent.provideInstalledRepositoryProvider.get());
            return sendFeedbackFragment;
        }

        private SettingsFragment injectSettingsFragment(SettingsFragment settingsFragment) {
            SettingsFragment_MembersInjector.injectMarketName(settingsFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            SettingsFragment_MembersInjector.injectMarketResourceFormatter(settingsFragment, (MarketResourceFormatter) this.applicationComponent.provideMarketResourceFormatterProvider.get());
            SettingsFragment_MembersInjector.injectSupportEmailProvider(settingsFragment, (SupportEmailProvider) this.applicationComponent.providesSupportEmailProvider2.get());
            SettingsFragment_MembersInjector.injectThemeManager(settingsFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            SettingsFragment_MembersInjector.injectThemeAnalytics(settingsFragment, (ThemeAnalytics) this.applicationComponent.providesThemeAnalyticsProvider.get());
            SettingsFragment_MembersInjector.injectUpdatesRepository(settingsFragment, (UpdateRepository) this.applicationComponent.providesUpdateRepositoryProvider.get());
            SettingsFragment_MembersInjector.injectFileManager(settingsFragment, (FileManager) this.applicationComponent.providesFileManagerProvider.get());
            return settingsFragment;
        }

        private StoreFragment injectStoreFragment(StoreFragment storeFragment) {
            StoreFragment_MembersInjector.injectAnalyticsManager(storeFragment, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            StoreFragment_MembersInjector.injectNavigationTracker(storeFragment, (NavigationTracker) this.applicationComponent.provideNavigationTrackerProvider.get());
            StoreFragment_MembersInjector.injectAppNavigator(storeFragment, (AppNavigator) this.activityComponentImpl.providesAppNavigatorProvider.get());
            StoreFragment_MembersInjector.injectMarketName(storeFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            StoreFragment_MembersInjector.injectThemeManager(storeFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            StoreFragment_MembersInjector.injectMarketResourceFormatter(storeFragment, (MarketResourceFormatter) this.applicationComponent.provideMarketResourceFormatterProvider.get());
            StoreFragment_MembersInjector.injectStoreCredentialsProvider(storeFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            StoreFragment_MembersInjector.injectStoreRepository(storeFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            return storeFragment;
        }

        private StoreTabWidgetsGridRecyclerFragment injectStoreTabWidgetsGridRecyclerFragment(StoreTabWidgetsGridRecyclerFragment storeTabWidgetsGridRecyclerFragment) {
            StoreTabGridRecyclerFragment_MembersInjector.injectStoreRepository(storeTabWidgetsGridRecyclerFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(storeTabWidgetsGridRecyclerFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreUtilsProxy(storeTabWidgetsGridRecyclerFragment, (StoreUtilsProxy) this.applicationComponent.provideStoreUtilsProxyProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAptoideInstalledAppsRepository(storeTabWidgetsGridRecyclerFragment, (AptoideInstalledAppsRepository) this.applicationComponent.provideInstalledRepositoryProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAnalyticsManager(storeTabWidgetsGridRecyclerFragment, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectMarketName(storeTabWidgetsGridRecyclerFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectThemeManager(storeTabWidgetsGridRecyclerFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreCredentialsProvider(storeTabWidgetsGridRecyclerFragment, (StoreCredentialsProvider) this.applicationComponent.providesStoreCredentialsProvider.get());
            StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectStoreRepository(storeTabWidgetsGridRecyclerFragment, (RoomStoreRepository) this.applicationComponent.providesRoomStoreRepositoryProvider.get());
            return storeTabWidgetsGridRecyclerFragment;
        }

        private TimeLineFollowersFragment injectTimeLineFollowersFragment(TimeLineFollowersFragment timeLineFollowersFragment) {
            GridRecyclerSwipeWithToolbarFragment_MembersInjector.injectMarketName(timeLineFollowersFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            TimeLineFollowersFragment_MembersInjector.injectThemeManager(timeLineFollowersFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return timeLineFollowersFragment;
        }

        private TimeLineFollowingFragment injectTimeLineFollowingFragment(TimeLineFollowingFragment timeLineFollowingFragment) {
            GridRecyclerSwipeWithToolbarFragment_MembersInjector.injectMarketName(timeLineFollowingFragment, (String) this.applicationComponent.provideMarketNameProvider.get());
            TimeLineFollowingFragment_MembersInjector.injectThemeManager(timeLineFollowingFragment, (ThemeManager) this.activityComponentImpl.providesThemeManagerProvider.get());
            return timeLineFollowingFragment;
        }

        private TopStoresFragment injectTopStoresFragment(TopStoresFragment topStoresFragment) {
            TopStoresFragment_MembersInjector.injectAnalyticsManager(topStoresFragment, (AnalyticsManager) this.applicationComponent.providesAnalyticsManagerProvider.get());
            TopStoresFragment_MembersInjector.injectNavigationTracker(topStoresFragment, (NavigationTracker) this.applicationComponent.provideNavigationTrackerProvider.get());
            return topStoresFragment;
        }

        private WizardFragment injectWizardFragment(WizardFragment wizardFragment) {
            WizardFragment_MembersInjector.injectWizardPresenter(wizardFragment, this.providesWizardPresenterProvider.get());
            WizardFragment_MembersInjector.injectWizardFragmentProvider(wizardFragment, this.providesWizardFragmentProvider.get());
            return wizardFragment;
        }

        private WizardPageTwoFragment injectWizardPageTwoFragment(WizardPageTwoFragment wizardPageTwoFragment) {
            WizardPageTwoFragment_MembersInjector.injectMarketResourceFormatter(wizardPageTwoFragment, (MarketResourceFormatter) this.applicationComponent.provideMarketResourceFormatterProvider.get());
            return wizardPageTwoFragment;
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(LoginSignUpCredentialsFragment loginSignUpCredentialsFragment) {
            injectLoginSignUpCredentialsFragment(loginSignUpCredentialsFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(InboxFragment inboxFragment) {
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(WizardFragmentProvider wizardFragmentProvider) {
        }

        private FragmentComponentImpl(DaggerApplicationComponent daggerApplicationComponent, ActivityComponentImpl activityComponentImpl, FragmentModule fragmentModule, FlavourFragmentModule flavourFragmentModule) {
            this.fragmentComponentImpl = this;
            this.applicationComponent = daggerApplicationComponent;
            this.activityComponentImpl = activityComponentImpl;
            initialize(fragmentModule, flavourFragmentModule);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(ManageUserFragment manageUserFragment) {
            injectManageUserFragment(manageUserFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(ManageStoreFragment manageStoreFragment) {
            injectManageStoreFragment(manageStoreFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(SearchResultFragment searchResultFragment) {
            injectSearchResultFragment(searchResultFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(StoreFragment storeFragment) {
            injectStoreFragment(storeFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(CommentListFragment commentListFragment) {
            injectCommentListFragment(commentListFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(TopStoresFragment topStoresFragment) {
            injectTopStoresFragment(topStoresFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(LatestReviewsFragment latestReviewsFragment) {
            injectLatestReviewsFragment(latestReviewsFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(ListStoresFragment listStoresFragment) {
            injectListStoresFragment(listStoresFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(MyStoresSubscribedFragment myStoresSubscribedFragment) {
            injectMyStoresSubscribedFragment(myStoresSubscribedFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(StoreTabWidgetsGridRecyclerFragment storeTabWidgetsGridRecyclerFragment) {
            injectStoreTabWidgetsGridRecyclerFragment(storeTabWidgetsGridRecyclerFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(RecommendedStoresFragment recommendedStoresFragment) {
            injectRecommendedStoresFragment(recommendedStoresFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(MyStoresFragment myStoresFragment) {
            injectMyStoresFragment(myStoresFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(ProfileStepOneFragment profileStepOneFragment) {
            injectProfileStepOneFragment(profileStepOneFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(ProfileStepTwoFragment profileStepTwoFragment) {
            injectProfileStepTwoFragment(profileStepTwoFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(ListStoreAppsFragment listStoreAppsFragment) {
            injectListStoreAppsFragment(listStoreAppsFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(HomeFragment homeFragment) {
            injectHomeFragment(homeFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(AppsFragment appsFragment) {
            injectAppsFragment(appsFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(MyAccountFragment myAccountFragment) {
            injectMyAccountFragment(myAccountFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(AppViewFragment appViewFragment) {
            injectAppViewFragment(appViewFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(RateAndReviewsFragment rateAndReviewsFragment) {
            injectRateAndReviewsFragment(rateAndReviewsFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(MoreBundleFragment moreBundleFragment) {
            injectMoreBundleFragment(moreBundleFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(WizardFragment wizardFragment) {
            injectWizardFragment(wizardFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(AppCoinsInfoFragment appCoinsInfoFragment) {
            injectAppCoinsInfoFragment(appCoinsInfoFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(EditorialFragment editorialFragment) {
            injectEditorialFragment(editorialFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(PromotionsFragment promotionsFragment) {
            injectPromotionsFragment(promotionsFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(DescriptionFragment descriptionFragment) {
            injectDescriptionFragment(descriptionFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(TimeLineFollowingFragment timeLineFollowingFragment) {
            injectTimeLineFollowingFragment(timeLineFollowingFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(TimeLineFollowersFragment timeLineFollowersFragment) {
            injectTimeLineFollowersFragment(timeLineFollowersFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(GridRecyclerSwipeWithToolbarFragment gridRecyclerSwipeWithToolbarFragment) {
            injectGridRecyclerSwipeWithToolbarFragment(gridRecyclerSwipeWithToolbarFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(SettingsFragment settingsFragment) {
            injectSettingsFragment(settingsFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(WizardPageTwoFragment wizardPageTwoFragment) {
            injectWizardPageTwoFragment(wizardPageTwoFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(ClaimPromotionDialogFragment claimPromotionDialogFragment) {
            injectClaimPromotionDialogFragment(claimPromotionDialogFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(HomeContainerFragment homeContainerFragment) {
            injectHomeContainerFragment(homeContainerFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(EditorialListFragment editorialListFragment) {
            injectEditorialListFragment(editorialListFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(EarnAppcListFragment earnAppcListFragment) {
            injectEarnAppcListFragment(earnAppcListFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(ListAppsMoreFragment listAppsMoreFragment) {
            injectListAppsMoreFragment(listAppsMoreFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(AutoUpdateDialogFragment autoUpdateDialogFragment) {
            injectAutoUpdateDialogFragment(autoUpdateDialogFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(NewFeatureDialogFragment newFeatureDialogFragment) {
            injectNewFeatureDialogFragment(newFeatureDialogFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(CommentDialogFragment commentDialogFragment) {
            injectCommentDialogFragment(commentDialogFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(SendFeedbackFragment sendFeedbackFragment) {
            injectSendFeedbackFragment(sendFeedbackFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(ExcludedUpdatesFragment excludedUpdatesFragment) {
            injectExcludedUpdatesFragment(excludedUpdatesFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(OtherVersionsFragment otherVersionsFragment) {
            injectOtherVersionsFragment(otherVersionsFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(AddStoreDialog addStoreDialog) {
            injectAddStoreDialog(addStoreDialog);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(PrivateStoreDialog privateStoreDialog) {
            injectPrivateStoreDialog(privateStoreDialog);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(CheckYourEmailFragment checkYourEmailFragment) {
            injectCheckYourEmailFragment(checkYourEmailFragment);
        }

        @Override // cm.aptoide.pt.view.FragmentComponent
        public void inject(OutOfSpaceDialogFragment outOfSpaceDialogFragment) {
            injectOutOfSpaceDialogFragment(outOfSpaceDialogFragment);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(ApplicationModule applicationModule, FlavourApplicationModule flavourApplicationModule) {
        Provider<RoomMigrationProvider> providerA = f.b.a.a(ApplicationModule_ProvidesRoomMigrationProviderFactory.create(applicationModule));
        this.providesRoomMigrationProvider = providerA;
        Provider<AptoideDatabase> providerA2 = f.b.a.a(ApplicationModule_ProvidesAptoideDataBaseFactory.create(applicationModule, providerA));
        this.providesAptoideDataBaseProvider = providerA2;
        this.provideRoomNotificationPersistenceProvider = f.b.a.a(ApplicationModule_ProvideRoomNotificationPersistenceFactory.create(applicationModule, providerA2));
        this.providesInstallationAccessorProvider = f.b.a.a(ApplicationModule_ProvidesInstallationAccessorFactory.create(applicationModule, this.providesAptoideDataBaseProvider));
        Provider<RoomInstallationMapper> providerA3 = f.b.a.a(ApplicationModule_ProvidesRoomInstallationMapperFactory.create(applicationModule));
        this.providesRoomInstallationMapperProvider = providerA3;
        this.provideRoomInstalledPersistenceProvider = f.b.a.a(ApplicationModule_ProvideRoomInstalledPersistenceFactory.create(applicationModule, this.providesAptoideDataBaseProvider, this.providesInstallationAccessorProvider, providerA3));
        Provider<FileUtils> providerA4 = f.b.a.a(ApplicationModule_ProvideFileUtilsFactory.create(applicationModule));
        this.provideFileUtilsProvider = providerA4;
        this.provideInstalledRepositoryProvider = f.b.a.a(ApplicationModule_ProvideInstalledRepositoryFactory.create(applicationModule, this.provideRoomInstalledPersistenceProvider, providerA4));
        Provider<SharedPreferences> providerA5 = f.b.a.a(ApplicationModule_ProvidesDefaultSharedPerefencesFactory.create(applicationModule));
        this.providesDefaultSharedPerefencesProvider = providerA5;
        this.providesBaseRakamHostProvider = f.b.a.a(ApplicationModule_ProvidesBaseRakamHostFactory.create(applicationModule, providerA5));
        Provider<DownloadPersistence> providerA6 = f.b.a.a(ApplicationModule_ProvideDownloadPersistenceFactory.create(applicationModule, this.providesAptoideDataBaseProvider));
        this.provideDownloadPersistenceProvider = providerA6;
        this.provideDownloadsRepositoryProvider = f.b.a.a(ApplicationModule_ProvideDownloadsRepositoryFactory.create(applicationModule, providerA6));
        this.downloadStatusMapperProvider = f.b.a.a(ApplicationModule_DownloadStatusMapperFactory.create(applicationModule));
        Provider<DownloadAppFileMapper> providerA7 = f.b.a.a(ApplicationModule_ProvidesDownloadAppFileMapperFactory.create(applicationModule));
        this.providesDownloadAppFileMapperProvider = providerA7;
        this.providesDownloadAppMapperProvider = f.b.a.a(ApplicationModule_ProvidesDownloadAppMapperFactory.create(applicationModule, providerA7));
        this.provideCachePathProvider = f.b.a.a(ApplicationModule_ProvideCachePathFactory.create(applicationModule));
        Provider<ContentResolver> providerA8 = f.b.a.a(ApplicationModule_ProvideContentResolverFactory.create(applicationModule));
        this.provideContentResolverProvider = providerA8;
        this.provideIdsRepositoryProvider = f.b.a.a(ApplicationModule_ProvideIdsRepositoryFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider, providerA8));
        Provider<String> providerA9 = f.b.a.a(FlavourApplicationModule_ProvidePartnerIDFactory.create(flavourApplicationModule));
        this.providePartnerIDProvider = providerA9;
        this.provideUserAgentInterceptorDownloadsProvider = f.b.a.a(ApplicationModule_ProvideUserAgentInterceptorDownloadsFactory.create(applicationModule, this.provideIdsRepositoryProvider, providerA9));
        this.provideAccountManagerProvider = f.b.a.a(ApplicationModule_ProvideAccountManagerFactory.create(applicationModule));
        Provider<String> providerA10 = f.b.a.a(ApplicationModule_ProvideAccountTypeFactory.create(applicationModule));
        this.provideAccountTypeProvider = providerA10;
        Provider<AndroidAccountProvider> providerA11 = f.b.a.a(ApplicationModule_ProvideAndroidAccountProviderFactory.create(applicationModule, this.provideAccountManagerProvider, providerA10));
        this.provideAndroidAccountProvider = providerA11;
        this.provideAuthenticationPersistenceProvider = f.b.a.a(ApplicationModule_ProvideAuthenticationPersistenceFactory.create(applicationModule, providerA11));
        this.provideAppEventsLoggerProvider = f.b.a.a(ApplicationModule_ProvideAppEventsLoggerFactory.create(applicationModule));
        Provider<AnalyticsLogger> providerA12 = f.b.a.a(ApplicationModule_ProvidesAnalyticsDebugLoggerFactory.create(applicationModule));
        this.providesAnalyticsDebugLoggerProvider = providerA12;
        this.providesFacebookEventLoggerProvider = f.b.a.a(ApplicationModule_ProvidesFacebookEventLoggerFactory.create(applicationModule, this.provideAppEventsLoggerProvider, providerA12));
        Provider<FlurryEventLogger> providerA13 = f.b.a.a(ApplicationModule_ProvidesFlurryLoggerFactory.create(applicationModule, this.providesAnalyticsDebugLoggerProvider));
        this.providesFlurryLoggerProvider = providerA13;
        this.providesFlurryEventLoggerProvider = f.b.a.a(ApplicationModule_ProvidesFlurryEventLoggerFactory.create(applicationModule, providerA13));
        this.provideL2CacheProvider = f.b.a.a(ApplicationModule_ProvideL2CacheFactory.create(applicationModule));
        Provider<Interceptor> providerA14 = f.b.a.a(ApplicationModule_ProvideRetrofitLogInterceptorFactory.create(applicationModule));
        this.provideRetrofitLogInterceptorProvider = providerA14;
        this.providesOkHttpBuilderProvider = f.b.a.a(ApplicationModule_ProvidesOkHttpBuilderFactory.create(applicationModule, this.provideL2CacheProvider, this.providesDefaultSharedPerefencesProvider, providerA14));
        Provider<PreferencesPersister> providerA15 = f.b.a.a(ApplicationModule_ProvidesUserPreferencesPersisterFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider));
        this.providesUserPreferencesPersisterProvider = providerA15;
        Provider<AptoideMd5Manager> providerA16 = f.b.a.a(ApplicationModule_ProvidesAptoideMd5ManagerFactory.create(applicationModule, providerA15));
        this.providesAptoideMd5ManagerProvider = providerA16;
        Provider<Interceptor> providerA17 = f.b.a.a(ApplicationModule_ProvideUserAgentInterceptorFactory.create(applicationModule, this.provideIdsRepositoryProvider, providerA16));
        this.provideUserAgentInterceptorProvider = providerA17;
        Provider<OkHttpClient> providerA18 = f.b.a.a(ApplicationModule_ProvideOkHttpClientFactory.create(applicationModule, this.providesOkHttpBuilderProvider, providerA17));
        this.provideOkHttpClientProvider = providerA18;
        this.providesknockEventLoggerProvider = f.b.a.a(ApplicationModule_ProvidesknockEventLoggerFactory.create(applicationModule, providerA18));
        this.provideFacebookEventsProvider = f.b.a.a(ApplicationModule_ProvideFacebookEventsFactory.create(applicationModule));
        this.provideFlurryEventsProvider = f.b.a.a(ApplicationModule_ProvideFlurryEventsFactory.create(applicationModule));
        this.providesFlurrySessionLoggerProvider = f.b.a.a(ApplicationModule_ProvidesFlurrySessionLoggerFactory.create(applicationModule, this.providesFlurryLoggerProvider));
        this.providesAnalyticsNormalizerProvider = f.b.a.a(ApplicationModule_ProvidesAnalyticsNormalizerFactory.create(applicationModule));
        Provider<MapToJsonMapper> providerA19 = f.b.a.a(ApplicationModule_ProvidesMapToJsonMapperFactory.create(applicationModule));
        this.providesMapToJsonMapperProvider = providerA19;
        this.providesRakamEventLoggerProvider = f.b.a.a(ApplicationModule_ProvidesRakamEventLoggerFactory.create(applicationModule, this.providesAnalyticsDebugLoggerProvider, providerA19));
        this.providesRakamEventsProvider = f.b.a.a(ApplicationModule_ProvidesRakamEventsFactory.create(applicationModule));
        this.providesIndicativeEventLoggerProvider = f.b.a.a(ApplicationModule_ProvidesIndicativeEventLoggerFactory.create(applicationModule, this.providesAnalyticsDebugLoggerProvider));
        this.providesIndicativeEventsProvider = f.b.a.a(ApplicationModule_ProvidesIndicativeEventsFactory.create(applicationModule));
        Provider<FirebaseAnalytics> providerA20 = f.b.a.a(ApplicationModule_ProvideFirebaseAnalyticsFactory.create(applicationModule));
        this.provideFirebaseAnalyticsProvider = providerA20;
        this.providesFirebaseEventLoggerProvider = f.b.a.a(ApplicationModule_ProvidesFirebaseEventLoggerFactory.create(applicationModule, providerA20, this.providesAnalyticsDebugLoggerProvider));
        Provider<Collection<String>> providerA21 = f.b.a.a(ApplicationModule_ProvidesFirebaseEventsFactory.create(applicationModule));
        this.providesFirebaseEventsProvider = providerA21;
        Provider<AnalyticsManager> providerA22 = f.b.a.a(ApplicationModule_ProvidesAnalyticsManagerFactory.create(applicationModule, this.providesFacebookEventLoggerProvider, this.providesFlurryEventLoggerProvider, this.providesknockEventLoggerProvider, this.provideFacebookEventsProvider, this.provideFlurryEventsProvider, this.providesFlurrySessionLoggerProvider, this.providesAnalyticsNormalizerProvider, this.providesRakamEventLoggerProvider, this.providesRakamEventsProvider, this.providesIndicativeEventLoggerProvider, this.providesIndicativeEventsProvider, this.providesFirebaseEventLoggerProvider, providerA21, this.providesAnalyticsDebugLoggerProvider));
        this.providesAnalyticsManagerProvider = providerA22;
        Provider<PageViewsAnalytics> providerA23 = f.b.a.a(ApplicationModule_ProvidePageViewsAnalyticsFactory.create(applicationModule, providerA22));
        this.providePageViewsAnalyticsProvider = providerA23;
        this.provideNavigationTrackerProvider = f.b.a.a(ApplicationModule_ProvideNavigationTrackerFactory.create(applicationModule, providerA23, this.providesAnalyticsDebugLoggerProvider));
        this.providesConnectivityManagerProvider = f.b.a.a(ApplicationModule_ProvidesConnectivityManagerFactory.create(applicationModule));
        this.providesTelephonyManagerProvider = f.b.a.a(ApplicationModule_ProvidesTelephonyManagerFactory.create(applicationModule));
        this.provideAppSizeAnalyticsStringMapperProvider = f.b.a.a(ApplicationModule_ProvideAppSizeAnalyticsStringMapperFactory.create(applicationModule));
        Provider<DownloadSpeedIntervalMapper> providerA24 = f.b.a.a(ApplicationModule_ProvideDownloadSpeedIntervalMapperFactory.create(applicationModule));
        this.provideDownloadSpeedIntervalMapperProvider = providerA24;
        this.providesDownloadAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesDownloadAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider, this.providesConnectivityManagerProvider, this.providesTelephonyManagerProvider, this.provideAppSizeAnalyticsStringMapperProvider, providerA24));
        this.provideInstallAnalyticsProvider = f.b.a.a(ApplicationModule_ProvideInstallAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider, this.providesConnectivityManagerProvider, this.providesTelephonyManagerProvider, this.provideAppSizeAnalyticsStringMapperProvider));
        Provider<Md5Comparator> providerA25 = f.b.a.a(ApplicationModule_ProvidesMd5ComparatorFactory.create(applicationModule, this.provideCachePathProvider));
        this.providesMd5ComparatorProvider = providerA25;
        Provider<FileDownloaderProvider> providerA26 = f.b.a.a(ApplicationModule_ProvidesFileDownloaderProviderFactory.create(applicationModule, this.provideCachePathProvider, this.provideUserAgentInterceptorDownloadsProvider, this.provideAuthenticationPersistenceProvider, this.providesDownloadAnalyticsProvider, this.provideInstallAnalyticsProvider, providerA25));
        this.providesFileDownloaderProvider = providerA26;
        Provider<RetryFileDownloaderProvider> providerA27 = f.b.a.a(ApplicationModule_ProvidesRetryFileDownloaderProviderFactory.create(applicationModule, providerA26));
        this.providesRetryFileDownloaderProvider = providerA27;
        this.providesAppDownloaderProvider = f.b.a.a(ApplicationModule_ProvidesAppDownloaderProviderFactory.create(applicationModule, providerA27, this.providesDownloadAnalyticsProvider));
        this.provideApkPathProvider = f.b.a.a(ApplicationModule_ProvideApkPathFactory.create(applicationModule));
        Provider<String> providerA28 = f.b.a.a(ApplicationModule_ProvideObbPathFactory.create(applicationModule));
        this.provideObbPathProvider = providerA28;
        this.provideAptoideDownloadManagerProvider = f.b.a.a(ApplicationModule_ProvideAptoideDownloadManagerFactory.create(applicationModule, this.provideDownloadsRepositoryProvider, this.downloadStatusMapperProvider, this.providesDownloadAppMapperProvider, this.providesAppDownloaderProvider, this.provideApkPathProvider, providerA28, this.providesDownloadAnalyticsProvider));
        this.providesUpdatePersistenceProvider = f.b.a.a(ApplicationModule_ProvidesUpdatePersistenceFactory.create(applicationModule, this.providesAptoideDataBaseProvider));
        Provider<StorePersistence> providerA29 = f.b.a.a(ApplicationModule_ProvidesStorePersistenceFactory.create(applicationModule, this.providesAptoideDataBaseProvider));
        this.providesStorePersistenceProvider = providerA29;
        this.providesRoomStoreRepositoryProvider = f.b.a.a(ApplicationModule_ProvidesRoomStoreRepositoryFactory.create(applicationModule, providerA29));
        this.provideResourcesProvider = f.b.a.a(ApplicationModule_ProvideResourcesFactory.create(applicationModule));
        Provider<WindowManager> providerA30 = f.b.a.a(ApplicationModule_ProvideWindowManagerFactory.create(applicationModule));
        this.provideWindowManagerProvider = providerA30;
        this.provideQManagerProvider = f.b.a.a(ApplicationModule_ProvideQManagerFactory.create(applicationModule, this.provideResourcesProvider, providerA30));
        Provider<String> providerA31 = f.b.a.a(ApplicationModule_ProvideAptoidePackageFactory.create(applicationModule));
        this.provideAptoidePackageProvider = providerA31;
        this.provideBodyInterceptorPoolV7Provider = f.b.a.a(ApplicationModule_ProvideBodyInterceptorPoolV7Factory.create(applicationModule, this.provideAuthenticationPersistenceProvider, this.provideIdsRepositoryProvider, this.providesDefaultSharedPerefencesProvider, this.provideResourcesProvider, this.provideQManagerProvider, providerA31, this.providesAptoideMd5ManagerProvider));
        this.provideDefaultPreferencesProvider = f.b.a.a(ApplicationModule_ProvideDefaultPreferencesFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider));
        Provider<SecureCoderDecoder> providerA32 = f.b.a.a(ApplicationModule_ProvideSecureCoderDecoderFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider));
        this.provideSecureCoderDecoderProvider = providerA32;
        Provider<SecurePreferences> providerA33 = f.b.a.a(ApplicationModule_ProvidesSecurePerefencesFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider, providerA32));
        this.providesSecurePerefencesProvider = providerA33;
        this.provideLocalAdultContentProvider = f.b.a.a(FlavourApplicationModule_ProvideLocalAdultContentFactory.create(flavourApplicationModule, this.provideDefaultPreferencesProvider, providerA33));
        this.provideLongTimeoutOkHttpClientProvider = f.b.a.a(ApplicationModule_ProvideLongTimeoutOkHttpClientFactory.create(applicationModule, this.provideUserAgentInterceptorProvider, this.providesDefaultSharedPerefencesProvider, this.provideRetrofitLogInterceptorProvider));
        this.provideNoAuthenticationBodyInterceptorV3Provider = f.b.a.a(ApplicationModule_ProvideNoAuthenticationBodyInterceptorV3Factory.create(applicationModule, this.provideIdsRepositoryProvider, this.provideAptoidePackageProvider, this.providesAptoideMd5ManagerProvider));
        Provider<String> providerA34 = f.b.a.a(ApplicationModule_ProvideExtraIDFactory.create(applicationModule));
        this.provideExtraIDProvider = providerA34;
        this.provideTokenInvalidatorProvider = f.b.a.a(ApplicationModule_ProvideTokenInvalidatorFactory.create(applicationModule, this.provideOkHttpClientProvider, this.providesDefaultSharedPerefencesProvider, this.provideAuthenticationPersistenceProvider, this.provideNoAuthenticationBodyInterceptorV3Provider, providerA34));
        this.provideBodyInterceptorWebV7Provider = f.b.a.a(ApplicationModule_ProvideBodyInterceptorWebV7Factory.create(applicationModule, this.provideAuthenticationPersistenceProvider, this.provideIdsRepositoryProvider, this.providesDefaultSharedPerefencesProvider, this.provideResourcesProvider, this.provideQManagerProvider, this.provideAptoidePackageProvider, this.providesAptoideMd5ManagerProvider));
        Provider<RequestBodyFactory> providerA35 = f.b.a.a(ApplicationModule_ProvideRequestBodyFactoryFactory.create(applicationModule));
        this.provideRequestBodyFactoryProvider = providerA35;
        this.provideMultipartBodyInterceptorProvider = f.b.a.a(ApplicationModule_ProvideMultipartBodyInterceptorFactory.create(applicationModule, this.provideIdsRepositoryProvider, this.provideAuthenticationPersistenceProvider, providerA35));
        Provider<NetworkOperatorManager> providerA36 = f.b.a.a(ApplicationModule_ProvidesNetworkOperatorManagerFactory.create(applicationModule, this.providesTelephonyManagerProvider));
        this.providesNetworkOperatorManagerProvider = providerA36;
        this.providesBodyInterceptorV3Provider = f.b.a.a(ApplicationModule_ProvidesBodyInterceptorV3Factory.create(applicationModule, this.provideIdsRepositoryProvider, this.provideQManagerProvider, this.providesDefaultSharedPerefencesProvider, providerA36, this.provideAuthenticationPersistenceProvider, this.provideAptoidePackageProvider, this.providesAptoideMd5ManagerProvider));
        this.provideNonNullObjectMapperProvider = f.b.a.a(ApplicationModule_ProvideNonNullObjectMapperFactory.create(applicationModule));
        this.providesConverterFactoryProvider = f.b.a.a(ApplicationModule_ProvidesConverterFactoryFactory.create(applicationModule));
        this.provideAccountFactoryProvider = f.b.a.a(ApplicationModule_ProvideAccountFactoryFactory.create(applicationModule));
        this.provideOAuthModeProvider = f.b.a.a(ApplicationModule_ProvideOAuthModeProviderFactory.create(applicationModule));
        Provider<String> providerA37 = f.b.a.a(ApplicationModule_ProvidesBaseWebservicesHostFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider));
        this.providesBaseWebservicesHostProvider = providerA37;
        Provider<AptoideAuthenticationRx> providerA38 = f.b.a.a(ApplicationModule_ProvidesAptoideAuthenticationFactory.create(applicationModule, providerA37, this.provideOkHttpClientProvider));
        this.providesAptoideAuthenticationProvider = providerA38;
        Provider<AccountService> providerA39 = f.b.a.a(ApplicationModule_ProvideAccountServiceFactory.create(applicationModule, this.provideOkHttpClientProvider, this.provideLongTimeoutOkHttpClientProvider, this.providesDefaultSharedPerefencesProvider, this.provideAuthenticationPersistenceProvider, this.provideTokenInvalidatorProvider, this.provideBodyInterceptorPoolV7Provider, this.provideBodyInterceptorWebV7Provider, this.provideMultipartBodyInterceptorProvider, this.provideNoAuthenticationBodyInterceptorV3Provider, this.providesBodyInterceptorV3Provider, this.provideNonNullObjectMapperProvider, this.providesConverterFactoryProvider, this.provideExtraIDProvider, this.provideAccountFactoryProvider, this.provideOAuthModeProvider, providerA38));
        this.provideAccountServiceProvider = providerA39;
        Provider<AdultContent> providerA40 = f.b.a.a(FlavourApplicationModule_ProvideAdultContentFactory.create(flavourApplicationModule, this.provideLocalAdultContentProvider, providerA39));
        this.provideAdultContentProvider = providerA40;
        this.provideAccountSettingsBodyInterceptorPoolV7Provider = f.b.a.a(ApplicationModule_ProvideAccountSettingsBodyInterceptorPoolV7Factory.create(applicationModule, this.provideBodyInterceptorPoolV7Provider, providerA40));
        Provider<UpdateMapper> providerA41 = f.b.a.a(ApplicationModule_ProvidesUpdateMapperFactory.create(applicationModule));
        this.providesUpdateMapperProvider = providerA41;
        this.providesUpdateRepositoryProvider = f.b.a.a(ApplicationModule_ProvidesUpdateRepositoryFactory.create(applicationModule, this.providesUpdatePersistenceProvider, this.providesRoomStoreRepositoryProvider, this.provideIdsRepositoryProvider, this.provideAccountSettingsBodyInterceptorPoolV7Provider, this.provideOkHttpClientProvider, this.providesConverterFactoryProvider, this.provideTokenInvalidatorProvider, this.providesDefaultSharedPerefencesProvider, providerA41, this.provideInstalledRepositoryProvider));
        this.provideCacheHelperProvider = f.b.a.a(ApplicationModule_ProvideCacheHelperFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider, this.provideCachePathProvider));
        this.provideGoogleApiClientProvider = f.b.a.a(ApplicationModule_ProvideGoogleApiClientFactory.create(applicationModule));
        this.provideStoreManagerProvider = f.b.a.a(ApplicationModule_ProvideStoreManagerFactory.create(applicationModule, this.provideOkHttpClientProvider, this.provideMultipartBodyInterceptorProvider, this.providesBodyInterceptorV3Provider, this.provideAccountSettingsBodyInterceptorPoolV7Provider, this.providesDefaultSharedPerefencesProvider, this.provideTokenInvalidatorProvider, this.provideRequestBodyFactoryProvider, this.provideNonNullObjectMapperProvider, this.providesRoomStoreRepositoryProvider));
    }

    private void initialize2(ApplicationModule applicationModule, FlavourApplicationModule flavourApplicationModule) {
        this.provideLoginPreferencesProvider = f.b.a.a(FlavourApplicationModule_ProvideLoginPreferencesFactory.create(flavourApplicationModule));
        Provider<DatabaseStoreDataPersist> providerA = f.b.a.a(ApplicationModule_ProvidesDatabaseStoreDataPersistFactory.create(applicationModule, this.providesRoomStoreRepositoryProvider));
        this.providesDatabaseStoreDataPersistProvider = providerA;
        this.providesAccountPersistenceProvider = f.b.a.a(ApplicationModule_ProvidesAccountPersistenceFactory.create(applicationModule, this.provideAccountManagerProvider, providerA, this.provideAccountFactoryProvider, this.provideAndroidAccountProvider, this.provideAuthenticationPersistenceProvider));
        Provider<List<String>> providerA2 = f.b.a.a(ApplicationModule_ProvidesFacebookLoginPermissionsFactory.create(applicationModule));
        this.providesFacebookLoginPermissionsProvider = providerA2;
        this.provideAptoideAccountManagerProvider = f.b.a.a(ApplicationModule_ProvideAptoideAccountManagerFactory.create(applicationModule, this.provideAdultContentProvider, this.provideGoogleApiClientProvider, this.provideStoreManagerProvider, this.provideAccountServiceProvider, this.provideLoginPreferencesProvider, this.providesAccountPersistenceProvider, providerA2));
        this.provideRootAvailabilityManagerProvider = f.b.a.a(ApplicationModule_ProvideRootAvailabilityManagerFactory.create(applicationModule, this.providesSecurePerefencesProvider));
        Provider<NotificationProvider> providerA3 = f.b.a.a(ApplicationModule_ProvideNotificationProviderFactory.create(applicationModule, this.provideRoomNotificationPersistenceProvider));
        this.provideNotificationProvider = providerA3;
        Provider<RoomLocalNotificationSyncPersistence> providerA4 = f.b.a.a(ApplicationModule_ProvidesRoomLocalNotificationSyncPersistenceFactory.create(applicationModule, this.providesAptoideDataBaseProvider, providerA3));
        this.providesRoomLocalNotificationSyncPersistenceProvider = providerA4;
        Provider<SyncStorage> providerA5 = f.b.a.a(ApplicationModule_ProvideSyncStorageFactory.create(applicationModule, providerA4));
        this.provideSyncStorageProvider = providerA5;
        this.provideSyncSchedulerProvider = f.b.a.a(ApplicationModule_ProvideSyncSchedulerFactory.create(applicationModule, providerA5));
        Provider<PackageRepository> providerA6 = f.b.a.a(ApplicationModule_ProvidesPackageRepositoryFactory.create(applicationModule));
        this.providesPackageRepositoryProvider = providerA6;
        this.providesAdsApplicationVersionCodeProvider = f.b.a.a(ApplicationModule_ProvidesAdsApplicationVersionCodeProviderFactory.create(applicationModule, providerA6));
        Provider<OemidProvider> providerA7 = f.b.a.a(ApplicationModule_ProvidesOemidProviderFactory.create(applicationModule));
        this.providesOemidProvider = providerA7;
        this.provideAdsRepositoryProvider = f.b.a.a(ApplicationModule_ProvideAdsRepositoryFactory.create(applicationModule, this.provideIdsRepositoryProvider, this.provideAptoideAccountManagerProvider, this.provideOkHttpClientProvider, this.provideQManagerProvider, this.providesDefaultSharedPerefencesProvider, this.providesAdsApplicationVersionCodeProvider, this.providesConnectivityManagerProvider, providerA7));
        this.providesNewFeatureProvider = f.b.a.a(ApplicationModule_ProvidesNewFeatureFactory.create(applicationModule));
        Provider<LocalNotificationSyncManager> providerA8 = f.b.a.a(ApplicationModule_ProvidesLocalNotificationSyncManagerFactory.create(applicationModule, this.provideSyncSchedulerProvider, this.provideNotificationProvider));
        this.providesLocalNotificationSyncManagerProvider = providerA8;
        this.providesNewFeatureManagerProvider = f.b.a.a(ApplicationModule_ProvidesNewFeatureManagerFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider, this.providesNewFeatureProvider, providerA8));
        Provider<RoomStoredMinimalAdPersistence> providerA9 = f.b.a.a(ApplicationModule_ProvidesRoomStoreMinimalAdPersistenceFactory.create(applicationModule, this.providesAptoideDataBaseProvider));
        this.providesRoomStoreMinimalAdPersistenceProvider = providerA9;
        this.provideInstallationProvider = f.b.a.a(ApplicationModule_ProvideInstallationProviderFactory.create(applicationModule, this.provideAptoideDownloadManagerProvider, this.provideDownloadPersistenceProvider, this.provideInstalledRepositoryProvider, providerA9));
        this.providesInstallerAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesInstallerAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideInstallAnalyticsProvider, this.providesDefaultSharedPerefencesProvider, this.provideRootAvailabilityManagerProvider, this.provideNavigationTrackerProvider));
        Provider<AppInstallerStatusReceiver> providerA10 = f.b.a.a(ApplicationModule_ProvidesAppInstallerStatusReceiverFactory.create(applicationModule));
        this.providesAppInstallerStatusReceiverProvider = providerA10;
        this.providesAppInstallerProvider = f.b.a.a(ApplicationModule_ProvidesAppInstallerFactory.create(applicationModule, providerA10));
        Provider<RootInstallerProvider> providerA11 = f.b.a.a(ApplicationModule_ProvidesRootInstallerProviderFactory.create(applicationModule, this.providesInstallerAnalyticsProvider));
        this.providesRootInstallerProvider = providerA11;
        this.provideDefaultInstallerProvider = f.b.a.a(ApplicationModule_ProvideDefaultInstallerFactory.create(applicationModule, this.provideInstallationProvider, this.providesDefaultSharedPerefencesProvider, this.provideInstalledRepositoryProvider, this.provideRootAvailabilityManagerProvider, this.providesInstallerAnalyticsProvider, this.providesAppInstallerProvider, this.providesAppInstallerStatusReceiverProvider, providerA11));
        this.providesSecureSharedPreferencesProvider = f.b.a.a(ApplicationModule_ProvidesSecureSharedPreferencesFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider));
        this.providesForegroundManagerProvider = f.b.a.a(ApplicationModule_ProvidesForegroundManagerFactory.create(applicationModule));
        Provider<AptoideInstallPersistence> providerA12 = f.b.a.a(ApplicationModule_ProvidesAptoideInstallPersistenceFactory.create(applicationModule, this.providesAptoideDataBaseProvider));
        this.providesAptoideInstallPersistenceProvider = providerA12;
        Provider<AptoideInstallRepository> providerA13 = f.b.a.a(ApplicationModule_ProvidesAptoideInstallRepositoryFactory.create(applicationModule, providerA12));
        this.providesAptoideInstallRepositoryProvider = providerA13;
        this.providesAptoideInstallManagerProvider = f.b.a.a(ApplicationModule_ProvidesAptoideInstallManagerFactory.create(applicationModule, this.provideInstalledRepositoryProvider, providerA13));
        Provider<FilePathProvider> providerA14 = f.b.a.a(ApplicationModule_FilePathManagerFactory.create(applicationModule, this.provideCachePathProvider, this.provideApkPathProvider, this.provideObbPathProvider));
        this.filePathManagerProvider = providerA14;
        this.providesInstallAppSizeValidatorProvider = f.b.a.a(ApplicationModule_ProvidesInstallAppSizeValidatorFactory.create(applicationModule, providerA14));
        Provider<FileManager> providerA15 = f.b.a.a(ApplicationModule_ProvidesFileManagerFactory.create(applicationModule, this.provideCacheHelperProvider, this.provideCachePathProvider, this.provideAptoideDownloadManagerProvider, this.provideL2CacheProvider));
        this.providesFileManagerProvider = providerA15;
        Provider<InstallManager> providerA16 = f.b.a.a(ApplicationModule_ProvidesInstallManagerFactory.create(applicationModule, this.provideAptoideDownloadManagerProvider, this.provideDefaultInstallerProvider, this.provideRootAvailabilityManagerProvider, this.providesDefaultSharedPerefencesProvider, this.providesSecureSharedPreferencesProvider, this.provideDownloadsRepositoryProvider, this.provideInstalledRepositoryProvider, this.providesForegroundManagerProvider, this.providesAptoideInstallManagerProvider, this.providesInstallAppSizeValidatorProvider, providerA15));
        this.providesInstallManagerProvider = providerA16;
        this.providesReadyToInstallNotificationManagerProvider = f.b.a.a(ApplicationModule_ProvidesReadyToInstallNotificationManagerFactory.create(applicationModule, providerA16));
        this.providesThemeAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesThemeAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideFirebaseAnalyticsProvider));
        Provider<StoreCredentialsProvider> providerA17 = f.b.a.a(ApplicationModule_ProvidesStoreCredentialsProviderFactory.create(applicationModule, this.providesRoomStoreRepositoryProvider));
        this.providesStoreCredentialsProvider = providerA17;
        this.provideStoreUtilsProxyProvider = f.b.a.a(ApplicationModule_ProvideStoreUtilsProxyFactory.create(applicationModule, this.provideAptoideAccountManagerProvider, this.providesRoomStoreRepositoryProvider, this.provideOkHttpClientProvider, this.providesDefaultSharedPerefencesProvider, this.provideTokenInvalidatorProvider, this.provideAccountSettingsBodyInterceptorPoolV7Provider, providerA17));
        Provider<TrendingService> providerA18 = f.b.a.a(ApplicationModule_ProvidesTrendingServiceFactory.create(applicationModule, this.providesStoreCredentialsProvider, this.providesDefaultSharedPerefencesProvider, this.provideTokenInvalidatorProvider, this.providesConverterFactoryProvider, this.provideOkHttpClientProvider, this.provideAccountSettingsBodyInterceptorPoolV7Provider));
        this.providesTrendingServiceProvider = providerA18;
        this.providesTrendingManagerProvider = f.b.a.a(ApplicationModule_ProvidesTrendingManagerFactory.create(applicationModule, providerA18));
        this.provideAdultContentAnalyticsProvider = f.b.a.a(ApplicationModule_ProvideAdultContentAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider));
        this.provideNotificationAnalyticsProvider = f.b.a.a(ApplicationModule_ProvideNotificationAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider));
        this.provideSearchBaseUrlProvider = f.b.a.a(ApplicationModule_ProvideSearchBaseUrlFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider));
        Provider<CallAdapter.Factory> providerA19 = f.b.a.a(ApplicationModule_ProvidesCallAdapterFactoryFactory.create(applicationModule));
        this.providesCallAdapterFactoryProvider = providerA19;
        Provider<Retrofit> providerA20 = f.b.a.a(ApplicationModule_ProvidesSearchSuggestionsRetrofitFactory.create(applicationModule, this.provideSearchBaseUrlProvider, this.provideOkHttpClientProvider, this.providesConverterFactoryProvider, providerA19));
        this.providesSearchSuggestionsRetrofitProvider = providerA20;
        Provider<SearchSuggestionRemoteRepository> providerA21 = f.b.a.a(ApplicationModule_ProvidesSearchSuggestionRemoteRepositoryFactory.create(applicationModule, providerA20));
        this.providesSearchSuggestionRemoteRepositoryProvider = providerA21;
        this.providesSearchSuggestionManagerProvider = f.b.a.a(ApplicationModule_ProvidesSearchSuggestionManagerFactory.create(applicationModule, providerA21));
        this.providesSafetyNetClientProvider = f.b.a.a(ApplicationModule_ProvidesSafetyNetClientFactory.create(applicationModule));
        Provider<GmsStatusValueProvider> providerA22 = f.b.a.a(ApplicationModule_ProvidesGmsStatusValueProviderFactory.create(applicationModule));
        this.providesGmsStatusValueProvider = providerA22;
        this.providesFirstLaunchAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesFirstLaunchAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.providesAnalyticsDebugLoggerProvider, this.providesSafetyNetClientProvider, providerA22));
        this.provideInvalidRefreshTokenLogoutManagerProvider = f.b.a.a(ApplicationModule_ProvideInvalidRefreshTokenLogoutManagerFactory.create(applicationModule, this.provideAptoideAccountManagerProvider, this.provideTokenInvalidatorProvider));
        this.provideRootInstallationRetryHandlerProvider = f.b.a.a(ApplicationModule_ProvideRootInstallationRetryHandlerFactory.create(applicationModule, this.providesInstallManagerProvider));
        this.providesShortcutManagerProvider = f.b.a.a(ApplicationModule_ProvidesShortcutManagerFactory.create(applicationModule));
        this.providesSettingsManagerProvider = f.b.a.a(ApplicationModule_ProvidesSettingsManagerFactory.create(applicationModule));
        this.provideDefaultFollowedStoresProvider = f.b.a.a(ApplicationModule_ProvideDefaultFollowedStoresFactory.create(applicationModule));
        this.providesCrashReportsProvider = f.b.a.a(ApplicationModule_ProvidesCrashReportsFactory.create(applicationModule));
        this.providesSplitsMapperProvider = f.b.a.a(ApplicationModule_ProvidesSplitsMapperFactory.create(applicationModule));
        Provider<CampaignMapper> providerA23 = f.b.a.a(ApplicationModule_ProvideCampaignMapperFactory.create(applicationModule));
        this.provideCampaignMapperProvider = providerA23;
        Provider<AppService> providerA24 = f.b.a.a(ApplicationModule_ProvidesAppServiceFactory.create(applicationModule, this.providesStoreCredentialsProvider, this.provideAccountSettingsBodyInterceptorPoolV7Provider, this.provideOkHttpClientProvider, this.provideTokenInvalidatorProvider, this.providesDefaultSharedPerefencesProvider, this.providesSplitsMapperProvider, providerA23));
        this.providesAppServiceProvider = providerA24;
        Provider<AppCenterRepository> providerA25 = f.b.a.a(ApplicationModule_ProvidesAppCenterRepositoryFactory.create(applicationModule, providerA24));
        this.providesAppCenterRepositoryProvider = providerA25;
        Provider<AppCenter> providerA26 = f.b.a.a(ApplicationModule_ProvidesAppCenterFactory.create(applicationModule, providerA25));
        this.providesAppCenterProvider = providerA26;
        this.providesUpdatesNotificationWorkerFactoryProvider = f.b.a.a(ApplicationModule_ProvidesUpdatesNotificationWorkerFactoryFactory.create(applicationModule, this.providesUpdateRepositoryProvider, this.providesDefaultSharedPerefencesProvider, this.providesAptoideInstallManagerProvider, this.provideSyncSchedulerProvider, this.provideSyncStorageProvider, this.providesCrashReportsProvider, providerA26));
        Provider<FollowedStoresManager> providerA27 = f.b.a.a(ApplicationModule_ProvidesFollowedStoresManagerFactory.create(applicationModule, this.providesStoreCredentialsProvider, this.provideDefaultFollowedStoresProvider, this.provideStoreUtilsProxyProvider, this.provideAccountSettingsBodyInterceptorPoolV7Provider, this.provideAptoideAccountManagerProvider, this.provideOkHttpClientProvider, this.provideTokenInvalidatorProvider, this.providesDefaultSharedPerefencesProvider));
        this.providesFollowedStoresManagerProvider = providerA27;
        this.providesFirstLaunchManagerProvider = f.b.a.a(ApplicationModule_ProvidesFirstLaunchManagerFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider, this.provideIdsRepositoryProvider, providerA27, this.provideRootAvailabilityManagerProvider, this.provideAptoideAccountManagerProvider, this.providesShortcutManagerProvider));
        Provider<UpdateLaunchManager> providerA28 = f.b.a.a(ApplicationModule_ProvidesUpdateLaunchManagerFactory.create(applicationModule, this.providesFollowedStoresManagerProvider));
        this.providesUpdateLaunchManagerProvider = providerA28;
        this.providesLaunchManagerProvider = f.b.a.a(ApplicationModule_ProvidesLaunchManagerFactory.create(applicationModule, this.providesFirstLaunchManagerProvider, providerA28, this.providesSecureSharedPreferencesProvider));
        this.providesAppInBackgroundTrackerProvider = f.b.a.a(ApplicationModule_ProvidesAppInBackgroundTrackerFactory.create(applicationModule));
        Provider<Interceptor> providerA29 = f.b.a.a(ApplicationModule_ProvideUserAgentInterceptorV8Factory.create(applicationModule, this.provideIdsRepositoryProvider, this.provideAptoidePackageProvider, this.provideAuthenticationPersistenceProvider, this.providesAptoideMd5ManagerProvider));
        this.provideUserAgentInterceptorV8Provider = providerA29;
        this.provideV8OkHttpClientProvider = f.b.a.a(ApplicationModule_ProvideV8OkHttpClientFactory.create(applicationModule, this.providesOkHttpBuilderProvider, providerA29));
        Provider<String> providerA30 = f.b.a.a(ApplicationModule_ProvidesApichainBdsBaseHostFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider));
        this.providesApichainBdsBaseHostProvider = providerA30;
        Provider<Retrofit> providerA31 = f.b.a.a(ApplicationModule_ProvidesApiChainBDSRetrofitFactory.create(applicationModule, this.provideV8OkHttpClientProvider, this.providesConverterFactoryProvider, this.providesCallAdapterFactoryProvider, providerA30));
        this.providesApiChainBDSRetrofitProvider = providerA31;
        Provider<BonusAppcRemoteService.ServiceApi> providerA32 = f.b.a.a(ApplicationModule_ProvidesBonusAppcServiceApiFactory.create(applicationModule, providerA31));
        this.providesBonusAppcServiceApiProvider = providerA32;
        Provider<BonusAppcService> providerA33 = f.b.a.a(ApplicationModule_ProvidesBonusAppcServiceFactory.create(applicationModule, providerA32));
        this.providesBonusAppcServiceProvider = providerA33;
        this.providesAppCoinsManagerProvider = f.b.a.a(ApplicationModule_ProvidesAppCoinsManagerFactory.create(applicationModule, providerA33));
        this.provideFirebaseNotificationAnalyticsProvider = f.b.a.a(ApplicationModule_ProvideFirebaseNotificationAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider));
        this.providesCampaignAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesCampaignAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider));
        Provider<AppcMigrationPersistence> providerA34 = f.b.a.a(ApplicationModule_ProvidesAppcMigrationAccessorFactory.create(applicationModule, this.providesAptoideDataBaseProvider));
        this.providesAppcMigrationAccessorProvider = providerA34;
        Provider<AppcMigrationRepository> providerA35 = f.b.a.a(ApplicationModule_ProvidesAppcMigrationServiceFactory.create(applicationModule, providerA34));
        this.providesAppcMigrationServiceProvider = providerA35;
        this.providesAppcMigrationManagerProvider = f.b.a.a(ApplicationModule_ProvidesAppcMigrationManagerFactory.create(applicationModule, this.provideInstalledRepositoryProvider, providerA35));
        this.provideMarketNameProvider = f.b.a.a(ApplicationModule_ProvideMarketNameFactory.create(applicationModule));
        Provider<AppValidationAnalytics> providerA36 = f.b.a.a(ApplicationModule_ProvidesAppValidationAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider));
        this.providesAppValidationAnalyticsProvider = providerA36;
        this.providesAppValidatorProvider = f.b.a.a(ApplicationModule_ProvidesAppValidatorFactory.create(applicationModule, providerA36));
        Provider<SplitTypeSubFileTypeMapper> providerA37 = f.b.a.a(ApplicationModule_ProvideSplitTypeSubFileTypeMapperFactory.create(applicationModule));
        this.provideSplitTypeSubFileTypeMapperProvider = providerA37;
        this.provideDownloadFactoryProvider = f.b.a.a(ApplicationModule_ProvideDownloadFactoryFactory.create(applicationModule, this.provideMarketNameProvider, this.provideCachePathProvider, this.providesAppValidatorProvider, providerA37));
        this.provideFragmentNavigatorMapProvider = f.b.a.a(ApplicationModule_ProvideFragmentNavigatorMapFactory.create(applicationModule));
        this.provideFragmentNavigatorRelayProvider = f.b.a.a(ApplicationModule_ProvideFragmentNavigatorRelayFactory.create(applicationModule));
        this.provideCallbackManagerProvider = f.b.a.a(ApplicationModule_ProvideCallbackManagerFactory.create(applicationModule));
        this.provideAccountAnalyticsProvider = f.b.a.a(ApplicationModule_ProvideAccountAnalyticsFactory.create(applicationModule, this.provideNavigationTrackerProvider, this.providesAnalyticsManagerProvider));
        this.providesSearchAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesSearchAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider));
        this.provideAptoideMmpBaseHostProvider = f.b.a.a(ApplicationModule_ProvideAptoideMmpBaseHostFactory.create(applicationModule));
        Provider<OkHttpClient.Builder> providerA38 = f.b.a.a(ApplicationModule_ProvidesAptoideMMPOkHttpBuilderFactory.create(applicationModule, this.provideL2CacheProvider, this.providesDefaultSharedPerefencesProvider, this.provideRetrofitLogInterceptorProvider));
        this.providesAptoideMMPOkHttpBuilderProvider = providerA38;
        Provider<OkHttpClient> providerA39 = f.b.a.a(ApplicationModule_ProvideAptoideMMpOkHttpClientFactory.create(applicationModule, providerA38, this.provideUserAgentInterceptorProvider));
        this.provideAptoideMMpOkHttpClientProvider = providerA39;
        Provider<Retrofit> providerA40 = f.b.a.a(ApplicationModule_ProvidesAptoideMmpRetrofitFactory.create(applicationModule, this.provideAptoideMmpBaseHostProvider, providerA39, this.providesConverterFactoryProvider, this.providesCallAdapterFactoryProvider));
        this.providesAptoideMmpRetrofitProvider = providerA40;
        Provider<AptoideApkfyService.ServiceApi> providerA41 = f.b.a.a(ApplicationModule_ProvidesApkfyServiceApiFactory.create(applicationModule, providerA40));
        this.providesApkfyServiceApiProvider = providerA41;
        Provider<ApkfyService> providerA42 = f.b.a.a(ApplicationModule_ProvideApkfyServiceFactory.create(applicationModule, providerA41));
        this.provideApkfyServiceProvider = providerA42;
        this.provideApkfyManagerProvider = f.b.a.a(ApplicationModule_ProvideApkfyManagerFactory.create(applicationModule, providerA42));
        this.provideDeepLinkAnalyticsProvider = f.b.a.a(ApplicationModule_ProvideDeepLinkAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider));
        this.providesAppShortcutsAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesAppShortcutsAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider));
        this.providesStoreAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesStoreAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider));
        this.providesUpdatesManagerProvider = f.b.a.a(ApplicationModule_ProvidesUpdatesManagerFactory.create(applicationModule, this.providesUpdateRepositoryProvider));
        this.providePermissionManagerProvider = f.b.a.a(ApplicationModule_ProvidePermissionManagerFactory.create(applicationModule));
    }

    private void initialize3(ApplicationModule applicationModule, FlavourApplicationModule flavourApplicationModule) {
        Provider<String> providerA = f.b.a.a(ApplicationModule_ProvidesBaseHostCacheFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider));
        this.providesBaseHostCacheProvider = providerA;
        Provider<Retrofit> providerA2 = f.b.a.a(ApplicationModule_ProvidesV7CacheRetrofitFactory.create(applicationModule, providerA, this.provideOkHttpClientProvider, this.providesConverterFactoryProvider, this.providesCallAdapterFactoryProvider));
        this.providesV7CacheRetrofitProvider = providerA2;
        this.providesAutoUpdateServiceProvider = f.b.a.a(ApplicationModule_ProvidesAutoUpdateServiceFactory.create(applicationModule, providerA2));
        this.providesAgentPersistenceProvider = f.b.a.a(ApplicationModule_ProvidesAgentPersistenceFactory.create(applicationModule, this.providesSecureSharedPreferencesProvider));
        this.provideMarketResourceFormatterProvider = f.b.a.a(ApplicationModule_ProvideMarketResourceFormatterFactory.create(applicationModule, this.provideMarketNameProvider));
        this.providesDownloadStateParserProvider = f.b.a.a(ApplicationModule_ProvidesDownloadStateParserFactory.create(applicationModule));
        Provider<WalletAdsOfferManager> providerA3 = f.b.a.a(FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory.create(flavourApplicationModule));
        this.providesWalletAdsOfferManagerProvider = providerA3;
        this.providesMoPubAdsManagerProvider = f.b.a.a(ApplicationModule_ProvidesMoPubAdsManagerFactory.create(applicationModule, providerA3));
        this.splitAnalyticsMapperProvider = f.b.a.a(ApplicationModule_SplitAnalyticsMapperFactory.create(applicationModule));
        this.providesWalletAppProvider = f.b.a.a(ApplicationModule_ProvidesWalletAppProviderFactory.create(applicationModule, this.providesAppCenterProvider, this.provideInstalledRepositoryProvider, this.providesInstallManagerProvider, this.providesDownloadStateParserProvider));
        this.providesDynamicSplitsApiProvider = f.b.a.a(ApplicationModule_ProvidesDynamicSplitsApiFactory.create(applicationModule, this.providesV7CacheRetrofitProvider));
        Provider<DynamicSplitsMapper> providerA4 = f.b.a.a(ApplicationModule_ProvidesDynamicSplitsMapperFactory.create(applicationModule));
        this.providesDynamicSplitsMapperProvider = providerA4;
        Provider<DynamicSplitsService> providerA5 = f.b.a.a(ApplicationModule_ProvidesDynamicSplitsServiceFactory.create(applicationModule, this.providesDynamicSplitsApiProvider, providerA4));
        this.providesDynamicSplitsServiceProvider = providerA5;
        this.providesDynamicSplitsManagerProvider = f.b.a.a(ApplicationModule_ProvidesDynamicSplitsManagerFactory.create(applicationModule, providerA5));
        Provider<String> providerA6 = f.b.a.a(FlavourApplicationModule_ProvidesSupportEmailFactory.create(flavourApplicationModule));
        this.providesSupportEmailProvider = providerA6;
        this.providesSupportEmailProvider2 = f.b.a.a(ApplicationModule_ProvidesSupportEmailProviderFactory.create(applicationModule, providerA6));
        this.providesImageInfoProvider = f.b.a.a(ApplicationModule_ProvidesImageInfoProviderFactory.create(applicationModule));
        this.providesNewsletterManagerProvider = f.b.a.a(ApplicationModule_ProvidesNewsletterManagerFactory.create(applicationModule));
        this.providesSearchRepositoryProvider = f.b.a.a(ApplicationModule_ProvidesSearchRepositoryFactory.create(applicationModule, this.providesRoomStoreRepositoryProvider, this.provideAccountSettingsBodyInterceptorPoolV7Provider, this.providesDefaultSharedPerefencesProvider, this.provideTokenInvalidatorProvider, this.provideOkHttpClientProvider, this.providesConverterFactoryProvider, this.providesOemidProvider, this.provideCampaignMapperProvider));
        this.providesDownloadStatusManagerProvider = f.b.a.a(ApplicationModule_ProvidesDownloadStatusManagerFactory.create(applicationModule, this.providesInstallManagerProvider, this.providesAppcMigrationManagerProvider));
        Provider<CampaignRepository> providerA7 = f.b.a.a(ApplicationModule_ProvideCampaignRepositoryFactory.create(applicationModule, this.provideOkHttpClientProvider));
        this.provideCampaignRepositoryProvider = providerA7;
        this.provideCampaignManagerProvider = f.b.a.a(ApplicationModule_ProvideCampaignManagerFactory.create(applicationModule, providerA7, this.providesSecureSharedPreferencesProvider));
        this.providesLoginSignupManagerProvider = f.b.a.a(ApplicationModule_ProvidesLoginSignupManagerFactory.create(applicationModule));
        Provider<BlacklistPersistence> providerA8 = f.b.a.a(ApplicationModule_ProvidesBlacklistPersistenceFactory.create(applicationModule, this.providesDefaultSharedPerefencesProvider));
        this.providesBlacklistPersistenceProvider = providerA8;
        this.providesBlacklisterProvider = f.b.a.a(ApplicationModule_ProvidesBlacklisterFactory.create(applicationModule, providerA8));
        Provider<BlacklistUnitMapper> providerA9 = f.b.a.a(ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory.create(applicationModule));
        this.providesBundleToBlacklistUnitMapperProvider = providerA9;
        Provider<BlacklistManager> providerA10 = f.b.a.a(ApplicationModule_ProvidesBlacklistManagerFactory.create(applicationModule, this.providesBlacklisterProvider, providerA9));
        this.providesBlacklistManagerProvider = providerA10;
        this.providesWalletAdsOfferCardManagerProvider = f.b.a.a(FlavourApplicationModule_ProvidesWalletAdsOfferCardManagerFactory.create(flavourApplicationModule, providerA10, this.providesPackageRepositoryProvider));
        Provider<AppComingSoonRegistrationPersistence> providerA11 = f.b.a.a(ApplicationModule_ProvidesAppComingSoonRegistrationPersistenceFactory.create(applicationModule, this.providesAptoideDataBaseProvider));
        this.providesAppComingSoonRegistrationPersistenceProvider = providerA11;
        Provider<AppComingSoonRegistrationManager> providerA12 = f.b.a.a(ApplicationModule_ProvidesAppComingSoonPreferencesManagerFactory.create(applicationModule, providerA11));
        this.providesAppComingSoonPreferencesManagerProvider = providerA12;
        Provider<BundlesResponseMapper> providerA13 = f.b.a.a(ApplicationModule_ProvidesBundlesMapperFactory.create(applicationModule, this.providesInstallManagerProvider, this.providesWalletAdsOfferCardManagerProvider, this.providesBlacklistManagerProvider, this.providesDownloadStateParserProvider, providerA12));
        this.providesBundlesMapperProvider = providerA13;
        Provider<BundleDataSource> providerA14 = f.b.a.a(ApplicationModule_ProvidesRemoteBundleDataSourceFactory.create(applicationModule, this.provideAccountSettingsBodyInterceptorPoolV7Provider, this.provideOkHttpClientProvider, this.providesConverterFactoryProvider, providerA13, this.provideTokenInvalidatorProvider, this.providesDefaultSharedPerefencesProvider, this.provideAptoideAccountManagerProvider, this.providesPackageRepositoryProvider, this.provideIdsRepositoryProvider, this.provideQManagerProvider, this.provideResourcesProvider, this.provideWindowManagerProvider, this.providesConnectivityManagerProvider, this.providesAdsApplicationVersionCodeProvider, this.providesOemidProvider, this.providesStoreCredentialsProvider, this.providesAppCoinsManagerProvider));
        this.providesRemoteBundleDataSourceProvider = providerA14;
        this.providesBundleRepositoryProvider = f.b.a.a(ApplicationModule_ProvidesBundleRepositoryFactory.create(applicationModule, providerA14));
        this.providesPromotionViewAppMapperProvider = f.b.a.a(ApplicationModule_ProvidesPromotionViewAppMapperFactory.create(applicationModule, this.providesDownloadStateParserProvider));
        this.providesPromotionsAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesPromotionsAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider, this.providesDownloadAnalyticsProvider, this.provideInstallAnalyticsProvider));
        Provider<PromotionsService> providerA15 = f.b.a.a(ApplicationModule_ProvidesPromotionsServiceFactory.create(applicationModule, this.provideAccountSettingsBodyInterceptorPoolV7Provider, this.provideOkHttpClientProvider, this.provideTokenInvalidatorProvider, this.providesConverterFactoryProvider, this.providesDefaultSharedPerefencesProvider, this.providesSplitsMapperProvider));
        this.providesPromotionsServiceProvider = providerA15;
        this.providePromotionsManagerProvider = f.b.a.a(ApplicationModule_ProvidePromotionsManagerFactory.create(applicationModule, this.providesInstallManagerProvider, this.providesPromotionViewAppMapperProvider, this.provideDownloadFactoryProvider, this.providesDownloadStateParserProvider, this.providesPromotionsAnalyticsProvider, this.provideNotificationAnalyticsProvider, this.provideInstallAnalyticsProvider, providerA15, this.provideInstalledRepositoryProvider, this.providesMoPubAdsManagerProvider, this.providesWalletAppProvider, this.providesDynamicSplitsManagerProvider, this.splitAnalyticsMapperProvider));
        this.providesPromotionsPreferencesManagerProvider = f.b.a.a(ApplicationModule_ProvidesPromotionsPreferencesManagerFactory.create(applicationModule, this.providesUserPreferencesPersisterProvider));
        this.provideHomePromotionsIdProvider = f.b.a.a(ApplicationModule_ProvideHomePromotionsIdFactory.create(applicationModule));
        Provider<String> providerA16 = f.b.a.a(ApplicationModule_ProvidesReactionsHostFactory.create(applicationModule));
        this.providesReactionsHostProvider = providerA16;
        Provider<Retrofit> providerA17 = f.b.a.a(ApplicationModule_ProvidesLoadTopReactionsRetrofitFactory.create(applicationModule, providerA16, this.provideV8OkHttpClientProvider, this.providesConverterFactoryProvider, this.providesCallAdapterFactoryProvider));
        this.providesLoadTopReactionsRetrofitProvider = providerA17;
        Provider<ReactionsRemoteService.ServiceV8> providerA18 = f.b.a.a(ApplicationModule_ProvidesReactionsServiceV8Factory.create(applicationModule, providerA17));
        this.providesReactionsServiceV8Provider = providerA18;
        Provider<ReactionsService> providerA19 = f.b.a.a(ApplicationModule_ProvidesReactionsServiceFactory.create(applicationModule, providerA18));
        this.providesReactionsServiceProvider = providerA19;
        this.providesReactionsManagerProvider = f.b.a.a(ApplicationModule_ProvidesReactionsManagerFactory.create(applicationModule, providerA19));
        this.providesComingSoonNotificationManagerProvider = f.b.a.a(ApplicationModule_ProvidesComingSoonNotificationManagerFactory.create(applicationModule, this.providesAppComingSoonPreferencesManagerProvider));
        this.providesAdMapperProvider = f.b.a.a(ApplicationModule_ProvidesAdMapperFactory.create(applicationModule));
        this.providesUserFeedbackAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesUserFeedbackAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider));
        this.providesCaptionBackgroundPainterProvider = f.b.a.a(ApplicationModule_ProvidesCaptionBackgroundPainterFactory.create(applicationModule));
        this.providesUpdatesAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesUpdatesAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider, this.provideInstallAnalyticsProvider));
        this.providesUpdatesNotificationManagerProvider = f.b.a.a(ApplicationModule_ProvidesUpdatesNotificationManagerFactory.create(applicationModule));
        this.providesMyAccountManagerProvider = f.b.a.a(ApplicationModule_ProvidesMyAccountManagerFactory.create(applicationModule));
        this.providesSocialMediaAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesSocialMediaAnalyticsFactory.create(applicationModule, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider));
        this.providesAppViewAnalyticsProvider = f.b.a.a(ApplicationModule_ProvidesAppViewAnalyticsFactory.create(applicationModule, this.providesDownloadAnalyticsProvider, this.providesAnalyticsManagerProvider, this.provideNavigationTrackerProvider, this.providesStoreAnalyticsProvider, this.provideInstallAnalyticsProvider));
        Provider<AppCoinsService> providerA20 = f.b.a.a(ApplicationModule_ProvidesAppCoinsServiceFactory.create(applicationModule, this.provideAccountSettingsBodyInterceptorPoolV7Provider, this.provideOkHttpClientProvider, this.provideTokenInvalidatorProvider, this.providesDefaultSharedPerefencesProvider, this.providesConverterFactoryProvider));
        this.providesAppCoinsServiceProvider = providerA20;
        this.providesAppCoinsAdvertisingManagerProvider = f.b.a.a(ApplicationModule_ProvidesAppCoinsAdvertisingManagerFactory.create(applicationModule, providerA20));
        Provider<ReviewsService> providerA21 = f.b.a.a(ApplicationModule_ProvidesReviewsServiceFactory.create(applicationModule, this.providesStoreCredentialsProvider, this.provideAccountSettingsBodyInterceptorPoolV7Provider, this.provideOkHttpClientProvider, this.provideTokenInvalidatorProvider, this.providesDefaultSharedPerefencesProvider));
        this.providesReviewsServiceProvider = providerA21;
        Provider<ReviewsRepository> providerA22 = f.b.a.a(ApplicationModule_ProvidesReviewsRepositoryFactory.create(applicationModule, providerA21));
        this.providesReviewsRepositoryProvider = providerA22;
        this.providesReviewsManagerProvider = f.b.a.a(ApplicationModule_ProvidesReviewsManagerFactory.create(applicationModule, providerA22));
        this.providesAdsManagerProvider = f.b.a.a(ApplicationModule_ProvidesAdsManagerFactory.create(applicationModule, this.provideAdsRepositoryProvider, this.providesRoomStoreMinimalAdPersistenceProvider));
        Provider<String> providerA23 = f.b.a.a(ApplicationModule_ProvidesAppsFlyerBaseUrlFactory.create(applicationModule));
        this.providesAppsFlyerBaseUrlProvider = providerA23;
        Provider<Retrofit> providerA24 = f.b.a.a(ApplicationModule_ProvidesAppsFlyerRetrofitFactory.create(applicationModule, providerA23, this.provideOkHttpClientProvider, this.providesConverterFactoryProvider, this.providesCallAdapterFactoryProvider));
        this.providesAppsFlyerRetrofitProvider = providerA24;
        Provider<AppsFlyerService> providerA25 = f.b.a.a(ApplicationModule_ProvidesAppsFlyerServiceFactory.create(applicationModule, providerA24));
        this.providesAppsFlyerServiceProvider = providerA25;
        Provider<AppsFlyerRepository> providerA26 = f.b.a.a(ApplicationModule_ProvidesAppsFlyerRepositoryFactory.create(applicationModule, providerA25));
        this.providesAppsFlyerRepositoryProvider = providerA26;
        this.providesAppsFlyerManagerProvider = f.b.a.a(ApplicationModule_ProvidesAppsFlyerManagerFactory.create(applicationModule, providerA26));
        this.providesDecimalFormatProvider = f.b.a.a(ApplicationModule_ProvidesDecimalFormatFactory.create(applicationModule));
        this.providesChipManagerProvider = f.b.a.a(ApplicationModule_ProvidesChipManagerFactory.create(applicationModule));
        this.providesEditorialServiceProvider = f.b.a.a(ApplicationModule_ProvidesEditorialServiceFactory.create(applicationModule, this.provideAccountSettingsBodyInterceptorPoolV7Provider, this.provideOkHttpClientProvider, this.providesConverterFactoryProvider, this.provideTokenInvalidatorProvider, this.providesDefaultSharedPerefencesProvider, this.providesSplitsMapperProvider, this.provideCampaignMapperProvider));
    }

    private AptoideApplication injectAptoideApplication(AptoideApplication aptoideApplication) {
        AptoideApplication_MembersInjector.injectAptoideDatabase(aptoideApplication, this.providesAptoideDataBaseProvider.get());
        AptoideApplication_MembersInjector.injectNotificationPersistence(aptoideApplication, this.provideRoomNotificationPersistenceProvider.get());
        AptoideApplication_MembersInjector.injectAptoideInstalledAppsRepository(aptoideApplication, this.provideInstalledRepositoryProvider.get());
        AptoideApplication_MembersInjector.injectRakamBaseHost(aptoideApplication, this.providesBaseRakamHostProvider.get());
        AptoideApplication_MembersInjector.injectAptoideDownloadManager(aptoideApplication, this.provideAptoideDownloadManagerProvider.get());
        AptoideApplication_MembersInjector.injectUpdateRepository(aptoideApplication, this.providesUpdateRepositoryProvider.get());
        AptoideApplication_MembersInjector.injectCacheHelper(aptoideApplication, this.provideCacheHelperProvider.get());
        AptoideApplication_MembersInjector.injectAccountManager(aptoideApplication, this.provideAptoideAccountManagerProvider.get());
        AptoideApplication_MembersInjector.injectPreferences(aptoideApplication, this.provideDefaultPreferencesProvider.get());
        AptoideApplication_MembersInjector.injectSecurePreferences(aptoideApplication, this.providesSecurePerefencesProvider.get());
        AptoideApplication_MembersInjector.injectAdultContent(aptoideApplication, this.provideAdultContentProvider.get());
        AptoideApplication_MembersInjector.injectIdsRepository(aptoideApplication, this.provideIdsRepositoryProvider.get());
        AptoideApplication_MembersInjector.injectDefaultClient(aptoideApplication, this.provideOkHttpClientProvider.get());
        AptoideApplication_MembersInjector.injectRootAvailabilityManager(aptoideApplication, this.provideRootAvailabilityManagerProvider.get());
        AptoideApplication_MembersInjector.injectAuthenticationPersistence(aptoideApplication, this.provideAuthenticationPersistenceProvider.get());
        AptoideApplication_MembersInjector.injectAlarmSyncScheduler(aptoideApplication, this.provideSyncSchedulerProvider.get());
        AptoideApplication_MembersInjector.injectBodyInterceptorPoolV7(aptoideApplication, this.provideAccountSettingsBodyInterceptorPoolV7Provider.get());
        AptoideApplication_MembersInjector.injectBodyInterceptorWebV7(aptoideApplication, this.provideBodyInterceptorWebV7Provider.get());
        AptoideApplication_MembersInjector.injectBodyInterceptorV3(aptoideApplication, this.providesBodyInterceptorV3Provider.get());
        AptoideApplication_MembersInjector.injectHttpClientCache(aptoideApplication, this.provideL2CacheProvider.get());
        AptoideApplication_MembersInjector.injectQManager(aptoideApplication, this.provideQManagerProvider.get());
        AptoideApplication_MembersInjector.injectTokenInvalidator(aptoideApplication, this.provideTokenInvalidatorProvider.get());
        AptoideApplication_MembersInjector.injectPackageRepository(aptoideApplication, this.providesPackageRepositoryProvider.get());
        AptoideApplication_MembersInjector.injectApplicationVersionCodeProvider(aptoideApplication, this.providesAdsApplicationVersionCodeProvider.get());
        AptoideApplication_MembersInjector.injectAdsRepository(aptoideApplication, this.provideAdsRepositoryProvider.get());
        AptoideApplication_MembersInjector.injectSyncStorage(aptoideApplication, this.provideSyncStorageProvider.get());
        AptoideApplication_MembersInjector.injectNavigationTracker(aptoideApplication, this.provideNavigationTrackerProvider.get());
        AptoideApplication_MembersInjector.injectNewFeature(aptoideApplication, this.providesNewFeatureProvider.get());
        AptoideApplication_MembersInjector.injectNewFeatureManager(aptoideApplication, this.providesNewFeatureManagerProvider.get());
        AptoideApplication_MembersInjector.injectReadyToInstallNotificationManager(aptoideApplication, this.providesReadyToInstallNotificationManagerProvider.get());
        AptoideApplication_MembersInjector.injectThemeAnalytics(aptoideApplication, this.providesThemeAnalyticsProvider.get());
        AptoideApplication_MembersInjector.injectAccountSettingsBodyInterceptorPoolV7(aptoideApplication, this.provideAccountSettingsBodyInterceptorPoolV7Provider.get());
        AptoideApplication_MembersInjector.injectStoreCredentials(aptoideApplication, this.providesStoreCredentialsProvider.get());
        AptoideApplication_MembersInjector.injectStoreUtilsProxy(aptoideApplication, this.provideStoreUtilsProxyProvider.get());
        AptoideApplication_MembersInjector.injectTrendingManager(aptoideApplication, this.providesTrendingManagerProvider.get());
        AptoideApplication_MembersInjector.injectAdultContentAnalytics(aptoideApplication, this.provideAdultContentAnalyticsProvider.get());
        AptoideApplication_MembersInjector.injectNotificationAnalytics(aptoideApplication, this.provideNotificationAnalyticsProvider.get());
        AptoideApplication_MembersInjector.injectSearchSuggestionManager(aptoideApplication, this.providesSearchSuggestionManagerProvider.get());
        AptoideApplication_MembersInjector.injectAnalyticsManager(aptoideApplication, this.providesAnalyticsManagerProvider.get());
        AptoideApplication_MembersInjector.injectFirstLaunchAnalytics(aptoideApplication, this.providesFirstLaunchAnalyticsProvider.get());
        AptoideApplication_MembersInjector.injectInvalidRefreshTokenLogoutManager(aptoideApplication, this.provideInvalidRefreshTokenLogoutManagerProvider.get());
        AptoideApplication_MembersInjector.injectRootInstallationRetryHandler(aptoideApplication, this.provideRootInstallationRetryHandlerProvider.get());
        AptoideApplication_MembersInjector.injectShortcutManager(aptoideApplication, this.providesShortcutManagerProvider.get());
        AptoideApplication_MembersInjector.injectSettingsManager(aptoideApplication, this.providesSettingsManagerProvider.get());
        AptoideApplication_MembersInjector.injectInstallManager(aptoideApplication, this.providesInstallManagerProvider.get());
        AptoideApplication_MembersInjector.injectDefaultFollowedStores(aptoideApplication, this.provideDefaultFollowedStoresProvider.get());
        AptoideApplication_MembersInjector.injectOemidProvider(aptoideApplication, this.providesOemidProvider.get());
        AptoideApplication_MembersInjector.injectAptoideMd5Manager(aptoideApplication, this.providesAptoideMd5ManagerProvider.get());
        AptoideApplication_MembersInjector.injectAptoideWorkerFactory(aptoideApplication, this.providesUpdatesNotificationWorkerFactoryProvider.get());
        AptoideApplication_MembersInjector.injectLaunchManager(aptoideApplication, this.providesLaunchManagerProvider.get());
        AptoideApplication_MembersInjector.injectAppInBackgroundTracker(aptoideApplication, this.providesAppInBackgroundTrackerProvider.get());
        AptoideApplication_MembersInjector.injectAppCoinsManager(aptoideApplication, this.providesAppCoinsManagerProvider.get());
        AptoideApplication_MembersInjector.injectFileManager(aptoideApplication, this.providesFileManagerProvider.get());
        AptoideApplication_MembersInjector.injectFirebaseAnalytics(aptoideApplication, this.provideFirebaseAnalyticsProvider.get());
        return aptoideApplication;
    }

    private AptoideFirebaseNotificationService injectAptoideFirebaseNotificationService(AptoideFirebaseNotificationService aptoideFirebaseNotificationService) {
        AptoideFirebaseNotificationService_MembersInjector.injectFirebaseNotificationAnalytics(aptoideFirebaseNotificationService, this.provideFirebaseNotificationAnalyticsProvider.get());
        return aptoideFirebaseNotificationService;
    }

    private DownloadService injectDownloadService(DownloadService downloadService) {
        DownloadService_MembersInjector.injectDownloadManager(downloadService, this.provideAptoideDownloadManagerProvider.get());
        DownloadService_MembersInjector.injectAppInBackgroundTracker(downloadService, this.providesAppInBackgroundTrackerProvider.get());
        DownloadService_MembersInjector.injectNotificationProvider(downloadService, this.provideNotificationProvider.get());
        return downloadService;
    }

    private InstalledIntentService injectInstalledIntentService(InstalledIntentService installedIntentService) {
        InstalledIntentService_MembersInjector.injectInstallAnalytics(installedIntentService, this.provideInstallAnalyticsProvider.get());
        InstalledIntentService_MembersInjector.injectCampaignAnalytics(installedIntentService, this.providesCampaignAnalyticsProvider.get());
        InstalledIntentService_MembersInjector.injectAppcMigrationManager(installedIntentService, this.providesAppcMigrationManagerProvider.get());
        InstalledIntentService_MembersInjector.injectRoomStoredMinimalAdPersistence(installedIntentService, this.providesRoomStoreMinimalAdPersistenceProvider.get());
        InstalledIntentService_MembersInjector.injectUpdatesRepository(installedIntentService, this.providesUpdateRepositoryProvider.get());
        InstalledIntentService_MembersInjector.injectAptoideInstallManager(installedIntentService, this.providesAptoideInstallManagerProvider.get());
        InstalledIntentService_MembersInjector.injectFileUtils(installedIntentService, this.provideFileUtilsProvider.get());
        return installedIntentService;
    }

    private NotificationApplicationView injectNotificationApplicationView(NotificationApplicationView notificationApplicationView) {
        AptoideApplication_MembersInjector.injectAptoideDatabase(notificationApplicationView, this.providesAptoideDataBaseProvider.get());
        AptoideApplication_MembersInjector.injectNotificationPersistence(notificationApplicationView, this.provideRoomNotificationPersistenceProvider.get());
        AptoideApplication_MembersInjector.injectAptoideInstalledAppsRepository(notificationApplicationView, this.provideInstalledRepositoryProvider.get());
        AptoideApplication_MembersInjector.injectRakamBaseHost(notificationApplicationView, this.providesBaseRakamHostProvider.get());
        AptoideApplication_MembersInjector.injectAptoideDownloadManager(notificationApplicationView, this.provideAptoideDownloadManagerProvider.get());
        AptoideApplication_MembersInjector.injectUpdateRepository(notificationApplicationView, this.providesUpdateRepositoryProvider.get());
        AptoideApplication_MembersInjector.injectCacheHelper(notificationApplicationView, this.provideCacheHelperProvider.get());
        AptoideApplication_MembersInjector.injectAccountManager(notificationApplicationView, this.provideAptoideAccountManagerProvider.get());
        AptoideApplication_MembersInjector.injectPreferences(notificationApplicationView, this.provideDefaultPreferencesProvider.get());
        AptoideApplication_MembersInjector.injectSecurePreferences(notificationApplicationView, this.providesSecurePerefencesProvider.get());
        AptoideApplication_MembersInjector.injectAdultContent(notificationApplicationView, this.provideAdultContentProvider.get());
        AptoideApplication_MembersInjector.injectIdsRepository(notificationApplicationView, this.provideIdsRepositoryProvider.get());
        AptoideApplication_MembersInjector.injectDefaultClient(notificationApplicationView, this.provideOkHttpClientProvider.get());
        AptoideApplication_MembersInjector.injectRootAvailabilityManager(notificationApplicationView, this.provideRootAvailabilityManagerProvider.get());
        AptoideApplication_MembersInjector.injectAuthenticationPersistence(notificationApplicationView, this.provideAuthenticationPersistenceProvider.get());
        AptoideApplication_MembersInjector.injectAlarmSyncScheduler(notificationApplicationView, this.provideSyncSchedulerProvider.get());
        AptoideApplication_MembersInjector.injectBodyInterceptorPoolV7(notificationApplicationView, this.provideAccountSettingsBodyInterceptorPoolV7Provider.get());
        AptoideApplication_MembersInjector.injectBodyInterceptorWebV7(notificationApplicationView, this.provideBodyInterceptorWebV7Provider.get());
        AptoideApplication_MembersInjector.injectBodyInterceptorV3(notificationApplicationView, this.providesBodyInterceptorV3Provider.get());
        AptoideApplication_MembersInjector.injectHttpClientCache(notificationApplicationView, this.provideL2CacheProvider.get());
        AptoideApplication_MembersInjector.injectQManager(notificationApplicationView, this.provideQManagerProvider.get());
        AptoideApplication_MembersInjector.injectTokenInvalidator(notificationApplicationView, this.provideTokenInvalidatorProvider.get());
        AptoideApplication_MembersInjector.injectPackageRepository(notificationApplicationView, this.providesPackageRepositoryProvider.get());
        AptoideApplication_MembersInjector.injectApplicationVersionCodeProvider(notificationApplicationView, this.providesAdsApplicationVersionCodeProvider.get());
        AptoideApplication_MembersInjector.injectAdsRepository(notificationApplicationView, this.provideAdsRepositoryProvider.get());
        AptoideApplication_MembersInjector.injectSyncStorage(notificationApplicationView, this.provideSyncStorageProvider.get());
        AptoideApplication_MembersInjector.injectNavigationTracker(notificationApplicationView, this.provideNavigationTrackerProvider.get());
        AptoideApplication_MembersInjector.injectNewFeature(notificationApplicationView, this.providesNewFeatureProvider.get());
        AptoideApplication_MembersInjector.injectNewFeatureManager(notificationApplicationView, this.providesNewFeatureManagerProvider.get());
        AptoideApplication_MembersInjector.injectReadyToInstallNotificationManager(notificationApplicationView, this.providesReadyToInstallNotificationManagerProvider.get());
        AptoideApplication_MembersInjector.injectThemeAnalytics(notificationApplicationView, this.providesThemeAnalyticsProvider.get());
        AptoideApplication_MembersInjector.injectAccountSettingsBodyInterceptorPoolV7(notificationApplicationView, this.provideAccountSettingsBodyInterceptorPoolV7Provider.get());
        AptoideApplication_MembersInjector.injectStoreCredentials(notificationApplicationView, this.providesStoreCredentialsProvider.get());
        AptoideApplication_MembersInjector.injectStoreUtilsProxy(notificationApplicationView, this.provideStoreUtilsProxyProvider.get());
        AptoideApplication_MembersInjector.injectTrendingManager(notificationApplicationView, this.providesTrendingManagerProvider.get());
        AptoideApplication_MembersInjector.injectAdultContentAnalytics(notificationApplicationView, this.provideAdultContentAnalyticsProvider.get());
        AptoideApplication_MembersInjector.injectNotificationAnalytics(notificationApplicationView, this.provideNotificationAnalyticsProvider.get());
        AptoideApplication_MembersInjector.injectSearchSuggestionManager(notificationApplicationView, this.providesSearchSuggestionManagerProvider.get());
        AptoideApplication_MembersInjector.injectAnalyticsManager(notificationApplicationView, this.providesAnalyticsManagerProvider.get());
        AptoideApplication_MembersInjector.injectFirstLaunchAnalytics(notificationApplicationView, this.providesFirstLaunchAnalyticsProvider.get());
        AptoideApplication_MembersInjector.injectInvalidRefreshTokenLogoutManager(notificationApplicationView, this.provideInvalidRefreshTokenLogoutManagerProvider.get());
        AptoideApplication_MembersInjector.injectRootInstallationRetryHandler(notificationApplicationView, this.provideRootInstallationRetryHandlerProvider.get());
        AptoideApplication_MembersInjector.injectShortcutManager(notificationApplicationView, this.providesShortcutManagerProvider.get());
        AptoideApplication_MembersInjector.injectSettingsManager(notificationApplicationView, this.providesSettingsManagerProvider.get());
        AptoideApplication_MembersInjector.injectInstallManager(notificationApplicationView, this.providesInstallManagerProvider.get());
        AptoideApplication_MembersInjector.injectDefaultFollowedStores(notificationApplicationView, this.provideDefaultFollowedStoresProvider.get());
        AptoideApplication_MembersInjector.injectOemidProvider(notificationApplicationView, this.providesOemidProvider.get());
        AptoideApplication_MembersInjector.injectAptoideMd5Manager(notificationApplicationView, this.providesAptoideMd5ManagerProvider.get());
        AptoideApplication_MembersInjector.injectAptoideWorkerFactory(notificationApplicationView, this.providesUpdatesNotificationWorkerFactoryProvider.get());
        AptoideApplication_MembersInjector.injectLaunchManager(notificationApplicationView, this.providesLaunchManagerProvider.get());
        AptoideApplication_MembersInjector.injectAppInBackgroundTracker(notificationApplicationView, this.providesAppInBackgroundTrackerProvider.get());
        AptoideApplication_MembersInjector.injectAppCoinsManager(notificationApplicationView, this.providesAppCoinsManagerProvider.get());
        AptoideApplication_MembersInjector.injectFileManager(notificationApplicationView, this.providesFileManagerProvider.get());
        AptoideApplication_MembersInjector.injectFirebaseAnalytics(notificationApplicationView, this.provideFirebaseAnalyticsProvider.get());
        return notificationApplicationView;
    }

    private PullingContentService injectPullingContentService(PullingContentService pullingContentService) {
        PullingContentService_MembersInjector.injectMarketName(pullingContentService, this.provideMarketNameProvider.get());
        PullingContentService_MembersInjector.injectDownloadFactory(pullingContentService, this.provideDownloadFactoryProvider.get());
        PullingContentService_MembersInjector.injectUpdateRepository(pullingContentService, this.providesUpdateRepositoryProvider.get());
        return pullingContentService;
    }

    private ToolboxContentProvider injectToolboxContentProvider(ToolboxContentProvider toolboxContentProvider) {
        ToolboxContentProvider_MembersInjector.injectAuthenticationPersistence(toolboxContentProvider, this.provideAuthenticationPersistenceProvider.get());
        ToolboxContentProvider_MembersInjector.injectSharedPreferences(toolboxContentProvider, this.providesDefaultSharedPerefencesProvider.get());
        ToolboxContentProvider_MembersInjector.injectAccountManager(toolboxContentProvider, this.provideAptoideAccountManagerProvider.get());
        return toolboxContentProvider;
    }

    @Override // cm.aptoide.pt.ApplicationComponent
    public void inject(AptoideApplication aptoideApplication) {
        injectAptoideApplication(aptoideApplication);
    }

    @Override // cm.aptoide.pt.ApplicationComponent
    public ActivityComponent plus(ActivityModule activityModule, FlavourActivityModule flavourActivityModule) {
        f.b.b.b(activityModule);
        f.b.b.b(flavourActivityModule);
        return new ActivityComponentImpl(activityModule, flavourActivityModule);
    }

    private DaggerApplicationComponent(ApplicationModule applicationModule, FlavourApplicationModule flavourApplicationModule) {
        this.applicationComponent = this;
        initialize(applicationModule, flavourApplicationModule);
        initialize2(applicationModule, flavourApplicationModule);
        initialize3(applicationModule, flavourApplicationModule);
    }

    @Override // cm.aptoide.pt.ApplicationComponent
    public void inject(NotificationApplicationView notificationApplicationView) {
        injectNotificationApplicationView(notificationApplicationView);
    }

    @Override // cm.aptoide.pt.ApplicationComponent
    public void inject(ToolboxContentProvider toolboxContentProvider) {
        injectToolboxContentProvider(toolboxContentProvider);
    }

    @Override // cm.aptoide.pt.ApplicationComponent
    public void inject(DownloadService downloadService) {
        injectDownloadService(downloadService);
    }

    @Override // cm.aptoide.pt.ApplicationComponent
    public void inject(AptoideFirebaseNotificationService aptoideFirebaseNotificationService) {
        injectAptoideFirebaseNotificationService(aptoideFirebaseNotificationService);
    }

    @Override // cm.aptoide.pt.ApplicationComponent
    public void inject(InstalledIntentService installedIntentService) {
        injectInstalledIntentService(installedIntentService);
    }

    @Override // cm.aptoide.pt.ApplicationComponent
    public void inject(PullingContentService pullingContentService) {
        injectPullingContentService(pullingContentService);
    }
}
