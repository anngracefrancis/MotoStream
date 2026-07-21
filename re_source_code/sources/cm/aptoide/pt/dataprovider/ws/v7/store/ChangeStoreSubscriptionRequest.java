package cm.aptoide.pt.dataprovider.ws.v7.store;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.ChangeStoreSubscriptionResponse;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class ChangeStoreSubscriptionRequest extends V7<ChangeStoreSubscriptionResponse, Body> {
    protected ChangeStoreSubscriptionRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_WRITE_V7_HOST);
        sb.append("/api/7/");
        return sb.toString();
    }

    public static ChangeStoreSubscriptionRequest of(String str, ChangeStoreSubscriptionResponse.StoreSubscriptionState storeSubscriptionState, String str2, String str3, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new ChangeStoreSubscriptionRequest(new Body(str, storeSubscriptionState, str2, str3), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<ChangeStoreSubscriptionResponse> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.changeStoreSubscription(z, (Body) this.body);
    }

    public static class Body extends BaseBody {
        private final ChangeStoreSubscriptionResponse.StoreSubscriptionState status;
        private final String storeName;
        private String storePassSha1;
        private String storeUser;

        public Body(String str, ChangeStoreSubscriptionResponse.StoreSubscriptionState storeSubscriptionState) {
            this.storeName = str;
            this.status = storeSubscriptionState;
        }

        public ChangeStoreSubscriptionResponse.StoreSubscriptionState getStatus() {
            return this.status;
        }

        public String getStoreName() {
            return this.storeName;
        }

        public String getStorePassSha1() {
            return this.storePassSha1;
        }

        public String getStoreUser() {
            return this.storeUser;
        }

        public Body(String str, ChangeStoreSubscriptionResponse.StoreSubscriptionState storeSubscriptionState, String str2, String str3) {
            this.storeName = str;
            this.storePassSha1 = str3;
            this.status = storeSubscriptionState;
            this.storeUser = str2;
        }
    }
}
