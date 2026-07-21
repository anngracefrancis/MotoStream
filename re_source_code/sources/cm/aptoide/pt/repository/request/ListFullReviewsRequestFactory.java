package cm.aptoide.pt.repository.request;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.ListFullReviewsRequest;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
class ListFullReviewsRequestFactory {
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Converter.Factory converterFactory;
    private final OkHttpClient httpClient;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    public ListFullReviewsRequestFactory(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        this.bodyInterceptor = bodyInterceptor;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
    }

    public ListFullReviewsRequest newListFullReviews(String str, boolean z, BaseRequestWithStore.StoreCredentials storeCredentials) {
        return ListFullReviewsRequest.ofAction(str, z, storeCredentials, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
    }
}
