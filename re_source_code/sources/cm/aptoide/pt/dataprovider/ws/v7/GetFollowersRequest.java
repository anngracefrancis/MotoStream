package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.GetFollowers;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetFollowersRequest extends V7<GetFollowers, Body> {

    public static class Body extends BaseBody implements Endless {
        private int limit = 25;
        private int offset;
        private Long storeId;
        private Long userId;

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public Integer getLimit() {
            return Integer.valueOf(this.limit);
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public int getOffset() {
            return this.offset;
        }

        public Long getStoreId() {
            return this.storeId;
        }

        public Long getUserId() {
            return this.userId;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public void setOffset(int i2) {
            this.offset = i2;
        }

        public void setStoreId(Long l) {
            this.storeId = l;
        }

        public void setUserId(Long l) {
            this.userId = l;
        }
    }

    protected GetFollowersRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static GetFollowersRequest of(BodyInterceptor<BaseBody> bodyInterceptor, Long l, Long l2, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        Body body = new Body();
        body.setUserId(l);
        body.setStoreId(l2);
        return new GetFollowersRequest(body, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetFollowers> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getTimelineFollowers((Body) this.body, z);
    }
}
