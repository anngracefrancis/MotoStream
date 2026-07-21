package cm.aptoide.pt.dataprovider.ws.v3;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v2.GenericResponseV2;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class AddApkFlagRequest extends V3<GenericResponseV2> {
    protected AddApkFlagRequest(BaseBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    public static AddApkFlagRequest of(String str, String str2, String str3, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        BaseBody baseBody = new BaseBody();
        baseBody.put("repo", str);
        baseBody.put("md5sum", str2);
        baseBody.put("flag", str3);
        baseBody.put("mode", BodyInterceptorV3.RESPONSE_MODE_JSON);
        return new AddApkFlagRequest(baseBody, bodyInterceptor, okHttpClient, WebService.getDefaultConverter(), tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<GenericResponseV2> loadDataFromNetwork(Service service, boolean z) {
        return service.addApkFlag(this.map, z);
    }
}
