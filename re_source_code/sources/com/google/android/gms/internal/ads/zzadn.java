package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzadn extends zzfm implements zzadl {
    zzadn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final String M5() throws RemoteException {
        Parcel parcelP = P(1, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final String getContent() throws RemoteException {
        Parcel parcelP = P(2, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void recordClick() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void recordImpression() throws RemoteException {
        k0(5, H());
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void z1(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(3, parcelH);
    }
}
