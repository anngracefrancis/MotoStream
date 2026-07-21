package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* JADX INFO: loaded from: classes2.dex */
public final class zzmz {
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f16481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f16483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f16484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f16487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f16488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final k10 f16489j;

    public zzmz() {
        int i2 = zzsy.a;
        MediaCodec.CryptoInfo cryptoInfo = i2 >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.f16488i = cryptoInfo;
        this.f16489j = i2 >= 24 ? new k10(cryptoInfo) : null;
    }

    public final void a(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3) {
        this.f16485f = i2;
        this.f16483d = iArr;
        this.f16484e = iArr2;
        this.f16481b = bArr;
        this.a = bArr2;
        this.f16482c = i3;
        this.f16486g = 0;
        this.f16487h = 0;
        int i4 = zzsy.a;
        if (i4 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.f16488i;
            cryptoInfo.numSubSamples = i2;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = i3;
            if (i4 >= 24) {
                this.f16489j.a(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo b() {
        return this.f16488i;
    }
}
