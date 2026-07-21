package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaaq extends zzfm implements zzaao {
    zzaaq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaao
    public final void onAdMetadataChanged() throws RemoteException {
        k0(1, H());
    }
}
