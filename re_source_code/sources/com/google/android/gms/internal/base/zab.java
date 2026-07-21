package com.google.android.gms.internal.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class zab extends Binder implements IInterface {
    protected zab(String str) {
        attachInterface(this, str);
    }

    protected boolean E3(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        return false;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        boolean zOnTransact;
        if (i2 > 16777215) {
            zOnTransact = super.onTransact(i2, parcel, parcel2, i3);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            zOnTransact = false;
        }
        if (zOnTransact) {
            return true;
        }
        return E3(i2, parcel, parcel2, i3);
    }
}
