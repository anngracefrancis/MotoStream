package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class uj implements zzban<ParcelFileDescriptor> {
    private final /* synthetic */ zzarr a;

    uj(zzcig zzcigVar, zzarr zzarrVar) {
        this.a = zzarrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        try {
            this.a.K5(zzaym.y(th, zzcgm.b(th)));
        } catch (RemoteException e2) {
            zzawz.l("Service can't call client", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            this.a.V0(parcelFileDescriptor);
        } catch (RemoteException e2) {
            zzawz.l("Service can't call client", e2);
        }
    }
}
