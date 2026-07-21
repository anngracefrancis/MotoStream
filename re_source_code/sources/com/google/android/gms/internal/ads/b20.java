package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import cm.aptoide.pt.root.execution.Command;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class b20 {
    private static final int a = zzsy.i("vide");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f12300b = zzsy.i("soun");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12301c = zzsy.i(Command.CommandHandler.TEXT);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f12302d = zzsy.i("sbtl");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f12303e = zzsy.i("subt");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f12304f = zzsy.i("clcp");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f12305g = zzsy.i("cenc");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f12306h = zzsy.i("meta");

    private static int a(zzst zzstVar, int i2, int i3, e20 e20Var, int i4) {
        int iB = zzstVar.b();
        while (true) {
            if (iB - i2 >= i3) {
                return 0;
            }
            zzstVar.k(iB);
            int iD = zzstVar.d();
            zzsk.b(iD > 0, "childAtomSize should be positive");
            if (zzstVar.d() == y10.V) {
                int i5 = iB + 8;
                Pair pairCreate = null;
                Integer numValueOf = null;
                zzpb zzpbVar = null;
                boolean z = false;
                while (i5 - iB < iD) {
                    zzstVar.k(i5);
                    int iD2 = zzstVar.d();
                    int iD3 = zzstVar.d();
                    if (iD3 == y10.b0) {
                        numValueOf = Integer.valueOf(zzstVar.d());
                    } else if (iD3 == y10.W) {
                        zzstVar.l(4);
                        z = zzstVar.d() == f12305g;
                    } else if (iD3 == y10.X) {
                        int i6 = i5 + 8;
                        while (true) {
                            if (i6 - i5 >= iD2) {
                                zzpbVar = null;
                                break;
                            }
                            zzstVar.k(i6);
                            int iD4 = zzstVar.d();
                            if (zzstVar.d() == y10.Y) {
                                zzstVar.l(6);
                                boolean z2 = zzstVar.g() == 1;
                                int iG = zzstVar.g();
                                byte[] bArr = new byte[16];
                                zzstVar.n(bArr, 0, 16);
                                zzpbVar = new zzpb(z2, iG, bArr);
                                break;
                            }
                            i6 += iD4;
                        }
                    }
                    i5 += iD2;
                }
                if (z) {
                    zzsk.b(numValueOf != null, "frma atom is mandatory");
                    zzsk.b(zzpbVar != null, "schi->tenc atom is mandatory");
                    pairCreate = Pair.create(numValueOf, zzpbVar);
                }
                if (pairCreate != null) {
                    e20Var.a[i4] = (zzpb) pairCreate.second;
                    return ((Integer) pairCreate.first).intValue();
                }
            }
            iB += iD;
        }
    }

    /* JADX WARN: Code duplicated, block: B:273:0x044d  */
    /* JADX WARN: Code duplicated, block: B:275:0x0462  */
    /* JADX WARN: Code duplicated, block: B:276:0x047d  */
    /* JADX WARN: Code duplicated, block: B:291:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:293:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:297:0x0512  */
    /* JADX WARN: Code duplicated, block: B:299:0x051f  */
    /* JADX WARN: Code duplicated, block: B:302:0x0528  */
    /* JADX WARN: Code duplicated, block: B:303:0x052a  */
    /* JADX WARN: Code duplicated, block: B:306:0x0536 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:307:0x0538  */
    /* JADX WARN: Code duplicated, block: B:308:0x053a  */
    /* JADX WARN: Code duplicated, block: B:311:0x054f  */
    /* JADX WARN: Code duplicated, block: B:313:0x0556  */
    /* JADX WARN: Code duplicated, block: B:315:0x055a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:316:0x055c  */
    /* JADX WARN: Code duplicated, block: B:317:0x055e  */
    /* JADX WARN: Code duplicated, block: B:321:0x057a  */
    /* JADX WARN: Code duplicated, block: B:323:0x057e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:324:0x0580  */
    /* JADX WARN: Code duplicated, block: B:325:0x0582  */
    /* JADX WARN: Code duplicated, block: B:328:0x058a  */
    /* JADX WARN: Code duplicated, block: B:329:0x058d  */
    /* JADX WARN: Code duplicated, block: B:331:0x0592  */
    /* JADX WARN: Code duplicated, block: B:333:0x0596 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:334:0x0598  */
    /* JADX WARN: Code duplicated, block: B:335:0x059a  */
    /* JADX WARN: Code duplicated, block: B:338:0x05a3  */
    /* JADX WARN: Code duplicated, block: B:340:0x05a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:341:0x05a9  */
    /* JADX WARN: Code duplicated, block: B:342:0x05ab  */
    /* JADX WARN: Code duplicated, block: B:344:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:346:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:347:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:349:0x05e0  */
    /* JADX WARN: Code duplicated, block: B:352:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:355:0x05ff A[LOOP:5: B:350:0x05e2->B:355:0x05ff, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:358:0x060c  */
    /* JADX WARN: Code duplicated, block: B:360:0x0612  */
    /* JADX WARN: Code duplicated, block: B:362:0x061c  */
    /* JADX WARN: Code duplicated, block: B:364:0x0622  */
    /* JADX WARN: Code duplicated, block: B:366:0x0625  */
    /* JADX WARN: Code duplicated, block: B:368:0x0628 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:370:0x062b  */
    /* JADX WARN: Code duplicated, block: B:371:0x062e  */
    /* JADX WARN: Code duplicated, block: B:372:0x0631  */
    /* JADX WARN: Code duplicated, block: B:373:0x0634  */
    /* JADX WARN: Code duplicated, block: B:377:0x0641  */
    /* JADX WARN: Code duplicated, block: B:400:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:403:0x06e6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:404:0x06e7  */
    /* JADX WARN: Code duplicated, block: B:412:0x0659 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:416:0x047f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:425:0x0636 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:429:0x0636 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:430:0x05f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:431:0x0605 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00cd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:61:0x00d6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:74:0x010d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0139  */
    /* JADX WARN: Code duplicated, block: B:78:0x013c  */
    /* JADX WARN: Code duplicated, block: B:81:0x0147  */
    /* JADX WARN: Code duplicated, block: B:82:0x0149  */
    /* JADX WARN: Code duplicated, block: B:85:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b0  */
    public static zzpa b(z10 z10Var, a20 a20Var, long j2, zzne zzneVar, boolean z) throws zzlm {
        int i2;
        boolean z2;
        long jQ;
        int iD;
        int i3;
        h20 h20Var;
        zzst zzstVar;
        int i4;
        long jQ2;
        long jC;
        int iB;
        int i5;
        int i6;
        Pair pairCreate;
        zzst zzstVar2;
        int i7;
        int i8;
        int iD2;
        e20 e20Var;
        int i9;
        Pair pair;
        h20 h20Var2;
        int i10;
        z10 z10VarE;
        zzpa zzpaVar;
        Pair pairCreate2;
        a20 a20VarD;
        int iB2;
        int iD3;
        boolean z3;
        String str;
        int iD4;
        Pair pair2;
        h20 h20Var3;
        int i11;
        int i12;
        int i13;
        int iH;
        int iH2;
        int iB3;
        boolean z4;
        String str2;
        List<byte[]> listSingletonList;
        float fS;
        byte[] bArr;
        int i14;
        int iB4;
        int iD5;
        boolean z5;
        int iD6;
        String str3;
        int iG;
        int iG2;
        int i15;
        byte[] bArrCopyOfRange;
        int iD7;
        boolean z6;
        boolean z7;
        boolean z8;
        String str4;
        boolean z9;
        List<byte[]> list;
        boolean z10;
        zzta zztaVarA;
        int i16;
        int iRound;
        int iS;
        String str5;
        String str6;
        int iB5;
        int i17;
        int i18;
        String str7;
        String str8;
        String str9;
        long j3;
        List listSingletonList2;
        z10 z10VarE2 = z10Var.e(y10.E);
        zzst zzstVar3 = z10VarE2.d(y10.S).Q0;
        zzstVar3.k(16);
        int iD8 = zzstVar3.d();
        if (iD8 == f12300b) {
            i2 = 1;
        } else if (iD8 == a) {
            i2 = 2;
        } else if (iD8 == f12301c || iD8 == f12302d || iD8 == f12303e || iD8 == f12304f) {
            i2 = 3;
        } else {
            i2 = iD8 == f12306h ? 4 : -1;
        }
        if (i2 == -1) {
            return null;
        }
        zzst zzstVar4 = z10Var.d(y10.O).Q0;
        zzstVar4.k(8);
        int iB6 = y10.b(zzstVar4.d());
        zzstVar4.l(iB6 == 0 ? 8 : 16);
        int iD9 = zzstVar4.d();
        zzstVar4.l(4);
        int iB7 = zzstVar4.b();
        int i19 = iB6 == 0 ? 4 : 8;
        int i20 = 0;
        while (true) {
            if (i20 >= i19) {
                z2 = true;
                break;
            }
            if (zzstVar4.a[iB7 + i20] != -1) {
                z2 = false;
                break;
            }
            i20++;
        }
        if (!z2) {
            jQ = iB6 == 0 ? zzstVar4.q() : zzstVar4.t();
            if (jQ == 0) {
            }
            zzstVar4.l(16);
            iD = zzstVar4.d();
            int iD10 = zzstVar4.d();
            zzstVar4.l(4);
            int iD11 = zzstVar4.d();
            int iD12 = zzstVar4.d();
            if (iD != 0 && iD10 == 65536 && iD11 == -65536 && iD12 == 0) {
                i3 = 90;
            } else if (iD != 0 && iD10 == -65536 && iD11 == 65536 && iD12 == 0) {
                i3 = 270;
            } else if (iD != -65536 && iD10 == 0 && iD11 == 0 && iD12 == -65536) {
                i3 = 180;
            } else {
                i3 = 0;
            }
            h20Var = new h20(iD9, jQ, i3);
            long j4 = h20Var.f12682b;
            zzstVar = a20Var.Q0;
            zzstVar.k(8);
            if (y10.b(zzstVar.d()) == 0) {
                i4 = 8;
            } else {
                i4 = 16;
            }
            zzstVar.l(i4);
            jQ2 = zzstVar.q();
            jC = j4 != -9223372036854775807L ? zzsy.c(j4, 1000000L, jQ2) : -9223372036854775807L;
            z10 z10VarE3 = z10VarE2.e(y10.F).e(y10.G);
            zzst zzstVar5 = z10VarE2.d(y10.R).Q0;
            zzstVar5.k(8);
            iB = y10.b(zzstVar5.d());
            if (iB == 0) {
                i5 = 8;
            } else {
                i5 = 16;
            }
            zzstVar5.l(i5);
            long jQ3 = zzstVar5.q();
            if (iB == 0) {
                i6 = 4;
            } else {
                i6 = 8;
            }
            zzstVar5.l(i6);
            int iH3 = zzstVar5.h();
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) (((iH3 >> 10) & 31) + 96));
            sb.append((char) (((iH3 >> 5) & 31) + 96));
            sb.append((char) ((iH3 & 31) + 96));
            pairCreate = Pair.create(Long.valueOf(jQ3), sb.toString());
            zzstVar2 = z10VarE3.d(y10.T).Q0;
            i7 = h20Var.a;
            i8 = h20Var.f12683c;
            String str10 = (String) pairCreate.second;
            zzstVar2.k(12);
            iD2 = zzstVar2.d();
            e20Var = new e20(iD2);
            i9 = 0;
            while (i9 < iD2) {
                iB2 = zzstVar2.b();
                iD3 = zzstVar2.d();
                if (iD3 > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                str = "childAtomSize should be positive";
                zzsk.b(z3, "childAtomSize should be positive");
                iD4 = zzstVar2.d();
                if (iD4 != y10.f13593b || iD4 == y10.f13594c || iD4 == y10.Z || iD4 == y10.l0 || iD4 == y10.f13595d || iD4 == y10.f13596e || iD4 == y10.f13597f || iD4 == y10.K0 || iD4 == y10.L0) {
                    pair2 = pairCreate;
                    h20Var3 = h20Var;
                    i11 = i8;
                    i12 = iD2;
                    i13 = i2;
                    zzstVar2.k(iB2 + 8 + 8);
                    zzstVar2.l(16);
                    iH = zzstVar2.h();
                    iH2 = zzstVar2.h();
                    zzstVar2.l(50);
                    iB3 = zzstVar2.b();
                    if (iD4 == y10.Z) {
                        iD4 = a(zzstVar2, iB2, iD3, e20Var, i9);
                        zzstVar2.k(iB3);
                    }
                    z4 = false;
                    str2 = null;
                    listSingletonList = null;
                    fS = 1.0f;
                    bArr = null;
                    i14 = -1;
                    while (iB3 - iB2 < iD3) {
                        zzstVar2.k(iB3);
                        iB4 = zzstVar2.b();
                        iD5 = zzstVar2.d();
                        if (iD5 != 0 && zzstVar2.b() - iB2 == iD3) {
                            break;
                        }
                        if (iD5 > 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        zzsk.b(z5, str);
                        iD6 = zzstVar2.d();
                        if (iD6 == y10.H) {
                            if (str2 == null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            zzsk.e(z10);
                            zzstVar2.k(iB4 + 8);
                            zztaVarA = zzta.a(zzstVar2);
                            list = zztaVarA.a;
                            e20Var.f12502c = zztaVarA.f16748b;
                            if (!z4) {
                                fS = zztaVarA.f16751e;
                            }
                            str2 = "video/avc";
                        } else {
                            if (iD6 == y10.I) {
                                if (str2 == null) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                zzsk.e(z9);
                                zzstVar2.k(iB4 + 8);
                                zztg zztgVarA = zztg.a(zzstVar2);
                                list = zztgVarA.a;
                                e20Var.f12502c = zztgVarA.f16762b;
                                str2 = "video/hevc";
                            } else {
                                if (iD6 == y10.M0) {
                                    if (str2 == null) {
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                    zzsk.e(z8);
                                    if (iD4 == y10.K0) {
                                        str4 = "video/x-vnd.on2.vp8";
                                    } else {
                                        str4 = "video/x-vnd.on2.vp9";
                                    }
                                    str2 = str4;
                                } else if (iD6 == y10.f13598g) {
                                    if (str2 == null) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    zzsk.e(z7);
                                    str2 = "video/3gpp";
                                } else if (iD6 == y10.J) {
                                    if (str2 == null) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    zzsk.e(z6);
                                    Pair<String, byte[]> pairE = e(zzstVar2, iB4);
                                    str2 = (String) pairE.first;
                                    listSingletonList = Collections.singletonList((byte[]) pairE.second);
                                } else if (iD6 == y10.i0) {
                                    zzstVar2.k(iB4 + 8);
                                    fS = zzstVar2.s() / zzstVar2.s();
                                    str3 = str;
                                    z4 = true;
                                } else if (iD6 == y10.I0) {
                                    i15 = iB4 + 8;
                                    while (true) {
                                        if (i15 - iB4 >= iD5) {
                                            str3 = str;
                                            bArrCopyOfRange = null;
                                            break;
                                        }
                                        zzstVar2.k(i15);
                                        iD7 = zzstVar2.d();
                                        str3 = str;
                                        if (zzstVar2.d() == y10.J0) {
                                            bArrCopyOfRange = Arrays.copyOfRange(zzstVar2.a, i15, iD7 + i15);
                                            break;
                                        }
                                        i15 += iD7;
                                        str = str3;
                                    }
                                    bArr = bArrCopyOfRange;
                                } else {
                                    str3 = str;
                                    if (iD6 == y10.H0) {
                                        iG = zzstVar2.g();
                                        zzstVar2.l(3);
                                        if (iG == 0) {
                                            iG2 = zzstVar2.g();
                                            if (iG2 == 0) {
                                                i14 = 0;
                                            } else if (iG2 == 1) {
                                                i14 = 1;
                                            } else if (iG2 == 2) {
                                                i14 = 2;
                                            } else if (iG2 == 3) {
                                                i14 = 3;
                                            }
                                        }
                                    }
                                }
                                str3 = str;
                            }
                            iB3 += iD5;
                            str = str3;
                        }
                        str3 = str;
                        listSingletonList = list;
                        iB3 += iD5;
                        str = str3;
                    }
                    if (str2 != null) {
                        e20Var.f12501b = zzlh.b(Integer.toString(i7), str2, null, -1, -1, iH, iH2, -1.0f, listSingletonList, i11, fS, bArr, i14, null, null);
                    }
                } else {
                    if (iD4 == y10.f13600i || iD4 == y10.a0 || iD4 == y10.n || iD4 == y10.p || iD4 == y10.r || iD4 == y10.u || iD4 == y10.s || iD4 == y10.t || iD4 == y10.y0 || iD4 == y10.z0 || iD4 == y10.l || iD4 == y10.m || iD4 == y10.f13601j || iD4 == y10.O0) {
                        i12 = iD2;
                        zzstVar2.k(iB2 + 8 + 8);
                        if (z) {
                            int iH4 = zzstVar2.h();
                            zzstVar2.l(6);
                            i16 = iH4;
                        } else {
                            zzstVar2.l(8);
                            i16 = 0;
                        }
                        if (i16 == 0 || i16 == 1) {
                            int iH5 = zzstVar2.h();
                            zzstVar2.l(6);
                            int iR = zzstVar2.r();
                            if (i16 == 1) {
                                zzstVar2.l(16);
                            }
                            iRound = iR;
                            iS = iH5;
                        } else if (i16 == 2) {
                            zzstVar2.l(16);
                            iRound = (int) Math.round(Double.longBitsToDouble(zzstVar2.e()));
                            iS = zzstVar2.s();
                            zzstVar2.l(20);
                        }
                        int iB8 = zzstVar2.b();
                        int i21 = iRound;
                        if (iD4 == y10.a0) {
                            iD4 = a(zzstVar2, iB2, iD3, e20Var, i9);
                            zzstVar2.k(iB8);
                        }
                        if (iD4 == y10.n) {
                            str5 = "audio/ac3";
                        } else if (iD4 == y10.p) {
                            str5 = "audio/eac3";
                        } else if (iD4 == y10.r) {
                            str5 = "audio/vnd.dts";
                        } else if (iD4 == y10.s || iD4 == y10.t) {
                            str5 = "audio/vnd.dts.hd";
                        } else if (iD4 == y10.u) {
                            str5 = "audio/vnd.dts.hd;profile=lbr";
                        } else if (iD4 == y10.y0) {
                            str5 = "audio/3gpp";
                        } else if (iD4 == y10.z0) {
                            str5 = "audio/amr-wb";
                        } else if (iD4 == y10.l || iD4 == y10.m) {
                            str5 = "audio/raw";
                        } else if (iD4 == y10.f13601j) {
                            str5 = "audio/mpeg";
                        } else {
                            str5 = iD4 == y10.O0 ? "audio/alac" : null;
                        }
                        i13 = i2;
                        byte[] bArr2 = null;
                        int i22 = iS;
                        String str11 = str5;
                        int i23 = iB8;
                        int i24 = i21;
                        int iIntValue = i22;
                        while (i23 - iB2 < iD3) {
                            zzstVar2.k(i23);
                            int iD13 = zzstVar2.d();
                            Pair pair3 = pairCreate;
                            zzsk.b(iD13 > 0, "childAtomSize should be positive");
                            int iD14 = zzstVar2.d();
                            h20 h20Var4 = h20Var;
                            int i25 = y10.J;
                            if (iD14 == i25 || (z && iD14 == y10.f13602k)) {
                                boolean z11 = false;
                                if (iD14 == i25) {
                                    i17 = i8;
                                    iB5 = i23;
                                } else {
                                    iB5 = zzstVar2.b();
                                    while (true) {
                                        if (iB5 - i23 >= iD13) {
                                            i17 = i8;
                                            i18 = -1;
                                            iB5 = -1;
                                            break;
                                        }
                                        zzstVar2.k(iB5);
                                        int iD15 = zzstVar2.d();
                                        if (iD15 > 0) {
                                            z11 = true;
                                        }
                                        zzsk.b(z11, "childAtomSize should be positive");
                                        i17 = i8;
                                        if (zzstVar2.d() != y10.J) {
                                            iB5 += iD15;
                                            i8 = i17;
                                            z11 = false;
                                        }
                                    }
                                    if (iB5 != i18) {
                                        Pair<String, byte[]> pairE2 = e(zzstVar2, iB5);
                                        str7 = (String) pairE2.first;
                                        bArr2 = (byte[]) pairE2.second;
                                        if ("audio/mp4a-latm".equals(str7)) {
                                            Pair<Integer, Integer> pairD = zzsl.d(bArr2);
                                            int iIntValue2 = ((Integer) pairD.first).intValue();
                                            iIntValue = ((Integer) pairD.second).intValue();
                                            str11 = str7;
                                            i24 = iIntValue2;
                                        } else {
                                            str11 = str7;
                                        }
                                    }
                                }
                                i18 = -1;
                                if (iB5 != i18) {
                                    Pair<String, byte[]> pairE3 = e(zzstVar2, iB5);
                                    str7 = (String) pairE3.first;
                                    bArr2 = (byte[]) pairE3.second;
                                    if ("audio/mp4a-latm".equals(str7)) {
                                        Pair<Integer, Integer> pairD2 = zzsl.d(bArr2);
                                        int iIntValue3 = ((Integer) pairD2.first).intValue();
                                        iIntValue = ((Integer) pairD2.second).intValue();
                                        str11 = str7;
                                        i24 = iIntValue3;
                                    } else {
                                        str11 = str7;
                                    }
                                }
                            } else {
                                if (iD14 == y10.o) {
                                    zzstVar2.k(i23 + 8);
                                    e20Var.f12501b = zzlv.a(zzstVar2, Integer.toString(i7), str10, null);
                                } else if (iD14 == y10.q) {
                                    zzstVar2.k(i23 + 8);
                                    e20Var.f12501b = zzlv.b(zzstVar2, Integer.toString(i7), str10, null);
                                } else if (iD14 == y10.v) {
                                    e20Var.f12501b = zzlh.d(Integer.toString(i7), str11, null, -1, -1, iIntValue, i24, null, null, 0, str10);
                                } else {
                                    if (iD14 == y10.O0) {
                                        byte[] bArr3 = new byte[iD13];
                                        zzstVar2.k(i23);
                                        zzstVar2.n(bArr3, 0, iD13);
                                        bArr2 = bArr3;
                                    }
                                    i17 = i8;
                                }
                                i17 = i8;
                            }
                            i23 += iD13;
                            pairCreate = pair3;
                            h20Var = h20Var4;
                            i8 = i17;
                        }
                        pair2 = pairCreate;
                        h20Var3 = h20Var;
                        i11 = i8;
                        if (e20Var.f12501b == null && (str6 = str11) != null) {
                            e20Var.f12501b = zzlh.c(Integer.toString(i7), str6, null, -1, -1, iIntValue, i24, "audio/raw".equals(str6) ? 2 : -1, bArr2 == null ? null : Collections.singletonList(bArr2), null, 0, str10);
                        }
                    } else {
                        int i26 = y10.j0;
                        if (iD4 == i26 || iD4 == y10.u0 || iD4 == y10.v0 || iD4 == y10.w0 || iD4 == y10.x0) {
                            i12 = iD2;
                            zzstVar2.k(iB2 + 8 + 8);
                            if (iD4 == i26) {
                                str9 = "application/ttml+xml";
                            } else {
                                if (iD4 == y10.u0) {
                                    int i27 = (iD3 - 8) - 8;
                                    byte[] bArr4 = new byte[i27];
                                    zzstVar2.n(bArr4, 0, i27);
                                    listSingletonList2 = Collections.singletonList(bArr4);
                                    str9 = "application/x-quicktime-tx3g";
                                    j3 = Long.MAX_VALUE;
                                } else {
                                    if (iD4 == y10.v0) {
                                        str8 = "application/x-mp4-vtt";
                                    } else {
                                        if (iD4 == y10.w0) {
                                            str9 = "application/ttml+xml";
                                            j3 = 0;
                                        } else {
                                            if (iD4 != y10.x0) {
                                                throw new IllegalStateException();
                                            }
                                            e20Var.f12503d = 1;
                                            str8 = "application/x-mp4-cea-608";
                                        }
                                        listSingletonList2 = null;
                                    }
                                    str9 = str8;
                                }
                                e20Var.f12501b = zzlh.e(Integer.toString(i7), str9, null, -1, 0, str10, -1, null, j3, listSingletonList2);
                            }
                            j3 = Long.MAX_VALUE;
                            listSingletonList2 = null;
                            e20Var.f12501b = zzlh.e(Integer.toString(i7), str9, null, -1, 0, str10, -1, null, j3, listSingletonList2);
                        } else if (iD4 == y10.N0) {
                            i12 = iD2;
                            e20Var.f12501b = zzlh.g(Integer.toString(i7), "application/x-camera-motion", null, -1, null);
                        } else {
                            i12 = iD2;
                        }
                    }
                    pair2 = pairCreate;
                    h20Var3 = h20Var;
                    i11 = i8;
                    i13 = i2;
                }
                zzstVar2.k(iB2 + iD3);
                i9++;
                iD2 = i12;
                i2 = i13;
                pairCreate = pair2;
                h20Var = h20Var3;
                i8 = i11;
            }
            pair = pairCreate;
            h20Var2 = h20Var;
            i10 = i2;
            z10VarE = z10Var.e(y10.P);
            if (z10VarE != null || (a20VarD = z10VarE.d(y10.Q)) == null) {
                zzpaVar = null;
                pairCreate2 = Pair.create(null, null);
            } else {
                zzst zzstVar6 = a20VarD.Q0;
                zzstVar6.k(8);
                int iB9 = y10.b(zzstVar6.d());
                int iS2 = zzstVar6.s();
                long[] jArr = new long[iS2];
                long[] jArr2 = new long[iS2];
                for (int i28 = 0; i28 < iS2; i28++) {
                    jArr[i28] = iB9 == 1 ? zzstVar6.t() : zzstVar6.q();
                    jArr2[i28] = iB9 == 1 ? zzstVar6.e() : zzstVar6.d();
                    if (zzstVar6.f() != 1) {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                    zzstVar6.l(2);
                }
                pairCreate2 = Pair.create(jArr, jArr2);
                zzpaVar = null;
            }
            if (e20Var.f12501b == null) {
                return zzpaVar;
            }
            return new zzpa(h20Var2.a, i10, ((Long) pair.first).longValue(), jQ2, jC, e20Var.f12501b, e20Var.f12503d, e20Var.a, e20Var.f12502c, (long[]) pairCreate2.first, (long[]) pairCreate2.second);
        }
        zzstVar4.l(i19);
        jQ = -9223372036854775807L;
        zzstVar4.l(16);
        iD = zzstVar4.d();
        int iD16 = zzstVar4.d();
        zzstVar4.l(4);
        int iD17 = zzstVar4.d();
        int iD18 = zzstVar4.d();
        if (iD != 0) {
            if (iD != 0) {
                if (iD != -65536) {
                    i3 = 0;
                } else {
                    i3 = 0;
                }
            } else if (iD != -65536) {
                i3 = 0;
            } else {
                i3 = 0;
            }
        } else if (iD != 0) {
            if (iD != -65536) {
                i3 = 0;
            } else {
                i3 = 0;
            }
        } else if (iD != -65536) {
            i3 = 0;
        } else {
            i3 = 0;
        }
        h20Var = new h20(iD9, jQ, i3);
        long j5 = h20Var.f12682b;
        zzstVar = a20Var.Q0;
        zzstVar.k(8);
        if (y10.b(zzstVar.d()) == 0) {
            i4 = 8;
        } else {
            i4 = 16;
        }
        zzstVar.l(i4);
        jQ2 = zzstVar.q();
        if (j5 != -9223372036854775807L) {
        }
        z10 z10VarE4 = z10VarE2.e(y10.F).e(y10.G);
        zzst zzstVar7 = z10VarE2.d(y10.R).Q0;
        zzstVar7.k(8);
        iB = y10.b(zzstVar7.d());
        if (iB == 0) {
            i5 = 8;
        } else {
            i5 = 16;
        }
        zzstVar7.l(i5);
        long jQ4 = zzstVar7.q();
        if (iB == 0) {
            i6 = 4;
        } else {
            i6 = 8;
        }
        zzstVar7.l(i6);
        int iH6 = zzstVar7.h();
        StringBuilder sb2 = new StringBuilder(3);
        sb2.append((char) (((iH6 >> 10) & 31) + 96));
        sb2.append((char) (((iH6 >> 5) & 31) + 96));
        sb2.append((char) ((iH6 & 31) + 96));
        pairCreate = Pair.create(Long.valueOf(jQ4), sb2.toString());
        zzstVar2 = z10VarE4.d(y10.T).Q0;
        i7 = h20Var.a;
        i8 = h20Var.f12683c;
        String str12 = (String) pairCreate.second;
        zzstVar2.k(12);
        iD2 = zzstVar2.d();
        e20Var = new e20(iD2);
        i9 = 0;
        while (i9 < iD2) {
            iB2 = zzstVar2.b();
            iD3 = zzstVar2.d();
            if (iD3 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            str = "childAtomSize should be positive";
            zzsk.b(z3, "childAtomSize should be positive");
            iD4 = zzstVar2.d();
            if (iD4 != y10.f13593b) {
                pair2 = pairCreate;
                h20Var3 = h20Var;
                i11 = i8;
                i12 = iD2;
                i13 = i2;
                zzstVar2.k(iB2 + 8 + 8);
                zzstVar2.l(16);
                iH = zzstVar2.h();
                iH2 = zzstVar2.h();
                zzstVar2.l(50);
                iB3 = zzstVar2.b();
                if (iD4 == y10.Z) {
                    iD4 = a(zzstVar2, iB2, iD3, e20Var, i9);
                    zzstVar2.k(iB3);
                }
                z4 = false;
                str2 = null;
                listSingletonList = null;
                fS = 1.0f;
                bArr = null;
                i14 = -1;
                while (iB3 - iB2 < iD3) {
                    zzstVar2.k(iB3);
                    iB4 = zzstVar2.b();
                    iD5 = zzstVar2.d();
                    if (iD5 != 0) {
                    }
                    if (iD5 > 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    zzsk.b(z5, str);
                    iD6 = zzstVar2.d();
                    if (iD6 == y10.H) {
                        if (str2 == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        zzsk.e(z10);
                        zzstVar2.k(iB4 + 8);
                        zztaVarA = zzta.a(zzstVar2);
                        list = zztaVarA.a;
                        e20Var.f12502c = zztaVarA.f16748b;
                        if (!z4) {
                            fS = zztaVarA.f16751e;
                        }
                        str2 = "video/avc";
                    } else {
                        if (iD6 == y10.I) {
                            if (str2 == null) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            zzsk.e(z9);
                            zzstVar2.k(iB4 + 8);
                            zztg zztgVarA2 = zztg.a(zzstVar2);
                            list = zztgVarA2.a;
                            e20Var.f12502c = zztgVarA2.f16762b;
                            str2 = "video/hevc";
                        } else {
                            if (iD6 == y10.M0) {
                                if (str2 == null) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                zzsk.e(z8);
                                if (iD4 == y10.K0) {
                                    str4 = "video/x-vnd.on2.vp8";
                                } else {
                                    str4 = "video/x-vnd.on2.vp9";
                                }
                                str2 = str4;
                            } else if (iD6 == y10.f13598g) {
                                if (str2 == null) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                zzsk.e(z7);
                                str2 = "video/3gpp";
                            } else if (iD6 == y10.J) {
                                if (str2 == null) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                zzsk.e(z6);
                                Pair<String, byte[]> pairE4 = e(zzstVar2, iB4);
                                str2 = (String) pairE4.first;
                                listSingletonList = Collections.singletonList((byte[]) pairE4.second);
                            } else if (iD6 == y10.i0) {
                                zzstVar2.k(iB4 + 8);
                                fS = zzstVar2.s() / zzstVar2.s();
                                str3 = str;
                                z4 = true;
                            } else if (iD6 == y10.I0) {
                                i15 = iB4 + 8;
                                while (true) {
                                    if (i15 - iB4 >= iD5) {
                                        str3 = str;
                                        bArrCopyOfRange = null;
                                        break;
                                    }
                                    zzstVar2.k(i15);
                                    iD7 = zzstVar2.d();
                                    str3 = str;
                                    if (zzstVar2.d() == y10.J0) {
                                        bArrCopyOfRange = Arrays.copyOfRange(zzstVar2.a, i15, iD7 + i15);
                                        break;
                                    }
                                    i15 += iD7;
                                    str = str3;
                                }
                                bArr = bArrCopyOfRange;
                            } else {
                                str3 = str;
                                if (iD6 == y10.H0) {
                                    iG = zzstVar2.g();
                                    zzstVar2.l(3);
                                    if (iG == 0) {
                                        iG2 = zzstVar2.g();
                                        if (iG2 == 0) {
                                            i14 = 0;
                                        } else if (iG2 == 1) {
                                            i14 = 1;
                                        } else if (iG2 == 2) {
                                            i14 = 2;
                                        } else if (iG2 == 3) {
                                            i14 = 3;
                                        }
                                    }
                                }
                            }
                            str3 = str;
                        }
                        iB3 += iD5;
                        str = str3;
                    }
                    str3 = str;
                    listSingletonList = list;
                    iB3 += iD5;
                    str = str3;
                }
                if (str2 != null) {
                    e20Var.f12501b = zzlh.b(Integer.toString(i7), str2, null, -1, -1, iH, iH2, -1.0f, listSingletonList, i11, fS, bArr, i14, null, null);
                }
            } else {
                pair2 = pairCreate;
                h20Var3 = h20Var;
                i11 = i8;
                i12 = iD2;
                i13 = i2;
                zzstVar2.k(iB2 + 8 + 8);
                zzstVar2.l(16);
                iH = zzstVar2.h();
                iH2 = zzstVar2.h();
                zzstVar2.l(50);
                iB3 = zzstVar2.b();
                if (iD4 == y10.Z) {
                    iD4 = a(zzstVar2, iB2, iD3, e20Var, i9);
                    zzstVar2.k(iB3);
                }
                z4 = false;
                str2 = null;
                listSingletonList = null;
                fS = 1.0f;
                bArr = null;
                i14 = -1;
                while (iB3 - iB2 < iD3) {
                    zzstVar2.k(iB3);
                    iB4 = zzstVar2.b();
                    iD5 = zzstVar2.d();
                    if (iD5 != 0) {
                    }
                    if (iD5 > 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    zzsk.b(z5, str);
                    iD6 = zzstVar2.d();
                    if (iD6 == y10.H) {
                        if (str2 == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        zzsk.e(z10);
                        zzstVar2.k(iB4 + 8);
                        zztaVarA = zzta.a(zzstVar2);
                        list = zztaVarA.a;
                        e20Var.f12502c = zztaVarA.f16748b;
                        if (!z4) {
                            fS = zztaVarA.f16751e;
                        }
                        str2 = "video/avc";
                    } else {
                        if (iD6 == y10.I) {
                            if (str2 == null) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            zzsk.e(z9);
                            zzstVar2.k(iB4 + 8);
                            zztg zztgVarA3 = zztg.a(zzstVar2);
                            list = zztgVarA3.a;
                            e20Var.f12502c = zztgVarA3.f16762b;
                            str2 = "video/hevc";
                        } else {
                            if (iD6 == y10.M0) {
                                if (str2 == null) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                zzsk.e(z8);
                                if (iD4 == y10.K0) {
                                    str4 = "video/x-vnd.on2.vp8";
                                } else {
                                    str4 = "video/x-vnd.on2.vp9";
                                }
                                str2 = str4;
                            } else if (iD6 == y10.f13598g) {
                                if (str2 == null) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                zzsk.e(z7);
                                str2 = "video/3gpp";
                            } else if (iD6 == y10.J) {
                                if (str2 == null) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                zzsk.e(z6);
                                Pair<String, byte[]> pairE5 = e(zzstVar2, iB4);
                                str2 = (String) pairE5.first;
                                listSingletonList = Collections.singletonList((byte[]) pairE5.second);
                            } else if (iD6 == y10.i0) {
                                zzstVar2.k(iB4 + 8);
                                fS = zzstVar2.s() / zzstVar2.s();
                                str3 = str;
                                z4 = true;
                            } else if (iD6 == y10.I0) {
                                i15 = iB4 + 8;
                                while (true) {
                                    if (i15 - iB4 >= iD5) {
                                        str3 = str;
                                        bArrCopyOfRange = null;
                                        break;
                                    }
                                    zzstVar2.k(i15);
                                    iD7 = zzstVar2.d();
                                    str3 = str;
                                    if (zzstVar2.d() == y10.J0) {
                                        bArrCopyOfRange = Arrays.copyOfRange(zzstVar2.a, i15, iD7 + i15);
                                        break;
                                    }
                                    i15 += iD7;
                                    str = str3;
                                }
                                bArr = bArrCopyOfRange;
                            } else {
                                str3 = str;
                                if (iD6 == y10.H0) {
                                    iG = zzstVar2.g();
                                    zzstVar2.l(3);
                                    if (iG == 0) {
                                        iG2 = zzstVar2.g();
                                        if (iG2 == 0) {
                                            i14 = 0;
                                        } else if (iG2 == 1) {
                                            i14 = 1;
                                        } else if (iG2 == 2) {
                                            i14 = 2;
                                        } else if (iG2 == 3) {
                                            i14 = 3;
                                        }
                                    }
                                }
                            }
                            str3 = str;
                        }
                        iB3 += iD5;
                        str = str3;
                    }
                    str3 = str;
                    listSingletonList = list;
                    iB3 += iD5;
                    str = str3;
                }
                if (str2 != null) {
                    e20Var.f12501b = zzlh.b(Integer.toString(i7), str2, null, -1, -1, iH, iH2, -1.0f, listSingletonList, i11, fS, bArr, i14, null, null);
                }
            }
            zzstVar2.k(iB2 + iD3);
            i9++;
            iD2 = i12;
            i2 = i13;
            pairCreate = pair2;
            h20Var = h20Var3;
            i8 = i11;
        }
        pair = pairCreate;
        h20Var2 = h20Var;
        i10 = i2;
        z10VarE = z10Var.e(y10.P);
        if (z10VarE != null) {
            zzpaVar = null;
            pairCreate2 = Pair.create(null, null);
        } else {
            zzpaVar = null;
            pairCreate2 = Pair.create(null, null);
        }
        if (e20Var.f12501b == null) {
            return zzpaVar;
        }
        return new zzpa(h20Var2.a, i10, ((Long) pair.first).longValue(), jQ2, jC, e20Var.f12501b, e20Var.f12503d, e20Var.a, e20Var.f12502c, (long[]) pairCreate2.first, (long[]) pairCreate2.second);
    }

    public static n20 c(zzpa zzpaVar, z10 z10Var, zznr zznrVar) throws zzlm {
        d20 g20Var;
        boolean z;
        int iS;
        int iS2;
        zzpa zzpaVar2;
        int i2;
        long[] jArr;
        int[] iArr;
        int i3;
        long[] jArr2;
        int[] iArr2;
        long j2;
        long j3;
        long[] jArr3;
        long[] jArr4;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        int i4;
        int iS3;
        int iS4;
        a20 a20VarD = z10Var.d(y10.q0);
        if (a20VarD != null) {
            g20Var = new f20(a20VarD);
        } else {
            a20 a20VarD2 = z10Var.d(y10.r0);
            if (a20VarD2 == null) {
                throw new zzlm("Track has no sample table size information");
            }
            g20Var = new g20(a20VarD2);
        }
        int iB = g20Var.b();
        if (iB == 0) {
            return new n20(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        a20 a20VarD3 = z10Var.d(y10.s0);
        if (a20VarD3 == null) {
            a20VarD3 = z10Var.d(y10.t0);
            z = true;
        } else {
            z = false;
        }
        zzst zzstVar = a20VarD3.Q0;
        zzst zzstVar2 = z10Var.d(y10.p0).Q0;
        zzst zzstVar3 = z10Var.d(y10.m0).Q0;
        a20 a20VarD4 = z10Var.d(y10.n0);
        zzst zzstVar4 = null;
        zzst zzstVar5 = a20VarD4 != null ? a20VarD4.Q0 : null;
        a20 a20VarD5 = z10Var.d(y10.o0);
        zzst zzstVar6 = a20VarD5 != null ? a20VarD5.Q0 : null;
        c20 c20Var = new c20(zzstVar2, zzstVar, z);
        zzstVar3.k(12);
        int iS5 = zzstVar3.s() - 1;
        int iS6 = zzstVar3.s();
        int iS7 = zzstVar3.s();
        if (zzstVar6 != null) {
            zzstVar6.k(12);
            iS = zzstVar6.s();
        } else {
            iS = 0;
        }
        int iS8 = -1;
        if (zzstVar5 != null) {
            zzstVar5.k(12);
            iS2 = zzstVar5.s();
            if (iS2 > 0) {
                iS8 = zzstVar5.s() - 1;
                zzstVar4 = zzstVar5;
            }
        } else {
            zzstVar4 = zzstVar5;
            iS2 = 0;
        }
        long j4 = 0;
        if (g20Var.a() && "audio/raw".equals(zzpaVar.f16561f.f16427k) && iS5 == 0 && iS == 0 && iS2 == 0) {
            zzpaVar2 = zzpaVar;
            i2 = iB;
            d20 d20Var = g20Var;
            int i5 = c20Var.a;
            long[] jArr5 = new long[i5];
            int[] iArr6 = new int[i5];
            while (c20Var.a()) {
                int i6 = c20Var.f12376b;
                jArr5[i6] = c20Var.f12378d;
                iArr6[i6] = c20Var.f12377c;
            }
            int iC = d20Var.c();
            long j5 = iS7;
            int i7 = 8192 / iC;
            int iJ = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                iJ += zzsy.j(iArr6[i8], i7);
            }
            long[] jArr6 = new long[iJ];
            int[] iArr7 = new int[iJ];
            long[] jArr7 = new long[iJ];
            int[] iArr8 = new int[iJ];
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int iMax = 0;
            while (i9 < i5) {
                int i12 = iArr6[i9];
                long j6 = jArr5[i9];
                int i13 = i5;
                int i14 = i12;
                while (i14 > 0) {
                    int iMin = Math.min(i7, i14);
                    jArr6[i11] = j6;
                    iArr7[i11] = iC * iMin;
                    iMax = Math.max(iMax, iArr7[i11]);
                    jArr7[i11] = ((long) i10) * j5;
                    iArr8[i11] = 1;
                    j6 += (long) iArr7[i11];
                    i10 += iMin;
                    i14 -= iMin;
                    i11++;
                    jArr5 = jArr5;
                    iArr6 = iArr6;
                }
                i9++;
                i5 = i13;
            }
            zzou zzouVar = new zzou(jArr6, iArr7, iMax, jArr7, iArr8);
            jArr = zzouVar.a;
            iArr = zzouVar.f16538b;
            i3 = zzouVar.f16539c;
            jArr2 = zzouVar.f16540d;
            iArr2 = zzouVar.f16541e;
            j2 = 0;
        } else {
            long[] jArr8 = new long[iB];
            iArr = new int[iB];
            jArr2 = new long[iB];
            int i15 = iS2;
            iArr2 = new int[iB];
            int iS9 = iS8;
            long j7 = 0;
            j2 = 0;
            int i16 = 0;
            i3 = 0;
            int iS10 = 0;
            int i17 = 0;
            int iD = 0;
            int i18 = iS;
            int i19 = iS7;
            int i20 = iS6;
            int i21 = iS5;
            int i22 = i15;
            while (i16 < iB) {
                while (i17 == 0) {
                    zzsk.e(c20Var.a());
                    j7 = c20Var.f12378d;
                    i17 = c20Var.f12377c;
                    i19 = i19;
                    i20 = i20;
                }
                int i23 = i20;
                int i24 = i19;
                if (zzstVar6 != null) {
                    while (iS10 == 0 && i18 > 0) {
                        iS10 = zzstVar6.s();
                        iD = zzstVar6.d();
                        i18--;
                    }
                    iS10--;
                }
                int i25 = iD;
                jArr8[i16] = j7;
                iArr[i16] = g20Var.c();
                if (iArr[i16] > i3) {
                    i3 = iArr[i16];
                }
                int i26 = iB;
                d20 d20Var2 = g20Var;
                jArr2[i16] = j2 + ((long) i25);
                iArr2[i16] = zzstVar4 == null ? 1 : 0;
                if (i16 == iS9) {
                    iArr2[i16] = 1;
                    i22--;
                    if (i22 > 0) {
                        iS9 = zzstVar4.s() - 1;
                    }
                }
                long[] jArr9 = jArr8;
                j2 += (long) i24;
                int i27 = i23 - 1;
                if (i27 != 0 || i21 <= 0) {
                    iS3 = i24;
                    iS4 = i27;
                } else {
                    iS4 = zzstVar3.s();
                    iS3 = zzstVar3.s();
                    i21--;
                }
                int i28 = iS4;
                j7 += (long) iArr[i16];
                i17--;
                i16++;
                iB = i26;
                jArr8 = jArr9;
                iS9 = iS9;
                iD = i25;
                i20 = i28;
                i19 = iS3;
                g20Var = d20Var2;
            }
            i2 = iB;
            long[] jArr10 = jArr8;
            int i29 = i20;
            zzsk.a(iS10 == 0);
            while (i18 > 0) {
                zzsk.a(zzstVar6.s() == 0);
                zzstVar6.d();
                i18--;
            }
            if (i22 == 0 && i29 == 0) {
                i4 = i17;
                if (i4 == 0 && i21 == 0) {
                    zzpaVar2 = zzpaVar;
                }
                jArr = jArr10;
            } else {
                i4 = i17;
            }
            zzpaVar2 = zzpaVar;
            int i30 = zzpaVar2.a;
            StringBuilder sb = new StringBuilder(215);
            sb.append("Inconsistent stbl box for track ");
            sb.append(i30);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i22);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i29);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i4);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i21);
            Log.w("AtomParsers", sb.toString());
            jArr = jArr10;
        }
        if (zzpaVar2.f16564i == null || zznrVar.c()) {
            int[] iArr9 = iArr;
            zzsy.f(jArr2, 1000000L, zzpaVar2.f16558c);
            return new n20(jArr, iArr9, i3, jArr2, iArr2);
        }
        long[] jArr11 = zzpaVar2.f16564i;
        if (jArr11.length == 1 && zzpaVar2.f16557b == 1 && jArr2.length >= 2) {
            long j8 = zzpaVar2.f16565j[0];
            long jC = zzsy.c(jArr11[0], zzpaVar2.f16558c, zzpaVar2.f16559d) + j8;
            if (jArr2[0] <= j8 && j8 < jArr2[1] && jArr2[jArr2.length - 1] < jC && jC <= j2) {
                long j9 = j2 - jC;
                long jC2 = zzsy.c(j8 - jArr2[0], zzpaVar2.f16561f.x, zzpaVar2.f16558c);
                long jC3 = zzsy.c(j9, zzpaVar2.f16561f.x, zzpaVar2.f16558c);
                if ((jC2 != 0 || jC3 != 0) && jC2 <= 2147483647L && jC3 <= 2147483647L) {
                    zznrVar.f16525c = (int) jC2;
                    zznrVar.f16526d = (int) jC3;
                    zzsy.f(jArr2, 1000000L, zzpaVar2.f16558c);
                    return new n20(jArr, iArr, i3, jArr2, iArr2);
                }
            }
        }
        long[] jArr12 = zzpaVar2.f16564i;
        if (jArr12.length == 1) {
            char c2 = 0;
            if (jArr12[0] == 0) {
                int i31 = 0;
                while (i31 < jArr2.length) {
                    jArr2[i31] = zzsy.c(jArr2[i31] - zzpaVar2.f16565j[c2], 1000000L, zzpaVar2.f16558c);
                    i31++;
                    c2 = 0;
                }
                return new n20(jArr, iArr, i3, jArr2, iArr2);
            }
        }
        boolean z2 = zzpaVar2.f16557b == 1;
        boolean z3 = false;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        while (true) {
            long[] jArr13 = zzpaVar2.f16564i;
            j3 = -1;
            if (i34 >= jArr13.length) {
                break;
            }
            int i35 = i3;
            int[] iArr10 = iArr;
            long j10 = zzpaVar2.f16565j[i34];
            if (j10 != -1) {
                long jC4 = zzsy.c(jArr13[i34], zzpaVar2.f16558c, zzpaVar2.f16559d);
                int iK = zzsy.k(jArr2, j10, true, true);
                int iK2 = zzsy.k(jArr2, j10 + jC4, z2, false);
                i32 += iK2 - iK;
                z3 |= i33 != iK;
                i33 = iK2;
            }
            i34++;
            iArr = iArr10;
            i3 = i35;
        }
        int i36 = i3;
        int[] iArr11 = iArr;
        boolean z4 = z3 | (i32 != i2);
        long[] jArr14 = z4 ? new long[i32] : jArr;
        int[] iArr12 = z4 ? new int[i32] : iArr11;
        int i37 = z4 ? 0 : i36;
        int[] iArr13 = z4 ? new int[i32] : iArr2;
        long[] jArr15 = new long[i32];
        int i38 = i37;
        int i39 = 0;
        int i40 = 0;
        while (true) {
            long[] jArr16 = zzpaVar2.f16564i;
            if (i39 >= jArr16.length) {
                break;
            }
            int[] iArr14 = iArr12;
            int[] iArr15 = iArr13;
            long j11 = zzpaVar2.f16565j[i39];
            long j12 = jArr16[i39];
            if (j11 != j3) {
                jArr3 = jArr14;
                jArr4 = jArr;
                long jC5 = zzsy.c(j12, zzpaVar2.f16558c, zzpaVar2.f16559d) + j11;
                int iK3 = zzsy.k(jArr2, j11, true, true);
                int iK4 = zzsy.k(jArr2, jC5, z2, false);
                if (z4) {
                    int i41 = iK4 - iK3;
                    System.arraycopy(jArr4, iK3, jArr3, i40, i41);
                    iArr4 = iArr11;
                    iArr3 = iArr14;
                    System.arraycopy(iArr4, iK3, iArr3, i40, i41);
                    iArr5 = iArr15;
                    System.arraycopy(iArr2, iK3, iArr5, i40, i41);
                } else {
                    iArr4 = iArr11;
                    iArr5 = iArr15;
                    iArr3 = iArr14;
                }
                int i42 = i38;
                while (iK3 < iK4) {
                    int[] iArr16 = iArr5;
                    int[] iArr17 = iArr4;
                    long j13 = j11;
                    jArr15[i40] = zzsy.c(j4, 1000000L, zzpaVar2.f16559d) + zzsy.c(jArr2[iK3] - j11, 1000000L, zzpaVar2.f16558c);
                    if (z4 && iArr3[i40] > i42) {
                        i42 = iArr17[iK3];
                    }
                    i40++;
                    iK3++;
                    iArr4 = iArr17;
                    j11 = j13;
                    iArr5 = iArr16;
                }
                iArr15 = iArr5;
                iArr11 = iArr4;
                i38 = i42;
            } else {
                jArr3 = jArr14;
                jArr4 = jArr;
                z2 = z2;
                iArr3 = iArr14;
            }
            j4 += j12;
            i39++;
            iArr12 = iArr3;
            jArr14 = jArr3;
            z2 = z2;
            iArr13 = iArr15;
            jArr = jArr4;
            j3 = -1;
        }
        long[] jArr17 = jArr14;
        int[] iArr18 = iArr12;
        int[] iArr19 = iArr13;
        boolean z5 = false;
        for (int i43 = 0; i43 < iArr19.length && !z5; i43++) {
            z5 |= (iArr19[i43] & 1) != 0;
        }
        if (z5) {
            return new n20(jArr17, iArr18, i38, jArr15, iArr19);
        }
        throw new zzlm("The edited sample sequence does not contain a sync sample.");
    }

    public static zzpo d(a20 a20Var, boolean z) {
        if (z) {
            return null;
        }
        zzst zzstVar = a20Var.Q0;
        zzstVar.k(8);
        while (zzstVar.u() >= 8) {
            int iB = zzstVar.b();
            int iD = zzstVar.d();
            if (zzstVar.d() == y10.B0) {
                zzstVar.k(iB);
                int i2 = iB + iD;
                zzstVar.l(12);
                while (zzstVar.b() < i2) {
                    int iB2 = zzstVar.b();
                    int iD2 = zzstVar.d();
                    if (zzstVar.d() == y10.C0) {
                        zzstVar.k(iB2);
                        int i3 = iB2 + iD2;
                        zzstVar.l(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzstVar.b() < i3) {
                            zzpo.zza zzaVarD = j20.d(zzstVar);
                            if (zzaVarD != null) {
                                arrayList.add(zzaVarD);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            break;
                        }
                        return new zzpo(arrayList);
                    }
                    zzstVar.l(iD2 - 8);
                }
                return null;
            }
            zzstVar.l(iD - 8);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    private static Pair<String, byte[]> e(zzst zzstVar, int i2) {
        zzstVar.k(i2 + 8 + 4);
        zzstVar.l(1);
        f(zzstVar);
        zzstVar.l(2);
        int iG = zzstVar.g();
        if ((iG & 128) != 0) {
            zzstVar.l(2);
        }
        if ((iG & 64) != 0) {
            zzstVar.l(zzstVar.h());
        }
        if ((iG & 32) != 0) {
            zzstVar.l(2);
        }
        zzstVar.l(1);
        f(zzstVar);
        int iG2 = zzstVar.g();
        String str = null;
        if (iG2 == 32) {
            str = "video/mp4v-es";
        } else if (iG2 == 33) {
            str = "video/avc";
        } else if (iG2 == 35) {
            str = "video/hevc";
        } else if (iG2 == 64) {
            str = "audio/mp4a-latm";
        } else {
            if (iG2 == 107) {
                return Pair.create("audio/mpeg", null);
            }
            if (iG2 == 165) {
                str = "audio/ac3";
            } else if (iG2 != 166) {
                switch (iG2) {
                    case 102:
                    case 103:
                    case 104:
                        str = "audio/mp4a-latm";
                        break;
                    default:
                        switch (iG2) {
                            case 169:
                            case 172:
                                return Pair.create("audio/vnd.dts", null);
                            case 170:
                            case 171:
                                return Pair.create("audio/vnd.dts.hd", null);
                        }
                }
            } else {
                str = "audio/eac3";
            }
        }
        zzstVar.l(12);
        zzstVar.l(1);
        int iF = f(zzstVar);
        byte[] bArr = new byte[iF];
        zzstVar.n(bArr, 0, iF);
        return Pair.create(str, bArr);
    }

    private static int f(zzst zzstVar) {
        int iG = zzstVar.g();
        int i2 = iG & 127;
        while ((iG & 128) == 128) {
            iG = zzstVar.g();
            i2 = (i2 << 7) | (iG & 127);
        }
        return i2;
    }
}
