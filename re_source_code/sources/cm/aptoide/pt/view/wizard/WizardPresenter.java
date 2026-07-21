package cm.aptoide.pt.view.wizard;

import androidx.viewpager.widget.ViewPager;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public class WizardPresenter implements Presenter, ViewPager.j {
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final CrashReport crashReport;
    private final WizardView view;

    public WizardPresenter(WizardView wizardView, AptoideAccountManager aptoideAccountManager, CrashReport crashReport, AccountAnalytics accountAnalytics) {
        this.view = wizardView;
        this.accountManager = aptoideAccountManager;
        this.crashReport = crashReport;
        this.accountAnalytics = accountAnalytics;
    }

    private rx.b createViewsAndButtons() {
        return this.accountManager.accountStatus().E().Z0().p(rx.l.c.a.b()).j(new rx.m.e() { // from class: cm.aptoide.pt.view.wizard.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8308f.a((Account) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createViewsAndButtons$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(Account account) {
        return this.view.createWizardAdapter(account.isLoggedIn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(View.LifecycleEvent lifecycleEvent) {
        return createViewsAndButtons().b(setupHandlers());
    }

    static /* synthetic */ void lambda$present$4(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupHandlers$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Void r1) {
        this.view.skipWizard();
    }

    private rx.e<Void> setupHandlers() {
        return this.view.skipWizardClick().j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.view.wizard.h
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8307f.d((Void) obj);
            }
        });
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrolled(int i2, float f2, int i3) {
        this.view.handleColorTransitions(i2, f2, i3);
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageSelected(int i2) {
        if (i2 == this.view.getCount() - 1) {
            this.accountAnalytics.enterAccountScreen(AccountAnalytics.AccountOrigins.WIZARD);
        }
        this.view.handleSelectedPage(i2);
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.wizard.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.wizard.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8306f.b((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.wizard.f
            @Override // rx.m.b
            public final void call(Object obj) {
                WizardPresenter.lambda$present$4((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.wizard.j
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8309f.c((Throwable) obj);
            }
        });
    }
}
