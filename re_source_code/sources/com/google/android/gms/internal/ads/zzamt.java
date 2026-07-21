package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzamt extends zzfn implements zzams {
    public zzamt() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzamv zzamxVar = null;
        switch (i2) {
            case 1:
                IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzyd zzydVar = (zzyd) zzfo.b(parcel, zzyd.CREATOR);
                zzxz zzxzVar = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String string = parcel.readString();
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzamxVar = iInterfaceQueryLocalInterface instanceof zzamv ? (zzamv) iInterfaceQueryLocalInterface : new zzamx(strongBinder);
                }
                y2(iObjectWrapperP, zzydVar, zzxzVar, string, zzamxVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperX1 = x1();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperX1);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperP2 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzxz zzxzVar2 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String string2 = parcel.readString();
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzamxVar = iInterfaceQueryLocalInterface2 instanceof zzamv ? (zzamv) iInterfaceQueryLocalInterface2 : new zzamx(strongBinder2);
                }
                Y2(iObjectWrapperP2, zzxzVar2, string2, zzamxVar);
                parcel2.writeNoException();
                return true;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 5:
                destroy();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperP3 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzyd zzydVar2 = (zzyd) zzfo.b(parcel, zzyd.CREATOR);
                zzxz zzxzVar3 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzamxVar = iInterfaceQueryLocalInterface3 instanceof zzamv ? (zzamv) iInterfaceQueryLocalInterface3 : new zzamx(strongBinder3);
                }
                s4(iObjectWrapperP3, zzydVar2, zzxzVar3, string3, string4, zzamxVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperP4 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzxz zzxzVar4 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzamxVar = iInterfaceQueryLocalInterface4 instanceof zzamv ? (zzamv) iInterfaceQueryLocalInterface4 : new zzamx(strongBinder4);
                }
                c6(iObjectWrapperP4, zzxzVar4, string5, string6, zzamxVar);
                parcel2.writeNoException();
                return true;
            case 8:
                pause();
                parcel2.writeNoException();
                return true;
            case 9:
                resume();
                parcel2.writeNoException();
                return true;
            case 10:
                h4(IObjectWrapper.Stub.P(parcel.readStrongBinder()), (zzxz) zzfo.b(parcel, zzxz.CREATOR), parcel.readString(), zzatl.h7(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                o6((zzxz) zzfo.b(parcel, zzxz.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                showVideo();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zIsInitialized = isInitialized();
                parcel2.writeNoException();
                zzfo.a(parcel2, zIsInitialized);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperP5 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzxz zzxzVar5 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzamxVar = iInterfaceQueryLocalInterface5 instanceof zzamv ? (zzamv) iInterfaceQueryLocalInterface5 : new zzamx(strongBinder5);
                }
                M3(iObjectWrapperP5, zzxzVar5, string7, string8, zzamxVar, (zzady) zzfo.b(parcel, zzady.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                zzana zzanaVarB7 = b7();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzanaVarB7);
                return true;
            case 16:
                zzand zzandVarE6 = e6();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzandVarE6);
                return true;
            case 17:
                Bundle bundleZzsh = zzsh();
                parcel2.writeNoException();
                zzfo.g(parcel2, bundleZzsh);
                return true;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzfo.g(parcel2, interstitialAdapterInfo);
                return true;
            case 19:
                Bundle bundleR4 = r4();
                parcel2.writeNoException();
                zzfo.g(parcel2, bundleR4);
                return true;
            case 20:
                Q2((zzxz) zzfo.b(parcel, zzxz.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                w0(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zX3 = x3();
                parcel2.writeNoException();
                zzfo.a(parcel2, zX3);
                return true;
            case 23:
                H4(IObjectWrapper.Stub.P(parcel.readStrongBinder()), zzatl.h7(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                zzafe zzafeVarF2 = F2();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzafeVarF2);
                return true;
            case 25:
                setImmersiveMode(zzfo.e(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 27:
                zzang zzangVarP1 = P1();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzangVarP1);
                return true;
            case 28:
                IObjectWrapper iObjectWrapperP6 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzxz zzxzVar6 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String string9 = parcel.readString();
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzamxVar = iInterfaceQueryLocalInterface6 instanceof zzamv ? (zzamv) iInterfaceQueryLocalInterface6 : new zzamx(strongBinder6);
                }
                f2(iObjectWrapperP6, zzxzVar6, string9, zzamxVar);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                a4(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 31:
                G4(IObjectWrapper.Stub.P(parcel.readStrongBinder()), zzair.h7(parcel.readStrongBinder()), parcel.createTypedArrayList(zzaiw.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
