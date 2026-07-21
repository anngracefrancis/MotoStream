package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class z2 implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzaoj a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzamv f13670b;

    z2(zzapc zzapcVar, zzaoj zzaojVar, zzamv zzamvVar) {
        this.a = zzaojVar;
        this.f13670b = zzamvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        try {
            this.a.c1(ObjectWrapper.E0(mediationBannerAd.getView()));
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        return new e3(this.f13670b);
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
