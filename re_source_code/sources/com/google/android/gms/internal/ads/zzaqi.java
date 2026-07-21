package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaqi extends zzfm implements zzaqg {
    zzaqi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onActivityResult(int i2, int i3, Intent intent) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeInt(i2);
        parcelH.writeInt(i3);
        zzfo.d(parcelH, intent);
        k0(12, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, bundle);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onDestroy() throws RemoteException {
        k0(8, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onPause() throws RemoteException {
        k0(5, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onRestart() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onResume() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel parcelH = H();
        zzfo.d(parcelH, bundle);
        Parcel parcelP = P(6, parcelH);
        if (parcelP.readInt() != 0) {
            bundle.readFromParcel(parcelP);
        }
        parcelP.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onStart() throws RemoteException {
        k0(3, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onStop() throws RemoteException {
        k0(7, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void zzac(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        k0(13, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void zzdd() throws RemoteException {
        k0(9, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final boolean zztg() throws RemoteException {
        Parcel parcelP = P(11, H());
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }
}
