package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzatd extends zzfm implements zzatb {
    zzatd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void l1(zzasr zzasrVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzasrVar);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdClosed() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdFailedToLoad(int i2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeInt(i2);
        k0(7, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        k0(6, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        k0(1, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdOpened() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoCompleted() throws RemoteException {
        k0(8, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoStarted() throws RemoteException {
        k0(3, H());
    }
}
