package kotlin.reflect.y.internal.j0.d.a.l0.m;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.p0;
import kotlin.collections.v;
import kotlin.collections.v0;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.k.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.u1.h;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.s;

/* JADX INFO: compiled from: TypeParameterUpperBoundEraser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f23588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f23589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.g<a, e0> f23590d;

    /* JADX INFO: compiled from: TypeParameterUpperBoundEraser.kt */
    private static final class a {
        private final e1 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f23591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.d.a.l0.m.a f23592c;

        public a(e1 e1Var, boolean z, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
            m.f(e1Var, "typeParameter");
            m.f(aVar, "typeAttr");
            this.a = e1Var;
            this.f23591b = z;
            this.f23592c = aVar;
        }

        public final kotlin.reflect.y.internal.j0.d.a.l0.m.a a() {
            return this.f23592c;
        }

        public final e1 b() {
            return this.a;
        }

        public final boolean c() {
            return this.f23591b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(aVar.a, this.a) && aVar.f23591b == this.f23591b && aVar.f23592c.d() == this.f23592c.d() && aVar.f23592c.e() == this.f23592c.e() && aVar.f23592c.g() == this.f23592c.g() && m.a(aVar.f23592c.c(), this.f23592c.c());
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode();
            int i2 = iHashCode + (iHashCode * 31) + (this.f23591b ? 1 : 0);
            int iHashCode2 = i2 + (i2 * 31) + this.f23592c.d().hashCode();
            int iHashCode3 = iHashCode2 + (iHashCode2 * 31) + this.f23592c.e().hashCode();
            int i3 = iHashCode3 + (iHashCode3 * 31) + (this.f23592c.g() ? 1 : 0);
            int i4 = i3 * 31;
            m0 m0VarC = this.f23592c.c();
            return i3 + i4 + (m0VarC != null ? m0VarC.hashCode() : 0);
        }

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.a + ", isRaw=" + this.f23591b + ", typeAttr=" + this.f23592c + ')';
        }
    }

    /* JADX INFO: compiled from: TypeParameterUpperBoundEraser.kt */
    static final class b extends Lambda implements Function0<h> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h invoke() {
            return k.d(j.z0, g.this.toString());
        }
    }

    /* JADX INFO: compiled from: TypeParameterUpperBoundEraser.kt */
    static final class c extends Lambda implements Function1<a, e0> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(a aVar) {
            return g.this.d(aVar.b(), aVar.c(), aVar.a());
        }
    }

    public g(e eVar) {
        f fVar = new f("Type parameter upper bound erasion results");
        this.a = fVar;
        this.f23588b = i.b(new b());
        this.f23589c = eVar == null ? new e(this) : eVar;
        kotlin.reflect.y.internal.j0.k.g<a, e0> gVarH = fVar.h(new c());
        m.e(gVarH, "storage.createMemoizedFu… isRaw, typeAttr) }\n    }");
        this.f23590d = gVarH;
    }

    private final e0 b(kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        e0 e0VarW;
        m0 m0VarC = aVar.c();
        return (m0VarC == null || (e0VarW = kotlin.reflect.y.internal.j0.l.x1.a.w(m0VarC)) == null) ? e() : e0VarW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e0 d(e1 e1Var, boolean z, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        g1 g1VarJ;
        Set<e1> setF = aVar.f();
        if (setF != null && setF.contains(e1Var.a())) {
            return b(aVar);
        }
        m0 m0VarS = e1Var.s();
        m.e(m0VarS, "typeParameter.defaultType");
        Set<e1> setF2 = kotlin.reflect.y.internal.j0.l.x1.a.f(m0VarS, setF);
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(p0.e(v.u(setF2, 10)), 16));
        for (e1 e1Var2 : setF2) {
            if (setF == null || !setF.contains(e1Var2)) {
                e eVar = this.f23589c;
                kotlin.reflect.y.internal.j0.d.a.l0.m.a aVarI = z ? aVar : aVar.i(kotlin.reflect.y.internal.j0.d.a.l0.m.b.INFLEXIBLE);
                e0 e0VarC = c(e1Var2, z, aVar.j(e1Var));
                m.e(e0VarC, "getErasedUpperBound(it, …Parameter(typeParameter))");
                g1VarJ = eVar.j(e1Var2, aVarI, e0VarC);
            } else {
                g1VarJ = d.b(e1Var2, aVar);
            }
            Pair pairA = s.a(e1Var2.h(), g1VarJ);
            linkedHashMap.put(pairA.c(), pairA.d());
        }
        l1 l1VarG = l1.g(f1.a.e(f1.f24727c, linkedHashMap, false, 2, null));
        m.e(l1VarG, "create(TypeConstructorSu…rsMap(erasedUpperBounds))");
        List<e0> upperBounds = e1Var.getUpperBounds();
        m.e(upperBounds, "typeParameter.upperBounds");
        e0 e0Var = (e0) kotlin.collections.s.U(upperBounds);
        if (e0Var.O0().w() instanceof e) {
            m.e(e0Var, "firstUpperBound");
            return kotlin.reflect.y.internal.j0.l.x1.a.v(e0Var, l1VarG, linkedHashMap, r1.OUT_VARIANCE, aVar.f());
        }
        Set<e1> setF3 = aVar.f();
        if (setF3 == null) {
            setF3 = v0.c(this);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarW = e0Var.O0().w();
        m.d(hVarW, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            e1 e1Var3 = (e1) hVarW;
            if (setF3.contains(e1Var3)) {
                return b(aVar);
            }
            List<e0> upperBounds2 = e1Var3.getUpperBounds();
            m.e(upperBounds2, "current.upperBounds");
            e0 e0Var2 = (e0) kotlin.collections.s.U(upperBounds2);
            if (e0Var2.O0().w() instanceof e) {
                m.e(e0Var2, "nextUpperBound");
                return kotlin.reflect.y.internal.j0.l.x1.a.v(e0Var2, l1VarG, linkedHashMap, r1.OUT_VARIANCE, aVar.f());
            }
            hVarW = e0Var2.O0().w();
            m.d(hVarW, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }

    private final h e() {
        return (h) this.f23588b.getValue();
    }

    public final e0 c(e1 e1Var, boolean z, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        m.f(e1Var, "typeParameter");
        m.f(aVar, "typeAttr");
        return this.f23590d.invoke(new a(e1Var, z, aVar));
    }

    public /* synthetic */ g(e eVar, int i2, kotlin.jvm.internal.g gVar) {
        this((i2 & 1) != 0 ? null : eVar);
    }
}
