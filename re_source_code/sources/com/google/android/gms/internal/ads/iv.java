package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class iv<K> implements Map.Entry<K, Object> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map.Entry<K, zzdon> f12781f;

    private iv(Map.Entry<K, zzdon> entry) {
        this.f12781f = entry;
    }

    public final zzdon a() {
        return this.f12781f.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f12781f.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f12781f.getValue() == null) {
            return null;
        }
        return zzdon.e();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzdpk) {
            return this.f12781f.getValue().d((zzdpk) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
