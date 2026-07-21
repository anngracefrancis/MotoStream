package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzanc extends zzfm implements zzana {
    zzanc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void A(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(16, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final boolean C() throws RemoteException {
        Parcel parcelP = P(13, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void C0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(12, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void D(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, iObjectWrapper2);
        zzfo.c(parcelH, iObjectWrapper3);
        k0(22, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper I() throws RemoteException {
        Parcel parcelP = P(20, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper K() throws RemoteException {
        Parcel parcelP = P(18, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final boolean M() throws RemoteException {
        Parcel parcelP = P(14, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void N(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(11, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaea f() throws RemoteException {
        Parcel parcelP = P(19, H());
        zzaea zzaeaVarH7 = zzaeb.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaeaVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String g() throws RemoteException {
        Parcel parcelP = P(2, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final Bundle getExtras() throws RemoteException {
        Parcel parcelP = P(15, H());
        Bundle bundle = (Bundle) zzfo.b(parcelP, Bundle.CREATOR);
        parcelP.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getStore() throws RemoteException {
        Parcel parcelP = P(8, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaar getVideoController() throws RemoteException {
        Parcel parcelP = P(17, H());
        zzaar zzaarVarH7 = zzaas.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaarVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String h() throws RemoteException {
        Parcel parcelP = P(6, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String i() throws RemoteException {
        Parcel parcelP = P(4, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper j() throws RemoteException {
        Parcel parcelP = P(21, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final List k() throws RemoteException {
        Parcel parcelP = P(3, H());
        ArrayList arrayListF = zzfo.f(parcelP);
        parcelP.recycle();
        return arrayListF;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaei n() throws RemoteException {
        Parcel parcelP = P(5, H());
        zzaei zzaeiVarH7 = zzaej.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaeiVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String o() throws RemoteException {
        Parcel parcelP = P(9, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void recordImpression() throws RemoteException {
        k0(10, H());
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final double t() throws RemoteException {
        Parcel parcelP = P(7, H());
        double d2 = parcelP.readDouble();
        parcelP.recycle();
        return d2;
    }
}
