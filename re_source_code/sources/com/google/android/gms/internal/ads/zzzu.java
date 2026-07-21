package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzu extends zzfm implements zzzs {
    zzzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzzs
    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        k0(1, parcelH);
    }
}
