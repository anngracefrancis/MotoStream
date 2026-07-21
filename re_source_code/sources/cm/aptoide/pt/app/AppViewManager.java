package cm.aptoide.pt.app;

import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.pt.AppCoinsManager;
import cm.aptoide.pt.R;
import cm.aptoide.pt.aab.DynamicSplitsManager;
import cm.aptoide.pt.aab.DynamicSplitsModel;
import cm.aptoide.pt.ads.MinimalAd;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.app.appsflyer.AppsFlyerManager;
import cm.aptoide.pt.app.migration.AppcMigrationManager;
import cm.aptoide.pt.app.mmpcampaigns.CampaignManager;
import cm.aptoide.pt.database.room.RoomDownload;
import cm.aptoide.pt.dataprovider.ws.v2.GenericResponseV2;
import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.download.InvalidAppException;
import cm.aptoide.pt.download.SplitAnalyticsMapper;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.InstallAnalytics;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.notification.AppcPromotionNotificationStringProvider;
import cm.aptoide.pt.notification.NotificationAnalytics;
import cm.aptoide.pt.notification.sync.LocalNotificationSync;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import cm.aptoide.pt.promotions.Promotion;
import cm.aptoide.pt.promotions.PromotionsManager;
import cm.aptoide.pt.promotions.WalletApp;
import cm.aptoide.pt.search.model.SearchAdResult;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.view.app.AppCenter;
import cm.aptoide.pt.view.app.AppsList;
import cm.aptoide.pt.view.app.FlagsVote;
import java.util.List;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AppViewManager {
    private final AdsManager adsManager;
    private final AppCenter appCenter;
    private final AppCoinsManager appCoinsManager;
    private final AppViewAnalytics appViewAnalytics;
    private final AppViewModelManager appViewModelManager;
    private final AppcMigrationManager appcMigrationManager;
    private final AppcPromotionNotificationStringProvider appcPromotionNotificationStringProvider;
    private AppsFlyerManager appsFlyerManager;
    private final AptoideAccountManager aptoideAccountManager;
    private SimilarAppsViewModel cachedAppcSimilarAppsViewModel;
    private PromotionViewModel cachedPromotionViewModel;
    private SimilarAppsViewModel cachedSimilarAppsViewModel;
    private CampaignManager campaignManager;
    private final DownloadFactory downloadFactory;
    private final DownloadStateParser downloadStateParser;
    private final DynamicSplitsManager dynamicSplitsManager;
    private final FlagManager flagManager;
    private final InstallAnalytics installAnalytics;
    private final InstallManager installManager;
    private final int limit;
    private final LocalNotificationSyncManager localNotificationSyncManager;
    private final String marketName;
    private final MoPubAdsManager moPubAdsManager;
    private final NotificationAnalytics notificationAnalytics;
    private final PromotionsManager promotionsManager;
    private final ReviewsManager reviewsManager;
    private SearchAdResult searchAdResult;
    private final SplitAnalyticsMapper splitAnalyticsMapper;
    private final StoreUtilsProxy storeUtilsProxy;
    private boolean isFirstLoad = true;
    private boolean appcPromotionImpressionSent = false;
    private boolean migrationImpressionSent = false;

    public AppViewManager(AppViewModelManager appViewModelManager, InstallManager installManager, DownloadFactory downloadFactory, AppCenter appCenter, ReviewsManager reviewsManager, AdsManager adsManager, FlagManager flagManager, StoreUtilsProxy storeUtilsProxy, AptoideAccountManager aptoideAccountManager, MoPubAdsManager moPubAdsManager, DownloadStateParser downloadStateParser, AppViewAnalytics appViewAnalytics, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, int i2, String str, AppCoinsManager appCoinsManager, PromotionsManager promotionsManager, AppcMigrationManager appcMigrationManager, LocalNotificationSyncManager localNotificationSyncManager, AppcPromotionNotificationStringProvider appcPromotionNotificationStringProvider, DynamicSplitsManager dynamicSplitsManager, SplitAnalyticsMapper splitAnalyticsMapper, AppsFlyerManager appsFlyerManager, CampaignManager campaignManager) {
        this.appViewModelManager = appViewModelManager;
        this.installManager = installManager;
        this.downloadFactory = downloadFactory;
        this.appCenter = appCenter;
        this.reviewsManager = reviewsManager;
        this.adsManager = adsManager;
        this.flagManager = flagManager;
        this.storeUtilsProxy = storeUtilsProxy;
        this.aptoideAccountManager = aptoideAccountManager;
        this.moPubAdsManager = moPubAdsManager;
        this.downloadStateParser = downloadStateParser;
        this.appViewAnalytics = appViewAnalytics;
        this.notificationAnalytics = notificationAnalytics;
        this.installAnalytics = installAnalytics;
        this.limit = i2;
        this.marketName = str;
        this.appCoinsManager = appCoinsManager;
        this.promotionsManager = promotionsManager;
        this.appcMigrationManager = appcMigrationManager;
        this.localNotificationSyncManager = localNotificationSyncManager;
        this.appcPromotionNotificationStringProvider = appcPromotionNotificationStringProvider;
        this.dynamicSplitsManager = dynamicSplitsManager;
        this.splitAnalyticsMapper = splitAnalyticsMapper;
        this.appsFlyerManager = appsFlyerManager;
        this.campaignManager = campaignManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createDownload, reason: merged with bridge method [inline-methods] */
    public rx.e<RoomDownload> k(final DownloadModel.Action action, final boolean z, final AppModel appModel, final DynamicSplitsModel dynamicSplitsModel) {
        return rx.e.S(appModel).G(new rx.m.e() { // from class: cm.aptoide.pt.app.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4113f.b(action, appModel, dynamicSplitsModel, (AppModel) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.app.h0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4131f.c(appModel, action, z, dynamicSplitsModel, (Throwable) obj);
            }
        });
    }

    private rx.e<List<Promotion>> getPromotions() {
        return this.appViewModelManager.getAppModel().k(new rx.m.e() { // from class: cm.aptoide.pt.app.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4117f.m((AppModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$convertCampaign$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(AppModel appModel) {
        return g.a.a.a.d.a(this.campaignManager.convertCampaign(appModel.getCampaign(), "Appview"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createDownload$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(DownloadModel.Action action, AppModel appModel, DynamicSplitsModel dynamicSplitsModel, AppModel appModel2) {
        return rx.e.S(this.downloadFactory.create(this.downloadStateParser.parseDownloadAction(action), appModel.getAppName(), appModel.getPackageName(), appModel.getMd5(), appModel.getIcon(), appModel.getVersionName(), appModel.getVersionCode(), appModel.getPath(), appModel.getPathAlt(), appModel.getObb(), appModel.hasAdvertising() || appModel.hasBilling(), appModel.getSize(), appModel.getSplits(), appModel.getRequiredSplits(), appModel.getMalware().getRank().toString(), appModel.getStore().getName(), appModel.getOemId(), dynamicSplitsModel.getDynamicSplitsList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createDownload$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(AppModel appModel, DownloadModel.Action action, boolean z, DynamicSplitsModel dynamicSplitsModel, Throwable th) {
        if (th instanceof InvalidAppException) {
            this.appViewAnalytics.sendInvalidAppEventError(appModel.getPackageName(), appModel.getVersionCode(), action, action != null && action.equals(DownloadModel.Action.MIGRATE), !appModel.getSplits().isEmpty(), appModel.hasAdvertising() || appModel.hasBilling(), appModel.getMalware().getRank().toString(), appModel.getStore().getName(), z, th, appModel.getObb() != null, this.splitAnalyticsMapper.getSplitTypesAsString(appModel.hasSplits(), dynamicSplitsModel.getDynamicSplitsList()), appModel.getAppCategory(), appModel.getSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(final DownloadModel.Action action, final boolean z, final long j2, final String str, final String str2, final AppModel appModel) {
        return rx.e.S(appModel).L(new rx.m.e() { // from class: cm.aptoide.pt.app.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4182f.j(appModel, (AppModel) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.app.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4121f.k(action, z, appModel, (DynamicSplitsModel) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.app.o
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4157f.l(action, j2, str, str2, z, appModel, (RoomDownload) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(DownloadModel.Action action, RoomDownload roomDownload) {
        if (action == DownloadModel.Action.MIGRATE) {
            this.appcMigrationManager.addMigrationCandidate(roomDownload.getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b f(RoomDownload roomDownload) {
        return this.installManager.x(roomDownload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g(WalletApp walletApp, DynamicSplitsModel dynamicSplitsModel) {
        return rx.e.S(this.downloadFactory.create(this.downloadStateParser.parseDownloadAction(walletApp.getDownloadModel().getAction()), walletApp.getAppName(), walletApp.getPackageName(), walletApp.getMd5sum(), walletApp.getIcon(), walletApp.getVersionName(), walletApp.getVersionCode(), walletApp.getPath(), walletApp.getPathAlt(), walletApp.getObb(), false, walletApp.getSize(), walletApp.getSplits(), walletApp.getRequiredSplits(), walletApp.getTrustedBadge(), walletApp.getStoreName(), dynamicSplitsModel.getDynamicSplitsList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(WalletApp walletApp, RoomDownload roomDownload) {
        setupDownloadEvents(roomDownload, walletApp.getDownloadModel().getAction(), walletApp.getId(), walletApp.getStoreName(), walletApp.getTrustedBadge(), false, true, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b i(RoomDownload roomDownload) {
        return this.installManager.x(roomDownload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single j(AppModel appModel, AppModel appModel2) {
        return g.a.a.a.d.d(this.dynamicSplitsManager.getAppSplitsByMd5(appModel.getMd5()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(DownloadModel.Action action, long j2, String str, String str2, boolean z, AppModel appModel, RoomDownload roomDownload) {
        setupDownloadEvents(roomDownload, action, j2, str, str2, roomDownload.getStoreName(), z, appModel.getBdsFlags().contains("STORE_BDS"), appModel.getAppCategory());
        if (DownloadModel.Action.MIGRATE.equals(action)) {
            setupMigratorUninstallEvent(roomDownload.getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getPromotions$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e m(AppModel appModel) {
        return this.promotionsManager.getPromotionsForPackage(appModel.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadAdsFromAppView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single n(AppModel appModel) {
        return this.adsManager.loadAds(appModel.getPackageName(), appModel.getStore().getName()).n(new rx.m.e() { // from class: cm.aptoide.pt.app.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return new SearchAdResult((MinimalAd) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadAppcSimilarAppsViewModel$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ SimilarAppsViewModel o(AppsList appsList) {
        SimilarAppsViewModel similarAppsViewModel = new SimilarAppsViewModel(null, appsList.getList(), appsList.isLoading(), appsList.getError(), null);
        this.cachedAppcSimilarAppsViewModel = similarAppsViewModel;
        return similarAppsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDownloadModel$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ DownloadModel p(Install install, Boolean bool) {
        return new DownloadModel(this.downloadStateParser.parseDownloadType(install.getType(), bool.booleanValue()), install.getProgress(), this.downloadStateParser.parseDownloadState(install.getState(), install.isIndeterminate()), install.getAppSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadPromotionViewModel$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ PromotionViewModel q(PromotionViewModel promotionViewModel, WalletApp walletApp, AppViewModel appViewModel) {
        return lambda$loadPromotionViewModel$24(walletApp, promotionViewModel.getPromotions(), appViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadPromotionViewModel$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e s(List list) {
        return rx.e.d(rx.e.S(list), this.promotionsManager.getWalletApp(), observeAppViewModel(), new rx.m.g() { // from class: cm.aptoide.pt.app.u
            @Override // rx.m.g
            public final Object a(Object obj, Object obj2, Object obj3) {
                return this.a.r((List) obj, (WalletApp) obj2, (AppViewModel) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadPromotionViewModel$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(PromotionViewModel promotionViewModel) {
        this.cachedPromotionViewModel = promotionViewModel;
    }

    static /* synthetic */ ReviewsViewModel lambda$loadReviewsViewModel$0(ReviewRequestResult reviewRequestResult) {
        return new ReviewsViewModel(reviewRequestResult.getReviewList(), reviewRequestResult.isLoading(), reviewRequestResult.getError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadSimilarAppsViewModel$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ SimilarAppsViewModel u(MinimalAdRequestResult minimalAdRequestResult, AppsList appsList) {
        SimilarAppsViewModel similarAppsViewModel = new SimilarAppsViewModel(minimalAdRequestResult.getAd(), appsList.getList(), appsList.isLoading(), appsList.getError(), minimalAdRequestResult.getError());
        this.cachedSimilarAppsViewModel = similarAppsViewModel;
        return similarAppsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadSimilarAppsViewModel$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single v(String str, final MinimalAdRequestResult minimalAdRequestResult) {
        return loadRecommended(this.limit, str).n(new rx.m.e() { // from class: cm.aptoide.pt.app.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4110f.u(minimalAdRequestResult, (AppsList) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(DownloadModel.Action action, long j2, String str, boolean z, boolean z2, String str2, RoomDownload roomDownload) {
        setupDownloadEvents(roomDownload, action, j2, roomDownload.getStoreName(), str, z, z2, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b x(RoomDownload roomDownload) {
        return this.installManager.x(roomDownload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$subscribeStore$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String str) {
        this.storeUtilsProxy.subscribeStore(str, null, null, this.aptoideAccountManager);
    }

    private Single<AppsList> loadAppcRecommended(int i2, String str) {
        return this.appCenter.loadAppcRecommendedApps(i2, str);
    }

    private Single<AppsList> loadRecommended(int i2, String str) {
        return this.appCenter.loadRecommendedApps(i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: mergeToPromotionViewModel, reason: merged with bridge method [inline-methods] */
    public PromotionViewModel r(WalletApp walletApp, List<Promotion> list, AppViewModel appViewModel) {
        return new PromotionViewModel(walletApp, list, appViewModel);
    }

    private void setupDownloadEvents(RoomDownload roomDownload, DownloadModel.Action action, long j2, String str, String str2, boolean z, boolean z2, String str3) {
        setupDownloadEvents(roomDownload, action, j2, str2, null, str, z, z2, str3);
    }

    public void allowRootInstall(Boolean bool) {
        this.installManager.rootInstallAllowed(bool.booleanValue());
    }

    public rx.b cancelDownload(String str, String str2, int i2) {
        return this.installManager.cancelInstall(str, str2, i2);
    }

    public rx.b convertCampaign() {
        return getAppModel().j(new rx.m.e() { // from class: cm.aptoide.pt.app.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4154f.a((AppModel) obj);
            }
        });
    }

    public rx.b downloadApp(final DownloadModel.Action action, final long j2, final String str, final String str2, final boolean z) {
        return getAppModel().k(new rx.m.e() { // from class: cm.aptoide.pt.app.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4174f.d(action, z, j2, str, str2, (AppModel) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.app.r
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4169f.e(action, (RoomDownload) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.app.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4108f.f((RoomDownload) obj);
            }
        }).X0();
    }

    public rx.e<DownloadModel> downloadStarted() {
        return this.appViewModelManager.observeAppViewModel().G(new rx.m.e() { // from class: cm.aptoide.pt.app.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return rx.e.S(((AppViewModel) obj).getDownloadModel());
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.app.a0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((DownloadModel) obj).isDownloading());
            }
        });
    }

    public Single<Boolean> flagApk(String str, String str2, FlagsVote.VoteType voteType) {
        return this.flagManager.flagApk(str, str2, voteType.name().toLowerCase()).n(new rx.m.e() { // from class: cm.aptoide.pt.app.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                GenericResponseV2 genericResponseV2 = (GenericResponseV2) obj;
                return Boolean.valueOf(genericResponseV2.isOk() && !genericResponseV2.hasErrors());
            }
        });
    }

    public Single<AppModel> getAppModel() {
        return this.appViewModelManager.getAppModel();
    }

    public Single<AppViewModel> getAppViewModel() {
        return this.appViewModelManager.getAppViewModel();
    }

    public SimilarAppsViewModel getCachedAppcSimilarAppsViewModel() {
        return this.cachedAppcSimilarAppsViewModel;
    }

    public SimilarAppsViewModel getCachedSimilarAppsViewModel() {
        return this.cachedSimilarAppsViewModel;
    }

    public Promotion getClaimablePromotion(List<Promotion> list, Promotion.ClaimAction claimAction) {
        return this.promotionsManager.getClaimablePromotion(list, claimAction);
    }

    public String getMarketName() {
        return this.marketName;
    }

    public SearchAdResult getSearchAdResult() {
        return this.searchAdResult;
    }

    public void handleAdsLogic(SearchAdResult searchAdResult) {
        this.adsManager.handleAdsLogic(searchAdResult);
    }

    public boolean hasClaimablePromotion(Promotion.ClaimAction claimAction) {
        PromotionViewModel promotionViewModel = this.cachedPromotionViewModel;
        return (promotionViewModel == null || getClaimablePromotion(promotionViewModel.getPromotions(), claimAction) == null) ? false : true;
    }

    public boolean isAppcPromotionImpressionSent() {
        return this.appcPromotionImpressionSent;
    }

    public boolean isMigrationImpressionSent() {
        return this.migrationImpressionSent;
    }

    public Single<SearchAdResult> loadAdsFromAppView() {
        return getAppModel().i(new rx.m.e() { // from class: cm.aptoide.pt.app.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4146f.n((AppModel) obj);
            }
        });
    }

    public Single<SimilarAppsViewModel> loadAppcSimilarAppsViewModel(String str) {
        SimilarAppsViewModel similarAppsViewModel = this.cachedAppcSimilarAppsViewModel;
        return similarAppsViewModel != null ? Single.m(similarAppsViewModel) : loadAppcRecommended(this.limit, str).n(new rx.m.e() { // from class: cm.aptoide.pt.app.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4148f.o((AppsList) obj);
            }
        });
    }

    public rx.e<DownloadModel> loadDownloadModel(String str, String str2, int i2, String str3, long j2, boolean z) {
        return rx.e.e(this.installManager.getInstall(str, str2, i2), this.appcMigrationManager.isMigrationApp(str2, str3, i2, j2, z), new rx.m.f() { // from class: cm.aptoide.pt.app.y
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return this.f4734f.p((Install) obj, (Boolean) obj2);
            }
        });
    }

    public rx.e<PromotionViewModel> loadPromotionViewModel() {
        rx.e eVarS = rx.e.S(new PromotionViewModel());
        PromotionViewModel promotionViewModel = this.cachedPromotionViewModel;
        return promotionViewModel != null ? rx.e.d(rx.e.S(promotionViewModel), this.promotionsManager.getWalletApp(), observeAppViewModel(), new rx.m.g() { // from class: cm.aptoide.pt.app.g
            @Override // rx.m.g
            public final Object a(Object obj, Object obj2, Object obj3) {
                return this.a.q((PromotionViewModel) obj, (WalletApp) obj2, (AppViewModel) obj3);
            }
        }) : getPromotions().D(new rx.m.e() { // from class: cm.aptoide.pt.app.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(!((List) obj).isEmpty());
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.app.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4172f.s((List) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.app.w
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4730f.t((PromotionViewModel) obj);
            }
        }).K0(eVarS);
    }

    public Single<ReviewsViewModel> loadReviewsViewModel(String str, String str2, String str3) {
        return this.reviewsManager.loadReviews(str, str2, 3, str3).n(new rx.m.e() { // from class: cm.aptoide.pt.app.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppViewManager.lambda$loadReviewsViewModel$0((ReviewRequestResult) obj);
            }
        });
    }

    public Single<SimilarAppsViewModel> loadSimilarAppsViewModel(final String str, List<String> list) {
        SimilarAppsViewModel similarAppsViewModel = this.cachedSimilarAppsViewModel;
        return similarAppsViewModel != null ? Single.m(similarAppsViewModel) : this.adsManager.loadAd(str, list).i(new rx.m.e() { // from class: cm.aptoide.pt.app.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4138f.v(str, (MinimalAdRequestResult) obj);
            }
        });
    }

    public rx.e<AppViewModel> observeAppViewModel() {
        return this.appViewModelManager.observeAppViewModel();
    }

    public rx.e<WalletApp> observeWalletInstallStatus() {
        return this.promotionsManager.getWalletApp();
    }

    public rx.b pauseDownload(String str) {
        return this.installManager.pauseInstall(str);
    }

    public Single<Boolean> registerAppsFlyerImpression(String str) {
        return str.equals("com.igg.android.lordsmobile") ? this.appsFlyerManager.registerImpression() : Single.m(Boolean.TRUE);
    }

    public rx.b resumeDownload(String str, final long j2, final DownloadModel.Action action, final String str2, final boolean z, final boolean z2, final String str3) {
        return this.installManager.getDownload(str).g(new rx.m.b() { // from class: cm.aptoide.pt.app.h
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4125f.w(action, j2, str2, z, z2, str3, (RoomDownload) obj);
            }
        }).e(new rx.m.b() { // from class: cm.aptoide.pt.app.f0
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).j(new rx.m.e() { // from class: cm.aptoide.pt.app.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4112f.x((RoomDownload) obj);
            }
        });
    }

    public void scheduleNotification(String str, String str2, String str3, String str4) {
        this.localNotificationSyncManager.schedule(String.format(this.appcPromotionNotificationStringProvider.getNotificationTitle(), str), this.appcPromotionNotificationStringProvider.getNotificationBody(), str2, R.string.promo_update2appc_notification_claim_button, "aptoideinstall://package=" + str3 + "&store=" + str4 + "&show_install_popup=false", LocalNotificationSync.APPC_CAMPAIGN_NOTIFICATION, 7, LocalNotificationSyncManager.FIVE_MINUTES);
    }

    public void sendAppOpenAnalytics(String str, String str2, String str3, boolean z, boolean z2) {
        if (this.isFirstLoad) {
            this.appViewAnalytics.sendAppViewOpenedFromEvent(str, str2, str3, z, z2);
            this.isFirstLoad = false;
        }
    }

    public void sendEditorsAppOpenAnalytics(String str, String str2, String str3, boolean z, boolean z2, String str4) {
        if (this.isFirstLoad) {
            this.appViewAnalytics.sendAppViewOpenedFromEvent(str, str2, str3, z, z2);
            this.appViewAnalytics.sendEditorsChoiceClickEvent(str, str4);
            this.isFirstLoad = false;
        }
    }

    public void setAppcPromotionImpressionSent() {
        this.appcPromotionImpressionSent = true;
    }

    public void setMigrationImpressionSent() {
        this.migrationImpressionSent = true;
    }

    public void setSearchAdResult(SearchAdResult searchAdResult) {
        this.searchAdResult = searchAdResult;
    }

    public void setupMigratorUninstallEvent(String str) {
        this.installAnalytics.uninstallStarted(str, AnalyticsManager.Action.INSTALL, DownloadAnalytics.AppContext.APPVIEW);
    }

    public boolean shouldShowRootInstallWarningPopup() {
        return this.installManager.showWarning();
    }

    public rx.b subscribeStore(final String str) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.app.p
            @Override // rx.m.a
            public final void call() {
                this.f4164f.y(str);
            }
        });
    }

    public void unscheduleNotificationSync() {
        this.localNotificationSyncManager.unschedule(LocalNotificationSync.APPC_CAMPAIGN_NOTIFICATION);
    }

    private void setupDownloadEvents(RoomDownload roomDownload, DownloadModel.Action action, long j2, String str, String str2, String str3, boolean z, boolean z2, String str4) {
        int campaignId = this.notificationAnalytics.getCampaignId(roomDownload.getPackageName(), j2);
        String abTestingGroup = this.notificationAnalytics.getAbTestingGroup(roomDownload.getPackageName(), j2);
        this.appViewAnalytics.setupDownloadEvents(roomDownload, campaignId, abTestingGroup, action, AnalyticsManager.Action.CLICK, str, str2, str3, z, this.splitAnalyticsMapper.getSplitTypesAsString(roomDownload.getSplits()), z2, str4);
        this.installAnalytics.installStarted(roomDownload.getPackageName(), roomDownload.getVersionCode(), AnalyticsManager.Action.INSTALL, DownloadAnalytics.AppContext.APPVIEW, this.downloadStateParser.getOrigin(roomDownload.getAction()), campaignId, abTestingGroup, action != null && action.equals(DownloadModel.Action.MIGRATE), roomDownload.hasAppc(), roomDownload.hasSplits(), str, str3, z, roomDownload.hasObbs(), this.splitAnalyticsMapper.getSplitTypesAsString(roomDownload.getSplits()), z2, str4, roomDownload.getSize());
    }

    public rx.b downloadApp(final WalletApp walletApp) {
        return g.a.a.a.d.d(this.dynamicSplitsManager.getAppSplitsByMd5(walletApp.getMd5sum())).k(new rx.m.e() { // from class: cm.aptoide.pt.app.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4143f.g(walletApp, (DynamicSplitsModel) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.app.x
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4732f.h(walletApp, (RoomDownload) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.app.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4167f.i((RoomDownload) obj);
            }
        }).X0();
    }
}
