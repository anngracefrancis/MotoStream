package kotlin.reflect.y.internal.j0.i.w;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: AbstractScopeAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements h {
    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<y0> a(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return i().a(fVar, bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> b() {
        return i().b();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return i().c(fVar, bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> d() {
        return i().d();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> e() {
        return i().e();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public h f(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return i().f(fVar, bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> g(d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        return i().g(dVar, function1);
    }

    public final h h() {
        if (!(i() instanceof a)) {
            return i();
        }
        h hVarI = i();
        m.d(hVarI, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
        return ((a) hVarI).h();
    }

    protected abstract h i();
}
