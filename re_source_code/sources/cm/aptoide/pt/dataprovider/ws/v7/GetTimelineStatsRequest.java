package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.TimelineStats;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetTimelineStatsRequest extends V7<TimelineStats, Body> {

    public static class Body extends BaseBody {
        private Long userId;

        public Body(Long l) {
            this.userId = l;
        }

        public Long getUserId() {
            return this.userId;
        }

        public void setUserId(Long l) {
            this.userId = l;
        }
    }

    protected GetTimelineStatsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static GetTimelineStatsRequest of(BodyInterceptor<BaseBody> bodyInterceptor, Long l, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return new GetTimelineStatsRequest(new Body(l), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<TimelineStats> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getTimelineStats((Body) this.body, z);
    }
}
