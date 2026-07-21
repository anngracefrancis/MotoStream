package com.bumptech.glide.load.m;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: DataRewinderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final e.a<?> a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f9267b = new HashMap();

    /* JADX INFO: compiled from: DataRewinderRegistry.java */
    class a implements e.a<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.m.e.a
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.m.e.a
        public e<Object> b(Object obj) {
            return new b(obj);
        }
    }

    /* JADX INFO: compiled from: DataRewinderRegistry.java */
    private static final class b implements e<Object> {
        private final Object a;

        b(Object obj) {
            this.a = obj;
        }

        @Override // com.bumptech.glide.load.m.e
        public Object a() {
            return this.a;
        }

        @Override // com.bumptech.glide.load.m.e
        public void b() {
        }
    }

    public synchronized <T> e<T> a(T t) {
        e.a<?> aVar;
        com.bumptech.glide.r.j.d(t);
        aVar = this.f9267b.get(t.getClass());
        if (aVar == null) {
            for (e.a<?> aVar2 : this.f9267b.values()) {
                if (aVar2.a().isAssignableFrom(t.getClass())) {
                    aVar = aVar2;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = a;
        }
        return (e<T>) aVar.b(t);
    }

    public synchronized void b(e.a<?> aVar) {
        this.f9267b.put(aVar.a(), aVar);
    }
}
