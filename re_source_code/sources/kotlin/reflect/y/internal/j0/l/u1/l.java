package kotlin.reflect.y.internal.j0.l.u1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.d;

/* JADX INFO: compiled from: ThrowingScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(g gVar, String... strArr) {
        super(gVar, (String[]) Arrays.copyOf(strArr, strArr.length));
        m.f(gVar, "kind");
        m.f(strArr, "formatParams");
    }

    @Override // kotlin.reflect.y.internal.j0.l.u1.f, kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> b() {
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.y.internal.j0.l.u1.f, kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> d() {
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.y.internal.j0.l.u1.f, kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> e() {
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.y.internal.j0.l.u1.f, kotlin.reflect.y.internal.j0.i.w.k
    public h f(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        throw new IllegalStateException(j() + ", required name: " + fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.l.u1.f, kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> g(d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        throw new IllegalStateException(j());
    }

    @Override // kotlin.reflect.y.internal.j0.l.u1.f, kotlin.reflect.y.internal.j0.i.w.h
    /* JADX INFO: renamed from: h */
    public Set<y0> a(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        throw new IllegalStateException(j() + ", required name: " + fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.l.u1.f, kotlin.reflect.y.internal.j0.i.w.h
    /* JADX INFO: renamed from: i */
    public Set<t0> c(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        throw new IllegalStateException(j() + ", required name: " + fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.l.u1.f
    public String toString() {
        return "ThrowingScope{" + j() + '}';
    }
}
