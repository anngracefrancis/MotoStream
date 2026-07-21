package com.google.zxing.f.b;

/* JADX INFO: compiled from: Encoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final int[] a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int[] a(com.google.zxing.g.a aVar, int i2, int i3) {
        int[] iArr = new int[i3];
        int i4 = aVar.i() / i2;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                i6 |= aVar.h((i5 * i2) + i7) ? 1 << ((i2 - i7) - 1) : 0;
            }
            iArr[i5] = i6;
        }
        return iArr;
    }

    private static void b(com.google.zxing.g.b bVar, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 <= i7) {
                    bVar.i(i6, i5);
                    bVar.i(i6, i7);
                    bVar.i(i5, i6);
                    bVar.i(i7, i6);
                    i6++;
                }
            }
        }
        int i8 = i2 - i3;
        bVar.i(i8, i8);
        int i9 = i8 + 1;
        bVar.i(i9, i8);
        bVar.i(i8, i9);
        int i10 = i2 + i3;
        bVar.i(i10, i8);
        bVar.i(i10, i9);
        bVar.i(i10, i10 - 1);
    }

    private static void c(com.google.zxing.g.b bVar, boolean z, int i2, com.google.zxing.g.a aVar) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (aVar.h(i4)) {
                    bVar.i(i5, i3 - 5);
                }
                if (aVar.h(i4 + 7)) {
                    bVar.i(i3 + 5, i5);
                }
                if (aVar.h(20 - i4)) {
                    bVar.i(i5, i3 + 5);
                }
                if (aVar.h(27 - i4)) {
                    bVar.i(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (aVar.h(i4)) {
                bVar.i(i6, i3 - 7);
            }
            if (aVar.h(i4 + 10)) {
                bVar.i(i3 + 7, i6);
            }
            if (aVar.h(29 - i4)) {
                bVar.i(i6, i3 + 7);
            }
            if (aVar.h(39 - i4)) {
                bVar.i(i3 - 7, i6);
            }
            i4++;
        }
    }

    public static a d(byte[] bArr, int i2, int i3) {
        com.google.zxing.g.a aVarH;
        int i4;
        boolean z;
        int iAbs;
        int i5;
        int i6;
        com.google.zxing.g.a aVarA = new d(bArr).a();
        int i7 = ((aVarA.i() * i2) / 100) + 11;
        int i8 = aVarA.i() + i7;
        int i9 = 0;
        int i10 = 1;
        if (i3 != 0) {
            z = i3 < 0;
            iAbs = Math.abs(i3);
            if (iAbs > (z ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i3)));
            }
            i5 = i(iAbs, z);
            i4 = a[iAbs];
            int i11 = i5 - (i5 % i4);
            aVarH = h(aVarA, i4);
            if (aVarH.i() + i7 > i11) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z && aVarH.i() > (i4 << 6)) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
        } else {
            com.google.zxing.g.a aVarH2 = null;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (i12 > 32) {
                    throw new IllegalArgumentException("Data too large for an Aztec code");
                }
                boolean z2 = i12 <= 3;
                int i14 = z2 ? i12 + 1 : i12;
                int i15 = i(i14, z2);
                if (i8 <= i15) {
                    if (aVarH2 == null || i13 != a[i14]) {
                        int i16 = a[i14];
                        i13 = i16;
                        aVarH2 = h(aVarA, i16);
                    }
                    int i17 = i15 - (i15 % i13);
                    if ((!z2 || aVarH2.i() <= (i13 << 6)) && aVarH2.i() + i7 <= i17) {
                        aVarH = aVarH2;
                        i4 = i13;
                        z = z2;
                        iAbs = i14;
                        i5 = i15;
                        break;
                    }
                }
                i12++;
                i9 = 0;
                i10 = 1;
            }
        }
        com.google.zxing.g.a aVarE = e(aVarH, i5, i4);
        int i18 = aVarH.i() / i4;
        com.google.zxing.g.a aVarF = f(z, iAbs, i18);
        int i19 = (z ? 11 : 14) + (iAbs << 2);
        int[] iArr = new int[i19];
        int i20 = 2;
        if (z) {
            for (int i21 = 0; i21 < i19; i21++) {
                iArr[i21] = i21;
            }
            i6 = i19;
        } else {
            int i22 = i19 / 2;
            i6 = i19 + 1 + (((i22 - 1) / 15) * 2);
            int i23 = i6 / 2;
            for (int i24 = 0; i24 < i22; i24++) {
                int i25 = (i24 / 15) + i24;
                iArr[(i22 - i24) - i10] = (i23 - i25) - 1;
                iArr[i22 + i24] = i25 + i23 + i10;
            }
        }
        com.google.zxing.g.b bVar = new com.google.zxing.g.b(i6);
        int i26 = 0;
        int i27 = 0;
        while (i26 < iAbs) {
            int i28 = ((iAbs - i26) << i20) + (z ? 9 : 12);
            int i29 = 0;
            while (i29 < i28) {
                int i30 = i29 << 1;
                while (i9 < i20) {
                    if (aVarE.h(i27 + i30 + i9)) {
                        int i31 = i26 << 1;
                        bVar.i(iArr[i31 + i9], iArr[i31 + i29]);
                    }
                    if (aVarE.h((i28 << 1) + i27 + i30 + i9)) {
                        int i32 = i26 << 1;
                        bVar.i(iArr[i32 + i29], iArr[((i19 - 1) - i32) - i9]);
                    }
                    if (aVarE.h((i28 << 2) + i27 + i30 + i9)) {
                        int i33 = (i19 - 1) - (i26 << 1);
                        bVar.i(iArr[i33 - i9], iArr[i33 - i29]);
                    }
                    if (aVarE.h((i28 * 6) + i27 + i30 + i9)) {
                        int i34 = i26 << 1;
                        bVar.i(iArr[((i19 - 1) - i34) - i29], iArr[i34 + i9]);
                    }
                    i9++;
                    i20 = 2;
                }
                i29++;
                i9 = 0;
                i20 = 2;
            }
            i27 += i28 << 3;
            i26++;
            i9 = 0;
            i20 = 2;
        }
        c(bVar, z, i6, aVarF);
        if (z) {
            b(bVar, i6 / 2, 5);
        } else {
            int i35 = i6 / 2;
            b(bVar, i35, 7);
            int i36 = 0;
            int i37 = 0;
            while (i37 < (i19 / 2) - 1) {
                for (int i38 = i35 & 1; i38 < i6; i38 += 2) {
                    int i39 = i35 - i36;
                    bVar.i(i39, i38);
                    int i40 = i35 + i36;
                    bVar.i(i40, i38);
                    bVar.i(i38, i39);
                    bVar.i(i38, i40);
                }
                i37 += 15;
                i36 += 16;
            }
        }
        a aVar = new a();
        aVar.c(z);
        aVar.f(i6);
        aVar.d(iAbs);
        aVar.b(i18);
        aVar.e(bVar);
        return aVar;
    }

    private static com.google.zxing.g.a e(com.google.zxing.g.a aVar, int i2, int i3) {
        int i4 = aVar.i() / i3;
        com.google.zxing.common.reedsolomon.c cVar = new com.google.zxing.common.reedsolomon.c(g(i3));
        int i5 = i2 / i3;
        int[] iArrA = a(aVar, i3, i5);
        cVar.b(iArrA, i5 - i4);
        com.google.zxing.g.a aVar2 = new com.google.zxing.g.a();
        aVar2.e(0, i2 % i3);
        for (int i6 : iArrA) {
            aVar2.e(i6, i3);
        }
        return aVar2;
    }

    static com.google.zxing.g.a f(boolean z, int i2, int i3) {
        com.google.zxing.g.a aVar = new com.google.zxing.g.a();
        if (z) {
            aVar.e(i2 - 1, 2);
            aVar.e(i3 - 1, 6);
            return e(aVar, 28, 4);
        }
        aVar.e(i2 - 1, 5);
        aVar.e(i3 - 1, 11);
        return e(aVar, 40, 4);
    }

    private static com.google.zxing.common.reedsolomon.a g(int i2) {
        if (i2 == 4) {
            return com.google.zxing.common.reedsolomon.a.f20311d;
        }
        if (i2 == 6) {
            return com.google.zxing.common.reedsolomon.a.f20310c;
        }
        if (i2 == 8) {
            return com.google.zxing.common.reedsolomon.a.f20314g;
        }
        if (i2 == 10) {
            return com.google.zxing.common.reedsolomon.a.f20309b;
        }
        if (i2 == 12) {
            return com.google.zxing.common.reedsolomon.a.a;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
    }

    static com.google.zxing.g.a h(com.google.zxing.g.a aVar, int i2) {
        com.google.zxing.g.a aVar2 = new com.google.zxing.g.a();
        int i3 = aVar.i();
        int i4 = (1 << i2) - 2;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = i5 + i7;
                if (i8 >= i3 || aVar.h(i8)) {
                    i6 |= 1 << ((i2 - 1) - i7);
                }
            }
            int i9 = i6 & i4;
            if (i9 == i4) {
                aVar2.e(i9, i2);
            } else {
                if (i9 == 0) {
                    aVar2.e(i6 | 1, i2);
                } else {
                    aVar2.e(i6, i2);
                }
                i5 += i2;
            }
            i5--;
            i5 += i2;
        }
        return aVar2;
    }

    private static int i(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }
}
