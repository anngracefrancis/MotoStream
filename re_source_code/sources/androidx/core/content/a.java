package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;

/* JADX INFO: compiled from: ContextCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f941b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static TypedValue f942c;

    /* JADX INFO: renamed from: androidx.core.content.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ContextCompat.java */
    static class C0021a {
        static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class b {
        static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class c {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        static Drawable b(Context context, int i2) {
            return context.getDrawable(i2);
        }

        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class d {
        static int a(Context context, int i2) {
            return context.getColor(i2);
        }

        static ColorStateList b(Context context, int i2) {
            return context.getColorStateList(i2);
        }

        static <T> T c(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        static String d(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class e {
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        static File b(Context context) {
            return context.getDataDir();
        }

        static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class f {
        static ComponentName a(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    public static int a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static Context b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.a(context);
        }
        return null;
    }

    private static File c(File file) {
        synchronized (f941b) {
            if (!file.exists()) {
                if (file.mkdirs()) {
                    return file;
                }
                Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
            }
            return file;
        }
    }

    public static int d(Context context, int i2) {
        return Build.VERSION.SDK_INT >= 23 ? d.a(context, i2) : context.getResources().getColor(i2);
    }

    public static ColorStateList e(Context context, int i2) {
        return androidx.core.content.d.f.c(context.getResources(), i2, context.getTheme());
    }

    public static Drawable f(Context context, int i2) {
        int i3;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            return c.b(context, i2);
        }
        if (i4 >= 16) {
            return context.getResources().getDrawable(i2);
        }
        synchronized (a) {
            if (f942c == null) {
                f942c = new TypedValue();
            }
            context.getResources().getValue(i2, f942c, true);
            i3 = f942c.resourceId;
        }
        return context.getResources().getDrawable(i3);
    }

    public static File[] g(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? b.a(context) : new File[]{context.getExternalCacheDir()};
    }

    public static File[] h(Context context, String str) {
        return Build.VERSION.SDK_INT >= 19 ? b.b(context, str) : new File[]{context.getExternalFilesDir(str)};
    }

    public static File i(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? c.c(context) : c(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public static boolean j(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            C0021a.a(context, intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    public static void k(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            C0021a.b(context, intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static void l(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            f.a(context, intent);
        } else {
            context.startService(intent);
        }
    }
}
