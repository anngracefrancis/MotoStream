package com.google.android.gms.internal.safetynet;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.zzd;
import com.google.android.gms.safetynet.zzf;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzh extends zzb implements zzg {
    public zzh() {
        super("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
    }

    @Override // com.google.android.gms.internal.safetynet.zzb
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            s1((Status) zzc.a(parcel, Status.CREATOR), (com.google.android.gms.safetynet.zza) zzc.a(parcel, com.google.android.gms.safetynet.zza.CREATOR));
        } else if (i2 == 2) {
            u(parcel.readString());
        } else if (i2 == 3) {
            H2((Status) zzc.a(parcel, Status.CREATOR), (SafeBrowsingData) zzc.a(parcel, SafeBrowsingData.CREATOR));
        } else if (i2 == 4) {
            A6((Status) zzc.a(parcel, Status.CREATOR), zzc.c(parcel));
        } else if (i2 == 6) {
            R3((Status) zzc.a(parcel, Status.CREATOR), (zzf) zzc.a(parcel, zzf.CREATOR));
        } else if (i2 == 8) {
            s5((Status) zzc.a(parcel, Status.CREATOR), (zzd) zzc.a(parcel, zzd.CREATOR));
        } else if (i2 == 15) {
            H5((Status) zzc.a(parcel, Status.CREATOR), (com.google.android.gms.safetynet.zzh) zzc.a(parcel, com.google.android.gms.safetynet.zzh.CREATOR));
        } else if (i2 == 10) {
            E5((Status) zzc.a(parcel, Status.CREATOR), zzc.c(parcel));
        } else {
            if (i2 != 11) {
                return false;
            }
            y0((Status) zzc.a(parcel, Status.CREATOR));
        }
        return true;
    }
}
