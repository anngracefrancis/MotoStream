package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaac extends zzfn implements zzaab {
    public zzaac() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                a();
                parcel2.writeNoException();
                return true;
            case 2:
                v5(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 3:
                e5(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                c2(zzfo.e(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                t6(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                B2(parcel.readString(), IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                float fC4 = C4();
                parcel2.writeNoException();
                parcel2.writeFloat(fC4);
                return true;
            case 8:
                boolean zJ3 = J3();
                parcel2.writeNoException();
                zzfo.a(parcel2, zJ3);
                return true;
            case 9:
                String strH3 = H3();
                parcel2.writeNoException();
                parcel2.writeString(strH3);
                return true;
            case 10:
                N2(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                O0(zzamq.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                Y1(zzaiu.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                List<zzaio> listT2 = T2();
                parcel2.writeNoException();
                parcel2.writeTypedList(listT2);
                return true;
            default:
                return false;
        }
    }
}
