package com.bumptech.glide.load.o.g;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.l;
import java.security.MessageDigest;

/* JADX INFO: compiled from: GifDrawableTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements l<c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<Bitmap> f9424b;

    public f(l<Bitmap> lVar) {
        this.f9424b = (l) com.bumptech.glide.r.j.d(lVar);
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f9424b.equals(((f) obj).f9424b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return this.f9424b.hashCode();
    }

    @Override // com.bumptech.glide.load.l
    public u<c> transform(Context context, u<c> uVar, int i2, int i3) {
        c cVar = uVar.get();
        u<Bitmap> dVar = new com.bumptech.glide.load.o.c.d(cVar.e(), com.bumptech.glide.c.c(context).f());
        u<Bitmap> uVarTransform = this.f9424b.transform(context, dVar, i2, i3);
        if (!dVar.equals(uVarTransform)) {
            dVar.c();
        }
        cVar.m(this.f9424b, uVarTransform.get());
        return uVar;
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f9424b.updateDiskCacheKey(messageDigest);
    }
}
