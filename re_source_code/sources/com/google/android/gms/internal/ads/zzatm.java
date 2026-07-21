package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzatm extends zzfm implements zzatk {
    zzatm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void F1(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeInt(i2);
        k0(2, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void G6(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(8, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void Y3(IObjectWrapper iObjectWrapper, zzato zzatoVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzatoVar);
        k0(7, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void Y5(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(6, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void a2(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void b5(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(11, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void c3(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void e4(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(10, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void f1(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(4, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void q2(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeInt(i2);
        k0(9, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void w3(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(3, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, bundle);
        k0(12, parcelH);
    }
}
