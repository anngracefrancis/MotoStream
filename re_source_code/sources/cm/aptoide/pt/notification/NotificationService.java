package cm.aptoide.pt.notification;

import android.content.SharedPreferences;
import android.content.res.Resources;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.dataprovider.model.v1.GetPullNotificationsResponse;
import cm.aptoide.pt.dataprovider.ws.v1.notification.PullCampaignNotificationsRequest;
import cm.aptoide.pt.networking.IdsRepository;
import java.util.LinkedList;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class NotificationService {
    private final AptoideAccountManager accountManager;
    private final String applicationId;
    private final Converter.Factory converterFactory;
    private final String extraId;
    private final OkHttpClient httpClient;
    private final IdsRepository idsRepository;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final String versionName;

    public NotificationService(String str, OkHttpClient okHttpClient, Converter.Factory factory, IdsRepository idsRepository, String str2, String str3, SharedPreferences sharedPreferences, Resources resources, AptoideAccountManager aptoideAccountManager) {
        this.applicationId = str;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.idsRepository = idsRepository;
        this.versionName = str2;
        this.extraId = str3;
        this.sharedPreferences = sharedPreferences;
        this.resources = resources;
        this.accountManager = aptoideAccountManager;
    }

    private List<AptoideNotification> convertCampaignNotifications(List<GetPullNotificationsResponse> list, String str) {
        String str2;
        String appGraphic;
        LinkedList linkedList = new LinkedList();
        for (GetPullNotificationsResponse getPullNotificationsResponse : list) {
            if (getPullNotificationsResponse.getAttr() != null) {
                String appName = getPullNotificationsResponse.getAttr().getAppName();
                appGraphic = getPullNotificationsResponse.getAttr().getAppGraphic();
                str2 = appName;
            } else {
                str2 = null;
                appGraphic = null;
            }
            linkedList.add(new AptoideNotification(getPullNotificationsResponse.getBody(), getPullNotificationsResponse.getImg(), getPullNotificationsResponse.getTitle(), getPullNotificationsResponse.getUrl(), 0, str2, appGraphic, -1L, str, getPullNotificationsResponse.getUrlTrack(), getPullNotificationsResponse.getUrlTrackNc(), false, System.currentTimeMillis(), getPullNotificationsResponse.getExpire(), getPullNotificationsResponse.getAbTestingGroup(), getPullNotificationsResponse.getCampaignId(), getPullNotificationsResponse.getLang(), -1, getPullNotificationsResponse.getWhitelistedPackages()));
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getCampaignNotifications$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(String str) {
        return PullCampaignNotificationsRequest.of(str, this.versionName, this.applicationId, this.httpClient, this.converterFactory, this.extraId, this.sharedPreferences, this.resources).observe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getCampaignNotifications$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ List b(List list, Account account) {
        return convertCampaignNotifications(list, account.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getCampaignNotifications$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(final List list) {
        return this.accountManager.accountStatus().E().X(new rx.m.e() { // from class: cm.aptoide.pt.notification.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6791f.b(list, (Account) obj);
            }
        });
    }

    public Single<List<AptoideNotification>> getCampaignNotifications() {
        return this.idsRepository.getUniqueIdentifier().k(new rx.m.e() { // from class: cm.aptoide.pt.notification.w
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6811f.a((String) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.notification.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6815f.c((List) obj);
            }
        }).E().Z0();
    }
}
