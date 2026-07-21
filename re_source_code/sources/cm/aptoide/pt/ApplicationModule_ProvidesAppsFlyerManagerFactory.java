package cm.aptoide.pt;

import cm.aptoide.pt.app.appsflyer.AppsFlyerManager;
import cm.aptoide.pt.app.appsflyer.AppsFlyerRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppsFlyerManagerFactory implements Provider {
    private final Provider<AppsFlyerRepository> appsFlyerRepositoryProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppsFlyerManagerFactory(ApplicationModule applicationModule, Provider<AppsFlyerRepository> provider) {
        this.module = applicationModule;
        this.appsFlyerRepositoryProvider = provider;
    }

    public static ApplicationModule_ProvidesAppsFlyerManagerFactory create(ApplicationModule applicationModule, Provider<AppsFlyerRepository> provider) {
        return new ApplicationModule_ProvidesAppsFlyerManagerFactory(applicationModule, provider);
    }

    public static AppsFlyerManager providesAppsFlyerManager(ApplicationModule applicationModule, AppsFlyerRepository appsFlyerRepository) {
        return (AppsFlyerManager) f.b.b.c(applicationModule.providesAppsFlyerManager(appsFlyerRepository));
    }

    @Override // javax.inject.Provider
    public AppsFlyerManager get() {
        return providesAppsFlyerManager(this.module, this.appsFlyerRepositoryProvider.get());
    }
}
