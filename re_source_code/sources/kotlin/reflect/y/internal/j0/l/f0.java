package kotlin.reflect.y.internal.j0.l;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.u;
import kotlin.reflect.y.internal.j0.i.r.n;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.t1.g;
import kotlin.reflect.y.internal.j0.l.u1.k;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 {
    public static final f0 a = new f0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function1<g, m0> f24715b = a.f24716f;

    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    static final class a extends Lambda implements Function1 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f24716f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke(g gVar) {
            m.f(gVar, "<anonymous parameter 0>");
            return null;
        }
    }

    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    private static final class b {
        private final m0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e1 f24717b;

        public b(m0 m0Var, e1 e1Var) {
            this.a = m0Var;
            this.f24717b = e1Var;
        }

        public final m0 a() {
            return this.a;
        }

        public final e1 b() {
            return this.f24717b;
        }
    }

    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    static final class c extends Lambda implements Function1<g, m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e1 f24718f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List<g1> f24719g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a1 f24720h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f24721i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(e1 e1Var, List<? extends g1> list, a1 a1Var, boolean z) {
            super(1);
            this.f24718f = e1Var;
            this.f24719g = list;
            this.f24720h = a1Var;
            this.f24721i = z;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0 invoke(g gVar) {
            m.f(gVar, "refiner");
            b bVarF = f0.a.f(this.f24718f, gVar, this.f24719g);
            if (bVarF == null) {
                return null;
            }
            m0 m0VarA = bVarF.a();
            if (m0VarA != null) {
                return m0VarA;
            }
            a1 a1Var = this.f24720h;
            e1 e1VarB = bVarF.b();
            m.c(e1VarB);
            return f0.h(a1Var, e1VarB, this.f24719g, this.f24721i, gVar);
        }
    }

    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    static final class d extends Lambda implements Function1<g, m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e1 f24722f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List<g1> f24723g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a1 f24724h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f24725i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ h f24726j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(e1 e1Var, List<? extends g1> list, a1 a1Var, boolean z, h hVar) {
            super(1);
            this.f24722f = e1Var;
            this.f24723g = list;
            this.f24724h = a1Var;
            this.f24725i = z;
            this.f24726j = hVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0 invoke(g gVar) {
            m.f(gVar, "kotlinTypeRefiner");
            b bVarF = f0.a.f(this.f24722f, gVar, this.f24723g);
            if (bVarF == null) {
                return null;
            }
            m0 m0VarA = bVarF.a();
            if (m0VarA != null) {
                return m0VarA;
            }
            a1 a1Var = this.f24724h;
            e1 e1VarB = bVarF.b();
            m.c(e1VarB);
            return f0.j(a1Var, e1VarB, this.f24723g, this.f24725i, this.f24726j);
        }
    }

    private f0() {
    }

    public static final m0 b(d1 d1Var, List<? extends g1> list) {
        m.f(d1Var, "<this>");
        m.f(list, "arguments");
        return new v0(x0.a.a, false).i(w0.a.a(null, d1Var, list), a1.f24676g.h());
    }

    private final h c(e1 e1Var, List<? extends g1> list, g gVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarC = e1Var.w();
        if (hVarC instanceof e1) {
            return ((e1) hVarC).s().q();
        }
        if (hVarC instanceof e) {
            if (gVar == null) {
                gVar = kotlin.reflect.y.internal.j0.i.t.a.k(kotlin.reflect.y.internal.j0.i.t.a.l(hVarC));
            }
            return list.isEmpty() ? u.b((e) hVarC, gVar) : u.a((e) hVarC, f1.f24727c.b(e1Var, list), gVar);
        }
        if (hVarC instanceof d1) {
            kotlin.reflect.y.internal.j0.l.u1.g gVar2 = kotlin.reflect.y.internal.j0.l.u1.g.SCOPE_FOR_ABBREVIATION_TYPE;
            String string = ((d1) hVarC).getName().toString();
            m.e(string, "descriptor.name.toString()");
            return k.a(gVar2, true, string);
        }
        if (e1Var instanceof d0) {
            return ((d0) e1Var).g();
        }
        throw new IllegalStateException("Unsupported classifier: " + hVarC + " for constructor: " + e1Var);
    }

    public static final q1 d(m0 m0Var, m0 m0Var2) {
        m.f(m0Var, "lowerBound");
        m.f(m0Var2, "upperBound");
        return m.a(m0Var, m0Var2) ? m0Var : new z(m0Var, m0Var2);
    }

    public static final m0 e(a1 a1Var, n nVar, boolean z) {
        m.f(a1Var, "attributes");
        m.f(nVar, "constructor");
        return j(a1Var, nVar, kotlin.collections.u.j(), z, k.a(kotlin.reflect.y.internal.j0.l.u1.g.INTEGER_LITERAL_TYPE_SCOPE, true, "unknown integer literal type"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b f(e1 e1Var, g gVar, List<? extends g1> list) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarF;
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarC = e1Var.w();
        if (hVarC == null || (hVarF = gVar.f(hVarC)) == null) {
            return null;
        }
        if (hVarF instanceof d1) {
            return new b(b((d1) hVarF, list), null);
        }
        e1 e1VarB = hVarF.h().b(gVar);
        m.e(e1VarB, "descriptor.typeConstruct…refine(kotlinTypeRefiner)");
        return new b(null, e1VarB);
    }

    public static final m0 g(a1 a1Var, e eVar, List<? extends g1> list) {
        m.f(a1Var, "attributes");
        m.f(eVar, "descriptor");
        m.f(list, "arguments");
        e1 e1VarH = eVar.h();
        m.e(e1VarH, "descriptor.typeConstructor");
        return i(a1Var, e1VarH, list, false, null, 16, null);
    }

    public static final m0 h(a1 a1Var, e1 e1Var, List<? extends g1> list, boolean z, g gVar) {
        m.f(a1Var, "attributes");
        m.f(e1Var, "constructor");
        m.f(list, "arguments");
        if (!a1Var.isEmpty() || !list.isEmpty() || z || e1Var.w() == null) {
            return k(a1Var, e1Var, list, z, a.c(e1Var, list, gVar), new c(e1Var, list, a1Var, z));
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarC = e1Var.w();
        m.c(hVarC);
        m0 m0VarS = hVarC.s();
        m.e(m0VarS, "constructor.declarationDescriptor!!.defaultType");
        return m0VarS;
    }

    public static /* synthetic */ m0 i(a1 a1Var, e1 e1Var, List list, boolean z, g gVar, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            gVar = null;
        }
        return h(a1Var, e1Var, list, z, gVar);
    }

    public static final m0 j(a1 a1Var, e1 e1Var, List<? extends g1> list, boolean z, h hVar) {
        m.f(a1Var, "attributes");
        m.f(e1Var, "constructor");
        m.f(list, "arguments");
        m.f(hVar, "memberScope");
        n0 n0Var = new n0(e1Var, list, z, hVar, new d(e1Var, list, a1Var, z, hVar));
        return a1Var.isEmpty() ? n0Var : new o0(n0Var, a1Var);
    }

    public static final m0 k(a1 a1Var, e1 e1Var, List<? extends g1> list, boolean z, h hVar, Function1<? super g, ? extends m0> function1) {
        m.f(a1Var, "attributes");
        m.f(e1Var, "constructor");
        m.f(list, "arguments");
        m.f(hVar, "memberScope");
        m.f(function1, "refinedTypeFactory");
        n0 n0Var = new n0(e1Var, list, z, hVar, function1);
        return a1Var.isEmpty() ? n0Var : new o0(n0Var, a1Var);
    }
}
