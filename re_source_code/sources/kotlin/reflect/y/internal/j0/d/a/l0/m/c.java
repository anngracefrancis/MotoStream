package kotlin.reflect.y.internal.j0.d.a.l0.m;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.IndexedValue;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.y.internal.j0.b.q.d;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.a.l0.k;
import kotlin.reflect.y.internal.j0.d.a.n0.a0;
import kotlin.reflect.y.internal.j0.d.a.n0.f;
import kotlin.reflect.y.internal.j0.d.a.n0.i;
import kotlin.reflect.y.internal.j0.d.a.n0.j;
import kotlin.reflect.y.internal.j0.d.a.n0.x;
import kotlin.reflect.y.internal.j0.d.a.n0.y;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.b1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.h0;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f23571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f23572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f23573d;

    /* JADX INFO: compiled from: JavaTypeResolver.kt */
    static final class a extends Lambda implements Function0<e0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e1 f23575g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ j f23576h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.m.a f23577i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.l.e1 f23578j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e1 e1Var, j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, kotlin.reflect.y.internal.j0.l.e1 e1Var2) {
            super(0);
            this.f23575g = e1Var;
            this.f23576h = jVar;
            this.f23577i = aVar;
            this.f23578j = e1Var2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke() {
            g gVar = c.this.f23572c;
            e1 e1Var = this.f23575g;
            boolean zX = this.f23576h.x();
            kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar = this.f23577i;
            h hVarC = this.f23578j.w();
            e0 e0VarC = gVar.c(e1Var, zX, aVar.h(hVarC != null ? hVarC.s() : null));
            m.e(e0VarC, "typeParameterUpperBoundE…efaultType)\n            )");
            return e0VarC;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(g gVar, k kVar) {
        m.f(gVar, "c");
        m.f(kVar, "typeParameterResolver");
        this.a = gVar;
        this.f23571b = kVar;
        g gVar2 = new g(null, 1, 0 == true ? 1 : 0);
        this.f23572c = gVar2;
        this.f23573d = new e(gVar2);
    }

    private final boolean b(j jVar, e eVar) {
        r1 r1VarN;
        if (!a0.a((x) s.i0(jVar.F()))) {
            return false;
        }
        List<e1> parameters = d.a.b(eVar).h().getParameters();
        m.e(parameters, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
        e1 e1Var = (e1) s.i0(parameters);
        return (e1Var == null || (r1VarN = e1Var.n()) == null || r1VarN == r1.OUT_VARIANCE) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    private final List<g1> c(j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, kotlin.reflect.y.internal.j0.l.e1 e1Var) {
        boolean z;
        if (!jVar.x()) {
            if (jVar.F().isEmpty()) {
                List<e1> parameters = e1Var.getParameters();
                m.e(parameters, "constructor.parameters");
                z = parameters.isEmpty() ^ true;
            }
        }
        List<e1> parameters2 = e1Var.getParameters();
        m.e(parameters2, "constructor.parameters");
        if (z) {
            return d(jVar, parameters2, e1Var, aVar);
        }
        if (parameters2.size() != jVar.F().size()) {
            ArrayList arrayList = new ArrayList(v.u(parameters2, 10));
            for (e1 e1Var2 : parameters2) {
                kotlin.reflect.y.internal.j0.l.u1.j jVar2 = kotlin.reflect.y.internal.j0.l.u1.j.Z;
                String strK = e1Var2.getName().k();
                m.e(strK, "p.name.asString()");
                arrayList.add(new i1(kotlin.reflect.y.internal.j0.l.u1.k.d(jVar2, strK)));
            }
            return c0.E0(arrayList);
        }
        Iterable<IndexedValue> iterableK0 = c0.K0(jVar.F());
        ArrayList arrayList2 = new ArrayList(v.u(iterableK0, 10));
        for (IndexedValue indexedValue : iterableK0) {
            int index = indexedValue.getIndex();
            x xVar = (x) indexedValue.b();
            parameters2.size();
            e1 e1Var3 = parameters2.get(index);
            kotlin.reflect.y.internal.j0.d.a.l0.m.a aVarD = d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, false, null, 3, null);
            m.e(e1Var3, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
            arrayList2.add(p(xVar, aVarD, e1Var3));
        }
        return c0.E0(arrayList2);
    }

    private final List<g1> d(j jVar, List<? extends e1> list, kotlin.reflect.y.internal.j0.l.e1 e1Var, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        g1 g1VarJ;
        ArrayList arrayList = new ArrayList(v.u(list, 10));
        for (e1 e1Var2 : list) {
            if (kotlin.reflect.y.internal.j0.l.x1.a.k(e1Var2, null, aVar.f())) {
                g1VarJ = d.b(e1Var2, aVar);
            } else {
                g1VarJ = this.f23573d.j(e1Var2, jVar.x() ? aVar : aVar.i(b.INFLEXIBLE), new h0(this.a.e(), new a(e1Var2, jVar, aVar, e1Var)));
            }
            arrayList.add(g1VarJ);
        }
        return arrayList;
    }

    private final m0 e(j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, m0 m0Var) {
        a1 a1VarB;
        if (m0Var == null || (a1VarB = m0Var.N0()) == null) {
            a1VarB = b1.b(new kotlin.reflect.y.internal.j0.d.a.l0.d(this.a, jVar, false, 4, null));
        }
        a1 a1Var = a1VarB;
        kotlin.reflect.y.internal.j0.l.e1 e1VarF = f(jVar, aVar);
        if (e1VarF == null) {
            return null;
        }
        boolean zI = i(aVar);
        return (m.a(m0Var != null ? m0Var.O0() : null, e1VarF) && !jVar.x() && zI) ? m0Var.S0(true) : f0.i(a1Var, e1VarF, c(jVar, aVar, e1VarF), zI, null, 16, null);
    }

    private final kotlin.reflect.y.internal.j0.l.e1 f(j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        kotlin.reflect.y.internal.j0.l.e1 e1VarH;
        i iVarC = jVar.c();
        if (iVarC == null) {
            return g(jVar);
        }
        if (!(iVarC instanceof kotlin.reflect.y.internal.j0.d.a.n0.g)) {
            if (iVarC instanceof y) {
                e1 e1VarA = this.f23571b.a((y) iVarC);
                if (e1VarA != null) {
                    return e1VarA.h();
                }
                return null;
            }
            throw new IllegalStateException("Unknown classifier kind: " + iVarC);
        }
        kotlin.reflect.y.internal.j0.d.a.n0.g gVar = (kotlin.reflect.y.internal.j0.d.a.n0.g) iVarC;
        kotlin.reflect.y.internal.j0.f.c cVarD = gVar.d();
        if (cVarD != null) {
            e eVarJ = j(jVar, aVar, cVarD);
            if (eVarJ == null) {
                eVarJ = this.a.a().n().a(gVar);
            }
            return (eVarJ == null || (e1VarH = eVarJ.h()) == null) ? g(jVar) : e1VarH;
        }
        throw new AssertionError("Class type should have a FQ name: " + iVarC);
    }

    private final kotlin.reflect.y.internal.j0.l.e1 g(j jVar) {
        b bVarM = b.m(new kotlin.reflect.y.internal.j0.f.c(jVar.y()));
        m.e(bVarM, "topLevel(FqName(javaType.classifierQualifiedName))");
        kotlin.reflect.y.internal.j0.l.e1 e1VarH = this.a.a().b().d().q().d(bVarM, t.e(0)).h();
        m.e(e1VarH, "c.components.deserialize…istOf(0)).typeConstructor");
        return e1VarH;
    }

    private final boolean h(r1 r1Var, e1 e1Var) {
        return (e1Var.n() == r1.INVARIANT || r1Var == e1Var.n()) ? false : true;
    }

    private final boolean i(kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        return (aVar.d() == b.FLEXIBLE_LOWER_BOUND || aVar.g() || aVar.e() == kotlin.reflect.y.internal.j0.d.a.j0.k.SUPERTYPE) ? false : true;
    }

    private final e j(j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, kotlin.reflect.y.internal.j0.f.c cVar) {
        if (aVar.g() && m.a(cVar, d.a)) {
            return this.a.a().p().c();
        }
        d dVar = d.a;
        e eVarF = d.f(dVar, cVar, this.a.d().o(), null, 4, null);
        if (eVarF == null) {
            return null;
        }
        return (dVar.d(eVarF) && (aVar.d() == b.FLEXIBLE_LOWER_BOUND || aVar.e() == kotlin.reflect.y.internal.j0.d.a.j0.k.SUPERTYPE || b(jVar, eVarF))) ? dVar.b(eVarF) : eVarF;
    }

    public static /* synthetic */ e0 l(c cVar, f fVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return cVar.k(fVar, aVar, z);
    }

    private final e0 m(j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        boolean z = (aVar.g() || aVar.e() == kotlin.reflect.y.internal.j0.d.a.j0.k.SUPERTYPE) ? false : true;
        boolean zX = jVar.x();
        if (!zX && !z) {
            m0 m0VarE = e(jVar, aVar, null);
            return m0VarE != null ? m0VarE : n(jVar);
        }
        m0 m0VarE2 = e(jVar, aVar.i(b.FLEXIBLE_LOWER_BOUND), null);
        if (m0VarE2 == null) {
            return n(jVar);
        }
        m0 m0VarE3 = e(jVar, aVar.i(b.FLEXIBLE_UPPER_BOUND), m0VarE2);
        if (m0VarE3 == null) {
            return n(jVar);
        }
        return zX ? new f(m0VarE2, m0VarE3) : f0.d(m0VarE2, m0VarE3);
    }

    private static final kotlin.reflect.y.internal.j0.l.u1.h n(j jVar) {
        return kotlin.reflect.y.internal.j0.l.u1.k.d(kotlin.reflect.y.internal.j0.l.u1.j.f24850i, jVar.p());
    }

    private final g1 p(x xVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, e1 e1Var) {
        if (!(xVar instanceof kotlin.reflect.y.internal.j0.d.a.n0.c0)) {
            return new i1(r1.INVARIANT, o(xVar, aVar));
        }
        kotlin.reflect.y.internal.j0.d.a.n0.c0 c0Var = (kotlin.reflect.y.internal.j0.d.a.n0.c0) xVar;
        x xVarC = c0Var.C();
        r1 r1Var = c0Var.J() ? r1.OUT_VARIANCE : r1.IN_VARIANCE;
        return (xVarC == null || h(r1Var, e1Var)) ? d.b(e1Var, aVar) : kotlin.reflect.y.internal.j0.l.x1.a.e(o(xVarC, d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, false, null, 3, null)), r1Var, e1Var);
    }

    public final e0 k(f fVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, boolean z) {
        m.f(fVar, "arrayType");
        m.f(aVar, "attr");
        x xVarN = fVar.n();
        kotlin.reflect.y.internal.j0.d.a.n0.v vVar = xVarN instanceof kotlin.reflect.y.internal.j0.d.a.n0.v ? (kotlin.reflect.y.internal.j0.d.a.n0.v) xVarN : null;
        kotlin.reflect.y.internal.j0.b.i type = vVar != null ? vVar.getType() : null;
        kotlin.reflect.y.internal.j0.d.a.l0.d dVar = new kotlin.reflect.y.internal.j0.d.a.l0.d(this.a, fVar, true);
        if (type != null) {
            m0 m0VarO = this.a.d().o().O(type);
            m.e(m0VarO, "c.module.builtIns.getPri…KotlinType(primitiveType)");
            kotlin.reflect.y.internal.j0.l.x1.a.u(m0VarO, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.a(c0.m0(dVar, m0VarO.getAnnotations())));
            return aVar.g() ? m0VarO : f0.d(m0VarO, m0VarO.S0(true));
        }
        e0 e0VarO = o(xVarN, d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, aVar.g(), null, 2, null));
        if (aVar.g()) {
            m0 m0VarM = this.a.d().o().m(z ? r1.OUT_VARIANCE : r1.INVARIANT, e0VarO, dVar);
            m.e(m0VarM, "c.module.builtIns.getArr…mponentType, annotations)");
            return m0VarM;
        }
        m0 m0VarM2 = this.a.d().o().m(r1.INVARIANT, e0VarO, dVar);
        m.e(m0VarM2, "c.module.builtIns.getArr…mponentType, annotations)");
        return f0.d(m0VarM2, this.a.d().o().m(r1.OUT_VARIANCE, e0VarO, dVar).S0(true));
    }

    public final e0 o(x xVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        e0 e0VarO;
        m.f(aVar, "attr");
        if (xVar instanceof kotlin.reflect.y.internal.j0.d.a.n0.v) {
            kotlin.reflect.y.internal.j0.b.i type = ((kotlin.reflect.y.internal.j0.d.a.n0.v) xVar).getType();
            m0 m0VarR = type != null ? this.a.d().o().R(type) : this.a.d().o().Z();
            m.e(m0VarR, "{\n                val pr…ns.unitType\n            }");
            return m0VarR;
        }
        if (xVar instanceof j) {
            return m((j) xVar, aVar);
        }
        if (xVar instanceof f) {
            return l(this, (f) xVar, aVar, false, 4, null);
        }
        if (xVar instanceof kotlin.reflect.y.internal.j0.d.a.n0.c0) {
            x xVarC = ((kotlin.reflect.y.internal.j0.d.a.n0.c0) xVar).C();
            if (xVarC != null && (e0VarO = o(xVarC, aVar)) != null) {
                return e0VarO;
            }
            m0 m0VarY = this.a.d().o().y();
            m.e(m0VarY, "c.module.builtIns.defaultBound");
            return m0VarY;
        }
        if (xVar == null) {
            m0 m0VarY2 = this.a.d().o().y();
            m.e(m0VarY2, "c.module.builtIns.defaultBound");
            return m0VarY2;
        }
        throw new UnsupportedOperationException("Unsupported type: " + xVar);
    }
}
