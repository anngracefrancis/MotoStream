package com.google.android.gms.internal.ads;

import java.io.IOException;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class au {
    static int a(int i2, byte[] bArr, int i3, int i4, bu buVar) throws zzdok {
        if ((i2 >>> 3) == 0) {
            throw zzdok.d();
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            return j(bArr, i3, buVar);
        }
        if (i5 == 1) {
            return i3 + 8;
        }
        if (i5 == 2) {
            return h(bArr, i3, buVar) + buVar.a;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                return i3 + 4;
            }
            throw zzdok.d();
        }
        int i6 = (i2 & (-8)) | 4;
        int i7 = 0;
        while (i3 < i4) {
            i3 = h(bArr, i3, buVar);
            i7 = buVar.a;
            if (i7 == i6) {
                break;
            }
            i3 = a(i7, bArr, i3, i4, buVar);
        }
        if (i3 > i4 || i7 != i6) {
            throw zzdok.g();
        }
        return i3;
    }

    static int b(int i2, byte[] bArr, int i3, int i4, zzdoj<?> zzdojVar, bu buVar) {
        gv gvVar = (gv) zzdojVar;
        int iH = h(bArr, i3, buVar);
        gvVar.Z0(buVar.a);
        while (iH < i4) {
            int iH2 = h(bArr, iH, buVar);
            if (i2 != buVar.a) {
                break;
            }
            iH = h(bArr, iH2, buVar);
            gvVar.Z0(buVar.a);
        }
        return iH;
    }

    static int c(int i2, byte[] bArr, int i3, int i4, zzdqu zzdquVar, bu buVar) throws zzdok {
        if ((i2 >>> 3) == 0) {
            throw zzdok.d();
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int iJ = j(bArr, i3, buVar);
            zzdquVar.k(i2, Long.valueOf(buVar.f12360b));
            return iJ;
        }
        if (i5 == 1) {
            zzdquVar.k(i2, Long.valueOf(o(bArr, i3)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int iH = h(bArr, i3, buVar);
            int i6 = buVar.a;
            if (i6 < 0) {
                throw zzdok.b();
            }
            if (i6 > bArr.length - iH) {
                throw zzdok.a();
            }
            if (i6 == 0) {
                zzdquVar.k(i2, zzdmr.f15982f);
            } else {
                zzdquVar.k(i2, zzdmr.A(bArr, iH, i6));
            }
            return iH + i6;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw zzdok.d();
            }
            zzdquVar.k(i2, Integer.valueOf(n(bArr, i3)));
            return i3 + 4;
        }
        zzdqu zzdquVarI = zzdqu.i();
        int i7 = (i2 & (-8)) | 4;
        int i8 = 0;
        while (i3 < i4) {
            int iH2 = h(bArr, i3, buVar);
            int i9 = buVar.a;
            i8 = i9;
            if (i9 == i7) {
                i3 = iH2;
                break;
            }
            int iC = c(i8, bArr, iH2, i4, zzdquVarI, buVar);
            i8 = i9;
            i3 = iC;
        }
        if (i3 > i4 || i8 != i7) {
            throw zzdok.g();
        }
        zzdquVar.k(i2, zzdquVarI);
        return i3;
    }

    static int d(int i2, byte[] bArr, int i3, bu buVar) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            buVar.a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & 127) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            buVar.a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & 127) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            buVar.a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & 127) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            buVar.a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                buVar.a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    static int e(lw<?> lwVar, int i2, byte[] bArr, int i3, int i4, zzdoj<?> zzdojVar, bu buVar) throws IOException {
        int iG = g(lwVar, bArr, i3, i4, buVar);
        zzdojVar.add(buVar.f12361c);
        while (iG < i4) {
            int iH = h(bArr, iG, buVar);
            if (i2 != buVar.a) {
                break;
            }
            iG = g(lwVar, bArr, iH, i4, buVar);
            zzdojVar.add(buVar.f12361c);
        }
        return iG;
    }

    static int f(lw lwVar, byte[] bArr, int i2, int i3, int i4, bu buVar) throws IOException {
        aw awVar = (aw) lwVar;
        Object objC = awVar.c();
        int iO = awVar.o(objC, bArr, i2, i3, i4, buVar);
        awVar.f(objC);
        buVar.f12361c = objC;
        return iO;
    }

    static int g(lw lwVar, byte[] bArr, int i2, int i3, bu buVar) throws IOException {
        int iD = i2 + 1;
        int i4 = bArr[i2];
        if (i4 < 0) {
            iD = d(i4, bArr, iD, buVar);
            i4 = buVar.a;
        }
        int i5 = iD;
        if (i4 < 0 || i4 > i3 - i5) {
            throw zzdok.a();
        }
        Object objC = lwVar.c();
        int i6 = i4 + i5;
        lwVar.g(objC, bArr, i5, i6, buVar);
        lwVar.f(objC);
        buVar.f12361c = objC;
        return i6;
    }

    static int h(byte[] bArr, int i2, bu buVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return d(b2, bArr, i3, buVar);
        }
        buVar.a = b2;
        return i3;
    }

    static int i(byte[] bArr, int i2, zzdoj<?> zzdojVar, bu buVar) throws IOException {
        gv gvVar = (gv) zzdojVar;
        int iH = h(bArr, i2, buVar);
        int i3 = buVar.a + iH;
        while (iH < i3) {
            iH = h(bArr, iH, buVar);
            gvVar.Z0(buVar.a);
        }
        if (iH == i3) {
            return iH;
        }
        throw zzdok.a();
    }

    static int j(byte[] bArr, int i2, bu buVar) {
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            buVar.f12360b = j2;
            return i3;
        }
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j3 = (j2 & 127) | (((long) (b2 & 127)) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            i5 += 7;
            j3 |= ((long) (b3 & 127)) << i5;
            b2 = b3;
            i4 = i6;
        }
        buVar.f12360b = j3;
        return i4;
    }

    static int k(byte[] bArr, int i2, bu buVar) throws zzdok {
        int iH = h(bArr, i2, buVar);
        int i3 = buVar.a;
        if (i3 < 0) {
            throw zzdok.b();
        }
        if (i3 == 0) {
            buVar.f12361c = HttpUrl.FRAGMENT_ENCODE_SET;
            return iH;
        }
        buVar.f12361c = new String(bArr, iH, i3, zzdod.a);
        return iH + i3;
    }

    static int l(byte[] bArr, int i2, bu buVar) throws zzdok {
        int iH = h(bArr, i2, buVar);
        int i3 = buVar.a;
        if (i3 < 0) {
            throw zzdok.b();
        }
        if (i3 == 0) {
            buVar.f12361c = HttpUrl.FRAGMENT_ENCODE_SET;
            return iH;
        }
        buVar.f12361c = jx.m(bArr, iH, i3);
        return iH + i3;
    }

    static int m(byte[] bArr, int i2, bu buVar) throws zzdok {
        int iH = h(bArr, i2, buVar);
        int i3 = buVar.a;
        if (i3 < 0) {
            throw zzdok.b();
        }
        if (i3 > bArr.length - iH) {
            throw zzdok.a();
        }
        if (i3 == 0) {
            buVar.f12361c = zzdmr.f15982f;
            return iH;
        }
        buVar.f12361c = zzdmr.A(bArr, iH, i3);
        return iH + i3;
    }

    static int n(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    static long o(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    static double p(byte[] bArr, int i2) {
        return Double.longBitsToDouble(o(bArr, i2));
    }

    static float q(byte[] bArr, int i2) {
        return Float.intBitsToFloat(n(bArr, i2));
    }
}
