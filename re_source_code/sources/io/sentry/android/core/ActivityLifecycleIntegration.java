package io.sentry.android.core;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import io.sentry.Integration;
import io.sentry.d2;
import io.sentry.d3;
import io.sentry.e2;
import io.sentry.f4;
import io.sentry.h2;
import io.sentry.i2;
import io.sentry.j5;
import io.sentry.m1;
import io.sentry.n1;
import io.sentry.r5;
import io.sentry.s3;
import io.sentry.s4;
import io.sentry.s5;
import io.sentry.t3;
import io.sentry.t5;
import io.sentry.v1;
import io.sentry.v2;
import io.sentry.w1;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityLifecycleIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Application f22005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final s0 f22006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private v1 f22007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SentryAndroidOptions f22008i;
    private boolean l;
    private final boolean n;
    private d2 p;
    private final f0 w;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f22009j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f22010k = false;
    private boolean m = false;
    private m1 o = null;
    private final WeakHashMap<Activity, d2> q = new WeakHashMap<>();
    private final WeakHashMap<Activity, d2> r = new WeakHashMap<>();
    private f4 s = h0.a();
    private final Handler t = new Handler(Looper.getMainLooper());
    private Future<?> u = null;
    private final WeakHashMap<Activity, e2> v = new WeakHashMap<>();

    public ActivityLifecycleIntegration(Application application, s0 s0Var, f0 f0Var) {
        Application application2 = (Application) io.sentry.util.q.c(application, "Application is required");
        this.f22005f = application2;
        this.f22006g = (s0) io.sentry.util.q.c(s0Var, "BuildInfoProvider is required");
        this.w = (f0) io.sentry.util.q.c(f0Var, "ActivityFramesTracker is required");
        if (s0Var.d() >= 29) {
            this.l = true;
        }
        this.n = t0.m(application2);
    }

    private String A(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    private String B(boolean z) {
        return z ? "Cold Start" : "Warm Start";
    }

    private String D(boolean z) {
        return z ? "app.start.cold" : "app.start.warm";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void m0(d2 d2Var, d2 d2Var2) {
        SentryAndroidOptions sentryAndroidOptions = this.f22008i;
        if (sentryAndroidOptions == null || d2Var2 == null) {
            m(d2Var2);
            return;
        }
        f4 f4VarA = sentryAndroidOptions.getDateProvider().a();
        long millis = TimeUnit.NANOSECONDS.toMillis(f4VarA.k(d2Var2.q()));
        Long lValueOf = Long.valueOf(millis);
        v2.a aVar = v2.a.MILLISECOND;
        d2Var2.h("time_to_initial_display", lValueOf, aVar);
        if (d2Var != null && d2Var.b()) {
            d2Var.c(f4VarA);
            d2Var2.h("time_to_full_display", Long.valueOf(millis), aVar);
        }
        p(d2Var2, f4VarA);
    }

    private void F0(Bundle bundle) {
        if (this.m) {
            return;
        }
        q0.e().j(bundle == null);
    }

    private void G0(d2 d2Var) {
        if (d2Var != null) {
            d2Var.m().m("auto.ui.activity");
        }
    }

    private String H(d2 d2Var) {
        String description = d2Var.getDescription();
        if (description != null && description.endsWith(" - Deadline Exceeded")) {
            return description;
        }
        return d2Var.getDescription() + " - Deadline Exceeded";
    }

    private String I(String str) {
        return str + " full display";
    }

    private String J(String str) {
        return str + " initial display";
    }

    private void J0(Activity activity) {
        final WeakReference weakReference = new WeakReference(activity);
        if (this.f22007h == null || N(activity)) {
            return;
        }
        boolean z = this.f22009j;
        if (!z) {
            this.v.put(activity, d3.r());
            io.sentry.util.v.e(this.f22007h);
            return;
        }
        if (z) {
            K0();
            final String strA = A(activity);
            f4 f4VarD = this.n ? q0.e().d() : null;
            Boolean boolF = q0.e().f();
            t5 t5Var = new t5();
            if (this.f22008i.isEnableActivityLifecycleTracingAutoFinish()) {
                t5Var.k(this.f22008i.getIdleTimeout());
                t5Var.d(true);
            }
            t5Var.n(true);
            t5Var.m(new s5() { // from class: io.sentry.android.core.p
                @Override // io.sentry.s5
                public final void a(e2 e2Var) {
                    this.a.p0(weakReference, strA, e2Var);
                }
            });
            f4 f4Var = (this.m || f4VarD == null || boolF == null) ? this.s : f4VarD;
            t5Var.l(f4Var);
            final e2 e2VarL = this.f22007h.l(new r5(strA, io.sentry.protocol.z.COMPONENT, "ui.load"), t5Var);
            G0(e2VarL);
            if (!this.m && f4VarD != null && boolF != null) {
                d2 d2VarF = e2VarL.f(D(boolF.booleanValue()), B(boolF.booleanValue()), f4VarD, h2.SENTRY);
                this.p = d2VarF;
                G0(d2VarF);
                k();
            }
            String strJ = J(strA);
            h2 h2Var = h2.SENTRY;
            final d2 d2VarF2 = e2VarL.f("ui.load.initial_display", strJ, f4Var, h2Var);
            this.q.put(activity, d2VarF2);
            G0(d2VarF2);
            if (this.f22010k && this.o != null && this.f22008i != null) {
                final d2 d2VarF3 = e2VarL.f("ui.load.full_display", I(strA), f4Var, h2Var);
                G0(d2VarF3);
                try {
                    this.r.put(activity, d2VarF3);
                    this.u = this.f22008i.getExecutorService().b(new Runnable() { // from class: io.sentry.android.core.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f22241f.t0(d2VarF3, d2VarF2);
                        }
                    }, 30000L);
                } catch (RejectedExecutionException e2) {
                    this.f22008i.getLogger().b(s4.ERROR, "Failed to call the executor. Time to full display span will not be finished automatically. Did you call Sentry.close()?", e2);
                }
            }
            this.f22007h.o(new t3() { // from class: io.sentry.android.core.j
                @Override // io.sentry.t3
                public final void a(s3 s3Var) {
                    this.a.y0(e2VarL, s3Var);
                }
            });
            this.v.put(activity, e2VarL);
        }
    }

    private boolean K(SentryAndroidOptions sentryAndroidOptions) {
        return sentryAndroidOptions.isTracingEnabled() && sentryAndroidOptions.isEnableAutoActivityLifecycleTracing();
    }

    private void K0() {
        for (Map.Entry<Activity, e2> entry : this.v.entrySet()) {
            z(entry.getValue(), this.q.get(entry.getKey()), this.r.get(entry.getKey()));
        }
    }

    private void M0(Activity activity, boolean z) {
        if (this.f22009j && z) {
            z(this.v.get(activity), null, null);
        }
    }

    private boolean N(Activity activity) {
        return this.v.containsKey(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T(s3 s3Var, e2 e2Var, e2 e2Var2) {
        if (e2Var2 == null) {
            s3Var.z(e2Var);
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.f22008i;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(s4.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", e2Var.getName());
        }
    }

    static /* synthetic */ void W(e2 e2Var, s3 s3Var, e2 e2Var2) {
        if (e2Var2 == e2Var) {
            s3Var.e();
        }
    }

    private void b(Activity activity, String str) {
        SentryAndroidOptions sentryAndroidOptions = this.f22008i;
        if (sentryAndroidOptions == null || this.f22007h == null || !sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs()) {
            return;
        }
        io.sentry.v0 v0Var = new io.sentry.v0();
        v0Var.p("navigation");
        v0Var.m("state", str);
        v0Var.m("screen", A(activity));
        v0Var.l("ui.lifecycle");
        v0Var.n(s4.INFO);
        n1 n1Var = new n1();
        n1Var.j("android:activity", activity);
        this.f22007h.n(v0Var, n1Var);
    }

    private void f() {
        Future<?> future = this.u;
        if (future != null) {
            future.cancel(false);
            this.u = null;
        }
    }

    private void k() {
        f4 f4VarA = q0.e().a();
        if (!this.f22009j || f4VarA == null) {
            return;
        }
        p(this.p, f4VarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void t0(d2 d2Var, d2 d2Var2) {
        if (d2Var == null || d2Var.b()) {
            return;
        }
        d2Var.j(H(d2Var));
        f4 f4VarN = d2Var2 != null ? d2Var2.n() : null;
        if (f4VarN == null) {
            f4VarN = d2Var.q();
        }
        x(d2Var, f4VarN, j5.DEADLINE_EXCEEDED);
    }

    private void m(d2 d2Var) {
        if (d2Var == null || d2Var.b()) {
            return;
        }
        d2Var.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0(WeakReference weakReference, String str, e2 e2Var) {
        Activity activity = (Activity) weakReference.get();
        if (activity != null) {
            this.w.n(activity, e2Var.k());
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.f22008i;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(s4.WARNING, "Unable to track activity frames as the Activity %s has been destroyed.", str);
        }
    }

    private void p(d2 d2Var, f4 f4Var) {
        x(d2Var, f4Var, null);
    }

    private void x(d2 d2Var, f4 f4Var, j5 j5Var) {
        if (d2Var == null || d2Var.b()) {
            return;
        }
        if (j5Var == null) {
            j5Var = d2Var.getStatus() != null ? d2Var.getStatus() : j5.OK;
        }
        d2Var.o(j5Var, f4Var);
    }

    private void y(d2 d2Var, j5 j5Var) {
        if (d2Var == null || d2Var.b()) {
            return;
        }
        d2Var.d(j5Var);
    }

    private void z(final e2 e2Var, d2 d2Var, d2 d2Var2) {
        if (e2Var == null || e2Var.b()) {
            return;
        }
        y(d2Var, j5.DEADLINE_EXCEEDED);
        q0(d2Var2, d2Var);
        f();
        j5 status = e2Var.getStatus();
        if (status == null) {
            status = j5.OK;
        }
        e2Var.d(status);
        v1 v1Var = this.f22007h;
        if (v1Var != null) {
            v1Var.o(new t3() { // from class: io.sentry.android.core.o
                @Override // io.sentry.t3
                public final void a(s3 s3Var) {
                    this.a.Z(e2Var, s3Var);
                }
            });
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public void c(v1 v1Var, x4 x4Var) {
        this.f22008i = (SentryAndroidOptions) io.sentry.util.q.c(x4Var instanceof SentryAndroidOptions ? (SentryAndroidOptions) x4Var : null, "SentryAndroidOptions is required");
        this.f22007h = (v1) io.sentry.util.q.c(v1Var, "Hub is required");
        w1 logger = this.f22008i.getLogger();
        s4 s4Var = s4.DEBUG;
        logger.c(s4Var, "ActivityLifecycleIntegration enabled: %s", Boolean.valueOf(this.f22008i.isEnableActivityLifecycleBreadcrumbs()));
        this.f22009j = K(this.f22008i);
        this.o = this.f22008i.getFullyDisplayedReporter();
        this.f22010k = this.f22008i.isEnableTimeToFullDisplayTracing();
        this.f22005f.registerActivityLifecycleCallbacks(this);
        this.f22008i.getLogger().c(s4Var, "ActivityLifecycleIntegration installed.", new Object[0]);
        a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22005f.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.f22008i;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(s4.DEBUG, "ActivityLifecycleIntegration removed.", new Object[0]);
        }
        this.w.p();
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void y0(final s3 s3Var, final e2 e2Var) {
        s3Var.D(new s3.c() { // from class: io.sentry.android.core.g
            @Override // io.sentry.s3.c
            public final void a(e2 e2Var2) {
                this.a.T(s3Var, e2Var, e2Var2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void Z(final s3 s3Var, final e2 e2Var) {
        s3Var.D(new s3.c() { // from class: io.sentry.android.core.i
            @Override // io.sentry.s3.c
            public final void a(e2 e2Var2) {
                ActivityLifecycleIntegration.W(e2Var, s3Var, e2Var2);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        F0(bundle);
        b(activity, "created");
        if (this.f22007h != null) {
            final String strA = io.sentry.android.core.internal.util.j.a(activity);
            this.f22007h.o(new t3() { // from class: io.sentry.android.core.m
                @Override // io.sentry.t3
                public final void a(s3 s3Var) {
                    s3Var.y(strA);
                }
            });
        }
        J0(activity);
        final d2 d2Var = this.r.get(activity);
        this.m = true;
        m1 m1Var = this.o;
        if (m1Var != null) {
            m1Var.b(new m1.a() { // from class: io.sentry.android.core.l
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityDestroyed(Activity activity) {
        if (this.f22009j || this.f22008i.isEnableActivityLifecycleBreadcrumbs()) {
            b(activity, "destroyed");
            y(this.p, j5.CANCELLED);
            d2 d2Var = this.q.get(activity);
            d2 d2Var2 = this.r.get(activity);
            y(d2Var, j5.DEADLINE_EXCEEDED);
            q0(d2Var2, d2Var);
            f();
            M0(activity, true);
            this.p = null;
            this.q.remove(activity);
            this.r.remove(activity);
        }
        this.v.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityPaused(Activity activity) {
        if (!this.l) {
            v1 v1Var = this.f22007h;
            if (v1Var == null) {
                this.s = h0.a();
            } else {
                this.s = v1Var.q().getDateProvider().a();
            }
        }
        b(activity, "paused");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
        if (this.l) {
            v1 v1Var = this.f22007h;
            if (v1Var == null) {
                this.s = h0.a();
            } else {
                this.s = v1Var.q().getDateProvider().a();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @SuppressLint({"NewApi"})
    public synchronized void onActivityResumed(Activity activity) {
        if (this.f22009j) {
            f4 f4VarD = q0.e().d();
            f4 f4VarA = q0.e().a();
            if (f4VarD != null && f4VarA == null) {
                q0.e().g();
            }
            k();
            final d2 d2Var = this.q.get(activity);
            final d2 d2Var2 = this.r.get(activity);
            View viewFindViewById = activity.findViewById(R.id.content);
            if (this.f22006g.d() < 16 || viewFindViewById == null) {
                this.t.post(new Runnable() { // from class: io.sentry.android.core.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22209f.m0(d2Var2, d2Var);
                    }
                });
            } else {
                io.sentry.android.core.internal.util.p.e(viewFindViewById, new Runnable() { // from class: io.sentry.android.core.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22137f.f0(d2Var2, d2Var);
                    }
                }, this.f22006g);
            }
        }
        b(activity, "resumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        b(activity, "saveInstanceState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        if (this.f22009j) {
            this.w.a(activity);
        }
        b(activity, "started");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity activity) {
        b(activity, "stopped");
    }
}
