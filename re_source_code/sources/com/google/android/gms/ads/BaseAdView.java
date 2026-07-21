package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzxr;

/* JADX INFO: loaded from: classes2.dex */
class BaseAdView extends ViewGroup {
    protected final zzabb zzaaq;

    public BaseAdView(Context context, int i2) {
        super(context);
        this.zzaaq = new zzabb(this, i2);
    }

    public void destroy() {
        this.zzaaq.a();
    }

    public AdListener getAdListener() {
        return this.zzaaq.b();
    }

    public AdSize getAdSize() {
        return this.zzaaq.c();
    }

    public String getAdUnitId() {
        return this.zzaaq.e();
    }

    public String getMediationAdapterClassName() {
        return this.zzaaq.g();
    }

    public boolean isLoading() {
        return this.zzaaq.k();
    }

    public void loadAd(AdRequest adRequest) {
        this.zzaaq.y(adRequest.zzde());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
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
    protected void onMeasure(int i2, int i3) {
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

    public void pause() {
        this.zzaaq.l();
    }

    public void resume() {
        this.zzaaq.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(AdListener adListener) {
        this.zzaaq.o(adListener);
        if (adListener == 0) {
            this.zzaaq.z(null);
            this.zzaaq.r(null);
            return;
        }
        if (adListener instanceof zzxr) {
            this.zzaaq.z((zzxr) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zzaaq.r((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzaaq.p(adSize);
    }

    public void setAdUnitId(String str) {
        this.zzaaq.q(str);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.zzaaq = new zzabb(this, attributeSet, false, i2);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.zzaaq = new zzabb(this, attributeSet, false, i3);
    }
}
