package com.airbnb.lottie.s;

import android.graphics.PointF;

/* JADX INFO: compiled from: CubicCurveData.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private final PointF a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PointF f8686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PointF f8687c;

    public a() {
        this.a = new PointF();
        this.f8686b = new PointF();
        this.f8687c = new PointF();
    }

    public PointF a() {
        return this.a;
    }

    public PointF b() {
        return this.f8686b;
    }

    public PointF c() {
        return this.f8687c;
    }

    public void d(float f2, float f3) {
        this.a.set(f2, f3);
    }

    public void e(float f2, float f3) {
        this.f8686b.set(f2, f3);
    }

    public void f(float f2, float f3) {
        this.f8687c.set(f2, f3);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.a = pointF;
        this.f8686b = pointF2;
        this.f8687c = pointF3;
    }
}
