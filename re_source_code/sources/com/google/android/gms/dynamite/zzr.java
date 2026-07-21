package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzr extends zza implements IInterface {
    zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final IObjectWrapper E0(IObjectWrapper iObjectWrapper, String str, int i2, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelK0 = k0();
        zzc.f(parcelK0, iObjectWrapper);
        parcelK0.writeString(str);
        parcelK0.writeInt(i2);
        zzc.f(parcelK0, iObjectWrapper2);
        Parcel parcelH = H(2, parcelK0);
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelH.readStrongBinder());
        parcelH.recycle();
        return iObjectWrapperP;
    }

    public final IObjectWrapper E3(IObjectWrapper iObjectWrapper, String str, int i2, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelK0 = k0();
        zzc.f(parcelK0, iObjectWrapper);
        parcelK0.writeString(str);
        parcelK0.writeInt(i2);
        zzc.f(parcelK0, iObjectWrapper2);
        Parcel parcelH = H(3, parcelK0);
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelH.readStrongBinder());
        parcelH.recycle();
        return iObjectWrapperP;
    }
}
