package com.bumptech.glide.load.o.c;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: TransformationUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class w {
    private static final Paint a = new Paint(6);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Paint f9399b = new Paint(7);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Paint f9400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f9401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Lock f9402e;

    /* JADX INFO: compiled from: TransformationUtils.java */
    private static final class a implements Lock {
        a() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j2, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f9401d = hashSet;
        f9402e = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new a();
        Paint paint = new Paint(7);
        f9400c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        f9402e.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, a);
            e(canvas);
        } finally {
            f9402e.unlock();
        }
    }

    public static Bitmap b(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap, int i2, int i3) {
        float width;
        float height;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
            width = i3 / bitmap.getHeight();
            width2 = (i2 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i2 / bitmap.getWidth();
            height = (i3 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapD = eVar.d(i2, i3, k(bitmap));
        p(bitmap, bitmapD);
        a(bitmap, bitmapD, matrix);
        return bitmapD;
    }

    public static Bitmap c(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return f(eVar, bitmap, i2, i3);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static Bitmap d(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap, int i2, int i3) {
        int iMin = Math.min(i2, i3);
        float f2 = iMin;
        float f3 = f2 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f2 / width, f2 / height);
        float f4 = width * fMax;
        float f5 = fMax * height;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f2 - f5) / 2.0f;
        RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
        Bitmap bitmapG = g(eVar, bitmap);
        Bitmap bitmapD = eVar.d(iMin, iMin, h(bitmap));
        bitmapD.setHasAlpha(true);
        Lock lock = f9402e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapD);
            canvas.drawCircle(f3, f3, f3, f9399b);
            canvas.drawBitmap(bitmapG, (Rect) null, rectF, f9400c);
            e(canvas);
            lock.unlock();
            if (!bitmapG.equals(bitmap)) {
                eVar.c(bitmapG);
            }
            return bitmapD;
        } catch (Throwable th) {
            f9402e.unlock();
            throw th;
        }
    }

    private static void e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap f(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float fMin = Math.min(i2 / bitmap.getWidth(), i3 / bitmap.getHeight());
        int iRound = Math.round(bitmap.getWidth() * fMin);
        int iRound2 = Math.round(bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == iRound && bitmap.getHeight() == iRound2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap bitmapD = eVar.d((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), k(bitmap));
        p(bitmap, bitmapD);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i2 + "x" + i3);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmapD.getWidth() + "x" + bitmapD.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(fMin);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        a(bitmap, bitmapD, matrix);
        return bitmapD;
    }

    private static Bitmap g(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap) {
        Bitmap.Config configH = h(bitmap);
        if (configH.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmapD = eVar.d(bitmap.getWidth(), bitmap.getHeight(), configH);
        new Canvas(bitmapD).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapD;
    }

    private static Bitmap.Config h(Bitmap bitmap) {
        return (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16;
    }

    public static Lock i() {
        return f9402e;
    }

    public static int j(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    private static Bitmap.Config k(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    static void l(int i2, Matrix matrix) {
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    public static boolean m(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap n(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap, int i2) {
        if (!m(i2)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        l(i2, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmapD = eVar.d(Math.round(rectF.width()), Math.round(rectF.height()), k(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmapD.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, bitmapD, matrix);
        return bitmapD;
    }

    public static Bitmap o(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap, int i2) {
        com.bumptech.glide.r.j.a(i2 > 0, "roundingRadius must be greater than 0.");
        Bitmap.Config configH = h(bitmap);
        Bitmap bitmapG = g(eVar, bitmap);
        Bitmap bitmapD = eVar.d(bitmapG.getWidth(), bitmapG.getHeight(), configH);
        bitmapD.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapG, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, bitmapD.getWidth(), bitmapD.getHeight());
        Lock lock = f9402e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapD);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            float f2 = i2;
            canvas.drawRoundRect(rectF, f2, f2, paint);
            e(canvas);
            lock.unlock();
            if (!bitmapG.equals(bitmap)) {
                eVar.c(bitmapG);
            }
            return bitmapD;
        } catch (Throwable th) {
            f9402e.unlock();
            throw th;
        }
    }

    public static void p(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
