package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaui extends zzatx {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RewardedAdCallback f14160f;

    public zzaui(RewardedAdCallback rewardedAdCallback) {
        this.f14160f = rewardedAdCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void S1() {
        RewardedAdCallback rewardedAdCallback = this.f14160f;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void o1() {
        RewardedAdCallback rewardedAdCallback = this.f14160f;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void p6(int i2) {
        RewardedAdCallback rewardedAdCallback = this.f14160f;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void v0(zzatq zzatqVar) {
        RewardedAdCallback rewardedAdCallback = this.f14160f;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzauh(zzatqVar));
        }
    }
}
