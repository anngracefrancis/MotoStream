package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class m20 {
    private static final int[] a = {zzsy.i("isom"), zzsy.i("iso2"), zzsy.i("iso3"), zzsy.i("iso4"), zzsy.i("iso5"), zzsy.i("iso6"), zzsy.i("avc1"), zzsy.i("hvc1"), zzsy.i("hev1"), zzsy.i("mp41"), zzsy.i("mp42"), zzsy.i("3g2a"), zzsy.i("3g2b"), zzsy.i("3gr6"), zzsy.i("3gs6"), zzsy.i("3ge6"), zzsy.i("3gg6"), zzsy.i("M4V "), zzsy.i("M4A "), zzsy.i("f4v "), zzsy.i("kddi"), zzsy.i("M4VP"), zzsy.i("qt  "), zzsy.i("MSNV")};

    public static boolean a(zzno zznoVar) throws InterruptedException, IOException {
        boolean z;
        boolean z2;
        long jF = zznoVar.f();
        if (jF == -1 || jF > 4096) {
            jF = 4096;
        }
        int i2 = (int) jF;
        zzst zzstVar = new zzst(64);
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            if (i3 < i2) {
                zzstVar.j(8);
                zznoVar.d(zzstVar.a, 0, 8);
                long jQ = zzstVar.q();
                int iD = zzstVar.d();
                int i4 = 16;
                if (jQ == 1) {
                    zznoVar.d(zzstVar.a, 8, 8);
                    zzstVar.o(16);
                    jQ = zzstVar.t();
                } else {
                    i4 = 8;
                }
                long j2 = i4;
                if (jQ >= j2) {
                    i3 += i4;
                    if (iD != y10.B) {
                        if (iD == y10.K || iD == y10.M) {
                            z = true;
                            if (!z3 && !z) {
                                return true;
                            }
                        } else if ((((long) i3) + jQ) - j2 < i2) {
                            int i5 = (int) (jQ - j2);
                            i3 += i5;
                            if (iD == y10.a) {
                                if (i5 >= 8) {
                                    zzstVar.j(i5);
                                    zznoVar.d(zzstVar.a, 0, i5);
                                    int i6 = i5 / 4;
                                    for (int i7 = 0; i7 < i6; i7++) {
                                        if (i7 != 1) {
                                            int iD2 = zzstVar.d();
                                            if ((iD2 >>> 8) == zzsy.i("3gp")) {
                                                z2 = true;
                                                break;
                                            }
                                            int[] iArr = a;
                                            int length = iArr.length;
                                            int i8 = 0;
                                            while (true) {
                                                if (i8 >= length) {
                                                    z2 = false;
                                                    break;
                                                }
                                                if (iArr[i8] == iD2) {
                                                    z2 = true;
                                                    break;
                                                }
                                                i8++;
                                            }
                                            if (z2) {
                                                z3 = true;
                                                break;
                                            }
                                        } else {
                                            zzstVar.l(4);
                                        }
                                    }
                                    if (z3) {
                                    }
                                }
                            } else if (i5 != 0) {
                                zznoVar.g(i5);
                            }
                        }
                    }
                }
                return false;
            }
            z = false;
            if (!z3) {
            }
            return false;
        }
    }
}
