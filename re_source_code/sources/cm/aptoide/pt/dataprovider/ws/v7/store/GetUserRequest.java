package cm.aptoide.pt.dataprovider.ws.v7.store;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.WindowManager;
import cm.aptoide.pt.AppCoinsManager;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets;
import cm.aptoide.pt.dataprovider.model.v7.Type;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStore;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.dataprovider.ws.v7.V7Url;
import cm.aptoide.pt.dataprovider.ws.v7.WSWidgetsUtils;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class GetUserRequest extends V7<GetStore, Body> {
    private final boolean accountMature;
    private final AppCoinsManager appCoinsManager;
    private boolean bypassServerCache;
    private final String clientUniqueId;
    private final ConnectivityManager connectivityManager;
    private final String filters;
    private final OkHttpClient httpClient;
    private final boolean isGooglePlayServicesAvailable;
    private final String partnerId;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final BaseRequestWithStore.StoreCredentials storeCredentials;
    private final TokenInvalidator tokenInvalidator;
    private String url;
    private final AdsApplicationVersionCodeProvider versionCodeProvider;
    private final WindowManager windowManager;

    public static class Body extends BaseBody {
        private WidgetsArgs widgetsArgs;

        public Body(WidgetsArgs widgetsArgs) {
            this.widgetsArgs = widgetsArgs;
        }

        public WidgetsArgs getWidgetsArgs() {
            return this.widgetsArgs;
        }
    }

    public GetUserRequest(String str, Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, BaseRequestWithStore.StoreCredentials storeCredentials, String str2, boolean z, String str3, boolean z2, String str4, SharedPreferences sharedPreferences2, Resources resources, WindowManager windowManager, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider, AppCoinsManager appCoinsManager) {
        super(body, V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
        this.url = str;
        this.httpClient = okHttpClient;
        this.tokenInvalidator = tokenInvalidator;
        this.storeCredentials = storeCredentials;
        this.clientUniqueId = str2;
        this.isGooglePlayServicesAvailable = z;
        this.partnerId = str3;
        this.accountMature = z2;
        this.filters = str4;
        this.sharedPreferences = sharedPreferences2;
        this.resources = resources;
        this.windowManager = windowManager;
        this.connectivityManager = connectivityManager;
        this.versionCodeProvider = adsApplicationVersionCodeProvider;
        this.appCoinsManager = appCoinsManager;
    }

    static /* synthetic */ GetStore lambda$loadDataFromNetwork$0(GetStore getStore, List list) {
        return getStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDataFromNetwork$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(final GetStore getStore) {
        return loadGetStoreWidgets(getStore).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.store.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                GetStore getStore2 = getStore;
                GetUserRequest.lambda$loadDataFromNetwork$0(getStore2, (List) obj);
                return getStore2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadGetStoreWidgets$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e i(GetStoreWidgets.WSWidget wSWidget) {
        WSWidgetsUtils wSWidgetsUtils = new WSWidgetsUtils();
        BaseRequestWithStore.StoreCredentials storeCredentials = this.storeCredentials;
        String str = this.clientUniqueId;
        boolean z = this.isGooglePlayServicesAvailable;
        String str2 = this.partnerId;
        boolean z2 = this.accountMature;
        BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Converter.Factory factory = this.converterFactory;
        String str3 = this.filters;
        TokenInvalidator tokenInvalidator = this.tokenInvalidator;
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Resources resources = this.resources;
        WindowManager windowManager = this.windowManager;
        return wSWidgetsUtils.loadWidgetNode(wSWidget, storeCredentials, false, str, z, str2, z2, bodyInterceptor, okHttpClient, factory, str3, tokenInvalidator, sharedPreferences, resources, windowManager, this.connectivityManager, this.versionCodeProvider, this.bypassServerCache, Type.ADS.getPerLineCount(resources, windowManager), Collections.emptyList(), this.appCoinsManager);
    }

    public static GetUserRequest of(String str, BaseRequestWithStore.StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager, String str2, boolean z, String str3, boolean z2, String str4, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider, AppCoinsManager appCoinsManager) {
        return new GetUserRequest(new V7Url(str).remove("user/get").get(), new Body(WidgetsArgs.createDefault(resources, windowManager)), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, storeCredentials, str2, z, str3, z2, str4, sharedPreferences, resources, windowManager, connectivityManager, adsApplicationVersionCodeProvider, appCoinsManager);
    }

    protected rx.e<List<GetStoreWidgets.WSWidget>> loadGetStoreWidgets(final GetStore getStore) {
        return rx.e.N(getStore.getNodes().getWidgets().getDataList().getList()).j0(Schedulers.io()).G(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.store.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5059f.i((GetStoreWidgets.WSWidget) obj);
            }
        }).Y0().J(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.store.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return getStore.getNodes().getWidgets().getDataList().getList();
            }
        }).Y0().E();
    }

    @Override // cm.aptoide.pt.dataprovider.ws.v7.V7
    public rx.e<GetStore> observe(boolean z, boolean z2) {
        this.bypassServerCache = z2;
        return super.observe(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetStore> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getUser(this.url, (Body) this.body, z).G(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.store.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5061f.h((GetStore) obj);
            }
        });
    }
}
