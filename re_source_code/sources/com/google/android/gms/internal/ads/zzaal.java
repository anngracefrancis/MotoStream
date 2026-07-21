package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaal extends zzfn implements zzaak {
    public zzaal() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzaak h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        return iInterfaceQueryLocalInterface instanceof zzaak ? (zzaak) iInterfaceQueryLocalInterface : new zzaam(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String description = getDescription();
            parcel2.writeNoException();
            parcel2.writeString(description);
        } else {
            if (i2 != 2) {
                return false;
            }
            String strZ1 = Z1();
            parcel2.writeNoException();
            parcel2.writeString(strZ1);
        }
        return true;
    }
}
