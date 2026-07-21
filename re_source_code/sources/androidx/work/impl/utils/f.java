package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: ProcessUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final String a = androidx.work.n.f("ProcessUtils");

    private f() {
    }

    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    public static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object objInvoke;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return Application.getProcessName();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread", false, f.class.getClassLoader());
            if (i2 >= 18) {
                Method declaredMethod = cls.getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(null, new Object[0]);
            } else {
                Method declaredMethod2 = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod("getProcessName", new Class[0]);
                declaredMethod3.setAccessible(true);
                objInvoke = declaredMethod3.invoke(declaredMethod2.invoke(null, new Object[0]), new Object[0]);
            }
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (Throwable th) {
            androidx.work.n.c().a(a, "Unable to check ActivityThread for processName", th);
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    public static boolean b(Context context, androidx.work.b bVar) {
        String strA = a(context);
        return !TextUtils.isEmpty(bVar.c()) ? TextUtils.equals(strA, bVar.c()) : TextUtils.equals(strA, context.getApplicationInfo().processName);
    }
}
