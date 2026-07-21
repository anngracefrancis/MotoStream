package cm.aptoide.pt.dataprovider.ws.v7.store;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.WindowManager;
import cm.aptoide.pt.AppCoinsManager;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets;
import cm.aptoide.pt.dataprovider.model.v7.Type;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBodyWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.Endless;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.dataprovider.ws.v7.V7Url;
import cm.aptoide.pt.dataprovider.ws.v7.WSWidgetsUtils;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class GetStoreWidgetsRequest extends BaseRequestWithStore<GetStoreWidgets, Body> {
    private final boolean accountMature;
    private final AppCoinsManager appCoinsManager;
    private boolean bypassServerCache;
    private final String clientUniqueId;
    private final ConnectivityManager connectivityManager;
    private final String filters;
    private final boolean isGooglePlayServicesAvailable;
    private final String partnerId;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final BaseRequestWithStore.StoreCredentials storeCredentials;
    private final String url;
    private final AdsApplicationVersionCodeProvider versionCodeProvider;
    private final WSWidgetsUtils widgetsUtils;
    private final WindowManager windowManager;

    public GetStoreWidgetsRequest(String str, Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, BaseRequestWithStore.StoreCredentials storeCredentials, String str2, boolean z, String str3, boolean z2, String str4, Resources resources, WindowManager windowManager, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider, WSWidgetsUtils wSWidgetsUtils, AppCoinsManager appCoinsManager) {
        super(body, okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.url = str;
        this.storeCredentials = storeCredentials;
        this.clientUniqueId = str2;
        this.isGooglePlayServicesAvailable = z;
        this.partnerId = str3;
        this.accountMature = z2;
        this.filters = str4;
        this.resources = resources;
        this.windowManager = windowManager;
        this.connectivityManager = connectivityManager;
        this.versionCodeProvider = adsApplicationVersionCodeProvider;
        this.sharedPreferences = sharedPreferences;
        this.widgetsUtils = wSWidgetsUtils;
        this.appCoinsManager = appCoinsManager;
    }

    static /* synthetic */ GetStoreWidgets lambda$loadDataFromNetwork$0(GetStoreWidgets getStoreWidgets, List list) {
        return getStoreWidgets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDataFromNetwork$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(boolean z, final GetStoreWidgets getStoreWidgets) {
        return loadGetStoreWidgets(getStoreWidgets, z).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.store.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                GetStoreWidgets getStoreWidgets2 = getStoreWidgets;
                GetStoreWidgetsRequest.lambda$loadDataFromNetwork$0(getStoreWidgets2, (List) obj);
                return getStoreWidgets2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadGetStoreWidgets$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e i(boolean z, GetStoreWidgets.WSWidget wSWidget) {
        WSWidgetsUtils wSWidgetsUtils = this.widgetsUtils;
        BaseRequestWithStore.StoreCredentials storeCredentials = this.storeCredentials;
        String str = this.clientUniqueId;
        boolean z2 = this.isGooglePlayServicesAvailable;
        String str2 = this.partnerId;
        boolean z3 = this.accountMature;
        BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptor;
        OkHttpClient httpClient = getHttpClient();
        Converter.Factory factory = this.converterFactory;
        String str3 = this.filters;
        TokenInvalidator tokenInvalidator = getTokenInvalidator();
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Resources resources = this.resources;
        WindowManager windowManager = this.windowManager;
        return wSWidgetsUtils.loadWidgetNode(wSWidget, storeCredentials, z, str, z2, str2, z3, bodyInterceptor, httpClient, factory, str3, tokenInvalidator, sharedPreferences, resources, windowManager, this.connectivityManager, this.versionCodeProvider, this.bypassServerCache, Type.ADS.getPerLineCount(resources, windowManager), Collections.emptyList(), this.appCoinsManager);
    }

    private rx.e<List<GetStoreWidgets.WSWidget>> loadGetStoreWidgets(final GetStoreWidgets getStoreWidgets, final boolean z) {
        return rx.e.N(getStoreWidgets.getDataList().getList()).j0(Schedulers.io()).G(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.store.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5056f.i(z, (GetStoreWidgets.WSWidget) obj);
            }
        }).Y0().J(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.store.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return getStoreWidgets.getDataList().getList();
            }
        }).Y0().E();
    }

    public static GetStoreWidgetsRequest ofAction(String str, BaseRequestWithStore.StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager, String str2, boolean z, String str3, boolean z2, String str4, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider, AppCoinsManager appCoinsManager) {
        return new GetStoreWidgetsRequest(new V7Url(str).remove("getStoreWidgets").get(), new Body(storeCredentials, WidgetsArgs.createDefault(resources, windowManager)), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, storeCredentials, str2, z, str3, z2, str4, resources, windowManager, connectivityManager, adsApplicationVersionCodeProvider, new WSWidgetsUtils(), appCoinsManager);
    }

    public String getUrl() {
        return this.url;
    }

    @Override // cm.aptoide.pt.dataprovider.ws.v7.V7
    public rx.e<GetStoreWidgets> observe(boolean z, boolean z2) {
        this.bypassServerCache = z2;
        return super.observe(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetStoreWidgets> loadDataFromNetwork(V7.Interfaces interfaces, final boolean z) {
        return interfaces.getStoreWidgets(this.url, (Body) this.body, z).G(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.store.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5054f.h(z, (GetStoreWidgets) obj);
            }
        });
    }

    public static class Body extends BaseBodyWithStore implements Endless {
        private StoreContext context;
        private Integer limit;
        private int offset;
        private String storeName;
        private WidgetsArgs widgetsArgs;

        public Body(BaseRequestWithStore.StoreCredentials storeCredentials, WidgetsArgs widgetsArgs) {
            super(storeCredentials);
            this.widgetsArgs = widgetsArgs;
            this.limit = 5;
        }

        public StoreContext getContext() {
            return this.context;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public Integer getLimit() {
            return this.limit;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public int getOffset() {
            return this.offset;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.BaseBodyWithStore
        public String getStoreName() {
            return this.storeName;
        }

        public WidgetsArgs getWidgetsArgs() {
            return this.widgetsArgs;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public void setOffset(int i2) {
            this.offset = i2;
        }

        public Body(BaseRequestWithStore.StoreCredentials storeCredentials, WidgetsArgs widgetsArgs, int i2) {
            super(storeCredentials);
            this.widgetsArgs = widgetsArgs;
            this.limit = Integer.valueOf(i2);
        }

        public Body(BaseRequestWithStore.StoreCredentials storeCredentials, WidgetsArgs widgetsArgs, StoreContext storeContext, String str) {
            super(storeCredentials);
            this.widgetsArgs = widgetsArgs;
            this.context = storeContext;
            this.storeName = str;
        }
    }
}
