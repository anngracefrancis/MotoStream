package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.collections.z;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.w1.d;
import kotlin.reflect.y.internal.j0.l.w1.e;
import kotlin.reflect.y.internal.j0.l.w1.h;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.reflect.y.internal.j0.l.w1.l;
import kotlin.reflect.y.internal.j0.l.w1.n;
import kotlin.reflect.y.internal.j0.l.w1.o;
import kotlin.reflect.y.internal.j0.l.w1.p;
import kotlin.reflect.y.internal.j0.l.w1.u;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final f a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f24705b;

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f24706b;

        static {
            int[] iArr = new int[u.values().length];
            iArr[u.INV.ordinal()] = 1;
            iArr[u.OUT.ordinal()] = 2;
            iArr[u.IN.ordinal()] = 3;
            a = iArr;
            int[] iArr2 = new int[d1.b.values().length];
            iArr2[d1.b.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[d1.b.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[d1.b.SKIP_LOWER.ordinal()] = 3;
            f24706b = iArr2;
        }
    }

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    static final class b extends Lambda implements Function1<d1.a, kotlin.u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<k> f24707f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d1 f24708g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ p f24709h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ k f24710i;

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        static final class a extends Lambda implements Function0<Boolean> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d1 f24711f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ p f24712g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ k f24713h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ k f24714i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d1 d1Var, p pVar, k kVar, k kVar2) {
                super(0);
                this.f24711f = d1Var;
                this.f24712g = pVar;
                this.f24713h = kVar;
                this.f24714i = kVar2;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(f.a.q(this.f24711f, this.f24712g.r(this.f24713h), this.f24714i));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(List<? extends k> list, d1 d1Var, p pVar, k kVar) {
            super(1);
            this.f24707f = list;
            this.f24708g = d1Var;
            this.f24709h = pVar;
            this.f24710i = kVar;
        }

        public final void b(d1.a aVar) {
            m.f(aVar, "$this$runForkingPoint");
            Iterator<k> it = this.f24707f.iterator();
            while (it.hasNext()) {
                aVar.a(new a(this.f24708g, this.f24709h, it.next(), this.f24710i));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.u invoke(d1.a aVar) {
            b(aVar);
            return kotlin.u.a;
        }
    }

    private f() {
    }

    private final Boolean a(d1 d1Var, k kVar, k kVar2) {
        p pVarJ = d1Var.j();
        if (!pVarJ.J(kVar) && !pVarJ.J(kVar2)) {
            return null;
        }
        if (d(pVarJ, kVar) && d(pVarJ, kVar2)) {
            return Boolean.TRUE;
        }
        if (pVarJ.J(kVar)) {
            if (e(pVarJ, d1Var, kVar, kVar2, false)) {
                return Boolean.TRUE;
            }
        } else if (pVarJ.J(kVar2) && (c(pVarJ, kVar) || e(pVarJ, d1Var, kVar2, kVar, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    private static final boolean b(p pVar, k kVar) {
        if (!(kVar instanceof d)) {
            return false;
        }
        kotlin.reflect.y.internal.j0.l.w1.m mVarS = pVar.S(pVar.d0((d) kVar));
        return !pVar.L(mVarS) && pVar.J(pVar.T(pVar.x0(mVarS)));
    }

    private static final boolean c(p pVar, k kVar) {
        boolean z;
        n nVarC = pVar.c(kVar);
        if (nVarC instanceof h) {
            Collection<i> collectionT = pVar.t(nVarC);
            if ((collectionT instanceof Collection) && collectionT.isEmpty()) {
                z = false;
            } else {
                Iterator<T> it = collectionT.iterator();
                while (it.hasNext()) {
                    k kVarA = pVar.a((i) it.next());
                    if (kVarA != null && pVar.J(kVarA)) {
                        z = true;
                    }
                }
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static final boolean d(p pVar, k kVar) {
        return pVar.J(kVar) || b(pVar, kVar);
    }

    private static final boolean e(p pVar, d1 d1Var, k kVar, k kVar2, boolean z) {
        Collection<i> collectionV = pVar.v(kVar);
        if (!(collectionV instanceof Collection) || !collectionV.isEmpty()) {
            for (i iVar : collectionV) {
                if (m.a(pVar.w(iVar), pVar.c(kVar2)) || (z && t(a, d1Var, kVar2, iVar, false, 8, null))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:82:0x0129  */
    private final Boolean f(d1 d1Var, k kVar, k kVar2) {
        k kVarH;
        o oVarM;
        p pVarJ = d1Var.j();
        boolean z = false;
        if (pVarJ.Y(kVar) || pVarJ.Y(kVar2)) {
            if (d1Var.m()) {
                return Boolean.TRUE;
            }
            return (!pVarJ.W(kVar) || pVarJ.W(kVar2)) ? Boolean.valueOf(d.a.b(pVarJ, pVarJ.d(kVar, false), pVarJ.d(kVar2, false))) : Boolean.FALSE;
        }
        if (pVarJ.w0(kVar) && pVarJ.w0(kVar2)) {
            return Boolean.valueOf(a.p(pVarJ, kVar, kVar2) || d1Var.n());
        }
        if (pVarJ.n0(kVar) || pVarJ.n0(kVar2)) {
            return Boolean.valueOf(d1Var.n());
        }
        e eVarS0 = pVarJ.s0(kVar2);
        if (eVarS0 == null || (kVarH = pVarJ.H(eVarS0)) == null) {
            kVarH = kVar2;
        }
        d dVarF = pVarJ.f(kVarH);
        i iVarU = dVarF != null ? pVarJ.U(dVarF) : null;
        if (dVarF != null && iVarU != null) {
            if (pVarJ.W(kVar2)) {
                iVarU = pVarJ.G(iVarU, true);
            } else if (pVarJ.C(kVar2)) {
                iVarU = pVarJ.Q(iVarU);
            }
            i iVar = iVarU;
            int i2 = a.f24706b[d1Var.g(kVar, dVarF).ordinal()];
            if (i2 == 1) {
                return Boolean.valueOf(t(a, d1Var, kVar, iVar, false, 8, null));
            }
            if (i2 == 2 && t(a, d1Var, kVar, iVar, false, 8, null)) {
                return Boolean.TRUE;
            }
        }
        n nVarC = pVarJ.c(kVar2);
        if (pVarJ.Z(nVarC)) {
            pVarJ.W(kVar2);
            Collection<i> collectionT = pVarJ.t(nVarC);
            if ((collectionT instanceof Collection) && collectionT.isEmpty()) {
                z = true;
            } else {
                Iterator<T> it = collectionT.iterator();
                while (it.hasNext()) {
                    if (!t(a, d1Var, kVar, (i) it.next(), false, 8, null)) {
                    }
                }
                z = true;
            }
            return Boolean.valueOf(z);
        }
        n nVarC2 = pVarJ.c(kVar);
        if (kVar instanceof d) {
            oVarM = a.m(d1Var.j(), kVar2, kVar);
            if (oVarM != null && pVarJ.o(oVarM, pVarJ.c(kVar2))) {
                return Boolean.TRUE;
            }
        } else if (pVarJ.Z(nVarC2)) {
            Collection<i> collectionT2 = pVarJ.t(nVarC2);
            if (!(collectionT2 instanceof Collection) || !collectionT2.isEmpty()) {
                Iterator<T> it2 = collectionT2.iterator();
                do {
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                } while (((i) it2.next()) instanceof d);
            } else {
                z = true;
                break;
            }
            if (z) {
                oVarM = a.m(d1Var.j(), kVar2, kVar);
                if (oVarM != null) {
                    return Boolean.TRUE;
                }
            }
        }
        return null;
    }

    private final List<k> g(d1 d1Var, k kVar, n nVar) {
        d1.c cVarA;
        p pVarJ = d1Var.j();
        List<k> listN = pVarJ.n(kVar, nVar);
        if (listN != null) {
            return listN;
        }
        if (!pVarJ.V(nVar) && pVarJ.v0(kVar)) {
            return kotlin.collections.u.j();
        }
        if (pVarJ.u0(nVar)) {
            if (!pVarJ.A0(pVarJ.c(kVar), nVar)) {
                return kotlin.collections.u.j();
            }
            k kVarR0 = pVarJ.r0(kVar, kotlin.reflect.y.internal.j0.l.w1.b.FOR_SUBTYPING);
            if (kVarR0 != null) {
                kVar = kVarR0;
            }
            return t.e(kVar);
        }
        kotlin.p002reflect.jvm.internal.impl.utils.e eVar = new kotlin.p002reflect.jvm.internal.impl.utils.e();
        d1Var.k();
        ArrayDeque<k> arrayDequeH = d1Var.h();
        m.c(arrayDequeH);
        Set<k> setI = d1Var.i();
        m.c(setI);
        arrayDequeH.push(kVar);
        while (!arrayDequeH.isEmpty()) {
            if (setI.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + kVar + ". Supertypes = " + c0.e0(setI, null, null, null, 0, null, null, 63, null)).toString());
            }
            k kVarPop = arrayDequeH.pop();
            m.e(kVarPop, "current");
            if (setI.add(kVarPop)) {
                k kVarR1 = pVarJ.r0(kVarPop, kotlin.reflect.y.internal.j0.l.w1.b.FOR_SUBTYPING);
                if (kVarR1 == null) {
                    kVarR1 = kVarPop;
                }
                if (pVarJ.A0(pVarJ.c(kVarR1), nVar)) {
                    eVar.add(kVarR1);
                    cVarA = d1.c.C0394c.a;
                } else {
                    cVarA = pVarJ.j(kVarR1) == 0 ? d1.c.b.a : d1Var.j().A(kVarR1);
                }
                if (!(!m.a(cVarA, d1.c.C0394c.a))) {
                    cVarA = null;
                }
                if (cVarA != null) {
                    p pVarJ2 = d1Var.j();
                    Iterator<i> it = pVarJ2.t(pVarJ2.c(kVarPop)).iterator();
                    while (it.hasNext()) {
                        arrayDequeH.add(cVarA.a(d1Var, it.next()));
                    }
                }
            }
        }
        d1Var.e();
        return eVar;
    }

    private final List<k> h(d1 d1Var, k kVar, n nVar) {
        return w(d1Var, g(d1Var, kVar, nVar));
    }

    private final boolean i(d1 d1Var, i iVar, i iVar2, boolean z) {
        p pVarJ = d1Var.j();
        i iVarO = d1Var.o(d1Var.p(iVar));
        i iVarO2 = d1Var.o(d1Var.p(iVar2));
        f fVar = a;
        Boolean boolF = fVar.f(d1Var, pVarJ.h0(iVarO), pVarJ.T(iVarO2));
        if (boolF == null) {
            Boolean boolC = d1Var.c(iVarO, iVarO2, z);
            return boolC != null ? boolC.booleanValue() : fVar.u(d1Var, pVarJ.h0(iVarO), pVarJ.T(iVarO2));
        }
        boolean zBooleanValue = boolF.booleanValue();
        d1Var.c(iVarO, iVarO2, z);
        return zBooleanValue;
    }

    private final o m(p pVar, i iVar, i iVar2) {
        i iVarX0;
        int iJ = pVar.j(iVar);
        int i2 = 0;
        while (true) {
            if (i2 >= iJ) {
                return null;
            }
            kotlin.reflect.y.internal.j0.l.w1.m mVarG0 = pVar.g0(iVar, i2);
            kotlin.reflect.y.internal.j0.l.w1.m mVar = pVar.L(mVarG0) ^ true ? mVarG0 : null;
            if (mVar != null && (iVarX0 = pVar.x0(mVar)) != null) {
                boolean z = pVar.B(pVar.h0(iVarX0)) && pVar.B(pVar.h0(iVar2));
                if (m.a(iVarX0, iVar2) || (z && m.a(pVar.w(iVarX0), pVar.w(iVar2)))) {
                    return pVar.D(pVar.w(iVar), i2);
                }
                o oVarM = m(pVar, iVarX0, iVar2);
                if (oVarM != null) {
                    return oVarM;
                }
            }
            i2++;
        }
    }

    private final boolean n(d1 d1Var, k kVar) {
        p pVarJ = d1Var.j();
        n nVarC = pVarJ.c(kVar);
        if (pVarJ.V(nVarC)) {
            return pVarJ.p(nVarC);
        }
        if (pVarJ.p(pVarJ.c(kVar))) {
            return true;
        }
        d1Var.k();
        ArrayDeque<k> arrayDequeH = d1Var.h();
        m.c(arrayDequeH);
        Set<k> setI = d1Var.i();
        m.c(setI);
        arrayDequeH.push(kVar);
        while (!arrayDequeH.isEmpty()) {
            if (setI.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + kVar + ". Supertypes = " + c0.e0(setI, null, null, null, 0, null, null, 63, null)).toString());
            }
            k kVarPop = arrayDequeH.pop();
            m.e(kVarPop, "current");
            if (setI.add(kVarPop)) {
                d1.c cVar = pVarJ.v0(kVarPop) ? d1.c.C0394c.a : d1.c.b.a;
                if (!(!m.a(cVar, d1.c.C0394c.a))) {
                    cVar = null;
                }
                if (cVar == null) {
                    continue;
                } else {
                    p pVarJ2 = d1Var.j();
                    Iterator<i> it = pVarJ2.t(pVarJ2.c(kVarPop)).iterator();
                    while (it.hasNext()) {
                        k kVarA = cVar.a(d1Var, it.next());
                        if (pVarJ.p(pVarJ.c(kVarA))) {
                            d1Var.e();
                            return true;
                        }
                        arrayDequeH.add(kVarA);
                    }
                }
            }
        }
        d1Var.e();
        return false;
    }

    private final boolean o(p pVar, i iVar) {
        return (!pVar.x(pVar.w(iVar)) || pVar.s(iVar) || pVar.C(iVar) || pVar.I(iVar) || !m.a(pVar.c(pVar.h0(iVar)), pVar.c(pVar.T(iVar)))) ? false : true;
    }

    private final boolean p(p pVar, k kVar, k kVar2) {
        k kVarH;
        k kVarH2;
        e eVarS0 = pVar.s0(kVar);
        if (eVarS0 == null || (kVarH = pVar.H(eVarS0)) == null) {
            kVarH = kVar;
        }
        e eVarS1 = pVar.s0(kVar2);
        if (eVarS1 == null || (kVarH2 = pVar.H(eVarS1)) == null) {
            kVarH2 = kVar2;
        }
        if (pVar.c(kVarH) != pVar.c(kVarH2)) {
            return false;
        }
        if (pVar.C(kVar) || !pVar.C(kVar2)) {
            return !pVar.W(kVar) || pVar.W(kVar2);
        }
        return false;
    }

    public static /* synthetic */ boolean t(f fVar, d1 d1Var, i iVar, i iVar2, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        return fVar.s(d1Var, iVar, iVar2, z);
    }

    private final boolean u(d1 d1Var, k kVar, k kVar2) {
        i iVarX0;
        p pVarJ = d1Var.j();
        if (f24705b) {
            if (!pVarJ.b(kVar) && !pVarJ.Z(pVarJ.c(kVar))) {
                d1Var.l(kVar);
            }
            if (!pVarJ.b(kVar2)) {
                d1Var.l(kVar2);
            }
        }
        if (!c.a.d(d1Var, kVar, kVar2)) {
            return false;
        }
        f fVar = a;
        Boolean boolA = fVar.a(d1Var, pVarJ.h0(kVar), pVarJ.T(kVar2));
        if (boolA != null) {
            boolean zBooleanValue = boolA.booleanValue();
            d1.d(d1Var, kVar, kVar2, false, 4, null);
            return zBooleanValue;
        }
        n nVarC = pVarJ.c(kVar2);
        if ((pVarJ.A0(pVarJ.c(kVar), nVarC) && pVarJ.h(nVarC) == 0) || pVarJ.k0(pVarJ.c(kVar2))) {
            return true;
        }
        List<k> listL = fVar.l(d1Var, kVar, nVarC);
        int i2 = 10;
        ArrayList<k> arrayList = new ArrayList(v.u(listL, 10));
        for (k kVar3 : listL) {
            k kVarA = pVarJ.a(d1Var.o(kVar3));
            if (kVarA != null) {
                kVar3 = kVarA;
            }
            arrayList.add(kVar3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return a.n(d1Var, kVar);
        }
        if (size == 1) {
            return a.q(d1Var, pVarJ.r((k) s.U(arrayList)), kVar2);
        }
        kotlin.reflect.y.internal.j0.l.w1.a aVar = new kotlin.reflect.y.internal.j0.l.w1.a(pVarJ.h(nVarC));
        int iH = pVarJ.h(nVarC);
        int i3 = 0;
        boolean z = false;
        while (i3 < iH) {
            z = z || pVarJ.N(pVarJ.D(nVarC, i3)) != u.OUT;
            if (!z) {
                ArrayList arrayList2 = new ArrayList(v.u(arrayList, i2));
                for (k kVar4 : arrayList) {
                    kotlin.reflect.y.internal.j0.l.w1.m mVarD0 = pVarJ.D0(kVar4, i3);
                    if (mVarD0 != null) {
                        if (!(pVarJ.j0(mVarD0) == u.INV)) {
                            mVarD0 = null;
                        }
                        if (mVarD0 != null && (iVarX0 = pVarJ.x0(mVarD0)) != null) {
                            arrayList2.add(iVarX0);
                        }
                    }
                    throw new IllegalStateException(("Incorrect type: " + kVar4 + ", subType: " + kVar + ", superType: " + kVar2).toString());
                }
                aVar.add(pVarJ.c0(pVarJ.O(arrayList2)));
            }
            i3++;
            i2 = 10;
        }
        if (z || !a.q(d1Var, aVar, kVar2)) {
            return d1Var.q(new b(arrayList, d1Var, pVarJ, kVar2));
        }
        return true;
    }

    private final boolean v(p pVar, i iVar, i iVar2, n nVar) {
        o oVarM0;
        k kVarA = pVar.a(iVar);
        if (!(kVarA instanceof d)) {
            return false;
        }
        d dVar = (d) kVarA;
        if (pVar.q(dVar) || !pVar.L(pVar.S(pVar.d0(dVar))) || pVar.P(dVar) != kotlin.reflect.y.internal.j0.l.w1.b.FOR_SUBTYPING) {
            return false;
        }
        n nVarW = pVar.w(iVar2);
        kotlin.reflect.y.internal.j0.l.w1.t tVar = nVarW instanceof kotlin.reflect.y.internal.j0.l.w1.t ? (kotlin.reflect.y.internal.j0.l.w1.t) nVarW : null;
        return (tVar == null || (oVarM0 = pVar.m0(tVar)) == null || !pVar.o(oVarM0, nVar)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<k> w(d1 d1Var, List<? extends k> list) {
        p pVarJ = d1Var.j();
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            l lVarR = pVarJ.r((k) next);
            int iR = pVarJ.R(lVarR);
            for (int i2 = 0; i2 < iR; i2++) {
                if (!(pVarJ.M(pVarJ.x0(pVarJ.u(lVarR, i2))) == null)) {
                    z = false;
                    break;
                }
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : list;
    }

    public final u j(u uVar, u uVar2) {
        m.f(uVar, "declared");
        m.f(uVar2, "useSite");
        u uVar3 = u.INV;
        if (uVar == uVar3) {
            return uVar2;
        }
        if (uVar2 == uVar3 || uVar == uVar2) {
            return uVar;
        }
        return null;
    }

    public final boolean k(d1 d1Var, i iVar, i iVar2) {
        m.f(d1Var, "state");
        m.f(iVar, "a");
        m.f(iVar2, "b");
        p pVarJ = d1Var.j();
        if (iVar == iVar2) {
            return true;
        }
        f fVar = a;
        if (fVar.o(pVarJ, iVar) && fVar.o(pVarJ, iVar2)) {
            i iVarO = d1Var.o(d1Var.p(iVar));
            i iVarO2 = d1Var.o(d1Var.p(iVar2));
            k kVarH0 = pVarJ.h0(iVarO);
            if (!pVarJ.A0(pVarJ.w(iVarO), pVarJ.w(iVarO2))) {
                return false;
            }
            if (pVarJ.j(kVarH0) == 0) {
                return pVarJ.z(iVarO) || pVarJ.z(iVarO2) || pVarJ.W(kVarH0) == pVarJ.W(pVarJ.h0(iVarO2));
            }
        }
        return t(fVar, d1Var, iVar, iVar2, false, 8, null) && t(fVar, d1Var, iVar2, iVar, false, 8, null);
    }

    public final List<k> l(d1 d1Var, k kVar, n nVar) {
        d1.c cVar;
        m.f(d1Var, "state");
        m.f(kVar, "subType");
        m.f(nVar, "superConstructor");
        p pVarJ = d1Var.j();
        if (pVarJ.v0(kVar)) {
            return a.h(d1Var, kVar, nVar);
        }
        if (!pVarJ.V(nVar) && !pVarJ.q0(nVar)) {
            return a.g(d1Var, kVar, nVar);
        }
        kotlin.p002reflect.jvm.internal.impl.utils.e<k> eVar = new kotlin.p002reflect.jvm.internal.impl.utils.e();
        d1Var.k();
        ArrayDeque<k> arrayDequeH = d1Var.h();
        m.c(arrayDequeH);
        Set<k> setI = d1Var.i();
        m.c(setI);
        arrayDequeH.push(kVar);
        while (!arrayDequeH.isEmpty()) {
            if (setI.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + kVar + ". Supertypes = " + c0.e0(setI, null, null, null, 0, null, null, 63, null)).toString());
            }
            k kVarPop = arrayDequeH.pop();
            m.e(kVarPop, "current");
            if (setI.add(kVarPop)) {
                if (pVarJ.v0(kVarPop)) {
                    eVar.add(kVarPop);
                    cVar = d1.c.C0394c.a;
                } else {
                    cVar = d1.c.b.a;
                }
                if (!(!m.a(cVar, d1.c.C0394c.a))) {
                    cVar = null;
                }
                if (cVar != null) {
                    p pVarJ2 = d1Var.j();
                    Iterator<i> it = pVarJ2.t(pVarJ2.c(kVarPop)).iterator();
                    while (it.hasNext()) {
                        arrayDequeH.add(cVar.a(d1Var, it.next()));
                    }
                }
            }
        }
        d1Var.e();
        ArrayList arrayList = new ArrayList();
        for (k kVar2 : eVar) {
            f fVar = a;
            m.e(kVar2, "it");
            z.z(arrayList, fVar.h(d1Var, kVar2, nVar));
        }
        return arrayList;
    }

    public final boolean q(d1 d1Var, l lVar, k kVar) {
        boolean zK;
        m.f(d1Var, "<this>");
        m.f(lVar, "capturedSubArguments");
        m.f(kVar, "superType");
        p pVarJ = d1Var.j();
        n nVarC = pVarJ.c(kVar);
        int iR = pVarJ.R(lVar);
        int iH = pVarJ.h(nVarC);
        if (iR != iH || iR != pVarJ.j(kVar)) {
            return false;
        }
        for (int i2 = 0; i2 < iH; i2++) {
            kotlin.reflect.y.internal.j0.l.w1.m mVarG0 = pVarJ.g0(kVar, i2);
            if (!pVarJ.L(mVarG0)) {
                i iVarX0 = pVarJ.x0(mVarG0);
                kotlin.reflect.y.internal.j0.l.w1.m mVarU = pVarJ.u(lVar, i2);
                pVarJ.j0(mVarU);
                u uVar = u.INV;
                i iVarX1 = pVarJ.x0(mVarU);
                f fVar = a;
                u uVarJ = fVar.j(pVarJ.N(pVarJ.D(nVarC, i2)), pVarJ.j0(mVarG0));
                if (uVarJ == null) {
                    return d1Var.m();
                }
                if (uVarJ == uVar && (fVar.v(pVarJ, iVarX1, iVarX0, nVarC) || fVar.v(pVarJ, iVarX0, iVarX1, nVarC))) {
                    continue;
                } else {
                    if (d1Var.f24692g > 100) {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + iVarX1).toString());
                    }
                    d1Var.f24692g++;
                    int i3 = a.a[uVarJ.ordinal()];
                    if (i3 == 1) {
                        zK = fVar.k(d1Var, iVarX1, iVarX0);
                    } else if (i3 == 2) {
                        zK = t(fVar, d1Var, iVarX1, iVarX0, false, 8, null);
                    } else {
                        if (i3 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        zK = t(fVar, d1Var, iVarX0, iVarX1, false, 8, null);
                    }
                    d1Var.f24692g--;
                    if (!zK) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean r(d1 d1Var, i iVar, i iVar2) {
        m.f(d1Var, "state");
        m.f(iVar, "subType");
        m.f(iVar2, "superType");
        return t(this, d1Var, iVar, iVar2, false, 8, null);
    }

    public final boolean s(d1 d1Var, i iVar, i iVar2, boolean z) {
        m.f(d1Var, "state");
        m.f(iVar, "subType");
        m.f(iVar2, "superType");
        if (iVar == iVar2) {
            return true;
        }
        if (d1Var.f(iVar, iVar2)) {
            return i(d1Var, iVar, iVar2, z);
        }
        return false;
    }
}
