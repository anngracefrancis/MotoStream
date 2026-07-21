package cm.aptoide.pt.dataprovider.ws.v7.store;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.store.GetHomeMeta;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBodyWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.dataprovider.ws.v7.V7Url;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetHomeMetaRequest extends BaseRequestWithStore<GetHomeMeta, Body> {
    private final String url;

    public static class Body extends BaseBodyWithStore {
        public Body(BaseRequestWithStore.StoreCredentials storeCredentials) {
            super(storeCredentials);
        }
    }

    private GetHomeMetaRequest(Body body, String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.url = str;
    }

    public static GetHomeMetaRequest of(BaseRequestWithStore.StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new GetHomeMetaRequest(new Body(storeCredentials), null, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    public static GetHomeMetaRequest ofAction(String str, BaseRequestWithStore.StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new GetHomeMetaRequest(new Body(storeCredentials), new V7Url(str).remove("home/getMeta").get(), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    public String getUrl() {
        return this.url;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetHomeMeta> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        String str = this.url;
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return interfaces.getHomeMeta(str, (Body) this.body, z);
    }
}
