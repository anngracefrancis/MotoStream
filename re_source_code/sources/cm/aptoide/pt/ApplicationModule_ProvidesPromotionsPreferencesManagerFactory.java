package cm.aptoide.pt;

import cm.aptoide.pt.appview.PreferencesPersister;
import cm.aptoide.pt.promotions.PromotionsPreferencesManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesPromotionsPreferencesManagerFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<PreferencesPersister> persisterProvider;

    public ApplicationModule_ProvidesPromotionsPreferencesManagerFactory(ApplicationModule applicationModule, Provider<PreferencesPersister> provider) {
        this.module = applicationModule;
        this.persisterProvider = provider;
    }

    public static ApplicationModule_ProvidesPromotionsPreferencesManagerFactory create(ApplicationModule applicationModule, Provider<PreferencesPersister> provider) {
        return new ApplicationModule_ProvidesPromotionsPreferencesManagerFactory(applicationModule, provider);
    }

    public static PromotionsPreferencesManager providesPromotionsPreferencesManager(ApplicationModule applicationModule, PreferencesPersister preferencesPersister) {
        return (PromotionsPreferencesManager) f.b.b.c(applicationModule.providesPromotionsPreferencesManager(preferencesPersister));
    }

    @Override // javax.inject.Provider
    public PromotionsPreferencesManager get() {
        return providesPromotionsPreferencesManager(this.module, this.persisterProvider.get());
    }
}
