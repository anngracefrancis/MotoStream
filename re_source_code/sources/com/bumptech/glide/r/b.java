package com.bumptech.glide.r;

/* JADX INFO: compiled from: CachedHashCodeArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public final class b<K, V> extends c.e.a<K, V> {
    private int n;

    @Override // c.e.g, java.util.Map
    public void clear() {
        this.n = 0;
        super.clear();
    }

    @Override // c.e.g, java.util.Map
    public int hashCode() {
        if (this.n == 0) {
            this.n = super.hashCode();
        }
        return this.n;
    }

    @Override // c.e.g
    public void k(c.e.g<? extends K, ? extends V> gVar) {
        this.n = 0;
        super.k(gVar);
    }

    @Override // c.e.g
    public V l(int i2) {
        this.n = 0;
        return (V) super.l(i2);
    }

    @Override // c.e.g
    public V m(int i2, V v) {
        this.n = 0;
        return (V) super.m(i2, v);
    }

    @Override // c.e.g, java.util.Map
    public V put(K k2, V v) {
        this.n = 0;
        return (V) super.put(k2, v);
    }
}
