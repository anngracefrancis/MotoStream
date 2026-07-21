package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzane extends zzfn implements zzand {
    public zzane() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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
                zzaei zzaeiVarD0 = D0();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzaeiVarD0);
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
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 9:
                N(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                C0(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                boolean zC = C();
                parcel2.writeNoException();
                zzfo.a(parcel2, zC);
                return true;
            case 12:
                boolean zM = M();
                parcel2.writeNoException();
                zzfo.a(parcel2, zM);
                return true;
            case 13:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.g(parcel2, extras);
                return true;
            case 14:
                A(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                IObjectWrapper iObjectWrapperK = K();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperK);
                return true;
            case 16:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 17:
            case 18:
            default:
                return false;
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
        }
    }
}
