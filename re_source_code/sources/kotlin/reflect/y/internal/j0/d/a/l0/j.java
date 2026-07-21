package kotlin.reflect.y.internal.j0.d.a.l0;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.d.a.n0.g;
import kotlin.reflect.y.internal.j0.i.u.c;

/* JADX INFO: compiled from: ModuleClassResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements i {
    public c a;

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.i
    public e a(g gVar) {
        m.f(gVar, "javaClass");
        return b().b(gVar);
    }

    public final c b() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar;
        }
        m.w("resolver");
        return null;
    }

    public final void c(c cVar) {
        m.f(cVar, "<set-?>");
        this.a = cVar;
    }
}
