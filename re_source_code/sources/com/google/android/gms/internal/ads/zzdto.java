package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdto {
    public static <T> T a(T t) {
        t.getClass();
        return t;
    }

    public static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static <T> void c(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }
}
