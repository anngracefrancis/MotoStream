package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaoq extends zzfn implements zzaop {
    public zzaoq() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            E4(zzanh.h7(parcel.readStrongBinder()));
        } else {
            if (i2 != 2) {
                return false;
            }
            p(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
