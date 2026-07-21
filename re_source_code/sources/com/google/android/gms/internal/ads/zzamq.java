package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzamq extends zzfn implements zzamp {
    public zzamq() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzamp h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return iInterfaceQueryLocalInterface instanceof zzamp ? (zzamp) iInterfaceQueryLocalInterface : new zzamr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzams zzamsVarL6 = l6(parcel.readString());
            parcel2.writeNoException();
            zzfo.c(parcel2, zzamsVarL6);
        } else if (i2 == 2) {
            boolean zN6 = N6(parcel.readString());
            parcel2.writeNoException();
            zzfo.a(parcel2, zN6);
        } else {
            if (i2 != 3) {
                return false;
            }
            zzaov zzaovVarP2 = P2(parcel.readString());
            parcel2.writeNoException();
            zzfo.c(parcel2, zzaovVarP2);
        }
        return true;
    }
}
