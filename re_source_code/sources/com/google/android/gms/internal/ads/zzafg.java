package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzafg extends zzfm implements zzafe {
    zzafg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final boolean F3(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        Parcel parcelP = P(10, parcelH);
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final zzaei N1(String str) throws RemoteException {
        zzaei zzaekVar;
        Parcel parcelH = H();
        parcelH.writeString(str);
        Parcel parcelP = P(2, parcelH);
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

    @Override // com.google.android.gms.internal.ads.zzafe
    public final IObjectWrapper U4() throws RemoteException {
        Parcel parcelP = P(9, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final String Y0(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        Parcel parcelP = P(1, parcelH);
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void destroy() throws RemoteException {
        k0(8, H());
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final List<String> getAvailableAssetNames() throws RemoteException {
        Parcel parcelP = P(3, H());
        ArrayList<String> arrayListCreateStringArrayList = parcelP.createStringArrayList();
        parcelP.recycle();
        return arrayListCreateStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final String getCustomTemplateId() throws RemoteException {
        Parcel parcelP = P(4, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final zzaar getVideoController() throws RemoteException {
        Parcel parcelP = P(7, H());
        zzaar zzaarVarH7 = zzaas.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaarVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void performClick(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void recordImpression() throws RemoteException {
        k0(6, H());
    }
}
