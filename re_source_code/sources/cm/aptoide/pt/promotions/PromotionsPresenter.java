package cm.aptoide.pt.promotions;

import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.ads.WalletAdsOfferManager;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceNavigatorWrapper;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import java.util.List;
import okhttp3.HttpUrl;
import rx.Single;
import rx.exceptions.OnErrorNotImplementedException;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class PromotionsPresenter implements Presenter {
    private final MoPubAdsManager moPubAdsManager;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private String promotionId;
    private final String promotionType;
    private final PromotionsAnalytics promotionsAnalytics;
    private final PromotionsManager promotionsManager;
    private final PromotionsNavigator promotionsNavigator;
    private final PromotionsView view;
    private final rx.h viewScheduler;

    public PromotionsPresenter(PromotionsView promotionsView, PromotionsManager promotionsManager, PermissionManager permissionManager, PermissionService permissionService, rx.h hVar, PromotionsAnalytics promotionsAnalytics, PromotionsNavigator promotionsNavigator, String str, MoPubAdsManager moPubAdsManager) {
        this.view = promotionsView;
        this.promotionsManager = promotionsManager;
        this.permissionManager = permissionManager;
        this.permissionService = permissionService;
        this.viewScheduler = hVar;
        this.promotionsAnalytics = promotionsAnalytics;
        this.promotionsNavigator = promotionsNavigator;
        this.promotionType = str;
        this.moPubAdsManager = moPubAdsManager;
    }

    private void cancelDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.g5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.p6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7139f.c((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.promotions.x4
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$cancelDownload$27((PromotionViewApp) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.promotions.b3
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$cancelDownload$28((Throwable) obj);
            }
        });
    }

    private void claimApp() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.j3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.n5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7119f.e((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.promotions.o6
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$claimApp$12((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.promotions.x3
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$claimApp$13((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadApp, reason: merged with bridge method [inline-methods] */
    public rx.b P(final PromotionViewApp promotionViewApp) {
        return rx.e.p(new rx.m.d() { // from class: cm.aptoide.pt.promotions.g3
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return this.f7049f.g();
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.d4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7021f.h((Boolean) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.f6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7042f.j(promotionViewApp, (Void) obj);
            }
        }).j0(Schedulers.io()).H(new rx.m.e() { // from class: cm.aptoide.pt.promotions.z4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7227f.k(promotionViewApp, (Void) obj);
            }
        }).X0();
    }

    private void getPromotionApps() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.f5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.r4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7157f.m((View.LifecycleEvent) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.promotions.o3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7126f.n((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.z5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7229f.o((PromotionsModel) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.w3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7199f.p((PromotionsModel) obj);
            }
        }).j0(this.viewScheduler).G(new r5(this)).w(new rx.m.b() { // from class: cm.aptoide.pt.promotions.g6
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7052f.q((Throwable) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.promotions.h4
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$getPromotionApps$65((PromotionsModel) obj);
            }
        }, x6.f7210f);
    }

    private void handleClickOnAppCard() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.u5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.i4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7067f.r((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.n3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7116f.s((PromotionAppClick) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.promotions.t5
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$handleClickOnAppCard$46((PromotionAppClick) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.promotions.d3
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$handleClickOnAppCard$47((Throwable) obj);
                throw null;
            }
        });
    }

    private rx.e<PromotionsModel> handleDownloadErrors(final PromotionsModel promotionsModel) {
        return rx.e.a0(this.view.installButtonClick(), this.view.resumeDownload()).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.o4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7127f.v(promotionsModel, (PromotionViewApp) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.r6
            @Override // rx.m.e
            public final Object call(Object obj) {
                PromotionsModel promotionsModel2 = promotionsModel;
                PromotionsPresenter.lambda$handleDownloadErrors$95(promotionsModel2, (PromotionViewApp) obj);
                return promotionsModel2;
            }
        });
    }

    private void handleOutOfSpaceDialog() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.v3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.d6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7023f.w((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.h6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((OutOfSpaceNavigatorWrapper) obj).getClearedSuccessfully());
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.c5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7012f.y((OutOfSpaceNavigatorWrapper) obj);
            }
        }).s0().f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.promotions.s5
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$handleOutOfSpaceDialog$7((PromotionApp) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.promotions.s4
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    private rx.e<PromotionsModel> handlePromotionApps(final PromotionsModel promotionsModel) {
        return rx.e.S(promotionsModel).J(new rx.m.e() { // from class: cm.aptoide.pt.promotions.n6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return promotionsModel.getAppsList();
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.b5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((PromotionApp) obj).getPackageName().equals(AptoideApplication.APPCOINS_WALLET_PACKAGE_NAME));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.z2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7224f.z(promotionsModel, (PromotionApp) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.p5
            @Override // rx.m.e
            public final Object call(Object obj) {
                PromotionsModel promotionsModel2 = promotionsModel;
                PromotionsPresenter.lambda$handlePromotionApps$81(promotionsModel2, (PromotionApp) obj);
                return promotionsModel2;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.c6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7013f.E(promotionsModel, (PromotionsModel) obj);
            }
        });
    }

    private void handlePromotionClaimResult() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.l3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.v4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7191f.F((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.z0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((ClaimDialogResultWrapper) obj).isOk());
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.e6
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7032f.G((ClaimDialogResultWrapper) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.promotions.a4
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$handlePromotionClaimResult$69((ClaimDialogResultWrapper) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.promotions.m6
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$handlePromotionClaimResult$70((Throwable) obj);
                throw null;
            }
        });
    }

    private void handlePromotionOverDialogClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.e5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.x2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7206f.H((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.y3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7216f.I((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.promotions.i6
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$handlePromotionOverDialogClick$51((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.promotions.a3
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$handlePromotionOverDialogClick$52((Throwable) obj);
            }
        });
    }

    private void handleRetryClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.l5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.h5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7060f.N((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.promotions.v2
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$handleRetryClick$77((PromotionsModel) obj);
            }
        }, x6.f7210f);
    }

    private void installButtonClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.q6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.e4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7030f.Q((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.promotions.k4
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$installButtonClick$41((PromotionViewApp) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.promotions.l6
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$installButtonClick$42((Throwable) obj);
                throw null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$cancelDownload$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b b(PromotionViewApp promotionViewApp) {
        return this.promotionsManager.cancelDownload(promotionViewApp.getMd5(), promotionViewApp.getPackageName(), promotionViewApp.getVersionCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$cancelDownload$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(View.LifecycleEvent lifecycleEvent) {
        return this.view.cancelDownload().H(new rx.m.e() { // from class: cm.aptoide.pt.promotions.z3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7226f.b((PromotionViewApp) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$cancelDownload$27(PromotionViewApp promotionViewApp) {
    }

    static /* synthetic */ void lambda$cancelDownload$28(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$claimApp$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(PromotionViewApp promotionViewApp) {
        this.promotionsAnalytics.sendPromotionsAppInteractClaimEvent(promotionViewApp.getPackageName(), promotionViewApp.getAppcValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$claimApp$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(View.LifecycleEvent lifecycleEvent) {
        return this.view.claimAppClick().x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.q3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7145f.d((PromotionViewApp) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.promotions.k6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7090f.showClaimView((PromotionViewApp) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$claimApp$12(String str) {
    }

    static /* synthetic */ void lambda$claimApp$13(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Boolean bool) {
        this.promotionsManager.allowRootInstall(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g() {
        return this.promotionsManager.shouldShowRootInstallWarningPopup() ? this.view.showRootInstallWarningPopup().x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.a5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6993f.f((Boolean) obj);
            }
        }) : rx.e.S(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(Boolean bool) {
        return this.permissionManager.requestDownloadAccess(this.permissionService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(PromotionViewApp promotionViewApp, Throwable th) {
        this.promotionsAnalytics.sendDownloadAbortEvent(promotionViewApp.getPackageName(), promotionViewApp.getVersionCode(), promotionViewApp.getDownloadModel().getAction(), promotionViewApp.getDownloadModel().getAction().equals(DownloadModel.Action.MIGRATE), promotionViewApp.hasSplits(), promotionViewApp.hasAppc(), promotionViewApp.getRank(), promotionViewApp.getStoreName(), false, promotionViewApp.getObb() != null, promotionViewApp.getBdsFlags().contains("STORE_BDS"), HttpUrl.FRAGMENT_ENCODE_SET, promotionViewApp.getSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e j(final PromotionViewApp promotionViewApp, Void r3) {
        return this.permissionManager.requestExternalStoragePermission(this.permissionService).w(new rx.m.b() { // from class: cm.aptoide.pt.promotions.f4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7039f.i(promotionViewApp, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b k(PromotionViewApp promotionViewApp, Void r2) {
        return this.promotionsManager.downloadApp(promotionViewApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getPromotionApps$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(View.LifecycleEvent lifecycleEvent) {
        this.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getPromotionApps$61, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single n(View.LifecycleEvent lifecycleEvent) {
        return this.promotionsManager.getPromotionsModel(this.promotionType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getPromotionApps$62, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(PromotionsModel promotionsModel) {
        this.promotionId = promotionsModel.getPromotionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getPromotionApps$63, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(PromotionsModel promotionsModel) {
        this.promotionsAnalytics.sendOpenPromotionsFragmentEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getPromotionApps$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(Throwable th) {
        this.view.showErrorView();
    }

    static /* synthetic */ void lambda$getPromotionApps$65(PromotionsModel promotionsModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAppCard$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e r(View.LifecycleEvent lifecycleEvent) {
        return this.view.appCardClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAppCard$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(PromotionAppClick promotionAppClick) {
        this.promotionsNavigator.navigateToAppView(promotionAppClick.getApp().getAppId(), promotionAppClick.getApp().getPackageName());
    }

    static /* synthetic */ void lambda$handleClickOnAppCard$46(PromotionAppClick promotionAppClick) {
    }

    static /* synthetic */ void lambda$handleClickOnAppCard$47(Throwable th) {
        throw new IllegalStateException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleDownloadErrors$92, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(PromotionViewApp promotionViewApp) {
        if (promotionViewApp.getDownloadModel().getDownloadState().equals(DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR)) {
            this.promotionsNavigator.navigateToOutOfSpaceDialog(promotionViewApp.getSize(), promotionViewApp.getPackageName());
        } else {
            this.view.showDownloadError(promotionViewApp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleDownloadErrors$93, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e u(PromotionApp promotionApp) {
        return this.promotionsManager.getDownload(promotionApp).D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.j5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((PromotionViewApp) obj).getDownloadModel().hasError());
            }
        }).E().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.u4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7183f.t((PromotionViewApp) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.s3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7165f.verifyNotEnoughSpaceError((PromotionViewApp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleDownloadErrors$94, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e v(PromotionsModel promotionsModel, PromotionViewApp promotionViewApp) {
        return rx.e.N(promotionsModel.getAppsList()).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.d5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7022f.u((PromotionApp) obj);
            }
        });
    }

    static /* synthetic */ PromotionsModel lambda$handleDownloadErrors$95(PromotionsModel promotionsModel, PromotionViewApp promotionViewApp) {
        return promotionsModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleOutOfSpaceDialog$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e w(View.LifecycleEvent lifecycleEvent) {
        return this.promotionsNavigator.outOfSpaceDialogResult();
    }

    static /* synthetic */ Iterable lambda$handleOutOfSpaceDialog$3(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleOutOfSpaceDialog$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b x(PromotionApp promotionApp) {
        return this.promotionsManager.resumeDownload(promotionApp.getMd5(), promotionApp.getPackageName(), promotionApp.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleOutOfSpaceDialog$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e y(final OutOfSpaceNavigatorWrapper outOfSpaceNavigatorWrapper) {
        return this.promotionsManager.getPromotionApps(this.promotionId).A().J(new rx.m.e() { // from class: cm.aptoide.pt.promotions.e3
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                PromotionsPresenter.lambda$handleOutOfSpaceDialog$3(list);
                return list;
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.q5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((PromotionApp) obj).getPackageName().equals(outOfSpaceNavigatorWrapper.getPackageName()));
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.promotions.f3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7038f.x((PromotionApp) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleOutOfSpaceDialog$7(PromotionApp promotionApp) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionApps$80, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(PromotionsModel promotionsModel, PromotionApp promotionApp) {
        this.view.lockPromotionApps(promotionsModel.isWalletInstalled() && promotionApp.isClaimed());
    }

    static /* synthetic */ PromotionsModel lambda$handlePromotionApps$81(PromotionsModel promotionsModel, PromotionApp promotionApp) {
        return promotionsModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionApps$83, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e A(PromotionApp promotionApp) {
        return this.promotionsManager.getDownload(promotionApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionApps$84, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(PromotionViewApp promotionViewApp) {
        this.view.showPromotionApp(promotionViewApp, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionApps$87, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(PromotionViewApp promotionViewApp, Boolean bool) {
        this.promotionsAnalytics.sendValentineMigratorEvent(promotionViewApp.getPackageName(), bool);
    }

    static /* synthetic */ PromotionsModel lambda$handlePromotionApps$88(PromotionsModel promotionsModel, Boolean bool) {
        return promotionsModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionApps$89, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e D(final PromotionsModel promotionsModel, final PromotionViewApp promotionViewApp) {
        return this.promotionsManager.getPackageSignature(promotionViewApp.getPackageName()).j0(this.viewScheduler).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.j6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(promotionViewApp.getSignature().equals((String) obj));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.v5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7192f.C(promotionViewApp, (Boolean) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.m4
            @Override // rx.m.e
            public final Object call(Object obj) {
                PromotionsModel promotionsModel2 = promotionsModel;
                PromotionsPresenter.lambda$handlePromotionApps$88(promotionsModel2, (Boolean) obj);
                return promotionsModel2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionApps$90, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e E(final PromotionsModel promotionsModel, PromotionsModel promotionsModel2) {
        return rx.e.S(promotionsModel).J(new rx.m.e() { // from class: cm.aptoide.pt.promotions.i3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return promotionsModel.getAppsList();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.b4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7002f.A((PromotionApp) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.g4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7050f.B((PromotionViewApp) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.x5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((PromotionViewApp) obj).getDownloadModel().getAction().equals(DownloadModel.Action.UPDATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.y5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7218f.D(promotionsModel, (PromotionViewApp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionClaimResult$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e F(View.LifecycleEvent lifecycleEvent) {
        return this.promotionsNavigator.claimDialogResults();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionClaimResult$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(ClaimDialogResultWrapper claimDialogResultWrapper) {
        this.view.updateClaimStatus(claimDialogResultWrapper.getPackageName());
    }

    static /* synthetic */ void lambda$handlePromotionClaimResult$69(ClaimDialogResultWrapper claimDialogResultWrapper) {
    }

    static /* synthetic */ void lambda$handlePromotionClaimResult$70(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionOverDialogClick$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e H(View.LifecycleEvent lifecycleEvent) {
        return this.view.promotionOverDialogClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionOverDialogClick$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(Void r1) {
        this.promotionsNavigator.navigateToHome();
    }

    static /* synthetic */ void lambda$handlePromotionOverDialogClick$51(Void r0) {
    }

    static /* synthetic */ void lambda$handlePromotionOverDialogClick$52(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$72, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(Void r1) {
        this.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$73, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single K(Void r2) {
        return this.promotionsManager.getPromotionsModel(this.promotionType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$74, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(PromotionsModel promotionsModel) {
        this.promotionId = promotionsModel.getPromotionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$75, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(Throwable th) {
        this.view.showErrorView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$76, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e N(View.LifecycleEvent lifecycleEvent) {
        return this.view.retryClicked().x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.y2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7215f.J((Void) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.promotions.w2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7198f.K((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.p4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7137f.L((PromotionsModel) obj);
            }
        }).j0(this.viewScheduler).G(new r5(this)).w(new rx.m.b() { // from class: cm.aptoide.pt.promotions.m3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7105f.M((Throwable) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleRetryClick$77(PromotionsModel promotionsModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$installButtonClick$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(PromotionViewApp promotionViewApp) {
        this.promotionsAnalytics.sendPromotionsAppInteractInstallEvent(promotionViewApp.getPackageName(), promotionViewApp.getAppcValue(), promotionViewApp.getDownloadModel().getAction(), promotionViewApp.hasSplits(), promotionViewApp.hasAppc(), promotionViewApp.getRank(), null, promotionViewApp.getStoreName(), promotionViewApp.getObb() != null, promotionViewApp.getBdsFlags(), promotionViewApp.getSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$installButtonClick$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e Q(View.LifecycleEvent lifecycleEvent) {
        return this.view.installButtonClick().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.y4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((PromotionViewApp) obj).getDownloadModel().isDownloadable());
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.promotions.k5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7089f.O((PromotionViewApp) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.promotions.i5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7068f.P((PromotionViewApp) obj);
            }
        }).j0(this.viewScheduler).w(new rx.m.b() { // from class: cm.aptoide.pt.promotions.a6
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).s0();
    }

    static /* synthetic */ void lambda$installButtonClick$41(PromotionViewApp promotionViewApp) {
    }

    static /* synthetic */ void lambda$installButtonClick$42(Throwable th) {
        throw new IllegalStateException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$pauseDownload$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b S(PromotionViewApp promotionViewApp) {
        return this.promotionsManager.pauseDownload(promotionViewApp.getMd5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$pauseDownload$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e T(View.LifecycleEvent lifecycleEvent) {
        return this.view.pauseDownload().H(new rx.m.e() { // from class: cm.aptoide.pt.promotions.o5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7129f.S((PromotionViewApp) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$pauseDownload$33(PromotionViewApp promotionViewApp) {
    }

    static /* synthetic */ void lambda$pauseDownload$34(Throwable th) {
        throw new IllegalStateException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(PromotionViewApp promotionViewApp, Throwable th) {
        this.promotionsAnalytics.sendDownloadAbortEvent(promotionViewApp.getPackageName(), promotionViewApp.getVersionCode(), promotionViewApp.getDownloadModel().getAction(), promotionViewApp.getDownloadModel().getAction().equals(DownloadModel.Action.MIGRATE), promotionViewApp.hasSplits(), promotionViewApp.hasAppc(), promotionViewApp.getRank(), promotionViewApp.getStoreName(), false, promotionViewApp.getObb() != null, promotionViewApp.getBdsFlags().contains("STORE_BDS"), HttpUrl.FRAGMENT_ENCODE_SET, promotionViewApp.getSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e V(final PromotionViewApp promotionViewApp, Void r3) {
        return this.permissionManager.requestExternalStoragePermission(this.permissionService).w(new rx.m.b() { // from class: cm.aptoide.pt.promotions.p3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7135f.U(promotionViewApp, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b W(PromotionViewApp promotionViewApp, Void r6) {
        return this.promotionsManager.resumeDownload(promotionViewApp.getMd5(), promotionViewApp.getPackageName(), promotionViewApp.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e X(final PromotionViewApp promotionViewApp) {
        return this.permissionManager.requestDownloadAccess(this.permissionService).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.l4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7096f.V(promotionViewApp, (Void) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.promotions.n4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7117f.W(promotionViewApp, (Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e Y(View.LifecycleEvent lifecycleEvent) {
        return this.view.resumeDownload().G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.t4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7174f.X((PromotionViewApp) obj);
            }
        });
    }

    static /* synthetic */ void lambda$resumeDownload$22(Void r0) {
    }

    static /* synthetic */ void lambda$resumeDownload$23(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showClaimView$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z(PromotionViewApp promotionViewApp, String str) {
        this.promotionsNavigator.navigateToClaimDialog(promotionViewApp.getPackageName(), this.promotionId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showClaimView$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(PromotionViewApp promotionViewApp, String str) {
        this.promotionsNavigator.navigateToClaimDialog(promotionViewApp.getPackageName(), this.promotionId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$verifyNotEnoughSpaceError$96, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(PromotionViewApp promotionViewApp, WalletAdsOfferManager.OfferResponseStatus offerResponseStatus) {
        this.promotionsAnalytics.sendNotEnoughSpaceErrorEvent(promotionViewApp.getMd5());
    }

    static /* synthetic */ PromotionViewApp lambda$verifyNotEnoughSpaceError$97(PromotionViewApp promotionViewApp, WalletAdsOfferManager.OfferResponseStatus offerResponseStatus) {
        return promotionViewApp;
    }

    private void pauseDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.q4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.w4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7200f.T((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).w(new rx.m.b() { // from class: cm.aptoide.pt.promotions.w5
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).s0().f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.promotions.h3
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$pauseDownload$33((PromotionViewApp) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.promotions.t3
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$pauseDownload$34((Throwable) obj);
                throw null;
            }
        });
    }

    private void resumeDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.promotions.c3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.promotions.k3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7087f.Y((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.promotions.b6
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$resumeDownload$22((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.promotions.u3
            @Override // rx.m.b
            public final void call(Object obj) {
                PromotionsPresenter.lambda$resumeDownload$23((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Single<? extends String> showClaimView(final PromotionViewApp promotionViewApp) {
        String str = this.promotionId;
        return str != null ? Single.m(str).g(new rx.m.b() { // from class: cm.aptoide.pt.promotions.r3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7155f.Z(promotionViewApp, (String) obj);
            }
        }) : this.promotionsManager.getPromotionsModel(this.promotionType).n(new rx.m.e() { // from class: cm.aptoide.pt.promotions.z6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((PromotionsModel) obj).getPromotionId();
            }
        }).g(new rx.m.b() { // from class: cm.aptoide.pt.promotions.m5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7107f.a0(promotionViewApp, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public rx.e<? extends PromotionsModel> showPromotions(PromotionsModel promotionsModel) {
        if (promotionsModel.getAppsList().isEmpty()) {
            this.view.showPromotionOverDialog();
            return rx.e.B();
        }
        this.view.setPromotionMessage(promotionsModel.getDescription());
        this.view.showPromotionTitle(promotionsModel.getTitle());
        this.view.showPromotionFeatureGraphic(promotionsModel.getFeatureGraphic());
        return rx.e.f0(handlePromotionApps(promotionsModel), handleDownloadErrors(promotionsModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public rx.e<PromotionViewApp> verifyNotEnoughSpaceError(final PromotionViewApp promotionViewApp) {
        return promotionViewApp.getDownloadModel().getDownloadState() == DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR ? this.moPubAdsManager.getAdsVisibilityStatus().g(new rx.m.b() { // from class: cm.aptoide.pt.promotions.j4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7077f.b0(promotionViewApp, (WalletAdsOfferManager.OfferResponseStatus) obj);
            }
        }).A().X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.c4
            @Override // rx.m.e
            public final Object call(Object obj) {
                PromotionViewApp promotionViewApp2 = promotionViewApp;
                PromotionsPresenter.lambda$verifyNotEnoughSpaceError$97(promotionViewApp2, (WalletAdsOfferManager.OfferResponseStatus) obj);
                return promotionViewApp2;
            }
        }) : rx.e.S(promotionViewApp);
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        getPromotionApps();
        installButtonClick();
        handleClickOnAppCard();
        pauseDownload();
        cancelDownload();
        resumeDownload();
        claimApp();
        handlePromotionClaimResult();
        handleRetryClick();
        handlePromotionOverDialogClick();
        handleOutOfSpaceDialog();
    }
}
