package com.google.gson.t.o;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: UnsafeReflectionAccessor.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class f20288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f20289c = d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Field f20290d = c();

    c() {
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Object d() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f20288b = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.gson.t.o.b
    public void b(AccessibleObject accessibleObject) {
        if (e(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e2) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
        }
    }

    boolean e(AccessibleObject accessibleObject) {
        if (this.f20289c != null && this.f20290d != null) {
            try {
                f20288b.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f20289c, accessibleObject, Long.valueOf(((Long) f20288b.getMethod("objectFieldOffset", Field.class).invoke(this.f20289c, this.f20290d)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
