package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzajd extends zzfm implements zzajc {
    zzajd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzajc
    public final void c7() throws RemoteException {
        k0(1, H());
    }

    @Override // com.google.android.gms.internal.ads.zzajc
    public final void i2(int i2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeInt(i2);
        k0(2, parcelH);
    }
}
