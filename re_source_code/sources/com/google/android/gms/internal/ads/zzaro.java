package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaro extends zzfm implements zzarm {
    zzaro(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void I5(zzarx zzarxVar, zzarr zzarrVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzarxVar);
        zzfo.c(parcelH, zzarrVar);
        k0(4, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void X6(zzarx zzarxVar, zzarr zzarrVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzarxVar);
        zzfo.c(parcelH, zzarrVar);
        k0(5, parcelH);
    }
}
