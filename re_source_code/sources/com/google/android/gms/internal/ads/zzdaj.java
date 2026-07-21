package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdaj extends zzfm implements zzdah {
    zzdaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final String H0() throws RemoteException {
        Parcel parcelP = P(6, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final boolean H1(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        Parcel parcelP = P(2, parcelH);
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final void a7(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(7, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final IObjectWrapper d3(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeString(str2);
        parcelH.writeString(str3);
        parcelH.writeString(str4);
        parcelH.writeString(str5);
        Parcel parcelP = P(9, parcelH);
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final void p1(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, iObjectWrapper2);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final void w6(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(4, parcelH);
    }
}
