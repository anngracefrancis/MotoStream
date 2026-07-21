package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.collections.w0;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.f0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.g;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends j implements g0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final n f25300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h f25301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final f f25302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map<f0<?>, Object> f25303k;
    private final a0 l;
    private v m;
    private l0 n;
    private boolean o;
    private final g<c, p0> p;
    private final Lazy q;

    /* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
    static final class a extends Lambda implements Function0<i> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i invoke() {
            v vVar = x.this.m;
            x xVar = x.this;
            if (vVar == null) {
                throw new AssertionError("Dependencies of module " + xVar.Q0() + " were not set before querying module content");
            }
            List<x> listA = vVar.a();
            x.this.P0();
            listA.contains(x.this);
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                ((x) it.next()).U0();
            }
            ArrayList arrayList = new ArrayList(v.u(listA, 10));
            Iterator<T> it2 = listA.iterator();
            while (it2.hasNext()) {
                l0 l0Var = ((x) it2.next()).n;
                m.c(l0Var);
                arrayList.add(l0Var);
            }
            return new i(arrayList, "CompositeProvider@ModuleDescriptor for " + x.this.getName());
        }
    }

    /* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
    static final class b extends Lambda implements Function1<c, p0> {
        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final p0 invoke(c cVar) {
            m.f(cVar, "fqName");
            a0 a0Var = x.this.l;
            x xVar = x.this;
            return a0Var.a(xVar, cVar, xVar.f25300h);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(f fVar, n nVar, h hVar, kotlin.reflect.y.internal.j0.g.a aVar) {
        this(fVar, nVar, hVar, aVar, null, null, 48, null);
        m.f(fVar, "moduleName");
        m.f(nVar, "storageManager");
        m.f(hVar, "builtIns");
    }

    public /* synthetic */ x(f fVar, n nVar, h hVar, kotlin.reflect.y.internal.j0.g.a aVar, Map map, f fVar2, int i2, kotlin.jvm.internal.g gVar) {
        this(fVar, nVar, hVar, (i2 & 8) != 0 ? null : aVar, (i2 & 16) != 0 ? q0.i() : map, (i2 & 32) != 0 ? null : fVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Q0() {
        String string = getName().toString();
        m.e(string, "name.toString()");
        return string;
    }

    private final i S0() {
        return (i) this.q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U0() {
        return this.n != null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public <T> T I0(f0<T> f0Var) {
        m.f(f0Var, "capability");
        T t = (T) this.f25303k.get(f0Var);
        if (t == null) {
            return null;
        }
        return t;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        return (R) g0.a.a(this, oVar, d2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public p0 N(c cVar) {
        m.f(cVar, "fqName");
        P0();
        return this.p.invoke(cVar);
    }

    public void P0() {
        if (V0()) {
            return;
        }
        a0.a(this);
    }

    public final l0 R0() {
        P0();
        return S0();
    }

    public final void T0(l0 l0Var) {
        m.f(l0Var, "providerForModuleContent");
        U0();
        this.n = l0Var;
    }

    public boolean V0() {
        return this.o;
    }

    public final void W0(List<x> list) {
        m.f(list, "descriptors");
        X0(list, w0.d());
    }

    public final void X0(List<x> list, Set<x> set) {
        m.f(list, "descriptors");
        m.f(set, "friends");
        Y0(new w(list, set, u.j(), w0.d()));
    }

    public final void Y0(v vVar) {
        m.f(vVar, "dependencies");
        v vVar2 = this.m;
        this.m = vVar;
    }

    public final void Z0(x... xVarArr) {
        m.f(xVarArr, "descriptors");
        W0(kotlin.collections.n.Z(xVarArr));
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public kotlin.p002reflect.jvm.internal.impl.descriptors.m b() {
        return g0.a.b(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public boolean e0(g0 g0Var) {
        m.f(g0Var, "targetModule");
        if (m.a(this, g0Var)) {
            return true;
        }
        v vVar = this.m;
        m.c(vVar);
        return c0.K(vVar.b(), g0Var) || t0().contains(g0Var) || g0Var.t0().contains(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public h o() {
        return this.f25301i;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public Collection<c> p(c cVar, Function1<? super f, Boolean> function1) {
        m.f(cVar, "fqName");
        m.f(function1, "nameFilter");
        P0();
        return R0().p(cVar, function1);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g0
    public List<g0> t0() {
        v vVar = this.m;
        if (vVar != null) {
            return vVar.c();
        }
        throw new AssertionError("Dependencies of module " + Q0() + " were not set");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(f fVar, n nVar, h hVar, kotlin.reflect.y.internal.j0.g.a aVar, Map<f0<?>, ? extends Object> map, f fVar2) {
        super(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), fVar);
        m.f(fVar, "moduleName");
        m.f(nVar, "storageManager");
        m.f(hVar, "builtIns");
        m.f(map, "capabilities");
        this.f25300h = nVar;
        this.f25301i = hVar;
        this.f25302j = fVar2;
        if (fVar.y()) {
            this.f25303k = map;
            a0 a0Var = (a0) I0(a0.a.a());
            this.l = a0Var == null ? a0.b.f25211b : a0Var;
            this.o = true;
            this.p = nVar.h(new b());
            this.q = i.b(new a());
            return;
        }
        throw new IllegalArgumentException("Module name must be special: " + fVar);
    }
}
