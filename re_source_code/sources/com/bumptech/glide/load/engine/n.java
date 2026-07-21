package com.bumptech.glide.load.engine;

import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: EngineKey.java */
/* JADX INFO: loaded from: classes.dex */
class n implements com.bumptech.glide.load.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Class<?> f9177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f9178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.f f9179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.l<?>> f9180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.i f9181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9182j;

    n(Object obj, com.bumptech.glide.load.f fVar, int i2, int i3, Map<Class<?>, com.bumptech.glide.load.l<?>> map, Class<?> cls, Class<?> cls2, com.bumptech.glide.load.i iVar) {
        this.f9174b = com.bumptech.glide.r.j.d(obj);
        this.f9179g = (com.bumptech.glide.load.f) com.bumptech.glide.r.j.e(fVar, "Signature must not be null");
        this.f9175c = i2;
        this.f9176d = i3;
        this.f9180h = (Map) com.bumptech.glide.r.j.d(map);
        this.f9177e = (Class) com.bumptech.glide.r.j.e(cls, "Resource class must not be null");
        this.f9178f = (Class) com.bumptech.glide.r.j.e(cls2, "Transcode class must not be null");
        this.f9181i = (com.bumptech.glide.load.i) com.bumptech.glide.r.j.d(iVar);
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f9174b.equals(nVar.f9174b) && this.f9179g.equals(nVar.f9179g) && this.f9176d == nVar.f9176d && this.f9175c == nVar.f9175c && this.f9180h.equals(nVar.f9180h) && this.f9177e.equals(nVar.f9177e) && this.f9178f.equals(nVar.f9178f) && this.f9181i.equals(nVar.f9181i);
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        if (this.f9182j == 0) {
            int iHashCode = this.f9174b.hashCode();
            this.f9182j = iHashCode;
            int iHashCode2 = (iHashCode * 31) + this.f9179g.hashCode();
            this.f9182j = iHashCode2;
            int i2 = (iHashCode2 * 31) + this.f9175c;
            this.f9182j = i2;
            int i3 = (i2 * 31) + this.f9176d;
            this.f9182j = i3;
            int iHashCode3 = (i3 * 31) + this.f9180h.hashCode();
            this.f9182j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.f9177e.hashCode();
            this.f9182j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f9178f.hashCode();
            this.f9182j = iHashCode5;
            this.f9182j = (iHashCode5 * 31) + this.f9181i.hashCode();
        }
        return this.f9182j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f9174b + ", width=" + this.f9175c + ", height=" + this.f9176d + ", resourceClass=" + this.f9177e + ", transcodeClass=" + this.f9178f + ", signature=" + this.f9179g + ", hashCode=" + this.f9182j + ", transformations=" + this.f9180h + ", options=" + this.f9181i + '}';
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
