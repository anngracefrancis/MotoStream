package kotlin.reflect.y.internal.j0.l.t1;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.l.d0;
import kotlin.reflect.y.internal.j0.l.d1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.f1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.j0;
import kotlin.reflect.y.internal.j0.l.l0;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.m1;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.p;
import kotlin.reflect.y.internal.j0.l.p0;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.v;
import kotlin.reflect.y.internal.j0.l.w1.c;
import kotlin.reflect.y.internal.j0.l.w1.d;
import kotlin.reflect.y.internal.j0.l.w1.g;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.j;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.reflect.y.internal.j0.l.w1.l;
import kotlin.reflect.y.internal.j0.l.w1.n;
import kotlin.reflect.y.internal.j0.l.w1.o;
import kotlin.reflect.y.internal.j0.l.w1.q;
import kotlin.reflect.y.internal.j0.l.w1.r;
import kotlin.reflect.y.internal.j0.l.w1.t;
import kotlin.reflect.y.internal.j0.l.w1.u;
import kotlin.reflect.y.internal.j0.l.y;

/* JADX INFO: compiled from: ClassicTypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b extends m1, r {

    /* JADX INFO: compiled from: ClassicTypeSystemContext.kt */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.l.t1.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ClassicTypeSystemContext.kt */
        public static final class C0397a extends d1.c.a {
            final /* synthetic */ b a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ l1 f24787b;

            C0397a(b bVar, l1 l1Var) {
                this.a = bVar;
                this.f24787b = l1Var;
            }

            @Override // kotlin.f0.y.e.j0.l.d1.c
            public k a(d1 d1Var, i iVar) {
                m.f(d1Var, "state");
                m.f(iVar, "type");
                b bVar = this.a;
                l1 l1Var = this.f24787b;
                i iVarH0 = bVar.h0(iVar);
                m.d(iVarH0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                e0 e0VarN = l1Var.n((e0) iVarH0, r1.INVARIANT);
                m.e(e0VarN, "substitutor.safeSubstitu…VARIANT\n                )");
                k kVarA = bVar.a(e0VarN);
                m.c(kVarA);
                return kVarA;
            }
        }

        public static o A(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                h hVarC = ((e1) nVar).w();
                if (hVarC instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e1) {
                    return (kotlin.p002reflect.jvm.internal.impl.descriptors.e1) hVarC;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static c A0(b bVar, d dVar) {
            m.f(dVar, "$receiver");
            if (dVar instanceof i) {
                return ((i) dVar).O0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + g0.b(dVar.getClass())).toString());
        }

        public static i B(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            if (iVar instanceof e0) {
                return f.e((e0) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + g0.b(iVar.getClass())).toString());
        }

        public static n B0(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return r.a.n(bVar, iVar);
        }

        public static List<i> C(b bVar, o oVar) {
            m.f(oVar, "$receiver");
            if (oVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e1) {
                List<e0> upperBounds = ((kotlin.p002reflect.jvm.internal.impl.descriptors.e1) oVar).getUpperBounds();
                m.e(upperBounds, "this.upperBounds");
                return upperBounds;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + g0.b(oVar.getClass())).toString());
        }

        public static n C0(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            if (kVar instanceof m0) {
                return ((m0) kVar).O0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        public static u D(b bVar, kotlin.reflect.y.internal.j0.l.w1.m mVar) {
            m.f(mVar, "$receiver");
            if (mVar instanceof g1) {
                r1 r1VarA = ((g1) mVar).a();
                m.e(r1VarA, "this.projectionKind");
                return q.a(r1VarA);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + g0.b(mVar.getClass())).toString());
        }

        public static k D0(b bVar, g gVar) {
            m.f(gVar, "$receiver");
            if (gVar instanceof y) {
                return ((y) gVar).X0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + g0.b(gVar.getClass())).toString());
        }

        public static u E(b bVar, o oVar) {
            m.f(oVar, "$receiver");
            if (oVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e1) {
                r1 r1VarN = ((kotlin.p002reflect.jvm.internal.impl.descriptors.e1) oVar).n();
                m.e(r1VarN, "this.variance");
                return q.a(r1VarN);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + g0.b(oVar.getClass())).toString());
        }

        public static k E0(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return r.a.o(bVar, iVar);
        }

        public static boolean F(b bVar, i iVar, kotlin.reflect.y.internal.j0.f.c cVar) {
            m.f(iVar, "$receiver");
            m.f(cVar, "fqName");
            if (iVar instanceof e0) {
                return ((e0) iVar).getAnnotations().R0(cVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + g0.b(iVar.getClass())).toString());
        }

        public static i F0(b bVar, i iVar, boolean z) {
            m.f(iVar, "$receiver");
            if (iVar instanceof k) {
                return bVar.d((k) iVar, z);
            }
            if (!(iVar instanceof g)) {
                throw new IllegalStateException("sealed".toString());
            }
            g gVar = (g) iVar;
            return bVar.E(bVar.d(bVar.g(gVar), z), bVar.d(bVar.e(gVar), z));
        }

        public static boolean G(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return r.a.d(bVar, iVar);
        }

        public static k G0(b bVar, k kVar, boolean z) {
            m.f(kVar, "$receiver");
            if (kVar instanceof m0) {
                return ((m0) kVar).S0(z);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        public static boolean H(b bVar, o oVar, n nVar) {
            m.f(oVar, "$receiver");
            if (!(oVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + g0.b(oVar.getClass())).toString());
            }
            if (nVar == null ? true : nVar instanceof e1) {
                return kotlin.reflect.y.internal.j0.l.x1.a.l((kotlin.p002reflect.jvm.internal.impl.descriptors.e1) oVar, (e1) nVar, null, 4, null);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + g0.b(oVar.getClass())).toString());
        }

        public static boolean I(b bVar, k kVar, k kVar2) {
            m.f(kVar, "a");
            m.f(kVar2, "b");
            if (!(kVar instanceof m0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
            }
            if (kVar2 instanceof m0) {
                return ((m0) kVar).M0() == ((m0) kVar2).M0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar2 + ", " + g0.b(kVar2.getClass())).toString());
        }

        public static i J(b bVar, List<? extends i> list) {
            m.f(list, "types");
            return d.a(list);
        }

        public static boolean K(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                return kotlin.reflect.y.internal.j0.b.h.v0((e1) nVar, kotlin.f0.y.e.j0.b.k.a.f23201b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static boolean L(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return r.a.e(bVar, iVar);
        }

        public static boolean M(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            return r.a.f(bVar, kVar);
        }

        public static boolean N(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                return ((e1) nVar).w() instanceof e;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static boolean O(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                h hVarC = ((e1) nVar).w();
                e eVar = hVarC instanceof e ? (e) hVarC : null;
                return (eVar == null || !kotlin.p002reflect.jvm.internal.impl.descriptors.e0.a(eVar) || eVar.i() == kotlin.p002reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY || eVar.i() == kotlin.p002reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static boolean P(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return r.a.g(bVar, iVar);
        }

        public static boolean Q(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                return ((e1) nVar).e();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static boolean R(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return r.a.h(bVar, iVar);
        }

        public static boolean S(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            if (iVar instanceof e0) {
                return kotlin.reflect.y.internal.j0.l.g0.a((e0) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + g0.b(iVar.getClass())).toString());
        }

        public static boolean T(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                h hVarC = ((e1) nVar).w();
                e eVar = hVarC instanceof e ? (e) hVarC : null;
                return (eVar != null ? eVar.z0() : null) instanceof z;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static boolean U(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            return r.a.i(bVar, kVar);
        }

        public static boolean V(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                return nVar instanceof kotlin.reflect.y.internal.j0.i.r.n;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static boolean W(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                return nVar instanceof d0;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static boolean X(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return r.a.j(bVar, iVar);
        }

        public static boolean Y(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            if (kVar instanceof m0) {
                return ((m0) kVar).P0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        public static boolean Z(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return iVar instanceof j0;
        }

        public static boolean a(b bVar, n nVar, n nVar2) {
            m.f(nVar, "c1");
            m.f(nVar2, "c2");
            if (!(nVar instanceof e1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
            }
            if (nVar2 instanceof e1) {
                return m.a(nVar, nVar2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar2 + ", " + g0.b(nVar2.getClass())).toString());
        }

        public static boolean a0(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return r.a.k(bVar, iVar);
        }

        public static int b(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            if (iVar instanceof e0) {
                return ((e0) iVar).M0().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + g0.b(iVar.getClass())).toString());
        }

        public static boolean b0(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                return kotlin.reflect.y.internal.j0.b.h.v0((e1) nVar, kotlin.f0.y.e.j0.b.k.a.f23202c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static l c(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            if (kVar instanceof m0) {
                return (l) kVar;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        public static boolean c0(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            if (iVar instanceof e0) {
                return n1.l((e0) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + g0.b(iVar.getClass())).toString());
        }

        public static d d(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            if (kVar instanceof m0) {
                if (kVar instanceof p0) {
                    return bVar.f(((p0) kVar).v());
                }
                if (kVar instanceof i) {
                    return (i) kVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        public static boolean d0(b bVar, d dVar) {
            m.f(dVar, "$receiver");
            return dVar instanceof kotlin.reflect.y.internal.j0.i.q.a.a;
        }

        public static kotlin.reflect.y.internal.j0.l.w1.e e(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            if (kVar instanceof m0) {
                if (kVar instanceof p) {
                    return (p) kVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean e0(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            if (kVar instanceof e0) {
                return kotlin.reflect.y.internal.j0.b.h.r0((e0) kVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        public static kotlin.reflect.y.internal.j0.l.w1.f f(b bVar, g gVar) {
            m.f(gVar, "$receiver");
            if (gVar instanceof y) {
                if (gVar instanceof v) {
                    return (v) gVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + g0.b(gVar.getClass())).toString());
        }

        public static boolean f0(b bVar, d dVar) {
            m.f(dVar, "$receiver");
            if (dVar instanceof i) {
                return ((i) dVar).a1();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + g0.b(dVar.getClass())).toString());
        }

        public static g g(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            if (iVar instanceof e0) {
                q1 q1VarR0 = ((e0) iVar).R0();
                if (q1VarR0 instanceof y) {
                    return (y) q1VarR0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + g0.b(iVar.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean g0(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            if (!(kVar instanceof m0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
            }
            if (!kotlin.reflect.y.internal.j0.l.g0.a((e0) kVar)) {
                m0 m0Var = (m0) kVar;
                if (!(m0Var.O0().w() instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.d1) && (m0Var.O0().w() != null || (kVar instanceof kotlin.reflect.y.internal.j0.i.q.a.a) || (kVar instanceof i) || (kVar instanceof p) || (m0Var.O0() instanceof kotlin.reflect.y.internal.j0.i.r.n) || h0(bVar, kVar))) {
                    return true;
                }
            }
            return false;
        }

        public static j h(b bVar, g gVar) {
            m.f(gVar, "$receiver");
            if (gVar instanceof y) {
                if (gVar instanceof l0) {
                    return (l0) gVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + g0.b(gVar.getClass())).toString());
        }

        private static boolean h0(b bVar, k kVar) {
            return (kVar instanceof p0) && bVar.b(((p0) kVar).v());
        }

        public static k i(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            if (iVar instanceof e0) {
                q1 q1VarR0 = ((e0) iVar).R0();
                if (q1VarR0 instanceof m0) {
                    return (m0) q1VarR0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + g0.b(iVar.getClass())).toString());
        }

        public static boolean i0(b bVar, kotlin.reflect.y.internal.j0.l.w1.m mVar) {
            m.f(mVar, "$receiver");
            if (mVar instanceof g1) {
                return ((g1) mVar).c();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + g0.b(mVar.getClass())).toString());
        }

        public static kotlin.reflect.y.internal.j0.l.w1.m j(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            if (iVar instanceof e0) {
                return kotlin.reflect.y.internal.j0.l.x1.a.a((e0) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + g0.b(iVar.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean j0(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            if (kVar instanceof m0) {
                return kotlin.reflect.y.internal.j0.l.x1.a.m((e0) kVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        public static k k(b bVar, k kVar, kotlin.reflect.y.internal.j0.l.w1.b bVar2) {
            m.f(kVar, "type");
            m.f(bVar2, "status");
            if (kVar instanceof m0) {
                return k.b((m0) kVar, bVar2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean k0(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            if (kVar instanceof m0) {
                return kotlin.reflect.y.internal.j0.l.x1.a.n((e0) kVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        public static kotlin.reflect.y.internal.j0.l.w1.b l(b bVar, d dVar) {
            m.f(dVar, "$receiver");
            if (dVar instanceof i) {
                return ((i) dVar).X0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + g0.b(dVar.getClass())).toString());
        }

        public static boolean l0(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return (iVar instanceof q1) && (((q1) iVar).O0() instanceof n);
        }

        public static i m(b bVar, k kVar, k kVar2) {
            m.f(kVar, "lowerBound");
            m.f(kVar2, "upperBound");
            if (!(kVar instanceof m0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + g0.b(bVar.getClass())).toString());
            }
            if (kVar2 instanceof m0) {
                return f0.d((m0) kVar, (m0) kVar2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + g0.b(bVar.getClass())).toString());
        }

        public static boolean m0(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                h hVarC = ((e1) nVar).w();
                return hVarC != null && kotlin.reflect.y.internal.j0.b.h.A0(hVarC);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static List<k> n(b bVar, k kVar, n nVar) {
            m.f(kVar, "$receiver");
            m.f(nVar, "constructor");
            return r.a.a(bVar, kVar, nVar);
        }

        public static k n0(b bVar, g gVar) {
            m.f(gVar, "$receiver");
            if (gVar instanceof y) {
                return ((y) gVar).W0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + g0.b(gVar.getClass())).toString());
        }

        public static kotlin.reflect.y.internal.j0.l.w1.m o(b bVar, l lVar, int i2) {
            m.f(lVar, "$receiver");
            return r.a.b(bVar, lVar, i2);
        }

        public static k o0(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return r.a.l(bVar, iVar);
        }

        public static kotlin.reflect.y.internal.j0.l.w1.m p(b bVar, i iVar, int i2) {
            m.f(iVar, "$receiver");
            if (iVar instanceof e0) {
                return ((e0) iVar).M0().get(i2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + g0.b(iVar.getClass())).toString());
        }

        public static i p0(b bVar, d dVar) {
            m.f(dVar, "$receiver");
            if (dVar instanceof i) {
                return ((i) dVar).Z0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + g0.b(dVar.getClass())).toString());
        }

        public static kotlin.reflect.y.internal.j0.l.w1.m q(b bVar, k kVar, int i2) {
            m.f(kVar, "$receiver");
            return r.a.c(bVar, kVar, i2);
        }

        public static i q0(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            if (iVar instanceof q1) {
                return c.b((q1) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + g0.b(iVar.getClass())).toString());
        }

        public static List<kotlin.reflect.y.internal.j0.l.w1.m> r(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            if (iVar instanceof e0) {
                return ((e0) iVar).M0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + g0.b(iVar.getClass())).toString());
        }

        public static i r0(b bVar, i iVar) {
            m.f(iVar, "$receiver");
            return m1.a.a(bVar, iVar);
        }

        public static kotlin.reflect.y.internal.j0.f.d s(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                h hVarC = ((e1) nVar).w();
                m.d(hVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return kotlin.reflect.y.internal.j0.i.t.a.i((e) hVarC);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static d1 s0(b bVar, boolean z, boolean z2) {
            return kotlin.reflect.y.internal.j0.l.t1.a.b(z, z2, bVar, null, null, 24, null);
        }

        public static o t(b bVar, n nVar, int i2) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                kotlin.p002reflect.jvm.internal.impl.descriptors.e1 e1Var = ((e1) nVar).getParameters().get(i2);
                m.e(e1Var, "this.parameters[index]");
                return e1Var;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static k t0(b bVar, kotlin.reflect.y.internal.j0.l.w1.e eVar) {
            m.f(eVar, "$receiver");
            if (eVar instanceof p) {
                return ((p) eVar).a1();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + eVar + ", " + g0.b(eVar.getClass())).toString());
        }

        public static List<o> u(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                List<kotlin.p002reflect.jvm.internal.impl.descriptors.e1> parameters = ((e1) nVar).getParameters();
                m.e(parameters, "this.parameters");
                return parameters;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static int u0(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                return ((e1) nVar).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static kotlin.reflect.y.internal.j0.b.i v(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                h hVarC = ((e1) nVar).w();
                m.d(hVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return kotlin.reflect.y.internal.j0.b.h.P((e) hVarC);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static Collection<i> v0(b bVar, k kVar) {
            m.f(kVar, "$receiver");
            n nVarC = bVar.c(kVar);
            if (nVarC instanceof kotlin.reflect.y.internal.j0.i.r.n) {
                return ((kotlin.reflect.y.internal.j0.i.r.n) nVarC).k();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        public static kotlin.reflect.y.internal.j0.b.i w(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                h hVarC = ((e1) nVar).w();
                m.d(hVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return kotlin.reflect.y.internal.j0.b.h.S((e) hVarC);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }

        public static kotlin.reflect.y.internal.j0.l.w1.m w0(b bVar, c cVar) {
            m.f(cVar, "$receiver");
            if (cVar instanceof j) {
                return ((j) cVar).f();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar + ", " + g0.b(cVar.getClass())).toString());
        }

        public static i x(b bVar, o oVar) {
            m.f(oVar, "$receiver");
            if (oVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e1) {
                return kotlin.reflect.y.internal.j0.l.x1.a.i((kotlin.p002reflect.jvm.internal.impl.descriptors.e1) oVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + g0.b(oVar.getClass())).toString());
        }

        public static int x0(b bVar, l lVar) {
            m.f(lVar, "$receiver");
            return r.a.m(bVar, lVar);
        }

        public static i y(b bVar, kotlin.reflect.y.internal.j0.l.w1.m mVar) {
            m.f(mVar, "$receiver");
            if (mVar instanceof g1) {
                return ((g1) mVar).getType().R0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + g0.b(mVar.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static d1.c y0(b bVar, k kVar) {
            m.f(kVar, "type");
            if (kVar instanceof m0) {
                return new C0397a(bVar, f1.f24727c.a((e0) kVar).c());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + g0.b(kVar.getClass())).toString());
        }

        public static o z(b bVar, t tVar) {
            m.f(tVar, "$receiver");
            if (tVar instanceof n) {
                return ((n) tVar).d();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + tVar + ", " + g0.b(tVar.getClass())).toString());
        }

        public static Collection<i> z0(b bVar, n nVar) {
            m.f(nVar, "$receiver");
            if (nVar instanceof e1) {
                Collection<e0> collectionA = ((e1) nVar).a();
                m.e(collectionA, "this.supertypes");
                return collectionA;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + g0.b(nVar.getClass())).toString());
        }
    }

    i E(k kVar, k kVar2);

    @Override // kotlin.reflect.y.internal.j0.l.w1.p
    k a(i iVar);

    @Override // kotlin.reflect.y.internal.j0.l.w1.p
    boolean b(k kVar);

    @Override // kotlin.reflect.y.internal.j0.l.w1.p
    n c(k kVar);

    @Override // kotlin.reflect.y.internal.j0.l.w1.p
    k d(k kVar, boolean z);

    @Override // kotlin.reflect.y.internal.j0.l.w1.p
    k e(g gVar);

    @Override // kotlin.reflect.y.internal.j0.l.w1.p
    d f(k kVar);

    @Override // kotlin.reflect.y.internal.j0.l.w1.p
    k g(g gVar);
}
