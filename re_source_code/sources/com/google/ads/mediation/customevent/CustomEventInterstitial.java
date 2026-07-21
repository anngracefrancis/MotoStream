package com.google.ads.mediation.customevent;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface CustomEventInterstitial {
    /* synthetic */ void destroy();

    void requestInterstitialAd(b bVar, Activity activity, String str, String str2, com.google.ads.mediation.a aVar, Object obj);

    void showInterstitial();
}
