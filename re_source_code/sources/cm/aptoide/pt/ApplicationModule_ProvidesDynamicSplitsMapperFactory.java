package cm.aptoide.pt;

import cm.aptoide.pt.aab.DynamicSplitsMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesDynamicSplitsMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesDynamicSplitsMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesDynamicSplitsMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesDynamicSplitsMapperFactory(applicationModule);
    }

    public static DynamicSplitsMapper providesDynamicSplitsMapper(ApplicationModule applicationModule) {
        return (DynamicSplitsMapper) f.b.b.c(applicationModule.providesDynamicSplitsMapper());
    }

    @Override // javax.inject.Provider
    public DynamicSplitsMapper get() {
        return providesDynamicSplitsMapper(this.module);
    }
}
