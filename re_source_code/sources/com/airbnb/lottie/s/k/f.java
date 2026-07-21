package com.airbnb.lottie.s.k;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.s.j.n;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ShapeLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    private final com.airbnb.lottie.q.a.c w;

    f(com.airbnb.lottie.f fVar, d dVar) {
        super(fVar, dVar);
        com.airbnb.lottie.q.a.c cVar = new com.airbnb.lottie.q.a.c(fVar, this, new n("__container", dVar.l()));
        this.w = cVar;
        cVar.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.s.k.a, com.airbnb.lottie.q.a.d
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        this.w.d(rectF, this.m);
    }

    @Override // com.airbnb.lottie.s.k.a
    void n(Canvas canvas, Matrix matrix, int i2) {
        this.w.f(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.s.k.a
    protected void w(com.airbnb.lottie.s.e eVar, int i2, List<com.airbnb.lottie.s.e> list, com.airbnb.lottie.s.e eVar2) {
        this.w.c(eVar, i2, list, eVar2);
    }
}
