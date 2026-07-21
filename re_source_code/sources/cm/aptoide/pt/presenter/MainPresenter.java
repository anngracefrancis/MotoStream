package cm.aptoide.pt.presenter;

import android.content.Intent;
import android.content.SharedPreferences;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.accountmanager.AptoideCredentials;
import cm.aptoide.pt.account.AgentPersistence;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.apkfy.ApkFyParser;
import cm.aptoide.pt.autoupdate.AutoUpdateDialogFragment;
import cm.aptoide.pt.autoupdate.AutoUpdateManager;
import cm.aptoide.pt.bottomNavigation.BottomNavigationMapper;
import cm.aptoide.pt.bottomNavigation.BottomNavigationNavigator;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.home.AptoideBottomNavigator;
import cm.aptoide.pt.home.apps.UpdatesManager;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.InstallCompletedNotifier;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.install.installer.RootInstallationRetryHandler;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.notification.ContentPuller;
import cm.aptoide.pt.notification.NotificationSyncScheduler;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.preferences.secure.SecurePreferences;
import cm.aptoide.pt.root.RootAvailabilityManager;
import cm.aptoide.pt.view.DeepLinkManager;
import cm.aptoide.pt.view.wizard.WizardFragment;
import com.aptoide.authentication.AuthenticationException;
import java.util.List;
import rx.Single;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: loaded from: classes.dex */
public class MainPresenter implements Presenter {
    private final AptoideAccountManager accountManager;
    private final AccountNavigator accountNavigator;
    private final AgentPersistence agentPersistence;
    private final ApkFyParser apkFyParser;
    private final AptoideBottomNavigator aptoideBottomNavigator;
    private final AutoUpdateManager autoUpdateManager;
    private final BottomNavigationMapper bottomNavigationMapper;
    private final BottomNavigationNavigator bottomNavigationNavigator;
    private final ContentPuller contentPuller;
    private final CrashReport crashReport;
    private final DeepLinkManager deepLinkManager;
    private final boolean firstCreated;
    private final FragmentNavigator fragmentNavigator;
    private final InstallCompletedNotifier installCompletedNotifier;
    private final InstallManager installManager;
    private final rx.h ioScheduler;
    private final NotificationSyncScheduler notificationSyncScheduler;
    private final PermissionService permissionService;
    private final RootAvailabilityManager rootAvailabilityManager;
    private final RootInstallationRetryHandler rootInstallationRetryHandler;
    private final SharedPreferences securePreferences;
    private final SharedPreferences sharedPreferences;
    private final UpdatesManager updatesManager;
    private final MainView view;
    private final rx.h viewScheduler;

    public MainPresenter(MainView mainView, InstallManager installManager, RootInstallationRetryHandler rootInstallationRetryHandler, CrashReport crashReport, ApkFyParser apkFyParser, ContentPuller contentPuller, NotificationSyncScheduler notificationSyncScheduler, InstallCompletedNotifier installCompletedNotifier, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, FragmentNavigator fragmentNavigator, DeepLinkManager deepLinkManager, boolean z, AptoideBottomNavigator aptoideBottomNavigator, rx.h hVar, rx.h hVar2, BottomNavigationNavigator bottomNavigationNavigator, UpdatesManager updatesManager, AutoUpdateManager autoUpdateManager, PermissionService permissionService, RootAvailabilityManager rootAvailabilityManager, BottomNavigationMapper bottomNavigationMapper, AptoideAccountManager aptoideAccountManager, AccountNavigator accountNavigator, AgentPersistence agentPersistence) {
        this.view = mainView;
        this.installManager = installManager;
        this.rootInstallationRetryHandler = rootInstallationRetryHandler;
        this.crashReport = crashReport;
        this.apkFyParser = apkFyParser;
        this.contentPuller = contentPuller;
        this.notificationSyncScheduler = notificationSyncScheduler;
        this.installCompletedNotifier = installCompletedNotifier;
        this.fragmentNavigator = fragmentNavigator;
        this.deepLinkManager = deepLinkManager;
        this.firstCreated = z;
        this.sharedPreferences = sharedPreferences;
        this.securePreferences = sharedPreferences2;
        this.aptoideBottomNavigator = aptoideBottomNavigator;
        this.viewScheduler = hVar;
        this.ioScheduler = hVar2;
        this.bottomNavigationNavigator = bottomNavigationNavigator;
        this.updatesManager = updatesManager;
        this.autoUpdateManager = autoUpdateManager;
        this.permissionService = permissionService;
        this.rootAvailabilityManager = rootAvailabilityManager;
        this.bottomNavigationMapper = bottomNavigationMapper;
        this.accountManager = aptoideAccountManager;
        this.accountNavigator = accountNavigator;
        this.agentPersistence = agentPersistence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: authenticate, reason: merged with bridge method [inline-methods] */
    public rx.b k(String str) {
        return this.accountManager.login(new AptoideCredentials(this.agentPersistence.getEmail(), str, true, this.agentPersistence.getAgent(), this.agentPersistence.getState())).p(this.viewScheduler).f(new rx.m.a() { // from class: cm.aptoide.pt.presenter.d3
            @Override // rx.m.a
            public final void call() {
                this.f6888f.a();
            }
        }).g(new rx.m.b() { // from class: cm.aptoide.pt.presenter.v1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6967f.b((Boolean) obj);
            }
        }).g(new rx.m.b() { // from class: cm.aptoide.pt.presenter.b3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6878f.c((Boolean) obj);
            }
        }).e(new rx.m.b() { // from class: cm.aptoide.pt.presenter.y1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6979f.d((Throwable) obj);
            }
        }).z();
    }

    private void downloadAutoUpdate() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(View.LifecycleEvent.CREATE.equals((View.LifecycleEvent) obj));
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.u2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6964f.e((View.LifecycleEvent) obj);
            }
        }).j0(this.ioScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.s1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6955f.f((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.e3
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                MainPresenter.lambda$downloadAutoUpdate$61(bool);
                return bool;
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.presenter.q0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6946f.g((Boolean) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.v0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6966f.h((Boolean) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.w2
            @Override // rx.m.b
            public final void call(Object obj) {
                MainPresenter.lambda$downloadAutoUpdate$64(obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.t0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6958f.i((Throwable) obj);
            }
        });
    }

    private void handleAuthentication() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.z0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(View.LifecycleEvent.CREATE.equals((View.LifecycleEvent) obj));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.h1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6906f.l((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.b1
            @Override // rx.m.b
            public final void call(Object obj) {
                MainPresenter.lambda$handleAuthentication$18((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.l3
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    private rx.e<Boolean> handleAutoUpdateDialog() {
        this.autoUpdateManager.incrementAutoUpdateShow();
        return this.autoUpdateManager.shouldShowAutoUpdateDialog().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.g3
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                MainPresenter.lambda$handleAutoUpdateDialog$69(bool);
                return bool;
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.w1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6971f.m((Boolean) obj);
            }
        });
    }

    private rx.e<Install> handleAutoUpdateDownload() {
        return this.autoUpdateManager.hasDownloadPermissions(this.permissionService).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.h3
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                MainPresenter.lambda$handleAutoUpdateDownload$66(bool);
                return bool;
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.s2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6956f.n((Boolean) obj);
            }
        }).j0(this.ioScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.r2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6952f.o((Boolean) obj);
            }
        });
    }

    private void handleErrorResult(Throwable th) {
        this.view.dismissAutoUpdateDialog();
        if (th instanceof SecurityException) {
            return;
        }
        this.view.showUnknownErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleFirstSignup, reason: merged with bridge method [inline-methods] */
    public void c(Boolean bool) {
        if (bool.booleanValue()) {
            this.accountNavigator.navigateToCreateProfileView();
        }
    }

    private Single<Boolean> isAutoUpdateDownloaded() {
        return this.autoUpdateManager.isDownloadComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$authenticate$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a() {
        this.view.showLoadingView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$authenticate$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Boolean bool) {
        this.view.hideLoadingView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$authenticate$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Throwable th) {
        this.view.hideLoadingView();
        if (th instanceof AuthenticationException) {
            AuthenticationException authenticationException = (AuthenticationException) th;
            if (authenticationException.getCode() >= 400 && authenticationException.getCode() < 500) {
                this.accountNavigator.navigateToLoginError();
                return;
            }
        }
        this.view.showGenericErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadAutoUpdate$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean e(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(ManagerPreferences.isCheckAutoUpdateEnable(this.sharedPreferences));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadAutoUpdate$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(View.LifecycleEvent lifecycleEvent) {
        return this.autoUpdateManager.shouldUpdate();
    }

    static /* synthetic */ Boolean lambda$downloadAutoUpdate$61(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadAutoUpdate$62, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single g(Boolean bool) {
        return isAutoUpdateDownloaded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadAutoUpdate$63, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(Boolean bool) {
        return bool.booleanValue() ? handleAutoUpdateDialog() : handleAutoUpdateDownload();
    }

    static /* synthetic */ void lambda$downloadAutoUpdate$64(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadAutoUpdate$65, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Throwable th) {
        handleErrorResult(th);
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAuthentication$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(String str) {
        this.accountNavigator.clearBackStackUntilLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAuthentication$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e l(View.LifecycleEvent lifecycleEvent) {
        return this.view.onAuthenticationIntent().x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.u0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6962f.j((String) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.presenter.m2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6932f.k((String) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleAuthentication$18(String str) {
    }

    static /* synthetic */ Boolean lambda$handleAutoUpdateDialog$69(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAutoUpdateDialog$70, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(Boolean bool) {
        showAutoUpdate();
    }

    static /* synthetic */ Boolean lambda$handleAutoUpdateDownload$66(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAutoUpdateDownload$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(Boolean bool) {
        this.autoUpdateManager.clearAutoUpdateShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAutoUpdateDownload$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e o(Boolean bool) {
        return this.autoUpdateManager.startUpdate(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(View.LifecycleEvent lifecycleEvent) {
        this.apkFyParser.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(Integer num) {
        this.aptoideBottomNavigator.showFragment(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e r(View.LifecycleEvent lifecycleEvent) {
        return this.aptoideBottomNavigator.navigationEvent().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.n2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6936f.q((Integer) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$present$12(Integer num) {
    }

    static /* synthetic */ void lambda$present$13(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean s(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(this.firstCreated);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(View.LifecycleEvent lifecycleEvent) {
        this.notificationSyncScheduler.forceSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(View.LifecycleEvent lifecycleEvent) {
        this.contentPuller.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(View.LifecycleEvent lifecycleEvent) {
        downloadAutoUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(View.LifecycleEvent lifecycleEvent) {
        navigate();
    }

    static /* synthetic */ void lambda$present$7(View.LifecycleEvent lifecycleEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single y(View.LifecycleEvent lifecycleEvent) {
        return this.rootAvailabilityManager.isRootAvailable();
    }

    static /* synthetic */ Boolean lambda$setupInstallErrorsDisplay$30(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e z(Boolean bool) {
        return this.rootInstallationRetryHandler.retries().f(this.view.bindUntilEvent(View.LifecycleEvent.PAUSE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(List list) {
        watchInstalls(list);
        this.view.showInstallationError(list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single C(View.LifecycleEvent lifecycleEvent) {
        return this.rootAvailabilityManager.isRootAvailable();
    }

    static /* synthetic */ Boolean lambda$setupInstallErrorsDisplay$38(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e D(Boolean bool) {
        return this.installManager.getTimedOutInstallations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(List list) {
        this.view.dismissInstallationError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single G(View.LifecycleEvent lifecycleEvent) {
        return this.rootAvailabilityManager.isRootAvailable();
    }

    static /* synthetic */ Boolean lambda$setupInstallErrorsDisplay$45(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e H(Boolean bool) {
        return this.installCompletedNotifier.getWatcher();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(Void r1) {
        this.view.showInstallationSuccessMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single J(View.LifecycleEvent lifecycleEvent) {
        return this.rootAvailabilityManager.isRootAvailable();
    }

    static /* synthetic */ Boolean lambda$setupInstallErrorsDisplay$50(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e K(Boolean bool) {
        return this.view.getInstallErrorsDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b L(Void r1) {
        return this.installManager.cleanTimedOutInstalls();
    }

    static /* synthetic */ void lambda$setupInstallErrorsDisplay$53(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInstallErrorsDisplay$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupUpdatesNumber$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e N(View.LifecycleEvent lifecycleEvent) {
        return this.updatesManager.getUpdatesNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupUpdatesNumber$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(Integer num) {
        this.view.showUpdatesBadge(num.intValue());
    }

    static /* synthetic */ void lambda$setupUpdatesNumber$26(Integer num) {
    }

    static /* synthetic */ void lambda$setupUpdatesNumber$27(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$shortcutManagement$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(View.LifecycleEvent lifecycleEvent) {
        this.deepLinkManager.freeSubscriptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$shortcutManagement$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(Throwable th) {
        this.crashReport.log(th);
    }

    private void navigate() {
        Intent intentAfterCreate = this.view.getIntentAfterCreate();
        showHome();
        if (this.deepLinkManager.showDeepLink(intentAfterCreate)) {
            SecurePreferences.setWizardAvailable(false, this.securePreferences);
        } else if (SecurePreferences.isWizardAvailable(this.securePreferences)) {
            showWizard();
            SecurePreferences.setWizardAvailable(false, this.securePreferences);
        }
    }

    private void setupInstallErrorsDisplay() {
        rx.e eVarJ0 = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.a2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(View.LifecycleEvent.RESUME.equals((View.LifecycleEvent) obj));
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.presenter.x0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6974f.y((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.p1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                MainPresenter.lambda$setupInstallErrorsDisplay$30(bool);
                return bool;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.l1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6926f.z((Boolean) obj);
            }
        }).u(new rx.m.e() { // from class: cm.aptoide.pt.presenter.p2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Integer.valueOf(((List) obj).size());
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.x1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(!((List) obj).isEmpty());
            }
        }).j0(rx.l.c.a.b());
        MainView mainView = this.view;
        View.LifecycleEvent lifecycleEvent = View.LifecycleEvent.DESTROY;
        eVarJ0.f(mainView.bindUntilEvent(lifecycleEvent)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.x2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6976f.A((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.j1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6916f.B((Throwable) obj);
            }
        });
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.t1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(View.LifecycleEvent.RESUME.equals((View.LifecycleEvent) obj));
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.presenter.s0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6954f.C((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.b2
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                MainPresenter.lambda$setupInstallErrorsDisplay$38(bool);
                return bool;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.z1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6983f.D((Boolean) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.o2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(!((List) obj).isEmpty());
            }
        }).j0(rx.l.c.a.b()).f(this.view.bindUntilEvent(lifecycleEvent)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.f2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6897f.E((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.h2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6907f.F((Throwable) obj);
            }
        });
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.t2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(View.LifecycleEvent.RESUME.equals((View.LifecycleEvent) obj));
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.presenter.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6950f.G((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.n1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                MainPresenter.lambda$setupInstallErrorsDisplay$45(bool);
                return bool;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6921f.H((Boolean) obj);
            }
        }).f(this.view.bindUntilEvent(lifecycleEvent)).G0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.u1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6963f.I((Void) obj);
            }
        });
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.c1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(View.LifecycleEvent.RESUME.equals((View.LifecycleEvent) obj));
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.presenter.i1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6911f.J((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.e2
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                MainPresenter.lambda$setupInstallErrorsDisplay$50(bool);
                return bool;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.g1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6901f.K((Boolean) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.presenter.z2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6984f.L((Void) obj);
            }
        }).f(this.view.bindUntilEvent(lifecycleEvent)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.i2
            @Override // rx.m.b
            public final void call(Object obj) {
                MainPresenter.lambda$setupInstallErrorsDisplay$53((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.y0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6978f.M((Throwable) obj);
            }
        });
    }

    private void setupUpdatesNumber() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.k2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.a3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6873f.N((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.v2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6968f.O((Integer) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.d1
            @Override // rx.m.b
            public final void call(Object obj) {
                MainPresenter.lambda$setupUpdatesNumber$26((Integer) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.f1
            @Override // rx.m.b
            public final void call(Object obj) {
                MainPresenter.lambda$setupUpdatesNumber$27((Throwable) obj);
                throw null;
            }
        });
    }

    private void shortcutManagement() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.i3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.DESTROY));
            }
        }).E().H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.o1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6939f.P((View.LifecycleEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.y2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6980f.Q((Throwable) obj);
            }
        });
    }

    private void showAutoUpdate() {
        this.fragmentNavigator.navigateToDialogFragment(new AutoUpdateDialogFragment());
    }

    private void showHome() {
        this.bottomNavigationNavigator.navigateToHome();
    }

    private void showWizard() {
        this.fragmentNavigator.navigateTo(WizardFragment.newInstance(), true);
    }

    private void watchInstalls(List<Install> list) {
        for (Install install : list) {
            this.installCompletedNotifier.add(install.getPackageName(), install.getVersionCode(), install.getMd5());
        }
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        rx.e<View.LifecycleEvent> eVarX = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.c2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(View.LifecycleEvent.CREATE.equals((View.LifecycleEvent) obj));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.r1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6951f.p((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.q2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6948f.s((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.f3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6898f.t((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.q1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6947f.u((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.a1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6871f.v((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.presenter.c3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6883f.w((View.LifecycleEvent) obj);
            }
        });
        MainView mainView = this.view;
        View.LifecycleEvent lifecycleEvent = View.LifecycleEvent.DESTROY;
        eVarX.f(mainView.bindUntilEvent(lifecycleEvent)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.d2
            @Override // rx.m.b
            public final void call(Object obj) {
                MainPresenter.lambda$present$7((View.LifecycleEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.j2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6917f.x((Throwable) obj);
            }
        });
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.presenter.m1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(View.LifecycleEvent.CREATE.equals((View.LifecycleEvent) obj));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.presenter.g2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6902f.r((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(lifecycleEvent)).H0(new rx.m.b() { // from class: cm.aptoide.pt.presenter.l2
            @Override // rx.m.b
            public final void call(Object obj) {
                MainPresenter.lambda$present$12((Integer) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.presenter.e1
            @Override // rx.m.b
            public final void call(Object obj) {
                MainPresenter.lambda$present$13((Throwable) obj);
                throw null;
            }
        });
        setupInstallErrorsDisplay();
        shortcutManagement();
        setupUpdatesNumber();
        handleAuthentication();
    }
}
