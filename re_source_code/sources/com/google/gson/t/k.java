package com.google.gson.t;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Primitives.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    private static final Map<Class<?>, Class<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f20222b;

    static {
        HashMap map = new HashMap(16);
        HashMap map2 = new HashMap(16);
        a(map, map2, Boolean.TYPE, Boolean.class);
        a(map, map2, Byte.TYPE, Byte.class);
        a(map, map2, Character.TYPE, Character.class);
        a(map, map2, Double.TYPE, Double.class);
        a(map, map2, Float.TYPE, Float.class);
        a(map, map2, Integer.TYPE, Integer.class);
        a(map, map2, Long.TYPE, Long.class);
        a(map, map2, Short.TYPE, Short.class);
        a(map, map2, Void.TYPE, Void.class);
        a = Collections.unmodifiableMap(map);
        f20222b = Collections.unmodifiableMap(map2);
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean b(Type type) {
        return a.containsKey(type);
    }
}
