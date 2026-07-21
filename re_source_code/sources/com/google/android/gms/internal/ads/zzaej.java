package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaej extends zzfn implements zzaei {
    public zzaej() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzaei h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return iInterfaceQueryLocalInterface instanceof zzaei ? (zzaei) iInterfaceQueryLocalInterface : new zzaek(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            IObjectWrapper iObjectWrapperT4 = t4();
            parcel2.writeNoException();
            zzfo.c(parcel2, iObjectWrapperT4);
        } else if (i2 == 2) {
            Uri uriI0 = I0();
            parcel2.writeNoException();
            zzfo.g(parcel2, uriI0);
        } else if (i2 == 3) {
            double dT3 = T3();
            parcel2.writeNoException();
            parcel2.writeDouble(dT3);
        } else if (i2 == 4) {
            int width = getWidth();
            parcel2.writeNoException();
            parcel2.writeInt(width);
        } else {
            if (i2 != 5) {
                return false;
            }
            int height = getHeight();
            parcel2.writeNoException();
            parcel2.writeInt(height);
        }
        return true;
    }
}
