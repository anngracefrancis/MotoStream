package c.i.j;

import android.os.Build;
import java.util.Arrays;

/* JADX INFO: compiled from: ObjectsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static boolean a(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return c.a(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Build.VERSION.SDK_INT >= 19 ? Arrays.hashCode(objArr) : Arrays.hashCode(objArr);
    }

    public static String c(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }
}
