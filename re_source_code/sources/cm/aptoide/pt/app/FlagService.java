package cm.aptoide.pt.app;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v2.GenericResponseV2;
import cm.aptoide.pt.dataprovider.ws.v3.AddApkFlagRequest;
import cm.aptoide.pt.dataprovider.ws.v3.BaseBody;
import okhttp3.OkHttpClient;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class FlagService {
    private final BodyInterceptor<BaseBody> bodyInterceptorV3;
    private final OkHttpClient okHttpClient;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    public FlagService(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        this.bodyInterceptorV3 = bodyInterceptor;
        this.okHttpClient = okHttpClient;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
    }

    public Single<GenericResponseV2> doApkFlagRequest(String str, String str2, String str3) {
        return AddApkFlagRequest.of(str, str2, str3, this.bodyInterceptorV3, this.okHttpClient, this.tokenInvalidator, this.sharedPreferences).observe(true).Z0();
    }
}
