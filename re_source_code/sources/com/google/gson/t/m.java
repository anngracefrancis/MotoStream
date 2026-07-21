package com.google.gson.t;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    static class a extends m {
        final /* synthetic */ Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f20226b;

        a(Method method, Object obj) {
            this.a = method;
            this.f20226b = obj;
        }

        @Override // com.google.gson.t.m
        public <T> T c(Class<T> cls) throws Exception {
            m.a(cls);
            return (T) this.a.invoke(this.f20226b, cls);
        }
    }

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    static class b extends m {
        final /* synthetic */ Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f20227b;

        b(Method method, int i2) {
            this.a = method;
            this.f20227b = i2;
        }

        @Override // com.google.gson.t.m
        public <T> T c(Class<T> cls) throws Exception {
            m.a(cls);
            return (T) this.a.invoke(null, cls, Integer.valueOf(this.f20227b));
        }
    }

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    static class c extends m {
        final /* synthetic */ Method a;

        c(Method method) {
            this.a = method;
        }

        @Override // com.google.gson.t.m
        public <T> T c(Class<T> cls) throws Exception {
            m.a(cls);
            return (T) this.a.invoke(null, cls, Object.class);
        }
    }

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    static class d extends m {
        d() {
        }

        @Override // com.google.gson.t.m
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static m b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    return new d();
                }
            } catch (Exception unused3) {
                Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new c(declaredMethod3);
            }
        }
    }

    public abstract <T> T c(Class<T> cls) throws Exception;
}
