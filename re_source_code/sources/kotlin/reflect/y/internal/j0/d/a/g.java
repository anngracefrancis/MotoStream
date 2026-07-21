package kotlin.reflect.y.internal.j0.d.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.s;

/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final g a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<c, f> f23371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<f, List<f>> f23372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<c> f23373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<f> f23374e;

    static {
        d dVar = k.a.s;
        c cVar = k.a.Y;
        Map<c, f> mapL = q0.l(s.a(h.d(dVar, "name"), f.x("name")), s.a(h.d(dVar, "ordinal"), f.x("ordinal")), s.a(h.c(k.a.U, "size"), f.x("size")), s.a(h.c(cVar, "size"), f.x("size")), s.a(h.d(k.a.f23206g, "length"), f.x("length")), s.a(h.c(cVar, "keys"), f.x("keySet")), s.a(h.c(cVar, "values"), f.x("values")), s.a(h.c(cVar, "entries"), f.x("entrySet")));
        f23371b = mapL;
        Set<Map.Entry<c, f>> setEntrySet = mapL.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(v.u(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((c) entry.getKey()).g(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            f fVar = (f) pair.d();
            Object arrayList2 = linkedHashMap.get(fVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(fVar, arrayList2);
            }
            ((List) arrayList2).add((f) pair.c());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(p0.e(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), c0.L((Iterable) entry2.getValue()));
        }
        f23372c = linkedHashMap2;
        Set<c> setKeySet = f23371b.keySet();
        f23373d = setKeySet;
        ArrayList arrayList3 = new ArrayList(v.u(setKeySet, 10));
        Iterator<T> it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((c) it2.next()).g());
        }
        f23374e = c0.I0(arrayList3);
    }

    private g() {
    }

    public final Map<c, f> a() {
        return f23371b;
    }

    public final List<f> b(f fVar) {
        m.f(fVar, "name1");
        List<f> list = f23372c.get(fVar);
        return list == null ? u.j() : list;
    }

    public final Set<c> c() {
        return f23373d;
    }

    public final Set<f> d() {
        return f23374e;
    }
}
