package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgb {
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f16234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f16236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f16237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f16239g;

    public zzgb() {
        this.f16239g = zzkq.a >= 16 ? new MediaCodec.CryptoInfo() : null;
    }

    public final void a(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3) {
        this.f16238f = i2;
        this.f16236d = iArr;
        this.f16237e = iArr2;
        this.f16234b = bArr;
        this.a = bArr2;
        this.f16235c = 1;
        if (zzkq.a >= 16) {
            this.f16239g.set(i2, iArr, iArr2, bArr, bArr2, 1);
        }
    }

    @TargetApi(16)
    public final void b(MediaExtractor mediaExtractor) {
        mediaExtractor.getSampleCryptoInfo(this.f16239g);
        MediaCodec.CryptoInfo cryptoInfo = this.f16239g;
        this.f16238f = cryptoInfo.numSubSamples;
        this.f16236d = cryptoInfo.numBytesOfClearData;
        this.f16237e = cryptoInfo.numBytesOfEncryptedData;
        this.f16234b = cryptoInfo.key;
        this.a = cryptoInfo.iv;
        this.f16235c = cryptoInfo.mode;
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo c() {
        return this.f16239g;
    }
}
