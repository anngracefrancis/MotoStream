package cm.aptoide.pt.dataprovider.ws.v7.store;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.WindowManager;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStore;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.dataprovider.ws.v7.V7Url;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetStoreRequest extends BaseRequestWithStore<GetStore, GetStoreBody> {
    private final String url;

    private GetStoreRequest(String str, GetStoreBody getStoreBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(getStoreBody, okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.url = str;
    }

    public static GetStoreRequest of(BaseRequestWithStore.StoreCredentials storeCredentials, StoreContext storeContext, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        GetStoreBody getStoreBody = new GetStoreBody(storeCredentials, WidgetsArgs.createDefault(resources, windowManager));
        getStoreBody.setContext(storeContext);
        return new GetStoreRequest(HttpUrl.FRAGMENT_ENCODE_SET, getStoreBody, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    public static GetStoreRequest ofAction(String str, BaseRequestWithStore.StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        return new GetStoreRequest(new V7Url(str).remove("getStore").get(), new GetStoreBody(storeCredentials, WidgetsArgs.createDefault(resources, windowManager)), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetStore> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getStore(this.url, (GetStoreBody) this.body, z);
    }
}
