package cm.aptoide.pt;

import cm.aptoide.pt.account.DatabaseStoreDataPersist;
import cm.aptoide.pt.store.RoomStoreRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesDatabaseStoreDataPersistFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<RoomStoreRepository> storeRepositoryProvider;

    public ApplicationModule_ProvidesDatabaseStoreDataPersistFactory(ApplicationModule applicationModule, Provider<RoomStoreRepository> provider) {
        this.module = applicationModule;
        this.storeRepositoryProvider = provider;
    }

    public static ApplicationModule_ProvidesDatabaseStoreDataPersistFactory create(ApplicationModule applicationModule, Provider<RoomStoreRepository> provider) {
        return new ApplicationModule_ProvidesDatabaseStoreDataPersistFactory(applicationModule, provider);
    }

    public static DatabaseStoreDataPersist providesDatabaseStoreDataPersist(ApplicationModule applicationModule, RoomStoreRepository roomStoreRepository) {
        return (DatabaseStoreDataPersist) f.b.b.c(applicationModule.providesDatabaseStoreDataPersist(roomStoreRepository));
    }

    @Override // javax.inject.Provider
    public DatabaseStoreDataPersist get() {
        return providesDatabaseStoreDataPersist(this.module, this.storeRepositoryProvider.get());
    }
}
