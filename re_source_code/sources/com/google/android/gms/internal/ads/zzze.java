package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzze extends zzfm implements zzzc {
    zzze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void F5(zzxz zzxzVar, int i2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzxzVar);
        parcelH.writeInt(i2);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String c0() throws RemoteException {
        Parcel parcelP = P(4, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void j2(zzxz zzxzVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzxzVar);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean p0() throws RemoteException {
        Parcel parcelP = P(3, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }
}
