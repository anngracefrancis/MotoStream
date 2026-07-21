package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class x5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f18022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzm f18023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzik f18024h;

    x5(zzik zzikVar, AtomicReference atomicReference, zzm zzmVar) {
        this.f18024h = zzikVar;
        this.f18022f = atomicReference;
        this.f18023g = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f18022f) {
            try {
                try {
                    zzel zzelVar = this.f18024h.f18193d;
                    if (zzelVar == null) {
                        this.f18024h.h().H().a("Failed to get app instance id");
                        this.f18022f.notify();
                        return;
                    }
                    this.f18022f.set(zzelVar.P4(this.f18023g));
                    String str = (String) this.f18022f.get();
                    if (str != null) {
                        this.f18024h.p().O(str);
                        this.f18024h.m().m.b(str);
                    }
                    this.f18024h.d0();
                    this.f18022f.notify();
                } catch (RemoteException e2) {
                    this.f18024h.h().H().b("Failed to get app instance id", e2);
                    this.f18022f.notify();
                }
            } catch (Throwable th) {
                this.f18022f.notify();
                throw th;
            }
        }
    }
}
