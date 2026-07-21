package com.airbnb.epoxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: ControllerHelperLookup.java */
/* JADX INFO: loaded from: classes.dex */
class g {
    private static final Map<Class<?>, Constructor<?>> a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final NoOpControllerHelper f8432b = new NoOpControllerHelper();

    private static Constructor<?> a(Class<?> cls) {
        Constructor<?> constructorA;
        Map<Class<?>, Constructor<?>> map = a;
        Constructor<?> constructor = map.get(cls);
        if (constructor != null || map.containsKey(cls)) {
            return constructor;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.")) {
            return null;
        }
        try {
            constructorA = Class.forName(name + "_EpoxyHelper").getConstructor(cls);
        } catch (ClassNotFoundException unused) {
            constructorA = a(cls.getSuperclass());
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Unable to find Epoxy Helper constructor for " + name, e2);
        }
        a.put(cls, constructorA);
        return constructorA;
    }

    static f b(n nVar) {
        Constructor<?> constructorA = a(nVar.getClass());
        if (constructorA == null) {
            return f8432b;
        }
        try {
            return (f) constructorA.newInstance(nVar);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Unable to invoke " + constructorA, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Unable to invoke " + constructorA, e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unable to get Epoxy helper class.", cause);
        }
    }
}
