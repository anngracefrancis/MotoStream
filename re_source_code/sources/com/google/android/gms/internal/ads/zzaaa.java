package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaaa extends zzfm implements zzzy {
    zzaaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }

    @Override // com.google.android.gms.internal.ads.zzzy
    public final long getValue() throws RemoteException {
        Parcel parcelP = P(1, H());
        long j2 = parcelP.readLong();
        parcelP.recycle();
        return j2;
    }
}
