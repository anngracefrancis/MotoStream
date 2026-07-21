package e.b.a.a;

import android.util.Log;

/* JADX INFO: compiled from: InstallReferrerCommons.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static void a(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }
}
