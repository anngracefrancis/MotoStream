package com.squareup.moshi;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ClassFactory.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class b<T> {

    /* JADX INFO: compiled from: ClassFactory.java */
    class a extends b<T> {
        final /* synthetic */ Constructor a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f20539b;

        a(Constructor constructor, Class cls) {
            this.a = constructor;
            this.f20539b = cls;
        }

        @Override // com.squareup.moshi.b
        public T b() throws IllegalAccessException, InstantiationException, InvocationTargetException {
            return (T) this.a.newInstance(null);
        }

        public String toString() {
            return this.f20539b.getName();
        }
    }

    /* JADX INFO: renamed from: com.squareup.moshi.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClassFactory.java */
    class C0249b extends b<T> {
        final /* synthetic */ Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f20540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f20541c;

        C0249b(Method method, Object obj, Class cls) {
            this.a = method;
            this.f20540b = obj;
            this.f20541c = cls;
        }

        @Override // com.squareup.moshi.b
        public T b() throws IllegalAccessException, InvocationTargetException {
            return (T) this.a.invoke(this.f20540b, this.f20541c);
        }

        public String toString() {
            return this.f20541c.getName();
        }
    }

    /* JADX INFO: compiled from: ClassFactory.java */
    class c extends b<T> {
        final /* synthetic */ Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f20542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f20543c;

        c(Method method, Class cls, int i2) {
            this.a = method;
            this.f20542b = cls;
            this.f20543c = i2;
        }

        @Override // com.squareup.moshi.b
        public T b() throws IllegalAccessException, InvocationTargetException {
            return (T) this.a.invoke(null, this.f20542b, Integer.valueOf(this.f20543c));
        }

        public String toString() {
            return this.f20542b.getName();
        }
    }

    /* JADX INFO: compiled from: ClassFactory.java */
    class d extends b<T> {
        final /* synthetic */ Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f20544b;

        d(Method method, Class cls) {
            this.a = method;
            this.f20544b = cls;
        }

        @Override // com.squareup.moshi.b
        public T b() throws IllegalAccessException, InvocationTargetException {
            return (T) this.a.invoke(null, this.f20544b, Object.class);
        }

        public String toString() {
            return this.f20544b.getName();
        }
    }

    b() {
    }

    public static <T> b<T> a(Class<?> cls) {
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return new a(declaredConstructor, cls);
        } catch (NoSuchMethodException unused) {
            try {
                Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                Field declaredField = cls2.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                return new C0249b(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null), cls);
            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused2) {
                try {
                    try {
                        Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                        declaredMethod.setAccessible(true);
                        int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                        Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                        declaredMethod2.setAccessible(true);
                        return new c(declaredMethod2, cls, iIntValue);
                    } catch (Exception unused3) {
                        throw new IllegalArgumentException("cannot construct instances of " + cls.getName());
                    }
                } catch (IllegalAccessException unused4) {
                    throw new AssertionError();
                } catch (NoSuchMethodException unused5) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new d(declaredMethod3, cls);
                } catch (InvocationTargetException e2) {
                    throw com.squareup.moshi.w.c.s(e2);
                }
            } catch (IllegalAccessException unused6) {
                throw new AssertionError();
            }
        }
    }

    abstract T b() throws IllegalAccessException, InstantiationException, InvocationTargetException;
}
