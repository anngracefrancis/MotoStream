package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.d.a.n0.d0;
import kotlin.reflect.y.internal.j0.d.a.n0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.u;
import kotlin.reflect.y.internal.j0.d.b.o;
import kotlin.reflect.y.internal.j0.d.b.p;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.h;
import kotlin.reflect.y.internal.j0.k.j;

/* JADX INFO: compiled from: LazyJavaPackageScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends l {
    private final u n;
    private final h o;
    private final j<Set<String>> p;
    private final h<a, e> q;

    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    private static final class a {
        private final f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f23520b;

        public a(f fVar, g gVar) {
            m.f(fVar, "name");
            this.a = fVar;
            this.f23520b = gVar;
        }

        public final g a() {
            return this.f23520b;
        }

        public final f b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && m.a(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    private static abstract class b {

        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class a extends b {
            private final e a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar) {
                super(null);
                m.f(eVar, "descriptor");
                this.a = eVar;
            }

            public final e a() {
                return this.a;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.a.l0.l.i$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class C0334b extends b {
            public static final C0334b a = new C0334b();

            private C0334b() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class c extends b {
            public static final c a = new c();

            private c() {
                super(null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    static final class c extends Lambda implements Function1<a, e> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.g f23522g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
            super(1);
            this.f23522g = gVar;
        }

        /* JADX WARN: Code duplicated, block: B:37:0x00a2  */
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e invoke(a aVar) {
            byte[] bArrB;
            m.f(aVar, "request");
            kotlin.reflect.y.internal.j0.f.b bVar = new kotlin.reflect.y.internal.j0.f.b(i.this.C().d(), aVar.b());
            o.a aVarA = aVar.a() != null ? this.f23522g.a().j().a(aVar.a()) : this.f23522g.a().j().c(bVar);
            q qVarA = aVarA != null ? aVarA.a() : null;
            kotlin.reflect.y.internal.j0.f.b bVarE = qVarA != null ? qVarA.e() : null;
            if (bVarE != null && (bVarE.l() || bVarE.k())) {
                return null;
            }
            b bVarR = i.this.R(qVarA);
            if (bVarR instanceof b.a) {
                return ((b.a) bVarR).a();
            }
            if (bVarR instanceof b.c) {
                return null;
            }
            if (!(bVarR instanceof b.C0334b)) {
                throw new NoWhenBranchMatchedException();
            }
            g gVarA = aVar.a();
            if (gVarA == null) {
                kotlin.reflect.y.internal.j0.d.a.o oVarD = this.f23522g.a().d();
                if (aVarA == null) {
                    bArrB = null;
                } else {
                    if (!(aVarA instanceof o.a.C0351a)) {
                        aVarA = null;
                    }
                    o.a.C0351a c0351a = (o.a.C0351a) aVarA;
                    if (c0351a != null) {
                        bArrB = c0351a.b();
                    } else {
                        bArrB = null;
                    }
                }
                gVarA = oVarD.a(new kotlin.f0.y.e.j0.d.a.o.b(bVar, bArrB, null, 4, null));
            }
            g gVar = gVarA;
            if ((gVar != null ? gVar.I() : null) != d0.BINARY) {
                kotlin.reflect.y.internal.j0.f.c cVarD = gVar != null ? gVar.d() : null;
                if (cVarD == null || cVarD.d() || !m.a(cVarD.e(), i.this.C().d())) {
                    return null;
                }
                f fVar = new f(this.f23522g, i.this.C(), gVar, null, 8, null);
                this.f23522g.a().e().a(fVar);
                return fVar;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + bVar + "\nfindKotlinClass(JavaClass) = " + p.a(this.f23522g.a().j(), gVar) + "\nfindKotlinClass(ClassId) = " + p.b(this.f23522g.a().j(), bVar) + '\n');
        }
    }

    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    static final class d extends Lambda implements Function0<Set<? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.g f23523f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i f23524g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, i iVar) {
            super(0);
            this.f23523f = gVar;
            this.f23524g = iVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Set<String> invoke() {
            return this.f23523f.a().d().b(this.f23524g.C().d());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, u uVar, h hVar) {
        super(gVar);
        m.f(gVar, "c");
        m.f(uVar, "jPackage");
        m.f(hVar, "ownerDescriptor");
        this.n = uVar;
        this.o = hVar;
        this.p = gVar.e().f(new d(gVar, this));
        this.q = gVar.e().i(new c(gVar));
    }

    private final e N(f fVar, g gVar) {
        if (!kotlin.reflect.y.internal.j0.f.h.a.a(fVar)) {
            return null;
        }
        Set<String> setInvoke = this.p.invoke();
        if (gVar != null || setInvoke == null || setInvoke.contains(fVar.k())) {
            return this.q.invoke(new a(fVar, gVar));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b R(q qVar) {
        if (qVar == null) {
            return b.C0334b.a;
        }
        if (qVar.a().c() != kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.CLASS) {
            return b.c.a;
        }
        e eVarK = w().a().b().k(qVar);
        return eVarK != null ? new b.a(eVarK) : b.C0334b.a;
    }

    public final e O(g gVar) {
        m.f(gVar, "javaClass");
        return N(gVar.getName(), gVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public e f(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return N(fVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public h C() {
        return this.o;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j, kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return kotlin.collections.u.j();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x005d  */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j, kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        boolean z;
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        kotlin.f0.y.e.j0.i.w.d.a aVar = kotlin.reflect.y.internal.j0.i.w.d.a;
        if (!dVar.a(aVar.e() | aVar.c())) {
            return kotlin.collections.u.j();
        }
        Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> collectionInvoke = v().invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionInvoke) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar = (kotlin.p002reflect.jvm.internal.impl.descriptors.m) obj;
            if (mVar instanceof e) {
                f name = ((e) mVar).getName();
                m.e(name, "it.name");
                if (function1.invoke(name).booleanValue()) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> l(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        if (!dVar.a(kotlin.reflect.y.internal.j0.i.w.d.a.e())) {
            return w0.d();
        }
        Set<String> setInvoke = this.p.invoke();
        if (setInvoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = setInvoke.iterator();
            while (it.hasNext()) {
                hashSet.add(f.x((String) it.next()));
            }
            return hashSet;
        }
        u uVar = this.n;
        if (function1 == null) {
            function1 = kotlin.p002reflect.jvm.internal.impl.utils.d.a();
        }
        Collection<g> collectionQ = uVar.q(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (g gVar : collectionQ) {
            f name = gVar.I() == d0.SOURCE ? null : gVar.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> n(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        return w0.d();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected kotlin.reflect.y.internal.j0.d.a.l0.l.b p() {
        return kotlin.f0.y.e.j0.d.a.l0.l.b.a.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void r(Collection<y0> collection, f fVar) {
        m.f(collection, "result");
        m.f(fVar, "name");
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> t(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        return w0.d();
    }
}
