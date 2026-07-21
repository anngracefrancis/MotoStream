package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzagh extends zzfn implements zzagg {
    public zzagh() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzagd zzagfVar;
        switch (i2) {
            case 2:
                String strG = g();
                parcel2.writeNoException();
                parcel2.writeString(strG);
                return true;
            case 3:
                List listK = k();
                parcel2.writeNoException();
                parcel2.writeList(listK);
                return true;
            case 4:
                String strI = i();
                parcel2.writeNoException();
                parcel2.writeString(strI);
                return true;
            case 5:
                zzaei zzaeiVarN = n();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzaeiVarN);
                return true;
            case 6:
                String strH = h();
                parcel2.writeNoException();
                parcel2.writeString(strH);
                return true;
            case 7:
                String strW = w();
                parcel2.writeNoException();
                parcel2.writeString(strW);
                return true;
            case 8:
                double dT = t();
                parcel2.writeNoException();
                parcel2.writeDouble(dT);
                return true;
            case 9:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                return true;
            case 10:
                String strO = o();
                parcel2.writeNoException();
                parcel2.writeString(strO);
                return true;
            case 11:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 12:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 13:
                destroy();
                parcel2.writeNoException();
                return true;
            case 14:
                zzaea zzaeaVarF = f();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzaeaVarF);
                return true;
            case 15:
                z((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 16:
                boolean zE = E((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfo.a(parcel2, zE);
                return true;
            case 17:
                L((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 18:
                IObjectWrapper iObjectWrapperR = r();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperR);
                return true;
            case 19:
                IObjectWrapper iObjectWrapperJ = j();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperJ);
                return true;
            case 20:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.g(parcel2, extras);
                return true;
            case 21:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzagfVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    zzagfVar = iInterfaceQueryLocalInterface instanceof zzagd ? (zzagd) iInterfaceQueryLocalInterface : new zzagf(strongBinder);
                }
                d0(zzagfVar);
                parcel2.writeNoException();
                return true;
            case 22:
                W();
                parcel2.writeNoException();
                return true;
            case 23:
                List listU4 = u4();
                parcel2.writeNoException();
                parcel2.writeList(listU4);
                return true;
            case 24:
                boolean zU2 = u2();
                parcel2.writeNoException();
                zzfo.a(parcel2, zU2);
                return true;
            case 25:
                e0(zzaal.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 26:
                G0(zzaah.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 27:
                j0();
                parcel2.writeNoException();
                return true;
            case 28:
                D6();
                parcel2.writeNoException();
                return true;
            case 29:
                zzaee zzaeeVarN2 = n2();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzaeeVarN2);
                return true;
            default:
                return false;
        }
    }
}
