package c.g.b.k;

import java.util.ArrayList;

/* JADX INFO: compiled from: Chain.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    /* JADX WARN: Code duplicated, block: B:100:0x0173  */
    /* JADX WARN: Code duplicated, block: B:102:0x0194  */
    /* JADX WARN: Code duplicated, block: B:172:0x02df  */
    /* JADX WARN: Code duplicated, block: B:25:0x003e A[PHI: r14 r15
      0x003e: PHI (r14v3 boolean) = (r14v1 boolean), (r14v30 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x003e: PHI (r15v3 boolean) = (r15v1 boolean), (r15v37 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0040 A[PHI: r14 r15
      0x0040: PHI (r14v28 boolean) = (r14v1 boolean), (r14v30 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x0040: PHI (r15v35 boolean) = (r15v1 boolean), (r15v37 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x016a  */
    /* JADX WARN: Code duplicated, block: B:98:0x016d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [c.g.b.d] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [c.g.b.i] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [c.g.b.k.e] */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    static void a(f fVar, c.g.b.d dVar, int i2, int i3, c cVar) {
        boolean z;
        boolean z2;
        boolean z3;
        Object obj;
        int i4;
        int i5;
        d dVar2;
        c.g.b.i iVar;
        c.g.b.i iVar2;
        d dVar3;
        c.g.b.i iVar3;
        c.g.b.i iVar4;
        ?? r5;
        c.g.b.i iVar5;
        int size;
        d dVar4;
        int i6;
        e eVar = cVar.a;
        e eVar2 = cVar.f3044c;
        e eVar3 = cVar.f3043b;
        e eVar4 = cVar.f3045d;
        e eVar5 = cVar.f3046e;
        float f2 = cVar.f3052k;
        boolean z4 = fVar.T[i2] == e.b.WRAP_CONTENT;
        if (i2 == 0) {
            int i7 = eVar5.s0;
            z = i7 == 0;
            z2 = i7 == 1;
            if (i7 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            int i8 = eVar5.t0;
            z = i8 == 0;
            z2 = i8 == 1;
            if (i8 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        ?? r7 = eVar;
        boolean z5 = false;
        while (true) {
            obj = null;
            if (z5) {
                break;
            }
            d dVar5 = r7.Q[i3];
            int i9 = z3 ? 1 : 4;
            int iE = dVar5.e();
            float f3 = f2;
            e.b bVar = r7.T[i2];
            boolean z6 = z5;
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            boolean z7 = bVar == bVar2 && r7.s[i2] == 0;
            d dVar6 = dVar5.f3057f;
            if (dVar6 != null && r7 != eVar) {
                iE += dVar6.e();
            }
            int i10 = iE;
            if (z3 && r7 != eVar && r7 != eVar3) {
                i9 = 8;
            }
            d dVar7 = dVar5.f3057f;
            if (dVar7 != null) {
                if (r7 == eVar3) {
                    dVar.h(dVar5.f3060i, dVar7.f3060i, i10, 6);
                } else {
                    dVar.h(dVar5.f3060i, dVar7.f3060i, i10, 8);
                }
                dVar.e(dVar5.f3060i, dVar5.f3057f.f3060i, i10, (!z7 || z3) ? i9 : 5);
            } else {
                eVar5 = eVar5;
                eVar = eVar;
            }
            if (z4) {
                if (r7.Q() == 8 || r7.T[i2] != bVar2) {
                    i6 = 0;
                } else {
                    d[] dVarArr = r7.Q;
                    i6 = 0;
                    dVar.h(dVarArr[i3 + 1].f3060i, dVarArr[i3].f3060i, 0, 5);
                }
                dVar.h(r7.Q[i3].f3060i, fVar.Q[i3].f3060i, i6, 8);
            }
            d dVar8 = r7.Q[i3 + 1].f3057f;
            if (dVar8 != null) {
                e eVar6 = dVar8.f3055d;
                d[] dVarArr2 = eVar6.Q;
                if (dVarArr2[i3].f3057f != null && dVarArr2[i3].f3057f.f3055d == r7) {
                    obj = eVar6;
                }
            }
            if (obj != null) {
                r7 = obj;
                z5 = z6;
            } else {
                z5 = true;
            }
            z = z;
            f2 = f3;
            z2 = z2;
            eVar5 = eVar5;
            eVar = eVar;
            r7 = r7;
        }
        e eVar7 = eVar5;
        float f4 = f2;
        e eVar8 = eVar;
        boolean z8 = z;
        boolean z9 = z2;
        if (eVar4 != null) {
            int i11 = i3 + 1;
            if (eVar2.Q[i11].f3057f != null) {
                d dVar9 = eVar4.Q[i11];
                if ((eVar4.T[i2] == e.b.MATCH_CONSTRAINT && eVar4.s[i2] == 0) && !z3) {
                    d dVar10 = dVar9.f3057f;
                    if (dVar10.f3055d == fVar) {
                        dVar.e(dVar9.f3060i, dVar10.f3060i, -dVar9.e(), 5);
                    } else if (z3) {
                        dVar4 = dVar9.f3057f;
                        if (dVar4.f3055d == fVar) {
                            dVar.e(dVar9.f3060i, dVar4.f3060i, -dVar9.e(), 4);
                        }
                    }
                } else if (z3) {
                    dVar4 = dVar9.f3057f;
                    if (dVar4.f3055d == fVar) {
                        dVar.e(dVar9.f3060i, dVar4.f3060i, -dVar9.e(), 4);
                    }
                }
                dVar.j(dVar9.f3060i, eVar2.Q[i11].f3057f.f3060i, -dVar9.e(), 6);
            }
        }
        if (z4) {
            int i12 = i3 + 1;
            c.g.b.i iVar6 = fVar.Q[i12].f3060i;
            d[] dVarArr3 = eVar2.Q;
            dVar.h(iVar6, dVarArr3[i12].f3060i, dVarArr3[i12].e(), 8);
        }
        ArrayList<e> arrayList = cVar.f3049h;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f5 = (!cVar.r || cVar.t) ? f4 : cVar.f3051j;
            float f6 = 0.0f;
            e eVar9 = null;
            int i13 = 0;
            float f7 = 0.0f;
            while (i13 < size) {
                e eVar10 = arrayList.get(i13);
                float f8 = eVar10.w0[i2];
                if (f8 < f6) {
                    if (cVar.t) {
                        d[] dVarArr4 = eVar10.Q;
                        dVar.e(dVarArr4[i3 + 1].f3060i, dVarArr4[i3].f3060i, 0, 4);
                    } else {
                        f8 = 1.0f;
                    }
                    arrayList = arrayList;
                    i13++;
                    arrayList = arrayList;
                    f6 = 0.0f;
                }
                if (f8 == f6) {
                    d[] dVarArr5 = eVar10.Q;
                    dVar.e(dVarArr5[i3 + 1].f3060i, dVarArr5[i3].f3060i, 0, 8);
                    arrayList = arrayList;
                } else {
                    if (eVar9 != null) {
                        d[] dVarArr6 = eVar9.Q;
                        c.g.b.i iVar7 = dVarArr6[i3].f3060i;
                        int i14 = i3 + 1;
                        c.g.b.i iVar8 = dVarArr6[i14].f3060i;
                        d[] dVarArr7 = eVar10.Q;
                        c.g.b.i iVar9 = dVarArr7[i3].f3060i;
                        c.g.b.i iVar10 = dVarArr7[i14].f3060i;
                        c.g.b.b bVarR = dVar.r();
                        bVarR.l(f7, f5, f8, iVar7, iVar8, iVar9, iVar10);
                        dVar.d(bVarR);
                    }
                    eVar9 = eVar10;
                    f7 = f8;
                }
                i13++;
                arrayList = arrayList;
                f6 = 0.0f;
            }
        }
        if (eVar3 != null && (eVar3 == eVar4 || z3)) {
            d dVar11 = eVar8.Q[i3];
            int i15 = i3 + 1;
            d dVar12 = eVar2.Q[i15];
            d dVar13 = dVar11.f3057f;
            c.g.b.i iVar11 = dVar13 != null ? dVar13.f3060i : null;
            d dVar14 = dVar12.f3057f;
            c.g.b.i iVar12 = dVar14 != null ? dVar14.f3060i : null;
            d dVar15 = eVar3.Q[i3];
            d dVar16 = eVar4.Q[i15];
            if (iVar11 != null && iVar12 != null) {
                dVar.c(dVar15.f3060i, iVar11, dVar15.e(), i2 == 0 ? eVar7.i0 : eVar7.j0, iVar12, dVar16.f3060i, dVar16.e(), 7);
            }
        } else if (!z8 || eVar3 == null) {
            int i16 = 8;
            if (z9 && eVar3 != null) {
                int i17 = cVar.f3051j;
                boolean z10 = i17 > 0 && cVar.f3050i == i17;
                e eVar11 = eVar3;
                e eVar12 = eVar11;
                while (eVar11 != null) {
                    e eVar13 = eVar11.y0[i2];
                    while (eVar13 != null && eVar13.Q() == i16) {
                        eVar13 = eVar13.y0[i2];
                    }
                    if (eVar11 == eVar3 || eVar11 == eVar4 || eVar13 == null) {
                        eVar12 = eVar12;
                        i5 = 8;
                    } else {
                        e eVar14 = eVar13 == eVar4 ? null : eVar13;
                        d dVar17 = eVar11.Q[i3];
                        c.g.b.i iVar13 = dVar17.f3060i;
                        d dVar18 = dVar17.f3057f;
                        if (dVar18 != null) {
                            c.g.b.i iVar14 = dVar18.f3060i;
                        }
                        int i18 = i3 + 1;
                        c.g.b.i iVar15 = eVar12.Q[i18].f3060i;
                        int iE2 = dVar17.e();
                        int iE3 = eVar11.Q[i18].e();
                        if (eVar14 != null) {
                            dVar2 = eVar14.Q[i3];
                            iVar = dVar2.f3060i;
                            d dVar19 = dVar2.f3057f;
                            iVar2 = dVar19 != null ? dVar19.f3060i : null;
                        } else {
                            dVar2 = eVar4.Q[i3];
                            iVar = dVar2 != null ? dVar2.f3060i : null;
                            iVar2 = eVar11.Q[i18].f3060i;
                        }
                        if (dVar2 != null) {
                            iE3 += dVar2.e();
                        }
                        int i19 = iE3;
                        int iE4 = eVar12.Q[i18].e() + iE2;
                        int i20 = z10 ? 8 : 4;
                        if (iVar13 == null || iVar15 == null || iVar == null || iVar2 == null) {
                            i5 = 8;
                        } else {
                            i5 = 8;
                            dVar.c(iVar13, iVar15, iE4, 0.5f, iVar, iVar2, i19, i20);
                        }
                        eVar13 = eVar14;
                    }
                    if (eVar11.Q() == i5) {
                        eVar11 = eVar12;
                    }
                    eVar12 = eVar11;
                    i16 = 8;
                    eVar11 = eVar13;
                }
                d dVar20 = eVar3.Q[i3];
                d dVar21 = eVar8.Q[i3].f3057f;
                int i21 = i3 + 1;
                d dVar22 = eVar4.Q[i21];
                d dVar23 = eVar2.Q[i21].f3057f;
                if (dVar21 == null) {
                    i4 = 5;
                } else if (eVar3 != eVar4) {
                    i4 = 5;
                    dVar.e(dVar20.f3060i, dVar21.f3060i, dVar20.e(), 5);
                } else {
                    i4 = 5;
                    if (dVar23 != null) {
                        dVar.c(dVar20.f3060i, dVar21.f3060i, dVar20.e(), 0.5f, dVar22.f3060i, dVar23.f3060i, dVar22.e(), 5);
                    }
                }
                if (dVar23 != null && eVar3 != eVar4) {
                    dVar.e(dVar22.f3060i, dVar23.f3060i, -dVar22.e(), i4);
                }
            }
        } else {
            int i22 = cVar.f3051j;
            boolean z11 = i22 > 0 && cVar.f3050i == i22;
            e eVar15 = eVar3;
            e eVar16 = eVar15;
            while (eVar15 != null) {
                e eVar17 = eVar15.y0[i2];
                while (eVar17 != null && eVar17.Q() == 8) {
                    eVar17 = eVar17.y0[i2];
                }
                if (eVar17 != null || eVar15 == eVar4) {
                    d dVar24 = eVar15.Q[i3];
                    c.g.b.i iVar16 = dVar24.f3060i;
                    d dVar25 = dVar24.f3057f;
                    c.g.b.i iVar17 = dVar25 != null ? dVar25.f3060i : null;
                    if (eVar16 != eVar15) {
                        iVar17 = eVar16.Q[i3 + 1].f3060i;
                    } else if (eVar15 == eVar3 && eVar16 == eVar15) {
                        d[] dVarArr8 = eVar8.Q;
                        iVar17 = dVarArr8[i3].f3057f != null ? dVarArr8[i3].f3057f.f3060i : null;
                    }
                    int iE5 = dVar24.e();
                    int i23 = i3 + 1;
                    int iE6 = eVar15.Q[i23].e();
                    if (eVar17 != null) {
                        dVar3 = eVar17.Q[i3];
                        c.g.b.i iVar18 = dVar3.f3060i;
                        iVar4 = eVar15.Q[i23].f3060i;
                        iVar3 = iVar18;
                    } else {
                        dVar3 = eVar2.Q[i23].f3057f;
                        iVar3 = dVar3 != null ? dVar3.f3060i : null;
                        iVar4 = eVar15.Q[i23].f3060i;
                    }
                    if (dVar3 != null) {
                        iE6 += dVar3.e();
                    }
                    if (eVar16 != null) {
                        iE5 += eVar16.Q[i23].e();
                    }
                    if (iVar16 != null && iVar17 != null && iVar3 != null && iVar4 != null) {
                        if (eVar15 == eVar3) {
                            iE5 = eVar3.Q[i3].e();
                        }
                        dVar.c(iVar16, iVar17, iE5, 0.5f, iVar3, iVar4, eVar15 == eVar4 ? eVar4.Q[i23].e() : iE6, z11 ? 8 : 5);
                    }
                }
                if (eVar15.Q() != 8) {
                    eVar16 = eVar15;
                }
                eVar15 = eVar17;
            }
        }
        if ((!z8 && !z9) || eVar3 == null || eVar3 == eVar4) {
            return;
        }
        d[] dVarArr9 = eVar3.Q;
        d dVar26 = dVarArr9[i3];
        int i24 = i3 + 1;
        d dVar27 = eVar4.Q[i24];
        d dVar28 = dVar26.f3057f;
        c.g.b.i iVar19 = dVar28 != null ? dVar28.f3060i : null;
        d dVar29 = dVar27.f3057f;
        if (dVar29 != null) {
            iVar5 = dVar29.f3060i;
        } else {
            r5 = 0;
        }
        if (eVar2 != eVar4) {
            d dVar30 = eVar2.Q[i24].f3057f;
            if (dVar30 != null) {
                r5 = iVar5;
                obj = dVar30.f3060i;
            }
            r5 = iVar5;
            r5 = obj;
        }
        if (eVar3 == eVar4) {
            dVar26 = dVarArr9[i3];
            dVar27 = dVarArr9[i24];
        }
        if (iVar19 == null || r5 == 0) {
            return;
        }
        dVar.c(dVar26.f3060i, iVar19, dVar26.e(), 0.5f, r5, dVar27.f3060i, eVar4.Q[i24].e(), 5);
    }

    public static void b(f fVar, c.g.b.d dVar, ArrayList<e> arrayList, int i2) {
        c[] cVarArr;
        int i3;
        int i4;
        if (i2 == 0) {
            i3 = fVar.O0;
            cVarArr = fVar.R0;
            i4 = 0;
        } else {
            int i5 = fVar.P0;
            cVarArr = fVar.Q0;
            i3 = i5;
            i4 = 2;
        }
        for (int i6 = 0; i6 < i3; i6++) {
            c cVar = cVarArr[i6];
            cVar.a();
            if (arrayList == null || arrayList.contains(cVar.a)) {
                a(fVar, dVar, i2, i4, cVar);
            }
        }
    }
}
