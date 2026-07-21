package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: CompositePackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements o0 {
    private final List<l0> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f25243b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(List<? extends l0> list, String str) {
        m.f(list, "providers");
        m.f(str, "debugName");
        this.a = list;
        this.f25243b = str;
        list.size();
        c0.I0(list).size();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l0
    public List<k0> a(c cVar) {
        m.f(cVar, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<l0> it = this.a.iterator();
        while (it.hasNext()) {
            n0.a(it.next(), cVar, arrayList);
        }
        return c0.E0(arrayList);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o0
    public void b(c cVar, Collection<k0> collection) {
        m.f(cVar, "fqName");
        m.f(collection, "packageFragments");
        Iterator<l0> it = this.a.iterator();
        while (it.hasNext()) {
            n0.a(it.next(), cVar, collection);
        }
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o0
    public boolean c(c cVar) {
        m.f(cVar, "fqName");
        List<l0> list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!n0.b((l0) it.next(), cVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l0
    public Collection<c> p(c cVar, Function1<? super f, Boolean> function1) {
        m.f(cVar, "fqName");
        m.f(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator<l0> it = this.a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().p(cVar, function1));
        }
        return hashSet;
    }

    public String toString() {
        return this.f25243b;
    }
}
