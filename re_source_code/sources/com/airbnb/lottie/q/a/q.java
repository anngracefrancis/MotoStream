package com.airbnb.lottie.q.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* JADX INFO: compiled from: StrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends a {
    private final com.airbnb.lottie.s.k.a o;
    private final String p;
    private final com.airbnb.lottie.q.b.a<Integer, Integer> q;
    private com.airbnb.lottie.q.b.a<ColorFilter, ColorFilter> r;

    public q(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.p pVar) {
        super(fVar, aVar, pVar.b().g(), pVar.e().g(), pVar.g(), pVar.i(), pVar.j(), pVar.f(), pVar.d());
        this.o = aVar;
        this.p = pVar.h();
        com.airbnb.lottie.q.b.a<Integer, Integer> aVarA = pVar.c().a();
        this.q = aVarA;
        aVarA.a(this);
        aVar.i(aVarA);
    }

    @Override // com.airbnb.lottie.q.a.a, com.airbnb.lottie.q.a.d
    public void f(Canvas canvas, Matrix matrix, int i2) {
        this.f8573i.setColor(this.q.h().intValue());
        com.airbnb.lottie.q.b.a<ColorFilter, ColorFilter> aVar = this.r;
        if (aVar != null) {
            this.f8573i.setColorFilter(aVar.h());
        }
        super.f(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.p;
    }

    @Override // com.airbnb.lottie.q.a.a, com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        super.h(t, cVar);
        if (t == com.airbnb.lottie.j.f8532b) {
            this.q.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.x) {
            if (cVar == null) {
                this.r = null;
                return;
            }
            com.airbnb.lottie.q.b.p pVar = new com.airbnb.lottie.q.b.p(cVar);
            this.r = pVar;
            pVar.a(this);
            this.o.i(this.q);
        }
    }
}
