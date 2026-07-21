package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.app.AppCoinsService;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppCoinsServiceFactory implements Provider {
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final Provider<Converter.Factory> converterFactoryProvider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    public ApplicationModule_ProvidesAppCoinsServiceFactory(ApplicationModule applicationModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<TokenInvalidator> provider3, Provider<SharedPreferences> provider4, Provider<Converter.Factory> provider5) {
        this.module = applicationModule;
        this.bodyInterceptorPoolV7Provider = provider;
        this.okHttpClientProvider = provider2;
        this.tokenInvalidatorProvider = provider3;
        this.sharedPreferencesProvider = provider4;
        this.converterFactoryProvider = provider5;
    }

    public static ApplicationModule_ProvidesAppCoinsServiceFactory create(ApplicationModule applicationModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<TokenInvalidator> provider3, Provider<SharedPreferences> provider4, Provider<Converter.Factory> provider5) {
        return new ApplicationModule_ProvidesAppCoinsServiceFactory(applicationModule, provider, provider2, provider3, provider4, provider5);
    }

    public static AppCoinsService providesAppCoinsService(ApplicationModule applicationModule, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Converter.Factory factory) {
        return (AppCoinsService) f.b.b.c(applicationModule.providesAppCoinsService(bodyInterceptor, okHttpClient, tokenInvalidator, sharedPreferences, factory));
    }

    @Override // javax.inject.Provider
    public AppCoinsService get() {
        return providesAppCoinsService(this.module, this.bodyInterceptorPoolV7Provider.get(), this.okHttpClientProvider.get(), this.tokenInvalidatorProvider.get(), this.sharedPreferencesProvider.get(), this.converterFactoryProvider.get());
    }
}
