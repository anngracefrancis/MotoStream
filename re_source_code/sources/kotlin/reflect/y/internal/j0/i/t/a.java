package kotlin.reflect.y.internal.j0.i.t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.s0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.t1.g;
import kotlin.reflect.y.internal.j0.l.t1.p;
import kotlin.reflect.y.internal.j0.l.t1.x;
import kotlin.sequences.Sequence;
import kotlin.sequences.l;
import kotlin.sequences.n;

/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final f a;

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.i.t.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    static final class C0380a<N> implements kotlin.reflect.jvm.internal.impl.utils.b.c {
        public static final C0380a<N> a = new C0380a<>();

        C0380a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<i1> a(i1 i1Var) {
            Collection<i1> collectionE = i1Var.e();
            ArrayList arrayList = new ArrayList(v.u(collectionE, 10));
            Iterator<T> it = collectionE.iterator();
            while (it.hasNext()) {
                arrayList.add(((i1) it.next()).a());
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: DescriptorUtils.kt */
    /* synthetic */ class b extends i implements Function1<i1, Boolean> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f24383h = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "declaresDefaultValue";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(i1.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(i1 i1Var) {
            m.f(i1Var, "p0");
            return Boolean.valueOf(i1Var.u0());
        }
    }

    /* JADX INFO: compiled from: DescriptorUtils.kt */
    static final class c<N> implements kotlin.reflect.jvm.internal.impl.utils.b.c {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<kotlin.p002reflect.jvm.internal.impl.descriptors.b> a(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            if (this.a) {
                bVar = bVar != null ? bVar.a() : null;
            }
            Collection<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.b> collectionE = bVar != null ? bVar.e() : null;
            return collectionE == null ? u.j() : collectionE;
        }
    }

    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class d extends kotlin.p002reflect.jvm.internal.impl.utils.b.AbstractC0417b<kotlin.p002reflect.jvm.internal.impl.descriptors.b, kotlin.p002reflect.jvm.internal.impl.descriptors.b> {
        final /* synthetic */ f0<kotlin.p002reflect.jvm.internal.impl.descriptors.b> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.b, Boolean> f24384b;

        /* JADX WARN: Multi-variable type inference failed */
        d(f0<kotlin.p002reflect.jvm.internal.impl.descriptors.b> f0Var, Function1<? super kotlin.p002reflect.jvm.internal.impl.descriptors.b, Boolean> function1) {
            this.a = f0Var;
            this.f24384b = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.p002reflect.jvm.internal.impl.utils.b.AbstractC0417b, kotlin.reflect.jvm.internal.impl.utils.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "current");
            if (this.a.f22943f == null && this.f24384b.invoke(bVar).booleanValue()) {
                this.a.f22943f = bVar;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "current");
            return this.a.f22943f == null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public kotlin.p002reflect.jvm.internal.impl.descriptors.b a() {
            return this.a.f22943f;
        }
    }

    /* JADX INFO: compiled from: DescriptorUtils.kt */
    static final class e extends Lambda implements Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.m, kotlin.p002reflect.jvm.internal.impl.descriptors.m> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f24385f = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.p002reflect.jvm.internal.impl.descriptors.m invoke(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
            m.f(mVar, "it");
            return mVar.b();
        }
    }

    static {
        f fVarX = f.x("value");
        m.e(fVarX, "identifier(\"value\")");
        a = fVarX;
    }

    public static final boolean a(i1 i1Var) {
        m.f(i1Var, "<this>");
        Boolean boolE = kotlin.p002reflect.jvm.internal.impl.utils.b.e(t.e(i1Var), C0380a.a, b.f24383h);
        m.e(boolE, "ifAny(\n        listOf(th…eclaresDefaultValue\n    )");
        return boolE.booleanValue();
    }

    public static final kotlin.p002reflect.jvm.internal.impl.descriptors.b b(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar, boolean z, Function1<? super kotlin.p002reflect.jvm.internal.impl.descriptors.b, Boolean> function1) {
        m.f(bVar, "<this>");
        m.f(function1, "predicate");
        return (kotlin.p002reflect.jvm.internal.impl.descriptors.b) kotlin.p002reflect.jvm.internal.impl.utils.b.b(t.e(bVar), new c(z), new d(new f0(), function1));
    }

    public static /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.b c(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return b(bVar, z, function1);
    }

    public static final kotlin.reflect.y.internal.j0.f.c d(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        kotlin.reflect.y.internal.j0.f.d dVarI = i(mVar);
        if (!dVarI.f()) {
            dVarI = null;
        }
        if (dVarI != null) {
            return dVarI.l();
        }
        return null;
    }

    public static final kotlin.p002reflect.jvm.internal.impl.descriptors.e e(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c cVar) {
        m.f(cVar, "<this>");
        h hVarC = cVar.getType().O0().w();
        if (hVarC instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e) {
            return (kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarC;
        }
        return null;
    }

    public static final kotlin.reflect.y.internal.j0.b.h f(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        return l(mVar).o();
    }

    public static final kotlin.reflect.y.internal.j0.f.b g(h hVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB;
        kotlin.reflect.y.internal.j0.f.b bVarG;
        if (hVar == null || (mVarB = hVar.b()) == null) {
            return null;
        }
        if (mVarB instanceof k0) {
            return new kotlin.reflect.y.internal.j0.f.b(((k0) mVarB).d(), hVar.getName());
        }
        if (!(mVarB instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.i) || (bVarG = g((h) mVarB)) == null) {
            return null;
        }
        return bVarG.d(hVar.getName());
    }

    public static final kotlin.reflect.y.internal.j0.f.c h(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        kotlin.reflect.y.internal.j0.f.c cVarN = kotlin.reflect.y.internal.j0.i.d.n(mVar);
        m.e(cVarN, "getFqNameSafe(this)");
        return cVarN;
    }

    public static final kotlin.reflect.y.internal.j0.f.d i(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        kotlin.reflect.y.internal.j0.f.d dVarM = kotlin.reflect.y.internal.j0.i.d.m(mVar);
        m.e(dVarM, "getFqName(this)");
        return dVarM;
    }

    public static final z<m0> j(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        g1<m0> g1VarZ0 = eVar != null ? eVar.z0() : null;
        if (g1VarZ0 instanceof z) {
            return (z) g1VarZ0;
        }
        return null;
    }

    public static final g k(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var) {
        m.f(g0Var, "<this>");
        p pVar = (p) g0Var.I0(kotlin.reflect.y.internal.j0.l.t1.h.a());
        x xVar = pVar != null ? (x) pVar.a() : null;
        return xVar instanceof x.a ? ((x.a) xVar).b() : g.a.a;
    }

    public static final kotlin.p002reflect.jvm.internal.impl.descriptors.g0 l(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0VarG = kotlin.reflect.y.internal.j0.i.d.g(mVar);
        m.e(g0VarG, "getContainingModule(this)");
        return g0VarG;
    }

    public static final Sequence<kotlin.p002reflect.jvm.internal.impl.descriptors.m> m(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        return n.k(n(mVar), 1);
    }

    public static final Sequence<kotlin.p002reflect.jvm.internal.impl.descriptors.m> n(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        return l.f(mVar, e.f24385f);
    }

    public static final kotlin.p002reflect.jvm.internal.impl.descriptors.b o(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
        m.f(bVar, "<this>");
        if (!(bVar instanceof s0)) {
            return bVar;
        }
        t0 t0VarB0 = ((s0) bVar).B0();
        m.e(t0VarB0, "correspondingProperty");
        return t0VarB0;
    }

    public static final kotlin.p002reflect.jvm.internal.impl.descriptors.e p(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        m.f(eVar, "<this>");
        for (e0 e0Var : eVar.s().O0().a()) {
            if (!kotlin.reflect.y.internal.j0.b.h.b0(e0Var)) {
                h hVarC = e0Var.O0().w();
                if (kotlin.reflect.y.internal.j0.i.d.w(hVarC)) {
                    m.d(hVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarC;
                }
            }
        }
        return null;
    }

    public static final boolean q(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var) {
        x xVar;
        m.f(g0Var, "<this>");
        p pVar = (p) g0Var.I0(kotlin.reflect.y.internal.j0.l.t1.h.a());
        return (pVar == null || (xVar = (x) pVar.a()) == null || !xVar.a()) ? false : true;
    }

    public static final kotlin.p002reflect.jvm.internal.impl.descriptors.e r(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var, kotlin.reflect.y.internal.j0.f.c cVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(g0Var, "<this>");
        m.f(cVar, "topLevelClassFqName");
        m.f(bVar, "location");
        cVar.d();
        kotlin.reflect.y.internal.j0.f.c cVarE = cVar.e();
        m.e(cVarE, "topLevelClassFqName.parent()");
        kotlin.reflect.y.internal.j0.i.w.h hVarQ = g0Var.N(cVarE).q();
        f fVarG = cVar.g();
        m.e(fVarG, "topLevelClassFqName.shortName()");
        h hVarF = hVarQ.f(fVarG, bVar);
        if (hVarF instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e) {
            return (kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarF;
        }
        return null;
    }
}
