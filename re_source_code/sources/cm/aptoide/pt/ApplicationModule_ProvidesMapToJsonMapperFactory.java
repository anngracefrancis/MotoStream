package cm.aptoide.pt;

import cm.aptoide.analytics.implementation.utils.MapToJsonMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesMapToJsonMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesMapToJsonMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesMapToJsonMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesMapToJsonMapperFactory(applicationModule);
    }

    public static MapToJsonMapper providesMapToJsonMapper(ApplicationModule applicationModule) {
        return (MapToJsonMapper) f.b.b.c(applicationModule.providesMapToJsonMapper());
    }

    @Override // javax.inject.Provider
    public MapToJsonMapper get() {
        return providesMapToJsonMapper(this.module);
    }
}
