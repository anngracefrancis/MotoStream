package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class g5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f17771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17772g;

    g5(zzhc zzhcVar, AtomicReference atomicReference) {
        this.f17772g = zzhcVar;
        this.f17771f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f17771f) {
            try {
                this.f17771f.set(Long.valueOf(this.f17772g.n().p(this.f17772g.q().C(), zzap.Q)));
                this.f17771f.notify();
            } catch (Throwable th) {
                this.f17771f.notify();
                throw th;
            }
        }
    }
}
