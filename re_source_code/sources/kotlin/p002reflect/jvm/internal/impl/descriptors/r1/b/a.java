package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: ReflectJavaRecordComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C0412a f25323b;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.descriptors.r1.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ReflectJavaRecordComponent.kt */
    public static final class C0412a {
        private final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f25324b;

        public C0412a(Method method, Method method2) {
            this.a = method;
            this.f25324b = method2;
        }

        public final Method a() {
            return this.f25324b;
        }

        public final Method b() {
            return this.a;
        }
    }

    private a() {
    }

    private final C0412a a(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new C0412a(cls.getMethod("getType", new Class[0]), cls.getMethod("getAccessor", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new C0412a(null, null);
        }
    }

    private final C0412a b(Object obj) {
        C0412a c0412a = f25323b;
        if (c0412a != null) {
            return c0412a;
        }
        C0412a c0412aA = a(obj);
        f25323b = c0412aA;
        return c0412aA;
    }

    public final Method c(Object obj) throws IllegalAccessException, InvocationTargetException {
        m.f(obj, "recordComponent");
        Method methodA = b(obj).a();
        if (methodA == null) {
            return null;
        }
        Object objInvoke = methodA.invoke(obj, new Object[0]);
        m.d(objInvoke, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) objInvoke;
    }

    public final Class<?> d(Object obj) throws IllegalAccessException, InvocationTargetException {
        m.f(obj, "recordComponent");
        Method methodB = b(obj).b();
        if (methodB == null) {
            return null;
        }
        Object objInvoke = methodB.invoke(obj, new Object[0]);
        m.d(objInvoke, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) objInvoke;
    }
}
