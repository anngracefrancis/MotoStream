package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzafw extends zzfm implements zzafu {
    zzafw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafu
    public final void h1(zzzk zzzkVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzzkVar);
        zzfo.c(parcelH, iObjectWrapper);
        k0(1, parcelH);
    }
}
