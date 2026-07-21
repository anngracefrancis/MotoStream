package com.google.zxing.k.c;

/* JADX INFO: compiled from: MaskUtil.java */
/* JADX INFO: loaded from: classes2.dex */
final class d {
    static int a(b bVar) {
        return b(bVar, true) + b(bVar, false);
    }

    private static int b(b bVar, boolean z) {
        int iD = z ? bVar.d() : bVar.e();
        int iE = z ? bVar.e() : bVar.d();
        byte[][] bArrC = bVar.c();
        int i2 = 0;
        for (int i3 = 0; i3 < iD; i3++) {
            byte b2 = -1;
            int i4 = 0;
            for (int i5 = 0; i5 < iE; i5++) {
                byte b3 = z ? bArrC[i3][i5] : bArrC[i5][i3];
                if (b3 == b2) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i2 += (i4 - 5) + 3;
                    }
                    b2 = b3;
                    i4 = 1;
                }
            }
            if (i4 >= 5) {
                i2 += (i4 - 5) + 3;
            }
        }
        return i2;
    }

    static int c(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < iD - 1; i3++) {
            byte[] bArr = bArrC[i3];
            int i4 = 0;
            while (i4 < iE - 1) {
                byte b2 = bArr[i4];
                int i5 = i4 + 1;
                if (b2 == bArr[i5]) {
                    int i6 = i3 + 1;
                    if (b2 == bArrC[i6][i4] && b2 == bArrC[i6][i5]) {
                        i2++;
                    }
                }
                i4 = i5;
            }
        }
        return i2 * 3;
    }

    static int d(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < iD; i3++) {
            for (int i4 = 0; i4 < iE; i4++) {
                byte[] bArr = bArrC[i3];
                int i5 = i4 + 6;
                if (i5 < iE && bArr[i4] == 1 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1 && bArr[i4 + 3] == 1 && bArr[i4 + 4] == 1 && bArr[i4 + 5] == 0 && bArr[i5] == 1 && (g(bArr, i4 - 4, i4) || g(bArr, i4 + 7, i4 + 11))) {
                    i2++;
                }
                int i6 = i3 + 6;
                if (i6 < iD && bArrC[i3][i4] == 1 && bArrC[i3 + 1][i4] == 0 && bArrC[i3 + 2][i4] == 1 && bArrC[i3 + 3][i4] == 1 && bArrC[i3 + 4][i4] == 1 && bArrC[i3 + 5][i4] == 0 && bArrC[i6][i4] == 1 && (h(bArrC, i4, i3 - 4, i3) || h(bArrC, i4, i3 + 7, i3 + 11))) {
                    i2++;
                }
            }
        }
        return i2 * 40;
    }

    static int e(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < iD; i3++) {
            byte[] bArr = bArrC[i3];
            for (int i4 = 0; i4 < iE; i4++) {
                if (bArr[i4] == 1) {
                    i2++;
                }
            }
        }
        int iD2 = bVar.d() * bVar.e();
        return ((Math.abs((i2 << 1) - iD2) * 10) / iD2) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x003f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x0040 A[RETURN] */
    static boolean f(int i2, int i3, int i4) {
        int i5;
        int i6;
        switch (i2) {
            case 0:
                i4 += i3;
                i5 = i4 & 1;
                if (i5 == 0) {
                    return true;
                }
                return false;
            case 1:
                i5 = i4 & 1;
                if (i5 == 0) {
                    return true;
                }
                return false;
            case 2:
                i5 = i3 % 3;
                if (i5 == 0) {
                    return true;
                }
                return false;
            case 3:
                i5 = (i4 + i3) % 3;
                if (i5 == 0) {
                    return true;
                }
                return false;
            case 4:
                i4 /= 2;
                i3 /= 3;
                i4 += i3;
                i5 = i4 & 1;
                if (i5 == 0) {
                    return true;
                }
                return false;
            case 5:
                int i7 = i4 * i3;
                i5 = (i7 & 1) + (i7 % 3);
                if (i5 == 0) {
                    return true;
                }
                return false;
            case 6:
                int i8 = i4 * i3;
                i6 = (i8 & 1) + (i8 % 3);
                i5 = i6 & 1;
                if (i5 == 0) {
                    return true;
                }
                return false;
            case 7:
                i6 = ((i4 * i3) % 3) + ((i4 + i3) & 1);
                i5 = i6 & 1;
                if (i5 == 0) {
                    return true;
                }
                return false;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i2)));
        }
    }

    private static boolean g(byte[] bArr, int i2, int i3) {
        int iMin = Math.min(i3, bArr.length);
        for (int iMax = Math.max(i2, 0); iMax < iMin; iMax++) {
            if (bArr[iMax] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i2, int i3, int i4) {
        int iMin = Math.min(i4, bArr.length);
        for (int iMax = Math.max(i3, 0); iMax < iMin; iMax++) {
            if (bArr[iMax][i2] == 1) {
                return false;
            }
        }
        return true;
    }
}
