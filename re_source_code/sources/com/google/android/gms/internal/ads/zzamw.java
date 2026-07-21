package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzamw extends zzfn implements zzamv {
    public zzamw() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzamv h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return iInterfaceQueryLocalInterface instanceof zzamv ? (zzamv) iInterfaceQueryLocalInterface : new zzamx(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzamy zzamzVar;
        switch (i2) {
            case 1:
                onAdClicked();
                break;
            case 2:
                onAdClosed();
                break;
            case 3:
                onAdFailedToLoad(parcel.readInt());
                break;
            case 4:
                onAdLeftApplication();
                break;
            case 5:
                onAdOpened();
                break;
            case 6:
                onAdLoaded();
                break;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzamzVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    zzamzVar = iInterfaceQueryLocalInterface instanceof zzamy ? (zzamy) iInterfaceQueryLocalInterface : new zzamz(strongBinder);
                }
                k1(zzamzVar);
                break;
            case 8:
                onAdImpression();
                break;
            case 9:
                onAppEvent(parcel.readString(), parcel.readString());
                break;
            case 10:
                F0(zzaff.h7(parcel.readStrongBinder()), parcel.readString());
                break;
            case 11:
                n0();
                break;
            case 12:
                m3(parcel.readString());
                break;
            case 13:
                b1();
                break;
            case 14:
                t5((zzato) zzfo.b(parcel, zzato.CREATOR));
                break;
            case 15:
                onVideoPause();
                break;
            case 16:
                v0(zzatr.h7(parcel.readStrongBinder()));
                break;
            case 17:
                R(parcel.readInt());
                break;
            case 18:
                I6();
                break;
            case 19:
                zzb((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                break;
            case 20:
                onVideoPlay();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
