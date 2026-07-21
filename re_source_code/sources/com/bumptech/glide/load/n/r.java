package com.bumptech.glide.load.n;

import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: MultiModelLoaderFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class r {
    private static final c a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final n<Object, Object> f9335b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b<?, ?>> f9336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f9337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<b<?, ?>> f9338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c.i.j.f<List<Throwable>> f9339f;

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.n.n
        public boolean a(Object obj) {
            return false;
        }

        @Override // com.bumptech.glide.load.n.n
        public n.a<Object> b(Object obj, int i2, int i3, com.bumptech.glide.load.i iVar) {
            return null;
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class b<Model, Data> {
        private final Class<Model> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<Data> f9340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final o<? extends Model, ? extends Data> f9341c;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.a = cls;
            this.f9340b = cls2;
            this.f9341c = oVar;
        }

        public boolean a(Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }

        public boolean b(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f9340b.isAssignableFrom(cls2);
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    static class c {
        c() {
        }

        public <Model, Data> q<Model, Data> a(List<n<Model, Data>> list, c.i.j.f<List<Throwable>> fVar) {
            return new q<>(list, fVar);
        }
    }

    public r(c.i.j.f<List<Throwable>> fVar) {
        this(fVar, a);
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f9336c;
        list.add(z ? list.size() : 0, bVar);
    }

    private <Model, Data> n<Model, Data> c(b<?, ?> bVar) {
        return (n) com.bumptech.glide.r.j.d(bVar.f9341c.b(this));
    }

    private static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>) f9335b;
    }

    synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    public synchronized <Model, Data> n<Model, Data> d(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.f9336c) {
                if (this.f9338e.contains(bVar)) {
                    z = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f9338e.add(bVar);
                    arrayList.add(c(bVar));
                    this.f9338e.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f9337d.a(arrayList, this.f9339f);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (!z) {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
            return f();
        } catch (Throwable th) {
            this.f9338e.clear();
            throw th;
        }
    }

    synchronized <Model> List<n<Model, ?>> e(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f9336c) {
                if (!this.f9338e.contains(bVar) && bVar.a(cls)) {
                    this.f9338e.add(bVar);
                    arrayList.add(c(bVar));
                    this.f9338e.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f9338e.clear();
            throw th;
        }
        return arrayList;
    }

    synchronized List<Class<?>> g(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f9336c) {
            if (!arrayList.contains(bVar.f9340b) && bVar.a(cls)) {
                arrayList.add(bVar.f9340b);
            }
        }
        return arrayList;
    }

    r(c.i.j.f<List<Throwable>> fVar, c cVar) {
        this.f9336c = new ArrayList();
        this.f9338e = new HashSet();
        this.f9339f = fVar;
        this.f9337d = cVar;
    }
}
