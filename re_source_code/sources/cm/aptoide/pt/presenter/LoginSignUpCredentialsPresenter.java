package cm.aptoide.pt.presenter;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.GoogleSignUpAdapter;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.account.view.LoginSignUpCredentialsConfiguration;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.view.BackButton;
import cm.aptoide.pt.view.ThrowableToStringMapper;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collection;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public abstract class LoginSignUpCredentialsPresenter implements Presenter, BackButton.ClickHandler {
    private static final int RESOLVE_GOOGLE_CREDENTIALS_REQUEST_CODE = 2;
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final AccountNavigator accountNavigator;
    private final LoginSignUpCredentialsConfiguration configuration;
    private final CrashReport crashReport;
    private final ThrowableToStringMapper errorMapper;
    private final Collection<String> permissions;
    private final LoginSignUpCredentialsView view;

    public LoginSignUpCredentialsPresenter(LoginSignUpCredentialsView loginSignUpCredentialsView, AptoideAccountManager aptoideAccountManager, CrashReport crashReport, LoginSignUpCredentialsConfiguration loginSignUpCredentialsConfiguration, AccountNavigator accountNavigator, Collection<String> collection, ThrowableToStringMapper throwableToStringMapper, AccountAnalytics accountAnalytics) {
        this.view = loginSignUpCredentialsView;
        this.accountManager = aptoideAccountManager;
        this.crashReport = crashReport;
        this.configuration = loginSignUpCredentialsConfiguration;
        this.accountNavigator = accountNavigator;
        this.permissions = collection;
        this.errorMapper = throwableToStringMapper;
        this.accountAnalytics = accountAnalytics;
    }

    private void handleAccountStatusChangeWhileShowingView() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.RESUME));
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.presenter.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6929f.a((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.u
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6961f.b((Account) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.PAUSE)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.n
            @Override // rx.m.b
            public final void call(Object obj) {
                LoginSignUpCredentialsPresenter.lambda$handleAccountStatusChangeWhileShowingView$7((Account) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.j
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    private void handleGoogleSignUpEvent() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.i
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6909f.c((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6879f.d((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.w
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6969f.e((Boolean) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.presenter.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6889f.f((Boolean) obj);
            }
        }).j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.t
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6957f.g((ConnectionResult) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.k
            @Override // rx.m.b
            public final void call(Object obj) {
                LoginSignUpCredentialsPresenter.lambda$handleGoogleSignUpEvent$16((ConnectionResult) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.b
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6874f.h((Throwable) obj);
            }
        });
    }

    private void handleGoogleSignUpResult() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6899f.m((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).D0();
    }

    private void handleOpenOptions() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.x
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6973f.n((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.h
            @Override // rx.m.b
            public final void call(Object obj) {
                LoginSignUpCredentialsPresenter.lambda$handleOpenOptions$2((View.LifecycleEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.q
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAccountStatusChangeWhileShowingView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single a(View.LifecycleEvent lifecycleEvent) {
        return this.accountManager.accountStatus().E().Z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAccountStatusChangeWhileShowingView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Account account) {
        if (account.isLoggedIn()) {
            navigateBack();
        }
    }

    static /* synthetic */ void lambda$handleAccountStatusChangeWhileShowingView$7(Account account) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGoogleSignUpEvent$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(View.LifecycleEvent lifecycleEvent) {
        showOrHideGoogleSignUp();
    }

    static /* synthetic */ Boolean lambda$handleGoogleSignUpEvent$11(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGoogleSignUpEvent$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(View.LifecycleEvent lifecycleEvent) {
        return this.view.googleSignUpEvent().x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.j3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6918f.showNotCheckedMessage(((Boolean) obj).booleanValue());
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                LoginSignUpCredentialsPresenter.lambda$handleGoogleSignUpEvent$11(bool);
                return bool;
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGoogleSignUpEvent$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(Boolean bool) {
        this.view.showLoading();
        this.accountAnalytics.sendGoogleLoginButtonPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGoogleSignUpEvent$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single f(Boolean bool) {
        return this.accountNavigator.navigateToGoogleSignUpForResult(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGoogleSignUpEvent$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(ConnectionResult connectionResult) {
        if (connectionResult.e0()) {
            return;
        }
        this.view.showConnectionError(connectionResult);
        this.view.hideLoading();
    }

    static /* synthetic */ void lambda$handleGoogleSignUpEvent$16(ConnectionResult connectionResult) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGoogleSignUpEvent$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Throwable th) {
        this.view.hideLoading();
        this.view.showError(this.errorMapper.map(th));
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGoogleSignUpResult$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i() {
        this.accountAnalytics.loginSuccess();
        navigateToMainView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGoogleSignUpResult$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j() {
        this.view.hideLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGoogleSignUpResult$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(Throwable th) {
        this.view.showError(this.errorMapper.map(th));
        this.crashReport.log(th);
        this.accountAnalytics.sendLoginErrorEvent(AccountAnalytics.LoginMethod.GOOGLE, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGoogleSignUpResult$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b l(GoogleSignInResult googleSignInResult) {
        return this.accountManager.signUp(GoogleSignUpAdapter.TYPE, googleSignInResult).z(rx.l.c.a.b()).m(new rx.m.a() { // from class: cm.aptoide.pt.presenter.r
            @Override // rx.m.a
            public final void call() {
                this.f6949f.i();
            }
        }).q(new rx.m.a() { // from class: cm.aptoide.pt.presenter.a
            @Override // rx.m.a
            public final void call() {
                this.f6869f.j();
            }
        }).n(new rx.m.b() { // from class: cm.aptoide.pt.presenter.v
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6965f.k((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGoogleSignUpResult$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e m(View.LifecycleEvent lifecycleEvent) {
        return this.accountNavigator.googleSignUpResults(2).H(new rx.m.e() { // from class: cm.aptoide.pt.presenter.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6941f.l((GoogleSignInResult) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleOpenOptions$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(View.LifecycleEvent lifecycleEvent) {
        if (this.configuration.getHasMagicLinkError()) {
            this.view.showAptoideLoginArea();
            this.view.showMagicLinkError(this.configuration.getMagicLinkErrorMessage());
        }
    }

    static /* synthetic */ void lambda$handleOpenOptions$2(View.LifecycleEvent lifecycleEvent) {
    }

    private void navigateBack() {
        this.accountNavigator.popView();
    }

    private void navigateToMainView() {
        if (this.configuration.getDismissToNavigateToMainView()) {
            this.view.dismiss();
        } else if (this.configuration.getCleanBackStack()) {
            navigateToMainViewCleaningBackStack();
        } else {
            navigateBack();
        }
    }

    private void navigateToMainViewCleaningBackStack() {
        this.accountNavigator.navigateToHomeView();
    }

    private void showOrHideGoogleSignUp() {
        if (this.accountManager.isSignUpEnabled(GoogleSignUpAdapter.TYPE)) {
            this.view.showGoogleLogin();
        } else {
            this.view.hideGoogleLogin();
        }
    }

    void lockScreenRotation() {
        this.view.lockScreenRotation();
    }

    void navigateToCreateProfile() {
        this.accountNavigator.navigateToCreateProfileView();
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        handleOpenOptions();
        handleGoogleSignUpEvent();
        handleGoogleSignUpResult();
        handleAccountStatusChangeWhileShowingView();
    }

    void showNotCheckedMessage(boolean z) {
        if (z) {
            return;
        }
        this.view.showTermsConditionError();
    }

    void unlockScreenRotation() {
        this.view.unlockScreenRotation();
    }
}
