package cm.aptoide.pt.analytics;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import cm.aptoide.analytics.AnalyticsLogger;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.pt.GmsStatusValueProvider;
import cm.aptoide.pt.account.AdultContentAnalytics;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.preferences.secure.SecurePreferences;
import com.facebook.o0.a0;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class FirstLaunchAnalytics {
    private static final String APTOIDE_PACKAGE = "aptoide_package";
    private static final String CATEGORY = "category";
    private static final String CONTEXT = "APPLICATION";
    private static final String ENTRY_POINT = "Entry Point";
    private static final String ENTRY_POINT_RAKAM = "entry_point";
    public static final String FIRST_LAUNCH = "Aptoide_First_Launch";
    public static final String FIRST_LAUNCH_RAKAM = "aptoide_first_launch";
    private static final String FLAGGED = "flagged";
    private static final String GMS = "GMS";
    private static final String GMS_RAKAM = "gms";
    private static final String IS_ACTIVE = "is_active";
    public static final String PLAY_PROTECT_EVENT = "Google_Play_Protect";
    private static final String TAG = "FirstLaunchAnalytics";
    private static final String UNKNOWN = "unknown";
    private static final String UTM_CAMPAIGN = "UTM Campaign";
    private static final String UTM_CAMPAIGN_RAKAM = "utm_campaign";
    private static final String UTM_CONTENT = "UTM Content";
    private static final String UTM_CONTENT_RAKAM = "utm_content";
    private static final String UTM_MEDIUM = "UTM Medium";
    private static final String UTM_MEDIUM_RAKAM = "utm_medium";
    private static final String UTM_PACKAGE_NAME = "utm_package_name";
    private static final String UTM_SOURCE = "UTM Source";
    private static final String UTM_SOURCE_RAKAM = "utm_source";
    private static final String UTM_TERM_RAKAM = "utm_term";
    private final AnalyticsManager analyticsManager;
    private final GmsStatusValueProvider gmsStatusValueProvider;
    private final AnalyticsLogger logger;
    private final String packageName;
    private final SafetyNetClient safetyNetClient;
    private String utmSource = UNKNOWN;
    private String utmMedium = UNKNOWN;
    private String utmCampaign = UNKNOWN;
    private String utmContent = UNKNOWN;
    private String entryPoint = UNKNOWN;

    public FirstLaunchAnalytics(AnalyticsManager analyticsManager, AnalyticsLogger analyticsLogger, SafetyNetClient safetyNetClient, String str, GmsStatusValueProvider gmsStatusValueProvider) {
        this.analyticsManager = analyticsManager;
        this.logger = analyticsLogger;
        this.safetyNetClient = safetyNetClient;
        this.packageName = str;
        this.gmsStatusValueProvider = gmsStatusValueProvider;
    }

    private JSONObject addFirstLaunchProperties(boolean z, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("first_session", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private Map<String, Object> createFacebookFirstLaunchDataMap(String str, String str2, String str3, String str4, String str5) {
        HashMap map = new HashMap();
        map.put(UTM_SOURCE, str);
        map.put(UTM_MEDIUM, str2);
        map.put(UTM_CAMPAIGN, str3);
        map.put(UTM_CONTENT, str4);
        map.put(ENTRY_POINT, str5);
        return map;
    }

    private String getCategoryFlaggedByPlayProtect(List<HarmfulAppsData> list) {
        for (HarmfulAppsData harmfulAppsData : list) {
            if (harmfulAppsData.f18250f.equals(this.packageName)) {
                return getPlayProtectCategoryName(harmfulAppsData.f18252h);
            }
        }
        return null;
    }

    private String getPlayProtectCategoryName(int i2) {
        switch (i2) {
            case 1:
                return "RANSOMWARE";
            case 2:
                return "PHISHING";
            case 3:
                return "TROJAN";
            case 4:
                return "UNCOMMON";
            case 5:
                return "FRAUDWARE";
            case 6:
                return "TOLL_FRAUD";
            case 7:
                return "WAP_FRAUD";
            case 8:
                return "CALL_FRAUD";
            case 9:
                return "BACKDOOR";
            case 10:
                return "SPYWARE";
            case 11:
                return "GENERIC_MALWARE";
            case 12:
                return "HARMFUL_SITE";
            case 13:
                return "WINDOWS_MALWARE";
            case 14:
                return "HOSTILE_DOWNLOADER";
            case 15:
                return "NON_ANDROID_THREAT";
            case 16:
                return "ROOTING";
            case 17:
                return "PRIVILEGE_ESCALATION";
            case 18:
                return "TRACKING";
            case 19:
                return "SPAM";
            case 20:
                return "DENIAL_OF_SERVICE";
            case 21:
                return "DATA_COLLECTION";
            default:
                return "UNKNOWN_CATEGORY";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$sendAppStart$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(SharedPreferences sharedPreferences, String str) {
        setupFirstLaunchSuperProperty(SecurePreferences.isFirstRun(sharedPreferences));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$sendAppStart$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(String str) {
        sendPlayProtectEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$sendAppStart$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(String str) {
        sendFirstLaunchEvent(this.utmSource, this.utmMedium, this.utmCampaign, this.utmContent, this.entryPoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$sendPlayProtectEvent$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Task task) {
        String categoryFlaggedByPlayProtect;
        boolean z = true;
        boolean z2 = false;
        if (task.n()) {
            categoryFlaggedByPlayProtect = getCategoryFlaggedByPlayProtect(((SafetyNetApi.HarmfulAppsResponse) task.j()).h());
            if (categoryFlaggedByPlayProtect != null) {
                z2 = true;
            }
        } else {
            categoryFlaggedByPlayProtect = null;
            z = false;
        }
        HashMap map = new HashMap();
        map.put(IS_ACTIVE, z ? "true" : AdultContentAnalytics.UNLOCK);
        map.put(FLAGGED, z2 ? "true" : AdultContentAnalytics.UNLOCK);
        map.put(CATEGORY, categoryFlaggedByPlayProtect);
        this.analyticsManager.logEvent(map, PLAY_PROTECT_EVENT, AnalyticsManager.Action.OPEN, CONTEXT);
    }

    private void sendFirstLaunchEvent(String str, String str2, String str3, String str4, String str5) {
        AnalyticsManager analyticsManager = this.analyticsManager;
        Map<String, Object> mapCreateFacebookFirstLaunchDataMap = createFacebookFirstLaunchDataMap(str, str2, str3, str4, str5);
        AnalyticsManager.Action action = AnalyticsManager.Action.OPEN;
        analyticsManager.logEvent(mapCreateFacebookFirstLaunchDataMap, FIRST_LAUNCH, action, CONTEXT);
        this.analyticsManager.logEvent(new HashMap(), FIRST_LAUNCH_RAKAM, action, CONTEXT);
    }

    private void sendPlayProtectEvent() {
        this.safetyNetClient.m().b(new OnCompleteListener() { // from class: cm.aptoide.pt.analytics.a
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void a(Task task) {
                this.a.d(task);
            }
        });
    }

    private void setUserProperties(String str, String str2) {
        new Bundle().putString(str, str2);
        e.d.a.b.C0255b.a(str, str2);
    }

    private void setupFirstLaunchSuperProperty(boolean z) {
        io.rakam.api.f.a().c0(addFirstLaunchProperties(z, io.rakam.api.f.a().x()));
        HashMap map = new HashMap();
        map.put("first_session", Boolean.valueOf(z));
        map.put(APTOIDE_PACKAGE, this.packageName);
        e.f.a.a.a.c(map);
    }

    public rx.b sendAppStart(Application application, final SharedPreferences sharedPreferences, IdsRepository idsRepository) {
        return idsRepository.getUniqueIdentifier().g(new rx.m.b() { // from class: cm.aptoide.pt.analytics.f
            @Override // rx.m.b
            public final void call(Object obj) {
                a0.f((String) obj);
            }
        }).A().x(new rx.m.b() { // from class: cm.aptoide.pt.analytics.e
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4101f.a(sharedPreferences, (String) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.analytics.c
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4099f.b((String) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.analytics.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(SecurePreferences.isFirstRun(sharedPreferences));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.analytics.d
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4100f.c((String) obj);
            }
        }).X0().K(Schedulers.io());
    }

    public void sendIndicativeFirstLaunchSourceUserProperties(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap map = new HashMap();
        map.put(GMS_RAKAM, this.gmsStatusValueProvider.getGmsValue());
        map.put(UTM_CONTENT_RAKAM, str);
        map.put(UTM_SOURCE_RAKAM, str2);
        map.put(UTM_CAMPAIGN_RAKAM, str3);
        map.put(UTM_MEDIUM_RAKAM, str4);
        map.put(UTM_TERM_RAKAM, str5);
        map.put(UTM_PACKAGE_NAME, str6);
        e.f.a.a.a.c(map);
    }

    public void setGmsPresent() {
        setUserProperties(GMS, this.gmsStatusValueProvider.getGmsValue());
    }
}
