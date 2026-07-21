package cm.aptoide.pt.dataprovider.ws.v7.home;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class GetActionItemRequest extends V7<ActionItemResponse, Body> {
    private final String url;

    public static class Body extends BaseBody {
    }

    public GetActionItemRequest(String str, Body body, SharedPreferences sharedPreferences, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator) {
        super(body, getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
        this.url = str;
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_V7_CACHE_HOST);
        sb.append("/api/7.20181019/");
        return sb.toString();
    }

    public static GetActionItemRequest ofAction(String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new GetActionItemRequest(str, new Body(), sharedPreferences, bodyInterceptor, okHttpClient, factory, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<ActionItemResponse> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getActionItem(this.url, getQueryStringMapper().map((Body) this.body), z);
    }
}
