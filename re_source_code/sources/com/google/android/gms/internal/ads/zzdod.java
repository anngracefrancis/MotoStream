package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdod {
    static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Charset f16032b = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f16033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ByteBuffer f16034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzdnd f16035e;

    static {
        byte[] bArr = new byte[0];
        f16033c = bArr;
        f16034d = ByteBuffer.wrap(bArr);
        f16035e = zzdnd.v(bArr, 0, bArr.length, false);
    }

    static <T> T a(T t) {
        t.getClass();
        return t;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        int iC = c(length, bArr, 0, length);
        if (iC == 0) {
            return 1;
        }
        return iC;
    }

    static int c(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    static <T> T d(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean e(byte[] bArr) {
        return jx.d(bArr);
    }

    public static String f(byte[] bArr) {
        return new String(bArr, a);
    }

    static Object g(Object obj, Object obj2) {
        return ((zzdpk) obj).b().M0((zzdpk) obj2).a1();
    }

    public static int h(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int i(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    static boolean j(zzdpk zzdpkVar) {
        return false;
    }
}
