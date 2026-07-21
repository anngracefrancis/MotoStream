package com.airbnb.epoxy;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: compiled from: EpoxyAsyncUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static final Handler a = b(Looper.getMainLooper(), false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f8441b = b(Looper.getMainLooper(), true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f8442c;

    public static Looper a(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return handlerThread.getLooper();
    }

    public static Handler b(Looper looper, boolean z) {
        if (!z) {
            return new Handler(looper);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return Handler.createAsync(looper);
        }
        if (i2 >= 16) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (Throwable unused) {
            }
        }
        return new Handler(looper);
    }

    public static Handler c() {
        if (f8442c == null) {
            f8442c = b(a("epoxy"), true);
        }
        return f8442c;
    }
}
