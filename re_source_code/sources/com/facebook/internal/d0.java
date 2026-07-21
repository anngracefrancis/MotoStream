package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.GraphRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FetchedAppSettingsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d0 {
    public static final d0 a = new d0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9751b = d0.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f9752c = kotlin.collections.u.m("supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url", "restrictive_data_filter_params", "aam_rules", "suggested_events_setting", "protected_mode_rules");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, c0> f9753d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReference<a> f9754e = new AtomicReference<>(a.NOT_LOADED);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<b> f9755f = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f9756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static JSONArray f9757h;

    /* JADX INFO: compiled from: FetchedAppSettingsManager.kt */
    public enum a {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            return (a[]) Arrays.copyOf(aVarArrValuesCustom, aVarArrValuesCustom.length);
        }
    }

    /* JADX INFO: compiled from: FetchedAppSettingsManager.kt */
    public interface b {
        void a(c0 c0Var);

        void onError();
    }

    private d0() {
    }

    public static final void a(b bVar) {
        kotlin.jvm.internal.m.f(bVar, "callback");
        f9755f.add(bVar);
        g();
    }

    private final JSONObject b(String str) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(f9752c);
        bundle.putString("fields", TextUtils.join(",", arrayList));
        GraphRequest graphRequestX = GraphRequest.a.x(null, "app", null);
        graphRequestX.E(true);
        graphRequestX.H(bundle);
        JSONObject jSONObjectD = graphRequestX.j().d();
        return jSONObjectD == null ? new JSONObject() : jSONObjectD;
    }

    public static final c0 c(String str) {
        if (str != null) {
            return f9753d.get(str);
        }
        return null;
    }

    public static final void g() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        final Context contextC = com.facebook.a0.c();
        final String strD = com.facebook.a0.d();
        p0 p0Var = p0.a;
        if (p0.a0(strD)) {
            f9754e.set(a.ERROR);
            a.l();
            return;
        }
        if (f9753d.containsKey(strD)) {
            f9754e.set(a.SUCCESS);
            a.l();
            return;
        }
        AtomicReference<a> atomicReference = f9754e;
        a aVar = a.NOT_LOADED;
        a aVar2 = a.LOADING;
        if (!(atomicReference.compareAndSet(aVar, aVar2) || atomicReference.compareAndSet(a.ERROR, aVar2))) {
            a.l();
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        final String str = String.format("com.facebook.internal.APP_SETTINGS.%s", Arrays.copyOf(new Object[]{strD}, 1));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        com.facebook.a0.k().execute(new Runnable() { // from class: com.facebook.internal.f
            @Override // java.lang.Runnable
            public final void run() {
                d0.h(contextC, str, strD);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Context context, String str, String str2) {
        JSONObject jSONObject;
        kotlin.jvm.internal.m.f(context, "$context");
        kotlin.jvm.internal.m.f(str, "$settingsKey");
        kotlin.jvm.internal.m.f(str2, "$applicationId");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
        c0 c0VarI = null;
        String string = sharedPreferences.getString(str, null);
        p0 p0Var = p0.a;
        if (!p0.a0(string)) {
            if (string == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e2) {
                p0 p0Var2 = p0.a;
                p0.i0("FacebookSDK", e2);
                jSONObject = null;
            }
            if (jSONObject != null) {
                c0VarI = a.i(str2, jSONObject);
            }
        }
        d0 d0Var = a;
        JSONObject jSONObjectB = d0Var.b(str2);
        if (jSONObjectB != null) {
            d0Var.i(str2, jSONObjectB);
            sharedPreferences.edit().putString(str, jSONObjectB.toString()).apply();
        }
        if (c0VarI != null) {
            String strJ = c0VarI.j();
            if (!f9756g && strJ != null && strJ.length() > 0) {
                f9756g = true;
                Log.w(f9751b, strJ);
            }
        }
        b0 b0Var = b0.a;
        b0.m(str2, true);
        com.facebook.o0.q0.i iVar = com.facebook.o0.q0.i.a;
        com.facebook.o0.q0.i.d();
        f9754e.set(f9753d.containsKey(str2) ? a.SUCCESS : a.ERROR);
        d0Var.l();
    }

    private final Map<String, Map<String, c0.b>> j(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        HashMap map = new HashMap();
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("data")) != null) {
            int i2 = 0;
            int length = jSONArrayOptJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    c0.b.a aVar = c0.b.a;
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    kotlin.jvm.internal.m.e(jSONObjectOptJSONObject, "dialogConfigData.optJSONObject(i)");
                    c0.b bVarA = aVar.a(jSONObjectOptJSONObject);
                    if (bVarA != null) {
                        String strA = bVarA.a();
                        Map map2 = (Map) map.get(strA);
                        if (map2 == null) {
                            map2 = new HashMap();
                            map.put(strA, map2);
                        }
                        map2.put(bVarA.b(), bVarA);
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
        }
        return map;
    }

    private final JSONArray k(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    private final synchronized void l() {
        a aVar = f9754e.get();
        if (a.NOT_LOADED != aVar && a.LOADING != aVar) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            final c0 c0Var = f9753d.get(com.facebook.a0.d());
            Handler handler = new Handler(Looper.getMainLooper());
            if (a.ERROR == aVar) {
                while (true) {
                    ConcurrentLinkedQueue<b> concurrentLinkedQueue = f9755f;
                    if (concurrentLinkedQueue.isEmpty()) {
                        return;
                    }
                    final b bVarPoll = concurrentLinkedQueue.poll();
                    handler.post(new Runnable() { // from class: com.facebook.internal.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            d0.m(bVarPoll);
                        }
                    });
                }
            } else {
                while (true) {
                    ConcurrentLinkedQueue<b> concurrentLinkedQueue2 = f9755f;
                    if (concurrentLinkedQueue2.isEmpty()) {
                        return;
                    }
                    final b bVarPoll2 = concurrentLinkedQueue2.poll();
                    handler.post(new Runnable() { // from class: com.facebook.internal.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            d0.n(bVarPoll2, c0Var);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(b bVar) {
        bVar.onError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(b bVar, c0 c0Var) {
        bVar.a(c0Var);
    }

    public static final c0 o(String str, boolean z) {
        kotlin.jvm.internal.m.f(str, "applicationId");
        if (!z) {
            Map<String, c0> map = f9753d;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        d0 d0Var = a;
        JSONObject jSONObjectB = d0Var.b(str);
        if (jSONObjectB == null) {
            return null;
        }
        c0 c0VarI = d0Var.i(str, jSONObjectB);
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (kotlin.jvm.internal.m.a(str, com.facebook.a0.d())) {
            f9754e.set(a.SUCCESS);
            d0Var.l();
        }
        return c0VarI;
    }

    public final c0 i(String str, JSONObject jSONObject) {
        kotlin.jvm.internal.m.f(str, "applicationId");
        kotlin.jvm.internal.m.f(jSONObject, "settingsJSON");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("android_sdk_error_categories");
        x.a aVar = x.a;
        x xVarA = aVar.a(jSONArrayOptJSONArray);
        if (xVarA == null) {
            xVarA = aVar.b();
        }
        x xVar = xVarA;
        int iOptInt = jSONObject.optInt("app_events_feature_bitmask", 0);
        boolean z = (iOptInt & 8) != 0;
        boolean z2 = (iOptInt & 16) != 0;
        boolean z3 = (iOptInt & 32) != 0;
        boolean z4 = (iOptInt & 256) != 0;
        boolean z5 = (iOptInt & Http2.INITIAL_MAX_FRAME_SIZE) != 0;
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("auto_event_mapping_android");
        f9757h = jSONArrayOptJSONArray2;
        if (jSONArrayOptJSONArray2 != null) {
            h0 h0Var = h0.a;
            if (h0.b()) {
                com.facebook.o0.m0.n.e eVar = com.facebook.o0.m0.n.e.a;
                com.facebook.o0.m0.n.e.c(jSONArrayOptJSONArray2 == null ? null : jSONArrayOptJSONArray2.toString());
            }
        }
        boolean zOptBoolean = jSONObject.optBoolean("supports_implicit_sdk_logging", false);
        String strOptString = jSONObject.optString("gdpv4_nux_content", HttpUrl.FRAGMENT_ENCODE_SET);
        kotlin.jvm.internal.m.e(strOptString, "settingsJSON.optString(APP_SETTING_NUX_CONTENT, \"\")");
        boolean zOptBoolean2 = jSONObject.optBoolean("gdpv4_nux_enabled", false);
        com.facebook.o0.q0.j jVar = com.facebook.o0.q0.j.a;
        int iOptInt2 = jSONObject.optInt("app_events_session_timeout", com.facebook.o0.q0.j.a());
        EnumSet<o0> enumSetA = o0.f9810f.a(jSONObject.optLong("seamless_login"));
        Map<String, Map<String, c0.b>> mapJ = j(jSONObject.optJSONObject("android_dialog_configs"));
        String strOptString2 = jSONObject.optString("smart_login_bookmark_icon_url");
        kotlin.jvm.internal.m.e(strOptString2, "settingsJSON.optString(SMART_LOGIN_BOOKMARK_ICON_URL)");
        String strOptString3 = jSONObject.optString("smart_login_menu_icon_url");
        kotlin.jvm.internal.m.e(strOptString3, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String strOptString4 = jSONObject.optString("sdk_update_message");
        kotlin.jvm.internal.m.e(strOptString4, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        c0 c0Var = new c0(zOptBoolean, strOptString, zOptBoolean2, iOptInt2, enumSetA, mapJ, z, xVar, strOptString2, strOptString3, z2, z3, jSONArrayOptJSONArray2, strOptString4, z4, z5, jSONObject.optString("aam_rules"), jSONObject.optString("suggested_events_setting"), jSONObject.optString("restrictive_data_filter_params"), k(jSONObject.optJSONObject("protected_mode_rules"), "standard_params"), k(jSONObject.optJSONObject("protected_mode_rules"), "maca_rules"));
        f9753d.put(str, c0Var);
        return c0Var;
    }
}
