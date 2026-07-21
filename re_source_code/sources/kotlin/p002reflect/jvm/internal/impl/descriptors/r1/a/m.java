package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes2.dex */
final class m {
    public static final m a = new m();

    private m() {
    }

    public final String a(Constructor<?> constructor) {
        kotlin.jvm.internal.m.f(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        kotlin.jvm.internal.m.e(parameterTypes, "constructor.parameterTypes");
        for (Class<?> cls : parameterTypes) {
            kotlin.jvm.internal.m.e(cls, "parameterType");
            sb.append(d.b(cls));
        }
        sb.append(")V");
        String string = sb.toString();
        kotlin.jvm.internal.m.e(string, "sb.toString()");
        return string;
    }

    public final String b(Field field) {
        kotlin.jvm.internal.m.f(field, "field");
        Class<?> type = field.getType();
        kotlin.jvm.internal.m.e(type, "field.type");
        return d.b(type);
    }

    public final String c(Method method) {
        kotlin.jvm.internal.m.f(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        kotlin.jvm.internal.m.e(parameterTypes, "method.parameterTypes");
        for (Class<?> cls : parameterTypes) {
            kotlin.jvm.internal.m.e(cls, "parameterType");
            sb.append(d.b(cls));
        }
        sb.append(")");
        Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.m.e(returnType, "method.returnType");
        sb.append(d.b(returnType));
        String string = sb.toString();
        kotlin.jvm.internal.m.e(string, "sb.toString()");
        return string;
    }
}
