package cm.aptoide.pt;

import cm.aptoide.pt.database.room.AptoideDatabase;
import cm.aptoide.pt.home.AppComingSoonRegistrationPersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppComingSoonRegistrationPersistenceFactory implements Provider {
    private final Provider<AptoideDatabase> databaseProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppComingSoonRegistrationPersistenceFactory(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        this.module = applicationModule;
        this.databaseProvider = provider;
    }

    public static ApplicationModule_ProvidesAppComingSoonRegistrationPersistenceFactory create(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        return new ApplicationModule_ProvidesAppComingSoonRegistrationPersistenceFactory(applicationModule, provider);
    }

    public static AppComingSoonRegistrationPersistence providesAppComingSoonRegistrationPersistence(ApplicationModule applicationModule, AptoideDatabase aptoideDatabase) {
        return (AppComingSoonRegistrationPersistence) f.b.b.c(applicationModule.providesAppComingSoonRegistrationPersistence(aptoideDatabase));
    }

    @Override // javax.inject.Provider
    public AppComingSoonRegistrationPersistence get() {
        return providesAppComingSoonRegistrationPersistence(this.module, this.databaseProvider.get());
    }
}
