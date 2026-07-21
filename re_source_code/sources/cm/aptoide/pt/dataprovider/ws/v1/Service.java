package cm.aptoide.pt.dataprovider.ws.v1;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.model.v1.GetPullNotificationsResponse;
import java.util.List;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public interface Service {
    @GET("notifications/{id}/campaigns")
    e<List<GetPullNotificationsResponse>> getPullCampaignNotifications(@Path(DeepLinkIntentReceiver.DeepLinksKeys.ID) String str, @QueryMap Map<String, String> map, @Header(WebService.BYPASS_HEADER_KEY) boolean z);
}
