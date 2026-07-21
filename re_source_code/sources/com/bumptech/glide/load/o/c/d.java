package com.bumptech.glide.load.o.c;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: BitmapResource.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bumptech.glide.load.engine.u<Bitmap>, com.bumptech.glide.load.engine.q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Bitmap f9354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.e f9355g;

    public d(Bitmap bitmap, com.bumptech.glide.load.engine.z.e eVar) {
        this.f9354f = (Bitmap) com.bumptech.glide.r.j.e(bitmap, "Bitmap must not be null");
        this.f9355g = (com.bumptech.glide.load.engine.z.e) com.bumptech.glide.r.j.e(eVar, "BitmapPool must not be null");
    }

    public static d f(Bitmap bitmap, com.bumptech.glide.load.engine.z.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, eVar);
    }

    @Override // com.bumptech.glide.load.engine.q
    public void a() {
        this.f9354f.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.u
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f9354f;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void c() {
        this.f9355g.c(this.f9354f);
    }

    @Override // com.bumptech.glide.load.engine.u
    public int d() {
        return com.bumptech.glide.r.k.h(this.f9354f);
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<Bitmap> e() {
        return Bitmap.class;
    }
}
