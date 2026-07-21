package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@KeepForSdk
public final class ArrayUtils {
    private ArrayUtils() {
    }

    @KeepForSdk
    public static <T> T[] a(T[]... tArr) {
        if (tArr.length == 0) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass(), 0));
        }
        int length = 0;
        for (T[] tArr2 : tArr) {
            length += tArr2.length;
        }
        T[] tArr3 = (T[]) Arrays.copyOf(tArr[0], length);
        int length2 = tArr[0].length;
        for (int i2 = 1; i2 < tArr.length; i2++) {
            T[] tArr4 = tArr[i2];
            int length3 = tArr4.length;
            System.arraycopy(tArr4, 0, tArr3, length2, length3);
            length2 += length3;
        }
        return tArr3;
    }

    @KeepForSdk
    public static <T> boolean b(T[] tArr, T t) {
        int length = tArr != null ? tArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Objects.a(tArr[i2], t)) {
                if (i2 >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @KeepForSdk
    public static void c(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(dArr[i2]));
        }
    }

    @KeepForSdk
    public static void d(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(fArr[i2]));
        }
    }

    @KeepForSdk
    public static void e(StringBuilder sb, int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(iArr[i2]));
        }
    }

    @KeepForSdk
    public static void f(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(jArr[i2]));
        }
    }

    @KeepForSdk
    public static <T> void g(StringBuilder sb, T[] tArr) {
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(tArr[i2]);
        }
    }

    @KeepForSdk
    public static void h(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(zArr[i2]));
        }
    }

    @KeepForSdk
    public static void i(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i2]);
            sb.append("\"");
        }
    }
}
