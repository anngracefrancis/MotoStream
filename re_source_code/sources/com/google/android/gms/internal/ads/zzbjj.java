package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbjj extends zzfm implements zzbjh {
    zzbjj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.measurement.IMeasurementManager");
    }

    @Override // com.google.android.gms.internal.ads.zzbjh
    public final void A1(zzbjf zzbjfVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzbjfVar);
        k0(1, parcelH);
    }
}
