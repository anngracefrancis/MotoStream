package cm.aptoide.pt;

import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideAptoideMMpOkHttpClientFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<OkHttpClient.Builder> okHttpClientBuilderProvider;
    private final Provider<Interceptor> userAgentInterceptorProvider;

    public ApplicationModule_ProvideAptoideMMpOkHttpClientFactory(ApplicationModule applicationModule, Provider<OkHttpClient.Builder> provider, Provider<Interceptor> provider2) {
        this.module = applicationModule;
        this.okHttpClientBuilderProvider = provider;
        this.userAgentInterceptorProvider = provider2;
    }

    public static ApplicationModule_ProvideAptoideMMpOkHttpClientFactory create(ApplicationModule applicationModule, Provider<OkHttpClient.Builder> provider, Provider<Interceptor> provider2) {
        return new ApplicationModule_ProvideAptoideMMpOkHttpClientFactory(applicationModule, provider, provider2);
    }

    public static OkHttpClient provideAptoideMMpOkHttpClient(ApplicationModule applicationModule, OkHttpClient.Builder builder, Interceptor interceptor) {
        return (OkHttpClient) f.b.b.c(applicationModule.provideAptoideMMpOkHttpClient(builder, interceptor));
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideAptoideMMpOkHttpClient(this.module, this.okHttpClientBuilderProvider.get(), this.userAgentInterceptorProvider.get());
    }
}
