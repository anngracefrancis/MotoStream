package e.h.a.k0;

import android.util.Log;

/* JADX INFO: compiled from: FileDownloadLog.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static boolean a = false;

    public static void a(Object obj, String str, Object... objArr) {
        f(3, obj, str, objArr);
    }

    public static void b(Object obj, String str, Object... objArr) {
        f(6, obj, str, objArr);
    }

    public static void c(Object obj, Throwable th, String str, Object... objArr) {
        g(6, obj, th, str, objArr);
    }

    private static String d(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("FileDownloader.");
        sb.append((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
        return sb.toString();
    }

    public static void e(Object obj, String str, Object... objArr) {
        f(4, obj, str, objArr);
    }

    private static void f(int i2, Object obj, String str, Object... objArr) {
        g(i2, obj, null, str, objArr);
    }

    private static void g(int i2, Object obj, Throwable th, String str, Object... objArr) {
        if ((i2 >= 5) || a) {
            Log.println(i2, d(obj), f.o(str, objArr));
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    public static void h(Object obj, String str, Object... objArr) {
        f(2, obj, str, objArr);
    }

    public static void i(Object obj, String str, Object... objArr) {
        f(5, obj, str, objArr);
    }
}
