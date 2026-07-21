package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzx extends zzfm implements zzzv {
    zzzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i2) throws RemoteException {
        zzzk zzzmVar;
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzydVar);
        parcelH.writeString(str);
        zzfo.c(parcelH, zzampVar);
        parcelH.writeInt(i2);
        Parcel parcelP = P(1, parcelH);
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzzmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzzmVar = iInterfaceQueryLocalInterface instanceof zzzk ? (zzzk) iInterfaceQueryLocalInterface : new zzzm(strongBinder);
        }
        parcelP.recycle();
        return zzzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zzb(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i2) throws RemoteException {
        zzzk zzzmVar;
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzydVar);
        parcelH.writeString(str);
        zzfo.c(parcelH, zzampVar);
        parcelH.writeInt(i2);
        Parcel parcelP = P(2, parcelH);
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzzmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzzmVar = iInterfaceQueryLocalInterface instanceof zzzk ? (zzzk) iInterfaceQueryLocalInterface : new zzzm(strongBinder);
        }
        parcelP.recycle();
        return zzzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaem zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, iObjectWrapper2);
        Parcel parcelP = P(5, parcelH);
        zzaem zzaemVarH7 = zzaen.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaemVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaqg zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        Parcel parcelP = P(8, parcelH);
        zzaqg zzaqgVarZzac = zzaqh.zzac(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaqgVarZzac;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzf zza(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i2) throws RemoteException {
        zzzf zzzhVar;
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeString(str);
        zzfo.c(parcelH, zzampVar);
        parcelH.writeInt(i2);
        Parcel parcelP = P(3, parcelH);
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzzhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (iInterfaceQueryLocalInterface instanceof zzzf) {
                zzzhVar = (zzzf) iInterfaceQueryLocalInterface;
            } else {
                zzzhVar = new zzzh(strongBinder);
            }
        }
        parcelP.recycle();
        return zzzhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzatt zzb(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeString(str);
        zzfo.c(parcelH, zzampVar);
        parcelH.writeInt(i2);
        Parcel parcelP = P(12, parcelH);
        zzatt zzattVarH7 = zzatu.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzattVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzasw zza(IObjectWrapper iObjectWrapper, zzamp zzampVar, int i2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, zzampVar);
        parcelH.writeInt(i2);
        Parcel parcelP = P(6, parcelH);
        zzasw zzaswVarH7 = zzasx.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaswVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaab zza(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        zzaab zzaadVar;
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeInt(i2);
        Parcel parcelP = P(9, parcelH);
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzaadVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (iInterfaceQueryLocalInterface instanceof zzaab) {
                zzaadVar = (zzaab) iInterfaceQueryLocalInterface;
            } else {
                zzaadVar = new zzaad(strongBinder);
            }
        }
        parcelP.recycle();
        return zzaadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, int i2) throws RemoteException {
        zzzk zzzmVar;
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzydVar);
        parcelH.writeString(str);
        parcelH.writeInt(i2);
        Parcel parcelP = P(10, parcelH);
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzzmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (iInterfaceQueryLocalInterface instanceof zzzk) {
                zzzmVar = (zzzk) iInterfaceQueryLocalInterface;
            } else {
                zzzmVar = new zzzm(strongBinder);
            }
        }
        parcelP.recycle();
        return zzzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaer zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, iObjectWrapper2);
        zzfo.c(parcelH, iObjectWrapper3);
        Parcel parcelP = P(11, parcelH);
        zzaer zzaerVarH7 = zzaes.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaerVarH7;
    }
}
