package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class e5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f17745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17746g;

    e5(zzhc zzhcVar, AtomicReference atomicReference) {
        this.f17746g = zzhcVar;
        this.f17745f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f17745f) {
            try {
                this.f17745f.set(this.f17746g.n().H(this.f17746g.q().C()));
                this.f17745f.notify();
            } catch (Throwable th) {
                this.f17745f.notify();
                throw th;
            }
        }
    }
}
