package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzkl {
    public static String a(String str) {
        int iIndexOf = str.indexOf(47);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException(str.length() != 0 ? "Invalid mime type: ".concat(str) : new String("Invalid mime type: "));
        }
        return str.substring(0, iIndexOf);
    }

    public static boolean b(String str) {
        return a(str).equals("audio");
    }

    public static boolean c(String str) {
        return "audio/ac3".equals(str) || "audio/eac3".equals(str);
    }
}
