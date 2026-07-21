package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdpe<K, V> extends LinkedHashMap<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzdpe f16049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16050g;

    static {
        zzdpe zzdpeVar = new zzdpe();
        f16049f = zzdpeVar;
        zzdpeVar.f16050g = false;
    }

    private zzdpe() {
        this.f16050g = true;
    }

    private static int e(Object obj) {
        if (obj instanceof byte[]) {
            return zzdod.b((byte[]) obj);
        }
        if (obj instanceof zzdoe) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    public static <K, V> zzdpe<K, V> h() {
        return f16049f;
    }

    private final void j() {
        if (!this.f16050g) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean b() {
        return this.f16050g;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        j();
        super.clear();
    }

    public final void d(zzdpe<K, V> zzdpeVar) {
        j();
        if (zzdpeVar.isEmpty()) {
            return;
        }
        putAll(zzdpeVar);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean z;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this == map) {
                z = true;
            } else {
                if (size() == map.size()) {
                    Iterator<Map.Entry<K, V>> it = entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Map.Entry<K, V> next = it.next();
                            if (map.containsKey(next.getKey())) {
                                V value = next.getValue();
                                Object obj2 = map.get(next.getKey());
                                if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                                }
                            }
                        } else {
                            z = true;
                        }
                    }
                }
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        this.f16050g = false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iE = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            iE += e(entry.getValue()) ^ e(entry.getKey());
        }
        return iE;
    }

    public final zzdpe<K, V> i() {
        return isEmpty() ? new zzdpe<>() : new zzdpe<>(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k2, V v) {
        j();
        zzdod.a(k2);
        zzdod.a(v);
        return (V) super.put(k2, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        j();
        for (K k2 : map.keySet()) {
            zzdod.a(k2);
            zzdod.a(map.get(k2));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        j();
        return (V) super.remove(obj);
    }

    private zzdpe(Map<K, V> map) {
        super(map);
        this.f16050g = true;
    }
}
