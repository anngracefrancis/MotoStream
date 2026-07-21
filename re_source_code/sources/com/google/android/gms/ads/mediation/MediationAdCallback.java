package com.google.android.gms.ads.mediation;

/* JADX INFO: loaded from: classes2.dex */
public interface MediationAdCallback {
    void onAdClosed();

    void onAdOpened();

    void reportAdClicked();

    void reportAdImpression();
}
