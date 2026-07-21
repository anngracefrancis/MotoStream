package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class d6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzik f17739g;

    d6(zzik zzikVar, zzm zzmVar) {
        this.f17739g = zzikVar;
        this.f17738f = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.f17739g.f18193d;
        if (zzelVar == null) {
            this.f17739g.h().H().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzelVar.U3(this.f17738f);
            this.f17739g.d0();
        } catch (RemoteException e2) {
            this.f17739g.h().H().b("Failed to send measurementEnabled to the service", e2);
        }
    }
}
