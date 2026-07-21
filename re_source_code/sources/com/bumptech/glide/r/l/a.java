package com.bumptech.glide.r.l;

import android.util.Log;
import c.i.j.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FactoryPools.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final g<Object> a = new C0143a();

    /* JADX INFO: renamed from: com.bumptech.glide.r.l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FactoryPools.java */
    class C0143a implements g<Object> {
        C0143a() {
        }

        @Override // com.bumptech.glide.r.l.a.g
        public void a(Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: FactoryPools.java */
    class b<T> implements d<List<T>> {
        b() {
        }

        @Override // com.bumptech.glide.r.l.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: FactoryPools.java */
    class c<T> implements g<List<T>> {
        c() {
        }

        @Override // com.bumptech.glide.r.l.a.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List<T> list) {
            list.clear();
        }
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface d<T> {
        T a();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    private static final class e<T> implements c.i.j.f<T> {
        private final d<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g<T> f9557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final c.i.j.f<T> f9558c;

        e(c.i.j.f<T> fVar, d<T> dVar, g<T> gVar) {
            this.f9558c = fVar;
            this.a = dVar;
            this.f9557b = gVar;
        }

        @Override // c.i.j.f
        public boolean a(T t) {
            if (t instanceof f) {
                ((f) t).u().b(true);
            }
            this.f9557b.a(t);
            return this.f9558c.a(t);
        }

        @Override // c.i.j.f
        public T b() {
            T tB = this.f9558c.b();
            if (tB == null) {
                tB = this.a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + tB.getClass());
                }
            }
            if (tB instanceof f) {
                ((f) tB).u().b(false);
            }
            return tB;
        }
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface f {
        com.bumptech.glide.r.l.c u();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface g<T> {
        void a(T t);
    }

    private static <T extends f> c.i.j.f<T> a(c.i.j.f<T> fVar, d<T> dVar) {
        return b(fVar, dVar, c());
    }

    private static <T> c.i.j.f<T> b(c.i.j.f<T> fVar, d<T> dVar, g<T> gVar) {
        return new e(fVar, dVar, gVar);
    }

    private static <T> g<T> c() {
        return (g<T>) a;
    }

    public static <T extends f> c.i.j.f<T> d(int i2, d<T> dVar) {
        return a(new h(i2), dVar);
    }

    public static <T> c.i.j.f<List<T>> e() {
        return f(20);
    }

    public static <T> c.i.j.f<List<T>> f(int i2) {
        return b(new h(i2), new b(), new c());
    }
}
