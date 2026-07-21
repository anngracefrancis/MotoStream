package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.sequences.n;

/* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m0 implements o0 {
    private final Collection<k0> a;

    /* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
    static final class a extends Lambda implements Function1<k0, c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f25162f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c invoke(k0 k0Var) {
            m.f(k0Var, "it");
            return k0Var.d();
        }
    }

    /* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
    static final class b extends Lambda implements Function1<c, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f25163f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(c cVar) {
            super(1);
            this.f25163f = cVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(c cVar) {
            m.f(cVar, "it");
            return Boolean.valueOf(!cVar.d() && m.a(cVar.e(), this.f25163f));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m0(Collection<? extends k0> collection) {
        m.f(collection, "packageFragments");
        this.a = collection;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l0
    public List<k0> a(c cVar) {
        m.f(cVar, "fqName");
        Collection<k0> collection = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (m.a(((k0) obj).d(), cVar)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o0
    public void b(c cVar, Collection<k0> collection) {
        m.f(cVar, "fqName");
        m.f(collection, "packageFragments");
        for (Object obj : this.a) {
            if (m.a(((k0) obj).d(), cVar)) {
                collection.add(obj);
            }
        }
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o0
    public boolean c(c cVar) {
        m.f(cVar, "fqName");
        Collection<k0> collection = this.a;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (m.a(((k0) it.next()).d(), cVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l0
    public Collection<c> p(c cVar, Function1<? super f, Boolean> function1) {
        m.f(cVar, "fqName");
        m.f(function1, "nameFilter");
        return n.A(n.l(n.u(c0.J(this.a), a.f25162f), new b(cVar)));
    }
}
