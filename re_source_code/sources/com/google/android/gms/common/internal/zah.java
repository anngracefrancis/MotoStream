package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zac;

/* JADX INFO: loaded from: classes2.dex */
public final class zah extends com.google.android.gms.internal.base.zaa implements ISignInButtonCreator {
    zah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // com.google.android.gms.common.internal.ISignInButtonCreator
    public final IObjectWrapper l3(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel parcelH = H();
        zac.c(parcelH, iObjectWrapper);
        zac.d(parcelH, signInButtonConfig);
        Parcel parcelP = P(2, parcelH);
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }
}
