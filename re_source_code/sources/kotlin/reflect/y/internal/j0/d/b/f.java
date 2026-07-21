package kotlin.reflect.y.internal.j0.d.b;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.c1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j0;
import kotlin.reflect.y.internal.j0.c.b.c;
import kotlin.reflect.y.internal.j0.d.a.d;
import kotlin.reflect.y.internal.j0.d.a.j0.g;
import kotlin.reflect.y.internal.j0.d.a.l0.i;
import kotlin.reflect.y.internal.j0.d.a.p;
import kotlin.reflect.y.internal.j0.d.a.t;
import kotlin.reflect.y.internal.j0.d.a.w;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.j.b.j;
import kotlin.reflect.y.internal.j0.j.b.l;
import kotlin.reflect.y.internal.j0.j.b.r;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.o;

/* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
    public static final class a implements t {
        a() {
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.t
        public List<kotlin.reflect.y.internal.j0.d.a.n0.a> a(b bVar) {
            m.f(bVar, "classId");
            return null;
        }
    }

    public static final e a(g0 g0Var, n nVar, j0 j0Var, kotlin.reflect.y.internal.j0.d.a.l0.f fVar, o oVar, g gVar, r rVar) {
        m.f(g0Var, "module");
        m.f(nVar, "storageManager");
        m.f(j0Var, "notFoundClasses");
        m.f(fVar, "lazyJavaPackageFragmentProvider");
        m.f(oVar, "reflectKotlinClassFinder");
        m.f(gVar, "deserializedDescriptorResolver");
        m.f(rVar, "errorReporter");
        return new e(nVar, g0Var, l.a.a, new h(oVar, gVar), new c(g0Var, j0Var, nVar, oVar), fVar, j0Var, rVar, c.a.a, j.a.a(), kotlin.reflect.y.internal.j0.l.t1.l.f24802b.a(), new kotlin.reflect.y.internal.j0.l.v1.a(kotlin.collections.t.e(o.a)));
    }

    public static final kotlin.reflect.y.internal.j0.d.a.l0.f b(kotlin.reflect.y.internal.j0.d.a.o oVar, g0 g0Var, n nVar, j0 j0Var, o oVar2, g gVar, r rVar, kotlin.reflect.y.internal.j0.d.a.m0.b bVar, i iVar, w wVar) {
        m.f(oVar, "javaClassFinder");
        m.f(g0Var, "module");
        m.f(nVar, "storageManager");
        m.f(j0Var, "notFoundClasses");
        m.f(oVar2, "reflectKotlinClassFinder");
        m.f(gVar, "deserializedDescriptorResolver");
        m.f(rVar, "errorReporter");
        m.f(bVar, "javaSourceElementFactory");
        m.f(iVar, "singleModuleClassResolver");
        m.f(wVar, "packagePartProvider");
        kotlin.reflect.y.internal.j0.d.a.j0.j jVar = kotlin.reflect.y.internal.j0.d.a.j0.j.a;
        m.e(jVar, "DO_NOTHING");
        g gVar2 = g.a;
        m.e(gVar2, "EMPTY");
        kotlin.f0.y.e.j0.d.a.j0.f.a aVar = kotlin.f0.y.e.j0.d.a.j0.f.a.a;
        kotlin.reflect.y.internal.j0.i.v.b bVar2 = new kotlin.reflect.y.internal.j0.i.v.b(nVar, u.j());
        c1.a aVar2 = c1.a.a;
        c.a aVar3 = c.a.a;
        kotlin.reflect.y.internal.j0.b.j jVar2 = new kotlin.reflect.y.internal.j0.b.j(g0Var, j0Var);
        w.b bVar3 = w.a;
        d dVar = new d(bVar3.a());
        kotlin.f0.y.e.j0.d.a.l0.c.b bVar4 = kotlin.f0.y.e.j0.d.a.l0.c.b.f23458b;
        return new kotlin.reflect.y.internal.j0.d.a.l0.f(new kotlin.reflect.y.internal.j0.d.a.l0.b(nVar, oVar, oVar2, gVar, jVar, rVar, gVar2, aVar, bVar2, bVar, iVar, wVar, aVar2, aVar3, g0Var, jVar2, dVar, new kotlin.reflect.y.internal.j0.d.a.o0.l(new kotlin.reflect.y.internal.j0.d.a.o0.d(bVar4)), p.a.a, bVar4, kotlin.reflect.y.internal.j0.l.t1.l.f24802b.a(), bVar3.a(), new a(), null, 8388608, null));
    }
}
