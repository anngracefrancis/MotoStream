package e.h.a;

import android.os.SystemClock;

/* JADX INFO: compiled from: DownloadSpeedMonitor.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements s, r {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f21209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f21210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f21211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21213f = 1000;

    @Override // e.h.a.s
    public void a() {
        this.f21212e = 0;
        this.a = 0L;
    }

    @Override // e.h.a.r
    public int c() {
        return this.f21212e;
    }

    @Override // e.h.a.s
    public void f(long j2) {
        if (this.f21211d <= 0) {
            return;
        }
        long j3 = j2 - this.f21210c;
        this.a = 0L;
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f21211d;
        if (jUptimeMillis <= 0) {
            this.f21212e = (int) j3;
        } else {
            this.f21212e = (int) (j3 / jUptimeMillis);
        }
    }

    @Override // e.h.a.s
    public void g(long j2) {
        this.f21211d = SystemClock.uptimeMillis();
        this.f21210c = j2;
    }

    @Override // e.h.a.s
    public void i(long j2) {
        if (this.f21213f <= 0) {
            return;
        }
        boolean z = true;
        if (this.a != 0) {
            long jUptimeMillis = SystemClock.uptimeMillis() - this.a;
            if (jUptimeMillis >= this.f21213f || (this.f21212e == 0 && jUptimeMillis > 0)) {
                int i2 = (int) ((j2 - this.f21209b) / jUptimeMillis);
                this.f21212e = i2;
                this.f21212e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f21209b = j2;
            this.a = SystemClock.uptimeMillis();
        }
    }
}
