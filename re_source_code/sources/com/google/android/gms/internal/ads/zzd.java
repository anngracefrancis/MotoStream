package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class zzd extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f15810f = zzag.f13871b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BlockingQueue<zzr<?>> f15811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BlockingQueue<zzr<?>> f15812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzb f15813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzab f15814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f15815k = false;
    private final uy l = new uy(this);

    public zzd(BlockingQueue<zzr<?>> blockingQueue, BlockingQueue<zzr<?>> blockingQueue2, zzb zzbVar, zzab zzabVar) {
        this.f15811g = blockingQueue;
        this.f15812h = blockingQueue2;
        this.f15813i = zzbVar;
        this.f15814j = zzabVar;
    }

    private final void a() throws InterruptedException {
        zzr<?> zzrVarTake = this.f15811g.take();
        zzrVarTake.I("cache-queue-take");
        zzrVarTake.A(1);
        try {
            zzrVarTake.u();
            zzc zzcVarU = this.f15813i.u(zzrVarTake.M());
            if (zzcVarU == null) {
                zzrVarTake.I("cache-miss");
                if (!this.l.d(zzrVarTake)) {
                    this.f15812h.put(zzrVarTake);
                }
                return;
            }
            if (zzcVarU.a()) {
                zzrVarTake.I("cache-hit-expired");
                zzrVarTake.v(zzcVarU);
                if (!this.l.d(zzrVarTake)) {
                    this.f15812h.put(zzrVarTake);
                }
                return;
            }
            zzrVarTake.I("cache-hit");
            zzy<?> zzyVarY = zzrVarTake.y(new zzp(zzcVarU.a, zzcVarU.f14951g));
            zzrVarTake.I("cache-hit-parsed");
            if (zzcVarU.f14950f < System.currentTimeMillis()) {
                zzrVarTake.I("cache-hit-refresh-needed");
                zzrVarTake.v(zzcVarU);
                zzyVarY.f16976d = true;
                if (this.l.d(zzrVarTake)) {
                    this.f15814j.c(zzrVarTake, zzyVarY);
                } else {
                    this.f15814j.b(zzrVarTake, zzyVarY, new my(this, zzrVarTake));
                }
            } else {
                this.f15814j.c(zzrVarTake, zzyVarY);
            }
        } finally {
            zzrVarTake.A(2);
        }
    }

    public final void b() {
        this.f15815k = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (f15810f) {
            zzag.c("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f15813i.a();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f15815k) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzag.b("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
