package cm.aptoide.pt.dataprovider.ws.v3;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v3.OAuth;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class OAuth2AuthenticationRequest extends V3<OAuth> {
    public OAuth2AuthenticationRequest(BaseBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    public static OAuth2AuthenticationRequest of(String str, String str2, String str3, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, String str4, String str5) {
        BaseBody baseBody = new BaseBody();
        baseBody.put("grant_type", "code");
        baseBody.put("client_id", BuildConfig.MARKET_NAME);
        baseBody.put("mode", BodyInterceptorV3.RESPONSE_MODE_JSON);
        if (str3 != null) {
            switch (str3) {
                case "APTOIDE":
                    baseBody.put("username", str);
                    baseBody.put("code", str2);
                    break;
                case "ABAN":
                    baseBody.put("oauthUserName", str);
                    baseBody.put("oauthToken", str2);
                    baseBody.put("authMode", str5);
                    break;
                case "FACEBOOK":
                case "GOOGLE":
                    baseBody.put("authMode", str5);
                    baseBody.put("oauthToken", str2);
                    break;
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            baseBody.put("oem_id", str4);
        }
        return new OAuth2AuthenticationRequest(baseBody, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<OAuth> loadDataFromNetwork(Service service, boolean z) {
        return service.oauth2Authentication(this.map, z);
    }

    public static OAuth2AuthenticationRequest of(String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, String str2) {
        BaseBody baseBody = new BaseBody();
        baseBody.put("grant_type", AuthenticationPersistence.ACCOUNT_REFRESH_TOKEN);
        baseBody.put("client_id", BuildConfig.MARKET_NAME);
        baseBody.put("mode", BodyInterceptorV3.RESPONSE_MODE_JSON);
        if (!TextUtils.isEmpty(str2)) {
            baseBody.put("oem_id", str2);
        }
        baseBody.put(AuthenticationPersistence.ACCOUNT_REFRESH_TOKEN, str);
        return new OAuth2AuthenticationRequest(baseBody, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }
}
