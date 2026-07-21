package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class zzn extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BlockingQueue<zzr<?>> f16490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzm f16491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzb f16492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzab f16493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f16494j = false;

    public zzn(BlockingQueue<zzr<?>> blockingQueue, zzm zzmVar, zzb zzbVar, zzab zzabVar) {
        this.f16490f = blockingQueue;
        this.f16491g = zzmVar;
        this.f16492h = zzbVar;
        this.f16493i = zzabVar;
    }

    private final void a() throws InterruptedException {
        zzr<?> zzrVarTake = this.f16490f.take();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        zzrVarTake.A(3);
        try {
            zzrVarTake.I("network-queue-take");
            zzrVarTake.u();
            TrafficStats.setThreadStatsTag(zzrVarTake.K());
            zzp zzpVarA = this.f16491g.a(zzrVarTake);
            zzrVarTake.I("network-http-complete");
            if (zzpVarA.f16555e && zzrVarTake.T()) {
                zzrVarTake.J("not-modified");
                zzrVarTake.U();
                return;
            }
            zzy<?> zzyVarY = zzrVarTake.y(zzpVarA);
            zzrVarTake.I("network-parse-complete");
            if (zzrVarTake.P() && zzyVarY.f16974b != null) {
                this.f16492h.v(zzrVarTake.M(), zzyVarY.f16974b);
                zzrVarTake.I("network-cache-written");
            }
            zzrVarTake.S();
            this.f16493i.c(zzrVarTake, zzyVarY);
            zzrVarTake.E(zzyVarY);
        } catch (Exception e2) {
            zzag.e(e2, "Unhandled exception %s", e2.toString());
            zzaf zzafVar = new zzaf(e2);
            zzafVar.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.f16493i.a(zzrVarTake, zzafVar);
            zzrVarTake.U();
        } catch (zzaf e3) {
            e3.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.f16493i.a(zzrVarTake, e3);
            zzrVarTake.U();
        } finally {
            zzrVarTake.A(4);
        }
    }

    public final void b() {
        this.f16494j = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f16494j) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzag.b("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
