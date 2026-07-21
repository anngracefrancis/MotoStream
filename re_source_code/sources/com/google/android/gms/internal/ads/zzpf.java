package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzpf extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f16577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f16578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f16579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f16580i;

    public zzpf(zzlh zzlhVar, Throwable th, boolean z, int i2) {
        String strValueOf = String.valueOf(zzlhVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
        sb.append("Decoder init failed: [");
        sb.append(i2);
        sb.append("], ");
        sb.append(strValueOf);
        super(sb.toString(), th);
        this.f16577f = zzlhVar.f16427k;
        this.f16578g = false;
        this.f16579h = null;
        String str = i2 < 0 ? "neg_" : HttpUrl.FRAGMENT_ENCODE_SET;
        int iAbs = Math.abs(i2);
        StringBuilder sb2 = new StringBuilder(str.length() + 64);
        sb2.append("com.google.android.exoplayer.MediaCodecTrackRenderer_");
        sb2.append(str);
        sb2.append(iAbs);
        this.f16580i = sb2.toString();
    }

    public zzpf(zzlh zzlhVar, Throwable th, boolean z, String str) {
        String strValueOf = String.valueOf(zzlhVar);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23 + strValueOf.length());
        sb.append("Decoder init failed: ");
        sb.append(str);
        sb.append(", ");
        sb.append(strValueOf);
        super(sb.toString(), th);
        this.f16577f = zzlhVar.f16427k;
        this.f16578g = false;
        this.f16579h = str;
        String diagnosticInfo = null;
        if (zzsy.a >= 21 && (th instanceof MediaCodec.CodecException)) {
            diagnosticInfo = ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.f16580i = diagnosticInfo;
    }
}
