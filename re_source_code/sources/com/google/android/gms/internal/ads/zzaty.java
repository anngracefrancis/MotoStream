package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaty extends zzfm implements zzatw {
    zzaty(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void S1() throws RemoteException {
        k0(1, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void o1() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void p6(int i2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeInt(i2);
        k0(4, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void v0(zzatq zzatqVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzatqVar);
        k0(3, parcelH);
    }
}
