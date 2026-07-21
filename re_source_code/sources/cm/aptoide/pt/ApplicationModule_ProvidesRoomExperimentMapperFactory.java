package cm.aptoide.pt;

import cm.aptoide.pt.database.RoomExperimentMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesRoomExperimentMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesRoomExperimentMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesRoomExperimentMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesRoomExperimentMapperFactory(applicationModule);
    }

    public static RoomExperimentMapper providesRoomExperimentMapper(ApplicationModule applicationModule) {
        return (RoomExperimentMapper) f.b.b.c(applicationModule.providesRoomExperimentMapper());
    }

    @Override // javax.inject.Provider
    public RoomExperimentMapper get() {
        return providesRoomExperimentMapper(this.module);
    }
}
