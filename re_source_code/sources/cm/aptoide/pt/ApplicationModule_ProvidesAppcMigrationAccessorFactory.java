package cm.aptoide.pt;

import cm.aptoide.pt.app.migration.AppcMigrationPersistence;
import cm.aptoide.pt.database.room.AptoideDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppcMigrationAccessorFactory implements Provider {
    private final Provider<AptoideDatabase> databaseProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppcMigrationAccessorFactory(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        this.module = applicationModule;
        this.databaseProvider = provider;
    }

    public static ApplicationModule_ProvidesAppcMigrationAccessorFactory create(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        return new ApplicationModule_ProvidesAppcMigrationAccessorFactory(applicationModule, provider);
    }

    public static AppcMigrationPersistence providesAppcMigrationAccessor(ApplicationModule applicationModule, AptoideDatabase aptoideDatabase) {
        return (AppcMigrationPersistence) f.b.b.c(applicationModule.providesAppcMigrationAccessor(aptoideDatabase));
    }

    @Override // javax.inject.Provider
    public AppcMigrationPersistence get() {
        return providesAppcMigrationAccessor(this.module, this.databaseProvider.get());
    }
}
