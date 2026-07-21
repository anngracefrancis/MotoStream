package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaua extends zzfm implements zzatz {
    zzaua(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzatz
    public final IBinder L6(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeString(str);
        zzfo.c(parcelH, zzampVar);
        parcelH.writeInt(i2);
        Parcel parcelP = P(1, parcelH);
        IBinder strongBinder = parcelP.readStrongBinder();
        parcelP.recycle();
        return strongBinder;
    }
}
