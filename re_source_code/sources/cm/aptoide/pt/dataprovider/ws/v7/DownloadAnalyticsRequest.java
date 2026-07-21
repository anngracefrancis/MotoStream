package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.analyticsbody.DownloadInstallAnalyticsBaseBody;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class DownloadAnalyticsRequest extends V7<BaseV7Response, DownloadInstallAnalyticsBaseBody> {
    private String action;
    private String context;
    private String name;

    protected DownloadAnalyticsRequest(DownloadInstallAnalyticsBaseBody downloadInstallAnalyticsBaseBody, String str, String str2, String str3, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(downloadInstallAnalyticsBaseBody, V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
        this.action = str;
        this.name = str2;
        this.context = str3;
    }

    public static DownloadAnalyticsRequest of(DownloadInstallAnalyticsBaseBody downloadInstallAnalyticsBaseBody, String str, String str2, String str3, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new DownloadAnalyticsRequest(downloadInstallAnalyticsBaseBody, str, str2, str3, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<BaseV7Response> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.addEvent(this.name, this.action, this.context, (DownloadInstallAnalyticsBaseBody) this.body);
    }
}
