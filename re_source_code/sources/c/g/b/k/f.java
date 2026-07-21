package c.g.b.k;

import com.google.android.gms.ads.AdRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: ConstraintWidgetContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends l {
    public c.g.b.e I0;
    int K0;
    int L0;
    int M0;
    int N0;
    c.g.b.k.m.b E0 = new c.g.b.k.m.b(this);
    public c.g.b.k.m.e F0 = new c.g.b.k.m.e(this);
    protected c.g.b.k.m.b.InterfaceC0070b G0 = null;
    private boolean H0 = false;
    protected c.g.b.d J0 = new c.g.b.d();
    public int O0 = 0;
    public int P0 = 0;
    c[] Q0 = new c[4];
    c[] R0 = new c[4];
    public boolean S0 = false;
    public boolean T0 = false;
    public boolean U0 = false;
    public int V0 = 0;
    public int W0 = 0;
    private int X0 = 257;
    public boolean Y0 = false;
    private boolean Z0 = false;
    private boolean a1 = false;
    int b1 = 0;
    private WeakReference<d> c1 = null;
    private WeakReference<d> d1 = null;
    private WeakReference<d> e1 = null;
    private WeakReference<d> f1 = null;
    public c.g.b.k.m.b.a g1 = new c.g.b.k.m.b.a();

    public static boolean A1(e eVar, c.g.b.k.m.b.InterfaceC0070b interfaceC0070b, c.g.b.k.m.b.a aVar, int i2) {
        int i3;
        int i4;
        if (interfaceC0070b == null) {
            return false;
        }
        aVar.f3087d = eVar.y();
        aVar.f3088e = eVar.O();
        aVar.f3089f = eVar.R();
        aVar.f3090g = eVar.v();
        aVar.l = false;
        aVar.m = i2;
        e.b bVar = aVar.f3087d;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z = bVar == bVar2;
        boolean z2 = aVar.f3088e == bVar2;
        boolean z3 = z && eVar.X > 0.0f;
        boolean z4 = z2 && eVar.X > 0.0f;
        if (z && eVar.V(0) && eVar.q == 0 && !z3) {
            aVar.f3087d = e.b.WRAP_CONTENT;
            if (z2 && eVar.r == 0) {
                aVar.f3087d = e.b.FIXED;
            }
            z = false;
        }
        if (z2 && eVar.V(1) && eVar.r == 0 && !z4) {
            aVar.f3088e = e.b.WRAP_CONTENT;
            if (z && eVar.q == 0) {
                aVar.f3088e = e.b.FIXED;
            }
            z2 = false;
        }
        if (eVar.e0()) {
            aVar.f3087d = e.b.FIXED;
            z = false;
        }
        if (eVar.f0()) {
            aVar.f3088e = e.b.FIXED;
            z2 = false;
        }
        if (z3) {
            if (eVar.s[0] == 4) {
                aVar.f3087d = e.b.FIXED;
            } else if (!z2) {
                e.b bVar3 = aVar.f3088e;
                e.b bVar4 = e.b.FIXED;
                if (bVar3 == bVar4) {
                    i4 = aVar.f3090g;
                } else {
                    aVar.f3087d = e.b.WRAP_CONTENT;
                    interfaceC0070b.b(eVar, aVar);
                    i4 = aVar.f3092i;
                }
                aVar.f3087d = bVar4;
                int i5 = eVar.Y;
                if (i5 == 0 || i5 == -1) {
                    aVar.f3089f = (int) (eVar.t() * i4);
                } else {
                    aVar.f3089f = (int) (eVar.t() / i4);
                }
            }
        }
        if (z4) {
            if (eVar.s[1] == 4) {
                aVar.f3088e = e.b.FIXED;
            } else if (!z) {
                e.b bVar5 = aVar.f3087d;
                e.b bVar6 = e.b.FIXED;
                if (bVar5 == bVar6) {
                    i3 = aVar.f3089f;
                } else {
                    aVar.f3088e = e.b.WRAP_CONTENT;
                    interfaceC0070b.b(eVar, aVar);
                    i3 = aVar.f3091h;
                }
                aVar.f3088e = bVar6;
                int i6 = eVar.Y;
                if (i6 == 0 || i6 == -1) {
                    aVar.f3090g = (int) (i3 / eVar.t());
                } else {
                    aVar.f3090g = (int) (i3 * eVar.t());
                }
            }
        }
        interfaceC0070b.b(eVar, aVar);
        eVar.U0(aVar.f3091h);
        eVar.v0(aVar.f3092i);
        eVar.u0(aVar.f3094k);
        eVar.k0(aVar.f3093j);
        aVar.m = c.g.b.k.m.b.a.a;
        return aVar.l;
    }

    private void C1() {
        this.O0 = 0;
        this.P0 = 0;
    }

    private void g1(e eVar) {
        int i2 = this.O0 + 1;
        c[] cVarArr = this.R0;
        if (i2 >= cVarArr.length) {
            this.R0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.R0[this.O0] = new c(eVar, 0, x1());
        this.O0++;
    }

    private void j1(d dVar, c.g.b.i iVar) {
        this.J0.h(iVar, this.J0.q(dVar), 0, 5);
    }

    private void k1(d dVar, c.g.b.i iVar) {
        this.J0.h(this.J0.q(dVar), iVar, 0, 5);
    }

    private void l1(e eVar) {
        int i2 = this.P0 + 1;
        c[] cVarArr = this.Q0;
        if (i2 >= cVarArr.length) {
            this.Q0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.Q0[this.P0] = new c(eVar, 1, x1());
        this.P0++;
    }

    public boolean B1(int i2) {
        return (this.X0 & i2) == i2;
    }

    public void D1(c.g.b.k.m.b.InterfaceC0070b interfaceC0070b) {
        this.G0 = interfaceC0070b;
        this.F0.n(interfaceC0070b);
    }

    public void E1(int i2) {
        this.X0 = i2;
        c.g.b.d.a = B1(AdRequest.MAX_CONTENT_URL_LENGTH);
    }

    public void F1(boolean z) {
        this.H0 = z;
    }

    public void G1(c.g.b.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zB1 = B1(64);
        Z0(dVar, zB1);
        int size = this.D0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.D0.get(i2).Z0(dVar, zB1);
        }
    }

    public void H1() {
        this.E0.e(this);
    }

    @Override // c.g.b.k.e
    public void Y0(boolean z, boolean z2) {
        super.Y0(z, z2);
        int size = this.D0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.D0.get(i2).Y0(z, z2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:152:0x02fb A[PHI: r0 r6
      0x02fb: PHI (r0v20 boolean) = (r0v19 boolean), (r0v22 boolean), (r0v22 boolean), (r0v22 boolean) binds: [B:139:0x02bf, B:147:0x02e3, B:148:0x02e5, B:150:0x02eb] A[DONT_GENERATE, DONT_INLINE]
      0x02fb: PHI (r6v11 boolean) = (r6v10 boolean), (r6v13 boolean), (r6v13 boolean), (r6v13 boolean) binds: [B:139:0x02bf, B:147:0x02e3, B:148:0x02e5, B:150:0x02eb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v13 */
    @Override // c.g.b.k.l
    public void b1() {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        ?? r8;
        boolean z3;
        e.b bVar;
        this.Z = 0;
        this.a0 = 0;
        this.Z0 = false;
        this.a1 = false;
        int size = this.D0.size();
        int iMax = Math.max(0, R());
        int iMax2 = Math.max(0, v());
        e.b[] bVarArr = this.T;
        e.b bVar2 = bVarArr[1];
        e.b bVar3 = bVarArr[0];
        WeakReference<d> weakReference = null;
        if (this.I0 != null) {
            throw null;
        }
        if (j.b(this.X0, 1)) {
            c.g.b.k.m.h.h(this, r1());
            for (int i4 = 0; i4 < size; i4++) {
                e eVar = this.D0.get(i4);
                if (eVar.d0() && !(eVar instanceof g) && !(eVar instanceof a) && !(eVar instanceof k) && !eVar.c0()) {
                    e.b bVarS = eVar.s(0);
                    e.b bVarS2 = eVar.s(1);
                    e.b bVar4 = e.b.MATCH_CONSTRAINT;
                    if (!(bVarS == bVar4 && eVar.q != 1 && bVarS2 == bVar4 && eVar.r != 1)) {
                        A1(eVar, this.G0, new c.g.b.k.m.b.a(), c.g.b.k.m.b.a.a);
                    }
                }
            }
        }
        if (size <= 2 || !((bVar3 == (bVar = e.b.WRAP_CONTENT) || bVar2 == bVar) && j.b(this.X0, 1024) && c.g.b.k.m.i.c(this, r1()))) {
            i2 = iMax2;
            i3 = iMax;
            z = false;
        } else {
            if (bVar3 == bVar) {
                if (iMax >= R() || iMax <= 0) {
                    iMax = R();
                } else {
                    U0(iMax);
                    this.Z0 = true;
                }
            }
            if (bVar2 == bVar) {
                if (iMax2 >= v() || iMax2 <= 0) {
                    iMax2 = v();
                } else {
                    v0(iMax2);
                    this.a1 = true;
                }
            }
            i2 = iMax2;
            i3 = iMax;
            z = true;
        }
        boolean z4 = B1(64) || B1(128);
        c.g.b.d dVar = this.J0;
        dVar.q = false;
        dVar.r = false;
        if (this.X0 != 0 && z4) {
            dVar.r = true;
        }
        ArrayList<e> arrayList = this.D0;
        e.b bVarY = y();
        e.b bVar5 = e.b.WRAP_CONTENT;
        boolean z5 = bVarY == bVar5 || O() == bVar5;
        C1();
        for (int i5 = 0; i5 < size; i5++) {
            e eVar2 = this.D0.get(i5);
            if (eVar2 instanceof l) {
                ((l) eVar2).b1();
            }
        }
        boolean zB1 = B1(64);
        boolean z6 = z;
        int i6 = 0;
        boolean zF1 = true;
        while (zF1) {
            int i7 = i6 + 1;
            try {
                this.J0.D();
                C1();
                k(this.J0);
                for (int i8 = 0; i8 < size; i8++) {
                    this.D0.get(i8).k(this.J0);
                }
                zF1 = f1(this.J0);
                WeakReference<d> weakReference2 = this.c1;
                if (weakReference2 != null && weakReference2.get() != null) {
                    k1(this.c1.get(), this.J0.q(this.J));
                    this.c1 = weakReference;
                }
                WeakReference<d> weakReference3 = this.e1;
                if (weakReference3 != null && weakReference3.get() != null) {
                    j1(this.e1.get(), this.J0.q(this.L));
                    this.e1 = weakReference;
                }
                WeakReference<d> weakReference4 = this.d1;
                if (weakReference4 != null && weakReference4.get() != null) {
                    k1(this.d1.get(), this.J0.q(this.I));
                    this.d1 = weakReference;
                }
                WeakReference<d> weakReference5 = this.f1;
                if (weakReference5 != null && weakReference5.get() != null) {
                    j1(this.f1.get(), this.J0.q(this.K));
                    this.f1 = weakReference;
                }
                if (zF1) {
                    this.J0.z();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                System.out.println("EXCEPTION : " + e2);
            }
            if (zF1) {
                G1(this.J0, j.a);
            } else {
                Z0(this.J0, zB1);
                for (int i9 = 0; i9 < size; i9++) {
                    this.D0.get(i9).Z0(this.J0, zB1);
                }
            }
            if (z5 && i7 < 8 && j.a[2]) {
                int iMax3 = 0;
                int iMax4 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    e eVar3 = this.D0.get(i10);
                    iMax3 = Math.max(iMax3, eVar3.Z + eVar3.R());
                    iMax4 = Math.max(iMax4, eVar3.a0 + eVar3.v());
                }
                int iMax5 = Math.max(this.g0, iMax3);
                int iMax6 = Math.max(this.h0, iMax4);
                e.b bVar6 = e.b.WRAP_CONTENT;
                if (bVar3 != bVar6 || R() >= iMax5) {
                    z2 = false;
                } else {
                    U0(iMax5);
                    this.T[0] = bVar6;
                    z2 = true;
                    z6 = true;
                }
                if (bVar2 == bVar6 && v() < iMax6) {
                    v0(iMax6);
                    this.T[1] = bVar6;
                    z2 = true;
                    z6 = true;
                }
            } else {
                z2 = false;
            }
            int iMax7 = Math.max(this.g0, R());
            if (iMax7 > R()) {
                U0(iMax7);
                this.T[0] = e.b.FIXED;
                z2 = true;
                z6 = true;
            }
            int iMax8 = Math.max(this.h0, v());
            if (iMax8 > v()) {
                v0(iMax8);
                r8 = 1;
                this.T[1] = e.b.FIXED;
                z2 = true;
                z3 = true;
            } else {
                r8 = 1;
                z3 = z6;
            }
            if (z3) {
                zF1 = z2;
                z6 = z3;
            } else {
                e.b bVar7 = this.T[0];
                e.b bVar8 = e.b.WRAP_CONTENT;
                if (bVar7 == bVar8 && i3 > 0 && R() > i3) {
                    this.Z0 = r8;
                    this.T[0] = e.b.FIXED;
                    U0(i3);
                    z2 = true;
                    z3 = true;
                }
                if (this.T[r8] != bVar8 || i2 <= 0 || v() <= i2) {
                    zF1 = z2;
                    z6 = z3;
                } else {
                    this.a1 = r8;
                    this.T[r8] = e.b.FIXED;
                    v0(i2);
                    z6 = true;
                    zF1 = true;
                }
            }
            i6 = i7;
            weakReference = null;
        }
        this.D0 = arrayList;
        if (z6) {
            e.b[] bVarArr2 = this.T;
            bVarArr2[0] = bVar3;
            bVarArr2[1] = bVar2;
        }
        j0(this.J0.v());
    }

    void e1(e eVar, int i2) {
        if (i2 == 0) {
            g1(eVar);
        } else if (i2 == 1) {
            l1(eVar);
        }
    }

    public boolean f1(c.g.b.d dVar) {
        boolean zB1 = B1(64);
        g(dVar, zB1);
        int size = this.D0.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.D0.get(i2);
            eVar.C0(0, false);
            eVar.C0(1, false);
            if (eVar instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                e eVar2 = this.D0.get(i3);
                if (eVar2 instanceof a) {
                    ((a) eVar2).h1();
                }
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            e eVar3 = this.D0.get(i4);
            if (eVar3.f()) {
                eVar3.g(dVar, zB1);
            }
        }
        if (c.g.b.d.a) {
            HashSet<e> hashSet = new HashSet<>();
            for (int i5 = 0; i5 < size; i5++) {
                e eVar4 = this.D0.get(i5);
                if (!eVar4.f()) {
                    hashSet.add(eVar4);
                }
            }
            e(this, dVar, hashSet, y() == e.b.WRAP_CONTENT ? 0 : 1, false);
            for (e eVar5 : hashSet) {
                j.a(this, dVar, eVar5);
                eVar5.g(dVar, zB1);
            }
        } else {
            for (int i6 = 0; i6 < size; i6++) {
                e eVar6 = this.D0.get(i6);
                if (eVar6 instanceof f) {
                    e.b[] bVarArr = eVar6.T;
                    e.b bVar = bVarArr[0];
                    e.b bVar2 = bVarArr[1];
                    e.b bVar3 = e.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        eVar6.z0(e.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.Q0(e.b.FIXED);
                    }
                    eVar6.g(dVar, zB1);
                    if (bVar == bVar3) {
                        eVar6.z0(bVar);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.Q0(bVar2);
                    }
                } else {
                    j.a(this, dVar, eVar6);
                    if (!eVar6.f()) {
                        eVar6.g(dVar, zB1);
                    }
                }
            }
        }
        if (this.O0 > 0) {
            b.b(this, dVar, null, 0);
        }
        if (this.P0 > 0) {
            b.b(this, dVar, null, 1);
        }
        return true;
    }

    @Override // c.g.b.k.l, c.g.b.k.e
    public void h0() {
        this.J0.D();
        this.K0 = 0;
        this.M0 = 0;
        this.L0 = 0;
        this.N0 = 0;
        this.Y0 = false;
        super.h0();
    }

    public void h1(d dVar) {
        WeakReference<d> weakReference = this.f1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > this.f1.get().d()) {
            this.f1 = new WeakReference<>(dVar);
        }
    }

    public void i1(d dVar) {
        WeakReference<d> weakReference = this.d1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > this.d1.get().d()) {
            this.d1 = new WeakReference<>(dVar);
        }
    }

    void m1(d dVar) {
        WeakReference<d> weakReference = this.e1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > this.e1.get().d()) {
            this.e1 = new WeakReference<>(dVar);
        }
    }

    void n1(d dVar) {
        WeakReference<d> weakReference = this.c1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > this.c1.get().d()) {
            this.c1 = new WeakReference<>(dVar);
        }
    }

    public boolean o1(boolean z) {
        return this.F0.f(z);
    }

    public boolean p1(boolean z) {
        return this.F0.g(z);
    }

    public boolean q1(boolean z, int i2) {
        return this.F0.h(z, i2);
    }

    public c.g.b.k.m.b.InterfaceC0070b r1() {
        return this.G0;
    }

    public int s1() {
        return this.X0;
    }

    public c.g.b.d t1() {
        return this.J0;
    }

    public void u1() {
        this.F0.j();
    }

    public void v1() {
        this.F0.k();
    }

    public boolean w1() {
        return this.a1;
    }

    public boolean x1() {
        return this.H0;
    }

    public boolean y1() {
        return this.Z0;
    }

    public long z1(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.K0 = i9;
        this.L0 = i10;
        return this.E0.d(this, i2, i9, i10, i3, i4, i5, i6, i7, i8);
    }
}
