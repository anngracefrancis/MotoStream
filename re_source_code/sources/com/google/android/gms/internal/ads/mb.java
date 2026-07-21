package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class mb implements com.google.android.gms.ads.internal.overlay.zzo {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbgz f12976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.google.android.gms.ads.internal.overlay.zzo f12977g;

    public mb(zzbgz zzbgzVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar) {
        this.f12976f = zzbgzVar;
        this.f12977g = zzoVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        this.f12977g.zzsz();
        this.f12976f.J();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
        this.f12977g.zzta();
        this.f12976f.c0();
    }
}
