package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.GetFollowers;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetFollowingRequest extends V7<GetFollowers, GetFollowersRequest.Body> {
    protected GetFollowingRequest(GetFollowersRequest.Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static GetFollowingRequest of(BodyInterceptor<BaseBody> bodyInterceptor, Long l, Long l2, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetFollowersRequest.Body body = new GetFollowersRequest.Body();
        body.setUserId(l);
        body.setStoreId(l2);
        return new GetFollowingRequest(body, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetFollowers> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getTimelineGetFollowing((GetFollowersRequest.Body) this.body, z);
    }
}
