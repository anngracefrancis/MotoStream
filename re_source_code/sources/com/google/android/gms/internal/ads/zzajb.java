package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzajb extends zzfn implements zzaja {
    public zzajb() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzajc zzajdVar;
        if (i2 == 3) {
            zzaar videoController = getVideoController();
            parcel2.writeNoException();
            zzfo.c(parcel2, videoController);
            return true;
        }
        if (i2 == 4) {
            destroy();
            parcel2.writeNoException();
            return true;
        }
        if (i2 != 5) {
            return false;
        }
        IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcel.readStrongBinder());
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzajdVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
            zzajdVar = iInterfaceQueryLocalInterface instanceof zzajc ? (zzajc) iInterfaceQueryLocalInterface : new zzajd(strongBinder);
        }
        m6(iObjectWrapperP, zzajdVar);
        parcel2.writeNoException();
        return true;
    }
}
