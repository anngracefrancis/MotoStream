package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class fn implements zzbsr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbsr f12600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzcqf f12601g;

    public fn(zzcqf zzcqfVar, zzbsr zzbsrVar) {
        this.f12601g = zzcqfVar;
        this.f12600f = zzbsrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        this.f12601g.l7();
        this.f12600f.onAdLoaded();
        this.f12601g.m7();
    }
}
