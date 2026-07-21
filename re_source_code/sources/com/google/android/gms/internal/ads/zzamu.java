package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzamu extends zzfm implements zzams {
    zzamu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void G4(IObjectWrapper iObjectWrapper, zzaiq zzaiqVar, List<zzaiw> list) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, zzaiqVar);
        parcelH.writeTypedList(list);
        k0(31, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void H4(IObjectWrapper iObjectWrapper, zzatk zzatkVar, List<String> list) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.c(parcelH, zzatkVar);
        parcelH.writeStringList(list);
        k0(23, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void M3(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar, zzady zzadyVar, List<String> list) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzxzVar);
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzfo.c(parcelH, zzamvVar);
        zzfo.d(parcelH, zzadyVar);
        parcelH.writeStringList(list);
        k0(14, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzang P1() throws RemoteException {
        zzang zzaniVar;
        Parcel parcelP = P(27, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzaniVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzaniVar = iInterfaceQueryLocalInterface instanceof zzang ? (zzang) iInterfaceQueryLocalInterface : new zzani(strongBinder);
        }
        parcelP.recycle();
        return zzaniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void Y2(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzxzVar);
        parcelH.writeString(str);
        zzfo.c(parcelH, zzamvVar);
        k0(3, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void a4(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(30, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzana b7() throws RemoteException {
        zzana zzancVar;
        Parcel parcelP = P(15, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzancVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzancVar = iInterfaceQueryLocalInterface instanceof zzana ? (zzana) iInterfaceQueryLocalInterface : new zzanc(strongBinder);
        }
        parcelP.recycle();
        return zzancVar;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void c6(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzxzVar);
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzfo.c(parcelH, zzamvVar);
        k0(7, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void destroy() throws RemoteException {
        k0(5, H());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzand e6() throws RemoteException {
        zzand zzanfVar;
        Parcel parcelP = P(16, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzanfVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzanfVar = iInterfaceQueryLocalInterface instanceof zzand ? (zzand) iInterfaceQueryLocalInterface : new zzanf(strongBinder);
        }
        parcelP.recycle();
        return zzanfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void f2(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzxzVar);
        parcelH.writeString(str);
        zzfo.c(parcelH, zzamvVar);
        k0(28, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzaar getVideoController() throws RemoteException {
        Parcel parcelP = P(26, H());
        zzaar zzaarVarH7 = zzaas.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaarVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void h4(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzatk zzatkVar, String str2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzxzVar);
        parcelH.writeString(str);
        zzfo.c(parcelH, zzatkVar);
        parcelH.writeString(str2);
        k0(10, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean isInitialized() throws RemoteException {
        Parcel parcelP = P(13, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void o6(zzxz zzxzVar, String str) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, zzxzVar);
        parcelH.writeString(str);
        k0(11, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void pause() throws RemoteException {
        k0(8, H());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void resume() throws RemoteException {
        k0(9, H());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void s4(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzydVar);
        zzfo.d(parcelH, zzxzVar);
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzfo.c(parcelH, zzamvVar);
        k0(6, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel parcelH = H();
        zzfo.a(parcelH, z);
        k0(25, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showInterstitial() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showVideo() throws RemoteException {
        k0(12, H());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void w0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(21, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final IObjectWrapper x1() throws RemoteException {
        Parcel parcelP = P(2, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean x3() throws RemoteException {
        Parcel parcelP = P(22, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void y2(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        zzfo.d(parcelH, zzydVar);
        zzfo.d(parcelH, zzxzVar);
        parcelH.writeString(str);
        zzfo.c(parcelH, zzamvVar);
        k0(1, parcelH);
    }
}
