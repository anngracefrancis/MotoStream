package cm.aptoide.pt;

import cm.aptoide.pt.database.RoomInstallationMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesRoomInstallationMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesRoomInstallationMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesRoomInstallationMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesRoomInstallationMapperFactory(applicationModule);
    }

    public static RoomInstallationMapper providesRoomInstallationMapper(ApplicationModule applicationModule) {
        return (RoomInstallationMapper) f.b.b.c(applicationModule.providesRoomInstallationMapper());
    }

    @Override // javax.inject.Provider
    public RoomInstallationMapper get() {
        return providesRoomInstallationMapper(this.module);
    }
}
