package cm.aptoide.pt;

import cm.aptoide.pt.app.aptoideinstall.AptoideInstallRepository;
import cm.aptoide.pt.install.AptoideInstallPersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAptoideInstallRepositoryFactory implements Provider {
    private final Provider<AptoideInstallPersistence> aptoideInstallPersistenceProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAptoideInstallRepositoryFactory(ApplicationModule applicationModule, Provider<AptoideInstallPersistence> provider) {
        this.module = applicationModule;
        this.aptoideInstallPersistenceProvider = provider;
    }

    public static ApplicationModule_ProvidesAptoideInstallRepositoryFactory create(ApplicationModule applicationModule, Provider<AptoideInstallPersistence> provider) {
        return new ApplicationModule_ProvidesAptoideInstallRepositoryFactory(applicationModule, provider);
    }

    public static AptoideInstallRepository providesAptoideInstallRepository(ApplicationModule applicationModule, AptoideInstallPersistence aptoideInstallPersistence) {
        return (AptoideInstallRepository) f.b.b.c(applicationModule.providesAptoideInstallRepository(aptoideInstallPersistence));
    }

    @Override // javax.inject.Provider
    public AptoideInstallRepository get() {
        return providesAptoideInstallRepository(this.module, this.aptoideInstallPersistenceProvider.get());
    }
}
