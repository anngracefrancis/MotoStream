package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzb extends zzfm implements zzyz {
    zzzb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdClicked() throws RemoteException {
        k0(6, H());
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdClosed() throws RemoteException {
        k0(1, H());
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdFailedToLoad(int i2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeInt(i2);
        k0(2, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdImpression() throws RemoteException {
        k0(7, H());
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdLeftApplication() throws RemoteException {
        k0(3, H());
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdLoaded() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdOpened() throws RemoteException {
        k0(5, H());
    }
}
