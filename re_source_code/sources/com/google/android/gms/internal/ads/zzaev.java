package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaev extends zzfm implements zzaeu {
    zzaev(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final IBinder y5(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, iObjectWrapper2);
        zzfo.c(parcelH, iObjectWrapper3);
        Parcel parcelP = P(1, parcelH);
        IBinder strongBinder = parcelP.readStrongBinder();
        parcelP.recycle();
        return strongBinder;
    }
}
