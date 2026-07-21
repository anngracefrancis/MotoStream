package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.a;
import kotlin.reflect.y.internal.j0.d.a.n0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.u;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ReflectJavaPackage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w extends p implements u {
    private final c a;

    public w(c cVar) {
        m.f(cVar, "fqName");
        this.a = cVar;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.u
    public Collection<u> A() {
        return kotlin.collections.u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public List<a> getAnnotations() {
        return kotlin.collections.u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.u
    public c d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && m.a(d(), ((w) obj).d());
    }

    public int hashCode() {
        return d().hashCode();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public a l(c cVar) {
        m.f(cVar, "fqName");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.u
    public Collection<g> q(Function1<? super f, Boolean> function1) {
        m.f(function1, "nameFilter");
        return kotlin.collections.u.j();
    }

    public String toString() {
        return w.class.getName() + ": " + d();
    }
}
