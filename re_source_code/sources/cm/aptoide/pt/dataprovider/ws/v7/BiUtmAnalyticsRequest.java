package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class BiUtmAnalyticsRequest extends V7<BaseV7Response, BiUtmAnalyticsRequestBody> {
    private final String action;
    private final String context;
    private final String name;

    private BiUtmAnalyticsRequest(String str, String str2, String str3, BiUtmAnalyticsRequestBody biUtmAnalyticsRequestBody, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor bodyInterceptor, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator) {
        super(biUtmAnalyticsRequestBody, V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
        this.action = str;
        this.name = str2;
        this.context = str3;
    }

    public static BiUtmAnalyticsRequest of(String str, String str2, String str3, BiUtmAnalyticsRequestBody biUtmAnalyticsRequestBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator) {
        return new BiUtmAnalyticsRequest(str, str2, str3, biUtmAnalyticsRequestBody, okHttpClient, factory, bodyInterceptor, sharedPreferences, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<BaseV7Response> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.addEvent(this.name, this.action, this.context, (BiUtmAnalyticsRequestBody) this.body);
    }
}
