package com.bumptech.glide.o;

import com.bumptech.glide.r.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ModelToResourceClassCache.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private final AtomicReference<i> a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.e.a<i, List<Class<?>>> f9479b = new c.e.a<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        i andSet = this.a.getAndSet(null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f9479b) {
            list = this.f9479b.get(andSet);
        }
        this.a.set(andSet);
        return list;
    }

    public void b(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f9479b) {
            this.f9479b.put(new i(cls, cls2, cls3), list);
        }
    }
}
