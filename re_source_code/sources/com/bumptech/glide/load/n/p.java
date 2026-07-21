package com.bumptech.glide.load.n;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ModelLoaderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class p {
    private final r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f9327b;

    /* JADX INFO: compiled from: ModelLoaderRegistry.java */
    private static class a {
        private final Map<Class<?>, C0135a<?>> a = new HashMap();

        /* JADX INFO: renamed from: com.bumptech.glide.load.n.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ModelLoaderRegistry.java */
        private static class C0135a<Model> {
            final List<n<Model, ?>> a;

            public C0135a(List<n<Model, ?>> list) {
                this.a = list;
            }
        }

        a() {
        }

        public void a() {
            this.a.clear();
        }

        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0135a<?> c0135a = this.a.get(cls);
            if (c0135a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c0135a.a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.a.put(cls, new C0135a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(c.i.j.f<List<Throwable>> fVar) {
        this(new r(fVar));
    }

    private static <A> Class<A> b(A a2) {
        return (Class<A>) a2.getClass();
    }

    private synchronized <A> List<n<A, ?>> e(Class<A> cls) {
        List<n<A, ?>> listB;
        listB = this.f9327b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.a.e(cls));
            this.f9327b.c(cls, listB);
        }
        return listB;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.a.b(cls, cls2, oVar);
        this.f9327b.a();
    }

    public synchronized List<Class<?>> c(Class<?> cls) {
        return this.a.g(cls);
    }

    public <A> List<n<A, ?>> d(A a2) {
        List<n<A, ?>> listE = e(b(a2));
        int size = listE.size();
        List<n<A, ?>> listEmptyList = Collections.emptyList();
        boolean z = true;
        for (int i2 = 0; i2 < size; i2++) {
            n<A, ?> nVar = listE.get(i2);
            if (nVar.a(a2)) {
                if (z) {
                    listEmptyList = new ArrayList<>(size - i2);
                    z = false;
                }
                listEmptyList.add(nVar);
            }
        }
        return listEmptyList;
    }

    private p(r rVar) {
        this.f9327b = new a();
        this.a = rVar;
    }
}
