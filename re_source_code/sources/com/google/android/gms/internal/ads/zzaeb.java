package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaeb extends zzfn implements zzaea {
    public zzaeb() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzaea h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        return iInterfaceQueryLocalInterface instanceof zzaea ? (zzaea) iInterfaceQueryLocalInterface : new zzaec(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 2) {
            String strM1 = m1();
            parcel2.writeNoException();
            parcel2.writeString(strM1);
            return true;
        }
        if (i2 != 3) {
            return false;
        }
        List<zzaei> listM0 = M0();
        parcel2.writeNoException();
        parcel2.writeList(listM0);
        return true;
    }
}
