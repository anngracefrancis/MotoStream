package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class k1 {
    private static final Class<?> a = a("libcore.io.Memory");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f17191b;

    static {
        f17191b = a("org.robolectric.Robolectric") != null;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean b() {
        return (a == null || f17191b) ? false : true;
    }

    static Class<?> c() {
        return a;
    }
}
