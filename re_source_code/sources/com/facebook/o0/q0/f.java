package com.facebook.o0.q0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.g0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import com.facebook.internal.j0;
import com.facebook.internal.p0;
import com.facebook.o0.a0;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.u;

/* JADX INFO: compiled from: ActivityLifecycleTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final f a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ScheduledExecutorService f10406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile ScheduledFuture<?> f10407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f10408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicInteger f10409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile m f10410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicBoolean f10411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f10412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f10413j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f10414k;
    private static WeakReference<Activity> l;

    /* JADX INFO: compiled from: ActivityLifecycleTracker.kt */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.m.f(activity, "activity");
            j0.a.b(g0.APP_EVENTS, f.f10405b, "onActivityCreated");
            g gVar = g.a;
            g.a();
            f fVar = f.a;
            f.p(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            j0.a.b(g0.APP_EVENTS, f.f10405b, "onActivityDestroyed");
            f.a.r(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            j0.a.b(g0.APP_EVENTS, f.f10405b, "onActivityPaused");
            g gVar = g.a;
            g.a();
            f.a.s(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            j0.a.b(g0.APP_EVENTS, f.f10405b, "onActivityResumed");
            g gVar = g.a;
            g.a();
            f fVar = f.a;
            f.v(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.m.f(activity, "activity");
            kotlin.jvm.internal.m.f(bundle, "outState");
            j0.a.b(g0.APP_EVENTS, f.f10405b, "onActivitySaveInstanceState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            f fVar = f.a;
            f.f10414k++;
            j0.a.b(g0.APP_EVENTS, f.f10405b, "onActivityStarted");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            j0.a.b(g0.APP_EVENTS, f.f10405b, "onActivityStopped");
            a0.a.h();
            f fVar = f.a;
            f.f10414k--;
        }
    }

    static {
        String canonicalName = f.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.internal.ActivityLifecycleTracker";
        }
        f10405b = canonicalName;
        f10406c = Executors.newSingleThreadScheduledExecutor();
        f10408e = new Object();
        f10409f = new AtomicInteger(0);
        f10411h = new AtomicBoolean(false);
    }

    private f() {
    }

    private final void f() {
        ScheduledFuture<?> scheduledFuture;
        synchronized (f10408e) {
            if (f10407d != null && (scheduledFuture = f10407d) != null) {
                scheduledFuture.cancel(false);
            }
            f10407d = null;
            u uVar = u.a;
        }
    }

    public static final Activity g() {
        WeakReference<Activity> weakReference = l;
        if (weakReference == null || weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static final UUID h() {
        m mVar;
        if (f10410g == null || (mVar = f10410g) == null) {
            return null;
        }
        return mVar.d();
    }

    private final int i() {
        d0 d0Var = d0.a;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        c0 c0VarC = d0.c(com.facebook.a0.d());
        if (c0VarC != null) {
            return c0VarC.k();
        }
        j jVar = j.a;
        return j.a();
    }

    public static final boolean j() {
        return f10414k == 0;
    }

    public static final void p(Activity activity) {
        f10406c.execute(new Runnable() { // from class: com.facebook.o0.q0.c
            @Override // java.lang.Runnable
            public final void run() {
                f.q();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        if (f10410g == null) {
            f10410g = m.a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(Activity activity) {
        com.facebook.o0.m0.i iVar = com.facebook.o0.m0.i.a;
        com.facebook.o0.m0.i.j(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(Activity activity) {
        AtomicInteger atomicInteger = f10409f;
        if (atomicInteger.decrementAndGet() < 0) {
            atomicInteger.set(0);
            Log.w(f10405b, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
        }
        f();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        p0 p0Var = p0.a;
        final String strR = p0.r(activity);
        com.facebook.o0.m0.i iVar = com.facebook.o0.m0.i.a;
        com.facebook.o0.m0.i.k(activity);
        f10406c.execute(new Runnable() { // from class: com.facebook.o0.q0.a
            @Override // java.lang.Runnable
            public final void run() {
                f.t(jCurrentTimeMillis, strR);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final long j2, final String str) {
        kotlin.jvm.internal.m.f(str, "$activityName");
        if (f10410g == null) {
            f10410g = new m(Long.valueOf(j2), null, null, 4, null);
        }
        m mVar = f10410g;
        if (mVar != null) {
            mVar.k(Long.valueOf(j2));
        }
        if (f10409f.get() <= 0) {
            Runnable runnable = new Runnable() { // from class: com.facebook.o0.q0.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.u(j2, str);
                }
            };
            synchronized (f10408e) {
                f10407d = f10406c.schedule(runnable, a.i(), TimeUnit.SECONDS);
                u uVar = u.a;
            }
        }
        long j3 = f10413j;
        long j4 = j3 > 0 ? (j2 - j3) / ((long) 1000) : 0L;
        i iVar = i.a;
        i.e(str, j4);
        m mVar2 = f10410g;
        if (mVar2 == null) {
            return;
        }
        mVar2.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(long j2, String str) {
        kotlin.jvm.internal.m.f(str, "$activityName");
        if (f10410g == null) {
            f10410g = new m(Long.valueOf(j2), null, null, 4, null);
        }
        if (f10409f.get() <= 0) {
            n nVar = n.a;
            n.e(str, f10410g, f10412i);
            m.a.a();
            f10410g = null;
        }
        synchronized (f10408e) {
            f10407d = null;
            u uVar = u.a;
        }
    }

    public static final void v(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        f fVar = a;
        l = new WeakReference<>(activity);
        f10409f.incrementAndGet();
        fVar.f();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        f10413j = jCurrentTimeMillis;
        p0 p0Var = p0.a;
        final String strR = p0.r(activity);
        com.facebook.o0.m0.i iVar = com.facebook.o0.m0.i.a;
        com.facebook.o0.m0.i.l(activity);
        com.facebook.o0.k0.c cVar = com.facebook.o0.k0.c.a;
        com.facebook.o0.k0.c.d(activity);
        com.facebook.o0.u0.h hVar = com.facebook.o0.u0.h.a;
        com.facebook.o0.u0.h.h(activity);
        com.facebook.o0.o0.k kVar = com.facebook.o0.o0.k.a;
        com.facebook.o0.o0.k.b();
        final Context applicationContext = activity.getApplicationContext();
        f10406c.execute(new Runnable() { // from class: com.facebook.o0.q0.b
            @Override // java.lang.Runnable
            public final void run() {
                f.w(jCurrentTimeMillis, strR, applicationContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(long j2, String str, Context context) {
        m mVar;
        kotlin.jvm.internal.m.f(str, "$activityName");
        m mVar2 = f10410g;
        Long lE = mVar2 == null ? null : mVar2.e();
        if (f10410g == null) {
            f10410g = new m(Long.valueOf(j2), null, null, 4, null);
            n nVar = n.a;
            String str2 = f10412i;
            kotlin.jvm.internal.m.e(context, "appContext");
            n.c(str, null, str2, context);
        } else if (lE != null) {
            long jLongValue = j2 - lE.longValue();
            if (jLongValue > a.i() * 1000) {
                n nVar2 = n.a;
                n.e(str, f10410g, f10412i);
                String str3 = f10412i;
                kotlin.jvm.internal.m.e(context, "appContext");
                n.c(str, null, str3, context);
                f10410g = new m(Long.valueOf(j2), null, null, 4, null);
            } else if (jLongValue > 1000 && (mVar = f10410g) != null) {
                mVar.h();
            }
        }
        m mVar3 = f10410g;
        if (mVar3 != null) {
            mVar3.k(Long.valueOf(j2));
        }
        m mVar4 = f10410g;
        if (mVar4 == null) {
            return;
        }
        mVar4.m();
    }

    public static final void x(Application application, String str) {
        kotlin.jvm.internal.m.f(application, "application");
        if (f10411h.compareAndSet(false, true)) {
            com.facebook.internal.a0 a0Var = com.facebook.internal.a0.a;
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.CodelessEvents, new com.facebook.internal.a0.a() { // from class: com.facebook.o0.q0.d
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    f.y(z);
                }
            });
            f10412i = str;
            application.registerActivityLifecycleCallbacks(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(boolean z) {
        if (z) {
            com.facebook.o0.m0.i iVar = com.facebook.o0.m0.i.a;
            com.facebook.o0.m0.i.d();
        } else {
            com.facebook.o0.m0.i iVar2 = com.facebook.o0.m0.i.a;
            com.facebook.o0.m0.i.c();
        }
    }
}
