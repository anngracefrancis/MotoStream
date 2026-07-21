package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzan extends zzb implements zzam {
    public zzan() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            Q5(parcel.readInt(), parcel.createStringArray());
        } else if (i2 == 2) {
            f7(parcel.readInt(), parcel.createStringArray());
        } else {
            if (i2 != 3) {
                return false;
            }
            v3(parcel.readInt(), (PendingIntent) zzc.a(parcel, PendingIntent.CREATOR));
        }
        return true;
    }
}
