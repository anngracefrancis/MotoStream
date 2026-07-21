package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class z5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f18047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ boolean f18048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzik f18049h;

    z5(zzik zzikVar, zzm zzmVar, boolean z) {
        this.f18049h = zzikVar;
        this.f18047f = zzmVar;
        this.f18048g = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.f18049h.f18193d;
        if (zzelVar == null) {
            this.f18049h.h().H().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzelVar.s6(this.f18047f);
            if (this.f18048g) {
                this.f18049h.t().K();
            }
            this.f18049h.M(zzelVar, null, this.f18047f);
            this.f18049h.d0();
        } catch (RemoteException e2) {
            this.f18049h.h().H().b("Failed to send app launch to the service", e2);
        }
    }
}
