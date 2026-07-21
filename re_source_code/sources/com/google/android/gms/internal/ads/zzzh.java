package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzh extends zzfm implements zzzf {
    zzzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void D5(String str, zzafr zzafrVar, zzafo zzafoVar) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        zzfo.c(parcelH, zzafrVar);
        zzfo.c(parcelH, zzafoVar);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void G3(zzafi zzafiVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzafiVar);
        k0(3, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final zzzc J1() throws RemoteException {
        zzzc zzzeVar;
        Parcel parcelP = P(1, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzzeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            zzzeVar = iInterfaceQueryLocalInterface instanceof zzzc ? (zzzc) iInterfaceQueryLocalInterface : new zzze(strongBinder);
        }
        parcelP.recycle();
        return zzzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void X1(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, publisherAdViewOptions);
        k0(9, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void Z3(zzafx zzafxVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzafxVar);
        k0(10, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void e2(zzyz zzyzVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzyzVar);
        k0(2, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void i1(zzafu zzafuVar, zzyd zzydVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzafuVar);
        zzfo.d(parcelH, zzydVar);
        k0(8, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void k6(zzady zzadyVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzadyVar);
        k0(6, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void q5(zzzy zzzyVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzzyVar);
        k0(7, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void y1(zzafl zzaflVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzaflVar);
        k0(4, parcelH);
    }
}
