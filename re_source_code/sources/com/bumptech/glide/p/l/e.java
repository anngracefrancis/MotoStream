package com.bumptech.glide.p.l;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: ImageViewTargetFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public <Z> j<ImageView, Z> a(ImageView imageView, Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new b(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new c(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
