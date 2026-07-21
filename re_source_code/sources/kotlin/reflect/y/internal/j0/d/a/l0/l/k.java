package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.collections.w0;
import kotlin.collections.z;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.d.a.n0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.q;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.sequences.n;
import kotlin.u;

/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends l {
    private final g n;
    private final f o;

    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    static final class a extends Lambda implements Function1<q, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f23557f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q qVar) {
            m.f(qVar, "it");
            return Boolean.valueOf(qVar.Q());
        }
    }

    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    static final class b extends Lambda implements Function1<h, Collection<? extends t0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f23558f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(f fVar) {
            super(1);
            this.f23558f = fVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<? extends t0> invoke(h hVar) {
            m.f(hVar, "it");
            return hVar.c(this.f23558f, kotlin.reflect.y.internal.j0.c.b.d.WHEN_GET_SUPER_MEMBERS);
        }
    }

    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    static final class c extends Lambda implements Function1<h, Collection<? extends f>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f23559f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<f> invoke(h hVar) {
            m.f(hVar, "it");
            return hVar.d();
        }
    }

    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    static final class d<N> implements kotlin.reflect.jvm.internal.impl.utils.b.c {
        public static final d<N> a = new d<>();

        /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
        static final class a extends Lambda implements Function1<e0, kotlin.p002reflect.jvm.internal.impl.descriptors.e> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f23560f = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final kotlin.p002reflect.jvm.internal.impl.descriptors.e invoke(e0 e0Var) {
                kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarW = e0Var.O0().w();
                if (hVarW instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e) {
                    return (kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarW;
                }
                return null;
            }
        }

        d() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<kotlin.p002reflect.jvm.internal.impl.descriptors.e> a(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
            Collection<e0> collectionA = eVar.h().a();
            m.e(collectionA, "it.typeConstructor.supertypes");
            return n.i(n.v(c0.J(collectionA), a.f23560f));
        }
    }

    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    public static final class e extends kotlin.p002reflect.jvm.internal.impl.utils.b.AbstractC0417b<kotlin.p002reflect.jvm.internal.impl.descriptors.e, u> {
        final /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set<R> f23561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<h, Collection<R>> f23562c;

        /* JADX WARN: Multi-variable type inference failed */
        e(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, Set<R> set, Function1<? super h, ? extends Collection<? extends R>> function1) {
            this.a = eVar;
            this.f23561b = set;
            this.f23562c = function1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return u.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
            m.f(eVar, "current");
            if (eVar == this.a) {
                return true;
            }
            h hVarS = eVar.S();
            m.e(hVarS, "current.staticScope");
            if (!(hVarS instanceof l)) {
                return true;
            }
            this.f23561b.addAll((Collection<? extends R>) ((Collection) this.f23562c.invoke(hVarS)));
            return false;
        }

        public void e() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, g gVar2, f fVar) {
        super(gVar);
        m.f(gVar, "c");
        m.f(gVar2, "jClass");
        m.f(fVar, "ownerDescriptor");
        this.n = gVar2;
        this.o = fVar;
    }

    private final <R> Set<R> N(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, Set<R> set, Function1<? super h, ? extends Collection<? extends R>> function1) {
        kotlin.p002reflect.jvm.internal.impl.utils.b.b(t.e(eVar), d.a, new e(eVar, set, function1));
        return set;
    }

    private final t0 P(t0 t0Var) {
        if (t0Var.i().g()) {
            return t0Var;
        }
        Collection<? extends t0> collectionE = t0Var.e();
        m.e(collectionE, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(v.u(collectionE, 10));
        for (t0 t0Var2 : collectionE) {
            m.e(t0Var2, "it");
            arrayList.add(P(t0Var2));
        }
        return (t0) s.s0(c0.L(arrayList));
    }

    private final Set<y0> Q(f fVar, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        k kVarB = kotlin.reflect.y.internal.j0.d.a.k0.h.b(eVar);
        return kVarB == null ? w0.d() : c0.I0(kVarB.a(fVar, kotlin.reflect.y.internal.j0.c.b.d.WHEN_GET_SUPER_MEMBERS));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.y.internal.j0.d.a.l0.l.a p() {
        return new kotlin.reflect.y.internal.j0.d.a.l0.l.a(this.n, a.f23557f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public f C() {
        return this.o;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public kotlin.p002reflect.jvm.internal.impl.descriptors.h f(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> l(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        return w0.d();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> n(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        Set<f> setH0 = c0.H0(y().invoke().a());
        k kVarB = kotlin.reflect.y.internal.j0.d.a.k0.h.b(C());
        Set<f> setB = kVarB != null ? kVarB.b() : null;
        if (setB == null) {
            setB = w0.d();
        }
        setH0.addAll(setB);
        if (this.n.B()) {
            setH0.addAll(kotlin.collections.u.m(kotlin.reflect.y.internal.j0.b.k.f23194e, kotlin.reflect.y.internal.j0.b.k.f23193d));
        }
        setH0.addAll(w().a().w().a(C()));
        return setH0;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void o(Collection<y0> collection, f fVar) {
        m.f(collection, "result");
        m.f(fVar, "name");
        w().a().w().e(C(), fVar, collection);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void r(Collection<y0> collection, f fVar) {
        m.f(collection, "result");
        m.f(fVar, "name");
        Collection<? extends y0> collectionE = kotlin.reflect.y.internal.j0.d.a.j0.a.e(fVar, Q(fVar, C()), collection, C(), w().a().c(), w().a().k().a());
        m.e(collectionE, "resolveOverridesForStati….overridingUtil\n        )");
        collection.addAll(collectionE);
        if (this.n.B()) {
            if (m.a(fVar, kotlin.reflect.y.internal.j0.b.k.f23194e)) {
                y0 y0VarF = kotlin.reflect.y.internal.j0.i.c.f(C());
                m.e(y0VarF, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(y0VarF);
            } else if (m.a(fVar, kotlin.reflect.y.internal.j0.b.k.f23193d)) {
                y0 y0VarG = kotlin.reflect.y.internal.j0.i.c.g(C());
                m.e(y0VarG, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(y0VarG);
            }
        }
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.l, kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void s(f fVar, Collection<t0> collection) {
        m.f(fVar, "name");
        m.f(collection, "result");
        Set setN = N(C(), new LinkedHashSet(), new b(fVar));
        if (!collection.isEmpty()) {
            Collection<? extends t0> collectionE = kotlin.reflect.y.internal.j0.d.a.j0.a.e(fVar, setN, collection, C(), w().a().c(), w().a().k().a());
            m.e(collectionE, "resolveOverridesForStati…ingUtil\n                )");
            collection.addAll(collectionE);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : setN) {
            t0 t0VarP = P((t0) obj);
            Object arrayList = linkedHashMap.get(t0VarP);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(t0VarP, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Collection collectionE2 = kotlin.reflect.y.internal.j0.d.a.j0.a.e(fVar, (Collection) ((Map.Entry) it.next()).getValue(), collection, C(), w().a().c(), w().a().k().a());
            m.e(collectionE2, "resolveOverridesForStati…ingUtil\n                )");
            z.z(arrayList2, collectionE2);
        }
        collection.addAll(arrayList2);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> t(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        Set<f> setH0 = c0.H0(y().invoke().e());
        N(C(), setH0, c.f23559f);
        return setH0;
    }
}
