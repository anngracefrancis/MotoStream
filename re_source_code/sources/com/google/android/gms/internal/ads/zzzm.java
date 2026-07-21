package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzm extends zzfm implements zzzk {
    zzzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean B() throws RemoteException {
        Parcel parcelP = P(3, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void C2(zzyd zzydVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzydVar);
        k0(13, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyd C5() throws RemoteException {
        Parcel parcelP = P(12, H());
        zzyd zzydVar = (zzyd) zzfo.b(parcelP, zzyd.CREATOR);
        parcelP.recycle();
        return zzydVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void H6(zzado zzadoVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzadoVar);
        k0(19, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzzs I4() throws RemoteException {
        zzzs zzzuVar;
        Parcel parcelP = P(32, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzzuVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzzuVar = iInterfaceQueryLocalInterface instanceof zzzs ? (zzzs) iInterfaceQueryLocalInterface : new zzzu(strongBinder);
        }
        parcelP.recycle();
        return zzzuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean J4(zzxz zzxzVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzxzVar);
        Parcel parcelP = P(4, parcelH);
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void L0(zzyz zzyzVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzyzVar);
        k0(7, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void P5(zzzs zzzsVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzzsVar);
        k0(8, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final IObjectWrapper S0() throws RemoteException {
        Parcel parcelP = P(1, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void W6(zzacd zzacdVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzacdVar);
        k0(29, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String c0() throws RemoteException {
        Parcel parcelP = P(35, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void destroy() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String f6() throws RemoteException {
        Parcel parcelP = P(31, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel parcelP = P(37, H());
        Bundle bundle = (Bundle) zzfo.b(parcelP, Bundle.CREATOR);
        parcelP.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzaar getVideoController() throws RemoteException {
        zzaar zzaatVar;
        Parcel parcelP = P(26, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzaatVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            zzaatVar = iInterfaceQueryLocalInterface instanceof zzaar ? (zzaar) iInterfaceQueryLocalInterface : new zzaat(strongBinder);
        }
        parcelP.recycle();
        return zzaatVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void h0(zzatb zzatbVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzatbVar);
        k0(24, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean p0() throws RemoteException {
        Parcel parcelP = P(23, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void pause() throws RemoteException {
        k0(5, H());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void resume() throws RemoteException {
        k0(6, H());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel parcelH = H();
        zzfo.a(parcelH, z);
        k0(34, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void showInterstitial() throws RemoteException {
        k0(9, H());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void t1(boolean z) throws RemoteException {
        Parcel parcelH = H();
        zzfo.a(parcelH, z);
        k0(22, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void v4(zzzy zzzyVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzzyVar);
        k0(21, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void w4(zzyw zzywVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzywVar);
        k0(20, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyz x5() throws RemoteException {
        zzyz zzzbVar;
        Parcel parcelP = P(33, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzzbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            zzzbVar = iInterfaceQueryLocalInterface instanceof zzyz ? (zzyz) iInterfaceQueryLocalInterface : new zzzb(strongBinder);
        }
        parcelP.recycle();
        return zzzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void x6() throws RemoteException {
        k0(11, H());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void z0(zzzp zzzpVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzzpVar);
        k0(36, parcelH);
    }
}
