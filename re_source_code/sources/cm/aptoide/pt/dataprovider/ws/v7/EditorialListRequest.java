package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class EditorialListRequest extends V7<EditorialListResponse, Body> {
    private final int limit;

    public static class Body extends BaseBody implements Endless {
        private int limit;
        private int offset;

        public Body(int i2, int i3) {
            this.limit = i2;
            this.offset = i3;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public Integer getLimit() {
            return Integer.valueOf(this.limit);
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public int getOffset() {
            return this.offset;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public void setOffset(int i2) {
            this.offset = i2;
        }
    }

    protected EditorialListRequest(Body body, String str, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator, int i2) {
        super(body, str, okHttpClient, factory, bodyInterceptor, tokenInvalidator);
        this.limit = i2;
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_V7_HOST);
        sb.append("/api/7.20181019/");
        return sb.toString();
    }

    public static EditorialListRequest of(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, int i2, int i3) {
        return new EditorialListRequest(new Body(i2, i3), getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<EditorialListResponse> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getEditorialList(this.limit, (Body) this.body);
    }
}
