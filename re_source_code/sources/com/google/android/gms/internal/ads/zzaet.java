package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaet extends zzfm implements zzaer {
    zzaet(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void V(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void x0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(3, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void z5() throws RemoteException {
        k0(2, H());
    }
}
