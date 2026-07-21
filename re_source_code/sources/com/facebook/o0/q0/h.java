package com.facebook.o0.q0;

import android.content.Context;
import com.facebook.g0;
import com.facebook.internal.j0;
import com.facebook.internal.p0;
import com.facebook.internal.q;
import com.facebook.o0.a0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppEventsLoggerUtility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final h a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<a, String> f10415b = q0.k(s.a(a.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL"), s.a(a.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS"));

    /* JADX INFO: compiled from: AppEventsLoggerUtility.kt */
    public enum a {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            return (a[]) Arrays.copyOf(aVarArrValuesCustom, aVarArrValuesCustom.length);
        }
    }

    private h() {
    }

    public static final JSONObject a(a aVar, q qVar, String str, boolean z, Context context) throws JSONException {
        kotlin.jvm.internal.m.f(aVar, "activityType");
        kotlin.jvm.internal.m.f(context, "context");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", f10415b.get(aVar));
        String strE = a0.a.e();
        if (strE != null) {
            jSONObject.put("app_user_id", strE);
        }
        p0 p0Var = p0.a;
        p0.C0(jSONObject, qVar, str, z, context);
        try {
            p0.D0(jSONObject, context);
        } catch (Exception e2) {
            j0.a.c(g0.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e2.toString());
        }
        p0 p0Var2 = p0.a;
        JSONObject jSONObjectA = p0.A();
        if (jSONObjectA != null) {
            Iterator<String> itKeys = jSONObjectA.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObjectA.get(next));
            }
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
