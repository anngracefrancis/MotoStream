package kotlin.reflect.y.internal.j0.l.x1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.IndexedValue;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.f;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.y.internal.j0.l.b1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.k1;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.p;
import kotlin.reflect.y.internal.j0.l.p1;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.s0;
import kotlin.reflect.y.internal.j0.l.u0;
import kotlin.reflect.y.internal.j0.l.y;

/* JADX INFO: compiled from: TypeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.l.x1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TypeUtils.kt */
    static final class C0399a extends Lambda implements Function1<q1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0399a f24876f = new C0399a();

        C0399a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q1 q1Var) {
            m.f(q1Var, "it");
            h hVarC = q1Var.O0().w();
            return Boolean.valueOf(hVarC != null ? a.p(hVarC) : false);
        }
    }

    /* JADX INFO: compiled from: TypeUtils.kt */
    static final class b extends Lambda implements Function1<q1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f24877f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q1 q1Var) {
            m.f(q1Var, "it");
            h hVarC = q1Var.O0().w();
            boolean z = false;
            if (hVarC != null && ((hVarC instanceof d1) || (hVarC instanceof e1))) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    public static final g1 a(e0 e0Var) {
        m.f(e0Var, "<this>");
        return new i1(e0Var);
    }

    public static final boolean b(e0 e0Var, Function1<? super q1, Boolean> function1) {
        m.f(e0Var, "<this>");
        m.f(function1, "predicate");
        return n1.c(e0Var, function1);
    }

    private static final boolean c(e0 e0Var, kotlin.reflect.y.internal.j0.l.e1 e1Var, Set<? extends e1> set) {
        boolean zC;
        if (m.a(e0Var.O0(), e1Var)) {
            return true;
        }
        h hVarC = e0Var.O0().w();
        i iVar = hVarC instanceof i ? (i) hVarC : null;
        List<e1> listW = iVar != null ? iVar.w() : null;
        Iterable<IndexedValue> iterableK0 = c0.K0(e0Var.M0());
        if (!(iterableK0 instanceof Collection) || !((Collection) iterableK0).isEmpty()) {
            for (IndexedValue indexedValue : iterableK0) {
                int index = indexedValue.getIndex();
                g1 g1Var = (g1) indexedValue.b();
                e1 e1Var2 = listW != null ? (e1) s.X(listW, index) : null;
                if (((e1Var2 == null || set == null || !set.contains(e1Var2)) ? false : true) || g1Var.c()) {
                    zC = false;
                } else {
                    e0 type = g1Var.getType();
                    m.e(type, "argument.type");
                    zC = c(type, e1Var, set);
                }
                if (zC) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean d(e0 e0Var) {
        m.f(e0Var, "<this>");
        return b(e0Var, C0399a.f24876f);
    }

    public static final g1 e(e0 e0Var, r1 r1Var, e1 e1Var) {
        m.f(e0Var, "type");
        m.f(r1Var, "projectionKind");
        if ((e1Var != null ? e1Var.n() : null) == r1Var) {
            r1Var = r1.INVARIANT;
        }
        return new i1(r1Var, e0Var);
    }

    public static final Set<e1> f(e0 e0Var, Set<? extends e1> set) {
        m.f(e0Var, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        g(e0Var, e0Var, linkedHashSet, set);
        return linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void g(e0 e0Var, e0 e0Var2, Set<e1> set, Set<? extends e1> set2) {
        h hVarC = e0Var.O0().w();
        if (hVarC instanceof e1) {
            if (!m.a(e0Var.O0(), e0Var2.O0())) {
                set.add(hVarC);
                return;
            }
            for (e0 e0Var3 : ((e1) hVarC).getUpperBounds()) {
                m.e(e0Var3, "upperBound");
                g(e0Var3, e0Var2, set, set2);
            }
            return;
        }
        h hVarC2 = e0Var.O0().w();
        i iVar = hVarC2 instanceof i ? (i) hVarC2 : null;
        List<e1> listW = iVar != null ? iVar.w() : null;
        int i2 = 0;
        for (g1 g1Var : e0Var.M0()) {
            int i3 = i2 + 1;
            e1 e1Var = listW != null ? (e1) s.X(listW, i2) : null;
            if (!((e1Var == null || set2 == null || !set2.contains(e1Var)) ? false : true) && !g1Var.c() && !c0.K(set, g1Var.getType().O0().w()) && !m.a(g1Var.getType().O0(), e0Var2.O0())) {
                e0 type = g1Var.getType();
                m.e(type, "argument.type");
                g(type, e0Var2, set, set2);
            }
            i2 = i3;
        }
    }

    public static final kotlin.reflect.y.internal.j0.b.h h(e0 e0Var) {
        m.f(e0Var, "<this>");
        kotlin.reflect.y.internal.j0.b.h hVarO = e0Var.O0().o();
        m.e(hVarO, "constructor.builtIns");
        return hVarO;
    }

    public static final e0 i(e1 e1Var) {
        Object obj;
        m.f(e1Var, "<this>");
        List<e0> upperBounds = e1Var.getUpperBounds();
        m.e(upperBounds, "upperBounds");
        upperBounds.isEmpty();
        List<e0> upperBounds2 = e1Var.getUpperBounds();
        m.e(upperBounds2, "upperBounds");
        Iterator<T> it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            h hVarC = ((e0) next).O0().w();
            e eVar = hVarC instanceof e ? (e) hVarC : null;
            boolean z = false;
            if (eVar != null && eVar.i() != f.INTERFACE && eVar.i() != f.ANNOTATION_CLASS) {
                z = true;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        e0 e0Var = (e0) obj;
        if (e0Var != null) {
            return e0Var;
        }
        List<e0> upperBounds3 = e1Var.getUpperBounds();
        m.e(upperBounds3, "upperBounds");
        Object objU = s.U(upperBounds3);
        m.e(objU, "upperBounds.first()");
        return (e0) objU;
    }

    public static final boolean j(e1 e1Var) {
        m.f(e1Var, "typeParameter");
        return l(e1Var, null, null, 6, null);
    }

    public static final boolean k(e1 e1Var, kotlin.reflect.y.internal.j0.l.e1 e1Var2, Set<? extends e1> set) {
        m.f(e1Var, "typeParameter");
        List<e0> upperBounds = e1Var.getUpperBounds();
        m.e(upperBounds, "typeParameter.upperBounds");
        if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
            for (e0 e0Var : upperBounds) {
                m.e(e0Var, "upperBound");
                if (c(e0Var, e1Var.s().O0(), set) && (e1Var2 == null || m.a(e0Var.O0(), e1Var2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ boolean l(e1 e1Var, kotlin.reflect.y.internal.j0.l.e1 e1Var2, Set set, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            e1Var2 = null;
        }
        if ((i2 & 4) != 0) {
            set = null;
        }
        return k(e1Var, e1Var2, set);
    }

    public static final boolean m(e0 e0Var) {
        m.f(e0Var, "<this>");
        if (!(e0Var instanceof kotlin.reflect.y.internal.j0.l.e)) {
            if (!((e0Var instanceof p) && (((p) e0Var).a1() instanceof kotlin.reflect.y.internal.j0.l.e))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean n(e0 e0Var) {
        m.f(e0Var, "<this>");
        if (!(e0Var instanceof u0)) {
            if (!((e0Var instanceof p) && (((p) e0Var).a1() instanceof u0))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean o(e0 e0Var, e0 e0Var2) {
        m.f(e0Var, "<this>");
        m.f(e0Var2, "superType");
        return kotlin.reflect.y.internal.j0.l.t1.e.a.d(e0Var, e0Var2);
    }

    public static final boolean p(h hVar) {
        m.f(hVar, "<this>");
        return (hVar instanceof e1) && (((e1) hVar).b() instanceof d1);
    }

    public static final boolean q(e0 e0Var) {
        m.f(e0Var, "<this>");
        return n1.m(e0Var);
    }

    public static final boolean r(e0 e0Var) {
        m.f(e0Var, "type");
        return (e0Var instanceof kotlin.reflect.y.internal.j0.l.u1.h) && ((kotlin.reflect.y.internal.j0.l.u1.h) e0Var).Y0().q();
    }

    public static final e0 s(e0 e0Var) {
        m.f(e0Var, "<this>");
        e0 e0VarN = n1.n(e0Var);
        m.e(e0VarN, "makeNotNullable(this)");
        return e0VarN;
    }

    public static final e0 t(e0 e0Var) {
        m.f(e0Var, "<this>");
        e0 e0VarO = n1.o(e0Var);
        m.e(e0VarO, "makeNullable(this)");
        return e0VarO;
    }

    public static final e0 u(e0 e0Var, g gVar) {
        m.f(e0Var, "<this>");
        m.f(gVar, "newAnnotations");
        return (e0Var.getAnnotations().isEmpty() && gVar.isEmpty()) ? e0Var : e0Var.R0().U0(b1.a(e0Var.N0(), gVar));
    }

    public static final e0 v(e0 e0Var, l1 l1Var, Map<kotlin.reflect.y.internal.j0.l.e1, ? extends g1> map, r1 r1Var, Set<? extends e1> set) {
        q1 q1VarF;
        m.f(e0Var, "<this>");
        m.f(l1Var, "substitutor");
        m.f(map, "substitutionMap");
        m.f(r1Var, "variance");
        q1 q1VarR0 = e0Var.R0();
        if (q1VarR0 instanceof y) {
            y yVar = (y) q1VarR0;
            m0 m0VarW0 = yVar.W0();
            if (!m0VarW0.O0().getParameters().isEmpty() && m0VarW0.O0().w() != null) {
                List<e1> parameters = m0VarW0.O0().getParameters();
                m.e(parameters, "constructor.parameters");
                ArrayList arrayList = new ArrayList(v.u(parameters, 10));
                for (e1 e1Var : parameters) {
                    g1 s0Var = (g1) s.X(e0Var.M0(), e1Var.g());
                    if ((set != null && set.contains(e1Var)) || s0Var == null || !map.containsKey(s0Var.getType().O0())) {
                        s0Var = new s0(e1Var);
                    }
                    arrayList.add(s0Var);
                }
                m0VarW0 = k1.f(m0VarW0, arrayList, null, 2, null);
            }
            m0 m0VarX0 = yVar.X0();
            if (!m0VarX0.O0().getParameters().isEmpty() && m0VarX0.O0().w() != null) {
                List<e1> parameters2 = m0VarX0.O0().getParameters();
                m.e(parameters2, "constructor.parameters");
                ArrayList arrayList2 = new ArrayList(v.u(parameters2, 10));
                for (e1 e1Var2 : parameters2) {
                    g1 s0Var2 = (g1) s.X(e0Var.M0(), e1Var2.g());
                    if ((set != null && set.contains(e1Var2)) || s0Var2 == null || !map.containsKey(s0Var2.getType().O0())) {
                        s0Var2 = new s0(e1Var2);
                    }
                    arrayList2.add(s0Var2);
                }
                m0VarX0 = k1.f(m0VarX0, arrayList2, null, 2, null);
            }
            q1VarF = f0.d(m0VarW0, m0VarX0);
        } else {
            if (!(q1VarR0 instanceof m0)) {
                throw new NoWhenBranchMatchedException();
            }
            m0 m0Var = (m0) q1VarR0;
            if (m0Var.O0().getParameters().isEmpty() || m0Var.O0().w() == null) {
                q1VarF = m0Var;
            } else {
                List<e1> parameters3 = m0Var.O0().getParameters();
                m.e(parameters3, "constructor.parameters");
                ArrayList arrayList3 = new ArrayList(v.u(parameters3, 10));
                for (e1 e1Var3 : parameters3) {
                    g1 s0Var3 = (g1) s.X(e0Var.M0(), e1Var3.g());
                    if ((set != null && set.contains(e1Var3)) || s0Var3 == null || !map.containsKey(s0Var3.getType().O0())) {
                        s0Var3 = new s0(e1Var3);
                    }
                    arrayList3.add(s0Var3);
                }
                q1VarF = k1.f(m0Var, arrayList3, null, 2, null);
            }
        }
        e0 e0VarN = l1Var.n(p1.b(q1VarF, q1VarR0), r1Var);
        m.e(e0VarN, "replaceArgumentsByParame…ubstitute(it, variance) }");
        return e0VarN;
    }

    public static final e0 w(e0 e0Var) {
        m0 m0Var;
        q1 q1VarF;
        m.f(e0Var, "<this>");
        q1 q1VarR0 = e0Var.R0();
        if (q1VarR0 instanceof y) {
            y yVar = (y) q1VarR0;
            m0 m0VarW0 = yVar.W0();
            if (!m0VarW0.O0().getParameters().isEmpty() && m0VarW0.O0().w() != null) {
                List<e1> parameters = m0VarW0.O0().getParameters();
                m.e(parameters, "constructor.parameters");
                ArrayList arrayList = new ArrayList(v.u(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new s0((e1) it.next()));
                }
                m0VarW0 = k1.f(m0VarW0, arrayList, null, 2, null);
            }
            m0 m0VarX0 = yVar.X0();
            if (!m0VarX0.O0().getParameters().isEmpty() && m0VarX0.O0().w() != null) {
                List<e1> parameters2 = m0VarX0.O0().getParameters();
                m.e(parameters2, "constructor.parameters");
                ArrayList arrayList2 = new ArrayList(v.u(parameters2, 10));
                Iterator<T> it2 = parameters2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new s0((e1) it2.next()));
                }
                m0VarX0 = k1.f(m0VarX0, arrayList2, null, 2, null);
            }
            q1VarF = f0.d(m0VarW0, m0VarX0);
        } else {
            if (!(q1VarR0 instanceof m0)) {
                throw new NoWhenBranchMatchedException();
            }
            m0Var = (m0) q1VarR0;
            if (!m0Var.O0().getParameters().isEmpty() && m0Var.O0().w() != null) {
                q1VarF = m0Var;
                q1VarF = m0Var;
                List<e1> parameters3 = m0Var.O0().getParameters();
                m.e(parameters3, "constructor.parameters");
                ArrayList arrayList3 = new ArrayList(v.u(parameters3, 10));
                Iterator<T> it3 = parameters3.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new s0((e1) it3.next()));
                }
                q1VarF = k1.f(m0Var, arrayList3, null, 2, null);
            }
        }
        q1VarF = m0Var;
        q1VarF = m0Var;
        q1VarF = m0Var;
        return p1.b(q1VarF, q1VarR0);
    }

    public static final boolean x(e0 e0Var) {
        m.f(e0Var, "<this>");
        return b(e0Var, b.f24877f);
    }
}
