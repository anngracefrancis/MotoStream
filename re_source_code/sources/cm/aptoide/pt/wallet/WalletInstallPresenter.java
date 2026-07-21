package cm.aptoide.pt.wallet;

import android.os.Build;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.promotions.WalletApp;
import kotlin.Metadata;
import kotlin.Pair;
import okhttp3.HttpUrl;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: WalletInstallPresenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020*H\u0002J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\b\u00101\u001a\u00020/H\u0002J\b\u00102\u001a\u00020*H\u0002J\u0016\u00103\u001a\b\u0012\u0004\u0012\u0002040.2\u0006\u00105\u001a\u000204H\u0002J\b\u00106\u001a\u00020*H\u0016J\u001e\u00107\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0004\u0012\u00020408\u0018\u00010.H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u00105\u001a\u000204H\u0002J\u001e\u0010<\u001a\b\u0012\u0004\u0012\u00020=0.2\u0006\u0010>\u001a\u00020=2\u0006\u00105\u001a\u000204H\u0002R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006?"}, d2 = {"Lcm/aptoide/pt/wallet/WalletInstallPresenter;", "Lcm/aptoide/pt/presenter/Presenter;", "view", "Lcm/aptoide/pt/wallet/WalletInstallView;", "walletInstallManager", "Lcm/aptoide/pt/wallet/WalletInstallManager;", "navigator", "Lcm/aptoide/pt/wallet/WalletInstallNavigator;", "permissionManager", "Lcm/aptoide/pt/actions/PermissionManager;", "permissionService", "Lcm/aptoide/pt/actions/PermissionService;", "viewScheduler", "Lrx/Scheduler;", "io", "configuration", "Lcm/aptoide/pt/wallet/WalletInstallConfiguration;", "walletInstallAnalytics", "Lcm/aptoide/pt/wallet/WalletInstallAnalytics;", "moPubAdsManager", "Lcm/aptoide/pt/ads/MoPubAdsManager;", "(Lcm/aptoide/pt/wallet/WalletInstallView;Lcm/aptoide/pt/wallet/WalletInstallManager;Lcm/aptoide/pt/wallet/WalletInstallNavigator;Lcm/aptoide/pt/actions/PermissionManager;Lcm/aptoide/pt/actions/PermissionService;Lrx/Scheduler;Lrx/Scheduler;Lcm/aptoide/pt/wallet/WalletInstallConfiguration;Lcm/aptoide/pt/wallet/WalletInstallAnalytics;Lcm/aptoide/pt/ads/MoPubAdsManager;)V", "getConfiguration", "()Lcm/aptoide/pt/wallet/WalletInstallConfiguration;", "getIo", "()Lrx/Scheduler;", "getMoPubAdsManager", "()Lcm/aptoide/pt/ads/MoPubAdsManager;", "getNavigator", "()Lcm/aptoide/pt/wallet/WalletInstallNavigator;", "getPermissionManager", "()Lcm/aptoide/pt/actions/PermissionManager;", "getPermissionService", "()Lcm/aptoide/pt/actions/PermissionService;", "getView", "()Lcm/aptoide/pt/wallet/WalletInstallView;", "getViewScheduler", "getWalletInstallAnalytics", "()Lcm/aptoide/pt/wallet/WalletInstallAnalytics;", "getWalletInstallManager", "()Lcm/aptoide/pt/wallet/WalletInstallManager;", "handleAnalyticsContextSetup", HttpUrl.FRAGMENT_ENCODE_SET, "handleCancelDownloadButton", "handleCloseButtonClick", "handleInstallDialogCancelButtonPress", "Lrx/Observable;", HttpUrl.FRAGMENT_ENCODE_SET, "handleWalletInstallation", "hasMinimumSdk", "loadWalletInstall", "observeDownloadProgress", "Lcm/aptoide/pt/promotions/WalletApp;", "walletApp", "present", "showWalletInitialState", "Lkotlin/Pair;", HttpUrl.FRAGMENT_ENCODE_SET, "startWalletDownload", "Lrx/Completable;", "verifyNotEnoughSpaceError", "Lcm/aptoide/pt/app/DownloadModel;", "downloadModel", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletInstallPresenter implements Presenter {
    private final WalletInstallConfiguration configuration;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private final rx.h f8316io;
    private final MoPubAdsManager moPubAdsManager;
    private final WalletInstallNavigator navigator;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private final WalletInstallView view;
    private final rx.h viewScheduler;
    private final WalletInstallAnalytics walletInstallAnalytics;
    private final WalletInstallManager walletInstallManager;

    public WalletInstallPresenter(WalletInstallView walletInstallView, WalletInstallManager walletInstallManager, WalletInstallNavigator walletInstallNavigator, PermissionManager permissionManager, PermissionService permissionService, rx.h hVar, rx.h hVar2, WalletInstallConfiguration walletInstallConfiguration, WalletInstallAnalytics walletInstallAnalytics, MoPubAdsManager moPubAdsManager) {
        kotlin.jvm.internal.m.f(walletInstallView, "view");
        kotlin.jvm.internal.m.f(walletInstallManager, "walletInstallManager");
        kotlin.jvm.internal.m.f(walletInstallNavigator, "navigator");
        kotlin.jvm.internal.m.f(permissionManager, "permissionManager");
        kotlin.jvm.internal.m.f(permissionService, "permissionService");
        kotlin.jvm.internal.m.f(hVar, "viewScheduler");
        kotlin.jvm.internal.m.f(hVar2, "io");
        kotlin.jvm.internal.m.f(walletInstallConfiguration, "configuration");
        kotlin.jvm.internal.m.f(walletInstallAnalytics, "walletInstallAnalytics");
        kotlin.jvm.internal.m.f(moPubAdsManager, "moPubAdsManager");
        this.view = walletInstallView;
        this.walletInstallManager = walletInstallManager;
        this.navigator = walletInstallNavigator;
        this.permissionManager = permissionManager;
        this.permissionService = permissionService;
        this.viewScheduler = hVar;
        this.f8316io = hVar2;
        this.configuration = walletInstallConfiguration;
        this.walletInstallAnalytics = walletInstallAnalytics;
        this.moPubAdsManager = moPubAdsManager;
    }

    private final void handleAnalyticsContextSetup() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.wallet.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m328handleAnalyticsContextSetup$lambda0((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.wallet.w
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m329handleAnalyticsContextSetup$lambda1(this.f8370f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.wallet.z0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m330handleAnalyticsContextSetup$lambda2((View.LifecycleEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.wallet.m0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m331handleAnalyticsContextSetup$lambda3(this.f8346f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleAnalyticsContextSetup$lambda-0, reason: not valid java name */
    public static final Boolean m328handleAnalyticsContextSetup$lambda0(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(View.LifecycleEvent.CREATE == lifecycleEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleAnalyticsContextSetup$lambda-1, reason: not valid java name */
    public static final void m329handleAnalyticsContextSetup$lambda1(WalletInstallPresenter walletInstallPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        walletInstallPresenter.walletInstallManager.setupAnalyticsHistoryTracker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleAnalyticsContextSetup$lambda-2, reason: not valid java name */
    public static final void m330handleAnalyticsContextSetup$lambda2(View.LifecycleEvent lifecycleEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleAnalyticsContextSetup$lambda-3, reason: not valid java name */
    public static final void m331handleAnalyticsContextSetup$lambda3(WalletInstallPresenter walletInstallPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        th.printStackTrace();
        walletInstallPresenter.view.dismissDialog();
    }

    private final void handleCancelDownloadButton() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.wallet.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m333handleCancelDownloadButton$lambda4((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.wallet.o0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m334handleCancelDownloadButton$lambda5(this.f8351f, (View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.wallet.j0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m335handleCancelDownloadButton$lambda6(this.f8339f, (Void) obj);
            }
        }).E().x(new rx.m.b() { // from class: cm.aptoide.pt.wallet.t0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m336handleCancelDownloadButton$lambda7(this.f8364f, (WalletApp) obj);
            }
        }).j0(this.viewScheduler).v(new rx.m.a() { // from class: cm.aptoide.pt.wallet.e0
            @Override // rx.m.a
            public final void call() {
                WalletInstallPresenter.m337handleCancelDownloadButton$lambda8(this.f8327f);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.wallet.s
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m338handleCancelDownloadButton$lambda9((WalletApp) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.wallet.y0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m332handleCancelDownloadButton$lambda10(this.f8376f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownloadButton$lambda-10, reason: not valid java name */
    public static final void m332handleCancelDownloadButton$lambda10(WalletInstallPresenter walletInstallPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        th.printStackTrace();
        walletInstallPresenter.view.dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownloadButton$lambda-4, reason: not valid java name */
    public static final Boolean m333handleCancelDownloadButton$lambda4(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(View.LifecycleEvent.CREATE == lifecycleEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownloadButton$lambda-5, reason: not valid java name */
    public static final rx.e m334handleCancelDownloadButton$lambda5(WalletInstallPresenter walletInstallPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        return walletInstallPresenter.view.cancelDownloadButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownloadButton$lambda-6, reason: not valid java name */
    public static final rx.e m335handleCancelDownloadButton$lambda6(WalletInstallPresenter walletInstallPresenter, Void r1) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        return walletInstallPresenter.walletInstallManager.getWallet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownloadButton$lambda-7, reason: not valid java name */
    public static final void m336handleCancelDownloadButton$lambda7(WalletInstallPresenter walletInstallPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        WalletInstallManager walletInstallManager = walletInstallPresenter.walletInstallManager;
        kotlin.jvm.internal.m.e(walletApp, "walletApp");
        walletInstallManager.removeDownload(walletApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownloadButton$lambda-8, reason: not valid java name */
    public static final void m337handleCancelDownloadButton$lambda8(WalletInstallPresenter walletInstallPresenter) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        walletInstallPresenter.view.dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownloadButton$lambda-9, reason: not valid java name */
    public static final void m338handleCancelDownloadButton$lambda9(WalletApp walletApp) {
    }

    private final void handleCloseButtonClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.wallet.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m339handleCloseButtonClick$lambda31((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.wallet.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m340handleCloseButtonClick$lambda32(this.f8355f, (View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.wallet.k0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m341handleCloseButtonClick$lambda33(this.f8342f, (Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.wallet.n0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m342handleCloseButtonClick$lambda34((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.wallet.i0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m343handleCloseButtonClick$lambda35(this.f8337f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCloseButtonClick$lambda-31, reason: not valid java name */
    public static final Boolean m339handleCloseButtonClick$lambda31(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(View.LifecycleEvent.CREATE == lifecycleEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCloseButtonClick$lambda-32, reason: not valid java name */
    public static final rx.e m340handleCloseButtonClick$lambda32(WalletInstallPresenter walletInstallPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        return walletInstallPresenter.view.closeButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCloseButtonClick$lambda-33, reason: not valid java name */
    public static final void m341handleCloseButtonClick$lambda33(WalletInstallPresenter walletInstallPresenter, Void r1) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        walletInstallPresenter.view.dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCloseButtonClick$lambda-34, reason: not valid java name */
    public static final void m342handleCloseButtonClick$lambda34(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCloseButtonClick$lambda-35, reason: not valid java name */
    public static final void m343handleCloseButtonClick$lambda35(WalletInstallPresenter walletInstallPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        th.printStackTrace();
        walletInstallPresenter.view.dismissDialog();
    }

    private final rx.e<Boolean> handleInstallDialogCancelButtonPress() {
        rx.e<Boolean> eVarX = this.walletInstallManager.onWalletInstallationCanceled().E().x(new rx.m.b() { // from class: cm.aptoide.pt.wallet.b0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m344handleInstallDialogCancelButtonPress$lambda36(this.f8320f, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarX, "walletInstallManager.onW… { view.dismissDialog() }");
        return eVarX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleInstallDialogCancelButtonPress$lambda-36, reason: not valid java name */
    public static final void m344handleInstallDialogCancelButtonPress$lambda36(WalletInstallPresenter walletInstallPresenter, Boolean bool) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        walletInstallPresenter.view.dismissDialog();
    }

    private final rx.e<Boolean> handleWalletInstallation() {
        rx.e<Boolean> eVarX = this.walletInstallManager.onWalletInstalled().E().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.wallet.a1
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m345handleWalletInstallation$lambda11(this.f8319f, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarX, "walletInstallManager.onW…stallationSuccessView() }");
        return eVarX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleWalletInstallation$lambda-11, reason: not valid java name */
    public static final void m345handleWalletInstallation$lambda11(WalletInstallPresenter walletInstallPresenter, Boolean bool) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        walletInstallPresenter.view.showInstallationSuccessView();
    }

    private final boolean hasMinimumSdk() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private final void loadWalletInstall() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.wallet.s0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m346loadWalletInstall$lambda12((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.wallet.f0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m347loadWalletInstall$lambda13(this.f8329f, (View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.wallet.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m348loadWalletInstall$lambda14(this.f8324f, (View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.wallet.x0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m349loadWalletInstall$lambda15(this.f8374f, (View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.wallet.a0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m350loadWalletInstall$lambda16((Pair) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.wallet.c0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m351loadWalletInstall$lambda17(this.f8322f, (Pair) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.wallet.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m352loadWalletInstall$lambda18(this.f8344f, (Pair) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.wallet.v
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m353loadWalletInstall$lambda19(obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.wallet.r0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m354loadWalletInstall$lambda20(this.f8359f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletInstall$lambda-12, reason: not valid java name */
    public static final Boolean m346loadWalletInstall$lambda12(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(View.LifecycleEvent.CREATE == lifecycleEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletInstall$lambda-13, reason: not valid java name */
    public static final void m347loadWalletInstall$lambda13(WalletInstallPresenter walletInstallPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        if (walletInstallPresenter.hasMinimumSdk()) {
            walletInstallPresenter.view.showSdkErrorView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletInstall$lambda-14, reason: not valid java name */
    public static final Boolean m348loadWalletInstall$lambda14(WalletInstallPresenter walletInstallPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        return Boolean.valueOf(!walletInstallPresenter.hasMinimumSdk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletInstall$lambda-15, reason: not valid java name */
    public static final rx.e m349loadWalletInstall$lambda15(WalletInstallPresenter walletInstallPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        return walletInstallPresenter.showWalletInitialState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletInstall$lambda-16, reason: not valid java name */
    public static final Boolean m350loadWalletInstall$lambda16(Pair pair) {
        return Boolean.valueOf(!((WalletApp) pair.d()).isInstalled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletInstall$lambda-17, reason: not valid java name */
    public static final void m351loadWalletInstall$lambda17(WalletInstallPresenter walletInstallPresenter, Pair pair) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        walletInstallPresenter.view.showIndeterminateDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletInstall$lambda-18, reason: not valid java name */
    public static final rx.e m352loadWalletInstall$lambda18(WalletInstallPresenter walletInstallPresenter, Pair pair) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        return walletInstallPresenter.startWalletDownload((WalletApp) pair.d()).b(rx.e.b0(walletInstallPresenter.handleWalletInstallation(), walletInstallPresenter.observeDownloadProgress((WalletApp) pair.d()), walletInstallPresenter.handleInstallDialogCancelButtonPress()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletInstall$lambda-19, reason: not valid java name */
    public static final void m353loadWalletInstall$lambda19(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletInstall$lambda-20, reason: not valid java name */
    public static final void m354loadWalletInstall$lambda20(WalletInstallPresenter walletInstallPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        th.printStackTrace();
        walletInstallPresenter.view.dismissDialog();
    }

    private final rx.e<WalletApp> observeDownloadProgress(final WalletApp walletApp) {
        rx.e<WalletApp> eVarX = this.walletInstallManager.loadDownloadModel(walletApp).G(new rx.m.e() { // from class: cm.aptoide.pt.wallet.v0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m355observeDownloadProgress$lambda21(this.f8368f, walletApp, (DownloadModel) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.wallet.u0
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m356observeDownloadProgress$lambda22(this.f8366f, (DownloadModel) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.wallet.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m357observeDownloadProgress$lambda23(walletApp, (DownloadModel) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarX, "walletInstallManager.loa…e(it) }.map { walletApp }");
        return eVarX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observeDownloadProgress$lambda-21, reason: not valid java name */
    public static final rx.e m355observeDownloadProgress$lambda21(WalletInstallPresenter walletInstallPresenter, WalletApp walletApp, DownloadModel downloadModel) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        kotlin.jvm.internal.m.f(walletApp, "$walletApp");
        kotlin.jvm.internal.m.e(downloadModel, "downloadModel");
        return walletInstallPresenter.verifyNotEnoughSpaceError(downloadModel, walletApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observeDownloadProgress$lambda-22, reason: not valid java name */
    public static final void m356observeDownloadProgress$lambda22(WalletInstallPresenter walletInstallPresenter, DownloadModel downloadModel) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        WalletInstallView walletInstallView = walletInstallPresenter.view;
        kotlin.jvm.internal.m.e(downloadModel, "it");
        walletInstallView.showDownloadState(downloadModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observeDownloadProgress$lambda-23, reason: not valid java name */
    public static final WalletApp m357observeDownloadProgress$lambda23(WalletApp walletApp, DownloadModel downloadModel) {
        kotlin.jvm.internal.m.f(walletApp, "$walletApp");
        return walletApp;
    }

    private final rx.e<Pair<String, WalletApp>> showWalletInitialState() {
        return rx.e.d1(this.walletInstallManager.getAppIcon(this.configuration.getAppPackageName()), this.walletInstallManager.getWallet(), new rx.m.f() { // from class: cm.aptoide.pt.wallet.q0
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return WalletInstallPresenter.m358showWalletInitialState$lambda29((String) obj, (WalletApp) obj2);
            }
        }).E().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.wallet.x
            @Override // rx.m.b
            public final void call(Object obj) {
                WalletInstallPresenter.m359showWalletInitialState$lambda30(this.f8373f, (Pair) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showWalletInitialState$lambda-29, reason: not valid java name */
    public static final Pair m358showWalletInitialState$lambda29(String str, WalletApp walletApp) {
        kotlin.jvm.internal.m.e(walletApp, "walletApp");
        return new Pair(str, walletApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showWalletInitialState$lambda-30, reason: not valid java name */
    public static final void m359showWalletInitialState$lambda30(WalletInstallPresenter walletInstallPresenter, Pair pair) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        if (((WalletApp) pair.d()).isInstalled()) {
            walletInstallPresenter.view.showWalletInstalledAlreadyView();
        } else {
            walletInstallPresenter.view.showWalletInstallationView((String) pair.c(), (WalletApp) pair.d());
        }
    }

    private final rx.b startWalletDownload(final WalletApp walletApp) {
        rx.b bVarX0 = rx.e.p(new rx.m.d() { // from class: cm.aptoide.pt.wallet.w0
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return WalletInstallPresenter.m360startWalletDownload$lambda26(this.f8371f, walletApp);
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.wallet.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m362startWalletDownload$lambda28(this.f8357f, walletApp, (WalletApp) obj);
            }
        }).X0();
        kotlin.jvm.internal.m.e(bVarX0, "defer {\n      if (wallet…}\n      }.toCompletable()");
        return bVarX0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startWalletDownload$lambda-26, reason: not valid java name */
    public static final rx.e m360startWalletDownload$lambda26(final WalletInstallPresenter walletInstallPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        kotlin.jvm.internal.m.f(walletApp, "$walletApp");
        if (walletInstallPresenter.walletInstallManager.shouldShowRootInstallWarningPopup()) {
            walletInstallPresenter.view.showRootInstallWarningPopup().x(new rx.m.b() { // from class: cm.aptoide.pt.wallet.y
                @Override // rx.m.b
                public final void call(Object obj) {
                    WalletInstallPresenter.m361startWalletDownload$lambda26$lambda25(this.f8375f, (Boolean) obj);
                }
            });
        }
        return rx.e.S(walletApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startWalletDownload$lambda-26$lambda-25, reason: not valid java name */
    public static final void m361startWalletDownload$lambda26$lambda25(WalletInstallPresenter walletInstallPresenter, Boolean bool) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        WalletInstallManager walletInstallManager = walletInstallPresenter.walletInstallManager;
        kotlin.jvm.internal.m.e(bool, "answer");
        walletInstallManager.allowRootInstall(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startWalletDownload$lambda-28, reason: not valid java name */
    public static final rx.e m362startWalletDownload$lambda28(final WalletInstallPresenter walletInstallPresenter, final WalletApp walletApp, WalletApp walletApp2) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        kotlin.jvm.internal.m.f(walletApp, "$walletApp");
        return walletInstallPresenter.permissionManager.requestDownloadAllowingMobileData(walletInstallPresenter.permissionService).j0(Schedulers.io()).H(new rx.m.e() { // from class: cm.aptoide.pt.wallet.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallPresenter.m363startWalletDownload$lambda28$lambda27(this.f8334f, walletApp, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startWalletDownload$lambda-28$lambda-27, reason: not valid java name */
    public static final rx.b m363startWalletDownload$lambda28$lambda27(WalletInstallPresenter walletInstallPresenter, WalletApp walletApp, Void r2) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        kotlin.jvm.internal.m.f(walletApp, "$walletApp");
        return walletInstallPresenter.walletInstallManager.downloadApp(walletApp);
    }

    private final rx.e<DownloadModel> verifyNotEnoughSpaceError(DownloadModel downloadModel, final WalletApp walletApp) {
        if (downloadModel.getDownloadState() == DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR) {
            rx.e.S(downloadModel).x(new rx.m.b() { // from class: cm.aptoide.pt.wallet.t
                @Override // rx.m.b
                public final void call(Object obj) {
                    WalletInstallPresenter.m364verifyNotEnoughSpaceError$lambda24(this.f8362f, walletApp, (DownloadModel) obj);
                }
            });
        }
        rx.e<DownloadModel> eVarS = rx.e.S(downloadModel);
        kotlin.jvm.internal.m.e(eVarS, "just(downloadModel)");
        return eVarS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: verifyNotEnoughSpaceError$lambda-24, reason: not valid java name */
    public static final void m364verifyNotEnoughSpaceError$lambda24(WalletInstallPresenter walletInstallPresenter, WalletApp walletApp, DownloadModel downloadModel) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "this$0");
        kotlin.jvm.internal.m.f(walletApp, "$walletApp");
        walletInstallPresenter.walletInstallAnalytics.sendNotEnoughSpaceErrorEvent(walletApp.getMd5sum());
    }

    public final WalletInstallConfiguration getConfiguration() {
        return this.configuration;
    }

    /* JADX INFO: renamed from: getIo, reason: from getter */
    public final rx.h getF8316io() {
        return this.f8316io;
    }

    public final MoPubAdsManager getMoPubAdsManager() {
        return this.moPubAdsManager;
    }

    public final WalletInstallNavigator getNavigator() {
        return this.navigator;
    }

    public final PermissionManager getPermissionManager() {
        return this.permissionManager;
    }

    public final PermissionService getPermissionService() {
        return this.permissionService;
    }

    public final WalletInstallView getView() {
        return this.view;
    }

    public final rx.h getViewScheduler() {
        return this.viewScheduler;
    }

    public final WalletInstallAnalytics getWalletInstallAnalytics() {
        return this.walletInstallAnalytics;
    }

    public final WalletInstallManager getWalletInstallManager() {
        return this.walletInstallManager;
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        loadWalletInstall();
        handleCloseButtonClick();
        handleCancelDownloadButton();
        handleAnalyticsContextSetup();
    }
}
