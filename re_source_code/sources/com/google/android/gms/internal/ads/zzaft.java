package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaft extends zzfm implements zzafr {
    zzaft(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final void M4(zzafe zzafeVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzafeVar);
        k0(1, parcelH);
    }
}
