package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class a6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzn f17697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzik f17698h;

    a6(zzik zzikVar, zzm zzmVar, zzn zznVar) {
        this.f17698h = zzikVar;
        this.f17696f = zzmVar;
        this.f17697g = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                zzel zzelVar = this.f17698h.f18193d;
                if (zzelVar == null) {
                    this.f17698h.h().H().a("Failed to get app instance id");
                    this.f17698h.l().P(this.f17697g, null);
                    return;
                }
                String strP4 = zzelVar.P4(this.f17696f);
                if (strP4 != null) {
                    this.f17698h.p().O(strP4);
                    this.f17698h.m().m.b(strP4);
                }
                this.f17698h.d0();
                this.f17698h.l().P(this.f17697g, strP4);
            } catch (RemoteException e2) {
                this.f17698h.h().H().b("Failed to get app instance id", e2);
                this.f17698h.l().P(this.f17697g, null);
            }
        } catch (Throwable th) {
            this.f17698h.l().P(this.f17697g, null);
            throw th;
        }
    }
}
