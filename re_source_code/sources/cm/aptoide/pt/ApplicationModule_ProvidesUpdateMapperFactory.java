package cm.aptoide.pt;

import cm.aptoide.pt.updates.UpdateMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesUpdateMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesUpdateMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesUpdateMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesUpdateMapperFactory(applicationModule);
    }

    public static UpdateMapper providesUpdateMapper(ApplicationModule applicationModule) {
        return (UpdateMapper) f.b.b.c(applicationModule.providesUpdateMapper());
    }

    @Override // javax.inject.Provider
    public UpdateMapper get() {
        return providesUpdateMapper(this.module);
    }
}
