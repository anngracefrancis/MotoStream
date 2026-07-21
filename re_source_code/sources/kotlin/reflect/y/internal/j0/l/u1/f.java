package kotlin.reflect.y.internal.j0.l.u1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.v0;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.i.w.d;
import kotlin.reflect.y.internal.j0.i.w.h;

/* JADX INFO: compiled from: ErrorScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f24832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24833c;

    public f(g gVar, String... strArr) {
        m.f(gVar, "kind");
        m.f(strArr, "formatParams");
        this.f24832b = gVar;
        String strK = gVar.k();
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
        String str = String.format(strK, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        m.e(str, "format(this, *args)");
        this.f24833c = str;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> b() {
        return w0.d();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> d() {
        return w0.d();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> e() {
        return w0.d();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public kotlin.p002reflect.jvm.internal.impl.descriptors.h f(kotlin.reflect.y.internal.j0.f.f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        String str = String.format(b.ERROR_CLASS.k(), Arrays.copyOf(new Object[]{fVar}, 1));
        m.e(str, "format(this, *args)");
        kotlin.reflect.y.internal.j0.f.f fVarD = kotlin.reflect.y.internal.j0.f.f.D(str);
        m.e(fVarD, "special(ErrorEntity.ERRO…S.debugText.format(name))");
        return new a(fVarD);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> g(d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        return u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Set<y0> a(kotlin.reflect.y.internal.j0.f.f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return v0.c(new c(k.a.h()));
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Set<t0> c(kotlin.reflect.y.internal.j0.f.f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return k.a.j();
    }

    protected final String j() {
        return this.f24833c;
    }

    public String toString() {
        return "ErrorScope{" + this.f24833c + '}';
    }
}
