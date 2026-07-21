package kotlin.reflect.y.internal.j0.l.w1;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.d1;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface p extends s {

    /* JADX INFO: compiled from: TypeSystemContext.kt */
    public static final class a {
        public static List<k> a(p pVar, k kVar, n nVar) {
            m.f(kVar, "$receiver");
            m.f(nVar, "constructor");
            return null;
        }

        public static m b(p pVar, l lVar, int i2) {
            m.f(lVar, "$receiver");
            if (lVar instanceof k) {
                return pVar.g0((i) lVar, i2);
            }
            if (lVar instanceof kotlin.reflect.y.internal.j0.l.w1.a) {
                m mVar = ((kotlin.reflect.y.internal.j0.l.w1.a) lVar).get(i2);
                m.e(mVar, "get(index)");
                return mVar;
            }
            throw new IllegalStateException(("unknown type argument list type: " + lVar + ", " + g0.b(lVar.getClass())).toString());
        }

        public static m c(p pVar, k kVar, int i2) {
            m.f(kVar, "$receiver");
            boolean z = false;
            if (i2 >= 0 && i2 < pVar.j(kVar)) {
                z = true;
            }
            if (z) {
                return pVar.g0(kVar, i2);
            }
            return null;
        }

        public static boolean d(p pVar, i iVar) {
            m.f(iVar, "$receiver");
            return pVar.W(pVar.h0(iVar)) != pVar.W(pVar.T(iVar));
        }

        public static boolean e(p pVar, i iVar) {
            m.f(iVar, "$receiver");
            k kVarA = pVar.a(iVar);
            return (kVarA != null ? pVar.f(kVarA) : null) != null;
        }

        public static boolean f(p pVar, k kVar) {
            m.f(kVar, "$receiver");
            return pVar.V(pVar.c(kVar));
        }

        public static boolean g(p pVar, i iVar) {
            m.f(iVar, "$receiver");
            k kVarA = pVar.a(iVar);
            return (kVarA != null ? pVar.s0(kVarA) : null) != null;
        }

        public static boolean h(p pVar, i iVar) {
            m.f(iVar, "$receiver");
            g gVarM = pVar.M(iVar);
            return (gVarM != null ? pVar.y0(gVarM) : null) != null;
        }

        public static boolean i(p pVar, k kVar) {
            m.f(kVar, "$receiver");
            return pVar.q0(pVar.c(kVar));
        }

        public static boolean j(p pVar, i iVar) {
            m.f(iVar, "$receiver");
            return (iVar instanceof k) && pVar.W((k) iVar);
        }

        public static boolean k(p pVar, i iVar) {
            m.f(iVar, "$receiver");
            return pVar.p(pVar.w(iVar)) && !pVar.p0(iVar);
        }

        public static k l(p pVar, i iVar) {
            k kVarG;
            m.f(iVar, "$receiver");
            g gVarM = pVar.M(iVar);
            if (gVarM != null && (kVarG = pVar.g(gVarM)) != null) {
                return kVarG;
            }
            k kVarA = pVar.a(iVar);
            m.c(kVarA);
            return kVarA;
        }

        public static int m(p pVar, l lVar) {
            m.f(lVar, "$receiver");
            if (lVar instanceof k) {
                return pVar.j((i) lVar);
            }
            if (lVar instanceof kotlin.reflect.y.internal.j0.l.w1.a) {
                return ((kotlin.reflect.y.internal.j0.l.w1.a) lVar).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + lVar + ", " + g0.b(lVar.getClass())).toString());
        }

        public static n n(p pVar, i iVar) {
            m.f(iVar, "$receiver");
            k kVarA = pVar.a(iVar);
            if (kVarA == null) {
                kVarA = pVar.h0(iVar);
            }
            return pVar.c(kVarA);
        }

        public static k o(p pVar, i iVar) {
            k kVarE;
            m.f(iVar, "$receiver");
            g gVarM = pVar.M(iVar);
            if (gVarM != null && (kVarE = pVar.e(gVarM)) != null) {
                return kVarE;
            }
            k kVarA = pVar.a(iVar);
            m.c(kVarA);
            return kVarA;
        }
    }

    d1.c A(k kVar);

    boolean A0(n nVar, n nVar2);

    boolean B(i iVar);

    List<i> B0(o oVar);

    boolean C(i iVar);

    o D(n nVar, int i2);

    m D0(k kVar, int i2);

    boolean E0(k kVar);

    o F(n nVar);

    i G(i iVar, boolean z);

    k H(e eVar);

    boolean I(i iVar);

    boolean J(k kVar);

    boolean L(m mVar);

    g M(i iVar);

    u N(o oVar);

    i O(List<? extends i> list);

    b P(d dVar);

    i Q(i iVar);

    int R(l lVar);

    m S(c cVar);

    k T(i iVar);

    i U(d dVar);

    boolean V(n nVar);

    boolean W(k kVar);

    List<m> X(i iVar);

    boolean Y(i iVar);

    boolean Z(n nVar);

    k a(i iVar);

    boolean b(k kVar);

    n c(k kVar);

    m c0(i iVar);

    k d(k kVar, boolean z);

    c d0(d dVar);

    k e(g gVar);

    List<o> e0(n nVar);

    d f(k kVar);

    boolean f0(i iVar);

    k g(g gVar);

    m g0(i iVar, int i2);

    int h(n nVar);

    k h0(i iVar);

    int j(i iVar);

    u j0(m mVar);

    boolean k(d dVar);

    boolean k0(n nVar);

    o m0(t tVar);

    List<k> n(k kVar, n nVar);

    boolean n0(k kVar);

    boolean o(o oVar, n nVar);

    boolean o0(i iVar);

    boolean p(n nVar);

    boolean p0(i iVar);

    boolean q(d dVar);

    boolean q0(n nVar);

    l r(k kVar);

    k r0(k kVar, b bVar);

    boolean s(i iVar);

    e s0(k kVar);

    Collection<i> t(n nVar);

    m u(l lVar, int i2);

    boolean u0(n nVar);

    Collection<i> v(k kVar);

    boolean v0(k kVar);

    n w(i iVar);

    boolean w0(k kVar);

    boolean x(n nVar);

    i x0(m mVar);

    j y(g gVar);

    f y0(g gVar);

    boolean z(i iVar);

    boolean z0(i iVar);
}
