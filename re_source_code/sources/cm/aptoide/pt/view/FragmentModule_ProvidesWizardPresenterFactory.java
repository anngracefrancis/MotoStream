package cm.aptoide.pt.view;

import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.view.wizard.WizardPresenter;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesWizardPresenterFactory implements Provider {
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<AptoideAccountManager> aptoideAccountManagerProvider;
    private final Provider<CrashReport> crashReportProvider;
    private final FragmentModule module;

    public FragmentModule_ProvidesWizardPresenterFactory(FragmentModule fragmentModule, Provider<AptoideAccountManager> provider, Provider<CrashReport> provider2, Provider<AccountAnalytics> provider3) {
        this.module = fragmentModule;
        this.aptoideAccountManagerProvider = provider;
        this.crashReportProvider = provider2;
        this.accountAnalyticsProvider = provider3;
    }

    public static FragmentModule_ProvidesWizardPresenterFactory create(FragmentModule fragmentModule, Provider<AptoideAccountManager> provider, Provider<CrashReport> provider2, Provider<AccountAnalytics> provider3) {
        return new FragmentModule_ProvidesWizardPresenterFactory(fragmentModule, provider, provider2, provider3);
    }

    public static WizardPresenter providesWizardPresenter(FragmentModule fragmentModule, AptoideAccountManager aptoideAccountManager, CrashReport crashReport, AccountAnalytics accountAnalytics) {
        return (WizardPresenter) f.b.b.c(fragmentModule.providesWizardPresenter(aptoideAccountManager, crashReport, accountAnalytics));
    }

    @Override // javax.inject.Provider
    public WizardPresenter get() {
        return providesWizardPresenter(this.module, this.aptoideAccountManagerProvider.get(), this.crashReportProvider.get(), this.accountAnalyticsProvider.get());
    }
}
