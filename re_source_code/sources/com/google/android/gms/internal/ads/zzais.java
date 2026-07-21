package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzais extends zzfm implements zzaiq {
    zzais(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final void onInitializationFailed(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        k0(3, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final void onInitializationSucceeded() throws RemoteException {
        k0(2, H());
    }
}
