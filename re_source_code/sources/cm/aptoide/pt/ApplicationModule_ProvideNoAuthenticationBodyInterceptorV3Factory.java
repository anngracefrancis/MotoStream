package cm.aptoide.pt;

import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v3.BaseBody;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.preferences.AptoideMd5Manager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideNoAuthenticationBodyInterceptorV3Factory implements Provider {
    private final Provider<AptoideMd5Manager> aptoideMd5ManagerProvider;
    private final Provider<String> aptoidePackageProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideNoAuthenticationBodyInterceptorV3Factory(ApplicationModule applicationModule, Provider<IdsRepository> provider, Provider<String> provider2, Provider<AptoideMd5Manager> provider3) {
        this.module = applicationModule;
        this.idsRepositoryProvider = provider;
        this.aptoidePackageProvider = provider2;
        this.aptoideMd5ManagerProvider = provider3;
    }

    public static ApplicationModule_ProvideNoAuthenticationBodyInterceptorV3Factory create(ApplicationModule applicationModule, Provider<IdsRepository> provider, Provider<String> provider2, Provider<AptoideMd5Manager> provider3) {
        return new ApplicationModule_ProvideNoAuthenticationBodyInterceptorV3Factory(applicationModule, provider, provider2, provider3);
    }

    public static BodyInterceptor<BaseBody> provideNoAuthenticationBodyInterceptorV3(ApplicationModule applicationModule, IdsRepository idsRepository, String str, AptoideMd5Manager aptoideMd5Manager) {
        return (BodyInterceptor) f.b.b.c(applicationModule.provideNoAuthenticationBodyInterceptorV3(idsRepository, str, aptoideMd5Manager));
    }

    @Override // javax.inject.Provider
    public BodyInterceptor<BaseBody> get() {
        return provideNoAuthenticationBodyInterceptorV3(this.module, this.idsRepositoryProvider.get(), this.aptoidePackageProvider.get(), this.aptoideMd5ManagerProvider.get());
    }
}
