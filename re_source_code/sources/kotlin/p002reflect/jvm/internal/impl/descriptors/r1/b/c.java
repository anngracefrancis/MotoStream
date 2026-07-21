package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes2.dex */
final class c {
    public static final c a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f25332b;

    /* JADX INFO: compiled from: ReflectJavaMember.kt */
    public static final class a {
        private final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f25333b;

        public a(Method method, Method method2) {
            this.a = method;
            this.f25333b = method2;
        }

        public final Method a() {
            return this.f25333b;
        }

        public final Method b() {
            return this.a;
        }
    }

    private c() {
    }

    public final a a(Member member) {
        m.f(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", new Class[0]), d.e(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final List<String> b(Member member) throws IllegalAccessException, InvocationTargetException {
        Method methodA;
        m.f(member, "member");
        a aVarA = f25332b;
        if (aVarA == null) {
            synchronized (this) {
                c cVar = a;
                a aVar = f25332b;
                if (aVar == null) {
                    aVarA = cVar.a(member);
                    f25332b = aVarA;
                } else {
                    aVarA = aVar;
                }
            }
        }
        Method methodB = aVarA.b();
        if (methodB == null || (methodA = aVarA.a()) == null) {
            return null;
        }
        Object objInvoke = methodB.invoke(member, new Object[0]);
        m.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) objInvoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object objInvoke2 = methodA.invoke(obj, new Object[0]);
            m.d(objInvoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) objInvoke2);
        }
        return arrayList;
    }
}
