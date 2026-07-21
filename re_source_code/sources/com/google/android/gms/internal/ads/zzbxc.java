package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxc implements zzbrl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbrt f14799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcxm f14800g;

    public zzbxc(zzbrt zzbrtVar, zzcxm zzcxmVar) {
        this.f14799f = zzbrtVar;
        this.f14800g = zzcxmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void a(zzasr zzasrVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdOpened() {
        int i2 = this.f14800g.O;
        if (i2 == 0 || i2 == 1) {
            this.f14799f.Y();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoStarted() {
    }
}
