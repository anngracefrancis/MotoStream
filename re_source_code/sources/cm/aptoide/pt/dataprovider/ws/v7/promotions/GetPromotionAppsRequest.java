package cm.aptoide.pt.dataprovider.ws.v7.promotions;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class GetPromotionAppsRequest extends V7<GetPromotionAppsResponse, Body> {

    public static class Body extends BaseBody {
        private String promotionId;

        public Body(String str) {
            this.promotionId = str;
        }

        public String getPromotionId() {
            return this.promotionId;
        }
    }

    public GetPromotionAppsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static GetPromotionAppsRequest of(String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new GetPromotionAppsRequest(new Body(str), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<GetPromotionAppsResponse> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getPromotionApps(30, (Body) this.body, z, true);
    }
}
