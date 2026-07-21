package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzanb extends zzfn implements zzana {
    public zzanb() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
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
                double dT = t();
                parcel2.writeNoException();
                parcel2.writeDouble(dT);
                return true;
            case 8:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                return true;
            case 9:
                String strO = o();
                parcel2.writeNoException();
                parcel2.writeString(strO);
                return true;
            case 10:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 11:
                N(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                C0(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zC = C();
                parcel2.writeNoException();
                zzfo.a(parcel2, zC);
                return true;
            case 14:
                boolean zM = M();
                parcel2.writeNoException();
                zzfo.a(parcel2, zM);
                return true;
            case 15:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.g(parcel2, extras);
                return true;
            case 16:
                A(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 17:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 18:
                IObjectWrapper iObjectWrapperK = K();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperK);
                return true;
            case 19:
                zzaea zzaeaVarF = f();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzaeaVarF);
                return true;
            case 20:
                IObjectWrapper iObjectWrapperI = I();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperI);
                return true;
            case 21:
                IObjectWrapper iObjectWrapperJ = j();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperJ);
                return true;
            case 22:
                D(IObjectWrapper.Stub.P(parcel.readStrongBinder()), IObjectWrapper.Stub.P(parcel.readStrongBinder()), IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
