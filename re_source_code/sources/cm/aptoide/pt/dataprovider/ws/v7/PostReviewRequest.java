package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class PostReviewRequest extends V7<BaseV7Response, Body> {
    protected PostReviewRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_WRITE_V7_HOST);
        sb.append("/api/7/");
        return sb.toString();
    }

    public static PostReviewRequest of(String str, String str2, String str3, Integer num, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, boolean z, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new PostReviewRequest(new Body(str, str2, str3, num, z), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<BaseV7Response> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.postReview((Body) this.body, true);
    }

    public static PostReviewRequest of(String str, String str2, Integer num, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, boolean z, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new PostReviewRequest(new Body(str, str2, num, z), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    public static class Body extends BaseBody {
        private final boolean appInstalled;
        private String body;
        private String packageName;
        private Integer rating;
        private String storeName;

        public Body(String str, String str2, Integer num, boolean z) {
            this.packageName = str;
            this.body = str2;
            this.rating = num;
            this.appInstalled = z;
        }

        public String getBody() {
            return this.body;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public Integer getRating() {
            return this.rating;
        }

        public String getStoreName() {
            return this.storeName;
        }

        public boolean isAppInstalled() {
            return this.appInstalled;
        }

        public void setBody(String str) {
            this.body = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setRating(Integer num) {
            this.rating = num;
        }

        public void setStoreName(String str) {
            this.storeName = str;
        }

        public Body(String str, String str2, String str3, Integer num, boolean z) {
            this.storeName = str;
            this.packageName = str2;
            this.body = str3;
            this.rating = num;
            this.appInstalled = z;
        }
    }
}
