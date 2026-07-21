package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzast extends zzfm implements zzasr {
    zzast(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzasr
    public final int getAmount() throws RemoteException {
        Parcel parcelP = P(2, H());
        int i2 = parcelP.readInt();
        parcelP.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzasr
    public final String getType() throws RemoteException {
        Parcel parcelP = P(1, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }
}
