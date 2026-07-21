package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaug;

/* JADX INFO: loaded from: classes2.dex */
public final class RewardedAd {
    private final zzaug zzgnu;

    public RewardedAd(Context context, String str) {
        Preconditions.l(context, "context cannot be null");
        Preconditions.l(str, "adUnitID cannot be null");
        this.zzgnu = new zzaug(context, str);
    }

    public final Bundle getAdMetadata() {
        return this.zzgnu.a();
    }

    public final String getMediationAdapterClassName() {
        return this.zzgnu.b();
    }

    public final RewardItem getRewardItem() {
        return this.zzgnu.c();
    }

    public final boolean isLoaded() {
        return this.zzgnu.d();
    }

    public final void loadAd(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzgnu.i(adRequest.zzde(), rewardedAdLoadCallback);
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzgnu.e(onAdMetadataChangedListener);
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.zzgnu.f(serverSideVerificationOptions);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        this.zzgnu.g(activity, rewardedAdCallback);
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzgnu.i(publisherAdRequest.zzde(), rewardedAdLoadCallback);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        this.zzgnu.h(activity, rewardedAdCallback, z);
    }
}
