package cm.aptoide.pt;

import cm.aptoide.pt.view.app.AppCenter;
import cm.aptoide.pt.view.app.AppCenterRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppCenterFactory implements Provider {
    private final Provider<AppCenterRepository> appCenterRepositoryProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppCenterFactory(ApplicationModule applicationModule, Provider<AppCenterRepository> provider) {
        this.module = applicationModule;
        this.appCenterRepositoryProvider = provider;
    }

    public static ApplicationModule_ProvidesAppCenterFactory create(ApplicationModule applicationModule, Provider<AppCenterRepository> provider) {
        return new ApplicationModule_ProvidesAppCenterFactory(applicationModule, provider);
    }

    public static AppCenter providesAppCenter(ApplicationModule applicationModule, AppCenterRepository appCenterRepository) {
        return (AppCenter) f.b.b.c(applicationModule.providesAppCenter(appCenterRepository));
    }

    @Override // javax.inject.Provider
    public AppCenter get() {
        return providesAppCenter(this.module, this.appCenterRepositoryProvider.get());
    }
}
