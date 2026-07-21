package com.google.firebase.installations;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* JADX INFO: compiled from: RandomFidGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static final byte a = Byte.parseByte("01110000", 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte f19694b = Byte.parseByte("00001111", 2);

    private static String b(byte[] bArr) {
        return new String(Base64.encode(bArr, 11), Charset.defaultCharset()).substring(0, 22);
    }

    private static byte[] c(UUID uuid, byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.putLong(uuid.getMostSignificantBits());
        byteBufferWrap.putLong(uuid.getLeastSignificantBits());
        return byteBufferWrap.array();
    }

    public String a() {
        byte[] bArrC = c(UUID.randomUUID(), new byte[17]);
        bArrC[16] = bArrC[0];
        bArrC[0] = (byte) ((f19694b & bArrC[0]) | a);
        return b(bArrC);
    }
}
