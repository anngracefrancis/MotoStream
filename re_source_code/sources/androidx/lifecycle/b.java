package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ClassesInfoCache.java */
/* JADX INFO: loaded from: classes.dex */
final class b {
    static b a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, a> f1745b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, Boolean> f1746c = new HashMap();

    /* JADX INFO: compiled from: ClassesInfoCache.java */
    static class a {
        final Map<g.b, List<C0038b>> a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<C0038b, g.b> f1747b;

        a(Map<C0038b, g.b> map) {
            this.f1747b = map;
            for (Map.Entry<C0038b, g.b> entry : map.entrySet()) {
                g.b value = entry.getValue();
                List<C0038b> arrayList = this.a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        private static void b(List<C0038b> list, k kVar, g.b bVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(kVar, bVar, obj);
                }
            }
        }

        void a(k kVar, g.b bVar, Object obj) {
            b(this.a.get(bVar), kVar, bVar, obj);
            b(this.a.get(g.b.ON_ANY), kVar, bVar, obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClassesInfoCache.java */
    static final class C0038b {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f1748b;

        C0038b(int i2, Method method) {
            this.a = i2;
            this.f1748b = method;
            method.setAccessible(true);
        }

        void a(k kVar, g.b bVar, Object obj) {
            try {
                int i2 = this.a;
                if (i2 == 0) {
                    this.f1748b.invoke(obj, new Object[0]);
                } else if (i2 == 1) {
                    this.f1748b.invoke(obj, kVar);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    this.f1748b.invoke(obj, kVar, bVar);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0038b)) {
                return false;
            }
            C0038b c0038b = (C0038b) obj;
            return this.a == c0038b.a && this.f1748b.getName().equals(c0038b.f1748b.getName());
        }

        public int hashCode() {
            return (this.a * 31) + this.f1748b.getName().hashCode();
        }
    }

    b() {
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i2;
        a aVarC;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f1747b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0038b, g.b> entry : c(cls2).f1747b.entrySet()) {
                e(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            s sVar = (s) method.getAnnotation(s.class);
            if (sVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(k.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i2 = 1;
                }
                g.b bVarValue = sVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(g.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (bVarValue != g.b.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i2 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new C0038b(i2, method), bVarValue, cls);
                z = true;
            }
        }
        a aVar = new a(map);
        this.f1745b.put(cls, aVar);
        this.f1746c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    private void e(Map<C0038b, g.b> map, C0038b c0038b, g.b bVar, Class<?> cls) {
        g.b bVar2 = map.get(c0038b);
        if (bVar2 == null || bVar == bVar2) {
            if (bVar2 == null) {
                map.put(c0038b, bVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0038b.f1748b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar2 + ", new value " + bVar);
    }

    a c(Class<?> cls) {
        a aVar = this.f1745b.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    boolean d(Class<?> cls) {
        Boolean bool = this.f1746c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((s) method.getAnnotation(s.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f1746c.put(cls, Boolean.FALSE);
        return false;
    }
}
