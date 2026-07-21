package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzapa extends zzfm implements zzaoy {
    zzapa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final void R2(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final void onFailure(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        k0(2, parcelH);
    }
}
