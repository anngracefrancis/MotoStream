package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class ConnectionTracker {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ConnectionTracker f12140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    public ConcurrentHashMap f12141c = new ConcurrentHashMap();

    private ConnectionTracker() {
    }

    @KeepForSdk
    public static ConnectionTracker b() {
        if (f12140b == null) {
            synchronized (a) {
                if (f12140b == null) {
                    f12140b = new ConnectionTracker();
                }
            }
        }
        ConnectionTracker connectionTracker = f12140b;
        Preconditions.k(connectionTracker);
        return connectionTracker;
    }

    private static void e(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean f(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2, boolean z, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((Wrappers.a(context).c(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!g(serviceConnection)) {
            return h(context, intent, serviceConnection, i2, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f12141c.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zH = h(context, intent, serviceConnection, i2, executor);
            if (zH) {
                return zH;
            }
            this.f12141c.remove(serviceConnection, serviceConnection);
            return false;
        } catch (Throwable th) {
            this.f12141c.remove(serviceConnection, serviceConnection);
            throw th;
        }
    }

    private static boolean g(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof zzs);
    }

    private static final boolean h(Context context, Intent intent, ServiceConnection serviceConnection, int i2, Executor executor) {
        return (!PlatformVersion.m() || executor == null) ? context.bindService(intent, serviceConnection, i2) : context.bindService(intent, i2, executor, serviceConnection);
    }

    @KeepForSdk
    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        return f(context, context.getClass().getName(), intent, serviceConnection, i2, true, null);
    }

    @KeepForSdk
    public void c(Context context, ServiceConnection serviceConnection) {
        if (!g(serviceConnection) || !this.f12141c.containsKey(serviceConnection)) {
            e(context, serviceConnection);
            return;
        }
        try {
            e(context, (ServiceConnection) this.f12141c.get(serviceConnection));
        } finally {
            this.f12141c.remove(serviceConnection);
        }
    }

    public final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2, Executor executor) {
        return f(context, str, intent, serviceConnection, i2, true, executor);
    }
}
