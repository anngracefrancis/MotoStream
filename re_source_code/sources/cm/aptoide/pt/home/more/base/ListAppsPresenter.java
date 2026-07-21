package cm.aptoide.pt.home.more.base;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.util.ErrorUtils;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.view.app.Application;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ListAppsPresenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H&J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\fH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcm/aptoide/pt/home/more/base/ListAppsPresenter;", "T", "Lcm/aptoide/pt/view/app/Application;", "Lcm/aptoide/pt/presenter/Presenter;", "view", "Lcm/aptoide/pt/home/more/base/ListAppsView;", "viewScheduler", "Lrx/Scheduler;", "crashReporter", "Lcm/aptoide/pt/crashreports/CrashReport;", "(Lcm/aptoide/pt/home/more/base/ListAppsView;Lrx/Scheduler;Lcm/aptoide/pt/crashreports/CrashReport;)V", "getApps", "Lrx/Observable;", HttpUrl.FRAGMENT_ENCODE_SET, "refresh", HttpUrl.FRAGMENT_ENCODE_SET, "getTitle", HttpUrl.FRAGMENT_ENCODE_SET, "handleAppClick", HttpUrl.FRAGMENT_ENCODE_SET, "appClickEvent", "Lcm/aptoide/pt/home/more/base/ListAppsClickEvent;", "handleBottomReached", "handleRefreshSwipe", "handleRetryClick", "loadAppList", "loadApps", "loadMoreApps", "present", "setupToolbar", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ListAppsPresenter<T extends Application> implements Presenter {
    private final CrashReport crashReporter;
    private final ListAppsView<T> view;
    private final rx.h viewScheduler;

    public ListAppsPresenter(ListAppsView<T> listAppsView, rx.h hVar, CrashReport crashReport) {
        kotlin.jvm.internal.m.f(listAppsView, "view");
        kotlin.jvm.internal.m.f(hVar, "viewScheduler");
        kotlin.jvm.internal.m.f(crashReport, "crashReporter");
        this.view = listAppsView;
        this.viewScheduler = hVar;
        this.crashReporter = crashReport;
    }

    private final void handleAppClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m243handleAppClick$lambda22((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m244handleAppClick$lambda24(this.f6246f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.l
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m246handleAppClick$lambda25((ListAppsClickEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.g
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m247handleAppClick$lambda26(this.f6224f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleAppClick$lambda-22, reason: not valid java name */
    public static final Boolean m243handleAppClick$lambda22(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleAppClick$lambda-24, reason: not valid java name */
    public static final rx.e m244handleAppClick$lambda24(final ListAppsPresenter listAppsPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        return listAppsPresenter.view.getItemClickEvents().x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.r
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m245handleAppClick$lambda24$lambda23(this.f6240f, (ListAppsClickEvent) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleAppClick$lambda-24$lambda-23, reason: not valid java name */
    public static final void m245handleAppClick$lambda24$lambda23(ListAppsPresenter listAppsPresenter, ListAppsClickEvent listAppsClickEvent) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        kotlin.jvm.internal.m.e(listAppsClickEvent, "e");
        listAppsPresenter.handleAppClick(listAppsClickEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleAppClick$lambda-25, reason: not valid java name */
    public static final void m246handleAppClick$lambda25(ListAppsClickEvent listAppsClickEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleAppClick$lambda-26, reason: not valid java name */
    public static final void m247handleAppClick$lambda26(ListAppsPresenter listAppsPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        listAppsPresenter.crashReporter.log(th);
    }

    private final void handleBottomReached() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m248handleBottomReached$lambda27((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m249handleBottomReached$lambda30(this.f6248f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.i0
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m252handleBottomReached$lambda31((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.p
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m253handleBottomReached$lambda32(this.f6238f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleBottomReached$lambda-27, reason: not valid java name */
    public static final Boolean m248handleBottomReached$lambda27(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleBottomReached$lambda-30, reason: not valid java name */
    public static final rx.e m249handleBottomReached$lambda30(final ListAppsPresenter listAppsPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        return listAppsPresenter.view.onBottomReached().G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m250handleBottomReached$lambda30$lambda28(this.f6219f, (Void) obj);
            }
        }).j0(listAppsPresenter.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.b0
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m251handleBottomReached$lambda30$lambda29(this.f6215f, (List) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleBottomReached$lambda-30$lambda-28, reason: not valid java name */
    public static final rx.e m250handleBottomReached$lambda30$lambda28(ListAppsPresenter listAppsPresenter, Void r1) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        return listAppsPresenter.loadMoreApps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleBottomReached$lambda-30$lambda-29, reason: not valid java name */
    public static final void m251handleBottomReached$lambda30$lambda29(ListAppsPresenter listAppsPresenter, List list) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        if (list == null || !(!list.isEmpty())) {
            return;
        }
        listAppsPresenter.view.addApps(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleBottomReached$lambda-31, reason: not valid java name */
    public static final void m252handleBottomReached$lambda31(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleBottomReached$lambda-32, reason: not valid java name */
    public static final void m253handleBottomReached$lambda32(ListAppsPresenter listAppsPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        listAppsPresenter.crashReporter.log(th);
    }

    private final void handleRefreshSwipe() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m255handleRefreshSwipe$lambda6((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m256handleRefreshSwipe$lambda8(this.f6221f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.a0
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m258handleRefreshSwipe$lambda9((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.h0
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m254handleRefreshSwipe$lambda10(this.f6227f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRefreshSwipe$lambda-10, reason: not valid java name */
    public static final void m254handleRefreshSwipe$lambda10(ListAppsPresenter listAppsPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        listAppsPresenter.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRefreshSwipe$lambda-6, reason: not valid java name */
    public static final Boolean m255handleRefreshSwipe$lambda6(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRefreshSwipe$lambda-8, reason: not valid java name */
    public static final rx.e m256handleRefreshSwipe$lambda8(final ListAppsPresenter listAppsPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        return listAppsPresenter.view.refreshEvents().G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m257handleRefreshSwipe$lambda8$lambda7(this.f6232f, (Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRefreshSwipe$lambda-8$lambda-7, reason: not valid java name */
    public static final rx.e m257handleRefreshSwipe$lambda8$lambda7(ListAppsPresenter listAppsPresenter, Void r1) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        return listAppsPresenter.loadApps(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRefreshSwipe$lambda-9, reason: not valid java name */
    public static final void m258handleRefreshSwipe$lambda9(List list) {
    }

    private final void handleRetryClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m259handleRetryClick$lambda0((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m260handleRetryClick$lambda3(this.f6230f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.n
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m263handleRetryClick$lambda4((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.c0
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m264handleRetryClick$lambda5(this.f6217f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRetryClick$lambda-0, reason: not valid java name */
    public static final Boolean m259handleRetryClick$lambda0(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRetryClick$lambda-3, reason: not valid java name */
    public static final rx.e m260handleRetryClick$lambda3(final ListAppsPresenter listAppsPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        return listAppsPresenter.view.errorRetryClick().x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.h
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m261handleRetryClick$lambda3$lambda1(this.f6226f, (Void) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m262handleRetryClick$lambda3$lambda2(this.f6220f, (Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRetryClick$lambda-3$lambda-1, reason: not valid java name */
    public static final void m261handleRetryClick$lambda3$lambda1(ListAppsPresenter listAppsPresenter, Void r1) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        listAppsPresenter.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRetryClick$lambda-3$lambda-2, reason: not valid java name */
    public static final rx.e m262handleRetryClick$lambda3$lambda2(ListAppsPresenter listAppsPresenter, Void r1) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        return listAppsPresenter.loadApps(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRetryClick$lambda-4, reason: not valid java name */
    public static final void m263handleRetryClick$lambda4(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRetryClick$lambda-5, reason: not valid java name */
    public static final void m264handleRetryClick$lambda5(ListAppsPresenter listAppsPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        listAppsPresenter.crashReporter.log(th);
    }

    private final void loadAppList() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.w
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m265loadAppList$lambda15((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.o
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m266loadAppList$lambda16(this.f6237f, (View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m267loadAppList$lambda17(this.f6243f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.k0
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m268loadAppList$lambda18((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.i
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m269loadAppList$lambda19(this.f6228f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAppList$lambda-15, reason: not valid java name */
    public static final Boolean m265loadAppList$lambda15(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAppList$lambda-16, reason: not valid java name */
    public static final void m266loadAppList$lambda16(ListAppsPresenter listAppsPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        listAppsPresenter.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAppList$lambda-17, reason: not valid java name */
    public static final rx.e m267loadAppList$lambda17(ListAppsPresenter listAppsPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        return listAppsPresenter.loadApps(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAppList$lambda-18, reason: not valid java name */
    public static final void m268loadAppList$lambda18(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAppList$lambda-19, reason: not valid java name */
    public static final void m269loadAppList$lambda19(ListAppsPresenter listAppsPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        listAppsPresenter.crashReporter.log(th);
    }

    private final rx.e<List<T>> loadApps(boolean z) {
        rx.e<List<T>> eVarW = getApps(z).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.v
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m270loadApps$lambda20(this.f6244f, (List) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.y
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m271loadApps$lambda21(this.f6247f, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarW, "getApps(refresh)\n       …r()\n          }\n        }");
        return eVarW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadApps$lambda-20, reason: not valid java name */
    public static final void m270loadApps$lambda20(ListAppsPresenter listAppsPresenter, List list) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        ListAppsView<T> listAppsView = listAppsPresenter.view;
        kotlin.jvm.internal.m.e(list, DeepLinkIntentReceiver.DeepLinksTargets.APPS);
        listAppsView.showApps(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadApps$lambda-21, reason: not valid java name */
    public static final void m271loadApps$lambda21(ListAppsPresenter listAppsPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        if (ErrorUtils.isNoNetworkConnection(th)) {
            listAppsPresenter.view.showNoNetworkError();
        } else {
            listAppsPresenter.view.showGenericError();
        }
    }

    private final void setupToolbar() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsPresenter.m272setupToolbar$lambda11((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.s
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m273setupToolbar$lambda12(this.f6241f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.j0
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m274setupToolbar$lambda13((View.LifecycleEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.base.g0
            @Override // rx.m.b
            public final void call(Object obj) {
                ListAppsPresenter.m275setupToolbar$lambda14(this.f6225f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupToolbar$lambda-11, reason: not valid java name */
    public static final Boolean m272setupToolbar$lambda11(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupToolbar$lambda-12, reason: not valid java name */
    public static final void m273setupToolbar$lambda12(ListAppsPresenter listAppsPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        listAppsPresenter.view.setToolbarInfo(listAppsPresenter.getTitle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupToolbar$lambda-13, reason: not valid java name */
    public static final void m274setupToolbar$lambda13(View.LifecycleEvent lifecycleEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupToolbar$lambda-14, reason: not valid java name */
    public static final void m275setupToolbar$lambda14(ListAppsPresenter listAppsPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(listAppsPresenter, "this$0");
        listAppsPresenter.crashReporter.log(th);
    }

    public abstract rx.e<List<T>> getApps(boolean z);

    public abstract String getTitle();

    public abstract void handleAppClick(ListAppsClickEvent<T> appClickEvent);

    public rx.e<List<T>> loadMoreApps() {
        rx.e<List<T>> eVarS = rx.e.S(null);
        kotlin.jvm.internal.m.e(eVarS, "just(null)");
        return eVarS;
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        loadAppList();
        setupToolbar();
        handleAppClick();
        handleRetryClick();
        handleRefreshSwipe();
        handleBottomReached();
    }
}
