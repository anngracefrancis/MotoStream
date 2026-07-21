package com.flurry.sdk;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes2.dex */
public final class d6 extends MessageDigest {
    private CRC32 a;

    public d6() {
        super("CRC");
        this.a = new CRC32();
    }

    public final int a() {
        return ByteBuffer.wrap(engineDigest()).getInt();
    }

    @Override // java.security.MessageDigestSpi
    protected final byte[] engineDigest() {
        long value = this.a.getValue();
        return new byte[]{(byte) (((-16777216) & value) >> 24), (byte) ((16711680 & value) >> 16), (byte) ((65280 & value) >> 8), (byte) ((value & 255) >> 0)};
    }

    @Override // java.security.MessageDigestSpi
    protected final void engineReset() {
        this.a.reset();
    }

    @Override // java.security.MessageDigestSpi
    protected final void engineUpdate(byte b2) {
        this.a.update(b2);
    }

    @Override // java.security.MessageDigestSpi
    protected final void engineUpdate(byte[] bArr, int i2, int i3) {
        this.a.update(bArr, i2, i3);
    }
}
