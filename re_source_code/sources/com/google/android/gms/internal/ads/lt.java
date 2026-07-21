package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

/* JADX INFO: loaded from: classes2.dex */
final class lt extends mt {
    lt(byte[] bArr, int i2) throws InvalidKeyException {
        super(bArr, i2);
    }

    @Override // com.google.android.gms.internal.ads.mt
    final int f() {
        return 12;
    }

    @Override // com.google.android.gms.internal.ads.mt
    final int[] g(int[] iArr, int i2) {
        if (iArr.length != 3) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
        }
        int[] iArr2 = new int[16];
        mt.e(iArr2, this.f12993b);
        iArr2[12] = i2;
        System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
        return iArr2;
    }
}
