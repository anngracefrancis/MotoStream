package cm.aptoide.pt.autoupdate;

import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: AutoUpdateDialogPresenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcm/aptoide/pt/autoupdate/AutoUpdateDialogPresenter;", "Lcm/aptoide/pt/presenter/Presenter;", "view", "Lcm/aptoide/pt/autoupdate/AutoUpdateDialogView;", "crashReporter", "Lcm/aptoide/pt/crashreports/CrashReport;", "autoUpdateManager", "Lcm/aptoide/pt/autoupdate/AutoUpdateManager;", "(Lcm/aptoide/pt/autoupdate/AutoUpdateDialogView;Lcm/aptoide/pt/crashreports/CrashReport;Lcm/aptoide/pt/autoupdate/AutoUpdateManager;)V", "handleNotNowClick", HttpUrl.FRAGMENT_ENCODE_SET, "handleUpdateClick", "present", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoUpdateDialogPresenter implements Presenter {
    private final AutoUpdateManager autoUpdateManager;
    private final CrashReport crashReporter;
    private final AutoUpdateDialogView view;

    public AutoUpdateDialogPresenter(AutoUpdateDialogView autoUpdateDialogView, CrashReport crashReport, AutoUpdateManager autoUpdateManager) {
        kotlin.jvm.internal.m.f(autoUpdateDialogView, "view");
        kotlin.jvm.internal.m.f(crashReport, "crashReporter");
        kotlin.jvm.internal.m.f(autoUpdateManager, "autoUpdateManager");
        this.view = autoUpdateDialogView;
        this.crashReporter = crashReport;
        this.autoUpdateManager = autoUpdateManager;
    }

    private final void handleNotNowClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateDialogPresenter.m51handleNotNowClick$lambda6((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateDialogPresenter.m52handleNotNowClick$lambda7(this.f4739f, (View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.autoupdate.c
            @Override // rx.m.b
            public final void call(Object obj) {
                AutoUpdateDialogPresenter.m53handleNotNowClick$lambda8(this.f4738f, (Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.autoupdate.f
            @Override // rx.m.b
            public final void call(Object obj) {
                AutoUpdateDialogPresenter.m54handleNotNowClick$lambda9((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.autoupdate.e
            @Override // rx.m.b
            public final void call(Object obj) {
                AutoUpdateDialogPresenter.m50handleNotNowClick$lambda10(this.f4740f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleNotNowClick$lambda-10, reason: not valid java name */
    public static final void m50handleNotNowClick$lambda10(AutoUpdateDialogPresenter autoUpdateDialogPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(autoUpdateDialogPresenter, "this$0");
        autoUpdateDialogPresenter.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleNotNowClick$lambda-6, reason: not valid java name */
    public static final Boolean m51handleNotNowClick$lambda6(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleNotNowClick$lambda-7, reason: not valid java name */
    public static final rx.e m52handleNotNowClick$lambda7(AutoUpdateDialogPresenter autoUpdateDialogPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(autoUpdateDialogPresenter, "this$0");
        return autoUpdateDialogPresenter.view.notNowClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleNotNowClick$lambda-8, reason: not valid java name */
    public static final void m53handleNotNowClick$lambda8(AutoUpdateDialogPresenter autoUpdateDialogPresenter, Void r1) {
        kotlin.jvm.internal.m.f(autoUpdateDialogPresenter, "this$0");
        autoUpdateDialogPresenter.view.dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleNotNowClick$lambda-9, reason: not valid java name */
    public static final void m54handleNotNowClick$lambda9(Void r0) {
    }

    private final void handleUpdateClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateDialogPresenter.m55handleUpdateClick$lambda0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateDialogPresenter.m56handleUpdateClick$lambda1(this.f4743f, (View.LifecycleEvent) obj);
            }
        }).j0(Schedulers.io()).G(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateDialogPresenter.m57handleUpdateClick$lambda2(this.f4745f, (Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.autoupdate.g
            @Override // rx.m.b
            public final void call(Object obj) {
                AutoUpdateDialogPresenter.m58handleUpdateClick$lambda3(this.f4742f, (Install) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.autoupdate.a
            @Override // rx.m.b
            public final void call(Object obj) {
                AutoUpdateDialogPresenter.m59handleUpdateClick$lambda4((Install) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.autoupdate.b
            @Override // rx.m.b
            public final void call(Object obj) {
                AutoUpdateDialogPresenter.m60handleUpdateClick$lambda5(this.f4737f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUpdateClick$lambda-0, reason: not valid java name */
    public static final Boolean m55handleUpdateClick$lambda0(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUpdateClick$lambda-1, reason: not valid java name */
    public static final rx.e m56handleUpdateClick$lambda1(AutoUpdateDialogPresenter autoUpdateDialogPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(autoUpdateDialogPresenter, "this$0");
        return autoUpdateDialogPresenter.view.updateClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUpdateClick$lambda-2, reason: not valid java name */
    public static final rx.e m57handleUpdateClick$lambda2(AutoUpdateDialogPresenter autoUpdateDialogPresenter, Void r1) {
        kotlin.jvm.internal.m.f(autoUpdateDialogPresenter, "this$0");
        return autoUpdateDialogPresenter.autoUpdateManager.startUpdate(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUpdateClick$lambda-3, reason: not valid java name */
    public static final void m58handleUpdateClick$lambda3(AutoUpdateDialogPresenter autoUpdateDialogPresenter, Install install) {
        kotlin.jvm.internal.m.f(autoUpdateDialogPresenter, "this$0");
        autoUpdateDialogPresenter.view.dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUpdateClick$lambda-4, reason: not valid java name */
    public static final void m59handleUpdateClick$lambda4(Install install) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUpdateClick$lambda-5, reason: not valid java name */
    public static final void m60handleUpdateClick$lambda5(AutoUpdateDialogPresenter autoUpdateDialogPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(autoUpdateDialogPresenter, "this$0");
        autoUpdateDialogPresenter.crashReporter.log(th);
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        handleUpdateClick();
        handleNotNowClick();
    }
}
