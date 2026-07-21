package cm.aptoide.pt.view;

import cm.aptoide.pt.autoupdate.AutoUpdateDialogPresenter;
import cm.aptoide.pt.autoupdate.AutoUpdateManager;
import cm.aptoide.pt.crashreports.CrashReport;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesAutoUpdateDialogPresenterFactory implements Provider {
    private final Provider<AutoUpdateManager> autoUpdateManagerProvider;
    private final Provider<CrashReport> crashReporterProvider;
    private final FragmentModule module;

    public FragmentModule_ProvidesAutoUpdateDialogPresenterFactory(FragmentModule fragmentModule, Provider<CrashReport> provider, Provider<AutoUpdateManager> provider2) {
        this.module = fragmentModule;
        this.crashReporterProvider = provider;
        this.autoUpdateManagerProvider = provider2;
    }

    public static FragmentModule_ProvidesAutoUpdateDialogPresenterFactory create(FragmentModule fragmentModule, Provider<CrashReport> provider, Provider<AutoUpdateManager> provider2) {
        return new FragmentModule_ProvidesAutoUpdateDialogPresenterFactory(fragmentModule, provider, provider2);
    }

    public static AutoUpdateDialogPresenter providesAutoUpdateDialogPresenter(FragmentModule fragmentModule, CrashReport crashReport, AutoUpdateManager autoUpdateManager) {
        return (AutoUpdateDialogPresenter) f.b.b.c(fragmentModule.providesAutoUpdateDialogPresenter(crashReport, autoUpdateManager));
    }

    @Override // javax.inject.Provider
    public AutoUpdateDialogPresenter get() {
        return providesAutoUpdateDialogPresenter(this.module, this.crashReporterProvider.get(), this.autoUpdateManagerProvider.get());
    }
}
