package cm.aptoide.pt;

import cm.aptoide.pt.database.room.AptoideDatabase;
import cm.aptoide.pt.updates.UpdatePersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesUpdatePersistenceFactory implements Provider {
    private final Provider<AptoideDatabase> databaseProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesUpdatePersistenceFactory(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        this.module = applicationModule;
        this.databaseProvider = provider;
    }

    public static ApplicationModule_ProvidesUpdatePersistenceFactory create(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        return new ApplicationModule_ProvidesUpdatePersistenceFactory(applicationModule, provider);
    }

    public static UpdatePersistence providesUpdatePersistence(ApplicationModule applicationModule, AptoideDatabase aptoideDatabase) {
        return (UpdatePersistence) f.b.b.c(applicationModule.providesUpdatePersistence(aptoideDatabase));
    }

    @Override // javax.inject.Provider
    public UpdatePersistence get() {
        return providesUpdatePersistence(this.module, this.databaseProvider.get());
    }
}
