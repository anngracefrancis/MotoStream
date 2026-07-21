package com.google.zxing.i;

import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: Code93Writer.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends n {
    private static int f(boolean[] zArr, int i2, int[] iArr) {
        int length = iArr.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            zArr[i2] = iArr[i3] != 0;
            i3++;
            i2 = i4;
        }
        return 9;
    }

    private static int g(String str, int i2) {
        int iIndexOf = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        return iIndexOf % 47;
    }

    private static void h(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            int i4 = 1;
            if (((1 << (8 - i3)) & i2) == 0) {
                i4 = 0;
            }
            iArr[i3] = i4;
        }
    }

    @Override // com.google.zxing.i.n, com.google.zxing.e
    public com.google.zxing.g.b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<com.google.zxing.c, ?> map) throws WriterException {
        if (aVar == com.google.zxing.a.CODE_93) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        int[] iArr = new int[9];
        int length2 = ((str.length() + 2 + 2) * 9) + 1;
        h(g.f20388b[47], iArr);
        boolean[] zArr = new boolean[length2];
        int iF = f(zArr, 0, iArr);
        for (int i2 = 0; i2 < length; i2++) {
            h(g.f20388b["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i2))], iArr);
            iF += f(zArr, iF, iArr);
        }
        int iG = g(str, 20);
        int[] iArr2 = g.f20388b;
        h(iArr2[iG], iArr);
        int iF2 = iF + f(zArr, iF, iArr);
        h(iArr2[g(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(iG), 15)], iArr);
        int iF3 = iF2 + f(zArr, iF2, iArr);
        h(iArr2[47], iArr);
        zArr[iF3 + f(zArr, iF3, iArr)] = true;
        return zArr;
    }
}
