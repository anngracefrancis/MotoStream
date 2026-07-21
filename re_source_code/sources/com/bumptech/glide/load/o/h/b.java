package com.bumptech.glide.load.o.h;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.o.c.r;
import com.bumptech.glide.r.j;

/* JADX INFO: compiled from: BitmapDrawableTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {
    private final Resources a;

    public b(Resources resources) {
        this.a = (Resources) j.d(resources);
    }

    @Override // com.bumptech.glide.load.o.h.e
    public u<BitmapDrawable> a(u<Bitmap> uVar, i iVar) {
        return r.f(this.a, uVar);
    }
}
