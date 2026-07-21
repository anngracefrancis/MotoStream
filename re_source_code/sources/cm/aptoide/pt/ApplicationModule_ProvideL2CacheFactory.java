package cm.aptoide.pt;

import cm.aptoide.pt.dataprovider.cache.L2Cache;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideL2CacheFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideL2CacheFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideL2CacheFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideL2CacheFactory(applicationModule);
    }

    public static L2Cache provideL2Cache(ApplicationModule applicationModule) {
        return (L2Cache) f.b.b.c(applicationModule.provideL2Cache());
    }

    @Override // javax.inject.Provider
    public L2Cache get() {
        return provideL2Cache(this.module);
    }
}
