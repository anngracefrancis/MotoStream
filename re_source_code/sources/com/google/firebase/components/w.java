package com.google.firebase.components;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: EventBus.java */
/* JADX INFO: loaded from: classes2.dex */
class w implements com.google.firebase.q.d, com.google.firebase.q.c {
    private final Map<Class<?>, ConcurrentHashMap<com.google.firebase.q.b<Object>, Executor>> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue<com.google.firebase.q.a<?>> f18915b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f18916c;

    w(Executor executor) {
        this.f18916c = executor;
    }

    private synchronized Set<Map.Entry<com.google.firebase.q.b<Object>, Executor>> d(com.google.firebase.q.a<?> aVar) {
        ConcurrentHashMap<com.google.firebase.q.b<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.a.get(aVar.b());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    @Override // com.google.firebase.q.d
    public <T> void a(Class<T> cls, com.google.firebase.q.b<? super T> bVar) {
        b(cls, this.f18916c, bVar);
    }

    @Override // com.google.firebase.q.d
    public synchronized <T> void b(Class<T> cls, Executor executor, com.google.firebase.q.b<? super T> bVar) {
        a0.b(cls);
        a0.b(bVar);
        a0.b(executor);
        if (!this.a.containsKey(cls)) {
            this.a.put(cls, new ConcurrentHashMap<>());
        }
        this.a.get(cls).put(bVar, executor);
    }

    void c() {
        Queue<com.google.firebase.q.a<?>> queue;
        synchronized (this) {
            queue = this.f18915b;
            if (queue != null) {
                this.f18915b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            Iterator<com.google.firebase.q.a<?>> it = queue.iterator();
            while (it.hasNext()) {
                f(it.next());
            }
        }
    }

    public void f(final com.google.firebase.q.a<?> aVar) {
        a0.b(aVar);
        synchronized (this) {
            Queue<com.google.firebase.q.a<?>> queue = this.f18915b;
            if (queue != null) {
                queue.add(aVar);
                return;
            }
            for (final Map.Entry<com.google.firebase.q.b<Object>, Executor> entry : d(aVar)) {
                entry.getValue().execute(new Runnable() { // from class: com.google.firebase.components.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((com.google.firebase.q.b) entry.getKey()).a(aVar);
                    }
                });
            }
        }
    }
}
