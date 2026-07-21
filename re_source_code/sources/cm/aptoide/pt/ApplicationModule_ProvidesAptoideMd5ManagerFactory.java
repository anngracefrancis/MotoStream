package cm.aptoide.pt;

import cm.aptoide.pt.appview.PreferencesPersister;
import cm.aptoide.pt.preferences.AptoideMd5Manager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAptoideMd5ManagerFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<PreferencesPersister> preferencesPersisterProvider;

    public ApplicationModule_ProvidesAptoideMd5ManagerFactory(ApplicationModule applicationModule, Provider<PreferencesPersister> provider) {
        this.module = applicationModule;
        this.preferencesPersisterProvider = provider;
    }

    public static ApplicationModule_ProvidesAptoideMd5ManagerFactory create(ApplicationModule applicationModule, Provider<PreferencesPersister> provider) {
        return new ApplicationModule_ProvidesAptoideMd5ManagerFactory(applicationModule, provider);
    }

    public static AptoideMd5Manager providesAptoideMd5Manager(ApplicationModule applicationModule, PreferencesPersister preferencesPersister) {
        return (AptoideMd5Manager) f.b.b.c(applicationModule.providesAptoideMd5Manager(preferencesPersister));
    }

    @Override // javax.inject.Provider
    public AptoideMd5Manager get() {
        return providesAptoideMd5Manager(this.module, this.preferencesPersisterProvider.get());
    }
}
