package c.g.b.k.m;

/* JADX INFO: compiled from: HorizontalWidgetRun.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int[] f3120k = new int[2];

    /* JADX INFO: compiled from: HorizontalWidgetRun.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[p.b.values().length];
            a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(c.g.b.k.e eVar) {
        super(eVar);
        this.f3148h.f3107e = f.a.LEFT;
        this.f3149i.f3107e = f.a.RIGHT;
        this.f3146f = 0;
    }

    private void q(int[] iArr, int i2, int i3, int i4, int i5, float f2, int i6) {
        int i7 = i3 - i2;
        int i8 = i5 - i4;
        if (i6 != -1) {
            if (i6 == 0) {
                iArr[0] = (int) ((i8 * f2) + 0.5f);
                iArr[1] = i8;
                return;
            } else {
                if (i6 != 1) {
                    return;
                }
                iArr[0] = i7;
                iArr[1] = (int) ((i7 * f2) + 0.5f);
                return;
            }
        }
        int i9 = (int) ((i8 * f2) + 0.5f);
        int i10 = (int) ((i7 / f2) + 0.5f);
        if (i9 <= i7 && i8 <= i8) {
            iArr[0] = i9;
            iArr[1] = i8;
        } else {
            if (i7 > i7 || i10 > i8) {
                return;
            }
            iArr[0] = i7;
            iArr[1] = i10;
        }
    }

    /* JADX WARN: Code duplicated, block: B:125:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:127:0x02f1  */
    @Override // c.g.b.k.m.p, c.g.b.k.m.d
    public void a(d dVar) {
        int iG;
        int i2;
        int iG2;
        float f2;
        float fT;
        float fT2;
        int i3;
        int i4 = a.a[this.f3150j.ordinal()];
        if (i4 == 1) {
            p(dVar);
        } else if (i4 == 2) {
            o(dVar);
        } else if (i4 == 3) {
            c.g.b.k.e eVar = this.f3142b;
            n(dVar, eVar.I, eVar.K, 0);
            return;
        }
        if (!this.f3145e.f3112j && this.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT) {
            c.g.b.k.e eVar2 = this.f3142b;
            int i5 = eVar2.q;
            if (i5 == 2) {
                c.g.b.k.e eVarI = eVar2.I();
                if (eVarI != null) {
                    g gVar = eVarI.f3071f.f3145e;
                    if (gVar.f3112j) {
                        this.f3145e.d((int) ((gVar.f3109g * this.f3142b.v) + 0.5f));
                    }
                }
            } else if (i5 == 3) {
                int i6 = eVar2.r;
                if (i6 == 0 || i6 == 3) {
                    n nVar = eVar2.f3072g;
                    f fVar = nVar.f3148h;
                    f fVar2 = nVar.f3149i;
                    boolean z = eVar2.I.f3057f != null;
                    boolean z2 = eVar2.J.f3057f != null;
                    boolean z3 = eVar2.K.f3057f != null;
                    boolean z4 = eVar2.L.f3057f != null;
                    int iU = eVar2.u();
                    if (z && z2 && z3 && z4) {
                        float fT3 = this.f3142b.t();
                        if (fVar.f3112j && fVar2.f3112j) {
                            f fVar3 = this.f3148h;
                            if (fVar3.f3105c && this.f3149i.f3105c) {
                                q(f3120k, fVar3.l.get(0).f3109g + this.f3148h.f3108f, this.f3149i.l.get(0).f3109g - this.f3149i.f3108f, fVar.f3109g + fVar.f3108f, fVar2.f3109g - fVar2.f3108f, fT3, iU);
                                this.f3145e.d(f3120k[0]);
                                this.f3142b.f3072g.f3145e.d(f3120k[1]);
                                return;
                            }
                            return;
                        }
                        f fVar4 = this.f3148h;
                        if (fVar4.f3112j) {
                            f fVar5 = this.f3149i;
                            if (fVar5.f3112j) {
                                if (!fVar.f3105c || !fVar2.f3105c) {
                                    return;
                                }
                                q(f3120k, fVar4.f3109g + fVar4.f3108f, fVar5.f3109g - fVar5.f3108f, fVar.l.get(0).f3109g + fVar.f3108f, fVar2.l.get(0).f3109g - fVar2.f3108f, fT3, iU);
                                this.f3145e.d(f3120k[0]);
                                this.f3142b.f3072g.f3145e.d(f3120k[1]);
                            }
                        }
                        f fVar6 = this.f3148h;
                        if (!fVar6.f3105c || !this.f3149i.f3105c || !fVar.f3105c || !fVar2.f3105c) {
                            return;
                        }
                        q(f3120k, fVar6.l.get(0).f3109g + this.f3148h.f3108f, this.f3149i.l.get(0).f3109g - this.f3149i.f3108f, fVar.l.get(0).f3109g + fVar.f3108f, fVar2.l.get(0).f3109g - fVar2.f3108f, fT3, iU);
                        this.f3145e.d(f3120k[0]);
                        this.f3142b.f3072g.f3145e.d(f3120k[1]);
                    } else if (z && z3) {
                        if (!this.f3148h.f3105c || !this.f3149i.f3105c) {
                            return;
                        }
                        float fT4 = this.f3142b.t();
                        int i7 = this.f3148h.l.get(0).f3109g + this.f3148h.f3108f;
                        int i8 = this.f3149i.l.get(0).f3109g - this.f3149i.f3108f;
                        if (iU == -1 || iU == 0) {
                            int iG3 = g(i8 - i7, 0);
                            int i9 = (int) ((iG3 * fT4) + 0.5f);
                            int iG4 = g(i9, 1);
                            if (i9 != iG4) {
                                iG3 = (int) ((iG4 / fT4) + 0.5f);
                            }
                            this.f3145e.d(iG3);
                            this.f3142b.f3072g.f3145e.d(iG4);
                        } else if (iU == 1) {
                            int iG5 = g(i8 - i7, 0);
                            int i10 = (int) ((iG5 / fT4) + 0.5f);
                            int iG6 = g(i10, 1);
                            if (i10 != iG6) {
                                iG5 = (int) ((iG6 * fT4) + 0.5f);
                            }
                            this.f3145e.d(iG5);
                            this.f3142b.f3072g.f3145e.d(iG6);
                        }
                    } else if (z2 && z4) {
                        if (!fVar.f3105c || !fVar2.f3105c) {
                            return;
                        }
                        float fT5 = this.f3142b.t();
                        int i11 = fVar.l.get(0).f3109g + fVar.f3108f;
                        int i12 = fVar2.l.get(0).f3109g - fVar2.f3108f;
                        if (iU == -1) {
                            iG = g(i12 - i11, 1);
                            i2 = (int) ((iG / fT5) + 0.5f);
                            iG2 = g(i2, 0);
                            if (i2 != iG2) {
                                iG = (int) ((iG2 * fT5) + 0.5f);
                            }
                            this.f3145e.d(iG2);
                            this.f3142b.f3072g.f3145e.d(iG);
                        } else if (iU == 0) {
                            int iG7 = g(i12 - i11, 1);
                            int i13 = (int) ((iG7 * fT5) + 0.5f);
                            int iG8 = g(i13, 0);
                            if (i13 != iG8) {
                                iG7 = (int) ((iG8 / fT5) + 0.5f);
                            }
                            this.f3145e.d(iG8);
                            this.f3142b.f3072g.f3145e.d(iG7);
                        } else if (iU == 1) {
                            iG = g(i12 - i11, 1);
                            i2 = (int) ((iG / fT5) + 0.5f);
                            iG2 = g(i2, 0);
                            if (i2 != iG2) {
                                iG = (int) ((iG2 * fT5) + 0.5f);
                            }
                            this.f3145e.d(iG2);
                            this.f3142b.f3072g.f3145e.d(iG);
                        }
                    }
                } else {
                    int iU2 = eVar2.u();
                    if (iU2 != -1) {
                        if (iU2 == 0) {
                            c.g.b.k.e eVar3 = this.f3142b;
                            fT2 = eVar3.f3072g.f3145e.f3109g / eVar3.t();
                            i3 = (int) (fT2 + 0.5f);
                        } else if (iU2 != 1) {
                            i3 = 0;
                        } else {
                            c.g.b.k.e eVar4 = this.f3142b;
                            f2 = eVar4.f3072g.f3145e.f3109g;
                            fT = eVar4.t();
                        }
                        this.f3145e.d(i3);
                    } else {
                        c.g.b.k.e eVar5 = this.f3142b;
                        f2 = eVar5.f3072g.f3145e.f3109g;
                        fT = eVar5.t();
                    }
                    fT2 = f2 * fT;
                    i3 = (int) (fT2 + 0.5f);
                    this.f3145e.d(i3);
                }
            }
        }
        f fVar7 = this.f3148h;
        if (fVar7.f3105c) {
            f fVar8 = this.f3149i;
            if (fVar8.f3105c) {
                if (fVar7.f3112j && fVar8.f3112j && this.f3145e.f3112j) {
                    return;
                }
                if (!this.f3145e.f3112j && this.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT) {
                    c.g.b.k.e eVar6 = this.f3142b;
                    if (eVar6.q == 0 && !eVar6.Z()) {
                        f fVar9 = this.f3148h.l.get(0);
                        f fVar10 = this.f3149i.l.get(0);
                        int i14 = fVar9.f3109g;
                        f fVar11 = this.f3148h;
                        int i15 = i14 + fVar11.f3108f;
                        int i16 = fVar10.f3109g + this.f3149i.f3108f;
                        fVar11.d(i15);
                        this.f3149i.d(i16);
                        this.f3145e.d(i16 - i15);
                        return;
                    }
                }
                if (!this.f3145e.f3112j && this.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT && this.a == 1 && this.f3148h.l.size() > 0 && this.f3149i.l.size() > 0) {
                    int iMin = Math.min((this.f3149i.l.get(0).f3109g + this.f3149i.f3108f) - (this.f3148h.l.get(0).f3109g + this.f3148h.f3108f), this.f3145e.m);
                    c.g.b.k.e eVar7 = this.f3142b;
                    int i17 = eVar7.u;
                    int iMax = Math.max(eVar7.t, iMin);
                    if (i17 > 0) {
                        iMax = Math.min(i17, iMax);
                    }
                    this.f3145e.d(iMax);
                }
                if (this.f3145e.f3112j) {
                    f fVar12 = this.f3148h.l.get(0);
                    f fVar13 = this.f3149i.l.get(0);
                    int i18 = fVar12.f3109g + this.f3148h.f3108f;
                    int i19 = fVar13.f3109g + this.f3149i.f3108f;
                    float fW = this.f3142b.w();
                    if (fVar12 == fVar13) {
                        i18 = fVar12.f3109g;
                        i19 = fVar13.f3109g;
                        fW = 0.5f;
                    }
                    this.f3148h.d((int) (i18 + 0.5f + (((i19 - i18) - this.f3145e.f3109g) * fW)));
                    this.f3149i.d(this.f3148h.f3109g + this.f3145e.f3109g);
                }
            }
        }
    }

    @Override // c.g.b.k.m.p
    void d() {
        c.g.b.k.e eVarI;
        c.g.b.k.e eVarI2;
        c.g.b.k.e eVar = this.f3142b;
        if (eVar.f3067b) {
            this.f3145e.d(eVar.R());
        }
        if (this.f3145e.f3112j) {
            c.g.b.k.e.b bVar = this.f3144d;
            c.g.b.k.e.b bVar2 = c.g.b.k.e.b.MATCH_PARENT;
            if (bVar == bVar2 && (((eVarI = this.f3142b.I()) != null && eVarI.y() == c.g.b.k.e.b.FIXED) || eVarI.y() == bVar2)) {
                b(this.f3148h, eVarI.f3071f.f3148h, this.f3142b.I.e());
                b(this.f3149i, eVarI.f3071f.f3149i, -this.f3142b.K.e());
                return;
            }
        } else {
            c.g.b.k.e.b bVarY = this.f3142b.y();
            this.f3144d = bVarY;
            if (bVarY != c.g.b.k.e.b.MATCH_CONSTRAINT) {
                c.g.b.k.e.b bVar3 = c.g.b.k.e.b.MATCH_PARENT;
                if (bVarY == bVar3 && (((eVarI2 = this.f3142b.I()) != null && eVarI2.y() == c.g.b.k.e.b.FIXED) || eVarI2.y() == bVar3)) {
                    int iR = (eVarI2.R() - this.f3142b.I.e()) - this.f3142b.K.e();
                    b(this.f3148h, eVarI2.f3071f.f3148h, this.f3142b.I.e());
                    b(this.f3149i, eVarI2.f3071f.f3149i, -this.f3142b.K.e());
                    this.f3145e.d(iR);
                    return;
                }
                if (this.f3144d == c.g.b.k.e.b.FIXED) {
                    this.f3145e.d(this.f3142b.R());
                }
            }
        }
        g gVar = this.f3145e;
        if (gVar.f3112j) {
            c.g.b.k.e eVar2 = this.f3142b;
            if (eVar2.f3067b) {
                c.g.b.k.d[] dVarArr = eVar2.Q;
                if (dVarArr[0].f3057f != null && dVarArr[1].f3057f != null) {
                    if (eVar2.Z()) {
                        this.f3148h.f3108f = this.f3142b.Q[0].e();
                        this.f3149i.f3108f = -this.f3142b.Q[1].e();
                        return;
                    }
                    f fVarH = h(this.f3142b.Q[0]);
                    if (fVarH != null) {
                        b(this.f3148h, fVarH, this.f3142b.Q[0].e());
                    }
                    f fVarH2 = h(this.f3142b.Q[1]);
                    if (fVarH2 != null) {
                        b(this.f3149i, fVarH2, -this.f3142b.Q[1].e());
                    }
                    this.f3148h.f3104b = true;
                    this.f3149i.f3104b = true;
                    return;
                }
                if (dVarArr[0].f3057f != null) {
                    f fVarH3 = h(dVarArr[0]);
                    if (fVarH3 != null) {
                        b(this.f3148h, fVarH3, this.f3142b.Q[0].e());
                        b(this.f3149i, this.f3148h, this.f3145e.f3109g);
                        return;
                    }
                    return;
                }
                if (dVarArr[1].f3057f != null) {
                    f fVarH4 = h(dVarArr[1]);
                    if (fVarH4 != null) {
                        b(this.f3149i, fVarH4, -this.f3142b.Q[1].e());
                        b(this.f3148h, this.f3149i, -this.f3145e.f3109g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof c.g.b.k.h) || eVar2.I() == null || this.f3142b.m(c.g.b.k.d.b.CENTER).f3057f != null) {
                    return;
                }
                b(this.f3148h, this.f3142b.I().f3071f.f3148h, this.f3142b.S());
                b(this.f3149i, this.f3148h, this.f3145e.f3109g);
                return;
            }
        }
        if (this.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT) {
            c.g.b.k.e eVar3 = this.f3142b;
            int i2 = eVar3.q;
            if (i2 == 2) {
                c.g.b.k.e eVarI3 = eVar3.I();
                if (eVarI3 != null) {
                    g gVar2 = eVarI3.f3072g.f3145e;
                    this.f3145e.l.add(gVar2);
                    gVar2.f3113k.add(this.f3145e);
                    g gVar3 = this.f3145e;
                    gVar3.f3104b = true;
                    gVar3.f3113k.add(this.f3148h);
                    this.f3145e.f3113k.add(this.f3149i);
                }
            } else if (i2 == 3) {
                if (eVar3.r == 3) {
                    this.f3148h.a = this;
                    this.f3149i.a = this;
                    n nVar = eVar3.f3072g;
                    nVar.f3148h.a = this;
                    nVar.f3149i.a = this;
                    gVar.a = this;
                    if (eVar3.b0()) {
                        this.f3145e.l.add(this.f3142b.f3072g.f3145e);
                        this.f3142b.f3072g.f3145e.f3113k.add(this.f3145e);
                        n nVar2 = this.f3142b.f3072g;
                        nVar2.f3145e.a = this;
                        this.f3145e.l.add(nVar2.f3148h);
                        this.f3145e.l.add(this.f3142b.f3072g.f3149i);
                        this.f3142b.f3072g.f3148h.f3113k.add(this.f3145e);
                        this.f3142b.f3072g.f3149i.f3113k.add(this.f3145e);
                    } else if (this.f3142b.Z()) {
                        this.f3142b.f3072g.f3145e.l.add(this.f3145e);
                        this.f3145e.f3113k.add(this.f3142b.f3072g.f3145e);
                    } else {
                        this.f3142b.f3072g.f3145e.l.add(this.f3145e);
                    }
                } else {
                    g gVar4 = eVar3.f3072g.f3145e;
                    gVar.l.add(gVar4);
                    gVar4.f3113k.add(this.f3145e);
                    this.f3142b.f3072g.f3148h.f3113k.add(this.f3145e);
                    this.f3142b.f3072g.f3149i.f3113k.add(this.f3145e);
                    g gVar5 = this.f3145e;
                    gVar5.f3104b = true;
                    gVar5.f3113k.add(this.f3148h);
                    this.f3145e.f3113k.add(this.f3149i);
                    this.f3148h.l.add(this.f3145e);
                    this.f3149i.l.add(this.f3145e);
                }
            }
        }
        c.g.b.k.e eVar4 = this.f3142b;
        c.g.b.k.d[] dVarArr2 = eVar4.Q;
        if (dVarArr2[0].f3057f != null && dVarArr2[1].f3057f != null) {
            if (eVar4.Z()) {
                this.f3148h.f3108f = this.f3142b.Q[0].e();
                this.f3149i.f3108f = -this.f3142b.Q[1].e();
                return;
            }
            f fVarH5 = h(this.f3142b.Q[0]);
            f fVarH6 = h(this.f3142b.Q[1]);
            fVarH5.b(this);
            fVarH6.b(this);
            this.f3150j = p.b.CENTER;
            return;
        }
        if (dVarArr2[0].f3057f != null) {
            f fVarH7 = h(dVarArr2[0]);
            if (fVarH7 != null) {
                b(this.f3148h, fVarH7, this.f3142b.Q[0].e());
                c(this.f3149i, this.f3148h, 1, this.f3145e);
                return;
            }
            return;
        }
        if (dVarArr2[1].f3057f != null) {
            f fVarH8 = h(dVarArr2[1]);
            if (fVarH8 != null) {
                b(this.f3149i, fVarH8, -this.f3142b.Q[1].e());
                c(this.f3148h, this.f3149i, -1, this.f3145e);
                return;
            }
            return;
        }
        if ((eVar4 instanceof c.g.b.k.h) || eVar4.I() == null) {
            return;
        }
        b(this.f3148h, this.f3142b.I().f3071f.f3148h, this.f3142b.S());
        c(this.f3149i, this.f3148h, 1, this.f3145e);
    }

    @Override // c.g.b.k.m.p
    public void e() {
        f fVar = this.f3148h;
        if (fVar.f3112j) {
            this.f3142b.V0(fVar.f3109g);
        }
    }

    @Override // c.g.b.k.m.p
    void f() {
        this.f3143c = null;
        this.f3148h.c();
        this.f3149i.c();
        this.f3145e.c();
        this.f3147g = false;
    }

    @Override // c.g.b.k.m.p
    boolean m() {
        return this.f3144d != c.g.b.k.e.b.MATCH_CONSTRAINT || this.f3142b.q == 0;
    }

    void r() {
        this.f3147g = false;
        this.f3148h.c();
        this.f3148h.f3112j = false;
        this.f3149i.c();
        this.f3149i.f3112j = false;
        this.f3145e.f3112j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f3142b.r();
    }
}
