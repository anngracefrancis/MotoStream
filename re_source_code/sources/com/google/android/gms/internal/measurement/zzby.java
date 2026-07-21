package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzby {
    private static UserManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f17341b = !a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f17342c = false;

    private zzby() {
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean b(Context context) {
        return !a() || d(context);
    }

    @TargetApi(24)
    private static boolean c(Context context) {
        boolean z;
        boolean z2 = true;
        int i2 = 1;
        while (true) {
            z = false;
            if (i2 > 2) {
                break;
            }
            if (a == null) {
                a = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = a;
            if (userManager == null) {
                return true;
            }
            try {
                if (!userManager.isUserUnlocked() && userManager.isUserRunning(Process.myUserHandle())) {
                    z2 = false;
                }
                z = z2;
                break;
            } catch (NullPointerException e2) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e2);
                a = null;
                i2++;
            }
        }
        if (z) {
            a = null;
        }
        return z;
    }

    @TargetApi(24)
    private static boolean d(Context context) {
        if (f17341b) {
            return true;
        }
        synchronized (zzby.class) {
            if (f17341b) {
                return true;
            }
            boolean zC = c(context);
            if (zC) {
                f17341b = zC;
            }
            return zC;
        }
    }
}
