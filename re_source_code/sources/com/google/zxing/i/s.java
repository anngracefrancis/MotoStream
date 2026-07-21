package com.google.zxing.i;

import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: UPCEWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends q {
    @Override // com.google.zxing.i.n, com.google.zxing.e
    public com.google.zxing.g.b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<com.google.zxing.c, ?> map) throws WriterException {
        if (aVar == com.google.zxing.a.UPC_E) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + p.b(r.c(str));
            } catch (FormatException e2) {
                throw new IllegalArgumentException(e2);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
            }
            try {
                if (!p.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        int iDigit = Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i2 = r.f20398g[iDigit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iB = n.b(zArr, 0, p.a, true) + 0;
        for (int i3 = 1; i3 <= 6; i3++) {
            int iDigit2 = Character.digit(str.charAt(i3), 10);
            if (((i2 >> (6 - i3)) & 1) == 1) {
                iDigit2 += 10;
            }
            iB += n.b(zArr, iB, p.f20396e[iDigit2], false);
        }
        n.b(zArr, iB, p.f20394c, false);
        return zArr;
    }
}
