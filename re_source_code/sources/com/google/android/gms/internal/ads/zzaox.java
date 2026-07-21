package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaox extends zzfm implements zzaov {
    zzaox(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void K4(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaoj zzaojVar, zzamv zzamvVar, zzyd zzydVar) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzfo.d(parcelH, zzxzVar);
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, zzaojVar);
        zzfo.c(parcelH, zzamvVar);
        zzfo.d(parcelH, zzydVar);
        k0(13, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final boolean L2(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        Parcel parcelP = P(17, parcelH);
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzapj a6() throws RemoteException {
        Parcel parcelP = P(2, H());
        zzapj zzapjVar = (zzapj) zzfo.b(parcelP, zzapj.CREATOR);
        parcelP.recycle();
        return zzapjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void g4(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaop zzaopVar, zzamv zzamvVar) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzfo.d(parcelH, zzxzVar);
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, zzaopVar);
        zzfo.c(parcelH, zzamvVar);
        k0(18, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzaar getVideoController() throws RemoteException {
        Parcel parcelP = P(5, H());
        zzaar zzaarVarH7 = zzaas.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaarVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void h5(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaos zzaosVar, zzamv zzamvVar) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzfo.d(parcelH, zzxzVar);
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, zzaosVar);
        zzfo.c(parcelH, zzamvVar);
        k0(16, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzapj i5() throws RemoteException {
        Parcel parcelP = P(3, H());
        zzapj zzapjVar = (zzapj) zzfo.b(parcelP, zzapj.CREATOR);
        parcelP.recycle();
        return zzapjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void u3(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzyd zzydVar, zzaoy zzaoyVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeString(str);
        zzfo.d(parcelH, bundle);
        zzfo.d(parcelH, bundle2);
        zzfo.d(parcelH, zzydVar);
        zzfo.c(parcelH, zzaoyVar);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final boolean x2(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        Parcel parcelP = P(15, parcelH);
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void y6(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaom zzaomVar, zzamv zzamvVar) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzfo.d(parcelH, zzxzVar);
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, zzaomVar);
        zzfo.c(parcelH, zzamvVar);
        k0(14, parcelH);
    }
}
