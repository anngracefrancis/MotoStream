package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class wa implements com.google.android.gms.ads.internal.overlay.zzo {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbgz f13504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.google.android.gms.ads.internal.overlay.zzo f13505g;

    public wa(zzbgz zzbgzVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar) {
        this.f13504f = zzbgzVar;
        this.f13505g = zzoVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        this.f13505g.zzsz();
        this.f13504f.J();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
        this.f13505g.zzta();
        this.f13504f.c0();
    }
}
