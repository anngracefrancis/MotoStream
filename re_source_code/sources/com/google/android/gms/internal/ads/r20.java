package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: loaded from: classes2.dex */
final class r20 implements q20 {
    private r20() {
    }

    @Override // com.google.android.gms.internal.ads.q20
    public final MediaCodecInfo a(int i2) {
        return MediaCodecList.getCodecInfoAt(i2);
    }

    @Override // com.google.android.gms.internal.ads.q20
    public final boolean b() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.q20
    public final int c() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.q20
    public final boolean d(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
