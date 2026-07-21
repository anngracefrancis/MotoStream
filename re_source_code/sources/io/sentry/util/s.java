package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class s {
    private static boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f22764b;

    static {
        try {
            a = "The Android Project".equals(System.getProperty("java.vendor"));
        } catch (Throwable unused) {
            a = false;
        }
        try {
            String property = System.getProperty("java.specification.version");
            if (property != null) {
                f22764b = Double.valueOf(property).doubleValue() >= 9.0d;
            } else {
                f22764b = false;
            }
        } catch (Throwable unused2) {
            f22764b = false;
        }
    }

    public static boolean a() {
        return f22764b;
    }

    public static boolean b() {
        return !a;
    }
}
