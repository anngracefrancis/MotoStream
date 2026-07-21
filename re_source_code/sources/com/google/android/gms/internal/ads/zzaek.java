package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaek extends zzfm implements zzaei {
    zzaek(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final Uri I0() throws RemoteException {
        Parcel parcelP = P(2, H());
        Uri uri = (Uri) zzfo.b(parcelP, Uri.CREATOR);
        parcelP.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final double T3() throws RemoteException {
        Parcel parcelP = P(3, H());
        double d2 = parcelP.readDouble();
        parcelP.recycle();
        return d2;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int getHeight() throws RemoteException {
        Parcel parcelP = P(5, H());
        int i2 = parcelP.readInt();
        parcelP.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int getWidth() throws RemoteException {
        Parcel parcelP = P(4, H());
        int i2 = parcelP.readInt();
        parcelP.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final IObjectWrapper t4() throws RemoteException {
        Parcel parcelP = P(1, H());
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcelP.readStrongBinder());
        parcelP.recycle();
        return iObjectWrapperP;
    }
}
