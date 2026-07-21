package com.bumptech.glide.load;

import java.security.MessageDigest;

/* JADX INFO: compiled from: Options.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.e.a<h<?>, Object> f9259b = new com.bumptech.glide.r.b();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void d(h<T> hVar, Object obj, MessageDigest messageDigest) {
        hVar.g(obj, messageDigest);
    }

    public <T> T a(h<T> hVar) {
        return this.f9259b.containsKey(hVar) ? (T) this.f9259b.get(hVar) : hVar.c();
    }

    public void b(i iVar) {
        this.f9259b.k(iVar.f9259b);
    }

    public <T> i c(h<T> hVar, T t) {
        this.f9259b.put(hVar, t);
        return this;
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f9259b.equals(((i) obj).f9259b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return this.f9259b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f9259b + '}';
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f9259b.size(); i2++) {
            d(this.f9259b.j(i2), this.f9259b.n(i2), messageDigest);
        }
    }
}
