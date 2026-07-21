package c.g.b.k.m;

import java.util.ArrayList;

/* JADX INFO: compiled from: BasicMeasure.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private final ArrayList<c.g.b.k.e> a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f3083b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c.g.b.k.f f3084c;

    /* JADX INFO: compiled from: BasicMeasure.java */
    public static class a {
        public static int a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f3085b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static int f3086c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c.g.b.k.e.b f3087d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c.g.b.k.e.b f3088e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3089f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3090g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3091h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3092i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3093j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f3094k;
        public boolean l;
        public int m;
    }

    /* JADX INFO: renamed from: c.g.b.k.m.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BasicMeasure.java */
    public interface InterfaceC0070b {
        void a();

        void b(c.g.b.k.e eVar, a aVar);
    }

    public b(c.g.b.k.f fVar) {
        this.f3084c = fVar;
    }

    private boolean a(InterfaceC0070b interfaceC0070b, c.g.b.k.e eVar, int i2) {
        this.f3083b.f3087d = eVar.y();
        this.f3083b.f3088e = eVar.O();
        this.f3083b.f3089f = eVar.R();
        this.f3083b.f3090g = eVar.v();
        a aVar = this.f3083b;
        aVar.l = false;
        aVar.m = i2;
        c.g.b.k.e.b bVar = aVar.f3087d;
        c.g.b.k.e.b bVar2 = c.g.b.k.e.b.MATCH_CONSTRAINT;
        boolean z = bVar == bVar2;
        boolean z2 = aVar.f3088e == bVar2;
        boolean z3 = z && eVar.X > 0.0f;
        boolean z4 = z2 && eVar.X > 0.0f;
        if (z3 && eVar.s[0] == 4) {
            aVar.f3087d = c.g.b.k.e.b.FIXED;
        }
        if (z4 && eVar.s[1] == 4) {
            aVar.f3088e = c.g.b.k.e.b.FIXED;
        }
        interfaceC0070b.b(eVar, aVar);
        eVar.U0(this.f3083b.f3091h);
        eVar.v0(this.f3083b.f3092i);
        eVar.u0(this.f3083b.f3094k);
        eVar.k0(this.f3083b.f3093j);
        a aVar2 = this.f3083b;
        aVar2.m = a.a;
        return aVar2.l;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0097 A[PHI: r10
      0x0097: PHI (r10v2 boolean) = (r10v1 boolean), (r10v1 boolean), (r10v1 boolean), (r10v4 boolean), (r10v4 boolean) binds: [B:32:0x0061, B:34:0x0067, B:36:0x006b, B:54:0x0094, B:52:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    private void b(c.g.b.k.f fVar) {
        boolean z;
        l lVar;
        n nVar;
        int size = fVar.D0.size();
        boolean zB1 = fVar.B1(64);
        InterfaceC0070b interfaceC0070bR1 = fVar.r1();
        for (int i2 = 0; i2 < size; i2++) {
            c.g.b.k.e eVar = fVar.D0.get(i2);
            if (!(eVar instanceof c.g.b.k.g) && !(eVar instanceof c.g.b.k.a) && !eVar.c0() && (!zB1 || (lVar = eVar.f3071f) == null || (nVar = eVar.f3072g) == null || !lVar.f3145e.f3112j || !nVar.f3145e.f3112j)) {
                c.g.b.k.e.b bVarS = eVar.s(0);
                c.g.b.k.e.b bVarS2 = eVar.s(1);
                c.g.b.k.e.b bVar = c.g.b.k.e.b.MATCH_CONSTRAINT;
                boolean z2 = bVarS == bVar && eVar.q != 1 && bVarS2 == bVar && eVar.r != 1;
                if (!z2 && fVar.B1(1) && !(eVar instanceof c.g.b.k.k)) {
                    if (bVarS == bVar && eVar.q == 0 && bVarS2 != bVar && !eVar.Z()) {
                        z2 = true;
                    }
                    if (bVarS2 == bVar && eVar.r == 0 && bVarS != bVar && !eVar.Z()) {
                        z2 = true;
                    }
                    z = (!(bVarS == bVar || bVarS2 == bVar) || eVar.X <= 0.0f) ? z2 : true;
                }
                if (z) {
                    continue;
                } else {
                    a(interfaceC0070bR1, eVar, a.a);
                    if (fVar.I0 != null) {
                        throw null;
                    }
                }
            }
        }
        interfaceC0070bR1.a();
    }

    private void c(c.g.b.k.f fVar, String str, int i2, int i3) {
        int iG = fVar.G();
        int iF = fVar.F();
        fVar.K0(0);
        fVar.J0(0);
        fVar.U0(i2);
        fVar.v0(i3);
        fVar.K0(iG);
        fVar.J0(iF);
        this.f3084c.b1();
    }

    public long d(c.g.b.k.f fVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        boolean zQ1;
        int i11;
        int i12;
        boolean z;
        boolean z2;
        boolean z3;
        int i13;
        boolean z4;
        boolean z5;
        InterfaceC0070b interfaceC0070bR1 = fVar.r1();
        int size = fVar.D0.size();
        int iR = fVar.R();
        int iV = fVar.v();
        boolean zB = c.g.b.k.j.b(i2, 128);
        boolean z6 = zB || c.g.b.k.j.b(i2, 64);
        if (z6) {
            for (int i14 = 0; i14 < size; i14++) {
                c.g.b.k.e eVar = fVar.D0.get(i14);
                c.g.b.k.e.b bVarY = eVar.y();
                c.g.b.k.e.b bVar = c.g.b.k.e.b.MATCH_CONSTRAINT;
                boolean z7 = (bVarY == bVar) && (eVar.O() == bVar) && eVar.t() > 0.0f;
                if ((eVar.Z() && z7) || ((eVar.b0() && z7) || (eVar instanceof c.g.b.k.k) || eVar.Z() || eVar.b0())) {
                    z6 = false;
                    break;
                }
            }
        }
        if (z6 && c.g.b.d.f3001g != null) {
            throw null;
        }
        boolean z8 = z6 & ((i5 == 1073741824 && i7 == 1073741824) || zB);
        if (z8) {
            int iMin = Math.min(fVar.E(), i6);
            int iMin2 = Math.min(fVar.D(), i8);
            if (i5 == 1073741824 && fVar.R() != iMin) {
                fVar.U0(iMin);
                fVar.u1();
            }
            if (i7 == 1073741824 && fVar.v() != iMin2) {
                fVar.v0(iMin2);
                fVar.u1();
            }
            if (i5 == 1073741824 && i7 == 1073741824) {
                zQ1 = fVar.o1(zB);
                i11 = 2;
            } else {
                boolean zP1 = fVar.p1(zB);
                if (i5 == 1073741824) {
                    zP1 &= fVar.q1(zB, 0);
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                if (i7 == 1073741824) {
                    zQ1 = fVar.q1(zB, 1) & zP1;
                    i11++;
                } else {
                    zQ1 = zP1;
                }
            }
            if (zQ1) {
                fVar.Y0(i5 == 1073741824, i7 == 1073741824);
            }
        } else {
            zQ1 = false;
            i11 = 0;
        }
        if (zQ1 && i11 == 2) {
            return 0L;
        }
        int iS1 = fVar.s1();
        if (size > 0) {
            b(fVar);
        }
        e(fVar);
        int size2 = this.a.size();
        if (size > 0) {
            c(fVar, "First pass", iR, iV);
        }
        if (size2 > 0) {
            c.g.b.k.e.b bVarY2 = fVar.y();
            c.g.b.k.e.b bVar2 = c.g.b.k.e.b.WRAP_CONTENT;
            boolean z9 = bVarY2 == bVar2;
            boolean z10 = fVar.O() == bVar2;
            int iMax = Math.max(fVar.R(), this.f3084c.G());
            int iMax2 = Math.max(fVar.v(), this.f3084c.F());
            int i15 = 0;
            boolean zD1 = false;
            while (i15 < size2) {
                c.g.b.k.e eVar2 = this.a.get(i15);
                if (eVar2 instanceof c.g.b.k.k) {
                    int iR2 = eVar2.R();
                    int iV2 = eVar2.v();
                    boolean zA = a(interfaceC0070bR1, eVar2, a.f3085b) | zD1;
                    if (fVar.I0 != null) {
                        throw null;
                    }
                    int iR3 = eVar2.R();
                    int iV3 = eVar2.v();
                    if (iR3 != iR2) {
                        eVar2.U0(iR3);
                        if (z9 && eVar2.K() > iMax) {
                            iMax = Math.max(iMax, eVar2.K() + eVar2.m(c.g.b.k.d.b.RIGHT).e());
                        }
                        z5 = true;
                    } else {
                        z5 = zA;
                    }
                    if (iV3 != iV2) {
                        eVar2.v0(iV3);
                        if (z10 && eVar2.p() > iMax2) {
                            iMax2 = Math.max(iMax2, eVar2.p() + eVar2.m(c.g.b.k.d.b.BOTTOM).e());
                        }
                        z5 = true;
                    }
                    zD1 = z5 | ((c.g.b.k.k) eVar2).d1();
                }
                i15++;
                iS1 = iS1;
                iR = iR;
            }
            int i16 = iS1;
            int i17 = iR;
            int i18 = 0;
            int i19 = 2;
            while (i18 < i19) {
                int i20 = 0;
                while (i20 < size2) {
                    c.g.b.k.e eVar3 = this.a.get(i20);
                    if (((eVar3 instanceof c.g.b.k.h) && !(eVar3 instanceof c.g.b.k.k)) || (eVar3 instanceof c.g.b.k.g) || eVar3.Q() == 8 || ((z8 && eVar3.f3071f.f3145e.f3112j && eVar3.f3072g.f3145e.f3112j) || (eVar3 instanceof c.g.b.k.k))) {
                        z3 = z8;
                        i13 = size2;
                    } else {
                        int iR4 = eVar3.R();
                        int iV4 = eVar3.v();
                        z3 = z8;
                        int iN = eVar3.n();
                        int i21 = a.f3085b;
                        i13 = size2;
                        if (i18 == 1) {
                            i21 = a.f3086c;
                        }
                        boolean zA2 = a(interfaceC0070bR1, eVar3, i21) | zD1;
                        if (fVar.I0 != null) {
                            throw null;
                        }
                        int iR5 = eVar3.R();
                        int iV5 = eVar3.v();
                        if (iR5 != iR4) {
                            eVar3.U0(iR5);
                            if (z9 && eVar3.K() > iMax) {
                                iMax = Math.max(iMax, eVar3.K() + eVar3.m(c.g.b.k.d.b.RIGHT).e());
                            }
                            z4 = true;
                        } else {
                            z4 = zA2;
                        }
                        if (iV5 != iV4) {
                            eVar3.v0(iV5);
                            if (z10 && eVar3.p() > iMax2) {
                                iMax2 = Math.max(iMax2, eVar3.p() + eVar3.m(c.g.b.k.d.b.BOTTOM).e());
                            }
                            z4 = true;
                        }
                        zD1 = (!eVar3.U() || iN == eVar3.n()) ? z4 : true;
                    }
                    i20++;
                    size2 = i13;
                    z8 = z3;
                }
                boolean z11 = z8;
                int i22 = size2;
                if (!zD1) {
                    break;
                }
                c(fVar, "intermediate pass", i17, iV);
                i18++;
                size2 = i22;
                z8 = z11;
                i19 = 2;
                zD1 = false;
            }
            if (zD1) {
                c(fVar, "2nd pass", i17, iV);
                if (fVar.R() < iMax) {
                    fVar.U0(iMax);
                    z = true;
                } else {
                    z = false;
                }
                if (fVar.v() < iMax2) {
                    fVar.v0(iMax2);
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (z2) {
                    c(fVar, "3rd pass", i17, iV);
                }
            }
            i12 = i16;
        } else {
            i12 = iS1;
        }
        fVar.E1(i12);
        return 0L;
    }

    public void e(c.g.b.k.f fVar) {
        this.a.clear();
        int size = fVar.D0.size();
        for (int i2 = 0; i2 < size; i2++) {
            c.g.b.k.e eVar = fVar.D0.get(i2);
            c.g.b.k.e.b bVarY = eVar.y();
            c.g.b.k.e.b bVar = c.g.b.k.e.b.MATCH_CONSTRAINT;
            if (bVarY == bVar || eVar.O() == bVar) {
                this.a.add(eVar);
            }
        }
        fVar.u1();
    }
}
