package com.google.zxing.k.c;

import com.google.zxing.WriterException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: Encoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: compiled from: Encoder.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.zxing.k.b.b.values().length];
            a = iArr;
            try {
                iArr[com.google.zxing.k.b.b.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.google.zxing.k.b.b.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.google.zxing.k.b.b.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.google.zxing.k.b.b.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void a(String str, com.google.zxing.g.a aVar, String str2) throws WriterException {
        try {
            for (byte b2 : str.getBytes(str2)) {
                aVar.e(b2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    static void b(CharSequence charSequence, com.google.zxing.g.a aVar) throws WriterException {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int iP = p(charSequence.charAt(i2));
            if (iP == -1) {
                throw new WriterException();
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                int iP2 = p(charSequence.charAt(i3));
                if (iP2 == -1) {
                    throw new WriterException();
                }
                aVar.e((iP * 45) + iP2, 11);
                i2 += 2;
            } else {
                aVar.e(iP, 6);
                i2 = i3;
            }
        }
    }

    static void c(String str, com.google.zxing.k.b.b bVar, com.google.zxing.g.a aVar, String str2) throws WriterException {
        int i2 = a.a[bVar.ordinal()];
        if (i2 == 1) {
            h(str, aVar);
            return;
        }
        if (i2 == 2) {
            b(str, aVar);
        } else if (i2 == 3) {
            a(str, aVar, str2);
        } else {
            if (i2 != 4) {
                throw new WriterException("Invalid mode: ".concat(String.valueOf(bVar)));
            }
            e(str, aVar);
        }
    }

    private static void d(com.google.zxing.g.c cVar, com.google.zxing.g.a aVar) {
        aVar.e(com.google.zxing.k.b.b.ECI.g(), 4);
        aVar.e(cVar.k(), 8);
    }

    static void e(String str, com.google.zxing.g.a aVar) throws WriterException {
        int i2;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i3 = 0; i3 < length; i3 += 2) {
                int i4 = ((bytes[i3] & 255) << 8) | (bytes[i3 + 1] & 255);
                int i5 = 33088;
                if (i4 >= 33088 && i4 <= 40956) {
                    i2 = i4 - i5;
                } else if (i4 < 57408 || i4 > 60351) {
                    i2 = -1;
                } else {
                    i5 = 49472;
                    i2 = i4 - i5;
                }
                if (i2 == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                aVar.e(((i2 >> 8) * 192) + (i2 & 255), 13);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    static void f(int i2, com.google.zxing.k.b.c cVar, com.google.zxing.k.b.b bVar, com.google.zxing.g.a aVar) throws WriterException {
        int iK = bVar.k(cVar);
        int i3 = 1 << iK;
        if (i2 < i3) {
            aVar.e(i2, iK);
            return;
        }
        throw new WriterException(i2 + " is bigger than " + (i3 - 1));
    }

    static void g(com.google.zxing.k.b.b bVar, com.google.zxing.g.a aVar) {
        aVar.e(bVar.g(), 4);
    }

    static void h(CharSequence charSequence, com.google.zxing.g.a aVar) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int iCharAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                aVar.e((iCharAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    aVar.e((iCharAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    aVar.e(iCharAt, 4);
                }
            }
        }
    }

    private static int i(com.google.zxing.k.b.b bVar, com.google.zxing.g.a aVar, com.google.zxing.g.a aVar2, com.google.zxing.k.b.c cVar) {
        return aVar.i() + bVar.k(cVar) + aVar2.i();
    }

    private static int j(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    private static int k(com.google.zxing.g.a aVar, com.google.zxing.k.b.a aVar2, com.google.zxing.k.b.c cVar, b bVar) throws WriterException {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            e.a(aVar, aVar2, cVar, i4, bVar);
            int iJ = j(bVar);
            if (iJ < i2) {
                i3 = i4;
                i2 = iJ;
            }
        }
        return i3;
    }

    private static com.google.zxing.k.b.b l(String str, String str2) {
        if ("Shift_JIS".equals(str2) && s(str)) {
            return com.google.zxing.k.b.b.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (p(cCharAt) == -1) {
                    return com.google.zxing.k.b.b.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return com.google.zxing.k.b.b.ALPHANUMERIC;
        }
        return z2 ? com.google.zxing.k.b.b.NUMERIC : com.google.zxing.k.b.b.BYTE;
    }

    private static com.google.zxing.k.b.c m(int i2, com.google.zxing.k.b.a aVar) throws WriterException {
        for (int i3 = 1; i3 <= 40; i3++) {
            com.google.zxing.k.b.c cVarE = com.google.zxing.k.b.c.e(i3);
            if (v(i2, cVarE, aVar)) {
                return cVarE;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0095  */
    public static f n(String str, com.google.zxing.k.b.a aVar, Map<com.google.zxing.c, ?> map) throws WriterException {
        com.google.zxing.k.b.c cVarT;
        com.google.zxing.g.c cVarG;
        boolean z = map != null && map.containsKey(com.google.zxing.c.CHARACTER_SET);
        String string = z ? map.get(com.google.zxing.c.CHARACTER_SET).toString() : "ISO-8859-1";
        com.google.zxing.k.b.b bVarL = l(str, string);
        com.google.zxing.g.a aVar2 = new com.google.zxing.g.a();
        com.google.zxing.k.b.b bVar = com.google.zxing.k.b.b.BYTE;
        if (bVarL == bVar && z && (cVarG = com.google.zxing.g.c.g(string)) != null) {
            d(cVarG, aVar2);
        }
        if ((map != null && map.containsKey(com.google.zxing.c.GS1_FORMAT)) && Boolean.valueOf(map.get(com.google.zxing.c.GS1_FORMAT).toString()).booleanValue()) {
            g(com.google.zxing.k.b.b.FNC1_FIRST_POSITION, aVar2);
        }
        g(bVarL, aVar2);
        com.google.zxing.g.a aVar3 = new com.google.zxing.g.a();
        c(str, bVarL, aVar3, string);
        if (map != null) {
            com.google.zxing.c cVar = com.google.zxing.c.QR_VERSION;
            if (map.containsKey(cVar)) {
                cVarT = com.google.zxing.k.b.c.e(Integer.parseInt(map.get(cVar).toString()));
                if (!v(i(bVarL, aVar2, aVar3, cVarT), cVarT, aVar)) {
                    throw new WriterException("Data too big for requested version");
                }
            } else {
                cVarT = t(aVar, bVarL, aVar2, aVar3);
            }
        } else {
            cVarT = t(aVar, bVarL, aVar2, aVar3);
        }
        com.google.zxing.g.a aVar4 = new com.google.zxing.g.a();
        aVar4.d(aVar2);
        f(bVarL == bVar ? aVar3.j() : str.length(), cVarT, bVarL, aVar4);
        aVar4.d(aVar3);
        com.google.zxing.k.b.c.b bVarC = cVarT.c(aVar);
        int iD = cVarT.d() - bVarC.d();
        u(iD, aVar4);
        com.google.zxing.g.a aVarR = r(aVar4, cVarT.d(), iD, bVarC.c());
        f fVar = new f();
        fVar.c(aVar);
        fVar.f(bVarL);
        fVar.g(cVarT);
        int iB = cVarT.b();
        b bVar2 = new b(iB, iB);
        int iK = k(aVarR, aVar, cVarT, bVar2);
        fVar.d(iK);
        e.a(aVarR, aVar, cVarT, iK, bVar2);
        fVar.e(bVar2);
        return fVar;
    }

    static byte[] o(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[length + i2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f20312e).b(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    static int p(int i2) {
        int[] iArr = a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    static void q(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws WriterException {
        if (i5 >= i4) {
            throw new WriterException("Block ID too large");
        }
        int i6 = i2 % i4;
        int i7 = i4 - i6;
        int i8 = i2 / i4;
        int i9 = i8 + 1;
        int i10 = i3 / i4;
        int i11 = i10 + 1;
        int i12 = i8 - i10;
        int i13 = i9 - i11;
        if (i12 != i13) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i4 != i7 + i6) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i5 < i7) {
            iArr[0] = i10;
            iArr2[0] = i12;
        } else {
            iArr[0] = i11;
            iArr2[0] = i13;
        }
    }

    static com.google.zxing.g.a r(com.google.zxing.g.a aVar, int i2, int i3, int i4) throws WriterException {
        if (aVar.j() != i3) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i4);
        int i5 = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            q(i2, i3, i4, i6, iArr, iArr2);
            int i7 = iArr[0];
            byte[] bArr = new byte[i7];
            aVar.l(i5 << 3, bArr, 0, i7);
            byte[] bArrO = o(bArr, iArr2[0]);
            arrayList.add(new com.google.zxing.k.c.a(bArr, bArrO));
            iMax = Math.max(iMax, i7);
            iMax2 = Math.max(iMax2, bArrO.length);
            i5 += iArr[0];
        }
        if (i3 != i5) {
            throw new WriterException("Data bytes does not match offset");
        }
        com.google.zxing.g.a aVar2 = new com.google.zxing.g.a();
        for (int i8 = 0; i8 < iMax; i8++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArrA = ((com.google.zxing.k.c.a) it.next()).a();
                if (i8 < bArrA.length) {
                    aVar2.e(bArrA[i8], 8);
                }
            }
        }
        for (int i9 = 0; i9 < iMax2; i9++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArrB = ((com.google.zxing.k.c.a) it2.next()).b();
                if (i9 < bArrB.length) {
                    aVar2.e(bArrB[i9], 8);
                }
            }
        }
        if (i2 == aVar2.j()) {
            return aVar2;
        }
        throw new WriterException("Interleaving error: " + i2 + " and " + aVar2.j() + " differ.");
    }

    private static boolean s(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = bytes[i2] & 255;
                if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static com.google.zxing.k.b.c t(com.google.zxing.k.b.a aVar, com.google.zxing.k.b.b bVar, com.google.zxing.g.a aVar2, com.google.zxing.g.a aVar3) throws WriterException {
        return m(i(bVar, aVar2, aVar3, m(i(bVar, aVar2, aVar3, com.google.zxing.k.b.c.e(1)), aVar)), aVar);
    }

    static void u(int i2, com.google.zxing.g.a aVar) throws WriterException {
        int i3 = i2 << 3;
        if (aVar.i() > i3) {
            throw new WriterException("data bits cannot fit in the QR Code" + aVar.i() + " > " + i3);
        }
        for (int i4 = 0; i4 < 4 && aVar.i() < i3; i4++) {
            aVar.b(false);
        }
        int i5 = aVar.i() & 7;
        if (i5 > 0) {
            while (i5 < 8) {
                aVar.b(false);
                i5++;
            }
        }
        int iJ = i2 - aVar.j();
        for (int i6 = 0; i6 < iJ; i6++) {
            aVar.e((i6 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.i() != i3) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    private static boolean v(int i2, com.google.zxing.k.b.c cVar, com.google.zxing.k.b.a aVar) {
        return cVar.d() - cVar.c(aVar).d() >= (i2 + 7) / 8;
    }
}
