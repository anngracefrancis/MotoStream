package com.bumptech.glide.load.o.c;

import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: StreamBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class v implements com.bumptech.glide.load.j<InputStream, Bitmap> {
    private final l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9397b;

    /* JADX INFO: compiled from: StreamBitmapDecoder.java */
    static class a implements l.b {
        private final s a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.r.d f9398b;

        a(s sVar, com.bumptech.glide.r.d dVar) {
            this.a = sVar;
            this.f9398b = dVar;
        }

        @Override // com.bumptech.glide.load.o.c.l.b
        public void a(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionA = this.f9398b.a();
            if (iOExceptionA != null) {
                if (bitmap == null) {
                    throw iOExceptionA;
                }
                eVar.c(bitmap);
                throw iOExceptionA;
            }
        }

        @Override // com.bumptech.glide.load.o.c.l.b
        public void b() {
            this.a.b();
        }
    }

    public v(l lVar, com.bumptech.glide.load.engine.z.b bVar) {
        this.a = lVar;
        this.f9397b = bVar;
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.u<Bitmap> b(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.i iVar) throws IOException {
        s sVar;
        boolean z;
        if (inputStream instanceof s) {
            sVar = (s) inputStream;
            z = false;
        } else {
            sVar = new s(inputStream, this.f9397b);
            z = true;
        }
        com.bumptech.glide.r.d dVarB = com.bumptech.glide.r.d.b(sVar);
        try {
            return this.a.e(new com.bumptech.glide.r.h(dVarB), i2, i3, iVar, new a(sVar, dVarB));
        } finally {
            dVarB.c();
            if (z) {
                sVar.c();
            }
        }
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, com.bumptech.glide.load.i iVar) {
        return this.a.m(inputStream);
    }
}
