package cm.aptoide.pt;

import cm.aptoide.pt.aab.DynamicSplitsManager;
import cm.aptoide.pt.aab.DynamicSplitsService;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesDynamicSplitsManagerFactory implements Provider {
    private final Provider<DynamicSplitsService> dynamicSplitsServiceProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesDynamicSplitsManagerFactory(ApplicationModule applicationModule, Provider<DynamicSplitsService> provider) {
        this.module = applicationModule;
        this.dynamicSplitsServiceProvider = provider;
    }

    public static ApplicationModule_ProvidesDynamicSplitsManagerFactory create(ApplicationModule applicationModule, Provider<DynamicSplitsService> provider) {
        return new ApplicationModule_ProvidesDynamicSplitsManagerFactory(applicationModule, provider);
    }

    public static DynamicSplitsManager providesDynamicSplitsManager(ApplicationModule applicationModule, DynamicSplitsService dynamicSplitsService) {
        return (DynamicSplitsManager) f.b.b.c(applicationModule.providesDynamicSplitsManager(dynamicSplitsService));
    }

    @Override // javax.inject.Provider
    public DynamicSplitsManager get() {
        return providesDynamicSplitsManager(this.module, this.dynamicSplitsServiceProvider.get());
    }
}
