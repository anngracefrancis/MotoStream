package com.flurry.sdk;

import android.content.SharedPreferences;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class p2 {
    public static void a(String str) {
        b0.a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit().remove(str).apply();
    }

    public static void b(String str, int i2) {
        SharedPreferences.Editor editorEdit = b0.a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        editorEdit.putInt(String.format(Locale.US, "com.flurry.sdk.%s", str), i2);
        editorEdit.apply();
    }

    public static void c(String str, long j2) {
        SharedPreferences.Editor editorEdit = b0.a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        editorEdit.putLong(String.format(Locale.US, "com.flurry.sdk.%s", str), j2);
        editorEdit.apply();
    }

    public static void d(String str, String str2) {
        SharedPreferences.Editor editorEdit = b0.a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        editorEdit.putString(String.format(Locale.US, "com.flurry.sdk.%s", str), str2);
        editorEdit.apply();
    }

    public static int e(String str, int i2) {
        return b0.a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getInt(String.format(Locale.US, "com.flurry.sdk.%s", str), i2);
    }

    public static long f(String str, long j2) {
        return b0.a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getLong(String.format(Locale.US, "com.flurry.sdk.%s", str), j2);
    }

    public static String g(String str, String str2) {
        return b0.a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString(String.format(Locale.US, "com.flurry.sdk.%s", str), str2);
    }
}
