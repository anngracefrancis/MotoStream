package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class y5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f18030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzik f18031g;

    y5(zzik zzikVar, zzm zzmVar) {
        this.f18031g = zzikVar;
        this.f18030f = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.f18031g.f18193d;
        if (zzelVar == null) {
            this.f18031g.h().H().a("Failed to reset data on the service; null service");
            return;
        }
        try {
            zzelVar.r2(this.f18030f);
        } catch (RemoteException e2) {
            this.f18031g.h().H().b("Failed to reset data on the service", e2);
        }
        this.f18031g.d0();
    }
}
