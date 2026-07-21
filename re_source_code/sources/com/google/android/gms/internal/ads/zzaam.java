package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaam extends zzfm implements zzaak {
    zzaam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    @Override // com.google.android.gms.internal.ads.zzaak
    public final String Z1() throws RemoteException {
        Parcel parcelP = P(2, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzaak
    public final String getDescription() throws RemoteException {
        Parcel parcelP = P(1, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }
}
