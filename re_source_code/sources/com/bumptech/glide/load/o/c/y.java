package com.bumptech.glide.load.o.c;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: VideoDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class y<T> implements com.bumptech.glide.load.j<T, Bitmap> {
    public static final com.bumptech.glide.load.h<Long> a = com.bumptech.glide.load.h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Integer> f9404b = com.bumptech.glide.load.h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d f9405c = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e<T> f9406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.e f9407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f9408f;

    /* JADX INFO: compiled from: VideoDecoder.java */
    class a implements com.bumptech.glide.load.h.b<Long> {
        private final ByteBuffer a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // com.bumptech.glide.load.h.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l.longValue()).array());
            }
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    class b implements com.bumptech.glide.load.h.b<Integer> {
        private final ByteBuffer a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // com.bumptech.glide.load.h.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    private static final class c implements e<AssetFileDescriptor> {
        private c() {
        }

        @Override // com.bumptech.glide.load.o.c.y.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    static class d {
        d() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    interface e<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    static final class f implements e<ParcelFileDescriptor> {
        f() {
        }

        @Override // com.bumptech.glide.load.o.c.y.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    y(com.bumptech.glide.load.engine.z.e eVar, e<T> eVar2) {
        this(eVar, eVar2, f9405c);
    }

    public static com.bumptech.glide.load.j<AssetFileDescriptor, Bitmap> c(com.bumptech.glide.load.engine.z.e eVar) {
        return new y(eVar, new c(null));
    }

    private static Bitmap d(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, k kVar) {
        Bitmap bitmapF = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || kVar == k.f9364f) ? null : f(mediaMetadataRetriever, j2, i2, i3, i4, kVar);
        return bitmapF == null ? e(mediaMetadataRetriever, j2, i2) : bitmapF;
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }

    @TargetApi(27)
    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, k kVar) {
        try {
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i7 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i7 == 90 || i7 == 270) {
                i6 = i5;
                i5 = i6;
            }
            float fB = kVar.b(i5, i6, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(i5 * fB), Math.round(fB * i6));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    public static com.bumptech.glide.load.j<ParcelFileDescriptor, Bitmap> g(com.bumptech.glide.load.engine.z.e eVar) {
        return new y(eVar, new f());
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(T t, com.bumptech.glide.load.i iVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.j
    public com.bumptech.glide.load.engine.u<Bitmap> b(T t, int i2, int i3, com.bumptech.glide.load.i iVar) throws IOException {
        long jLongValue = ((Long) iVar.a(a)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) iVar.a(f9404b);
        if (num == null) {
            num = 2;
        }
        k kVar = (k) iVar.a(k.f9366h);
        if (kVar == null) {
            kVar = k.f9365g;
        }
        k kVar2 = kVar;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f9408f.a();
        try {
            try {
                this.f9406d.a(mediaMetadataRetrieverA, t);
                Bitmap bitmapD = d(mediaMetadataRetrieverA, jLongValue, num.intValue(), i2, i3, kVar2);
                mediaMetadataRetrieverA.release();
                return com.bumptech.glide.load.o.c.d.f(bitmapD, this.f9407e);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            mediaMetadataRetrieverA.release();
            throw th;
        }
    }

    y(com.bumptech.glide.load.engine.z.e eVar, e<T> eVar2, d dVar) {
        this.f9407e = eVar;
        this.f9406d = eVar2;
        this.f9408f = dVar;
    }
}
