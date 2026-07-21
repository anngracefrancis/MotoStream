package cm.aptoide.pt;

import android.os.Bundle;
import cm.aptoide.analytics.AnalyticsManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AptoideApplicationAnalytics {
    private static final String APTOIDE_PACKAGE = "aptoide_package";
    private static final String CONTEXT = "APPLICATION";
    public static final String IS_ANDROID_TV = "Is_Android_Tv";
    private static final String IS_ANDROID_TV_FIELD = "is_android_tv";
    private final AnalyticsManager analyticsManager;
    private final FirebaseAnalytics firebaseAnalytics;

    public AptoideApplicationAnalytics(AnalyticsManager analyticsManager, FirebaseAnalytics firebaseAnalytics) {
        this.analyticsManager = analyticsManager;
        this.firebaseAnalytics = firebaseAnalytics;
    }

    private JSONObject addJsonLoginSuperProperty(boolean z, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("logged_in", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void sendIsTvEvent(boolean z) {
        HashMap map = new HashMap();
        map.put(IS_ANDROID_TV_FIELD, Boolean.valueOf(z));
        this.analyticsManager.logEvent(map, IS_ANDROID_TV, AnalyticsManager.Action.AUTO, CONTEXT);
    }

    public void setPackageDimension(String str) {
        new Bundle().putString(APTOIDE_PACKAGE, str);
        e.d.a.b.C0255b.a(APTOIDE_PACKAGE, str);
    }

    public void setVersionCodeDimension(String str) {
        new Bundle().putString("version code", str);
        e.d.a.b.C0255b.a("version code", str);
    }

    public void updateDimension(boolean z) {
        new Bundle().putString("Logged In", z ? "Logged In" : "Not Logged In");
        e.d.a.b.C0255b.a("Logged In", z ? "Logged In" : "Not Logged In");
        io.rakam.api.f.a().c0(addJsonLoginSuperProperty(z, io.rakam.api.f.a().x()));
        e.f.a.a.a.f("logged_in", z);
        this.firebaseAnalytics.b("logged_in", String.valueOf(z));
    }
}
