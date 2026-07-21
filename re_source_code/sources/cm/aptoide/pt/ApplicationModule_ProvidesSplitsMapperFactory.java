package cm.aptoide.pt;

import cm.aptoide.pt.aab.SplitsMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesSplitsMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesSplitsMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesSplitsMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesSplitsMapperFactory(applicationModule);
    }

    public static SplitsMapper providesSplitsMapper(ApplicationModule applicationModule) {
        return (SplitsMapper) f.b.b.c(applicationModule.providesSplitsMapper());
    }

    @Override // javax.inject.Provider
    public SplitsMapper get() {
        return providesSplitsMapper(this.module);
    }
}
