package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzatv extends zzfm implements zzatt {
    zzatv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void G5(zzaao zzaaoVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzaaoVar);
        k0(8, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void L5(zzatw zzatwVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzatwVar);
        k0(2, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final zzatq O6() throws RemoteException {
        zzatq zzatsVar;
        Parcel parcelP = P(11, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzatsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            zzatsVar = iInterfaceQueryLocalInterface instanceof zzatq ? (zzatq) iInterfaceQueryLocalInterface : new zzats(strongBinder);
        }
        parcelP.recycle();
        return zzatsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void W1(zzxz zzxzVar, zzaub zzaubVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzxzVar);
        zzfo.c(parcelH, zzaubVar);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void e7(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.a(parcelH, z);
        k0(10, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void f5(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel parcelP = P(9, H());
        Bundle bundle = (Bundle) zzfo.b(parcelP, Bundle.CREATOR);
        parcelP.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel parcelP = P(4, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final boolean isLoaded() throws RemoteException {
        Parcel parcelP = P(3, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void m2(zzaum zzaumVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzaumVar);
        k0(7, parcelH);
    }
}
