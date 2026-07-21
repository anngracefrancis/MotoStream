package com.squareup.moshi;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: ClassJsonAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
final class c<T> extends f<T> {
    public static final f.e a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.squareup.moshi.b<T> f20545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b<?>[] f20546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i.a f20547d;

    /* JADX INFO: compiled from: ClassJsonAdapter.java */
    class a implements f.e {
        a() {
        }

        private void b(r rVar, Type type, Map<String, b<?>> map) {
            e eVar;
            Class<?> clsG = u.g(type);
            boolean zI = com.squareup.moshi.w.c.i(clsG);
            for (Field field : clsG.getDeclaredFields()) {
                if (c(zI, field.getModifiers()) && ((eVar = (e) field.getAnnotation(e.class)) == null || !eVar.ignore())) {
                    Type typeP = com.squareup.moshi.w.c.p(type, clsG, field.getGenericType());
                    Set<? extends Annotation> setJ = com.squareup.moshi.w.c.j(field);
                    String name = field.getName();
                    f<T> fVarF = rVar.f(typeP, setJ, name);
                    field.setAccessible(true);
                    String strL = com.squareup.moshi.w.c.l(name, eVar);
                    b<?> bVar = new b<>(strL, field, fVarF);
                    b<?> bVarPut = map.put(strL, bVar);
                    if (bVarPut != null) {
                        throw new IllegalArgumentException("Conflicting fields:\n    " + bVarPut.f20548b + "\n    " + bVar.f20548b);
                    }
                }
            }
        }

        private boolean c(boolean z, int i2) {
            if (Modifier.isStatic(i2) || Modifier.isTransient(i2)) {
                return false;
            }
            return Modifier.isPublic(i2) || Modifier.isProtected(i2) || !z;
        }

        private void d(Type type, Class<?> cls) {
            Class<?> clsG = u.g(type);
            if (cls.isAssignableFrom(clsG)) {
                throw new IllegalArgumentException("No JsonAdapter for " + type + ", you should probably use " + cls.getSimpleName() + " instead of " + clsG.getSimpleName() + " (Moshi only supports the collection interfaces by default) or else register a custom JsonAdapter.");
            }
        }

        @Override // com.squareup.moshi.f.e
        public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
                return null;
            }
            Class<?> clsG = u.g(type);
            if (clsG.isInterface() || clsG.isEnum() || !set.isEmpty()) {
                return null;
            }
            if (com.squareup.moshi.w.c.i(clsG)) {
                d(type, List.class);
                d(type, Set.class);
                d(type, Map.class);
                d(type, Collection.class);
                String str = "Platform " + clsG;
                if (type instanceof ParameterizedType) {
                    str = str + " in " + type;
                }
                throw new IllegalArgumentException(str + " requires explicit JsonAdapter to be registered");
            }
            if (clsG.isAnonymousClass()) {
                throw new IllegalArgumentException("Cannot serialize anonymous class " + clsG.getName());
            }
            if (clsG.isLocalClass()) {
                throw new IllegalArgumentException("Cannot serialize local class " + clsG.getName());
            }
            if (clsG.getEnclosingClass() != null && !Modifier.isStatic(clsG.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize non-static nested class " + clsG.getName());
            }
            if (Modifier.isAbstract(clsG.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize abstract class " + clsG.getName());
            }
            if (com.squareup.moshi.w.c.h(clsG)) {
                throw new IllegalArgumentException("Cannot serialize Kotlin type " + clsG.getName() + ". Reflective serialization of Kotlin classes without using kotlin-reflect has undefined and unexpected behavior. Please use KotlinJsonAdapterFactory from the moshi-kotlin artifact or use code gen from the moshi-kotlin-codegen artifact.");
            }
            com.squareup.moshi.b bVarA = com.squareup.moshi.b.a(clsG);
            TreeMap treeMap = new TreeMap();
            while (type != Object.class) {
                b(rVar, type, treeMap);
                type = u.f(type);
            }
            return new c(bVarA, treeMap).nullSafe();
        }
    }

    /* JADX INFO: compiled from: ClassJsonAdapter.java */
    static class b<T> {
        final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Field f20548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final f<T> f20549c;

        b(String str, Field field, f<T> fVar) {
            this.a = str;
            this.f20548b = field;
            this.f20549c = fVar;
        }

        void a(i iVar, Object obj) throws IllegalAccessException, IOException {
            this.f20548b.set(obj, this.f20549c.fromJson(iVar));
        }

        void b(o oVar, Object obj) throws IllegalAccessException, IOException {
            this.f20549c.toJson(oVar, (T) this.f20548b.get(obj));
        }
    }

    c(com.squareup.moshi.b<T> bVar, Map<String, b<?>> map) {
        this.f20545b = bVar;
        this.f20546c = (b[]) map.values().toArray(new b[map.size()]);
        this.f20547d = i.a.a((String[]) map.keySet().toArray(new String[map.size()]));
    }

    @Override // com.squareup.moshi.f
    public T fromJson(i iVar) throws IOException {
        try {
            T tB = this.f20545b.b();
            try {
                iVar.b();
                while (iVar.f()) {
                    int iH = iVar.H(this.f20547d);
                    if (iH == -1) {
                        iVar.N();
                        iVar.Q();
                    } else {
                        this.f20546c[iH].a(iVar, tB);
                    }
                }
                iVar.d();
                return tB;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw com.squareup.moshi.w.c.s(e3);
        }
    }

    @Override // com.squareup.moshi.f
    public void toJson(o oVar, T t) throws IOException {
        try {
            oVar.b();
            for (b<?> bVar : this.f20546c) {
                oVar.l(bVar.a);
                bVar.b(oVar, t);
            }
            oVar.e();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonAdapter(" + this.f20545b + ")";
    }
}
