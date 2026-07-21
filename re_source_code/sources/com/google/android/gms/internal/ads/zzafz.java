package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzafz extends zzfm implements zzafx {
    zzafz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void u6(zzagg zzaggVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzaggVar);
        k0(1, parcelH);
    }
}
