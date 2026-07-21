package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzamr extends zzfm implements zzamp {
    zzamr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzamp
    public final boolean N6(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        Parcel parcelP = P(2, parcelH);
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzamp
    public final zzaov P2(String str) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        Parcel parcelP = P(3, parcelH);
        zzaov zzaovVarH7 = zzaow.h7(parcelP.readStrongBinder());
        parcelP.recycle();
        return zzaovVarH7;
    }

    @Override // com.google.android.gms.internal.ads.zzamp
    public final zzams l6(String str) throws RemoteException {
        zzams zzamuVar;
        Parcel parcelH = H();
        parcelH.writeString(str);
        Parcel parcelP = P(1, parcelH);
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzamuVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzamuVar = iInterfaceQueryLocalInterface instanceof zzams ? (zzams) iInterfaceQueryLocalInterface : new zzamu(strongBinder);
        }
        parcelP.recycle();
        return zzamuVar;
    }
}
