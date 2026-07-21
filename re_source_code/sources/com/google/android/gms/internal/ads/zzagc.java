package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzagc extends zzfm implements zzaga {
    zzagc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaga
    public final boolean W2(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelH = H();
        zzfo.c(parcelH, iObjectWrapper);
        Parcel parcelP = P(2, parcelH);
        boolean zE = zzfo.e(parcelP);
        parcelP.recycle();
        return zE;
    }
}
