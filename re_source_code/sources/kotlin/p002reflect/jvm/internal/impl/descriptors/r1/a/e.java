package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: ReflectJavaClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final Class<?> a(ClassLoader classLoader, String str) {
        m.f(classLoader, "<this>");
        m.f(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
