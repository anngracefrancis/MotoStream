package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.d.a.n0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.n;
import kotlin.reflect.y.internal.j0.d.a.n0.p;
import kotlin.reflect.y.internal.j0.d.a.n0.q;
import kotlin.reflect.y.internal.j0.d.a.n0.r;
import kotlin.reflect.y.internal.j0.d.a.n0.w;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: DeclaredMemberIndex.kt */
/* JADX INFO: loaded from: classes2.dex */
public class a implements b {
    private final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<q, Boolean> f23476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1<r, Boolean> f23477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<f, List<r>> f23478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<f, n> f23479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<f, w> f23480f;

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.a.l0.l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DeclaredMemberIndex.kt */
    static final class C0331a extends Lambda implements Function1<r, Boolean> {
        C0331a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(r rVar) {
            m.f(rVar, "m");
            return Boolean.valueOf(((Boolean) a.this.f23476b.invoke(rVar)).booleanValue() && !p.c(rVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(g gVar, Function1<? super q, Boolean> function1) {
        m.f(gVar, "jClass");
        m.f(function1, "memberFilter");
        this.a = gVar;
        this.f23476b = function1;
        C0331a c0331a = new C0331a();
        this.f23477c = c0331a;
        Sequence sequenceL = kotlin.sequences.n.l(c0.J(gVar.M()), c0331a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequenceL) {
            f name = ((r) obj).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f23478d = linkedHashMap;
        Sequence sequenceL2 = kotlin.sequences.n.l(c0.J(this.a.D()), this.f23476b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : sequenceL2) {
            linkedHashMap2.put(((n) obj2).getName(), obj2);
        }
        this.f23479e = linkedHashMap2;
        Collection<w> collectionJ = this.a.j();
        Function1<q, Boolean> function2 = this.f23476b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : collectionJ) {
            if (function2.invoke((q) obj3).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(l.b(p0.e(v.u(arrayList2, 10)), 16));
        for (Object obj4 : arrayList2) {
            linkedHashMap3.put(((w) obj4).getName(), obj4);
        }
        this.f23480f = linkedHashMap3;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public Set<f> a() {
        Sequence sequenceL = kotlin.sequences.n.l(c0.J(this.a.M()), this.f23477c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = sequenceL.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((r) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public w b(f fVar) {
        m.f(fVar, "name");
        return this.f23480f.get(fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public n c(f fVar) {
        m.f(fVar, "name");
        return this.f23479e.get(fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public Set<f> d() {
        return this.f23480f.keySet();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public Set<f> e() {
        Sequence sequenceL = kotlin.sequences.n.l(c0.J(this.a.D()), this.f23476b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = sequenceL.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((n) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public Collection<r> f(f fVar) {
        m.f(fVar, "name");
        List<r> list = this.f23478d.get(fVar);
        return list != null ? list : u.j();
    }
}
