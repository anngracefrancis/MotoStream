package com.bumptech.glide.load.n;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferFileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements n<File, ByteBuffer> {

    /* JADX INFO: compiled from: ByteBufferFileLoader.java */
    private static final class a implements com.bumptech.glide.load.m.d<ByteBuffer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final File f9297f;

        a(File file) {
            this.f9297f = file;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.m.d
        public void e(com.bumptech.glide.g gVar, com.bumptech.glide.load.m.d.a<? super ByteBuffer> aVar) {
            try {
                aVar.f(com.bumptech.glide.r.a.a(this.f9297f));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.c(e2);
            }
        }
    }

    /* JADX INFO: compiled from: ByteBufferFileLoader.java */
    public static class b implements o<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.n.o
        public n<File, ByteBuffer> b(r rVar) {
            return new d();
        }
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<ByteBuffer> b(File file, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return new n.a<>(new com.bumptech.glide.q.c(file), new a(file));
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(File file) {
        return true;
    }
}
