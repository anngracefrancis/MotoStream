package c.g.b.k.m;

/* JADX INFO: compiled from: WidgetRun.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p implements d {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    c.g.b.k.e f3142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    m f3143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected c.g.b.k.e.b f3144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    g f3145e = new g(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3146f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f3147g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f3148h = new f(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f3149i = new f(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected b f3150j = b.NONE;

    /* JADX INFO: compiled from: WidgetRun.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.g.b.k.d.b.values().length];
            a = iArr;
            try {
                iArr[c.g.b.k.d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.g.b.k.d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.g.b.k.d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.g.b.k.d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.g.b.k.d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: WidgetRun.java */
    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(c.g.b.k.e eVar) {
        this.f3142b = eVar;
    }

    private void l(int i2, int i3) {
        int i4 = this.a;
        if (i4 == 0) {
            this.f3145e.d(g(i3, i2));
            return;
        }
        if (i4 == 1) {
            this.f3145e.d(Math.min(g(this.f3145e.m, i2), i3));
            return;
        }
        if (i4 == 2) {
            c.g.b.k.e eVarI = this.f3142b.I();
            if (eVarI != null) {
                g gVar = (i2 == 0 ? eVarI.f3071f : eVarI.f3072g).f3145e;
                if (gVar.f3112j) {
                    c.g.b.k.e eVar = this.f3142b;
                    this.f3145e.d(g((int) ((gVar.f3109g * (i2 == 0 ? eVar.v : eVar.y)) + 0.5f), i2));
                    return;
                }
                return;
            }
            return;
        }
        if (i4 != 3) {
            return;
        }
        c.g.b.k.e eVar2 = this.f3142b;
        p pVar = eVar2.f3071f;
        c.g.b.k.e.b bVar = pVar.f3144d;
        c.g.b.k.e.b bVar2 = c.g.b.k.e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && pVar.a == 3) {
            n nVar = eVar2.f3072g;
            if (nVar.f3144d == bVar2 && nVar.a == 3) {
                return;
            }
        }
        if (i2 == 0) {
            pVar = eVar2.f3072g;
        }
        if (pVar.f3145e.f3112j) {
            float fT = eVar2.t();
            this.f3145e.d(i2 == 1 ? (int) ((pVar.f3145e.f3109g / fT) + 0.5f) : (int) ((fT * pVar.f3145e.f3109g) + 0.5f));
        }
    }

    @Override // c.g.b.k.m.d
    public void a(d dVar) {
    }

    protected final void b(f fVar, f fVar2, int i2) {
        fVar.l.add(fVar2);
        fVar.f3108f = i2;
        fVar2.f3113k.add(fVar);
    }

    protected final void c(f fVar, f fVar2, int i2, g gVar) {
        fVar.l.add(fVar2);
        fVar.l.add(this.f3145e);
        fVar.f3110h = i2;
        fVar.f3111i = gVar;
        fVar2.f3113k.add(fVar);
        gVar.f3113k.add(fVar);
    }

    abstract void d();

    abstract void e();

    abstract void f();

    protected final int g(int i2, int i3) {
        int iMax;
        if (i3 == 0) {
            c.g.b.k.e eVar = this.f3142b;
            int i4 = eVar.u;
            iMax = Math.max(eVar.t, i2);
            if (i4 > 0) {
                iMax = Math.min(i4, i2);
            }
            if (iMax == i2) {
                return i2;
            }
        } else {
            c.g.b.k.e eVar2 = this.f3142b;
            int i5 = eVar2.x;
            iMax = Math.max(eVar2.w, i2);
            if (i5 > 0) {
                iMax = Math.min(i5, i2);
            }
            if (iMax == i2) {
                return i2;
            }
        }
        return iMax;
    }

    protected final f h(c.g.b.k.d dVar) {
        c.g.b.k.d dVar2 = dVar.f3057f;
        if (dVar2 == null) {
            return null;
        }
        c.g.b.k.e eVar = dVar2.f3055d;
        int i2 = a.a[dVar2.f3056e.ordinal()];
        if (i2 == 1) {
            return eVar.f3071f.f3148h;
        }
        if (i2 == 2) {
            return eVar.f3071f.f3149i;
        }
        if (i2 == 3) {
            return eVar.f3072g.f3148h;
        }
        if (i2 == 4) {
            return eVar.f3072g.f3128k;
        }
        if (i2 != 5) {
            return null;
        }
        return eVar.f3072g.f3149i;
    }

    protected final f i(c.g.b.k.d dVar, int i2) {
        c.g.b.k.d dVar2 = dVar.f3057f;
        if (dVar2 == null) {
            return null;
        }
        c.g.b.k.e eVar = dVar2.f3055d;
        p pVar = i2 == 0 ? eVar.f3071f : eVar.f3072g;
        int i3 = a.a[dVar2.f3056e.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f3149i;
        }
        return pVar.f3148h;
    }

    public long j() {
        g gVar = this.f3145e;
        if (gVar.f3112j) {
            return gVar.f3109g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f3147g;
    }

    abstract boolean m();

    protected void n(d dVar, c.g.b.k.d dVar2, c.g.b.k.d dVar3, int i2) {
        f fVarH = h(dVar2);
        f fVarH2 = h(dVar3);
        if (fVarH.f3112j && fVarH2.f3112j) {
            int iE = fVarH.f3109g + dVar2.e();
            int iE2 = fVarH2.f3109g - dVar3.e();
            int i3 = iE2 - iE;
            if (!this.f3145e.f3112j && this.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT) {
                l(i2, i3);
            }
            g gVar = this.f3145e;
            if (gVar.f3112j) {
                if (gVar.f3109g == i3) {
                    this.f3148h.d(iE);
                    this.f3149i.d(iE2);
                    return;
                }
                c.g.b.k.e eVar = this.f3142b;
                float fW = i2 == 0 ? eVar.w() : eVar.M();
                if (fVarH == fVarH2) {
                    iE = fVarH.f3109g;
                    iE2 = fVarH2.f3109g;
                    fW = 0.5f;
                }
                this.f3148h.d((int) (iE + 0.5f + (((iE2 - iE) - this.f3145e.f3109g) * fW)));
                this.f3149i.d(this.f3148h.f3109g + this.f3145e.f3109g);
            }
        }
    }

    protected void o(d dVar) {
    }

    protected void p(d dVar) {
    }
}
