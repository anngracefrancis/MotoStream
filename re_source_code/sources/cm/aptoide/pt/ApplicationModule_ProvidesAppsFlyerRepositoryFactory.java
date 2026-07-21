package cm.aptoide.pt;

import cm.aptoide.pt.app.appsflyer.AppsFlyerRepository;
import cm.aptoide.pt.app.appsflyer.AppsFlyerService;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppsFlyerRepositoryFactory implements Provider {
    private final Provider<AppsFlyerService> appsFlyerServiceProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppsFlyerRepositoryFactory(ApplicationModule applicationModule, Provider<AppsFlyerService> provider) {
        this.module = applicationModule;
        this.appsFlyerServiceProvider = provider;
    }

    public static ApplicationModule_ProvidesAppsFlyerRepositoryFactory create(ApplicationModule applicationModule, Provider<AppsFlyerService> provider) {
        return new ApplicationModule_ProvidesAppsFlyerRepositoryFactory(applicationModule, provider);
    }

    public static AppsFlyerRepository providesAppsFlyerRepository(ApplicationModule applicationModule, AppsFlyerService appsFlyerService) {
        return (AppsFlyerRepository) f.b.b.c(applicationModule.providesAppsFlyerRepository(appsFlyerService));
    }

    @Override // javax.inject.Provider
    public AppsFlyerRepository get() {
        return providesAppsFlyerRepository(this.module, this.appsFlyerServiceProvider.get());
    }
}
