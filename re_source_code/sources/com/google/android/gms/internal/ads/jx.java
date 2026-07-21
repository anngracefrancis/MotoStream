package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class jx {
    private static final lx a;

    static {
        a = (!(gx.p() && gx.q()) || zt.a()) ? new mx() : new ox();
    }

    static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt >= 2048) {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char cCharAt2 = charSequence.charAt(i3);
                    if (cCharAt2 < 2048) {
                        i2 += (127 - cCharAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                throw new nx(i3, length2);
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i4 += i2;
                break;
            }
            i4 += (127 - cCharAt) >>> 31;
            i3++;
        }
        if (i4 >= length) {
            return i4;
        }
        long j2 = ((long) i4) + 4294967296L;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j2);
        throw new IllegalArgumentException(sb.toString());
    }

    static int b(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return a.b(charSequence, bArr, i2, i3);
    }

    static void c(CharSequence charSequence, ByteBuffer byteBuffer) {
        lx lxVar = a;
        if (byteBuffer.hasArray()) {
            int iArrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(b(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
        } else if (byteBuffer.isDirect()) {
            lxVar.c(charSequence, byteBuffer);
        } else {
            lx.d(charSequence, byteBuffer);
        }
    }

    public static boolean d(byte[] bArr) {
        return a.e(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    public static boolean k(byte[] bArr, int i2, int i3) {
        return a.e(bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 == 0) {
            return h(b2);
        }
        if (i4 == 1) {
            return e(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return g(b2, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    static String m(byte[] bArr, int i2, int i3) throws zzdok {
        return a.f(bArr, i2, i3);
    }
}
