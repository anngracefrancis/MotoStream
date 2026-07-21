package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaok extends zzfn implements zzaoj {
    public zzaok() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            c1(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
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
