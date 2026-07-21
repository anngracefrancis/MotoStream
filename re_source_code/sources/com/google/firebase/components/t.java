package com.google.firebase.components;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ComponentRuntime.java */
/* JADX INFO: loaded from: classes2.dex */
public class t implements p, com.google.firebase.p.a {
    private static final com.google.firebase.s.b<Set<Object>> a = new com.google.firebase.s.b() { // from class: com.google.firebase.components.i
        @Override // com.google.firebase.s.b
        public final Object get() {
            return Collections.emptySet();
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<n<?>, com.google.firebase.s.b<?>> f18899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<b0<?>, com.google.firebase.s.b<?>> f18900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<b0<?>, y<?>> f18901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<com.google.firebase.s.b<ComponentRegistrar>> f18902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Set<String> f18903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final w f18904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicReference<Boolean> f18905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final s f18906i;

    /* JADX INFO: compiled from: ComponentRuntime.java */
    public static final class b {
        private final Executor a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<com.google.firebase.s.b<ComponentRegistrar>> f18907b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<n<?>> f18908c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private s f18909d = s.a;

        b(Executor executor) {
            this.a = executor;
        }

        static /* synthetic */ ComponentRegistrar e(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public b a(n<?> nVar) {
            this.f18908c.add(nVar);
            return this;
        }

        public b b(final ComponentRegistrar componentRegistrar) {
            this.f18907b.add(new com.google.firebase.s.b() { // from class: com.google.firebase.components.e
                @Override // com.google.firebase.s.b
                public final Object get() {
                    ComponentRegistrar componentRegistrar2 = componentRegistrar;
                    t.b.e(componentRegistrar2);
                    return componentRegistrar2;
                }
            });
            return this;
        }

        public b c(Collection<com.google.firebase.s.b<ComponentRegistrar>> collection) {
            this.f18907b.addAll(collection);
            return this;
        }

        public t d() {
            return new t(this.a, this.f18907b, this.f18908c, this.f18909d);
        }

        public b f(s sVar) {
            this.f18909d = sVar;
            return this;
        }
    }

    public static b j(Executor executor) {
        return new b(executor);
    }

    private void k(List<n<?>> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<com.google.firebase.s.b<ComponentRegistrar>> it = this.f18902e.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f18906i.a(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException e2) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e2);
                }
            }
            Iterator<n<?>> it2 = list.iterator();
            while (it2.hasNext()) {
                for (Object obj : it2.next().h().toArray()) {
                    if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                        if (this.f18903f.contains(obj.toString())) {
                            it2.remove();
                            break;
                        }
                        this.f18903f.add(obj.toString());
                    }
                }
            }
            if (this.f18899b.isEmpty()) {
                u.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f18899b.keySet());
                arrayList2.addAll(list);
                u.a(arrayList2);
            }
            for (final n<?> nVar : list) {
                this.f18899b.put(nVar, new x(new com.google.firebase.s.b() { // from class: com.google.firebase.components.d
                    @Override // com.google.firebase.s.b
                    public final Object get() {
                        return this.a.p(nVar);
                    }
                }));
            }
            arrayList.addAll(u(list));
            arrayList.addAll(v());
            t();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((Runnable) it3.next()).run();
        }
        s();
    }

    private void l(Map<n<?>, com.google.firebase.s.b<?>> map, boolean z) {
        for (Map.Entry<n<?>, com.google.firebase.s.b<?>> entry : map.entrySet()) {
            n<?> key = entry.getKey();
            com.google.firebase.s.b<?> value = entry.getValue();
            if (key.l() || (key.m() && z)) {
                value.get();
            }
        }
        this.f18904g.c();
    }

    private static <T> List<T> n(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Object p(n nVar) {
        return nVar.f().a(new c0(nVar, this));
    }

    private void s() {
        Boolean bool = this.f18905h.get();
        if (bool != null) {
            l(this.f18899b, bool.booleanValue());
        }
    }

    private void t() {
        for (n<?> nVar : this.f18899b.keySet()) {
            for (v vVar : nVar.e()) {
                if (vVar.g() && !this.f18901d.containsKey(vVar.c())) {
                    this.f18901d.put(vVar.c(), y.b(Collections.emptySet()));
                } else if (this.f18900c.containsKey(vVar.c())) {
                    continue;
                } else {
                    if (vVar.f()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", nVar, vVar.c()));
                    }
                    if (!vVar.g()) {
                        this.f18900c.put(vVar.c(), z.b());
                    }
                }
            }
        }
    }

    private List<Runnable> u(List<n<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (n<?> nVar : list) {
            if (nVar.n()) {
                final com.google.firebase.s.b<?> bVar = this.f18899b.get(nVar);
                for (b0<? super Object> b0Var : nVar.h()) {
                    if (this.f18900c.containsKey(b0Var)) {
                        final z zVar = (z) this.f18900c.get(b0Var);
                        arrayList.add(new Runnable() { // from class: com.google.firebase.components.g
                            @Override // java.lang.Runnable
                            public final void run() {
                                zVar.g(bVar);
                            }
                        });
                    } else {
                        this.f18900c.put(b0Var, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> v() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry<n<?>, com.google.firebase.s.b<?>> entry : this.f18899b.entrySet()) {
            n<?> key = entry.getKey();
            if (!key.n()) {
                com.google.firebase.s.b<?> value = entry.getValue();
                for (b0<? super Object> b0Var : key.h()) {
                    if (!map.containsKey(b0Var)) {
                        map.put(b0Var, new HashSet());
                    }
                    ((Set) map.get(b0Var)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f18901d.containsKey(entry2.getKey())) {
                final y<?> yVar = this.f18901d.get(entry2.getKey());
                for (final com.google.firebase.s.b bVar : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: com.google.firebase.components.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            yVar.a(bVar);
                        }
                    });
                }
            } else {
                this.f18901d.put((b0) entry2.getKey(), y.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    @Override // com.google.firebase.components.p
    public /* synthetic */ Object a(Class cls) {
        return o.b(this, cls);
    }

    @Override // com.google.firebase.components.p
    public synchronized <T> com.google.firebase.s.b<T> b(b0<T> b0Var) {
        a0.c(b0Var, "Null interface requested.");
        return (com.google.firebase.s.b) this.f18900c.get(b0Var);
    }

    @Override // com.google.firebase.components.p
    public /* synthetic */ com.google.firebase.s.b c(Class cls) {
        return o.d(this, cls);
    }

    @Override // com.google.firebase.components.p
    public /* synthetic */ Set d(b0 b0Var) {
        return o.e(this, b0Var);
    }

    @Override // com.google.firebase.components.p
    public synchronized <T> com.google.firebase.s.b<Set<T>> e(b0<T> b0Var) {
        y<?> yVar = this.f18901d.get(b0Var);
        if (yVar != null) {
            return yVar;
        }
        return (com.google.firebase.s.b<Set<T>>) a;
    }

    @Override // com.google.firebase.components.p
    public /* synthetic */ Object f(b0 b0Var) {
        return o.a(this, b0Var);
    }

    @Override // com.google.firebase.components.p
    public /* synthetic */ Set g(Class cls) {
        return o.f(this, cls);
    }

    @Override // com.google.firebase.components.p
    public <T> com.google.firebase.s.a<T> h(b0<T> b0Var) {
        com.google.firebase.s.b<T> bVarB = b(b0Var);
        if (bVarB == null) {
            return z.b();
        }
        return bVarB instanceof z ? (z) bVarB : z.f(bVarB);
    }

    @Override // com.google.firebase.components.p
    public /* synthetic */ com.google.firebase.s.a i(Class cls) {
        return o.c(this, cls);
    }

    public void m(boolean z) {
        HashMap map;
        if (this.f18905h.compareAndSet(null, Boolean.valueOf(z))) {
            synchronized (this) {
                map = new HashMap(this.f18899b);
            }
            l(map, z);
        }
    }

    private t(Executor executor, Iterable<com.google.firebase.s.b<ComponentRegistrar>> iterable, Collection<n<?>> collection, s sVar) {
        this.f18899b = new HashMap();
        this.f18900c = new HashMap();
        this.f18901d = new HashMap();
        this.f18903f = new HashSet();
        this.f18905h = new AtomicReference<>();
        w wVar = new w(executor);
        this.f18904g = wVar;
        this.f18906i = sVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(n.q(wVar, w.class, com.google.firebase.q.d.class, com.google.firebase.q.c.class));
        arrayList.add(n.q(this, com.google.firebase.p.a.class, new Class[0]));
        for (n<?> nVar : collection) {
            if (nVar != null) {
                arrayList.add(nVar);
            }
        }
        this.f18902e = n(iterable);
        k(arrayList);
    }
}
