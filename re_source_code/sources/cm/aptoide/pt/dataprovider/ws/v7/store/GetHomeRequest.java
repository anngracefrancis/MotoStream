package cm.aptoide.pt.dataprovider.ws.v7.store;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.WindowManager;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.store.GetHome;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetHomeRequest extends V7<GetHome, GetHomeBody> {
    protected GetHomeRequest(GetHomeBody getHomeBody, String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator) {
        super(getHomeBody, str, okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static GetHomeRequest of(BaseRequestWithStore.StoreCredentials storeCredentials, Long l, StoreContext storeContext, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        GetHomeBody getHomeBody = new GetHomeBody(storeCredentials, WidgetsArgs.createDefault(resources, windowManager), l);
        getHomeBody.setContext(storeContext);
        return new GetHomeRequest(getHomeBody, V7.getHost(sharedPreferences), bodyInterceptor, okHttpClient, factory, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetHome> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getHome((GetHomeBody) this.body, z);
    }
}
