package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdjh implements zzdby {
    private final SecretKey a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f15930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f15931d;

    private static Cipher b() throws GeneralSecurityException {
        return zzdkx.f15960c.b("AES/ECB/NoPadding");
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        byte[] bArrD;
        Cipher cipherB = b();
        cipherB.init(1, this.a);
        double length = bArr.length;
        Double.isNaN(length);
        int iMax = Math.max(1, (int) Math.ceil(length / 16.0d));
        if ((iMax << 4) == bArr.length) {
            bArrD = zzdjs.b(bArr, (iMax - 1) << 4, this.f15930c, 0, 16);
        } else {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, (iMax - 1) << 4, bArr.length);
            if (bArrCopyOfRange.length >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, 16);
            bArrCopyOf[bArrCopyOfRange.length] = -128;
            bArrD = zzdjs.d(bArrCopyOf, this.f15931d);
        }
        byte[] bArrDoFinal = new byte[16];
        for (int i2 = 0; i2 < iMax - 1; i2++) {
            bArrDoFinal = cipherB.doFinal(zzdjs.b(bArrDoFinal, 0, bArr, i2 << 4, 16));
        }
        byte[] bArrD2 = zzdjs.d(bArrD, bArrDoFinal);
        byte[] bArr2 = new byte[this.f15929b];
        System.arraycopy(cipherB.doFinal(bArrD2), 0, bArr2, 0, this.f15929b);
        return bArr2;
    }
}
