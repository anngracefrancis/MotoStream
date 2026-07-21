package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzu extends zza implements zzs {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final int a() throws RemoteException {
        Parcel parcelP = P(2, H());
        int i2 = parcelP.readInt();
        parcelP.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final void q4(String str, String str2, Bundle bundle, long j2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzb.c(parcelH, bundle);
        parcelH.writeLong(j2);
        k0(1, parcelH);
    }
}
