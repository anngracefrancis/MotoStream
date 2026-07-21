package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzagm extends zzafj {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener f13881f;

    public zzagm(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.f13881f = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafi
    public final void D3(zzaew zzaewVar) {
        this.f13881f.onAppInstallAdLoaded(new zzaez(zzaewVar));
    }
}
