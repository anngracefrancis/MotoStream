package c.g.b.k.m;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: DependencyGraph.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private c.g.b.k.f a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c.g.b.k.f f3098d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3096b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3097c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<p> f3099e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<m> f3100f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b.InterfaceC0070b f3101g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b.a f3102h = new b.a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ArrayList<m> f3103i = new ArrayList<>();

    public e(c.g.b.k.f fVar) {
        this.a = fVar;
        this.f3098d = fVar;
    }

    private void a(f fVar, int i2, int i3, f fVar2, ArrayList<m> arrayList, m mVar) {
        p pVar = fVar.f3106d;
        if (pVar.f3143c == null) {
            c.g.b.k.f fVar3 = this.a;
            if (pVar == fVar3.f3071f || pVar == fVar3.f3072g) {
                return;
            }
            if (mVar == null) {
                mVar = new m(pVar, i3);
                arrayList.add(mVar);
            }
            pVar.f3143c = mVar;
            mVar.a(pVar);
            for (d dVar : pVar.f3148h.f3113k) {
                if (dVar instanceof f) {
                    a((f) dVar, i2, 0, fVar2, arrayList, mVar);
                }
            }
            for (d dVar2 : pVar.f3149i.f3113k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i2, 1, fVar2, arrayList, mVar);
                }
            }
            if (i2 == 1 && (pVar instanceof n)) {
                for (d dVar3 : ((n) pVar).f3128k.f3113k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i2, 2, fVar2, arrayList, mVar);
                    }
                }
            }
            for (f fVar4 : pVar.f3148h.l) {
                if (fVar4 == fVar2) {
                    mVar.f3122c = true;
                }
                a(fVar4, i2, 0, fVar2, arrayList, mVar);
            }
            for (f fVar5 : pVar.f3149i.l) {
                if (fVar5 == fVar2) {
                    mVar.f3122c = true;
                }
                a(fVar5, i2, 1, fVar2, arrayList, mVar);
            }
            if (i2 == 1 && (pVar instanceof n)) {
                Iterator<f> it = ((n) pVar).f3128k.l.iterator();
                while (it.hasNext()) {
                    a(it.next(), i2, 2, fVar2, arrayList, mVar);
                }
            }
        }
    }

    private boolean b(c.g.b.k.f fVar) {
        int iR;
        c.g.b.k.e.b bVar;
        int iV;
        c.g.b.k.e.b bVar2;
        c.g.b.k.e.b bVar3;
        c.g.b.k.e.b bVar4;
        for (c.g.b.k.e eVar : fVar.D0) {
            c.g.b.k.e.b[] bVarArr = eVar.T;
            c.g.b.k.e.b bVar5 = bVarArr[0];
            c.g.b.k.e.b bVar6 = bVarArr[1];
            if (eVar.Q() == 8) {
                eVar.f3067b = true;
            } else {
                if (eVar.v < 1.0f && bVar5 == c.g.b.k.e.b.MATCH_CONSTRAINT) {
                    eVar.q = 2;
                }
                if (eVar.y < 1.0f && bVar6 == c.g.b.k.e.b.MATCH_CONSTRAINT) {
                    eVar.r = 2;
                }
                if (eVar.t() > 0.0f) {
                    c.g.b.k.e.b bVar7 = c.g.b.k.e.b.MATCH_CONSTRAINT;
                    if (bVar5 == bVar7 && (bVar6 == c.g.b.k.e.b.WRAP_CONTENT || bVar6 == c.g.b.k.e.b.FIXED)) {
                        eVar.q = 3;
                    } else if (bVar6 == bVar7 && (bVar5 == c.g.b.k.e.b.WRAP_CONTENT || bVar5 == c.g.b.k.e.b.FIXED)) {
                        eVar.r = 3;
                    } else if (bVar5 == bVar7 && bVar6 == bVar7) {
                        if (eVar.q == 0) {
                            eVar.q = 3;
                        }
                        if (eVar.r == 0) {
                            eVar.r = 3;
                        }
                    }
                }
                c.g.b.k.e.b bVar8 = c.g.b.k.e.b.MATCH_CONSTRAINT;
                if (bVar5 == bVar8 && eVar.q == 1 && (eVar.I.f3057f == null || eVar.K.f3057f == null)) {
                    bVar5 = c.g.b.k.e.b.WRAP_CONTENT;
                }
                c.g.b.k.e.b bVar9 = bVar5;
                if (bVar6 == bVar8 && eVar.r == 1 && (eVar.J.f3057f == null || eVar.L.f3057f == null)) {
                    bVar6 = c.g.b.k.e.b.WRAP_CONTENT;
                }
                c.g.b.k.e.b bVar10 = bVar6;
                l lVar = eVar.f3071f;
                lVar.f3144d = bVar9;
                int i2 = eVar.q;
                lVar.a = i2;
                n nVar = eVar.f3072g;
                nVar.f3144d = bVar10;
                int i3 = eVar.r;
                nVar.a = i3;
                c.g.b.k.e.b bVar11 = c.g.b.k.e.b.MATCH_PARENT;
                if ((bVar9 == bVar11 || bVar9 == c.g.b.k.e.b.FIXED || bVar9 == c.g.b.k.e.b.WRAP_CONTENT) && (bVar10 == bVar11 || bVar10 == c.g.b.k.e.b.FIXED || bVar10 == c.g.b.k.e.b.WRAP_CONTENT)) {
                    int iR2 = eVar.R();
                    if (bVar9 == bVar11) {
                        iR = (fVar.R() - eVar.I.f3058g) - eVar.K.f3058g;
                        bVar = c.g.b.k.e.b.FIXED;
                    } else {
                        iR = iR2;
                        bVar = bVar9;
                    }
                    int iV2 = eVar.v();
                    if (bVar10 == bVar11) {
                        iV = (fVar.v() - eVar.J.f3058g) - eVar.L.f3058g;
                        bVar2 = c.g.b.k.e.b.FIXED;
                    } else {
                        iV = iV2;
                        bVar2 = bVar10;
                    }
                    l(eVar, bVar, iR, bVar2, iV);
                    eVar.f3071f.f3145e.d(eVar.R());
                    eVar.f3072g.f3145e.d(eVar.v());
                    eVar.f3067b = true;
                } else {
                    if (bVar9 == bVar8 && (bVar10 == (bVar4 = c.g.b.k.e.b.WRAP_CONTENT) || bVar10 == c.g.b.k.e.b.FIXED)) {
                        if (i2 == 3) {
                            if (bVar10 == bVar4) {
                                l(eVar, bVar4, 0, bVar4, 0);
                            }
                            int iV3 = eVar.v();
                            int i4 = (int) ((iV3 * eVar.X) + 0.5f);
                            c.g.b.k.e.b bVar12 = c.g.b.k.e.b.FIXED;
                            l(eVar, bVar12, i4, bVar12, iV3);
                            eVar.f3071f.f3145e.d(eVar.R());
                            eVar.f3072g.f3145e.d(eVar.v());
                            eVar.f3067b = true;
                        } else if (i2 == 1) {
                            l(eVar, bVar4, 0, bVar10, 0);
                            eVar.f3071f.f3145e.m = eVar.R();
                        } else if (i2 == 2) {
                            c.g.b.k.e.b[] bVarArr2 = fVar.T;
                            c.g.b.k.e.b bVar13 = bVarArr2[0];
                            c.g.b.k.e.b bVar14 = c.g.b.k.e.b.FIXED;
                            if (bVar13 == bVar14 || bVarArr2[0] == bVar11) {
                                l(eVar, bVar14, (int) ((eVar.v * fVar.R()) + 0.5f), bVar10, eVar.v());
                                eVar.f3071f.f3145e.d(eVar.R());
                                eVar.f3072g.f3145e.d(eVar.v());
                                eVar.f3067b = true;
                            }
                        } else {
                            c.g.b.k.d[] dVarArr = eVar.Q;
                            if (dVarArr[0].f3057f == null || dVarArr[1].f3057f == null) {
                                l(eVar, bVar4, 0, bVar10, 0);
                                eVar.f3071f.f3145e.d(eVar.R());
                                eVar.f3072g.f3145e.d(eVar.v());
                                eVar.f3067b = true;
                            }
                        }
                    }
                    if (bVar10 == bVar8 && (bVar9 == (bVar3 = c.g.b.k.e.b.WRAP_CONTENT) || bVar9 == c.g.b.k.e.b.FIXED)) {
                        if (i3 == 3) {
                            if (bVar9 == bVar3) {
                                l(eVar, bVar3, 0, bVar3, 0);
                            }
                            int iR3 = eVar.R();
                            float f2 = eVar.X;
                            if (eVar.u() == -1) {
                                f2 = 1.0f / f2;
                            }
                            c.g.b.k.e.b bVar15 = c.g.b.k.e.b.FIXED;
                            l(eVar, bVar15, iR3, bVar15, (int) ((iR3 * f2) + 0.5f));
                            eVar.f3071f.f3145e.d(eVar.R());
                            eVar.f3072g.f3145e.d(eVar.v());
                            eVar.f3067b = true;
                        } else if (i3 == 1) {
                            l(eVar, bVar9, 0, bVar3, 0);
                            eVar.f3072g.f3145e.m = eVar.v();
                        } else if (i3 == 2) {
                            c.g.b.k.e.b[] bVarArr3 = fVar.T;
                            c.g.b.k.e.b bVar16 = bVarArr3[1];
                            c.g.b.k.e.b bVar17 = c.g.b.k.e.b.FIXED;
                            if (bVar16 == bVar17 || bVarArr3[1] == bVar11) {
                                l(eVar, bVar9, eVar.R(), bVar17, (int) ((eVar.y * fVar.v()) + 0.5f));
                                eVar.f3071f.f3145e.d(eVar.R());
                                eVar.f3072g.f3145e.d(eVar.v());
                                eVar.f3067b = true;
                            }
                        } else {
                            c.g.b.k.d[] dVarArr2 = eVar.Q;
                            if (dVarArr2[2].f3057f == null || dVarArr2[3].f3057f == null) {
                                l(eVar, bVar3, 0, bVar10, 0);
                                eVar.f3071f.f3145e.d(eVar.R());
                                eVar.f3072g.f3145e.d(eVar.v());
                                eVar.f3067b = true;
                            }
                        }
                    }
                    if (bVar9 == bVar8 && bVar10 == bVar8) {
                        if (i2 == 1 || i3 == 1) {
                            c.g.b.k.e.b bVar18 = c.g.b.k.e.b.WRAP_CONTENT;
                            l(eVar, bVar18, 0, bVar18, 0);
                            eVar.f3071f.f3145e.m = eVar.R();
                            eVar.f3072g.f3145e.m = eVar.v();
                        } else if (i3 == 2 && i2 == 2) {
                            c.g.b.k.e.b[] bVarArr4 = fVar.T;
                            c.g.b.k.e.b bVar19 = bVarArr4[0];
                            c.g.b.k.e.b bVar20 = c.g.b.k.e.b.FIXED;
                            if (bVar19 == bVar20 || bVarArr4[0] == bVar20) {
                                if (bVarArr4[1] == bVar20 || bVarArr4[1] == bVar20) {
                                    l(eVar, bVar20, (int) ((eVar.v * fVar.R()) + 0.5f), bVar20, (int) ((eVar.y * fVar.v()) + 0.5f));
                                    eVar.f3071f.f3145e.d(eVar.R());
                                    eVar.f3072g.f3145e.d(eVar.v());
                                    eVar.f3067b = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int e(c.g.b.k.f fVar, int i2) {
        int size = this.f3103i.size();
        long jMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            jMax = Math.max(jMax, this.f3103i.get(i3).b(fVar, i2));
        }
        return (int) jMax;
    }

    private void i(p pVar, int i2, ArrayList<m> arrayList) {
        for (d dVar : pVar.f3148h.f3113k) {
            if (dVar instanceof f) {
                a((f) dVar, i2, 0, pVar.f3149i, arrayList, null);
            } else if (dVar instanceof p) {
                a(((p) dVar).f3148h, i2, 0, pVar.f3149i, arrayList, null);
            }
        }
        for (d dVar2 : pVar.f3149i.f3113k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i2, 1, pVar.f3148h, arrayList, null);
            } else if (dVar2 instanceof p) {
                a(((p) dVar2).f3149i, i2, 1, pVar.f3148h, arrayList, null);
            }
        }
        if (i2 == 1) {
            for (d dVar3 : ((n) pVar).f3128k.f3113k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i2, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(c.g.b.k.e eVar, c.g.b.k.e.b bVar, int i2, c.g.b.k.e.b bVar2, int i3) {
        b.a aVar = this.f3102h;
        aVar.f3087d = bVar;
        aVar.f3088e = bVar2;
        aVar.f3089f = i2;
        aVar.f3090g = i3;
        this.f3101g.b(eVar, aVar);
        eVar.U0(this.f3102h.f3091h);
        eVar.v0(this.f3102h.f3092i);
        eVar.u0(this.f3102h.f3094k);
        eVar.k0(this.f3102h.f3093j);
    }

    public void c() {
        d(this.f3099e);
        this.f3103i.clear();
        m.a = 0;
        i(this.a.f3071f, 0, this.f3103i);
        i(this.a.f3072g, 1, this.f3103i);
        this.f3096b = false;
    }

    public void d(ArrayList<p> arrayList) {
        arrayList.clear();
        this.f3098d.f3071f.f();
        this.f3098d.f3072g.f();
        arrayList.add(this.f3098d.f3071f);
        arrayList.add(this.f3098d.f3072g);
        HashSet hashSet = null;
        for (c.g.b.k.e eVar : this.f3098d.D0) {
            if (eVar instanceof c.g.b.k.g) {
                arrayList.add(new j(eVar));
            } else {
                if (eVar.Z()) {
                    if (eVar.f3069d == null) {
                        eVar.f3069d = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f3069d);
                } else {
                    arrayList.add(eVar.f3071f);
                }
                if (eVar.b0()) {
                    if (eVar.f3070e == null) {
                        eVar.f3070e = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f3070e);
                } else {
                    arrayList.add(eVar.f3072g);
                }
                if (eVar instanceof c.g.b.k.i) {
                    arrayList.add(new k(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<p> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        for (p pVar : arrayList) {
            if (pVar.f3142b != this.f3098d) {
                pVar.d();
            }
        }
    }

    public boolean f(boolean z) {
        boolean z2;
        boolean z3 = true;
        boolean z4 = z & true;
        if (this.f3096b || this.f3097c) {
            for (c.g.b.k.e eVar : this.a.D0) {
                eVar.l();
                eVar.f3067b = false;
                eVar.f3071f.r();
                eVar.f3072g.q();
            }
            this.a.l();
            c.g.b.k.f fVar = this.a;
            fVar.f3067b = false;
            fVar.f3071f.r();
            this.a.f3072g.q();
            this.f3097c = false;
        }
        if (b(this.f3098d)) {
            return false;
        }
        this.a.V0(0);
        this.a.W0(0);
        c.g.b.k.e.b bVarS = this.a.s(0);
        c.g.b.k.e.b bVarS2 = this.a.s(1);
        if (this.f3096b) {
            c();
        }
        int iS = this.a.S();
        int iT = this.a.T();
        this.a.f3071f.f3148h.d(iS);
        this.a.f3072g.f3148h.d(iT);
        m();
        c.g.b.k.e.b bVar = c.g.b.k.e.b.WRAP_CONTENT;
        if (bVarS == bVar || bVarS2 == bVar) {
            if (z4) {
                Iterator<p> it = this.f3099e.iterator();
                while (it.hasNext()) {
                    if (!it.next().m()) {
                        z4 = false;
                        break;
                    }
                }
            }
            if (z4 && bVarS == c.g.b.k.e.b.WRAP_CONTENT) {
                this.a.z0(c.g.b.k.e.b.FIXED);
                c.g.b.k.f fVar2 = this.a;
                fVar2.U0(e(fVar2, 0));
                c.g.b.k.f fVar3 = this.a;
                fVar3.f3071f.f3145e.d(fVar3.R());
            }
            if (z4 && bVarS2 == c.g.b.k.e.b.WRAP_CONTENT) {
                this.a.Q0(c.g.b.k.e.b.FIXED);
                c.g.b.k.f fVar4 = this.a;
                fVar4.v0(e(fVar4, 1));
                c.g.b.k.f fVar5 = this.a;
                fVar5.f3072g.f3145e.d(fVar5.v());
            }
        }
        c.g.b.k.f fVar6 = this.a;
        c.g.b.k.e.b[] bVarArr = fVar6.T;
        c.g.b.k.e.b bVar2 = bVarArr[0];
        c.g.b.k.e.b bVar3 = c.g.b.k.e.b.FIXED;
        if (bVar2 == bVar3 || bVarArr[0] == c.g.b.k.e.b.MATCH_PARENT) {
            int iR = fVar6.R() + iS;
            this.a.f3071f.f3149i.d(iR);
            this.a.f3071f.f3145e.d(iR - iS);
            m();
            c.g.b.k.f fVar7 = this.a;
            c.g.b.k.e.b[] bVarArr2 = fVar7.T;
            if (bVarArr2[1] == bVar3 || bVarArr2[1] == c.g.b.k.e.b.MATCH_PARENT) {
                int iV = fVar7.v() + iT;
                this.a.f3072g.f3149i.d(iV);
                this.a.f3072g.f3145e.d(iV - iT);
            }
            m();
            z2 = true;
        } else {
            z2 = false;
        }
        for (p pVar : this.f3099e) {
            if (pVar.f3142b != this.a || pVar.f3147g) {
                pVar.e();
            }
        }
        for (p pVar2 : this.f3099e) {
            if (z2 || pVar2.f3142b != this.a) {
                if (!pVar2.f3148h.f3112j || ((!pVar2.f3149i.f3112j && !(pVar2 instanceof j)) || (!pVar2.f3145e.f3112j && !(pVar2 instanceof c) && !(pVar2 instanceof j)))) {
                    z3 = false;
                    break;
                }
            }
        }
        this.a.z0(bVarS);
        this.a.Q0(bVarS2);
        return z3;
    }

    public boolean g(boolean z) {
        if (this.f3096b) {
            for (c.g.b.k.e eVar : this.a.D0) {
                eVar.l();
                eVar.f3067b = false;
                l lVar = eVar.f3071f;
                lVar.f3145e.f3112j = false;
                lVar.f3147g = false;
                lVar.r();
                n nVar = eVar.f3072g;
                nVar.f3145e.f3112j = false;
                nVar.f3147g = false;
                nVar.q();
            }
            this.a.l();
            c.g.b.k.f fVar = this.a;
            fVar.f3067b = false;
            l lVar2 = fVar.f3071f;
            lVar2.f3145e.f3112j = false;
            lVar2.f3147g = false;
            lVar2.r();
            n nVar2 = this.a.f3072g;
            nVar2.f3145e.f3112j = false;
            nVar2.f3147g = false;
            nVar2.q();
            c();
        }
        if (b(this.f3098d)) {
            return false;
        }
        this.a.V0(0);
        this.a.W0(0);
        this.a.f3071f.f3148h.d(0);
        this.a.f3072g.f3148h.d(0);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c5  */
    public boolean h(boolean z, int i2) {
        boolean z2;
        c.g.b.k.e.b bVar;
        boolean z3 = true;
        boolean z4 = z & true;
        c.g.b.k.e.b bVarS = this.a.s(0);
        c.g.b.k.e.b bVarS2 = this.a.s(1);
        int iS = this.a.S();
        int iT = this.a.T();
        if (z4 && (bVarS == (bVar = c.g.b.k.e.b.WRAP_CONTENT) || bVarS2 == bVar)) {
            for (p pVar : this.f3099e) {
                if (pVar.f3146f == i2 && !pVar.m()) {
                    z4 = false;
                    break;
                }
            }
            if (i2 == 0) {
                if (z4 && bVarS == c.g.b.k.e.b.WRAP_CONTENT) {
                    this.a.z0(c.g.b.k.e.b.FIXED);
                    c.g.b.k.f fVar = this.a;
                    fVar.U0(e(fVar, 0));
                    c.g.b.k.f fVar2 = this.a;
                    fVar2.f3071f.f3145e.d(fVar2.R());
                }
            } else if (z4 && bVarS2 == c.g.b.k.e.b.WRAP_CONTENT) {
                this.a.Q0(c.g.b.k.e.b.FIXED);
                c.g.b.k.f fVar3 = this.a;
                fVar3.v0(e(fVar3, 1));
                c.g.b.k.f fVar4 = this.a;
                fVar4.f3072g.f3145e.d(fVar4.v());
            }
        }
        if (i2 == 0) {
            c.g.b.k.f fVar5 = this.a;
            c.g.b.k.e.b[] bVarArr = fVar5.T;
            if (bVarArr[0] == c.g.b.k.e.b.FIXED || bVarArr[0] == c.g.b.k.e.b.MATCH_PARENT) {
                int iR = fVar5.R() + iS;
                this.a.f3071f.f3149i.d(iR);
                this.a.f3071f.f3145e.d(iR - iS);
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            c.g.b.k.f fVar6 = this.a;
            c.g.b.k.e.b[] bVarArr2 = fVar6.T;
            if (bVarArr2[1] == c.g.b.k.e.b.FIXED || bVarArr2[1] == c.g.b.k.e.b.MATCH_PARENT) {
                int iV = fVar6.v() + iT;
                this.a.f3072g.f3149i.d(iV);
                this.a.f3072g.f3145e.d(iV - iT);
                z2 = true;
            } else {
                z2 = false;
            }
        }
        m();
        for (p pVar2 : this.f3099e) {
            if (pVar2.f3146f == i2 && (pVar2.f3142b != this.a || pVar2.f3147g)) {
                pVar2.e();
            }
        }
        for (p pVar3 : this.f3099e) {
            if (pVar3.f3146f == i2 && (z2 || pVar3.f3142b != this.a)) {
                if (!pVar3.f3148h.f3112j || !pVar3.f3149i.f3112j || (!(pVar3 instanceof c) && !pVar3.f3145e.f3112j)) {
                    z3 = false;
                    break;
                }
            }
        }
        this.a.z0(bVarS);
        this.a.Q0(bVarS2);
        return z3;
    }

    public void j() {
        this.f3096b = true;
    }

    public void k() {
        this.f3097c = true;
    }

    public void m() {
        g gVar;
        for (c.g.b.k.e eVar : this.a.D0) {
            if (!eVar.f3067b) {
                c.g.b.k.e.b[] bVarArr = eVar.T;
                boolean z = false;
                c.g.b.k.e.b bVar = bVarArr[0];
                c.g.b.k.e.b bVar2 = bVarArr[1];
                int i2 = eVar.q;
                int i3 = eVar.r;
                c.g.b.k.e.b bVar3 = c.g.b.k.e.b.WRAP_CONTENT;
                boolean z2 = bVar == bVar3 || (bVar == c.g.b.k.e.b.MATCH_CONSTRAINT && i2 == 1);
                if (bVar2 == bVar3 || (bVar2 == c.g.b.k.e.b.MATCH_CONSTRAINT && i3 == 1)) {
                    z = true;
                }
                g gVar2 = eVar.f3071f.f3145e;
                boolean z3 = gVar2.f3112j;
                g gVar3 = eVar.f3072g.f3145e;
                boolean z4 = gVar3.f3112j;
                if (z3 && z4) {
                    c.g.b.k.e.b bVar4 = c.g.b.k.e.b.FIXED;
                    l(eVar, bVar4, gVar2.f3109g, bVar4, gVar3.f3109g);
                    eVar.f3067b = true;
                } else if (z3 && z) {
                    l(eVar, c.g.b.k.e.b.FIXED, gVar2.f3109g, bVar3, gVar3.f3109g);
                    if (bVar2 == c.g.b.k.e.b.MATCH_CONSTRAINT) {
                        eVar.f3072g.f3145e.m = eVar.v();
                    } else {
                        eVar.f3072g.f3145e.d(eVar.v());
                        eVar.f3067b = true;
                    }
                } else if (z4 && z2) {
                    l(eVar, bVar3, gVar2.f3109g, c.g.b.k.e.b.FIXED, gVar3.f3109g);
                    if (bVar == c.g.b.k.e.b.MATCH_CONSTRAINT) {
                        eVar.f3071f.f3145e.m = eVar.R();
                    } else {
                        eVar.f3071f.f3145e.d(eVar.R());
                        eVar.f3067b = true;
                    }
                }
                if (eVar.f3067b && (gVar = eVar.f3072g.l) != null) {
                    gVar.d(eVar.n());
                }
            }
        }
    }

    public void n(b.InterfaceC0070b interfaceC0070b) {
        this.f3101g = interfaceC0070b;
    }
}
