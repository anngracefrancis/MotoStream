package com.airbnb.lottie.s.j;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ShapeData.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    private final List<com.airbnb.lottie.s.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PointF f8775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8776c;

    public l(PointF pointF, boolean z, List<com.airbnb.lottie.s.a> list) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.f8775b = pointF;
        this.f8776c = z;
        arrayList.addAll(list);
    }

    private void e(float f2, float f3) {
        if (this.f8775b == null) {
            this.f8775b = new PointF();
        }
        this.f8775b.set(f2, f3);
    }

    public List<com.airbnb.lottie.s.a> a() {
        return this.a;
    }

    public PointF b() {
        return this.f8775b;
    }

    public void c(l lVar, l lVar2, float f2) {
        if (this.f8775b == null) {
            this.f8775b = new PointF();
        }
        this.f8776c = lVar.d() || lVar2.d();
        if (lVar.a().size() != lVar2.a().size()) {
            com.airbnb.lottie.c.d("Curves must have the same number of control points. Shape 1: " + lVar.a().size() + "\tShape 2: " + lVar2.a().size());
        }
        if (this.a.isEmpty()) {
            int iMin = Math.min(lVar.a().size(), lVar2.a().size());
            for (int i2 = 0; i2 < iMin; i2++) {
                this.a.add(new com.airbnb.lottie.s.a());
            }
        }
        PointF pointFB = lVar.b();
        PointF pointFB2 = lVar2.b();
        e(com.airbnb.lottie.v.e.j(pointFB.x, pointFB2.x, f2), com.airbnb.lottie.v.e.j(pointFB.y, pointFB2.y, f2));
        for (int size = this.a.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.s.a aVar = lVar.a().get(size);
            com.airbnb.lottie.s.a aVar2 = lVar2.a().get(size);
            PointF pointFA = aVar.a();
            PointF pointFB3 = aVar.b();
            PointF pointFC = aVar.c();
            PointF pointFA2 = aVar2.a();
            PointF pointFB4 = aVar2.b();
            PointF pointFC2 = aVar2.c();
            this.a.get(size).d(com.airbnb.lottie.v.e.j(pointFA.x, pointFA2.x, f2), com.airbnb.lottie.v.e.j(pointFA.y, pointFA2.y, f2));
            this.a.get(size).e(com.airbnb.lottie.v.e.j(pointFB3.x, pointFB4.x, f2), com.airbnb.lottie.v.e.j(pointFB3.y, pointFB4.y, f2));
            this.a.get(size).f(com.airbnb.lottie.v.e.j(pointFC.x, pointFC2.x, f2), com.airbnb.lottie.v.e.j(pointFC.y, pointFC2.y, f2));
        }
    }

    public boolean d() {
        return this.f8776c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.f8776c + '}';
    }

    public l() {
        this.a = new ArrayList();
    }
}
