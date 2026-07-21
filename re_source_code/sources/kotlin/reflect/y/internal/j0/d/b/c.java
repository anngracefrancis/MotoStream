package kotlin.reflect.y.internal.j0.d.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.s;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.d;
import kotlin.p002reflect.jvm.internal.impl.descriptors.x;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.i.r.h;
import kotlin.reflect.y.internal.j0.i.r.j;
import kotlin.reflect.y.internal.j0.i.r.k;
import kotlin.reflect.y.internal.j0.i.r.q;
import kotlin.reflect.y.internal.j0.i.r.r;
import kotlin.reflect.y.internal.j0.i.r.u;
import kotlin.reflect.y.internal.j0.i.r.w;
import kotlin.reflect.y.internal.j0.i.r.y;
import kotlin.reflect.y.internal.j0.i.r.z;
import kotlin.reflect.y.internal.j0.j.b.e;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.text.v;

/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends kotlin.reflect.y.internal.j0.d.b.a<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c, g<?>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g0 f23737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j0 f23738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e f23739e;

    /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
    private abstract class a implements q.a {

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.b.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        public static final class C0343a implements q.a {
            private final /* synthetic */ q.a a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ q.a f23740b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f23741c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ f f23742d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArrayList<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> f23743e;

            C0343a(q.a aVar, a aVar2, f fVar, ArrayList<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> arrayList) {
                this.f23740b = aVar;
                this.f23741c = aVar2;
                this.f23742d = fVar;
                this.f23743e = arrayList;
                this.a = aVar;
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.a
            public void a() {
                this.f23740b.a();
                this.f23741c.h(this.f23742d, new kotlin.reflect.y.internal.j0.i.r.a((kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c) s.s0(this.f23743e)));
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.a
            public void b(f fVar, kotlin.reflect.y.internal.j0.i.r.f fVar2) {
                m.f(fVar2, "value");
                this.a.b(fVar, fVar2);
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.a
            public void c(f fVar, Object obj) {
                this.a.c(fVar, obj);
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.a
            public void d(f fVar, kotlin.reflect.y.internal.j0.f.b bVar, f fVar2) {
                m.f(bVar, "enumClassId");
                m.f(fVar2, "enumEntryName");
                this.a.d(fVar, bVar, fVar2);
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.a
            public q.a e(f fVar, kotlin.reflect.y.internal.j0.f.b bVar) {
                m.f(bVar, "classId");
                return this.a.e(fVar, bVar);
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.a
            public q.b f(f fVar) {
                return this.a.f(fVar);
            }
        }

        /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        public static final class b implements q.b {
            private final ArrayList<g<?>> a = new ArrayList<>();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f23744b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ f f23745c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f23746d;

            /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.b.c$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
            public static final class C0344a implements q.a {
                private final /* synthetic */ q.a a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ q.a f23747b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ b f23748c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> f23749d;

                C0344a(q.a aVar, b bVar, ArrayList<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> arrayList) {
                    this.f23747b = aVar;
                    this.f23748c = bVar;
                    this.f23749d = arrayList;
                    this.a = aVar;
                }

                @Override // kotlin.f0.y.e.j0.d.b.q.a
                public void a() {
                    this.f23747b.a();
                    this.f23748c.a.add(new kotlin.reflect.y.internal.j0.i.r.a((kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c) s.s0(this.f23749d)));
                }

                @Override // kotlin.f0.y.e.j0.d.b.q.a
                public void b(f fVar, kotlin.reflect.y.internal.j0.i.r.f fVar2) {
                    m.f(fVar2, "value");
                    this.a.b(fVar, fVar2);
                }

                @Override // kotlin.f0.y.e.j0.d.b.q.a
                public void c(f fVar, Object obj) {
                    this.a.c(fVar, obj);
                }

                @Override // kotlin.f0.y.e.j0.d.b.q.a
                public void d(f fVar, kotlin.reflect.y.internal.j0.f.b bVar, f fVar2) {
                    m.f(bVar, "enumClassId");
                    m.f(fVar2, "enumEntryName");
                    this.a.d(fVar, bVar, fVar2);
                }

                @Override // kotlin.f0.y.e.j0.d.b.q.a
                public q.a e(f fVar, kotlin.reflect.y.internal.j0.f.b bVar) {
                    m.f(bVar, "classId");
                    return this.a.e(fVar, bVar);
                }

                @Override // kotlin.f0.y.e.j0.d.b.q.a
                public q.b f(f fVar) {
                    return this.a.f(fVar);
                }
            }

            b(c cVar, f fVar, a aVar) {
                this.f23744b = cVar;
                this.f23745c = fVar;
                this.f23746d = aVar;
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.b
            public void a() {
                this.f23746d.g(this.f23745c, this.a);
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.b
            public void b(Object obj) {
                this.a.add(this.f23744b.K(this.f23745c, obj));
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.b
            public void c(kotlin.reflect.y.internal.j0.f.b bVar, f fVar) {
                m.f(bVar, "enumClassId");
                m.f(fVar, "enumEntryName");
                this.a.add(new j(bVar, fVar));
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.b
            public q.a d(kotlin.reflect.y.internal.j0.f.b bVar) {
                m.f(bVar, "classId");
                ArrayList arrayList = new ArrayList();
                c cVar = this.f23744b;
                z0 z0Var = z0.a;
                m.e(z0Var, "NO_SOURCE");
                q.a aVarX = cVar.x(bVar, z0Var, arrayList);
                m.c(aVarX);
                return new C0344a(aVarX, this, arrayList);
            }

            @Override // kotlin.f0.y.e.j0.d.b.q.b
            public void e(kotlin.reflect.y.internal.j0.i.r.f fVar) {
                m.f(fVar, "value");
                this.a.add(new q(fVar));
            }
        }

        public a() {
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.a
        public void b(f fVar, kotlin.reflect.y.internal.j0.i.r.f fVar2) {
            m.f(fVar2, "value");
            h(fVar, new q(fVar2));
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.a
        public void c(f fVar, Object obj) {
            h(fVar, c.this.K(fVar, obj));
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.a
        public void d(f fVar, kotlin.reflect.y.internal.j0.f.b bVar, f fVar2) {
            m.f(bVar, "enumClassId");
            m.f(fVar2, "enumEntryName");
            h(fVar, new j(bVar, fVar2));
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.a
        public q.a e(f fVar, kotlin.reflect.y.internal.j0.f.b bVar) {
            m.f(bVar, "classId");
            ArrayList arrayList = new ArrayList();
            c cVar = c.this;
            z0 z0Var = z0.a;
            m.e(z0Var, "NO_SOURCE");
            q.a aVarX = cVar.x(bVar, z0Var, arrayList);
            m.c(aVarX);
            return new C0343a(aVarX, this, fVar, arrayList);
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.a
        public q.b f(f fVar) {
            return new b(c.this, fVar, this);
        }

        public abstract void g(f fVar, ArrayList<g<?>> arrayList);

        public abstract void h(f fVar, g<?> gVar);
    }

    /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HashMap<f, g<?>> f23750b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.e f23752d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.f.b f23753e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> f23754f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ z0 f23755g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.y.internal.j0.f.b bVar, List<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> list, z0 z0Var) {
            super();
            this.f23752d = eVar;
            this.f23753e = bVar;
            this.f23754f = list;
            this.f23755g = z0Var;
            this.f23750b = new HashMap<>();
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.a
        public void a() {
            if (c.this.E(this.f23753e, this.f23750b) || c.this.w(this.f23753e)) {
                return;
            }
            this.f23754f.add(new d(this.f23752d.s(), this.f23750b, this.f23755g));
        }

        @Override // kotlin.f0.y.e.j0.d.b.c.a
        public void g(f fVar, ArrayList<g<?>> arrayList) {
            m.f(arrayList, "elements");
            if (fVar == null) {
                return;
            }
            i1 i1VarB = kotlin.reflect.y.internal.j0.d.a.j0.a.b(fVar, this.f23752d);
            if (i1VarB != null) {
                HashMap<f, g<?>> map = this.f23750b;
                h hVar = h.a;
                List<? extends g<?>> listC = kotlin.p002reflect.jvm.internal.impl.utils.a.c(arrayList);
                e0 type = i1VarB.getType();
                m.e(type, "parameter.type");
                map.put(fVar, hVar.b(listC, type));
                return;
            }
            if (c.this.w(this.f23753e) && m.a(fVar.k(), "value")) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (obj instanceof kotlin.reflect.y.internal.j0.i.r.a) {
                        arrayList2.add(obj);
                    }
                }
                List<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> list = this.f23754f;
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    list.add(((kotlin.reflect.y.internal.j0.i.r.a) it.next()).b());
                }
            }
        }

        @Override // kotlin.f0.y.e.j0.d.b.c.a
        public void h(f fVar, g<?> gVar) {
            m.f(gVar, "value");
            if (fVar != null) {
                this.f23750b.put(fVar, gVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g0 g0Var, j0 j0Var, n nVar, o oVar) {
        super(nVar, oVar);
        m.f(g0Var, "module");
        m.f(j0Var, "notFoundClasses");
        m.f(nVar, "storageManager");
        m.f(oVar, "kotlinClassFinder");
        this.f23737c = g0Var;
        this.f23738d = j0Var;
        this.f23739e = new e(g0Var, j0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g<?> K(f fVar, Object obj) {
        g<?> gVarC = h.a.c(obj);
        if (gVarC != null) {
            return gVarC;
        }
        return k.f24364b.a("Unsupported annotation argument: " + fVar);
    }

    private final kotlin.p002reflect.jvm.internal.impl.descriptors.e N(kotlin.reflect.y.internal.j0.f.b bVar) {
        return x.c(this.f23737c, bVar, this.f23738d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.b.a
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public g<?> G(String str, Object obj) {
        m.f(str, "desc");
        m.f(obj, "initializer");
        if (v.J("ZBCS", str, false, 2, null)) {
            int iIntValue = ((Integer) obj).intValue();
            int iHashCode = str.hashCode();
            if (iHashCode == 66) {
                if (str.equals("B")) {
                    obj = Byte.valueOf((byte) iIntValue);
                }
                throw new AssertionError(str);
            }
            if (iHashCode == 67) {
                if (str.equals("C")) {
                    obj = Character.valueOf((char) iIntValue);
                }
                throw new AssertionError(str);
            }
            if (iHashCode == 83) {
                if (str.equals("S")) {
                    obj = Short.valueOf((short) iIntValue);
                }
                throw new AssertionError(str);
            }
            if (iHashCode == 90 && str.equals("Z")) {
                obj = Boolean.valueOf(iIntValue != 0);
            }
            throw new AssertionError(str);
        }
        return h.a.c(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.b.b
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c A(kotlin.reflect.y.internal.j0.e.b bVar, kotlin.reflect.y.internal.j0.e.z.c cVar) {
        m.f(bVar, "proto");
        m.f(cVar, "nameResolver");
        return this.f23739e.a(bVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.b.a
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public g<?> I(g<?> gVar) {
        g<?> yVar;
        m.f(gVar, "constant");
        if (gVar instanceof kotlin.reflect.y.internal.j0.i.r.d) {
            yVar = new w(((kotlin.reflect.y.internal.j0.i.r.d) gVar).b().byteValue());
        } else if (gVar instanceof u) {
            yVar = new z(((u) gVar).b().shortValue());
        } else if (gVar instanceof kotlin.reflect.y.internal.j0.i.r.m) {
            yVar = new kotlin.reflect.y.internal.j0.i.r.x(((kotlin.reflect.y.internal.j0.i.r.m) gVar).b().intValue());
        } else {
            if (!(gVar instanceof r)) {
                return gVar;
            }
            yVar = new y(((r) gVar).b().longValue());
        }
        return yVar;
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.b
    protected q.a x(kotlin.reflect.y.internal.j0.f.b bVar, z0 z0Var, List<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> list) {
        m.f(bVar, "annotationClassId");
        m.f(z0Var, "source");
        m.f(list, "result");
        return new b(N(bVar), bVar, list, z0Var);
    }
}
