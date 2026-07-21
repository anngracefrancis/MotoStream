package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzf extends zza implements zzd {
    zzf(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzd
    public final Bundle J(Bundle bundle) throws RemoteException {
        Parcel parcelH = H();
        zzb.c(parcelH, bundle);
        Parcel parcelP = P(1, parcelH);
        Bundle bundle2 = (Bundle) zzb.a(parcelP, Bundle.CREATOR);
        parcelP.recycle();
        return bundle2;
    }
}
