package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class jn implements zzbsr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbsr f12834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzcqj f12835g;

    public jn(zzcqj zzcqjVar, zzbsr zzbsrVar) {
        this.f12835g = zzcqjVar;
        this.f12834f = zzbsrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        this.f12835g.m7();
        this.f12834f.onAdLoaded();
        this.f12835g.n7();
    }
}
