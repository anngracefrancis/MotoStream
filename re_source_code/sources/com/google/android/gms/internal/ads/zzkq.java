package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class zzkq {
    public static final int a = Build.VERSION.SDK_INT;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f16398b = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f16399c = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

    public static int a(long[] jArr, long j2, boolean z, boolean z2) {
        int iBinarySearch = Arrays.binarySearch(jArr, j2);
        if (iBinarySearch < 0) {
            iBinarySearch = -(iBinarySearch + 2);
        }
        return z2 ? Math.max(0, iBinarySearch) : iBinarySearch;
    }

    public static long b(long j2, long j3, long j4) {
        if (j4 >= 1000000 && j4 % 1000000 == 0) {
            return j2 / (j4 / 1000000);
        }
        if (j4 < 1000000 && 1000000 % j4 == 0) {
            return j2 * (1000000 / j4);
        }
        double d2 = j4;
        Double.isNaN(d2);
        double d3 = j2;
        Double.isNaN(d3);
        return (long) (d3 * (1000000.0d / d2));
    }

    public static void c(long[] jArr, long j2, long j3) {
        int i2 = 0;
        if (j3 >= 1000000 && j3 % 1000000 == 0) {
            long j4 = j3 / 1000000;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j4;
                i2++;
            }
            return;
        }
        if (j3 < 1000000 && 1000000 % j3 == 0) {
            long j5 = 1000000 / j3;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] * j5;
                i2++;
            }
            return;
        }
        double d2 = j3;
        Double.isNaN(d2);
        double d3 = 1000000.0d / d2;
        while (i2 < jArr.length) {
            double d4 = jArr[i2];
            Double.isNaN(d4);
            jArr[i2] = (long) (d4 * d3);
            i2++;
        }
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static ExecutorService e(String str) {
        return Executors.newSingleThreadExecutor(new m00(str));
    }

    public static int f(String str) {
        int length = str.length();
        zzkh.a(length <= 4);
        int iCharAt = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iCharAt = (iCharAt << 8) | str.charAt(i2);
        }
        return iCharAt;
    }

    public static int g(int i2, int i3) {
        return ((i3 + 0) - 1) / i3;
    }

    public static int h(long[] jArr, long j2, boolean z, boolean z2) {
        int iBinarySearch = Arrays.binarySearch(jArr, j2);
        return iBinarySearch < 0 ? iBinarySearch ^ (-1) : iBinarySearch;
    }
}
