package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class a extends zzyv {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzabb f12206c;

    a(zzabb zzabbVar) {
        this.f12206c = zzabbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyv, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i2) {
        this.f12206c.f13754d.zza(this.f12206c.D());
        super.onAdFailedToLoad(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzyv, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        this.f12206c.f13754d.zza(this.f12206c.D());
        super.onAdLoaded();
    }
}
