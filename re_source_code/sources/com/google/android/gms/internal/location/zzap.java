package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzap extends zza implements zzao {
    zzap(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void A3(zzo zzoVar) throws RemoteException {
        Parcel parcelH = H();
        zzc.b(parcelH, zzoVar);
        P(75, parcelH);
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void B0(boolean z) throws RemoteException {
        Parcel parcelH = H();
        zzc.c(parcelH, z);
        P(12, parcelH);
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void B5(zzbf zzbfVar) throws RemoteException {
        Parcel parcelH = H();
        zzc.b(parcelH, zzbfVar);
        P(59, parcelH);
    }
}
