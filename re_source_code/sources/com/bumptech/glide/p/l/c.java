package com.bumptech.glide.p.l;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: DrawableImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends d<Drawable> {
    public c(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.p.l.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void h(Drawable drawable) {
        ((ImageView) this.f9523h).setImageDrawable(drawable);
    }
}
