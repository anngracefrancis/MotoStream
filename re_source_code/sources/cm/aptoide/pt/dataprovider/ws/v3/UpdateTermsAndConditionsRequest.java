package cm.aptoide.pt.dataprovider.ws.v3;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v3.BaseV3Response;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class UpdateTermsAndConditionsRequest extends V3<BaseV3Response> {
    private UpdateTermsAndConditionsRequest(BaseBody baseBody, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    public static UpdateTermsAndConditionsRequest of(BodyInterceptor<BaseBody> bodyInterceptor, Converter.Factory factory, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new UpdateTermsAndConditionsRequest(new BaseBody(), okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<BaseV3Response> loadDataFromNetwork(Service service, boolean z) {
        return service.updateTermsAndConditions(this.map, z);
    }
}
