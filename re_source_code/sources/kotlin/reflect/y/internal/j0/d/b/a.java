package kotlin.reflect.y.internal.j0.d.b;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.b.o;
import kotlin.reflect.y.internal.j0.e.a0.b.i;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.q;
import kotlin.reflect.y.internal.j0.j.b.z;
import kotlin.reflect.y.internal.j0.k.g;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<A, C> extends kotlin.reflect.y.internal.j0.d.b.b<A, C0340a<? extends A, ? extends C>> implements kotlin.reflect.y.internal.j0.j.b.c<A, C> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<q, C0340a<A, C>> f23709b;

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class C0340a<A, C> extends kotlin.f0.y.e.j0.d.b.b.a<A> {
        private final Map<t, List<A>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<t, C> f23710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<t, C> f23711c;

        /* JADX WARN: Multi-variable type inference failed */
        public C0340a(Map<t, ? extends List<? extends A>> map, Map<t, ? extends C> map2, Map<t, ? extends C> map3) {
            m.f(map, "memberAnnotations");
            m.f(map2, "propertyConstants");
            m.f(map3, "annotationParametersDefaultValues");
            this.a = map;
            this.f23710b = map2;
            this.f23711c = map3;
        }

        @Override // kotlin.f0.y.e.j0.d.b.b.a
        public Map<t, List<A>> a() {
            return this.a;
        }

        public final Map<t, C> b() {
            return this.f23711c;
        }

        public final Map<t, C> c() {
            return this.f23710b;
        }
    }

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    static final class b extends Lambda implements Function2<C0340a<? extends A, ? extends C>, t, C> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f23712f = new b();

        b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final C invoke(C0340a<? extends A, ? extends C> c0340a, t tVar) {
            m.f(c0340a, "$this$loadConstantFromProperty");
            m.f(tVar, "it");
            return c0340a.b().get(tVar);
        }
    }

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class c implements q.d {
        final /* synthetic */ a<A, C> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<t, List<A>> f23713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ q f23714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap<t, C> f23715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashMap<t, C> f23716e;

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.b.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
        public final class C0341a extends b implements q.e {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f23717d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0341a(c cVar, t tVar) {
                super(cVar, tVar);
                m.f(tVar, RoomInstalled.SIGNATURE);
                this.f23717d = cVar;
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.e
            public q.a c(int i2, kotlin.reflect.y.internal.j0.f.b bVar, z0 z0Var) {
                m.f(bVar, "classId");
                m.f(z0Var, "source");
                t tVarE = t.a.e(d(), i2);
                List<A> arrayList = this.f23717d.f23713b.get(tVarE);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f23717d.f23713b.put(tVarE, arrayList);
                }
                return this.f23717d.a.y(bVar, z0Var, arrayList);
            }
        }

        /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
        public class b implements q.c {
            private final t a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ArrayList<A> f23718b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f23719c;

            public b(c cVar, t tVar) {
                m.f(tVar, RoomInstalled.SIGNATURE);
                this.f23719c = cVar;
                this.a = tVar;
                this.f23718b = new ArrayList<>();
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.c
            public void a() {
                if (!this.f23718b.isEmpty()) {
                    this.f23719c.f23713b.put(this.a, this.f23718b);
                }
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.c
            public q.a b(kotlin.reflect.y.internal.j0.f.b bVar, z0 z0Var) {
                m.f(bVar, "classId");
                m.f(z0Var, "source");
                return this.f23719c.a.y(bVar, z0Var, this.f23718b);
            }

            protected final t d() {
                return this.a;
            }
        }

        c(a<A, C> aVar, HashMap<t, List<A>> map, q qVar, HashMap<t, C> map2, HashMap<t, C> map3) {
            this.a = aVar;
            this.f23713b = map;
            this.f23714c = qVar;
            this.f23715d = map2;
            this.f23716e = map3;
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.d
        public q.c a(f fVar, String str, Object obj) {
            C cG;
            m.f(fVar, "name");
            m.f(str, "desc");
            t.a aVar = t.a;
            String strK = fVar.k();
            m.e(strK, "name.asString()");
            t tVarA = aVar.a(strK, str);
            if (obj != null && (cG = this.a.G(str, obj)) != null) {
                this.f23716e.put(tVarA, cG);
            }
            return new b(this, tVarA);
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.d
        public q.e b(f fVar, String str) {
            m.f(fVar, "name");
            m.f(str, "desc");
            t.a aVar = t.a;
            String strK = fVar.k();
            m.e(strK, "name.asString()");
            return new C0341a(this, aVar.d(strK, str));
        }
    }

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    static final class d extends Lambda implements Function2<C0340a<? extends A, ? extends C>, t, C> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f23720f = new d();

        d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final C invoke(C0340a<? extends A, ? extends C> c0340a, t tVar) {
            m.f(c0340a, "$this$loadConstantFromProperty");
            m.f(tVar, "it");
            return c0340a.c().get(tVar);
        }
    }

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    static final class e extends Lambda implements Function1<q, C0340a<? extends A, ? extends C>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<A, C> f23721f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(a<A, C> aVar) {
            super(1);
            this.f23721f = aVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final C0340a<A, C> invoke(q qVar) {
            m.f(qVar, "kotlinClass");
            return this.f23721f.F(qVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(n nVar, o oVar) {
        super(oVar);
        m.f(nVar, "storageManager");
        m.f(oVar, "kotlinClassFinder");
        this.f23709b = nVar.h(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C0340a<A, C> F(q qVar) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        qVar.c(new c(this, map, qVar, map3, map2), q(qVar));
        return new C0340a<>(map, map2, map3);
    }

    private final C H(z zVar, kotlin.reflect.y.internal.j0.e.n nVar, kotlin.reflect.y.internal.j0.j.b.b bVar, e0 e0Var, Function2<? super C0340a<? extends A, ? extends C>, ? super t, ? extends C> function2) {
        C cInvoke;
        q qVarO = o(zVar, v(zVar, true, true, kotlin.reflect.y.internal.j0.e.z.b.A.d(nVar.b0()), i.f(nVar)));
        if (qVarO == null) {
            return null;
        }
        t tVarR = r(nVar, zVar.b(), zVar.d(), bVar, qVarO.a().d().d(g.a.a()));
        if (tVarR == null || (cInvoke = function2.invoke(this.f23709b.invoke(qVarO), tVarR)) == null) {
            return null;
        }
        return o.d(e0Var) ? I(cInvoke) : cInvoke;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.b.b
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public C0340a<A, C> p(q qVar) {
        m.f(qVar, "binaryClass");
        return this.f23709b.invoke(qVar);
    }

    protected final boolean E(kotlin.reflect.y.internal.j0.f.b bVar, Map<f, ? extends kotlin.reflect.y.internal.j0.i.r.g<?>> map) {
        m.f(bVar, "annotationClassId");
        m.f(map, "arguments");
        if (!m.a(bVar, kotlin.reflect.y.internal.j0.a.a.a())) {
            return false;
        }
        kotlin.reflect.y.internal.j0.i.r.g<?> gVar = map.get(f.x("value"));
        q qVar = gVar instanceof q ? (q) gVar : null;
        if (qVar == null) {
            return false;
        }
        q.b bVarB = qVar.b();
        q.b.C0379b c0379b = bVarB instanceof q.b.C0379b ? (q.b.C0379b) bVarB : null;
        if (c0379b == null) {
            return false;
        }
        return w(c0379b.b());
    }

    protected abstract C G(String str, Object obj);

    protected abstract C I(C c2);

    @Override // kotlin.reflect.y.internal.j0.j.b.c
    public C e(z zVar, kotlin.reflect.y.internal.j0.e.n nVar, e0 e0Var) {
        m.f(zVar, "container");
        m.f(nVar, "proto");
        m.f(e0Var, "expectedType");
        return H(zVar, nVar, kotlin.reflect.y.internal.j0.j.b.b.PROPERTY, e0Var, d.f23720f);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.c
    public C k(z zVar, kotlin.reflect.y.internal.j0.e.n nVar, e0 e0Var) {
        m.f(zVar, "container");
        m.f(nVar, "proto");
        m.f(e0Var, "expectedType");
        return H(zVar, nVar, kotlin.reflect.y.internal.j0.j.b.b.PROPERTY_GETTER, e0Var, b.f23712f);
    }
}
