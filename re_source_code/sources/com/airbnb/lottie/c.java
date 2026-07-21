package com.airbnb.lottie;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: L.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static boolean a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String[] f8491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long[] f8492e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f8489b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f8490c = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f8493f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f8494g = 0;

    public static void a(String str) {
        if (f8490c) {
            int i2 = f8493f;
            if (i2 == 20) {
                f8494g++;
                return;
            }
            f8491d[i2] = str;
            f8492e[i2] = System.nanoTime();
            androidx.core.os.d.a(str);
            f8493f++;
        }
    }

    public static void b(String str) {
        if (a) {
            Log.d("LOTTIE", str);
        }
    }

    public static float c(String str) {
        int i2 = f8494g;
        if (i2 > 0) {
            f8494g = i2 - 1;
            return 0.0f;
        }
        if (!f8490c) {
            return 0.0f;
        }
        int i3 = f8493f - 1;
        f8493f = i3;
        if (i3 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(f8491d[i3])) {
            androidx.core.os.d.b();
            return (System.nanoTime() - f8492e[f8493f]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f8491d[f8493f] + ".");
    }

    public static void d(String str) {
        Set<String> set = f8489b;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str);
        set.add(str);
    }
}
