package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ e f12551f;

    f(e eVar) {
        this.f12551f = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f12551f.f12490f.f13778f != null) {
            try {
                this.f12551f.f12490f.f13778f.onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbad.d("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
