package kotlin.reflect.y.internal.j0.i.u;

import kotlin.collections.s;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.c.b.d;
import kotlin.reflect.y.internal.j0.d.a.j0.g;
import kotlin.reflect.y.internal.j0.d.a.l0.f;
import kotlin.reflect.y.internal.j0.d.a.n0.d0;
import kotlin.reflect.y.internal.j0.i.w.h;

/* JADX INFO: compiled from: JavaDescriptorResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f24387b;

    public c(f fVar, g gVar) {
        m.f(fVar, "packageFragmentProvider");
        m.f(gVar, "javaResolverCache");
        this.a = fVar;
        this.f24387b = gVar;
    }

    public final f a() {
        return this.a;
    }

    public final e b(kotlin.reflect.y.internal.j0.d.a.n0.g gVar) {
        m.f(gVar, "javaClass");
        kotlin.reflect.y.internal.j0.f.c cVarD = gVar.d();
        if (cVarD != null && gVar.I() == d0.SOURCE) {
            return this.f24387b.a(cVarD);
        }
        kotlin.reflect.y.internal.j0.d.a.n0.g gVarI = gVar.i();
        if (gVarI != null) {
            e eVarB = b(gVarI);
            h hVarY0 = eVarB != null ? eVarB.y0() : null;
            kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarF = hVarY0 != null ? hVarY0.f(gVar.getName(), d.FROM_JAVA_LOADER) : null;
            if (hVarF instanceof e) {
                return (e) hVarF;
            }
            return null;
        }
        if (cVarD == null) {
            return null;
        }
        f fVar = this.a;
        kotlin.reflect.y.internal.j0.f.c cVarE = cVarD.e();
        m.e(cVarE, "fqName.parent()");
        kotlin.reflect.y.internal.j0.d.a.l0.l.h hVar = (kotlin.reflect.y.internal.j0.d.a.l0.l.h) s.W(fVar.a(cVarE));
        if (hVar != null) {
            return hVar.M0(gVar);
        }
        return null;
    }
}
