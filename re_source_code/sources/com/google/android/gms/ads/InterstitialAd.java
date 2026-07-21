package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabd;
import com.google.android.gms.internal.ads.zzxr;

/* JADX INFO: loaded from: classes2.dex */
public final class InterstitialAd {
    private final zzabd zzaas;

    public InterstitialAd(Context context) {
        this.zzaas = new zzabd(context);
        Preconditions.l(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzaas.a();
    }

    public final Bundle getAdMetadata() {
        return this.zzaas.b();
    }

    public final String getAdUnitId() {
        return this.zzaas.c();
    }

    public final String getMediationAdapterClassName() {
        return this.zzaas.e();
    }

    public final boolean isLoaded() {
        return this.zzaas.g();
    }

    public final boolean isLoading() {
        return this.zzaas.h();
    }

    public final void loadAd(AdRequest adRequest) {
        this.zzaas.r(adRequest.zzde());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAdListener(AdListener adListener) {
        this.zzaas.i(adListener);
        if (adListener != 0 && (adListener instanceof zzxr)) {
            this.zzaas.s((zzxr) adListener);
        } else if (adListener == 0) {
            this.zzaas.s(null);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.zzaas.j(adMetadataListener);
    }

    public final void setAdUnitId(String str) {
        this.zzaas.k(str);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzaas.n(z);
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzaas.p(rewardedVideoAdListener);
    }

    public final void show() {
        this.zzaas.q();
    }

    public final void zzc(boolean z) {
        this.zzaas.t(true);
    }
}
