package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.zzb;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    @KeepForSdk
    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void c(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @KeepForSdk
    public static void d(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            throw new IllegalStateException("Must be called on " + handler.getLooper().getThread().getName() + " thread, but got " + name + ".");
        }
    }

    @KeepForSdk
    public static void e(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    public static void f(String str) {
        if (!zzb.a()) {
            throw new IllegalStateException(str);
        }
    }

    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static String h(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    @KeepForSdk
    public static void i() {
        j("Must not be called on the main application thread");
    }

    @KeepForSdk
    public static void j(String str) {
        if (zzb.a()) {
            throw new IllegalStateException(str);
        }
    }

    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static <T> T k(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static <T> T l(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @KeepForSdk
    public static int m(int i2) {
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    @KeepForSdk
    public static void n(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    @KeepForSdk
    public static void o(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void p(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }
}
