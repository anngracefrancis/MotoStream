package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaeo extends zzfm implements zzaem {
    zzaeo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void V(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(3, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void X0(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeInt(i2);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void d5(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        zzfo.c(parcelH, iObjectWrapper);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void destroy() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final IObjectWrapper n4(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        Parcel parcelP = P(2, parcelH);
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void x0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(6, parcelH);
    }
}
