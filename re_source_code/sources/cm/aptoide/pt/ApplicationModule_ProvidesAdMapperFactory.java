package cm.aptoide.pt;

import cm.aptoide.pt.home.bundles.ads.AdMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAdMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAdMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesAdMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesAdMapperFactory(applicationModule);
    }

    public static AdMapper providesAdMapper(ApplicationModule applicationModule) {
        return (AdMapper) f.b.b.c(applicationModule.providesAdMapper());
    }

    @Override // javax.inject.Provider
    public AdMapper get() {
        return providesAdMapper(this.module);
    }
}
