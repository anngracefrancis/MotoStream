package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaex extends zzfn implements zzaew {
    public zzaex() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 2:
                IObjectWrapper iObjectWrapperR = r();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperR);
                return true;
            case 3:
                String strG = g();
                parcel2.writeNoException();
                parcel2.writeString(strG);
                return true;
            case 4:
                List listK = k();
                parcel2.writeNoException();
                parcel2.writeList(listK);
                return true;
            case 5:
                String strI = i();
                parcel2.writeNoException();
                parcel2.writeString(strI);
                return true;
            case 6:
                zzaei zzaeiVarN = n();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzaeiVarN);
                return true;
            case 7:
                String strH = h();
                parcel2.writeNoException();
                parcel2.writeString(strH);
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
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.g(parcel2, extras);
                return true;
            case 12:
                destroy();
                parcel2.writeNoException();
                return true;
            case 13:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 14:
                z((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zE = E((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfo.a(parcel2, zE);
                return true;
            case 16:
                L((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 17:
                zzaea zzaeaVarF = f();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzaeaVarF);
                return true;
            case 18:
                IObjectWrapper iObjectWrapperJ = j();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperJ);
                return true;
            case 19:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            default:
                return false;
        }
    }
}
