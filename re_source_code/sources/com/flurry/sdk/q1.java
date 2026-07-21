package com.flurry.sdk;

import android.app.Activity;
import android.view.ViewTreeObserver;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class q1 {
    private static q1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o1.b f11013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    m1 f11014c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11016e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f11017f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f11018g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f11019h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f11020i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, m1> f11015d = new HashMap();

    final class a implements o1.b {

        /* JADX INFO: renamed from: com.flurry.sdk.q1$a$a, reason: collision with other inner class name */
        final class ViewTreeObserverOnGlobalLayoutListenerC0166a implements ViewTreeObserver.OnGlobalLayoutListener {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Activity f11021f;

            ViewTreeObserverOnGlobalLayoutListenerC0166a(Activity activity) {
                this.f11021f = activity;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                m1 m1Var;
                this.f11021f.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                q1 q1Var = q1.this;
                if (!q1Var.f11016e || (m1Var = q1Var.f11014c) == null) {
                    return;
                }
                double dNanoTime = System.nanoTime() - q1.this.f11017f;
                Double.isNaN(dNanoTime);
                m1Var.f10912h = (long) (dNanoTime / 1000000.0d);
                d1.c(3, "ScreenTimeMonitor", "Start timed event for activity: " + q1.this.f11014c.f10906b);
                m1 m1Var2 = q1.this.f11014c;
                if (m1Var2.f10910f) {
                    return;
                }
                d1.c(4, "ActivityScreenData", "Start timed activity event: " + m1Var2.f10906b);
                com.flurry.sdk.a aVarV = com.flurry.sdk.a.v();
                String str = m1Var2.a;
                v3.a aVar = v3.a.PERFORMANCE;
                String str2 = m1Var2.f10907c;
                if (str2 != null) {
                    m1Var2.f10909e.put("fl.previous.screen", str2);
                }
                m1Var2.f10909e.put("fl.current.screen", m1Var2.f10906b);
                m1Var2.f10909e.put("fl.resume.time", Long.toString(m1Var2.f10911g));
                m1Var2.f10909e.put("fl.layout.time", Long.toString(m1Var2.f10912h));
                Map<String, String> map = m1Var2.f10909e;
                if (c2.g(16)) {
                    aVarV.t(str, aVar, map, true, true);
                } else {
                    e.d.a.d dVar = e.d.a.d.kFlurryEventFailed;
                }
                m1Var2.f10910f = true;
            }
        }

        a() {
        }

        @Override // com.flurry.sdk.o1.b
        public final void a() {
            q1.this.f11017f = System.nanoTime();
        }

        @Override // com.flurry.sdk.o1.b
        public final void b(Activity activity) {
            d1.c(3, "ScreenTimeMonitor", "onActivityStarted for activity: " + activity.toString());
            q1 q1Var = q1.this;
            m1 m1Var = q1Var.f11014c;
            q1Var.f11014c = new m1(activity.getClass().getSimpleName(), m1Var == null ? null : m1Var.f10906b);
            q1.this.f11015d.put(activity.toString(), q1.this.f11014c);
            q1 q1Var2 = q1.this;
            int i2 = q1Var2.f11019h + 1;
            q1Var2.f11019h = i2;
            if (i2 == 1 && !q1Var2.f11020i) {
                d1.c(3, "ScreenTimeMonitor", "onForeground for activity: " + activity.toString());
                long jNanoTime = System.nanoTime();
                q1 q1Var3 = q1.this;
                double d2 = jNanoTime - q1Var3.f11018g;
                Double.isNaN(d2);
                long j2 = (long) (d2 / 1000000.0d);
                q1Var3.f11018g = jNanoTime;
                q1Var3.f11017f = jNanoTime;
                if (q1Var3.f11016e) {
                    q1.b("fl.background.time", activity.getClass().getSimpleName(), j2);
                }
            }
            activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0166a(activity));
        }

        @Override // com.flurry.sdk.o1.b
        public final void c(Activity activity) {
            m1 m1VarRemove = q1.this.f11015d.remove(activity.toString());
            q1.this.f11020i = activity.isChangingConfigurations();
            q1 q1Var = q1.this;
            int i2 = q1Var.f11019h - 1;
            q1Var.f11019h = i2;
            if (i2 == 0 && !q1Var.f11020i) {
                d1.c(3, "ScreenTimeMonitor", "onBackground for activity: " + activity.toString());
                long jNanoTime = System.nanoTime();
                q1 q1Var2 = q1.this;
                double d2 = jNanoTime - q1Var2.f11018g;
                Double.isNaN(d2);
                long j2 = (long) (d2 / 1000000.0d);
                q1Var2.f11018g = jNanoTime;
                if (q1Var2.f11016e) {
                    q1.b("fl.foreground.time", activity.getClass().getSimpleName(), j2);
                }
            }
            if (!q1.this.f11016e || m1VarRemove == null) {
                return;
            }
            d1.c(3, "ScreenTimeMonitor", "End timed event: " + m1VarRemove.f10906b);
            if (m1VarRemove.f10910f) {
                d1.c(4, "ActivityScreenData", "End timed activity event: " + m1VarRemove.f10906b);
                com.flurry.sdk.a aVarV = com.flurry.sdk.a.v();
                String str = m1VarRemove.a;
                v3.a aVar = v3.a.PERFORMANCE;
                double dNanoTime = System.nanoTime() - m1VarRemove.f10908d;
                Double.isNaN(dNanoTime);
                m1VarRemove.f10909e.put("fl.duration", Long.toString((long) (dNanoTime / 1000000.0d)));
                Map<String, String> map = m1VarRemove.f10909e;
                if (c2.g(16)) {
                    aVarV.t(str, aVar, map, true, false);
                } else {
                    e.d.a.d dVar = e.d.a.d.kFlurryEventFailed;
                }
                m1VarRemove.f10910f = false;
            }
        }

        @Override // com.flurry.sdk.o1.b
        public final void d(Activity activity) {
            m1 m1Var;
            q1 q1Var = q1.this;
            if (!q1Var.f11016e || (m1Var = q1Var.f11014c) == null) {
                return;
            }
            double dNanoTime = System.nanoTime() - q1.this.f11017f;
            Double.isNaN(dNanoTime);
            m1Var.f10911g = (long) (dNanoTime / 1000000.0d);
        }
    }

    private q1() {
    }

    public static synchronized q1 a() {
        if (a == null) {
            a = new q1();
        }
        return a;
    }

    static /* synthetic */ void b(String str, String str2, long j2) {
        HashMap map = new HashMap();
        map.put("fl.current.screen", str2);
        map.put(str, Long.toString(j2));
        com.flurry.sdk.a.v().s("Flurry.ForegroundTime", v3.a.PERFORMANCE, map);
    }

    public final void c() {
        if (this.f11013b != null) {
            return;
        }
        d1.c(3, "ScreenTimeMonitor", "Register Screen Time metrics.");
        long jNanoTime = System.nanoTime();
        this.f11018g = jNanoTime;
        this.f11017f = jNanoTime;
        this.f11013b = new a();
        o1.a().c(this.f11013b);
    }
}
