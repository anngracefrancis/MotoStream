package kotlin.reflect.y.internal.j0.j.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.p002reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.y.internal.j0.e.b;
import kotlin.reflect.y.internal.j0.e.i;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.e.z.e;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: AnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements c<c, g<?>> {
    private final kotlin.reflect.y.internal.j0.j.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f24474b;

    /* JADX INFO: compiled from: AnnotationAndConstantLoaderImpl.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            iArr[b.PROPERTY.ordinal()] = 1;
            iArr[b.PROPERTY_GETTER.ordinal()] = 2;
            iArr[b.PROPERTY_SETTER.ordinal()] = 3;
            a = iArr;
        }
    }

    public d(g0 g0Var, j0 j0Var, kotlin.reflect.y.internal.j0.j.a aVar) {
        m.f(g0Var, "module");
        m.f(j0Var, "notFoundClasses");
        m.f(aVar, "protocol");
        this.a = aVar;
        this.f24474b = new e(g0Var, j0Var);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<c> a(s sVar, kotlin.reflect.y.internal.j0.e.z.c cVar) {
        m.f(sVar, "proto");
        m.f(cVar, "nameResolver");
        List listJ = (List) sVar.u(this.a.l());
        if (listJ == null) {
            listJ = u.j();
        }
        ArrayList arrayList = new ArrayList(v.u(listJ, 10));
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24474b.a((b) it.next(), cVar));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<c> b(z zVar, o oVar, b bVar, int i2, kotlin.reflect.y.internal.j0.e.u uVar) {
        m.f(zVar, "container");
        m.f(oVar, "callableProto");
        m.f(bVar, "kind");
        m.f(uVar, "proto");
        List listJ = (List) uVar.u(this.a.g());
        if (listJ == null) {
            listJ = u.j();
        }
        ArrayList arrayList = new ArrayList(v.u(listJ, 10));
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24474b.a((b) it.next(), zVar.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<c> c(z.a aVar) {
        m.f(aVar, "container");
        List listJ = (List) aVar.f().u(this.a.a());
        if (listJ == null) {
            listJ = u.j();
        }
        ArrayList arrayList = new ArrayList(v.u(listJ, 10));
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24474b.a((b) it.next(), aVar.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<c> d(q qVar, kotlin.reflect.y.internal.j0.e.z.c cVar) {
        m.f(qVar, "proto");
        m.f(cVar, "nameResolver");
        List listJ = (List) qVar.u(this.a.k());
        if (listJ == null) {
            listJ = u.j();
        }
        ArrayList arrayList = new ArrayList(v.u(listJ, 10));
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24474b.a((b) it.next(), cVar));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<c> f(z zVar, kotlin.reflect.y.internal.j0.e.g gVar) {
        m.f(zVar, "container");
        m.f(gVar, "proto");
        List listJ = (List) gVar.u(this.a.d());
        if (listJ == null) {
            listJ = u.j();
        }
        ArrayList arrayList = new ArrayList(v.u(listJ, 10));
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24474b.a((b) it.next(), zVar.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<c> g(z zVar, n nVar) {
        m.f(zVar, "container");
        m.f(nVar, "proto");
        return u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<c> h(z zVar, o oVar, b bVar) {
        m.f(zVar, "container");
        m.f(oVar, "proto");
        m.f(bVar, "kind");
        return u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<c> i(z zVar, n nVar) {
        m.f(zVar, "container");
        m.f(nVar, "proto");
        return u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<c> j(z zVar, o oVar, b bVar) {
        List listJ;
        m.f(zVar, "container");
        m.f(oVar, "proto");
        m.f(bVar, "kind");
        if (oVar instanceof kotlin.reflect.y.internal.j0.e.d) {
            listJ = (List) ((kotlin.reflect.y.internal.j0.e.d) oVar).u(this.a.c());
        } else if (oVar instanceof i) {
            listJ = (List) ((i) oVar).u(this.a.f());
        } else {
            if (!(oVar instanceof n)) {
                throw new IllegalStateException(("Unknown message: " + oVar).toString());
            }
            int i2 = a.a[bVar.ordinal()];
            if (i2 == 1) {
                listJ = (List) ((n) oVar).u(this.a.h());
            } else if (i2 == 2) {
                listJ = (List) ((n) oVar).u(this.a.i());
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto".toString());
                }
                listJ = (List) ((n) oVar).u(this.a.j());
            }
        }
        if (listJ == null) {
            listJ = u.j();
        }
        ArrayList arrayList = new ArrayList(v.u(listJ, 10));
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24474b.a((b) it.next(), zVar.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.c
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public g<?> k(z zVar, n nVar, e0 e0Var) {
        m.f(zVar, "container");
        m.f(nVar, "proto");
        m.f(e0Var, "expectedType");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.c
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public g<?> e(z zVar, n nVar, e0 e0Var) {
        m.f(zVar, "container");
        m.f(nVar, "proto");
        m.f(e0Var, "expectedType");
        b.C0361b.c cVar = (b.C0361b.c) e.a(nVar, this.a.b());
        if (cVar == null) {
            return null;
        }
        return this.f24474b.f(e0Var, cVar, zVar.b());
    }
}
