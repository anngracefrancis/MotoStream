package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class n4 {
    private static final o4 a;

    static {
        a = (!(k4.m() && k4.r()) || k1.b()) ? new r4() : new t4();
    }

    static int d(CharSequence charSequence) {
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
                                throw new q4(i3, length2);
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

    static int e(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return a.b(charSequence, bArr, i2, i3);
    }

    public static boolean f(byte[] bArr) {
        return a.c(bArr, 0, bArr.length);
    }

    public static boolean g(byte[] bArr, int i2, int i3) {
        return a.c(bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    static String k(byte[] bArr, int i2, int i3) throws zzfo {
        return a.d(bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 == 0) {
            return h(b2);
        }
        if (i4 == 1) {
            return i(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return j(b2, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }
}
