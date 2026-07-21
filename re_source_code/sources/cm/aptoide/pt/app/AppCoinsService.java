package cm.aptoide.pt.app;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.AppCoinsCampaign;
import cm.aptoide.pt.dataprovider.model.v7.ListAppCoinsCampaigns;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.GetAppCoinsCampaignsRequest;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AppCoinsService {
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Converter.Factory converterFactory;
    private final OkHttpClient httpClient;
    private final SharedPreferences preferences;
    private final TokenInvalidator tokenInvalidator;

    public AppCoinsService(OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, BodyInterceptor<BaseBody> bodyInterceptor, Converter.Factory factory) {
        this.httpClient = okHttpClient;
        this.tokenInvalidator = tokenInvalidator;
        this.preferences = sharedPreferences;
        this.bodyInterceptor = bodyInterceptor;
        this.converterFactory = factory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: mapAdvertising, reason: merged with bridge method [inline-methods] */
    public AppCoinsAdvertisingModel a(ListAppCoinsCampaigns listAppCoinsCampaigns) {
        List<AppCoinsCampaign> list = listAppCoinsCampaigns.getDataList().getList();
        if (list.isEmpty()) {
            return new AppCoinsAdvertisingModel();
        }
        return new AppCoinsAdvertisingModel(list.get(0).getReward().getAppc(), true, list.get(0).getReward().getFiat().getAmount(), list.get(0).getReward().getFiat().getSymbol(), list.get(0).getBudget() != null ? list.get(0).getBudget().getAppc() : -1.0d, list.get(0).getEndDate() != null ? list.get(0).getEndDate() : HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public Single<AppCoinsAdvertisingModel> getValidCampaign(String str, int i2) {
        return new GetAppCoinsCampaignsRequest(new GetAppCoinsCampaignsRequest.Body(str, i2), this.httpClient, this.converterFactory, this.bodyInterceptor, this.tokenInvalidator, this.preferences).observe().Z0().n(new rx.m.e() { // from class: cm.aptoide.pt.app.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4109f.a((ListAppCoinsCampaigns) obj);
            }
        });
    }
}
