package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v3.BaseBody;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideTokenInvalidatorFactory implements Provider {
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider;
    private final Provider<String> extraIdProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public ApplicationModule_ProvideTokenInvalidatorFactory(ApplicationModule applicationModule, Provider<OkHttpClient> provider, Provider<SharedPreferences> provider2, Provider<AuthenticationPersistence> provider3, Provider<BodyInterceptor<BaseBody>> provider4, Provider<String> provider5) {
        this.module = applicationModule;
        this.httpClientProvider = provider;
        this.sharedPreferencesProvider = provider2;
        this.authenticationPersistenceProvider = provider3;
        this.bodyInterceptorProvider = provider4;
        this.extraIdProvider = provider5;
    }

    public static ApplicationModule_ProvideTokenInvalidatorFactory create(ApplicationModule applicationModule, Provider<OkHttpClient> provider, Provider<SharedPreferences> provider2, Provider<AuthenticationPersistence> provider3, Provider<BodyInterceptor<BaseBody>> provider4, Provider<String> provider5) {
        return new ApplicationModule_ProvideTokenInvalidatorFactory(applicationModule, provider, provider2, provider3, provider4, provider5);
    }

    public static TokenInvalidator provideTokenInvalidator(ApplicationModule applicationModule, OkHttpClient okHttpClient, SharedPreferences sharedPreferences, AuthenticationPersistence authenticationPersistence, BodyInterceptor<BaseBody> bodyInterceptor, String str) {
        return (TokenInvalidator) f.b.b.c(applicationModule.provideTokenInvalidator(okHttpClient, sharedPreferences, authenticationPersistence, bodyInterceptor, str));
    }

    @Override // javax.inject.Provider
    public TokenInvalidator get() {
        return provideTokenInvalidator(this.module, this.httpClientProvider.get(), this.sharedPreferencesProvider.get(), this.authenticationPersistenceProvider.get(), this.bodyInterceptorProvider.get(), this.extraIdProvider.get());
    }
}
