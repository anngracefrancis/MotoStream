package cm.aptoide.pt;

import cm.aptoide.pt.install.AppInstallerStatusReceiver;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppInstallerStatusReceiverFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppInstallerStatusReceiverFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesAppInstallerStatusReceiverFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesAppInstallerStatusReceiverFactory(applicationModule);
    }

    public static AppInstallerStatusReceiver providesAppInstallerStatusReceiver(ApplicationModule applicationModule) {
        return (AppInstallerStatusReceiver) f.b.b.c(applicationModule.providesAppInstallerStatusReceiver());
    }

    @Override // javax.inject.Provider
    public AppInstallerStatusReceiver get() {
        return providesAppInstallerStatusReceiver(this.module);
    }
}
