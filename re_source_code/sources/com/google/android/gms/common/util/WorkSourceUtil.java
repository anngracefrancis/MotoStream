package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class WorkSourceUtil {
    private static final int a = Process.myUid();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f12156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Method f12157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f12158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f12159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Method f12160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Method f12161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Method f12162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Method f12163i;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        Method method8 = null;
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            method = null;
        }
        f12156b = method;
        if (PlatformVersion.e()) {
            try {
                method2 = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused2) {
                method2 = null;
            }
        } else {
            method2 = null;
        }
        f12157c = method2;
        try {
            method3 = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused3) {
            method3 = null;
        }
        f12158d = method3;
        try {
            method4 = WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused4) {
            method4 = null;
        }
        f12159e = method4;
        if (PlatformVersion.e()) {
            try {
                method5 = WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused5) {
                method5 = null;
            }
        } else {
            method5 = null;
        }
        f12160f = method5;
        if (PlatformVersion.l()) {
            try {
                method6 = WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e2);
                method6 = null;
            }
        } else {
            method6 = null;
        }
        f12161g = method6;
        if (PlatformVersion.l()) {
            try {
                method7 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e3) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e3);
                method7 = null;
            }
        } else {
            method7 = null;
        }
        f12162h = method7;
        if (PlatformVersion.l()) {
            try {
                method8 = WorkSource.class.getMethod("isEmpty", new Class[0]);
                method8.setAccessible(true);
            } catch (Exception unused6) {
            }
        }
        f12163i = method8;
    }

    private WorkSourceUtil() {
    }

    @KeepForSdk
    public static void a(WorkSource workSource, int i2, String str) {
        Method method = f12157c;
        if (method != null) {
            if (str == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            try {
                method.invoke(workSource, Integer.valueOf(i2), str);
                return;
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                return;
            }
        }
        Method method2 = f12156b;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i2));
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            }
        }
    }

    @KeepForSdk
    public static WorkSource b(Context context, String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfoC = Wrappers.a(context).c(str, 0);
                if (applicationInfoC == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i2 = applicationInfoC.uid;
                WorkSource workSource = new WorkSource();
                a(workSource, i2, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    @KeepForSdk
    public static String c(WorkSource workSource, int i2) {
        Method method = f12160f;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i2));
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }

    @KeepForSdk
    public static List<String> d(WorkSource workSource) {
        ArrayList arrayList = new ArrayList();
        int iF = workSource == null ? 0 : f(workSource);
        if (iF != 0) {
            for (int i2 = 0; i2 < iF; i2++) {
                String strC = c(workSource, i2);
                if (!Strings.a(strC)) {
                    Preconditions.k(strC);
                    arrayList.add(strC);
                }
            }
        }
        return arrayList;
    }

    @KeepForSdk
    public static boolean e(Context context) {
        return (context == null || context.getPackageManager() == null || Wrappers.a(context).b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    @KeepForSdk
    public static int f(WorkSource workSource) {
        Method method = f12158d;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(workSource, new Object[0]);
                Preconditions.k(objInvoke);
                return ((Integer) objInvoke).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }
}
