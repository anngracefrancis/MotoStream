package cm.aptoide.pt.dataprovider.ws.v1.notification;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import cm.aptoide.pt.dataprovider.model.v1.GetPullNotificationsResponse;
import cm.aptoide.pt.dataprovider.ws.v1.PnpV1WebService;
import cm.aptoide.pt.dataprovider.ws.v1.Service;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import cm.aptoide.pt.utils.AptoideUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class PullCampaignNotificationsRequest extends PnpV1WebService<List<GetPullNotificationsResponse>> {
    private final String id;
    private final Map<String, String> options;

    protected PullCampaignNotificationsRequest(String str, Map<String, String> map, OkHttpClient okHttpClient, Converter.Factory factory, SharedPreferences sharedPreferences) {
        super(okHttpClient, factory, sharedPreferences);
        this.options = map;
        this.id = str;
    }

    public static PullCampaignNotificationsRequest of(String str, String str2, String str3, OkHttpClient okHttpClient, Converter.Factory factory, String str4, SharedPreferences sharedPreferences, Resources resources) {
        HashMap map = new HashMap();
        map.put("language", AptoideUtils.SystemU.getCountryCode(resources));
        map.put("aptoide_version", str2);
        if (!TextUtils.isEmpty(str4)) {
            map.put("oem_id", str4);
        }
        map.put("aptoide_package", str3);
        if (ToolboxManager.isDebug(sharedPreferences)) {
            map.put("debug", "true");
        }
        return new PullCampaignNotificationsRequest(str, map, okHttpClient, factory, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<List<GetPullNotificationsResponse>> loadDataFromNetwork(Service service, boolean z) {
        return service.getPullCampaignNotifications(this.id, this.options, true);
    }
}
