package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class el extends zzaon {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzcjy<zzaov, zzcla> f12534f;

    private el(zzclq zzclqVar, zzcjy zzcjyVar) {
        this.f12534f = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final void K0() throws RemoteException {
        ((zzcla) this.f12534f.f15314c).onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final void p(String str) throws RemoteException {
        ((zzcla) this.f12534f.f15314c).onAdFailedToLoad(0);
    }
}
