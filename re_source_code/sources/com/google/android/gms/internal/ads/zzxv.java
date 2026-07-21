package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzxv extends zzza {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AdListener f16966f;

    public zzxv(AdListener adListener) {
        this.f16966f = adListener;
    }

    public final AdListener h7() {
        return this.f16966f;
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdClicked() {
        this.f16966f.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdClosed() {
        this.f16966f.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdFailedToLoad(int i2) {
        this.f16966f.onAdFailedToLoad(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdImpression() {
        this.f16966f.onAdImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdLeftApplication() {
        this.f16966f.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdLoaded() {
        this.f16966f.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdOpened() {
        this.f16966f.onAdOpened();
    }
}
