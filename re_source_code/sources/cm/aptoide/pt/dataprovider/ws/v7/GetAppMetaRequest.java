package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.GetApp;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetAppMetaRequest extends V7<GetApp, BaseBody> {
    private final String url;

    public GetAppMetaRequest(String str, BaseBody baseBody, String str2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator) {
        super(baseBody, str, okHttpClient, factory, bodyInterceptor, tokenInvalidator);
        this.url = str2;
    }

    public static GetAppMetaRequest ofAction(String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        if (str.contains("getApp")) {
            str = str.split("getApp/")[1];
        }
        return new GetAppMetaRequest(V7.getCacheHost(sharedPreferences), new BaseBody(), str, bodyInterceptor, okHttpClient, factory, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetApp> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getAppMeta(z, this.url);
    }
}
