package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes2.dex */
final class b {
    public static final b a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f25325b;

    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public static final class a {
        private final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f25326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f25327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Method f25328d;

        public a(Method method, Method method2, Method method3, Method method4) {
            this.a = method;
            this.f25326b = method2;
            this.f25327c = method3;
            this.f25328d = method4;
        }

        public final Method a() {
            return this.f25326b;
        }

        public final Method b() {
            return this.f25328d;
        }

        public final Method c() {
            return this.f25327c;
        }

        public final Method d() {
            return this.a;
        }
    }

    private b() {
    }

    private final a a() {
        try {
            return new a(Class.class.getMethod("isSealed", new Class[0]), Class.class.getMethod("getPermittedSubclasses", new Class[0]), Class.class.getMethod("isRecord", new Class[0]), Class.class.getMethod("getRecordComponents", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new a(null, null, null, null);
        }
    }

    private final a b() {
        a aVar = f25325b;
        if (aVar != null) {
            return aVar;
        }
        a aVarA = a();
        f25325b = aVarA;
        return aVarA;
    }

    public final Class<?>[] c(Class<?> cls) throws IllegalAccessException, InvocationTargetException {
        m.f(cls, "clazz");
        Method methodA = b().a();
        if (methodA == null) {
            return null;
        }
        Object objInvoke = methodA.invoke(cls, new Object[0]);
        m.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) objInvoke;
    }

    public final Object[] d(Class<?> cls) {
        m.f(cls, "clazz");
        Method methodB = b().b();
        if (methodB == null) {
            return null;
        }
        return (Object[]) methodB.invoke(cls, new Object[0]);
    }

    public final Boolean e(Class<?> cls) throws IllegalAccessException, InvocationTargetException {
        m.f(cls, "clazz");
        Method methodC = b().c();
        if (methodC == null) {
            return null;
        }
        Object objInvoke = methodC.invoke(cls, new Object[0]);
        m.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) objInvoke;
    }

    public final Boolean f(Class<?> cls) throws IllegalAccessException, InvocationTargetException {
        m.f(cls, "clazz");
        Method methodD = b().d();
        if (methodD == null) {
            return null;
        }
        Object objInvoke = methodD.invoke(cls, new Object[0]);
        m.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) objInvoke;
    }
}
