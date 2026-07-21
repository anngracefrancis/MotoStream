package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.o0.g0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LoginLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ScheduledExecutorService f10047b = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g0 f10049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10050e;

    /* JADX INFO: compiled from: LoginLogger.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle b(String str) {
            Bundle bundle = new Bundle();
            bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
            bundle.putString("0_auth_logger_id", str);
            bundle.putString("3_method", HttpUrl.FRAGMENT_ENCODE_SET);
            bundle.putString("2_result", HttpUrl.FRAGMENT_ENCODE_SET);
            bundle.putString("5_error_message", HttpUrl.FRAGMENT_ENCODE_SET);
            bundle.putString("4_error_code", HttpUrl.FRAGMENT_ENCODE_SET);
            bundle.putString("6_extras", HttpUrl.FRAGMENT_ENCODE_SET);
            return bundle;
        }
    }

    public w(Context context, String str) {
        PackageInfo packageInfo;
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(str, "applicationId");
        this.f10048c = str;
        this.f10049d = new g0(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) == null) {
                return;
            }
            this.f10050e = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final void g(String str) {
        final Bundle bundleB = a.b(str);
        f10047b.schedule(new Runnable() { // from class: com.facebook.login.l
            @Override // java.lang.Runnable
            public final void run() {
                w.h(this.f10011f, bundleB);
            }
        }, 5L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(w wVar, Bundle bundle) {
        kotlin.jvm.internal.m.f(wVar, "this$0");
        kotlin.jvm.internal.m.f(bundle, "$bundle");
        wVar.f10049d.g("fb_mobile_login_heartbeat", bundle);
    }

    public static /* synthetic */ void k(w wVar, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        wVar.j(str, str2, str3);
    }

    public final String a() {
        return this.f10048c;
    }

    public final void c(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6) {
        Bundle bundleB = a.b(str);
        if (str3 != null) {
            bundleB.putString("2_result", str3);
        }
        if (str4 != null) {
            bundleB.putString("5_error_message", str4);
        }
        if (str5 != null) {
            bundleB.putString("4_error_code", str5);
        }
        if (map != null && (!map.isEmpty())) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            bundleB.putString("6_extras", new JSONObject(linkedHashMap).toString());
        }
        bundleB.putString("3_method", str2);
        this.f10049d.g(str6, bundleB);
    }

    public final void d(String str, String str2, String str3) {
        Bundle bundleB = a.b(str);
        bundleB.putString("3_method", str2);
        this.f10049d.g(str3, bundleB);
    }

    public final void e(String str, String str2, String str3) {
        Bundle bundleB = a.b(str);
        bundleB.putString("3_method", str2);
        this.f10049d.g(str3, bundleB);
    }

    public final void f(String str, Map<String, String> map, LoginClient.Result.a aVar, Map<String, String> map2, Exception exc, String str2) {
        kotlin.jvm.internal.m.f(map, "loggingExtras");
        Bundle bundleB = a.b(str);
        if (aVar != null) {
            bundleB.putString("2_result", aVar.k());
        }
        if ((exc == null ? null : exc.getMessage()) != null) {
            bundleB.putString("5_error_message", exc.getMessage());
        }
        JSONObject jSONObject = map.isEmpty() ^ true ? new JSONObject(map) : null;
        if (map2 != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (key != null) {
                        jSONObject.put(key, value);
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (jSONObject != null) {
            bundleB.putString("6_extras", jSONObject.toString());
        }
        this.f10049d.g(str2, bundleB);
        if (aVar == LoginClient.Result.a.SUCCESS) {
            g(str);
        }
    }

    public final void i(LoginClient.Request request, String str) {
        kotlin.jvm.internal.m.f(request, "pendingLoginRequest");
        Bundle bundleB = a.b(request.b());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("login_behavior", request.j().toString());
            jSONObject.put("request_code", LoginClient.f9960f.b());
            jSONObject.put("permissions", TextUtils.join(",", request.n()));
            jSONObject.put("default_audience", request.g().toString());
            jSONObject.put("isReauthorize", request.s());
            String str2 = this.f10050e;
            if (str2 != null) {
                jSONObject.put("facebookVersion", str2);
            }
            if (request.k() != null) {
                jSONObject.put("target_app", request.k().toString());
            }
            bundleB.putString("6_extras", jSONObject.toString());
        } catch (JSONException unused) {
        }
        this.f10049d.g(str, bundleB);
    }

    public final void j(String str, String str2, String str3) {
        Bundle bundleB = a.b(HttpUrl.FRAGMENT_ENCODE_SET);
        bundleB.putString("2_result", LoginClient.Result.a.ERROR.k());
        bundleB.putString("5_error_message", str2);
        bundleB.putString("3_method", str3);
        this.f10049d.g(str, bundleB);
    }
}
