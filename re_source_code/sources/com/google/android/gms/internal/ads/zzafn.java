package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzafn extends zzfm implements zzafl {
    zzafn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafl
    public final void t2(zzafa zzafaVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzafaVar);
        k0(1, parcelH);
    }
}
