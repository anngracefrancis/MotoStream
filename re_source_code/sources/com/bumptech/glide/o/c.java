package com.bumptech.glide.o;

import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.o.h.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: LoadPathCache.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final s<?, ?, ?> a = new s<>(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.e.a<com.bumptech.glide.r.i, s<?, ?, ?>> f9477b = new c.e.a<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<com.bumptech.glide.r.i> f9478c = new AtomicReference<>();

    private com.bumptech.glide.r.i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        com.bumptech.glide.r.i andSet = this.f9478c.getAndSet(null);
        if (andSet == null) {
            andSet = new com.bumptech.glide.r.i();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s<Data, TResource, Transcode> sVar;
        com.bumptech.glide.r.i iVarB = b(cls, cls2, cls3);
        synchronized (this.f9477b) {
            sVar = (s) this.f9477b.get(iVarB);
        }
        this.f9478c.set(iVarB);
        return sVar;
    }

    public boolean c(s<?, ?, ?> sVar) {
        return a.equals(sVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, s<?, ?, ?> sVar) {
        synchronized (this.f9477b) {
            c.e.a<com.bumptech.glide.r.i, s<?, ?, ?>> aVar = this.f9477b;
            com.bumptech.glide.r.i iVar = new com.bumptech.glide.r.i(cls, cls2, cls3);
            if (sVar == null) {
                sVar = a;
            }
            aVar.put(iVar, sVar);
        }
    }
}
