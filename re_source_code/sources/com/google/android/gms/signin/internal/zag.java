package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;

/* JADX INFO: loaded from: classes2.dex */
public final class zag extends com.google.android.gms.internal.base.zaa implements zaf {
    zag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void B1(int i2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeInt(i2);
        k0(7, parcelH);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void V2(IAccountAccessor iAccountAccessor, int i2, boolean z) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.base.zac.c(parcelH, iAccountAccessor);
        parcelH.writeInt(i2);
        com.google.android.gms.internal.base.zac.a(parcelH, z);
        k0(9, parcelH);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void n3(zah zahVar, zad zadVar) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.base.zac.d(parcelH, zahVar);
        com.google.android.gms.internal.base.zac.c(parcelH, zadVar);
        k0(12, parcelH);
    }
}
