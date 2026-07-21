package kotlin.reflect.y.internal.j0.d.a.k0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.l0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.d.a.l0.l.k;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final List<i1> a(Collection<? extends e0> collection, Collection<? extends i1> collection2, a aVar) {
        m.f(collection, "newValueParameterTypes");
        m.f(collection2, "oldValueParameters");
        m.f(aVar, "newOwner");
        collection.size();
        collection2.size();
        List<Pair> listL0 = c0.L0(collection, collection2);
        ArrayList arrayList = new ArrayList(v.u(listL0, 10));
        for (Pair pair : listL0) {
            e0 e0Var = (e0) pair.a();
            i1 i1Var = (i1) pair.b();
            int iG = i1Var.g();
            g annotations = i1Var.getAnnotations();
            f name = i1Var.getName();
            m.e(name, "oldParameter.name");
            boolean zU0 = i1Var.u0();
            boolean zB0 = i1Var.b0();
            boolean zY = i1Var.Y();
            e0 e0VarK = i1Var.l0() != null ? kotlin.reflect.y.internal.j0.i.t.a.l(aVar).o().k(e0Var) : null;
            z0 z0VarT = i1Var.t();
            m.e(z0VarT, "oldParameter.source");
            arrayList.add(new l0(aVar, null, iG, annotations, name, e0Var, zU0, zB0, zY, e0VarK, z0VarT));
        }
        return arrayList;
    }

    public static final k b(e eVar) {
        m.f(eVar, "<this>");
        e eVarP = kotlin.reflect.y.internal.j0.i.t.a.p(eVar);
        if (eVarP == null) {
            return null;
        }
        kotlin.reflect.y.internal.j0.i.w.h hVarS = eVarP.S();
        k kVar = hVarS instanceof k ? (k) hVarS : null;
        return kVar == null ? b(eVarP) : kVar;
    }
}
