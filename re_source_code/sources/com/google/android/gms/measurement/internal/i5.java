package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class i5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f17817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17818g;

    i5(zzhc zzhcVar, AtomicReference atomicReference) {
        this.f17818g = zzhcVar;
        this.f17817f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f17817f) {
            try {
                this.f17817f.set(Double.valueOf(this.f17818g.n().v(this.f17818g.q().C(), zzap.S)));
                this.f17817f.notify();
            } catch (Throwable th) {
                this.f17817f.notify();
                throw th;
            }
        }
    }
}
