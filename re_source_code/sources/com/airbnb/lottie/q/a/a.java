package com.airbnb.lottie.q.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BaseStrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements com.airbnb.lottie.q.b.a.InterfaceC0118a, j, d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.f f8569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.s.k.a f8570f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f8572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Paint f8573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Integer> f8575k;
    private final List<com.airbnb.lottie.q.b.a<?, Float>> l;
    private final com.airbnb.lottie.q.b.a<?, Float> m;
    private com.airbnb.lottie.q.b.a<ColorFilter, ColorFilter> n;
    private final PathMeasure a = new PathMeasure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f8566b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f8567c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RectF f8568d = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<b> f8571g = new ArrayList();

    /* JADX INFO: compiled from: BaseStrokeContent.java */
    private static final class b {
        private final List<l> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final r f8576b;

        private b(r rVar) {
            this.a = new ArrayList();
            this.f8576b = rVar;
        }
    }

    a(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, Paint.Cap cap, Paint.Join join, float f2, com.airbnb.lottie.s.i.d dVar, com.airbnb.lottie.s.i.b bVar, List<com.airbnb.lottie.s.i.b> list, com.airbnb.lottie.s.i.b bVar2) {
        Paint paint = new Paint(1);
        this.f8573i = paint;
        this.f8569e = fVar;
        this.f8570f = aVar;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(f2);
        this.f8575k = dVar.a();
        this.f8574j = bVar.a();
        if (bVar2 == null) {
            this.m = null;
        } else {
            this.m = bVar2.a();
        }
        this.l = new ArrayList(list.size());
        this.f8572h = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.l.add(list.get(i2).a());
        }
        aVar.i(this.f8575k);
        aVar.i(this.f8574j);
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            aVar.i(this.l.get(i3));
        }
        com.airbnb.lottie.q.b.a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar.i(aVar2);
        }
        this.f8575k.a(this);
        this.f8574j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.l.get(i4).a(this);
        }
        com.airbnb.lottie.q.b.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    private void e(Matrix matrix) {
        com.airbnb.lottie.c.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            com.airbnb.lottie.c.c("StrokeContent#applyDashPattern");
            return;
        }
        float f2 = com.airbnb.lottie.v.f.f(matrix);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            this.f8572h[i2] = this.l.get(i2).h().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f8572h;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f8572h;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f8572h;
            fArr3[i2] = fArr3[i2] * f2;
        }
        com.airbnb.lottie.q.b.a<?, Float> aVar = this.m;
        this.f8573i.setPathEffect(new DashPathEffect(this.f8572h, aVar == null ? 0.0f : aVar.h().floatValue()));
        com.airbnb.lottie.c.c("StrokeContent#applyDashPattern");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00f9  */
    private void i(Canvas canvas, b bVar, Matrix matrix) {
        float f2;
        com.airbnb.lottie.c.a("StrokeContent#applyTrimPath");
        if (bVar.f8576b == null) {
            com.airbnb.lottie.c.c("StrokeContent#applyTrimPath");
            return;
        }
        this.f8566b.reset();
        for (int size = bVar.a.size() - 1; size >= 0; size--) {
            this.f8566b.addPath(((l) bVar.a.get(size)).g(), matrix);
        }
        this.a.setPath(this.f8566b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        float fFloatValue = (bVar.f8576b.h().h().floatValue() * length) / 360.0f;
        float fFloatValue2 = ((bVar.f8576b.i().h().floatValue() * length) / 100.0f) + fFloatValue;
        float fFloatValue3 = ((bVar.f8576b.e().h().floatValue() * length) / 100.0f) + fFloatValue;
        float f3 = 0.0f;
        for (int size2 = bVar.a.size() - 1; size2 >= 0; size2--) {
            this.f8567c.set(((l) bVar.a.get(size2)).g());
            this.f8567c.transform(matrix);
            this.a.setPath(this.f8567c, false);
            float length2 = this.a.getLength();
            if (fFloatValue3 > length) {
                float f4 = fFloatValue3 - length;
                if (f4 >= f3 + length2 || f3 >= f4) {
                    f2 = f3 + length2;
                    if (f2 < fFloatValue2 && f3 <= fFloatValue3) {
                        if (f2 > fFloatValue3 || fFloatValue2 >= f3) {
                            com.airbnb.lottie.v.f.a(this.f8567c, fFloatValue2 < f3 ? 0.0f : (fFloatValue2 - f3) / length2, fFloatValue3 <= f2 ? (fFloatValue3 - f3) / length2 : 1.0f, 0.0f);
                            canvas.drawPath(this.f8567c, this.f8573i);
                        } else {
                            canvas.drawPath(this.f8567c, this.f8573i);
                        }
                    }
                } else {
                    com.airbnb.lottie.v.f.a(this.f8567c, fFloatValue2 > length ? (fFloatValue2 - length) / length2 : 0.0f, Math.min(f4 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f8567c, this.f8573i);
                }
            } else {
                f2 = f3 + length2;
                if (f2 < fFloatValue2) {
                }
            }
            f3 += length2;
        }
        com.airbnb.lottie.c.c("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        this.f8569e.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    @Override // com.airbnb.lottie.q.a.b
    public void b(List<com.airbnb.lottie.q.a.b> list, List<com.airbnb.lottie.q.a.b> list2) {
        r rVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.q.a.b bVar = list.get(size);
            if (bVar instanceof r) {
                r rVar2 = (r) bVar;
                if (rVar2.j() == com.airbnb.lottie.s.j.q.a.Individually) {
                    rVar = rVar2;
                }
            }
        }
        if (rVar != null) {
            rVar.c(this);
        }
        b bVar2 = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            com.airbnb.lottie.q.a.b bVar3 = list2.get(size2);
            if (bVar3 instanceof r) {
                r rVar3 = (r) bVar3;
                if (rVar3.j() == com.airbnb.lottie.s.j.q.a.Individually) {
                    if (bVar2 != null) {
                        this.f8571g.add(bVar2);
                    }
                    bVar2 = new b(rVar3);
                    rVar3.c(this);
                } else if (!(bVar3 instanceof l)) {
                    if (bVar2 == null) {
                        bVar2 = new b(rVar);
                    }
                    bVar2.a.add((l) bVar3);
                }
            } else if (!(bVar3 instanceof l)) {
                if (bVar2 == null) {
                    bVar2 = new b(rVar);
                }
                bVar2.a.add((l) bVar3);
            }
        }
        if (bVar2 != null) {
            this.f8571g.add(bVar2);
        }
    }

    @Override // com.airbnb.lottie.s.f
    public void c(com.airbnb.lottie.s.e eVar, int i2, List<com.airbnb.lottie.s.e> list, com.airbnb.lottie.s.e eVar2) {
        com.airbnb.lottie.v.e.l(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.q.a.d
    public void d(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.c.a("StrokeContent#getBounds");
        this.f8566b.reset();
        for (int i2 = 0; i2 < this.f8571g.size(); i2++) {
            b bVar = this.f8571g.get(i2);
            for (int i3 = 0; i3 < bVar.a.size(); i3++) {
                this.f8566b.addPath(((l) bVar.a.get(i3)).g(), matrix);
            }
        }
        this.f8566b.computeBounds(this.f8568d, false);
        float fFloatValue = this.f8574j.h().floatValue();
        RectF rectF2 = this.f8568d;
        float f2 = fFloatValue / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f8568d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.c.c("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.q.a.d
    public void f(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.c.a("StrokeContent#draw");
        this.f8573i.setAlpha(com.airbnb.lottie.v.e.c((int) ((((i2 / 255.0f) * this.f8575k.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        this.f8573i.setStrokeWidth(this.f8574j.h().floatValue() * com.airbnb.lottie.v.f.f(matrix));
        if (this.f8573i.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.c.c("StrokeContent#draw");
            return;
        }
        e(matrix);
        com.airbnb.lottie.q.b.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.f8573i.setColorFilter(aVar.h());
        }
        for (int i3 = 0; i3 < this.f8571g.size(); i3++) {
            b bVar = this.f8571g.get(i3);
            if (bVar.f8576b != null) {
                i(canvas, bVar, matrix);
            } else {
                com.airbnb.lottie.c.a("StrokeContent#buildPath");
                this.f8566b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.f8566b.addPath(((l) bVar.a.get(size)).g(), matrix);
                }
                com.airbnb.lottie.c.c("StrokeContent#buildPath");
                com.airbnb.lottie.c.a("StrokeContent#drawPath");
                canvas.drawPath(this.f8566b, this.f8573i);
                com.airbnb.lottie.c.c("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.c.c("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        if (t == com.airbnb.lottie.j.f8534d) {
            this.f8575k.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.f8541k) {
            this.f8574j.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.x) {
            if (cVar == null) {
                this.n = null;
                return;
            }
            com.airbnb.lottie.q.b.p pVar = new com.airbnb.lottie.q.b.p(cVar);
            this.n = pVar;
            pVar.a(this);
            this.f8570f.i(this.n);
        }
    }
}
