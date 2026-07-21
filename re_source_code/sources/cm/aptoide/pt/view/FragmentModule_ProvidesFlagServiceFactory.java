package cm.aptoide.pt.view;

import android.content.SharedPreferences;
import cm.aptoide.pt.app.FlagService;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v3.BaseBody;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesFlagServiceFactory implements Provider {
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorV3Provider;
    private final FragmentModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    public FragmentModule_ProvidesFlagServiceFactory(FragmentModule fragmentModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<TokenInvalidator> provider3, Provider<SharedPreferences> provider4) {
        this.module = fragmentModule;
        this.bodyInterceptorV3Provider = provider;
        this.okHttpClientProvider = provider2;
        this.tokenInvalidatorProvider = provider3;
        this.sharedPreferencesProvider = provider4;
    }

    public static FragmentModule_ProvidesFlagServiceFactory create(FragmentModule fragmentModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<TokenInvalidator> provider3, Provider<SharedPreferences> provider4) {
        return new FragmentModule_ProvidesFlagServiceFactory(fragmentModule, provider, provider2, provider3, provider4);
    }

    public static FlagService providesFlagService(FragmentModule fragmentModule, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return (FlagService) f.b.b.c(fragmentModule.providesFlagService(bodyInterceptor, okHttpClient, tokenInvalidator, sharedPreferences));
    }

    @Override // javax.inject.Provider
    public FlagService get() {
        return providesFlagService(this.module, this.bodyInterceptorV3Provider.get(), this.okHttpClientProvider.get(), this.tokenInvalidatorProvider.get(), this.sharedPreferencesProvider.get());
    }
}
