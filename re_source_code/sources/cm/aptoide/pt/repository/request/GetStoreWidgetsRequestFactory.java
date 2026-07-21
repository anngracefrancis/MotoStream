package cm.aptoide.pt.repository.request;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.WindowManager;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.AppCoinsManager;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreWidgetsRequest;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
class GetStoreWidgetsRequestFactory {
    private final AptoideAccountManager accountManager;
    private final AppCoinsManager appCoinsManager;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final String clientUniqueId;
    private final Converter.Factory converterFactory;
    private final String filters;
    private final OkHttpClient httpClient;
    private final String partnerId;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final ConnectivityManager systemService;
    private final TokenInvalidator tokenInvalidator;
    private final AdsApplicationVersionCodeProvider versionCodeProvider;
    private final WindowManager windowManager;

    public GetStoreWidgetsRequestFactory(StoreCredentialsProvider storeCredentialsProvider, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager, String str, String str2, AptoideAccountManager aptoideAccountManager, String str3, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider, AppCoinsManager appCoinsManager) {
        this.storeCredentialsProvider = storeCredentialsProvider;
        this.bodyInterceptor = bodyInterceptor;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
        this.resources = resources;
        this.windowManager = windowManager;
        this.clientUniqueId = str;
        this.partnerId = str2;
        this.accountManager = aptoideAccountManager;
        this.filters = str3;
        this.systemService = connectivityManager;
        this.versionCodeProvider = adsApplicationVersionCodeProvider;
        this.appCoinsManager = appCoinsManager;
    }

    public GetStoreWidgetsRequest newStoreWidgets(String str, boolean z) {
        return GetStoreWidgetsRequest.ofAction(str, this.storeCredentialsProvider.fromUrl(str), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.resources, this.windowManager, this.clientUniqueId, z, this.partnerId, this.accountManager.hasMatureContentEnabled().E().Z0().y().b().booleanValue(), this.filters, this.systemService, this.versionCodeProvider, this.appCoinsManager);
    }
}
