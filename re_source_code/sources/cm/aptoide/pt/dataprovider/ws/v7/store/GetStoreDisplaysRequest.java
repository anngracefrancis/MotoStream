package cm.aptoide.pt.dataprovider.ws.v7.store;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreDisplays;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBodyWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.dataprovider.ws.v7.V7Url;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetStoreDisplaysRequest extends BaseRequestWithStore<GetStoreDisplays, Body> {
    private String url;

    public static class Body extends BaseBodyWithStore {
        public Body(BaseRequestWithStore.StoreCredentials storeCredentials) {
            super(storeCredentials);
        }
    }

    GetStoreDisplaysRequest(String str, Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.url = str;
    }

    public static GetStoreDisplaysRequest ofAction(String str, BaseRequestWithStore.StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new GetStoreDisplaysRequest(new V7Url(str).remove("getStoreDisplays").get(), new Body(storeCredentials), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetStoreDisplays> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getStoreDisplays(this.url, (Body) this.body, z);
    }
}
