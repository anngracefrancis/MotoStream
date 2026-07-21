package kotlin.reflect.y.internal.j0.l;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.c0;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.c1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.t1.h;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.u;

/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i<b> f24730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f24731c;

    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    private final class a implements e1 {
        private final kotlin.reflect.y.internal.j0.l.t1.g a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Lazy f24732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f24733c;

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.l.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
        static final class C0396a extends Lambda implements Function0<List<? extends e0>> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ g f24735g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0396a(g gVar) {
                super(0);
                this.f24735g = gVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends e0> invoke() {
                return h.b(a.this.a, this.f24735g.a());
            }
        }

        public a(g gVar, kotlin.reflect.y.internal.j0.l.t1.g gVar2) {
            m.f(gVar2, "kotlinTypeRefiner");
            this.f24733c = gVar;
            this.a = gVar2;
            this.f24732b = kotlin.i.a(LazyThreadSafetyMode.PUBLICATION, new C0396a(gVar));
        }

        private final List<e0> h() {
            return (List) this.f24732b.getValue();
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public e1 b(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
            m.f(gVar, "kotlinTypeRefiner");
            return this.f24733c.b(gVar);
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        /* JADX INFO: renamed from: c */
        public kotlin.p002reflect.jvm.internal.impl.descriptors.h w() {
            return this.f24733c.w();
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public boolean e() {
            return this.f24733c.e();
        }

        public boolean equals(Object obj) {
            return this.f24733c.equals(obj);
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public List<e1> getParameters() {
            List<e1> parameters = this.f24733c.getParameters();
            m.e(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return this.f24733c.hashCode();
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public List<e0> a() {
            return h();
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public kotlin.reflect.y.internal.j0.b.h o() {
            kotlin.reflect.y.internal.j0.b.h hVarO = this.f24733c.o();
            m.e(hVarO, "this@AbstractTypeConstructor.builtIns");
            return hVarO;
        }

        public String toString() {
            return this.f24733c.toString();
        }
    }

    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    private static final class b {
        private final Collection<e0> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<? extends e0> f24736b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Collection<? extends e0> collection) {
            m.f(collection, "allSupertypes");
            this.a = collection;
            this.f24736b = t.e(k.a.l());
        }

        public final Collection<e0> a() {
            return this.a;
        }

        public final List<e0> b() {
            return this.f24736b;
        }

        public final void c(List<? extends e0> list) {
            m.f(list, "<set-?>");
            this.f24736b = list;
        }
    }

    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    static final class c extends Lambda implements Function0<b> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b(g.this.l());
        }
    }

    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    static final class d extends Lambda implements Function1<Boolean, b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f24738f = new d();

        d() {
            super(1);
        }

        public final b b(boolean z) {
            return new b(t.e(k.a.l()));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ b invoke(Boolean bool) {
            return b(bool.booleanValue());
        }
    }

    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    static final class e extends Lambda implements Function1<b, u> {

        /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
        static final class a extends Lambda implements Function1<e1, Iterable<? extends e0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f24740f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(1);
                this.f24740f = gVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterable<e0> invoke(e1 e1Var) {
                m.f(e1Var, "it");
                return this.f24740f.k(e1Var, true);
            }
        }

        /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
        static final class b extends Lambda implements Function1<e0, u> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f24741f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(g gVar) {
                super(1);
                this.f24741f = gVar;
            }

            public final void b(e0 e0Var) {
                m.f(e0Var, "it");
                this.f24741f.t(e0Var);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ u invoke(e0 e0Var) {
                b(e0Var);
                return u.a;
            }
        }

        /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
        static final class c extends Lambda implements Function1<e1, Iterable<? extends e0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f24742f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(g gVar) {
                super(1);
                this.f24742f = gVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterable<e0> invoke(e1 e1Var) {
                m.f(e1Var, "it");
                return this.f24742f.k(e1Var, false);
            }
        }

        /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
        static final class d extends Lambda implements Function1<e0, u> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f24743f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(g gVar) {
                super(1);
                this.f24743f = gVar;
            }

            public final void b(e0 e0Var) {
                m.f(e0Var, "it");
                this.f24743f.u(e0Var);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ u invoke(e0 e0Var) {
                b(e0Var);
                return u.a;
            }
        }

        e() {
            super(1);
        }

        public final void b(b bVar) {
            m.f(bVar, "supertypes");
            Collection<e0> collectionA = g.this.q().a(g.this, bVar.a(), new c(g.this), new d(g.this));
            if (collectionA.isEmpty()) {
                e0 e0VarM = g.this.m();
                collectionA = e0VarM != null ? t.e(e0VarM) : null;
                if (collectionA == null) {
                    collectionA = kotlin.collections.u.j();
                }
            }
            if (g.this.p()) {
                c1 c1VarQ = g.this.q();
                g gVar = g.this;
                c1VarQ.a(gVar, collectionA, new a(gVar), new b(g.this));
            }
            g gVar2 = g.this;
            List<e0> listE0 = collectionA instanceof List ? (List) collectionA : null;
            if (listE0 == null) {
                listE0 = c0.E0(collectionA);
            }
            bVar.c(gVar2.s(listE0));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(b bVar) {
            b(bVar);
            return u.a;
        }
    }

    public g(n nVar) {
        m.f(nVar, "storageManager");
        this.f24730b = nVar.g(new c(), d.f24738f, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<e0> k(e1 e1Var, boolean z) {
        List listO0;
        g gVar = e1Var instanceof g ? (g) e1Var : null;
        if (gVar != null && (listO0 = c0.o0(gVar.f24730b.invoke().a(), gVar.n(z))) != null) {
            return listO0;
        }
        Collection<e0> collectionA = e1Var.a();
        m.e(collectionA, "supertypes");
        return collectionA;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public e1 b(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return new a(this, gVar);
    }

    protected abstract Collection<e0> l();

    protected e0 m() {
        return null;
    }

    protected Collection<e0> n(boolean z) {
        return kotlin.collections.u.j();
    }

    protected boolean p() {
        return this.f24731c;
    }

    protected abstract c1 q();

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public List<e0> a() {
        return this.f24730b.invoke().b();
    }

    protected List<e0> s(List<e0> list) {
        m.f(list, "supertypes");
        return list;
    }

    protected void t(e0 e0Var) {
        m.f(e0Var, "type");
    }

    protected void u(e0 e0Var) {
        m.f(e0Var, "type");
    }
}
