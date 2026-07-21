package com.bumptech.glide.load.o.c;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: UnitBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class x implements com.bumptech.glide.load.j<Bitmap, Bitmap> {

    /* JADX INFO: compiled from: UnitBitmapDecoder.java */
    private static final class a implements com.bumptech.glide.load.engine.u<Bitmap> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Bitmap f9403f;

        a(Bitmap bitmap) {
            this.f9403f = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.u
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f9403f;
        }

        @Override // com.bumptech.glide.load.engine.u
        public void c() {
        }

        @Override // com.bumptech.glide.load.engine.u
        public int d() {
            return com.bumptech.glide.r.k.h(this.f9403f);
        }

        @Override // com.bumptech.glide.load.engine.u
        public Class<Bitmap> e() {
            return Bitmap.class;
        }
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.u<Bitmap> b(Bitmap bitmap, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return new a(bitmap);
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Bitmap bitmap, com.bumptech.glide.load.i iVar) {
        return true;
    }
}
