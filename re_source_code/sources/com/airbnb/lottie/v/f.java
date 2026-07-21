package com.airbnb.lottie.v;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.q.a.r;
import java.io.Closeable;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static final PathMeasure a = new PathMeasure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Path f8857b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Path f8858c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float[] f8859d = new float[4];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f8860e = (float) Math.sqrt(2.0d);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static float f8861f = -1.0f;

    public static void a(Path path, float f2, float f3, float f4) {
        com.airbnb.lottie.c.a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = a;
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            com.airbnb.lottie.c.c("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f3 - f2) - 1.0f) < 0.01d) {
            com.airbnb.lottie.c.c("applyTrimPathIfNeeded");
            return;
        }
        float f5 = f2 * length;
        float f6 = f3 * length;
        float f7 = f4 * length;
        float fMin = Math.min(f5, f6) + f7;
        float fMax = Math.max(f5, f6) + f7;
        if (fMin >= length && fMax >= length) {
            fMin = e.f(fMin, length);
            fMax = e.f(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = e.f(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = e.f(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            com.airbnb.lottie.c.c("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        Path path2 = f8857b;
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        if (fMax > length) {
            Path path3 = f8858c;
            path3.reset();
            pathMeasure.getSegment(0.0f, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < 0.0f) {
            Path path4 = f8858c;
            path4.reset();
            pathMeasure.getSegment(fMin + length, length, path4, true);
            path2.addPath(path4);
        }
        path.set(path2);
        com.airbnb.lottie.c.c("applyTrimPathIfNeeded");
    }

    public static void b(Path path, r rVar) {
        if (rVar == null) {
            return;
        }
        a(path, rVar.i().h().floatValue() / 100.0f, rVar.e().h().floatValue() / 100.0f, rVar.h().h().floatValue() / 360.0f);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f2 = pointF3.x + pointF.x;
            float f3 = pointF.y + pointF3.y;
            float f4 = pointF2.x;
            float f5 = f4 + pointF4.x;
            float f6 = pointF2.y;
            path.cubicTo(f2, f3, f5, f6 + pointF4.y, f4, f6);
        }
        return path;
    }

    public static float e() {
        if (f8861f == -1.0f) {
            f8861f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f8861f;
    }

    public static float f(Matrix matrix) {
        float[] fArr = f8859d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = f8860e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        return ((float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1])) / 2.0f;
    }

    public static int g(float f2, float f3, float f4, float f5) {
        int i2 = f2 != 0.0f ? (int) (527 * f2) : 17;
        if (f3 != 0.0f) {
            i2 = (int) (i2 * 31 * f3);
        }
        if (f4 != 0.0f) {
            i2 = (int) (i2 * 31 * f4);
        }
        return f5 != 0.0f ? (int) (i2 * 31 * f5) : i2;
    }

    public static boolean h(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 < i6) {
            return false;
        }
        return i3 > i6 || i4 >= i7;
    }
}
