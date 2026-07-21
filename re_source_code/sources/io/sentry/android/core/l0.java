package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.b2;
import io.sentry.k3;
import io.sentry.s4;
import io.sentry.w1;
import io.sentry.w2;
import java.io.File;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AndroidProfiler.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public class l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f22213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22214c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22217f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final io.sentry.android.core.internal.util.t f22219h;
    private final s0 m;
    private final b2 n;
    private final w1 o;
    private long a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Future<?> f22215d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f22216e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile b f22218g = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ArrayDeque<io.sentry.profilemeasurements.b> f22220i = new ArrayDeque<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ArrayDeque<io.sentry.profilemeasurements.b> f22221j = new ArrayDeque<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ArrayDeque<io.sentry.profilemeasurements.b> f22222k = new ArrayDeque<>();
    private final Map<String, io.sentry.profilemeasurements.a> l = new HashMap();
    private boolean p = false;

    /* JADX INFO: compiled from: AndroidProfiler.java */
    class a implements io.sentry.android.core.internal.util.t.b {
        final long a = TimeUnit.SECONDS.toNanos(1);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f22223b = TimeUnit.MILLISECONDS.toNanos(700);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f22224c = 0.0f;

        a() {
        }

        @Override // io.sentry.android.core.internal.util.t.b
        public void a(long j2, long j3, float f2) {
            long jNanoTime = ((j2 - System.nanoTime()) + SystemClock.elapsedRealtimeNanos()) - l0.this.a;
            if (jNanoTime < 0) {
                return;
            }
            boolean z = ((float) j3) > ((float) this.a) / (f2 - 1.0f);
            float f3 = ((int) (f2 * 100.0f)) / 100.0f;
            if (j3 > this.f22223b) {
                l0.this.f22222k.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jNanoTime), Long.valueOf(j3)));
            } else if (z) {
                l0.this.f22221j.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jNanoTime), Long.valueOf(j3)));
            }
            if (f3 != this.f22224c) {
                this.f22224c = f3;
                l0.this.f22220i.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jNanoTime), Float.valueOf(f3)));
            }
        }
    }

    /* JADX INFO: compiled from: AndroidProfiler.java */
    public static class b {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f22226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final File f22227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, io.sentry.profilemeasurements.a> f22228d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f22229e;

        public b(long j2, long j3, boolean z, File file, Map<String, io.sentry.profilemeasurements.a> map) {
            this.a = j2;
            this.f22227c = file;
            this.f22226b = j3;
            this.f22228d = map;
            this.f22229e = z;
        }
    }

    /* JADX INFO: compiled from: AndroidProfiler.java */
    public static class c {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f22230b;

        public c(long j2, long j3) {
            this.a = j2;
            this.f22230b = j3;
        }
    }

    public l0(String str, int i2, io.sentry.android.core.internal.util.t tVar, b2 b2Var, w1 w1Var, s0 s0Var) {
        this.f22213b = new File((String) io.sentry.util.q.c(str, "TracesFilesDirPath is required"));
        this.f22214c = i2;
        this.o = (w1) io.sentry.util.q.c(w1Var, "Logger is required");
        this.n = (b2) io.sentry.util.q.c(b2Var, "ExecutorService is required.");
        this.f22219h = (io.sentry.android.core.internal.util.t) io.sentry.util.q.c(tVar, "SentryFrameMetricsCollector is required");
        this.m = (s0) io.sentry.util.q.c(s0Var, "The BuildInfoProvider is required.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h() {
        this.f22218g = f(true, null);
    }

    @SuppressLint({"NewApi"})
    private void i(List<k3> list) {
        if (this.m.d() < 21) {
            return;
        }
        long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.a) - TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        if (list != null) {
            ArrayDeque arrayDeque = new ArrayDeque(list.size());
            ArrayDeque arrayDeque2 = new ArrayDeque(list.size());
            ArrayDeque arrayDeque3 = new ArrayDeque(list.size());
            for (k3 k3Var : list) {
                io.sentry.x0 x0VarC = k3Var.c();
                w2 w2VarD = k3Var.d();
                if (x0VarC != null) {
                    arrayDeque3.add(new io.sentry.profilemeasurements.b(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(x0VarC.b()) + jElapsedRealtimeNanos), Double.valueOf(x0VarC.a())));
                }
                if (w2VarD != null && w2VarD.b() > -1) {
                    arrayDeque.add(new io.sentry.profilemeasurements.b(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(w2VarD.a()) + jElapsedRealtimeNanos), Long.valueOf(w2VarD.b())));
                }
                if (w2VarD != null && w2VarD.c() > -1) {
                    arrayDeque2.add(new io.sentry.profilemeasurements.b(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(w2VarD.a()) + jElapsedRealtimeNanos), Long.valueOf(w2VarD.c())));
                }
            }
            if (!arrayDeque3.isEmpty()) {
                this.l.put("cpu_usage", new io.sentry.profilemeasurements.a("percent", arrayDeque3));
            }
            if (!arrayDeque.isEmpty()) {
                this.l.put("memory_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque));
            }
            if (arrayDeque2.isEmpty()) {
                return;
            }
            this.l.put("memory_native_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque2));
        }
    }

    public synchronized void e() {
        Future<?> future = this.f22215d;
        if (future != null) {
            future.cancel(true);
            this.f22215d = null;
        }
        if (this.p) {
            f(true, null);
        }
    }

    @SuppressLint({"NewApi"})
    public synchronized b f(boolean z, List<k3> list) {
        if (this.f22218g != null) {
            return this.f22218g;
        }
        if (!this.p) {
            this.o.c(s4.WARNING, "Profiler not running", new Object[0]);
            return null;
        }
        if (this.m.d() < 21) {
            return null;
        }
        try {
            Debug.stopMethodTracing();
        } catch (Throwable th) {
            try {
                this.o.b(s4.ERROR, "Error while stopping profiling: ", th);
            } catch (Throwable th2) {
                this.p = false;
                throw th2;
            }
        }
        this.p = false;
        this.f22219h.j(this.f22217f);
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        long elapsedCpuTime = Process.getElapsedCpuTime();
        if (this.f22216e == null) {
            this.o.c(s4.ERROR, "Trace file does not exists", new Object[0]);
            return null;
        }
        if (!this.f22221j.isEmpty()) {
            this.l.put("slow_frame_renders", new io.sentry.profilemeasurements.a("nanosecond", this.f22221j));
        }
        if (!this.f22222k.isEmpty()) {
            this.l.put("frozen_frame_renders", new io.sentry.profilemeasurements.a("nanosecond", this.f22222k));
        }
        if (!this.f22220i.isEmpty()) {
            this.l.put("screen_frame_rates", new io.sentry.profilemeasurements.a("hz", this.f22220i));
        }
        i(list);
        Future<?> future = this.f22215d;
        if (future != null) {
            future.cancel(true);
            this.f22215d = null;
        }
        return new b(jElapsedRealtimeNanos, elapsedCpuTime, z, this.f22216e, this.l);
    }

    @SuppressLint({"NewApi"})
    public synchronized c j() {
        int i2 = this.f22214c;
        if (i2 == 0) {
            this.o.c(s4.WARNING, "Disabling profiling because intervaUs is set to %d", Integer.valueOf(i2));
            return null;
        }
        if (this.p) {
            this.o.c(s4.WARNING, "Profiling has already started...", new Object[0]);
            return null;
        }
        if (this.m.d() < 21) {
            return null;
        }
        this.f22216e = new File(this.f22213b, UUID.randomUUID() + ".trace");
        this.l.clear();
        this.f22220i.clear();
        this.f22221j.clear();
        this.f22222k.clear();
        this.f22217f = this.f22219h.i(new a());
        try {
            this.f22215d = this.n.b(new Runnable() { // from class: io.sentry.android.core.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22257f.h();
                }
            }, 30000L);
        } catch (RejectedExecutionException e2) {
            this.o.b(s4.ERROR, "Failed to call the executor. Profiling will not be automatically finished. Did you call Sentry.close()?", e2);
        }
        this.a = SystemClock.elapsedRealtimeNanos();
        long elapsedCpuTime = Process.getElapsedCpuTime();
        try {
            Debug.startMethodTracingSampling(this.f22216e.getPath(), 3000000, this.f22214c);
            this.p = true;
            return new c(this.a, elapsedCpuTime);
        } catch (Throwable th) {
            f(false, null);
            this.o.b(s4.ERROR, "Unable to start a profile: ", th);
            this.p = false;
            return null;
        }
    }
}
