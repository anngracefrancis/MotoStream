package com.google.zxing.i;

import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: OneDimensionalCodeWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class n implements com.google.zxing.e {
    protected static int b(boolean[] zArr, int i2, int[] iArr, boolean z) {
        int i3 = 0;
        for (int i4 : iArr) {
            int i5 = 0;
            while (i5 < i4) {
                zArr[i2] = z;
                i5++;
                i2++;
            }
            i3 += i4;
            z = !z;
        }
        return i3;
    }

    private static com.google.zxing.g.b e(boolean[] zArr, int i2, int i3, int i4) {
        int length = zArr.length;
        int i5 = i4 + length;
        int iMax = Math.max(i2, i5);
        int iMax2 = Math.max(1, i3);
        int i6 = iMax / i5;
        int i7 = (iMax - (length * i6)) / 2;
        com.google.zxing.g.b bVar = new com.google.zxing.g.b(iMax, iMax2);
        int i8 = 0;
        while (i8 < length) {
            if (zArr[i8]) {
                bVar.j(i7, 0, i6, iMax2);
            }
            i8++;
            i7 += i6;
        }
        return bVar;
    }

    @Override // com.google.zxing.e
    public com.google.zxing.g.b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<com.google.zxing.c, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i2 + 'x' + i3);
        }
        int iD = d();
        if (map != null) {
            com.google.zxing.c cVar = com.google.zxing.c.MARGIN;
            if (map.containsKey(cVar)) {
                iD = Integer.parseInt(map.get(cVar).toString());
            }
        }
        return e(c(str), i2, i3, iD);
    }

    public abstract boolean[] c(String str);

    public int d() {
        return 10;
    }
}
