package io.sentry.util;

import io.sentry.n1;
import io.sentry.w1;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: HintUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class m {

    /* JADX INFO: compiled from: HintUtils.java */
    @FunctionalInterface
    public interface a<T> {
        void a(T t);
    }

    /* JADX INFO: compiled from: HintUtils.java */
    @FunctionalInterface
    public interface b {
        void a(Object obj, Class<?> cls);
    }

    /* JADX INFO: compiled from: HintUtils.java */
    @FunctionalInterface
    public interface c<T> {
        void a(T t);
    }

    public static n1 a(Object obj) {
        n1 n1Var = new n1();
        p(n1Var, obj);
        return n1Var;
    }

    public static io.sentry.hints.h b(n1 n1Var) {
        return (io.sentry.hints.h) n1Var.d("sentry:eventDropReason", io.sentry.hints.h.class);
    }

    public static Object c(n1 n1Var) {
        return n1Var.c("sentry:typeCheckHint");
    }

    public static boolean d(n1 n1Var, Class<?> cls) {
        return cls.isInstance(c(n1Var));
    }

    public static boolean e(n1 n1Var) {
        return Boolean.TRUE.equals(n1Var.d("sentry:isFromHybridSdk", Boolean.class));
    }

    static /* synthetic */ void f(Object obj) {
    }

    static /* synthetic */ void h(Object obj, Class cls) {
    }

    public static <T> void j(n1 n1Var, Class<T> cls, final c<Object> cVar) {
        l(n1Var, cls, new a() { // from class: io.sentry.util.d
            @Override // io.sentry.util.m.a
            public final void a(Object obj) {
                m.f(obj);
            }
        }, new b() { // from class: io.sentry.util.c
            @Override // io.sentry.util.m.b
            public final void a(Object obj, Class cls2) {
                cVar.a(obj);
            }
        });
    }

    public static <T> void k(n1 n1Var, Class<T> cls, a<T> aVar) {
        l(n1Var, cls, aVar, new b() { // from class: io.sentry.util.a
            @Override // io.sentry.util.m.b
            public final void a(Object obj, Class cls2) {
                m.h(obj, cls2);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void l(n1 n1Var, Class<T> cls, a<T> aVar, b bVar) {
        Object objC = c(n1Var);
        if (!d(n1Var, cls) || objC == null) {
            bVar.a(objC, cls);
        } else {
            aVar.a(objC);
        }
    }

    public static <T> void m(n1 n1Var, Class<T> cls, final w1 w1Var, a<T> aVar) {
        l(n1Var, cls, aVar, new b() { // from class: io.sentry.util.b
            @Override // io.sentry.util.m.b
            public final void a(Object obj, Class cls2) {
                p.a(cls2, obj, w1Var);
            }
        });
    }

    public static void n(n1 n1Var, io.sentry.hints.h hVar) {
        n1Var.j("sentry:eventDropReason", hVar);
    }

    public static void o(n1 n1Var, String str) {
        if (str.startsWith("sentry.javascript") || str.startsWith("sentry.dart") || str.startsWith("sentry.dotnet")) {
            n1Var.j("sentry:isFromHybridSdk", Boolean.TRUE);
        }
    }

    public static void p(n1 n1Var, Object obj) {
        n1Var.j("sentry:typeCheckHint", obj);
    }

    public static boolean q(n1 n1Var) {
        return !(d(n1Var, io.sentry.hints.f.class) || d(n1Var, io.sentry.hints.d.class)) || d(n1Var, io.sentry.hints.c.class);
    }
}
