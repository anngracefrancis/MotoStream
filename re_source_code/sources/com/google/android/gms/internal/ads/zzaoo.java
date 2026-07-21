package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaoo extends zzfm implements zzaom {
    zzaoo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final void K0() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final void p(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        k0(3, parcelH);
    }
}
