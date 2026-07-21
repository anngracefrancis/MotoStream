package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.Iterator;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
final class c implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.f.c f23609f;

    public c(kotlin.reflect.y.internal.j0.f.c cVar) {
        m.f(cVar, "fqNameToMatch");
        this.f23609f = cVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public boolean R0(kotlin.reflect.y.internal.j0.f.c cVar) {
        return g.b.b(this, cVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public b l(kotlin.reflect.y.internal.j0.f.c cVar) {
        m.f(cVar, "fqName");
        if (m.a(cVar, this.f23609f)) {
            return b.a;
        }
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> iterator() {
        return u.j().iterator();
    }
}
