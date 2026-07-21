package com.google.zxing.i;

import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: ITFWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends n {
    private static final int[] a = {1, 1, 1, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f20391b = {3, 1, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[][] f20392c = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // com.google.zxing.i.n, com.google.zxing.e
    public com.google.zxing.g.b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<com.google.zxing.c, ?> map) throws WriterException {
        if (aVar == com.google.zxing.a.ITF) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[(length * 9) + 9];
        int iB = n.b(zArr, 0, a, true);
        for (int i2 = 0; i2 < length; i2 += 2) {
            int iDigit = Character.digit(str.charAt(i2), 10);
            int iDigit2 = Character.digit(str.charAt(i2 + 1), 10);
            int[] iArr = new int[10];
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                int[][] iArr2 = f20392c;
                iArr[i4] = iArr2[iDigit][i3];
                iArr[i4 + 1] = iArr2[iDigit2][i3];
            }
            iB += n.b(zArr, iB, iArr, true);
        }
        n.b(zArr, iB, f20391b, true);
        return zArr;
    }
}
