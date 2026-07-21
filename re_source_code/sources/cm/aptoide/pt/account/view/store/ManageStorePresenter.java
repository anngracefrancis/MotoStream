package cm.aptoide.pt.account.view.store;

import android.net.Uri;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.UriToPathResolver;
import cm.aptoide.pt.account.view.exception.InvalidImageException;
import cm.aptoide.pt.account.view.exception.StoreCreationException;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import java.util.concurrent.Callable;
import okhttp3.HttpUrl;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class ManageStorePresenter implements Presenter {
    private AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final String applicationPackageName;
    private final CrashReport crashReport;
    private final ManageStoreErrorMapper errorMapper;
    private final boolean goBackToHome;
    private final ManageStoreNavigator navigator;
    private final int requestCode;
    private final UriToPathResolver uriToPathResolver;
    private final ManageStoreView view;

    public ManageStorePresenter(ManageStoreView manageStoreView, CrashReport crashReport, UriToPathResolver uriToPathResolver, String str, ManageStoreNavigator manageStoreNavigator, boolean z, ManageStoreErrorMapper manageStoreErrorMapper, AptoideAccountManager aptoideAccountManager, int i2, AccountAnalytics accountAnalytics) {
        this.view = manageStoreView;
        this.crashReport = crashReport;
        this.uriToPathResolver = uriToPathResolver;
        this.applicationPackageName = str;
        this.navigator = manageStoreNavigator;
        this.goBackToHome = z;
        this.errorMapper = manageStoreErrorMapper;
        this.accountManager = aptoideAccountManager;
        this.requestCode = i2;
        this.accountAnalytics = accountAnalytics;
    }

    private void handleCancel() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3925f.c((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.store.m
            @Override // rx.m.b
            public final void call(Object obj) {
                ManageStorePresenter.lambda$handleCancel$3((ManageStoreViewModel) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.store.p
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3930f.d((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public rx.b handleSaveClick(final ManageStoreViewModel manageStoreViewModel) {
        final ManageStoreView manageStoreView = this.view;
        manageStoreView.getClass();
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.account.view.store.b
            @Override // rx.m.a
            public final void call() {
                manageStoreView.showWaitProgressBar();
            }
        }).z(Schedulers.io()).a(saveData(manageStoreViewModel)).z(rx.l.c.a.b()).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.store.o
            @Override // rx.m.a
            public final void call() {
                this.f3928f.h(manageStoreViewModel);
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.store.j
            @Override // rx.m.a
            public final void call() {
                this.f3923f.i();
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.store.s
            @Override // rx.m.a
            public final void call() {
                this.f3934f.j();
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.store.x
            @Override // rx.m.a
            public final void call() {
                this.f3940f.e();
            }
        }).C(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3931f.g((Throwable) obj);
            }
        });
    }

    private void handleSaveData() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3924f.k((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).D0();
    }

    private void handleStoreCreationErrors(Throwable th) {
        if (th instanceof InvalidImageException) {
            InvalidImageException invalidImageException = (InvalidImageException) th;
            if (invalidImageException.getImageErrors().contains(InvalidImageException.ImageError.API_ERROR)) {
                this.view.showError(this.errorMapper.getImageError());
                return;
            } else {
                this.view.showError(this.errorMapper.getNetworkError(invalidImageException.getErrorCode(), this.applicationPackageName));
                return;
            }
        }
        if (th instanceof StoreCreationException) {
            StoreCreationException storeCreationException = (StoreCreationException) th;
            if (storeCreationException.hasErrorCode()) {
                this.view.showError(this.errorMapper.getNetworkError(storeCreationException.getErrorCode(), this.applicationPackageName));
                return;
            } else {
                this.view.showError(this.errorMapper.getInvalidStoreError());
                return;
            }
        }
        if (th instanceof StoreValidationException) {
            StoreValidationException storeValidationException = (StoreValidationException) th;
            if (storeValidationException.getErrorCode() == 0) {
                this.view.showError(this.errorMapper.getInvalidStoreError());
                return;
            } else if (storeValidationException.getErrorCode() == 1) {
                this.view.showError(this.errorMapper.getImageError());
                return;
            }
        }
        this.crashReport.log(th);
        this.view.showError(this.errorMapper.getGenericError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCancel$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(ManageStoreViewModel manageStoreViewModel) {
        if (this.goBackToHome) {
            this.accountAnalytics.createStore(manageStoreViewModel.hasPicture(), AccountAnalytics.CreateStoreAction.SKIP);
        }
        navigate(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCancel$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(View.LifecycleEvent lifecycleEvent) {
        return this.view.cancelClick().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.store.v
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3937f.b((ManageStoreViewModel) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleCancel$3(ManageStoreViewModel manageStoreViewModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCancel$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSaveClick$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e() {
        navigate(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSaveClick$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        this.view.dismissWaitProgressBar();
        handleStoreCreationErrors(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSaveClick$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b g(final Throwable th) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.account.view.store.r
            @Override // rx.m.a
            public final void call() {
                this.f3932f.f(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSaveClick$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(ManageStoreViewModel manageStoreViewModel) {
        if (this.goBackToHome) {
            this.accountAnalytics.createStore(manageStoreViewModel.hasPicture(), AccountAnalytics.CreateStoreAction.CREATE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSaveClick$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i() {
        this.view.dismissWaitProgressBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSaveClick$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j() {
        this.view.showSuccessMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSaveData$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e k(View.LifecycleEvent lifecycleEvent) {
        rx.e<ManageStoreViewModel> eVarH = this.view.saveDataClick().H(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3927f.handleSaveClick((ManageStoreViewModel) obj);
            }
        });
        final CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        return eVarH.w(new rx.m.b() { // from class: cm.aptoide.pt.account.view.store.a
            @Override // rx.m.b
            public final void call(Object obj) {
                crashReport.log((Throwable) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveData$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String l(ManageStoreViewModel manageStoreViewModel) throws Exception {
        return manageStoreViewModel.hasNewAvatar() ? this.uriToPathResolver.getMediaStoragePath(Uri.parse(manageStoreViewModel.getPictureUri())) : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveData$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b m(ManageStoreViewModel manageStoreViewModel, String str) {
        return this.accountManager.createOrUpdate(manageStoreViewModel.getStoreName(), manageStoreViewModel.getStoreDescription(), str, manageStoreViewModel.hasNewAvatar(), manageStoreViewModel.getStoreTheme().getThemeName(), manageStoreViewModel.storeExists());
    }

    private void navigate(boolean z) {
        if (this.goBackToHome) {
            this.navigator.goToHome();
        } else {
            this.navigator.popViewWithResult(this.requestCode, z);
        }
    }

    private rx.b saveData(final ManageStoreViewModel manageStoreViewModel) {
        return Single.l(new Callable() { // from class: cm.aptoide.pt.account.view.store.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f3938f.l(manageStoreViewModel);
            }
        }).j(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.y
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3941f.m(manageStoreViewModel, (String) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        handleSaveData();
        handleCancel();
    }
}
