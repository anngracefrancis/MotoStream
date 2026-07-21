package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzff {
    static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Charset f17407b = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f17408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ByteBuffer f17409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzeg f17410e;

    static {
        byte[] bArr = new byte[0];
        f17408c = bArr;
        f17409d = ByteBuffer.wrap(bArr);
        f17410e = zzeg.c(bArr, 0, bArr.length, false);
    }

    static int a(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    public static int b(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static int c(boolean z) {
        return z ? 1231 : 1237;
    }

    static <T> T d(T t) {
        t.getClass();
        return t;
    }

    static Object e(Object obj, Object obj2) {
        return ((zzgo) obj).e().X0((zzgo) obj2).x();
    }

    static <T> T f(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static boolean g(zzgo zzgoVar) {
        if (!(zzgoVar instanceof zzdm)) {
            return false;
        }
        return false;
    }

    public static boolean h(byte[] bArr) {
        return n4.f(bArr);
    }

    public static String i(byte[] bArr) {
        return new String(bArr, a);
    }

    public static int j(byte[] bArr) {
        int length = bArr.length;
        int iA = a(length, bArr, 0, length);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
