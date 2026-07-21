package cm.aptoide.pt.home;

import cm.aptoide.pt.blacklist.BlacklistManager;
import cm.aptoide.pt.home.bundles.BundlesRepository;
import cm.aptoide.pt.home.bundles.HomeBundlesModel;
import cm.aptoide.pt.home.bundles.base.ActionBundle;
import cm.aptoide.pt.home.bundles.base.ActionItem;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.notification.ComingSoonNotificationManager;
import cm.aptoide.pt.promotions.PromotionApp;
import cm.aptoide.pt.promotions.PromotionsManager;
import cm.aptoide.pt.promotions.PromotionsModel;
import cm.aptoide.pt.promotions.PromotionsPreferencesManager;
import cm.aptoide.pt.reactions.ReactionsManager;
import cm.aptoide.pt.reactions.network.LoadReactionModel;
import cm.aptoide.pt.reactions.network.ReactionsResponse;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class Home {
    private final BlacklistManager blacklistManager;
    private final BundlesRepository bundlesRepository;
    private final ComingSoonNotificationManager comingSoonNotificationManager;
    private final String promotionType;
    private final PromotionsManager promotionsManager;
    private final PromotionsPreferencesManager promotionsPreferencesManager;
    private final ReactionsManager reactionsManager;

    public Home(BundlesRepository bundlesRepository, PromotionsManager promotionsManager, PromotionsPreferencesManager promotionsPreferencesManager, BlacklistManager blacklistManager, String str, ReactionsManager reactionsManager, ComingSoonNotificationManager comingSoonNotificationManager) {
        this.bundlesRepository = bundlesRepository;
        this.promotionsManager = promotionsManager;
        this.promotionsPreferencesManager = promotionsPreferencesManager;
        this.promotionType = str;
        this.blacklistManager = blacklistManager;
        this.reactionsManager = reactionsManager;
        this.comingSoonNotificationManager = comingSoonNotificationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getUpdatedCards, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public Single<List<HomeBundle>> e(HomeBundlesModel homeBundlesModel, LoadReactionModel loadReactionModel, String str) {
        ActionItem actionItem;
        List<HomeBundle> list = homeBundlesModel.getList();
        for (HomeBundle homeBundle : list) {
            if (homeBundle.getType() == HomeBundle.BundleType.EDITORIAL && (homeBundle instanceof ActionBundle) && (actionItem = ((ActionBundle) homeBundle).getActionItem()) != null && actionItem.getCardId().equals(str)) {
                actionItem.setReactions(loadReactionModel.getTopReactionList());
                actionItem.setNumberOfReactions(loadReactionModel.getTotal());
                actionItem.setUserReaction(loadReactionModel.getMyReaction());
            }
        }
        return Single.m(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$actionBundleImpression$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(ActionBundle actionBundle) {
        this.blacklistManager.addImpression(actionBundle.getType().toString(), actionBundle.getActionItem().getCardId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadNextHomeBundles$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(HomeBundlesModel homeBundlesModel) {
        if (homeBundlesModel.hasErrors()) {
            setLoadMoreError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadReactionModel$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single f(final String str, final LoadReactionModel loadReactionModel) {
        return this.bundlesRepository.loadHomeBundles().Z0().i(new rx.m.e() { // from class: cm.aptoide.pt.home.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6044f.e(loadReactionModel, str, (HomeBundlesModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$remove$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(ActionBundle actionBundle) {
        this.blacklistManager.blacklist(actionBundle.getType().toString(), actionBundle.getActionItem().getCardId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HomePromotionsWrapper mapPromotions(PromotionsModel promotionsModel) {
        int i2;
        float f2;
        List<PromotionApp> appsList = promotionsModel.getAppsList();
        if (appsList.size() > 0) {
            int i3 = 0;
            float appcValue = 0.0f;
            for (PromotionApp promotionApp : appsList) {
                if (!promotionApp.isClaimed()) {
                    i3++;
                    appcValue += promotionApp.getAppcValue();
                }
            }
            i2 = i3;
            f2 = appcValue;
        } else {
            i2 = 0;
            f2 = 0.0f;
        }
        return new HomePromotionsWrapper(promotionsModel.getTitle(), promotionsModel.getFeatureGraphic(), !appsList.isEmpty(), i2, f2, this.promotionsPreferencesManager.shouldShowPromotionsDialog() && f2 > 0.0f, promotionsModel.getDialogDescription());
    }

    private void setLoadMoreError() {
        this.bundlesRepository.setHomeLoadMoreError();
    }

    public rx.b actionBundleImpression(final ActionBundle actionBundle) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.home.k
            @Override // rx.m.a
            public final void call() {
                this.f6110f.b(actionBundle);
            }
        });
    }

    public rx.b cancelAppComingSoonNotification(String str) {
        return this.comingSoonNotificationManager.cancelScheduledNotification(str);
    }

    public Single<ReactionsResponse> deleteReaction(String str, String str2) {
        return this.reactionsManager.deleteReaction(str, str2);
    }

    public boolean hasMore() {
        return this.bundlesRepository.hasMore();
    }

    public Single<HomePromotionsWrapper> hasPromotionApps() {
        return this.promotionsManager.getPromotionsModel(this.promotionType).n(new rx.m.e() { // from class: cm.aptoide.pt.home.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6058f.mapPromotions((PromotionsModel) obj);
            }
        });
    }

    public Single<Boolean> isFirstReaction(String str, String str2) {
        return this.reactionsManager.isFirstReaction(str, str2);
    }

    public rx.e<HomeBundlesModel> loadFreshHomeBundles() {
        return this.bundlesRepository.loadFreshHomeBundles();
    }

    public rx.e<HomeBundlesModel> loadHomeBundles() {
        return this.bundlesRepository.loadHomeBundles();
    }

    public rx.e<HomeBundlesModel> loadNextHomeBundles() {
        return this.bundlesRepository.loadNextHomeBundles(false).x(new rx.m.b() { // from class: cm.aptoide.pt.home.h
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6070f.c((HomeBundlesModel) obj);
            }
        });
    }

    public Single<List<HomeBundle>> loadReactionModel(final String str, String str2, final HomeBundlesModel homeBundlesModel) {
        return this.reactionsManager.loadReactionModel(str, str2).A().D(new rx.m.e() { // from class: cm.aptoide.pt.home.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(homeBundlesModel.isComplete());
            }
        }).Z0().i(new rx.m.e() { // from class: cm.aptoide.pt.home.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6082f.d(homeBundlesModel, str, (LoadReactionModel) obj);
            }
        });
    }

    public rx.b remove(final ActionBundle actionBundle) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.home.l
            @Override // rx.m.a
            public final void call() {
                this.f6123f.g(actionBundle);
            }
        }).a(this.bundlesRepository.remove(actionBundle));
    }

    public void setPromotionsDialogShown() {
        this.promotionsPreferencesManager.setPromotionsDialogShown();
    }

    public Single<ReactionsResponse> setReaction(String str, String str2, String str3) {
        return this.reactionsManager.setReaction(str, str2, str3);
    }

    public rx.b setupAppComingSoonNotification(String str) {
        return this.comingSoonNotificationManager.setupNotification(str);
    }

    public Single<List<HomeBundle>> loadReactionModel(final String str, String str2) {
        return this.reactionsManager.loadReactionModel(str, str2).i(new rx.m.e() { // from class: cm.aptoide.pt.home.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6096f.f(str, (LoadReactionModel) obj);
            }
        });
    }
}
