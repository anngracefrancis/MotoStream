package cm.aptoide.pt;

import cm.aptoide.pt.database.RoomEventMapper;
import cm.aptoide.pt.database.RoomEventPersistence;
import cm.aptoide.pt.database.room.AptoideDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesRoomEventPersistenceFactory implements Provider {
    private final Provider<AptoideDatabase> aptoideDatabaseProvider;
    private final ApplicationModule module;
    private final Provider<RoomEventMapper> roomEventMapperProvider;

    public ApplicationModule_ProvidesRoomEventPersistenceFactory(ApplicationModule applicationModule, Provider<AptoideDatabase> provider, Provider<RoomEventMapper> provider2) {
        this.module = applicationModule;
        this.aptoideDatabaseProvider = provider;
        this.roomEventMapperProvider = provider2;
    }

    public static ApplicationModule_ProvidesRoomEventPersistenceFactory create(ApplicationModule applicationModule, Provider<AptoideDatabase> provider, Provider<RoomEventMapper> provider2) {
        return new ApplicationModule_ProvidesRoomEventPersistenceFactory(applicationModule, provider, provider2);
    }

    public static RoomEventPersistence providesRoomEventPersistence(ApplicationModule applicationModule, AptoideDatabase aptoideDatabase, RoomEventMapper roomEventMapper) {
        return (RoomEventPersistence) f.b.b.c(applicationModule.providesRoomEventPersistence(aptoideDatabase, roomEventMapper));
    }

    @Override // javax.inject.Provider
    public RoomEventPersistence get() {
        return providesRoomEventPersistence(this.module, this.aptoideDatabaseProvider.get(), this.roomEventMapperProvider.get());
    }
}
