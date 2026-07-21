package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzxy extends zzzq {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AdMetadataListener f16967f;

    public zzxy(AdMetadataListener adMetadataListener) {
        this.f16967f = adMetadataListener;
    }

    @Override // com.google.android.gms.internal.ads.zzzp
    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.f16967f;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
