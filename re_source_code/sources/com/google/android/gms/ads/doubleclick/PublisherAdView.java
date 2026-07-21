package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzzk;

/* JADX INFO: loaded from: classes2.dex */
public final class PublisherAdView extends ViewGroup {
    private final zzabb zzabf;

    public PublisherAdView(Context context) {
        super(context);
        this.zzabf = new zzabb(this);
    }

    public final void destroy() {
        this.zzabf.a();
    }

    public final AdListener getAdListener() {
        return this.zzabf.b();
    }

    public final AdSize getAdSize() {
        return this.zzabf.c();
    }

    public final AdSize[] getAdSizes() {
        return this.zzabf.d();
    }

    public final String getAdUnitId() {
        return this.zzabf.e();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzabf.f();
    }

    public final String getMediationAdapterClassName() {
        return this.zzabf.g();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzabf.h();
    }

    public final VideoController getVideoController() {
        return this.zzabf.i();
    }

    public final VideoOptions getVideoOptions() {
        return this.zzabf.j();
    }

    public final boolean isLoading() {
        return this.zzabf.k();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzabf.y(publisherAdRequest.zzde());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i6 = ((i4 - i2) - measuredWidth) / 2;
        int i7 = ((i5 - i3) - measuredHeight) / 2;
        childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i3) {
        int heightInPixels;
        int measuredWidth = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e2) {
                zzbad.c("Unable to retrieve ad size.", e2);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                heightInPixels = adSize.getHeightInPixels(context);
                measuredWidth = widthInPixels;
            } else {
                heightInPixels = 0;
            }
        } else {
            measureChild(childAt, i2, i3);
            measuredWidth = childAt.getMeasuredWidth();
            heightInPixels = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i2), View.resolveSize(Math.max(heightInPixels, getSuggestedMinimumHeight()), i3));
    }

    public final void pause() {
        this.zzabf.l();
    }

    public final void recordManualImpression() {
        this.zzabf.m();
    }

    public final void resume() {
        this.zzabf.n();
    }

    public final void setAdListener(AdListener adListener) {
        this.zzabf.o(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzabf.A(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        this.zzabf.q(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzabf.r(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzabf.s(correlator);
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzabf.t(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzabf.u(onCustomRenderedAdLoadedListener);
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzabf.v(videoOptions);
    }

    public final boolean zza(zzzk zzzkVar) {
        return this.zzabf.B(zzzkVar);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzabf = new zzabb(this, attributeSet, true);
        Preconditions.l(context, "Context cannot be null");
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.zzabf = new zzabb(this, attributeSet, true);
    }
}
