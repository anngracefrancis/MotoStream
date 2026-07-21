package com.bumptech.glide.load.o.c;

import android.graphics.Bitmap;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements com.bumptech.glide.load.j<ByteBuffer, Bitmap> {
    private final l a;

    public f(l lVar) {
        this.a = lVar;
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.u<Bitmap> b(ByteBuffer byteBuffer, int i2, int i3, com.bumptech.glide.load.i iVar) throws IOException {
        return this.a.d(com.bumptech.glide.r.a.e(byteBuffer), i2, i3, iVar);
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, com.bumptech.glide.load.i iVar) {
        return this.a.n(byteBuffer);
    }
}
