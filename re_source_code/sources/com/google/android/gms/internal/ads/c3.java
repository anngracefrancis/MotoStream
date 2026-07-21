package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class c3 implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    private final /* synthetic */ zzaop a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzamv f12384b;

    c3(zzapc zzapcVar, zzaop zzaopVar, zzamv zzamvVar) {
        this.a = zzaopVar;
        this.f12384b = zzamvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        try {
            this.a.E4(new zzaoi(unifiedNativeAdMapper));
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        return new e3(this.f12384b);
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
