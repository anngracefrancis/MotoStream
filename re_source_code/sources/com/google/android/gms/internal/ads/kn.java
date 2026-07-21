package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class kn implements zzban<zzcrc> {
    private final /* synthetic */ zzavy a;

    kn(zzcqq zzcqqVar, zzavy zzavyVar) {
        this.a = zzavyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        try {
            this.a.onError("Internal error.");
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzcrc zzcrcVar) {
        zzcrc zzcrcVar2 = zzcrcVar;
        try {
            this.a.T6(zzcrcVar2.a, zzcrcVar2.f15558b);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }
}
