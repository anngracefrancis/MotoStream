package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzak extends zzb implements zzaj {
    public zzak() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        D1((zzad) zzc.a(parcel, zzad.CREATOR));
        return true;
    }
}
