package com.airbnb.lottie.q.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

/* JADX INFO: compiled from: RectangleContent.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements com.airbnb.lottie.q.b.a.InterfaceC0118a, j, l {
    private final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f8624b = new RectF();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.f f8626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, PointF> f8627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, PointF> f8628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private r f8630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8631i;

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.j jVar) {
        this.f8625c = jVar.c();
        this.f8626d = fVar;
        com.airbnb.lottie.q.b.a<PointF, PointF> aVarA = jVar.d().a();
        this.f8627e = aVarA;
        com.airbnb.lottie.q.b.a<PointF, PointF> aVarA2 = jVar.e().a();
        this.f8628f = aVarA2;
        com.airbnb.lottie.q.b.a<Float, Float> aVarA3 = jVar.b().a();
        this.f8629g = aVarA3;
        aVar.i(aVarA);
        aVar.i(aVarA2);
        aVar.i(aVarA3);
        aVarA.a(this);
        aVarA2.a(this);
        aVarA3.a(this);
    }

    private void e() {
        this.f8631i = false;
        this.f8626d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        e();
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.j() == com.airbnb.lottie.s.j.q.a.Simultaneously) {
                    this.f8630h = rVar;
                    rVar.c(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.s.f
    public void c(com.airbnb.lottie.s.e eVar, int i2, List<com.airbnb.lottie.s.e> list, com.airbnb.lottie.s.e eVar2) {
        com.airbnb.lottie.v.e.l(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.q.a.l
    public Path g() {
        if (this.f8631i) {
            return this.a;
        }
        this.a.reset();
        PointF pointFH = this.f8628f.h();
        float f2 = pointFH.x / 2.0f;
        float f3 = pointFH.y / 2.0f;
        com.airbnb.lottie.q.b.a<?, Float> aVar = this.f8629g;
        float fFloatValue = aVar == null ? 0.0f : aVar.h().floatValue();
        float fMin = Math.min(f2, f3);
        if (fFloatValue > fMin) {
            fFloatValue = fMin;
        }
        PointF pointFH2 = this.f8627e.h();
        this.a.moveTo(pointFH2.x + f2, (pointFH2.y - f3) + fFloatValue);
        this.a.lineTo(pointFH2.x + f2, (pointFH2.y + f3) - fFloatValue);
        if (fFloatValue > 0.0f) {
            RectF rectF = this.f8624b;
            float f4 = pointFH2.x;
            float f5 = fFloatValue * 2.0f;
            float f6 = pointFH2.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.a.arcTo(this.f8624b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointFH2.x - f2) + fFloatValue, pointFH2.y + f3);
        if (fFloatValue > 0.0f) {
            RectF rectF2 = this.f8624b;
            float f7 = pointFH2.x;
            float f8 = pointFH2.y;
            float f9 = fFloatValue * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.a.arcTo(this.f8624b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointFH2.x - f2, (pointFH2.y - f3) + fFloatValue);
        if (fFloatValue > 0.0f) {
            RectF rectF3 = this.f8624b;
            float f10 = pointFH2.x;
            float f11 = pointFH2.y;
            float f12 = fFloatValue * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.a.arcTo(this.f8624b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointFH2.x + f2) - fFloatValue, pointFH2.y - f3);
        if (fFloatValue > 0.0f) {
            RectF rectF4 = this.f8624b;
            float f13 = pointFH2.x;
            float f14 = fFloatValue * 2.0f;
            float f15 = pointFH2.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.a.arcTo(this.f8624b, 270.0f, 90.0f, false);
        }
        this.a.close();
        com.airbnb.lottie.v.f.b(this.a, this.f8630h);
        this.f8631i = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.f8625c;
    }

    @Override // com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
    }
}
