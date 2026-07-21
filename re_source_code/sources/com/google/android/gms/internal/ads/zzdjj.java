package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdjj implements zzdlk {
    private final SecretKeySpec a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15933c;

    public zzdjj(byte[] bArr, int i2) throws GeneralSecurityException {
        zzdlx.a(bArr.length);
        this.a = new SecretKeySpec(bArr, "AES");
        int blockSize = zzdkx.f15960c.b("AES/CTR/NoPadding").getBlockSize();
        this.f15933c = blockSize;
        if (i2 < 12 || i2 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f15932b = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.f15932b;
        if (length > Integer.MAX_VALUE - i2) {
            int i3 = Integer.MAX_VALUE - this.f15932b;
            StringBuilder sb = new StringBuilder(43);
            sb.append("plaintext length can not exceed ");
            sb.append(i3);
            throw new GeneralSecurityException(sb.toString());
        }
        byte[] bArr2 = new byte[bArr.length + i2];
        byte[] bArrC = zzdlo.c(i2);
        System.arraycopy(bArrC, 0, bArr2, 0, this.f15932b);
        int length2 = bArr.length;
        int i4 = this.f15932b;
        Cipher cipherB = zzdkx.f15960c.b("AES/CTR/NoPadding");
        byte[] bArr3 = new byte[this.f15933c];
        System.arraycopy(bArrC, 0, bArr3, 0, this.f15932b);
        cipherB.init(1, this.a, new IvParameterSpec(bArr3));
        if (cipherB.doFinal(bArr, 0, length2, bArr2, i4) == length2) {
            return bArr2;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
