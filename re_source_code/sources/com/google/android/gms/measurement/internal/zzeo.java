package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzc;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeo extends zzc implements zzel {
    public zzeo() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzc
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                Z5((zzan) com.google.android.gms.internal.measurement.zzb.a(parcel, zzan.CREATOR), (zzm) com.google.android.gms.internal.measurement.zzb.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                b4((zzkj) com.google.android.gms.internal.measurement.zzb.a(parcel, zzkj.CREATOR), (zzm) com.google.android.gms.internal.measurement.zzb.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                s6((zzm) com.google.android.gms.internal.measurement.zzb.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                j6((zzan) com.google.android.gms.internal.measurement.zzb.a(parcel, zzan.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                U3((zzm) com.google.android.gms.internal.measurement.zzb.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzkj> listI1 = I1((zzm) com.google.android.gms.internal.measurement.zzb.a(parcel, zzm.CREATOR), com.google.android.gms.internal.measurement.zzb.e(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(listI1);
                return true;
            case 9:
                byte[] bArrT1 = T1((zzan) com.google.android.gms.internal.measurement.zzb.a(parcel, zzan.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrT1);
                return true;
            case 10:
                j3(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String strP4 = P4((zzm) com.google.android.gms.internal.measurement.zzb.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(strP4);
                return true;
            case 12:
                h2((zzv) com.google.android.gms.internal.measurement.zzb.a(parcel, zzv.CREATOR), (zzm) com.google.android.gms.internal.measurement.zzb.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                R6((zzv) com.google.android.gms.internal.measurement.zzb.a(parcel, zzv.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzkj> listF3 = f3(parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzb.e(parcel), (zzm) com.google.android.gms.internal.measurement.zzb.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listF3);
                return true;
            case 15:
                List<zzkj> listK1 = K1(parcel.readString(), parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzb.e(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(listK1);
                return true;
            case 16:
                List<zzv> listA2 = A2(parcel.readString(), parcel.readString(), (zzm) com.google.android.gms.internal.measurement.zzb.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listA2);
                return true;
            case 17:
                List<zzv> listR3 = r3(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(listR3);
                return true;
            case 18:
                r2((zzm) com.google.android.gms.internal.measurement.zzb.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
