package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaoi extends zzanh {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final UnifiedNativeAdMapper f14027f;

    public zzaoi(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.f14027f = unifiedNativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void A(IObjectWrapper iObjectWrapper) {
        this.f14027f.untrackView((View) ObjectWrapper.k0(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean C() {
        return this.f14027f.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void D(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f14027f.trackViews((View) ObjectWrapper.k0(iObjectWrapper), (HashMap) ObjectWrapper.k0(iObjectWrapper2), (HashMap) ObjectWrapper.k0(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper I() {
        View viewZzacd = this.f14027f.zzacd();
        if (viewZzacd == null) {
            return null;
        }
        return ObjectWrapper.E0(viewZzacd);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper K() {
        View adChoicesContent = this.f14027f.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.E0(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean M() {
        return this.f14027f.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void N(IObjectWrapper iObjectWrapper) {
        this.f14027f.handleClick((View) ObjectWrapper.k0(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final float X3() {
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzaea f() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String g() {
        return this.f14027f.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle getExtras() {
        return this.f14027f.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getStore() {
        return this.f14027f.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzaar getVideoController() {
        if (this.f14027f.getVideoController() != null) {
            return this.f14027f.getVideoController().zzdh();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String h() {
        return this.f14027f.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String i() {
        return this.f14027f.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper j() {
        Object objZzkv = this.f14027f.zzkv();
        if (objZzkv == null) {
            return null;
        }
        return ObjectWrapper.E0(objZzkv);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final List k() {
        List<NativeAd.Image> images = this.f14027f.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image image : images) {
                arrayList.add(new zzadw(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzaei n() {
        NativeAd.Image icon = this.f14027f.getIcon();
        if (icon != null) {
            return new zzadw(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String o() {
        return this.f14027f.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void recordImpression() {
        this.f14027f.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final double t() {
        if (this.f14027f.getStarRating() != null) {
            return this.f14027f.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String w() {
        return this.f14027f.getAdvertiser();
    }
}
