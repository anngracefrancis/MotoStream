package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class ml extends zzaoq {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzcjy<zzaov, zzcla> f12990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzcmg f12991g;

    private ml(zzcmg zzcmgVar, zzcjy zzcjyVar) {
        this.f12991g = zzcmgVar;
        this.f12990f = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void E4(zzang zzangVar) throws RemoteException {
        this.f12991g.f15384c = zzangVar;
        ((zzcla) this.f12990f.f15314c).onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void p(String str) throws RemoteException {
        ((zzcla) this.f12990f.f15314c).onAdFailedToLoad(0);
    }
}
