package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzafk extends zzfm implements zzafi {
    zzafk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafi
    public final void D3(zzaew zzaewVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzaewVar);
        k0(1, parcelH);
    }
}
