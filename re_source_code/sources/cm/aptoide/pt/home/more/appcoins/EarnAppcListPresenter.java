package cm.aptoide.pt.home.more.appcoins;

import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceNavigatorWrapper;
import cm.aptoide.pt.home.bundles.apps.RewardApp;
import cm.aptoide.pt.home.more.base.ListAppsClickEvent;
import cm.aptoide.pt.home.more.base.ListAppsPresenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.promotions.WalletApp;
import cm.aptoide.pt.repository.request.RewardAppCoinsAppsRepository;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: EarnAppcListPresenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0016J\b\u0010)\u001a\u00020&H\u0002J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0\u001fH\u0002J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\u0014\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020 0\u001fH\u0016J\b\u00100\u001a\u00020&H\u0002J\u000e\u00101\u001a\b\u0012\u0004\u0012\u0002020\u001fH\u0002J\u000e\u00103\u001a\b\u0012\u0004\u0012\u0002020\u001fH\u0002J\b\u00104\u001a\u00020&H\u0016J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0002J\u0016\u00108\u001a\b\u0012\u0004\u0012\u0002020\u001f2\u0006\u00109\u001a\u000202H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcm/aptoide/pt/home/more/appcoins/EarnAppcListPresenter;", "Lcm/aptoide/pt/home/more/base/ListAppsPresenter;", "Lcm/aptoide/pt/home/bundles/apps/RewardApp;", "view", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListView;", "viewScheduler", "Lrx/Scheduler;", "crashReporter", "Lcm/aptoide/pt/crashreports/CrashReport;", "rewardAppsRepository", "Lcm/aptoide/pt/repository/request/RewardAppCoinsAppsRepository;", "analyticsManager", "Lcm/aptoide/analytics/AnalyticsManager;", "appNavigator", "Lcm/aptoide/pt/app/AppNavigator;", "earnAppcListConfiguration", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListConfiguration;", "earnAppcListManager", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListManager;", "permissionManager", "Lcm/aptoide/pt/actions/PermissionManager;", "permissionService", "Lcm/aptoide/pt/actions/PermissionService;", "moPubAdsManager", "Lcm/aptoide/pt/ads/MoPubAdsManager;", "earnAppcListAnalytics", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListAnalytics;", "earnAppcNavigator", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcNavigator;", "(Lcm/aptoide/pt/home/more/appcoins/EarnAppcListView;Lrx/Scheduler;Lcm/aptoide/pt/crashreports/CrashReport;Lcm/aptoide/pt/repository/request/RewardAppCoinsAppsRepository;Lcm/aptoide/analytics/AnalyticsManager;Lcm/aptoide/pt/app/AppNavigator;Lcm/aptoide/pt/home/more/appcoins/EarnAppcListConfiguration;Lcm/aptoide/pt/home/more/appcoins/EarnAppcListManager;Lcm/aptoide/pt/actions/PermissionManager;Lcm/aptoide/pt/actions/PermissionService;Lcm/aptoide/pt/ads/MoPubAdsManager;Lcm/aptoide/pt/home/more/appcoins/EarnAppcListAnalytics;Lcm/aptoide/pt/home/more/appcoins/EarnAppcNavigator;)V", "getApps", "Lrx/Observable;", HttpUrl.FRAGMENT_ENCODE_SET, "refresh", HttpUrl.FRAGMENT_ENCODE_SET, "getTitle", HttpUrl.FRAGMENT_ENCODE_SET, "handleAppClick", HttpUrl.FRAGMENT_ENCODE_SET, "appClickEvent", "Lcm/aptoide/pt/home/more/base/ListAppsClickEvent;", "handleCancelDownload", "handleOnWalletInstalled", "handleOutOfSpaceDialogResult", "handlePauseDownload", "handleResumeDownload", "handleWalletInstallClick", "loadMoreApps", "loadWalletApp", "observeWalletDownloadError", "Lcm/aptoide/pt/promotions/WalletApp;", "observeWalletState", "present", "startWalletDownload", "Lrx/Completable;", "actionCompletable", "verifyNotEnoughSpaceError", "walletApp", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EarnAppcListPresenter extends ListAppsPresenter<RewardApp> {
    private final AnalyticsManager analyticsManager;
    private final AppNavigator appNavigator;
    private final CrashReport crashReporter;
    private final EarnAppcListAnalytics earnAppcListAnalytics;
    private final EarnAppcListConfiguration earnAppcListConfiguration;
    private final EarnAppcListManager earnAppcListManager;
    private final EarnAppcNavigator earnAppcNavigator;
    private final MoPubAdsManager moPubAdsManager;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private final RewardAppCoinsAppsRepository rewardAppsRepository;
    private final EarnAppcListView view;
    private final rx.h viewScheduler;

    /* JADX INFO: renamed from: cm.aptoide.pt.home.more.appcoins.EarnAppcListPresenter$startWalletDownload$2, reason: invalid class name */
    /* JADX INFO: compiled from: EarnAppcListPresenter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lrx/Observable;", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", HttpUrl.FRAGMENT_ENCODE_SET, "call"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass2<T, R> implements rx.m.e {
        final /* synthetic */ rx.b $actionCompletable;

        AnonymousClass2(rx.b bVar) {
            this.$actionCompletable = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: call$lambda-0, reason: not valid java name */
        public static final rx.e m232call$lambda0(EarnAppcListPresenter earnAppcListPresenter, Void r1) {
            kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
            return earnAppcListPresenter.permissionManager.requestExternalStoragePermission(earnAppcListPresenter.permissionService);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: call$lambda-1, reason: not valid java name */
        public static final rx.b m233call$lambda1(rx.b bVar, Void r1) {
            kotlin.jvm.internal.m.f(bVar, "$actionCompletable");
            return bVar;
        }

        @Override // rx.m.e
        public final rx.e<? extends Void> call(Void r3) {
            rx.e<Void> eVarRequestDownloadAllowingMobileData = EarnAppcListPresenter.this.permissionManager.requestDownloadAllowingMobileData(EarnAppcListPresenter.this.permissionService);
            final EarnAppcListPresenter earnAppcListPresenter = EarnAppcListPresenter.this;
            rx.e<R> eVarJ0 = eVarRequestDownloadAllowingMobileData.G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.y0
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return EarnAppcListPresenter.AnonymousClass2.m232call$lambda0(earnAppcListPresenter, (Void) obj);
                }
            }).j0(Schedulers.io());
            final rx.b bVar = this.$actionCompletable;
            return eVarJ0.H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.x0
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return EarnAppcListPresenter.AnonymousClass2.m233call$lambda1(bVar, (Void) obj);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarnAppcListPresenter(EarnAppcListView earnAppcListView, rx.h hVar, CrashReport crashReport, RewardAppCoinsAppsRepository rewardAppCoinsAppsRepository, AnalyticsManager analyticsManager, AppNavigator appNavigator, EarnAppcListConfiguration earnAppcListConfiguration, EarnAppcListManager earnAppcListManager, PermissionManager permissionManager, PermissionService permissionService, MoPubAdsManager moPubAdsManager, EarnAppcListAnalytics earnAppcListAnalytics, EarnAppcNavigator earnAppcNavigator) {
        super(earnAppcListView, hVar, crashReport);
        kotlin.jvm.internal.m.f(earnAppcListView, "view");
        kotlin.jvm.internal.m.f(hVar, "viewScheduler");
        kotlin.jvm.internal.m.f(crashReport, "crashReporter");
        kotlin.jvm.internal.m.f(rewardAppCoinsAppsRepository, "rewardAppsRepository");
        kotlin.jvm.internal.m.f(analyticsManager, "analyticsManager");
        kotlin.jvm.internal.m.f(appNavigator, "appNavigator");
        kotlin.jvm.internal.m.f(earnAppcListConfiguration, "earnAppcListConfiguration");
        kotlin.jvm.internal.m.f(earnAppcListManager, "earnAppcListManager");
        kotlin.jvm.internal.m.f(permissionManager, "permissionManager");
        kotlin.jvm.internal.m.f(permissionService, "permissionService");
        kotlin.jvm.internal.m.f(moPubAdsManager, "moPubAdsManager");
        kotlin.jvm.internal.m.f(earnAppcListAnalytics, "earnAppcListAnalytics");
        kotlin.jvm.internal.m.f(earnAppcNavigator, "earnAppcNavigator");
        this.view = earnAppcListView;
        this.viewScheduler = hVar;
        this.crashReporter = crashReport;
        this.rewardAppsRepository = rewardAppCoinsAppsRepository;
        this.analyticsManager = analyticsManager;
        this.appNavigator = appNavigator;
        this.earnAppcListConfiguration = earnAppcListConfiguration;
        this.earnAppcListManager = earnAppcListManager;
        this.permissionManager = permissionManager;
        this.permissionService = permissionService;
        this.moPubAdsManager = moPubAdsManager;
        this.earnAppcListAnalytics = earnAppcListAnalytics;
        this.earnAppcNavigator = earnAppcNavigator;
    }

    private final void handleCancelDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m188handleCancelDownload$lambda20((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m189handleCancelDownload$lambda22(this.f6201f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.p
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m191handleCancelDownload$lambda23((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.i0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m192handleCancelDownload$lambda24(this.f6172f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownload$lambda-20, reason: not valid java name */
    public static final Boolean m188handleCancelDownload$lambda20(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownload$lambda-22, reason: not valid java name */
    public static final rx.e m189handleCancelDownload$lambda22(final EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.view.cancelDownload().H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m190handleCancelDownload$lambda22$lambda21(this.f6188f, (Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownload$lambda-22$lambda-21, reason: not valid java name */
    public static final rx.b m190handleCancelDownload$lambda22$lambda21(EarnAppcListPresenter earnAppcListPresenter, Void r1) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.earnAppcListManager.cancelWalletDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownload$lambda-23, reason: not valid java name */
    public static final void m191handleCancelDownload$lambda23(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCancelDownload$lambda-24, reason: not valid java name */
    public static final void m192handleCancelDownload$lambda24(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    private final rx.e<Boolean> handleOnWalletInstalled() {
        rx.e<Boolean> eVarX = this.earnAppcListManager.onWalletInstalled().E().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.m0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m193handleOnWalletInstalled$lambda6(this.f6181f, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarX, "earnAppcListManager.onWa…{ view.hideWalletArea() }");
        return eVarX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleOnWalletInstalled$lambda-6, reason: not valid java name */
    public static final void m193handleOnWalletInstalled$lambda6(EarnAppcListPresenter earnAppcListPresenter, Boolean bool) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.view.hideWalletArea();
    }

    private final void handleOutOfSpaceDialogResult() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.a1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m194handleOutOfSpaceDialogResult$lambda0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m195handleOutOfSpaceDialogResult$lambda1(this.f6194f, (View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m196handleOutOfSpaceDialogResult$lambda2((OutOfSpaceNavigatorWrapper) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.a0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m197handleOutOfSpaceDialogResult$lambda3(this.f6149f, (OutOfSpaceNavigatorWrapper) obj);
            }
        }).s0().f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.b0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m198handleOutOfSpaceDialogResult$lambda4((OutOfSpaceNavigatorWrapper) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.h0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m199handleOutOfSpaceDialogResult$lambda5(this.f6170f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleOutOfSpaceDialogResult$lambda-0, reason: not valid java name */
    public static final Boolean m194handleOutOfSpaceDialogResult$lambda0(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleOutOfSpaceDialogResult$lambda-1, reason: not valid java name */
    public static final rx.e m195handleOutOfSpaceDialogResult$lambda1(EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.earnAppcNavigator.outOfSpaceDialogResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleOutOfSpaceDialogResult$lambda-2, reason: not valid java name */
    public static final Boolean m196handleOutOfSpaceDialogResult$lambda2(OutOfSpaceNavigatorWrapper outOfSpaceNavigatorWrapper) {
        return Boolean.valueOf(outOfSpaceNavigatorWrapper.getClearedSuccessfully());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleOutOfSpaceDialogResult$lambda-3, reason: not valid java name */
    public static final rx.b m197handleOutOfSpaceDialogResult$lambda3(EarnAppcListPresenter earnAppcListPresenter, OutOfSpaceNavigatorWrapper outOfSpaceNavigatorWrapper) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.startWalletDownload(earnAppcListPresenter.earnAppcListManager.resumeWalletDownload());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleOutOfSpaceDialogResult$lambda-4, reason: not valid java name */
    public static final void m198handleOutOfSpaceDialogResult$lambda4(OutOfSpaceNavigatorWrapper outOfSpaceNavigatorWrapper) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleOutOfSpaceDialogResult$lambda-5, reason: not valid java name */
    public static final void m199handleOutOfSpaceDialogResult$lambda5(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    private final void handlePauseDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m200handlePauseDownload$lambda30((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.w
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m201handlePauseDownload$lambda32(this.f6200f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.q0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m203handlePauseDownload$lambda33((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.s0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m204handlePauseDownload$lambda34(this.f6193f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handlePauseDownload$lambda-30, reason: not valid java name */
    public static final Boolean m200handlePauseDownload$lambda30(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handlePauseDownload$lambda-32, reason: not valid java name */
    public static final rx.e m201handlePauseDownload$lambda32(final EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.view.pauseDownload().H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m202handlePauseDownload$lambda32$lambda31(this.f6158f, (Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handlePauseDownload$lambda-32$lambda-31, reason: not valid java name */
    public static final rx.b m202handlePauseDownload$lambda32$lambda31(EarnAppcListPresenter earnAppcListPresenter, Void r1) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.earnAppcListManager.pauseWalletDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handlePauseDownload$lambda-33, reason: not valid java name */
    public static final void m203handlePauseDownload$lambda33(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handlePauseDownload$lambda-34, reason: not valid java name */
    public static final void m204handlePauseDownload$lambda34(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    private final void handleResumeDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m205handleResumeDownload$lambda25((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.j0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m206handleResumeDownload$lambda27(this.f6174f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.u
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m208handleResumeDownload$lambda28((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.l0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m209handleResumeDownload$lambda29(this.f6179f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleResumeDownload$lambda-25, reason: not valid java name */
    public static final Boolean m205handleResumeDownload$lambda25(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleResumeDownload$lambda-27, reason: not valid java name */
    public static final rx.e m206handleResumeDownload$lambda27(final EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.view.resumeDownload().H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.v0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m207handleResumeDownload$lambda27$lambda26(this.f6199f, (Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleResumeDownload$lambda-27$lambda-26, reason: not valid java name */
    public static final rx.b m207handleResumeDownload$lambda27$lambda26(EarnAppcListPresenter earnAppcListPresenter, Void r1) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.startWalletDownload(earnAppcListPresenter.earnAppcListManager.resumeWalletDownload());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleResumeDownload$lambda-28, reason: not valid java name */
    public static final void m208handleResumeDownload$lambda28(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleResumeDownload$lambda-29, reason: not valid java name */
    public static final void m209handleResumeDownload$lambda29(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    private final void handleWalletInstallClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m210handleWalletInstallClick$lambda13((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m211handleWalletInstallClick$lambda15(this.f6191f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.b1
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m213handleWalletInstallClick$lambda16((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.j
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m214handleWalletInstallClick$lambda17(this.f6173f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleWalletInstallClick$lambda-13, reason: not valid java name */
    public static final Boolean m210handleWalletInstallClick$lambda13(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleWalletInstallClick$lambda-15, reason: not valid java name */
    public static final rx.e m211handleWalletInstallClick$lambda15(final EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.view.onWalletInstallClick().H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m212handleWalletInstallClick$lambda15$lambda14(this.f6166f, (Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleWalletInstallClick$lambda-15$lambda-14, reason: not valid java name */
    public static final rx.b m212handleWalletInstallClick$lambda15$lambda14(EarnAppcListPresenter earnAppcListPresenter, Void r1) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.startWalletDownload(earnAppcListPresenter.earnAppcListManager.downloadApp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleWalletInstallClick$lambda-16, reason: not valid java name */
    public static final void m213handleWalletInstallClick$lambda16(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleWalletInstallClick$lambda-17, reason: not valid java name */
    public static final void m214handleWalletInstallClick$lambda17(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    private final void loadWalletApp() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m218loadWalletApp$lambda7((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m219loadWalletApp$lambda8(this.f6155f, (View.LifecycleEvent) obj);
            }
        }).E().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.z
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m220loadWalletApp$lambda9(this.f6206f, (WalletApp) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m215loadWalletApp$lambda10(this.f6180f, (WalletApp) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.o0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m216loadWalletApp$lambda11(obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.r
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m217loadWalletApp$lambda12(this.f6190f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletApp$lambda-10, reason: not valid java name */
    public static final rx.e m215loadWalletApp$lambda10(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return rx.e.g0(earnAppcListPresenter.observeWalletState(), earnAppcListPresenter.handleOnWalletInstalled(), earnAppcListPresenter.observeWalletDownloadError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletApp$lambda-11, reason: not valid java name */
    public static final void m216loadWalletApp$lambda11(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletApp$lambda-12, reason: not valid java name */
    public static final void m217loadWalletApp$lambda12(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletApp$lambda-7, reason: not valid java name */
    public static final Boolean m218loadWalletApp$lambda7(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletApp$lambda-8, reason: not valid java name */
    public static final rx.e m219loadWalletApp$lambda8(EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.earnAppcListManager.getWalletApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadWalletApp$lambda-9, reason: not valid java name */
    public static final void m220loadWalletApp$lambda9(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        EarnAppcListView earnAppcListView = earnAppcListPresenter.view;
        kotlin.jvm.internal.m.e(walletApp, "walletApp");
        earnAppcListView.setupWallet(walletApp);
    }

    private final rx.e<WalletApp> observeWalletDownloadError() {
        rx.e<WalletApp> eVarS0 = rx.e.a0(this.view.resumeDownload(), this.view.onWalletInstallClick()).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m221observeWalletDownloadError$lambda40(this.f6163f, (Void) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m224observeWalletDownloadError$lambda41(this.f6182f, (WalletApp) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.y
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).s0();
        kotlin.jvm.internal.m.e(eVarS0, "merge(view.resumeDownloa…kTrace() }\n      .retry()");
        return eVarS0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observeWalletDownloadError$lambda-40, reason: not valid java name */
    public static final rx.e m221observeWalletDownloadError$lambda40(final EarnAppcListPresenter earnAppcListPresenter, Void r2) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.earnAppcListManager.observeWalletApp().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m222observeWalletDownloadError$lambda40$lambda38((WalletApp) obj);
            }
        }).j0(earnAppcListPresenter.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.v
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m223observeWalletDownloadError$lambda40$lambda39(this.f6198f, (WalletApp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observeWalletDownloadError$lambda-40$lambda-38, reason: not valid java name */
    public static final Boolean m222observeWalletDownloadError$lambda40$lambda38(WalletApp walletApp) {
        DownloadModel downloadModel = walletApp.getDownloadModel();
        if (downloadModel != null) {
            return Boolean.valueOf(downloadModel.hasError());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observeWalletDownloadError$lambda-40$lambda-39, reason: not valid java name */
    public static final void m223observeWalletDownloadError$lambda40$lambda39(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        kotlin.jvm.internal.m.f(walletApp, "walletApp");
        DownloadModel downloadModel = walletApp.getDownloadModel();
        if ((downloadModel != null ? downloadModel.getDownloadState() : null) == DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR) {
            earnAppcListPresenter.earnAppcNavigator.openOutOfSpaceDialog(walletApp.getSize(), walletApp.getPackageName());
        } else {
            earnAppcListPresenter.view.showDownloadError(walletApp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observeWalletDownloadError$lambda-41, reason: not valid java name */
    public static final rx.e m224observeWalletDownloadError$lambda41(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        kotlin.jvm.internal.m.e(walletApp, "walletApp");
        return earnAppcListPresenter.verifyNotEnoughSpaceError(walletApp);
    }

    private final rx.e<WalletApp> observeWalletState() {
        rx.e<WalletApp> eVarW = this.earnAppcListManager.observeWalletApp().G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.t0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListPresenter.m226observeWalletState$lambda35(this.f6195f, (WalletApp) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.z0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m227observeWalletState$lambda36(this.f6207f, (WalletApp) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.x
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
        kotlin.jvm.internal.m.e(eVarW, "earnAppcListManager.obse… -> e.printStackTrace() }");
        return eVarW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observeWalletState$lambda-35, reason: not valid java name */
    public static final rx.e m226observeWalletState$lambda35(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        kotlin.jvm.internal.m.e(walletApp, "walletApp");
        return earnAppcListPresenter.verifyNotEnoughSpaceError(walletApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observeWalletState$lambda-36, reason: not valid java name */
    public static final void m227observeWalletState$lambda36(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        EarnAppcListView earnAppcListView = earnAppcListPresenter.view;
        kotlin.jvm.internal.m.e(walletApp, "walletApp");
        earnAppcListView.updateState(walletApp);
    }

    private final rx.b startWalletDownload(rx.b bVar) {
        rx.b bVarX0 = rx.e.p(new rx.m.d() { // from class: cm.aptoide.pt.home.more.appcoins.o
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return EarnAppcListPresenter.m229startWalletDownload$lambda19(this.f6184f);
            }
        }).j0(this.viewScheduler).G(new AnonymousClass2(bVar)).X0();
        kotlin.jvm.internal.m.e(bVarX0, "private fun startWalletD…    }.toCompletable()\n  }");
        return bVarX0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startWalletDownload$lambda-19, reason: not valid java name */
    public static final rx.e m229startWalletDownload$lambda19(final EarnAppcListPresenter earnAppcListPresenter) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        if (earnAppcListPresenter.earnAppcListManager.shouldShowRootInstallWarningPopup()) {
            earnAppcListPresenter.view.showRootInstallWarningPopup().x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.c1
                @Override // rx.m.b
                public final void call(Object obj) {
                    EarnAppcListPresenter.m230startWalletDownload$lambda19$lambda18(this.f6156f, (Boolean) obj);
                }
            });
        }
        return rx.e.S(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startWalletDownload$lambda-19$lambda-18, reason: not valid java name */
    public static final void m230startWalletDownload$lambda19$lambda18(EarnAppcListPresenter earnAppcListPresenter, Boolean bool) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        EarnAppcListManager earnAppcListManager = earnAppcListPresenter.earnAppcListManager;
        kotlin.jvm.internal.m.e(bool, "answer");
        earnAppcListManager.allowRootInstall(bool.booleanValue());
    }

    private final rx.e<WalletApp> verifyNotEnoughSpaceError(final WalletApp walletApp) {
        DownloadModel downloadModel = walletApp.getDownloadModel();
        if (downloadModel != null && downloadModel.getDownloadState() == DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR) {
            rx.e.S(walletApp).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.k0
                @Override // rx.m.b
                public final void call(Object obj) {
                    EarnAppcListPresenter.m231verifyNotEnoughSpaceError$lambda44$lambda43(this.f6176f, walletApp, (WalletApp) obj);
                }
            });
        }
        rx.e<WalletApp> eVarS = rx.e.S(walletApp);
        kotlin.jvm.internal.m.e(eVarS, "just(walletApp)");
        return eVarS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: verifyNotEnoughSpaceError$lambda-44$lambda-43, reason: not valid java name */
    public static final void m231verifyNotEnoughSpaceError$lambda44$lambda43(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp, WalletApp walletApp2) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        kotlin.jvm.internal.m.f(walletApp, "$walletApp");
        earnAppcListPresenter.earnAppcListAnalytics.sendNotEnoughSpaceErrorEvent(walletApp.getMd5sum());
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsPresenter
    public rx.e<List<RewardApp>> getApps(boolean z) {
        rx.e<List<RewardApp>> freshAppCoinsRewardAppsFromHomeMore = this.rewardAppsRepository.getFreshAppCoinsRewardAppsFromHomeMore("appcoins-ads");
        kotlin.jvm.internal.m.e(freshAppCoinsRewardAppsFromHomeMore, "rewardAppsRepository.get…mHomeMore(\"appcoins-ads\")");
        return freshAppCoinsRewardAppsFromHomeMore;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsPresenter
    public String getTitle() {
        String title = this.earnAppcListConfiguration.getTitle();
        return title == null ? HttpUrl.FRAGMENT_ENCODE_SET : title;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsPresenter
    public void handleAppClick(ListAppsClickEvent<RewardApp> appClickEvent) {
        kotlin.jvm.internal.m.f(appClickEvent, "appClickEvent");
        RewardApp rewardApp = (RewardApp) appClickEvent.getApplication();
        this.analyticsManager.logEvent(((RewardApp) appClickEvent.getApplication()).getClickUrl());
        AppNavigator appNavigator = this.appNavigator;
        long appId = rewardApp.getAppId();
        String packageName = rewardApp.getPackageName();
        String tag = this.earnAppcListConfiguration.getTag();
        String downloadUrl = rewardApp.getDownloadUrl();
        RewardApp.Reward reward = rewardApp.getReward();
        appNavigator.navigateWithDownloadUrlAndReward(appId, packageName, tag, downloadUrl, reward != null ? (float) reward.getAppc() : -1.0f);
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsPresenter
    public rx.e<List<RewardApp>> loadMoreApps() {
        rx.e<List<RewardApp>> nextAppCoinsRewardAppsFromHomeMore = this.rewardAppsRepository.getNextAppCoinsRewardAppsFromHomeMore("appcoins-ads");
        kotlin.jvm.internal.m.e(nextAppCoinsRewardAppsFromHomeMore, "rewardAppsRepository.get…mHomeMore(\"appcoins-ads\")");
        return nextAppCoinsRewardAppsFromHomeMore;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsPresenter, cm.aptoide.pt.presenter.Presenter
    public void present() {
        super.present();
        loadWalletApp();
        handleWalletInstallClick();
        handleResumeDownload();
        handlePauseDownload();
        handleCancelDownload();
        handleOutOfSpaceDialogResult();
    }
}
