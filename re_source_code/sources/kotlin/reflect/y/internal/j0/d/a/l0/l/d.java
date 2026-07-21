package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.n;
import kotlin.collections.w0;
import kotlin.collections.z;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.u;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.i.w.j;
import kotlin.reflect.y.internal.j0.k.i;

/* JADX INFO: compiled from: JvmPackageScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23482b = {g0.h(new y(g0.b(d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f23483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f23484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i f23485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f23486f;

    /* JADX INFO: compiled from: JvmPackageScope.kt */
    static final class a extends Lambda implements Function0<h[]> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h[] invoke() {
            Collection<q> collectionValues = d.this.f23484d.N0().values();
            d dVar = d.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                h hVarB = dVar.f23483c.a().b().b(dVar.f23484d, (q) it.next());
                if (hVarB != null) {
                    arrayList.add(hVarB);
                }
            }
            Object[] array = kotlin.reflect.y.internal.j0.m.v.a.b(arrayList).toArray(new h[0]);
            m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (h[]) array;
        }
    }

    public d(g gVar, u uVar, h hVar) {
        m.f(gVar, "c");
        m.f(uVar, "jPackage");
        m.f(hVar, "packageFragment");
        this.f23483c = gVar;
        this.f23484d = hVar;
        this.f23485e = new i(gVar, uVar, hVar);
        this.f23486f = gVar.e().d(new a());
    }

    private final h[] k() {
        return (h[]) kotlin.reflect.y.internal.j0.k.m.a(this.f23486f, this, f23482b[0]);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<y0> a(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        l(fVar, bVar);
        i iVar = this.f23485e;
        h[] hVarArrK = k();
        Collection<? extends y0> collectionA = iVar.a(fVar, bVar);
        int length = hVarArrK.length;
        int i2 = 0;
        Collection collection = collectionA;
        while (i2 < length) {
            Collection collectionA2 = kotlin.reflect.y.internal.j0.m.v.a.a(collection, hVarArrK[i2].a(fVar, bVar));
            i2++;
            collection = collectionA2;
        }
        return collection == null ? w0.d() : collection;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> b() {
        h[] hVarArrK = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : hVarArrK) {
            z.z(linkedHashSet, hVar.b());
        }
        linkedHashSet.addAll(this.f23485e.b());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        l(fVar, bVar);
        i iVar = this.f23485e;
        h[] hVarArrK = k();
        Collection<? extends t0> collectionC = iVar.c(fVar, bVar);
        int length = hVarArrK.length;
        int i2 = 0;
        Collection collection = collectionC;
        while (i2 < length) {
            Collection collectionA = kotlin.reflect.y.internal.j0.m.v.a.a(collection, hVarArrK[i2].c(fVar, bVar));
            i2++;
            collection = collectionA;
        }
        return collection == null ? w0.d() : collection;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> d() {
        h[] hVarArrK = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : hVarArrK) {
            z.z(linkedHashSet, hVar.d());
        }
        linkedHashSet.addAll(this.f23485e.d());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> e() {
        Set<f> setA = j.a(n.q(k()));
        if (setA == null) {
            return null;
        }
        setA.addAll(this.f23485e.e());
        return setA;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public kotlin.p002reflect.jvm.internal.impl.descriptors.h f(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        l(fVar, bVar);
        e eVarP = this.f23485e.f(fVar, bVar);
        if (eVarP != null) {
            return eVarP;
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVar = null;
        for (h hVar2 : k()) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarF = hVar2.f(fVar, bVar);
            if (hVarF != null) {
                if (!(hVarF instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.i) || !((kotlin.p002reflect.jvm.internal.impl.descriptors.i) hVarF).M()) {
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
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        i iVar = this.f23485e;
        h[] hVarArrK = k();
        Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> collectionG = iVar.g(dVar, function1);
        for (h hVar : hVarArrK) {
            collectionG = kotlin.reflect.y.internal.j0.m.v.a.a(collectionG, hVar.g(dVar, function1));
        }
        return collectionG == null ? w0.d() : collectionG;
    }

    public final i j() {
        return this.f23485e;
    }

    public void l(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        kotlin.reflect.y.internal.j0.c.a.b(this.f23483c.a().l(), bVar, this.f23484d, fVar);
    }

    public String toString() {
        return "scope for " + this.f23484d;
    }
}
