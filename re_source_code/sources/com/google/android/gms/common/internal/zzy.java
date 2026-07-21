package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzy extends zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static zzz P(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return iInterfaceQueryLocalInterface instanceof zzz ? (zzz) iInterfaceQueryLocalInterface : new zzx(iBinder);
    }

    @Override // com.google.android.gms.internal.common.zzb
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            IObjectWrapper iObjectWrapperD = d();
            parcel2.writeNoException();
            com.google.android.gms.internal.common.zzc.f(parcel2, iObjectWrapperD);
        } else {
            if (i2 != 2) {
                return false;
            }
            int iC = c();
            parcel2.writeNoException();
            parcel2.writeInt(iC);
        }
        return true;
    }
}
