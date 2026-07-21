package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdjk implements zzdbj {
    private final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f15934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SecretKeySpec f15935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15936d;

    public zzdjk(byte[] bArr, int i2) throws GeneralSecurityException {
        if (i2 != 12 && i2 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.f15936d = i2;
        zzdlx.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f15935c = secretKeySpec;
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        cipher.init(1, secretKeySpec);
        byte[] bArrD = d(cipher.doFinal(new byte[16]));
        this.a = bArrD;
        this.f15934b = d(bArrD);
    }

    private final byte[] b(Cipher cipher, int i2, byte[] bArr, int i3, int i4) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArrC;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i2;
        if (i4 == 0) {
            return cipher.doFinal(c(bArr2, this.a));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i5 = 0;
        while (i4 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                bArrDoFinal[i6] = (byte) (bArrDoFinal[i6] ^ bArr[(i3 + i5) + i6]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i5 += 16;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i5 + i3, i3 + i4);
        if (bArrCopyOfRange.length == 16) {
            bArrC = c(bArrCopyOfRange, this.a);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(this.f15934b, 16);
            for (int i7 = 0; i7 < bArrCopyOfRange.length; i7++) {
                bArrCopyOf[i7] = (byte) (bArrCopyOf[i7] ^ bArrCopyOfRange[i7]);
            }
            bArrCopyOf[bArrCopyOfRange.length] = (byte) (bArrCopyOf[bArrCopyOfRange.length] ^ 128);
            bArrC = bArrCopyOf;
        }
        return cipher.doFinal(c(bArrDoFinal, bArrC));
    }

    private static byte[] c(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
        return bArr3;
    }

    private static byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & 255) >>> 7));
            i2 = i3;
        }
        bArr2[15] = (byte) ((bArr[15] << 1) ^ ((bArr[0] & 128) != 0 ? 135 : 0));
        return bArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzdbj
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.f15936d;
        if (length > (Integer.MAX_VALUE - i2) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + i2 + 16];
        byte[] bArrC = zzdlo.c(i2);
        System.arraycopy(bArrC, 0, bArr3, 0, this.f15936d);
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        cipher.init(1, this.f15935c);
        byte[] bArrB = b(cipher, 0, bArrC, 0, bArrC.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrB2 = b(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher2.init(1, this.f15935c, new IvParameterSpec(bArrB));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.f15936d);
        byte[] bArrB3 = b(cipher, 2, bArr3, this.f15936d, bArr.length);
        int length2 = bArr.length + this.f15936d;
        for (int i3 = 0; i3 < 16; i3++) {
            bArr3[length2 + i3] = (byte) ((bArrB2[i3] ^ bArrB[i3]) ^ bArrB3[i3]);
        }
        return bArr3;
    }
}
