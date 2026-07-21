package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzanq extends zzanb {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NativeAppInstallAdMapper f14013f;

    public zzanq(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.f14013f = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void A(IObjectWrapper iObjectWrapper) {
        this.f14013f.untrackView((View) ObjectWrapper.k0(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final boolean C() {
        return this.f14013f.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void C0(IObjectWrapper iObjectWrapper) {
        this.f14013f.trackView((View) ObjectWrapper.k0(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void D(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f14013f.trackViews((View) ObjectWrapper.k0(iObjectWrapper), (HashMap) ObjectWrapper.k0(iObjectWrapper2), (HashMap) ObjectWrapper.k0(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper I() {
        View viewZzacd = this.f14013f.zzacd();
        if (viewZzacd == null) {
            return null;
        }
        return ObjectWrapper.E0(viewZzacd);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper K() {
        View adChoicesContent = this.f14013f.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.E0(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final boolean M() {
        return this.f14013f.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void N(IObjectWrapper iObjectWrapper) {
        this.f14013f.handleClick((View) ObjectWrapper.k0(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaea f() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String g() {
        return this.f14013f.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final Bundle getExtras() {
        return this.f14013f.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getStore() {
        return this.f14013f.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaar getVideoController() {
        if (this.f14013f.getVideoController() != null) {
            return this.f14013f.getVideoController().zzdh();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String h() {
        return this.f14013f.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String i() {
        return this.f14013f.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper j() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final List k() {
        List<NativeAd.Image> images = this.f14013f.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzadw(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaei n() {
        NativeAd.Image icon = this.f14013f.getIcon();
        if (icon != null) {
            return new zzadw(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String o() {
        return this.f14013f.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void recordImpression() {
        this.f14013f.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final double t() {
        return this.f14013f.getStarRating();
    }
}
