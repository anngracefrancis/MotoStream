package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaaw extends zzfm implements zzaau {
    zzaaw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void T0(boolean z) throws RemoteException {
        Parcel parcelH = H();
        zzfo.a(parcelH, z);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void n0() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoPause() throws RemoteException {
        k0(3, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoPlay() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoStart() throws RemoteException {
        k0(1, H());
    }
}
