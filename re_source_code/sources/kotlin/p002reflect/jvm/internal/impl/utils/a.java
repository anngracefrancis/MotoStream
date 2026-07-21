package kotlin.p002reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final <T> void a(Collection<T> collection, T t) {
        m.f(collection, "<this>");
        if (t != null) {
            collection.add(t);
        }
    }

    private static final int b(int i2) {
        if (i2 < 3) {
            return 3;
        }
        return i2 + (i2 / 3) + 1;
    }

    public static final <T> List<T> c(ArrayList<T> arrayList) {
        m.f(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return u.j();
        }
        if (size == 1) {
            return t.e(s.U(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final <K> Map<K, Integer> d(Iterable<? extends K> iterable) {
        m.f(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends K> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i2));
            i2++;
        }
        return linkedHashMap;
    }

    public static final <K, V> HashMap<K, V> e(int i2) {
        return new HashMap<>(b(i2));
    }

    public static final <E> HashSet<E> f(int i2) {
        return new HashSet<>(b(i2));
    }

    public static final <E> LinkedHashSet<E> g(int i2) {
        return new LinkedHashSet<>(b(i2));
    }
}
