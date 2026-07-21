package io.sentry.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: CollectionUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class i {
    public static <T> List<T> a(List<T> list) {
        if (list != null) {
            return new ArrayList(list);
        }
        return null;
    }

    public static <K, V> Map<K, V> b(Map<K, V> map) {
        if (map == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                concurrentHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return concurrentHashMap;
    }

    public static <K, V> Map<K, V> c(Map<K, V> map) {
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    public static int d(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        int i2 = 0;
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }
}
