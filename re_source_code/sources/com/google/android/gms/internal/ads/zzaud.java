package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaud extends zzfm implements zzaub {
    zzaud(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaub
    public final void R4(int i2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeInt(i2);
        k0(2, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaub
    public final void n1() throws RemoteException {
        k0(1, H());
    }
}
