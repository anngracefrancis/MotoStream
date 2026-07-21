package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 {
    private static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f10698b = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f10699c = false;

    public static void a() {
        a = true;
    }

    public static void b(int i2) {
        f10698b = i2;
    }

    public static void c(int i2, String str, String str2) {
        m(i2, str, str2);
    }

    public static void d(int i2, String str, String str2, Throwable th) {
        m(i2, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void e(String str, String str2) {
        h(3, str, str2);
    }

    public static void f(String str, String str2, Throwable th) {
        i(6, str, str2, th);
    }

    public static void g() {
        a = false;
    }

    private static void h(int i2, String str, String str2) {
        if (a || f10698b > i2) {
            return;
        }
        k(i2, str, str2);
    }

    private static void i(int i2, String str, String str2, Throwable th) {
        h(i2, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void j(String str, String str2) {
        h(6, str, str2);
    }

    private static void k(int i2, String str, String str2) {
        if (!f10699c) {
            str = "FlurryAgent";
        }
        int i3 = 0;
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        while (i3 < length) {
            int i4 = 4000 > length - i3 ? length : i3 + 4000;
            if (Log.println(i2, str, str2.substring(i3, i4)) <= 0) {
                return;
            } else {
                i3 = i4;
            }
        }
    }

    public static void l(String str, String str2) {
        h(4, str, str2);
    }

    private static void m(int i2, String str, String str2) {
        if (f10699c) {
            k(i2, str, str2);
        }
    }

    public static void n(String str, String str2) {
        h(2, str, str2);
    }

    public static void o(String str, String str2) {
        h(5, str, str2);
    }
}
