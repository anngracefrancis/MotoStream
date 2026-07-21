package cm.aptoide.pt;

import cm.aptoide.pt.database.RoomInstallationMapper;
import cm.aptoide.pt.database.RoomInstallationPersistence;
import cm.aptoide.pt.database.RoomInstalledPersistence;
import cm.aptoide.pt.database.room.AptoideDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideRoomInstalledPersistenceFactory implements Provider {
    private final Provider<AptoideDatabase> databaseProvider;
    private final ApplicationModule module;
    private final Provider<RoomInstallationMapper> roomInstallationMapperProvider;
    private final Provider<RoomInstallationPersistence> roomInstallationPersistenceProvider;

    public ApplicationModule_ProvideRoomInstalledPersistenceFactory(ApplicationModule applicationModule, Provider<AptoideDatabase> provider, Provider<RoomInstallationPersistence> provider2, Provider<RoomInstallationMapper> provider3) {
        this.module = applicationModule;
        this.databaseProvider = provider;
        this.roomInstallationPersistenceProvider = provider2;
        this.roomInstallationMapperProvider = provider3;
    }

    public static ApplicationModule_ProvideRoomInstalledPersistenceFactory create(ApplicationModule applicationModule, Provider<AptoideDatabase> provider, Provider<RoomInstallationPersistence> provider2, Provider<RoomInstallationMapper> provider3) {
        return new ApplicationModule_ProvideRoomInstalledPersistenceFactory(applicationModule, provider, provider2, provider3);
    }

    public static RoomInstalledPersistence provideRoomInstalledPersistence(ApplicationModule applicationModule, AptoideDatabase aptoideDatabase, RoomInstallationPersistence roomInstallationPersistence, RoomInstallationMapper roomInstallationMapper) {
        return (RoomInstalledPersistence) f.b.b.c(applicationModule.provideRoomInstalledPersistence(aptoideDatabase, roomInstallationPersistence, roomInstallationMapper));
    }

    @Override // javax.inject.Provider
    public RoomInstalledPersistence get() {
        return provideRoomInstalledPersistence(this.module, this.databaseProvider.get(), this.roomInstallationPersistenceProvider.get(), this.roomInstallationMapperProvider.get());
    }
}
