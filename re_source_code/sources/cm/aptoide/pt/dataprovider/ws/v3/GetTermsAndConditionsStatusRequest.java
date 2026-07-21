package cm.aptoide.pt.dataprovider.ws.v3;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v3.TermsAndConditionsResponse;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class GetTermsAndConditionsStatusRequest extends V3<TermsAndConditionsResponse> {
    private GetTermsAndConditionsStatusRequest(BaseBody baseBody, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    public static GetTermsAndConditionsStatusRequest of(BodyInterceptor<BaseBody> bodyInterceptor, Converter.Factory factory, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new GetTermsAndConditionsStatusRequest(new BaseBody(), okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<TermsAndConditionsResponse> loadDataFromNetwork(Service service, boolean z) {
        return service.getTermsAndConditionsStatus(this.map, z);
    }
}
