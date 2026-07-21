package cm.aptoide.pt.download.view.outofspace;

import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: compiled from: OutOfSpaceDialogPresenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcm/aptoide/pt/download/view/outofspace/OutOfSpaceDialogPresenter;", "Lcm/aptoide/pt/presenter/Presenter;", "view", "Lcm/aptoide/pt/download/view/outofspace/OutOfSpaceDialogView;", "crashReporter", "Lcm/aptoide/pt/crashreports/CrashReport;", "viewScheduler", "Lrx/Scheduler;", "ioScheduler", "outOfSpaceManager", "Lcm/aptoide/pt/download/view/outofspace/OutOfSpaceManager;", "outOfSpaceNavigator", "Lcm/aptoide/pt/download/view/outofspace/OutOfSpaceNavigator;", "(Lcm/aptoide/pt/download/view/outofspace/OutOfSpaceDialogView;Lcm/aptoide/pt/crashreports/CrashReport;Lrx/Scheduler;Lrx/Scheduler;Lcm/aptoide/pt/download/view/outofspace/OutOfSpaceManager;Lcm/aptoide/pt/download/view/outofspace/OutOfSpaceNavigator;)V", "handleDismissDialogButtonClick", HttpUrl.FRAGMENT_ENCODE_SET, "handleUninstalledEnoughApps", "loadAppsToUninstall", "loadRequiredStorageSize", "present", "uninstallApp", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OutOfSpaceDialogPresenter implements Presenter {
    private final CrashReport crashReporter;
    private final rx.h ioScheduler;
    private final OutOfSpaceManager outOfSpaceManager;
    private final OutOfSpaceNavigator outOfSpaceNavigator;
    private final OutOfSpaceDialogView view;
    private final rx.h viewScheduler;

    public OutOfSpaceDialogPresenter(OutOfSpaceDialogView outOfSpaceDialogView, CrashReport crashReport, rx.h hVar, rx.h hVar2, OutOfSpaceManager outOfSpaceManager, OutOfSpaceNavigator outOfSpaceNavigator) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogView, "view");
        kotlin.jvm.internal.m.f(crashReport, "crashReporter");
        kotlin.jvm.internal.m.f(hVar, "viewScheduler");
        kotlin.jvm.internal.m.f(hVar2, "ioScheduler");
        kotlin.jvm.internal.m.f(outOfSpaceManager, "outOfSpaceManager");
        kotlin.jvm.internal.m.f(outOfSpaceNavigator, "outOfSpaceNavigator");
        this.view = outOfSpaceDialogView;
        this.crashReporter = crashReport;
        this.viewScheduler = hVar;
        this.ioScheduler = hVar2;
        this.outOfSpaceManager = outOfSpaceManager;
        this.outOfSpaceNavigator = outOfSpaceNavigator;
    }

    private final void handleDismissDialogButtonClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceDialogPresenter.m112handleDismissDialogButtonClick$lambda10((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceDialogPresenter.m113handleDismissDialogButtonClick$lambda11(this.f5149f, (View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.d
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m114handleDismissDialogButtonClick$lambda12(this.f5135f, (Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.z
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m115handleDismissDialogButtonClick$lambda13((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.m
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m116handleDismissDialogButtonClick$lambda14(this.f5151f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleDismissDialogButtonClick$lambda-10, reason: not valid java name */
    public static final Boolean m112handleDismissDialogButtonClick$lambda10(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleDismissDialogButtonClick$lambda-11, reason: not valid java name */
    public static final rx.e m113handleDismissDialogButtonClick$lambda11(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        return outOfSpaceDialogPresenter.view.dismissDialogClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleDismissDialogButtonClick$lambda-12, reason: not valid java name */
    public static final void m114handleDismissDialogButtonClick$lambda12(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, Void r1) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        outOfSpaceDialogPresenter.view.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleDismissDialogButtonClick$lambda-13, reason: not valid java name */
    public static final void m115handleDismissDialogButtonClick$lambda13(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleDismissDialogButtonClick$lambda-14, reason: not valid java name */
    public static final void m116handleDismissDialogButtonClick$lambda14(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        outOfSpaceDialogPresenter.crashReporter.log(th);
    }

    private final void handleUninstalledEnoughApps() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceDialogPresenter.m117handleUninstalledEnoughApps$lambda5((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceDialogPresenter.m118handleUninstalledEnoughApps$lambda6(this.f5140f, (View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.t
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m119handleUninstalledEnoughApps$lambda7(this.f5158f, (Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.a0
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m120handleUninstalledEnoughApps$lambda8((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.n
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m121handleUninstalledEnoughApps$lambda9(this.f5152f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUninstalledEnoughApps$lambda-5, reason: not valid java name */
    public static final Boolean m117handleUninstalledEnoughApps$lambda5(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUninstalledEnoughApps$lambda-6, reason: not valid java name */
    public static final rx.e m118handleUninstalledEnoughApps$lambda6(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        return outOfSpaceDialogPresenter.outOfSpaceManager.uninstalledEnoughApps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUninstalledEnoughApps$lambda-7, reason: not valid java name */
    public static final void m119handleUninstalledEnoughApps$lambda7(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, Void r1) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        outOfSpaceDialogPresenter.outOfSpaceNavigator.clearedEnoughSpace();
        outOfSpaceDialogPresenter.view.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUninstalledEnoughApps$lambda-8, reason: not valid java name */
    public static final void m120handleUninstalledEnoughApps$lambda8(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUninstalledEnoughApps$lambda-9, reason: not valid java name */
    public static final void m121handleUninstalledEnoughApps$lambda9(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        outOfSpaceDialogPresenter.crashReporter.log(th);
    }

    private final void loadAppsToUninstall() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceDialogPresenter.m122loadAppsToUninstall$lambda21((View.LifecycleEvent) obj);
            }
        }).j0(this.ioScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceDialogPresenter.m123loadAppsToUninstall$lambda22(this.f5154f, (View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.e
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m124loadAppsToUninstall$lambda23(this.f5137f, (List) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.u
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m125loadAppsToUninstall$lambda24((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.s
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m126loadAppsToUninstall$lambda25(this.f5157f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAppsToUninstall$lambda-21, reason: not valid java name */
    public static final Boolean m122loadAppsToUninstall$lambda21(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAppsToUninstall$lambda-22, reason: not valid java name */
    public static final rx.e m123loadAppsToUninstall$lambda22(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        return outOfSpaceDialogPresenter.outOfSpaceManager.getInstalledApps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAppsToUninstall$lambda-23, reason: not valid java name */
    public static final void m124loadAppsToUninstall$lambda23(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, List list) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        kotlin.jvm.internal.m.e(list, "appsList");
        if (!list.isEmpty()) {
            outOfSpaceDialogPresenter.view.showInstalledApps(list);
        } else {
            outOfSpaceDialogPresenter.view.showGeneralOutOfSpaceError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAppsToUninstall$lambda-24, reason: not valid java name */
    public static final void m125loadAppsToUninstall$lambda24(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAppsToUninstall$lambda-25, reason: not valid java name */
    public static final void m126loadAppsToUninstall$lambda25(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        outOfSpaceDialogPresenter.crashReporter.log(th);
    }

    private final void loadRequiredStorageSize() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceDialogPresenter.m127loadRequiredStorageSize$lambda0((View.LifecycleEvent) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceDialogPresenter.m128loadRequiredStorageSize$lambda1(this.f5148f, (View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.y
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m129loadRequiredStorageSize$lambda2(this.f5163f, (Long) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.v
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m130loadRequiredStorageSize$lambda3((Long) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.r
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m131loadRequiredStorageSize$lambda4(this.f5156f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadRequiredStorageSize$lambda-0, reason: not valid java name */
    public static final Boolean m127loadRequiredStorageSize$lambda0(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadRequiredStorageSize$lambda-1, reason: not valid java name */
    public static final Single m128loadRequiredStorageSize$lambda1(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        return outOfSpaceDialogPresenter.outOfSpaceManager.getRequiredStorageSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadRequiredStorageSize$lambda-2, reason: not valid java name */
    public static final void m129loadRequiredStorageSize$lambda2(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, Long l) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        OutOfSpaceDialogView outOfSpaceDialogView = outOfSpaceDialogPresenter.view;
        kotlin.jvm.internal.m.e(l, "it");
        outOfSpaceDialogView.requiredSpaceToInstall(l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadRequiredStorageSize$lambda-3, reason: not valid java name */
    public static final void m130loadRequiredStorageSize$lambda3(Long l) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadRequiredStorageSize$lambda-4, reason: not valid java name */
    public static final void m131loadRequiredStorageSize$lambda4(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        outOfSpaceDialogPresenter.crashReporter.log(th);
    }

    private final void uninstallApp() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceDialogPresenter.m132uninstallApp$lambda15((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceDialogPresenter.m133uninstallApp$lambda16(this.f5133f, (View.LifecycleEvent) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceDialogPresenter.m134uninstallApp$lambda17(this.f5147f, (String) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.o
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m135uninstallApp$lambda18(this.f5153f, (Long) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.q
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m136uninstallApp$lambda19((Long) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.w
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceDialogPresenter.m137uninstallApp$lambda20(this.f5161f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: uninstallApp$lambda-15, reason: not valid java name */
    public static final Boolean m132uninstallApp$lambda15(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: uninstallApp$lambda-16, reason: not valid java name */
    public static final rx.e m133uninstallApp$lambda16(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        return outOfSpaceDialogPresenter.view.uninstallClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: uninstallApp$lambda-17, reason: not valid java name */
    public static final Single m134uninstallApp$lambda17(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, String str) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        return outOfSpaceDialogPresenter.outOfSpaceManager.uninstallApp(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: uninstallApp$lambda-18, reason: not valid java name */
    public static final void m135uninstallApp$lambda18(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, Long l) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        OutOfSpaceDialogView outOfSpaceDialogView = outOfSpaceDialogPresenter.view;
        kotlin.jvm.internal.m.e(l, "removedAppSize");
        outOfSpaceDialogView.requiredSpaceToInstall(l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: uninstallApp$lambda-19, reason: not valid java name */
    public static final void m136uninstallApp$lambda19(Long l) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: uninstallApp$lambda-20, reason: not valid java name */
    public static final void m137uninstallApp$lambda20(OutOfSpaceDialogPresenter outOfSpaceDialogPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(outOfSpaceDialogPresenter, "this$0");
        outOfSpaceDialogPresenter.crashReporter.log(th);
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        loadAppsToUninstall();
        loadRequiredStorageSize();
        uninstallApp();
        handleDismissDialogButtonClick();
        handleUninstalledEnoughApps();
    }
}
