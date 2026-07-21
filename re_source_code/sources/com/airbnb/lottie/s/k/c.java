package com.airbnb.lottie.s.k;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.j;
import com.airbnb.lottie.q.b.p;

/* JADX INFO: compiled from: ImageLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    private final Paint w;
    private final Rect x;
    private final Rect y;
    private com.airbnb.lottie.q.b.a<ColorFilter, ColorFilter> z;

    c(com.airbnb.lottie.f fVar, d dVar) {
        super(fVar, dVar);
        this.w = new Paint(3);
        this.x = new Rect();
        this.y = new Rect();
    }

    private Bitmap D() {
        return this.n.n(this.o.k());
    }

    @Override // com.airbnb.lottie.s.k.a, com.airbnb.lottie.q.a.d
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        Bitmap bitmapD = D();
        if (bitmapD != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, bitmapD.getWidth()), Math.min(rectF.bottom, bitmapD.getHeight()));
            this.m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.s.k.a, com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        super.h(t, cVar);
        if (t == j.x) {
            if (cVar == null) {
                this.z = null;
            } else {
                this.z = new p(cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.s.k.a
    public void n(Canvas canvas, Matrix matrix, int i2) {
        Bitmap bitmapD = D();
        if (bitmapD == null || bitmapD.isRecycled()) {
            return;
        }
        float fE = com.airbnb.lottie.v.f.e();
        this.w.setAlpha(i2);
        com.airbnb.lottie.q.b.a<ColorFilter, ColorFilter> aVar = this.z;
        if (aVar != null) {
            this.w.setColorFilter(aVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.x.set(0, 0, bitmapD.getWidth(), bitmapD.getHeight());
        this.y.set(0, 0, (int) (bitmapD.getWidth() * fE), (int) (bitmapD.getHeight() * fE));
        canvas.drawBitmap(bitmapD, this.x, this.y, this.w);
        canvas.restore();
    }
}
