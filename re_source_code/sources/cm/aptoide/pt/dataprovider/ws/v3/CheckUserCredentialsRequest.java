package cm.aptoide.pt.dataprovider.ws.v3;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v3.CheckUserCredentialsJson;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class CheckUserCredentialsRequest extends V3<CheckUserCredentialsJson> {
    private static final String CREATE_REPO_VALUE = "1";
    private static final String DEFAULT_AUTH_MODE = "aptoide";
    private static final String OAUTH_CREATE_REPO_VALUE = "true";
    private final boolean createStore;

    private CheckUserCredentialsRequest(BaseBody baseBody, boolean z, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.createStore = z;
    }

    public static CheckUserCredentialsRequest toCreateStore(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, String str) {
        BaseBody baseBody = new BaseBody();
        baseBody.put("createRepo", CREATE_REPO_VALUE);
        baseBody.put("oauthCreateRepo", "true");
        baseBody.put("repo", str);
        baseBody.setAuthMode(DEFAULT_AUTH_MODE);
        return new CheckUserCredentialsRequest(baseBody, true, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<CheckUserCredentialsJson> loadDataFromNetwork(Service service, boolean z) {
        return this.createStore ? service.checkUserCredentials(this.map, z) : service.getUserInfo(this.map, z);
    }
}
