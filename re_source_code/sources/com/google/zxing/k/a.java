package com.google.zxing.k;

import com.google.zxing.WriterException;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.g.b;
import com.google.zxing.k.c.f;
import java.util.Map;

/* JADX INFO: compiled from: QRCodeWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements e {
    private static b b(f fVar, int i2, int i3, int i4) {
        com.google.zxing.k.c.b bVarA = fVar.a();
        if (bVarA == null) {
            throw new IllegalStateException();
        }
        int iE = bVarA.e();
        int iD = bVarA.d();
        int i5 = i4 << 1;
        int i6 = iE + i5;
        int i7 = i5 + iD;
        int iMax = Math.max(i2, i6);
        int iMax2 = Math.max(i3, i7);
        int iMin = Math.min(iMax / i6, iMax2 / i7);
        int i8 = (iMax - (iE * iMin)) / 2;
        int i9 = (iMax2 - (iD * iMin)) / 2;
        b bVar = new b(iMax, iMax2);
        int i10 = 0;
        while (i10 < iD) {
            int i11 = i8;
            int i12 = 0;
            while (i12 < iE) {
                if (bVarA.b(i12, i10) == 1) {
                    bVar.j(i11, i9, iMin, iMin);
                }
                i12++;
                i11 += iMin;
            }
            i10++;
            i9 += iMin;
        }
        return bVar;
    }

    @Override // com.google.zxing.e
    public b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<c, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != com.google.zxing.a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(aVar)));
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        com.google.zxing.k.b.a aVarValueOf = com.google.zxing.k.b.a.L;
        int i4 = 4;
        if (map != null) {
            c cVar = c.ERROR_CORRECTION;
            if (map.containsKey(cVar)) {
                aVarValueOf = com.google.zxing.k.b.a.valueOf(map.get(cVar).toString());
            }
            c cVar2 = c.MARGIN;
            if (map.containsKey(cVar2)) {
                i4 = Integer.parseInt(map.get(cVar2).toString());
            }
        }
        return b(com.google.zxing.k.c.c.n(str, aVarValueOf, map), i2, i3, i4);
    }
}
