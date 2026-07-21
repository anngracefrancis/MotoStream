package cm.aptoide.pt;

import cm.aptoide.pt.preferences.SecurePreferences;
import cm.aptoide.pt.root.RootAvailabilityManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideRootAvailabilityManagerFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SecurePreferences> securePreferencesProvider;

    public ApplicationModule_ProvideRootAvailabilityManagerFactory(ApplicationModule applicationModule, Provider<SecurePreferences> provider) {
        this.module = applicationModule;
        this.securePreferencesProvider = provider;
    }

    public static ApplicationModule_ProvideRootAvailabilityManagerFactory create(ApplicationModule applicationModule, Provider<SecurePreferences> provider) {
        return new ApplicationModule_ProvideRootAvailabilityManagerFactory(applicationModule, provider);
    }

    public static RootAvailabilityManager provideRootAvailabilityManager(ApplicationModule applicationModule, SecurePreferences securePreferences) {
        return (RootAvailabilityManager) f.b.b.c(applicationModule.provideRootAvailabilityManager(securePreferences));
    }

    @Override // javax.inject.Provider
    public RootAvailabilityManager get() {
        return provideRootAvailabilityManager(this.module, this.securePreferencesProvider.get());
    }
}
