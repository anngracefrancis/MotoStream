package cm.aptoide.pt.account.view.user;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.LoginSignupManager;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public class ProfileStepOnePresenter implements Presenter {
    private static final String TAG = "ProfileStepOnePresenter";
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final AccountNavigator accountNavigator;
    private final CrashReport crashReport;
    private LoginSignupManager loginSignupManager;
    private final ProfileStepOneView view;

    public ProfileStepOnePresenter(ProfileStepOneView profileStepOneView, CrashReport crashReport, AptoideAccountManager aptoideAccountManager, AccountNavigator accountNavigator, AccountAnalytics accountAnalytics, LoginSignupManager loginSignupManager) {
        this.view = profileStepOneView;
        this.crashReport = crashReport;
        this.accountManager = aptoideAccountManager;
        this.accountNavigator = accountNavigator;
        this.accountAnalytics = accountAnalytics;
        this.loginSignupManager = loginSignupManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$makeUserProfilePublic$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(Throwable th) {
        this.crashReport.log(th);
        return this.view.showGenericErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Void r3) {
        this.accountAnalytics.accountProfileAction(1, AccountAnalytics.ProfileAction.MORE_INFO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Boolean bool) {
        if (bool.booleanValue() || !this.loginSignupManager.shouldShowCreateStore()) {
            this.accountNavigator.navigateToHomeView();
        } else {
            this.accountNavigator.navigateToCreateStoreView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(final Boolean bool) {
        return makeUserProfilePublic().z(rx.l.c.a.b()).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.h0
            @Override // rx.m.a
            public final void call() {
                this.f3979f.k();
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.k0
            @Override // rx.m.a
            public final void call() {
                this.f3989f.l();
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.l0
            @Override // rx.m.a
            public final void call() {
                this.f3992f.c(bool);
            }
        }).M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(View.LifecycleEvent lifecycleEvent) {
        return this.view.continueButtonClick().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.s0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4012f.j((Boolean) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4010f.d((Boolean) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.j0
            @Override // rx.m.b
            public final void call(Object obj) {
                Logger.getInstance().e(ProfileStepOnePresenter.TAG, (Throwable) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$present$14(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Void r1) {
        this.accountNavigator.navigateToProfileStepTwoView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(View.LifecycleEvent lifecycleEvent) {
        return this.view.moreInfoButtonClick().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.f0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3972f.b((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.c0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3963f.g((Void) obj);
            }
        });
    }

    static /* synthetic */ void lambda$present$4(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Boolean bool) {
        this.view.showWaitDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k() {
        this.accountAnalytics.accountProfileAction(1, AccountAnalytics.ProfileAction.CONTINUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l() {
        this.view.dismissWaitDialog();
    }

    private rx.b makeUserProfilePublic() {
        return this.accountManager.updateAccount(Account.Access.PUBLIC).C(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.m0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3997f.a((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        rx.e<R> eVarG = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3969f.h((View.LifecycleEvent) obj);
            }
        });
        ProfileStepOneView profileStepOneView = this.view;
        View.LifecycleEvent lifecycleEvent = View.LifecycleEvent.DESTROY;
        eVarG.f(profileStepOneView.bindUntilEvent(lifecycleEvent)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.q0
            @Override // rx.m.b
            public final void call(Object obj) {
                ProfileStepOnePresenter.lambda$present$4((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.n0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4000f.i((Throwable) obj);
            }
        });
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4006f.e((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(lifecycleEvent)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.o0
            @Override // rx.m.b
            public final void call(Object obj) {
                ProfileStepOnePresenter.lambda$present$14(obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.i0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3982f.f((Throwable) obj);
            }
        });
    }
}
