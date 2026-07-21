package com.airbnb.lottie.q.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GradientFillContent.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements d, com.airbnb.lottie.q.b.a.InterfaceC0118a, j {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.s.k.a f8599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c.e.d<LinearGradient> f8600c = new c.e.d<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c.e.d<RadialGradient> f8601d = new c.e.d<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Matrix f8602e = new Matrix();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f8603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f8604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f8605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<l> f8606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.s.j.f f8607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<com.airbnb.lottie.s.j.c, com.airbnb.lottie.s.j.c> f8608k;
    private final com.airbnb.lottie.q.b.a<Integer, Integer> l;
    private final com.airbnb.lottie.q.b.a<PointF, PointF> m;
    private final com.airbnb.lottie.q.b.a<PointF, PointF> n;
    private com.airbnb.lottie.q.b.a<ColorFilter, ColorFilter> o;
    private final com.airbnb.lottie.f p;
    private final int q;

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.d dVar) {
        Path path = new Path();
        this.f8603f = path;
        this.f8604g = new Paint(1);
        this.f8605h = new RectF();
        this.f8606i = new ArrayList();
        this.f8599b = aVar;
        this.a = dVar.f();
        this.p = fVar;
        this.f8607j = dVar.e();
        path.setFillType(dVar.c());
        this.q = (int) (fVar.j().d() / 32.0f);
        com.airbnb.lottie.q.b.a<com.airbnb.lottie.s.j.c, com.airbnb.lottie.s.j.c> aVarA = dVar.d().a();
        this.f8608k = aVarA;
        aVarA.a(this);
        aVar.i(aVarA);
        com.airbnb.lottie.q.b.a<Integer, Integer> aVarA2 = dVar.g().a();
        this.l = aVarA2;
        aVarA2.a(this);
        aVar.i(aVarA2);
        com.airbnb.lottie.q.b.a<PointF, PointF> aVarA3 = dVar.h().a();
        this.m = aVarA3;
        aVarA3.a(this);
        aVar.i(aVarA3);
        com.airbnb.lottie.q.b.a<PointF, PointF> aVarA4 = dVar.b().a();
        this.n = aVarA4;
        aVarA4.a(this);
        aVar.i(aVarA4);
    }

    private int e() {
        int iRound = Math.round(this.m.f() * this.q);
        int iRound2 = Math.round(this.n.f() * this.q);
        int iRound3 = Math.round(this.f8608k.f() * this.q);
        int i2 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }

    private LinearGradient i() {
        long jE = e();
        LinearGradient linearGradientG = this.f8600c.g(jE);
        if (linearGradientG != null) {
            return linearGradientG;
        }
        PointF pointFH = this.m.h();
        PointF pointFH2 = this.n.h();
        com.airbnb.lottie.s.j.c cVarH = this.f8608k.h();
        LinearGradient linearGradient = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, cVarH.a(), cVarH.b(), Shader.TileMode.CLAMP);
        this.f8600c.k(jE, linearGradient);
        return linearGradient;
    }

    private RadialGradient j() {
        long jE = e();
        RadialGradient radialGradientG = this.f8601d.g(jE);
        if (radialGradientG != null) {
            return radialGradientG;
        }
        PointF pointFH = this.m.h();
        PointF pointFH2 = this.n.h();
        com.airbnb.lottie.s.j.c cVarH = this.f8608k.h();
        int[] iArrA = cVarH.a();
        float[] fArrB = cVarH.b();
        float f2 = pointFH.x;
        float f3 = pointFH.y;
        RadialGradient radialGradient = new RadialGradient(f2, f3, (float) Math.hypot(pointFH2.x - f2, pointFH2.y - f3), iArrA, fArrB, Shader.TileMode.CLAMP);
        this.f8601d.k(jE, radialGradient);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        this.p.invalidateSelf();
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            b bVar = list2.get(i2);
            if (bVar instanceof l) {
                this.f8606i.add((l) bVar);
            }
        }
    }

    @Override // com.airbnb.lottie.s.f
    public void c(com.airbnb.lottie.s.e eVar, int i2, List<com.airbnb.lottie.s.e> list, com.airbnb.lottie.s.e eVar2) {
        com.airbnb.lottie.v.e.l(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.q.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.f8603f.reset();
        for (int i2 = 0; i2 < this.f8606i.size(); i2++) {
            this.f8603f.addPath(this.f8606i.get(i2).g(), matrix);
        }
        this.f8603f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.q.a.d
    public void f(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.c.a("GradientFillContent#draw");
        this.f8603f.reset();
        for (int i3 = 0; i3 < this.f8606i.size(); i3++) {
            this.f8603f.addPath(this.f8606i.get(i3).g(), matrix);
        }
        this.f8603f.computeBounds(this.f8605h, false);
        Shader shaderI = this.f8607j == com.airbnb.lottie.s.j.f.Linear ? i() : j();
        this.f8602e.set(matrix);
        shaderI.setLocalMatrix(this.f8602e);
        this.f8604g.setShader(shaderI);
        com.airbnb.lottie.q.b.a<ColorFilter, ColorFilter> aVar = this.o;
        if (aVar != null) {
            this.f8604g.setColorFilter(aVar.h());
        }
        this.f8604g.setAlpha(com.airbnb.lottie.v.e.c((int) ((((i2 / 255.0f) * this.l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f8603f, this.f8604g);
        com.airbnb.lottie.c.c("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.a;
    }

    @Override // com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        if (t == com.airbnb.lottie.j.x) {
            if (cVar == null) {
                this.o = null;
                return;
            }
            com.airbnb.lottie.q.b.p pVar = new com.airbnb.lottie.q.b.p(cVar);
            this.o = pVar;
            pVar.a(this);
            this.f8599b.i(this.o);
        }
    }
}
