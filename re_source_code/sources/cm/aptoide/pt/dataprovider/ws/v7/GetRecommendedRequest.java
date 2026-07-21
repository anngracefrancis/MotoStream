package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.ListApps;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetRecommendedRequest extends V7<ListApps, Body> {
    public GetRecommendedRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_V7_CACHE_HOST);
        sb.append("/api/7.20240701/");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<ListApps> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getRecommended(z ? "no-cache" : null, getQueryStringMapper().map((Body) this.body));
    }

    public static class Body extends BaseBody implements Endless {
        private Integer limit;
        private int offset;
        private String packageName;
        private String section;

        public Body(int i2, String str) {
            this.limit = Integer.valueOf(i2);
            this.packageName = str;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public Integer getLimit() {
            return this.limit;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public int getOffset() {
            return this.offset;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getSection() {
            return this.section;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public void setOffset(int i2) {
            this.offset = i2;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setSection(String str) {
            this.section = str;
        }

        public Body(int i2, String str, String str2) {
            this.limit = Integer.valueOf(i2);
            this.packageName = str;
            this.section = str2;
        }
    }
}
