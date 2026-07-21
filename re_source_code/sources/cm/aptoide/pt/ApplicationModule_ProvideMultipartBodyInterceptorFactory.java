package cm.aptoide.pt;

import cm.aptoide.pt.dataprovider.ws.v7.store.RequestBodyFactory;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.networking.MultipartBodyInterceptor;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideMultipartBodyInterceptorFactory implements Provider {
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<RequestBodyFactory> requestBodyFactoryProvider;

    public ApplicationModule_ProvideMultipartBodyInterceptorFactory(ApplicationModule applicationModule, Provider<IdsRepository> provider, Provider<AuthenticationPersistence> provider2, Provider<RequestBodyFactory> provider3) {
        this.module = applicationModule;
        this.idsRepositoryProvider = provider;
        this.authenticationPersistenceProvider = provider2;
        this.requestBodyFactoryProvider = provider3;
    }

    public static ApplicationModule_ProvideMultipartBodyInterceptorFactory create(ApplicationModule applicationModule, Provider<IdsRepository> provider, Provider<AuthenticationPersistence> provider2, Provider<RequestBodyFactory> provider3) {
        return new ApplicationModule_ProvideMultipartBodyInterceptorFactory(applicationModule, provider, provider2, provider3);
    }

    public static MultipartBodyInterceptor provideMultipartBodyInterceptor(ApplicationModule applicationModule, IdsRepository idsRepository, AuthenticationPersistence authenticationPersistence, RequestBodyFactory requestBodyFactory) {
        return (MultipartBodyInterceptor) f.b.b.c(applicationModule.provideMultipartBodyInterceptor(idsRepository, authenticationPersistence, requestBodyFactory));
    }

    @Override // javax.inject.Provider
    public MultipartBodyInterceptor get() {
        return provideMultipartBodyInterceptor(this.module, this.idsRepositoryProvider.get(), this.authenticationPersistenceProvider.get(), this.requestBodyFactoryProvider.get());
    }
}
