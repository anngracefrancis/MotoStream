package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zzrg extends zzrj {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f16650f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzrn f16651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicReference<zzrh> f16652h;

    public zzrg() {
        this(null);
    }

    private static boolean g(zzlh zzlhVar, String str) {
        return str != null && TextUtils.equals(str, zzsy.l(zzlhVar.D));
    }

    private static int h(int i2, int i3) {
        if (i2 == -1) {
            return i3 == -1 ? 0 : -1;
        }
        if (i3 == -1) {
            return 1;
        }
        return i2 - i3;
    }

    private static boolean i(int i2, boolean z) {
        int i3 = i2 & 3;
        if (i3 != 3) {
            return z && i3 == 2;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:102:0x01af  */
    /* JADX WARN: Code duplicated, block: B:103:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:105:0x01c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:108:0x01c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:112:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:86:0x0182 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:89:0x018c  */
    /* JADX WARN: Code duplicated, block: B:91:0x0192  */
    /* JADX WARN: Code duplicated, block: B:92:0x0194  */
    /* JADX WARN: Code duplicated, block: B:95:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:97:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a6  */
    @Override // com.google.android.gms.internal.ads.zzrj
    protected final zzrm[] e(zzlp[] zzlpVarArr, zzrb[] zzrbVarArr, int[][][] iArr) throws zzku {
        int i2;
        zzrh zzrhVar;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        zzrb zzrbVar;
        zzrm[] zzrmVarArr;
        int i5;
        int i6;
        zzra zzraVar;
        boolean z3;
        int i7;
        boolean z4;
        int i8;
        int i9;
        int[] iArr2;
        zzra zzraVar2;
        int i10;
        boolean z5;
        int i11;
        boolean zI;
        boolean z6;
        int iH;
        int i12;
        int i13;
        boolean z7;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Point point;
        int i20;
        zzlp[] zzlpVarArr2 = zzlpVarArr;
        int length = zzlpVarArr2.length;
        zzrm[] zzrmVarArr2 = new zzrm[length];
        zzrh zzrhVar2 = this.f16652h.get();
        int i21 = 0;
        boolean z8 = false;
        while (i21 < length) {
            if (2 == zzlpVarArr2[i21].E()) {
                if (z8) {
                    zzrmVarArr = zzrmVarArr2;
                    i5 = i21;
                } else {
                    zzrb zzrbVar2 = zzrbVarArr[i21];
                    int[][] iArr3 = iArr[i21];
                    int i22 = zzrhVar2.f16656e;
                    int i23 = zzrhVar2.f16657f;
                    int i24 = zzrhVar2.f16658g;
                    int i25 = zzrhVar2.f16661j;
                    int i26 = zzrhVar2.f16662k;
                    boolean z9 = zzrhVar2.l;
                    boolean z10 = zzrhVar2.f16659h;
                    boolean z11 = zzrhVar2.f16660i;
                    int i27 = 0;
                    zzra zzraVar3 = null;
                    int i28 = 0;
                    int i29 = 0;
                    int i30 = -1;
                    int i31 = -1;
                    while (i28 < zzrbVar2.f16641b) {
                        zzra zzraVarB = zzrbVar2.b(i28);
                        zzrb zzrbVar3 = zzrbVar2;
                        zzrm[] zzrmVarArr3 = zzrmVarArr2;
                        ArrayList arrayList = new ArrayList(zzraVarB.a);
                        int i32 = i21;
                        for (int i33 = 0; i33 < zzraVarB.a; i33++) {
                            arrayList.add(Integer.valueOf(i33));
                        }
                        int i34 = Integer.MAX_VALUE;
                        if (i25 == Integer.MAX_VALUE || i26 == Integer.MAX_VALUE) {
                            i6 = i27;
                            zzraVar = zzraVar3;
                            z3 = z9;
                            i7 = i26;
                            z4 = z10;
                            i8 = i25;
                            i9 = i24;
                        } else {
                            i6 = i27;
                            int i35 = 0;
                            while (i35 < zzraVarB.a) {
                                zzlh zzlhVarA = zzraVarB.a(i35);
                                zzra zzraVar4 = zzraVar3;
                                int i36 = zzlhVarA.o;
                                if (i36 > 0) {
                                    z7 = z10;
                                    int i37 = zzlhVarA.p;
                                    if (i37 > 0) {
                                        z9 = z9;
                                        if (z9) {
                                            i26 = i26;
                                            if ((i36 > i37) != (i25 > i26)) {
                                                i17 = i25;
                                                i14 = i17;
                                                i16 = i26;
                                            }
                                            i18 = i36 * i17;
                                            i15 = i24;
                                            i19 = i37 * i16;
                                            if (i18 >= i19) {
                                                point = new Point(i16, zzsy.j(i19, i36));
                                            } else {
                                                point = new Point(zzsy.j(i18, i37), i17);
                                            }
                                            i20 = zzlhVarA.o;
                                            int i38 = zzlhVarA.p;
                                            int i39 = i20 * i38;
                                            if (i20 < ((int) (point.x * 0.98f)) && i38 >= ((int) (point.y * 0.98f)) && i39 < i34) {
                                                i34 = i39;
                                            }
                                        } else {
                                            i26 = i26;
                                        }
                                        i16 = i25;
                                        i14 = i16;
                                        i17 = i26;
                                        i18 = i36 * i17;
                                        i15 = i24;
                                        i19 = i37 * i16;
                                        if (i18 >= i19) {
                                            point = new Point(i16, zzsy.j(i19, i36));
                                        } else {
                                            point = new Point(zzsy.j(i18, i37), i17);
                                        }
                                        i20 = zzlhVarA.o;
                                        int i310 = zzlhVarA.p;
                                        int i311 = i20 * i310;
                                        if (i20 < ((int) (point.x * 0.98f))) {
                                        }
                                    }
                                    i35++;
                                    zzraVar3 = zzraVar4;
                                    z10 = z7;
                                    z9 = z9;
                                    i26 = i26;
                                    i25 = i14;
                                    i24 = i15;
                                } else {
                                    z7 = z10;
                                }
                                i14 = i25;
                                i15 = i24;
                                i35++;
                                zzraVar3 = zzraVar4;
                                z10 = z7;
                                z9 = z9;
                                i26 = i26;
                                i25 = i14;
                                i24 = i15;
                            }
                            zzraVar = zzraVar3;
                            z3 = z9;
                            i7 = i26;
                            z4 = z10;
                            i8 = i25;
                            i9 = i24;
                            if (i34 != Integer.MAX_VALUE) {
                                for (int size = arrayList.size() - 1; size >= 0; size--) {
                                    int iN = zzraVarB.a(((Integer) arrayList.get(size)).intValue()).n();
                                    if (iN == -1 || iN > i34) {
                                        arrayList.remove(size);
                                    }
                                }
                            }
                        }
                        int[] iArr4 = iArr3[i28];
                        int i40 = i29;
                        int iN2 = i30;
                        int i41 = i31;
                        zzraVar3 = zzraVar;
                        int i42 = 0;
                        while (i42 < zzraVarB.a) {
                            if (i(iArr4[i42], z11)) {
                                zzlh zzlhVarA2 = zzraVarB.a(i42);
                                if (!arrayList.contains(Integer.valueOf(i42)) || (((i12 = zzlhVarA2.o) != -1 && i12 > i22) || ((i13 = zzlhVarA2.p) != -1 && i13 > i23))) {
                                    i10 = i9;
                                } else {
                                    int i43 = zzlhVarA2.f16423g;
                                    if (i43 != -1) {
                                        i10 = i9;
                                        if (i43 <= i10) {
                                        }
                                        if (!z5 || z4) {
                                            zzraVar2 = zzraVarB;
                                            if (z5) {
                                                i11 = 2;
                                            } else {
                                                i11 = 1;
                                            }
                                            iArr2 = iArr4;
                                            zI = i(iArr4[i42], false);
                                            if (zI) {
                                                i11 += 1000;
                                            }
                                            if (i11 > i40) {
                                                z6 = true;
                                            } else {
                                                z6 = false;
                                            }
                                            if (i11 == i40) {
                                                if (zzlhVarA2.n() != iN2) {
                                                    iH = h(zzlhVarA2.n(), iN2);
                                                } else {
                                                    iH = h(zzlhVarA2.f16423g, i41);
                                                }
                                                z6 = zI || !z5 ? iH < 0 : iH > 0;
                                            }
                                            if (z6) {
                                                i41 = zzlhVarA2.f16423g;
                                                i40 = i11;
                                                i6 = i42;
                                                iN2 = zzlhVarA2.n();
                                                zzraVar3 = zzraVar2;
                                            }
                                            i42++;
                                            i9 = i10;
                                            zzraVarB = zzraVar2;
                                            iArr4 = iArr2;
                                        } else {
                                            iArr2 = iArr4;
                                            zzraVar2 = zzraVarB;
                                        }
                                    } else {
                                        i10 = i9;
                                    }
                                    z5 = true;
                                    if (z5) {
                                        zzraVar2 = zzraVarB;
                                        if (z5) {
                                            i11 = 2;
                                        } else {
                                            i11 = 1;
                                        }
                                        iArr2 = iArr4;
                                        zI = i(iArr4[i42], false);
                                        if (zI) {
                                            i11 += 1000;
                                        }
                                        if (i11 > i40) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        if (i11 == i40) {
                                            if (zzlhVarA2.n() != iN2) {
                                                iH = h(zzlhVarA2.n(), iN2);
                                            } else {
                                                iH = h(zzlhVarA2.f16423g, i41);
                                            }
                                            if (zI) {
                                            }
                                        }
                                        if (z6) {
                                            i41 = zzlhVarA2.f16423g;
                                            i40 = i11;
                                            i6 = i42;
                                            iN2 = zzlhVarA2.n();
                                            zzraVar3 = zzraVar2;
                                        }
                                    } else {
                                        zzraVar2 = zzraVarB;
                                        if (z5) {
                                            i11 = 2;
                                        } else {
                                            i11 = 1;
                                        }
                                        iArr2 = iArr4;
                                        zI = i(iArr4[i42], false);
                                        if (zI) {
                                            i11 += 1000;
                                        }
                                        if (i11 > i40) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        if (i11 == i40) {
                                            if (zzlhVarA2.n() != iN2) {
                                                iH = h(zzlhVarA2.n(), iN2);
                                            } else {
                                                iH = h(zzlhVarA2.f16423g, i41);
                                            }
                                            if (zI) {
                                            }
                                        }
                                        if (z6) {
                                            i41 = zzlhVarA2.f16423g;
                                            i40 = i11;
                                            i6 = i42;
                                            iN2 = zzlhVarA2.n();
                                            zzraVar3 = zzraVar2;
                                        }
                                    }
                                    i42++;
                                    i9 = i10;
                                    zzraVarB = zzraVar2;
                                    iArr4 = iArr2;
                                }
                                z5 = false;
                                if (z5) {
                                    zzraVar2 = zzraVarB;
                                    if (z5) {
                                        i11 = 2;
                                    } else {
                                        i11 = 1;
                                    }
                                    iArr2 = iArr4;
                                    zI = i(iArr4[i42], false);
                                    if (zI) {
                                        i11 += 1000;
                                    }
                                    if (i11 > i40) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    if (i11 == i40) {
                                        if (zzlhVarA2.n() != iN2) {
                                            iH = h(zzlhVarA2.n(), iN2);
                                        } else {
                                            iH = h(zzlhVarA2.f16423g, i41);
                                        }
                                        if (zI) {
                                        }
                                    }
                                    if (z6) {
                                        i41 = zzlhVarA2.f16423g;
                                        i40 = i11;
                                        i6 = i42;
                                        iN2 = zzlhVarA2.n();
                                        zzraVar3 = zzraVar2;
                                    }
                                } else {
                                    zzraVar2 = zzraVarB;
                                    if (z5) {
                                        i11 = 2;
                                    } else {
                                        i11 = 1;
                                    }
                                    iArr2 = iArr4;
                                    zI = i(iArr4[i42], false);
                                    if (zI) {
                                        i11 += 1000;
                                    }
                                    if (i11 > i40) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    if (i11 == i40) {
                                        if (zzlhVarA2.n() != iN2) {
                                            iH = h(zzlhVarA2.n(), iN2);
                                        } else {
                                            iH = h(zzlhVarA2.f16423g, i41);
                                        }
                                        if (zI) {
                                        }
                                    }
                                    if (z6) {
                                        i41 = zzlhVarA2.f16423g;
                                        i40 = i11;
                                        i6 = i42;
                                        iN2 = zzlhVarA2.n();
                                        zzraVar3 = zzraVar2;
                                    }
                                }
                                i42++;
                                i9 = i10;
                                zzraVarB = zzraVar2;
                                iArr4 = iArr2;
                            } else {
                                iArr2 = iArr4;
                                zzraVar2 = zzraVarB;
                                i10 = i9;
                            }
                            zzraVar3 = zzraVar3;
                            i42++;
                            i9 = i10;
                            zzraVarB = zzraVar2;
                            iArr4 = iArr2;
                        }
                        i24 = i9;
                        i28++;
                        i29 = i40;
                        i31 = i41;
                        zzrbVar2 = zzrbVar3;
                        zzrmVarArr2 = zzrmVarArr3;
                        i27 = i6;
                        z10 = z4;
                        z9 = z3;
                        i26 = i7;
                        i25 = i8;
                        i30 = iN2;
                        i21 = i32;
                    }
                    zzrmVarArr = zzrmVarArr2;
                    zzra zzraVar5 = zzraVar3;
                    i5 = i21;
                    zzrmVarArr[i5] = zzraVar5 == null ? null : new zzri(zzraVar5, i27);
                    z8 = zzrmVarArr[i5] != null;
                }
                int i44 = zzrbVarArr[i5].f16641b;
            } else {
                length = length;
                zzrmVarArr = zzrmVarArr2;
                zzrhVar2 = zzrhVar2;
                i5 = i21;
            }
            i21 = i5 + 1;
            zzlpVarArr2 = zzlpVarArr;
            zzrhVar2 = zzrhVar2;
            length = length;
            zzrmVarArr2 = zzrmVarArr;
        }
        zzrm[] zzrmVarArr4 = zzrmVarArr2;
        zzrh zzrhVar3 = zzrhVar2;
        int i45 = length;
        int i46 = 0;
        boolean z12 = false;
        boolean z13 = false;
        while (i46 < i45) {
            int iE = zzlpVarArr[i46].E();
            if (iE == 1) {
                i2 = i45;
                zzrhVar = zzrhVar3;
                if (!z12) {
                    zzrb zzrbVar4 = zzrbVarArr[i46];
                    int[][] iArr5 = iArr[i46];
                    boolean z14 = zzrhVar.f16660i;
                    int i47 = 0;
                    int i48 = 0;
                    int i49 = -1;
                    int i50 = -1;
                    while (i47 < zzrbVar4.f16641b) {
                        zzra zzraVarB2 = zzrbVar4.b(i47);
                        int[] iArr6 = iArr5[i47];
                        int i51 = i50;
                        int i52 = i49;
                        int i53 = i48;
                        int i54 = 0;
                        while (i54 < zzraVarB2.a) {
                            if (i(iArr6[i54], z14)) {
                                zzlh zzlhVarA3 = zzraVarB2.a(i54);
                                int i55 = iArr6[i54];
                                z2 = z13;
                                boolean z15 = (zzlhVarA3.C & 1) != 0;
                                int i56 = g(zzlhVarA3, null) ? z15 ? 4 : 3 : z15 ? 2 : 1;
                                if (i(i55, false)) {
                                    i56 += 1000;
                                }
                                if (i56 > i53) {
                                    i52 = i47;
                                    i51 = i54;
                                    i53 = i56;
                                }
                            } else {
                                z2 = z13;
                            }
                            i54++;
                            z13 = z2;
                        }
                        i47++;
                        i48 = i53;
                        i49 = i52;
                        i50 = i51;
                        z13 = z13;
                    }
                    z = z13;
                    zzrmVarArr4[i46] = i49 == -1 ? null : new zzri(zzrbVar4.b(i49), i50);
                    z12 = zzrmVarArr4[i46] != null;
                }
                i46++;
                zzrhVar3 = zzrhVar;
                z13 = z;
                i45 = i2;
            } else if (iE == 2) {
                i2 = i45;
                zzrhVar = zzrhVar3;
            } else if (iE != 3) {
                zzlpVarArr[i46].E();
                zzrb zzrbVar5 = zzrbVarArr[i46];
                int[][] iArr7 = iArr[i46];
                zzrhVar = zzrhVar3;
                boolean z16 = zzrhVar.f16660i;
                zzra zzraVar6 = null;
                int i57 = 0;
                int i58 = 0;
                for (int i59 = 0; i59 < zzrbVar5.f16641b; i59++) {
                    zzra zzraVarB3 = zzrbVar5.b(i59);
                    int[] iArr8 = iArr7[i59];
                    int i60 = 0;
                    while (i60 < zzraVarB3.a) {
                        if (i(iArr8[i60], z16)) {
                            i4 = i45;
                            int i61 = (zzraVarB3.a(i60).C & 1) != 0 ? 2 : 1;
                            zzrbVar = zzrbVar5;
                            if (i(iArr8[i60], false)) {
                                i61 += 1000;
                            }
                            if (i61 > i58) {
                                i58 = i61;
                                zzraVar6 = zzraVarB3;
                                i57 = i60;
                            }
                        } else {
                            i4 = i45;
                            zzrbVar = zzrbVar5;
                        }
                        i60++;
                        zzrbVar5 = zzrbVar;
                        i45 = i4;
                    }
                }
                i2 = i45;
                zzrmVarArr4[i46] = zzraVar6 == null ? null : new zzri(zzraVar6, i57);
            } else {
                i2 = i45;
                zzrhVar = zzrhVar3;
                if (!z13) {
                    zzrb zzrbVar6 = zzrbVarArr[i46];
                    int[][] iArr9 = iArr[i46];
                    boolean z17 = zzrhVar.f16660i;
                    int i62 = 0;
                    int i63 = 0;
                    int i64 = 0;
                    zzra zzraVar7 = null;
                    while (i62 < zzrbVar6.f16641b) {
                        zzra zzraVarB4 = zzrbVar6.b(i62);
                        int[] iArr10 = iArr9[i62];
                        zzra zzraVar8 = zzraVar7;
                        int i65 = i64;
                        int i66 = i63;
                        for (int i67 = 0; i67 < zzraVarB4.a; i67++) {
                            if (i(iArr10[i67], z17)) {
                                zzlh zzlhVarA4 = zzraVarB4.a(i67);
                                int i68 = zzlhVarA4.C;
                                boolean z18 = (i68 & 1) != 0;
                                boolean z19 = (i68 & 2) != 0;
                                if (g(zzlhVarA4, null)) {
                                    i3 = z18 ? 6 : !z19 ? 5 : 4;
                                } else if (z18) {
                                    i3 = 3;
                                } else if (z19) {
                                    i3 = g(zzlhVarA4, null) ? 2 : 1;
                                }
                                if (i(iArr10[i67], false)) {
                                    i3 += 1000;
                                }
                                if (i3 > i65) {
                                    i65 = i3;
                                    i66 = i67;
                                    zzraVar8 = zzraVarB4;
                                }
                            }
                        }
                        i62++;
                        i63 = i66;
                        i64 = i65;
                        zzraVar7 = zzraVar8;
                    }
                    zzrmVarArr4[i46] = zzraVar7 == null ? null : new zzri(zzraVar7, i63);
                    z = zzrmVarArr4[i46] != null;
                }
                i46++;
                zzrhVar3 = zzrhVar;
                z13 = z;
                i45 = i2;
            }
            z = z13;
            i46++;
            zzrhVar3 = zzrhVar;
            z13 = z;
            i45 = i2;
        }
        return zzrmVarArr4;
    }

    private zzrg(zzrn zzrnVar) {
        this.f16651g = null;
        this.f16652h = new AtomicReference<>(new zzrh());
    }
}
