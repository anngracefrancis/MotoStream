package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzx extends zza implements zzz {
    zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzz
    public final int c() throws RemoteException {
        Parcel parcelH = H(2, k0());
        int i2 = parcelH.readInt();
        parcelH.recycle();
        return i2;
    }

    @Override // com.google.android.gms.common.internal.zzz
    public final IObjectWrapper d() throws RemoteException {
        Parcel parcelH = H(1, k0());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelH.readStrongBinder());
        parcelH.recycle();
        return iObjectWrapperP;
    }
}
