package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: CycleDetector.java */
/* JADX INFO: loaded from: classes2.dex */
class u {

    /* JADX INFO: compiled from: CycleDetector.java */
    private static class b {
        private final n<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<b> f18910b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<b> f18911c = new HashSet();

        b(n<?> nVar) {
            this.a = nVar;
        }

        void a(b bVar) {
            this.f18910b.add(bVar);
        }

        void b(b bVar) {
            this.f18911c.add(bVar);
        }

        n<?> c() {
            return this.a;
        }

        Set<b> d() {
            return this.f18910b;
        }

        boolean e() {
            return this.f18910b.isEmpty();
        }

        boolean f() {
            return this.f18911c.isEmpty();
        }

        void g(b bVar) {
            this.f18911c.remove(bVar);
        }
    }

    /* JADX INFO: compiled from: CycleDetector.java */
    private static class c {
        private final b0<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f18912b;

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.a.equals(this.a) && cVar.f18912b == this.f18912b;
        }

        public int hashCode() {
            return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f18912b).hashCode();
        }

        private c(b0<?> b0Var, boolean z) {
            this.a = b0Var;
            this.f18912b = z;
        }
    }

    static void a(List<n<?>> list) {
        Set<b> setC = c(list);
        Set<b> setB = b(setC);
        int i2 = 0;
        while (!setB.isEmpty()) {
            b next = setB.iterator().next();
            setB.remove(next);
            i2++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    setB.add(bVar);
                }
            }
        }
        if (i2 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : setC) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    private static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set<b> c(List<n<?>> list) {
        Set<b> set;
        HashMap map = new HashMap(list.size());
        Iterator<n<?>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (v vVar : bVar.c().e()) {
                            if (vVar.e() && (set = (Set) map.get(new c(vVar.c(), vVar.g()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            n<?> next = it.next();
            b bVar3 = new b(next);
            for (b0<? super Object> b0Var : next.h()) {
                c cVar = new c(b0Var, !next.n());
                if (!map.containsKey(cVar)) {
                    map.put(cVar, new HashSet());
                }
                Set set2 = (Set) map.get(cVar);
                if (!set2.isEmpty() && !cVar.f18912b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", b0Var));
                }
                set2.add(bVar3);
            }
        }
    }
}
