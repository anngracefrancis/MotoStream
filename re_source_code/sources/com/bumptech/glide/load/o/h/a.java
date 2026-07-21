package com.bumptech.glide.load.o.h;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.i;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: BitmapBytesTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {
    private final Bitmap.CompressFormat a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9443b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.bumptech.glide.load.o.h.e
    public u<byte[]> a(u<Bitmap> uVar, i iVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        uVar.get().compress(this.a, this.f9443b, byteArrayOutputStream);
        uVar.c();
        return new com.bumptech.glide.load.o.d.b(byteArrayOutputStream.toByteArray());
    }

    public a(Bitmap.CompressFormat compressFormat, int i2) {
        this.a = compressFormat;
        this.f9443b = i2;
    }
}
