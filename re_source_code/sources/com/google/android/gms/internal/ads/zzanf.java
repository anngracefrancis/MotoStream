package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzanf extends zzfm implements zzand {
    zzanf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void A(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(14, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean C() throws RemoteException {
        Parcel parcelP = P(11, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void C0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(10, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void D(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, iObjectWrapper2);
        zzfo.c(parcelH, iObjectWrapper3);
        k0(22, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaei D0() throws RemoteException {
        Parcel parcelP = P(5, H());
        zzaei zzaeiVarH7 = zzaej.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaeiVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper I() throws RemoteException {
        Parcel parcelP = P(20, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper K() throws RemoteException {
        Parcel parcelP = P(15, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean M() throws RemoteException {
        Parcel parcelP = P(12, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void N(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(9, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaea f() throws RemoteException {
        Parcel parcelP = P(19, H());
        zzaea zzaeaVarH7 = zzaeb.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaeaVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String g() throws RemoteException {
        Parcel parcelP = P(2, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final Bundle getExtras() throws RemoteException {
        Parcel parcelP = P(13, H());
        Bundle bundle = (Bundle) zzfo.b(parcelP, Bundle.CREATOR);
        parcelP.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaar getVideoController() throws RemoteException {
        Parcel parcelP = P(16, H());
        zzaar zzaarVarH7 = zzaas.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaarVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String h() throws RemoteException {
        Parcel parcelP = P(6, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String i() throws RemoteException {
        Parcel parcelP = P(4, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper j() throws RemoteException {
        Parcel parcelP = P(21, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final List k() throws RemoteException {
        Parcel parcelP = P(3, H());
        ArrayList arrayListF = zzfo.f(parcelP);
        parcelP.recycle();
        return arrayListF;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void recordImpression() throws RemoteException {
        k0(8, H());
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String w() throws RemoteException {
        Parcel parcelP = P(7, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }
}
