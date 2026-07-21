package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.g0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends k implements d1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final u f25224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<? extends e1> f25225k;
    private final c l;

    /* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
    static final class a extends Lambda implements Function1<g, m0> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0 invoke(g gVar) {
            h hVarF = gVar.f(d.this);
            if (hVarF != null) {
                return hVarF.s();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
    static final class b extends Lambda implements Function1<q1, Boolean> {
        b() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x002d  */
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q1 q1Var) {
            boolean z;
            m.e(q1Var, "type");
            if (!g0.a(q1Var)) {
                d dVar = d.this;
                h hVarW = q1Var.O0().w();
                z = (hVarW instanceof e1) && !m.a(((e1) hVarW).b(), dVar);
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
    public static final class c implements kotlin.reflect.y.internal.j0.l.e1 {
        c() {
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public Collection<e0> a() {
            Collection<e0> collectionA = w().g0().O0().a();
            m.e(collectionA, "declarationDescriptor.un…pe.constructor.supertypes");
            return collectionA;
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public kotlin.reflect.y.internal.j0.l.e1 b(g gVar) {
            m.f(gVar, "kotlinTypeRefiner");
            return this;
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public boolean e() {
            return true;
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public d1 w() {
            return d.this;
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public List<e1> getParameters() {
            return d.this.N0();
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public kotlin.reflect.y.internal.j0.b.h o() {
            return kotlin.reflect.y.internal.j0.i.t.a.f(w());
        }

        public String toString() {
            return "[typealias " + w().getName().k() + ']';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, f fVar, z0 z0Var, u uVar) {
        super(mVar, gVar, fVar, z0Var);
        m.f(mVar, "containingDeclaration");
        m.f(gVar, "annotations");
        m.f(fVar, "name");
        m.f(z0Var, "sourceElement");
        m.f(uVar, "visibilityImpl");
        this.f25224j = uVar;
        this.l = new c();
    }

    protected final m0 A0() {
        kotlin.reflect.y.internal.j0.i.w.h hVarD0;
        e eVarR = r();
        if (eVarR == null || (hVarD0 = eVarR.D0()) == null) {
            hVarD0 = kotlin.f0.y.e.j0.i.w.h.b.f24422b;
        }
        m0 m0VarT = n1.t(this, hVarD0, new a());
        m.e(m0VarT, "@OptIn(TypeRefinement::c…s)?.defaultType\n        }");
        return m0VarT;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean E0() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        m.f(oVar, "visitor");
        return oVar.e(this, d2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public d1 a() {
        p pVarA = super.a();
        m.d(pVarA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (d1) pVarA;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return false;
    }

    public final Collection<i0> M0() {
        e eVarR = r();
        if (eVarR == null) {
            return kotlin.collections.u.j();
        }
        Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.d> collectionK = eVarR.k();
        m.e(collectionK, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (kotlin.p002reflect.jvm.internal.impl.descriptors.d dVar : collectionK) {
            j0.a aVar = j0.J;
            n nVarH0 = h0();
            m.e(dVar, "it");
            i0 i0VarB = aVar.b(nVarH0, this, dVar);
            if (i0VarB != null) {
                arrayList.add(i0VarB);
            }
        }
        return arrayList;
    }

    protected abstract List<e1> N0();

    public final void O0(List<? extends e1> list) {
        m.f(list, "declaredTypeParameters");
        this.f25225k = list;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.q, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public u getVisibility() {
        return this.f25224j;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.y.internal.j0.l.e1 h() {
        return this.l;
    }

    protected abstract n h0();

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i
    public boolean m() {
        return n1.c(g0(), new b());
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j
    public String toString() {
        return "typealias " + getName().k();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i
    public List<e1> w() {
        List list = this.f25225k;
        if (list != null) {
            return list;
        }
        m.w("declaredTypeParametersImpl");
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean z() {
        return false;
    }
}
