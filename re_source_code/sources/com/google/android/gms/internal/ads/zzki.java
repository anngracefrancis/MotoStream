package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public final class zzki {
    private static final byte[] a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f16392b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f16393c = {0, 1, 2, 3, 4, 5, 6, 8};

    public static byte[] a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = a;
        byte[] bArr3 = new byte[bArr2.length + i3];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, bArr2.length, i3);
        return bArr3;
    }

    public static Pair<Integer, Integer> b(byte[] bArr) {
        int i2 = (bArr[0] >> 3) & 31;
        int i3 = (i2 == 5 || i2 == 29) ? 1 : 0;
        int i4 = (bArr[i3] & 7) << 1;
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i5] >> 7) & 1);
        zzkh.d(i6 < 13);
        return Pair.create(Integer.valueOf(f16392b[i6]), Integer.valueOf((bArr[i5] >> 3) & 15));
    }
}
