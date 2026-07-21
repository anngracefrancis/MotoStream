package kotlin.reflect.y.internal.j0.d.a.l0;

import java.util.Iterator;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.k.h;
import kotlin.sequences.n;

/* JADX INFO: compiled from: LazyJavaAnnotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f23459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.d.a.n0.d f23460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f23461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h<kotlin.reflect.y.internal.j0.d.a.n0.a, c> f23462i;

    /* JADX INFO: compiled from: LazyJavaAnnotations.kt */
    static final class a extends Lambda implements Function1<kotlin.reflect.y.internal.j0.d.a.n0.a, c> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c invoke(kotlin.reflect.y.internal.j0.d.a.n0.a aVar) {
            m.f(aVar, "annotation");
            return kotlin.reflect.y.internal.j0.d.a.j0.c.a.e(aVar, d.this.f23459f, d.this.f23461h);
        }
    }

    public d(g gVar, kotlin.reflect.y.internal.j0.d.a.n0.d dVar, boolean z) {
        m.f(gVar, "c");
        m.f(dVar, "annotationOwner");
        this.f23459f = gVar;
        this.f23460g = dVar;
        this.f23461h = z;
        this.f23462i = gVar.a().u().i(new a());
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public boolean R0(kotlin.reflect.y.internal.j0.f.c cVar) {
        return g.b.b(this, cVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public boolean isEmpty() {
        return this.f23460g.getAnnotations().isEmpty() && !this.f23460g.m();
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return n.n(n.x(n.u(c0.J(this.f23460g.getAnnotations()), this.f23462i), kotlin.reflect.y.internal.j0.d.a.j0.c.a.a(k.a.y, this.f23460g, this.f23459f))).iterator();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public c l(kotlin.reflect.y.internal.j0.f.c cVar) {
        c cVarInvoke;
        m.f(cVar, "fqName");
        kotlin.reflect.y.internal.j0.d.a.n0.a aVarL = this.f23460g.l(cVar);
        return (aVarL == null || (cVarInvoke = this.f23462i.invoke(aVarL)) == null) ? kotlin.reflect.y.internal.j0.d.a.j0.c.a.a(cVar, this.f23460g, this.f23459f) : cVarInvoke;
    }

    public /* synthetic */ d(g gVar, kotlin.reflect.y.internal.j0.d.a.n0.d dVar, boolean z, int i2, kotlin.jvm.internal.g gVar2) {
        this(gVar, dVar, (i2 & 4) != 0 ? false : z);
    }
}
