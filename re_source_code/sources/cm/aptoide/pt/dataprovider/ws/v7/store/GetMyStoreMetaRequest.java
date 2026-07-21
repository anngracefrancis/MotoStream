package cm.aptoide.pt.dataprovider.ws.v7.store;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetMyStoreMetaRequest extends V7<GetStoreMeta, BaseBody> {
    public GetMyStoreMetaRequest(BaseBody baseBody, String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator) {
        super(baseBody, str, okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static GetMyStoreMetaRequest of(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new GetMyStoreMetaRequest(new BaseBody(), V7.getHost(sharedPreferences), bodyInterceptor, okHttpClient, factory, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetStoreMeta> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getMyStoreMeta((BaseBody) this.body, z);
    }
}
