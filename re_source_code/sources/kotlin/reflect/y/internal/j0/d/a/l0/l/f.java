package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.IntIterator;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p002reflect.jvm.internal.impl.descriptors.c1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.f1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.x0;
import kotlin.ranges.IntRange;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.a.a0;
import kotlin.reflect.y.internal.j0.d.a.i0;
import kotlin.reflect.y.internal.j0.d.a.m;
import kotlin.reflect.y.internal.j0.d.a.n0.j;
import kotlin.reflect.y.internal.j0.d.a.n0.x;
import kotlin.reflect.y.internal.j0.d.a.n0.y;
import kotlin.reflect.y.internal.j0.j.b.r;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends g implements kotlin.reflect.y.internal.j0.d.a.k0.c {
    public static final a n = new a(null);
    private static final Set<String> o = w0.i("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");
    private final x0<g> A;
    private final kotlin.reflect.y.internal.j0.i.w.f B;
    private final k C;
    private final kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g D;
    private final i<List<e1>> E;
    private final kotlin.reflect.y.internal.j0.d.a.l0.g p;
    private final kotlin.reflect.y.internal.j0.d.a.n0.g q;
    private final kotlin.p002reflect.jvm.internal.impl.descriptors.e r;
    private final kotlin.reflect.y.internal.j0.d.a.l0.g s;
    private final Lazy t;
    private final kotlin.p002reflect.jvm.internal.impl.descriptors.f u;
    private final d0 v;
    private final m1 w;
    private final boolean x;
    private final b y;
    private final g z;

    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    private final class b extends kotlin.reflect.y.internal.j0.l.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final i<List<e1>> f23499d;

        /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
        static final class a extends Lambda implements Function0<List<? extends e1>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ f f23501f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(0);
                this.f23501f = fVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends e1> invoke() {
                return f1.d(this.f23501f);
            }
        }

        public b() {
            super(f.this.s.e());
            this.f23499d = f.this.s.e().d(new a(f.this));
        }

        /* JADX WARN: Code duplicated, block: B:12:0x001c  */
        private final e0 x() {
            kotlin.reflect.y.internal.j0.f.c cVarB;
            ArrayList arrayList;
            kotlin.reflect.y.internal.j0.f.c cVarY = y();
            if (cVarY == null) {
                cVarY = null;
            } else {
                if (!(!cVarY.d() && cVarY.i(k.q))) {
                    cVarY = null;
                }
            }
            if (cVarY == null) {
                cVarB = m.a.b(kotlin.reflect.y.internal.j0.i.t.a.h(f.this));
                if (cVarB == null) {
                    return null;
                }
            } else {
                cVarB = cVarY;
            }
            kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarR = kotlin.reflect.y.internal.j0.i.t.a.r(f.this.s.d(), cVarB, kotlin.reflect.y.internal.j0.c.b.d.FROM_JAVA_LOADER);
            if (eVarR == null) {
                return null;
            }
            int size = eVarR.h().getParameters().size();
            List<e1> parameters = f.this.h().getParameters();
            kotlin.jvm.internal.m.e(parameters, "getTypeConstructor().parameters");
            int size2 = parameters.size();
            if (size2 == size) {
                arrayList = new ArrayList(v.u(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new i1(r1.INVARIANT, ((e1) it.next()).s()));
                }
            } else {
                if (size2 != 1 || size <= 1 || cVarY != null) {
                    return null;
                }
                i1 i1Var = new i1(r1.INVARIANT, ((e1) s.s0(parameters)).s());
                IntRange intRange = new IntRange(1, size);
                ArrayList arrayList2 = new ArrayList(v.u(intRange, 10));
                Iterator<Integer> it2 = intRange.iterator();
                while (it2.hasNext()) {
                    ((IntIterator) it2).b();
                    arrayList2.add(i1Var);
                }
                arrayList = arrayList2;
            }
            return f0.g(a1.f24676g.h(), eVarR, arrayList);
        }

        private final kotlin.reflect.y.internal.j0.f.c y() {
            String strB;
            kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g annotations = f.this.getAnnotations();
            kotlin.reflect.y.internal.j0.f.c cVar = a0.q;
            kotlin.jvm.internal.m.e(cVar, "PURELY_IMPLEMENTS_ANNOTATION");
            kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c cVarL = annotations.l(cVar);
            if (cVarL == null) {
                return null;
            }
            Object objT0 = s.t0(cVarL.a().values());
            kotlin.reflect.y.internal.j0.i.r.v vVar = objT0 instanceof kotlin.reflect.y.internal.j0.i.r.v ? (kotlin.reflect.y.internal.j0.i.r.v) objT0 : null;
            if (vVar == null || (strB = vVar.b()) == null || !kotlin.reflect.y.internal.j0.f.e.e(strB)) {
                return null;
            }
            return new kotlin.reflect.y.internal.j0.f.c(strB);
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public boolean e() {
            return true;
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public List<e1> getParameters() {
            return this.f23499d.invoke();
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected Collection<e0> l() {
            Collection<j> collectionA = f.this.Q0().a();
            ArrayList arrayList = new ArrayList(collectionA.size());
            ArrayList<x> arrayList2 = new ArrayList(0);
            e0 e0VarX = x();
            Iterator<j> it = collectionA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j next = it.next();
                e0 e0VarH = f.this.s.a().r().h(f.this.s.g().o(next, kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.SUPERTYPE, false, null, 3, null)), f.this.s);
                if (e0VarH.O0().w() instanceof j0.b) {
                    arrayList2.add(next);
                }
                if (!kotlin.jvm.internal.m.a(e0VarH.O0(), e0VarX != null ? e0VarX.O0() : null) && !h.b0(e0VarH)) {
                    arrayList.add(e0VarH);
                }
            }
            kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar = f.this.r;
            kotlin.p002reflect.jvm.internal.impl.utils.a.a(arrayList, eVar != null ? kotlin.reflect.y.internal.j0.b.q.j.a(eVar, f.this).c().p(eVar.s(), r1.INVARIANT) : null);
            kotlin.p002reflect.jvm.internal.impl.utils.a.a(arrayList, e0VarX);
            if (!arrayList2.isEmpty()) {
                r rVarC = f.this.s.a().c();
                kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarW = w();
                ArrayList arrayList3 = new ArrayList(v.u(arrayList2, 10));
                for (x xVar : arrayList2) {
                    kotlin.jvm.internal.m.d(xVar, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    arrayList3.add(((j) xVar).p());
                }
                rVarC.b(eVarW, arrayList3);
            }
            return arrayList.isEmpty() ^ true ? c0.E0(arrayList) : t.e(f.this.s.d().o().i());
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected c1 q() {
            return f.this.s.a().v();
        }

        public String toString() {
            String strK = f.this.getName().k();
            kotlin.jvm.internal.m.e(strK, "name.asString()");
            return strK;
        }

        @Override // kotlin.reflect.y.internal.j0.l.m, kotlin.reflect.y.internal.j0.l.e1
        public kotlin.p002reflect.jvm.internal.impl.descriptors.e w() {
            return f.this;
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    static final class c extends Lambda implements Function0<List<? extends e1>> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends e1> invoke() {
            List<y> typeParameters = f.this.Q0().getTypeParameters();
            f fVar = f.this;
            ArrayList arrayList = new ArrayList(v.u(typeParameters, 10));
            for (y yVar : typeParameters) {
                e1 e1VarA = fVar.s.f().a(yVar);
                if (e1VarA == null) {
                    throw new AssertionError("Parameter " + yVar + " surely belongs to class " + fVar.Q0() + ", so it must be resolved");
                }
                arrayList.add(e1VarA);
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return kotlin.comparisons.b.a(kotlin.reflect.y.internal.j0.i.t.a.h((kotlin.p002reflect.jvm.internal.impl.descriptors.e) t).b(), kotlin.reflect.y.internal.j0.i.t.a.h((kotlin.p002reflect.jvm.internal.impl.descriptors.e) t2).b());
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    static final class e extends Lambda implements Function0<List<? extends kotlin.reflect.y.internal.j0.d.a.n0.a>> {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.reflect.y.internal.j0.d.a.n0.a> invoke() {
            kotlin.reflect.y.internal.j0.f.b bVarG = kotlin.reflect.y.internal.j0.i.t.a.g(f.this);
            if (bVarG != null) {
                return f.this.S0().a().f().a(bVarG);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.a.l0.l.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    static final class C0332f extends Lambda implements Function1<kotlin.reflect.y.internal.j0.l.t1.g, g> {
        C0332f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g invoke(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
            kotlin.jvm.internal.m.f(gVar, "it");
            kotlin.reflect.y.internal.j0.d.a.l0.g gVar2 = f.this.s;
            f fVar = f.this;
            return new g(gVar2, fVar, fVar.Q0(), f.this.r != null, f.this.z);
        }
    }

    public /* synthetic */ f(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.y.internal.j0.d.a.n0.g gVar2, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, int i2, kotlin.jvm.internal.g gVar3) {
        this(gVar, mVar, gVar2, (i2 & 8) != 0 ? null : eVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean A() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean D() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean E0() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.e> J() {
        if (this.v != d0.SEALED) {
            return u.j();
        }
        kotlin.reflect.y.internal.j0.d.a.l0.m.a aVarD = kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, false, null, 3, null);
        Collection<j> collectionN = this.q.N();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionN.iterator();
        while (it.hasNext()) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarW = this.s.g().o((j) it.next(), aVarD).O0().w();
            kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar = hVarW instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e ? (kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarW : null;
            if (eVar != null) {
                arrayList.add(eVar);
            }
        }
        return c0.x0(arrayList, new d());
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean J0() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return false;
    }

    public final f O0(kotlin.reflect.y.internal.j0.d.a.j0.g gVar, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.jvm.internal.m.f(gVar, "javaResolverCache");
        kotlin.reflect.y.internal.j0.d.a.l0.g gVar2 = this.s;
        kotlin.reflect.y.internal.j0.d.a.l0.g gVarI = kotlin.reflect.y.internal.j0.d.a.l0.a.i(gVar2, gVar2.a().x(gVar));
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = b();
        kotlin.jvm.internal.m.e(mVarB, "containingDeclaration");
        return new f(gVarI, mVarB, this.q, eVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public List<kotlin.p002reflect.jvm.internal.impl.descriptors.d> k() {
        return this.z.w0().invoke();
    }

    public final kotlin.reflect.y.internal.j0.d.a.n0.g Q0() {
        return this.q;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public kotlin.p002reflect.jvm.internal.impl.descriptors.d R() {
        return null;
    }

    public final List<kotlin.reflect.y.internal.j0.d.a.n0.a> R0() {
        return (List) this.t.getValue();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h S() {
        return this.C;
    }

    public final kotlin.reflect.y.internal.j0.d.a.l0.g S0() {
        return this.p;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.a, kotlin.p002reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public g D0() {
        kotlin.reflect.y.internal.j0.i.w.h hVarD0 = super.D0();
        kotlin.jvm.internal.m.d(hVarD0, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (g) hVarD0;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public kotlin.p002reflect.jvm.internal.impl.descriptors.e U() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.t
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public g H(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        kotlin.jvm.internal.m.f(gVar, "kotlinTypeRefiner");
        return (g) this.A.c(gVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        return this.D;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.q, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public kotlin.p002reflect.jvm.internal.impl.descriptors.u getVisibility() {
        if (!kotlin.jvm.internal.m.a(this.w, kotlin.p002reflect.jvm.internal.impl.descriptors.t.a) || this.q.i() != null) {
            return i0.c(this.w);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.u uVar = kotlin.reflect.y.internal.j0.d.a.r.a;
        kotlin.jvm.internal.m.e(uVar, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
        return uVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.y.internal.j0.l.e1 h() {
        return this.y;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public kotlin.p002reflect.jvm.internal.impl.descriptors.f i() {
        return this.u;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public d0 j() {
        return this.v;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean l() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i
    public boolean m() {
        return this.x;
    }

    public String toString() {
        return "Lazy Java class " + kotlin.reflect.y.internal.j0.i.t.a.i(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.i
    public List<e1> w() {
        return this.E.invoke();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.a, kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h y0() {
        return this.B;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public g1<m0> z0() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.y.internal.j0.d.a.n0.g gVar2, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        d0 d0VarA;
        super(gVar.e(), mVar, gVar2.getName(), gVar.a().t().a(gVar2), false);
        kotlin.jvm.internal.m.f(gVar, "outerContext");
        kotlin.jvm.internal.m.f(mVar, "containingDeclaration");
        kotlin.jvm.internal.m.f(gVar2, "jClass");
        this.p = gVar;
        this.q = gVar2;
        this.r = eVar;
        kotlin.reflect.y.internal.j0.d.a.l0.g gVarD = kotlin.reflect.y.internal.j0.d.a.l0.a.d(gVar, this, gVar2, 0, 4, null);
        this.s = gVarD;
        gVarD.a().h().c(gVar2, this);
        gVar2.I();
        this.t = kotlin.i.b(new e());
        this.u = gVar2.r() ? kotlin.p002reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS : gVar2.H() ? kotlin.p002reflect.jvm.internal.impl.descriptors.f.INTERFACE : gVar2.B() ? kotlin.p002reflect.jvm.internal.impl.descriptors.f.ENUM_CLASS : kotlin.p002reflect.jvm.internal.impl.descriptors.f.CLASS;
        if (gVar2.r() || gVar2.B()) {
            d0VarA = d0.FINAL;
        } else {
            d0VarA = d0.f25129f.a(gVar2.o(), gVar2.o() || gVar2.isAbstract() || gVar2.H(), !gVar2.isFinal());
        }
        this.v = d0VarA;
        this.w = gVar2.getVisibility();
        this.x = (gVar2.i() == null || gVar2.Q()) ? false : true;
        this.y = new b();
        g gVar3 = new g(gVarD, this, gVar2, eVar != null, null, 16, null);
        this.z = gVar3;
        this.A = x0.a.a(this, gVarD.e(), gVarD.a().k().c(), new C0332f());
        this.B = new kotlin.reflect.y.internal.j0.i.w.f(gVar3);
        this.C = new k(gVarD, gVar2, this);
        this.D = kotlin.reflect.y.internal.j0.d.a.l0.e.a(gVarD, gVar2);
        this.E = gVarD.e().d(new c());
    }
}
