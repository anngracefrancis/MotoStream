package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: Utf8.java */
/* JADX INFO: loaded from: classes.dex */
final class q1 {
    private static final b a;

    /* JADX INFO: compiled from: Utf8.java */
    private static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void h(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (m(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || m(b4) || m(b5)) {
                throw InvalidProtocolBufferException.c();
            }
            int iR = ((b2 & 7) << 18) | (r(b3) << 12) | (r(b4) << 6) | r(b5);
            cArr[i2] = l(iR);
            cArr[i2 + 1] = q(iR);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void i(byte b2, char[] cArr, int i2) {
            cArr[i2] = (char) b2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(byte b2, byte b3, byte b4, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (m(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || m(b4)))) {
                throw InvalidProtocolBufferException.c();
            }
            cArr[i2] = (char) (((b2 & 15) << 12) | (r(b3) << 6) | r(b4));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k(byte b2, byte b3, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (b2 < -62 || m(b3)) {
                throw InvalidProtocolBufferException.c();
            }
            cArr[i2] = (char) (((b2 & 31) << 6) | r(b3));
        }

        private static char l(int i2) {
            return (char) ((i2 >>> 10) + 55232);
        }

        private static boolean m(byte b2) {
            return b2 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n(byte b2) {
            return b2 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean o(byte b2) {
            return b2 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean p(byte b2) {
            return b2 < -32;
        }

        private static char q(int i2) {
            return (char) ((i2 & 1023) + 56320);
        }

        private static int r(byte b2) {
            return b2 & 63;
        }
    }

    /* JADX INFO: compiled from: Utf8.java */
    static abstract class b {
        b() {
        }

        abstract String a(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException;

        abstract int b(CharSequence charSequence, byte[] bArr, int i2, int i3);

        final boolean c(byte[] bArr, int i2, int i3) {
            return d(0, bArr, i2, i3) == 0;
        }

        abstract int d(int i2, byte[] bArr, int i3, int i4);
    }

    /* JADX INFO: compiled from: Utf8.java */
    static final class c extends b {
        c() {
        }

        private static int e(byte[] bArr, int i2, int i3) {
            while (i2 < i3 && bArr[i2] >= 0) {
                i2++;
            }
            if (i2 >= i3) {
                return 0;
            }
            return f(bArr, i2, i3);
        }

        private static int f(byte[] bArr, int i2, int i3) {
            while (i2 < i3) {
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 < 0) {
                    if (b2 < -32) {
                        if (i4 >= i3) {
                            return b2;
                        }
                        if (b2 >= -62) {
                            i2 = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b2 >= -16) {
                        if (i4 >= i3 - 2) {
                            return q1.l(bArr, i4, i3);
                        }
                        int i5 = i4 + 1;
                        byte b3 = bArr[i4];
                        if (b3 <= -65 && (((b2 << 28) + (b3 + 112)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (bArr[i5] <= -65) {
                                i4 = i6 + 1;
                                if (bArr[i6] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i4 >= i3 - 1) {
                        return q1.l(bArr, i4, i3);
                    }
                    int i7 = i4 + 1;
                    byte b4 = bArr[i4];
                    if (b4 <= -65 && ((b2 != -32 || b4 >= -96) && (b2 != -19 || b4 < -96))) {
                        i2 = i7 + 1;
                        if (bArr[i7] > -65) {
                        }
                    }
                    return -1;
                }
                i2 = i4;
            }
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.q1.b
        String a(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
            if ((i2 | i3 | ((bArr.length - i2) - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i2 < i4) {
                byte b2 = bArr[i2];
                if (!a.n(b2)) {
                    break;
                }
                i2++;
                a.i(b2, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i2 < i4) {
                int i7 = i2 + 1;
                byte b3 = bArr[i2];
                if (a.n(b3)) {
                    int i8 = i6 + 1;
                    a.i(b3, cArr, i6);
                    while (i7 < i4) {
                        byte b4 = bArr[i7];
                        if (!a.n(b4)) {
                            break;
                        }
                        i7++;
                        a.i(b4, cArr, i8);
                        i8++;
                    }
                    i2 = i7;
                    i6 = i8;
                } else if (a.p(b3)) {
                    if (i7 >= i4) {
                        throw InvalidProtocolBufferException.c();
                    }
                    a.k(b3, bArr[i7], cArr, i6);
                    i2 = i7 + 1;
                    i6++;
                } else if (a.o(b3)) {
                    if (i7 >= i4 - 1) {
                        throw InvalidProtocolBufferException.c();
                    }
                    int i9 = i7 + 1;
                    a.j(b3, bArr[i7], bArr[i9], cArr, i6);
                    i2 = i9 + 1;
                    i6++;
                } else {
                    if (i7 >= i4 - 2) {
                        throw InvalidProtocolBufferException.c();
                    }
                    int i10 = i7 + 1;
                    byte b5 = bArr[i7];
                    int i11 = i10 + 1;
                    a.h(b3, b5, bArr[i10], bArr[i11], cArr, i6);
                    i2 = i11 + 1;
                    i6 = i6 + 1 + 1;
                }
            }
            return new String(cArr, 0, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.q1.b
        int b(CharSequence charSequence, byte[] bArr, int i2, int i3) {
            int i4;
            int i5;
            int i6;
            char cCharAt;
            int length = charSequence.length();
            int i7 = i3 + i2;
            int i8 = 0;
            while (i8 < length && (i6 = i8 + i2) < i7 && (cCharAt = charSequence.charAt(i8)) < 128) {
                bArr[i6] = (byte) cCharAt;
                i8++;
            }
            if (i8 == length) {
                return i2 + length;
            }
            int i9 = i2 + i8;
            while (i8 < length) {
                char cCharAt2 = charSequence.charAt(i8);
                if (cCharAt2 >= 128 || i9 >= i7) {
                    if (cCharAt2 < 2048 && i9 <= i7 - 2) {
                        int i10 = i9 + 1;
                        bArr[i9] = (byte) ((cCharAt2 >>> 6) | 960);
                        i9 = i10 + 1;
                        bArr[i10] = (byte) ((cCharAt2 & '?') | 128);
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i9 > i7 - 3) {
                            if (i9 > i7 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i5 = i8 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i5)))) {
                                    throw new d(i8, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i9);
                            }
                            int i11 = i8 + 1;
                            if (i11 != charSequence.length()) {
                                char cCharAt3 = charSequence.charAt(i11);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i12 = i9 + 1;
                                    bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                                    int i13 = i12 + 1;
                                    bArr[i12] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i14 = i13 + 1;
                                    bArr[i13] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i9 = i14 + 1;
                                    bArr[i14] = (byte) ((codePoint & 63) | 128);
                                    i8 = i11;
                                } else {
                                    i8 = i11;
                                }
                            }
                            throw new d(i8 - 1, length);
                        }
                        int i15 = i9 + 1;
                        bArr[i9] = (byte) ((cCharAt2 >>> '\f') | 480);
                        int i16 = i15 + 1;
                        bArr[i15] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                        i4 = i16 + 1;
                        bArr[i16] = (byte) ((cCharAt2 & '?') | 128);
                    }
                    i8++;
                } else {
                    i4 = i9 + 1;
                    bArr[i9] = (byte) cCharAt2;
                }
                i9 = i4;
                i8++;
            }
            return i9;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x007f, code lost:
        
            if (r8[r9] > (-65)) goto L53;
         */
        @Override // androidx.datastore.preferences.protobuf.q1.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int d(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L82
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L82
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                r7 = r7 ^ r2
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = androidx.datastore.preferences.protobuf.q1.a(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                r1 = r1 ^ r2
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L5d
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5b
                int r7 = androidx.datastore.preferences.protobuf.q1.a(r0, r1)
                return r7
            L5b:
                r9 = r7
                goto L60
            L5d:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L60:
                if (r4 != 0) goto L6e
                int r7 = r9 + 1
                r4 = r8[r9]
                if (r7 < r10) goto L6d
                int r7 = androidx.datastore.preferences.protobuf.q1.b(r0, r1, r4)
                return r7
            L6d:
                r9 = r7
            L6e:
                if (r1 > r3) goto L81
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L81
                if (r4 > r3) goto L81
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L81:
                return r2
            L82:
                int r7 = e(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q1.c.d(int, byte[], int, int):int");
        }
    }

    /* JADX INFO: compiled from: Utf8.java */
    static class d extends IllegalArgumentException {
        d(int i2, int i3) {
            super("Unpaired surrogate at index " + i2 + " of " + i3);
        }
    }

    /* JADX INFO: compiled from: Utf8.java */
    static final class e extends b {
        e() {
        }

        static boolean e() {
            return p1.C() && p1.D();
        }

        private static int f(byte[] bArr, long j2, int i2) {
            long j3;
            int iG = g(bArr, j2, i2);
            int i3 = i2 - iG;
            long j4 = j2 + ((long) iG);
            while (true) {
                byte bS = 0;
                while (i3 > 0) {
                    long j5 = j4 + 1;
                    bS = p1.s(bArr, j4);
                    if (bS < 0) {
                        j4 = j5;
                        break;
                    }
                    i3--;
                    j4 = j5;
                }
                if (i3 == 0) {
                    return 0;
                }
                int i4 = i3 - 1;
                if (bS < -32) {
                    if (i4 == 0) {
                        return bS;
                    }
                    i3 = i4 - 1;
                    if (bS >= -62) {
                        j3 = 1 + j4;
                        if (p1.s(bArr, j4) > -65) {
                        }
                    }
                    return -1;
                }
                if (bS >= -16) {
                    if (i4 < 3) {
                        return h(bArr, bS, j4, i4);
                    }
                    i3 = i4 - 3;
                    long j6 = j4 + 1;
                    byte bS2 = p1.s(bArr, j4);
                    if (bS2 <= -65 && (((bS << 28) + (bS2 + 112)) >> 30) == 0) {
                        long j7 = j6 + 1;
                        if (p1.s(bArr, j6) <= -65) {
                            j3 = 1 + j7;
                            if (p1.s(bArr, j7) > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i4 < 2) {
                    return h(bArr, bS, j4, i4);
                }
                i3 = i4 - 2;
                long j8 = j4 + 1;
                byte bS3 = p1.s(bArr, j4);
                if (bS3 <= -65 && ((bS != -32 || bS3 >= -96) && (bS != -19 || bS3 < -96))) {
                    j3 = 1 + j8;
                    if (p1.s(bArr, j8) > -65) {
                    }
                }
                return -1;
                j4 = j3;
            }
        }

        private static int g(byte[] bArr, long j2, int i2) {
            int i3 = 0;
            if (i2 < 16) {
                return 0;
            }
            while (i3 < i2) {
                long j3 = 1 + j2;
                if (p1.s(bArr, j2) < 0) {
                    return i3;
                }
                i3++;
                j2 = j3;
            }
            return i2;
        }

        private static int h(byte[] bArr, int i2, long j2, int i3) {
            if (i3 == 0) {
                return q1.i(i2);
            }
            if (i3 == 1) {
                return q1.j(i2, p1.s(bArr, j2));
            }
            if (i3 == 2) {
                return q1.k(i2, p1.s(bArr, j2), p1.s(bArr, j2 + 1));
            }
            throw new AssertionError();
        }

        @Override // androidx.datastore.preferences.protobuf.q1.b
        String a(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
            if ((i2 | i3 | ((bArr.length - i2) - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i2 < i4) {
                byte bS = p1.s(bArr, i2);
                if (!a.n(bS)) {
                    break;
                }
                i2++;
                a.i(bS, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i2 < i4) {
                int i7 = i2 + 1;
                byte bS2 = p1.s(bArr, i2);
                if (a.n(bS2)) {
                    int i8 = i6 + 1;
                    a.i(bS2, cArr, i6);
                    while (i7 < i4) {
                        byte bS3 = p1.s(bArr, i7);
                        if (!a.n(bS3)) {
                            break;
                        }
                        i7++;
                        a.i(bS3, cArr, i8);
                        i8++;
                    }
                    i2 = i7;
                    i6 = i8;
                } else if (a.p(bS2)) {
                    if (i7 >= i4) {
                        throw InvalidProtocolBufferException.c();
                    }
                    a.k(bS2, p1.s(bArr, i7), cArr, i6);
                    i2 = i7 + 1;
                    i6++;
                } else if (a.o(bS2)) {
                    if (i7 >= i4 - 1) {
                        throw InvalidProtocolBufferException.c();
                    }
                    int i9 = i7 + 1;
                    a.j(bS2, p1.s(bArr, i7), p1.s(bArr, i9), cArr, i6);
                    i2 = i9 + 1;
                    i6++;
                } else {
                    if (i7 >= i4 - 2) {
                        throw InvalidProtocolBufferException.c();
                    }
                    int i10 = i7 + 1;
                    byte bS4 = p1.s(bArr, i7);
                    int i11 = i10 + 1;
                    a.h(bS2, bS4, p1.s(bArr, i10), p1.s(bArr, i11), cArr, i6);
                    i2 = i11 + 1;
                    i6 = i6 + 1 + 1;
                }
            }
            return new String(cArr, 0, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.q1.b
        int b(CharSequence charSequence, byte[] bArr, int i2, int i3) {
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
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i2 + i3));
            }
            int i5 = 0;
            while (true) {
                c2 = 128;
                j2 = 1;
                if (i5 >= length || (cCharAt = charSequence.charAt(i5)) >= 128) {
                    break;
                }
                p1.H(bArr, j5, (byte) cCharAt);
                i5++;
                j5 = 1 + j5;
            }
            if (i5 == length) {
                return (int) j5;
            }
            while (i5 < length) {
                char cCharAt2 = charSequence.charAt(i5);
                if (cCharAt2 >= c2 || j5 >= j6) {
                    if (cCharAt2 < 2048 && j5 <= j6 - 2) {
                        long j7 = j5 + j2;
                        p1.H(bArr, j5, (byte) ((cCharAt2 >>> 6) | 960));
                        p1.H(bArr, j7, (byte) ((cCharAt2 & '?') | 128));
                        j3 = j7 + j2;
                        j4 = j2;
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j5 > j6 - 3) {
                            if (j5 > j6 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i5 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4)))) {
                                    throw new d(i5, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + j5);
                            }
                            int i6 = i5 + 1;
                            if (i6 != length) {
                                char cCharAt3 = charSequence.charAt(i6);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    long j8 = j5 + 1;
                                    p1.H(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                                    long j9 = j8 + 1;
                                    p1.H(bArr, j8, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j10 = j9 + 1;
                                    p1.H(bArr, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j4 = 1;
                                    j3 = j10 + 1;
                                    p1.H(bArr, j10, (byte) ((codePoint & 63) | 128));
                                    i5 = i6;
                                } else {
                                    i5 = i6;
                                }
                            }
                            throw new d(i5 - 1, length);
                        }
                        long j11 = j5 + j2;
                        p1.H(bArr, j5, (byte) ((cCharAt2 >>> '\f') | 480));
                        long j12 = j11 + j2;
                        p1.H(bArr, j11, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        p1.H(bArr, j12, (byte) ((cCharAt2 & '?') | 128));
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
                    p1.H(bArr, j5, (byte) cCharAt2);
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

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
        
            if (androidx.datastore.preferences.protobuf.p1.s(r13, r2) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        
            if (androidx.datastore.preferences.protobuf.p1.s(r13, r2) > (-65)) goto L59;
         */
        @Override // androidx.datastore.preferences.protobuf.q1.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int d(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instruction units count: 206
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q1.e.d(int, byte[], int, int):int");
        }
    }

    static {
        a = (!e.e() || androidx.datastore.preferences.protobuf.d.c()) ? new c() : new e();
    }

    static String e(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
        return a.a(bArr, i2, i3);
    }

    static int f(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return a.b(charSequence, bArr, i2, i3);
    }

    static int g(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int iH = length;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt >= 2048) {
                iH += h(charSequence, i2);
                break;
            }
            iH += (127 - cCharAt) >>> 31;
            i2++;
        }
        if (iH >= length) {
            return iH;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iH) + 4294967296L));
    }

    private static int h(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < 2048) {
                i3 += (127 - cCharAt) >>> 31;
            } else {
                i3 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i2) < 65536) {
                        throw new d(i2, length);
                    }
                    i2++;
                }
            }
            i2++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 == 0) {
            return i(b2);
        }
        if (i4 == 1) {
            return j(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return k(b2, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    public static boolean m(byte[] bArr) {
        return a.c(bArr, 0, bArr.length);
    }

    public static boolean n(byte[] bArr, int i2, int i3) {
        return a.c(bArr, i2, i3);
    }
}
