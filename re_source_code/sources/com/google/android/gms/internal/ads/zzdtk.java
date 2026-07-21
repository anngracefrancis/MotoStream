package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdtk<K, V> implements zzdti<Map<K, V>> {
    private static final zzdtu<Map<Object, Object>> a = zzdtj.a(Collections.emptyMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<K, zzdtu<V>> f16171b;

    private zzdtk(Map<K, zzdtu<V>> map) {
        this.f16171b = Collections.unmodifiableMap(map);
    }

    public static <K, V> zzdtm<K, V> a(int i2) {
        return new zzdtm<>(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        LinkedHashMap linkedHashMapC = zzdtf.c(this.f16171b.size());
        for (Map.Entry<K, zzdtu<V>> entry : this.f16171b.entrySet()) {
            linkedHashMapC.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(linkedHashMapC);
    }
}
