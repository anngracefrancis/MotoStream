package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: loaded from: classes2.dex */
final class hz implements gz {
    private hz() {
    }

    @Override // com.google.android.gms.internal.ads.gz
    public final MediaCodecInfo a(int i2) {
        return MediaCodecList.getCodecInfoAt(i2);
    }

    @Override // com.google.android.gms.internal.ads.gz
    public final boolean b() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.gz
    public final int c() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.gz
    public final boolean d(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
