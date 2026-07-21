package cm.aptoide.pt;

import cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider;
import cm.aptoide.pt.install.PackageRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAdsApplicationVersionCodeProviderFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<PackageRepository> packageRepositoryProvider;

    public ApplicationModule_ProvidesAdsApplicationVersionCodeProviderFactory(ApplicationModule applicationModule, Provider<PackageRepository> provider) {
        this.module = applicationModule;
        this.packageRepositoryProvider = provider;
    }

    public static ApplicationModule_ProvidesAdsApplicationVersionCodeProviderFactory create(ApplicationModule applicationModule, Provider<PackageRepository> provider) {
        return new ApplicationModule_ProvidesAdsApplicationVersionCodeProviderFactory(applicationModule, provider);
    }

    public static AdsApplicationVersionCodeProvider providesAdsApplicationVersionCodeProvider(ApplicationModule applicationModule, PackageRepository packageRepository) {
        return (AdsApplicationVersionCodeProvider) f.b.b.c(applicationModule.providesAdsApplicationVersionCodeProvider(packageRepository));
    }

    @Override // javax.inject.Provider
    public AdsApplicationVersionCodeProvider get() {
        return providesAdsApplicationVersionCodeProvider(this.module, this.packageRepositoryProvider.get());
    }
}
