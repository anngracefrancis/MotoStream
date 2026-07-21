package com.airbnb.lottie.q.b;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: compiled from: TransformKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class o {
    private final Matrix a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a<PointF, PointF> f8669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a<?, PointF> f8670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a<com.airbnb.lottie.w.d, com.airbnb.lottie.w.d> f8671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a<Float, Float> f8672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a<Integer, Integer> f8673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a<?, Float> f8674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a<?, Float> f8675h;

    public o(com.airbnb.lottie.s.i.l lVar) {
        this.f8669b = lVar.c().a();
        this.f8670c = lVar.f().a();
        this.f8671d = lVar.h().a();
        this.f8672e = lVar.g().a();
        this.f8673f = lVar.e().a();
        if (lVar.i() != null) {
            this.f8674g = lVar.i().a();
        } else {
            this.f8674g = null;
        }
        if (lVar.d() != null) {
            this.f8675h = lVar.d().a();
        } else {
            this.f8675h = null;
        }
    }

    public void a(com.airbnb.lottie.s.k.a aVar) {
        aVar.i(this.f8669b);
        aVar.i(this.f8670c);
        aVar.i(this.f8671d);
        aVar.i(this.f8672e);
        aVar.i(this.f8673f);
        a<?, Float> aVar2 = this.f8674g;
        if (aVar2 != null) {
            aVar.i(aVar2);
        }
        a<?, Float> aVar3 = this.f8675h;
        if (aVar3 != null) {
            aVar.i(aVar3);
        }
    }

    public void b(a.InterfaceC0118a interfaceC0118a) {
        this.f8669b.a(interfaceC0118a);
        this.f8670c.a(interfaceC0118a);
        this.f8671d.a(interfaceC0118a);
        this.f8672e.a(interfaceC0118a);
        this.f8673f.a(interfaceC0118a);
        a<?, Float> aVar = this.f8674g;
        if (aVar != null) {
            aVar.a(interfaceC0118a);
        }
        a<?, Float> aVar2 = this.f8675h;
        if (aVar2 != null) {
            aVar2.a(interfaceC0118a);
        }
    }

    public <T> boolean c(T t, com.airbnb.lottie.w.c<T> cVar) {
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == com.airbnb.lottie.j.f8535e) {
            this.f8669b.m(cVar);
            return true;
        }
        if (t == com.airbnb.lottie.j.f8536f) {
            this.f8670c.m(cVar);
            return true;
        }
        if (t == com.airbnb.lottie.j.f8539i) {
            this.f8671d.m(cVar);
            return true;
        }
        if (t == com.airbnb.lottie.j.f8540j) {
            this.f8672e.m(cVar);
            return true;
        }
        if (t == com.airbnb.lottie.j.f8533c) {
            this.f8673f.m(cVar);
            return true;
        }
        if (t == com.airbnb.lottie.j.u && (aVar2 = this.f8674g) != null) {
            aVar2.m(cVar);
            return true;
        }
        if (t != com.airbnb.lottie.j.v || (aVar = this.f8675h) == null) {
            return false;
        }
        aVar.m(cVar);
        return true;
    }

    public a<?, Float> d() {
        return this.f8675h;
    }

    public Matrix e() {
        this.a.reset();
        PointF pointFH = this.f8670c.h();
        float f2 = pointFH.x;
        if (f2 != 0.0f || pointFH.y != 0.0f) {
            this.a.preTranslate(f2, pointFH.y);
        }
        float fFloatValue = this.f8672e.h().floatValue();
        if (fFloatValue != 0.0f) {
            this.a.preRotate(fFloatValue);
        }
        com.airbnb.lottie.w.d dVarH = this.f8671d.h();
        if (dVarH.a() != 1.0f || dVarH.b() != 1.0f) {
            this.a.preScale(dVarH.a(), dVarH.b());
        }
        PointF pointFH2 = this.f8669b.h();
        float f3 = pointFH2.x;
        if (f3 != 0.0f || pointFH2.y != 0.0f) {
            this.a.preTranslate(-f3, -pointFH2.y);
        }
        return this.a;
    }

    public Matrix f(float f2) {
        PointF pointFH = this.f8670c.h();
        PointF pointFH2 = this.f8669b.h();
        com.airbnb.lottie.w.d dVarH = this.f8671d.h();
        float fFloatValue = this.f8672e.h().floatValue();
        this.a.reset();
        this.a.preTranslate(pointFH.x * f2, pointFH.y * f2);
        double d2 = f2;
        this.a.preScale((float) Math.pow(dVarH.a(), d2), (float) Math.pow(dVarH.b(), d2));
        this.a.preRotate(fFloatValue * f2, pointFH2.x, pointFH2.y);
        return this.a;
    }

    public a<?, Integer> g() {
        return this.f8673f;
    }

    public a<?, Float> h() {
        return this.f8674g;
    }

    public void i(float f2) {
        this.f8669b.l(f2);
        this.f8670c.l(f2);
        this.f8671d.l(f2);
        this.f8672e.l(f2);
        this.f8673f.l(f2);
        a<?, Float> aVar = this.f8674g;
        if (aVar != null) {
            aVar.l(f2);
        }
        a<?, Float> aVar2 = this.f8675h;
        if (aVar2 != null) {
            aVar2.l(f2);
        }
    }
}
