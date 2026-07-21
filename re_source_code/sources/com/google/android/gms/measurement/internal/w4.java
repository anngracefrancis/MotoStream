package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class w4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f18002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f18003g;

    w4(zzhc zzhcVar, AtomicReference atomicReference) {
        this.f18003g = zzhcVar;
        this.f18002f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f18002f) {
            try {
                this.f18002f.set(Boolean.valueOf(this.f18003g.n().F(this.f18003g.q().C())));
                this.f18002f.notify();
            } catch (Throwable th) {
                this.f18002f.notify();
                throw th;
            }
        }
    }
}
