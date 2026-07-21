package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzvz extends zzfm implements zzvy {
    zzvz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final zzvs F4(zzvv zzvvVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzvvVar);
        Parcel parcelP = P(1, parcelH);
        zzvs zzvsVar = (zzvs) zzfo.b(parcelP, zzvs.CREATOR);
        parcelP.recycle();
        return zzvsVar;
    }
}
