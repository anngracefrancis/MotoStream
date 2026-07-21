package cm.aptoide.pt;

import cm.aptoide.pt.database.room.AptoideDatabase;
import cm.aptoide.pt.store.StorePersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesStorePersistenceFactory implements Provider {
    private final Provider<AptoideDatabase> aptoideDatabaseProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesStorePersistenceFactory(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        this.module = applicationModule;
        this.aptoideDatabaseProvider = provider;
    }

    public static ApplicationModule_ProvidesStorePersistenceFactory create(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        return new ApplicationModule_ProvidesStorePersistenceFactory(applicationModule, provider);
    }

    public static StorePersistence providesStorePersistence(ApplicationModule applicationModule, AptoideDatabase aptoideDatabase) {
        return (StorePersistence) f.b.b.c(applicationModule.providesStorePersistence(aptoideDatabase));
    }

    @Override // javax.inject.Provider
    public StorePersistence get() {
        return providesStorePersistence(this.module, this.aptoideDatabaseProvider.get());
    }
}
