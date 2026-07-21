package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaes extends zzfn implements zzaer {
    public zzaes() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public static zzaer h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        return iInterfaceQueryLocalInterface instanceof zzaer ? (zzaer) iInterfaceQueryLocalInterface : new zzaet(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            V(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
        } else if (i2 == 2) {
            z5();
        } else {
            if (i2 != 3) {
                return false;
            }
            x0(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
