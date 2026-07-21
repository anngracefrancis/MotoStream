package cm.aptoide.pt.view.app;

import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class ListStoreAppsPresenter implements Presenter {
    private final AppCenter appCenter;
    private final CrashReport crashReport;
    private final int limit;
    private final ListStoreAppsNavigator navigator;
    private final long storeId;
    private final ListStoreAppsView view;
    private final rx.h viewScheduler;

    /* JADX INFO: renamed from: cm.aptoide.pt.view.app.ListStoreAppsPresenter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$view$app$AppsList$Error;

        static {
            int[] iArr = new int[AppsList.Error.values().length];
            $SwitchMap$cm$aptoide$pt$view$app$AppsList$Error = iArr;
            try {
                iArr[AppsList.Error.NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$view$app$AppsList$Error[AppsList.Error.GENERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ListStoreAppsPresenter(ListStoreAppsView listStoreAppsView, long j2, rx.h hVar, AppCenter appCenter, CrashReport crashReport, ListStoreAppsNavigator listStoreAppsNavigator, int i2) {
        this.view = listStoreAppsView;
        this.storeId = j2;
        this.viewScheduler = hVar;
        this.appCenter = appCenter;
        this.crashReport = crashReport;
        this.navigator = listStoreAppsNavigator;
        this.limit = i2;
    }

    private Single<AppsList> getApps() {
        return this.appCenter.getApps(this.storeId, this.limit).p(this.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.view.app.x1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7997f.a((AppsList) obj);
            }
        });
    }

    private void handleError(AppsList.Error error) {
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$view$app$AppsList$Error[error.ordinal()];
        if (i2 == 1) {
            this.view.showNetworkError();
        } else {
            if (i2 != 2) {
                return;
            }
            this.view.showGenericError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getApps$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(AppsList appsList) {
        if (appsList.hasErrors()) {
            handleError(appsList.getError());
        } else {
            if (appsList.isLoading()) {
                return;
            }
            this.view.setApps(appsList.getList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadFreshApps$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(AppsList appsList) {
        this.view.hideRefreshLoading();
        if (appsList.hasErrors()) {
            handleError(appsList.getError());
        } else {
            if (appsList.isLoading()) {
                return;
            }
            this.view.setApps(appsList.getList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadShowNextApps$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(AppsList appsList) {
        this.view.hideLoading();
        if (appsList.hasErrors()) {
            handleError(appsList.getError());
        } else {
            if (appsList.isLoading()) {
                return;
            }
            this.view.addApps(appsList.getList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleAppClicks$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Application application) {
        this.navigator.navigateToAppView(application.getAppId(), application.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleAppClicks$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(View.LifecycleEvent lifecycleEvent) {
        return this.view.getAppClick().x(new rx.m.b() { // from class: cm.aptoide.pt.view.app.q1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7976f.d((Application) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onCreateHandleAppClicks$27(Application application) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleAppClicks$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleBottomReached$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Object obj) {
        this.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleBottomReached$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single h(Object obj) {
        return loadShowNextApps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleBottomReached$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e i(View.LifecycleEvent lifecycleEvent) {
        return this.view.reachesBottom().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.view.app.e2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7937f.g(obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.view.app.u1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7988f.h(obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$onCreateHandleBottomReached$22(AppsList appsList) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleBottomReached$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Throwable th) {
        this.crashReport.log(th);
    }

    static /* synthetic */ void lambda$onCreateHandleRefresh$10(AppsList appsList) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleRefresh$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleRefresh$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single l(Void r1) {
        return loadFreshApps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleRefresh$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e m(View.LifecycleEvent lifecycleEvent) {
        return this.view.getRefreshEvent().j0(this.viewScheduler).L(new rx.m.e() { // from class: cm.aptoide.pt.view.app.v1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7991f.l((Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleRetry$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(Void r1) {
        this.view.showStartingLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleRetry$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single o(Void r1) {
        return loadShowNextApps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleRetry$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e p(View.LifecycleEvent lifecycleEvent) {
        return this.view.getRetryEvent().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.view.app.s1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7982f.n((Void) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.view.app.o1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7970f.o((Void) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$onCreateHandleRetry$4(AppsList appsList) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateHandleRetry$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateLoadApps$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single r(View.LifecycleEvent lifecycleEvent) {
        return getApps();
    }

    static /* synthetic */ void lambda$onCreateLoadApps$15(AppsList appsList) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateLoadApps$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(Throwable th) {
        this.crashReport.log(th);
    }

    private Single<AppsList> loadFreshApps() {
        return this.appCenter.loadFreshApps(this.storeId, this.limit).p(this.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.view.app.c2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7928f.b((AppsList) obj);
            }
        });
    }

    private Single<AppsList> loadShowNextApps() {
        return this.appCenter.loadNextApps(this.storeId, this.limit).p(this.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.view.app.m1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7963f.c((AppsList) obj);
            }
        });
    }

    private void onCreateHandleAppClicks() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.app.r1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.d2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7933f.e((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.app.n1
            @Override // rx.m.b
            public final void call(Object obj) {
                ListStoreAppsPresenter.lambda$onCreateHandleAppClicks$27((Application) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.app.a2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7920f.f((Throwable) obj);
            }
        });
    }

    private void onCreateHandleBottomReached() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.app.g1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.i1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7951f.i((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.app.f1
            @Override // rx.m.b
            public final void call(Object obj) {
                ListStoreAppsPresenter.lambda$onCreateHandleBottomReached$22((AppsList) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.app.t1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7985f.j((Throwable) obj);
            }
        });
    }

    private void onCreateHandleRefresh() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.app.w1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.l1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7960f.m((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.app.z1
            @Override // rx.m.b
            public final void call(Object obj) {
                ListStoreAppsPresenter.lambda$onCreateHandleRefresh$10((AppsList) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.app.j1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7954f.k((Throwable) obj);
            }
        });
    }

    private void onCreateHandleRetry() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.app.c1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.d1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7932f.p((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.app.h1
            @Override // rx.m.b
            public final void call(Object obj) {
                ListStoreAppsPresenter.lambda$onCreateHandleRetry$4((AppsList) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.app.p1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7973f.q((Throwable) obj);
            }
        });
    }

    private void onCreateLoadApps() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.app.y1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.view.app.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7957f.r((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.app.e1
            @Override // rx.m.b
            public final void call(Object obj) {
                ListStoreAppsPresenter.lambda$onCreateLoadApps$15((AppsList) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.app.b2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7924f.s((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        onCreateLoadApps();
        onCreateHandleAppClicks();
        onCreateHandleBottomReached();
        onCreateHandleRefresh();
        onCreateHandleRetry();
    }
}
