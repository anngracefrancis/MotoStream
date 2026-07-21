package e.d.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.flurry.sdk.a.C0156a;
import com.flurry.sdk.a.b;
import com.flurry.sdk.a.c;
import com.flurry.sdk.a.d;
import com.flurry.sdk.a.e;
import com.flurry.sdk.a.g;
import com.flurry.sdk.a.h;
import com.flurry.sdk.a.j;
import com.flurry.sdk.b0;
import com.flurry.sdk.c2;
import com.flurry.sdk.d1;
import com.flurry.sdk.e7;
import com.flurry.sdk.k0;
import com.flurry.sdk.m2;
import com.flurry.sdk.w4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: loaded from: classes.dex */
    public static class a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private e.d.a.a f20697j;
        private c a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f20689b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20690c = 5;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f20691d = 10000;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f20692e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f20693f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f20694g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f20695h = f.a;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List<e> f20696i = new ArrayList();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f20698k = false;
        private boolean l = false;

        public void a(Context context, String str) {
            if (b.b()) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("API key not specified");
                }
                b0.b(context);
                k0.a().f10860c = str;
                com.flurry.sdk.a aVarV = com.flurry.sdk.a.v();
                c cVar = this.a;
                boolean z = this.f20689b;
                int i2 = this.f20690c;
                long j2 = this.f20691d;
                boolean z2 = this.f20692e;
                boolean z3 = this.f20693f;
                boolean z4 = this.f20694g;
                int i3 = this.f20695h;
                List<e> list = this.f20696i;
                e.d.a.a aVar = this.f20697j;
                boolean z5 = this.f20698k;
                boolean z6 = this.l;
                if (com.flurry.sdk.a.o.get()) {
                    d1.n("FlurryAgentImpl", "Invalid call to Init. Flurry is already initialized");
                    return;
                }
                d1.n("FlurryAgentImpl", "Initializing Flurry SDK");
                if (com.flurry.sdk.a.o.get()) {
                    d1.n("FlurryAgentImpl", "Invalid call to register. Flurry is already initialized");
                } else {
                    aVarV.q = list;
                }
                m2.a();
                aVarV.m(aVarV.new b(context, list));
                w4 w4VarA = w4.a();
                e7 e7VarA = e7.a();
                if (e7VarA != null) {
                    e7VarA.f10723b.v(w4VarA.f11127h);
                    e7VarA.f10724c.v(w4VarA.f11128i);
                    e7VarA.f10725d.v(w4VarA.f11125f);
                    e7VarA.f10726e.v(w4VarA.f11126g);
                    e7VarA.f10727f.v(w4VarA.l);
                    e7VarA.f10728g.v(w4VarA.f11123d);
                    e7VarA.f10729h.v(w4VarA.f11124e);
                    e7VarA.f10730i.v(w4VarA.f11130k);
                    e7VarA.f10731j.v(w4VarA.f11121b);
                    e7VarA.f10732k.v(w4VarA.f11129j);
                    e7VarA.l.v(w4VarA.f11122c);
                    e7VarA.m.v(w4VarA.m);
                    e7VarA.o.v(w4VarA.n);
                    e7VarA.p.v(w4VarA.o);
                    e7VarA.q.v(w4VarA.p);
                }
                k0.a().c();
                e7.a().f10731j.a();
                e7.a().f10728g.q = z2;
                if (aVar != null) {
                    e7.a().m.x(aVar);
                }
                if (z) {
                    d1.g();
                } else {
                    d1.a();
                }
                d1.b(i2);
                aVarV.m(aVarV.new C0156a(j2, cVar));
                aVarV.m(aVarV.new g(z3, z4));
                aVarV.m(aVarV.new d(i3, context));
                aVarV.m(aVarV.new e(z5));
                com.flurry.sdk.a.o.set(true);
                if (z6) {
                    d1.n("FlurryAgentImpl", "Force start session");
                    aVarV.w(context.getApplicationContext());
                }
            }
        }

        public a b(boolean z) {
            this.f20692e = z;
            return this;
        }

        public a c(boolean z) {
            this.f20693f = z;
            return this;
        }

        public a d(boolean z) {
            this.f20689b = z;
            return this;
        }

        public a e(int i2) {
            this.f20695h = i2;
            return this;
        }
    }

    /* JADX INFO: renamed from: e.d.a.b$b, reason: collision with other inner class name */
    public static class C0255b {
        public static void a(String str, String str2) {
            if (b.b()) {
                com.flurry.sdk.a aVarV = com.flurry.sdk.a.v();
                if (com.flurry.sdk.a.o.get()) {
                    aVarV.m(aVarV.new c(str, str2));
                } else {
                    d1.n("FlurryAgentImpl", "Invalid call to UserProperties.add. Flurry is not initialized");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b() {
        if (c2.g(16)) {
            return true;
        }
        d1.j("FlurryAgent", String.format(Locale.getDefault(), "Device SDK Version older than %d", 16));
        return false;
    }

    public static d c(String str) {
        return !b() ? d.kFlurryEventFailed : com.flurry.sdk.a.v().u(str, Collections.emptyMap(), false, false);
    }

    public static d d(String str, Map<String, String> map) {
        d dVar = d.kFlurryEventFailed;
        if (!b()) {
            return dVar;
        }
        if (str == null) {
            d1.j("FlurryAgent", "String eventId passed to logEvent was null.");
            return dVar;
        }
        if (map == null) {
            d1.l("FlurryAgent", "String parameters passed to logEvent was null.");
        }
        return com.flurry.sdk.a.v().u(str, map, false, false);
    }

    public static void e(Context context) {
        if (b()) {
            com.flurry.sdk.a aVarV = com.flurry.sdk.a.v();
            if (context instanceof Activity) {
                d1.e("FlurryAgentImpl", "Activity's session is controlled by Flurry SDK");
            } else if (com.flurry.sdk.a.o.get()) {
                aVarV.m(aVarV.new h());
            } else {
                d1.n("FlurryAgentImpl", "Invalid call to onStartSession. Flurry is not initialized");
            }
        }
    }

    public static void f(String str, String str2, Throwable th, Map<String, String> map) {
        if (b()) {
            com.flurry.sdk.a aVarV = com.flurry.sdk.a.v();
            if (!com.flurry.sdk.a.o.get()) {
                d1.n("FlurryAgentImpl", "Invalid call to onError. Flurry is not initialized");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap map2 = new HashMap();
            if (map != null) {
                map2.putAll(map);
            }
            aVarV.m(aVarV.new j(str, jCurrentTimeMillis, str2, th, map2));
        }
    }

    public static void g(Context context) {
        if (b()) {
            com.flurry.sdk.a.v().w(context);
        }
    }
}
