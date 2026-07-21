package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzkh {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static <T> T c(T t) {
        t.getClass();
        return t;
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
