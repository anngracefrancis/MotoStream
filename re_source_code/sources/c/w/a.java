package c.w;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: Trace.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f3524b;

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(str);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.b();
        }
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    @SuppressLint({"NewApi"})
    public static boolean d() {
        try {
            if (f3524b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    private static boolean e() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f3524b == null) {
                    a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    f3524b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) f3524b.invoke(null, Long.valueOf(a))).booleanValue();
            } catch (Exception e2) {
                c("isTagEnabled", e2);
            }
        }
        return false;
    }
}
