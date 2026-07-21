package cm.aptoide.pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideWebSocketOkHttpClientFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<Interceptor> retrofitLogInterceptorProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<Interceptor> userAgentInterceptorProvider;

    public ApplicationModule_ProvideWebSocketOkHttpClientFactory(ApplicationModule applicationModule, Provider<Interceptor> provider, Provider<SharedPreferences> provider2, Provider<Interceptor> provider3) {
        this.module = applicationModule;
        this.userAgentInterceptorProvider = provider;
        this.sharedPreferencesProvider = provider2;
        this.retrofitLogInterceptorProvider = provider3;
    }

    public static ApplicationModule_ProvideWebSocketOkHttpClientFactory create(ApplicationModule applicationModule, Provider<Interceptor> provider, Provider<SharedPreferences> provider2, Provider<Interceptor> provider3) {
        return new ApplicationModule_ProvideWebSocketOkHttpClientFactory(applicationModule, provider, provider2, provider3);
    }

    public static OkHttpClient provideWebSocketOkHttpClient(ApplicationModule applicationModule, Interceptor interceptor, SharedPreferences sharedPreferences, Interceptor interceptor2) {
        return (OkHttpClient) f.b.b.c(applicationModule.provideWebSocketOkHttpClient(interceptor, sharedPreferences, interceptor2));
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideWebSocketOkHttpClient(this.module, this.userAgentInterceptorProvider.get(), this.sharedPreferencesProvider.get(), this.retrofitLogInterceptorProvider.get());
    }
}
