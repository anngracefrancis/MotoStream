package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaas extends zzfn implements zzaar {
    public zzaas() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzaar h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return iInterfaceQueryLocalInterface instanceof zzaar ? (zzaar) iInterfaceQueryLocalInterface : new zzaat(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzaau zzaawVar;
        switch (i2) {
            case 1:
                k5();
                parcel2.writeNoException();
                return true;
            case 2:
                pause();
                parcel2.writeNoException();
                return true;
            case 3:
                o2(zzfo.e(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zG1 = G1();
                parcel2.writeNoException();
                zzfo.a(parcel2, zG1);
                return true;
            case 5:
                int iF = F();
                parcel2.writeNoException();
                parcel2.writeInt(iF);
                return true;
            case 6:
                float fQ6 = Q6();
                parcel2.writeNoException();
                parcel2.writeFloat(fQ6);
                return true;
            case 7:
                float fS5 = S5();
                parcel2.writeNoException();
                parcel2.writeFloat(fS5);
                return true;
            case 8:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzaawVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    zzaawVar = iInterfaceQueryLocalInterface instanceof zzaau ? (zzaau) iInterfaceQueryLocalInterface : new zzaaw(strongBinder);
                }
                R1(zzaawVar);
                parcel2.writeNoException();
                return true;
            case 9:
                float fT = T();
                parcel2.writeNoException();
                parcel2.writeFloat(fT);
                return true;
            case 10:
                boolean zL5 = l5();
                parcel2.writeNoException();
                zzfo.a(parcel2, zL5);
                return true;
            case 11:
                zzaau zzaauVarA5 = a5();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzaauVarA5);
                return true;
            case 12:
                boolean zD1 = d1();
                parcel2.writeNoException();
                zzfo.a(parcel2, zD1);
                return true;
            default:
                return false;
        }
    }
}
