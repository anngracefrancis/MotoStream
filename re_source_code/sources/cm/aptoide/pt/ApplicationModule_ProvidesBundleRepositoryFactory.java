package cm.aptoide.pt;

import cm.aptoide.pt.home.bundles.BundleDataSource;
import cm.aptoide.pt.home.bundles.BundlesRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesBundleRepositoryFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<BundleDataSource> remoteBundleDataSourceProvider;

    public ApplicationModule_ProvidesBundleRepositoryFactory(ApplicationModule applicationModule, Provider<BundleDataSource> provider) {
        this.module = applicationModule;
        this.remoteBundleDataSourceProvider = provider;
    }

    public static ApplicationModule_ProvidesBundleRepositoryFactory create(ApplicationModule applicationModule, Provider<BundleDataSource> provider) {
        return new ApplicationModule_ProvidesBundleRepositoryFactory(applicationModule, provider);
    }

    public static BundlesRepository providesBundleRepository(ApplicationModule applicationModule, BundleDataSource bundleDataSource) {
        return (BundlesRepository) f.b.b.c(applicationModule.providesBundleRepository(bundleDataSource));
    }

    @Override // javax.inject.Provider
    public BundlesRepository get() {
        return providesBundleRepository(this.module, this.remoteBundleDataSourceProvider.get());
    }
}
