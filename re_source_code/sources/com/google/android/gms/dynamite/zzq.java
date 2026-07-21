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
public final class zzq extends zza implements IInterface {
    zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int E0() throws RemoteException {
        Parcel parcelH = H(6, k0());
        int i2 = parcelH.readInt();
        parcelH.recycle();
        return i2;
    }

    public final int E3(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel parcelK0 = k0();
        zzc.f(parcelK0, iObjectWrapper);
        parcelK0.writeString(str);
        zzc.c(parcelK0, z);
        Parcel parcelH = H(3, parcelK0);
        int i2 = parcelH.readInt();
        parcelH.recycle();
        return i2;
    }

    public final IObjectWrapper S4(IObjectWrapper iObjectWrapper, String str, int i2, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelK0 = k0();
        zzc.f(parcelK0, iObjectWrapper);
        parcelK0.writeString(str);
        parcelK0.writeInt(i2);
        zzc.f(parcelK0, iObjectWrapper2);
        Parcel parcelH = H(8, parcelK0);
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelH.readStrongBinder());
        parcelH.recycle();
        return iObjectWrapperP;
    }

    public final int V3(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel parcelK0 = k0();
        zzc.f(parcelK0, iObjectWrapper);
        parcelK0.writeString(str);
        zzc.c(parcelK0, z);
        Parcel parcelH = H(5, parcelK0);
        int i2 = parcelH.readInt();
        parcelH.recycle();
        return i2;
    }

    public final IObjectWrapper Y4(IObjectWrapper iObjectWrapper, String str, int i2) throws RemoteException {
        Parcel parcelK0 = k0();
        zzc.f(parcelK0, iObjectWrapper);
        parcelK0.writeString(str);
        parcelK0.writeInt(i2);
        Parcel parcelH = H(4, parcelK0);
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelH.readStrongBinder());
        parcelH.recycle();
        return iObjectWrapperP;
    }

    public final IObjectWrapper p5(IObjectWrapper iObjectWrapper, String str, boolean z, long j2) throws RemoteException {
        Parcel parcelK0 = k0();
        zzc.f(parcelK0, iObjectWrapper);
        parcelK0.writeString(str);
        zzc.c(parcelK0, z);
        parcelK0.writeLong(j2);
        Parcel parcelH = H(7, parcelK0);
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelH.readStrongBinder());
        parcelH.recycle();
        return iObjectWrapperP;
    }

    public final IObjectWrapper y4(IObjectWrapper iObjectWrapper, String str, int i2) throws RemoteException {
        Parcel parcelK0 = k0();
        zzc.f(parcelK0, iObjectWrapper);
        parcelK0.writeString(str);
        parcelK0.writeInt(i2);
        Parcel parcelH = H(2, parcelK0);
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelH.readStrongBinder());
        parcelH.recycle();
        return iObjectWrapperP;
    }
}
