package kotlin.reflect.y.internal.j0.d.a.l0;

import java.util.Collection;
import java.util.List;
import kotlin.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.y.internal.j0.d.a.l0.l.h;
import kotlin.reflect.y.internal.j0.d.a.n0.u;
import kotlin.reflect.y.internal.j0.d.a.o;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: LazyJavaPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements o0 {
    private final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.a<c, h> f23464b;

    /* JADX INFO: compiled from: LazyJavaPackageFragmentProvider.kt */
    static final class a extends Lambda implements Function0<h> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ u f23466g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(u uVar) {
            super(0);
            this.f23466g = uVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h invoke() {
            return new h(f.this.a, this.f23466g);
        }
    }

    public f(b bVar) {
        m.f(bVar, "components");
        g gVar = new g(bVar, k.a.a, j.c(null));
        this.a = gVar;
        this.f23464b = gVar.e().b();
    }

    private final h e(c cVar) {
        u uVarA = o.a.a(this.a.a().d(), cVar, false, 2, null);
        if (uVarA == null) {
            return null;
        }
        return this.f23464b.b(cVar, new a(uVarA));
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l0
    public List<h> a(c cVar) {
        m.f(cVar, "fqName");
        return kotlin.collections.u.n(e(cVar));
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o0
    public void b(c cVar, Collection<k0> collection) {
        m.f(cVar, "fqName");
        m.f(collection, "packageFragments");
        kotlin.p002reflect.jvm.internal.impl.utils.a.a(collection, e(cVar));
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o0
    public boolean c(c cVar) {
        m.f(cVar, "fqName");
        return o.a.a(this.a.a().d(), cVar, false, 2, null) == null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public List<c> p(c cVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        m.f(cVar, "fqName");
        m.f(function1, "nameFilter");
        h hVarE = e(cVar);
        List<c> listP0 = hVarE != null ? hVarE.P0() : null;
        return listP0 == null ? kotlin.collections.u.j() : listP0;
    }

    public String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.a.a().m();
    }
}
