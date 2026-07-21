package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class b6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzan f17707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzn f17709h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzik f17710i;

    b6(zzik zzikVar, zzan zzanVar, String str, zzn zznVar) {
        this.f17710i = zzikVar;
        this.f17707f = zzanVar;
        this.f17708g = str;
        this.f17709h = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                zzel zzelVar = this.f17710i.f18193d;
                if (zzelVar == null) {
                    this.f17710i.h().H().a("Discarding data. Failed to send event to service to bundle");
                    this.f17710i.l().S(this.f17709h, null);
                } else {
                    byte[] bArrT1 = zzelVar.T1(this.f17707f, this.f17708g);
                    this.f17710i.d0();
                    this.f17710i.l().S(this.f17709h, bArrT1);
                }
            } catch (RemoteException e2) {
                this.f17710i.h().H().b("Failed to send event to the service to bundle", e2);
                this.f17710i.l().S(this.f17709h, null);
            }
        } catch (Throwable th) {
            this.f17710i.l().S(this.f17709h, null);
            throw th;
        }
    }
}
