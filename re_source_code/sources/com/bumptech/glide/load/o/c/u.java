package com.bumptech.glide.load.o.c;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: RoundedCorners.java */
/* JADX INFO: loaded from: classes.dex */
public final class u extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f9395b = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(com.bumptech.glide.load.f.a);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9396c;

    public u(int i2) {
        com.bumptech.glide.r.j.a(i2 > 0, "roundingRadius must be greater than 0.");
        this.f9396c = i2;
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        return (obj instanceof u) && this.f9396c == ((u) obj).f9396c;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return com.bumptech.glide.r.k.n(-569625254, com.bumptech.glide.r.k.m(this.f9396c));
    }

    @Override // com.bumptech.glide.load.o.c.e
    protected Bitmap transform(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap, int i2, int i3) {
        return w.o(eVar, bitmap, this.f9396c);
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f9395b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f9396c).array());
    }
}
