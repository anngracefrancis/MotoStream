package com.facebook.o0.u0;

import android.app.Activity;
import com.facebook.a0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SuggestedEventsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final h a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10524b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f10525c = new LinkedHashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f10526d = new LinkedHashSet();

    private h() {
    }

    public static final synchronized void a() {
        a0 a0Var = a0.a;
        a0.k().execute(new Runnable() { // from class: com.facebook.o0.u0.a
            @Override // java.lang.Runnable
            public final void run() {
                h.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        AtomicBoolean atomicBoolean = f10524b;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        a.c();
    }

    private final void c() {
        String strM;
        try {
            d0 d0Var = d0.a;
            a0 a0Var = a0.a;
            c0 c0VarO = d0.o(a0.d(), false);
            if (c0VarO == null || (strM = c0VarO.m()) == null) {
                return;
            }
            g(strM);
            if ((!f10525c.isEmpty()) || (!f10526d.isEmpty())) {
                com.facebook.o0.r0.h hVar = com.facebook.o0.r0.h.a;
                File fileI = com.facebook.o0.r0.h.i(com.facebook.o0.r0.h.a.MTML_APP_EVENT_PREDICTION);
                if (fileI == null) {
                    return;
                }
                e eVar = e.a;
                e.d(fileI);
                com.facebook.o0.q0.f fVar = com.facebook.o0.q0.f.a;
                Activity activityG = com.facebook.o0.q0.f.g();
                if (activityG != null) {
                    h(activityG);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean d(String str) {
        m.f(str, "event");
        return f10526d.contains(str);
    }

    public static final boolean e(String str) {
        m.f(str, "event");
        return f10525c.contains(str);
    }

    public static final void h(Activity activity) {
        m.f(activity, "activity");
        try {
            if (f10524b.get()) {
                e eVar = e.a;
                if (e.f() && (!f10525c.isEmpty() || !f10526d.isEmpty())) {
                    i.f10527f.a(activity);
                    return;
                }
            }
            i.f10527f.b(activity);
        } catch (Exception unused) {
        }
    }

    public final void g(String str) {
        JSONArray jSONArray;
        int length;
        JSONArray jSONArray2;
        int length2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = 0;
            if (jSONObject.has("production_events") && (length2 = (jSONArray2 = jSONObject.getJSONArray("production_events")).length()) > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    Set<String> set = f10525c;
                    String string = jSONArray2.getString(i3);
                    m.e(string, "jsonArray.getString(i)");
                    set.add(string);
                    if (i4 >= length2) {
                        break;
                    } else {
                        i3 = i4;
                    }
                }
            }
            if (!jSONObject.has("eligible_for_prediction_events") || (length = (jSONArray = jSONObject.getJSONArray("eligible_for_prediction_events")).length()) <= 0) {
                return;
            }
            while (true) {
                int i5 = i2 + 1;
                Set<String> set2 = f10526d;
                String string2 = jSONArray.getString(i2);
                m.e(string2, "jsonArray.getString(i)");
                set2.add(string2);
                if (i5 >= length) {
                    return;
                } else {
                    i2 = i5;
                }
            }
        } catch (Exception unused) {
        }
    }
}
