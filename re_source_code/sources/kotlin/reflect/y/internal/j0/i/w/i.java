package kotlin.reflect.y.internal.j0.i.w;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.p002reflect.jvm.internal.impl.utils.d;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: MemberScopeImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements h {
    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<? extends y0> a(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> b() {
        Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> collectionG = g(d.t, d.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionG) {
            if (obj instanceof y0) {
                f name = ((y0) obj).getName();
                m.e(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<? extends t0> c(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> d() {
        Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> collectionG = g(d.u, d.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionG) {
            if (obj instanceof y0) {
                f name = ((y0) obj).getName();
                m.e(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> e() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public h f(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> g(d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        return u.j();
    }
}
