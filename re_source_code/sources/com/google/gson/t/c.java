package com.google.gson.t;

import com.google.gson.JsonIOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private final Map<Type, com.google.gson.f<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.t.o.b f20180b = com.google.gson.t.o.b.a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class a<T> implements com.google.gson.t.i<T> {
        a() {
        }

        @Override // com.google.gson.t.i
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class b<T> implements com.google.gson.t.i<T> {
        b() {
        }

        @Override // com.google.gson.t.i
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.t.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class C0242c<T> implements com.google.gson.t.i<T> {
        C0242c() {
        }

        @Override // com.google.gson.t.i
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class d<T> implements com.google.gson.t.i<T> {
        d() {
        }

        @Override // com.google.gson.t.i
        public T a() {
            return (T) new com.google.gson.t.h();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class e<T> implements com.google.gson.t.i<T> {
        private final com.google.gson.t.m a = com.google.gson.t.m.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f20181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Type f20182c;

        e(Class cls, Type type) {
            this.f20181b = cls;
            this.f20182c = type;
        }

        @Override // com.google.gson.t.i
        public T a() {
            try {
                return (T) this.a.c(this.f20181b);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f20182c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class f<T> implements com.google.gson.t.i<T> {
        final /* synthetic */ com.google.gson.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f20184b;

        f(com.google.gson.f fVar, Type type) {
            this.a = fVar;
            this.f20184b = type;
        }

        @Override // com.google.gson.t.i
        public T a() {
            return (T) this.a.a(this.f20184b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class g<T> implements com.google.gson.t.i<T> {
        final /* synthetic */ com.google.gson.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f20186b;

        g(com.google.gson.f fVar, Type type) {
            this.a = fVar;
            this.f20186b = type;
        }

        @Override // com.google.gson.t.i
        public T a() {
            return (T) this.a.a(this.f20186b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class h<T> implements com.google.gson.t.i<T> {
        final /* synthetic */ Constructor a;

        h(Constructor constructor) {
            this.a = constructor;
        }

        @Override // com.google.gson.t.i
        public T a() {
            try {
                return (T) this.a.newInstance(null);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e4.getTargetException());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class i<T> implements com.google.gson.t.i<T> {
        i() {
        }

        @Override // com.google.gson.t.i
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class j<T> implements com.google.gson.t.i<T> {
        final /* synthetic */ Type a;

        j(Type type) {
            this.a = type;
        }

        @Override // com.google.gson.t.i
        public T a() {
            Type type = this.a;
            if (!(type instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class k<T> implements com.google.gson.t.i<T> {
        k() {
        }

        @Override // com.google.gson.t.i
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class l<T> implements com.google.gson.t.i<T> {
        l() {
        }

        @Override // com.google.gson.t.i
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class m<T> implements com.google.gson.t.i<T> {
        m() {
        }

        @Override // com.google.gson.t.i
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class n<T> implements com.google.gson.t.i<T> {
        n() {
        }

        @Override // com.google.gson.t.i
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    public c(Map<Type, com.google.gson.f<?>> map) {
        this.a = map;
    }

    private <T> com.google.gson.t.i<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f20180b.b(declaredConstructor);
            }
            return new h(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> com.google.gson.t.i<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i();
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new j(type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new k();
            }
            return Queue.class.isAssignableFrom(cls) ? new l() : new m();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new n();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new a();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new b();
        }
        return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(com.google.gson.u.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new d() : new C0242c();
    }

    private <T> com.google.gson.t.i<T> d(Type type, Class<? super T> cls) {
        return new e(cls, type);
    }

    public <T> com.google.gson.t.i<T> a(com.google.gson.u.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        com.google.gson.f<?> fVar = this.a.get(type);
        if (fVar != null) {
            return new f(fVar, type);
        }
        com.google.gson.f<?> fVar2 = this.a.get(rawType);
        if (fVar2 != null) {
            return new g(fVar2, type);
        }
        com.google.gson.t.i<T> iVarB = b(rawType);
        if (iVarB != null) {
            return iVarB;
        }
        com.google.gson.t.i<T> iVarC = c(type, rawType);
        return iVarC != null ? iVarC : d(type, rawType);
    }

    public String toString() {
        return this.a.toString();
    }
}
