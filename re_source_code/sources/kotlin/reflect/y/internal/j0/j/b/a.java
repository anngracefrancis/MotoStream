package kotlin.reflect.y.internal.j0.j.b;

import java.util.Collection;
import java.util.List;
import kotlin.collections.u;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.h;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements o0 {
    private final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f24454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g0 f24455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected k f24456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h<c, k0> f24457e;

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.j.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
    static final class C0383a extends Lambda implements Function1<c, k0> {
        C0383a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final k0 invoke(c cVar) {
            m.f(cVar, "fqName");
            p pVarD = a.this.d(cVar);
            if (pVarD == null) {
                return null;
            }
            pVarD.M0(a.this.e());
            return pVarD;
        }
    }

    public a(n nVar, u uVar, g0 g0Var) {
        m.f(nVar, "storageManager");
        m.f(uVar, "finder");
        m.f(g0Var, "moduleDescriptor");
        this.a = nVar;
        this.f24454b = uVar;
        this.f24455c = g0Var;
        this.f24457e = nVar.i(new C0383a());
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l0
    public List<k0> a(c cVar) {
        m.f(cVar, "fqName");
        return u.n(this.f24457e.invoke(cVar));
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o0
    public void b(c cVar, Collection<k0> collection) {
        m.f(cVar, "fqName");
        m.f(collection, "packageFragments");
        kotlin.p002reflect.jvm.internal.impl.utils.a.a(collection, this.f24457e.invoke(cVar));
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o0
    public boolean c(c cVar) {
        m.f(cVar, "fqName");
        return (this.f24457e.f(cVar) ? (k0) this.f24457e.invoke(cVar) : d(cVar)) == null;
    }

    protected abstract p d(c cVar);

    protected final k e() {
        k kVar = this.f24456d;
        if (kVar != null) {
            return kVar;
        }
        m.w("components");
        return null;
    }

    protected final u f() {
        return this.f24454b;
    }

    protected final g0 g() {
        return this.f24455c;
    }

    protected final n h() {
        return this.a;
    }

    protected final void i(k kVar) {
        m.f(kVar, "<set-?>");
        this.f24456d = kVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l0
    public Collection<c> p(c cVar, Function1<? super f, Boolean> function1) {
        m.f(cVar, "fqName");
        m.f(function1, "nameFilter");
        return w0.d();
    }
}
