package kotlin.reflect.y.internal.j0.j.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.p;
import kotlin.reflect.y.internal.j0.l.r0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.s0;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.reflect.y.internal.j0.l.z0;
import kotlin.sequences.l;
import kotlin.sequences.n;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: TypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 {
    private final m a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d0 f24475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f24477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function1<Integer, h> f24478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function1<Integer, h> f24479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<Integer, e1> f24480g;

    /* JADX INFO: compiled from: TypeDeserializer.kt */
    static final class a extends Lambda implements Function1<Integer, h> {
        a() {
            super(1);
        }

        public final h b(int i2) {
            return d0.this.d(i2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ h invoke(Integer num) {
            return b(num.intValue());
        }
    }

    /* JADX INFO: compiled from: TypeDeserializer.kt */
    static final class b extends Lambda implements Function0<List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ q f24483g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(q qVar) {
            super(0);
            this.f24483g = qVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> invoke() {
            return d0.this.a.c().d().d(this.f24483g, d0.this.a.g());
        }
    }

    /* JADX INFO: compiled from: TypeDeserializer.kt */
    static final class c extends Lambda implements Function1<Integer, h> {
        c() {
            super(1);
        }

        public final h b(int i2) {
            return d0.this.f(i2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ h invoke(Integer num) {
            return b(num.intValue());
        }
    }

    /* JADX INFO: compiled from: TypeDeserializer.kt */
    /* synthetic */ class d extends i implements Function1<kotlin.reflect.y.internal.j0.f.b, kotlin.reflect.y.internal.j0.f.b> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f24485h = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "getOuterClassId";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(kotlin.reflect.y.internal.j0.f.b.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.f.b invoke(kotlin.reflect.y.internal.j0.f.b bVar) {
            m.f(bVar, "p0");
            return bVar.g();
        }
    }

    /* JADX INFO: compiled from: TypeDeserializer.kt */
    static final class e extends Lambda implements Function1<q, q> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final q invoke(q qVar) {
            m.f(qVar, "it");
            return kotlin.reflect.y.internal.j0.e.z.f.g(qVar, d0.this.a.j());
        }
    }

    /* JADX INFO: compiled from: TypeDeserializer.kt */
    static final class f extends Lambda implements Function1<q, Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f24487f = new f();

        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(q qVar) {
            m.f(qVar, "it");
            return Integer.valueOf(qVar.U());
        }
    }

    public d0(m mVar, d0 d0Var, List<s> list, String str, String str2) {
        Map<Integer, e1> linkedHashMap;
        m.f(mVar, "c");
        m.f(list, "typeParameterProtos");
        m.f(str, "debugName");
        m.f(str2, "containerPresentableName");
        this.a = mVar;
        this.f24475b = d0Var;
        this.f24476c = str;
        this.f24477d = str2;
        this.f24478e = mVar.h().i(new a());
        this.f24479f = mVar.h().i(new c());
        if (list.isEmpty()) {
            linkedHashMap = q0.i();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i2 = 0;
            for (s sVar : list) {
                linkedHashMap.put(Integer.valueOf(sVar.M()), new kotlin.reflect.y.internal.j0.j.b.g0.m(this.a, sVar, i2));
                i2++;
            }
        }
        this.f24480g = linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h d(int i2) {
        kotlin.reflect.y.internal.j0.f.b bVarA = x.a(this.a.g(), i2);
        return bVarA.k() ? this.a.c().b(bVarA) : x.b(this.a.c().p(), bVarA);
    }

    private final m0 e(int i2) {
        if (x.a(this.a.g(), i2).k()) {
            return this.a.c().n().a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h f(int i2) {
        kotlin.reflect.y.internal.j0.f.b bVarA = x.a(this.a.g(), i2);
        if (bVarA.k()) {
            return null;
        }
        return x.d(this.a.c().p(), bVarA);
    }

    private final m0 g(e0 e0Var, e0 e0Var2) {
        kotlin.reflect.y.internal.j0.b.h hVarH = kotlin.reflect.y.internal.j0.l.x1.a.h(e0Var);
        g annotations = e0Var.getAnnotations();
        e0 e0VarJ = kotlin.reflect.y.internal.j0.b.g.j(e0Var);
        List<e0> listE = kotlin.reflect.y.internal.j0.b.g.e(e0Var);
        List listN = c0.N(kotlin.reflect.y.internal.j0.b.g.l(e0Var), 1);
        ArrayList arrayList = new ArrayList(v.u(listN, 10));
        Iterator it = listN.iterator();
        while (it.hasNext()) {
            arrayList.add(((g1) it.next()).getType());
        }
        return kotlin.reflect.y.internal.j0.b.g.b(hVarH, annotations, e0VarJ, listE, arrayList, null, e0Var2, true).S0(e0Var.P0());
    }

    private final m0 h(a1 a1Var, kotlin.reflect.y.internal.j0.l.e1 e1Var, List<? extends g1> list, boolean z) {
        int size;
        int size2 = e1Var.getParameters().size() - list.size();
        m0 m0VarI = null;
        if (size2 == 0) {
            m0VarI = i(a1Var, e1Var, list, z);
        } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
            kotlin.reflect.y.internal.j0.l.e1 e1VarH = e1Var.o().X(size).h();
            m.e(e1VarH, "functionTypeConstructor.…on(arity).typeConstructor");
            m0VarI = f0.i(a1Var, e1VarH, list, z, null, 16, null);
        }
        return m0VarI == null ? k.a.f(j.S, list, e1Var, new String[0]) : m0VarI;
    }

    private final m0 i(a1 a1Var, kotlin.reflect.y.internal.j0.l.e1 e1Var, List<? extends g1> list, boolean z) {
        m0 m0VarI = f0.i(a1Var, e1Var, list, z, null, 16, null);
        if (kotlin.reflect.y.internal.j0.b.g.p(m0VarI)) {
            return p(m0VarI);
        }
        return null;
    }

    private final e1 k(int i2) {
        e1 e1Var = this.f24480g.get(Integer.valueOf(i2));
        if (e1Var != null) {
            return e1Var;
        }
        d0 d0Var = this.f24475b;
        if (d0Var != null) {
            return d0Var.k(i2);
        }
        return null;
    }

    private static final List<q.b> m(q qVar, d0 d0Var) {
        List<q.b> listV = qVar.V();
        m.e(listV, "argumentList");
        q qVarG = kotlin.reflect.y.internal.j0.e.z.f.g(qVar, d0Var.a.j());
        List<q.b> listM = qVarG != null ? m(qVarG, d0Var) : null;
        if (listM == null) {
            listM = u.j();
        }
        return c0.o0(listV, listM);
    }

    public static /* synthetic */ m0 n(d0 d0Var, q qVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return d0Var.l(qVar, z);
    }

    private final a1 o(List<? extends z0> list, g gVar, kotlin.reflect.y.internal.j0.l.e1 e1Var, kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        ArrayList arrayList = new ArrayList(v.u(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((z0) it.next()).a(gVar, e1Var, mVar));
        }
        return a1.f24676g.g(v.w(arrayList));
    }

    private final m0 p(e0 e0Var) {
        e0 type;
        g1 g1Var = (g1) kotlin.collections.s.i0(kotlin.reflect.y.internal.j0.b.g.l(e0Var));
        if (g1Var == null || (type = g1Var.getType()) == null) {
            return null;
        }
        h hVarC = type.O0().w();
        kotlin.reflect.y.internal.j0.f.c cVarH = hVarC != null ? kotlin.reflect.y.internal.j0.i.t.a.h(hVarC) : null;
        if (type.M0().size() != 1 || (!m.a(cVarH, kotlin.reflect.y.internal.j0.b.k.m) && !m.a(cVarH, e0.a))) {
            return (m0) e0Var;
        }
        e0 type2 = ((g1) kotlin.collections.s.s0(type.M0())).getType();
        m.e(type2, "continuationArgumentType.arguments.single().type");
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarE = this.a.e();
        if (!(mVarE instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.a)) {
            mVarE = null;
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.p002reflect.jvm.internal.impl.descriptors.a) mVarE;
        return m.a(aVar != null ? kotlin.reflect.y.internal.j0.i.t.a.d(aVar) : null, c0.a) ? g(e0Var, type2) : g(e0Var, type2);
    }

    private final g1 r(e1 e1Var, q.b bVar) {
        if (bVar.x() == q.b.c.STAR) {
            return e1Var == null ? new r0(this.a.c().p().o()) : new s0(e1Var);
        }
        a0 a0Var = a0.a;
        q.b.c cVarX = bVar.x();
        m.e(cVarX, "typeArgumentProto.projection");
        r1 r1VarC = a0Var.c(cVarX);
        q qVarM = kotlin.reflect.y.internal.j0.e.z.f.m(bVar, this.a.j());
        return qVarM == null ? new i1(k.d(j.C0, bVar.toString())) : new i1(r1VarC, q(qVarM));
    }

    private final kotlin.reflect.y.internal.j0.l.e1 s(q qVar) {
        h hVarInvoke;
        Object next;
        if (qVar.m0()) {
            hVarInvoke = this.f24478e.invoke(Integer.valueOf(qVar.X()));
            if (hVarInvoke == null) {
                hVarInvoke = t(this, qVar, qVar.X());
            }
        } else if (qVar.v0()) {
            hVarInvoke = k(qVar.i0());
            if (hVarInvoke == null) {
                return k.a.e(j.Q, String.valueOf(qVar.i0()), this.f24477d);
            }
        } else if (qVar.w0()) {
            String string = this.a.g().getString(qVar.j0());
            Iterator<T> it = j().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!m.a(((e1) next).getName().k(), string));
            hVarInvoke = (e1) next;
            if (hVarInvoke == null) {
                return k.a.e(j.R, string, this.a.e().toString());
            }
        } else {
            if (!qVar.u0()) {
                return k.a.e(j.U, new String[0]);
            }
            hVarInvoke = this.f24479f.invoke(Integer.valueOf(qVar.h0()));
            if (hVarInvoke == null) {
                hVarInvoke = t(this, qVar, qVar.h0());
            }
        }
        kotlin.reflect.y.internal.j0.l.e1 e1VarH = hVarInvoke.h();
        m.e(e1VarH, "classifier.typeConstructor");
        return e1VarH;
    }

    private static final kotlin.p002reflect.jvm.internal.impl.descriptors.e t(d0 d0Var, q qVar, int i2) {
        kotlin.reflect.y.internal.j0.f.b bVarA = x.a(d0Var.a.g(), i2);
        List<Integer> listB = n.B(n.u(l.f(qVar, d0Var.new e()), f.f24487f));
        int iJ = n.j(l.f(bVarA, d.f24485h));
        while (listB.size() < iJ) {
            listB.add(0);
        }
        return d0Var.a.c().q().d(bVarA, listB);
    }

    public final List<e1> j() {
        return c0.E0(this.f24480g.values());
    }

    public final m0 l(q qVar, boolean z) {
        m0 m0VarI;
        m0 m0VarJ;
        m.f(qVar, "proto");
        m0 m0VarE = qVar.m0() ? e(qVar.X()) : qVar.u0() ? e(qVar.h0()) : null;
        if (m0VarE != null) {
            return m0VarE;
        }
        kotlin.reflect.y.internal.j0.l.e1 e1VarS = s(qVar);
        boolean z2 = true;
        if (k.m(e1VarS.w())) {
            return k.a.c(j.x0, e1VarS, e1VarS.toString());
        }
        kotlin.reflect.y.internal.j0.j.b.g0.a aVar = new kotlin.reflect.y.internal.j0.j.b.g0.a(this.a.h(), new b(qVar));
        a1 a1VarO = o(this.a.c().v(), aVar, e1VarS, this.a.e());
        List<q.b> listM = m(qVar, this);
        ArrayList arrayList = new ArrayList(v.u(listM, 10));
        int i2 = 0;
        for (Object obj : listM) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                u.t();
            }
            List<e1> parameters = e1VarS.getParameters();
            m.e(parameters, "constructor.parameters");
            arrayList.add(r((e1) kotlin.collections.s.X(parameters, i2), (q.b) obj));
            i2 = i3;
        }
        List<? extends g1> listE0 = c0.E0(arrayList);
        h hVarC = e1VarS.w();
        if (z && (hVarC instanceof d1)) {
            f0 f0Var = f0.a;
            m0 m0VarB = f0.b((d1) hVarC, listE0);
            a1 a1VarO2 = o(this.a.c().v(), g.f25179c.a(c0.m0(aVar, m0VarB.getAnnotations())), e1VarS, this.a.e());
            if (!kotlin.reflect.y.internal.j0.l.g0.b(m0VarB) && !qVar.e0()) {
                z2 = false;
            }
            m0VarI = m0VarB.S0(z2).U0(a1VarO2);
        } else {
            Boolean boolD = kotlin.reflect.y.internal.j0.e.z.b.a.d(qVar.a0());
            m.e(boolD, "SUSPEND_TYPE.get(proto.flags)");
            if (boolD.booleanValue()) {
                m0VarI = h(a1VarO, e1VarS, listE0, qVar.e0());
            } else {
                m0VarI = f0.i(a1VarO, e1VarS, listE0, qVar.e0(), null, 16, null);
                Boolean boolD2 = kotlin.reflect.y.internal.j0.e.z.b.f24182b.d(qVar.a0());
                m.e(boolD2, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
                if (boolD2.booleanValue()) {
                    p pVarC = p.a.c(p.f24771g, m0VarI, false, 2, null);
                    if (pVarC == null) {
                        throw new IllegalStateException(("null DefinitelyNotNullType for '" + m0VarI + '\'').toString());
                    }
                    m0VarI = pVarC;
                }
            }
        }
        q qVarA = kotlin.reflect.y.internal.j0.e.z.f.a(qVar, this.a.j());
        if (qVarA != null && (m0VarJ = kotlin.reflect.y.internal.j0.l.q0.j(m0VarI, l(qVarA, false))) != null) {
            m0VarI = m0VarJ;
        }
        return qVar.m0() ? this.a.c().t().a(x.a(this.a.g(), qVar.X()), m0VarI) : m0VarI;
    }

    public final e0 q(q qVar) {
        m.f(qVar, "proto");
        if (!qVar.o0()) {
            return l(qVar, true);
        }
        String string = this.a.g().getString(qVar.b0());
        m0 m0VarN = n(this, qVar, false, 2, null);
        q qVarC = kotlin.reflect.y.internal.j0.e.z.f.c(qVar, this.a.j());
        m.c(qVarC);
        return this.a.c().l().a(qVar, string, m0VarN, n(this, qVarC, false, 2, null));
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f24476c);
        if (this.f24475b == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            str = ". Child of " + this.f24475b.f24476c;
        }
        sb.append(str);
        return sb.toString();
    }
}
