package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* JADX INFO: compiled from: Intrinsics.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    private m() {
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) l(new IllegalStateException(str + " must not be null")));
    }

    public static void c(Object obj) {
        if (obj == null) {
            o();
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            p(str);
        }
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) l(new NullPointerException(str + " must not be null")));
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            s(str);
        }
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            r(str);
        }
    }

    public static int h(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public static int i(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    private static String j(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void k(int i2, String str) {
        t();
    }

    private static <T extends Throwable> T l(T t) {
        return (T) m(t, m.class.getName());
    }

    static <T extends Throwable> T m(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }

    public static String n(String str, Object obj) {
        return str + obj;
    }

    public static void o() {
        throw ((NullPointerException) l(new NullPointerException()));
    }

    public static void p(String str) {
        throw ((NullPointerException) l(new NullPointerException(str)));
    }

    public static void q() {
        throw ((KotlinNullPointerException) l(new KotlinNullPointerException()));
    }

    private static void r(String str) {
        throw ((IllegalArgumentException) l(new IllegalArgumentException(j(str))));
    }

    private static void s(String str) {
        throw ((NullPointerException) l(new NullPointerException(j(str))));
    }

    public static void t() {
        u("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void u(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void v(String str) {
        throw ((UninitializedPropertyAccessException) l(new UninitializedPropertyAccessException(str)));
    }

    public static void w(String str) {
        v("lateinit property " + str + " has not been initialized");
    }
}
