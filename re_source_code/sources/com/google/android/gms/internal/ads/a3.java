package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class a3 implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzaom a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzamv f12213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzapc f12214c;

    a3(zzapc zzapcVar, zzaom zzaomVar, zzamv zzamvVar) {
        this.f12214c = zzapcVar;
        this.a = zzaomVar;
        this.f12213b = zzamvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        try {
            this.f12214c.f14029g = mediationInterstitialAd;
            this.a.K0();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        return new e3(this.f12213b);
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
