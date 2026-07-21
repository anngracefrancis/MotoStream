package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: BitmapPoolAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements e {
    @Override // com.bumptech.glide.load.engine.z.e
    public void a(int i2) {
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        return d(i2, i3, config);
    }
}
