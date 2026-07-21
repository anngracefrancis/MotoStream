package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzad extends zza implements zzaf {
    zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean C1(com.google.android.gms.common.zzs zzsVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelK0 = k0();
        com.google.android.gms.internal.common.zzc.d(parcelK0, zzsVar);
        com.google.android.gms.internal.common.zzc.f(parcelK0, iObjectWrapper);
        Parcel parcelH = H(5, parcelK0);
        boolean zG = com.google.android.gms.internal.common.zzc.g(parcelH);
        parcelH.recycle();
        return zG;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final zzq c4(zzo zzoVar) throws RemoteException {
        Parcel parcelK0 = k0();
        com.google.android.gms.internal.common.zzc.d(parcelK0, zzoVar);
        Parcel parcelH = H(8, parcelK0);
        zzq zzqVar = (zzq) com.google.android.gms.internal.common.zzc.a(parcelH, zzq.CREATOR);
        parcelH.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean l() throws RemoteException {
        Parcel parcelH = H(7, k0());
        boolean zG = com.google.android.gms.internal.common.zzc.g(parcelH);
        parcelH.recycle();
        return zG;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final zzq q3(zzo zzoVar) throws RemoteException {
        Parcel parcelK0 = k0();
        com.google.android.gms.internal.common.zzc.d(parcelK0, zzoVar);
        Parcel parcelH = H(6, parcelK0);
        zzq zzqVar = (zzq) com.google.android.gms.internal.common.zzc.a(parcelH, zzq.CREATOR);
        parcelH.recycle();
        return zzqVar;
    }
}
