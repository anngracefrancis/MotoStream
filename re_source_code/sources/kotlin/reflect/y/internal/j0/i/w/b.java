package kotlin.reflect.y.internal.j0.i.w;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.collections.w0;
import kotlin.collections.z;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.p002reflect.jvm.internal.impl.utils.e;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ChainedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24397b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h[] f24399d;

    /* JADX INFO: compiled from: ChainedMemberScope.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final h a(String str, Iterable<? extends h> iterable) {
            m.f(str, "debugName");
            m.f(iterable, "scopes");
            e eVar = new e();
            for (h hVar : iterable) {
                if (hVar != h.b.f24422b) {
                    if (hVar instanceof b) {
                        z.A(eVar, ((b) hVar).f24399d);
                    } else {
                        eVar.add(hVar);
                    }
                }
            }
            return b(str, eVar);
        }

        public final h b(String str, List<? extends h> list) {
            m.f(str, "debugName");
            m.f(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return h.b.f24422b;
            }
            if (size == 1) {
                return list.get(0);
            }
            Object[] array = list.toArray(new h[0]);
            m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new b(str, (h[]) array, null);
        }
    }

    private b(String str, h[] hVarArr) {
        this.f24398c = str;
        this.f24399d = hVarArr;
    }

    public /* synthetic */ b(String str, h[] hVarArr, g gVar) {
        this(str, hVarArr);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<y0> a(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        h[] hVarArr = this.f24399d;
        int length = hVarArr.length;
        if (length == 0) {
            return u.j();
        }
        if (length == 1) {
            return hVarArr[0].a(fVar, bVar);
        }
        Collection<y0> collectionA = null;
        for (h hVar : hVarArr) {
            collectionA = kotlin.reflect.y.internal.j0.m.v.a.a(collectionA, hVar.a(fVar, bVar));
        }
        return collectionA == null ? w0.d() : collectionA;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> b() {
        h[] hVarArr = this.f24399d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : hVarArr) {
            z.z(linkedHashSet, hVar.b());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        h[] hVarArr = this.f24399d;
        int length = hVarArr.length;
        if (length == 0) {
            return u.j();
        }
        if (length == 1) {
            return hVarArr[0].c(fVar, bVar);
        }
        Collection<t0> collectionA = null;
        for (h hVar : hVarArr) {
            collectionA = kotlin.reflect.y.internal.j0.m.v.a.a(collectionA, hVar.c(fVar, bVar));
        }
        return collectionA == null ? w0.d() : collectionA;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> d() {
        h[] hVarArr = this.f24399d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : hVarArr) {
            z.z(linkedHashSet, hVar.d());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> e() {
        return j.a(n.q(this.f24399d));
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public h f(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        h hVar = null;
        for (h hVar2 : this.f24399d) {
            h hVarF = hVar2.f(fVar, bVar);
            if (hVarF != null) {
                if (!(hVarF instanceof i) || !((i) hVarF).M()) {
                    return hVarF;
                }
                if (hVar == null) {
                    hVar = hVarF;
                }
            }
        }
        return hVar;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> g(d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        h[] hVarArr = this.f24399d;
        int length = hVarArr.length;
        if (length == 0) {
            return u.j();
        }
        if (length == 1) {
            return hVarArr[0].g(dVar, function1);
        }
        Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> collectionA = null;
        for (h hVar : hVarArr) {
            collectionA = kotlin.reflect.y.internal.j0.m.v.a.a(collectionA, hVar.g(dVar, function1));
        }
        return collectionA == null ? w0.d() : collectionA;
    }

    public String toString() {
        return this.f24398c;
    }
}
