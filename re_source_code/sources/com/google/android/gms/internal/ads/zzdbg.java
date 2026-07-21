package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdbg extends zzfm implements zzdbf {
    zzdbg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final zzdbd B4(zzdbb zzdbbVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzdbbVar);
        Parcel parcelP = P(1, parcelH);
        zzdbd zzdbdVar = (zzdbd) zzfo.b(parcelP, zzdbd.CREATOR);
        parcelP.recycle();
        return zzdbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void s3(zzday zzdayVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzdayVar);
        k0(2, parcelH);
    }
}
