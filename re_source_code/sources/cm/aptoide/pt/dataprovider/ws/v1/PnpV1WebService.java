package cm.aptoide.pt.dataprovider.ws.v1;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public abstract class PnpV1WebService<U> extends WebService<Service, U> {
    protected PnpV1WebService(OkHttpClient okHttpClient, Converter.Factory factory, SharedPreferences sharedPreferences) {
        super(Service.class, okHttpClient, factory, getHost(sharedPreferences));
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_NOTIFICATION_HOST);
        sb.append("/pnp/v1/");
        return sb.toString();
    }
}
