package cm.aptoide.pt;

import cm.aptoide.pt.database.RoomStoredMinimalAdPersistence;
import cm.aptoide.pt.database.room.AptoideDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesRoomStoreMinimalAdPersistenceFactory implements Provider {
    private final Provider<AptoideDatabase> databaseProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesRoomStoreMinimalAdPersistenceFactory(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        this.module = applicationModule;
        this.databaseProvider = provider;
    }

    public static ApplicationModule_ProvidesRoomStoreMinimalAdPersistenceFactory create(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        return new ApplicationModule_ProvidesRoomStoreMinimalAdPersistenceFactory(applicationModule, provider);
    }

    public static RoomStoredMinimalAdPersistence providesRoomStoreMinimalAdPersistence(ApplicationModule applicationModule, AptoideDatabase aptoideDatabase) {
        return (RoomStoredMinimalAdPersistence) f.b.b.c(applicationModule.providesRoomStoreMinimalAdPersistence(aptoideDatabase));
    }

    @Override // javax.inject.Provider
    public RoomStoredMinimalAdPersistence get() {
        return providesRoomStoreMinimalAdPersistence(this.module, this.databaseProvider.get());
    }
}
