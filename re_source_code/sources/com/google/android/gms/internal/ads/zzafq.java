package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzafq extends zzfm implements zzafo {
    zzafq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void F0(zzafe zzafeVar, String str) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzafeVar);
        parcelH.writeString(str);
        k0(1, parcelH);
    }
}
