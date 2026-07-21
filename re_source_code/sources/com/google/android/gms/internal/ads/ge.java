package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ge implements zzbtu {
    static final zzbtu a = new ge();

    private ge() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtu
    public final void a(Object obj) {
        ((AdMetadataListener) obj).onAdMetadataChanged();
    }
}
