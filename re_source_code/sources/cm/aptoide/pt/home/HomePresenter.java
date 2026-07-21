package cm.aptoide.pt.home;

import android.util.Pair;
import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.ads.data.ApplicationAd;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.home.bundles.HomeBundlesModel;
import cm.aptoide.pt.home.bundles.ads.AdClick;
import cm.aptoide.pt.home.bundles.ads.AdHomeEvent;
import cm.aptoide.pt.home.bundles.ads.AdMapper;
import cm.aptoide.pt.home.bundles.ads.SearchAdNavigationResult;
import cm.aptoide.pt.home.bundles.apps.RewardApp;
import cm.aptoide.pt.home.bundles.base.ActionBundle;
import cm.aptoide.pt.home.bundles.base.AppComingSoonPromotionalBundle;
import cm.aptoide.pt.home.bundles.base.AppHomeEvent;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.home.bundles.base.PromotionalBundle;
import cm.aptoide.pt.home.bundles.editorial.EditorialHomeEvent;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.reactions.ReactionsHomeEvent;
import cm.aptoide.pt.reactions.network.ReactionsResponse;
import cm.aptoide.pt.view.app.Application;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;
import rx.Single;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: loaded from: classes.dex */
public class HomePresenter implements Presenter {
    private final AdMapper adMapper;
    private final CrashReport crashReporter;
    private final Home home;
    private final HomeAnalytics homeAnalytics;
    private final HomeNavigator homeNavigator;
    private final UserFeedbackAnalytics userFeedbackAnalytics;
    private final HomeView view;
    private final rx.h viewScheduler;

    /* JADX INFO: renamed from: cm.aptoide.pt.home.HomePresenter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$home$bundles$HomeBundlesModel$Error;

        static {
            int[] iArr = new int[HomeBundlesModel.Error.values().length];
            $SwitchMap$cm$aptoide$pt$home$bundles$HomeBundlesModel$Error = iArr;
            try {
                iArr[HomeBundlesModel.Error.NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$HomeBundlesModel$Error[HomeBundlesModel.Error.GENERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public HomePresenter(HomeView homeView, Home home, rx.h hVar, CrashReport crashReport, HomeNavigator homeNavigator, AdMapper adMapper, HomeAnalytics homeAnalytics, UserFeedbackAnalytics userFeedbackAnalytics) {
        this.view = homeView;
        this.home = home;
        this.viewScheduler = hVar;
        this.crashReporter = crashReport;
        this.homeNavigator = homeNavigator;
        this.adMapper = adMapper;
        this.homeAnalytics = homeAnalytics;
        this.userFeedbackAnalytics = userFeedbackAnalytics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBundlesResult(HomeBundlesModel homeBundlesModel) {
        if (homeBundlesModel.hasErrors()) {
            handleError(homeBundlesModel.getError());
        } else {
            if (homeBundlesModel.isLoading()) {
                return;
            }
            this.view.showBundles(homeBundlesModel.getList());
            this.view.hideLoading();
        }
    }

    private void handleCancelNotifyMeAppComingSoonClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.g6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.y9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6380f.r((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.y5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getBundle() instanceof AppComingSoonPromotionalBundle);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.home.q9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return HomePresenter.lambda$handleCancelNotifyMeAppComingSoonClick$153((HomeEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.n5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6255f.s((Pair) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.home.j6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return HomePresenter.lambda$handleCancelNotifyMeAppComingSoonClick$155((Pair) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.d6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6027f.t((AppComingSoonPromotionalBundle) obj);
            }
        }).j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.home.u7
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6333f.u((AppComingSoonPromotionalBundle) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.i4
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleCancelNotifyMeAppComingSoonClick$158((AppComingSoonPromotionalBundle) obj);
            }
        }, ia.f6095f);
    }

    private void handleEditorialCardClick() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.m7
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.a9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5687f.A((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        t9 t9Var = new rx.m.b() { // from class: cm.aptoide.pt.home.t9
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleEditorialCardClick$99((EditorialHomeEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(t9Var, new d(crashReport));
    }

    private void handleError(HomeBundlesModel.Error error) {
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$home$bundles$HomeBundlesModel$Error[error.ordinal()];
        if (i2 == 1) {
            this.view.showNetworkError();
        } else {
            if (i2 != 2) {
                return;
            }
            this.view.showGenericError();
        }
    }

    private void handleInstallWalletOfferClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.l5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.e8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6041f.C((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.h5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6076f.D((HomeEvent) obj);
            }
        }).X(a.f5677f).D(new rx.m.e() { // from class: cm.aptoide.pt.home.s6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeBundle) obj) instanceof ActionBundle);
            }
        }).b(ActionBundle.class).x(new rx.m.b() { // from class: cm.aptoide.pt.home.m5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6142f.B((ActionBundle) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.p9
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleInstallWalletOfferClick$12((ActionBundle) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.a4
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleInstallWalletOfferClick$13((Throwable) obj);
                throw null;
            }
        });
    }

    private void handleLoadMoreError() {
        this.view.showLoadMoreError();
    }

    private void handleLoadMoreErrorRetry() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.v4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.z3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6385f.G((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.e5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6038f.H((HomeEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.b7
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5848f.I((HomeEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.u9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6335f.J((HomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.e4
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleLoadMoreErrorRetry$5((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.m8
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6145f.K((Throwable) obj);
            }
        });
    }

    private void handlePromotionalClick() {
        rx.e eVarX = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.z4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.y3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6374f.T((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.a5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((AppHomeEvent) obj).getBundle() instanceof PromotionalBundle);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.v6
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6343f.U((AppHomeEvent) obj);
            }
        });
        HomeView homeView = this.view;
        View.LifecycleEvent lifecycleEvent = View.LifecycleEvent.DESTROY;
        rx.e eVarF = eVarX.f(homeView.bindUntilEvent(lifecycleEvent));
        i9 i9Var = new rx.m.b() { // from class: cm.aptoide.pt.home.i9
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handlePromotionalClick$45((AppHomeEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(i9Var, new d(crashReport));
        rx.e eVarF2 = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.h4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.t6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6321f.V((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.q5
            @Override // rx.m.e
            public final Object call(Object obj) {
                EditorialHomeEvent editorialHomeEvent = (EditorialHomeEvent) obj;
                return Boolean.valueOf((editorialHomeEvent.getBundle() instanceof ActionBundle) && editorialHomeEvent.getBundle().getType().isPromotional());
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.q7
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6289f.W((EditorialHomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(lifecycleEvent));
        p5 p5Var = new rx.m.b() { // from class: cm.aptoide.pt.home.p5
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handlePromotionalClick$50((EditorialHomeEvent) obj);
            }
        };
        CrashReport crashReport2 = this.crashReporter;
        crashReport2.getClass();
        eVarF2.H0(p5Var, new d(crashReport2));
    }

    private void handleReactionsResponse(ReactionsResponse reactionsResponse, boolean z) {
        if (reactionsResponse.wasSuccess()) {
            if (z) {
                this.homeAnalytics.sendDeleteEvent();
                return;
            } else {
                this.homeAnalytics.sendReactedEvent();
                return;
            }
        }
        if (reactionsResponse.reactionsExceeded()) {
            this.view.showLogInDialog();
        } else if (reactionsResponse.wasNetworkError()) {
            this.view.showNetworkErrorToast();
        } else if (reactionsResponse.wasGeneralError()) {
            this.view.showGenericErrorToast();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleActionBundlesImpression$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(View.LifecycleEvent lifecycleEvent) {
        return this.view.visibleBundles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleActionBundlesImpression$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(HomeEvent homeEvent) {
        if (homeEvent.getBundle().getType().equals(HomeBundle.BundleType.INFO_BUNDLE) || homeEvent.getBundle().getType().equals(HomeBundle.BundleType.WALLET_ADS_OFFER) || homeEvent.getBundle().getType().isPromotional()) {
            this.homeAnalytics.sendActionItemImpressionEvent(homeEvent.getBundle().getTag(), homeEvent.getBundlePosition());
            return;
        }
        ActionBundle actionBundle = (ActionBundle) homeEvent.getBundle();
        if (actionBundle.getActionItem() != null) {
            this.homeAnalytics.sendEditorialImpressionEvent(actionBundle.getTag(), homeEvent.getBundlePosition(), actionBundle.getActionItem().getCardId());
            this.homeAnalytics.sendActionItemEditorialImpressionEvent(actionBundle.getTag(), homeEvent.getBundlePosition(), actionBundle.getActionItem().getCardId());
        }
    }

    static /* synthetic */ void lambda$handleActionBundlesImpression$56(ActionBundle actionBundle) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleActionBundlesImpression$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdClick$101, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(AdHomeEvent adHomeEvent) {
        this.homeAnalytics.sendAdClickEvent(adHomeEvent.getAdClick().getAd().getStars().intValue(), adHomeEvent.getAdClick().getAd().getPackageName(), adHomeEvent.getBundlePosition(), adHomeEvent.getBundle().getTag(), adHomeEvent.getType(), ApplicationAd.Network.SERVER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdClick$103, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        Logger.getInstance().e(getClass().getCanonicalName(), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdClick$104, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(SearchAdNavigationResult searchAdNavigationResult) {
        this.homeNavigator.navigateToAppView(searchAdNavigationResult.getTag(), searchAdNavigationResult.getSearchAdResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdClick$105, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(View.LifecycleEvent lifecycleEvent) {
        rx.e<R> eVarX = this.view.adClicked().x(new rx.m.b() { // from class: cm.aptoide.pt.home.c7
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6016f.e((AdHomeEvent) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.home.c9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((AdHomeEvent) obj).getAdClick();
            }
        });
        final AdMapper adMapper = this.adMapper;
        adMapper.getClass();
        return eVarX.X(new rx.m.e() { // from class: cm.aptoide.pt.home.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return adMapper.mapAdToSearchAd((AdClick) obj);
            }
        }).j0(this.viewScheduler).w(new rx.m.b() { // from class: cm.aptoide.pt.home.t4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6319f.f((Throwable) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.h6
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6077f.g((SearchAdNavigationResult) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleAdClick$106(SearchAdNavigationResult searchAdNavigationResult) {
    }

    static /* synthetic */ void lambda$handleAdClick$107(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAppClick$91, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(AppHomeEvent appHomeEvent) {
        this.homeAnalytics.sendTapOnAppInteractEvent(appHomeEvent.getApp().getRating(), appHomeEvent.getApp().getPackageName(), appHomeEvent.getAppPosition(), appHomeEvent.getBundlePosition(), appHomeEvent.getBundle().getTag(), appHomeEvent.getBundle().getContent().size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAppClick$92, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(AppHomeEvent appHomeEvent) {
        Application app = appHomeEvent.getApp();
        if (appHomeEvent.getBundle().getType().equals(HomeBundle.BundleType.EDITORS)) {
            this.homeNavigator.navigateWithEditorsPosition(appHomeEvent.getApp().getAppId(), appHomeEvent.getApp().getPackageName(), HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, appHomeEvent.getApp().getTag(), String.valueOf(appHomeEvent.getAppPosition()));
        } else {
            if (!appHomeEvent.getBundle().getType().equals(HomeBundle.BundleType.APPCOINS_ADS)) {
                this.homeNavigator.navigateToAppView(app.getAppId(), app.getPackageName(), app.getTag());
                return;
            }
            RewardApp rewardApp = (RewardApp) app;
            this.homeAnalytics.convertAppcAdClick(rewardApp.getClickUrl());
            this.homeNavigator.navigateWithDownloadUrlAndReward(rewardApp.getAppId(), rewardApp.getPackageName(), rewardApp.getTag(), rewardApp.getDownloadUrl(), (float) rewardApp.getReward().getAppc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAppClick$93, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e k(View.LifecycleEvent lifecycleEvent) {
        return this.view.appClicked().x(new rx.m.b() { // from class: cm.aptoide.pt.home.k4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6116f.i((AppHomeEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.p8
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6278f.j((AppHomeEvent) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleAppClick$94(AppHomeEvent appHomeEvent) {
    }

    static /* synthetic */ void lambda$handleAppClick$95(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomReached$119, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean l(Object obj) {
        return Boolean.valueOf(this.home.hasMore());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomReached$120, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(Object obj) {
        this.view.showLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomReached$121, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e n(Object obj) {
        return loadNextBundlesAndReactions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomReached$122, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e o(View.LifecycleEvent lifecycleEvent) {
        return this.view.reachesBottom().D(new rx.m.e() { // from class: cm.aptoide.pt.home.d9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6030f.l(obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.i6
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6091f.m(obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.w9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6358f.n(obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleBottomReached$123(List list) {
    }

    static /* synthetic */ void lambda$handleBottomReached$124(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBundleScrolledRight$114, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(HomeEvent homeEvent) {
        this.homeAnalytics.sendScrollRightInteractEvent(homeEvent.getBundlePosition(), homeEvent.getBundle().getTag(), homeEvent.getBundle().getContent().size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBundleScrolledRight$115, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e q(View.LifecycleEvent lifecycleEvent) {
        rx.e<HomeEvent> eVarX = this.view.bundleScrolled().x(new rx.m.b() { // from class: cm.aptoide.pt.home.ba
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5851f.p((HomeEvent) obj);
            }
        });
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        return eVarX.w(new d(crashReport)).s0();
    }

    static /* synthetic */ void lambda$handleBundleScrolledRight$116(HomeEvent homeEvent) {
    }

    static /* synthetic */ void lambda$handleBundleScrolledRight$117(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCancelNotifyMeAppComingSoonClick$151, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e r(View.LifecycleEvent lifecycleEvent) {
        return this.view.cancelNotifyMeClicked();
    }

    static /* synthetic */ Pair lambda$handleCancelNotifyMeAppComingSoonClick$153(HomeEvent homeEvent) {
        return new Pair(Integer.valueOf(homeEvent.getBundlePosition()), (AppComingSoonPromotionalBundle) homeEvent.getBundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCancelNotifyMeAppComingSoonClick$154, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(Pair pair) {
        this.homeAnalytics.sendPromotionalArticleClickEvent(((AppComingSoonPromotionalBundle) pair.second).getType().name(), ((AppComingSoonPromotionalBundle) pair.second).getActionItem().getCardId());
        this.homeAnalytics.sendActionItemTapOnCardInteractEvent(((AppComingSoonPromotionalBundle) pair.second).getTag(), ((Integer) pair.first).intValue(), ((AppComingSoonPromotionalBundle) pair.second).getActionItem().getCardId());
    }

    static /* synthetic */ AppComingSoonPromotionalBundle lambda$handleCancelNotifyMeAppComingSoonClick$155(Pair pair) {
        return (AppComingSoonPromotionalBundle) pair.second;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCancelNotifyMeAppComingSoonClick$156, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e t(AppComingSoonPromotionalBundle appComingSoonPromotionalBundle) {
        return this.home.cancelAppComingSoonNotification(appComingSoonPromotionalBundle.getActionItem().getPackageName()).b(rx.e.S(appComingSoonPromotionalBundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCancelNotifyMeAppComingSoonClick$157, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(AppComingSoonPromotionalBundle appComingSoonPromotionalBundle) {
        this.view.updateAppComingSoonStatus(appComingSoonPromotionalBundle, false);
    }

    static /* synthetic */ void lambda$handleCancelNotifyMeAppComingSoonClick$158(AppComingSoonPromotionalBundle appComingSoonPromotionalBundle) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleDismissClick$79, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e v(View.LifecycleEvent lifecycleEvent) {
        return this.view.dismissBundleClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleDismissClick$81, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(HomeEvent homeEvent) {
        this.homeAnalytics.sendActionItemDismissInteractEvent(homeEvent.getBundle().getTag(), homeEvent.getBundlePosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleDismissClick$82, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e x(HomeEvent homeEvent) {
        return this.home.remove((ActionBundle) homeEvent.getBundle()).b(rx.e.S(homeEvent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleDismissClick$83, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(HomeEvent homeEvent) {
        this.view.hideBundle(homeEvent.getBundlePosition());
    }

    static /* synthetic */ void lambda$handleDismissClick$84(HomeEvent homeEvent) {
    }

    static /* synthetic */ void lambda$handleDismissClick$85(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleEditorialCardClick$97, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(EditorialHomeEvent editorialHomeEvent) {
        this.homeAnalytics.sendEditorialInteractEvent(editorialHomeEvent.getBundle().getTag(), editorialHomeEvent.getBundlePosition(), editorialHomeEvent.getCardId());
        this.homeAnalytics.sendActionItemTapOnCardInteractEvent(editorialHomeEvent.getBundle().getTag(), editorialHomeEvent.getBundlePosition(), editorialHomeEvent.getCardId());
        this.homeNavigator.navigateToEditorial(editorialHomeEvent.getCardId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleEditorialCardClick$98, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e A(View.LifecycleEvent lifecycleEvent) {
        return this.view.editorialCardClicked().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.b9
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5850f.z((EditorialHomeEvent) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleEditorialCardClick$99(EditorialHomeEvent editorialHomeEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallWalletOfferClick$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(ActionBundle actionBundle) {
        this.view.sendDeeplinkToWalletAppView(actionBundle.getActionItem().getUrl());
    }

    static /* synthetic */ void lambda$handleInstallWalletOfferClick$12(ActionBundle actionBundle) {
    }

    static /* synthetic */ void lambda$handleInstallWalletOfferClick$13(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallWalletOfferClick$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e C(View.LifecycleEvent lifecycleEvent) {
        return this.view.walletOfferCardInstallWalletClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallWalletOfferClick$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(HomeEvent homeEvent) {
        this.homeAnalytics.sendActionItemTapOnCardInteractEvent(homeEvent.getBundle().getTag(), homeEvent.getBundlePosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleKnowMoreClick$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e E(View.LifecycleEvent lifecycleEvent) {
        return this.view.infoBundleKnowMoreClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleKnowMoreClick$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(HomeEvent homeEvent) {
        this.homeAnalytics.sendActionItemTapOnCardInteractEvent(homeEvent.getBundle().getTag(), homeEvent.getBundlePosition());
        this.homeNavigator.navigateToAppCoinsInformationView();
    }

    static /* synthetic */ void lambda$handleKnowMoreClick$61(HomeEvent homeEvent) {
    }

    static /* synthetic */ void lambda$handleKnowMoreClick$62(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLoadMoreErrorRetry$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e G(View.LifecycleEvent lifecycleEvent) {
        return this.view.onLoadMoreRetryClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLoadMoreErrorRetry$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(HomeEvent homeEvent) {
        this.view.removeLoadMoreError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLoadMoreErrorRetry$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(HomeEvent homeEvent) {
        this.view.showLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLoadMoreErrorRetry$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e J(HomeEvent homeEvent) {
        return loadNextBundlesAndReactions();
    }

    static /* synthetic */ void lambda$handleLoadMoreErrorRetry$5(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLoadMoreErrorRetry$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLongPressedReactionButton$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e L(View.LifecycleEvent lifecycleEvent) {
        return this.view.reactionButtonLongPress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLongPressedReactionButton$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(EditorialHomeEvent editorialHomeEvent) {
        this.homeAnalytics.sendReactionButtonClickEvent();
        this.view.showReactionsPopup(editorialHomeEvent.getCardId(), editorialHomeEvent.getGroupId(), editorialHomeEvent.getBundlePosition());
    }

    static /* synthetic */ void lambda$handleLongPressedReactionButton$17(EditorialHomeEvent editorialHomeEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleMoreClick$109, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(HomeEvent homeEvent) {
        this.homeAnalytics.sendTapOnMoreInteractEvent(homeEvent.getBundlePosition(), homeEvent.getBundle().getTag(), homeEvent.getBundle().getContent().size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleMoreClick$110, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e O(View.LifecycleEvent lifecycleEvent) {
        rx.e<HomeEvent> eVarJ0 = this.view.moreClicked().x(new rx.m.b() { // from class: cm.aptoide.pt.home.j7
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6105f.N((HomeEvent) obj);
            }
        }).j0(this.viewScheduler);
        final HomeNavigator homeNavigator = this.homeNavigator;
        homeNavigator.getClass();
        return eVarJ0.x(new rx.m.b() { // from class: cm.aptoide.pt.home.fa
            @Override // rx.m.b
            public final void call(Object obj) {
                homeNavigator.navigateWithAction((HomeEvent) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleMoreClick$111(HomeEvent homeEvent) {
    }

    static /* synthetic */ void lambda$handleMoreClick$112(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleNotifyMeAppComingSoonClick$142, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e P(View.LifecycleEvent lifecycleEvent) {
        return this.view.notifyMeClicked();
    }

    static /* synthetic */ Pair lambda$handleNotifyMeAppComingSoonClick$144(HomeEvent homeEvent) {
        return new Pair(Integer.valueOf(homeEvent.getBundlePosition()), (AppComingSoonPromotionalBundle) homeEvent.getBundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleNotifyMeAppComingSoonClick$145, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(Pair pair) {
        this.homeAnalytics.sendPromotionalArticleClickEvent(((AppComingSoonPromotionalBundle) pair.second).getType().name(), ((AppComingSoonPromotionalBundle) pair.second).getActionItem().getCardId());
        this.homeAnalytics.sendActionItemTapOnCardInteractEvent(((AppComingSoonPromotionalBundle) pair.second).getTag(), ((Integer) pair.first).intValue(), ((AppComingSoonPromotionalBundle) pair.second).getActionItem().getCardId());
    }

    static /* synthetic */ AppComingSoonPromotionalBundle lambda$handleNotifyMeAppComingSoonClick$146(Pair pair) {
        return (AppComingSoonPromotionalBundle) pair.second;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleNotifyMeAppComingSoonClick$147, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e R(AppComingSoonPromotionalBundle appComingSoonPromotionalBundle) {
        return this.home.setupAppComingSoonNotification(appComingSoonPromotionalBundle.getActionItem().getPackageName()).b(rx.e.S(appComingSoonPromotionalBundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleNotifyMeAppComingSoonClick$148, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S(AppComingSoonPromotionalBundle appComingSoonPromotionalBundle) {
        this.view.updateAppComingSoonStatus(appComingSoonPromotionalBundle, true);
    }

    static /* synthetic */ void lambda$handleNotifyMeAppComingSoonClick$149(AppComingSoonPromotionalBundle appComingSoonPromotionalBundle) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionalClick$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e T(View.LifecycleEvent lifecycleEvent) {
        return this.view.appClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionalClick$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(AppHomeEvent appHomeEvent) {
        HomeBundle bundle = appHomeEvent.getBundle();
        this.homeAnalytics.sendPromotionalAppClickEvent(bundle.getType().name(), ((PromotionalBundle) bundle).getApp().getPackageName());
    }

    static /* synthetic */ void lambda$handlePromotionalClick$45(AppHomeEvent appHomeEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionalClick$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e V(View.LifecycleEvent lifecycleEvent) {
        return this.view.editorialCardClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionalClick$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(EditorialHomeEvent editorialHomeEvent) {
        HomeBundle bundle = editorialHomeEvent.getBundle();
        this.homeAnalytics.sendPromotionalArticleClickEvent(bundle.getType().name(), ((ActionBundle) bundle).getActionItem().getCardId());
    }

    static /* synthetic */ void lambda$handlePromotionalClick$50(EditorialHomeEvent editorialHomeEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionalImpression$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e X(View.LifecycleEvent lifecycleEvent) {
        return this.view.visibleBundles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionalImpression$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(HomeEvent homeEvent) {
        HomeBundle bundle = homeEvent.getBundle();
        this.homeAnalytics.sendPromotionalAppImpressionEvent(bundle.getType().name(), ((PromotionalBundle) bundle).getApp().getPackageName());
        this.homeAnalytics.sendPromotionalAppHomeInteractImpressionEvent(bundle.getTag(), homeEvent.getBundlePosition());
    }

    static /* synthetic */ void lambda$handlePromotionalImpression$35(HomeEvent homeEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionalImpression$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e Z(View.LifecycleEvent lifecycleEvent) {
        return this.view.visibleBundles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionalImpression$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(HomeEvent homeEvent) {
        ActionBundle actionBundle = (ActionBundle) homeEvent.getBundle();
        if (actionBundle.getActionItem() != null) {
            this.homeAnalytics.sendPromotionalArticleImpressionEvent(actionBundle.getType().name(), actionBundle.getActionItem().getCardId());
        }
    }

    static /* synthetic */ void lambda$handlePromotionalImpression$40(HomeEvent homeEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePullToRefresh$127, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(Void r1) {
        this.homeAnalytics.sendPullRefreshInteractEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePullToRefresh$128, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c0(Void r1) {
        return loadFreshBundlesAndReactions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePullToRefresh$129, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d0(View.LifecycleEvent lifecycleEvent) {
        return this.view.refreshes().x(new rx.m.b() { // from class: cm.aptoide.pt.home.j5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6103f.b0((Void) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.k9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6121f.c0((Void) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handlePullToRefresh$130(List list) {
    }

    static /* synthetic */ void lambda$handlePullToRefresh$131(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleReactionButtonClick$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e0(View.LifecycleEvent lifecycleEvent) {
        return this.view.reactionsButtonClicked();
    }

    static /* synthetic */ void lambda$handleReactionButtonClick$65(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleReactionButtonClick$66, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f0(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$134, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g0(Void r1) {
        this.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$135, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h0(Void r1) {
        return loadNextBundlesAndReactions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$136, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e i0(View.LifecycleEvent lifecycleEvent) {
        return this.view.retryClicked().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.g5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6064f.g0((Void) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.v5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6342f.h0((Void) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleRetryClick$137(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSnackLogInClick$75, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e j0(View.LifecycleEvent lifecycleEvent) {
        return this.view.snackLogInClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSnackLogInClick$76, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k0(Void r1) {
        this.homeNavigator.navigateToLogIn();
    }

    static /* synthetic */ void lambda$handleSnackLogInClick$77(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e l0(View.LifecycleEvent lifecycleEvent) {
        return this.view.reactionClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$69, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m0(ReactionsHomeEvent reactionsHomeEvent) {
        this.userFeedbackAnalytics.sendReactionEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$70, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0(ReactionsResponse reactionsResponse) {
        handleReactionsResponse(reactionsResponse, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$71, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single o0(ReactionsHomeEvent reactionsHomeEvent, ReactionsResponse reactionsResponse) {
        return loadReactionModel(reactionsHomeEvent.getCardId(), reactionsHomeEvent.getGroupId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$72, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e p0(final ReactionsHomeEvent reactionsHomeEvent) {
        return this.home.setReaction(reactionsHomeEvent.getCardId(), reactionsHomeEvent.getGroupId(), reactionsHomeEvent.getReaction()).A().D(new rx.m.e() { // from class: cm.aptoide.pt.home.ca
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((ReactionsResponse) obj).differentReaction());
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.o5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6265f.n0((ReactionsResponse) obj);
            }
        }).D(ha.f6081f).L(new rx.m.e() { // from class: cm.aptoide.pt.home.j8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6106f.o0(reactionsHomeEvent, (ReactionsResponse) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleUserReaction$73(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadFreshBundles$132, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0(HomeBundlesModel homeBundlesModel) {
        this.view.hideRefresh();
        if (homeBundlesModel.hasErrors()) {
            handleError(homeBundlesModel.getError());
        } else {
            if (homeBundlesModel.isLoading()) {
                return;
            }
            this.view.showBundles(homeBundlesModel.getList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadFreshBundlesAndReactions$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single r0(ActionBundle actionBundle) {
        return loadReactionModel(actionBundle.getActionItem().getCardId(), actionBundle.getActionItem().getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadHomeAndReactions$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single s0(HomeBundlesModel homeBundlesModel, ActionBundle actionBundle) {
        return loadReactionModel(actionBundle.getActionItem().getCardId(), actionBundle.getActionItem().getType(), homeBundlesModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadHomeAndReactions$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e t0(final HomeBundlesModel homeBundlesModel) {
        return rx.e.N(homeBundlesModel.getList()).D(new rx.m.e() { // from class: cm.aptoide.pt.home.r9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeBundle) obj).getType() == HomeBundle.BundleType.EDITORIAL);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.n9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeBundle) obj) instanceof ActionBundle);
            }
        }).b(ActionBundle.class).D(new rx.m.e() { // from class: cm.aptoide.pt.home.v7
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((ActionBundle) obj).getActionItem() != null);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.home.q6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6287f.s0(homeBundlesModel, (ActionBundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadNextBundles$125, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(HomeBundlesModel homeBundlesModel) {
        this.homeAnalytics.sendLoadMoreInteractEvent();
        if (homeBundlesModel.hasErrors()) {
            handleLoadMoreError();
        } else if (!homeBundlesModel.isLoading()) {
            this.view.showMoreHomeBundles(homeBundlesModel.getList());
            this.view.hideLoading();
        }
        this.view.hideShowMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadNextBundlesAndReactions$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single v0(ActionBundle actionBundle) {
        return loadReactionModel(actionBundle.getActionItem().getCardId(), actionBundle.getActionItem().getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadReactionModel$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0(List list) {
        this.view.updateEditorialCards();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadReactionModel$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x0(List list) {
        this.view.updateEditorialCards();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateLoadBundles$87, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z0(View.LifecycleEvent lifecycleEvent) {
        this.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateLoadBundles$88, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e A0(View.LifecycleEvent lifecycleEvent) {
        return loadHomeAndReactions();
    }

    static /* synthetic */ void lambda$onCreateLoadBundles$89(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$singlePressReactionButtonAction$138, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0(ReactionsResponse reactionsResponse) {
        handleReactionsResponse(reactionsResponse, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$singlePressReactionButtonAction$139, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single C0(EditorialHomeEvent editorialHomeEvent, ReactionsResponse reactionsResponse) {
        return loadReactionModel(editorialHomeEvent.getCardId(), editorialHomeEvent.getGroupId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$singlePressReactionButtonAction$140, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e D0(final EditorialHomeEvent editorialHomeEvent, Boolean bool) {
        if (!bool.booleanValue()) {
            return this.home.deleteReaction(editorialHomeEvent.getCardId(), editorialHomeEvent.getGroupId()).A().x(new rx.m.b() { // from class: cm.aptoide.pt.home.e6
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f6039f.B0((ReactionsResponse) obj);
                }
            }).D(ha.f6081f).L(new rx.m.e() { // from class: cm.aptoide.pt.home.z5
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f6387f.C0(editorialHomeEvent, (ReactionsResponse) obj);
                }
            });
        }
        this.homeAnalytics.sendReactionButtonClickEvent();
        this.view.showReactionsPopup(editorialHomeEvent.getCardId(), editorialHomeEvent.getGroupId(), editorialHomeEvent.getBundlePosition());
        return rx.e.S(Collections.emptyList());
    }

    private rx.e<HomeBundlesModel> loadFreshBundles() {
        return this.home.loadFreshHomeBundles().D(ka.f6122f).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.v9
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6346f.q0((HomeBundlesModel) obj);
            }
        });
    }

    private rx.e<List<HomeBundle>> loadFreshBundlesAndReactions() {
        return loadFreshBundles().E().J(ja.f6109f).D(new rx.m.e() { // from class: cm.aptoide.pt.home.c4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeBundle) obj).getType() == HomeBundle.BundleType.EDITORIAL);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.u4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeBundle) obj) instanceof ActionBundle);
            }
        }).b(ActionBundle.class).L(new rx.m.e() { // from class: cm.aptoide.pt.home.f9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6056f.r0((ActionBundle) obj);
            }
        });
    }

    private rx.e<HomeBundlesModel> loadHome() {
        rx.e eVarJ0 = this.home.loadHomeBundles().b(HomeBundlesModel.class).j0(this.viewScheduler);
        final HomeView homeView = this.view;
        homeView.getClass();
        return eVarJ0.x(new rx.m.b() { // from class: cm.aptoide.pt.home.ga
            @Override // rx.m.b
            public final void call(Object obj) {
                homeView.showBundlesSkeleton((HomeBundlesModel) obj);
            }
        }).D(ka.f6122f).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.o8
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6268f.handleBundlesResult((HomeBundlesModel) obj);
            }
        });
    }

    private rx.e<List<HomeBundle>> loadHomeAndReactions() {
        return loadHome().G(new rx.m.e() { // from class: cm.aptoide.pt.home.x3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6363f.t0((HomeBundlesModel) obj);
            }
        });
    }

    private Single<HomeBundlesModel> loadNextBundles() {
        return this.home.loadNextHomeBundles().D(ka.f6122f).Z0().p(this.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.home.o7
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6267f.u0((HomeBundlesModel) obj);
            }
        });
    }

    private rx.e<List<HomeBundle>> loadNextBundlesAndReactions() {
        return loadNextBundles().A().J(ja.f6109f).D(new rx.m.e() { // from class: cm.aptoide.pt.home.i7
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeBundle) obj).getType() == HomeBundle.BundleType.EDITORIAL);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.f7
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeBundle) obj) instanceof ActionBundle);
            }
        }).b(ActionBundle.class).L(new rx.m.e() { // from class: cm.aptoide.pt.home.d7
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6028f.v0((ActionBundle) obj);
            }
        });
    }

    private Single<List<HomeBundle>> loadReactionModel(String str, String str2, HomeBundlesModel homeBundlesModel) {
        return this.home.loadReactionModel(str, str2, homeBundlesModel).p(this.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.home.b8
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5849f.w0((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public rx.e<List<HomeBundle>> singlePressReactionButtonAction(final EditorialHomeEvent editorialHomeEvent) {
        return this.home.isFirstReaction(editorialHomeEvent.getCardId(), editorialHomeEvent.getGroupId()).k(new rx.m.e() { // from class: cm.aptoide.pt.home.w6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6354f.D0(editorialHomeEvent, (Boolean) obj);
            }
        });
    }

    public void handleActionBundlesImpression() {
        rx.e eVarB = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.r5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.c8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6017f.b((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.d5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getBundle() instanceof ActionBundle);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.x7
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6367f.c((HomeEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.t5
            @Override // rx.m.e
            public final Object call(Object obj) {
                HomeEvent homeEvent = (HomeEvent) obj;
                return Boolean.valueOf(homeEvent.getBundle().getType().equals(HomeBundle.BundleType.INFO_BUNDLE) || homeEvent.getBundle().getType().equals(HomeBundle.BundleType.WALLET_ADS_OFFER));
            }
        }).X(a.f5677f).b(ActionBundle.class);
        final Home home = this.home;
        home.getClass();
        eVarB.H(new rx.m.e() { // from class: cm.aptoide.pt.home.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return home.actionBundleImpression((ActionBundle) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.o4
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleActionBundlesImpression$56((ActionBundle) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.o9
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6269f.d((Throwable) obj);
            }
        });
    }

    public void handleAdClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.c6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.g8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6067f.h((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.g4
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleAdClick$106((SearchAdNavigationResult) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.s8
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleAdClick$107((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleAppClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.h8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.g7
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6066f.k((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.q4
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleAppClick$94((AppHomeEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.d4
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleAppClick$95((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleBottomReached() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.e9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.q8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6290f.o((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.l9
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleBottomReached$123((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.p7
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleBottomReached$124((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleBundleScrolledRight() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.m9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.w4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6352f.q((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.w5
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleBundleScrolledRight$116((HomeEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.z6
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleBundleScrolledRight$117((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleDismissClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.y6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.m4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6141f.v((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.r6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getBundle() instanceof ActionBundle);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.l4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6129f.w((HomeEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.m6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6143f.x((HomeEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.l7
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6132f.y((HomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.y8
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleDismissClick$84((HomeEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.a7
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleDismissClick$85((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleKnowMoreClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.n7
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.p6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6276f.E((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.i8
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6093f.F((HomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.s9
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleKnowMoreClick$61((HomeEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.k7
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleKnowMoreClick$62((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleLongPressedReactionButton() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.a8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.c5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6014f.L((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.r8
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6301f.M((EditorialHomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        x9 x9Var = new rx.m.b() { // from class: cm.aptoide.pt.home.x9
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleLongPressedReactionButton$17((EditorialHomeEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(x9Var, new d(crashReport));
    }

    public void handleMoreClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.n4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.f6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6053f.O((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.f4
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleMoreClick$111((HomeEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.k5
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleMoreClick$112((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleNotifyMeAppComingSoonClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.h7
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.x4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6364f.P((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.z9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getBundle() instanceof AppComingSoonPromotionalBundle);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.home.d8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return HomePresenter.lambda$handleNotifyMeAppComingSoonClick$144((HomeEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.j4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6102f.Q((Pair) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.home.j9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return HomePresenter.lambda$handleNotifyMeAppComingSoonClick$146((Pair) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.x6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6366f.R((AppComingSoonPromotionalBundle) obj);
            }
        }).j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.home.z8
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6391f.S((AppComingSoonPromotionalBundle) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.f5
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleNotifyMeAppComingSoonClick$149((AppComingSoonPromotionalBundle) obj);
            }
        }, ia.f6095f);
    }

    public void handlePromotionalImpression() {
        rx.e eVarX = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.a6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.o6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6266f.X((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.k6
            @Override // rx.m.e
            public final Object call(Object obj) {
                HomeEvent homeEvent = (HomeEvent) obj;
                return Boolean.valueOf((homeEvent.getBundle() instanceof PromotionalBundle) && homeEvent.getBundle().getType().isPromotional());
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.x8
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6368f.Y((HomeEvent) obj);
            }
        });
        HomeView homeView = this.view;
        View.LifecycleEvent lifecycleEvent = View.LifecycleEvent.DESTROY;
        rx.e eVarF = eVarX.f(homeView.bindUntilEvent(lifecycleEvent));
        y4 y4Var = new rx.m.b() { // from class: cm.aptoide.pt.home.y4
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handlePromotionalImpression$35((HomeEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(y4Var, new d(crashReport));
        rx.e eVarF2 = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.i5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.b4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5845f.Z((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.s7
            @Override // rx.m.e
            public final Object call(Object obj) {
                HomeEvent homeEvent = (HomeEvent) obj;
                return Boolean.valueOf((homeEvent.getBundle() instanceof ActionBundle) && homeEvent.getBundle().getType().isPromotional());
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.u8
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6334f.a0((HomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(lifecycleEvent));
        n6 n6Var = new rx.m.b() { // from class: cm.aptoide.pt.home.n6
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handlePromotionalImpression$40((HomeEvent) obj);
            }
        };
        CrashReport crashReport2 = this.crashReporter;
        crashReport2.getClass();
        eVarF2.H0(n6Var, new d(crashReport2));
    }

    public void handlePullToRefresh() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.l6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.s5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6309f.d0((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.u6
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handlePullToRefresh$130((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.b5
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handlePullToRefresh$131((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleReactionButtonClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.h9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.t8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6323f.e0((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.r4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6297f.singlePressReactionButtonAction((EditorialHomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.s4
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleReactionButtonClick$65((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.n8
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6258f.f0((Throwable) obj);
            }
        });
    }

    public void handleRetryClick() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.p4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.v8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6345f.i0((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        u5 u5Var = new rx.m.b() { // from class: cm.aptoide.pt.home.u5
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleRetryClick$137((List) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(u5Var, new d(crashReport));
    }

    public void handleSnackLogInClick() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.aa
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.y7
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6378f.j0((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.w7
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6356f.k0((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        t7 t7Var = new rx.m.b() { // from class: cm.aptoide.pt.home.t7
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleSnackLogInClick$77((Void) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(t7Var, new d(crashReport));
    }

    public void handleUserReaction() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.b6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.l8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6133f.l0((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.k8
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6120f.m0((ReactionsHomeEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.g9
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6068f.p0((ReactionsHomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        f8 f8Var = new rx.m.b() { // from class: cm.aptoide.pt.home.f8
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$handleUserReaction$73((List) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(f8Var, new d(crashReport));
    }

    public void onCreateLoadBundles() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.r7
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.e7
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6040f.z0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.w8
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6357f.A0((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        z7 z7Var = new rx.m.b() { // from class: cm.aptoide.pt.home.z7
            @Override // rx.m.b
            public final void call(Object obj) {
                HomePresenter.lambda$onCreateLoadBundles$89((List) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(z7Var, new d(crashReport));
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        onCreateLoadBundles();
        handleAppClick();
        handleAdClick();
        handleMoreClick();
        handleBottomReached();
        handlePullToRefresh();
        handleRetryClick();
        handleBundleScrolledRight();
        handleKnowMoreClick();
        handleDismissClick();
        handleActionBundlesImpression();
        handleEditorialCardClick();
        handleInstallWalletOfferClick();
        handleReactionButtonClick();
        handleLongPressedReactionButton();
        handleUserReaction();
        handleSnackLogInClick();
        handleLoadMoreErrorRetry();
        handlePromotionalImpression();
        handlePromotionalClick();
        handleNotifyMeAppComingSoonClick();
        handleCancelNotifyMeAppComingSoonClick();
    }

    private Single<List<HomeBundle>> loadReactionModel(String str, String str2) {
        return this.home.loadReactionModel(str, str2).p(this.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.home.x5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6365f.x0((List) obj);
            }
        });
    }
}
