package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: KeyframeParser.java */
/* JADX INFO: loaded from: classes.dex */
class q {
    private static final Interpolator a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c.e.h<WeakReference<Interpolator>> f8849b;

    q() {
    }

    private static WeakReference<Interpolator> a(int i2) {
        WeakReference<Interpolator> weakReferenceG;
        synchronized (q.class) {
            weakReferenceG = e().g(i2);
        }
        return weakReferenceG;
    }

    static <T> com.airbnb.lottie.w.a<T> b(JsonReader jsonReader, com.airbnb.lottie.d dVar, float f2, j0<T> j0Var, boolean z) throws IOException {
        return z ? c(dVar, jsonReader, f2, j0Var) : d(jsonReader, f2, j0Var);
    }

    private static <T> com.airbnb.lottie.w.a<T> c(com.airbnb.lottie.d dVar, JsonReader jsonReader, float f2, j0<T> j0Var) throws IOException {
        Interpolator interpolator;
        jsonReader.beginObject();
        PointF pointFE = null;
        PointF pointFE2 = null;
        T tA = null;
        T tA2 = null;
        PointF pointFE3 = null;
        PointF pointFE4 = null;
        boolean z = false;
        float fNextDouble = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    tA2 = j0Var.a(jsonReader, f2);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "i":
                    pointFE2 = p.e(jsonReader, f2);
                    break;
                case "o":
                    pointFE = p.e(jsonReader, f2);
                    break;
                case "s":
                    tA = j0Var.a(jsonReader, f2);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFE4 = p.e(jsonReader, f2);
                    break;
                case "to":
                    pointFE3 = p.e(jsonReader, f2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = a;
            tA2 = tA;
        } else if (pointFE == null || pointFE2 == null) {
            interpolator = a;
        } else {
            float f3 = -f2;
            pointFE.x = com.airbnb.lottie.v.e.b(pointFE.x, f3, f2);
            pointFE.y = com.airbnb.lottie.v.e.b(pointFE.y, -100.0f, 100.0f);
            pointFE2.x = com.airbnb.lottie.v.e.b(pointFE2.x, f3, f2);
            float fB = com.airbnb.lottie.v.e.b(pointFE2.y, -100.0f, 100.0f);
            pointFE2.y = fB;
            int iG = com.airbnb.lottie.v.f.g(pointFE.x, pointFE.y, pointFE2.x, fB);
            WeakReference<Interpolator> weakReferenceA = a(iG);
            Interpolator interpolatorA = weakReferenceA != null ? weakReferenceA.get() : null;
            if (weakReferenceA == null || interpolatorA == null) {
                interpolatorA = androidx.core.view.e0.b.a(pointFE.x / f2, pointFE.y / f2, pointFE2.x / f2, pointFE2.y / f2);
                try {
                    f(iG, new WeakReference(interpolatorA));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
            interpolator = interpolatorA;
        }
        com.airbnb.lottie.w.a<T> aVar = new com.airbnb.lottie.w.a<>(dVar, tA, tA2, interpolator, fNextDouble, null);
        aVar.f8869i = pointFE3;
        aVar.f8870j = pointFE4;
        return aVar;
    }

    private static <T> com.airbnb.lottie.w.a<T> d(JsonReader jsonReader, float f2, j0<T> j0Var) throws IOException {
        return new com.airbnb.lottie.w.a<>(j0Var.a(jsonReader, f2));
    }

    private static c.e.h<WeakReference<Interpolator>> e() {
        if (f8849b == null) {
            f8849b = new c.e.h<>();
        }
        return f8849b;
    }

    private static void f(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f8849b.k(i2, weakReference);
        }
    }
}
