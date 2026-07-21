package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: loaded from: classes2.dex */
abstract class nt implements zzdbj {
    private final mt a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final mt f13063b;

    public nt(byte[] bArr) throws InvalidKeyException {
        this.a = b(bArr, 1);
        this.f13063b = b(bArr, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzdbj
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > (Integer.MAX_VALUE - this.a.f()) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + this.a.f() + 16);
        if (byteBufferAllocate.remaining() < bArr.length + this.a.f() + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int iPosition = byteBufferAllocate.position();
        this.a.c(byteBufferAllocate, bArr);
        byteBufferAllocate.position(iPosition);
        byte[] bArr3 = new byte[this.a.f()];
        byteBufferAllocate.get(bArr3);
        byteBufferAllocate.limit(byteBufferAllocate.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr4 = new byte[32];
        this.f13063b.h(bArr3, 0).get(bArr4);
        int length = bArr2.length % 16 == 0 ? bArr2.length : (bArr2.length + 16) - (bArr2.length % 16);
        int iRemaining = byteBufferAllocate.remaining();
        int i2 = iRemaining % 16;
        int i3 = (i2 == 0 ? iRemaining : (iRemaining + 16) - i2) + length;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i3 + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(bArr2);
        byteBufferOrder.position(length);
        byteBufferOrder.put(byteBufferAllocate);
        byteBufferOrder.position(i3);
        byteBufferOrder.putLong(bArr2.length);
        byteBufferOrder.putLong(iRemaining);
        byte[] bArrC = pt.c(bArr4, byteBufferOrder.array());
        byteBufferAllocate.limit(byteBufferAllocate.limit() + 16);
        byteBufferAllocate.put(bArrC);
        return byteBufferAllocate.array();
    }

    abstract mt b(byte[] bArr, int i2) throws InvalidKeyException;
}
