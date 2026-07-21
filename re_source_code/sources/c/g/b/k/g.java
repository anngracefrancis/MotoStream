package c.g.b.k;

/* JADX INFO: compiled from: Guideline.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends e {
    protected float D0 = -1.0f;
    protected int E0 = -1;
    protected int F0 = -1;
    private d G0 = this.J;
    private int H0 = 0;
    private int I0 = 0;
    private boolean J0;

    /* JADX INFO: compiled from: Guideline.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.b.values().length];
            a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public g() {
        this.R.clear();
        this.R.add(this.G0);
        int length = this.Q.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.Q[i2] = this.G0;
        }
    }

    @Override // c.g.b.k.e
    public void Z0(c.g.b.d dVar, boolean z) {
        if (I() == null) {
            return;
        }
        int iX = dVar.x(this.G0);
        if (this.H0 == 1) {
            V0(iX);
            W0(0);
            v0(I().v());
            U0(0);
            return;
        }
        V0(0);
        W0(iX);
        U0(I().R());
        v0(0);
    }

    public d a1() {
        return this.G0;
    }

    public int b1() {
        return this.H0;
    }

    public int c1() {
        return this.E0;
    }

    public int d1() {
        return this.F0;
    }

    @Override // c.g.b.k.e
    public boolean e0() {
        return this.J0;
    }

    public float e1() {
        return this.D0;
    }

    @Override // c.g.b.k.e
    public boolean f0() {
        return this.J0;
    }

    public void f1(int i2) {
        this.G0.s(i2);
        this.J0 = true;
    }

    @Override // c.g.b.k.e
    public void g(c.g.b.d dVar, boolean z) {
        f fVar = (f) I();
        if (fVar == null) {
            return;
        }
        d dVarM = fVar.m(d.b.LEFT);
        d dVarM2 = fVar.m(d.b.RIGHT);
        e eVar = this.U;
        boolean z2 = eVar != null && eVar.T[0] == e.b.WRAP_CONTENT;
        if (this.H0 == 0) {
            dVarM = fVar.m(d.b.TOP);
            dVarM2 = fVar.m(d.b.BOTTOM);
            e eVar2 = this.U;
            z2 = eVar2 != null && eVar2.T[1] == e.b.WRAP_CONTENT;
        }
        if (this.J0 && this.G0.m()) {
            c.g.b.i iVarQ = dVar.q(this.G0);
            dVar.f(iVarQ, this.G0.d());
            if (this.E0 != -1) {
                if (z2) {
                    dVar.h(dVar.q(dVarM2), iVarQ, 0, 5);
                }
            } else if (this.F0 != -1 && z2) {
                c.g.b.i iVarQ2 = dVar.q(dVarM2);
                dVar.h(iVarQ, dVar.q(dVarM), 0, 5);
                dVar.h(iVarQ2, iVarQ, 0, 5);
            }
            this.J0 = false;
            return;
        }
        if (this.E0 != -1) {
            c.g.b.i iVarQ3 = dVar.q(this.G0);
            dVar.e(iVarQ3, dVar.q(dVarM), this.E0, 8);
            if (z2) {
                dVar.h(dVar.q(dVarM2), iVarQ3, 0, 5);
                return;
            }
            return;
        }
        if (this.F0 == -1) {
            if (this.D0 != -1.0f) {
                dVar.d(c.g.b.d.s(dVar, dVar.q(this.G0), dVar.q(dVarM2), this.D0));
                return;
            }
            return;
        }
        c.g.b.i iVarQ4 = dVar.q(this.G0);
        c.g.b.i iVarQ5 = dVar.q(dVarM2);
        dVar.e(iVarQ4, iVarQ5, -this.F0, 8);
        if (z2) {
            dVar.h(iVarQ4, dVar.q(dVarM), 0, 5);
            dVar.h(iVarQ5, iVarQ4, 0, 5);
        }
    }

    public void g1(int i2) {
        if (i2 > -1) {
            this.D0 = -1.0f;
            this.E0 = i2;
            this.F0 = -1;
        }
    }

    @Override // c.g.b.k.e
    public boolean h() {
        return true;
    }

    public void h1(int i2) {
        if (i2 > -1) {
            this.D0 = -1.0f;
            this.E0 = -1;
            this.F0 = i2;
        }
    }

    public void i1(float f2) {
        if (f2 > -1.0f) {
            this.D0 = f2;
            this.E0 = -1;
            this.F0 = -1;
        }
    }

    public void j1(int i2) {
        if (this.H0 == i2) {
            return;
        }
        this.H0 = i2;
        this.R.clear();
        if (this.H0 == 1) {
            this.G0 = this.I;
        } else {
            this.G0 = this.J;
        }
        this.R.add(this.G0);
        int length = this.Q.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.Q[i3] = this.G0;
        }
    }

    @Override // c.g.b.k.e
    public d m(d.b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
            case 2:
                if (this.H0 == 1) {
                    return this.G0;
                }
                break;
            case 3:
            case 4:
                if (this.H0 == 0) {
                    return this.G0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(bVar.name());
    }
}
