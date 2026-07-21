package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: loaded from: classes2.dex */
final class e3 implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationNativeAdCallback, MediationRewardedAdCallback {
    private zzamv a;

    e3(zzamv zzamvVar) {
        this.a = zzamvVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdClosed() {
        try {
            this.a.onAdClosed();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onAdFailedToShow(String str) {
        try {
            String strValueOf = String.valueOf(str);
            zzbad.i(strValueOf.length() != 0 ? "Mediated ad failed to show: ".concat(strValueOf) : new String("Mediated ad failed to show: "));
            this.a.R(0);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdCallback, com.google.android.gms.ads.mediation.MediationInterstitialAdCallback, com.google.android.gms.ads.mediation.MediationNativeAdCallback
    public final void onAdLeftApplication() {
        try {
            this.a.onAdLeftApplication();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdOpened() {
        try {
            this.a.onAdOpened();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            this.a.v0(new zzaup(rewardItem));
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdCallback, com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onVideoComplete() {
        try {
            this.a.n0();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdCallback
    public final void onVideoMute() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdCallback
    public final void onVideoPause() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdCallback
    public final void onVideoPlay() {
        try {
            this.a.onVideoPlay();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onVideoStart() {
        try {
            this.a.b1();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdCallback
    public final void onVideoUnmute() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdClicked() {
        try {
            this.a.onAdClicked();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdImpression() {
    }
}
