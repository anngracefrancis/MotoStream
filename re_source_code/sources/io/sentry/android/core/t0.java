package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.util.DisplayMetrics;
import io.sentry.s4;
import io.sentry.w1;
import io.sentry.x4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ContextUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class t0 {

    /* JADX INFO: compiled from: ContextUtils.java */
    static class a {
        private final boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22258b;

        public a(boolean z, String str) {
            this.a = z;
            this.f22258b = str;
        }

        public Map<String, String> a() {
            HashMap map = new HashMap();
            map.put("isSideLoaded", String.valueOf(this.a));
            String str = this.f22258b;
            if (str != null) {
                map.put("installerStore", str);
            }
            return map;
        }
    }

    @SuppressLint({"NewApi"})
    static ApplicationInfo a(Context context, long j2, s0 s0Var) throws PackageManager.NameNotFoundException {
        return s0Var.d() >= 33 ? context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(j2)) : context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
    }

    static String b(Context context, w1 w1Var) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.labelRes;
            if (i2 != 0) {
                return context.getString(i2);
            }
            CharSequence charSequence = applicationInfo.nonLocalizedLabel;
            return charSequence != null ? charSequence.toString() : context.getPackageManager().getApplicationLabel(applicationInfo).toString();
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Error getting application name.", th);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    static String[] c(s0 s0Var) {
        return s0Var.d() >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    @SuppressLint({"NewApi"})
    static String d(Context context, s0 s0Var) {
        if (s0Var.d() >= 17) {
            return Settings.Global.getString(context.getContentResolver(), "device_name");
        }
        return null;
    }

    static DisplayMetrics e(Context context, w1 w1Var) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Error getting DisplayMetrics.", th);
            return null;
        }
    }

    static String f(w1 w1Var) {
        try {
            return Build.MODEL.split(" ", -1)[0];
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Error getting device family.", th);
            return null;
        }
    }

    static String g(w1 w1Var) {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                return line;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException e2) {
            w1Var.b(s4.ERROR, "Exception while attempting to read kernel information", e2);
            return property;
        }
    }

    static ActivityManager.MemoryInfo h(Context context, w1 w1Var) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            w1Var.c(s4.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    static PackageInfo i(Context context, int i2, w1 w1Var, s0 s0Var) {
        try {
            return s0Var.d() >= 33 ? context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(i2)) : context.getPackageManager().getPackageInfo(context.getPackageName(), i2);
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Error getting package info.", th);
            return null;
        }
    }

    static PackageInfo j(Context context, w1 w1Var, s0 s0Var) {
        return i(context, 0, w1Var, s0Var);
    }

    @SuppressLint({"NewApi"})
    static String k(PackageInfo packageInfo, s0 s0Var) {
        return s0Var.d() >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : l(packageInfo);
    }

    private static String l(PackageInfo packageInfo) {
        return Integer.toString(packageInfo.versionCode);
    }

    static boolean m(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Object systemService = context.getSystemService("activity");
            if (!(systemService instanceof ActivityManager) || (runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses()) == null) {
                return false;
            }
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.importance == 100;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    static Intent n(Context context, x4 x4Var, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return o(context, new s0(x4Var.getLogger()), broadcastReceiver, intentFilter);
    }

    @SuppressLint({"NewApi", "UnspecifiedRegisterReceiverFlag"})
    static Intent o(Context context, s0 s0Var, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return s0Var.d() >= 33 ? context.registerReceiver(broadcastReceiver, intentFilter, 2) : context.registerReceiver(broadcastReceiver, intentFilter);
    }

    static a p(Context context, w1 w1Var, s0 s0Var) {
        String str;
        try {
            PackageInfo packageInfoJ = j(context, w1Var, s0Var);
            PackageManager packageManager = context.getPackageManager();
            if (packageInfoJ != null && packageManager != null) {
                str = packageInfoJ.packageName;
                try {
                    String installerPackageName = packageManager.getInstallerPackageName(str);
                    return new a(installerPackageName == null, installerPackageName);
                } catch (IllegalArgumentException unused) {
                    w1Var.c(s4.DEBUG, "%s package isn't installed.", str);
                    return null;
                }
            }
        } catch (IllegalArgumentException unused2) {
            str = null;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    static void q(PackageInfo packageInfo, s0 s0Var, io.sentry.protocol.a aVar) {
        aVar.l(packageInfo.packageName);
        aVar.o(packageInfo.versionName);
        aVar.k(k(packageInfo, s0Var));
        if (s0Var.d() >= 16) {
            HashMap map = new HashMap();
            String[] strArr = packageInfo.requestedPermissions;
            int[] iArr = packageInfo.requestedPermissionsFlags;
            if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    String str = strArr[i2];
                    map.put(str.substring(str.lastIndexOf(46) + 1), (iArr[i2] & 2) == 2 ? "granted" : "not_granted");
                }
            }
            aVar.q(map);
        }
    }
}
