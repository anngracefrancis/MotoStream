package io.sentry.android.core;

import android.app.Activity;
import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator;
import io.sentry.s4;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: compiled from: ActivityFramesTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 {
    private FrameMetricsAggregator a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SentryAndroidOptions f22116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<io.sentry.protocol.q, Map<String, io.sentry.protocol.h>> f22117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Activity, b> f22118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c1 f22119e;

    /* JADX INFO: compiled from: ActivityFramesTracker.java */
    private static final class b {
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f22120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f22121c;

        private b(int i2, int i3, int i4) {
            this.a = i2;
            this.f22120b = i3;
            this.f22121c = i4;
        }
    }

    public f0(b1 b1Var, SentryAndroidOptions sentryAndroidOptions, c1 c1Var) {
        this.a = null;
        this.f22117c = new ConcurrentHashMap();
        this.f22118d = new WeakHashMap();
        if (b1Var.a("androidx.core.app.FrameMetricsAggregator", sentryAndroidOptions.getLogger())) {
            this.a = new FrameMetricsAggregator();
        }
        this.f22116b = sentryAndroidOptions;
        this.f22119e = c1Var;
    }

    private b b() {
        FrameMetricsAggregator frameMetricsAggregator;
        int i2;
        int i3;
        SparseIntArray sparseIntArray;
        if (!d() || (frameMetricsAggregator = this.a) == null) {
            return null;
        }
        SparseIntArray[] sparseIntArrayArrB = frameMetricsAggregator.b();
        int i4 = 0;
        if (sparseIntArrayArrB == null || sparseIntArrayArrB.length <= 0 || (sparseIntArray = sparseIntArrayArrB[0]) == null) {
            i2 = 0;
            i3 = 0;
        } else {
            int i5 = 0;
            i2 = 0;
            i3 = 0;
            while (i4 < sparseIntArray.size()) {
                int iKeyAt = sparseIntArray.keyAt(i4);
                int iValueAt = sparseIntArray.valueAt(i4);
                i5 += iValueAt;
                if (iKeyAt > 700) {
                    i3 += iValueAt;
                } else if (iKeyAt > 16) {
                    i2 += iValueAt;
                }
                i4++;
            }
            i4 = i5;
        }
        return new b(i4, i2, i3);
    }

    private b c(Activity activity) {
        b bVarB;
        b bVarRemove = this.f22118d.remove(activity);
        if (bVarRemove == null || (bVarB = b()) == null) {
            return null;
        }
        return new b(bVarB.a - bVarRemove.a, bVarB.f22120b - bVarRemove.f22120b, bVarB.f22121c - bVarRemove.f22121c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Activity activity) {
        this.a.a(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Runnable runnable, String str) {
        try {
            runnable.run();
        } catch (Throwable unused) {
            if (str != null) {
                this.f22116b.getLogger().c(s4.WARNING, "Failed to execute " + str, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Activity activity) {
        this.a.c(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l() {
        this.a.e();
    }

    private void m(final Runnable runnable, final String str) {
        try {
            if (io.sentry.android.core.internal.util.h.e().d()) {
                runnable.run();
            } else {
                this.f22119e.b(new Runnable() { // from class: io.sentry.android.core.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22105f.h(runnable, str);
                    }
                });
            }
        } catch (Throwable unused) {
            if (str != null) {
                this.f22116b.getLogger().c(s4.WARNING, "Failed to execute " + str, new Object[0]);
            }
        }
    }

    private void o(Activity activity) {
        b bVarB = b();
        if (bVarB != null) {
            this.f22118d.put(activity, bVarB);
        }
    }

    public synchronized void a(final Activity activity) {
        if (d()) {
            m(new Runnable() { // from class: io.sentry.android.core.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22114f.f(activity);
                }
            }, "FrameMetricsAggregator.add");
            o(activity);
        }
    }

    @VisibleForTesting
    public boolean d() {
        return this.a != null && this.f22116b.isEnableFramesTracking();
    }

    public synchronized void n(final Activity activity, io.sentry.protocol.q qVar) {
        if (d()) {
            m(new Runnable() { // from class: io.sentry.android.core.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22096f.j(activity);
                }
            }, null);
            b bVarC = c(activity);
            if (bVarC != null && (bVarC.a != 0 || bVarC.f22120b != 0 || bVarC.f22121c != 0)) {
                io.sentry.protocol.h hVar = new io.sentry.protocol.h(Integer.valueOf(bVarC.a), "none");
                io.sentry.protocol.h hVar2 = new io.sentry.protocol.h(Integer.valueOf(bVarC.f22120b), "none");
                io.sentry.protocol.h hVar3 = new io.sentry.protocol.h(Integer.valueOf(bVarC.f22121c), "none");
                HashMap map = new HashMap();
                map.put("frames_total", hVar);
                map.put("frames_slow", hVar2);
                map.put("frames_frozen", hVar3);
                this.f22117c.put(qVar, map);
            }
        }
    }

    public synchronized void p() {
        if (d()) {
            m(new Runnable() { // from class: io.sentry.android.core.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22099f.l();
                }
            }, "FrameMetricsAggregator.stop");
            this.a.d();
        }
        this.f22117c.clear();
    }

    public synchronized Map<String, io.sentry.protocol.h> q(io.sentry.protocol.q qVar) {
        if (!d()) {
            return null;
        }
        Map<String, io.sentry.protocol.h> map = this.f22117c.get(qVar);
        this.f22117c.remove(qVar);
        return map;
    }

    public f0(b1 b1Var, SentryAndroidOptions sentryAndroidOptions) {
        this(b1Var, sentryAndroidOptions, new c1());
    }
}
