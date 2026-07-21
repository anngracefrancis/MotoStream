package c.g.b.k;

import java.util.ArrayList;

/* JADX INFO: compiled from: ChainHead.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    protected e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected e f3043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected e f3044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected e f3045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected e f3046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected e f3047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected e f3048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected ArrayList<e> f3049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f3050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f3051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected float f3052k = 0.0f;
    int l;
    int m;
    int n;
    boolean o;
    private int p;
    private boolean q;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    private boolean v;

    public c(e eVar, int i2, boolean z) {
        this.q = false;
        this.a = eVar;
        this.p = i2;
        this.q = z;
    }

    private void b() {
        int i2 = this.p * 2;
        e eVar = this.a;
        this.o = true;
        e eVar2 = eVar;
        boolean z = false;
        while (!z) {
            this.f3050i++;
            e[] eVarArr = eVar.y0;
            int i3 = this.p;
            e eVar3 = null;
            eVarArr[i3] = null;
            eVar.x0[i3] = null;
            if (eVar.Q() != 8) {
                this.l++;
                e.b bVarS = eVar.s(this.p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarS != bVar) {
                    this.m += eVar.C(this.p);
                }
                int iE = this.m + eVar.Q[i2].e();
                this.m = iE;
                int i4 = i2 + 1;
                this.m = iE + eVar.Q[i4].e();
                int iE2 = this.n + eVar.Q[i2].e();
                this.n = iE2;
                this.n = iE2 + eVar.Q[i4].e();
                if (this.f3043b == null) {
                    this.f3043b = eVar;
                }
                this.f3045d = eVar;
                e.b[] bVarArr = eVar.T;
                int i5 = this.p;
                if (bVarArr[i5] == bVar) {
                    int[] iArr = eVar.s;
                    if (iArr[i5] == 0 || iArr[i5] == 3 || iArr[i5] == 2) {
                        this.f3051j++;
                        float[] fArr = eVar.w0;
                        float f2 = fArr[i5];
                        if (f2 > 0.0f) {
                            this.f3052k += fArr[i5];
                        }
                        if (c(eVar, i5)) {
                            if (f2 < 0.0f) {
                                this.r = true;
                            } else {
                                this.s = true;
                            }
                            if (this.f3049h == null) {
                                this.f3049h = new ArrayList<>();
                            }
                            this.f3049h.add(eVar);
                        }
                        if (this.f3047f == null) {
                            this.f3047f = eVar;
                        }
                        e eVar4 = this.f3048g;
                        if (eVar4 != null) {
                            eVar4.x0[this.p] = eVar;
                        }
                        this.f3048g = eVar;
                    }
                    if (this.p == 0) {
                        if (eVar.q != 0 || eVar.t != 0 || eVar.u != 0) {
                            this.o = false;
                        }
                    } else if (eVar.r != 0 || eVar.w != 0 || eVar.x != 0) {
                        this.o = false;
                    }
                    if (eVar.X != 0.0f) {
                        this.o = false;
                        this.u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.y0[this.p] = eVar;
            }
            d dVar = eVar.Q[i2 + 1].f3057f;
            if (dVar != null) {
                e eVar5 = dVar.f3055d;
                d[] dVarArr = eVar5.Q;
                if (dVarArr[i2].f3057f != null && dVarArr[i2].f3057f.f3055d == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f3043b;
        if (eVar6 != null) {
            this.m -= eVar6.Q[i2].e();
        }
        e eVar7 = this.f3045d;
        if (eVar7 != null) {
            this.m -= eVar7.Q[i2 + 1].e();
        }
        this.f3044c = eVar;
        if (this.p == 0 && this.q) {
            this.f3046e = eVar;
        } else {
            this.f3046e = this.a;
        }
        this.t = this.s && this.r;
    }

    private static boolean c(e eVar, int i2) {
        if (eVar.Q() != 8 && eVar.T[i2] == e.b.MATCH_CONSTRAINT) {
            int[] iArr = eVar.s;
            if (iArr[i2] == 0 || iArr[i2] == 3) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (!this.v) {
            b();
        }
        this.v = true;
    }
}
