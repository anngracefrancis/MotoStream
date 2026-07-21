package com.google.firebase.components;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: RestrictedComponentContainer.java */
/* JADX INFO: loaded from: classes2.dex */
final class c0 implements p {
    private final Set<b0<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<b0<?>> f18870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<b0<?>> f18871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<b0<?>> f18872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<b0<?>> f18873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<Class<?>> f18874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final p f18875g;

    /* JADX INFO: compiled from: RestrictedComponentContainer.java */
    private static class a implements com.google.firebase.q.c {
        private final Set<Class<?>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.firebase.q.c f18876b;

        public a(Set<Class<?>> set, com.google.firebase.q.c cVar) {
            this.a = set;
            this.f18876b = cVar;
        }
    }

    c0(n<?> nVar, p pVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (v vVar : nVar.e()) {
            if (vVar.e()) {
                if (vVar.g()) {
                    hashSet4.add(vVar.c());
                } else {
                    hashSet.add(vVar.c());
                }
            } else if (vVar.d()) {
                hashSet3.add(vVar.c());
            } else if (vVar.g()) {
                hashSet5.add(vVar.c());
            } else {
                hashSet2.add(vVar.c());
            }
        }
        if (!nVar.i().isEmpty()) {
            hashSet.add(b0.b(com.google.firebase.q.c.class));
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.f18870b = Collections.unmodifiableSet(hashSet2);
        this.f18871c = Collections.unmodifiableSet(hashSet3);
        this.f18872d = Collections.unmodifiableSet(hashSet4);
        this.f18873e = Collections.unmodifiableSet(hashSet5);
        this.f18874f = nVar.i();
        this.f18875g = pVar;
    }

    @Override // com.google.firebase.components.p
    public <T> T a(Class<T> cls) {
        if (!this.a.contains(b0.b(cls))) {
            throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t = (T) this.f18875g.a(cls);
        return !cls.equals(com.google.firebase.q.c.class) ? t : (T) new a(this.f18874f, (com.google.firebase.q.c) t);
    }

    @Override // com.google.firebase.components.p
    public <T> com.google.firebase.s.b<T> b(b0<T> b0Var) {
        if (this.f18870b.contains(b0Var)) {
            return this.f18875g.b(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", b0Var));
    }

    @Override // com.google.firebase.components.p
    public <T> com.google.firebase.s.b<T> c(Class<T> cls) {
        return b(b0.b(cls));
    }

    @Override // com.google.firebase.components.p
    public <T> Set<T> d(b0<T> b0Var) {
        if (this.f18872d.contains(b0Var)) {
            return this.f18875g.d(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", b0Var));
    }

    @Override // com.google.firebase.components.p
    public <T> com.google.firebase.s.b<Set<T>> e(b0<T> b0Var) {
        if (this.f18873e.contains(b0Var)) {
            return this.f18875g.e(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", b0Var));
    }

    @Override // com.google.firebase.components.p
    public <T> T f(b0<T> b0Var) {
        if (this.a.contains(b0Var)) {
            return (T) this.f18875g.f(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", b0Var));
    }

    @Override // com.google.firebase.components.p
    public /* synthetic */ Set g(Class cls) {
        return o.f(this, cls);
    }

    @Override // com.google.firebase.components.p
    public <T> com.google.firebase.s.a<T> h(b0<T> b0Var) {
        if (this.f18871c.contains(b0Var)) {
            return this.f18875g.h(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", b0Var));
    }

    @Override // com.google.firebase.components.p
    public <T> com.google.firebase.s.a<T> i(Class<T> cls) {
        return h(b0.b(cls));
    }
}
