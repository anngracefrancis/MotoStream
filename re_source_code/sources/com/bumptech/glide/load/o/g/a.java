package com.bumptech.glide.load.o.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.r.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: ByteBufferGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bumptech.glide.load.j<ByteBuffer, c> {
    private static final C0138a a = new C0138a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f9411b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f9412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<ImageHeaderParser> f9413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f9414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final C0138a f9415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.o.g.b f9416g;

    /* JADX INFO: renamed from: com.bumptech.glide.load.o.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    static class C0138a {
        C0138a() {
        }

        com.bumptech.glide.l.a a(com.bumptech.glide.l.a.InterfaceC0122a interfaceC0122a, com.bumptech.glide.l.c cVar, ByteBuffer byteBuffer, int i2) {
            return new com.bumptech.glide.l.e(interfaceC0122a, cVar, byteBuffer, i2);
        }
    }

    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    static class b {
        private final Queue<com.bumptech.glide.l.d> a = k.f(0);

        b() {
        }

        synchronized com.bumptech.glide.l.d a(ByteBuffer byteBuffer) {
            com.bumptech.glide.l.d dVarPoll;
            dVarPoll = this.a.poll();
            if (dVarPoll == null) {
                dVarPoll = new com.bumptech.glide.l.d();
            }
            return dVarPoll.p(byteBuffer);
        }

        synchronized void b(com.bumptech.glide.l.d dVar) {
            dVar.a();
            this.a.offer(dVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar) {
        this(context, list, eVar, bVar, f9411b, a);
    }

    private e c(ByteBuffer byteBuffer, int i2, int i3, com.bumptech.glide.l.d dVar, com.bumptech.glide.load.i iVar) {
        long jB = com.bumptech.glide.r.f.b();
        try {
            com.bumptech.glide.l.c cVarC = dVar.c();
            if (cVarC.b() > 0 && cVarC.c() == 0) {
                Bitmap.Config config = iVar.a(i.a) == com.bumptech.glide.load.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                com.bumptech.glide.l.a aVarA = this.f9415f.a(this.f9416g, cVarC, byteBuffer, e(cVarC, i2, i3));
                aVarA.f(config);
                aVarA.c();
                Bitmap bitmapA = aVarA.a();
                if (bitmapA == null) {
                    return null;
                }
                return new e(new c(this.f9412c, aVarA, com.bumptech.glide.load.o.b.a(), i2, i3, bitmapA));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.r.f.a(jB));
            }
        }
    }

    private static int e(com.bumptech.glide.l.c cVar, int i2, int i3) {
        int iMin = Math.min(cVar.a() / i3, cVar.d() / i2);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return iMax;
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public e b(ByteBuffer byteBuffer, int i2, int i3, com.bumptech.glide.load.i iVar) {
        com.bumptech.glide.l.d dVarA = this.f9414e.a(byteBuffer);
        try {
            return c(byteBuffer, i2, i3, dVarA, iVar);
        } finally {
            this.f9414e.b(dVarA);
        }
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, com.bumptech.glide.load.i iVar) throws IOException {
        return !((Boolean) iVar.a(i.f9440b)).booleanValue() && com.bumptech.glide.load.e.c(this.f9413d, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar, b bVar2, C0138a c0138a) {
        this.f9412c = context.getApplicationContext();
        this.f9413d = list;
        this.f9415f = c0138a;
        this.f9416g = new com.bumptech.glide.load.o.g.b(eVar, bVar);
        this.f9414e = bVar2;
    }
}
