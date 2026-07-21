package com.bumptech.glide.load.engine;

import java.security.MessageDigest;

/* JADX INFO: compiled from: DataCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
final class d implements com.bumptech.glide.load.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.f f9099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.f f9100c;

    d(com.bumptech.glide.load.f fVar, com.bumptech.glide.load.f fVar2) {
        this.f9099b = fVar;
        this.f9100c = fVar2;
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f9099b.equals(dVar.f9099b) && this.f9100c.equals(dVar.f9100c);
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return (this.f9099b.hashCode() * 31) + this.f9100c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f9099b + ", signature=" + this.f9100c + '}';
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f9099b.updateDiskCacheKey(messageDigest);
        this.f9100c.updateDiskCacheKey(messageDigest);
    }
}
