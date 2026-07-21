package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwq implements com.google.android.gms.ads.internal.overlay.zzo {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbsv f14780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbuv f14781g;

    public zzbwq(zzbsv zzbsvVar, zzbuv zzbuvVar) {
        this.f14780f = zzbsvVar;
        this.f14781g = zzbuvVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
        this.f14780f.onPause();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
        this.f14780f.onResume();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        this.f14780f.zzsz();
        this.f14781g.Y();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
        this.f14780f.zzta();
        this.f14781g.f0();
    }
}
