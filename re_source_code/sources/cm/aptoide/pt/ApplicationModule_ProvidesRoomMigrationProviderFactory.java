package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesRoomMigrationProviderFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesRoomMigrationProviderFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesRoomMigrationProviderFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesRoomMigrationProviderFactory(applicationModule);
    }

    public static RoomMigrationProvider providesRoomMigrationProvider(ApplicationModule applicationModule) {
        return (RoomMigrationProvider) f.b.b.c(applicationModule.providesRoomMigrationProvider());
    }

    @Override // javax.inject.Provider
    public RoomMigrationProvider get() {
        return providesRoomMigrationProvider(this.module);
    }
}
