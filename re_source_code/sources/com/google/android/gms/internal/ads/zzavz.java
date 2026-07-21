package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzavz extends zzfm implements zzavy {
    zzavz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzavy
    public final void T6(String str, String str2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzavy
    public final void onError(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        k0(2, parcelH);
    }
}
