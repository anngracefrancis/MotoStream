package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzzl extends zzfn implements zzzk {
    public zzzl() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzzk h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return iInterfaceQueryLocalInterface instanceof zzzk ? (zzzk) iInterfaceQueryLocalInterface : new zzzm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzyz zzzbVar = null;
        zzzp zzzrVar = null;
        zzzy zzaaaVar = null;
        zzyw zzyyVar = null;
        zzzs zzzuVar = null;
        switch (i2) {
            case 1:
                IObjectWrapper iObjectWrapperS0 = S0();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperS0);
                return true;
            case 2:
                destroy();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zB = B();
                parcel2.writeNoException();
                zzfo.a(parcel2, zB);
                return true;
            case 4:
                boolean zJ4 = J4((zzxz) zzfo.b(parcel, zzxz.CREATOR));
                parcel2.writeNoException();
                zzfo.a(parcel2, zJ4);
                return true;
            case 5:
                pause();
                parcel2.writeNoException();
                return true;
            case 6:
                resume();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzzbVar = iInterfaceQueryLocalInterface instanceof zzyz ? (zzyz) iInterfaceQueryLocalInterface : new zzzb(strongBinder);
                }
                L0(zzzbVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    zzzuVar = iInterfaceQueryLocalInterface2 instanceof zzzs ? (zzzs) iInterfaceQueryLocalInterface2 : new zzzu(strongBinder2);
                }
                P5(zzzuVar);
                parcel2.writeNoException();
                return true;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 10:
                k4();
                parcel2.writeNoException();
                return true;
            case 11:
                x6();
                parcel2.writeNoException();
                return true;
            case 12:
                zzyd zzydVarC5 = C5();
                parcel2.writeNoException();
                zzfo.g(parcel2, zzydVarC5);
                return true;
            case 13:
                C2((zzyd) zzfo.b(parcel, zzyd.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                U5(zzaqo.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                C3(zzaqu.h7(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 19:
                H6(zzadp.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    zzyyVar = iInterfaceQueryLocalInterface3 instanceof zzyw ? (zzyw) iInterfaceQueryLocalInterface3 : new zzyy(strongBinder3);
                }
                w4(zzyyVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzaaaVar = iInterfaceQueryLocalInterface4 instanceof zzzy ? (zzzy) iInterfaceQueryLocalInterface4 : new zzaaa(strongBinder4);
                }
                v4(zzaaaVar);
                parcel2.writeNoException();
                return true;
            case 22:
                t1(zzfo.e(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                boolean zP0 = p0();
                parcel2.writeNoException();
                zzfo.a(parcel2, zP0);
                return true;
            case 24:
                h0(zzatc.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 29:
                W6((zzacd) zzfo.b(parcel, zzacd.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                X5((zzaax) zzfo.b(parcel, zzaax.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                String strF6 = f6();
                parcel2.writeNoException();
                parcel2.writeString(strF6);
                return true;
            case 32:
                zzzs zzzsVarI4 = I4();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzzsVarI4);
                return true;
            case 33:
                zzyz zzyzVarX5 = x5();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzyzVarX5);
                return true;
            case 34:
                setImmersiveMode(zzfo.e(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                String strC0 = c0();
                parcel2.writeNoException();
                parcel2.writeString(strC0);
                return true;
            case 36:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    zzzrVar = iInterfaceQueryLocalInterface5 instanceof zzzp ? (zzzp) iInterfaceQueryLocalInterface5 : new zzzr(strongBinder5);
                }
                z0(zzzrVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzfo.g(parcel2, adMetadata);
                return true;
            case 38:
                m4(parcel.readString());
                parcel2.writeNoException();
                return true;
        }
    }
}
