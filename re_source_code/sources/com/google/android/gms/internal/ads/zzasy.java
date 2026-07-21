package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzasy extends zzfm implements zzasw {
    zzasy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void M6(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(9, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void T5(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(10, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void d2(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(11, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel parcelP = P(15, H());
        Bundle bundle = (Bundle) zzfo.b(parcelP, Bundle.CREATOR);
        parcelP.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel parcelP = P(12, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void h0(zzatb zzatbVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzatbVar);
        k0(3, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void i4(zzath zzathVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzathVar);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final boolean isLoaded() throws RemoteException {
        Parcel parcelP = P(5, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setCustomData(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        k0(19, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel parcelH = H();
        zzfo.a(parcelH, z);
        k0(34, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setUserId(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        k0(13, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void show() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void z0(zzzp zzzpVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzzpVar);
        k0(14, parcelH);
    }
}
