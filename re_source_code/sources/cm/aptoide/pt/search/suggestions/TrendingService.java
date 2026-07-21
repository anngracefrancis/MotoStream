package cm.aptoide.pt.search.suggestions;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.ListApps;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.ListAppsRequest;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class TrendingService {
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Converter.Factory converterFactory;
    private final OkHttpClient httpClient;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final TokenInvalidator tokenInvalidator;

    public TrendingService(StoreCredentialsProvider storeCredentialsProvider, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        this.storeCredentialsProvider = storeCredentialsProvider;
        this.bodyInterceptor = bodyInterceptor;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
    }

    public rx.e<ListApps> getTrendingApps(int i2, int i3) {
        long j2 = i3;
        ListAppsRequest.Body body = new ListAppsRequest.Body(this.storeCredentialsProvider.get(j2), i2, this.sharedPreferences, ListAppsRequest.Sort.trending60d);
        body.setStoreId(j2);
        return new ListAppsRequest(body, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false);
    }
}
