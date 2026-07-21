package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class f3 implements com.google.android.gms.ads.internal.overlay.zzo {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzapl f12556f;

    f3(zzapl zzaplVar) {
        this.f12556f = zzaplVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
        zzbad.e("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
        zzbad.e("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        zzbad.e("AdMobCustomTabsAdapter overlay is closed.");
        this.f12556f.f14034b.onAdClosed(this.f12556f);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
        zzbad.e("Opening AdMobCustomTabsAdapter overlay.");
        this.f12556f.f14034b.onAdOpened(this.f12556f);
    }
}
