package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzart extends zzfm implements zzarr {
    zzart(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzarr
    public final void K5(zzaym zzaymVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzaymVar);
        k0(2, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzarr
    public final void V0(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, parcelFileDescriptor);
        k0(1, parcelH);
    }
}
