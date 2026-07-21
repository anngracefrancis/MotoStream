package cm.aptoide.pt;

import cm.aptoide.pt.home.AppComingSoonRegistrationManager;
import cm.aptoide.pt.notification.ComingSoonNotificationManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesComingSoonNotificationManagerFactory implements Provider {
    private final Provider<AppComingSoonRegistrationManager> appComingSoonRegistrationManagerProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesComingSoonNotificationManagerFactory(ApplicationModule applicationModule, Provider<AppComingSoonRegistrationManager> provider) {
        this.module = applicationModule;
        this.appComingSoonRegistrationManagerProvider = provider;
    }

    public static ApplicationModule_ProvidesComingSoonNotificationManagerFactory create(ApplicationModule applicationModule, Provider<AppComingSoonRegistrationManager> provider) {
        return new ApplicationModule_ProvidesComingSoonNotificationManagerFactory(applicationModule, provider);
    }

    public static ComingSoonNotificationManager providesComingSoonNotificationManager(ApplicationModule applicationModule, AppComingSoonRegistrationManager appComingSoonRegistrationManager) {
        return (ComingSoonNotificationManager) f.b.b.c(applicationModule.providesComingSoonNotificationManager(appComingSoonRegistrationManager));
    }

    @Override // javax.inject.Provider
    public ComingSoonNotificationManager get() {
        return providesComingSoonNotificationManager(this.module, this.appComingSoonRegistrationManagerProvider.get());
    }
}
