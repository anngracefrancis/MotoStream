package com.google.zxing.k.c;

import com.google.zxing.WriterException;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: MatrixUtil.java */
/* JADX INFO: loaded from: classes2.dex */
final class e {
    private static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[][] f20445b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[][] f20446c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, WebSocketProtocol.PAYLOAD_SHORT, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, WebSocketProtocol.PAYLOAD_SHORT, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f20447d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void a(com.google.zxing.g.a aVar, com.google.zxing.k.b.a aVar2, com.google.zxing.k.b.c cVar, int i2, b bVar) throws WriterException {
        c(bVar);
        d(cVar, bVar);
        l(aVar2, i2, bVar);
        s(cVar, bVar);
        f(aVar, i2, bVar);
    }

    static int b(int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iN = n(i3);
        int iN2 = i2 << (iN - 1);
        while (n(iN2) >= iN) {
            iN2 ^= i3 << (n(iN2) - iN);
        }
        return iN2;
    }

    static void c(b bVar) {
        bVar.a((byte) -1);
    }

    static void d(com.google.zxing.k.b.c cVar, b bVar) throws WriterException {
        j(bVar);
        e(bVar);
        r(cVar, bVar);
        k(bVar);
    }

    private static void e(b bVar) throws WriterException {
        if (bVar.b(8, bVar.d() - 8) == 0) {
            throw new WriterException();
        }
        bVar.f(8, bVar.d() - 8, 1);
    }

    static void f(com.google.zxing.g.a aVar, int i2, b bVar) throws WriterException {
        boolean zH;
        int iE = bVar.e() - 1;
        int iD = bVar.d() - 1;
        int i3 = 0;
        int i4 = -1;
        while (iE > 0) {
            if (iE == 6) {
                iE--;
            }
            while (iD >= 0 && iD < bVar.d()) {
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = iE - i5;
                    if (o(bVar.b(i6, iD))) {
                        if (i3 < aVar.i()) {
                            zH = aVar.h(i3);
                            i3++;
                        } else {
                            zH = false;
                        }
                        if (i2 != -1 && d.f(i2, i6, iD)) {
                            zH = !zH;
                        }
                        bVar.g(i6, iD, zH);
                    }
                }
                iD += i4;
            }
            i4 = -i4;
            iD += i4;
            iE -= 2;
        }
        if (i3 == aVar.i()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i3 + '/' + aVar.i());
    }

    private static void g(int i2, int i3, b bVar) throws WriterException {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (!o(bVar.b(i5, i3))) {
                throw new WriterException();
            }
            bVar.f(i5, i3, 0);
        }
    }

    private static void h(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 5; i4++) {
            int[] iArr = f20445b[i4];
            for (int i5 = 0; i5 < 5; i5++) {
                bVar.f(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    private static void i(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 7; i4++) {
            int[] iArr = a[i4];
            for (int i5 = 0; i5 < 7; i5++) {
                bVar.f(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    private static void j(b bVar) throws WriterException {
        int length = a[0].length;
        i(0, 0, bVar);
        i(bVar.e() - length, 0, bVar);
        i(0, bVar.e() - length, bVar);
        g(0, 7, bVar);
        g(bVar.e() - 8, 7, bVar);
        g(0, bVar.e() - 8, bVar);
        m(7, 0, bVar);
        m((bVar.d() - 7) - 1, 0, bVar);
        m(7, bVar.d() - 7, bVar);
    }

    private static void k(b bVar) {
        int i2 = 8;
        while (i2 < bVar.e() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (o(bVar.b(i2, 6))) {
                bVar.f(i2, 6, i4);
            }
            if (o(bVar.b(6, i2))) {
                bVar.f(6, i2, i4);
            }
            i2 = i3;
        }
    }

    static void l(com.google.zxing.k.b.a aVar, int i2, b bVar) throws WriterException {
        com.google.zxing.g.a aVar2 = new com.google.zxing.g.a();
        p(aVar, i2, aVar2);
        for (int i3 = 0; i3 < aVar2.i(); i3++) {
            boolean zH = aVar2.h((aVar2.i() - 1) - i3);
            int[] iArr = f20447d[i3];
            bVar.g(iArr[0], iArr[1], zH);
            if (i3 < 8) {
                bVar.g((bVar.e() - i3) - 1, 8, zH);
            } else {
                bVar.g(8, (bVar.d() - 7) + (i3 - 8), zH);
            }
        }
    }

    private static void m(int i2, int i3, b bVar) throws WriterException {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (!o(bVar.b(i2, i5))) {
                throw new WriterException();
            }
            bVar.f(i2, i5, 0);
        }
    }

    static int n(int i2) {
        return 32 - Integer.numberOfLeadingZeros(i2);
    }

    private static boolean o(int i2) {
        return i2 == -1;
    }

    static void p(com.google.zxing.k.b.a aVar, int i2, com.google.zxing.g.a aVar2) throws WriterException {
        if (!f.b(i2)) {
            throw new WriterException("Invalid mask pattern");
        }
        int iG = (aVar.g() << 3) | i2;
        aVar2.e(iG, 5);
        aVar2.e(b(iG, 1335), 10);
        com.google.zxing.g.a aVar3 = new com.google.zxing.g.a();
        aVar3.e(21522, 15);
        aVar2.m(aVar3);
        if (aVar2.i() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar2.i());
    }

    static void q(com.google.zxing.k.b.c cVar, com.google.zxing.g.a aVar) throws WriterException {
        aVar.e(cVar.f(), 6);
        aVar.e(b(cVar.f(), 7973), 12);
        if (aVar.i() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.i());
    }

    private static void r(com.google.zxing.k.b.c cVar, b bVar) {
        if (cVar.f() < 2) {
            return;
        }
        int[] iArr = f20446c[cVar.f() - 1];
        for (int i2 : iArr) {
            if (i2 >= 0) {
                for (int i3 : iArr) {
                    if (i3 >= 0 && o(bVar.b(i3, i2))) {
                        h(i3 - 2, i2 - 2, bVar);
                    }
                }
            }
        }
    }

    static void s(com.google.zxing.k.b.c cVar, b bVar) throws WriterException {
        if (cVar.f() < 7) {
            return;
        }
        com.google.zxing.g.a aVar = new com.google.zxing.g.a();
        q(cVar, aVar);
        int i2 = 17;
        for (int i3 = 0; i3 < 6; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                boolean zH = aVar.h(i2);
                i2--;
                bVar.g(i3, (bVar.d() - 11) + i4, zH);
                bVar.g((bVar.d() - 11) + i4, i3, zH);
            }
        }
    }
}
