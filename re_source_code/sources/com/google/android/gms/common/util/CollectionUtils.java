package com.google.android.gms.common.util;

import c.e.a;
import c.e.b;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> a() {
        return Collections.emptyList();
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> b(T t) {
        return Collections.singletonList(t);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> c(T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? Collections.unmodifiableList(Arrays.asList(tArr)) : b(tArr[0]);
        }
        return a();
    }

    @KeepForSdk
    public static <K, V> Map<K, V> d(K k2, V v, K k3, V v2, K k4, V v3) {
        Map mapH = h(3, false);
        mapH.put(k2, v);
        mapH.put(k3, v2);
        mapH.put(k4, v3);
        return Collections.unmodifiableMap(mapH);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> e(K[] kArr, V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        }
        if (length == 0) {
            return Collections.emptyMap();
        }
        if (length == 1) {
            return Collections.singletonMap(kArr[0], vArr[0]);
        }
        Map mapH = h(length, false);
        for (int i2 = 0; i2 < kArr.length; i2++) {
            mapH.put(kArr[i2], vArr[i2]);
        }
        return Collections.unmodifiableMap(mapH);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> f(T t, T t2, T t3) {
        Set setI = i(3, false);
        setI.add(t);
        setI.add(t2);
        setI.add(t3);
        return Collections.unmodifiableSet(setI);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> g(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t = tArr[0];
            T t2 = tArr[1];
            Set setI = i(2, false);
            setI.add(t);
            setI.add(t2);
            return Collections.unmodifiableSet(setI);
        }
        if (length == 3) {
            return f(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set setI2 = i(length, false);
            Collections.addAll(setI2, tArr);
            return Collections.unmodifiableSet(setI2);
        }
        T t3 = tArr[0];
        T t4 = tArr[1];
        T t5 = tArr[2];
        T t6 = tArr[3];
        Set setI3 = i(4, false);
        setI3.add(t3);
        setI3.add(t4);
        setI3.add(t5);
        setI3.add(t6);
        return Collections.unmodifiableSet(setI3);
    }

    private static Map h(int i2, boolean z) {
        return i2 <= 256 ? new a(i2) : new HashMap(i2, 1.0f);
    }

    private static Set i(int i2, boolean z) {
        return i2 <= (true != z ? 256 : 128) ? new b(i2) : new HashSet(i2, true != z ? 1.0f : 0.75f);
    }
}
