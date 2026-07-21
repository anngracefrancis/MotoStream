package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaul extends zzauc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RewardedAdLoadCallback f14161f;

    public zzaul(RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.f14161f = rewardedAdLoadCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzaub
    public final void R4(int i2) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.f14161f;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaub
    public final void n1() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.f14161f;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdLoaded();
        }
    }
}
