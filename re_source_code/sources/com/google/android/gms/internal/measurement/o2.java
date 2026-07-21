package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class o2<K> implements Map.Entry<K, Object> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map.Entry<K, zzfp> f17237f;

    private o2(Map.Entry<K, zzfp> entry) {
        this.f17237f = entry;
    }

    public final zzfp a() {
        return this.f17237f.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f17237f.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f17237f.getValue() == null) {
            return null;
        }
        return zzfp.e();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzgo) {
            return this.f17237f.getValue().a((zzgo) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
