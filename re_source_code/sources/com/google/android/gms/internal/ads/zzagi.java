package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzagi extends zzfm implements zzagg {
    zzagi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void D6() throws RemoteException {
        k0(28, H());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final boolean E(Bundle bundle) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, bundle);
        Parcel parcelP = P(16, parcelH);
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void G0(zzaag zzaagVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzaagVar);
        k0(26, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void L(Bundle bundle) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, bundle);
        k0(17, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void W() throws RemoteException {
        k0(22, H());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void d0(zzagd zzagdVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzagdVar);
        k0(21, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void destroy() throws RemoteException {
        k0(13, H());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void e0(zzaak zzaakVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzaakVar);
        k0(25, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaea f() throws RemoteException {
        zzaea zzaecVar;
        Parcel parcelP = P(14, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzaecVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzaecVar = iInterfaceQueryLocalInterface instanceof zzaea ? (zzaea) iInterfaceQueryLocalInterface : new zzaec(strongBinder);
        }
        parcelP.recycle();
        return zzaecVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String g() throws RemoteException {
        Parcel parcelP = P(2, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final Bundle getExtras() throws RemoteException {
        Parcel parcelP = P(20, H());
        Bundle bundle = (Bundle) zzfo.b(parcelP, Bundle.CREATOR);
        parcelP.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel parcelP = P(12, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getStore() throws RemoteException {
        Parcel parcelP = P(9, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaar getVideoController() throws RemoteException {
        Parcel parcelP = P(11, H());
        zzaar zzaarVarH7 = zzaas.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaarVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String h() throws RemoteException {
        Parcel parcelP = P(6, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String i() throws RemoteException {
        Parcel parcelP = P(4, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final IObjectWrapper j() throws RemoteException {
        Parcel parcelP = P(19, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void j0() throws RemoteException {
        k0(27, H());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final List k() throws RemoteException {
        Parcel parcelP = P(3, H());
        ArrayList arrayListF = zzfo.f(parcelP);
        parcelP.recycle();
        return arrayListF;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaei n() throws RemoteException {
        zzaei zzaekVar;
        Parcel parcelP = P(5, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzaekVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzaekVar = iInterfaceQueryLocalInterface instanceof zzaei ? (zzaei) iInterfaceQueryLocalInterface : new zzaek(strongBinder);
        }
        parcelP.recycle();
        return zzaekVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaee n2() throws RemoteException {
        zzaee zzaegVar;
        Parcel parcelP = P(29, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzaegVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzaegVar = iInterfaceQueryLocalInterface instanceof zzaee ? (zzaee) iInterfaceQueryLocalInterface : new zzaeg(strongBinder);
        }
        parcelP.recycle();
        return zzaegVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String o() throws RemoteException {
        Parcel parcelP = P(10, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final IObjectWrapper r() throws RemoteException {
        Parcel parcelP = P(18, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final double t() throws RemoteException {
        Parcel parcelP = P(8, H());
        double d2 = parcelP.readDouble();
        parcelP.recycle();
        return d2;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final boolean u2() throws RemoteException {
        Parcel parcelP = P(24, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final List u4() throws RemoteException {
        Parcel parcelP = P(23, H());
        ArrayList arrayListF = zzfo.f(parcelP);
        parcelP.recycle();
        return arrayListF;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String w() throws RemoteException {
        Parcel parcelP = P(7, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void z(Bundle bundle) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, bundle);
        k0(15, parcelH);
    }
}
