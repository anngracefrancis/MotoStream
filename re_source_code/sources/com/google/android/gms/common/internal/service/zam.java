package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zam extends com.google.android.gms.internal.base.zaa implements zal {
    zam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    @Override // com.google.android.gms.common.internal.service.zal
    public final void N0(zaj zajVar) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.base.zac.c(parcelH, zajVar);
        E0(1, parcelH);
    }
}
