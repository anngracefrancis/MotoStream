package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdtf {
    public static <T> List<T> a(int i2) {
        return i2 == 0 ? Collections.emptyList() : new ArrayList(i2);
    }

    static <T> HashSet<T> b(int i2) {
        return new HashSet<>(d(i2));
    }

    public static <K, V> LinkedHashMap<K, V> c(int i2) {
        return new LinkedHashMap<>(d(i2));
    }

    private static int d(int i2) {
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
