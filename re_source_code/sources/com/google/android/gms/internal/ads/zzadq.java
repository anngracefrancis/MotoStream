package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzadq extends zzfm implements zzado {
    zzadq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final void O2(zzadl zzadlVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzadlVar);
        k0(1, parcelH);
    }
}
