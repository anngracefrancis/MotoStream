package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: loaded from: classes2.dex */
public interface MediationRewardedAdCallback extends MediationAdCallback {
    void onAdFailedToShow(String str);

    void onUserEarnedReward(RewardItem rewardItem);

    void onVideoComplete();

    void onVideoStart();
}
