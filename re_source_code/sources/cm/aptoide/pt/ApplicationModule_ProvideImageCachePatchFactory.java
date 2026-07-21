package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideImageCachePatchFactory implements Provider {
    private final Provider<String> cachePathProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideImageCachePatchFactory(ApplicationModule applicationModule, Provider<String> provider) {
        this.module = applicationModule;
        this.cachePathProvider = provider;
    }

    public static ApplicationModule_ProvideImageCachePatchFactory create(ApplicationModule applicationModule, Provider<String> provider) {
        return new ApplicationModule_ProvideImageCachePatchFactory(applicationModule, provider);
    }

    public static String provideImageCachePatch(ApplicationModule applicationModule, String str) {
        return (String) f.b.b.c(applicationModule.provideImageCachePatch(str));
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideImageCachePatch(this.module, this.cachePathProvider.get());
    }
}
