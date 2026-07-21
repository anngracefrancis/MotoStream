package cm.aptoide.pt;

import cm.aptoide.pt.blacklist.BlacklistUnitMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory(applicationModule);
    }

    public static BlacklistUnitMapper providesBundleToBlacklistUnitMapper(ApplicationModule applicationModule) {
        return (BlacklistUnitMapper) f.b.b.c(applicationModule.providesBundleToBlacklistUnitMapper());
    }

    @Override // javax.inject.Provider
    public BlacklistUnitMapper get() {
        return providesBundleToBlacklistUnitMapper(this.module);
    }
}
