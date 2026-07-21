package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p0;
import kotlin.p002reflect.jvm.internal.impl.utils.a;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.d;
import kotlin.reflect.y.internal.j0.i.w.i;

/* JADX INFO: compiled from: SubpackagesScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public class h0 extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g0 f25241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f25242c;

    public h0(g0 g0Var, c cVar) {
        m.f(g0Var, "moduleDescriptor");
        m.f(cVar, "fqName");
        this.f25241b = g0Var;
        this.f25242c = cVar;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> e() {
        return w0.d();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> g(d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        if (!dVar.a(d.a.f())) {
            return u.j();
        }
        if (this.f25242c.d() && dVar.l().contains(kotlin.f0.y.e.j0.i.w.c.b.a)) {
            return u.j();
        }
        Collection<c> collectionP = this.f25241b.p(this.f25242c, function1);
        ArrayList arrayList = new ArrayList(collectionP.size());
        Iterator<c> it = collectionP.iterator();
        while (it.hasNext()) {
            f fVarG = it.next().g();
            m.e(fVarG, "subFqName.shortName()");
            if (function1.invoke(fVarG).booleanValue()) {
                a.a(arrayList, h(fVarG));
            }
        }
        return arrayList;
    }

    protected final p0 h(f fVar) {
        m.f(fVar, "name");
        if (fVar.y()) {
            return null;
        }
        g0 g0Var = this.f25241b;
        c cVarC = this.f25242c.c(fVar);
        m.e(cVarC, "fqName.child(name)");
        p0 p0VarN = g0Var.N(cVarC);
        if (p0VarN.isEmpty()) {
            return null;
        }
        return p0VarN;
    }

    public String toString() {
        return "subpackages of " + this.f25242c + " from " + this.f25241b;
    }
}
