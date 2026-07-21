package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzauf extends zzfm implements zzaue {
    zzauf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaue
    public final void X2(zzatq zzatqVar, String str, String str2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzatqVar);
        parcelH.writeString(str);
        parcelH.writeString(str2);
        k0(2, parcelH);
    }
}
