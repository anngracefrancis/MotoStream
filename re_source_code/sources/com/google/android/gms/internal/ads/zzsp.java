package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzsp {
    private static String a(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(47);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException(str.length() != 0 ? "Invalid mime type: ".concat(str) : new String("Invalid mime type: "));
        }
        return str.substring(0, iIndexOf);
    }

    public static boolean b(String str) {
        return "audio".equals(a(str));
    }

    public static boolean c(String str) {
        return "video".equals(a(str));
    }
}
