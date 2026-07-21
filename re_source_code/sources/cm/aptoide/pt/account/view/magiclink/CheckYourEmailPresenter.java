package cm.aptoide.pt.account.view.magiclink;

import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CheckYourEmailPresenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailPresenter;", "Lcm/aptoide/pt/presenter/Presenter;", "view", "Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailView;", "navigator", "Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailNavigator;", "(Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailView;Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailNavigator;)V", "handleCheckEmailAppClick", HttpUrl.FRAGMENT_ENCODE_SET, "present", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckYourEmailPresenter implements Presenter {
    private final CheckYourEmailNavigator navigator;
    private final CheckYourEmailView view;

    public CheckYourEmailPresenter(CheckYourEmailView checkYourEmailView, CheckYourEmailNavigator checkYourEmailNavigator) {
        kotlin.jvm.internal.m.f(checkYourEmailView, "view");
        kotlin.jvm.internal.m.f(checkYourEmailNavigator, "navigator");
        this.view = checkYourEmailView;
        this.navigator = checkYourEmailNavigator;
    }

    private final void handleCheckEmailAppClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.magiclink.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return CheckYourEmailPresenter.m23handleCheckEmailAppClick$lambda0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.magiclink.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return CheckYourEmailPresenter.m24handleCheckEmailAppClick$lambda2(this.f3866f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.b
            @Override // rx.m.b
            public final void call(Object obj) {
                CheckYourEmailPresenter.m26handleCheckEmailAppClick$lambda3((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.a
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCheckEmailAppClick$lambda-0, reason: not valid java name */
    public static final Boolean m23handleCheckEmailAppClick$lambda0(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(View.LifecycleEvent.CREATE == lifecycleEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCheckEmailAppClick$lambda-2, reason: not valid java name */
    public static final rx.e m24handleCheckEmailAppClick$lambda2(final CheckYourEmailPresenter checkYourEmailPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(checkYourEmailPresenter, "this$0");
        return checkYourEmailPresenter.view.getCheckYourEmailClick().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.c
            @Override // rx.m.b
            public final void call(Object obj) {
                CheckYourEmailPresenter.m25handleCheckEmailAppClick$lambda2$lambda1(this.f3865f, (Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCheckEmailAppClick$lambda-2$lambda-1, reason: not valid java name */
    public static final void m25handleCheckEmailAppClick$lambda2$lambda1(CheckYourEmailPresenter checkYourEmailPresenter, Void r1) {
        kotlin.jvm.internal.m.f(checkYourEmailPresenter, "this$0");
        checkYourEmailPresenter.navigator.navigateToEmailApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleCheckEmailAppClick$lambda-3, reason: not valid java name */
    public static final void m26handleCheckEmailAppClick$lambda3(Void r0) {
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        handleCheckEmailAppClick();
    }
}
