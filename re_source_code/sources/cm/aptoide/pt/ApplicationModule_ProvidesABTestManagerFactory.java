package cm.aptoide.pt;

import cm.aptoide.pt.abtesting.ABTestCenterRepository;
import cm.aptoide.pt.abtesting.ABTestManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesABTestManagerFactory implements Provider {
    private final Provider<ABTestCenterRepository> abTestCenterRepositoryProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesABTestManagerFactory(ApplicationModule applicationModule, Provider<ABTestCenterRepository> provider) {
        this.module = applicationModule;
        this.abTestCenterRepositoryProvider = provider;
    }

    public static ApplicationModule_ProvidesABTestManagerFactory create(ApplicationModule applicationModule, Provider<ABTestCenterRepository> provider) {
        return new ApplicationModule_ProvidesABTestManagerFactory(applicationModule, provider);
    }

    public static ABTestManager providesABTestManager(ApplicationModule applicationModule, ABTestCenterRepository aBTestCenterRepository) {
        return (ABTestManager) f.b.b.c(applicationModule.providesABTestManager(aBTestCenterRepository));
    }

    @Override // javax.inject.Provider
    public ABTestManager get() {
        return providesABTestManager(this.module, this.abTestCenterRepositoryProvider.get());
    }
}
