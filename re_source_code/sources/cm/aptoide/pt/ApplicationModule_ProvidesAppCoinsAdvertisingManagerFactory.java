package cm.aptoide.pt;

import cm.aptoide.pt.app.AppCoinsAdvertisingManager;
import cm.aptoide.pt.app.AppCoinsService;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppCoinsAdvertisingManagerFactory implements Provider {
    private final Provider<AppCoinsService> appCoinsServiceProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppCoinsAdvertisingManagerFactory(ApplicationModule applicationModule, Provider<AppCoinsService> provider) {
        this.module = applicationModule;
        this.appCoinsServiceProvider = provider;
    }

    public static ApplicationModule_ProvidesAppCoinsAdvertisingManagerFactory create(ApplicationModule applicationModule, Provider<AppCoinsService> provider) {
        return new ApplicationModule_ProvidesAppCoinsAdvertisingManagerFactory(applicationModule, provider);
    }

    public static AppCoinsAdvertisingManager providesAppCoinsAdvertisingManager(ApplicationModule applicationModule, AppCoinsService appCoinsService) {
        return (AppCoinsAdvertisingManager) f.b.b.c(applicationModule.providesAppCoinsAdvertisingManager(appCoinsService));
    }

    @Override // javax.inject.Provider
    public AppCoinsAdvertisingManager get() {
        return providesAppCoinsAdvertisingManager(this.module, this.appCoinsServiceProvider.get());
    }
}
