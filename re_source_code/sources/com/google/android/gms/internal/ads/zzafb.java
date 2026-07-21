package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzafb extends zzfn implements zzafa {
    public zzafb() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
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
                zzaei zzaeiVarD0 = D0();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzaeiVarD0);
                return true;
            case 7:
                String strH = h();
                parcel2.writeNoException();
                parcel2.writeString(strH);
                return true;
            case 8:
                String strW = w();
                parcel2.writeNoException();
                parcel2.writeString(strW);
                return true;
            case 9:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.g(parcel2, extras);
                return true;
            case 10:
                destroy();
                parcel2.writeNoException();
                return true;
            case 11:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 12:
                z((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zE = E((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfo.a(parcel2, zE);
                return true;
            case 14:
                L((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzaea zzaeaVarF = f();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzaeaVarF);
                return true;
            case 16:
                IObjectWrapper iObjectWrapperJ = j();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperJ);
                return true;
            case 17:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            default:
                return false;
        }
    }
}
