package cm.aptoide.pt.view;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.editorialList.EditorialCardListService;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesEditorialServiceFactory implements Provider {
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final FragmentModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    public FragmentModule_ProvidesEditorialServiceFactory(FragmentModule fragmentModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<TokenInvalidator> provider3, Provider<SharedPreferences> provider4) {
        this.module = fragmentModule;
        this.bodyInterceptorPoolV7Provider = provider;
        this.okHttpClientProvider = provider2;
        this.tokenInvalidatorProvider = provider3;
        this.sharedPreferencesProvider = provider4;
    }

    public static FragmentModule_ProvidesEditorialServiceFactory create(FragmentModule fragmentModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<TokenInvalidator> provider3, Provider<SharedPreferences> provider4) {
        return new FragmentModule_ProvidesEditorialServiceFactory(fragmentModule, provider, provider2, provider3, provider4);
    }

    public static EditorialCardListService providesEditorialService(FragmentModule fragmentModule, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return (EditorialCardListService) f.b.b.c(fragmentModule.providesEditorialService(bodyInterceptor, okHttpClient, tokenInvalidator, sharedPreferences));
    }

    @Override // javax.inject.Provider
    public EditorialCardListService get() {
        return providesEditorialService(this.module, this.bodyInterceptorPoolV7Provider.get(), this.okHttpClientProvider.get(), this.tokenInvalidatorProvider.get(), this.sharedPreferencesProvider.get());
    }
}
