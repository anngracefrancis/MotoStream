package cm.aptoide.pt;

import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.install.installer.RootInstallationRetryHandler;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideRootInstallationRetryHandlerFactory implements Provider {
    private final Provider<InstallManager> installManagerProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideRootInstallationRetryHandlerFactory(ApplicationModule applicationModule, Provider<InstallManager> provider) {
        this.module = applicationModule;
        this.installManagerProvider = provider;
    }

    public static ApplicationModule_ProvideRootInstallationRetryHandlerFactory create(ApplicationModule applicationModule, Provider<InstallManager> provider) {
        return new ApplicationModule_ProvideRootInstallationRetryHandlerFactory(applicationModule, provider);
    }

    public static RootInstallationRetryHandler provideRootInstallationRetryHandler(ApplicationModule applicationModule, InstallManager installManager) {
        return (RootInstallationRetryHandler) f.b.b.c(applicationModule.provideRootInstallationRetryHandler(installManager));
    }

    @Override // javax.inject.Provider
    public RootInstallationRetryHandler get() {
        return provideRootInstallationRetryHandler(this.module, this.installManagerProvider.get());
    }
}
