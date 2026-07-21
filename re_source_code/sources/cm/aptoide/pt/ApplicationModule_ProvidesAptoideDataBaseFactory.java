package cm.aptoide.pt;

import cm.aptoide.pt.database.room.AptoideDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAptoideDataBaseFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<RoomMigrationProvider> roomMigrationProvider;

    public ApplicationModule_ProvidesAptoideDataBaseFactory(ApplicationModule applicationModule, Provider<RoomMigrationProvider> provider) {
        this.module = applicationModule;
        this.roomMigrationProvider = provider;
    }

    public static ApplicationModule_ProvidesAptoideDataBaseFactory create(ApplicationModule applicationModule, Provider<RoomMigrationProvider> provider) {
        return new ApplicationModule_ProvidesAptoideDataBaseFactory(applicationModule, provider);
    }

    public static AptoideDatabase providesAptoideDataBase(ApplicationModule applicationModule, RoomMigrationProvider roomMigrationProvider) {
        return (AptoideDatabase) f.b.b.c(applicationModule.providesAptoideDataBase(roomMigrationProvider));
    }

    @Override // javax.inject.Provider
    public AptoideDatabase get() {
        return providesAptoideDataBase(this.module, this.roomMigrationProvider.get());
    }
}
