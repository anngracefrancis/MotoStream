package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public abstract class GmsClientSupervisor {
    private static int a = 4225;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f11984b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static o f11985c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    static HandlerThread f11986d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f11987e = false;

    @KeepForSdk
    public static int a() {
        return a;
    }

    @KeepForSdk
    public static GmsClientSupervisor b(Context context) {
        synchronized (f11984b) {
            if (f11985c == null) {
                f11985c = new o(context.getApplicationContext(), f11987e ? c().getLooper() : context.getMainLooper());
            }
        }
        return f11985c;
    }

    @KeepForSdk
    public static HandlerThread c() {
        synchronized (f11984b) {
            HandlerThread handlerThread = f11986d;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f11986d = handlerThread2;
            handlerThread2.start();
            return f11986d;
        }
    }

    protected abstract void d(zzn zznVar, ServiceConnection serviceConnection, String str);

    public final void e(String str, String str2, int i2, ServiceConnection serviceConnection, String str3, boolean z) {
        d(new zzn(str, str2, i2, z), serviceConnection, str3);
    }

    protected abstract boolean f(zzn zznVar, ServiceConnection serviceConnection, String str, Executor executor);
}
