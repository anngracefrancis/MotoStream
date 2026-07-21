package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabd;

/* JADX INFO: loaded from: classes2.dex */
public final class PublisherInterstitialAd {
    private final zzabd zzaas;

    public PublisherInterstitialAd(Context context) {
        this.zzaas = new zzabd(context, this);
        Preconditions.l(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzaas.a();
    }

    public final String getAdUnitId() {
        return this.zzaas.c();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzaas.d();
    }

    public final String getMediationAdapterClassName() {
        return this.zzaas.e();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzaas.f();
    }

    public final boolean isLoaded() {
        return this.zzaas.g();
    }

    public final boolean isLoading() {
        return this.zzaas.h();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzaas.r(publisherAdRequest.zzde());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzaas.i(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzaas.k(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzaas.l(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzaas.m(correlator);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzaas.n(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzaas.o(onCustomRenderedAdLoadedListener);
    }

    public final void show() {
        this.zzaas.q();
    }
}
