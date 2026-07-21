package com.google.android.gms.internal.safetynet;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzj extends zza implements zzi {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.safetynet.internal.ISafetyNetService");
    }

    @Override // com.google.android.gms.internal.safetynet.zzi
    public final void M1(zzg zzgVar) throws RemoteException {
        Parcel parcelH = H();
        zzc.b(parcelH, zzgVar);
        P(5, parcelH);
    }
}
