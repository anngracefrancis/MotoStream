package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzzg extends zzfn implements zzzf {
    public zzzg() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzyz zzzbVar = null;
        zzzy zzaaaVar = null;
        switch (i2) {
            case 1:
                zzzc zzzcVarJ1 = J1();
                parcel2.writeNoException();
                zzfo.c(parcel2, zzzcVarJ1);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzzbVar = iInterfaceQueryLocalInterface instanceof zzyz ? (zzyz) iInterfaceQueryLocalInterface : new zzzb(strongBinder);
                }
                e2(zzzbVar);
                parcel2.writeNoException();
                return true;
            case 3:
                G3(zzafj.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                y1(zzafm.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                D5(parcel.readString(), zzafs.h7(parcel.readStrongBinder()), zzafp.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                k6((zzady) zzfo.b(parcel, zzady.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzaaaVar = iInterfaceQueryLocalInterface2 instanceof zzzy ? (zzzy) iInterfaceQueryLocalInterface2 : new zzaaa(strongBinder2);
                }
                q5(zzaaaVar);
                parcel2.writeNoException();
                return true;
            case 8:
                i1(zzafv.h7(parcel.readStrongBinder()), (zzyd) zzfo.b(parcel, zzyd.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                X1((PublisherAdViewOptions) zzfo.b(parcel, PublisherAdViewOptions.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                Z3(zzafy.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                Q3((zzaiy) zzfo.b(parcel, zzaiy.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                M2(zzajf.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
