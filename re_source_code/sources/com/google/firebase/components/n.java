package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: Component.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n<T> {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<b0<? super T>> f18886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<v> f18887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f18888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f18889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final r<T> f18890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<Class<?>> f18891g;

    public static <T> b<T> a(b0<T> b0Var) {
        return new b<>(b0Var, new b0[0]);
    }

    @SafeVarargs
    public static <T> b<T> b(b0<T> b0Var, b0<? super T>... b0VarArr) {
        return new b<>(b0Var, b0VarArr);
    }

    public static <T> b<T> c(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> b<T> d(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    public static <T> n<T> j(final T t, Class<T> cls) {
        return k(cls).f(new r() { // from class: com.google.firebase.components.a
            @Override // com.google.firebase.components.r
            public final Object a(p pVar) {
                Object obj = t;
                n.o(obj, pVar);
                return obj;
            }
        }).d();
    }

    public static <T> b<T> k(Class<T> cls) {
        return c(cls).g();
    }

    static /* synthetic */ Object o(Object obj, p pVar) {
        return obj;
    }

    static /* synthetic */ Object p(Object obj, p pVar) {
        return obj;
    }

    @SafeVarargs
    public static <T> n<T> q(final T t, Class<T> cls, Class<? super T>... clsArr) {
        return d(cls, clsArr).f(new r() { // from class: com.google.firebase.components.b
            @Override // com.google.firebase.components.r
            public final Object a(p pVar) {
                Object obj = t;
                n.p(obj, pVar);
                return obj;
            }
        }).d();
    }

    public Set<v> e() {
        return this.f18887c;
    }

    public r<T> f() {
        return this.f18890f;
    }

    public String g() {
        return this.a;
    }

    public Set<b0<? super T>> h() {
        return this.f18886b;
    }

    public Set<Class<?>> i() {
        return this.f18891g;
    }

    public boolean l() {
        return this.f18888d == 1;
    }

    public boolean m() {
        return this.f18888d == 2;
    }

    public boolean n() {
        return this.f18889e == 0;
    }

    public n<T> r(r<T> rVar) {
        return new n<>(this.a, this.f18886b, this.f18887c, this.f18888d, this.f18889e, rVar, this.f18891g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f18886b.toArray()) + ">{" + this.f18888d + ", type=" + this.f18889e + ", deps=" + Arrays.toString(this.f18887c.toArray()) + "}";
    }

    /* JADX INFO: compiled from: Component.java */
    public static class b<T> {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<b0<? super T>> f18892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<v> f18893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f18894d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f18895e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private r<T> f18896f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Set<Class<?>> f18897g;

        /* JADX INFO: Access modifiers changed from: private */
        public b<T> g() {
            this.f18895e = 1;
            return this;
        }

        private b<T> i(int i2) {
            a0.d(this.f18894d == 0, "Instantiation type has already been set.");
            this.f18894d = i2;
            return this;
        }

        private void j(b0<?> b0Var) {
            a0.a(!this.f18892b.contains(b0Var), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b<T> b(v vVar) {
            a0.c(vVar, "Null dependency");
            j(vVar.c());
            this.f18893c.add(vVar);
            return this;
        }

        public b<T> c() {
            return i(1);
        }

        public n<T> d() {
            a0.d(this.f18896f != null, "Missing required property: factory.");
            return new n<>(this.a, new HashSet(this.f18892b), new HashSet(this.f18893c), this.f18894d, this.f18895e, this.f18896f, this.f18897g);
        }

        public b<T> e() {
            return i(2);
        }

        public b<T> f(r<T> rVar) {
            this.f18896f = (r) a0.c(rVar, "Null factory");
            return this;
        }

        public b<T> h(String str) {
            this.a = str;
            return this;
        }

        @SafeVarargs
        private b(Class<T> cls, Class<? super T>... clsArr) {
            this.a = null;
            HashSet hashSet = new HashSet();
            this.f18892b = hashSet;
            this.f18893c = new HashSet();
            this.f18894d = 0;
            this.f18895e = 0;
            this.f18897g = new HashSet();
            a0.c(cls, "Null interface");
            hashSet.add(b0.b(cls));
            for (Class<? super T> cls2 : clsArr) {
                a0.c(cls2, "Null interface");
                this.f18892b.add(b0.b(cls2));
            }
        }

        @SafeVarargs
        private b(b0<T> b0Var, b0<? super T>... b0VarArr) {
            this.a = null;
            HashSet hashSet = new HashSet();
            this.f18892b = hashSet;
            this.f18893c = new HashSet();
            this.f18894d = 0;
            this.f18895e = 0;
            this.f18897g = new HashSet();
            a0.c(b0Var, "Null interface");
            hashSet.add(b0Var);
            for (b0<? super T> b0Var2 : b0VarArr) {
                a0.c(b0Var2, "Null interface");
            }
            Collections.addAll(this.f18892b, b0VarArr);
        }
    }

    private n(String str, Set<b0<? super T>> set, Set<v> set2, int i2, int i3, r<T> rVar, Set<Class<?>> set3) {
        this.a = str;
        this.f18886b = Collections.unmodifiableSet(set);
        this.f18887c = Collections.unmodifiableSet(set2);
        this.f18888d = i2;
        this.f18889e = i3;
        this.f18890f = rVar;
        this.f18891g = Collections.unmodifiableSet(set3);
    }
}
