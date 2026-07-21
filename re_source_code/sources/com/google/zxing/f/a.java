package com.google.zxing.f;

import com.google.zxing.e;
import com.google.zxing.f.b.c;
import com.google.zxing.g.b;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: compiled from: AztecWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements e {
    private static b b(String str, com.google.zxing.a aVar, int i2, int i3, Charset charset, int i4, int i5) {
        if (aVar == com.google.zxing.a.AZTEC) {
            return c(c.d(str.getBytes(charset), i4, i5), i2, i3);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
    }

    private static b c(com.google.zxing.f.b.a aVar, int i2, int i3) {
        b bVarA = aVar.a();
        if (bVarA == null) {
            throw new IllegalStateException();
        }
        int iH = bVarA.h();
        int iG = bVarA.g();
        int iMax = Math.max(i2, iH);
        int iMax2 = Math.max(i3, iG);
        int iMin = Math.min(iMax / iH, iMax2 / iG);
        int i4 = (iMax - (iH * iMin)) / 2;
        int i5 = (iMax2 - (iG * iMin)) / 2;
        b bVar = new b(iMax, iMax2);
        int i6 = 0;
        while (i6 < iG) {
            int i7 = i4;
            int i8 = 0;
            while (i8 < iH) {
                if (bVarA.f(i8, i6)) {
                    bVar.j(i7, i5, iMin, iMin);
                }
                i8++;
                i7 += iMin;
            }
            i6++;
            i5 += iMin;
        }
        return bVar;
    }

    @Override // com.google.zxing.e
    public b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<com.google.zxing.c, ?> map) {
        Charset charset;
        int i4;
        int i5;
        Charset charsetForName = StandardCharsets.ISO_8859_1;
        if (map != null) {
            com.google.zxing.c cVar = com.google.zxing.c.CHARACTER_SET;
            if (map.containsKey(cVar)) {
                charsetForName = Charset.forName(map.get(cVar).toString());
            }
            com.google.zxing.c cVar2 = com.google.zxing.c.ERROR_CORRECTION;
            int i6 = map.containsKey(cVar2) ? Integer.parseInt(map.get(cVar2).toString()) : 33;
            com.google.zxing.c cVar3 = com.google.zxing.c.AZTEC_LAYERS;
            if (map.containsKey(cVar3)) {
                charset = charsetForName;
                i4 = i6;
                i5 = Integer.parseInt(map.get(cVar3).toString());
            } else {
                charset = charsetForName;
                i4 = i6;
            }
            return b(str, aVar, i2, i3, charset, i4, i5);
        }
        charset = charsetForName;
        i4 = 33;
        i5 = 0;
        return b(str, aVar, i2, i3, charset, i4, i5);
    }
}
