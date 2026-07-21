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
public class GetPackagePromotionsRequest extends V7<GetPackagePromotionsResponse, Body> {

    public static class Body extends BaseBody {
        private String packageName;

        public Body(String str) {
            this.packageName = str;
        }

        public String getPackageName() {
            return this.packageName;
        }
    }

    public GetPackagePromotionsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static GetPackagePromotionsRequest of(String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new GetPackagePromotionsRequest(new Body(str), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<GetPackagePromotionsResponse> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getPromotionsForPackage((Body) this.body, z);
    }
}
