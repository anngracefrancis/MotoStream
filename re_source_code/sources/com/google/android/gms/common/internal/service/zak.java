package com.google.android.gms.common.internal.service;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zab;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zak extends zab implements zaj {
    public zak() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    protected boolean E3(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        z2(parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}
