package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaiv extends zzfm implements zzait {
    zzaiv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzait
    public final void u0(List<zzaio> list) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeTypedList(list);
        k0(1, parcelH);
    }
}
