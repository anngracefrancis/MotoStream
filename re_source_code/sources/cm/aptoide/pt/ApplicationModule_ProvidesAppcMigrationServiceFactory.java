package cm.aptoide.pt;

import cm.aptoide.pt.app.migration.AppcMigrationPersistence;
import cm.aptoide.pt.app.migration.AppcMigrationRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppcMigrationServiceFactory implements Provider {
    private final Provider<AppcMigrationPersistence> appcMigrationPersistenceProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppcMigrationServiceFactory(ApplicationModule applicationModule, Provider<AppcMigrationPersistence> provider) {
        this.module = applicationModule;
        this.appcMigrationPersistenceProvider = provider;
    }

    public static ApplicationModule_ProvidesAppcMigrationServiceFactory create(ApplicationModule applicationModule, Provider<AppcMigrationPersistence> provider) {
        return new ApplicationModule_ProvidesAppcMigrationServiceFactory(applicationModule, provider);
    }

    public static AppcMigrationRepository providesAppcMigrationService(ApplicationModule applicationModule, AppcMigrationPersistence appcMigrationPersistence) {
        return (AppcMigrationRepository) f.b.b.c(applicationModule.providesAppcMigrationService(appcMigrationPersistence));
    }

    @Override // javax.inject.Provider
    public AppcMigrationRepository get() {
        return providesAppcMigrationService(this.module, this.appcMigrationPersistenceProvider.get());
    }
}
