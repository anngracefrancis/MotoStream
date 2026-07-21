package cm.aptoide.pt;

import cm.aptoide.pt.apkfy.AptoideApkfyService;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesApkfyServiceApiFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ApplicationModule_ProvidesApkfyServiceApiFactory(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        this.module = applicationModule;
        this.retrofitProvider = provider;
    }

    public static ApplicationModule_ProvidesApkfyServiceApiFactory create(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        return new ApplicationModule_ProvidesApkfyServiceApiFactory(applicationModule, provider);
    }

    public static AptoideApkfyService.ServiceApi providesApkfyServiceApi(ApplicationModule applicationModule, Retrofit retrofit) {
        return (AptoideApkfyService.ServiceApi) f.b.b.c(applicationModule.providesApkfyServiceApi(retrofit));
    }

    @Override // javax.inject.Provider
    public AptoideApkfyService.ServiceApi get() {
        return providesApkfyServiceApi(this.module, this.retrofitProvider.get());
    }
}
