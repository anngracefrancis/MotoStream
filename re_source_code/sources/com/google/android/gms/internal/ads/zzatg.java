package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzatg extends zzatc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RewardedVideoAdListener f14149f;

    public zzatg(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f14149f = rewardedVideoAdListener;
    }

    public final RewardedVideoAdListener i7() {
        return this.f14149f;
    }

    public final void j7(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f14149f = rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void l1(zzasr zzasrVar) {
        RewardedVideoAdListener rewardedVideoAdListener = this.f14149f;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewarded(new zzate(zzasrVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdClosed() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f14149f;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdFailedToLoad(int i2) {
        RewardedVideoAdListener rewardedVideoAdListener = this.f14149f;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdFailedToLoad(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdLeftApplication() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f14149f;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdLoaded() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f14149f;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdOpened() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f14149f;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoCompleted() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f14149f;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoCompleted();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoStarted() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f14149f;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoStarted();
        }
    }
}
