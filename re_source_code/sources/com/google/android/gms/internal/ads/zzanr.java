package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzanr extends zzane {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NativeContentAdMapper f14014f;

    public zzanr(NativeContentAdMapper nativeContentAdMapper) {
        this.f14014f = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void A(IObjectWrapper iObjectWrapper) {
        this.f14014f.untrackView((View) ObjectWrapper.k0(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean C() {
        return this.f14014f.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void C0(IObjectWrapper iObjectWrapper) {
        this.f14014f.trackView((View) ObjectWrapper.k0(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void D(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f14014f.trackViews((View) ObjectWrapper.k0(iObjectWrapper), (HashMap) ObjectWrapper.k0(iObjectWrapper2), (HashMap) ObjectWrapper.k0(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaei D0() {
        NativeAd.Image logo = this.f14014f.getLogo();
        if (logo != null) {
            return new zzadw(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper I() {
        View viewZzacd = this.f14014f.zzacd();
        if (viewZzacd == null) {
            return null;
        }
        return ObjectWrapper.E0(viewZzacd);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper K() {
        View adChoicesContent = this.f14014f.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.E0(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean M() {
        return this.f14014f.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void N(IObjectWrapper iObjectWrapper) {
        this.f14014f.handleClick((View) ObjectWrapper.k0(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaea f() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String g() {
        return this.f14014f.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final Bundle getExtras() {
        return this.f14014f.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaar getVideoController() {
        if (this.f14014f.getVideoController() != null) {
            return this.f14014f.getVideoController().zzdh();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String h() {
        return this.f14014f.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String i() {
        return this.f14014f.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper j() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final List k() {
        List<NativeAd.Image> images = this.f14014f.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzadw(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void recordImpression() {
        this.f14014f.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String w() {
        return this.f14014f.getAdvertiser();
    }
}
