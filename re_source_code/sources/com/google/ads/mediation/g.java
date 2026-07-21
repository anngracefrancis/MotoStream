package com.google.ads.mediation;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* JADX INFO: loaded from: classes2.dex */
final class g extends AdMetadataListener {
    private final /* synthetic */ AbstractAdViewAdapter a;

    g(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        if (this.a.zzmh == null || this.a.zzmi == null) {
            return;
        }
        this.a.zzmi.zzb(this.a.zzmh.getAdMetadata());
    }
}
