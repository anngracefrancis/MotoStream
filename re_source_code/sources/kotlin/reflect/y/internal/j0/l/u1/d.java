package kotlin.reflect.y.internal.j0.l.u1;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.f0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.y.internal.j0.b.e;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ErrorModuleDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements g0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f24825f = new d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final f f24826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<g0> f24827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final List<g0> f24828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Set<g0> f24829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final h f24830k;

    static {
        f fVarD = f.D(b.ERROR_MODULE.k());
        m.e(fVarD, "special(ErrorEntity.ERROR_MODULE.debugText)");
        f24826g = fVarD;
        f24827h = u.j();
        f24828i = u.j();
        f24829j = w0.d();
        f24830k = e.f23157h.a();
    }

    private d() {
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public <T> T I0(f0<T> f0Var) {
        m.f(f0Var, "capability");
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        m.f(oVar, "visitor");
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public p0 N(c cVar) {
        m.f(cVar, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public kotlin.p002reflect.jvm.internal.impl.descriptors.m a() {
        return this;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public kotlin.p002reflect.jvm.internal.impl.descriptors.m b() {
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public boolean e0(g0 g0Var) {
        m.f(g0Var, "targetModule");
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a
    public g getAnnotations() {
        return g.f25179c.b();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i0
    public f getName() {
        return v();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public h o() {
        return f24830k;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public Collection<c> p(c cVar, Function1<? super f, Boolean> function1) {
        m.f(cVar, "fqName");
        m.f(function1, "nameFilter");
        return u.j();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public List<g0> t0() {
        return f24828i;
    }

    public f v() {
        return f24826g;
    }
}
