package cm.aptoide.pt;

import cm.aptoide.pt.view.app.AppCenterRepository;
import cm.aptoide.pt.view.app.AppService;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppCenterRepositoryFactory implements Provider {
    private final Provider<AppService> appServiceProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppCenterRepositoryFactory(ApplicationModule applicationModule, Provider<AppService> provider) {
        this.module = applicationModule;
        this.appServiceProvider = provider;
    }

    public static ApplicationModule_ProvidesAppCenterRepositoryFactory create(ApplicationModule applicationModule, Provider<AppService> provider) {
        return new ApplicationModule_ProvidesAppCenterRepositoryFactory(applicationModule, provider);
    }

    public static AppCenterRepository providesAppCenterRepository(ApplicationModule applicationModule, AppService appService) {
        return (AppCenterRepository) f.b.b.c(applicationModule.providesAppCenterRepository(appService));
    }

    @Override // javax.inject.Provider
    public AppCenterRepository get() {
        return providesAppCenterRepository(this.module, this.appServiceProvider.get());
    }
}
