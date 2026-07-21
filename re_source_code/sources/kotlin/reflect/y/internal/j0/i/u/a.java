package kotlin.reflect.y.internal.j0.i.u;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.z;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: SyntheticJavaPartsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<f> f24386b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends f> list) {
        m.f(list, "inner");
        this.f24386b = list;
    }

    @Override // kotlin.reflect.y.internal.j0.i.u.f
    public List<f> a(e eVar) {
        m.f(eVar, "thisDescriptor");
        List<f> list = this.f24386b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            z.z(arrayList, ((f) it.next()).a(eVar));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.i.u.f
    public void b(e eVar, f fVar, Collection<y0> collection) {
        m.f(eVar, "thisDescriptor");
        m.f(fVar, "name");
        m.f(collection, "result");
        Iterator<T> it = this.f24386b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).b(eVar, fVar, collection);
        }
    }

    @Override // kotlin.reflect.y.internal.j0.i.u.f
    public void c(e eVar, List<d> list) {
        m.f(eVar, "thisDescriptor");
        m.f(list, "result");
        Iterator<T> it = this.f24386b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).c(eVar, list);
        }
    }

    @Override // kotlin.reflect.y.internal.j0.i.u.f
    public List<f> d(e eVar) {
        m.f(eVar, "thisDescriptor");
        List<f> list = this.f24386b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            z.z(arrayList, ((f) it.next()).d(eVar));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.i.u.f
    public void e(e eVar, f fVar, Collection<y0> collection) {
        m.f(eVar, "thisDescriptor");
        m.f(fVar, "name");
        m.f(collection, "result");
        Iterator<T> it = this.f24386b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).e(eVar, fVar, collection);
        }
    }
}
