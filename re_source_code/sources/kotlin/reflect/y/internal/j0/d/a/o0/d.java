package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.y.internal.j0.d.a.l0.c;
import kotlin.reflect.y.internal.j0.d.a.l0.m.f;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.b0;
import kotlin.reflect.y.internal.j0.l.b1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.l0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.p1;
import kotlin.reflect.y.internal.j0.l.q0;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.y;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private final c a;

    /* JADX INFO: compiled from: typeEnhancement.kt */
    private static final class a {
        private final e0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f23610b;

        public a(e0 e0Var, int i2) {
            this.a = e0Var;
            this.f23610b = i2;
        }

        public final int a() {
            return this.f23610b;
        }

        public final e0 b() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: typeEnhancement.kt */
    private static final class b {
        private final m0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f23611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f23612c;

        public b(m0 m0Var, int i2, boolean z) {
            this.a = m0Var;
            this.f23611b = i2;
            this.f23612c = z;
        }

        public final boolean a() {
            return this.f23612c;
        }

        public final int b() {
            return this.f23611b;
        }

        public final m0 c() {
            return this.a;
        }
    }

    public d(c cVar) {
        m.f(cVar, "javaResolverSettings");
        this.a = cVar;
    }

    private final b b(m0 m0Var, Function1<? super Integer, e> function1, int i2, o oVar, boolean z, boolean z2) {
        e1 e1VarO0;
        boolean z3;
        boolean z4;
        a aVar;
        g1 g1VarS;
        Function1<? super Integer, e> function2 = function1;
        boolean zA = p.a(oVar);
        boolean z5 = (z2 && z) ? false : true;
        e0 e0Var = null;
        if (!zA && m0Var.M0().isEmpty()) {
            return new b(null, 1, false);
        }
        h hVarW = m0Var.O0().w();
        if (hVarW == null) {
            return new b(null, 1, false);
        }
        e eVarInvoke = function2.invoke(Integer.valueOf(i2));
        h hVarG = r.g(hVarW, eVarInvoke, oVar);
        Boolean boolH = r.h(eVarInvoke, oVar);
        if (hVarG == null || (e1VarO0 = hVarG.h()) == null) {
            e1VarO0 = m0Var.O0();
        }
        e1 e1Var = e1VarO0;
        m.e(e1Var, "enhancedClassifier?.typeConstructor ?: constructor");
        int iA = i2 + 1;
        List<g1> listM0 = m0Var.M0();
        List<kotlin.p002reflect.jvm.internal.impl.descriptors.e1> parameters = e1Var.getParameters();
        m.e(parameters, "typeConstructor.parameters");
        Iterator<T> it = listM0.iterator();
        Iterator<T> it2 = parameters.iterator();
        ArrayList arrayList = new ArrayList(Math.min(v.u(listM0, 10), v.u(parameters, 10)));
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            kotlin.p002reflect.jvm.internal.impl.descriptors.e1 e1Var2 = (kotlin.p002reflect.jvm.internal.impl.descriptors.e1) it2.next();
            g1 g1Var = (g1) next;
            if (z5) {
                z4 = z5;
                if (!g1Var.c()) {
                    aVar = d(g1Var.getType().R0(), function2, iA, z2);
                } else if (function2.invoke(Integer.valueOf(iA)).d() == h.FORCE_FLEXIBILITY) {
                    q1 q1VarR0 = g1Var.getType().R0();
                    aVar = new a(f0.d(b0.c(q1VarR0).S0(false), b0.d(q1VarR0).S0(true)), 1);
                } else {
                    aVar = new a(null, 1);
                }
            } else {
                z4 = z5;
                aVar = new a(e0Var, 0);
            }
            iA += aVar.a();
            if (aVar.b() != null) {
                e0 e0VarB = aVar.b();
                r1 r1VarA = g1Var.a();
                m.e(r1VarA, "arg.projectionKind");
                g1VarS = kotlin.reflect.y.internal.j0.l.x1.a.e(e0VarB, r1VarA, e1Var2);
            } else if (hVarG == null || g1Var.c()) {
                g1VarS = hVarG != null ? n1.s(e1Var2) : null;
            } else {
                e0 type = g1Var.getType();
                m.e(type, "arg.type");
                r1 r1VarA2 = g1Var.a();
                m.e(r1VarA2, "arg.projectionKind");
                g1VarS = kotlin.reflect.y.internal.j0.l.x1.a.e(type, r1VarA2, e1Var2);
            }
            arrayList.add(g1VarS);
            function2 = function1;
            z5 = z4;
            e0Var = null;
        }
        int i3 = iA - i2;
        if (hVarG == null && boolH == null) {
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z3 = true;
                        break;
                    }
                    if (!(((g1) it3.next()) == null)) {
                        z3 = false;
                        break;
                    }
                }
            } else {
                z3 = true;
                break;
            }
            if (z3) {
                return new b(null, i3, false);
            }
        }
        g[] gVarArr = new g[3];
        gVarArr[0] = m0Var.getAnnotations();
        c cVar = r.f23682b;
        if (!(hVarG != null)) {
            cVar = null;
        }
        gVarArr[1] = cVar;
        c cVar2 = r.a;
        if (!(boolH != null)) {
            cVar2 = null;
        }
        gVarArr[2] = cVar2;
        a1 a1VarB = b1.b(r.f(u.o(gVarArr)));
        List<g1> listM1 = m0Var.M0();
        Iterator it4 = arrayList.iterator();
        Iterator<T> it5 = listM1.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(v.u(arrayList, 10), v.u(listM1, 10)));
        while (it4.hasNext() && it5.hasNext()) {
            Object next2 = it4.next();
            g1 g1Var2 = (g1) it5.next();
            g1 g1Var3 = (g1) next2;
            if (g1Var3 != null) {
                g1Var2 = g1Var3;
            }
            arrayList2.add(g1Var2);
        }
        m0 m0VarI = f0.i(a1VarB, e1Var, arrayList2, boolH != null ? boolH.booleanValue() : m0Var.P0(), null, 16, null);
        if (eVarInvoke.b()) {
            m0VarI = e(m0VarI);
        }
        return new b(m0VarI, i3, boolH != null && eVarInvoke.e());
    }

    static /* synthetic */ b c(d dVar, m0 m0Var, Function1 function1, int i2, o oVar, boolean z, boolean z2, int i3, Object obj) {
        return dVar.b(m0Var, function1, i2, oVar, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x009a  */
    private final a d(q1 q1Var, Function1<? super Integer, e> function1, int i2, boolean z) {
        e0 e0VarC;
        e0 e0VarD = null;
        if (g0.a(q1Var)) {
            return new a(null, 1);
        }
        if (!(q1Var instanceof y)) {
            if (!(q1Var instanceof m0)) {
                throw new NoWhenBranchMatchedException();
            }
            b bVarC = c(this, (m0) q1Var, function1, i2, o.INFLEXIBLE, false, z, 8, null);
            return new a(bVarC.a() ? p1.d(q1Var, bVarC.c()) : bVarC.c(), bVarC.b());
        }
        boolean z2 = q1Var instanceof l0;
        y yVar = (y) q1Var;
        b bVarB = b(yVar.W0(), function1, i2, o.FLEXIBLE_LOWER, z2, z);
        b bVarB2 = b(yVar.X0(), function1, i2, o.FLEXIBLE_UPPER, z2, z);
        bVarB.b();
        bVarB2.b();
        if (bVarB.c() != null || bVarB2.c() != null) {
            if (bVarB.a() || bVarB2.a()) {
                m0 m0VarC = bVarB2.c();
                if (m0VarC == null) {
                    e0VarC = bVarB.c();
                    m.c(e0VarC);
                } else {
                    m0 m0VarC2 = bVarB.c();
                    if (m0VarC2 == null) {
                        m0VarC2 = m0VarC;
                    }
                    e0VarC = f0.d(m0VarC2, m0VarC);
                    if (e0VarC == null) {
                        e0VarC = bVarB.c();
                        m.c(e0VarC);
                    }
                }
                e0VarD = p1.d(q1Var, e0VarC);
            } else if (z2) {
                m0 m0VarC3 = bVarB.c();
                if (m0VarC3 == null) {
                    m0VarC3 = yVar.W0();
                }
                m0 m0VarC4 = bVarB2.c();
                if (m0VarC4 == null) {
                    m0VarC4 = yVar.X0();
                }
                e0VarD = new f(m0VarC3, m0VarC4);
            } else {
                m0 m0VarC5 = bVarB.c();
                if (m0VarC5 == null) {
                    m0VarC5 = yVar.W0();
                }
                m0 m0VarC6 = bVarB2.c();
                if (m0VarC6 == null) {
                    m0VarC6 = yVar.X0();
                }
                e0VarD = f0.d(m0VarC5, m0VarC6);
            }
        }
        return new a(e0VarD, bVarB.b());
    }

    private final m0 e(m0 m0Var) {
        return this.a.a() ? q0.h(m0Var, true) : new g(m0Var);
    }

    public final e0 a(e0 e0Var, Function1<? super Integer, e> function1, boolean z) {
        m.f(e0Var, "<this>");
        m.f(function1, "qualifiers");
        return d(e0Var.R0(), function1, 0, z).b();
    }
}
