package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
@NullMarked
public final class zzs {
    public static int a(int i2, int i3, String str) {
        String strA;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 < 0) {
            strA = zzy.a("%s (%s) must not be negative", "index", Integer.valueOf(i2));
        } else {
            if (i3 < 0) {
                throw new IllegalArgumentException("negative size: " + i3);
            }
            strA = zzy.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IndexOutOfBoundsException(strA);
    }

    public static int b(int i2, int i3, String str) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(d(i2, i3, "index"));
        }
        return i2;
    }

    public static void c(int i2, int i3, int i4) {
        String strD;
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            if (i2 < 0 || i2 > i4) {
                strD = d(i2, i4, "start index");
            } else {
                strD = (i3 < 0 || i3 > i4) ? d(i3, i4, "end index") : zzy.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(strD);
        }
    }

    private static String d(int i2, int i3, String str) {
        if (i2 < 0) {
            return zzy.a("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return zzy.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException("negative size: " + i3);
    }
}
