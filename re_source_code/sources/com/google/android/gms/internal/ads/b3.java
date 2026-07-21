package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class b3 implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzaos a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzamv f12307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzapc f12308c;

    b3(zzapc zzapcVar, zzaos zzaosVar, zzamv zzamvVar) {
        this.f12308c = zzapcVar;
        this.a = zzaosVar;
        this.f12307b = zzamvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            this.f12308c.f14030h = mediationRewardedAd;
            this.a.K0();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        return new e3(this.f12307b);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.a.p(str);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }
}
