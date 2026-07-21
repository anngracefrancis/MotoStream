package c.g.b.k;

/* JADX INFO: compiled from: Barrier.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends i {
    private int F0 = 0;
    private boolean G0 = true;
    private int H0 = 0;
    boolean I0 = false;

    public boolean c1() {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        boolean z = true;
        while (true) {
            i2 = this.E0;
            if (i5 >= i2) {
                break;
            }
            e eVar = this.D0[i5];
            if ((this.G0 || eVar.h()) && ((((i3 = this.F0) == 0 || i3 == 1) && !eVar.e0()) || (((i4 = this.F0) == 2 || i4 == 3) && !eVar.f0()))) {
                z = false;
            }
            i5++;
        }
        if (!z || i2 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.E0; i6++) {
            e eVar2 = this.D0[i6];
            if (this.G0 || eVar2.h()) {
                if (!z2) {
                    int i7 = this.F0;
                    if (i7 == 0) {
                        iMax = eVar2.m(d.b.LEFT).d();
                    } else if (i7 == 1) {
                        iMax = eVar2.m(d.b.RIGHT).d();
                    } else if (i7 == 2) {
                        iMax = eVar2.m(d.b.TOP).d();
                    } else if (i7 == 3) {
                        iMax = eVar2.m(d.b.BOTTOM).d();
                    }
                    z2 = true;
                }
                int i8 = this.F0;
                if (i8 == 0) {
                    iMax = Math.min(iMax, eVar2.m(d.b.LEFT).d());
                } else if (i8 == 1) {
                    iMax = Math.max(iMax, eVar2.m(d.b.RIGHT).d());
                } else if (i8 == 2) {
                    iMax = Math.min(iMax, eVar2.m(d.b.TOP).d());
                } else if (i8 == 3) {
                    iMax = Math.max(iMax, eVar2.m(d.b.BOTTOM).d());
                }
            }
        }
        int i9 = iMax + this.H0;
        int i10 = this.F0;
        if (i10 == 0 || i10 == 1) {
            p0(i9, i9);
        } else {
            s0(i9, i9);
        }
        this.I0 = true;
        return true;
    }

    public boolean d1() {
        return this.G0;
    }

    @Override // c.g.b.k.e
    public boolean e0() {
        return this.I0;
    }

    public int e1() {
        return this.F0;
    }

    @Override // c.g.b.k.e
    public boolean f0() {
        return this.I0;
    }

    public int f1() {
        return this.H0;
    }

    @Override // c.g.b.k.e
    public void g(c.g.b.d dVar, boolean z) {
        d[] dVarArr;
        boolean z2;
        int i2;
        int i3;
        int i4;
        d[] dVarArr2 = this.Q;
        dVarArr2[0] = this.I;
        dVarArr2[2] = this.J;
        dVarArr2[1] = this.K;
        dVarArr2[3] = this.L;
        int i5 = 0;
        while (true) {
            dVarArr = this.Q;
            if (i5 >= dVarArr.length) {
                break;
            }
            dVarArr[i5].f3060i = dVar.q(dVarArr[i5]);
            i5++;
        }
        int i6 = this.F0;
        if (i6 < 0 || i6 >= 4) {
            return;
        }
        d dVar2 = dVarArr[i6];
        if (!this.I0) {
            c1();
        }
        if (this.I0) {
            this.I0 = false;
            int i7 = this.F0;
            if (i7 == 0 || i7 == 1) {
                dVar.f(this.I.f3060i, this.Z);
                dVar.f(this.K.f3060i, this.Z);
                return;
            } else {
                if (i7 == 2 || i7 == 3) {
                    dVar.f(this.J.f3060i, this.a0);
                    dVar.f(this.L.f3060i, this.a0);
                    return;
                }
                return;
            }
        }
        int i8 = 0;
        while (true) {
            if (i8 >= this.E0) {
                z2 = false;
                break;
            }
            e eVar = this.D0[i8];
            if ((this.G0 || eVar.h()) && ((((i3 = this.F0) == 0 || i3 == 1) && eVar.y() == e.b.MATCH_CONSTRAINT && eVar.I.f3057f != null && eVar.K.f3057f != null) || (((i4 = this.F0) == 2 || i4 == 3) && eVar.O() == e.b.MATCH_CONSTRAINT && eVar.J.f3057f != null && eVar.L.f3057f != null))) {
                z2 = true;
                break;
            }
            i8++;
        }
        boolean z3 = this.I.k() || this.K.k();
        boolean z4 = this.J.k() || this.L.k();
        int i9 = !z2 && (((i2 = this.F0) == 0 && z3) || ((i2 == 2 && z4) || ((i2 == 1 && z3) || (i2 == 3 && z4)))) ? 5 : 4;
        for (int i10 = 0; i10 < this.E0; i10++) {
            e eVar2 = this.D0[i10];
            if (this.G0 || eVar2.h()) {
                c.g.b.i iVarQ = dVar.q(eVar2.Q[this.F0]);
                d[] dVarArr3 = eVar2.Q;
                int i11 = this.F0;
                dVarArr3[i11].f3060i = iVarQ;
                int i12 = (dVarArr3[i11].f3057f == null || dVarArr3[i11].f3057f.f3055d != this) ? 0 : dVarArr3[i11].f3058g + 0;
                if (i11 == 0 || i11 == 2) {
                    dVar.i(dVar2.f3060i, iVarQ, this.H0 - i12, z2);
                } else {
                    dVar.g(dVar2.f3060i, iVarQ, this.H0 + i12, z2);
                }
                dVar.e(dVar2.f3060i, iVarQ, this.H0 + i12, i9);
            }
        }
        int i13 = this.F0;
        if (i13 == 0) {
            dVar.e(this.K.f3060i, this.I.f3060i, 0, 8);
            dVar.e(this.I.f3060i, this.U.K.f3060i, 0, 4);
            dVar.e(this.I.f3060i, this.U.I.f3060i, 0, 0);
            return;
        }
        if (i13 == 1) {
            dVar.e(this.I.f3060i, this.K.f3060i, 0, 8);
            dVar.e(this.I.f3060i, this.U.I.f3060i, 0, 4);
            dVar.e(this.I.f3060i, this.U.K.f3060i, 0, 0);
        } else if (i13 == 2) {
            dVar.e(this.L.f3060i, this.J.f3060i, 0, 8);
            dVar.e(this.J.f3060i, this.U.L.f3060i, 0, 4);
            dVar.e(this.J.f3060i, this.U.J.f3060i, 0, 0);
        } else if (i13 == 3) {
            dVar.e(this.J.f3060i, this.L.f3060i, 0, 8);
            dVar.e(this.J.f3060i, this.U.J.f3060i, 0, 4);
            dVar.e(this.J.f3060i, this.U.L.f3060i, 0, 0);
        }
    }

    public int g1() {
        int i2 = this.F0;
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return (i2 == 2 || i2 == 3) ? 1 : -1;
    }

    @Override // c.g.b.k.e
    public boolean h() {
        return true;
    }

    protected void h1() {
        for (int i2 = 0; i2 < this.E0; i2++) {
            e eVar = this.D0[i2];
            int i3 = this.F0;
            if (i3 == 0 || i3 == 1) {
                eVar.C0(0, true);
            } else if (i3 == 2 || i3 == 3) {
                eVar.C0(1, true);
            }
        }
    }

    public void i1(boolean z) {
        this.G0 = z;
    }

    public void j1(int i2) {
        this.F0 = i2;
    }

    public void k1(int i2) {
        this.H0 = i2;
    }

    @Override // c.g.b.k.e
    public String toString() {
        String str = "[Barrier] " + r() + " {";
        for (int i2 = 0; i2 < this.E0; i2++) {
            e eVar = this.D0[i2];
            if (i2 > 0) {
                str = str + ", ";
            }
            str = str + eVar.r();
        }
        return str + "}";
    }
}
