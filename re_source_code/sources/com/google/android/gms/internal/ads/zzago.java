package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzago extends zzafp {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NativeCustomTemplateAd.OnCustomClickListener f13883f;

    public zzago(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.f13883f = onCustomClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void F0(zzafe zzafeVar, String str) {
        this.f13883f.onCustomClick(zzafh.a(zzafeVar), str);
    }
}
