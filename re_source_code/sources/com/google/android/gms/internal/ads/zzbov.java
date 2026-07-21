package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbov implements zzbsr, zzue {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzcxm f14639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbrt f14640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f14641h = new AtomicBoolean();

    public zzbov(zzcxm zzcxmVar, zzbrt zzbrtVar) {
        this.f14639f = zzcxmVar;
        this.f14640g = zzbrtVar;
    }

    private final void j() {
        if (this.f14641h.compareAndSet(false, true)) {
            this.f14640g.Y();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final synchronized void onAdLoaded() {
        if (this.f14639f.f15727e != 1) {
            j();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final void r0(zzud zzudVar) {
        if (this.f14639f.f15727e == 1 && zzudVar.m) {
            j();
        }
    }
}
