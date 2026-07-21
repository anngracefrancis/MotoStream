package cm.aptoide.pt;

import cm.aptoide.pt.abtesting.ABTestService;
import cm.aptoide.pt.abtesting.ABTestServiceProvider;
import cm.aptoide.pt.networking.IdsRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesABTestServiceFactory implements Provider {
    private final Provider<ABTestServiceProvider> abTestServiceProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesABTestServiceFactory(ApplicationModule applicationModule, Provider<ABTestServiceProvider> provider, Provider<IdsRepository> provider2) {
        this.module = applicationModule;
        this.abTestServiceProvider = provider;
        this.idsRepositoryProvider = provider2;
    }

    public static ApplicationModule_ProvidesABTestServiceFactory create(ApplicationModule applicationModule, Provider<ABTestServiceProvider> provider, Provider<IdsRepository> provider2) {
        return new ApplicationModule_ProvidesABTestServiceFactory(applicationModule, provider, provider2);
    }

    public static ABTestService providesABTestService(ApplicationModule applicationModule, ABTestServiceProvider aBTestServiceProvider, IdsRepository idsRepository) {
        return (ABTestService) f.b.b.c(applicationModule.providesABTestService(aBTestServiceProvider, idsRepository));
    }

    @Override // javax.inject.Provider
    public ABTestService get() {
        return providesABTestService(this.module, this.abTestServiceProvider.get(), this.idsRepositoryProvider.get());
    }
}
