package com.facebook.o0.m0;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import com.facebook.internal.p0;
import com.facebook.internal.q;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CodelessManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SensorManager f10267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static l f10268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f10269e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f10272h;
    public static final i a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final m f10266b = new m();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicBoolean f10270f = new AtomicBoolean(true);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicBoolean f10271g = new AtomicBoolean(false);

    private i() {
    }

    private final void a(final String str) {
        if (f10272h) {
            return;
        }
        f10272h = true;
        a0 a0Var = a0.a;
        a0.k().execute(new Runnable() { // from class: com.facebook.o0.m0.b
            @Override // java.lang.Runnable
            public final void run() {
                i.b(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String str) {
        Bundle bundle = new Bundle();
        a0 a0Var = a0.a;
        q qVarE = q.a.e(a0.c());
        JSONArray jSONArray = new JSONArray();
        String str2 = Build.MODEL;
        if (str2 == null) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        jSONArray.put(str2);
        if ((qVarE == null ? null : qVarE.h()) != null) {
            jSONArray.put(qVarE.h());
        } else {
            jSONArray.put(HttpUrl.FRAGMENT_ENCODE_SET);
        }
        jSONArray.put("0");
        com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
        jSONArray.put(com.facebook.o0.q0.g.f() ? "1" : "0");
        p0 p0Var = p0.a;
        Locale localeY = p0.y();
        jSONArray.put(localeY.getLanguage() + '_' + ((Object) localeY.getCountry()));
        String string = jSONArray.toString();
        kotlin.jvm.internal.m.e(string, "extInfoArray.toString()");
        bundle.putString("device_session_id", e());
        bundle.putString("extinfo", string);
        GraphRequest.c cVar = GraphRequest.a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str3 = String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(new Object[]{str}, 1));
        kotlin.jvm.internal.m.e(str3, "java.lang.String.format(locale, format, *args)");
        JSONObject jSONObjectC = cVar.B(null, str3, bundle, null).j().c();
        AtomicBoolean atomicBoolean = f10271g;
        atomicBoolean.set(jSONObjectC != null && jSONObjectC.optBoolean("is_app_indexing_enabled", false));
        if (atomicBoolean.get()) {
            l lVar = f10268d;
            if (lVar != null) {
                lVar.h();
            }
        } else {
            f10269e = null;
        }
        f10272h = false;
    }

    public static final void c() {
        f10270f.set(false);
    }

    public static final void d() {
        f10270f.set(true);
    }

    public static final String e() {
        if (f10269e == null) {
            f10269e = UUID.randomUUID().toString();
        }
        String str = f10269e;
        if (str != null) {
            return str;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public static final boolean f() {
        return f10271g.get();
    }

    private final boolean g() {
        return false;
    }

    public static final void j(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        j.a.a().e(activity);
    }

    public static final void k(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        if (f10270f.get()) {
            j.a.a().h(activity);
            l lVar = f10268d;
            if (lVar != null) {
                lVar.l();
            }
            SensorManager sensorManager = f10267c;
            if (sensorManager == null) {
                return;
            }
            sensorManager.unregisterListener(f10266b);
        }
    }

    public static final void l(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        if (f10270f.get()) {
            j.a.a().d(activity);
            Context applicationContext = activity.getApplicationContext();
            a0 a0Var = a0.a;
            final String strD = a0.d();
            d0 d0Var = d0.a;
            final c0 c0VarC = d0.c(strD);
            if (kotlin.jvm.internal.m.a(c0VarC == null ? null : Boolean.valueOf(c0VarC.b()), Boolean.TRUE) || a.g()) {
                SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
                if (sensorManager == null) {
                    return;
                }
                f10267c = sensorManager;
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                l lVar = new l(activity);
                f10268d = lVar;
                m mVar = f10266b;
                mVar.a(new m.b() { // from class: com.facebook.o0.m0.c
                    @Override // com.facebook.o0.m0.m.b
                    public final void a() {
                        i.m(c0VarC, strD);
                    }
                });
                sensorManager.registerListener(mVar, defaultSensor, 2);
                if (c0VarC != null && c0VarC.b()) {
                    lVar.h();
                }
            }
            i iVar = a;
            if (!iVar.g() || f10271g.get()) {
                return;
            }
            iVar.a(strD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(c0 c0Var, String str) {
        kotlin.jvm.internal.m.f(str, "$appId");
        boolean z = c0Var != null && c0Var.b();
        a0 a0Var = a0.a;
        boolean z2 = a0.j();
        if (z && z2) {
            a.a(str);
        }
    }

    public static final void n(boolean z) {
        f10271g.set(z);
    }
}
