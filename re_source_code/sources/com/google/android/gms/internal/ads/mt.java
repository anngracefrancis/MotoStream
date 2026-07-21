package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: loaded from: classes2.dex */
abstract class mt implements zzdlk {
    private static final int[] a = j(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f12993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12994c;

    mt(byte[] bArr, int i2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f12993b = j(bArr);
        this.f12994c = i2;
    }

    private static int b(int i2, int i3) {
        return (i2 >>> (-i3)) | (i2 << i3);
    }

    private static void d(int[] iArr, int i2, int i3, int i4, int i5) {
        iArr[i2] = iArr[i2] + iArr[i3];
        iArr[i5] = b(iArr[i5] ^ iArr[i2], 16);
        iArr[i4] = iArr[i4] + iArr[i5];
        iArr[i3] = b(iArr[i3] ^ iArr[i4], 12);
        iArr[i2] = iArr[i2] + iArr[i3];
        iArr[i5] = b(iArr[i2] ^ iArr[i5], 8);
        iArr[i4] = iArr[i4] + iArr[i5];
        iArr[i3] = b(iArr[i3] ^ iArr[i4], 7);
    }

    static void e(int[] iArr, int[] iArr2) {
        int[] iArr3 = a;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    static void i(int[] iArr) {
        for (int i2 = 0; i2 < 10; i2++) {
            d(iArr, 0, 4, 8, 12);
            d(iArr, 1, 5, 9, 13);
            d(iArr, 2, 6, 10, 14);
            d(iArr, 3, 7, 11, 15);
            d(iArr, 0, 5, 10, 15);
            d(iArr, 1, 6, 11, 12);
            d(iArr, 2, 7, 8, 13);
            d(iArr, 3, 4, 9, 14);
        }
    }

    private static int[] j(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > Integer.MAX_VALUE - f()) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(f() + bArr.length);
        c(byteBufferAllocate, bArr);
        return byteBufferAllocate.array();
    }

    final void c(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - f() < bArr.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        byte[] bArrC = zzdlo.c(f());
        byteBuffer.put(bArrC);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        int iRemaining = byteBufferWrap.remaining();
        int i2 = (iRemaining / 64) + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer byteBufferH = h(bArrC, this.f12994c + i3);
            if (i3 == i2 - 1) {
                zzdjs.a(byteBuffer, byteBufferWrap, byteBufferH, iRemaining % 64);
            } else {
                zzdjs.a(byteBuffer, byteBufferWrap, byteBufferH, 64);
            }
        }
    }

    abstract int f();

    abstract int[] g(int[] iArr, int i2);

    final ByteBuffer h(byte[] bArr, int i2) {
        int[] iArrG = g(j(bArr), i2);
        int[] iArr = (int[]) iArrG.clone();
        i(iArr);
        for (int i3 = 0; i3 < iArrG.length; i3++) {
            iArrG[i3] = iArrG[i3] + iArr[i3];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrG, 0, 16);
        return byteBufferOrder;
    }
}
