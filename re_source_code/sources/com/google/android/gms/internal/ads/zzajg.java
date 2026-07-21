package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzajg extends zzfm implements zzaje {
    zzajg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void g6(zzaja zzajaVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzajaVar);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void h3(int i2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeInt(i2);
        k0(2, parcelH);
    }
}
