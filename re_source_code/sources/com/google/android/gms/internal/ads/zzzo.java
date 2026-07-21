package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzo extends zzfm implements zzzn {
    zzzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzzn
    public final IBinder o5(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i2, int i3) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzydVar);
        parcelH.writeString(str);
        zzfo.c(parcelH, zzampVar);
        parcelH.writeInt(i2);
        parcelH.writeInt(i3);
        Parcel parcelP = P(2, parcelH);
        IBinder strongBinder = parcelP.readStrongBinder();
        parcelP.recycle();
        return strongBinder;
    }
}
