package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzv extends com.google.android.gms.internal.location.zzb implements zzu {
    public zzv() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzu P(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return iInterfaceQueryLocalInterface instanceof zzu ? (zzu) iInterfaceQueryLocalInterface : new zzw(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            W4((LocationResult) com.google.android.gms.internal.location.zzc.a(parcel, LocationResult.CREATOR));
        } else {
            if (i2 != 2) {
                return false;
            }
            P3((LocationAvailability) com.google.android.gms.internal.location.zzc.a(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
