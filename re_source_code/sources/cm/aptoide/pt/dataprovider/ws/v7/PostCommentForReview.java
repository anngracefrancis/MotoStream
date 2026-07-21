package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.util.CommentType;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class PostCommentForReview extends V7<BaseV7Response, Body> {

    public static class Body extends BaseBody {
        private String body;
        private String commentType = CommentType.REVIEW.name();
        private long reviewId;

        public Body(long j2, String str) {
            this.reviewId = j2;
            this.body = str;
        }

        public String getBody() {
            return this.body;
        }

        public String getCommentType() {
            return this.commentType;
        }

        public long getReviewId() {
            return this.reviewId;
        }

        public void setBody(String str) {
            this.body = str;
        }

        public void setCommentType(String str) {
            this.commentType = str;
        }

        public void setReviewId(long j2) {
            this.reviewId = j2;
        }
    }

    protected PostCommentForReview(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
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

    public static PostCommentForReview of(long j2, String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new PostCommentForReview(new Body(j2, str), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<BaseV7Response> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.postReviewComment((Body) this.body, true);
    }
}
