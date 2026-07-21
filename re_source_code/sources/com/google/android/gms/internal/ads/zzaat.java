package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaat extends zzfm implements zzaar {
    zzaat(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final int F() throws RemoteException {
        Parcel parcelP = P(5, H());
        int i2 = parcelP.readInt();
        parcelP.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean G1() throws RemoteException {
        Parcel parcelP = P(4, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void R1(zzaau zzaauVar) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, zzaauVar);
        k0(8, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float T() throws RemoteException {
        Parcel parcelP = P(9, H());
        float f2 = parcelP.readFloat();
        parcelP.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final zzaau a5() throws RemoteException {
        zzaau zzaawVar;
        Parcel parcelP = P(11, H());
        IBinder strongBinder = parcelP.readStrongBinder();
        if (strongBinder == null) {
            zzaawVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            zzaawVar = iInterfaceQueryLocalInterface instanceof zzaau ? (zzaau) iInterfaceQueryLocalInterface : new zzaaw(strongBinder);
        }
        parcelP.recycle();
        return zzaawVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean d1() throws RemoteException {
        Parcel parcelP = P(12, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void k5() throws RemoteException {
        k0(1, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean l5() throws RemoteException {
        Parcel parcelP = P(10, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void o2(boolean z) throws RemoteException {
        Parcel parcelH = H();
        zzfo.a(parcelH, z);
        k0(3, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void pause() throws RemoteException {
        k0(2, H());
    }
}
