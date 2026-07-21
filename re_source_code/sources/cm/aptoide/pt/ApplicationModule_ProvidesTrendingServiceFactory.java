package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.search.suggestions.TrendingService;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesTrendingServiceFactory implements Provider {
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider;
    private final Provider<Converter.Factory> converterFactoryProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<StoreCredentialsProvider> storeCredentialsProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    public ApplicationModule_ProvidesTrendingServiceFactory(ApplicationModule applicationModule, Provider<StoreCredentialsProvider> provider, Provider<SharedPreferences> provider2, Provider<TokenInvalidator> provider3, Provider<Converter.Factory> provider4, Provider<OkHttpClient> provider5, Provider<BodyInterceptor<BaseBody>> provider6) {
        this.module = applicationModule;
        this.storeCredentialsProvider = provider;
        this.sharedPreferencesProvider = provider2;
        this.tokenInvalidatorProvider = provider3;
        this.converterFactoryProvider = provider4;
        this.httpClientProvider = provider5;
        this.bodyInterceptorProvider = provider6;
    }

    public static ApplicationModule_ProvidesTrendingServiceFactory create(ApplicationModule applicationModule, Provider<StoreCredentialsProvider> provider, Provider<SharedPreferences> provider2, Provider<TokenInvalidator> provider3, Provider<Converter.Factory> provider4, Provider<OkHttpClient> provider5, Provider<BodyInterceptor<BaseBody>> provider6) {
        return new ApplicationModule_ProvidesTrendingServiceFactory(applicationModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static TrendingService providesTrendingService(ApplicationModule applicationModule, StoreCredentialsProvider storeCredentialsProvider, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, Converter.Factory factory, OkHttpClient okHttpClient, BodyInterceptor<BaseBody> bodyInterceptor) {
        return (TrendingService) f.b.b.c(applicationModule.providesTrendingService(storeCredentialsProvider, sharedPreferences, tokenInvalidator, factory, okHttpClient, bodyInterceptor));
    }

    @Override // javax.inject.Provider
    public TrendingService get() {
        return providesTrendingService(this.module, this.storeCredentialsProvider.get(), this.sharedPreferencesProvider.get(), this.tokenInvalidatorProvider.get(), this.converterFactoryProvider.get(), this.httpClientProvider.get(), this.bodyInterceptorProvider.get());
    }
}
