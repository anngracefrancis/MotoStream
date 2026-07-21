package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzagf extends zzfm implements zzagd {
    zzagf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final void onUnconfirmedClickCancelled() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final void onUnconfirmedClickReceived(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        k0(1, parcelH);
    }
}
