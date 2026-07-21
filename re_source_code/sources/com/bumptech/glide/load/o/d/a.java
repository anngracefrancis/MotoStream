package com.bumptech.glide.load.o.d;

import com.bumptech.glide.load.m.e;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferRewinder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e<ByteBuffer> {
    private final ByteBuffer a;

    /* JADX INFO: renamed from: com.bumptech.glide.load.o.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferRewinder.java */
    public static class C0137a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.m.e.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.m.e.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.m.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.m.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a() {
        this.a.position(0);
        return this.a;
    }
}
