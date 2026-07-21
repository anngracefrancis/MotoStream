package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaih extends zzfm implements zzaig {
    zzaih(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void b3(zzaia zzaiaVar, zzaie zzaieVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzaiaVar);
        zzfo.c(parcelH, zzaieVar);
        E0(2, parcelH);
    }
}
