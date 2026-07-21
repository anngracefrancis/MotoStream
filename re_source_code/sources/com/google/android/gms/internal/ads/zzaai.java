package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaai extends zzfm implements zzaag {
    zzaai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaag
    public final void onAdMuted() throws RemoteException {
        k0(1, H());
    }
}
