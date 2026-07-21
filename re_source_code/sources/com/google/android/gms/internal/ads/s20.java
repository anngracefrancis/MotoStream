package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
final class s20 implements q20 {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MediaCodecInfo[] f13305b;

    public s20(boolean z) {
        this.a = z ? 1 : 0;
    }

    private final void e() {
        if (this.f13305b == null) {
            this.f13305b = new MediaCodecList(this.a).getCodecInfos();
        }
    }

    @Override // com.google.android.gms.internal.ads.q20
    public final MediaCodecInfo a(int i2) {
        e();
        return this.f13305b[i2];
    }

    @Override // com.google.android.gms.internal.ads.q20
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.q20
    public final int c() {
        e();
        return this.f13305b.length;
    }

    @Override // com.google.android.gms.internal.ads.q20
    public final boolean d(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }
}
