package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
final class iz implements gz {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MediaCodecInfo[] f12787b;

    public iz(boolean z) {
        this.a = z ? 1 : 0;
    }

    private final void e() {
        if (this.f12787b == null) {
            this.f12787b = new MediaCodecList(this.a).getCodecInfos();
        }
    }

    @Override // com.google.android.gms.internal.ads.gz
    public final MediaCodecInfo a(int i2) {
        e();
        return this.f12787b[i2];
    }

    @Override // com.google.android.gms.internal.ads.gz
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.gz
    public final int c() {
        e();
        return this.f12787b.length;
    }

    @Override // com.google.android.gms.internal.ads.gz
    public final boolean d(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }
}
