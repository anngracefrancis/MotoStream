package cm.aptoide.pt;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.WindowManager;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.download.OemidProvider;
import cm.aptoide.pt.home.bundles.BundleDataSource;
import cm.aptoide.pt.home.bundles.BundlesResponseMapper;
import cm.aptoide.pt.install.PackageRepository;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.utils.q.QManager;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesRemoteBundleDataSourceFactory implements Provider {
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<AdsApplicationVersionCodeProvider> adsApplicationVersionCodeProvider;
    private final Provider<AppCoinsManager> appCoinsManagerProvider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final Provider<ConnectivityManager> connectivityManagerProvider;
    private final Provider<Converter.Factory> converterProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final Provider<BundlesResponseMapper> mapperProvider;
    private final ApplicationModule module;
    private final Provider<OemidProvider> oemidProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<PackageRepository> packageRepositoryProvider;
    private final Provider<QManager> qManagerProvider;
    private final Provider<Resources> resourcesProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<StoreCredentialsProvider> storeCredentialsProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;
    private final Provider<WindowManager> windowManagerProvider;

    public ApplicationModule_ProvidesRemoteBundleDataSourceFactory(ApplicationModule applicationModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<Converter.Factory> provider3, Provider<BundlesResponseMapper> provider4, Provider<TokenInvalidator> provider5, Provider<SharedPreferences> provider6, Provider<AptoideAccountManager> provider7, Provider<PackageRepository> provider8, Provider<IdsRepository> provider9, Provider<QManager> provider10, Provider<Resources> provider11, Provider<WindowManager> provider12, Provider<ConnectivityManager> provider13, Provider<AdsApplicationVersionCodeProvider> provider14, Provider<OemidProvider> provider15, Provider<StoreCredentialsProvider> provider16, Provider<AppCoinsManager> provider17) {
        this.module = applicationModule;
        this.bodyInterceptorPoolV7Provider = provider;
        this.okHttpClientProvider = provider2;
        this.converterProvider = provider3;
        this.mapperProvider = provider4;
        this.tokenInvalidatorProvider = provider5;
        this.sharedPreferencesProvider = provider6;
        this.accountManagerProvider = provider7;
        this.packageRepositoryProvider = provider8;
        this.idsRepositoryProvider = provider9;
        this.qManagerProvider = provider10;
        this.resourcesProvider = provider11;
        this.windowManagerProvider = provider12;
        this.connectivityManagerProvider = provider13;
        this.adsApplicationVersionCodeProvider = provider14;
        this.oemidProvider = provider15;
        this.storeCredentialsProvider = provider16;
        this.appCoinsManagerProvider = provider17;
    }

    public static ApplicationModule_ProvidesRemoteBundleDataSourceFactory create(ApplicationModule applicationModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<OkHttpClient> provider2, Provider<Converter.Factory> provider3, Provider<BundlesResponseMapper> provider4, Provider<TokenInvalidator> provider5, Provider<SharedPreferences> provider6, Provider<AptoideAccountManager> provider7, Provider<PackageRepository> provider8, Provider<IdsRepository> provider9, Provider<QManager> provider10, Provider<Resources> provider11, Provider<WindowManager> provider12, Provider<ConnectivityManager> provider13, Provider<AdsApplicationVersionCodeProvider> provider14, Provider<OemidProvider> provider15, Provider<StoreCredentialsProvider> provider16, Provider<AppCoinsManager> provider17) {
        return new ApplicationModule_ProvidesRemoteBundleDataSourceFactory(applicationModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    public static BundleDataSource providesRemoteBundleDataSource(ApplicationModule applicationModule, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, BundlesResponseMapper bundlesResponseMapper, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, AptoideAccountManager aptoideAccountManager, PackageRepository packageRepository, IdsRepository idsRepository, QManager qManager, Resources resources, WindowManager windowManager, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider, OemidProvider oemidProvider, StoreCredentialsProvider storeCredentialsProvider, AppCoinsManager appCoinsManager) {
        return (BundleDataSource) f.b.b.c(applicationModule.providesRemoteBundleDataSource(bodyInterceptor, okHttpClient, factory, bundlesResponseMapper, tokenInvalidator, sharedPreferences, aptoideAccountManager, packageRepository, idsRepository, qManager, resources, windowManager, connectivityManager, adsApplicationVersionCodeProvider, oemidProvider, storeCredentialsProvider, appCoinsManager));
    }

    @Override // javax.inject.Provider
    public BundleDataSource get() {
        return providesRemoteBundleDataSource(this.module, this.bodyInterceptorPoolV7Provider.get(), this.okHttpClientProvider.get(), this.converterProvider.get(), this.mapperProvider.get(), this.tokenInvalidatorProvider.get(), this.sharedPreferencesProvider.get(), this.accountManagerProvider.get(), this.packageRepositoryProvider.get(), this.idsRepositoryProvider.get(), this.qManagerProvider.get(), this.resourcesProvider.get(), this.windowManagerProvider.get(), this.connectivityManagerProvider.get(), this.adsApplicationVersionCodeProvider.get(), this.oemidProvider.get(), this.storeCredentialsProvider.get(), this.appCoinsManagerProvider.get());
    }
}
