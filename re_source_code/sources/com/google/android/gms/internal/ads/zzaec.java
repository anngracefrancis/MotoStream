package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaec extends zzfm implements zzaea {
    zzaec(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final List<zzaei> M0() throws RemoteException {
        Parcel parcelP = P(3, H());
        ArrayList arrayListF = zzfo.f(parcelP);
        parcelP.recycle();
        return arrayListF;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final String m1() throws RemoteException {
        Parcel parcelP = P(2, H());
        String string = parcelP.readString();
        parcelP.recycle();
        return string;
    }
}
