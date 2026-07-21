package com.airbnb.lottie.q.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FillContent.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d, com.airbnb.lottie.q.b.a.InterfaceC0118a, j {
    private final Path a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f8591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.s.k.a f8592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<l> f8594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<Integer, Integer> f8595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<Integer, Integer> f8596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.airbnb.lottie.q.b.a<ColorFilter, ColorFilter> f8597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.f f8598i;

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.m mVar) {
        Path path = new Path();
        this.a = path;
        this.f8591b = new Paint(1);
        this.f8594e = new ArrayList();
        this.f8592c = aVar;
        this.f8593d = mVar.d();
        this.f8598i = fVar;
        if (mVar.b() == null || mVar.e() == null) {
            this.f8595f = null;
            this.f8596g = null;
            return;
        }
        path.setFillType(mVar.c());
        com.airbnb.lottie.q.b.a<Integer, Integer> aVarA = mVar.b().a();
        this.f8595f = aVarA;
        aVarA.a(this);
        aVar.i(aVarA);
        com.airbnb.lottie.q.b.a<Integer, Integer> aVarA2 = mVar.e().a();
        this.f8596g = aVarA2;
        aVarA2.a(this);
        aVar.i(aVarA2);
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        this.f8598i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            b bVar = list2.get(i2);
            if (bVar instanceof l) {
                this.f8594e.add((l) bVar);
            }
        }
    }

    @Override // com.airbnb.lottie.s.f
    public void c(com.airbnb.lottie.s.e eVar, int i2, List<com.airbnb.lottie.s.e> list, com.airbnb.lottie.s.e eVar2) {
        com.airbnb.lottie.v.e.l(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.q.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.a.reset();
        for (int i2 = 0; i2 < this.f8594e.size(); i2++) {
            this.a.addPath(this.f8594e.get(i2).g(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.q.a.d
    public void f(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.c.a("FillContent#draw");
        this.f8591b.setColor(this.f8595f.h().intValue());
        this.f8591b.setAlpha(com.airbnb.lottie.v.e.c((int) ((((i2 / 255.0f) * this.f8596g.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.airbnb.lottie.q.b.a<ColorFilter, ColorFilter> aVar = this.f8597h;
        if (aVar != null) {
            this.f8591b.setColorFilter(aVar.h());
        }
        this.a.reset();
        for (int i3 = 0; i3 < this.f8594e.size(); i3++) {
            this.a.addPath(this.f8594e.get(i3).g(), matrix);
        }
        canvas.drawPath(this.a, this.f8591b);
        com.airbnb.lottie.c.c("FillContent#draw");
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.f8593d;
    }

    @Override // com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        if (t == com.airbnb.lottie.j.a) {
            this.f8595f.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.f8534d) {
            this.f8596g.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.x) {
            if (cVar == null) {
                this.f8597h = null;
                return;
            }
            com.airbnb.lottie.q.b.p pVar = new com.airbnb.lottie.q.b.p(cVar);
            this.f8597h = pVar;
            pVar.a(this);
            this.f8592c.i(this.f8597h);
        }
    }
}
