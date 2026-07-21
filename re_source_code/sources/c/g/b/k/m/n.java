package c.g.b.k.m;

/* JADX INFO: compiled from: VerticalWidgetRun.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f3128k;
    g l;

    /* JADX INFO: compiled from: VerticalWidgetRun.java */
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

    public n(c.g.b.k.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f3128k = fVar;
        this.l = null;
        this.f3148h.f3107e = f.a.TOP;
        this.f3149i.f3107e = f.a.BOTTOM;
        fVar.f3107e = f.a.BASELINE;
        this.f3146f = 1;
    }

    @Override // c.g.b.k.m.p, c.g.b.k.m.d
    public void a(d dVar) {
        float f2;
        float fT;
        float fT2;
        int i2;
        int i3 = a.a[this.f3150j.ordinal()];
        if (i3 == 1) {
            p(dVar);
        } else if (i3 == 2) {
            o(dVar);
        } else if (i3 == 3) {
            c.g.b.k.e eVar = this.f3142b;
            n(dVar, eVar.J, eVar.L, 1);
            return;
        }
        g gVar = this.f3145e;
        if (gVar.f3105c && !gVar.f3112j && this.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT) {
            c.g.b.k.e eVar2 = this.f3142b;
            int i4 = eVar2.r;
            if (i4 == 2) {
                c.g.b.k.e eVarI = eVar2.I();
                if (eVarI != null) {
                    g gVar2 = eVarI.f3072g.f3145e;
                    if (gVar2.f3112j) {
                        this.f3145e.d((int) ((gVar2.f3109g * this.f3142b.y) + 0.5f));
                    }
                }
            } else if (i4 == 3 && eVar2.f3071f.f3145e.f3112j) {
                int iU = eVar2.u();
                if (iU != -1) {
                    if (iU == 0) {
                        c.g.b.k.e eVar3 = this.f3142b;
                        fT2 = eVar3.f3071f.f3145e.f3109g * eVar3.t();
                        i2 = (int) (fT2 + 0.5f);
                    } else if (iU != 1) {
                        i2 = 0;
                    } else {
                        c.g.b.k.e eVar4 = this.f3142b;
                        f2 = eVar4.f3071f.f3145e.f3109g;
                        fT = eVar4.t();
                    }
                    this.f3145e.d(i2);
                } else {
                    c.g.b.k.e eVar5 = this.f3142b;
                    f2 = eVar5.f3071f.f3145e.f3109g;
                    fT = eVar5.t();
                }
                fT2 = f2 / fT;
                i2 = (int) (fT2 + 0.5f);
                this.f3145e.d(i2);
            }
        }
        f fVar = this.f3148h;
        if (fVar.f3105c) {
            f fVar2 = this.f3149i;
            if (fVar2.f3105c) {
                if (fVar.f3112j && fVar2.f3112j && this.f3145e.f3112j) {
                    return;
                }
                if (!this.f3145e.f3112j && this.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT) {
                    c.g.b.k.e eVar6 = this.f3142b;
                    if (eVar6.q == 0 && !eVar6.b0()) {
                        f fVar3 = this.f3148h.l.get(0);
                        f fVar4 = this.f3149i.l.get(0);
                        int i5 = fVar3.f3109g;
                        f fVar5 = this.f3148h;
                        int i6 = i5 + fVar5.f3108f;
                        int i7 = fVar4.f3109g + this.f3149i.f3108f;
                        fVar5.d(i6);
                        this.f3149i.d(i7);
                        this.f3145e.d(i7 - i6);
                        return;
                    }
                }
                if (!this.f3145e.f3112j && this.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT && this.a == 1 && this.f3148h.l.size() > 0 && this.f3149i.l.size() > 0) {
                    f fVar6 = this.f3148h.l.get(0);
                    int i8 = (this.f3149i.l.get(0).f3109g + this.f3149i.f3108f) - (fVar6.f3109g + this.f3148h.f3108f);
                    g gVar3 = this.f3145e;
                    int i9 = gVar3.m;
                    if (i8 < i9) {
                        gVar3.d(i8);
                    } else {
                        gVar3.d(i9);
                    }
                }
                if (this.f3145e.f3112j && this.f3148h.l.size() > 0 && this.f3149i.l.size() > 0) {
                    f fVar7 = this.f3148h.l.get(0);
                    f fVar8 = this.f3149i.l.get(0);
                    int i10 = fVar7.f3109g + this.f3148h.f3108f;
                    int i11 = fVar8.f3109g + this.f3149i.f3108f;
                    float fM = this.f3142b.M();
                    if (fVar7 == fVar8) {
                        i10 = fVar7.f3109g;
                        i11 = fVar8.f3109g;
                        fM = 0.5f;
                    }
                    this.f3148h.d((int) (i10 + 0.5f + (((i11 - i10) - this.f3145e.f3109g) * fM)));
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
            this.f3145e.d(eVar.v());
        }
        if (!this.f3145e.f3112j) {
            this.f3144d = this.f3142b.O();
            if (this.f3142b.U()) {
                this.l = new c.g.b.k.m.a(this);
            }
            c.g.b.k.e.b bVar = this.f3144d;
            if (bVar != c.g.b.k.e.b.MATCH_CONSTRAINT) {
                if (bVar == c.g.b.k.e.b.MATCH_PARENT && (eVarI2 = this.f3142b.I()) != null && eVarI2.O() == c.g.b.k.e.b.FIXED) {
                    int iV = (eVarI2.v() - this.f3142b.J.e()) - this.f3142b.L.e();
                    b(this.f3148h, eVarI2.f3072g.f3148h, this.f3142b.J.e());
                    b(this.f3149i, eVarI2.f3072g.f3149i, -this.f3142b.L.e());
                    this.f3145e.d(iV);
                    return;
                }
                if (this.f3144d == c.g.b.k.e.b.FIXED) {
                    this.f3145e.d(this.f3142b.v());
                }
            }
        } else if (this.f3144d == c.g.b.k.e.b.MATCH_PARENT && (eVarI = this.f3142b.I()) != null && eVarI.O() == c.g.b.k.e.b.FIXED) {
            b(this.f3148h, eVarI.f3072g.f3148h, this.f3142b.J.e());
            b(this.f3149i, eVarI.f3072g.f3149i, -this.f3142b.L.e());
            return;
        }
        g gVar = this.f3145e;
        boolean z = gVar.f3112j;
        if (z) {
            c.g.b.k.e eVar2 = this.f3142b;
            if (eVar2.f3067b) {
                c.g.b.k.d[] dVarArr = eVar2.Q;
                if (dVarArr[2].f3057f != null && dVarArr[3].f3057f != null) {
                    if (eVar2.b0()) {
                        this.f3148h.f3108f = this.f3142b.Q[2].e();
                        this.f3149i.f3108f = -this.f3142b.Q[3].e();
                    } else {
                        f fVarH = h(this.f3142b.Q[2]);
                        if (fVarH != null) {
                            b(this.f3148h, fVarH, this.f3142b.Q[2].e());
                        }
                        f fVarH2 = h(this.f3142b.Q[3]);
                        if (fVarH2 != null) {
                            b(this.f3149i, fVarH2, -this.f3142b.Q[3].e());
                        }
                        this.f3148h.f3104b = true;
                        this.f3149i.f3104b = true;
                    }
                    if (this.f3142b.U()) {
                        b(this.f3128k, this.f3148h, this.f3142b.n());
                        return;
                    }
                    return;
                }
                if (dVarArr[2].f3057f != null) {
                    f fVarH3 = h(dVarArr[2]);
                    if (fVarH3 != null) {
                        b(this.f3148h, fVarH3, this.f3142b.Q[2].e());
                        b(this.f3149i, this.f3148h, this.f3145e.f3109g);
                        if (this.f3142b.U()) {
                            b(this.f3128k, this.f3148h, this.f3142b.n());
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (dVarArr[3].f3057f != null) {
                    f fVarH4 = h(dVarArr[3]);
                    if (fVarH4 != null) {
                        b(this.f3149i, fVarH4, -this.f3142b.Q[3].e());
                        b(this.f3148h, this.f3149i, -this.f3145e.f3109g);
                    }
                    if (this.f3142b.U()) {
                        b(this.f3128k, this.f3148h, this.f3142b.n());
                        return;
                    }
                    return;
                }
                if (dVarArr[4].f3057f != null) {
                    f fVarH5 = h(dVarArr[4]);
                    if (fVarH5 != null) {
                        b(this.f3128k, fVarH5, 0);
                        b(this.f3148h, this.f3128k, -this.f3142b.n());
                        b(this.f3149i, this.f3148h, this.f3145e.f3109g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof c.g.b.k.h) || eVar2.I() == null || this.f3142b.m(c.g.b.k.d.b.CENTER).f3057f != null) {
                    return;
                }
                b(this.f3148h, this.f3142b.I().f3072g.f3148h, this.f3142b.T());
                b(this.f3149i, this.f3148h, this.f3145e.f3109g);
                if (this.f3142b.U()) {
                    b(this.f3128k, this.f3148h, this.f3142b.n());
                    return;
                }
                return;
            }
        }
        if (z || this.f3144d != c.g.b.k.e.b.MATCH_CONSTRAINT) {
            gVar.b(this);
        } else {
            c.g.b.k.e eVar3 = this.f3142b;
            int i2 = eVar3.r;
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
            } else if (i2 == 3 && !eVar3.b0()) {
                c.g.b.k.e eVar4 = this.f3142b;
                if (eVar4.q != 3) {
                    g gVar4 = eVar4.f3071f.f3145e;
                    this.f3145e.l.add(gVar4);
                    gVar4.f3113k.add(this.f3145e);
                    g gVar5 = this.f3145e;
                    gVar5.f3104b = true;
                    gVar5.f3113k.add(this.f3148h);
                    this.f3145e.f3113k.add(this.f3149i);
                }
            }
        }
        c.g.b.k.e eVar5 = this.f3142b;
        c.g.b.k.d[] dVarArr2 = eVar5.Q;
        if (dVarArr2[2].f3057f != null && dVarArr2[3].f3057f != null) {
            if (eVar5.b0()) {
                this.f3148h.f3108f = this.f3142b.Q[2].e();
                this.f3149i.f3108f = -this.f3142b.Q[3].e();
            } else {
                f fVarH6 = h(this.f3142b.Q[2]);
                f fVarH7 = h(this.f3142b.Q[3]);
                fVarH6.b(this);
                fVarH7.b(this);
                this.f3150j = p.b.CENTER;
            }
            if (this.f3142b.U()) {
                c(this.f3128k, this.f3148h, 1, this.l);
            }
        } else if (dVarArr2[2].f3057f != null) {
            f fVarH8 = h(dVarArr2[2]);
            if (fVarH8 != null) {
                b(this.f3148h, fVarH8, this.f3142b.Q[2].e());
                c(this.f3149i, this.f3148h, 1, this.f3145e);
                if (this.f3142b.U()) {
                    c(this.f3128k, this.f3148h, 1, this.l);
                }
                c.g.b.k.e.b bVar2 = this.f3144d;
                c.g.b.k.e.b bVar3 = c.g.b.k.e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f3142b.t() > 0.0f) {
                    l lVar = this.f3142b.f3071f;
                    if (lVar.f3144d == bVar3) {
                        lVar.f3145e.f3113k.add(this.f3145e);
                        this.f3145e.l.add(this.f3142b.f3071f.f3145e);
                        this.f3145e.a = this;
                    }
                }
            }
        } else if (dVarArr2[3].f3057f != null) {
            f fVarH9 = h(dVarArr2[3]);
            if (fVarH9 != null) {
                b(this.f3149i, fVarH9, -this.f3142b.Q[3].e());
                c(this.f3148h, this.f3149i, -1, this.f3145e);
                if (this.f3142b.U()) {
                    c(this.f3128k, this.f3148h, 1, this.l);
                }
            }
        } else if (dVarArr2[4].f3057f != null) {
            f fVarH10 = h(dVarArr2[4]);
            if (fVarH10 != null) {
                b(this.f3128k, fVarH10, 0);
                c(this.f3148h, this.f3128k, -1, this.l);
                c(this.f3149i, this.f3148h, 1, this.f3145e);
            }
        } else if (!(eVar5 instanceof c.g.b.k.h) && eVar5.I() != null) {
            b(this.f3148h, this.f3142b.I().f3072g.f3148h, this.f3142b.T());
            c(this.f3149i, this.f3148h, 1, this.f3145e);
            if (this.f3142b.U()) {
                c(this.f3128k, this.f3148h, 1, this.l);
            }
            c.g.b.k.e.b bVar4 = this.f3144d;
            c.g.b.k.e.b bVar5 = c.g.b.k.e.b.MATCH_CONSTRAINT;
            if (bVar4 == bVar5 && this.f3142b.t() > 0.0f) {
                l lVar2 = this.f3142b.f3071f;
                if (lVar2.f3144d == bVar5) {
                    lVar2.f3145e.f3113k.add(this.f3145e);
                    this.f3145e.l.add(this.f3142b.f3071f.f3145e);
                    this.f3145e.a = this;
                }
            }
        }
        if (this.f3145e.l.size() == 0) {
            this.f3145e.f3105c = true;
        }
    }

    @Override // c.g.b.k.m.p
    public void e() {
        f fVar = this.f3148h;
        if (fVar.f3112j) {
            this.f3142b.W0(fVar.f3109g);
        }
    }

    @Override // c.g.b.k.m.p
    void f() {
        this.f3143c = null;
        this.f3148h.c();
        this.f3149i.c();
        this.f3128k.c();
        this.f3145e.c();
        this.f3147g = false;
    }

    @Override // c.g.b.k.m.p
    boolean m() {
        return this.f3144d != c.g.b.k.e.b.MATCH_CONSTRAINT || this.f3142b.r == 0;
    }

    void q() {
        this.f3147g = false;
        this.f3148h.c();
        this.f3148h.f3112j = false;
        this.f3149i.c();
        this.f3149i.f3112j = false;
        this.f3128k.c();
        this.f3128k.f3112j = false;
        this.f3145e.f3112j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f3142b.r();
    }
}
