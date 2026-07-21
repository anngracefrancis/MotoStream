package com.airbnb.lottie.q.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: compiled from: GradientStrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends a {
    private final String o;
    private final c.e.d<LinearGradient> p;
    private final c.e.d<RadialGradient> q;
    private final RectF r;
    private final com.airbnb.lottie.s.j.f s;
    private final int t;
    private final com.airbnb.lottie.q.b.a<com.airbnb.lottie.s.j.c, com.airbnb.lottie.s.j.c> u;
    private final com.airbnb.lottie.q.b.a<PointF, PointF> v;
    private final com.airbnb.lottie.q.b.a<PointF, PointF> w;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.e eVar) {
        super(fVar, aVar, eVar.b().g(), eVar.g().g(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        this.p = new c.e.d<>();
        this.q = new c.e.d<>();
        this.r = new RectF();
        this.o = eVar.j();
        this.s = eVar.f();
        this.t = (int) (fVar.j().d() / 32.0f);
        com.airbnb.lottie.q.b.a<com.airbnb.lottie.s.j.c, com.airbnb.lottie.s.j.c> aVarA = eVar.e().a();
        this.u = aVarA;
        aVarA.a(this);
        aVar.i(aVarA);
        com.airbnb.lottie.q.b.a<PointF, PointF> aVarA2 = eVar.l().a();
        this.v = aVarA2;
        aVarA2.a(this);
        aVar.i(aVarA2);
        com.airbnb.lottie.q.b.a<PointF, PointF> aVarA3 = eVar.d().a();
        this.w = aVarA3;
        aVarA3.a(this);
        aVar.i(aVarA3);
    }

    private int j() {
        int iRound = Math.round(this.v.f() * this.t);
        int iRound2 = Math.round(this.w.f() * this.t);
        int iRound3 = Math.round(this.u.f() * this.t);
        int i2 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }

    private LinearGradient k() {
        long j2 = j();
        LinearGradient linearGradientG = this.p.g(j2);
        if (linearGradientG != null) {
            return linearGradientG;
        }
        PointF pointFH = this.v.h();
        PointF pointFH2 = this.w.h();
        com.airbnb.lottie.s.j.c cVarH = this.u.h();
        int[] iArrA = cVarH.a();
        float[] fArrB = cVarH.b();
        RectF rectF = this.r;
        int iWidth = (int) (rectF.left + (rectF.width() / 2.0f) + pointFH.x);
        RectF rectF2 = this.r;
        int iHeight = (int) (rectF2.top + (rectF2.height() / 2.0f) + pointFH.y);
        RectF rectF3 = this.r;
        int iWidth2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + pointFH2.x);
        RectF rectF4 = this.r;
        LinearGradient linearGradient = new LinearGradient(iWidth, iHeight, iWidth2, (int) (rectF4.top + (rectF4.height() / 2.0f) + pointFH2.y), iArrA, fArrB, Shader.TileMode.CLAMP);
        this.p.k(j2, linearGradient);
        return linearGradient;
    }

    private RadialGradient l() {
        long j2 = j();
        RadialGradient radialGradientG = this.q.g(j2);
        if (radialGradientG != null) {
            return radialGradientG;
        }
        PointF pointFH = this.v.h();
        PointF pointFH2 = this.w.h();
        com.airbnb.lottie.s.j.c cVarH = this.u.h();
        int[] iArrA = cVarH.a();
        float[] fArrB = cVarH.b();
        RectF rectF = this.r;
        int iWidth = (int) (rectF.left + (rectF.width() / 2.0f) + pointFH.x);
        RectF rectF2 = this.r;
        int iHeight = (int) (rectF2.top + (rectF2.height() / 2.0f) + pointFH.y);
        RectF rectF3 = this.r;
        int iWidth2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + pointFH2.x);
        RectF rectF4 = this.r;
        RadialGradient radialGradient = new RadialGradient(iWidth, iHeight, (float) Math.hypot(iWidth2 - iWidth, ((int) ((rectF4.top + (rectF4.height() / 2.0f)) + pointFH2.y)) - iHeight), iArrA, fArrB, Shader.TileMode.CLAMP);
        this.q.k(j2, radialGradient);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.q.a.a, com.airbnb.lottie.q.a.d
    public void f(Canvas canvas, Matrix matrix, int i2) {
        d(this.r, matrix);
        if (this.s == com.airbnb.lottie.s.j.f.Linear) {
            this.f8573i.setShader(k());
        } else {
            this.f8573i.setShader(l());
        }
        super.f(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.o;
    }
}
