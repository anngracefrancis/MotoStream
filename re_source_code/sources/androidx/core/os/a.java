package androidx.core.os;

import android.os.Build;

/* JADX INFO: compiled from: BuildCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    protected static boolean a(String str, String str2) {
        return !"REL".equals(str2) && str2.compareTo(str) >= 0;
    }

    @Deprecated
    public static boolean b() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 31 || a("S", Build.VERSION.CODENAME);
    }
}
