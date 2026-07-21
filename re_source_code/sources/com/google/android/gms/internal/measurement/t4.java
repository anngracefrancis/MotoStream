package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class t4 extends o4 {
    t4() {
    }

    private static int e(byte[] bArr, int i2, long j2, int i3) {
        if (i3 == 0) {
            return n4.h(i2);
        }
        if (i3 == 1) {
            return n4.i(i2, k4.a(bArr, j2));
        }
        if (i3 == 2) {
            return n4.j(i2, k4.a(bArr, j2), k4.a(bArr, j2 + 1));
        }
        throw new AssertionError();
    }

    @Override // com.google.android.gms.internal.measurement.o4
    final int a(int i2, byte[] bArr, int i3, int i4) {
        int i5;
        long j2;
        if ((i3 | i4 | (bArr.length - i4)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        long j3 = i3;
        int i6 = (int) (((long) i4) - j3);
        if (i6 >= 16) {
            long j4 = j3;
            i5 = 0;
            while (true) {
                if (i5 >= i6) {
                    i5 = i6;
                    break;
                }
                long j5 = j4 + 1;
                if (k4.a(bArr, j4) < 0) {
                    break;
                }
                i5++;
                j4 = j5;
            }
        } else {
            i5 = 0;
        }
        int i7 = i6 - i5;
        long j6 = j3 + ((long) i5);
        while (true) {
            byte bA = 0;
            while (i7 > 0) {
                long j7 = j6 + 1;
                bA = k4.a(bArr, j6);
                if (bA < 0) {
                    j6 = j7;
                    break;
                }
                i7--;
                j6 = j7;
            }
            if (i7 == 0) {
                return 0;
            }
            int i8 = i7 - 1;
            if (bA < -32) {
                if (i8 == 0) {
                    return bA;
                }
                i7 = i8 - 1;
                if (bA >= -62) {
                    j2 = j6 + 1;
                    if (k4.a(bArr, j6) > -65) {
                    }
                }
                return -1;
            }
            if (bA >= -16) {
                if (i8 < 3) {
                    return e(bArr, bA, j6, i8);
                }
                i7 = i8 - 3;
                long j8 = j6 + 1;
                byte bA2 = k4.a(bArr, j6);
                if (bA2 <= -65 && (((bA << 28) + (bA2 + 112)) >> 30) == 0) {
                    long j9 = j8 + 1;
                    if (k4.a(bArr, j8) <= -65) {
                        j2 = j9 + 1;
                        if (k4.a(bArr, j9) > -65) {
                        }
                    }
                }
                return -1;
            }
            if (i8 < 2) {
                return e(bArr, bA, j6, i8);
            }
            i7 = i8 - 2;
            long j10 = j6 + 1;
            byte bA3 = k4.a(bArr, j6);
            if (bA3 <= -65 && ((bA != -32 || bA3 >= -96) && (bA != -19 || bA3 < -96))) {
                j6 = j10 + 1;
                if (k4.a(bArr, j10) > -65) {
                }
            }
            return -1;
            j6 = j2;
        }
    }

    @Override // com.google.android.gms.internal.measurement.o4
    final int b(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        char c2;
        long j2;
        long j3;
        long j4;
        int i4;
        char cCharAt;
        long j5 = i2;
        long j6 = ((long) i3) + j5;
        int length = charSequence.length();
        if (length > i3 || bArr.length - i3 < i2) {
            char cCharAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(i2 + i3);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i5 = 0;
        while (true) {
            c2 = 128;
            j2 = 1;
            if (i5 >= length || (cCharAt = charSequence.charAt(i5)) >= 128) {
                break;
            }
            k4.l(bArr, j5, (byte) cCharAt);
            i5++;
            j5 = 1 + j5;
        }
        if (i5 == length) {
            return (int) j5;
        }
        while (i5 < length) {
            char cCharAt3 = charSequence.charAt(i5);
            if (cCharAt3 >= c2 || j5 >= j6) {
                if (cCharAt3 < 2048 && j5 <= j6 - 2) {
                    long j7 = j5 + j2;
                    k4.l(bArr, j5, (byte) ((cCharAt3 >>> 6) | 960));
                    k4.l(bArr, j7, (byte) ((cCharAt3 & '?') | 128));
                    j3 = j7 + j2;
                    j4 = j2;
                } else {
                    if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j5 > j6 - 3) {
                        if (j5 > j6 - 4) {
                            if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i4 = i5 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i4)))) {
                                throw new q4(i5, length);
                            }
                            StringBuilder sb2 = new StringBuilder(46);
                            sb2.append("Failed writing ");
                            sb2.append(cCharAt3);
                            sb2.append(" at index ");
                            sb2.append(j5);
                            throw new ArrayIndexOutOfBoundsException(sb2.toString());
                        }
                        int i6 = i5 + 1;
                        if (i6 != length) {
                            char cCharAt4 = charSequence.charAt(i6);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                long j8 = j5 + 1;
                                k4.l(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                                long j9 = j8 + 1;
                                k4.l(bArr, j8, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j10 = j9 + 1;
                                k4.l(bArr, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                j4 = 1;
                                j3 = j10 + 1;
                                k4.l(bArr, j10, (byte) ((codePoint & 63) | 128));
                                i5 = i6;
                            } else {
                                i5 = i6;
                            }
                        }
                        throw new q4(i5 - 1, length);
                    }
                    long j11 = j5 + j2;
                    k4.l(bArr, j5, (byte) ((cCharAt3 >>> '\f') | 480));
                    long j12 = j11 + j2;
                    k4.l(bArr, j11, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    k4.l(bArr, j12, (byte) ((cCharAt3 & '?') | 128));
                    j3 = j12 + 1;
                    j4 = 1;
                }
                i5++;
                c2 = 128;
                long j13 = j4;
                j5 = j3;
                j2 = j13;
            } else {
                long j14 = j5 + j2;
                k4.l(bArr, j5, (byte) cCharAt3);
                j4 = j2;
                j3 = j14;
            }
            i5++;
            c2 = 128;
            long j15 = j4;
            j5 = j3;
            j2 = j15;
        }
        return (int) j5;
    }

    @Override // com.google.android.gms.internal.measurement.o4
    final String d(byte[] bArr, int i2, int i3) throws zzfo {
        if ((i2 | i3 | ((bArr.length - i2) - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        int i4 = i2 + i3;
        char[] cArr = new char[i3];
        int i5 = 0;
        while (i2 < i4) {
            byte bA = k4.a(bArr, i2);
            if (!p4.l(bA)) {
                break;
            }
            i2++;
            p4.i(bA, cArr, i5);
            i5++;
        }
        int i6 = i5;
        while (i2 < i4) {
            int i7 = i2 + 1;
            byte bA2 = k4.a(bArr, i2);
            if (p4.l(bA2)) {
                int i8 = i6 + 1;
                p4.i(bA2, cArr, i6);
                while (i7 < i4) {
                    byte bA3 = k4.a(bArr, i7);
                    if (!p4.l(bA3)) {
                        break;
                    }
                    i7++;
                    p4.i(bA3, cArr, i8);
                    i8++;
                }
                i2 = i7;
                i6 = i8;
            } else if (p4.m(bA2)) {
                if (i7 >= i4) {
                    throw zzfo.h();
                }
                p4.h(bA2, k4.a(bArr, i7), cArr, i6);
                i2 = i7 + 1;
                i6++;
            } else if (p4.n(bA2)) {
                if (i7 >= i4 - 1) {
                    throw zzfo.h();
                }
                int i9 = i7 + 1;
                p4.g(bA2, k4.a(bArr, i7), k4.a(bArr, i9), cArr, i6);
                i2 = i9 + 1;
                i6++;
            } else {
                if (i7 >= i4 - 2) {
                    throw zzfo.h();
                }
                int i10 = i7 + 1;
                byte bA4 = k4.a(bArr, i7);
                int i11 = i10 + 1;
                p4.f(bA2, bA4, k4.a(bArr, i10), k4.a(bArr, i11), cArr, i6);
                i2 = i11 + 1;
                i6 = i6 + 1 + 1;
            }
        }
        return new String(cArr, 0, i6);
    }
}
