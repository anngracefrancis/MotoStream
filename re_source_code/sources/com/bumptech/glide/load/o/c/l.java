package com.bumptech.glide.load.o.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Downsampler.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final com.bumptech.glide.load.h<com.bumptech.glide.load.b> a = com.bumptech.glide.load.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.bumptech.glide.load.b.f9031h);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final com.bumptech.glide.load.h<k> f9370b = k.f9366h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Boolean> f9371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Boolean> f9372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<String> f9373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final b f9374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f9375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f9376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.e f9377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final DisplayMetrics f9378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9379k;
    private final List<ImageHeaderParser> l;
    private final q m = q.a();

    /* JADX INFO: compiled from: Downsampler.java */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.o.c.l.b
        public void a(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.o.c.l.b
        public void b() {
        }
    }

    /* JADX INFO: compiled from: Downsampler.java */
    public interface b {
        void a(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f9371c = com.bumptech.glide.load.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f9372d = com.bumptech.glide.load.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f9373e = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f9374f = new a();
        f9375g = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f9376h = com.bumptech.glide.r.k.f(0);
    }

    public l(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar) {
        this.l = list;
        this.f9378j = (DisplayMetrics) com.bumptech.glide.r.j.d(displayMetrics);
        this.f9377i = (com.bumptech.glide.load.engine.z.e) com.bumptech.glide.r.j.d(eVar);
        this.f9379k = (com.bumptech.glide.load.engine.z.b) com.bumptech.glide.r.j.d(bVar);
    }

    private static int a(double d2) {
        int iJ = j(d2);
        double d3 = iJ;
        Double.isNaN(d3);
        int iT = t(d3 * d2);
        double d4 = iT / iJ;
        Double.isNaN(d4);
        double d5 = iT;
        Double.isNaN(d5);
        return t((d2 / d4) * d5);
    }

    private void b(InputStream inputStream, com.bumptech.glide.load.b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (this.m.c(i2, i3, options, bVar, z, z2)) {
            return;
        }
        if (bVar == com.bumptech.glide.load.b.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean zHasAlpha = false;
        try {
            zHasAlpha = com.bumptech.glide.load.e.b(this.l, inputStream, this.f9379k).hasAlpha();
        } catch (IOException e2) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e2);
            }
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, InputStream inputStream, b bVar, com.bumptech.glide.load.engine.z.e eVar, k kVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int iFloor;
        double dFloor;
        int iRound;
        if (i3 <= 0 || i4 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
                return;
            }
            return;
        }
        float fB = (i2 == 90 || i2 == 270) ? kVar.b(i4, i3, i5, i6) : kVar.b(i3, i4, i5, i6);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + kVar + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        k.g gVarA = kVar.a(i3, i4, i5, i6);
        if (gVarA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i3;
        float f3 = i4;
        int iT = i3 / t(fB * f2);
        int iT2 = i4 / t(fB * f3);
        k.g gVar = k.g.MEMORY;
        int iMax = gVarA == gVar ? Math.max(iT, iT2) : Math.min(iT, iT2);
        int i9 = Build.VERSION.SDK_INT;
        if (i9 > 23 || !f9373e.contains(options.outMimeType)) {
            int iMax2 = Math.max(1, Integer.highestOneBit(iMax));
            i7 = (gVarA != gVar || ((float) iMax2) >= 1.0f / fB) ? iMax2 : iMax2 << 1;
        } else {
            i7 = 1;
        }
        options.inSampleSize = i7;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(i7, 8);
            i8 = i9;
            iFloor = (int) Math.ceil(f2 / fMin);
            iRound = (int) Math.ceil(f3 / fMin);
            int i10 = i7 / 8;
            if (i10 > 0) {
                iFloor /= i10;
                iRound /= i10;
            }
        } else {
            i8 = i9;
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f4 = i7;
                iFloor = (int) Math.floor(f2 / f4);
                dFloor = Math.floor(f3 / f4);
            } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                if (i8 >= 24) {
                    float f5 = i7;
                    iFloor = Math.round(f2 / f5);
                    iRound = Math.round(f3 / f5);
                } else {
                    float f6 = i7;
                    iFloor = (int) Math.floor(f2 / f6);
                    dFloor = Math.floor(f3 / f6);
                }
            } else if (i3 % i7 == 0 && i4 % i7 == 0) {
                iFloor = i3 / i7;
                iRound = i4 / i7;
            } else {
                int[] iArrK = k(inputStream, options, bVar, eVar);
                int i11 = iArrK[0];
                iRound = iArrK[1];
                iFloor = i11;
            }
            iRound = (int) dFloor;
        }
        double dB = kVar.b(iFloor, iRound, i5, i6);
        if (i8 >= 19) {
            options.inTargetDensity = a(dB);
            options.inDensity = j(dB);
        }
        if (o(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "], power of two scaled: [" + iFloor + "x" + iRound + "], exact scale factor: " + fB + ", power of 2 sample size: " + i7 + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private Bitmap f(InputStream inputStream, BitmapFactory.Options options, k kVar, com.bumptech.glide.load.b bVar, boolean z, int i2, int i3, boolean z2, b bVar2) throws IOException {
        l lVar;
        int iRound;
        int iRound2;
        long jB = com.bumptech.glide.r.f.b();
        int[] iArrK = k(inputStream, options, bVar2, this.f9377i);
        int i4 = iArrK[0];
        int i5 = iArrK[1];
        String str = options.outMimeType;
        boolean z3 = (i4 == -1 || i5 == -1) ? false : z;
        int iA = com.bumptech.glide.load.e.a(this.l, inputStream, this.f9379k);
        int iJ = w.j(iA);
        boolean zM = w.m(iA);
        int i6 = i2 == Integer.MIN_VALUE ? i4 : i2;
        int i7 = i3 == Integer.MIN_VALUE ? i5 : i3;
        ImageHeaderParser.ImageType imageTypeB = com.bumptech.glide.load.e.b(this.l, inputStream, this.f9379k);
        c(imageTypeB, inputStream, bVar2, this.f9377i, kVar, iJ, i4, i5, i6, i7, options);
        b(inputStream, bVar, z3, zM, options, i6, i7);
        boolean z4 = Build.VERSION.SDK_INT >= 19;
        if (options.inSampleSize == 1 || z4) {
            lVar = this;
            if (lVar.v(imageTypeB)) {
                if (i4 < 0 || i5 < 0 || !z2 || !z4) {
                    float f2 = o(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i8 = options.inSampleSize;
                    float f3 = i8;
                    int iCeil = (int) Math.ceil(i4 / f3);
                    int iCeil2 = (int) Math.ceil(i5 / f3);
                    iRound = Math.round(iCeil * f2);
                    iRound2 = Math.round(iCeil2 * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + iRound + "x" + iRound2 + "] for source [" + i4 + "x" + i5 + "], sampleSize: " + i8 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                    }
                } else {
                    iRound = i6;
                    iRound2 = i7;
                }
                if (iRound > 0 && iRound2 > 0) {
                    u(options, lVar.f9377i, iRound, iRound2);
                }
            }
        } else {
            lVar = this;
        }
        Bitmap bitmapG = g(inputStream, options, bVar2, lVar.f9377i);
        bVar2.a(lVar.f9377i, bitmapG);
        if (Log.isLoggable("Downsampler", 2)) {
            p(i4, i5, str, options, bitmapG, i2, i3, jB);
        }
        Bitmap bitmapN = null;
        if (bitmapG != null) {
            bitmapG.setDensity(lVar.f9378j.densityDpi);
            bitmapN = w.n(lVar.f9377i, bitmapG, iA);
            if (!bitmapG.equals(bitmapN)) {
                lVar.f9377i.c(bitmapG);
            }
        }
        return bitmapN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap g(java.io.InputStream r6, android.graphics.BitmapFactory.Options r7, com.bumptech.glide.load.o.c.l.b r8, com.bumptech.glide.load.engine.z.e r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r7.inJustDecodeBounds
            if (r1 == 0) goto Lc
            r1 = 10485760(0xa00000, float:1.469368E-38)
            r6.mark(r1)
            goto Lf
        Lc:
            r8.b()
        Lf:
            int r1 = r7.outWidth
            int r2 = r7.outHeight
            java.lang.String r3 = r7.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.o.c.w.i()
            r4.lock()
            r4 = 0
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r6, r4, r7)     // Catch: java.lang.Throwable -> L30 java.lang.IllegalArgumentException -> L32
            java.util.concurrent.locks.Lock r9 = com.bumptech.glide.load.o.c.w.i()
            r9.unlock()
            boolean r7 = r7.inJustDecodeBounds
            if (r7 == 0) goto L2f
            r6.reset()
        L2f:
            return r8
        L30:
            r6 = move-exception
            goto L5f
        L32:
            r5 = move-exception
            java.io.IOException r1 = q(r5, r1, r2, r3, r7)     // Catch: java.lang.Throwable -> L30
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L30
            if (r2 == 0) goto L43
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L30
        L43:
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L5e
            r6.reset()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            r9.c(r0)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            r7.inBitmap = r4     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            android.graphics.Bitmap r6 = g(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            java.util.concurrent.locks.Lock r7 = com.bumptech.glide.load.o.c.w.i()
            r7.unlock()
            return r6
        L5d:
            throw r1     // Catch: java.lang.Throwable -> L30
        L5e:
            throw r1     // Catch: java.lang.Throwable -> L30
        L5f:
            java.util.concurrent.locks.Lock r7 = com.bumptech.glide.load.o.c.w.i()
            r7.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.o.c.l.g(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.o.c.l$b, com.bumptech.glide.load.engine.z.e):android.graphics.Bitmap");
    }

    @TargetApi(19)
    private static String h(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static synchronized BitmapFactory.Options i() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = f9376h;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            s(optionsPoll);
        }
        return optionsPoll;
    }

    private static int j(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int[] k(InputStream inputStream, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.engine.z.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        g(inputStream, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String l(BitmapFactory.Options options) {
        return h(options.inBitmap);
    }

    private static boolean o(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    private static void p(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + h(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + l(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.r.f.a(j2));
    }

    private static IOException q(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + l(options), illegalArgumentException);
    }

    private static void r(BitmapFactory.Options options) {
        s(options);
        Queue<BitmapFactory.Options> queue = f9376h;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void s(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int t(double d2) {
        return (int) (d2 + 0.5d);
    }

    @TargetApi(26)
    private static void u(BitmapFactory.Options options, com.bumptech.glide.load.engine.z.e eVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.e(i2, i3, config);
    }

    private boolean v(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f9375g.contains(imageType);
    }

    public com.bumptech.glide.load.engine.u<Bitmap> d(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.i iVar) throws IOException {
        return e(inputStream, i2, i3, iVar, f9374f);
    }

    public com.bumptech.glide.load.engine.u<Bitmap> e(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.i iVar, b bVar) throws IOException {
        com.bumptech.glide.r.j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f9379k.e(65536, byte[].class);
        BitmapFactory.Options optionsI = i();
        optionsI.inTempStorage = bArr;
        com.bumptech.glide.load.b bVar2 = (com.bumptech.glide.load.b) iVar.a(a);
        k kVar = (k) iVar.a(k.f9366h);
        boolean zBooleanValue = ((Boolean) iVar.a(f9371c)).booleanValue();
        com.bumptech.glide.load.h<Boolean> hVar = f9372d;
        try {
            return d.f(f(inputStream, optionsI, kVar, bVar2, iVar.a(hVar) != null && ((Boolean) iVar.a(hVar)).booleanValue(), i2, i3, zBooleanValue, bVar), this.f9377i);
        } finally {
            r(optionsI);
            this.f9379k.d(bArr);
        }
    }

    public boolean m(InputStream inputStream) {
        return true;
    }

    public boolean n(ByteBuffer byteBuffer) {
        return true;
    }
}
