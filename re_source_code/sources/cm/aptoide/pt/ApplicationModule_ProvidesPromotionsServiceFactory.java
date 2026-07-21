package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.aab.SplitsMapper;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.promotions.PromotionsService;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesPromotionsServiceFactory implements Provider {
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final Provider<Converter.Factory> converterFactoryProvider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<SplitsMapper> splitsMapperProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    public ApplicationModule_ProvidesPromotionsServiceFactory(ApplicationModule applicationModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<TokenInvalidator> provider3, Provider<Converter.Factory> provider4, Provider<SharedPreferences> provider5, Provider<SplitsMapper> provider6) {
        this.module = applicationModule;
        this.bodyInterceptorPoolV7Provider = provider;
        this.okHttpClientProvider = provider2;
        this.tokenInvalidatorProvider = provider3;
        this.converterFactoryProvider = provider4;
        this.sharedPreferencesProvider = provider5;
        this.splitsMapperProvider = provider6;
    }

    public static ApplicationModule_ProvidesPromotionsServiceFactory create(ApplicationModule applicationModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<TokenInvalidator> provider3, Provider<Converter.Factory> provider4, Provider<SharedPreferences> provider5, Provider<SplitsMapper> provider6) {
        return new ApplicationModule_ProvidesPromotionsServiceFactory(applicationModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PromotionsService providesPromotionsService(ApplicationModule applicationModule, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, Converter.Factory factory, SharedPreferences sharedPreferences, SplitsMapper splitsMapper) {
        return (PromotionsService) f.b.b.c(applicationModule.providesPromotionsService(bodyInterceptor, okHttpClient, tokenInvalidator, factory, sharedPreferences, splitsMapper));
    }

    @Override // javax.inject.Provider
    public PromotionsService get() {
        return providesPromotionsService(this.module, this.bodyInterceptorPoolV7Provider.get(), this.okHttpClientProvider.get(), this.tokenInvalidatorProvider.get(), this.converterFactoryProvider.get(), this.sharedPreferencesProvider.get(), this.splitsMapperProvider.get());
    }
}
