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
public final class zzafc extends zzfm implements zzafa {
    zzafc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final zzaei D0() throws RemoteException {
        zzaei zzaekVar;
        Parcel parcelP = P(6, H());
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

    @Override // com.google.android.gms.internal.ads.zzafa
    public final boolean E(Bundle bundle) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, bundle);
        Parcel parcelP = P(13, parcelH);
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void L(Bundle bundle) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, bundle);
        k0(14, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void destroy() throws RemoteException {
        k0(10, H());
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final zzaea f() throws RemoteException {
        zzaea zzaecVar;
        Parcel parcelP = P(15, H());
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

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String g() throws RemoteException {
        Parcel parcelP = P(3, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final Bundle getExtras() throws RemoteException {
        Parcel parcelP = P(9, H());
        Bundle bundle = (Bundle) zzfo.b(parcelP, Bundle.CREATOR);
        parcelP.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel parcelP = P(17, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final zzaar getVideoController() throws RemoteException {
        Parcel parcelP = P(11, H());
        zzaar zzaarVarH7 = zzaas.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaarVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String h() throws RemoteException {
        Parcel parcelP = P(7, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String i() throws RemoteException {
        Parcel parcelP = P(5, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final List k() throws RemoteException {
        Parcel parcelP = P(4, H());
        ArrayList arrayListF = zzfo.f(parcelP);
        parcelP.recycle();
        return arrayListF;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final IObjectWrapper r() throws RemoteException {
        Parcel parcelP = P(2, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String w() throws RemoteException {
        Parcel parcelP = P(8, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void z(Bundle bundle) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, bundle);
        k0(12, parcelH);
    }
}
