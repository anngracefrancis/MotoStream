package cm.aptoide.pt;

import cm.aptoide.pt.database.room.AptoideDatabase;
import cm.aptoide.pt.install.AptoideInstallPersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAptoideInstallPersistenceFactory implements Provider {
    private final Provider<AptoideDatabase> databaseProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAptoideInstallPersistenceFactory(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        this.module = applicationModule;
        this.databaseProvider = provider;
    }

    public static ApplicationModule_ProvidesAptoideInstallPersistenceFactory create(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        return new ApplicationModule_ProvidesAptoideInstallPersistenceFactory(applicationModule, provider);
    }

    public static AptoideInstallPersistence providesAptoideInstallPersistence(ApplicationModule applicationModule, AptoideDatabase aptoideDatabase) {
        return (AptoideInstallPersistence) f.b.b.c(applicationModule.providesAptoideInstallPersistence(aptoideDatabase));
    }

    @Override // javax.inject.Provider
    public AptoideInstallPersistence get() {
        return providesAptoideInstallPersistence(this.module, this.databaseProvider.get());
    }
}
