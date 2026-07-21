package com.squareup.moshi;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Moshi.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r {
    static final List<f.e> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<f.e> f20603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadLocal<c> f20605d = new ThreadLocal<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Object, f<?>> f20606e = new LinkedHashMap();

    /* JADX INFO: compiled from: Moshi.java */
    public static final class a {
        final List<f.e> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f20607b = 0;

        public a a(f.e eVar) {
            if (eVar == null) {
                throw new IllegalArgumentException("factory == null");
            }
            List<f.e> list = this.a;
            int i2 = this.f20607b;
            this.f20607b = i2 + 1;
            list.add(i2, eVar);
            return this;
        }

        public r b() {
            return new r(this);
        }
    }

    /* JADX INFO: compiled from: Moshi.java */
    static final class b<T> extends f<T> {
        final Type a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f20608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object f20609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        f<T> f20610d;

        b(Type type, String str, Object obj) {
            this.a = type;
            this.f20608b = str;
            this.f20609c = obj;
        }

        @Override // com.squareup.moshi.f
        public T fromJson(i iVar) throws IOException {
            f<T> fVar = this.f20610d;
            if (fVar != null) {
                return fVar.fromJson(iVar);
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        @Override // com.squareup.moshi.f
        public void toJson(o oVar, T t) throws IOException {
            f<T> fVar = this.f20610d;
            if (fVar == null) {
                throw new IllegalStateException("JsonAdapter isn't ready");
            }
            fVar.toJson(oVar, t);
        }

        public String toString() {
            f<T> fVar = this.f20610d;
            return fVar != null ? fVar.toString() : super.toString();
        }
    }

    /* JADX INFO: compiled from: Moshi.java */
    final class c {
        final List<b<?>> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Deque<b<?>> f20611b = new ArrayDeque();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f20612c;

        c() {
        }

        <T> void a(f<T> fVar) {
            this.f20611b.getLast().f20610d = fVar;
        }

        IllegalArgumentException b(IllegalArgumentException illegalArgumentException) {
            if (this.f20612c) {
                return illegalArgumentException;
            }
            this.f20612c = true;
            if (this.f20611b.size() == 1 && this.f20611b.getFirst().f20608b == null) {
                return illegalArgumentException;
            }
            StringBuilder sb = new StringBuilder(illegalArgumentException.getMessage());
            Iterator<b<?>> itDescendingIterator = this.f20611b.descendingIterator();
            while (itDescendingIterator.hasNext()) {
                b<?> next = itDescendingIterator.next();
                sb.append("\nfor ");
                sb.append(next.a);
                if (next.f20608b != null) {
                    sb.append(' ');
                    sb.append(next.f20608b);
                }
            }
            return new IllegalArgumentException(sb.toString(), illegalArgumentException);
        }

        void c(boolean z) {
            this.f20611b.removeLast();
            if (this.f20611b.isEmpty()) {
                r.this.f20605d.remove();
                if (z) {
                    synchronized (r.this.f20606e) {
                        int size = this.a.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            b<?> bVar = this.a.get(i2);
                            f<T> fVar = (f) r.this.f20606e.put(bVar.f20609c, bVar.f20610d);
                            if (fVar != 0) {
                                bVar.f20610d = fVar;
                                r.this.f20606e.put(bVar.f20609c, fVar);
                            }
                        }
                    }
                }
            }
        }

        <T> f<T> d(Type type, String str, Object obj) {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                b<?> bVar = this.a.get(i2);
                if (bVar.f20609c.equals(obj)) {
                    this.f20611b.add(bVar);
                    f<T> fVar = (f<T>) bVar.f20610d;
                    return fVar != null ? fVar : bVar;
                }
            }
            b<?> bVar2 = new b<>(type, str, obj);
            this.a.add(bVar2);
            this.f20611b.add(bVar2);
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(5);
        a = arrayList;
        arrayList.add(t.a);
        arrayList.add(d.a);
        arrayList.add(q.a);
        arrayList.add(com.squareup.moshi.a.a);
        arrayList.add(s.a);
        arrayList.add(com.squareup.moshi.c.a);
    }

    r(a aVar) {
        int size = aVar.a.size();
        List<f.e> list = a;
        ArrayList arrayList = new ArrayList(size + list.size());
        arrayList.addAll(aVar.a);
        arrayList.addAll(list);
        this.f20603b = Collections.unmodifiableList(arrayList);
        this.f20604c = aVar.f20607b;
    }

    private Object g(Type type, Set<? extends Annotation> set) {
        return set.isEmpty() ? type : Arrays.asList(type, set);
    }

    public <T> f<T> c(Class<T> cls) {
        return e(cls, com.squareup.moshi.w.c.a);
    }

    public <T> f<T> d(Type type) {
        return e(type, com.squareup.moshi.w.c.a);
    }

    public <T> f<T> e(Type type, Set<? extends Annotation> set) {
        return f(type, set, null);
    }

    public <T> f<T> f(Type type, Set<? extends Annotation> set, String str) {
        if (type == null) {
            throw new NullPointerException("type == null");
        }
        if (set == null) {
            throw new NullPointerException("annotations == null");
        }
        Type typeO = com.squareup.moshi.w.c.o(com.squareup.moshi.w.c.a(type));
        Object objG = g(typeO, set);
        synchronized (this.f20606e) {
            f<T> fVar = (f) this.f20606e.get(objG);
            if (fVar != null) {
                return fVar;
            }
            c cVar = this.f20605d.get();
            if (cVar == null) {
                cVar = new c();
                this.f20605d.set(cVar);
            }
            f<T> fVarD = cVar.d(typeO, str, objG);
            try {
                if (fVarD != null) {
                    cVar.c(false);
                    return fVarD;
                }
                try {
                    int size = this.f20603b.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        f<T> fVar2 = (f<T>) this.f20603b.get(i2).a(typeO, set, this);
                        if (fVar2 != null) {
                            cVar.a(fVar2);
                            cVar.c(true);
                            return fVar2;
                        }
                    }
                    throw new IllegalArgumentException("No JsonAdapter for " + com.squareup.moshi.w.c.t(typeO, set));
                } catch (IllegalArgumentException e2) {
                    throw cVar.b(e2);
                }
            } catch (Throwable th) {
                cVar.c(false);
                throw th;
            }
        }
    }
}
