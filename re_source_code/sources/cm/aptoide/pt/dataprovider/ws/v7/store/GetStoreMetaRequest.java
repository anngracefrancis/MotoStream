package cm.aptoide.pt.dataprovider.ws.v7.store;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetStoreMetaRequest extends BaseRequestWithStore<GetStoreMeta, GetHomeMetaRequest.Body> {
    private final String url;

    public GetStoreMetaRequest(String str, GetHomeMetaRequest.Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.url = str;
    }

    public static GetStoreMetaRequest of(BaseRequestWithStore.StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new GetStoreMetaRequest(HttpUrl.FRAGMENT_ENCODE_SET, new GetHomeMetaRequest.Body(storeCredentials), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    public static GetStoreMetaRequest ofAction(String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new GetStoreMetaRequest(str, new GetHomeMetaRequest.Body(new BaseRequestWithStore.StoreCredentials()), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetStoreMeta> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return !this.url.isEmpty() ? interfaces.getStoreMeta(this.url, (GetHomeMetaRequest.Body) this.body, z) : interfaces.getStoreMeta((GetHomeMetaRequest.Body) this.body, z);
    }
}
