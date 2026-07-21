package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class j implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzabx f12788f;

    j(zzabx zzabxVar) {
        this.f12788f = zzabxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f12788f.f13781f != null) {
            try {
                this.f12788f.f13781f.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbad.d("Could not notify onRewardedVideoAdFailedToLoad event.", e2);
            }
        }
    }
}
