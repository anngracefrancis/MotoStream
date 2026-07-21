package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.reflect.y.internal.j0.l.u1.k;

/* JADX INFO: compiled from: TypeAliasExpander.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v0 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final v0 f24860b = new v0(x0.a.a, false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x0 f24861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f24862d;

    /* JADX INFO: compiled from: TypeAliasExpander.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i2, d1 d1Var) {
            if (i2 <= 100) {
                return;
            }
            throw new AssertionError("Too deep recursion while expanding type alias " + d1Var.getName());
        }
    }

    public v0(x0 x0Var, boolean z) {
        m.f(x0Var, "reportStrategy");
        this.f24861c = x0Var;
        this.f24862d = z;
    }

    private final void a(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar2) {
        HashSet hashSet = new HashSet();
        Iterator<c> it = gVar.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().d());
        }
        for (c cVar : gVar2) {
            if (hashSet.contains(cVar.d())) {
                this.f24861c.a(cVar);
            }
        }
    }

    private final void b(e0 e0Var, e0 e0Var2) {
        l1 l1VarF = l1.f(e0Var2);
        m.e(l1VarF, "create(substitutedType)");
        int i2 = 0;
        for (Object obj : e0Var2.M0()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                u.t();
            }
            g1 g1Var = (g1) obj;
            if (!g1Var.c()) {
                e0 type = g1Var.getType();
                m.e(type, "substitutedArgument.type");
                if (!kotlin.reflect.y.internal.j0.l.x1.a.d(type)) {
                    g1 g1Var2 = e0Var.M0().get(i2);
                    e1 e1Var = e0Var.O0().getParameters().get(i2);
                    if (this.f24862d) {
                        x0 x0Var = this.f24861c;
                        e0 type2 = g1Var2.getType();
                        m.e(type2, "unsubstitutedArgument.type");
                        e0 type3 = g1Var.getType();
                        m.e(type3, "substitutedArgument.type");
                        m.e(e1Var, "typeParameter");
                        x0Var.c(l1VarF, type2, type3, e1Var);
                    }
                }
            }
            i2 = i3;
        }
    }

    private final v c(v vVar, a1 a1Var) {
        return vVar.U0(h(vVar, a1Var));
    }

    private final m0 d(m0 m0Var, a1 a1Var) {
        return g0.a(m0Var) ? m0Var : k1.f(m0Var, null, h(m0Var, a1Var), 1, null);
    }

    private final m0 e(m0 m0Var, e0 e0Var) {
        m0 m0VarR = n1.r(m0Var, e0Var.P0());
        m.e(m0VarR, "makeNullableIfNeeded(thi…romType.isMarkedNullable)");
        return m0VarR;
    }

    private final m0 f(m0 m0Var, e0 e0Var) {
        return d(e(m0Var, e0Var), e0Var.N0());
    }

    private final m0 g(w0 w0Var, a1 a1Var, boolean z) {
        e1 e1VarH = w0Var.b().h();
        m.e(e1VarH, "descriptor.typeConstructor");
        return f0.j(a1Var, e1VarH, w0Var.a(), z, h.b.f24422b);
    }

    private final a1 h(e0 e0Var, a1 a1Var) {
        return g0.a(e0Var) ? e0Var.N0() : a1Var.n(e0Var.N0());
    }

    private final g1 j(g1 g1Var, w0 w0Var, int i2) {
        q1 q1VarR0 = g1Var.getType().R0();
        if (w.a(q1VarR0)) {
            return g1Var;
        }
        m0 m0VarA = k1.a(q1VarR0);
        if (g0.a(m0VarA) || !kotlin.reflect.y.internal.j0.l.x1.a.x(m0VarA)) {
            return g1Var;
        }
        e1 e1VarO0 = m0VarA.O0();
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarW = e1VarO0.w();
        e1VarO0.getParameters().size();
        m0VarA.M0().size();
        if (hVarW instanceof e1) {
            return g1Var;
        }
        if (!(hVarW instanceof d1)) {
            m0 m0VarM = m(m0VarA, w0Var, i2);
            b(m0VarA, m0VarM);
            return new i1(g1Var.a(), m0VarM);
        }
        d1 d1Var = (d1) hVarW;
        int i3 = 0;
        if (w0Var.d(d1Var)) {
            this.f24861c.d(d1Var);
            r1 r1Var = r1.INVARIANT;
            j jVar = j.v;
            String string = d1Var.getName().toString();
            m.e(string, "typeDescriptor.name.toString()");
            return new i1(r1Var, k.d(jVar, string));
        }
        List<g1> listM0 = m0VarA.M0();
        ArrayList arrayList = new ArrayList(v.u(listM0, 10));
        for (Object obj : listM0) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                u.t();
            }
            arrayList.add(l((g1) obj, w0Var, e1VarO0.getParameters().get(i3), i2 + 1));
            i3 = i4;
        }
        m0 m0VarK = k(w0.a.a(w0Var, d1Var, arrayList), m0VarA.N0(), m0VarA.P0(), i2 + 1, false);
        m0 m0VarM2 = m(m0VarA, w0Var, i2);
        if (!w.a(m0VarK)) {
            m0VarK = q0.j(m0VarK, m0VarM2);
        }
        return new i1(g1Var.a(), m0VarK);
    }

    private final m0 k(w0 w0Var, a1 a1Var, boolean z, int i2, boolean z2) {
        g1 g1VarL = l(new i1(r1.INVARIANT, w0Var.b().g0()), w0Var, null, i2);
        e0 type = g1VarL.getType();
        m.e(type, "expandedProjection.type");
        m0 m0VarA = k1.a(type);
        if (g0.a(m0VarA)) {
            return m0VarA;
        }
        g1VarL.a();
        a(m0VarA.getAnnotations(), k.a(a1Var));
        m0 m0VarR = n1.r(d(m0VarA, a1Var), z);
        m.e(m0VarR, "expandedType.combineAttr…fNeeded(it, isNullable) }");
        return z2 ? q0.j(m0VarR, g(w0Var, a1Var, z)) : m0VarR;
    }

    private final g1 l(g1 g1Var, w0 w0Var, e1 e1Var, int i2) {
        r1 r1VarN;
        r1 r1Var;
        r1 r1Var2;
        a.b(i2, w0Var.b());
        if (g1Var.c()) {
            m.c(e1Var);
            g1 g1VarS = n1.s(e1Var);
            m.e(g1VarS, "makeStarProjection(typeParameterDescriptor!!)");
            return g1VarS;
        }
        e0 type = g1Var.getType();
        m.e(type, "underlyingProjection.type");
        g1 g1VarC = w0Var.c(type.O0());
        if (g1VarC == null) {
            return j(g1Var, w0Var, i2);
        }
        if (g1VarC.c()) {
            m.c(e1Var);
            g1 g1VarS2 = n1.s(e1Var);
            m.e(g1VarS2, "makeStarProjection(typeParameterDescriptor!!)");
            return g1VarS2;
        }
        q1 q1VarR0 = g1VarC.getType().R0();
        r1 r1VarA = g1VarC.a();
        m.e(r1VarA, "argument.projectionKind");
        r1 r1VarA2 = g1Var.a();
        m.e(r1VarA2, "underlyingProjection.projectionKind");
        if (r1VarA2 != r1VarA && r1VarA2 != (r1Var2 = r1.INVARIANT)) {
            if (r1VarA == r1Var2) {
                r1VarA = r1VarA2;
            } else {
                this.f24861c.b(w0Var.b(), e1Var, q1VarR0);
            }
        }
        if (e1Var == null || (r1VarN = e1Var.n()) == null) {
            r1VarN = r1.INVARIANT;
        }
        m.e(r1VarN, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
        if (r1VarN != r1VarA && r1VarN != (r1Var = r1.INVARIANT)) {
            if (r1VarA == r1Var) {
                r1VarA = r1Var;
            } else {
                this.f24861c.b(w0Var.b(), e1Var, q1VarR0);
            }
        }
        a(type.getAnnotations(), q1VarR0.getAnnotations());
        return new i1(r1VarA, q1VarR0 instanceof v ? c((v) q1VarR0, type.N0()) : f(k1.a(q1VarR0), type));
    }

    private final m0 m(m0 m0Var, w0 w0Var, int i2) {
        e1 e1VarO0 = m0Var.O0();
        List<g1> listM0 = m0Var.M0();
        ArrayList arrayList = new ArrayList(v.u(listM0, 10));
        int i3 = 0;
        for (Object obj : listM0) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                u.t();
            }
            g1 g1Var = (g1) obj;
            g1 g1VarL = l(g1Var, w0Var, e1VarO0.getParameters().get(i3), i2 + 1);
            if (!g1VarL.c()) {
                g1VarL = new i1(g1VarL.a(), n1.q(g1VarL.getType(), g1Var.getType().P0()));
            }
            arrayList.add(g1VarL);
            i3 = i4;
        }
        return k1.f(m0Var, arrayList, null, 2, null);
    }

    public final m0 i(w0 w0Var, a1 a1Var) {
        m.f(w0Var, "typeAliasExpansion");
        m.f(a1Var, "attributes");
        return k(w0Var, a1Var, false, 0, true);
    }
}
