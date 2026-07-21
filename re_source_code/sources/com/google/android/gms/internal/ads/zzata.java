package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzata extends zzfm implements zzasz {
    zzata(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzasz
    public final IBinder V5(IObjectWrapper iObjectWrapper, zzamp zzampVar, int i2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, zzampVar);
        parcelH.writeInt(i2);
        Parcel parcelP = P(1, parcelH);
        IBinder strongBinder = parcelP.readStrongBinder();
        parcelP.recycle();
        return strongBinder;
    }
}
