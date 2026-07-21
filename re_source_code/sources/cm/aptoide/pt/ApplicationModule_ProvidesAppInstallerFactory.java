package cm.aptoide.pt;

import cm.aptoide.pt.install.AppInstallerStatusReceiver;
import cm.aptoide.pt.packageinstaller.AppInstaller;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppInstallerFactory implements Provider {
    private final Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppInstallerFactory(ApplicationModule applicationModule, Provider<AppInstallerStatusReceiver> provider) {
        this.module = applicationModule;
        this.appInstallerStatusReceiverProvider = provider;
    }

    public static ApplicationModule_ProvidesAppInstallerFactory create(ApplicationModule applicationModule, Provider<AppInstallerStatusReceiver> provider) {
        return new ApplicationModule_ProvidesAppInstallerFactory(applicationModule, provider);
    }

    public static AppInstaller providesAppInstaller(ApplicationModule applicationModule, AppInstallerStatusReceiver appInstallerStatusReceiver) {
        return (AppInstaller) f.b.b.c(applicationModule.providesAppInstaller(appInstallerStatusReceiver));
    }

    @Override // javax.inject.Provider
    public AppInstaller get() {
        return providesAppInstaller(this.module, this.appInstallerStatusReceiverProvider.get());
    }
}
