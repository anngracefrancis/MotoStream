package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class v0 {
    private static final long a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f19880b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static WakeLock f19881c;

    private static void a(Context context) {
        if (f19881c == null) {
            WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f19881c = wakeLock;
            wakeLock.c(true);
        }
    }

    static void b(Intent intent) {
        synchronized (f19880b) {
            if (f19881c != null && c(intent)) {
                d(intent, false);
                f19881c.b();
            }
        }
    }

    static boolean c(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    private static void d(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    static ComponentName e(Context context, Intent intent) {
        synchronized (f19880b) {
            a(context);
            boolean zC = c(intent);
            d(intent, true);
            ComponentName componentNameStartService = context.startService(intent);
            if (componentNameStartService == null) {
                return null;
            }
            if (!zC) {
                f19881c.a(a);
            }
            return componentNameStartService;
        }
    }
}
