package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfz extends zzfm implements zzfx {
    zzfz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void N3(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeString(str);
        parcelH.writeString(null);
        k0(8, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void R0(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        parcelH.writeString(str);
        k0(2, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void U0(byte[] bArr) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeByteArray(bArr);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void a1(int i2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeInt(i2);
        k0(7, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void a3(int[] iArr) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeIntArray(null);
        k0(4, parcelH);
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void b6() throws RemoteException {
        k0(3, H());
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void z3(int i2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeInt(i2);
        k0(6, parcelH);
    }
}
