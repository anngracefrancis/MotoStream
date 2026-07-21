package com.google.zxing.j.b;

import com.google.zxing.WriterException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: PDF417HighLevelEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f20420c;
    private static final byte[] a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f20419b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f20421d = new byte[128];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Charset f20422e = StandardCharsets.ISO_8859_1;

    /* JADX INFO: compiled from: PDF417HighLevelEncoder.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        byte[] bArr = new byte[128];
        f20420c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr2 = a;
            if (i3 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i3];
            if (b2 > 0) {
                f20420c[b2] = (byte) i3;
            }
            i3++;
        }
        Arrays.fill(f20421d, (byte) -1);
        while (true) {
            byte[] bArr3 = f20419b;
            if (i2 >= bArr3.length) {
                return;
            }
            byte b3 = bArr3[i2];
            if (b3 > 0) {
                f20421d[b3] = (byte) i2;
            }
            i2++;
        }
    }

    private static int a(String str, int i2, Charset charset) throws WriterException {
        int i3;
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        int length = str.length();
        int i4 = i2;
        while (i4 < length) {
            char cCharAt = str.charAt(i4);
            int i5 = 0;
            while (i5 < 13 && k(cCharAt) && (i3 = i4 + (i5 = i5 + 1)) < length) {
                cCharAt = str.charAt(i3);
            }
            if (i5 >= 13) {
                return i4 - i2;
            }
            char cCharAt2 = str.charAt(i4);
            if (!charsetEncoderNewEncoder.canEncode(cCharAt2)) {
                throw new WriterException("Non-encodable character detected: " + cCharAt2 + " (Unicode: " + ((int) cCharAt2) + ')');
            }
            i4++;
        }
        return i4 - i2;
    }

    private static int b(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        if (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            while (k(cCharAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    cCharAt = charSequence.charAt(i2);
                }
            }
        }
        return i3;
    }

    private static int c(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = i2;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            int i4 = 0;
            while (i4 < 13 && k(cCharAt) && i3 < length) {
                i4++;
                i3++;
                if (i3 < length) {
                    cCharAt = charSequence.charAt(i3);
                }
            }
            if (i4 < 13) {
                if (i4 <= 0) {
                    if (!n(charSequence.charAt(i3))) {
                        break;
                    }
                    i3++;
                }
            } else {
                return (i3 - i2) - i4;
            }
        }
        return i3 - i2;
    }

    private static void d(byte[] bArr, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        if (i3 == 1 && i4 == 0) {
            sb.append((char) 913);
        } else if (i3 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i3 >= 6) {
            char[] cArr = new char[5];
            i5 = i2;
            while ((i2 + i3) - i5 >= 6) {
                long j2 = 0;
                for (int i6 = 0; i6 < 6; i6++) {
                    j2 = (j2 << 8) + ((long) (bArr[i5 + i6] & 255));
                }
                for (int i7 = 0; i7 < 5; i7++) {
                    cArr[i7] = (char) (j2 % 900);
                    j2 /= 900;
                }
                for (int i8 = 4; i8 >= 0; i8--) {
                    sb.append(cArr[i8]);
                }
                i5 += 6;
            }
        } else {
            i5 = i2;
        }
        while (i5 < i2 + i3) {
            sb.append((char) (bArr[i5] & 255));
            i5++;
        }
    }

    static String e(String str, c cVar, Charset charset) throws WriterException {
        com.google.zxing.g.c cVarG;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = f20422e;
        } else if (!f20422e.equals(charset) && (cVarG = com.google.zxing.g.c.g(charset.name())) != null) {
            h(cVarG.k(), sb);
        }
        int length = str.length();
        int i2 = a.a[cVar.ordinal()];
        if (i2 == 1) {
            g(str, 0, length, sb, 0);
        } else if (i2 == 2) {
            byte[] bytes = str.getBytes(charset);
            d(bytes, 0, bytes.length, 1, sb);
        } else if (i2 != 3) {
            int i3 = 0;
            int iG = 0;
            int i4 = 0;
            while (i3 < length) {
                int iB = b(str, i3);
                if (iB >= 13) {
                    sb.append((char) 902);
                    f(str, i3, iB, sb);
                    i3 += iB;
                    iG = 0;
                    i4 = 2;
                } else {
                    int iC = c(str, i3);
                    if (iC >= 5 || iB == length) {
                        if (i4 != 0) {
                            sb.append((char) 900);
                            iG = 0;
                            i4 = 0;
                        }
                        iG = g(str, i3, iC, sb, iG);
                        i3 += iC;
                    } else {
                        int iA = a(str, i3, charset);
                        if (iA == 0) {
                            iA = 1;
                        }
                        int i5 = iA + i3;
                        byte[] bytes2 = str.substring(i3, i5).getBytes(charset);
                        if (bytes2.length == 1 && i4 == 0) {
                            d(bytes2, 0, 1, 0, sb);
                        } else {
                            d(bytes2, 0, bytes2.length, i4, sb);
                            iG = 0;
                            i4 = 1;
                        }
                        i3 = i5;
                    }
                }
            }
        } else {
            sb.append((char) 902);
            f(str, 0, length, sb);
        }
        return sb.toString();
    }

    private static void f(String str, int i2, int i3, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i3 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i4 = 0;
        while (i4 < i3) {
            sb2.setLength(0);
            int iMin = Math.min(44, i3 - i4);
            StringBuilder sb3 = new StringBuilder("1");
            int i5 = i2 + i4;
            sb3.append(str.substring(i5, i5 + iMin));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i4 += iMin;
        }
    }

    /* JADX WARN: Code duplicated, block: B:76:0x00f6 A[EDGE_INSN: B:76:0x00f6->B:55:0x00f6 BREAK  A[LOOP:0: B:3:0x0011->B:93:0x0011], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0011 A[SYNTHETIC] */
    private static int g(CharSequence charSequence, int i2, int i3, StringBuilder sb, int i4) {
        StringBuilder sb2 = new StringBuilder(i3);
        int i5 = i4;
        int i6 = 0;
        while (true) {
            int i7 = i2 + i6;
            char cCharAt = charSequence.charAt(i7);
            if (i5 == 0) {
                if (j(cCharAt)) {
                    if (cCharAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (cCharAt - 'A'));
                    }
                } else if (i(cCharAt)) {
                    sb2.append((char) 27);
                    i5 = 1;
                } else if (l(cCharAt)) {
                    sb2.append((char) 28);
                    i5 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) f20421d[cCharAt]);
                }
                i6++;
                if (i6 >= i3) {
                    break;
                    break;
                }
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (m(cCharAt)) {
                            sb2.append((char) f20421d[cCharAt]);
                        } else {
                            sb2.append((char) 29);
                            i5 = 0;
                        }
                    } else if (l(cCharAt)) {
                        sb2.append((char) f20420c[cCharAt]);
                    } else if (j(cCharAt)) {
                        sb2.append((char) 28);
                        i5 = 0;
                    } else if (i(cCharAt)) {
                        sb2.append((char) 27);
                        i5 = 1;
                    } else {
                        int i8 = i7 + 1;
                        if (i8 >= i3 || !m(charSequence.charAt(i8))) {
                            sb2.append((char) 29);
                            sb2.append((char) f20421d[cCharAt]);
                        } else {
                            i5 = 3;
                            sb2.append((char) 25);
                        }
                    }
                } else if (i(cCharAt)) {
                    if (cCharAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (cCharAt - 'a'));
                    }
                } else if (j(cCharAt)) {
                    sb2.append((char) 27);
                    sb2.append((char) (cCharAt - 'A'));
                } else if (l(cCharAt)) {
                    sb2.append((char) 28);
                    i5 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) f20421d[cCharAt]);
                }
                i6++;
                if (i6 >= i3) {
                    break;
                }
            }
        }
        int length = sb2.length();
        char cCharAt2 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            if (i9 % 2 != 0) {
                cCharAt2 = (char) ((cCharAt2 * 30) + sb2.charAt(i9));
                sb.append(cCharAt2);
            } else {
                cCharAt2 = sb2.charAt(i9);
            }
        }
        if (length % 2 != 0) {
            sb.append((char) ((cCharAt2 * 30) + 29));
        }
        return i5;
    }

    private static void h(int i2, StringBuilder sb) throws WriterException {
        if (i2 >= 0 && i2 < 900) {
            sb.append((char) 927);
            sb.append((char) i2);
        } else if (i2 < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i2 / 900) - 1));
            sb.append((char) (i2 % 900));
        } else {
            if (i2 >= 811800) {
                throw new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i2)));
            }
            sb.append((char) 925);
            sb.append((char) (810900 - i2));
        }
    }

    private static boolean i(char c2) {
        if (c2 != ' ') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    private static boolean j(char c2) {
        if (c2 != ' ') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean k(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean l(char c2) {
        return f20420c[c2] != -1;
    }

    private static boolean m(char c2) {
        return f20421d[c2] != -1;
    }

    private static boolean n(char c2) {
        if (c2 == '\t' || c2 == '\n' || c2 == '\r') {
            return true;
        }
        return c2 >= ' ' && c2 <= '~';
    }
}
