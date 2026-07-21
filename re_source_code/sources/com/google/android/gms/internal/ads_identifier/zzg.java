package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzg extends zza implements zze {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final boolean c() throws RemoteException {
        Parcel parcelP = P(6, H());
        boolean zB = zzc.b(parcelP);
        parcelP.recycle();
        return zB;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final boolean g0(boolean z) throws RemoteException {
        Parcel parcelH = H();
        zzc.a(parcelH, true);
        Parcel parcelP = P(2, parcelH);
        boolean zB = zzc.b(parcelP);
        parcelP.recycle();
        return zB;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final String getId() throws RemoteException {
        Parcel parcelP = P(1, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }
}
