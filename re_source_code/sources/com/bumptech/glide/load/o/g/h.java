package com.bumptech.glide.load.o.g;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;

/* JADX INFO: compiled from: GifFrameResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class h implements com.bumptech.glide.load.j<com.bumptech.glide.l.a, Bitmap> {
    private final com.bumptech.glide.load.engine.z.e a;

    public h(com.bumptech.glide.load.engine.z.e eVar) {
        this.a = eVar;
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public u<Bitmap> b(com.bumptech.glide.l.a aVar, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return com.bumptech.glide.load.o.c.d.f(aVar.a(), this.a);
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(com.bumptech.glide.l.a aVar, com.bumptech.glide.load.i iVar) {
        return true;
    }
}
