package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.updates.UpdateMapper;
import cm.aptoide.pt.updates.UpdatePersistence;
import cm.aptoide.pt.updates.UpdateRepository;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesUpdateRepositoryFactory implements Provider {
    private final Provider<AptoideInstalledAppsRepository> aptoideInstalledAppsRepositoryProvider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final Provider<Converter.Factory> converterFactoryProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<RoomStoreRepository> storeRepositoryProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;
    private final Provider<UpdateMapper> updateMapperProvider;
    private final Provider<UpdatePersistence> updatePersistenceProvider;

    public ApplicationModule_ProvidesUpdateRepositoryFactory(ApplicationModule applicationModule, Provider<UpdatePersistence> provider, Provider<RoomStoreRepository> provider2, Provider<IdsRepository> provider3, Provider<BodyInterceptor<BaseBody>> provider4, Provider<OkHttpClient> provider5, Provider<Converter.Factory> provider6, Provider<TokenInvalidator> provider7, Provider<SharedPreferences> provider8, Provider<UpdateMapper> provider9, Provider<AptoideInstalledAppsRepository> provider10) {
        this.module = applicationModule;
        this.updatePersistenceProvider = provider;
        this.storeRepositoryProvider = provider2;
        this.idsRepositoryProvider = provider3;
        this.bodyInterceptorPoolV7Provider = provider4;
        this.okHttpClientProvider = provider5;
        this.converterFactoryProvider = provider6;
        this.tokenInvalidatorProvider = provider7;
        this.sharedPreferencesProvider = provider8;
        this.updateMapperProvider = provider9;
        this.aptoideInstalledAppsRepositoryProvider = provider10;
    }

    public static ApplicationModule_ProvidesUpdateRepositoryFactory create(ApplicationModule applicationModule, Provider<UpdatePersistence> provider, Provider<RoomStoreRepository> provider2, Provider<IdsRepository> provider3, Provider<BodyInterceptor<BaseBody>> provider4, Provider<OkHttpClient> provider5, Provider<Converter.Factory> provider6, Provider<TokenInvalidator> provider7, Provider<SharedPreferences> provider8, Provider<UpdateMapper> provider9, Provider<AptoideInstalledAppsRepository> provider10) {
        return new ApplicationModule_ProvidesUpdateRepositoryFactory(applicationModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static UpdateRepository providesUpdateRepository(ApplicationModule applicationModule, UpdatePersistence updatePersistence, RoomStoreRepository roomStoreRepository, IdsRepository idsRepository, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, UpdateMapper updateMapper, AptoideInstalledAppsRepository aptoideInstalledAppsRepository) {
        return (UpdateRepository) f.b.b.c(applicationModule.providesUpdateRepository(updatePersistence, roomStoreRepository, idsRepository, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, updateMapper, aptoideInstalledAppsRepository));
    }

    @Override // javax.inject.Provider
    public UpdateRepository get() {
        return providesUpdateRepository(this.module, this.updatePersistenceProvider.get(), this.storeRepositoryProvider.get(), this.idsRepositoryProvider.get(), this.bodyInterceptorPoolV7Provider.get(), this.okHttpClientProvider.get(), this.converterFactoryProvider.get(), this.tokenInvalidatorProvider.get(), this.sharedPreferencesProvider.get(), this.updateMapperProvider.get(), this.aptoideInstalledAppsRepositoryProvider.get());
    }
}
