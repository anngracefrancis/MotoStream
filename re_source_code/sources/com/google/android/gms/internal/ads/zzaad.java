package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaad extends zzfm implements zzaab {
    zzaad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void B2(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        zzfo.c(parcelH, iObjectWrapper);
        k0(6, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final float C4() throws RemoteException {
        Parcel parcelP = P(7, H());
        float f2 = parcelP.readFloat();
        parcelP.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final String H3() throws RemoteException {
        Parcel parcelP = P(9, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final boolean J3() throws RemoteException {
        Parcel parcelP = P(8, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void N2(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        k0(10, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void O0(zzamp zzampVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzampVar);
        k0(11, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void a() throws RemoteException {
        k0(1, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void c2(boolean z) throws RemoteException {
        Parcel parcelH = H();
        zzfo.a(parcelH, z);
        k0(4, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void t6(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeString(str);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void v5(float f2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeFloat(f2);
        k0(2, parcelH);
    }
}
