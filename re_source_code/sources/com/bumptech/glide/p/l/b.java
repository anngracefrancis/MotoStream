package com.bumptech.glide.p.l;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: compiled from: BitmapImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends d<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.p.l.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void h(Bitmap bitmap) {
        ((ImageView) this.f9523h).setImageBitmap(bitmap);
    }
}
