package kotlin.reflect.y.internal.j0.j.b.g0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.w0;
import kotlin.collections.z;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.r;
import kotlin.reflect.y.internal.j0.e.t;
import kotlin.reflect.y.internal.j0.e.w;
import kotlin.reflect.y.internal.j0.e.z.a;
import kotlin.reflect.y.internal.j0.e.z.g;
import kotlin.reflect.y.internal.j0.e.z.h;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.d;
import kotlin.reflect.y.internal.j0.j.b.k;

/* JADX INFO: compiled from: DeserializedPackageMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public class i extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final k0 f24572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f24573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c f24574i;

    public i(k0 k0Var, l lVar, kotlin.reflect.y.internal.j0.e.z.c cVar, a aVar, f fVar, k kVar, String str, Function0<? extends Collection<f>> function0) {
        m.f(k0Var, "packageDescriptor");
        m.f(lVar, "proto");
        m.f(cVar, "nameResolver");
        m.f(aVar, "metadataVersion");
        m.f(kVar, "components");
        m.f(str, "debugName");
        m.f(function0, "classNames");
        t tVarV = lVar.V();
        m.e(tVarV, "proto.typeTable");
        g gVar = new g(tVarV);
        h.a aVar2 = h.a;
        w wVarX = lVar.X();
        m.e(wVarX, "proto.versionRequirementTable");
        kotlin.reflect.y.internal.j0.j.b.m mVarA = kVar.a(k0Var, cVar, gVar, aVar2.a(wVarX), aVar, fVar);
        List<kotlin.reflect.y.internal.j0.e.i> listO = lVar.O();
        m.e(listO, "proto.functionList");
        List<n> listR = lVar.R();
        m.e(listR, "proto.propertyList");
        List<r> listU = lVar.U();
        m.e(listU, "proto.typeAliasList");
        super(mVarA, listO, listR, listU, function0);
        this.f24572g = k0Var;
        this.f24573h = str;
        this.f24574i = k0Var.d();
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.h, kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public kotlin.p002reflect.jvm.internal.impl.descriptors.h f(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        z(fVar, bVar);
        return super.f(fVar, bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.h
    protected void i(Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> collection, Function1<? super f, Boolean> function1) {
        m.f(collection, "result");
        m.f(function1, "nameFilter");
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.h
    protected kotlin.reflect.y.internal.j0.f.b m(f fVar) {
        m.f(fVar, "name");
        return new kotlin.reflect.y.internal.j0.f.b(this.f24574i, fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.h
    protected Set<f> s() {
        return w0.d();
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.h
    protected Set<f> t() {
        return w0.d();
    }

    public String toString() {
        return this.f24573h;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.h
    protected Set<f> u() {
        return w0.d();
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.h
    protected boolean w(f fVar) {
        boolean z;
        m.f(fVar, "name");
        if (super.w(fVar)) {
            return true;
        }
        Iterable<kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b> iterableK = p().c().k();
        if ((iterableK instanceof Collection) && ((Collection) iterableK).isEmpty()) {
            z = false;
        } else {
            Iterator<kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b> it = iterableK.iterator();
            while (it.hasNext()) {
                if (it.next().b(this.f24574i, fVar)) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public List<kotlin.p002reflect.jvm.internal.impl.descriptors.m> g(d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> collectionJ = j(dVar, function1, kotlin.reflect.y.internal.j0.c.b.d.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b> iterableK = p().c().k();
        ArrayList arrayList = new ArrayList();
        Iterator<kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b> it = iterableK.iterator();
        while (it.hasNext()) {
            z.z(arrayList, it.next().a(this.f24574i));
        }
        return c0.o0(collectionJ, arrayList);
    }

    public void z(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        kotlin.reflect.y.internal.j0.c.a.b(p().c().o(), bVar, this.f24572g, fVar);
    }
}
