package cm.aptoide.pt;

import cm.aptoide.pt.home.AppComingSoonRegistrationManager;
import cm.aptoide.pt.home.AppComingSoonRegistrationPersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppComingSoonPreferencesManagerFactory implements Provider {
    private final Provider<AppComingSoonRegistrationPersistence> appComingSoonRegistrationPersistenceProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppComingSoonPreferencesManagerFactory(ApplicationModule applicationModule, Provider<AppComingSoonRegistrationPersistence> provider) {
        this.module = applicationModule;
        this.appComingSoonRegistrationPersistenceProvider = provider;
    }

    public static ApplicationModule_ProvidesAppComingSoonPreferencesManagerFactory create(ApplicationModule applicationModule, Provider<AppComingSoonRegistrationPersistence> provider) {
        return new ApplicationModule_ProvidesAppComingSoonPreferencesManagerFactory(applicationModule, provider);
    }

    public static AppComingSoonRegistrationManager providesAppComingSoonPreferencesManager(ApplicationModule applicationModule, AppComingSoonRegistrationPersistence appComingSoonRegistrationPersistence) {
        return (AppComingSoonRegistrationManager) f.b.b.c(applicationModule.providesAppComingSoonPreferencesManager(appComingSoonRegistrationPersistence));
    }

    @Override // javax.inject.Provider
    public AppComingSoonRegistrationManager get() {
        return providesAppComingSoonPreferencesManager(this.module, this.appComingSoonRegistrationPersistenceProvider.get());
    }
}
