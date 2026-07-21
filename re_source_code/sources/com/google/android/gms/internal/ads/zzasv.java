package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzasv extends zzfm implements zzasu {
    zzasv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzasu
    public final void y3(zzasr zzasrVar, String str, String str2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzasrVar);
        parcelH.writeString(str);
        parcelH.writeString(str2);
        k0(2, parcelH);
    }
}
