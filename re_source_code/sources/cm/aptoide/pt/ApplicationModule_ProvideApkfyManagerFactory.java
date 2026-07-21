package cm.aptoide.pt;

import cm.aptoide.pt.apkfy.ApkfyManager;
import cm.aptoide.pt.apkfy.ApkfyService;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideApkfyManagerFactory implements Provider {
    private final Provider<ApkfyService> apkfyServiceProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideApkfyManagerFactory(ApplicationModule applicationModule, Provider<ApkfyService> provider) {
        this.module = applicationModule;
        this.apkfyServiceProvider = provider;
    }

    public static ApplicationModule_ProvideApkfyManagerFactory create(ApplicationModule applicationModule, Provider<ApkfyService> provider) {
        return new ApplicationModule_ProvideApkfyManagerFactory(applicationModule, provider);
    }

    public static ApkfyManager provideApkfyManager(ApplicationModule applicationModule, ApkfyService apkfyService) {
        return (ApkfyManager) f.b.b.c(applicationModule.provideApkfyManager(apkfyService));
    }

    @Override // javax.inject.Provider
    public ApkfyManager get() {
        return provideApkfyManager(this.module, this.apkfyServiceProvider.get());
    }
}
