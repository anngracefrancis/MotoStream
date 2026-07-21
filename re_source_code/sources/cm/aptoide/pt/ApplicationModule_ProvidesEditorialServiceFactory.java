package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.aab.SplitsMapper;
import cm.aptoide.pt.app.mmpcampaigns.CampaignMapper;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.editorial.EditorialService;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesEditorialServiceFactory implements Provider {
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final Provider<CampaignMapper> campaignMapperProvider;
    private final Provider<Converter.Factory> converterFactoryProvider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<SplitsMapper> splitsMapperProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    public ApplicationModule_ProvidesEditorialServiceFactory(ApplicationModule applicationModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<Converter.Factory> provider3, Provider<TokenInvalidator> provider4, Provider<SharedPreferences> provider5, Provider<SplitsMapper> provider6, Provider<CampaignMapper> provider7) {
        this.module = applicationModule;
        this.bodyInterceptorPoolV7Provider = provider;
        this.okHttpClientProvider = provider2;
        this.converterFactoryProvider = provider3;
        this.tokenInvalidatorProvider = provider4;
        this.sharedPreferencesProvider = provider5;
        this.splitsMapperProvider = provider6;
        this.campaignMapperProvider = provider7;
    }

    public static ApplicationModule_ProvidesEditorialServiceFactory create(ApplicationModule applicationModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<Converter.Factory> provider3, Provider<TokenInvalidator> provider4, Provider<SharedPreferences> provider5, Provider<SplitsMapper> provider6, Provider<CampaignMapper> provider7) {
        return new ApplicationModule_ProvidesEditorialServiceFactory(applicationModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static EditorialService providesEditorialService(ApplicationModule applicationModule, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, SplitsMapper splitsMapper, CampaignMapper campaignMapper) {
        return (EditorialService) f.b.b.c(applicationModule.providesEditorialService(bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, splitsMapper, campaignMapper));
    }

    @Override // javax.inject.Provider
    public EditorialService get() {
        return providesEditorialService(this.module, this.bodyInterceptorPoolV7Provider.get(), this.okHttpClientProvider.get(), this.converterFactoryProvider.get(), this.tokenInvalidatorProvider.get(), this.sharedPreferencesProvider.get(), this.splitsMapperProvider.get(), this.campaignMapperProvider.get());
    }
}
