package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzatn implements MediationRewardedVideoAdListener {
    private final zzatk a;

    public zzatn(zzatk zzatkVar) {
        this.a = zzatkVar;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onAdClicked.");
        try {
            this.a.G6(ObjectWrapper.E0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onAdClosed.");
        try {
            this.a.Y5(ObjectWrapper.E0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i2) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onAdFailedToLoad.");
        try {
            this.a.q2(ObjectWrapper.E0(mediationRewardedVideoAdAdapter), i2);
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onAdLeftApplication.");
        try {
            this.a.e4(ObjectWrapper.E0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onAdLoaded.");
        try {
            this.a.w3(ObjectWrapper.E0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onAdOpened.");
        try {
            this.a.f1(ObjectWrapper.E0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i2) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onInitializationFailed.");
        try {
            this.a.F1(ObjectWrapper.E0(mediationRewardedVideoAdAdapter), i2);
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onInitializationSucceeded.");
        try {
            this.a.c3(ObjectWrapper.E0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onRewarded.");
        try {
            if (rewardItem != null) {
                this.a.Y3(ObjectWrapper.E0(mediationRewardedVideoAdAdapter), new zzato(rewardItem));
            } else {
                this.a.Y3(ObjectWrapper.E0(mediationRewardedVideoAdAdapter), new zzato(HttpUrl.FRAGMENT_ENCODE_SET, 1));
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoCompleted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onVideoCompleted.");
        try {
            this.a.b5(ObjectWrapper.E0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onVideoStarted.");
        try {
            this.a.a2(ObjectWrapper.E0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void zzb(Bundle bundle) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbad.e("Adapter called onAdMetadataChanged.");
        try {
            this.a.zzb(bundle);
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }
}
