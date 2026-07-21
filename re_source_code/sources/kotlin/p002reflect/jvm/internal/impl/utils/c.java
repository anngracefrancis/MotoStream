package kotlin.p002reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: exceptionUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final boolean a(Throwable th) {
        m.f(th, "<this>");
        Class<?> superclass = th.getClass();
        while (!m.a(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException b(Throwable th) throws Throwable {
        m.f(th, "e");
        throw th;
    }
}
