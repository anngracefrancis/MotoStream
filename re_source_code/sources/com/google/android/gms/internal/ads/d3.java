package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class d3 implements SignalCallbacks {
    private final /* synthetic */ zzaoy a;

    d3(zzapc zzapcVar, zzaoy zzaoyVar) {
        this.a = zzaoyVar;
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onFailure(String str) {
        try {
            this.a.onFailure(str);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onSuccess(String str) {
        try {
            this.a.R2(str);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }
}
