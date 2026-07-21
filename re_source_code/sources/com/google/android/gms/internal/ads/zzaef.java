package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaef extends zzfn implements zzaee {
    public zzaef() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 2) {
            return false;
        }
        float fT = T();
        parcel2.writeNoException();
        parcel2.writeFloat(fT);
        return true;
    }
}
