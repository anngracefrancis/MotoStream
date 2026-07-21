package com.airbnb.lottie.q.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: RepeaterContent.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements d, l, i, com.airbnb.lottie.q.b.a.InterfaceC0118a, j {
    private final Matrix a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f8632b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.f f8633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.s.k.a f8634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f8635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<Float, Float> f8636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<Float, Float> f8637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.o f8638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f8639i;

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.k kVar) {
        this.f8633c = fVar;
        this.f8634d = aVar;
        this.f8635e = kVar.c();
        com.airbnb.lottie.q.b.a<Float, Float> aVarA = kVar.b().a();
        this.f8636f = aVarA;
        aVar.i(aVarA);
        aVarA.a(this);
        com.airbnb.lottie.q.b.a<Float, Float> aVarA2 = kVar.d().a();
        this.f8637g = aVarA2;
        aVar.i(aVarA2);
        aVarA2.a(this);
        com.airbnb.lottie.q.b.o oVarB = kVar.e().b();
        this.f8638h = oVarB;
        oVarB.a(aVar);
        oVarB.b(this);
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        this.f8633c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<b> list, List<b> list2) {
        this.f8639i.b(list, list2);
    }

    @Override // com.airbnb.lottie.s.f
    public void c(com.airbnb.lottie.s.e eVar, int i2, List<com.airbnb.lottie.s.e> list, com.airbnb.lottie.s.e eVar2) {
        com.airbnb.lottie.v.e.l(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.q.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.f8639i.d(rectF, matrix);
    }

    @Override // com.airbnb.lottie.q.a.i
    public void e(ListIterator<b> listIterator) {
        if (this.f8639i != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f8639i = new c(this.f8633c, this.f8634d, "Repeater", arrayList, null);
    }

    @Override // com.airbnb.lottie.q.a.d
    public void f(Canvas canvas, Matrix matrix, int i2) {
        float fFloatValue = this.f8636f.h().floatValue();
        float fFloatValue2 = this.f8637g.h().floatValue();
        float fFloatValue3 = this.f8638h.h().h().floatValue() / 100.0f;
        float fFloatValue4 = this.f8638h.d().h().floatValue() / 100.0f;
        for (int i3 = ((int) fFloatValue) - 1; i3 >= 0; i3--) {
            this.a.set(matrix);
            float f2 = i3;
            this.a.preConcat(this.f8638h.f(f2 + fFloatValue2));
            this.f8639i.f(canvas, this.a, (int) (i2 * com.airbnb.lottie.v.e.j(fFloatValue3, fFloatValue4, f2 / fFloatValue)));
        }
    }

    @Override // com.airbnb.lottie.q.a.l
    public Path g() {
        Path pathG = this.f8639i.g();
        this.f8632b.reset();
        float fFloatValue = this.f8636f.h().floatValue();
        float fFloatValue2 = this.f8637g.h().floatValue();
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.a.set(this.f8638h.f(i2 + fFloatValue2));
            this.f8632b.addPath(pathG, this.a);
        }
        return this.f8632b;
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.f8635e;
    }

    @Override // com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        if (this.f8638h.c(t, cVar)) {
            return;
        }
        if (t == com.airbnb.lottie.j.m) {
            this.f8636f.m(cVar);
        } else if (t == com.airbnb.lottie.j.n) {
            this.f8637g.m(cVar);
        }
    }
}
