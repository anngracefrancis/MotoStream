package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdjm implements zzdbj {
    private final SecretKey a;

    public zzdjm(byte[] bArr) throws GeneralSecurityException {
        zzdlx.a(bArr.length);
        this.a = new SecretKeySpec(bArr, "AES");
    }

    private static AlgorithmParameterSpec b(byte[] bArr, int i2, int i3) throws GeneralSecurityException {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, 0, i3);
        } catch (ClassNotFoundException unused) {
            if (zzdlv.a()) {
                return new IvParameterSpec(bArr, 0, i3);
            }
            throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbj
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 12 + 16];
        byte[] bArrC = zzdlo.c(12);
        System.arraycopy(bArrC, 0, bArr3, 0, 12);
        Cipher cipherB = zzdkx.f15960c.b("AES/GCM/NoPadding");
        cipherB.init(1, this.a, b(bArrC, 0, bArrC.length));
        if (bArr2 != null && bArr2.length != 0) {
            cipherB.updateAAD(bArr2);
        }
        int iDoFinal = cipherB.doFinal(bArr, 0, bArr.length, bArr3, 12);
        if (iDoFinal == bArr.length + 16) {
            return bArr3;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(iDoFinal - bArr.length)));
    }
}
