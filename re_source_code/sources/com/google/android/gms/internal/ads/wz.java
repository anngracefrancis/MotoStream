package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class wz {
    public static zzix a(zzir zzirVar, zzis zzisVar) {
        boolean z;
        boolean z2;
        long jK;
        int i2;
        int i3;
        int i4;
        int i5;
        zzir zzirVarD = zzirVar.d(vz.s);
        zzkm zzkmVar = zzirVarD.c(vz.B).b0;
        zzkmVar.g(16);
        int iC = zzkmVar.c();
        if (iC != 1936684398 && iC != 1986618469 && iC != 1952807028 && iC != 1953325924) {
            return null;
        }
        zzkm zzkmVar2 = zzirVar.c(vz.z).b0;
        zzkmVar2.g(8);
        int iA = vz.a(zzkmVar2.c());
        zzkmVar2.h(iA == 0 ? 8 : 16);
        int iC2 = zzkmVar2.c();
        zzkmVar2.h(4);
        int iA2 = zzkmVar2.a();
        int i6 = iA == 0 ? 4 : 8;
        int i7 = 0;
        while (true) {
            z = true;
            if (i7 >= i6) {
                z2 = true;
                break;
            }
            if (zzkmVar2.a[iA2 + i7] != -1) {
                z2 = false;
                break;
            }
            i7++;
        }
        if (z2) {
            zzkmVar2.h(i6);
            jK = -1;
        } else {
            jK = iA == 0 ? zzkmVar2.k() : zzkmVar2.n();
        }
        Pair pairCreate = Pair.create(Integer.valueOf(iC2), Long.valueOf(jK));
        int iIntValue = ((Integer) pairCreate.first).intValue();
        long jLongValue = ((Long) pairCreate.second).longValue();
        zzkm zzkmVar3 = zzisVar.b0;
        zzkmVar3.g(8);
        zzkmVar3.h(vz.a(zzkmVar3.c()) == 0 ? 8 : 16);
        long jB = jLongValue == -1 ? -1L : zzkq.b(jLongValue, 1000000L, zzkmVar3.k());
        zzir zzirVarD2 = zzirVarD.d(vz.t).d(vz.u);
        zzkm zzkmVar4 = zzirVarD.c(vz.A).b0;
        zzkmVar4.g(8);
        zzkmVar4.h(vz.a(zzkmVar4.c()) != 0 ? 16 : 8);
        long jK2 = zzkmVar4.k();
        zzkm zzkmVar5 = zzirVarD2.c(vz.C).b0;
        zzkmVar5.g(12);
        int iC3 = zzkmVar5.c();
        xz xzVar = new xz(iC3);
        int i8 = 0;
        while (i8 < iC3) {
            int iA3 = zzkmVar5.a();
            int iC4 = zzkmVar5.c();
            zzkh.b(iC4 > 0, "childAtomSize should be positive");
            int iC5 = zzkmVar5.c();
            if (iC5 == vz.f13474b || iC5 == vz.f13475c || iC5 == vz.I) {
                i2 = iC3;
                i3 = iIntValue;
                i4 = iC;
                i5 = iC4;
                zzkmVar5.g(iA3 + 8);
                zzkmVar5.h(24);
                int iF = zzkmVar5.f();
                int iF2 = zzkmVar5.f();
                zzkmVar5.h(50);
                int iA4 = zzkmVar5.a();
                float fM = 1.0f;
                List list = null;
                while (iA4 - iA3 < i5) {
                    zzkmVar5.g(iA4);
                    int iA5 = zzkmVar5.a();
                    int iC6 = zzkmVar5.c();
                    if (iC6 == 0 && zzkmVar5.a() - iA3 == i5) {
                        break;
                    }
                    zzkh.b(iC6 > 0, "childAtomSize should be positive");
                    int iC7 = zzkmVar5.c();
                    if (iC7 == vz.v) {
                        zzkmVar5.g(iA5 + 8 + 4);
                        int iE = (zzkmVar5.e() & 3) + 1;
                        if (iE == 3) {
                            throw new IllegalStateException();
                        }
                        ArrayList arrayList = new ArrayList();
                        int iE2 = zzkmVar5.e() & 31;
                        for (int i9 = 0; i9 < iE2; i9++) {
                            arrayList.add(zzkj.a(zzkmVar5));
                        }
                        int iE3 = zzkmVar5.e();
                        for (int i10 = 0; i10 < iE3; i10++) {
                            arrayList.add(zzkj.a(zzkmVar5));
                        }
                        Pair pairCreate2 = Pair.create(arrayList, Integer.valueOf(iE));
                        list = (List) pairCreate2.first;
                        xzVar.f13588c = ((Integer) pairCreate2.second).intValue();
                    } else if (iC7 == vz.E) {
                        xzVar.a[i8] = b(zzkmVar5, iA5, iC6);
                    } else if (iC7 == vz.O) {
                        zzkmVar5.g(iA5 + 8);
                        fM = zzkmVar5.m() / zzkmVar5.m();
                    }
                    iA4 += iC6;
                }
                z = true;
                xzVar.f13587b = zzhj.d("video/avc", -1, jB, iF, iF2, fM, list);
            } else {
                if (iC5 == vz.f13478f || iC5 == vz.J || iC5 == vz.f13479g) {
                    i2 = iC3;
                    i5 = iC4;
                    zzkmVar5.g(iA3 + 8);
                    zzkmVar5.h(16);
                    int iF3 = zzkmVar5.f();
                    int iF4 = zzkmVar5.f();
                    zzkmVar5.h(4);
                    int iL = zzkmVar5.l();
                    int iA6 = zzkmVar5.a();
                    int iIntValue2 = iF3;
                    int iIntValue3 = iL;
                    byte[] bArrC = null;
                    while (true) {
                        if (iA6 - iA3 >= i5) {
                            i3 = iIntValue;
                            i4 = iC;
                            xzVar.f13587b = zzhj.g(iC5 == vz.f13479g ? "audio/ac3" : iC5 == vz.f13481i ? "audio/eac3" : "audio/mp4a-latm", iF4, jB, iIntValue2, iIntValue3, bArrC == null ? null : Collections.singletonList(bArrC));
                            break;
                        }
                        zzkmVar5.g(iA6);
                        int iA7 = zzkmVar5.a();
                        int iC8 = zzkmVar5.c();
                        i4 = iC;
                        zzkh.b(iC8 > 0, "childAtomSize should be positive");
                        int iC9 = zzkmVar5.c();
                        i3 = iIntValue;
                        if (iC5 != vz.f13478f && iC5 != vz.J) {
                            if (iC5 != vz.f13479g || iC9 != vz.f13480h) {
                                if (iC5 == vz.f13481i && iC9 == vz.f13482j) {
                                    zzkmVar5.g(iA7 + 8);
                                    xzVar.f13587b = zzkg.c(zzkmVar5);
                                    break;
                                }
                            } else {
                                zzkmVar5.g(iA7 + 8);
                                xzVar.f13587b = zzkg.b(zzkmVar5);
                                break;
                            }
                        } else if (iC9 == vz.f13476d) {
                            bArrC = c(zzkmVar5, iA7);
                            Pair<Integer, Integer> pairB = zzki.b(bArrC);
                            iIntValue3 = ((Integer) pairB.first).intValue();
                            iIntValue2 = ((Integer) pairB.second).intValue();
                        } else if (iC9 == vz.E) {
                            xzVar.a[i8] = b(zzkmVar5, iA7, iC8);
                        }
                        iA6 += iC8;
                        iC = i4;
                        iIntValue = i3;
                    }
                } else if (iC5 == vz.P) {
                    xzVar.f13587b = zzhj.h();
                    i2 = iC3;
                    i3 = iIntValue;
                    i4 = iC;
                    i5 = iC4;
                } else if (iC5 == vz.S) {
                    zzkmVar5.g(iA3 + 8);
                    zzkmVar5.h(24);
                    int iF5 = zzkmVar5.f();
                    int iF6 = zzkmVar5.f();
                    zzkmVar5.h(50);
                    ArrayList arrayList2 = new ArrayList(z ? 1 : 0);
                    int iA8 = zzkmVar5.a();
                    while (iA8 - iA3 < iC4) {
                        zzkmVar5.g(iA8);
                        int iA9 = zzkmVar5.a();
                        int iC10 = zzkmVar5.c();
                        if (iC10 <= 0) {
                            z = false;
                        }
                        zzkh.b(z, "childAtomSize should be positive");
                        int i11 = iC3;
                        if (zzkmVar5.c() == vz.f13476d) {
                            arrayList2.add(c(zzkmVar5, iA9));
                        }
                        iA8 += iC10;
                        iC3 = i11;
                        z = true;
                    }
                    i2 = iC3;
                    i5 = iC4;
                    xzVar.f13587b = zzhj.e("video/mp4v-es", -1, jB, iF5, iF6, arrayList2);
                    i3 = iIntValue;
                    i4 = iC;
                } else {
                    i2 = iC3;
                    i5 = iC4;
                    i3 = iIntValue;
                    i4 = iC;
                }
                z = true;
            }
            zzkmVar5.g(iA3 + i5);
            i8++;
            iC3 = i2;
            iC = i4;
            iIntValue = i3;
        }
        return new zzix(iIntValue, iC, jK2, jB, xzVar.f13587b, xzVar.a, xzVar.f13588c);
    }

    private static zziy b(zzkm zzkmVar, int i2, int i3) {
        int i4 = i2 + 8;
        zziy zziyVar = null;
        while (i4 - i2 < i3) {
            zzkmVar.g(i4);
            int iC = zzkmVar.c();
            int iC2 = zzkmVar.c();
            if (iC2 == vz.K) {
                zzkmVar.c();
            } else if (iC2 == vz.F) {
                zzkmVar.h(4);
                zzkmVar.c();
                zzkmVar.c();
            } else if (iC2 == vz.G) {
                int i5 = i4 + 8;
                while (true) {
                    if (i5 - i4 >= iC) {
                        zziyVar = null;
                        break;
                    }
                    zzkmVar.g(i5);
                    int iC3 = zzkmVar.c();
                    if (zzkmVar.c() == vz.H) {
                        zzkmVar.h(4);
                        int iC4 = zzkmVar.c();
                        boolean z = (iC4 >> 8) == 1;
                        byte[] bArr = new byte[16];
                        zzkmVar.j(bArr, 0, 16);
                        zziyVar = new zziy(z, iC4 & 255, bArr);
                        break;
                    }
                    i5 += iC3;
                }
            }
            i4 += iC;
        }
        return zziyVar;
    }

    private static byte[] c(zzkm zzkmVar, int i2) {
        zzkmVar.g(i2 + 8 + 4);
        zzkmVar.h(1);
        int iE = zzkmVar.e();
        while (iE > 127) {
            iE = zzkmVar.e();
        }
        zzkmVar.h(2);
        int iE2 = zzkmVar.e();
        if ((iE2 & 128) != 0) {
            zzkmVar.h(2);
        }
        if ((iE2 & 64) != 0) {
            zzkmVar.h(zzkmVar.f());
        }
        if ((iE2 & 32) != 0) {
            zzkmVar.h(2);
        }
        zzkmVar.h(1);
        int iE3 = zzkmVar.e();
        while (iE3 > 127) {
            iE3 = zzkmVar.e();
        }
        zzkmVar.h(13);
        zzkmVar.h(1);
        int iE4 = zzkmVar.e();
        int i3 = iE4 & 127;
        while (iE4 > 127) {
            iE4 = zzkmVar.e();
            i3 = (i3 << 8) | (iE4 & 127);
        }
        byte[] bArr = new byte[i3];
        zzkmVar.j(bArr, 0, i3);
        return bArr;
    }
}
