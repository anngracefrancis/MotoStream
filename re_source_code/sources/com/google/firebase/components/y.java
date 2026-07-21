package com.google.firebase.components;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: LazySet.java */
/* JADX INFO: loaded from: classes2.dex */
class y<T> implements com.google.firebase.s.b<Set<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Set<T> f18919b = null;
    private volatile Set<com.google.firebase.s.b<T>> a = Collections.newSetFromMap(new ConcurrentHashMap());

    y(Collection<com.google.firebase.s.b<T>> collection) {
        this.a.addAll(collection);
    }

    static y<?> b(Collection<com.google.firebase.s.b<?>> collection) {
        return new y<>((Set) collection);
    }

    private synchronized void d() {
        Iterator<com.google.firebase.s.b<T>> it = this.a.iterator();
        while (it.hasNext()) {
            this.f18919b.add(it.next().get());
        }
        this.a = null;
    }

    synchronized void a(com.google.firebase.s.b<T> bVar) {
        if (this.f18919b == null) {
            this.a.add(bVar);
        } else {
            this.f18919b.add(bVar.get());
        }
    }

    @Override // com.google.firebase.s.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set<T> get() {
        if (this.f18919b == null) {
            synchronized (this) {
                if (this.f18919b == null) {
                    this.f18919b = Collections.newSetFromMap(new ConcurrentHashMap());
                    d();
                }
            }
        }
        return Collections.unmodifiableSet(this.f18919b);
    }
}
