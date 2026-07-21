package cm.aptoide.pt;

import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.notification.ReadyToInstallNotificationManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesReadyToInstallNotificationManagerFactory implements Provider {
    private final Provider<InstallManager> installManagerProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesReadyToInstallNotificationManagerFactory(ApplicationModule applicationModule, Provider<InstallManager> provider) {
        this.module = applicationModule;
        this.installManagerProvider = provider;
    }

    public static ApplicationModule_ProvidesReadyToInstallNotificationManagerFactory create(ApplicationModule applicationModule, Provider<InstallManager> provider) {
        return new ApplicationModule_ProvidesReadyToInstallNotificationManagerFactory(applicationModule, provider);
    }

    public static ReadyToInstallNotificationManager providesReadyToInstallNotificationManager(ApplicationModule applicationModule, InstallManager installManager) {
        return (ReadyToInstallNotificationManager) f.b.b.c(applicationModule.providesReadyToInstallNotificationManager(installManager));
    }

    @Override // javax.inject.Provider
    public ReadyToInstallNotificationManager get() {
        return providesReadyToInstallNotificationManager(this.module, this.installManagerProvider.get());
    }
}
