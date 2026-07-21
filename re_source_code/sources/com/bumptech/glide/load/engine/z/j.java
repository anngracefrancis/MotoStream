package com.bumptech.glide.load.engine.z;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: LruArrayPool.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements com.bumptech.glide.load.engine.z.b {
    private final h<a, Object> a = new h<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f9228b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f9229c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.engine.z.a<?>> f9230d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9232f;

    /* JADX INFO: compiled from: LruArrayPool.java */
    private static final class a implements m {
        private final b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<?> f9234c;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.a.c(this);
        }

        void b(int i2, Class<?> cls) {
            this.f9233b = i2;
            this.f9234c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9233b == aVar.f9233b && this.f9234c == aVar.f9234c;
        }

        public int hashCode() {
            int i2 = this.f9233b * 31;
            Class<?> cls = this.f9234c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f9233b + "array=" + this.f9234c + '}';
        }
    }

    /* JADX INFO: compiled from: LruArrayPool.java */
    private static final class b extends d<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.z.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a e(int i2, Class<?> cls) {
            a aVarB = b();
            aVarB.b(i2, cls);
            return aVarB;
        }
    }

    public j(int i2) {
        this.f9231e = i2;
    }

    private void f(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapM = m(cls);
        Integer num = (Integer) navigableMapM.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapM.remove(Integer.valueOf(i2));
                return;
            } else {
                navigableMapM.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    private void g() {
        h(this.f9231e);
    }

    private void h(int i2) {
        while (this.f9232f > i2) {
            Object objF = this.a.f();
            com.bumptech.glide.r.j.d(objF);
            com.bumptech.glide.load.engine.z.a aVarI = i(objF);
            this.f9232f -= aVarI.b(objF) * aVarI.a();
            f(aVarI.b(objF), objF.getClass());
            if (Log.isLoggable(aVarI.getTag(), 2)) {
                Log.v(aVarI.getTag(), "evicted: " + aVarI.b(objF));
            }
        }
    }

    private <T> com.bumptech.glide.load.engine.z.a<T> i(T t) {
        return j(t.getClass());
    }

    private <T> com.bumptech.glide.load.engine.z.a<T> j(Class<T> cls) {
        com.bumptech.glide.load.engine.z.a<T> gVar = (com.bumptech.glide.load.engine.z.a) this.f9230d.get(cls);
        if (gVar == null) {
            if (cls.equals(int[].class)) {
                gVar = new i();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                gVar = new g();
            }
            this.f9230d.put(cls, gVar);
        }
        return gVar;
    }

    private <T> T k(a aVar) {
        return (T) this.a.a(aVar);
    }

    private <T> T l(a aVar, Class<T> cls) {
        com.bumptech.glide.load.engine.z.a<T> aVarJ = j(cls);
        T t = (T) k(aVar);
        if (t != null) {
            this.f9232f -= aVarJ.b(t) * aVarJ.a();
            f(aVarJ.b(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(aVarJ.getTag(), 2)) {
            Log.v(aVarJ.getTag(), "Allocated " + aVar.f9233b + " bytes");
        }
        return aVarJ.newArray(aVar.f9233b);
    }

    private NavigableMap<Integer, Integer> m(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f9229c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f9229c.put(cls, treeMap);
        return treeMap;
    }

    private boolean n() {
        int i2 = this.f9232f;
        return i2 == 0 || this.f9231e / i2 >= 2;
    }

    private boolean o(int i2) {
        return i2 <= this.f9231e / 2;
    }

    private boolean p(int i2, Integer num) {
        return num != null && (n() || num.intValue() <= i2 * 8);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized void a(int i2) {
        try {
            if (i2 >= 40) {
                b();
            } else if (i2 >= 20 || i2 == 15) {
                h(this.f9231e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized void b() {
        h(0);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> T c(int i2, Class<T> cls) {
        return (T) l(this.f9228b.e(i2, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> void d(T t) {
        Class<?> cls = t.getClass();
        com.bumptech.glide.load.engine.z.a<T> aVarJ = j(cls);
        int iB = aVarJ.b(t);
        int iA = aVarJ.a() * iB;
        if (o(iA)) {
            a aVarE = this.f9228b.e(iB, cls);
            this.a.d(aVarE, t);
            NavigableMap<Integer, Integer> navigableMapM = m(cls);
            Integer num = (Integer) navigableMapM.get(Integer.valueOf(aVarE.f9233b));
            Integer numValueOf = Integer.valueOf(aVarE.f9233b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapM.put(numValueOf, Integer.valueOf(iIntValue));
            this.f9232f += iA;
            g();
        }
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> T e(int i2, Class<T> cls) {
        Integer numCeilingKey;
        numCeilingKey = m(cls).ceilingKey(Integer.valueOf(i2));
        return (T) l(p(i2, numCeilingKey) ? this.f9228b.e(numCeilingKey.intValue(), cls) : this.f9228b.e(i2, cls), cls);
    }
}
