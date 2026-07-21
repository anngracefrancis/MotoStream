package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(24)
final class k10 {
    private final MediaCodec.CryptoInfo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaCodec.CryptoInfo.Pattern f12849b;

    private k10(MediaCodec.CryptoInfo cryptoInfo) {
        this.a = cryptoInfo;
        this.f12849b = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i2, int i3) {
        this.f12849b.set(i2, i3);
        this.a.setPattern(this.f12849b);
    }
}
