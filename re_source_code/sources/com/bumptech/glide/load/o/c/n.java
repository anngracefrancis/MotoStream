package com.bumptech.glide.load.o.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DrawableTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements com.bumptech.glide.load.l<Drawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.l<Bitmap> f9380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f9381c;

    public n(com.bumptech.glide.load.l<Bitmap> lVar, boolean z) {
        this.f9380b = lVar;
        this.f9381c = z;
    }

    private com.bumptech.glide.load.engine.u<Drawable> b(Context context, com.bumptech.glide.load.engine.u<Bitmap> uVar) {
        return r.f(context.getResources(), uVar);
    }

    public com.bumptech.glide.load.l<BitmapDrawable> a() {
        return this;
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f9380b.equals(((n) obj).f9380b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return this.f9380b.hashCode();
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.engine.u<Drawable> transform(Context context, com.bumptech.glide.load.engine.u<Drawable> uVar, int i2, int i3) {
        com.bumptech.glide.load.engine.z.e eVarF = com.bumptech.glide.c.c(context).f();
        Drawable drawable = uVar.get();
        com.bumptech.glide.load.engine.u<Bitmap> uVarA = m.a(eVarF, drawable, i2, i3);
        if (uVarA != null) {
            com.bumptech.glide.load.engine.u<Bitmap> uVarTransform = this.f9380b.transform(context, uVarA, i2, i3);
            if (!uVarTransform.equals(uVarA)) {
                return b(context, uVarTransform);
            }
            uVarTransform.c();
            return uVar;
        }
        if (!this.f9381c) {
            return uVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f9380b.updateDiskCacheKey(messageDigest);
    }
}
