package com.facebook.o0.o0;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: compiled from: InAppPurchaseUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static final m a = new m();

    private m() {
    }

    public static final Class<?> a(String str) {
        kotlin.jvm.internal.m.f(str, "className");
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final Class<?> b(Context context, String str) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(str, "className");
        try {
            return context.getClassLoader().loadClass(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final Method c(Class<?> cls, String str, Class<?>... clsArr) {
        kotlin.jvm.internal.m.f(cls, "clazz");
        kotlin.jvm.internal.m.f(str, "methodName");
        kotlin.jvm.internal.m.f(clsArr, "args");
        try {
            return cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static final Method d(Class<?> cls, String str, Class<?>... clsArr) {
        kotlin.jvm.internal.m.f(cls, "clazz");
        kotlin.jvm.internal.m.f(str, "methodName");
        kotlin.jvm.internal.m.f(clsArr, "args");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static final Object e(Class<?> cls, Method method, Object obj, Object... objArr) {
        kotlin.jvm.internal.m.f(cls, "clazz");
        kotlin.jvm.internal.m.f(method, "method");
        kotlin.jvm.internal.m.f(objArr, "args");
        if (obj != null) {
            obj = cls.cast(obj);
        }
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }
}
