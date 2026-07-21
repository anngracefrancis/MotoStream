package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes2.dex */
final class vw<K, V> implements Comparable<vw>, Map.Entry<K, V> {

    /* JADX INFO: Incorrect field signature: TK; */
    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Comparable f13467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private V f13468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ ow f13469h;

    vw(ow owVar, Map.Entry<K, V> entry) {
        this(owVar, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean g(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(vw vwVar) {
        return ((Comparable) getKey()).compareTo((Comparable) vwVar.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return g(this.f13467f, entry.getKey()) && g(this.f13468g, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f13467f;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f13468g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f13467f;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f13468g;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f13469h.k();
        V v2 = this.f13468g;
        this.f13468g = v;
        return v2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f13467f);
        String strValueOf2 = String.valueOf(this.f13468g);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    vw(ow owVar, K k2, V v) {
        this.f13469h = owVar;
        this.f13467f = k2;
        this.f13468g = v;
    }
}
