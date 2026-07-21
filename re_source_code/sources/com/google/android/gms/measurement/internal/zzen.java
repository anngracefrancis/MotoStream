package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzen extends zza implements zzel {
    zzen(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzv> A2(String str, String str2, zzm zzmVar) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzmVar);
        Parcel parcelP = P(16, parcelH);
        ArrayList arrayListCreateTypedArrayList = parcelP.createTypedArrayList(zzv.CREATOR);
        parcelP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkj> K1(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        parcelH.writeString(str3);
        com.google.android.gms.internal.measurement.zzb.d(parcelH, z);
        Parcel parcelP = P(15, parcelH);
        ArrayList arrayListCreateTypedArrayList = parcelP.createTypedArrayList(zzkj.CREATOR);
        parcelP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final String P4(zzm zzmVar) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzmVar);
        Parcel parcelP = P(11, parcelH);
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void R6(zzv zzvVar) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzvVar);
        k0(13, parcelH);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final byte[] T1(zzan zzanVar, String str) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzanVar);
        parcelH.writeString(str);
        Parcel parcelP = P(9, parcelH);
        byte[] bArrCreateByteArray = parcelP.createByteArray();
        parcelP.recycle();
        return bArrCreateByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void U3(zzm zzmVar) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzmVar);
        k0(6, parcelH);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void Z5(zzan zzanVar, zzm zzmVar) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzanVar);
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzmVar);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void b4(zzkj zzkjVar, zzm zzmVar) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzkjVar);
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzmVar);
        k0(2, parcelH);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkj> f3(String str, String str2, boolean z, zzm zzmVar) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        com.google.android.gms.internal.measurement.zzb.d(parcelH, z);
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzmVar);
        Parcel parcelP = P(14, parcelH);
        ArrayList arrayListCreateTypedArrayList = parcelP.createTypedArrayList(zzkj.CREATOR);
        parcelP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void h2(zzv zzvVar, zzm zzmVar) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzvVar);
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzmVar);
        k0(12, parcelH);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void j3(long j2, String str, String str2, String str3) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeLong(j2);
        parcelH.writeString(str);
        parcelH.writeString(str2);
        parcelH.writeString(str3);
        k0(10, parcelH);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void j6(zzan zzanVar, String str, String str2) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzanVar);
        parcelH.writeString(str);
        parcelH.writeString(str2);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void r2(zzm zzmVar) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzmVar);
        k0(18, parcelH);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzv> r3(String str, String str2, String str3) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        parcelH.writeString(str3);
        Parcel parcelP = P(17, parcelH);
        ArrayList arrayListCreateTypedArrayList = parcelP.createTypedArrayList(zzv.CREATOR);
        parcelP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void s6(zzm zzmVar) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.measurement.zzb.c(parcelH, zzmVar);
        k0(4, parcelH);
    }
}
