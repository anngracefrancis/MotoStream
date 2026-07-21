package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzars extends zzfn implements zzarr {
    public zzars() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            V0((ParcelFileDescriptor) zzfo.b(parcel, ParcelFileDescriptor.CREATOR));
        } else {
            if (i2 != 2) {
                return false;
            }
            K5((zzaym) zzfo.b(parcel, zzaym.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
