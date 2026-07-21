package com.bumptech.glide.load.engine;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: ResourceCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
final class w implements com.bumptech.glide.load.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.bumptech.glide.r.g<Class<?>, byte[]> f9204b = new com.bumptech.glide.r.g<>(50);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.f f9206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.f f9207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f9209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Class<?> f9210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.i f9211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.l<?> f9212j;

    w(com.bumptech.glide.load.engine.z.b bVar, com.bumptech.glide.load.f fVar, com.bumptech.glide.load.f fVar2, int i2, int i3, com.bumptech.glide.load.l<?> lVar, Class<?> cls, com.bumptech.glide.load.i iVar) {
        this.f9205c = bVar;
        this.f9206d = fVar;
        this.f9207e = fVar2;
        this.f9208f = i2;
        this.f9209g = i3;
        this.f9212j = lVar;
        this.f9210h = cls;
        this.f9211i = iVar;
    }

    private byte[] a() {
        com.bumptech.glide.r.g<Class<?>, byte[]> gVar = f9204b;
        byte[] bArrG = gVar.g(this.f9210h);
        if (bArrG != null) {
            return bArrG;
        }
        byte[] bytes = this.f9210h.getName().getBytes(com.bumptech.glide.load.f.a);
        gVar.k(this.f9210h, bytes);
        return bytes;
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f9209g == wVar.f9209g && this.f9208f == wVar.f9208f && com.bumptech.glide.r.k.d(this.f9212j, wVar.f9212j) && this.f9210h.equals(wVar.f9210h) && this.f9206d.equals(wVar.f9206d) && this.f9207e.equals(wVar.f9207e) && this.f9211i.equals(wVar.f9211i);
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        int iHashCode = (((((this.f9206d.hashCode() * 31) + this.f9207e.hashCode()) * 31) + this.f9208f) * 31) + this.f9209g;
        com.bumptech.glide.load.l<?> lVar = this.f9212j;
        if (lVar != null) {
            iHashCode = (iHashCode * 31) + lVar.hashCode();
        }
        return (((iHashCode * 31) + this.f9210h.hashCode()) * 31) + this.f9211i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f9206d + ", signature=" + this.f9207e + ", width=" + this.f9208f + ", height=" + this.f9209g + ", decodedResourceClass=" + this.f9210h + ", transformation='" + this.f9212j + "', options=" + this.f9211i + '}';
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f9205c.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f9208f).putInt(this.f9209g).array();
        this.f9207e.updateDiskCacheKey(messageDigest);
        this.f9206d.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.load.l<?> lVar = this.f9212j;
        if (lVar != null) {
            lVar.updateDiskCacheKey(messageDigest);
        }
        this.f9211i.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.f9205c.d(bArr);
    }
}
