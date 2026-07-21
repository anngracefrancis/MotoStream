package cm.aptoide.pt.promotions;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.aab.DynamicSplitsManager;
import cm.aptoide.pt.aab.DynamicSplitsModel;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.app.DownloadStateParser;
import cm.aptoide.pt.database.room.RoomDownload;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.download.SplitAnalyticsMapper;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.InstallAnalytics;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.notification.NotificationAnalytics;
import cm.aptoide.pt.wallet.WalletAppProvider;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class PromotionsManager {
    private final AptoideInstalledAppsRepository aptoideInstalledAppsRepository;
    private final DownloadFactory downloadFactory;
    private final DownloadStateParser downloadStateParser;
    private final DynamicSplitsManager dynamicSplitsManager;
    private final InstallAnalytics installAnalytics;
    private final InstallManager installManager;
    private final MoPubAdsManager moPubAdsManager;
    private final NotificationAnalytics notificationAnalytics;
    private final PackageManager packageManager;
    private final PromotionViewAppMapper promotionViewAppMapper;
    private final PromotionsAnalytics promotionsAnalytics;
    private final PromotionsService promotionsService;
    private final SplitAnalyticsMapper splitAnalyticsMapper;
    private final WalletAppProvider walletAppProvider;

    public PromotionsManager(PromotionViewAppMapper promotionViewAppMapper, InstallManager installManager, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, PromotionsAnalytics promotionsAnalytics, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, PackageManager packageManager, PromotionsService promotionsService, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, MoPubAdsManager moPubAdsManager, WalletAppProvider walletAppProvider, DynamicSplitsManager dynamicSplitsManager, SplitAnalyticsMapper splitAnalyticsMapper) {
        this.promotionViewAppMapper = promotionViewAppMapper;
        this.installManager = installManager;
        this.downloadFactory = downloadFactory;
        this.downloadStateParser = downloadStateParser;
        this.promotionsAnalytics = promotionsAnalytics;
        this.notificationAnalytics = notificationAnalytics;
        this.installAnalytics = installAnalytics;
        this.packageManager = packageManager;
        this.promotionsService = promotionsService;
        this.aptoideInstalledAppsRepository = aptoideInstalledAppsRepository;
        this.moPubAdsManager = moPubAdsManager;
        this.walletAppProvider = walletAppProvider;
        this.dynamicSplitsManager = dynamicSplitsManager;
        this.splitAnalyticsMapper = splitAnalyticsMapper;
    }

    private int getTotalAppc(List<PromotionApp> list) {
        Iterator<PromotionApp> it = list.iterator();
        int appcValue = 0;
        while (it.hasNext()) {
            appcValue = (int) (appcValue + it.next().getAppcValue());
        }
        return appcValue;
    }

    private boolean isWalletInstalled() {
        Iterator<ApplicationInfo> it = this.packageManager.getInstalledApplications(0).iterator();
        while (it.hasNext()) {
            if (it.next().packageName.equals(AptoideApplication.APPCOINS_WALLET_PACKAGE_NAME)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(PromotionViewApp promotionViewApp, DynamicSplitsModel dynamicSplitsModel) {
        return rx.e.S(this.downloadFactory.create(this.downloadStateParser.parseDownloadAction(promotionViewApp.getDownloadModel().getAction()), promotionViewApp.getName(), promotionViewApp.getPackageName(), promotionViewApp.getMd5(), promotionViewApp.getAppIcon(), promotionViewApp.getVersionName(), promotionViewApp.getVersionCode(), promotionViewApp.getDownloadPath(), promotionViewApp.getAlternativePath(), promotionViewApp.getObb(), promotionViewApp.hasAppc(), promotionViewApp.getSize(), promotionViewApp.getSplits(), promotionViewApp.getRequiredSplits(), promotionViewApp.getRank(), promotionViewApp.getStoreName(), dynamicSplitsModel.getDynamicSplitsList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(PromotionViewApp promotionViewApp, RoomDownload roomDownload) {
        lambda$resumeDownload$7(roomDownload, promotionViewApp.getPackageName(), promotionViewApp.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b d(RoomDownload roomDownload) {
        return this.installManager.lambda$startInstalls$25(roomDownload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getDownload$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ PromotionViewApp e(PromotionApp promotionApp, Install install) {
        return this.promotionViewAppMapper.mapInstallToPromotionApp(install, promotionApp);
    }

    static /* synthetic */ String lambda$getPackageSignature$9(RoomInstalled roomInstalled) {
        return roomInstalled != null ? roomInstalled.getSignature() : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    static /* synthetic */ Iterable lambda$getPromotionsForPackage$2(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getPromotionsModel$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ PromotionsModel f(PromotionMeta promotionMeta, List list) {
        return new PromotionsModel(promotionMeta.getPromotionId(), list, promotionMeta.getTitle(), promotionMeta.getBackground(), isWalletInstalled(), false, promotionMeta.getDescription(), promotionMeta.getDialogDescription());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getPromotionsModel$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single g(List list) {
        if (list.isEmpty()) {
            return Single.m(PromotionsModel.ofError());
        }
        final PromotionMeta promotionMeta = (PromotionMeta) list.get(0);
        return getPromotionApps(promotionMeta.getPromotionId()).n(new rx.m.e() { // from class: cm.aptoide.pt.promotions.n2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7114f.f(promotionMeta, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b i(RoomDownload roomDownload) {
        return this.installManager.lambda$startInstalls$25(roomDownload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Promotion mapPromotionAction(Promotion promotion) {
        String promotionId = promotion.getPromotionId();
        promotionId.hashCode();
        if (promotionId.equals("BONUS_MIGRATION_19")) {
            promotion.setClaimActions(Collections.singletonList(Promotion.ClaimAction.MIGRATE));
        } else if (promotionId.equals("BONUS_GAME_WALLET_OFFER_19")) {
            promotion.setClaimActions(Arrays.asList(Promotion.ClaimAction.INSTALL, Promotion.ClaimAction.MIGRATE));
        }
        return promotion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupDownloadEvents, reason: merged with bridge method [inline-methods] */
    public void h(RoomDownload roomDownload, String str, long j2) {
        int campaignId = this.notificationAnalytics.getCampaignId(str, j2);
        String abTestingGroup = this.notificationAnalytics.getAbTestingGroup(str, j2);
        this.promotionsAnalytics.setupDownloadEvents(roomDownload, campaignId, abTestingGroup, AnalyticsManager.Action.CLICK, this.downloadStateParser.getOrigin(roomDownload.getAction()), roomDownload.hasSplits());
        this.installAnalytics.installStarted(roomDownload.getPackageName(), roomDownload.getVersionCode(), AnalyticsManager.Action.INSTALL, DownloadAnalytics.AppContext.PROMOTIONS, this.downloadStateParser.getOrigin(roomDownload.getAction()), campaignId, abTestingGroup, false, roomDownload.hasAppc(), roomDownload.hasSplits(), roomDownload.getTrustedBadge(), roomDownload.getStoreName(), false, roomDownload.hasObbs(), this.splitAnalyticsMapper.getSplitTypesAsString(roomDownload.getSplits()), roomDownload.getStoreName().equals("catappult"), HttpUrl.FRAGMENT_ENCODE_SET, roomDownload.getSize());
    }

    public void allowRootInstall(Boolean bool) {
        this.installManager.rootInstallAllowed(bool.booleanValue());
    }

    public rx.b cancelDownload(String str, String str2, int i2) {
        return this.installManager.cancelInstall(str, str2, i2);
    }

    public Single<ClaimStatusWrapper> claimPromotion(String str, String str2, String str3) {
        return this.promotionsService.claimPromotion(str, str2, str3);
    }

    public rx.b downloadApp(final PromotionViewApp promotionViewApp) {
        return g.a.a.a.d.d(this.dynamicSplitsManager.getAppSplitsByMd5(promotionViewApp.getMd5())).k(new rx.m.e() { // from class: cm.aptoide.pt.promotions.j2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7074f.b(promotionViewApp, (DynamicSplitsModel) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.k2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7085f.c(promotionViewApp, (RoomDownload) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.promotions.i2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7065f.d((RoomDownload) obj);
            }
        }).X0();
    }

    public Promotion getClaimablePromotion(List<Promotion> list, Promotion.ClaimAction claimAction) {
        for (Promotion promotion : list) {
            if (promotion.getClaimActions().contains(claimAction) && promotion.isClaimable()) {
                return promotion;
            }
        }
        return null;
    }

    public rx.e<PromotionViewApp> getDownload(final PromotionApp promotionApp) {
        return this.installManager.getInstall(promotionApp.getMd5(), promotionApp.getPackageName(), promotionApp.getVersionCode()).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.m2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7103f.e(promotionApp, (Install) obj);
            }
        });
    }

    public rx.e<String> getPackageSignature(String str) {
        return this.aptoideInstalledAppsRepository.getInstalled(str).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.s2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return PromotionsManager.lambda$getPackageSignature$9((RoomInstalled) obj);
            }
        });
    }

    public Single<List<PromotionApp>> getPromotionApps(String str) {
        return this.promotionsService.getPromotionApps(str);
    }

    public rx.e<List<Promotion>> getPromotionsForPackage(String str) {
        return this.promotionsService.getPromotionsForPackage(str).A().J(new rx.m.e() { // from class: cm.aptoide.pt.promotions.p2
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                PromotionsManager.lambda$getPromotionsForPackage$2(list);
                return list;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.l2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7094f.mapPromotionAction((Promotion) obj);
            }
        }).Y0();
    }

    public Single<PromotionsModel> getPromotionsModel(String str) {
        return this.promotionsService.getPromotions(str).i(new rx.m.e() { // from class: cm.aptoide.pt.promotions.o2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7125f.g((List) obj);
            }
        });
    }

    public String getWalletAddress() {
        return this.promotionsService.getWalletAddress();
    }

    public rx.e<WalletApp> getWalletApp() {
        return this.walletAppProvider.getWalletApp();
    }

    public rx.b pauseDownload(String str) {
        return this.installManager.pauseInstall(str);
    }

    public rx.b resumeDownload(String str, final String str2, final long j2) {
        return this.installManager.getDownload(str).g(new rx.m.b() { // from class: cm.aptoide.pt.promotions.r2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7152f.h(str2, j2, (RoomDownload) obj);
            }
        }).j(new rx.m.e() { // from class: cm.aptoide.pt.promotions.q2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7144f.i((RoomDownload) obj);
            }
        });
    }

    public void saveWalletAddress(String str) {
        this.promotionsService.saveWalletAddress(str);
    }

    public boolean shouldShowRootInstallWarningPopup() {
        return this.installManager.showWarning();
    }
}
