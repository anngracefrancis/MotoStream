package cm.aptoide.pt.account.view.user;

import android.net.Uri;
import android.text.TextUtils;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.UriToPathResolver;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.view.ThrowableToStringMapper;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class ManageUserPresenter implements Presenter {
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final CrashReport crashReport;
    private final ThrowableToStringMapper errorMapper;
    private final boolean isEditProfile;
    private final boolean isFirstTime;
    private final ManageUserNavigator navigator;
    private final boolean showPrivacyConfigs;
    private final UriToPathResolver uriToPathResolver;
    private final ManageUserView view;

    public ManageUserPresenter(ManageUserView manageUserView, CrashReport crashReport, AptoideAccountManager aptoideAccountManager, ThrowableToStringMapper throwableToStringMapper, ManageUserNavigator manageUserNavigator, boolean z, UriToPathResolver uriToPathResolver, boolean z2, boolean z3, AccountAnalytics accountAnalytics) {
        this.view = manageUserView;
        this.crashReport = crashReport;
        this.accountManager = aptoideAccountManager;
        this.errorMapper = throwableToStringMapper;
        this.navigator = manageUserNavigator;
        this.isEditProfile = z;
        this.uriToPathResolver = uriToPathResolver;
        this.showPrivacyConfigs = z2;
        this.isFirstTime = z3;
        this.accountAnalytics = accountAnalytics;
    }

    private void handleCancelClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3975f.b((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.a0
            @Override // rx.m.b
            public final void call(Object obj) {
                ManageUserPresenter.lambda$handleCancelClick$18((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.k
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3988f.c((Throwable) obj);
            }
        });
    }

    private void handleSaveDataClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3984f.d((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSaveUserDataError, reason: merged with bridge method [inline-methods] */
    public rx.b q(Throwable th) {
        String map = this.errorMapper.map(th);
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.s
            @Override // rx.m.a
            public final void call() {
                this.f4011f.h();
            }
        }).a(((th instanceof SocketTimeoutException) || (th instanceof TimeoutException)) ? this.view.showErrorMessage(map).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.m
            @Override // rx.m.a
            public final void call() {
                this.f3996f.g();
            }
        }) : this.view.showErrorMessage(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCancelClick$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Void r1) {
        this.navigator.goBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCancelClick$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(View.LifecycleEvent lifecycleEvent) {
        return this.view.cancelButtonClick().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.i
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3981f.a((Void) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleCancelClick$18(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCancelClick$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSaveDataClick$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(View.LifecycleEvent lifecycleEvent) {
        return this.view.saveUserDataButtonClick().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.x
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4022f.e((ManageUserFragment.ViewModel) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4026f.f((ManageUserFragment.ViewModel) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSaveDataClick$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(ManageUserFragment.ViewModel viewModel) {
        this.view.showProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSaveUserDataError$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h() {
        this.view.hideProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreatedLoadUserData$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean i(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(this.isFirstTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreatedLoadUserData$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single j(View.LifecycleEvent lifecycleEvent) {
        return this.accountManager.accountStatus().E().Z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreatedLoadUserData$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ManageUserFragment.ViewModel k(Account account) {
        if (this.isEditProfile) {
            return new ManageUserFragment.ViewModel(account.getNickname(), account.getAvatar());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreatedLoadUserData$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(ManageUserFragment.ViewModel viewModel) {
        this.view.loadImageStateless(viewModel.getPictureUri());
        this.view.setUserName(viewModel.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreatedLoadUserData$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveUserData$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        this.view.hideProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: navigateAway, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void p() {
        if (this.isEditProfile) {
            this.navigator.goBack();
        } else if (this.showPrivacyConfigs) {
            this.navigator.toProfileStepOne();
        } else {
            this.navigator.goToHome();
        }
    }

    private void onViewCreatedLoadUserData() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4002f.i((View.LifecycleEvent) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4007f.j((View.LifecycleEvent) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4005f.k((Account) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((ManageUserFragment.ViewModel) obj) != null);
            }
        }).j0(rx.l.c.a.b()).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.y
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4024f.l((ManageUserFragment.ViewModel) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.h
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3978f.m((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: saveUserData, reason: merged with bridge method [inline-methods] */
    public rx.b f(final ManageUserFragment.ViewModel viewModel) {
        return updateUserAccount(viewModel).z(rx.l.c.a.b()).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.f
            @Override // rx.m.a
            public final void call() {
                this.f3971f.n();
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.u
            @Override // rx.m.a
            public final void call() {
                this.f4015f.o(viewModel);
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.w
            @Override // rx.m.a
            public final void call() {
                this.f4020f.p();
            }
        }).C(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3991f.q((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sendAnalytics, reason: merged with bridge method [inline-methods] */
    public void o(ManageUserFragment.ViewModel viewModel) {
        if (this.isEditProfile) {
            return;
        }
        this.accountAnalytics.createdUserProfile(!TextUtils.isEmpty(viewModel.getPictureUri()));
    }

    private rx.b updateUserAccount(ManageUserFragment.ViewModel viewModel) {
        if (this.isEditProfile) {
            if (!viewModel.hasNewPicture()) {
                return this.accountManager.updateAccount(viewModel.getName());
            }
            return this.accountManager.updateAccount(viewModel.getName(), this.uriToPathResolver.getMediaStoragePath(Uri.parse(viewModel.getPictureUri())));
        }
        if (!viewModel.hasNewPicture()) {
            return this.accountManager.updateAccount(viewModel.getName());
        }
        return this.accountManager.updateAccount(viewModel.getName(), this.uriToPathResolver.getMediaStoragePath(Uri.parse(viewModel.getPictureUri())));
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        handleSaveDataClick();
        handleCancelClick();
        onViewCreatedLoadUserData();
    }
}
