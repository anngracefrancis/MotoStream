package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzabp f12608f;

    g(zzabp zzabpVar) {
        this.f12608f = zzabpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f12608f.f13779f != null) {
            try {
                this.f12608f.f13779f.onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbad.d("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
