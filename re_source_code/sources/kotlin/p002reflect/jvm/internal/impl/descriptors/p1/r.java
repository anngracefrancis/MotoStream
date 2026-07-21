package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public class r extends j implements p0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f25282h = {g0.h(new y(g0.b(r.class), "fragments", "getFragments()Ljava/util/List;")), g0.h(new y(g0.b(r.class), "empty", "getEmpty()Z"))};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final x f25283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.f.c f25284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final i f25285k;
    private final i l;
    private final h m;

    /* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
    static final class a extends Lambda implements Function0<Boolean> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(n0.b(r.this.v0().R0(), r.this.d()));
        }
    }

    /* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
    static final class b extends Lambda implements Function0<List<? extends k0>> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends k0> invoke() {
            return n0.c(r.this.v0().R0(), r.this.d());
        }
    }

    /* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
    static final class c extends Lambda implements Function0<h> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h invoke() {
            if (r.this.isEmpty()) {
                return h.b.f24422b;
            }
            List<k0> listI = r.this.I();
            ArrayList arrayList = new ArrayList(v.u(listI, 10));
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                arrayList.add(((k0) it.next()).q());
            }
            List listP0 = c0.p0(arrayList, new h0(r.this.v0(), r.this.d()));
            return kotlin.reflect.y.internal.j0.i.w.b.f24397b.a("package view scope for " + r.this.d() + " in " + r.this.v0().getName(), listP0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(x xVar, kotlin.reflect.y.internal.j0.f.c cVar, n nVar) {
        super(g.f25179c.b(), cVar.h());
        m.f(xVar, "module");
        m.f(cVar, "fqName");
        m.f(nVar, "storageManager");
        this.f25283i = xVar;
        this.f25284j = cVar;
        this.f25285k = nVar.d(new b());
        this.l = nVar.d(new a());
        this.m = new kotlin.reflect.y.internal.j0.i.w.g(nVar, new c());
    }

    protected final boolean A0() {
        return ((Boolean) kotlin.reflect.y.internal.j0.k.m.a(this.l, this, f25282h[1])).booleanValue();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p0
    public List<k0> I() {
        return (List) kotlin.reflect.y.internal.j0.k.m.a(this.f25285k, this, f25282h[0]);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public p0 b() {
        if (d().d()) {
            return null;
        }
        x xVarV0 = v0();
        kotlin.reflect.y.internal.j0.f.c cVarE = d().e();
        m.e(cVarE, "fqName.parent()");
        return xVarV0.N(cVarE);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        m.f(oVar, "visitor");
        return oVar.c(this, d2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p0
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public x v0() {
        return this.f25283i;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p0
    public kotlin.reflect.y.internal.j0.f.c d() {
        return this.f25284j;
    }

    public boolean equals(Object obj) {
        p0 p0Var = obj instanceof p0 ? (p0) obj : null;
        return p0Var != null && m.a(d(), p0Var.d()) && m.a(v0(), p0Var.v0());
    }

    public int hashCode() {
        return (v0().hashCode() * 31) + d().hashCode();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p0
    public boolean isEmpty() {
        return A0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p0
    public h q() {
        return this.m;
    }
}
