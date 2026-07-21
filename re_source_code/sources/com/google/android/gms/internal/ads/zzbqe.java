package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqe implements zzbrl, zzbrw, zzbsr, zzbtk, zzxr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Clock f14682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzawj f14683g;

    public zzbqe(Clock clock, zzawj zzawjVar) {
        this.f14682f = clock;
        this.f14683g = zzawjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void N(zzarx zzarxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void a(zzasr zzasrVar, String str, String str2) {
    }

    public final void b(zzxz zzxzVar) {
        this.f14683g.d(zzxzVar);
    }

    public final String c() {
        return this.f14683g.i();
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final void onAdClicked() {
        this.f14683g.g();
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdClosed() {
        this.f14683g.h();
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final void onAdImpression() {
        this.f14683g.f();
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        this.f14683g.c(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void q(zzcxu zzcxuVar) {
        this.f14683g.e(this.f14682f.b());
    }
}
