package kotlin.reflect.y.internal.j0.d.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.z;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.b;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.i.r.j;
import kotlin.reflect.y.internal.j0.i.t.a;

/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends a<c> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(w wVar) {
        super(wVar);
        m.f(wVar, "javaTypeEnhancementState");
    }

    private final List<String> y(g<?> gVar) {
        if (!(gVar instanceof b)) {
            return gVar instanceof j ? t.e(((j) gVar).c().u()) : u.j();
        }
        List<? extends g<?>> listB = ((b) gVar).b();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            z.z(arrayList, y((g) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Iterable<String> b(c cVar, boolean z) {
        m.f(cVar, "<this>");
        Map<f, g<?>> mapA = cVar.a();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<f, g<?>> entry : mapA.entrySet()) {
            z.z(arrayList, (!z || m.a(entry.getKey(), a0.f23325c)) ? y(entry.getValue()) : u.j());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.y.internal.j0.f.c i(c cVar) {
        m.f(cVar, "<this>");
        return cVar.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.a
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public Object j(c cVar) {
        m.f(cVar, "<this>");
        e eVarE = a.e(cVar);
        m.c(eVarE);
        return eVarE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public Iterable<c> k(c cVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g annotations;
        m.f(cVar, "<this>");
        e eVarE = a.e(cVar);
        return (eVarE == null || (annotations = eVarE.getAnnotations()) == null) ? u.j() : annotations;
    }
}
