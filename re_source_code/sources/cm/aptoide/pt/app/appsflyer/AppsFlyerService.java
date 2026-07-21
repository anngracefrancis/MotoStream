package cm.aptoide.pt.app.appsflyer;

import kotlin.Metadata;
import okhttp3.HttpUrl;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Single;

/* JADX INFO: compiled from: AppsFlyerService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'¨\u0006\u0006"}, d2 = {"Lcm/aptoide/pt/app/appsflyer/AppsFlyerService;", HttpUrl.FRAGMENT_ENCODE_SET, "registerImpression", "Lrx/Single;", "Lretrofit2/Response;", "Lcm/aptoide/pt/app/appsflyer/AppsFlyerResponse;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AppsFlyerService {
    @GET("com.igg.android.lordsmobile?pid=aptoide_int&af_siteid=aptoide&c=project42&af_click_lookback=7d&af_ad_id=android&af_channel=editorial&af_ad=article&af_c_id=com.igg.android.lordsmobile")
    Single<Response<AppsFlyerResponse>> registerImpression();
}
