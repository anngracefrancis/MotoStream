package cm.aptoide.pt;

import cm.aptoide.pt.download.Md5Comparator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesMd5ComparatorFactory implements Provider {
    private final Provider<String> cachePathProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesMd5ComparatorFactory(ApplicationModule applicationModule, Provider<String> provider) {
        this.module = applicationModule;
        this.cachePathProvider = provider;
    }

    public static ApplicationModule_ProvidesMd5ComparatorFactory create(ApplicationModule applicationModule, Provider<String> provider) {
        return new ApplicationModule_ProvidesMd5ComparatorFactory(applicationModule, provider);
    }

    public static Md5Comparator providesMd5Comparator(ApplicationModule applicationModule, String str) {
        return (Md5Comparator) f.b.b.c(applicationModule.providesMd5Comparator(str));
    }

    @Override // javax.inject.Provider
    public Md5Comparator get() {
        return providesMd5Comparator(this.module, this.cachePathProvider.get());
    }
}
