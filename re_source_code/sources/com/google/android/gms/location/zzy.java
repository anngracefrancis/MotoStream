package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzy extends com.google.android.gms.internal.location.zzb implements zzx {
    public zzy() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static zzx P(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return iInterfaceQueryLocalInterface instanceof zzx ? (zzx) iInterfaceQueryLocalInterface : new zzz(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        v6((Location) com.google.android.gms.internal.location.zzc.a(parcel, Location.CREATOR));
        return true;
    }
}
