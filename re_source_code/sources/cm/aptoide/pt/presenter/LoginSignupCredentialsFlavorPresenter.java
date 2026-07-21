package cm.aptoide.pt.presenter;

import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.account.view.LoginSignUpCredentialsConfiguration;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.view.ThrowableToStringMapper;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class LoginSignupCredentialsFlavorPresenter extends LoginSignUpCredentialsPresenter {
    private final AccountNavigator accountNavigator;
    private final CrashReport crashReport;
    private final ThrowableToStringMapper errorMapper;
    private final LoginSignUpCredentialsView view;

    public LoginSignupCredentialsFlavorPresenter(LoginSignUpCredentialsView loginSignUpCredentialsView, AptoideAccountManager aptoideAccountManager, CrashReport crashReport, LoginSignUpCredentialsConfiguration loginSignUpCredentialsConfiguration, AccountNavigator accountNavigator, Collection<String> collection, ThrowableToStringMapper throwableToStringMapper, AccountAnalytics accountAnalytics) {
        super(loginSignUpCredentialsView, aptoideAccountManager, crashReport, loginSignUpCredentialsConfiguration, accountNavigator, collection, throwableToStringMapper, accountAnalytics);
        this.view = loginSignUpCredentialsView;
        this.errorMapper = throwableToStringMapper;
        this.crashReport = crashReport;
        this.accountNavigator = accountNavigator;
    }

    private void handleClickOnPrivacyPolicy() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6900f.o((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.o0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6938f.p((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.b0
            @Override // rx.m.b
            public final void call(Object obj) {
                LoginSignupCredentialsFlavorPresenter.lambda$handleClickOnPrivacyPolicy$8((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.y
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6977f.q((Throwable) obj);
            }
        });
    }

    private void handleClickOnTermsAndConditions() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.k0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6920f.r((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.j0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6915f.s((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.z
            @Override // rx.m.b
            public final void call(Object obj) {
                LoginSignupCredentialsFlavorPresenter.lambda$handleClickOnTermsAndConditions$3((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.m0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6930f.t((Throwable) obj);
            }
        });
    }

    private void handleConnectWithEmailClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6880f.v((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.d0
            @Override // rx.m.b
            public final void call(Object obj) {
                LoginSignupCredentialsFlavorPresenter.lambda$handleConnectWithEmailClick$16((Boolean) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.l0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6925f.w((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnPrivacyPolicy$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e o(View.LifecycleEvent lifecycleEvent) {
        return this.view.privacyPolicyClickEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnPrivacyPolicy$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(Void r1) {
        this.accountNavigator.navigateToPrivacyPolicy();
    }

    static /* synthetic */ void lambda$handleClickOnPrivacyPolicy$8(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnPrivacyPolicy$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnTermsAndConditions$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e r(View.LifecycleEvent lifecycleEvent) {
        return this.view.termsAndConditionsClickEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnTermsAndConditions$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(Void r1) {
        this.accountNavigator.navigateToTermsAndConditions();
    }

    static /* synthetic */ void lambda$handleClickOnTermsAndConditions$3(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnTermsAndConditions$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(Throwable th) {
        this.crashReport.log(th);
    }

    static /* synthetic */ Boolean lambda$handleConnectWithEmailClick$13(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleConnectWithEmailClick$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(Boolean bool) {
        this.view.showAptoideLoginArea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleConnectWithEmailClick$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e v(View.LifecycleEvent lifecycleEvent) {
        return this.view.showAptoideLoginAreaClick().x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.k3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6923f.showNotCheckedMessage(((Boolean) obj).booleanValue());
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.a0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                LoginSignupCredentialsFlavorPresenter.lambda$handleConnectWithEmailClick$13(bool);
                return bool;
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.e0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6890f.u((Boolean) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleConnectWithEmailClick$16(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleConnectWithEmailClick$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(Throwable th) {
        this.view.hideLoading();
        this.view.showError(this.errorMapper.map(th));
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showTCandPP$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(View.LifecycleEvent lifecycleEvent) {
        this.view.showTCandPP();
    }

    private void showTCandPP() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.h0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6905f.x((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).D0();
    }

    @Override // cm.aptoide.pt.view.BackButton.ClickHandler
    public boolean handle() {
        return this.view.tryCloseLoginBottomSheet(true);
    }

    @Override // cm.aptoide.pt.presenter.LoginSignUpCredentialsPresenter, cm.aptoide.pt.presenter.Presenter
    public void present() {
        showTCandPP();
        super.present();
        handleConnectWithEmailClick();
        handleClickOnTermsAndConditions();
        handleClickOnPrivacyPolicy();
    }
}
