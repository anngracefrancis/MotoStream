package com.bumptech.glide.load.o.c;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: CircleCrop.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f9358b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(com.bumptech.glide.load.f.a);

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return 1101716364;
    }

    @Override // com.bumptech.glide.load.o.c.e
    protected Bitmap transform(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap, int i2, int i3) {
        return w.d(eVar, bitmap, i2, i3);
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f9358b);
    }
}
