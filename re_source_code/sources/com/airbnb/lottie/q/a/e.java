package com.airbnb.lottie.q.a;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: EllipseContent.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements l, com.airbnb.lottie.q.b.a.InterfaceC0118a, j {
    private final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.f f8585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, PointF> f8586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, PointF> f8587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.s.j.a f8588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private r f8589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8590h;

    public e(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.a aVar2) {
        this.f8584b = aVar2.b();
        this.f8585c = fVar;
        com.airbnb.lottie.q.b.a<PointF, PointF> aVarA = aVar2.d().a();
        this.f8586d = aVarA;
        com.airbnb.lottie.q.b.a<PointF, PointF> aVarA2 = aVar2.c().a();
        this.f8587e = aVarA2;
        this.f8588f = aVar2;
        aVar.i(aVarA);
        aVar.i(aVarA2);
        aVarA.a(this);
        aVarA2.a(this);
    }

    private void e() {
        this.f8590h = false;
        this.f8585c.invalidateSelf();
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
                    this.f8589g = rVar;
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
        if (this.f8590h) {
            return this.a;
        }
        this.a.reset();
        PointF pointFH = this.f8586d.h();
        float f2 = pointFH.x / 2.0f;
        float f3 = pointFH.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.a.reset();
        if (this.f8588f.e()) {
            float f6 = -f3;
            this.a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            this.a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            this.a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            this.a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            this.a.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            this.a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            this.a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            this.a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            this.a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF pointFH2 = this.f8587e.h();
        this.a.offset(pointFH2.x, pointFH2.y);
        this.a.close();
        com.airbnb.lottie.v.f.b(this.a, this.f8589g);
        this.f8590h = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.f8584b;
    }

    @Override // com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        if (t == com.airbnb.lottie.j.f8537g) {
            this.f8586d.m(cVar);
        } else if (t == com.airbnb.lottie.j.f8538h) {
            this.f8587e.m(cVar);
        }
    }
}
