package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class t2 implements InitializationCompleteCallback {
    private final /* synthetic */ zzaiq a;

    t2(zzanl zzanlVar, zzaiq zzaiqVar) {
        this.a = zzaiqVar;
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationFailed(String str) {
        try {
            this.a.onInitializationFailed(str);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationSucceeded() {
        try {
            this.a.onInitializationSucceeded();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }
}
