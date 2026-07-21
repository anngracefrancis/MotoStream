package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzatl extends zzfn implements zzatk {
    public zzatl() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzatk h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        return iInterfaceQueryLocalInterface instanceof zzatk ? (zzatk) iInterfaceQueryLocalInterface : new zzatm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                c3(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                break;
            case 2:
                F1(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                w3(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                break;
            case 4:
                f1(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                break;
            case 5:
                a2(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                break;
            case 6:
                Y5(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                break;
            case 7:
                Y3(IObjectWrapper.Stub.P(parcel.readStrongBinder()), (zzato) zzfo.b(parcel, zzato.CREATOR));
                break;
            case 8:
                G6(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                break;
            case 9:
                q2(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                e4(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                break;
            case 11:
                b5(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                break;
            case 12:
                zzb((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
