package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class zt {
    private static final Class<?> a = c("libcore.io.Memory");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f13721b;

    static {
        f13721b = c("org.robolectric.Robolectric") != null;
    }

    static boolean a() {
        return (a == null || f13721b) ? false : true;
    }

    static Class<?> b() {
        return a;
    }

    private static <T> Class<T> c(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
