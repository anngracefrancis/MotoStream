package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import io.sentry.k3;
import io.sentry.r1;
import io.sentry.s4;
import io.sentry.w1;
import java.io.File;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AndroidCpuCollector.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class g0 implements r1 {
    private long a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f22127b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f22128c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f22129d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f22130e = 1000000000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f22131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final File f22132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final w1 f22133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final s0 f22134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f22135j;

    public g0(w1 w1Var, s0 s0Var) {
        double d2 = 1L;
        Double.isNaN(d2);
        this.f22131f = 1.0E9d / d2;
        this.f22132g = new File("/proc/self/stat");
        this.f22135j = false;
        this.f22133h = (w1) io.sentry.util.q.c(w1Var, "Logger is required.");
        this.f22134i = (s0) io.sentry.util.q.c(s0Var, "BuildInfoProvider is required.");
    }

    private long b() {
        String strC;
        try {
            strC = io.sentry.util.l.c(this.f22132g);
        } catch (IOException e2) {
            this.f22135j = false;
            this.f22133h.b(s4.WARNING, "Unable to read /proc/self/stat file. Disabling cpu collection.", e2);
            strC = null;
        }
        if (strC != null) {
            String[] strArrSplit = strC.trim().split("[\n\t\r ]");
            try {
                double d2 = Long.parseLong(strArrSplit[13]) + Long.parseLong(strArrSplit[14]) + Long.parseLong(strArrSplit[15]) + Long.parseLong(strArrSplit[16]);
                double d3 = this.f22131f;
                Double.isNaN(d2);
                return (long) (d2 * d3);
            } catch (NumberFormatException e3) {
                this.f22133h.b(s4.ERROR, "Error parsing /proc/self/stat file.", e3);
            }
        }
        return 0L;
    }

    @Override // io.sentry.r1
    @SuppressLint({"NewApi"})
    public void a(k3 k3Var) {
        if (this.f22134i.d() < 21 || !this.f22135j) {
            return;
        }
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        long j2 = jElapsedRealtimeNanos - this.a;
        this.a = jElapsedRealtimeNanos;
        long jB = b();
        long j3 = jB - this.f22127b;
        this.f22127b = jB;
        double d2 = j3;
        double d3 = j2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        long jCurrentTimeMillis = System.currentTimeMillis();
        double d4 = this.f22129d;
        Double.isNaN(d4);
        k3Var.a(new io.sentry.x0(jCurrentTimeMillis, ((d2 / d3) / d4) * 100.0d));
    }

    @Override // io.sentry.r1
    @SuppressLint({"NewApi"})
    public void setup() {
        if (this.f22134i.d() < 21) {
            this.f22135j = false;
            return;
        }
        this.f22135j = true;
        this.f22128c = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.f22129d = Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
        double d2 = this.f22128c;
        Double.isNaN(d2);
        this.f22131f = 1.0E9d / d2;
        this.f22127b = b();
    }
}
