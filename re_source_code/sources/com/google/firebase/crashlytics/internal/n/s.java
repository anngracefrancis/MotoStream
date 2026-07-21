package com.google.firebase.crashlytics.internal.n;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: CLSUUID.java */
/* JADX INFO: loaded from: classes2.dex */
class s {
    private static final AtomicLong a = new AtomicLong(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f19077b;

    s(i0 i0Var) {
        byte[] bArr = new byte[10];
        e(bArr);
        d(bArr);
        c(bArr);
        String strZ = t.z(i0Var.a().c());
        String strT = t.t(bArr);
        Locale locale = Locale.US;
        f19077b = String.format(locale, "%s%s%s%s", strT.substring(0, 12), strT.substring(12, 16), strT.subSequence(16, 20), strZ.substring(0, 12)).toUpperCase(locale);
    }

    private static byte[] a(long j2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt((int) j2);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.position(0);
        return byteBufferAllocate.array();
    }

    private static byte[] b(long j2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2);
        byteBufferAllocate.putShort((short) j2);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.position(0);
        return byteBufferAllocate.array();
    }

    private void c(byte[] bArr) {
        byte[] bArrB = b(Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = bArrB[0];
        bArr[9] = bArrB[1];
    }

    private void d(byte[] bArr) {
        byte[] bArrB = b(a.incrementAndGet());
        bArr[6] = bArrB[0];
        bArr[7] = bArrB[1];
    }

    private void e(byte[] bArr) {
        long time = new Date().getTime();
        byte[] bArrA = a(time / 1000);
        bArr[0] = bArrA[0];
        bArr[1] = bArrA[1];
        bArr[2] = bArrA[2];
        bArr[3] = bArrA[3];
        byte[] bArrB = b(time % 1000);
        bArr[4] = bArrB[0];
        bArr[5] = bArrB[1];
    }

    public String toString() {
        return f19077b;
    }
}
