package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class s2 implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzamv a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Adapter f13303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzanl f13304c;

    s2(zzanl zzanlVar, zzamv zzamvVar, Adapter adapter) {
        this.f13304c = zzanlVar;
        this.a = zzamvVar;
        this.f13303b = adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            this.f13304c.f14007j = mediationRewardedAd;
            this.a.onAdLoaded();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        return new zzauo(this.a);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            String canonicalName = this.f13303b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 30 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded medation ad: ");
            sb.append(str);
            zzbad.e(sb.toString());
            this.a.onAdFailedToLoad(0);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }
}
