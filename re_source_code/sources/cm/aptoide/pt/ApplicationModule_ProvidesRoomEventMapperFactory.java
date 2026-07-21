package cm.aptoide.pt;

import cm.aptoide.pt.database.RoomEventMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesRoomEventMapperFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<ObjectMapper> objectMapperProvider;

    public ApplicationModule_ProvidesRoomEventMapperFactory(ApplicationModule applicationModule, Provider<ObjectMapper> provider) {
        this.module = applicationModule;
        this.objectMapperProvider = provider;
    }

    public static ApplicationModule_ProvidesRoomEventMapperFactory create(ApplicationModule applicationModule, Provider<ObjectMapper> provider) {
        return new ApplicationModule_ProvidesRoomEventMapperFactory(applicationModule, provider);
    }

    public static RoomEventMapper providesRoomEventMapper(ApplicationModule applicationModule, ObjectMapper objectMapper) {
        return (RoomEventMapper) f.b.b.c(applicationModule.providesRoomEventMapper(objectMapper));
    }

    @Override // javax.inject.Provider
    public RoomEventMapper get() {
        return providesRoomEventMapper(this.module, this.objectMapperProvider.get());
    }
}
