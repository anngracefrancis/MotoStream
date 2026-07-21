package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.app.mmpcampaigns.CampaignMapper;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.download.OemidProvider;
import cm.aptoide.pt.search.SearchRepository;
import cm.aptoide.pt.store.RoomStoreRepository;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesSearchRepositoryFactory implements Provider {
    private final Provider<BodyInterceptor<BaseBody>> baseBodyBodyInterceptorProvider;
    private final Provider<CampaignMapper> campaignMapperProvider;
    private final Provider<Converter.Factory> converterFactoryProvider;
    private final ApplicationModule module;
    private final Provider<OemidProvider> oemidProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<RoomStoreRepository> roomStoreRepositoryProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    public ApplicationModule_ProvidesSearchRepositoryFactory(ApplicationModule applicationModule, Provider<RoomStoreRepository> provider, Provider<BodyInterceptor<BaseBody>> provider2, Provider<SharedPreferences> provider3, Provider<TokenInvalidator> provider4, Provider<OkHttpClient> provider5, Provider<Converter.Factory> provider6, Provider<OemidProvider> provider7, Provider<CampaignMapper> provider8) {
        this.module = applicationModule;
        this.roomStoreRepositoryProvider = provider;
        this.baseBodyBodyInterceptorProvider = provider2;
        this.sharedPreferencesProvider = provider3;
        this.tokenInvalidatorProvider = provider4;
        this.okHttpClientProvider = provider5;
        this.converterFactoryProvider = provider6;
        this.oemidProvider = provider7;
        this.campaignMapperProvider = provider8;
    }

    public static ApplicationModule_ProvidesSearchRepositoryFactory create(ApplicationModule applicationModule, Provider<RoomStoreRepository> provider, Provider<BodyInterceptor<BaseBody>> provider2, Provider<SharedPreferences> provider3, Provider<TokenInvalidator> provider4, Provider<OkHttpClient> provider5, Provider<Converter.Factory> provider6, Provider<OemidProvider> provider7, Provider<CampaignMapper> provider8) {
        return new ApplicationModule_ProvidesSearchRepositoryFactory(applicationModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static SearchRepository providesSearchRepository(ApplicationModule applicationModule, RoomStoreRepository roomStoreRepository, BodyInterceptor<BaseBody> bodyInterceptor, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, OkHttpClient okHttpClient, Converter.Factory factory, OemidProvider oemidProvider, CampaignMapper campaignMapper) {
        return (SearchRepository) f.b.b.c(applicationModule.providesSearchRepository(roomStoreRepository, bodyInterceptor, sharedPreferences, tokenInvalidator, okHttpClient, factory, oemidProvider, campaignMapper));
    }

    @Override // javax.inject.Provider
    public SearchRepository get() {
        return providesSearchRepository(this.module, this.roomStoreRepositoryProvider.get(), this.baseBodyBodyInterceptorProvider.get(), this.sharedPreferencesProvider.get(), this.tokenInvalidatorProvider.get(), this.okHttpClientProvider.get(), this.converterFactoryProvider.get(), this.oemidProvider.get(), this.campaignMapperProvider.get());
    }
}
