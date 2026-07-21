package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class zzsk {
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

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static <T> T d(T t) {
        t.getClass();
        return t;
    }

    public static void e(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void f(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static int g(int i2, int i3, int i4) {
        if (i2 < 0 || i2 >= i4) {
            throw new IndexOutOfBoundsException();
        }
        return i2;
    }
}
