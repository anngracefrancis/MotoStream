package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* JADX INFO: loaded from: classes2.dex */
final class f implements RewardedVideoAdListener {
    private final /* synthetic */ AbstractAdViewAdapter a;

    f(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewarded(RewardItem rewardItem) {
        this.a.zzmi.onRewarded(this.a, rewardItem);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdClosed() {
        this.a.zzmi.onAdClosed(this.a);
        AbstractAdViewAdapter.zza(this.a, (InterstitialAd) null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdFailedToLoad(int i2) {
        this.a.zzmi.onAdFailedToLoad(this.a, i2);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdLeftApplication() {
        this.a.zzmi.onAdLeftApplication(this.a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdLoaded() {
        this.a.zzmi.onAdLoaded(this.a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdOpened() {
        this.a.zzmi.onAdOpened(this.a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoCompleted() {
        this.a.zzmi.onVideoCompleted(this.a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoStarted() {
        this.a.zzmi.onVideoStarted(this.a);
    }
}
