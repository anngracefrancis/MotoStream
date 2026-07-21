package com.google.zxing.i;

import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: EAN13Writer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends q {
    @Override // com.google.zxing.i.n, com.google.zxing.e
    public com.google.zxing.g.b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<com.google.zxing.c, ?> map) throws WriterException {
        if (aVar == com.google.zxing.a.EAN_13) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + p.b(str);
            } catch (FormatException e2) {
                throw new IllegalArgumentException(e2);
            }
        } else {
            if (length != 13) {
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
            }
            try {
                if (!p.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        int i2 = i.f20390f[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iB = n.b(zArr, 0, p.a, true) + 0;
        for (int i3 = 1; i3 <= 6; i3++) {
            int iDigit = Character.digit(str.charAt(i3), 10);
            if (((i2 >> (6 - i3)) & 1) == 1) {
                iDigit += 10;
            }
            iB += n.b(zArr, iB, p.f20396e[iDigit], false);
        }
        int iB2 = iB + n.b(zArr, iB, p.f20393b, false);
        for (int i4 = 7; i4 <= 12; i4++) {
            iB2 += n.b(zArr, iB2, p.f20395d[Character.digit(str.charAt(i4), 10)], true);
        }
        n.b(zArr, iB2, p.a, true);
        return zArr;
    }
}
